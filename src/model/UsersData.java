package model;

import java.util.List;

public class UsersData {
	private String msg;
	private Integer state;
	private List<UserRongModel> userRongModels;
	
	public UsersData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UsersData(String msg, Integer state,
			List<UserRongModel> userRongModels) {
		super();
		this.msg = msg;
		this.state = state;
		this.userRongModels = userRongModels;
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
	public List<UserRongModel> getUserRongModels() {
		return userRongModels;
	}
	public void setUserRongModels(List<UserRongModel> userRongModels) {
		this.userRongModels = userRongModels;
	}
	
}
