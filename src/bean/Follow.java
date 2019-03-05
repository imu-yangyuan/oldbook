package bean;

/**
 * Follow entity. @author MyEclipse Persistence Tools
 */

public class Follow implements java.io.Serializable {

	// Fields

	private String id;
	private String userId;
	private String followUserId;

	// Constructors

	/** default constructor */
	public Follow() {
	}

	/** full constructor */
	public Follow(String userId, String followUserId) {
		this.userId = userId;
		this.followUserId = followUserId;
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

	public String getFollowUserId() {
		return this.followUserId;
	}

	public void setFollowUserId(String followUserId) {
		this.followUserId = followUserId;
	}

}