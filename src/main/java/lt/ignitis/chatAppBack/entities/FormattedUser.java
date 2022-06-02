package lt.ignitis.chatAppBack.entities;

public class FormattedUser {
	private Integer userId;
	private String username;
	private Integer messageQty;
	private String firstMessageTime;
	private String lastMessageTime;
	private Double meanMessageLen;
	private String lastMessageContent;
	
	public FormattedUser(String username, Integer messageQty, String firstMessageTime, String lastMessageTime,
			Double meanMessageLen, String lastMessageContent, Integer userId) {
		super();
		this.username = username;
		this.messageQty = messageQty;
		this.firstMessageTime = firstMessageTime;
		this.lastMessageTime = lastMessageTime;
		this.meanMessageLen = meanMessageLen;
		this.lastMessageContent = lastMessageContent;
		this.userId = userId;
	}

	public FormattedUser() {
		super();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getMessageQty() {
		return messageQty;
	}

	public void setMessageQty(Integer messageQty) {
		this.messageQty = messageQty;
	}

	public String getFirstMessageTime() {
		return firstMessageTime;
	}

	public void setFirstMessageTime(String firstMessageTime) {
		this.firstMessageTime = firstMessageTime;
	}

	public String getLastMessageTime() {
		return lastMessageTime;
	}

	public void setLastMessageTime(String lastMessageTime) {
		this.lastMessageTime = lastMessageTime;
	}

	public Double getMeanMessageLen() {
		return meanMessageLen;
	}

	public void setMeanMessageLen(Double meanMessageLen) {
		this.meanMessageLen = meanMessageLen;
	}

	public String getLastMessageContent() {
		return lastMessageContent;
	}

	public void setLastMessageContent(String lastMessageContent) {
		this.lastMessageContent = lastMessageContent;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	
	
}
