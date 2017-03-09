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

);

CREATE TABLE Status (
  code VARCHAR(32) NOT NULL PRIMARY KEY
);

CREATE TABLE MESSAGE (
id          INT AUTO_INCREMENT PRIMARY KEY,
id_from     INT,
id_to       INT
)

