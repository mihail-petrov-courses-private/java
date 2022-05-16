-- users
-- * username
-- * email
-- * password
-- * city
-- * IBAN / DEBIT CARD
-- * EGN
-- * age

-- DDL
-- DML

-- create database online_catshop
CREATE DATABASE online_catshop;


-- create tabke for users
CREATE TABLE online_catshop.users(
	
    username VARCHAR(136),
    email VARCHAR(136),
    password VARCHAR(136),
    age INTEGER
);



-- create sample records
INSERT INTO online_catshop.users(username, email, password, age)
VALUES('admin', 'admin.onlineshop.com', '123456', 28);

INSERT INTO online_catshop.users(username, email, password, age)
VALUES('moderator', 'moderator.onlineshop.com', '123456', 24)

-- add new role column
ALTER TABLE online_catshop.users ADD COLUMN role INTEGER

-- get all users
SELECT * FROM online_catshop.users
SELECT username, email FROM online_catshop.users

-- update specific column
UPDATE online_catshop.users SET role = 0 WHERE username = 'admin'
UPDATE online_catshop.users SET role = 1 WHERE username = 'moderator'