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
        '89672223322',
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
        '89672123322',
        'Meri@mail.ru',
        'qwerty',
        167,
        49,
        'Россия',
        'Москва',
        'Sportsman',
        0
        );
       INSERT INTO User (first_name,last_name,patronymic,gender_code,nickname,dob,telephone,email,password,height,weight,country,city,status_code,rating)
VALUES ('Дмитрий',
        'Смирнов',
        'Сергеевич',
        'Male',
        'Dmitriy',
        '1983-11-02',
        '89995231465',
        'Dmitr83@gmail.com',
        'qwerty',
        181,
        85,
        'Россия',
        'Санкт-Петербург',
        'Trainer',
        0
        );
       INSERT INTO User (first_name,last_name,patronymic,gender_code,nickname,dob,telephone,email,password,height,weight,country,city,status_code,rating)
VALUES ('Алексей',
        'Дмитриевич',
        'Петров',
        'Male',
        'Alex',
        '1979-11-02',
        '89671113322',
        'Alex@mail.ru',
        'qwerty',
        177,
        78,
        'Россия',
        'Москва',
        'Sportsman',
        0
        );
        INSERT INTO User (first_name,last_name,patronymic,gender_code,nickname,dob,telephone,email,password,height,weight,country,city,status_code,rating)
VALUES ('Ирина',
        'Максимовна',
        'Михайлова',
        'Female',
        'Irina',
        '1992-03-15',
        '89671113322',
        'Ira@mail.ru',
        'qwerty',
        173,
        51,
        'Россия',
        'Москва',
        'Sportsman',
        0
        );
 INSERT INTO User (first_name,last_name,patronymic,gender_code,nickname,dob,telephone,email,password,height,weight,country,city,status_code,rating)
VALUES ('Светлана',
        'Сергеевна',
        'Смирнова',
        'Female',
        'Sveta',
        '1987-01-15',
        '89998887722',
        'Svet150187@mail.ru',
        'qwerty',
        168,
        48,
        'Россия',
        'Пермь',
        'Sportsman',
        0
        );






