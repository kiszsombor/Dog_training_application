CREATE SCHEMA `dog_training_database` DEFAULT CHARACTER SET utf8 COLLATE utf8_bin ;

CREATE TABLE `dog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `birth_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `breed` varchar(45) DEFAULT NULL,
  `sex` enum('MALE','FEMALE','NEUTERED_MALE','NEUTERED_FEMALE') NOT NULL,
  `weight` varchar(45) DEFAULT NULL,
  `trainer_id` int(11) DEFAULT NULL,
  `owner_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `trainer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `user_name` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `email` varchar(45) DEFAULT NULL,
---  `address` varchar(45) DEFAULT NULL,
  `phone_number` int(11) DEFAULT NULL,
---  `birth_date` timestamp NULL DEFAULT NULL,
---  `birth_place` varchar(45) DEFAULT NULL,
  `role` ENUM('ROLE_ADMIN','ROLE_USER','ROLE_TRAINER') NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- CREATE TABLE `season_ticket` (
--   `id` int(11) NOT NULL AUTO_INCREMENT,
--   `start_date` datetime NULL DEFAULT NULL,
--   `end_date` datetime NULL DEFAULT NULL,
--   `paid` boolean NOT NULL,
--   `dog_id` int(11) DEFAULT NULL,
--   PRIMARY KEY (`Id`)
-- ) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `season_ticket` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dog_id` int(11) DEFAULT NULL,
  `start_date` timestamp NULL DEFAULT NULL,
  `end_date` timestamp NULL DEFAULT NULL,
  `spent_time` int(11) DEFAULT NULL,
  `paid` boolean DEFAULT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`dog_id`) REFERENCES `dog_training_database`.`dog`(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- CREATE TABLE `season_ticket_segment` (
--   `id` int(11) NOT NULL AUTO_INCREMENT,
--   `season_ticket_id` int(11) NOT NULL,
--   `date` timestamp NULL DEFAULT NULL,
--   `spent_time` timestamp NULL DEFAULT NULL,
--   PRIMARY KEY (`Id`)
-- ) ENGINE=InnoDB DEFAULT CHARSET=latin1;

---CREATE TABLE `season_ticket_segment` (
---  `id` int(11) NOT NULL AUTO_INCREMENT,
---  `season_ticket_id` int(11) DEFAULT NULL,
---  `date` timestamp NULL DEFAULT NULL,
---  `spent_time` int(11) DEFAULT NULL,
---  PRIMARY KEY (`id`),
---  KEY `season_ticket_id` (`season_ticket_id`),
---  FOREIGN KEY (`season_ticket_id`) REFERENCES `season_ticket` (`id`)
---) ENGINE=InnoDB DEFAULT CHARSET=latin1;

---CREATE TABLE `free_times` (
---  `id` int(11) NOT NULL AUTO_INCREMENT,
---  `date` datetime NULL DEFAULT NULL,
---  `time` timestamp NULL DEFAULT NULL,
---  PRIMARY KEY (`Id`)
---) ENGINE=InnoDB DEFAULT CHARSET=latin1;

---CREATE TABLE `taken_times` (
---  `id` int(11) NOT NULL AUTO_INCREMENT,
---  `date` datetime NULL DEFAULT NULL,
---  `time` timestamp NULL DEFAULT NULL,
---  PRIMARY KEY (`Id`)
---) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `trick` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` enum('COME', 'SIT', 'LAY', 'STAY', 'PAY_ATTENTION', 'LEAVE_IT', 'LEASH_WALK', 'LEG_WALK', 'UP', 'SHAKE_IT', 'ROLL_OVER', 'BRING_IT') NOT NULL,
  `category` enum('BASIC','INTERMEDIATE','ADVANCED') NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `dog_tricks` (
  `dog_id` int(11) NOT NULL, FOREIGN KEY (`dog_id`) REFERENCES `dog_training_database`.`dog`(`id`),
  `trick_id` int(11) NOT NULL, FOREIGN KEY (`trick_id`) REFERENCES `dog_training_database`.`trick`(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

---------------------------------------------------------------------------------------------------------------------------------------------------------

INSERT INTO trainer (name, user_name, password, email, phone_number, role) 
VALUES ('Nagy Emma', 'emma1@gmail.com', 202135544, 'ROLE_TRAINER'); 
INSERT INTO trainer (name, user_name, password, email, phone_number, role) 
VALUES ('Kis Károly', 'karcsi25@gmail.com', 305552145, 'ROLE_TRAINER');
INSERT INTO trainer (name, user_name, password, email, phone_number, role)
VALUES ('Apáti Kinga', 'kinga@gmail.com', 707070707, 'ROLE_TRAINER');
INSERT INTO trainer (name, user_name, password, email, phone_number, role)
VALUES ('Horváth Miklós', 'miki@gmail.com', 305552145, 'ROLE_TRAINER');

INSERT INTO dog (name, birth_date, breed, sex, weight, trainer_id, owner_id) VALUES ("Buksi", '2016-04-03 00:00:00', "keverék", "MALE", 30, 3, 1);
INSERT INTO dog (name, birth_date, breed, sex, weight, trainer_id, owner_id) VALUES ("Morci", '2018-05-24 00:00:00', "border collie", "NEUTERED_FEMALE", 23, 2, 4);
INSERT INTO dog (name, birth_date, breed, sex, weight, trainer_id, owner_id) VALUES ("Max", '2016-06-20 00:00:00', "golden retriever", "NEUTERED_MALE", 32, 1, 2);
INSERT INTO dog (name, birth_date, breed, sex, weight, trainer_id, owner_id) VALUES ("Morci", '2012-12-12 00:00:00', "tacskó", "FEMALE", 5, 4, 3);


---INSERT INTO season_ticket_segment (season_ticket_id, date, spent_time) VALUES (1, NOW(), 90);

---INSERT INTO season_ticket (start_date, end_date, paid, dog_id) VALUES ('2019-01-16 12:00:00', '2019-02-16 12:00:00', true, 1);

---INSERT INTO free_times (date, time) VALUES ('2019-01-20 12:00:00', '2019-02-10 12:00:00');

---INSERT INTO taken_times (date, time) VALUES ('2019-01-20 12:00:00', '2019-02-10 12:00:00');

INSERT INTO trick (name, category) VALUES ("COME", "BASIC");
INSERT INTO trick (name, category) VALUES ("SIT", "BASIC");
INSERT INTO trick (name, category) VALUES ("LAY", "BASIC");
INSERT INTO trick (name, category) VALUES ("STAY", "BASIC");
INSERT INTO trick (name, category) VALUES ("PAY_ATTENTION", "INTERMEDIATE");
INSERT INTO trick (name, category) VALUES ("LEAVE_IT", "INTERMEDIATE");
INSERT INTO trick (name, category) VALUES ("LEASH_WALK", "INTERMEDIATE");
INSERT INTO trick (name, category) VALUES ("LEG_WALK", "INTERMEDIATE");
INSERT INTO trick (name, category) VALUES ("UP", "ADVANCED");
INSERT INTO trick (name, category) VALUES ("SHAKE_IT", "ADVANCED");
INSERT INTO trick (name, category) VALUES ("ROLL_OVER", "ADVANCED");
INSERT INTO trick (name, category) VALUES ("BRING_IT", "ADVANCED");


INSERT INTO `season_ticket` (`id`, `dog_id`, `start_date`, `end_date`, `type`, `paid`) VALUES (NULL, '4', '2019-04-03 00:00:00', '2019-04-19 00:00:00', NULL, '0');
INSERT INTO `season_ticket` (`id`, `dog_id`, `start_date`, `end_date`, `type`, `paid`) VALUES (NULL, '3', '2019-04-14 00:00:00', '2019-04-27 00:00:00', NULL, '1');
INSERT INTO `season_ticket` (`id`, `dog_id`, `start_date`, `end_date`, `type`, `paid`) VALUES (NULL, '1', '2019-05-23 00:00:00', '2019-06-10 00:00:00', NULL, '1');
INSERT INTO `season_ticket` (`id`, `dog_id`, `start_date`, `end_date`, `type`, `paid`) VALUES (NULL, '2', '2019-04-20 00:00:00', '2019-05-03 00:00:00', NULL, '1');

INSERT INTO dog_tricks (dog_id, trick_id) VALUES (1, 1);
INSERT INTO dog_tricks (dog_id, trick_id) VALUES (1, 2);
INSERT INTO dog_tricks (dog_id, trick_id) VALUES (1, 3);
INSERT INTO dog_tricks (dog_id, trick_id) VALUES (2, 1);
INSERT INTO dog_tricks (dog_id, trick_id) VALUES (2, 2);
INSERT INTO dog_tricks (dog_id, trick_id) VALUES (3, 1);
INSERT INTO dog_tricks (dog_id, trick_id) VALUES (3, 2);
INSERT INTO dog_tricks (dog_id, trick_id) VALUES (3, 3);
INSERT INTO dog_tricks (dog_id, trick_id) VALUES (3, 4);
INSERT INTO dog_tricks (dog_id, trick_id) VALUES (4, 1);

---CREATE TABLE `dog_training_database`.`dog_tricks` ( 
---	`id` INT NOT NULL AUTO_INCREMENT ,
---	`dog_id` int(11) NOT NULL, FOREIGN KEY (`dog_id`) REFERENCES `dog_training_database`.`dog`(`id`),
---	`trick_id` int(11) NOT NULL, FOREIGN KEY (`trick_id`) REFERENCES `dog_training_database`.`trick`(`id`), 
---	PRIMARY KEY (`id`)
---) ENGINE = InnoDB;

												   
---ALTER TABLE `trainer` ADD `user_name` VARCHAR(45) NOT NULL AFTER `name`;
---ALTER TABLE `trainer` ADD `password` VARCHAR(45) NOT NULL AFTER `user_name`;
---ALTER TABLE `trainer` ADD `role` ENUM('ROLE_ADMIN','ROLE_USER','ROLE_TRAINER') NOT NULL AFTER `birth_place`;


ALTER TABLE `season_ticket` CHANGE `type` `spent_time` INT(10) NULL DEFAULT NULL;

<<<<<<< HEAD
INSERT INTO trick (name, category) VALUES ("sit", "basic");CREATE TABLE `season_ticket` (   `id` int(11) NOT NULL AUTO_INCREMENT,   `student_id` int(11) DEFAULT NULL,   `language` enum('ENGLISH','GERMAN','FRENCH') DEFAULT NULL,   `start_date` timestamp NULL DEFAULT NULL,   `end_date` timestamp NULL DEFAULT NULL,   `type` enum('TWELWE','SIXTEEN','TWENTY') DEFAULT NULL,   `paid` tinyint(4) DEFAULT NULL,   PRIMARY KEY (`id`),   KEY `student_id` (`student_id`),   FOREIGN KEY (`student_id`) REFERENCES `dog_training_database`.`student`(`id`) ) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1


#Trainer tábla módosítás

ALTER TABLE `trainer` ADD `password` VARCHAR(45) NOT NULL AFTER `email`;
INSERT INTO `trainer` (`id`, `name`, `email`, `password`, `address`, `phone_number`, `birth_date`, `birth_place`) VALUES (NULL, 'Kovács Gábor', 'gabor82@gmail.com', 'gabor82', 'gabor_addr', '2055566', '1995-05-02 00:00:00', 'Veszprém');

ALTER TABLE `trainer` ADD `role` ENUM('ROLE_ADMIN','ROLE_USER','','','') NOT NULL AFTER `password`;

UPDATE `trainer` SET `password` = 'emma1' WHERE `trainer`.`id` = 1;
UPDATE `trainer` SET `password` = 'karcsi25', `role` = 'ROLE_USER' WHERE `trainer`.`id` = 2;


ALTER TABLE `trainer` ADD `user_name` VARCHAR(45) NOT NULL AFTER `email`;
---ALTER TABLE `season_ticket` CHANGE `type` `spent_time` INT(10) NULL DEFAULT NULL;