CREATE TABLE person(

  id INTEGER NOT NULL,
  name VARCHAR(255),
  location VARCHAR(255),
  birth_date TIMESTAMP,
  PRIMARY KEY(id)

);

INSERT INTO PERSON (ID, NAME, LOCATION, BIRTH_DATE )
VALUES(10001,  'Ranga', 'Hyderabad',sysdate());
INSERT INTO PERSON (ID, NAME, LOCATION, BIRTH_DATE )
VALUES(10002,  'James', 'New York',sysdate());
INSERT INTO PERSON (ID, NAME, LOCATION, BIRTH_DATE )
VALUES(10003,  'Pieter', 'Amsterdam',sysdate());

INSERT INTO course(id, name, created_date, last_updated_date) VALUES (10001, 'Java Developer', sysdate(), sysdate());
INSERT INTO course(id, name, created_date, last_updated_date) VALUES (10002, 'Php Developer', sysdate(), sysdate());
INSERT INTO course(id, name, created_date, last_updated_date) VALUES (10003, 'Ruby Developer', sysdate(), sysdate());

INSERT INTO passport(id, number) VALUES (40001, 'E48487554');
INSERT INTO passport(id, number) VALUES (40002, 'E63859954');
INSERT INTO passport(id, number) VALUES (40003, 'E94938858');

INSERT INTO student(id, name, passport_id) VALUES (20001, 'Theara', 40001);
INSERT INTO student(id, name, passport_id) VALUES (20002, 'Dara', 40002);
INSERT INTO student(id, name, passport_id) VALUES (20003, 'Rotha', 40003);

INSERT INTO review(id, rating, description) VALUES (50001, '5', 'Description 1');
INSERT INTO review(id, rating, description) VALUES (50002, '2', 'Description 2');
INSERT INTO review(id, rating, description) VALUES (50003, '4', 'Description 3');