CREATE TABLE task (
                      id INT AUTO_INCREMENT PRIMARY KEY,
                      title VARCHAR(100) NOT NULL,
                      description VARCHAR(255) NOT NULL,
                      completed TINYINT(1) DEFAULT 0,
                      created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);