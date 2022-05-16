CREATE DATABASE fat_cat;

CREATE TABLE td_users(

	-- id
    id INT AUTO_INCREMENT PRIMARY KEY,
	-- 
    
	user_email 		VARCHAR(250),
	user_name 		VARCHAR(250),
    user_password 	VARCHAR(250),
	first_name 		VARCHAR(250),
    last_name 		VARCHAR(250),
	age 		INTEGER,
	city  		VARCHAR(250),
    address  	VARCHAR(250)
);

CREATE TABLE tm_roles (
    id INT AUTO_INCREMENT PRIMARY KEY,
	title VARCHAR(256)
);

CREATE TABLE td_user__role(
    user_id INT,
    role_Id INT
);

--  Insert roles
INSERT INTO tm_roles(title) VALUES('USER');
INSERT INTO tm_roles(title) VALUES('MODERATOR');
INSERT INTO tm_roles(title) VALUES('ADMIN');

-- Insert sample user
INSERT INTO td_users(user_email,  user_name, user_password, first_name, last_name, age, city, address)
VALUES('mail@mail.bg',  'mihailpetrov',  'password',  'Mihail',  'Petrov',  29,  'Plovdiv',  'Bjalo more');

INSERT INTO td_users(user_email,  user_name, user_password, first_name, last_name, age, city, address)
VALUES('todor@mail.bg',  'todorivanov',  'password',  'Todor',  'Ivanov',  55,  'Sofia',  'Centar');

-- Insert user roles
INSERT INTO td_user__role(user_id,  role_id ) VALUES(1, 1);
INSERT INTO td_user__role(user_id,  role_id ) VALUES(1, 2);

INSERT INTO td_user__role(user_id,  role_id ) VALUES(2, 3);

-- 
select * from td_users;
select * from tm_roles;
select * from td_user__role;


-- JOIN table data
SELECT * FROM td_users WHERE id = 1; -- > single user 
SELECT * FROM td_user__role WHERE user_id = 1; -- > collection of roles

-- GET ALL DATA (WITH ALIASES)
SELECT * 
FROM td_users 		AS a, 
	 td_user__role 	AS b, 
     tm_roles 		AS c
WHERE      
     a.id = b.user_id AND
	 c.id = b.role_id AND 
     a.id = 1;
     
-- GET ALL DATA (NO ALIASES)
SELECT * 
FROM td_users 		, 
	 td_user__role 	, 
     tm_roles 		
WHERE      
     td_users.id = td_user__role.user_id AND
	 tm_roles.id = td_user__role.role_id AND 
     td_users.id = 1;     
     
	
-- GET ALL ROLES (WITH ALIASES)
SELECT c.* 
FROM td_users 		AS a, 
	 td_user__role 	AS b, 
     tm_roles 		AS c
WHERE      
     a.id = b.user_id AND
	 c.id = b.role_id AND 
     a.id = 1;
     
-- GET ALL ROLES (NO ALIASES)
SELECT tm_roles.* 
FROM td_users 		AS a, 
	 td_user__role 	AS b, 
     tm_roles 		AS c
WHERE      
     a.id = b.user_id AND
	 c.id = b.role_id AND 
     a.id = 1
     
     
