package lt.ignitis.chatAppBack.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import lt.ignitis.chatAppBack.entities.User;
import lt.ignitis.chatAppBack.services.UserService;

@SpringBootTest
public class UsersControllerTest {
	User incomingUserObject;
	User returnedUserObject;
	
	@Mock//which is bellow is inserted into usersController
	UserService userService;
	
	
	@InjectMocks//into something that is bellow which is usersController
	UserController usersController;
	
	@BeforeEach
	void setUp() {
		incomingUserObject= new User(null, "zbignevas", "", null,null,null,null);
		returnedUserObject= new User(0, "zbignevas", "", "user",0,null,null);
	}
	
	@Test
	void onSuccessfulUserAddReturnsUserObject() {
		when(userService.addUser(incomingUserObject)).thenReturn(returnedUserObject);
		User u = usersController.addUser(incomingUserObject);
		assertEquals(u, returnedUserObject);
		verify(userService).addUser(incomingUserObject);
	}
	
	
}
