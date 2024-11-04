package com.example.managerservice.ModelMigration;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "manager")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Manager {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "manager_gen")
    @SequenceGenerator(name = "manager_gen",sequenceName = "manager_seq", allocationSize = 1, initialValue = 11)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "pickUpPoint_id")
    private Long pickUpPointId;
}