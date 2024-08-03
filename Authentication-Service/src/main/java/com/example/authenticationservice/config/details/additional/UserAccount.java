package com.example.authenticationservice.config.details.additional;

import org.springframework.security.core.userdetails.UserDetails;

public interface UserAccount extends UserDetails {
    Long getId();
    String getEmail();
    String getPassword();
}