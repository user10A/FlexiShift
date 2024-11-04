package com.example.pickuppointservice.repository;

import com.example.pickuppointservice.ModelMigration.PickupPoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PickupPointRepository extends JpaRepository<PickupPoint, Long> {
    Optional<PickupPoint> findPickupPointByManagerId(Long managerId);
}
