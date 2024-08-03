package com.example.shiftservice.ModelMigration;

import com.example.shiftservice.enums.ShiftStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@Table(name = "shift")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Shift {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "start_time")
    private Timestamp startTime;

    @Column(name = "end_time")
    private Timestamp endTime;

    @Column(name = "is_confirmed")
    private boolean isConfirmed;

    @Column(name = "status", nullable = false, columnDefinition = "VARCHAR(20) DEFAULT 'available'")
    private ShiftStatus status;

    @Column(name = "pickup_point_id")
    private Long pickupPointId;

    @Column(name = "worker_id")
    private Long workerId;
}