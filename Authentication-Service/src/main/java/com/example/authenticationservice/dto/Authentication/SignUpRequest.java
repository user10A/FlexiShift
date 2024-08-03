package com.example.authenticationservice.dto.Authentication;

import com.example.authenticationservice.util.validation.EmailValidation;
import com.example.authenticationservice.util.validation.ValidPassword;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SignUpRequest {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    @EmailValidation(message = "Неверный формат почты")
    private String email;
    @ValidPassword
    private String password;
}