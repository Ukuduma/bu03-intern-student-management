
CREATE TABLE `NOTIFICATION`(
                               `ID` BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                               `TITLE` VARCHAR(255) DEFAULT NULL,
                               `BODY` VARCHAR(255) DEFAULT NULL,
                               `CREATED_DATE` TIMESTAMP DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;