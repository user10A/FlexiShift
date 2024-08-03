package com.example.managerservice.service.impl;

import com.example.managerservice.ModelMigration.Manager;
import com.example.managerservice.ModelMigration.ManagerDto;
import com.example.managerservice.repository.ManagerRepository;
import com.example.managerservice.service.ManagerService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ManagerServiceImpl implements ManagerService {
    private final ManagerRepository managerRepository;
    private final ModelMapper modelMapper;

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
}
