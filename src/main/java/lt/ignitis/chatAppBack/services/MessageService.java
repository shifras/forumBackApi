package lt.ignitis.chatAppBack.services;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lt.ignitis.chatAppBack.entities.FormattedMessage;
import lt.ignitis.chatAppBack.entities.Message;
import lt.ignitis.chatAppBack.entities.User;
import lt.ignitis.chatAppBack.repositories.MessageRepository;
import lt.ignitis.chatAppBack.repositories.UserRepository;

@Service
public class MessageService {
	
	@Autowired
	MessageRepository messageRepository;
	
	@Autowired
	UserService userService;
	
	public List<Message> getMessages(){
		List<Message> messages = messageRepository.findAll();
		return messages;
	}
	
	public List<FormattedMessage> getFormattedMessages(){
		List<Message> messages = messageRepository.findAll();
		List<FormattedMessage> formattedMessages = new ArrayList<>();
		for (Message message : messages) {
			
			FormattedMessage formattedMessage = new FormattedMessage();
			
			formattedMessage.setAuthorUserId(message.getUser().getId());
			formattedMessage.setAuthorUsername(message.getUser().getUsername());
			formattedMessage.setDateCreated(message.getDateCreated());
			formattedMessage.setContent(message.getContent());
			
			formattedMessages.add(formattedMessage);
		}
		return formattedMessages;
	}
	
	public Message saveMessage(Message message) {
			Message m=messageRepository.save(message);
			m.setDateCreated(new Timestamp(System.currentTimeMillis()).toString());
			User user = userService.getUserById(m.getUser().getId());
			m.setUser(user);
			if (m.getUser().getMessageQty() == 0) {
				m.getUser().setFirstMessageId(m.getId());
			}
			m.getUser().setMessageQty(m.getUser().getMessageQty() + 1);
			m.getUser().setLastMessageId(m.getId());
			userService.updateUser(m.getUser());
		return messageRepository.save(m);
	}
}
