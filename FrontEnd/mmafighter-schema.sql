DROP SCHEMA IF EXISTS `mma`;

CREATE SCHEMA IF NOT EXISTS `mma`;

USE `mma` ;

CREATE TABLE IF NOT EXISTS `mma`.`fighters` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(80) NOT NULL,
    `age` int(2) NOT NULL,
    `wins` int DEFAULT 0,
    `losses` int DEFAULT 0,
    `draws` int DEFAULT 0,
    `no-contests` int DEFAULT 0,
    PRIMARY KEY (`id`)
);

