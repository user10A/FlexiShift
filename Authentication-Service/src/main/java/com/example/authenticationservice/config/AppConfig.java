package com.example.authenticationservice.config;

import com.example.authenticationservice.config.details.ManagerDetails;
import com.example.authenticationservice.config.details.WorkerDetails;
import com.example.authenticationservice.modelDto.ManagerDto;
import com.example.authenticationservice.modelDto.WorkerDto;
import com.example.authenticationservice.openFeign.ManagerOpenFeign;
import com.example.authenticationservice.openFeign.WorkerOpenFeign;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
public class AppConfig {
    private final WorkerOpenFeign workerOpenFeign;
    private final ManagerOpenFeign managerOpenFeign;

    @Bean
    public Validator validator() {
        return new LocalValidatorFactoryBean();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return email -> {
            ResponseEntity<WorkerDto> workerResponse = workerOpenFeign.getWorkerByEmail(email);
            if (workerResponse.getStatusCode().is2xxSuccessful()) {
                WorkerDto workerDto = workerResponse.getBody();
                return new WorkerDetails(workerDto);
            }

            ResponseEntity<ManagerDto> managerResponse = managerOpenFeign.getManagerByEmail(email);
            if (managerResponse.getStatusCode().is2xxSuccessful()) {
                ManagerDto managerDto = managerResponse.getBody();
                return new ManagerDetails(managerDto);
            }

            throw new EntityNotFoundException("User with email " + email + " not found");
        };
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder) {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder);
        return daoAuthenticationProvider;
    }
}