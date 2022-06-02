package lt.ignitis.chatAppBack.entities;


import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "users", schema = "forum")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(unique = true , columnDefinition = "VARCHAR(30)")
	private String username;
	
	@Column(columnDefinition = "VARCHAR(50) default ''")
	private String password = "";
	
	@Column(columnDefinition = "VARCHAR(10) default 'user'")
	private String role = "user";
	
	@Column(name = "message_qty", columnDefinition = "INT default '0'")
	private Integer messageQty = 0;
	
//	@OneToOne(targetEntity = Message.class, fetch = FetchType.EAGER)
//	@JoinColumn(name = "first_message_id", columnDefinition = "Integer DEFAULT 'NULL'", referencedColumnName = "id")
	@Column(name = "first_message_id")
	private Integer firstMessageId;
	
//	@OneToOne(targetEntity = Message.class, fetch = FetchType.EAGER)
//	@JoinColumn(name = "last_message_id", columnDefinition = "Integer DEFAULT 'NULL'", referencedColumnName = "id")
	@Column(name = "last_message_id")
	private Integer lastMessageId;
	
//	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
//	private List<Message> messages;
	
	public User() {
		super();
	}

	public User(Integer id, String username, String password, String role, Integer messageQty, Integer firstMessageId,
			Integer lastMessageId, List<Message> messages) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.role = role;
		this.messageQty = messageQty;
		this.firstMessageId = firstMessageId;
		this.lastMessageId = lastMessageId;
//		this.messages = messages;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Integer getMessageQty() {
		return messageQty;
	}

	public void setMessageQty(Integer messageQty) {
		this.messageQty = messageQty;
	}



	public Integer getFirstMessageId() {
		return firstMessageId;
	}



	public void setFirstMessageId(Integer firstMessageId) {
		this.firstMessageId = firstMessageId;
	}



	public Integer getLastMessageId() {
		return lastMessageId;
	}



	public void setLastMessageId(Integer lastMessageId) {
		this.lastMessageId = lastMessageId;
	}

	public Double calcMeanMessageLen(List<Message> userMessages) {
		Double messageLenSum = 0.0;
		for (Message message : userMessages) {
			messageLenSum += message.getContent().length();
		}
		return messageLenSum/this.messageQty*1.0;
	}

	

	

	

}
