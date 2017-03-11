CREATE TABLE User (
  id          INT AUTO_INCREMENT PRIMARY KEY,
  first_name  VARCHAR(50)  NOT NULL,
  last_name   VARCHAR(50)  NOT NULL,
  patronymic VARCHAR(255),
  nickname    VARCHAR(50)  NOT NULL,
  dob         DATE,
  telephone   VARCHAR(100) NOT NULL,
  email       VARCHAR(100) NOT NULL,
  password    VARCHAR(255) NOT NULL,
  status_code      VARCHAR(15)  NOT NULL,
  UNIQUE (nickname),
  UNIQUE (email)

);

CREATE TABLE Status (
  code VARCHAR(32) NOT NULL PRIMARY KEY
);

CREATE TABLE MESSAGE (
id          INT AUTO_INCREMENT PRIMARY KEY,
id_from     INT,
id_to       INT,
FOREIGN KEY(id_from) REFERENCES User(id),
FOREIGN KEY(id_to) REFERENCES User(id),
);

CREATE TABLE Friends(
id          INT AUTO_INCREMENT PRIMARY KEY,
id_friend1    INT,
id_friend2       INT,
FOREIGN KEY(id_friend1) REFERENCES User(id),
FOREIGN KEY(id_friend2) REFERENCES User(id),
);

CREATE TABLE Mission(
id          INT AUTO_INCREMENT PRIMARY KEY,
id_trainer    INT,
id_sportsman      INT,
mission VARCHAR (500) NOT NULL,
state VARCHAR (10) NOT NULL,
date DATE,
FOREIGN KEY(id_trainer) REFERENCES User(id),
FOREIGN KEY(id_sportsman) REFERENCES User(id),
);

