package lt.ignitis.chatAppBack.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lt.ignitis.chatAppBack.entities.Message;
import lt.ignitis.chatAppBack.repositories.MessageRepository;

@Service
public class MessageService {
	
	@Autowired
	MessageRepository messageRepository;
	
	public List<Message> getMessages(){
		return messageRepository.findAll();
	}
}
