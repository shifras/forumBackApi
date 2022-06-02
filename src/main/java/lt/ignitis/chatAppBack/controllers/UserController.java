package lt.ignitis.chatAppBack.controllers;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lt.ignitis.chatAppBack.entities.FormattedUser;
import lt.ignitis.chatAppBack.entities.User;
import lt.ignitis.chatAppBack.services.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	@CrossOrigin
	@GetMapping("/users")
	public List<User> getUsers(){
		return userService.getAllUsers();
	}
	
	@CrossOrigin
	@GetMapping("/users/{userId}")
	public FormattedUser getUser(@PathVariable Integer userId) {
		return userService.getFormattedUser(userId);
	}
}
