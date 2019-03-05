package bean;

/**
 * Businessrecord entity. @author MyEclipse Persistence Tools
 */

public class Businessrecord implements java.io.Serializable {

	// Fields

	private String id;
	private String bookId;
	private String giveUserId;
	private String getUserId;
	private String time;

	// Constructors

	/** default constructor */
	public Businessrecord() {
	}

	/** full constructor */
	public Businessrecord(String bookId, String giveUserId, String getUserId,
			String time) {
		this.bookId = bookId;
		this.giveUserId = giveUserId;
		this.getUserId = getUserId;
		this.time = time;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBookId() {
		return this.bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getGiveUserId() {
		return this.giveUserId;
	}

	public void setGiveUserId(String giveUserId) {
		this.giveUserId = giveUserId;
	}

	public String getGetUserId() {
		return this.getUserId;
	}

	public void setGetUserId(String getUserId) {
		this.getUserId = getUserId;
	}

	public String getTime() {
		return this.time;
	}

	public void setTime(String time) {
		this.time = time;
	}

}