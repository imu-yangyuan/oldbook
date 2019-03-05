package service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import dao.CommentDao;
import service.CommentService;
import bean.Comment;
@Service("commentService")
public class CommentServiceImpl extends BaseServiceImpl<Comment>
implements CommentService{
	private CommentDao commentDao;
	@Resource
	public void setCommentDao(CommentDao commentDao) {
		super.setBaseDao(commentDao);
		this.commentDao = commentDao;
	}
	@Override
	public List<Comment> findCommentbybookId(String bookId) {
		// TODO Auto-generated method stub
		return commentDao.findCommentbybookId(bookId);
	}
	@Override
	public List<Comment> findCommentbyuserId(String userId) {
		// TODO Auto-generated method stub
		return commentDao.findCommentbyuserId(userId);
	}
	
	
}
