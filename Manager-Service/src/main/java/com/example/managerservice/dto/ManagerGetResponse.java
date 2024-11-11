package com.example.managerservice.dto;
import lombok.Builder;

@Builder
public class ManagerGetResponse {
    private Long id;
    private String name;
    private String email;
    private PickupPointsResponse pickupPoints;
}
