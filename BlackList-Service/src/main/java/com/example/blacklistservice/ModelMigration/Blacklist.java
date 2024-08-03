package com.example.blacklistservice.ModelMigration;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "blacklist")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Blacklist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "reason")
    private String reason;

    @Column(name = "worker_id")
    private Long workerId;

    @Column(name = "manager_id")
    private Long managerId;

    @Column(name = "pickup_point_id")
    private Long pickUpPointId;
}