package com.example.managerservice.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class ManagerUpdateRequest {
    private String name;
    private String email;
    private String password;
}
