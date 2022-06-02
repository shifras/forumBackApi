package lt.ignitis.chatAppBack.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lt.ignitis.chatAppBack.entities.FormattedUser;
import lt.ignitis.chatAppBack.entities.Message;
import lt.ignitis.chatAppBack.entities.User;
import lt.ignitis.chatAppBack.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	MessageService messageService;
	
	public User getUserById(Integer id) {
		//looks like if you dont add .get() at the end, you get serialisable/proxy exception, 
		//and does not return back User Object.
		//It still does the job anyway.
		return userRepository.findById(id).get();
	}
	
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	public FormattedUser getFormattedUser(Integer userId) {
		FormattedUser formattedUser = new FormattedUser();
		User user = this.getUserById(userId);
		
		Message firstMessage = messageService.getMessageById(user.getFirstMessageId());
		Message lastMessage = messageService.getMessageById(user.getLastMessageId());
		
		List<Message> userMessages = messageService.getUserMessages(userId);
		
		formattedUser.setUserId(user.getId());
		formattedUser.setUsername(user.getUsername());
		formattedUser.setMessageQty(user.getMessageQty());
		formattedUser.setFirstMessageTime(firstMessage.getDateCreated());
		formattedUser.setLastMessageTime(lastMessage.getDateCreated());
		formattedUser.setLastMessageContent(lastMessage.getContent());
		formattedUser.setMeanMessageLen(user.calcMeanMessageLen(userMessages));
		return formattedUser;
	}
	
	public User updateUser(User user) {
//		User old = this.findById(user.getId());
//		if (old.getFirstMessage() == null) {
//			old.setFirstMessage(user.getFirstMessage());
//		}
//		
//		old.setLastMessage(user.getLastMessage());
//		old.setMessageQty(user.getMessageQty());
		return userRepository.save(user);
	}
}
