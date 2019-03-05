package test;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.impl.SchoolDaoImpl;
import service.BookService;
import service.BusinessrecordService;
import service.CommentService;
import service.FollowService;
import service.SchoolService;
import service.UserService;
import test.bean.Person;
import test.service.TestService;
import bean.Book;
import bean.Businessrecord;
import bean.Comment;
import bean.Follow;
import bean.School;
import bean.User;

public class TestMerge {

	ClassPathXmlApplicationContext ctx;

	@Before
	public void loadCtx() {
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	}

	@Test
	public void testSpring() {
		TestService ts = (TestService) ctx.getBean("testService");
		ts.say();
	}

	@Test
	public void testHibernate() {
		SessionFactory sf = (SessionFactory) ctx.getBean("sessionFactory");

		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		// 保存人员
		Person person = new Person();
		person.setName("人员1");
		session.save(person);
		transaction.commit();
		session.close();
	}

	@Test
	public void testServiceAndDao() {
		TestService ts = (TestService) ctx.getBean("testService");
		ts.save(new Person("人员2"));
		// System.out.println(ts.findPerson("4028eea54c8cdb1f014c8cdb20ab0000").getName());
	}

	@Test
	public void testTransationReadOnly() {// 只读事务，如果在只读事务中出现更新操作则回滚
		TestService ts = (TestService) ctx.getBean("testService");
		System.out.println(ts.findPerson("4028b88156b20b2a0156b20b2d640002")
				.getName());
	}

	@Test
	public void testTransationRollback() {// 回滚事务，如果操作中出现有任务异常则回滚先前的操作
		TestService ts = (TestService) ctx.getBean("testService");
		ts.save(new Person("人员4"));
	}

	@Test
	public void testUserService2Dao() {
		// 测试成功
		UserService userService = (UserService) ctx.getBean("userService");
		List<User> users;
		// user = userService.findUsersByPhoneAndPass("12", "12");
		users = userService.findUsersByPhone("15661109712");
		System.out.println(users.get(0).getAddress());

		
	}

	@Test
	public void testBookService2Dao() {
		// 测试成功
		BookService bookService = (BookService) ctx.getBean("bookService");
		/*List<Book> books;
		// books = bookService.findBookBybookName("123");
		
		// System.out.println(books.get(0).getId());
		Book book = bookService.findObjectById("12312");
		System.out.println(book.getBookName());*/
		Book book=new Book();
		book.setBookAboutText("asdfasdfasd");
		book.setBookName("asdfasdf");
		book.setBookPrice(3.12);
		bookService.save(book);

	}
	@Test
	public void testSchoolDao() {
		
		//测试成功
		SchoolDaoImpl schoolDaoImpl= (SchoolDaoImpl) ctx.getBean("schoolDao");
		//School school=schoolDaoImpl.findSchoolById(11);
		//System.out.println(school.getPlace());
		List<School> schools=schoolDaoImpl.findSchoolByName("内蒙古大学");
		System.out.println(schools.get(0).getPlace());

	}
	@Test
	public void testSchoolService2Dao() {
		
		//测试成功
		SchoolService schoolService= (SchoolService) ctx.getBean("schoolService");
		//School school=schoolDaoImpl.findSchoolById(11);
		//System.out.println(school.getPlace());
		List<School> schools=schoolService.findSchoolByName("内蒙古大学");
		System.out.println(schools.get(0).getPlace());
	}

	@Test
	public void testBusinessrecordService2Dao() {
		// 测试成功
		BusinessrecordService businessrecordService = (BusinessrecordService) ctx
				.getBean("businessrecordService");
		List<Businessrecord> businessrecords;
		// Businessrecord businessrecord = businessrecordService
		// .findObjectById("12312");
		// System.out.println(businessrecord);
//		businessrecords = businessrecordService
//				.findBusinessrecordbyGiveUserId("111");
//		businessrecords = businessrecordService
//				.findBusinessrecordbyBookid("111");
		Businessrecord businessrecord = businessrecordService
			.findObjectById("1111");
		//System.out.println(businessrecords.get(0).getBookId());
		System.out.println(businessrecord.getBookId());

	}
	@Test
	public void testCommentService2Dao() {
		// 测试成功
		CommentService commentService = (CommentService) ctx
				.getBean("commentService");
		Comment comment=new Comment();
		comment.setBookId("asdfsdfa");
		comment.setCommentInfo("asdfasdf");
		comment.setUserId("asdfasdf");
		comment.setCommentTime(System.currentTimeMillis()+"");
		commentService.save(comment);
		/*List<Comment> comments = null;
		//comments=commentService.findCommentbybookId("297e0d79578ed1d301578ed23bce0000");
		comments=commentService.findCommentbyuserId("297eba845756ecf0015756eeef030001");
		System.out.println(comments.get(1).getBookId());*/

	}
	@Test
	public void testFollowService2Dao() {
		// 测试成功
		FollowService followService = (FollowService) ctx
				.getBean("followService");
		Follow follow=new Follow();
		follow.setFollowUserId("297eba845756ecf0015756eeef030001");
		follow.setUserId("297ed2495751e61b0157520057210004");
		//followService.save(follow);
		System.out.println(followService.findFollowbyuserIdAndFollowUseriId("297ed2495751e61b0157520057210004", "297eba845756ecf0015756eeef030001").get(0).getFollowUserId());

	}
	
}
