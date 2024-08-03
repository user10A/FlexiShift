package com.example.managerservice.openFeign;

import com.example.managerservice.dto.UpdatePickUpPointRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PatchMapping;

@FeignClient(name = "PickUpPoint-Service", url = "http://localhost:9094/")
public interface PickUpPointFeignClient {
    @PatchMapping("/updatePickUpPoint")
    void updatePickUpPoint(UpdatePickUpPointRequest updatePickUpPointRequest);
}