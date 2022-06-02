package lt.ignitis.chatAppBack.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lt.ignitis.chatAppBack.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
}
