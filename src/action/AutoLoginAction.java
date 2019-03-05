package action;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import model.UserLoginData;
import model.UserModel;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;

import service.SchoolService;
import service.UserService;
import bean.School;
import bean.User;

import com.opensymphony.xwork2.ActionSupport;

public class AutoLoginAction extends ActionSupport {
	private String userId;
	private String secretKey;
	private UserLoginData userLoginData=new UserLoginData();
	@Resource
	private UserService userService;
	@Resource
	private SchoolService schoolService;
	@Override
	public String execute() throws Exception {
		userLoginData.setMsg("");
		userLoginData.setState(0);
		try {
			if(!ServletActionContext.getRequest().getMethod().equals("POST")){
				userLoginData.setMsg("请求方式错误！");
				userLoginData.setState(0);
				return "success";
			}
			else if ("".equals(userId) || "".equals(secretKey) || userId == null
					|| secretKey == null) {
				userLoginData = new UserLoginData();
				userLoginData.setMsg("自动登录失败！");
				userLoginData.setState(0);
				return SUCCESS;
			} else if (StringUtils.isNotBlank(userId)
					&& StringUtils.isNotBlank(secretKey)) {
				User user = userService.findObjectById(userId);
				if (user!= null && secretKey.equals(user.getSecretKey())) {
					user.setIpAddress(getIp());
					user.setSecretKey(getUUID());
					user.setLoginTime(System.currentTimeMillis() + "");
					userService.update(user);
					/*ServletActionContext.getRequest().getSession()
							.setAttribute("user", user);*/
					userLoginData.setMsg("登录成功");
					userLoginData.setState(1);
					UserModel userModel = new UserModel();
					if (!"".equals(user.getUniversity())||user.getUniversity()==null) {
						String id=user.getUniversity();
						School school=schoolService.findSchoolById(id);
						userModel.setUniversityId(id);
						userModel.setUniversity(school.getName());
					}else{
						userModel.setUniversity("未设置学校");
					}
					userModel.setId(user.getId());
					userModel.setSecretKey(user.getSecretKey());
					userModel.setUsername(user.getUsername());
					userModel.setPhone(user.getPhone());
					userModel.setSex(user.getSex());
					userModel.setAddress(user.getAddress());
					userModel.setBirthday(user.getBirthday());
					userModel.setUserPhotoUrl(user.getUserPhotoUrl());
					userLoginData.setUserModel(userModel);
					System.out.println(userModel);
					return SUCCESS;
				}
				else{
					userLoginData = new UserLoginData();
					userLoginData.setMsg("手机号或密码错误！");
					userLoginData.setState(0);
					return SUCCESS;
				}

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			userLoginData.setMsg("自动登录失败！");
			userLoginData.setState(0);
		}
		return SUCCESS;
	}

	private String getIp() {
		return ServletActionContext.getRequest().getRemoteAddr();
	}

	public String getUUID() {
		String uuid = UUID.randomUUID().toString().trim().replaceAll("-", "");
		return uuid;
	}

	public UserLoginData getUserLoginData() {
		return userLoginData;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}

	
}
