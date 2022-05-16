USE bank;

-- drop table 
DROP TABLE is_true

CREATE DATABASE sample_databe_for_drop
DROP DATABASE sample_databe_for_drop

ALTER TABLE users DROP COLUMN id2
ALTER TABLE users ADD is_active CHAR(1) DEFAULT 'Y'
ALTER TABLE users DROP is_active
ALTER TABLE users ADD is_active TINYINT DEFAULT(1)

select * from users

CREATE TABLE truncate_users AS (SELECT * FROM users)

DELETE FROM truncate_users WHERE egn = 'AB01'

ALTER TABLE truncate_users ADD PRIMARY KEY(egn)
schema_users
TRUNCATE TABLE truncate_users

--
ALTER TABLE truncate_users ADD PRIMARY KEY(egn)
ALTER TABLE truncate_users  DROP PRIMARY KEY
ALTER TABLE truncate_users ADD PRIMARY KEY(egn, email)

DELETE FROM truncate_users 
select * from truncate_users 
INSERT INTO truncate_users(egn, fname, email)
VALUES('A5', 'Modor', 'Email')

-- DROP TABLE new_users, name_users

select * from users
ALTER TABLE users DROP manager_id 
ALTER TABLE users ADD manager_id VARCHAR(256) NOT NULL

UPDATE 
	users 
SET 
	manager_id = 'AB01' 
WHERE 
	egn = 'AB01'
    
-- select all users and there manager
SELECT 
	a.fname user_fname, 
    a.lname user_lname, 
    a.fname manager_fname, 
    a.lname manager_lname
FROM 
	users a
WHERE 
a.manager_id = (
	SELECT b.egn 
    FROM users b 
    WHERE egn = a.manager_id
)

-- select all users and there manager
SELECT 
	a.fname user_fname, 
    a.lname user_lname, 
    (
		-- SELECT b.fname, b.lname
        SELECT CONCAT(b.fname, ' ',b.lname) 
		FROM users b 
		WHERE egn = a.manager_id
	) manager_name
FROM 
	users a

ALTER TABLE users ADD salary INTEGER

select * from users

-- INSERT WITH SELECTION
INSERT INTO users(egn, fname, lname, title_id, department_id, manager_id, salary) 
VALUES (SELECT egn, fname, lname, title_id, department_id, manager_id, salary 
		FROM users 
        WHERE egn = 'AB01')
        
INSERT INTO users(egn, fname, lname, title_id, department_id, manager_id, salary) 
VALUES('AB03', 'Kozeto', 'Nenchov', 1,1, 'AB01', 1000)


CREATE TABLE user_copy AS (SELECT * FROM users)

-- NO NO 
INSERT INTO users(egn, fname, lname, title_id, department_id, manager_id, salary) 
AS (SELECT *
		FROM user_copy 
        WHERE egn = 'AB01')
        
		
INSERT INTO users(egn, fname, lname, title_id, department_id, manager_id) 
VALUES('AB06', (SELECT fname
		FROM user_copy 
        WHERE egn = 'AB01'), 'Test', 1,1, 'AB01')
        select * from users


-- spot the diference
SELECT MAX(salary), a.* FROM users a

/*
SELECT a.* 
FROM users a
WHERE a.salary = MAX(a.salary)
*/

-- NOt posible 
SELECT MAX(a.salary) max_salary
FROM users a 
WHERE a.salary = max_salary

SELECT * 
FROM users a
WHERE a.salary = (
	SELECT MAX(b.salary) 
    FROm users b
)

SELECT * FROM users a
SELECT SUM(fname) FROM users a

SELECT * 
from users 
ORDER BY salary DESC