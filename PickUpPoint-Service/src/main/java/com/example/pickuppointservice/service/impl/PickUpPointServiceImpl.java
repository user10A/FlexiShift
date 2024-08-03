package com.example.pickuppointservice.service.impl;

import com.example.pickuppointservice.ModelMigration.PickupPoint;
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
}
