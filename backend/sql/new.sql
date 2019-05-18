---CREATE SEQUENCE dog_seq;

ALTER SEQUENCE trainer_seq RESTART WITH 1;

---CREATE TYPE sex_enum AS ENUM ('MALE','FEMALE','NEUTERED_MALE','NEUTERED_FEMALE');

CREATE TABLE dog (
  id int NOT NULL DEFAULT NEXTVAL ('dog_seq'),
  name varchar(45) NOT NULL,
  birth_date timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP,
  breed varchar(45) DEFAULT NULL,
  sex sex_enum NOT NULL,
  weight varchar(45) DEFAULT NULL,
  trainer_id int DEFAULT NULL,
  PRIMARY KEY (id)
) ;

------------------------------------

---CREATE SEQUENCE trainer_seq;

ALTER SEQUENCE trainer_seq RESTART WITH 1;

CREATE TABLE trainer (
  id int NOT NULL DEFAULT NEXTVAL ('trainer_seq'),
  name varchar(45) DEFAULT NULL,
  email varchar(45) DEFAULT NULL,
  address varchar(45) DEFAULT NULL,
  phone_number int DEFAULT NULL,
  birth_date timestamp(0) NULL DEFAULT NULL,
  birth_place varchar(45) DEFAULT NULL,
  PRIMARY KEY (id)
) ;

------------------------------------

---CREATE SEQUENCE season_ticket_seq;

ALTER SEQUENCE season_ticket_seq RESTART WITH 1;

---CREATE TYPE type_enum AS ENUM ('TWELWE','SIXTEEN','TWENTY');

CREATE TABLE season_ticket (
  id int NOT NULL DEFAULT NEXTVAL ('season_ticket_seq'),
  dog_id int DEFAULT NULL,
  start_date timestamp(0) NULL DEFAULT NULL,
  end_date timestamp(0) NULL DEFAULT NULL,
  type type_enum DEFAULT NULL,
  paid boolean DEFAULT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (dog_id) REFERENCES dog(id)
);

------------------------------------

---CREATE SEQUENCE season_ticket_segment_seq;

ALTER SEQUENCE season_ticket_segment_seq RESTART WITH 1;

CREATE TABLE season_ticket_segment (
  id int NOT NULL DEFAULT NEXTVAL ('season_ticket_segment_seq'),
  season_ticket_id int DEFAULT NULL,
  date timestamp(0) NULL DEFAULT NULL,
  spent_time int DEFAULT NULL,
  PRIMARY KEY (id)
 ,
  FOREIGN KEY (season_ticket_id) REFERENCES season_ticket (id)
) ;

CREATE INDEX season_ticket_id ON season_ticket_segment (season_ticket_id);

------------------------------------

---CREATE SEQUENCE free_times_seq;

ALTER SEQUENCE free_times_seq RESTART WITH 1;

CREATE TABLE free_times (
  id int NOT NULL DEFAULT NEXTVAL ('free_times_seq'),
  date timestamp(0) NULL DEFAULT NULL,
  time timestamp(0) NULL DEFAULT NULL,
  PRIMARY KEY (Id)
) ;

------------------------------------

---CREATE SEQUENCE taken_times_seq;

ALTER SEQUENCE taken_times_seq RESTART WITH 1;

CREATE TABLE taken_times (
  id int NOT NULL DEFAULT NEXTVAL ('taken_times_seq'),
  date timestamp(0) NULL DEFAULT NULL,
  time timestamp(0) NULL DEFAULT NULL,
  PRIMARY KEY (Id)
) ;

------------------------------------

---CREATE SEQUENCE trick_seq;

ALTER SEQUENCE trick_seq RESTART WITH 1;

---CREATE TYPE name_enum AS ENUM ('COME', 'SIT', 'LAY', 'STAY', 'PAY_ATTENTION', 'LEAVE_IT', 'LEASH_WALK', 'LEG_WALK', 'UP', 'SHAKE_IT', 'ROLL_OVER', 'BRING_IT');
---CREATE TYPE category_enum AS ENUM ('BASIC','INTERMEDIATE','ADVANCED');

CREATE TABLE trick (
  id int NOT NULL DEFAULT NEXTVAL ('trick_seq'),
  name name_enum NOT NULL,
  category category_enum NOT NULL,
  PRIMARY KEY (Id)
);

------------------------------------

CREATE TABLE dog_tricks (
  dog_id int NOT NULL,
  trick_id int NOT NULL
) ;

--------------------------------------------------------------------------------------------

INSERT INTO trainer (name, email, address, phone_number, birth_date, birth_place) 
VALUES ('Nagy Emma', 'emma1@gmail.com', 'emma_address', 305552145, '1995-03-05 00:00:00', 'Budapest'); 
INSERT INTO trainer (name, email, address, phone_number, birth_date, birth_place) 
VALUES ('Kis Károly', 'karcsi25@gmail.com', 'karesz_address', 305552145, '1990-04-16 00:00:00', 'Budapest'); 


INSERT INTO dog (name,birth_date,breed,sex,weight,trainer_id) VALUES ('Buksi',NOW(),'breed_Buksi','MALE',5,1);
INSERT INTO dog (name,birth_date,breed,sex,weight,trainer_id) VALUES ('Morci',NOW(),'breed_Morci','NEUTERED_FEMALE',5,2);

INSERT INTO season_ticket (start_date, end_date, paid, dog_id) VALUES ('2019-01-16 12:00:00', '2019-02-16 12:00:00', true, 1);

INSERT INTO season_ticket_segment (season_ticket_id, date, spent_time) VALUES (1, NOW(), 90);

INSERT INTO free_times (date, time) VALUES ('2019-01-20 12:00:00', '2019-02-10 12:00:00');

INSERT INTO taken_times (date, time) VALUES ('2019-01-20 12:00:00', '2019-02-10 12:00:00');

INSERT INTO trick (name, category) VALUES ('COME', 'BASIC');
INSERT INTO trick (name, category) VALUES ('SIT', 'BASIC');
INSERT INTO trick (name, category) VALUES ('LAY', 'BASIC');
INSERT INTO trick (name, category) VALUES ('STAY', 'BASIC');
INSERT INTO trick (name, category) VALUES ('PAY_ATTENTION', 'INTERMEDIATE');
INSERT INTO trick (name, category) VALUES ('LEAVE_IT', 'INTERMEDIATE');
INSERT INTO trick (name, category) VALUES ('LEASH_WALK', 'INTERMEDIATE');
INSERT INTO trick (name, category) VALUES ('LEG_WALK', 'INTERMEDIATE');
INSERT INTO trick (name, category) VALUES ('UP', 'ADVANCED');
INSERT INTO trick (name, category) VALUES ('SHAKE_IT', 'ADVANCED');
INSERT INTO trick (name, category) VALUES ('ROLL_OVER', 'ADVANCED');
INSERT INTO trick (name, category) VALUES ('BRING_IT', 'ADVANCED');

INSERT INTO dog_tricks (dog_id, trick_id) VALUES (1, 1);
INSERT INTO dog_tricks (dog_id, trick_id) VALUES (1, 2);
INSERT INTO dog_tricks (dog_id, trick_id) VALUES (1, 3);
INSERT INTO dog_tricks (dog_id, trick_id) VALUES (2, 1);
INSERT INTO dog_tricks (dog_id, trick_id) VALUES (2, 2);