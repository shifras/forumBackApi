package lt.ignitis.chatAppBack.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lt.ignitis.chatAppBack.entities.Message;
import lt.ignitis.chatAppBack.services.MessageService;
import lt.ignitis.chatAppBack.services.UserService;

@RestController
@RequestMapping("/messages")
public class MessagesController {
	
	@Autowired
	MessageService messageService;
	
	@Autowired
	UserService userService;
	
	
	@GetMapping("/")
	public List<Message> getMessages() {
		return messageService.getMessages();
	}
}
