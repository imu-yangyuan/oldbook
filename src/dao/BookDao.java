package dao;

import java.util.List;

import bean.Book;

public interface BookDao extends BaseDao<Book> {
	public List<Book> findBookBybookName(String bookName);
}
