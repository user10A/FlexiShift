package com.example.authenticationservice.service.impl;

import com.example.authenticationservice.config.details.ManagerDetails;
import com.example.authenticationservice.config.details.WorkerDetails;
import com.example.authenticationservice.config.jwt.JwtService;
import com.example.authenticationservice.dto.Authentication.AuthenticationResponse;
import com.example.authenticationservice.dto.Authentication.SignInRequest;
import com.example.authenticationservice.dto.Authentication.SignUpRequest;
import com.example.authenticationservice.modelDto.ManagerDto;
import com.example.authenticationservice.modelDto.WorkerDto;
import com.example.authenticationservice.openFeign.ManagerOpenFeign;
import com.example.authenticationservice.openFeign.WorkerOpenFeign;
import com.example.authenticationservice.service.AuthenticationService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.concurrent.CompletableFuture;

@Service
@Transactional
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final WorkerOpenFeign workerOpenFeign;
    private final ManagerOpenFeign managerOpenFeign;

    @Override
    public AuthenticationResponse signUp(SignUpRequest request) {
        ResponseEntity<Boolean> workerExistsResponse = workerOpenFeign.existsByEmail(request.getEmail());
        ResponseEntity<Boolean> managerExistsResponse = managerOpenFeign.existsByEmail(request.getEmail());

        if (Boolean.TRUE.equals(workerExistsResponse.getBody()) || Boolean.TRUE.equals(managerExistsResponse.getBody())) {
            throw new NotFoundException("Account already exists");
        }

        WorkerDto worker = WorkerDto.builder()
                .name(request.getFirstName() + " " + request.getLastName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .phoneNumber(request.getPhoneNumber())
                .build();

        WorkerDetails workerDetails = new WorkerDetails(worker);

        workerOpenFeign.saveWorker(worker);

        String jwt = jwtService.generateToken(workerDetails);

        return AuthenticationResponse.builder()
                .email(worker.getEmail())
                .token(jwt)
                .build();
    }

    @Override
    public AuthenticationResponse signIn(SignInRequest request) {
        CompletableFuture<ManagerDto> managerFuture = CompletableFuture.supplyAsync(() ->
                managerOpenFeign.getManagerByEmail(request.getEmail()).getBody()
        );

        CompletableFuture<WorkerDto> workerFuture = CompletableFuture.supplyAsync(() ->
                workerOpenFeign.getWorkerByEmail(request.getEmail()).getBody()
        );

        CompletableFuture<Object> combinedFuture = CompletableFuture.anyOf(managerFuture, workerFuture);

        Object result = combinedFuture.join();

        if (result instanceof ManagerDto managerDto) {
            return processAuthentication(managerDto, request);
        } else if (result instanceof WorkerDto workerDto) {
            return processAuthentication(workerDto, request);
        } else {
            throw new UsernameNotFoundException("Пользователь с таким email не найден");
        }

    }

    private AuthenticationResponse processAuthentication(Object userDto, SignInRequest request) {
        String passwordBCrypt = request.getPassword();
        if (userDto instanceof ManagerDto managerDto) {
            if (!passwordEncoder.matches(passwordBCrypt, managerDto.getPassword())) {
                throw new BadCredentialsException("Внутренняя ошибка");
            }
            ManagerDetails managerDetails = new ManagerDetails(managerDto);
            return generateAuthenticationResponse(managerDto.getEmail(), managerDetails);
        } else if (userDto instanceof WorkerDto workerDto) {
            if (!passwordEncoder.matches(passwordBCrypt, workerDto.getPassword())) {
                throw new BadCredentialsException("Внутренняя ошибка");
            }
            WorkerDetails workerDetails = new WorkerDetails(workerDto);
            return generateAuthenticationResponse(workerDto.getEmail(), workerDetails);
        }
        return null;
    }

    private AuthenticationResponse generateAuthenticationResponse(String email, UserDetails userDetails) {
        String jwt = jwtService.generateToken(userDetails);
        return AuthenticationResponse.builder()
                .email(email)
                .token(jwt)
                .build();
    }
}