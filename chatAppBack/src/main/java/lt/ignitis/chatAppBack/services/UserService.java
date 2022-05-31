package lt.ignitis.chatAppBack.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lt.ignitis.chatAppBack.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
}
