package com.example.workerservice.api;

import com.example.workerservice.ModelMigration.WorkerDto;
import com.example.workerservice.service.WorkerService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/worker")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:8080")
public class WorkerApi {

    private final WorkerService workerService;
/*
    @ApiOperation(
            value = "Создать нового работника",
            notes = "Сохраняет нового работника в базе данных",
            httpMethod = "POST"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Работник успешно создан"),
            @ApiResponse(code = 400, message = "Некорректные данные"),
            @ApiResponse(code = 500, message = "Внутренняя ошибка сервера")
    })*/

    @GetMapping("/existsByEmail/{email}")
    public ResponseEntity<Boolean> existsByEmail(@PathVariable String email) {
        return ResponseEntity.ok(workerService.existsByEmail(email));
    }

    @GetMapping("/getWorkerByEmail/{email}")
    public ResponseEntity<WorkerDto> getWorkerByEmail(@PathVariable String email) {
        return ResponseEntity.ok(workerService.getWorkerByEmail(email));
    }

    @PostMapping("/saveWorker")
    public void saveWorker(@RequestBody WorkerDto workerDto){
        workerService.saveWorker(workerDto);
    }
}
