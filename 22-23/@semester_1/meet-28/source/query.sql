-- създаване на база данни 
-- ================================
CREATE DATABASE db_bank_of_tomorow;

-- избор на база данни
-- ================================
USE db_bank_of_tomorow;

-- Изтриване на таблица
-- ================================
DROP TABLE td_users;

-- създаване на таблица
-- ================================
CREATE TABLE td_users(
	first_name VARCHAR(40),
    last_name  VARCHAR(40),
    extra_name VARCHAR(40),
    address VARCHAR(100),
    phone CHAR(10),
    email VARCHAR(100),
    ocupation VARCHAR(100),
    department VARCHAR(100)
);

-- добавяне на информация към таблица
-- ================================
INSERT INTO td_users(
	first_name, last_name
)
VALUES(
	"Mihail", "Petrov"
);

-- селектирам информация от таблица 
-- ================================
SELECT *
FROM td_users;

-- актуализирам информация в таблица
-- внимавайте когато изпълнявате такава заявка
-- ================================
UPDATE td_users
SET last_name = 'Ivanov';

-- изтриване на данни от таблица
-- ================================
DELETE 
FROM td_users;
