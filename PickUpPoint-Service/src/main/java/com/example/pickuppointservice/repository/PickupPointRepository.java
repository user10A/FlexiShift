package com.example.pickuppointservice.repository;

import com.example.pickuppointservice.ModelMigration.PickupPoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PickupPointRepository extends JpaRepository<PickupPoint, Long> {
}
