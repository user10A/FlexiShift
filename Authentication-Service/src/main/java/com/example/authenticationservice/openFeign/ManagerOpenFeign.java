package com.example.authenticationservice.openFeign;

import com.example.authenticationservice.modelDto.ManagerDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "Manager-Service", url = "http://localhost:9092/api/manager")
public interface ManagerOpenFeign {
    @GetMapping("/existsByEmail/{email}")
    ResponseEntity<Boolean> existsByEmail(@PathVariable String email);

    @GetMapping("/getManagerByEmail/{email}")
    ResponseEntity<ManagerDto> getManagerByEmail(@PathVariable String email);

    @PostMapping("/saveManager")
    void saveWorker(@RequestBody ManagerDto managerDto);
}