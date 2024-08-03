package com.example.authenticationservice.dto.Authentication;

import com.example.authenticationservice.util.validation.EmailValidation;
import com.example.authenticationservice.util.validation.ValidPassword;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SignInRequest {
    @EmailValidation(message = "Email не может быть пустым и должен быть валидным")
    private String email;
    @ValidPassword
    private String password;
}
