package action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;

import service.CommentService;
import service.UserService;
import model.BookCommentData;
import model.CommentModel;
import bean.Comment;
import bean.User;

import com.opensymphony.xwork2.ActionSupport;

public class GetCommentAction extends ActionSupport {
private String bookId;
private BookCommentData bookCommentData=new BookCommentData();
@Resource
private UserService userService;
@Resource
private CommentService commentService;
@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		bookCommentData.setMsg("");
		bookCommentData.setState(0);
		try {
			if(StringUtils.isNotBlank(bookId)){
				List<Comment> comments=commentService.findCommentbybookId(bookId);
				if(comments!=null&&comments.size()>0){
					Comment comment;
					User user;
					CommentModel commentModel;
					List<User> users = new ArrayList<User>();
					List<User> usersForModel = new ArrayList<User>();
					List<CommentModel> commentModels=new ArrayList<CommentModel>();
					Iterator<Comment> iterator=comments.iterator();
					while(iterator.hasNext()){
						user=new User();
						user.setId(iterator.next().getUserId());
						users.add(user);
						
					}
					for (int i = 0; i < users.size(); i++) {
						usersForModel.add(userService.findObjectById(users.get(i).getId()));
					}
					for (int i = 0; i < comments.size(); i++) {
						comment=comments.get(i);
						user=usersForModel.get(i);
						commentModel=new CommentModel();
						commentModel.setUserId(user.getId());
						commentModel.setCommentInfo(comment.getCommentInfo());
						commentModel.setUserSex(user.getSex());
						commentModel.setUserName(user.getUsername());
						commentModel.setUserPhoto(user.getUserPhotoUrl());
						commentModel.setCommentTime(comment.getCommentTime());
						commentModels.add(commentModel);
					}
					bookCommentData.setCommentModels(commentModels);
					bookCommentData.setMsg("获取成功！");
					bookCommentData.setState(1);
				}else {
					bookCommentData.setMsg("暂时没有评论");
					bookCommentData.setState(1);
				}
			}else {
				bookCommentData.setMsg("请求错误");
				bookCommentData.setState(0);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			bookCommentData.setMsg("请求错误");
			bookCommentData.setState(0);
			e.printStackTrace();
		}
		return SUCCESS;
	}
public void setBookId(String bookId) {
	this.bookId = bookId;
}
public BookCommentData getBookCommentData() {
	return bookCommentData;
}

}
