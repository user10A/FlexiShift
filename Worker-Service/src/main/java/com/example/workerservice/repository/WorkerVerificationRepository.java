package com.example.workerservice.repository;

import com.example.workerservice.ModelMigration.WorkerVerification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkerVerificationRepository extends JpaRepository<WorkerVerification, Long> {
}
