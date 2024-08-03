CREATE TABLE PickupPoint (
                             id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
                             name VARCHAR(255) NOT NULL,
                             address VARCHAR(255) NOT NULL,
                             manager_id BIGINT,
                             CONSTRAINT fk_manager
                                 FOREIGN KEY (manager_id)
                                     REFERENCES Manager(id)
);

-- Вставка данных в таблицу PickupPoint
INSERT INTO PickupPoint (name, address, manager_id) VALUES
                                                        ('ПВЗ "Центральный"', 'ул. Центральная, д. 10', null),
                                                        ('ПВЗ "Северный"', 'ул. Северная, д. 5', null),
                                                        ('ПВЗ "Южный"', 'ул. Южная, д. 15', null),
                                                        ('ПВЗ "Восточный"', 'ул. Восточная, д. 20', null),
                                                        ('ПВЗ "Западный"', 'ул. Западная, д. 25', null),
                                                        ('ПВЗ "Городской"', 'ул. Городская, д. 30', null),
                                                        ('ПВЗ "Пригородный"', 'ул. Пригородная, д. 35', null),
                                                        ('ПВЗ "Университетский"', 'ул. Университетская, д. 40', null),
                                                        ('ПВЗ "Спортивный"', 'ул. Спортивная, д. 45', null),
                                                        ('ПВЗ "Культурный"', 'ул. Культурная, д. 50', null);