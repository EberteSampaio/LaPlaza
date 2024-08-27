CREATE TABLE food_status (
                               id INT PRIMARY KEY AUTO_INCREMENT,
                               short_name VARCHAR(50) NOT NULL,
                               description TEXT,
                               created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                               updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);
