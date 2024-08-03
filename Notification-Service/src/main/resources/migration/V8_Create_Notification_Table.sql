CREATE TABLE Notifications (
                               notification_id INT PRIMARY KEY AUTO_INCREMENT,
                               notification_type VARCHAR(30) NOT NULL, --'booking_confirmation', 'shift_reminder', 'penalty', 'bonus'
                               message TEXT NOT NULL,
                               shift_id BIGINT,
                               worker_id BIGINT,
                               manager_id BIGINT,
                               is_sent BOOLEAN DEFAULT FALSE,
                               sent_at DATETIME,
                               FOREIGN KEY (shift_id) REFERENCES Shifts(shift_id),
                               FOREIGN KEY (worker_id) REFERENCES Workers(worker_id),
                               FOREIGN KEY (manager_id) REFERENCES Workers(worker_id)
);