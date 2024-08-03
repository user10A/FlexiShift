package com.example.authenticationservice.config.details;

import com.example.authenticationservice.config.details.additional.UserAccount;
import com.example.authenticationservice.modelDto.ManagerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.List;

@RequiredArgsConstructor
public class ManagerDetails implements UserAccount {
    private final ManagerDto manager;

    @Override
    public Long getId() {
        return manager.getId();
    }

    @Override
    public String getEmail() {
        return manager.getEmail();
    }

    @Override
    public String getPassword() {
        return manager.getPassword();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("Manager"));
    }

    @Override
    public String getUsername() {
        return manager.getEmail();
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
