package com.example.managerservice.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ManagerDto {
    private Long id;
    private String name;
    private String email;
    private String password;
}