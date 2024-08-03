package com.example.pickuppointservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdatePickUpPointRequest {
    private Long pickUpPointId;
    private String pickUpPointName;
    private String pickUpPointAddress;
}