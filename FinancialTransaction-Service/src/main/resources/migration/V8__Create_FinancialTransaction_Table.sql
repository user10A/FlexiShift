CREATE TABLE FinancialTransaction (
                                      id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
                                      amount DECIMAL(19, 2) NOT NULL,
                                      transaction_date TIMESTAMP NOT NULL,
                                      type VARCHAR(255) NOT NULL,
                                      worker_id BIGINT,
                                      manager_id BIGINT,
                                      CONSTRAINT fk_worker_transaction
                                          FOREIGN KEY (worker_id)
                                              REFERENCES Worker(id),
                                      CONSTRAINT fk_manager_transaction
                                          FOREIGN KEY (manager_id)
                                              REFERENCES Manager(id)
);
