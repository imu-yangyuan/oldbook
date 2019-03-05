package dao.impl;

import java.util.List;

import org.hibernate.Query;

import bean.Book;
import dao.BookDao;

public class BookDaoImpl extends BaseDaoImpl<Book> implements BookDao {

	@Override
	public List<Book> findBookBybookName(String bookName) {
		// TODO Auto-generated method stub
		Query query = getSession().createQuery("FROM Book WHERE bookName=?");
		query.setParameter(0, bookName);
		return query.list();
	}

}
