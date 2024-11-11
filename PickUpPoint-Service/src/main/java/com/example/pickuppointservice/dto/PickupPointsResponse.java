package com.example.pickuppointservice.dto;
import lombok.Builder;
import lombok.RequiredArgsConstructor;

@Builder
public class PickupPointsResponse {
    private Long id;
    private String name;
    private String address;
    private Long managerId;
}
