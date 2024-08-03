package com.example.authenticationservice.modelDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ManagerDto {
    private Long id;
    private String name;
    private String email;
    private String password;
}