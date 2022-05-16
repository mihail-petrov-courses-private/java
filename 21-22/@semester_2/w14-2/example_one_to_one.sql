CREATE TABLE tb_users(
	id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    username VARCHAR(256) NOT NULL,
    password VARCHAR(256) NOT NULL,
    email VARCHAR(256) NOT NULL
);

CREATE TABLE tb_user_personal_data(
	user_id INT,
    fname VARCHAR(256) NOT NULL,
    lname VARCHAR(256) NOT NULL,
    city  VARCHAR(256) NOT NULL,
    age INT
);

INSERT INTO tb_users(username, password, email)
VALUES('mihail', 'password', 'mail@mail.bg');

INSERT INTO tb_user_personal_data(user_id, fname, lname, city, age)
VALUES(1, 'Mihail', 'Petrov', 'Plovdiv', 29);

SELECT a.*, b.fname, b.lname, b.city, b.age 
FROM tb_users AS a, tb_user_personal_data AS b
WHERE a.id = b.user_id;

