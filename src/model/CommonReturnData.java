package model;

public class CommonReturnData {
	private String msg;
	private Integer state;

	public CommonReturnData(String msg, Integer state) {
		super();
		this.msg = msg;
		this.state = state;
	}

	public CommonReturnData() {
		super();
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

}
