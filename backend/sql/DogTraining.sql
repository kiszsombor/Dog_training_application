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

#--------------------------------------------------------------------------------------
#----------------------------------BESZÚRÁSOK TÁBLÁKBA
#--------------------------------------------------------------------------------------
INSERT INTO trainer (name, email, address, phone_number, birth_date, birth_place) 
VALUES ('Nagy Emma', 'emma1@gmail.com', 'emma_address', 305552145, '1995-03-05 00:00:00', 'Budapest'); 
INSERT INTO trainer (name, email, address, phone_number, birth_date, birth_place) 
VALUES ('Kis Károly', 'karcsi25@gmail.com', 'karesz_address', 305552145, '1990-04-16 00:00:00', 'Budapest'); 


INSERT INTO dog (name,age,breed,weight,trainer_id) VALUES ("Buksi",5,"breed_Buksi",5,1);
INSERT INTO dog (name,age,breed,weight,trainer_id) VALUES ("Morci",4,"breed_Morci",5,2);