package lt.ignitis.chatAppBack.entities;

public class FormattedMessage {
	private Integer authorUserId;
	private String authorUsername;
	private String dateCreated;
	private String content;
	
	public FormattedMessage() {
		super();
	}
	
	

	public Integer getAuthorUserId() {
		return authorUserId;
	}



	public void setAuthorUserId(Integer authorUserId) {
		this.authorUserId = authorUserId;
	}



	public String getAuthorUsername() {
		return authorUsername;
	}
	
	public void setAuthorUsername(String authorUsername) {
		this.authorUsername = authorUsername;
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
}
