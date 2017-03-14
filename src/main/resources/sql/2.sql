INSERT INTO Gender (code)
  SELECT 'Male' AS code
  UNION ALL SELECT 'Female'
  UNION ALL SELECT 'Unknown';

  INSERT INTO Status (code)
  SELECT 'Sportsman' AS code
  UNION ALL SELECT 'Trainer'
  UNION ALL SELECT 'Unknown';

INSERT INTO User (first_name,last_name,patronymic,gender_code,nickname,dob,telephone,email,password,height,weight,country,city,status_code,rating)
VALUES ('Иван',
        'Иванов',
        'Иванович',
        'Male',
        'ИванX3',
        '1989-03-04',
        '8-967-222-33-22',
        'Vanya@mail.ru',
        'qwerty',
        177,
        75,
        'Россия',
        'Москва',
        'Trainer',
        0
        );
INSERT INTO User (first_name,last_name,patronymic,gender_code,nickname,dob,telephone,email,password,height,weight,country,city,status_code,rating)
VALUES ('Мария',
        'Соколова',
        'Сергеевна',
        'Female',
        'Мэри',
        '1993-12-04',
        '8-967-212-33-22',
        'Meri@mail.ru',
        'qwerty',
        167,
        49,
        'Россия',
        'Москва',
        'Sportsman',
        0
        );






