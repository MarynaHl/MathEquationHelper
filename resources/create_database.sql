CREATE DATABASE IF NOT EXISTS your_database_name;
USE your_database_name;

CREATE TABLE IF NOT EXISTS equations (
    id INT AUTO_INCREMENT PRIMARY KEY,
    equation VARCHAR(255) NOT NULL
);