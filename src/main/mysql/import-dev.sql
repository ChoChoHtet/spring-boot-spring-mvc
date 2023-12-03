CREATE
DATABASE  IF NOT EXISTS `student_directory`;
USE`student_directory`;
DROP TABLE IF EXISTS `student_info`;

CREATE TABLE `student_info` (
    `id` int NOT NULL AUTO_INCREMENT,
    `first_name` varchar(64) DEFAULT NULL,
    `last_name` varchar(64) DEFAULT NULL,
    `phone_number` varchar(16) DEFAULT NULL,
    `email` varchar(64) DEFAULT NULL,
    `country` varchar(64) DEFAULT NULL,
    PRIMARY KEY (`id`)
);

INSERT INTO `student_info` VALUES (1,'cho','cho','09973042679','cho@gmail.com','Myanmar');
