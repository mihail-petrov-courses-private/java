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

    id INT PRIMARY KEY AUTO_INCREMENT,

	first_name VARCHAR(40) NOT NULL,
    last_name  VARCHAR(40) NOT NULL,
    extra_name VARCHAR(40),
    address VARCHAR(100) NOT NULL,
    phone CHAR(10) NOT NULL,
    email VARCHAR(100) NOT NULL,
    ocupation_id INT NOT NULL,
    department_id INT NOT NULL,
    
    UNIQUE(phone),
    UNIQUE(email),
    FOREIGN KEY(department_id) REFERENCES td_department(id),
    FOREIGN KEY(ocupation_id) REFERENCES td_ocupation(id)
);

INSERT INTO td_users(first_name, last_name, extra_name, address, phone, email, ocupation_id, department_id) 
VALUES
	('Mihail', 'Petrov', 'Todorov', 'Plovdiv', '088650401', 'mihail.petrov@mail.bg', 1, 1),
	('Todor', 'Ivanov', 'Nachev', 'Sofia', '085650401', 'todor.ivanov@mail.bg', 1, 2),
    ('Boris', 'Mihalev', 'Kirilov', 'Varna', '085640401', 'boris.mihalev@mail.bg', 3, 3);
    
-- нямам такава информация за подобен отдел с номер 4
INSERT INTO td_users(first_name, last_name, extra_name, address, phone, email, ocupation_id, department_id) 
VALUES    
    ('Georgi', 'Denchev', 'Marinov', 'Burgas', '085630851', 'georgi.denchev@mail.bg', 3, 4);

-- дай ми всички служители
SELECT *
FROM td_users;

-- дай ми всички програмисти
SELECT * 
FROM td_users
WHERE ocupation_id = 1;

-- дай ми всички програмисти, които работят в отдел операции
SELECT *
FROM td_users
WHERE ocupation_id = 1 AND department_id = 1;

-- изтрии всички директори в банката
DELETE FROM td_users
WHERE ocupation_id = 3;

-- актуализирай имела на всички от операции
UPDATE td_users
SET email = CONCAT('bt__', email)
WHERE department_id = 2;

-- свързване на 2 - таблици
SELECT * 
FROM td_users
INNER JOIN td_department 
ON td_users.department_id = td_department.id;

-- свързване на 3 - таблици
SELECT * 
FROM td_users AS a
INNER JOIN td_department AS b
	ON a.department_id = b.id
INNER JOIN td_ocupation AS c
	ON a.ocupation_id = c.id;

-- свързване на 3 - таблици в естетически издържан вид
SELECT 
	a.id, a.first_name, a.last_name, a.extra_name, a.address, a.phone, a.email,
    b.title AS 'department',
    c.title AS 'ocupation'
FROM td_users AS a
INNER JOIN td_department AS b
	ON a.department_id = b.id
INNER JOIN td_ocupation AS c
	ON a.ocupation_id = c.id;

--- 
DROP TABLE td_department;

CREATE TABLE td_department(
	id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(100)
);

-- предварителна информация за отделите на банката
INSERT INTO td_department(title)
VALUES('операции'), ('кредитна администрация'), ('валутни преводи');

CREATE TABLE td_ocupation(
	id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(100)
);

SELECT * FROM td_department;

-- предварителна информация за длъжностите
INSERT INTO td_ocupation(title)
VALUES('програмист') , ('експерт'), ('мениджър');

SELECT * FROM td_ocupation;