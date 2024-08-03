package com.example.workerservice.ModelMigration;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@Table(name = "workerverification")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkerVerification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "is_verified")
    private boolean isVerified;

    @Column(name = "verification_date")
    private Timestamp verificationDate;

    @ManyToOne
    @JoinColumn(name = "worker_id")
    private Worker worker;
}