INSERT INTO Status (code)
  SELECT 'Trainer' AS code
  UNION ALL SELECT 'Sportsman'
  UNION ALL SELECT 'Unknown';
INSERT INTO User (first_name,last_name,patronymic,nickname,dob,telephone,email,password,status_code)
VALUES ('Вася',
        'Пупкин',
        'tyf',
        'Вася',
        '1989-03-04',
        '222-33-22',
        'VasyaPupkin@mail.ru',
        'qwerty',
        'trainer');







