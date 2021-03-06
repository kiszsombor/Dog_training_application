CREATE DATABASE IF NOT EXISTS dog_training_database DEFAULT CHARACTER SET utf8 COLLATE utf8_bin;

CREATE TABLE dog_training_database.trainer (
      `id` int NOT NULL AUTO_INCREMENT,
      `name` varchar(45) DEFAULT NULL,
      `username` varchar(45) DEFAULT NULL,
      `password` varchar(45) DEFAULT NULL,
      `email` varchar(45) DEFAULT NULL,
      `address` varchar(45) DEFAULT NULL,
      `phone_number` int DEFAULT NULL,
      `birth_date` timestamp(0) NULL DEFAULT NULL,
      `birth_place` varchar(45) DEFAULT NULL,
      `role` varchar(45) DEFAULT NULL,

      PRIMARY KEY (id)
    );

INSERT INTO dog_training_database.trainer (name, username, password, email, address, phone_number, birth_date, birth_place, role)
VALUES ("Nagy Emma", "emma", "password1", "emma1@gmail.com", "emma_address", 305552145, "1995-03-05 00:00:00", "Budapest", "ROLE_USER");

INSERT INTO dog_training_database.trainer (name, username, password, email, address, phone_number, birth_date, birth_place, role)
VALUES ("Kis Károly", "karcsi", "password2", "karcsi25@gmail.com", "karesz_address", 305552145, "1990-04-16 00:00:00", "Budapest", "ROLE_USER");