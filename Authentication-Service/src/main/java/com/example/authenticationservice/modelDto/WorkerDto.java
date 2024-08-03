package com.example.authenticationservice.modelDto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class WorkerDto {
    private Long id;
    private String name;
    private String email;
    private String password;
    private String phoneNumber;
}