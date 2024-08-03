package com.example.workerservice.repository;

import com.example.workerservice.ModelMigration.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WorkerRepository extends JpaRepository<Worker, Long> {
    Optional<Worker> getWorkerByEmail(String email);
    boolean existsWorkerByEmail(String email);
}
