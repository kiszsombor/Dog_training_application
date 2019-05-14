#
# Létrehozó script a sémához
#
CREATE SCHEMA `dog_training_database` DEFAULT CHARACTER SET utf8 COLLATE utf8_bin ;

#----------------------------------
# Author: Bajári LÚCIA 
#----------------------------------
#
# Létrehozó script a dog táblához
#
#----------------------------------
CREATE TABLE `dog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `birth_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `breed` varchar(45) DEFAULT NULL,
  `sex` enum('MALE','FEMALE','NEUTERED_MALE','NEUTERED_FEMALE') NOT NULL,
  `weight` varchar(45) DEFAULT NULL,
  `trainer_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#----------------------------------
# Author: Bajári LÚCIA 
#----------------------------------
#
# Létrehozó script a trainer táblához
#
#----------------------------------
CREATE TABLE `trainer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `phone_number` int(11) DEFAULT NULL,
  `birth_date` timestamp NULL DEFAULT NULL,
  `birth_place` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#----------------------------------
# Author: Kis Zsombor
#----------------------------------
#
# Létrehozó script a season_ticket_segment táblához
#
#----------------------------------
-- CREATE TABLE `season_ticket_segment` (
--   `id` int(11) NOT NULL AUTO_INCREMENT,
--   `season_ticket_id` int(11) NOT NULL,
--   `date` timestamp NULL DEFAULT NULL,
--   `spent_time` timestamp NULL DEFAULT NULL,
--   PRIMARY KEY (`Id`)
-- ) ENGINE=InnoDB DEFAULT CHARSET=latin1;
#----------------------------------
# Author: Bajári Lúcia
#----------------------------------
#
# Módosítás + kapcsolat hozzáadása: season_ticket_segment
#
#----------------------------------

CREATE TABLE `season_ticket_segment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `season_ticket_id` int(11) DEFAULT NULL,
  `date` timestamp NULL DEFAULT NULL,
  `spent_time` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `season_ticket_id` (`season_ticket_id`),
  FOREIGN KEY (`season_ticket_id`) REFERENCES `season_ticket` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#----------------------------------
# Author: Kis Zsombor
#----------------------------------
#
# Létrehozó script a season_ticket táblához
#
#----------------------------------
-- CREATE TABLE `season_ticket` (
--   `id` int(11) NOT NULL AUTO_INCREMENT,
--   `start_date` datetime NULL DEFAULT NULL,
--   `end_date` datetime NULL DEFAULT NULL,
--   `paid` boolean NOT NULL,
--   `dog_id` int(11) DEFAULT NULL,
--   PRIMARY KEY (`Id`)
-- ) ENGINE=InnoDB DEFAULT CHARSET=latin1;
#----------------------------------
# Author: Bajári Lúcia
#----------------------------------
#
# Módosítás + kapcsolat hozzáadása: season_ticket
#
#----------------------------------

CREATE TABLE `season_ticket` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dog_id` int(11) DEFAULT NULL,
  `start_date` timestamp NULL DEFAULT NULL,
  `end_date` timestamp NULL DEFAULT NULL,
  `type` enum('TWELWE','SIXTEEN','TWENTY') DEFAULT NULL,
  `paid` boolean DEFAULT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`dog_id`) REFERENCES `dog_training_database`.`dog`(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#----------------------------------
# Author: Kis Zsombor
#----------------------------------
#
# Létrehozó script a free_times táblához
#
#----------------------------------
CREATE TABLE `free_times` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` datetime NULL DEFAULT NULL,
  `time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#----------------------------------
# Author: Kis Zsombor
#----------------------------------
#
# Létrehozó script a taken_times táblához
#
#----------------------------------
CREATE TABLE `taken_times` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` datetime NULL DEFAULT NULL,
  `time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#----------------------------------
# Author: Kis Zsombor
#----------------------------------
#
# Létrehozó script a trick táblához
#
#----------------------------------
CREATE TABLE `trick` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` enum('COME', 'SIT', 'LAY', 'STAY', 'PAY_ATTENTION', 'LEAVE_IT', 'LEASH_WALK', 'LEG_WALK', 'UP', 'SHAKE_IT', 'ROLL_OVER', 'BRING_IT') NOT NULL,
  `category` enum('BASIC','INTERMEDIATE','ADVANCED') NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#----------------------------------
# Author: Kis Zsombor
#----------------------------------
#
# Létrehozó script a dog_tricks táblához
#
#----------------------------------
#----------------------------------
CREATE TABLE `dog_tricks` (
  `dog_id` int(11) NOT NULL, FOREIGN KEY (`dog_id`) REFERENCES `dog_training_database`.`dog`(`id`),
  `trick_id` int(11) NOT NULL, FOREIGN KEY (`trick_id`) REFERENCES `dog_training_database`.`trick`(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
#--------------------------------------------------------------------------------------
#----------------------------------BESZÚRÁSOK TÁBLÁKBA
#--------------------------------------------------------------------------------------
INSERT INTO trainer (name, email, address, phone_number, birth_date, birth_place) 
VALUES ('Nagy Emma', 'emma1@gmail.com', 'emma_address', 305552145, '1995-03-05 00:00:00', 'Budapest'); 
INSERT INTO trainer (name, email, address, phone_number, birth_date, birth_place) 
VALUES ('Kis Károly', 'karcsi25@gmail.com', 'karesz_address', 305552145, '1990-04-16 00:00:00', 'Budapest'); 


INSERT INTO dog (name,birth_date,breed,sex,weight,trainer_id) VALUES ("Buksi",NOW(),"breed_Buksi","MALE",5,1);
INSERT INTO dog (name,birth_date,breed,sex,weight,trainer_id) VALUES ("Morci",NOW(),"breed_Morci","NEUTERED_FEMALE",5,2);

INSERT INTO season_ticket_segment (season_ticket_id, date, spent_time) VALUES (1, NOW(), 90);

INSERT INTO season_ticket (start_date, end_date, paid, dog_id) VALUES ('2019-01-16 12:00:00', '2019-02-16 12:00:00', true, 1);

INSERT INTO free_times (date, time) VALUES ('2019-01-20 12:00:00', '2019-02-10 12:00:00');

INSERT INTO taken_times (date, time) VALUES ('2019-01-20 12:00:00', '2019-02-10 12:00:00');

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


INSERT INTO `season_ticket` (`id`, `dog_id`, `start_date`, `end_date`, `type`, `paid`) VALUES (NULL, '2', '2019-04-03 00:00:00', '2019-04-19 00:00:00', NULL, '0'), (NULL, '3', '2019-04-14 00:00:00', '2019-04-27 00:00:00', NULL, '1');
INSERT INTO `season_ticket` (`id`, `dog_id`, `start_date`, `end_date`, `type`, `paid`) VALUES (NULL, '2', '2019-04-23 00:00:00', '2019-05-24 00:00:00', NULL, '1'), (NULL, '2', '2019-04-20 00:00:00', '2019-05-17 00:00:00', NULL, '1');

INSERT INTO dog_tricks (dog_id, trick_id) VALUES (1, 1);
INSERT INTO dog_tricks (dog_id, trick_id) VALUES (1, 2);
INSERT INTO dog_tricks (dog_id, trick_id) VALUES (1, 3);
INSERT INTO dog_tricks (dog_id, trick_id) VALUES (2, 1);
INSERT INTO dog_tricks (dog_id, trick_id) VALUES (2, 2);

CREATE TABLE `dog_training_database`.`dog_tricks` ( `id` INT NOT NULL AUTO_INCREMENT , 
                                                  `dog_id` int(11) NOT NULL, FOREIGN KEY (`dog_id`) REFERENCES `dog_training_database`.`dog`(`id`),
  													`trick_id` int(11) NOT NULL, FOREIGN KEY (`trick_id`) REFERENCES `dog_training_database`.`trick`(`id`), 
                                                   PRIMARY KEY (`id`)) ENGINE = InnoDB;