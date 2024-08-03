CREATE TABLE Blacklist (
                           id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
                           reason TEXT NOT NULL,
                           worker_id BIGINT,
                           manager_id BIGINT,
                           pickup_point_id BIGINT,
                           CONSTRAINT fk_worker_blacklist
                               FOREIGN KEY (worker_id)
                                   REFERENCES Worker(id),
                           CONSTRAINT fk_manager_blacklist
                               FOREIGN KEY (manager_id)
                                   REFERENCES Manager(id),
                           CONSTRAINT fk_pickup_point
                               FOREIGN KEY (pickup_point_id)
                                   REFERENCES PickUpPoint(pickup_point_id)
);
