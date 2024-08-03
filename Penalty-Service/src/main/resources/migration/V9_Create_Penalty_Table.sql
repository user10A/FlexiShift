CREATE TABLE Penalty (
                         penalty_id INT PRIMARY KEY AUTO_INCREMENT,
                         worker_id INT NOT NULL,
                         shift_id INT,
                         reason TEXT NOT NULL,
                         penalty_type VARCHAR(20) NOT NULL, --'account_block', 'rating_decrease', 'fine'
                         penalty_value INT NOT NULL,
                         applied_at DATETIME NOT NULL,
                         FOREIGN KEY (worker_id) REFERENCES Workers(worker_id),
                         FOREIGN KEY (shift_id) REFERENCES Shifts(shift_id)
);