package model;

import java.util.List;

public class BookReturnData {
	private String msg;
	private Integer state;
	private List<BookModel> bookModels;
	
	public BookReturnData() {
	}
	public BookReturnData(String msg, Integer state, List<BookModel> bookModels) {
		super();
		this.msg = msg;
		this.state = state;
		this.bookModels = bookModels;
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
	public List<BookModel> getBookModels() {
		return bookModels;
	}
	public void setBookModels(List<BookModel> bookModels) {
		this.bookModels = bookModels;
	}
	
}
