package model;

public class UserLoginData {
	private String msg;
	private Integer state;
	private UserModel userModel;

	public UserLoginData() {
		super();
	}

	public UserLoginData(String msg, Integer state, UserModel userModel) {
		super();
		this.msg = msg;
		this.state = state;
		this.userModel = userModel;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public UserModel getUserModel() {
		return userModel;
	}

	public void setUserModel(UserModel userModel) {
		this.userModel = userModel;
	}

}
