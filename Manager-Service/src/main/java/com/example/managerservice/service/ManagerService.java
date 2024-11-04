package com.example.managerservice.service;

import com.example.managerservice.dto.ManagerDto;
import com.example.managerservice.dto.ManagerGetResponse;
import com.example.managerservice.dto.ManagerUpdateRequest;

import java.sql.Timestamp;

public interface ManagerService {
    Boolean existsByEmail(String email);
    ManagerDto getManagerByEmail(String email);
    void saveManager(ManagerDto managerDto);
    ManagerGetResponse getManagerById(Long id);
    ManagerDto updateManagerProfile(Long manager_id, ManagerUpdateRequest managerUpdateRequest);
    ManagerGetResponse addPosToManager (Long manager_id,Long pos_id);
}