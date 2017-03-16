CREATE TABLE Gender (
  code VARCHAR(20) NOT NULL PRIMARY KEY
);
CREATE TABLE Status (
  code VARCHAR(32) NOT NULL PRIMARY KEY
);
CREATE TABLE User (
  id          INT AUTO_INCREMENT PRIMARY KEY,
  first_name  VARCHAR(50)  NOT NULL,
  last_name   VARCHAR(50)  NOT NULL,
  patronymic VARCHAR(255),
  gender_code VARCHAR (20) NOT NULL,
  nickname    VARCHAR(50)  NOT NULL,
  dob         DATE,
  telephone   VARCHAR(100) NOT NULL,
  email       VARCHAR(100) NOT NULL,
  password    VARCHAR(255) NOT NULL,
  height FLOAT ,
  weight FLOAT ,
  country VARCHAR(60),
  city VARCHAR(60),
  status_code VARCHAR(32) NOT NULL,
  rating INT,

  FOREIGN KEY (gender_code) REFERENCES Gender (code),
  FOREIGN KEY (status_code) REFERENCES Status (code),
  UNIQUE (email)
);

CREATE TABLE MESSAGE (
id          INT AUTO_INCREMENT PRIMARY KEY,
id_from     INT,
id_to       INT,
message VARCHAR(1000) NOT NULL,
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
state BOOL NOT NULL,
date DATE,
FOREIGN KEY(id_trainer) REFERENCES User(id),
FOREIGN KEY(id_sportsman) REFERENCES User(id),
);

