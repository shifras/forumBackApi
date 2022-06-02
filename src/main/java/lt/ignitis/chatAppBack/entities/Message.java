package lt.ignitis.chatAppBack.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "messages", schema = "forum")
public class Message {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "date_created" ,columnDefinition = "VARCHAR(30) DEFAULT 'NULL'")
	private String dateCreated;
	
	@Column(length = 280)
	private String content;
	
	@ManyToOne
	@JoinColumn(name = "user_id", columnDefinition = "INT DEFAULT 'null'", referencedColumnName = "id")
	private User user;

	public Message() {
		super();
	}


	public Message(Integer id, String dateCreated, String content, User user) {
		super();
		this.id = id;
		this.dateCreated = dateCreated;
		this.content = content;
		this.user = user;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDateCreated() {
		return dateCreated;
	}


	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	@Override
	public String toString() {
		return "Message [id=" + id + ", dateCreated=" + dateCreated + ", content=" + content + ", user=" + user + "]";
	}


	

	
	

	
	
	
	
	
}
