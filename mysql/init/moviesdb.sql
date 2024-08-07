CREATE USER 'debezium'@'%' IDENTIFIED BY 'dbz';
GRANT SELECT, RELOAD, SHOW DATABASES, REPLICATION SLAVE, REPLICATION CLIENT ON *.* TO 'debezium'@'%';
FLUSH PRIVILEGES;

USE moviesdb;

CREATE TABLE `movies` (
                          `imdb_id` VARCHAR(10) PRIMARY KEY NOT NULL,
                          `year` INT NOT NULL,
                          `title` VARCHAR(255) NOT NULL,
                          `actors` VARCHAR(1000) NOT NULL,
                          `poster` VARCHAR(255) NOT NULL,
                          `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
                          `updated_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
