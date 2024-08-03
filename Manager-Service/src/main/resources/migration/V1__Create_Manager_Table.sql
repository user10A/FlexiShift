CREATE TABLE Manager (
                         id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
                         name VARCHAR(255) NOT NULL,
                         email VARCHAR(255) NOT NULL,
                         password VARCHAR(255) NOT NULL
);

INSERT INTO Manager (name, email, password) VALUES
                                                ('Иван Иванов', 'xemyru@gmail.com', '$2a$10$w3v5RmXc1z5Kylz2UMMdu.cVeWaT6eKrM8fOZES0E9/W1dYM.sLVK'),
                                                ('Петр Петров', 'petr.petrov@gmail.com', '$2a$10$w3v5RmXc1z5Kylz2UMMdu.cVeWaT6eKrM8fOZES0E9/W1dYM.sLVK'),
                                                ('Мария Сидорова', 'maria.sidorova@gmail.com', '$2a$10$w3v5RmXc1z5Kylz2UMMdu.cVeWaT6eKrM8fOZES0E9/W1dYM.sLVK'),
                                                ('Алексей Кузнецов', 'alexey.kuznetsov@gmail.com', '$2a$10$w3v5RmXc1z5Kylz2UMMdu.cVeWaT6eKrM8fOZES0E9/W1dYM.sLVK'),
                                                ('Ольга Смирнова', 'olga.smirnova@gmail.com', '$2a$10$w3v5RmXc1z5Kylz2UMMdu.cVeWaT6eKrM8fOZES0E9/W1dYM.sLVK'),
                                                ('Дмитрий Федоров', 'dmitry.fedorov@gmail.com', '$2a$10$w3v5RmXc1z5Kylz2UMMdu.cVeWaT6eKrM8fOZES0E9/W1dYM.sLVK'),
                                                ('Екатерина Романова', 'ekaterina.romanova@gmail.com', '$2a$10$w3v5RmXc1z5Kylz2UMMdu.cVeWaT6eKrM8fOZES0E9/W1dYM.sLVK'),
                                                ('Сергей Соколов', 'sergey.sokolov@gmail.com', '$2a$10$w3v5RmXc1z5Kylz2UMMdu.cVeWaT6eKrM8fOZES0E9/W1dYM.sLVK'),
                                                ('Анна Новикова', 'anna.novikova@gmail.com', '$2a$10$w3v5RmXc1z5Kylz2UMMdu.cVeWaT6eKrM8fOZES0E9/W1dYM.sLVK'),
                                                ('Максим Васильев', 'maxim.vasilyev@gmail.com', '$2a$10$w3v5RmXc1z5Kylz2UMMdu.cVeWaT6eKrM8fOZES0E9/W1dYM.sLVK');
