package action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import model.BookModel;
import model.BookReturnData;

import org.apache.commons.lang3.StringUtils;

import page.PageResult;
import service.BookService;
import service.UserService;
import util.QueryHelper;
import bean.Book;
import bean.User;

import com.opensymphony.xwork2.ActionSupport;

public class OldbookAction extends ActionSupport {
	private String universityId;
	private String page;
	private BookReturnData bookReturnData=new BookReturnData();
	
	@Resource
	private BookService bookService;
	@Resource
	private UserService userService;
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		bookReturnData.setMsg("");
		bookReturnData.setState(0);
		if(StringUtils.isNotBlank(universityId)&&StringUtils.isNotBlank(page)){
			QueryHelper queryHelper=new QueryHelper(Book.class, "b");
			queryHelper.addCondition("b.universityId=?", Integer.valueOf(universityId));
			queryHelper.addCondition("b.state=?", 0);
			queryHelper.addCondition("b.bookPrice!=?", 0.0);
			queryHelper.addOrderByProperty("b.addTime", QueryHelper.ORDER_BY_ASC);
			PageResult pageResult=bookService.getPageResult(queryHelper, Integer.parseInt(page), 10);
			if(pageResult.getItems().size()!=0){
				Book book;
				User user;
				BookModel bookModel;
				List<Book> books=pageResult.getItems();
				List<User> users = new ArrayList<User>();
				List<User> usersForModel = new ArrayList<User>();
				List<BookModel> bookModels=new ArrayList<BookModel>();
				Iterator<Book> iterator=books.iterator();
				while(iterator.hasNext()){
					user=new User();
					user.setId(iterator.next().getUserid());
					users.add(user);
					
				}
				for (int i = 0; i < users.size(); i++) {
					usersForModel.add(userService.findObjectById(users.get(i).getId()));
				}
				for (int i = 0; i < books.size(); i++) {
					book=books.get(i);
					user=usersForModel.get(i);
					bookModel=new BookModel();
					bookModel.setBookId(book.getId());
					bookModel.setUserId(user.getId());
					bookModel.setUserName(user.getUsername());
					bookModel.setBookName(book.getBookName());
					bookModel.setBookPhotoUrl(book.getBookPhotoUrl());
					bookModel.setUserPhotoUrl(user.getUserPhotoUrl());
					bookModel.setBookAboutText(book.getBookAboutText());
					bookModel.setBookPrice(book.getBookPrice());
					bookModel.setAddTime(book.getAddTime());
					bookModel.setUserSex(user.getSex());
					bookModel.setState(book.getState());
					bookModels.add(bookModel);
				}
				bookReturnData.setBookModels(bookModels);
				bookReturnData.setMsg("获取书籍数据成功");
				bookReturnData.setState(1);
				System.out.println(pageResult.getItems().size());
			}else {
				bookReturnData.setMsg("书籍数据已经获取完了");
				bookReturnData.setState(0);
			}
				
		}
		return SUCCESS;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public String getUniversityId() {
		return universityId;
	}

	public void setUniversityId(String universityId) {
		this.universityId = universityId;
	}
	public BookReturnData getBookReturnData() {
		return bookReturnData;
	}

}
