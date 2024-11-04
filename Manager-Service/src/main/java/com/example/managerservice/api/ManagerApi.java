package com.example.managerservice.api;

import com.example.managerservice.dto.ManagerDto;
import com.example.managerservice.dto.ManagerGetResponse;
import com.example.managerservice.dto.ManagerUpdateRequest;
import com.example.managerservice.service.ManagerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/manager")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:8080")
public class ManagerApi {

    private final ManagerService managerService;

    @Operation(summary = "Проверить существование менеджера по email")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Проверка успешна", content = @Content(schema = @Schema(implementation = Boolean.class))),
            @ApiResponse(responseCode = "404", description = "Менеджер не найден", content = @Content)
    })
    @GetMapping("/existsByEmail/{email}")
    public ResponseEntity<Boolean> existsByEmail(@PathVariable String email) {
        return ResponseEntity.ok(managerService.existsByEmail(email));
    }

    @Operation(summary = "Получить менеджера по email")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Менеджер найден", content = @Content(schema = @Schema(implementation = ManagerDto.class))),
            @ApiResponse(responseCode = "404", description = "Менеджер не найден", content = @Content)
    })
    @GetMapping("/getManagerByEmail/{email}")
    public ResponseEntity<ManagerDto> getManagerByEmail(@PathVariable String email) {
        return ResponseEntity.ok(managerService.getManagerByEmail(email));
    }
    @Operation(summary = "Сохранить нового менеджера")
    @ApiResponse(responseCode = "200", description = "Менеджер успешно сохранен")
    @PostMapping("/saveManager")
    public void saveManager(@RequestBody ManagerDto managerDto) {
        managerService.saveManager(managerDto);
    }
    @Operation(summary = "Получить менеджера по ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Менеджер найден", content = @Content(schema = @Schema(implementation = ManagerGetResponse.class))),
            @ApiResponse(responseCode = "404", description = "Менеджер не найден", content = @Content)
    })
    @GetMapping("/{id}")
    public ResponseEntity<ManagerGetResponse> getManagerById(@PathVariable("id") Long managerId) {
        ManagerGetResponse response = managerService.getManagerById(managerId);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Обновить профиль менеджера")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Профиль менеджера успешно обновлен", content = @Content(schema = @Schema(implementation = ManagerDto.class))),
            @ApiResponse(responseCode = "404", description = "Менеджер не найден", content = @Content)
    })
    @PutMapping("/{id}/update")
    public ResponseEntity<ManagerDto> updateManagerProfile(
            @PathVariable("id") Long managerId,
            @RequestBody ManagerUpdateRequest managerUpdateRequest) {
        ManagerDto updatedManager = managerService.updateManagerProfile(managerId, managerUpdateRequest);
        return ResponseEntity.ok(updatedManager);
    }

    @Operation(summary = "Добавить точку к менеджеру")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Точка успешно добавлена", content = @Content(schema = @Schema(implementation = ManagerGetResponse.class))),
            @ApiResponse(responseCode = "404", description = "Менеджер не найден", content = @Content)
    })
    @PostMapping("/{id}/add-pos/{posId}")
    public ResponseEntity<ManagerGetResponse> addPosToManager(
            @PathVariable("id") Long managerId,
            @PathVariable("posId") Long posId) {
        ManagerGetResponse response = managerService.addPosToManager(managerId, posId);
        return ResponseEntity.ok(response);
    }
}