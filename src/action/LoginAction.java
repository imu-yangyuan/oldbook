package action;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import model.UserLoginData;
import model.UserModel;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import service.SchoolService;
import service.UserService;
import service.impl.UserServiceImpl;
import util.SpringContext;
import util.getObjectBySpring;
import bean.School;
import bean.User;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
	private String userPhone;
	private String password;
	
	private UserLoginData userLoginData=new UserLoginData();
	@Resource
	private UserService userService;
	@Resource
	private SchoolService schoolService;
	public LoginAction() {
		super();
	}

	public LoginAction(String userPhone, String password) {
		super();
		this.userPhone = userPhone;
		this.password = password;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String execute() throws Exception {
		try {
			if(!ServletActionContext.getRequest().getMethod().equals("POST")){
			   // userLoginData=(UserLoginData)getObjectBySpring.getObject("userLoginData");
				userLoginData.setMsg("请求方式错误！");
				userLoginData.setState(0);
				return "success";
			}
			else if ("".equals(userPhone) || "".equals(password) || userPhone == null
					|| password == null) {
				userLoginData = new UserLoginData();
				userLoginData.setMsg("手机号或密码错误！");
				userLoginData.setState(0);
				return SUCCESS;
			} else if (StringUtils.isNotBlank(userPhone)
					&& StringUtils.isNotBlank(password)) {
				List<User> users = userService.findUsersByPhoneAndPass(
						userPhone, password);
				if (users != null && users.size() > 0) {
					User user = users.get(0);
					//user.setId(user.getId());
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
					userModel.setToken(user.getToken());
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
			userLoginData.setMsg("登录失败！");
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

	public void setUserLoginData(UserLoginData userLoginData) {
		this.userLoginData = userLoginData;
	}
	
}
