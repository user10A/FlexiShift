package com.example.pickuppointservice.service.impl;

import com.example.pickuppointservice.ModelMigration.PickupPoint;
import com.example.pickuppointservice.dto.PickupPointsResponse;
import com.example.pickuppointservice.dto.UpdatePickUpPointRequest;
import com.example.pickuppointservice.repository.PickupPointRepository;
import com.example.pickuppointservice.service.PickUpPointService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

@Service
@RequiredArgsConstructor
public class PickUpPointServiceImpl implements PickUpPointService {

    private final PickupPointRepository pickupPointRepository;

    @Override
    public void updatePickupPoint(UpdatePickUpPointRequest request) {
        PickupPoint pickupPoint = pickupPointRepository.findById(request.getPickUpPointId()).orElseThrow(() ->
                new NotFoundException("PickUpPoint not found"));

        pickupPoint.setName(request.getPickUpPointName());
        pickupPoint.setAddress(request.getPickUpPointAddress());

        pickupPointRepository.save(pickupPoint);
    }

    @Override
    public PickupPointsResponse findPickupPointByManagerId(Long managerId) {
        PickupPoint pickupPoint = pickupPointRepository.findPickupPointByManagerId(managerId).orElseThrow(()->
                new NotFoundException("Manager not found by id: " + managerId));

        return PickupPointsResponse.builder()
                .managerId(pickupPoint.getManagerId())
                .id(pickupPoint.getId())
                .name(pickupPoint.getName())
                .address(pickupPoint.getAddress())
                .build();
    }

    @Override
    public boolean addPosToManager(Long managerId, Long posId) {
        PickupPoint pickupPoint = pickupPointRepository.findPickupPointByManagerId(managerId)
                .orElseThrow(() -> new NotFoundException("Manager not found by id: " + managerId));
        if (pickupPoint.getManagerId() != null && pickupPoint.getManagerId().equals(managerId)) {
            return false;
        }
        pickupPoint.setManagerId(managerId);
        pickupPointRepository.save(pickupPoint);

        return true;
    }

}
