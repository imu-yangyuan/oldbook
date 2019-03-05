package service;

import java.util.List;

import bean.Book;

public interface BookService extends BaseService<Book> {
	public List<Book> findBookBybookName(String bookName);
}
