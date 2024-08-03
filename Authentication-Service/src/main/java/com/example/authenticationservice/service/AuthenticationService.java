package com.example.authenticationservice.service;


import com.example.authenticationservice.dto.Authentication.AuthenticationResponse;
import com.example.authenticationservice.dto.Authentication.SignInRequest;
import com.example.authenticationservice.dto.Authentication.SignUpRequest;

public interface AuthenticationService {
    AuthenticationResponse signUp(SignUpRequest request);
    AuthenticationResponse signIn(SignInRequest request);
}