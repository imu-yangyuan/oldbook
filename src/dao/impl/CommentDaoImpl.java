package dao.impl;

import java.util.List;

import org.hibernate.Query;

import bean.Comment;
import dao.CommentDao;

public class CommentDaoImpl extends BaseDaoImpl<Comment>
implements CommentDao  {

	@Override
	public List<Comment> findCommentbybookId(String bookId) {
		// TODO Auto-generated method stub
		Query query = getSession().createQuery(
				"FROM Comment WHERE bookId=?");
		query.setParameter(0, bookId);
		return query.list();
	}

	@Override
	public List<Comment> findCommentbyuserId(String userId) {
		// TODO Auto-generated method stub
		Query query = getSession().createQuery(
				"FROM Comment WHERE userId=?");
		query.setParameter(0, userId);
		return query.list();
	}

	

}
