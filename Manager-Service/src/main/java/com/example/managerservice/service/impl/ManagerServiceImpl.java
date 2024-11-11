package com.example.managerservice.service.impl;

import com.example.managerservice.ModelMigration.Manager;
import com.example.managerservice.dto.ManagerDto;
import com.example.managerservice.dto.ManagerGetResponse;
import com.example.managerservice.dto.ManagerUpdateRequest;
import com.example.managerservice.dto.PickupPointsResponse;
import com.example.managerservice.openFeign.PickUpPointFeignClient;
import com.example.managerservice.repository.ManagerRepository;
import com.example.managerservice.service.ManagerService;
import jakarta.ws.rs.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ManagerServiceImpl implements ManagerService {
    private final ManagerRepository managerRepository;
    private final ModelMapper modelMapper;
    private final PickUpPointFeignClient pickUpPointFeignClient;


    @Override
    public Boolean existsByEmail(String email) {
        return managerRepository.existsManagerByEmail(email);
    }

    @Override
    public ManagerDto getManagerByEmail(String email) {
        Optional<Manager> manager = managerRepository.getManagerByEmail(email);
        return manager.map(managerDto -> modelMapper.map(manager, ManagerDto.class)).orElse(null);
    }

    @Override
    public void saveManager(ManagerDto managerDto) {
        Manager manager = modelMapper.map(managerDto, Manager.class);
        managerRepository.save(manager);
    }

    @Override
    public ManagerGetResponse getManagerById(Long manager_id) {
        Manager manager = managerRepository.findById(manager_id).orElseThrow(()->
                new NotFoundException("Manager with id " + manager_id + " not found") );
        PickupPointsResponse pickupPointsResponse =pickUpPointFeignClient.findPickupPointByManagerId(manager_id);
        return ManagerGetResponse.builder()
                .id(manager_id)
                .name(manager.getName())
                .email(manager.getEmail())
                .pickupPoints(pickupPointsResponse)
                .build();
    }

    @Override
    public ManagerDto updateManagerProfile(Long manager_id, ManagerUpdateRequest managerUpdateRequest) {
        Manager manager = managerRepository.findById(manager_id).orElseThrow(()->
                new NotFoundException("Manager with id " + manager_id + " not found") );
        manager.setName(managerUpdateRequest.getName());
        manager.setEmail(managerUpdateRequest.getEmail());
        manager.setPassword(managerUpdateRequest.getPassword());
        managerRepository.save(manager);
        return ManagerDto.builder()
                .email(manager.getEmail())
                .name(manager.getName())
                .password(manager.getPassword())
                .build();
    }


    @Override
    public ManagerGetResponse addPosToManager(Long manager_id, Long pos_id) {
        Manager manager = managerRepository.findById(manager_id).orElseThrow(()->
                new NotFoundException("Manager with id " + manager_id + " not found") );

        manager.setPickUpPointId(pos_id);
        managerRepository.save(manager);
        pickUpPointFeignClient.addPosToManager(manager_id,pos_id);

        PickupPointsResponse pickupPointsResponse =pickUpPointFeignClient.findPickupPointByManagerId(manager_id);
        return ManagerGetResponse.builder()
                .id(manager_id)
                .name(manager.getName())
                .email(manager.getEmail())
                .pickupPoints(pickupPointsResponse)
                .build();
    }
}
