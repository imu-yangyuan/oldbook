package dao;

import java.util.List;

import bean.Comment;

public interface CommentDao extends BaseDao<Comment> {
public List<Comment> findCommentbybookId(String bookId);
public List<Comment> findCommentbyuserId(String userId);
}
