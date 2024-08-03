package com.example.reviewservice.ModelMigration;

import com.example.reviewservice.enums.ReviewType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "review")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "rating", nullable = false)
    private Integer rating;

    @Column(name = "comment")
    private String comment;

    @Column(name = "review_type", nullable = false)
    private ReviewType reviewType;

    @Column(name = "worker_id")
    private Long workerId;

    @Column(name = "manager_id")
    private Long managerId;

    @Column(name = "pickup_point_id")
    private Long pickupPointId;
}