INSERT INTO `forum`.`users` (`username`, `password`, `role`, `message_qty`, `first_message_timestamp`, `last_message_timestamp`) 
	VALUES ('testUser', 'password', 'user', 0, null, null)
;
INSERT INTO `forum`.`users` (`username`, `password`, `role`, `message_qty`, `first_message_timestamp`, `last_message_timestamp`) 
	VALUES ('admin', 'admin', 'admin', 0, null, null)
;

INSERT INTO `forum`.`messages` (date_created, content, user_id) 
	VALUES null, "this is a test message post", 0
;