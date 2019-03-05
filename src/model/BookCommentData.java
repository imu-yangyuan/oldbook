package model;

import java.util.List;

public class BookCommentData {
	private String msg;
    private Integer state;
    private List<CommentModel> commentModels;

    public BookCommentData() {
    }

    public BookCommentData(String msg, Integer state,List<CommentModel> commentModels) {
        this.msg = msg;
        this.state = state;
        this.commentModels = commentModels;
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

    public List<CommentModel> getCommentModels() {
        return commentModels;
    }

    public void setCommentModels(List<CommentModel> commentModels) {
        this.commentModels = commentModels;
    }
}
