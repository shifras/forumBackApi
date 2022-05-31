package lt.ignitis.chatAppBack.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lt.ignitis.chatAppBack.entities.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer> {
	
}
