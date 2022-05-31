package lt.ignitis.chatAppBack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class ChatAppBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChatAppBackApplication.class, args);
	}

}