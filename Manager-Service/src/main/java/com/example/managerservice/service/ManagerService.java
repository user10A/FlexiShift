package com.example.managerservice.service;

import com.example.managerservice.ModelMigration.ManagerDto;

public interface ManagerService {
    Boolean existsByEmail(String email);
    ManagerDto getManagerByEmail(String email);
    void saveManager(ManagerDto managerDto);
}