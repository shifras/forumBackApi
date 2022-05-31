package lt.ignitis.chatAppBack.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users", schema = "forum")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private String username;
	
	@Column
	private String password;
	
	@Column
	private String role;
	
	@Column(name = "message_qty", columnDefinition = "INT default '0'")
	private Integer messageQty;
	
	@Column(name = "first_message_timestamp", columnDefinition = "VARCHAR(30) default 'NULL'")
	private String firstMessageTimestamp;
	
	@Column(name = "last_message_timestamp", columnDefinition = "VARCHAR(30) default 'NULL'")
	private String lastMessageTimestamp;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(Integer id, String username, String password, String role, Integer messageQty, String firstMessageTimestamp, String lastMessageTimestamp) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.role = role;
		this.messageQty = messageQty;
		this.firstMessageTimestamp = firstMessageTimestamp;
		this.lastMessageTimestamp = lastMessageTimestamp;
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

	public String getFirstMessageTimestamp() {
		return firstMessageTimestamp;
	}

	public void setFirstMessageTimestamp(String firstMessageTimestamp) {
		this.firstMessageTimestamp = firstMessageTimestamp;
	}

	public String getLastMessageTimestamp() {
		return lastMessageTimestamp;
	}

	public void setLastMessageTimestamp(String lastMessageTimestamp) {
		this.lastMessageTimestamp = lastMessageTimestamp;
	}

	
	
	
	
	
	
}
