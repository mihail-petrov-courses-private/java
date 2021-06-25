-- операции за създаване (рефлектират физически върху базата)

-- създаване на база данни
CREATE DATABASE bank_of_tommoroy;


-- създаване на таблица
-- VARCHAR <=> String
CREATE TABLE users(
	first_name 	VARCHAR(250),
    last_name 	VARCHAR(250),
    extra_name 	VARCHAR(250),
    adress  	VARCHAR(250),
    phone  		VARCHAR(30),
    email  		VARCHAR(150),
	ocupation   VARCHAR(100),
    department  VARCHAR(100)
);

-- операции за минипулиране (променят или създават данни в базат)

-- * създаване на информация (пъхане) INSERT
INSERT INTO users
(first_name, last_name, extra_name, 
adress, phone, email, ocupation, department)
VALUES
('Mihail', 'Petrov', 'Todorov', 'Plovdiv', 
 '08865058050', 'mail@mail', 'developer', 'IT');

-- частичен INSERT
INSERT INTO users
(first_name, last_name)
VALUES
('Todor', 'Nikolov');

-- * актуализация на информация (ъпдеит) UPDATE
UPDATE users
SET 
	first_name = 'Grigori';
    
-- откриване на подходящи записи
UPDATE users
	SET first_name = 'Manol'
WHERE
	extra_name = 'Todorov' OR 
	phone = '08865058050';

-- * изтриване на информация DELETE
DELETE FROM users
WHERE 
	phone IS NOT NULL

-- * селектиране на информация SELECT
SELECT first_name, last_name 
FROM users
WHERE phone = '08865068050'