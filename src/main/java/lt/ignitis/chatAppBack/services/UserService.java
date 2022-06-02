package lt.ignitis.chatAppBack.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lt.ignitis.chatAppBack.entities.User;
import lt.ignitis.chatAppBack.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	public User getUserById(Integer id) {
		//looks like if you dont add .get() at the end, you get serialisable/proxy exception, 
		//and does not return back User Object.
		//It still does the job anyway.
		return userRepository.findById(id).get();
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
