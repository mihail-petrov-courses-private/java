CREATE DATABASE relation_db;
USE relation_db;

CREATE TABLE tb_users(
	id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    username VARCHAR(256) NOT NULL,
    password VARCHAR(256) NOT NULL,
    email VARCHAR(256) NOT NULL
);

CREATE TABLE tb_products(
	id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    category_id INT,
    title VARCHAR(256) NOT NULL,
    description TEXT,
    price DECIMAL
);

CREATE TABLE tm_category(
	id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    title VARCHAR(256) NOT NULL
);

CREATE TABLE tb_purchase(
	id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    user_id INT NOT NULL,
    product_id INT NOT NULL,
    quantity INT NOT NULL
);

-- users
INSERT INTO `relation_db`.`tb_users`
(`username`, `password`, `email`)
VALUES
('mihail', 'password', 'mail@mail.bg');

-- products
INSERT INTO `relation_db`.`tm_category` (`title`) VALUES ('дом');
INSERT INTO `relation_db`.`tm_category`(`title`) VALUES ('градина');

-- products
INSERT INTO `relation_db`.`tb_products`
(`category_id`, `title`, `description`, `price`)
VALUES
(1, 'Микровълнова', 'Чудесна печка', 290);

-- tb_purchase
INSERT INTO `relation_db`.`tb_purchase`
(`user_id`, `product_id`, `quantity`)
VALUES
(1, 1, 1);



-- Вземи информация за всички продукти, които са купени от mihail
SELECT a.username, a.password, a.email,
	   b.title, b.description, b.price,
       d.title
FROM tb_users 		AS a, 
	 tb_products 	AS b,
     tb_purchase 	AS c,
     tm_category 	AS d
WHERE 
	a.id = c.user_id 
    AND 
    b.id = c.product_id
    AND 
    d.id = b.category_id;


CREATE VIEW test_view AS
SELECT a.username, a.password, a.email,
	   b.title, b.description, b.price,
       d.title AS category_title
FROM tb_users 		AS a, 
	 tb_products 	AS b,
     tb_purchase 	AS c,
     tm_category 	AS d
WHERE 
	a.id = c.user_id 
    AND 
    b.id = c.product_id
    AND 
    d.id = b.category_id;
    
    
SELECT * FROM test_view




