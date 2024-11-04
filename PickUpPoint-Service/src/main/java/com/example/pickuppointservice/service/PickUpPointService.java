package com.example.pickuppointservice.service;

import com.example.pickuppointservice.ModelMigration.PickupPoint;
import com.example.pickuppointservice.dto.PickupPointsResponse;
import com.example.pickuppointservice.dto.UpdatePickUpPointRequest;

public interface PickUpPointService {
    void updatePickupPoint(UpdatePickUpPointRequest request);
    PickupPointsResponse findPickupPointByManagerId(Long managerId);
    boolean addPosToManager (Long manager_id,Long pos_id);

}