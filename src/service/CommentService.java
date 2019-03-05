package service;

import java.util.List;

import bean.Comment;

public interface CommentService extends BaseService<Comment> {
	public List<Comment> findCommentbybookId(String bookId);
	public List<Comment> findCommentbyuserId(String userId);
}
