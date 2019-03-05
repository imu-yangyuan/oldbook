package bean;

/**
 * Comment entity. @author MyEclipse Persistence Tools
 */

public class Comment implements java.io.Serializable {

	// Fields

	private String id;
	private String userId;
	private String commentInfo;
	private String bookId;
	private String commentTime;

	// Constructors

	/** default constructor */
	public Comment() {
	}

	/** full constructor */
	public Comment(String userId, String commentInfo, String bookId,
			String commentTime) {
		this.userId = userId;
		this.commentInfo = commentInfo;
		this.bookId = bookId;
		this.commentTime = commentTime;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCommentInfo() {
		return this.commentInfo;
	}

	public void setCommentInfo(String commentInfo) {
		this.commentInfo = commentInfo;
	}

	public String getBookId() {
		return this.bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getCommentTime() {
		return this.commentTime;
	}

	public void setCommentTime(String commentTime) {
		this.commentTime = commentTime;
	}

}