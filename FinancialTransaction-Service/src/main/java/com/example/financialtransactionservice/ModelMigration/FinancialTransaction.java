package com.example.financialtransactionservice.ModelMigration;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "financial_transactions")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FinancialTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "transaction_date")
    private Timestamp transactionDate;

    @Column(name = "type")
    private String type;

    @Column(name = "worker_id")
    private Long workerId;

    @Column(name = "manager_id")
    private Long managerId;
}