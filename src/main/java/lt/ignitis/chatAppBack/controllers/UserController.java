package lt.ignitis.chatAppBack.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lt.ignitis.chatAppBack.entities.FormattedUser;
import lt.ignitis.chatAppBack.entities.User;
import lt.ignitis.chatAppBack.exceptions.ErrorResponse;
import lt.ignitis.chatAppBack.exceptions.UserExistsException;
import lt.ignitis.chatAppBack.services.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	@ExceptionHandler(value= {Exception.class})
	public ResponseEntity<ErrorResponse> defaultException(Exception e){
		System.out.println("toks vardas egzistuoja, exception handleris");
		return new ResponseEntity<>(new ErrorResponse("Bad username","",406), HttpStatus.NOT_ACCEPTABLE);
	}
	
	@CrossOrigin
	@GetMapping("/users")
	public List<User> getUsers(){
		return userService.getAllUsers();
	}
	
	@CrossOrigin
	@PostMapping("/users/add")
	public User addUser(@RequestBody User user) {
		List<User> messages = userService.findByUsername(user.getUsername());
		if(messages.isEmpty()) {
			return userService.addUser(user);
		} else {
		throw new UserExistsException("Vartotojas tokiu vardu jau egzistuoja", 406);
		}
			
	}
	
	@CrossOrigin
	@GetMapping("/users/{userId}")
	public FormattedUser getUser(@PathVariable Integer userId) {
		return userService.getFormattedUser(userId);
	}
}
