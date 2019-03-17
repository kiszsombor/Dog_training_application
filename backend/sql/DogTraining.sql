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
  `age` int(10) unsigned NOT NULL,
  `breed` varchar(45) DEFAULT NULL,
  `weight` varchar(45) DEFAULT NULL,
  `trainer_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`)
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
CREATE TABLE `season_ticket_segment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `season_ticket_id` int(11) NOT NULL,
  `date` timestamp NULL DEFAULT NULL,
  `spent_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#----------------------------------
# Author: Kis Zsombor
#----------------------------------
#
# Létrehozó script a season_ticket táblához
#
#----------------------------------
CREATE TABLE `season_ticket` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `start_date` datetime NULL DEFAULT NULL,
  `end_date` datetime NULL DEFAULT NULL,
  `paid` boolean NOT NULL,
  `dog_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`)
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
# Létrehozó script a dog_tricks táblához
#
#----------------------------------
CREATE TABLE `dog_tricks` (
  `dog_id` int(11) NOT NULL,
  `trick_id` int(11) NOT NULL
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
  `name` enum NULL DEFAULT NULL,
  `category` enum NULL DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#--------------------------------------------------------------------------------------
#----------------------------------BESZÚRÁSOK TÁBLÁKBA
#--------------------------------------------------------------------------------------
INSERT INTO trainer (name, email, address, phone_number, birth_date, birth_place) 
VALUES ('Nagy Emma', 'emma1@gmail.com', 'emma_address', 305552145, '1995-03-05 00:00:00', 'Budapest'); 
INSERT INTO trainer (name, email, address, phone_number, birth_date, birth_place) 
VALUES ('Kis Károly', 'karcsi25@gmail.com', 'karesz_address', 305552145, '1990-04-16 00:00:00', 'Budapest'); 


INSERT INTO dog (name,age,breed,weight,trainer_id) VALUES ("Buksi",5,"breed_Buksi",5,1);
INSERT INTO dog (name,age,breed,weight,trainer_id) VALUES ("Morci",4,"breed_Morci",5,2);

INSERT INTO season_ticket_segment (season_ticket_id, date, spent_time) VALUES (1, '2019-01-16 12:00:00', '2019-02-16 12:00:00');

INSERT INTO season_ticket (start_date, end_date, paid, dog_id) VALUES ('2019-01-16 12:00:00', '2019-02-16 12:00:00', true, 1);

INSERT INTO free_times (date, time) VALUES ('2019-01-20 12:00:00', '2019-02-10 12:00:00');

INSERT INTO taken_times (date, time) VALUES ('2019-01-20 12:00:00', '2019-02-10 12:00:00');

INSERT INTO dog_tricks (dog_id, trick_id) VALUES (1, 1);

INSERT INTO trick (name, category) VALUES ("sit", "basic");