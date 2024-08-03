package com.example.authenticationservice.openFeign;

import com.example.authenticationservice.modelDto.WorkerDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "Worker-Service", url = "http://localhost:9097/api/worker")
public interface WorkerOpenFeign {
    @GetMapping("/existsByEmail/{email}")
    ResponseEntity<Boolean> existsByEmail(@PathVariable String email);

    @GetMapping("/getWorkerByEmail/{email}")
    ResponseEntity<WorkerDto> getWorkerByEmail(@PathVariable String email);

    @PostMapping("/saveWorker")
    void saveWorker(@RequestBody WorkerDto workerDto);
}
