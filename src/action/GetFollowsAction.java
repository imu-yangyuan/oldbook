package action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import model.UserRongModel;
import model.UsersData;

import org.apache.commons.lang3.StringUtils;

import service.FollowService;
import service.UserService;
import bean.Follow;
import bean.User;

import com.opensymphony.xwork2.ActionSupport;

public class GetFollowsAction extends ActionSupport {
private String userId;
private UsersData usersData=new UsersData();
@Resource
private FollowService followService;
@Resource 
private UserService userService;
@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
	usersData.setMsg("");
	usersData.setState(0);
	try {
		if (StringUtils.isNotBlank(userId)){
			List<Follow> follows=followService.findFollowbyuserId(userId);
			List<User> users=new ArrayList<User>();
			List<UserRongModel> userRongModels = new ArrayList<UserRongModel>();
			UserRongModel userRongModel;
			for (Follow follow : follows) {
				users.add(userService.findObjectById(follow.getFollowUserId()));
			}
			for (User user : users) {
				userRongModel=new UserRongModel();
				userRongModel.setId(user.getId());
				userRongModel.setToken(user.getToken());
				userRongModel.setUsername(user.getUsername());
				userRongModel.setUserPhotoUrl(user.getUserPhotoUrl());
				userRongModel.setSex(user.getSex());
				userRongModels.add(userRongModel);
			}
			usersData.setMsg("获取关注者成功");
			usersData.setState(1);
			usersData.setUserRongModels(userRongModels);
		}else {
			usersData.setMsg("参数错误");
			usersData.setState(0);
		}
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println(e);
	}
		return SUCCESS;
	}
public UsersData getUsersData() {
	return usersData;
}
public void setUserId(String userId) {
	this.userId = userId;
}

}
