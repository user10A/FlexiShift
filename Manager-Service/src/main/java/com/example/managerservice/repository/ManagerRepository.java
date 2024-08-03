package com.example.managerservice.repository;

import com.example.managerservice.ModelMigration.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Long> {
    Optional<Manager> getManagerByEmail(String email);
    boolean existsManagerByEmail(String email);
}