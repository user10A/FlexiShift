package com.example.authenticationservice.api;

import com.example.authenticationservice.dto.Authentication.AuthenticationResponse;
import com.example.authenticationservice.dto.Authentication.SignInRequest;
import com.example.authenticationservice.dto.Authentication.SignUpRequest;
import com.example.authenticationservice.service.AuthenticationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
@CrossOrigin(origins = "http://localhost:8080")
@Tag(name = "Auth api", description = "API's for Authentication ")
public class AuthApi {

    private final AuthenticationService authenticationService;

    @PostMapping("/signUp")
    @Operation(summary = "Sign Up", description = "Register a new user")
    public AuthenticationResponse signUp(@Valid @RequestBody SignUpRequest signUpRequest) {
        return authenticationService.signUp(signUpRequest);
    }

    @PostMapping("/signIn")
    @Operation(summary = "Sign In", description = "Authenticate and sign in the user")
    public AuthenticationResponse signIn(@RequestBody SignInRequest signInRequest) {
        return authenticationService.signIn(signInRequest);
    }
}