package service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import service.BookService;
import bean.Book;
import dao.BookDao;

@Service("bookService")
public class BookServiceImpl extends BaseServiceImpl<Book> implements
		BookService {
	private BookDao bookDao;

	@Resource
	public void setBookDao(BookDao bookDao) {
		super.setBaseDao(bookDao);
		this.bookDao = bookDao;
	}

	@Override
	public List<Book> findBookBybookName(String bookName) {
		// TODO Auto-generated method stub
		return bookDao.findBookBybookName(bookName);
	}

}
