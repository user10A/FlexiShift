package com.example.managerservice.dto;
import lombok.Builder;

@Builder
public class PickupPointsResponse {
    private Long id;
    private String name;
    private String address;
    private Long managerId;
}

