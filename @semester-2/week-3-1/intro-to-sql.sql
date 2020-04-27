CREATE DATABASE bank;

USE bank;

CREATE TABLE bank.users (
	egn VARCHAR(10) PRIMARY KEY,
	fname VARCHAR(256),
    lname VARCHAR(256),
    ename VARCHAR(256),
    address VARCHAR(256),
    mphone VARCHAR(256),
    email  VARCHAR(256),
    
    -- 
    title_id  INTEGER,
    department_id INTEGER
);

INSERT INTO users(egn, fname, lname, ename, address, mphone, email, title_id, department_id) 
VALUES('AB01', 'Mihail', 'Petrov', NULL, 'Plovdiv', '088505050', 'mail@mihail-petrov.me', NULL, NULL); 

INSERT INTO users(egn, fname, lname, ename, address, mphone, email, title_id, department_id) 
VALUES('AB02', 'Anton', 'Jankov', NULL, 'Sofia', '088404040', 'mail@anton-jankov.me', 2, 2); 


select * from users
ALTER TABLE users ADD COLUMN id2 INTEGER
ALTER TABLE users DROP COLUMN id

-- 
CREATE TABLE new_users AS (SELECT * FROM users)
CREATE TABLE schema_users AS (SELECT * FROM users WHERE 1 = 2)

CREATE TABLE name_users AS (SELECT fname,lname, ename FROM users WHERE 1 = 2)

-- 
select * from new_users
select * from schema_users
select * from name_users
ALTER TABLE schema_users DROP COLUMN id2

ALTER TABLE schema_users DROP department_id



CREATE TABLE job_titles (
	id INTEGER PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(256)
);

INSERT INTO job_titles(title) 
VALUES('IT operator');
INSERT INTO job_titles(title) 
VALUES('Credit ecspert');
INSERT INTO job_titles(title) 
VALUES('Director');

select * from job_titles

DELETE from job_titles where id = 3


CREATE TABLE departments (
	id INTEGER PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(256)
);

INSERT INTO departments(title)
VALUES('IT');
INSERT INTO departments(title)
VALUES('Credits');
INSERT INTO departments(title)
VALUES('Administration');


select * from users;

UPDATE users
	SET title_id = 1,
		department_id = 1
	WHERE egn = 'AB01';
    
-- users
-- job_titles
-- departments

CREATE TABLE join_users AS 
(
SELECT  a.EgN, 
		a.fname, 
        a.lname, 
        a.ename, 
        a.address, 
        a.mphone, 
        a.email, 
		b.title job_title, 
        c.title  department_title
FROM  users a,
	  job_titles b,
	  departments c
WHERE a.title_id = b.id 	 AND
	  a.department_id = c.id AND 
      a.egn = 'AB01'
);
      
      select * from join_users;
      
  CREATE TABLE is_true (
	id INTEGER PRIMARY KEY AUTO_INCREMENT,
    is_true BOOLEAN
  )
  
  select * from is_true
  INSERT INTO is_true(is_true)VALUES(FALSE)
  
  'Y' / 'N'
  
  
  
CREATE TABLE account_items(
	id INTEGER PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(256)
);

INSERT INTO account_items(title) VALUES('Printer A1');
INSERT INTO account_items(title) VALUES('Scaner  A2');
INSERT INTO account_items(title) VALUES('Laptop  B5');

CREATE TABLE user__account_item(
	user_id INTEGER,
    account_item_id INTEGER
);

INSERT INTO user__account_item(user_id, account_item_id) 
VALUES(1,1);

INSERT INTO user__account_item(user_id, account_item_id) 
VALUES(1,2);

INSERT INTO user__account_item(user_id, account_item_id) 
VALUES(1,3);

select * from account_items a,
			  user__account_item b,
              users c
              WHERE c.fname = ''
					b.user_id = 1 AND 
					a.id = b.account_item_id