CREATE SCHEMA forum;

--CREATE TABLE `forum`.`users`(
--	id          					INTEGER auto_increment PRIMARY KEY,
--	username 						VARCHAR(64) NOT NULL DEFAULT "username",
--	password						VARCHAR(300)NOT NULL DEFAULT "ASD",
--	message_qty   					INTEGER NOT NULL DEFAULT 0,
--	first_message_timestamp			VARCHAR(35),
--	last_message_timestamp			VARCHAR(35)
--);
--
--CREATE TABLE `forum`.`messages`(
--	id          	INTEGER auto_increment PRIMARY KEY,
--	date_created 	VARCHAR(35),
--	content   		VARCHAR(280),
--	user_id			INTEGER,
--	CONSTRAINT  FOREIGN KEY (user_id) REFERENCES users(id)
--);