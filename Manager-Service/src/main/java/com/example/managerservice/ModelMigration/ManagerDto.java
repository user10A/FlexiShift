package com.example.managerservice.ModelMigration;

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