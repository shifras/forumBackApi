package lt.ignitis.chatAppBack.exceptions;

public class UserException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer code;
	private String description;

	

	public UserException(String message, Integer code) {
		super(message);
		this.code = code;
	}
	
	public UserException(String message, String Description, Integer code) {
		super(message);
		this.code = code;
		this.description = description;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	

}
