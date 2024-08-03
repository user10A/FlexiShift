package com.example.managerservice.api;

import com.example.managerservice.ModelMigration.ManagerDto;
import com.example.managerservice.service.ManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/manager")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:8080")
public class ManagerApi {

    private final ManagerService managerService;

    @GetMapping("/existsByEmail/{email}")
    public ResponseEntity<Boolean> existsByEmail(@PathVariable String email) {
        return ResponseEntity.ok(managerService.existsByEmail(email));
    }

    @GetMapping("/getManagerByEmail/{email}")
    public ResponseEntity<ManagerDto> getManagerByEmail(@PathVariable String email) {
        return ResponseEntity.ok(managerService.getManagerByEmail(email));
    }

    @PostMapping("/saveManager")
    public void saveManager(@RequestBody ManagerDto managerDto) {
        managerService.saveManager(managerDto);
    }
}