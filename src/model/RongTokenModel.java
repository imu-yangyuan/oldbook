package model;

public class RongTokenModel {
	private String code;
	private String token;
	private String userId;
	public RongTokenModel() {
	}
	public RongTokenModel(String code, String token, String userId) {
		super();
		this.code = code;
		this.token = token;
		this.userId = userId;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
}
