package action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;

import service.BookService;
import service.CommentService;
import service.UserService;
import model.CommonReturnData;
import bean.Book;
import bean.Comment;
import bean.User;

import com.opensymphony.xwork2.ActionSupport;
public class AddCommentAction extends ActionSupport {
	private String bookId;
	private String userId;
	private String secretKey;
	private String commentInfo;
	private CommonReturnData commonReturnData=new CommonReturnData();
	@Resource
	private CommentService commentService;
	@Resource
	private UserService userService;
	@Resource
	private BookService bookService;
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		commonReturnData.setMsg("");
		commonReturnData.setState(0);
		try {
			
			if (StringUtils.isNotBlank(bookId)&&StringUtils.isNotBlank(secretKey)&&StringUtils.isNotBlank(userId)&&StringUtils.isNotBlank(commentInfo)) {
				User user=userService.findObjectById(userId);
				Book book= bookService.findObjectById(bookId);
				if (user!=null&&book!=null&secretKey.equals(user.getSecretKey())) {
					Comment comment=new Comment();
					comment.setBookId(bookId);
					comment.setUserId(userId);
					comment.setCommentInfo(commentInfo);
					comment.setCommentTime(System.currentTimeMillis()+"");
					commentService.save(comment);
					commonReturnData.setMsg("评论成功");
					commonReturnData.setState(1);
				} else {
					commonReturnData.setMsg("参数错误");
					commonReturnData.setState(0);
				}
			} else {
				commonReturnData.setMsg("参数错误");
				commonReturnData.setState(0);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return SUCCESS;
	}
	
	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}

	public CommonReturnData getCommonReturnData() {
		return commonReturnData;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public void setCommentInfo(String commentInfo) {
		this.commentInfo = commentInfo;
	}
	
}
