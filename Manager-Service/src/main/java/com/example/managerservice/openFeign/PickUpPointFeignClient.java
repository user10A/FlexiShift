package com.example.managerservice.openFeign;

import com.example.managerservice.dto.PickupPointsResponse;
import com.example.managerservice.dto.UpdatePickUpPointRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "PickUpPoint-Service", url = "http://localhost:9094/")
public interface PickUpPointFeignClient {
    @PatchMapping("/updatePickUpPoint")
    void updatePickUpPoint(@RequestBody UpdatePickUpPointRequest updatePickUpPointRequest);

    @GetMapping("/getPickUpPointByManagerId/{managerId}")
    PickupPointsResponse findPickupPointByManagerId(@PathVariable Long managerId);

    @PatchMapping("/{id}/add-pos/{posId}")
     boolean addPosToManager(@PathVariable Long id, @PathVariable Long posId);
}