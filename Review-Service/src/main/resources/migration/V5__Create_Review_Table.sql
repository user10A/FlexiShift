CREATE TABLE Review (
                        id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
                        rating INT NOT NULL,
                        comment TEXT,
                        review_type VARCHAR(10) NOT NULL,  -- "worker" or "manager"
                        worker_id BIGINT,                  -- ID работника, оставляющего отзыв
                        manager_id BIGINT,                 -- ID менеджера, получающего отзыв
                        pickup_point_id BIGINT,            -- ID пункта сбора, о котором идет речь
                        CONSTRAINT fk_worker_review FOREIGN KEY (worker_id) REFERENCES Worker(id),
                        CONSTRAINT fk_manager_review FOREIGN KEY (manager_id) REFERENCES Manager(id),
                        CONSTRAINT fk_pickup_point_review FOREIGN KEY (pickup_point_id) REFERENCES PickupPoint(id)
);