package com.example.pickuppointservice.api;

import com.example.pickuppointservice.dto.UpdatePickUpPointRequest;
import com.example.pickuppointservice.service.PickUpPointService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pickUpPoint")
@RequiredArgsConstructor
public class PickUpPointApi {
    private final PickUpPointService pickUpPointService;

    @ApiOperation(
            value = "Редактировать данные о ПВЗ",
            notes = "Менеджер редактирует данные существующего ПВЗ из бд",
            httpMethod = "PATCH"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "ПВЗ успешно обновлен"),
            @ApiResponse(code = 400, message = "Некорректные данные"),
            @ApiResponse(code = 500, message = "Внутренняя ошибка сервера")
    })
    @PatchMapping("/updatePickUpPoint")
    @PreAuthorize("hasRole('MANAGER')")
    public void updatePickUpPoint(UpdatePickUpPointRequest updatePickUpPointRequest) {
        pickUpPointService.updatePickupPoint(updatePickUpPointRequest);
    }
}