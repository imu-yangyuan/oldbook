package model;

public class CommentModel {
	private String userId;
	private String commentInfo;
	private String userSex;
	private String userName;
	private String userPhoto;
	private String commentTime;
	
	public CommentModel() {
	}

	public CommentModel(String userId, String commentInfo, String userSex, String userName, String userPhoto, String commentTime) {
		this.userId = userId;
		this.commentInfo = commentInfo;
		this.userSex = userSex;
		this.userName = userName;
		this.userPhoto = userPhoto;
		this.commentTime = commentTime;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCommentInfo() {
		return commentInfo;
	}

	public void setCommentInfo(String commentInfo) {
		this.commentInfo = commentInfo;
	}

	public String getUserSex() {
		return userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPhoto() {
		return userPhoto;
	}

	public void setUserPhoto(String userPhoto) {
		this.userPhoto = userPhoto;
	}

	public String getCommentTime() {
		return commentTime;
	}

	public void setCommentTime(String commentTime) {
		this.commentTime = commentTime;
	}
	
}
