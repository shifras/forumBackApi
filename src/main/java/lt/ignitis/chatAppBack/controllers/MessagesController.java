package lt.ignitis.chatAppBack.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lt.ignitis.chatAppBack.entities.FormattedMessage;
import lt.ignitis.chatAppBack.entities.Message;
import lt.ignitis.chatAppBack.services.MessageService;
import lt.ignitis.chatAppBack.services.UserService;

@RestController
@RequestMapping("/")
public class MessagesController {
	
	@Autowired
	MessageService messageService;
	
	@Autowired
	UserService userService;
	
	@CrossOrigin
	@GetMapping("/messages")
	public List<FormattedMessage> getFormattedMessages() {
		return messageService.getFormattedMessages();
	}
	
	@CrossOrigin
	@PostMapping("/messages")
	public Message add(@RequestBody Message message) {
			return messageService.saveMessage(message);
	}
	
	@CrossOrigin
	@GetMapping("/")
	public List<Message> getMessages() {
		return messageService.getMessages();
	}
	
	
	
} 
	
