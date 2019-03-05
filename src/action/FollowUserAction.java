package action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;

import service.FollowService;
import service.UserService;
import model.CommonReturnData;
import bean.Book;
import bean.Follow;
import bean.User;

import com.opensymphony.xwork2.ActionSupport;

public class FollowUserAction extends ActionSupport {
private String userId;
private String secretKey;
private String befollowUserId;
private CommonReturnData commonReturnData;
private UserService userService;
@Resource
private FollowService followService;
@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
	commonReturnData.setMsg("");
	commonReturnData.setState(0);
	try {
		if (StringUtils.isNotBlank(userId)&&StringUtils.isNotBlank(secretKey)&&StringUtils.isNotBlank(befollowUserId)) {
			User user=userService.findObjectById(userId);
			List<Follow> follows=followService.findFollowbyuserIdAndFollowUseriId(userId, befollowUserId);
			if (user!=null&&secretKey.equals(user.getSecretKey())){
				if (follows!=null&&follows.size()>0) {
					commonReturnData.setMsg("已关注过");
					commonReturnData.setState(0);
				}else {
					Follow follow=new Follow();
					follow.setFollowUserId(befollowUserId);
					follow.setUserId(userId);
					followService.save(follow);
					commonReturnData.setMsg("关注成功");
					commonReturnData.setState(1);
				}
			}else{
				commonReturnData.setMsg("参数错误");
				commonReturnData.setState(0);
			}
		}else{
			commonReturnData.setMsg("参数错误");
			commonReturnData.setState(0);
		}
		
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println(e);
		return SUCCESS;
	}
		return SUCCESS;
	}
public CommonReturnData getCommonReturnData() {
	return commonReturnData;
}
public void setUserId(String userId) {
	this.userId = userId;
}
public void setSecretKey(String secretKey) {
	this.secretKey = secretKey;
}
public void setBefollowUserId(String befollowUserId) {
	this.befollowUserId = befollowUserId;
}

}
