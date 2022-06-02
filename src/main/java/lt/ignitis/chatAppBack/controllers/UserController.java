package lt.ignitis.chatAppBack.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lt.ignitis.chatAppBack.entities.FormattedUser;
import lt.ignitis.chatAppBack.entities.User;
import lt.ignitis.chatAppBack.exceptions.ErrorResponse;
import lt.ignitis.chatAppBack.exceptions.UserException;
import lt.ignitis.chatAppBack.services.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	@ExceptionHandler(value = {UserException.class})
	public ResponseEntity<ErrorResponse> userException(UserException e){
		return new ResponseEntity<>(new ErrorResponse(e.getMessage(),HttpStatus.valueOf(e.getCode()).toString(),e.getCode()), HttpStatus.valueOf(e.getCode()));
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
		throw new UserException("Vartotojas tokiu vardu jau egzistuoja", 406);
		}
			
	}
	
	@CrossOrigin
	@GetMapping("/users/{userId}")
	public FormattedUser getUser(@PathVariable Integer userId) {
		return userService.getFormattedUser(userId);
	}
	
	@CrossOrigin
	@DeleteMapping("/users/delete/{userId}")
	public Boolean deleteUser(@PathVariable Integer userId) {
		User u=userService.getUserById(userId);
		Integer a=u.getMessageQty();
		if (a == 0) {
			userService.deleteUser(userId);
			return true;
		} else {
			throw new UserException("Negalima istrinti "+u.getUsername()+", pirma reikia istrinti userio zinutes kuriu yra "+u.getMessageQty()+".", 500);
		}
	}
}
