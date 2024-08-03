package com.example.authenticationservice.config.details;

import com.example.authenticationservice.config.details.additional.UserAccount;
import com.example.authenticationservice.modelDto.WorkerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.List;

@RequiredArgsConstructor
public class WorkerDetails implements UserAccount {
    private final WorkerDto worker;

    @Override
    public Long getId() {
        return worker.getId();
    }

    @Override
    public String getEmail() {
        return worker.getEmail();
    }

    @Override
    public String getPassword() {
        return worker.getPassword();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("Worker"));
    }

    @Override
    public String getUsername() {
        return worker.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}