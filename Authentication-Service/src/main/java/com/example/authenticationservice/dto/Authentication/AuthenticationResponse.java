package com.example.authenticationservice.dto.Authentication;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class AuthenticationResponse {
    private String token;
    private String email;
}
