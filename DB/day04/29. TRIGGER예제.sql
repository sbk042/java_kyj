
CREATE SCHEMA `text` ;

CREATE DATABASE  IF NOT EXISTS `text`;
USE `text`;
DROP TABLE IF EXISTS `member`;

CREATE TABLE `member` (
  `me_id` varchar(10) NOT NULL,
  `me_pw` varchar(45) NOT NULL,
  PRIMARY KEY (`me_id`)
);

DROP TABLE IF EXISTS `dash_board`;

CREATE TABLE `dash_board` (
  `db_num` int NOT NULL AUTO_INCREMENT,
  `db_member` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`db_num`)
);
INSERT INTO `text`.`dash_board` (`db_member`) VALUES ('0');