package action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;

import service.UserService;
import util.MD5;
import model.CommonReturnData;
import model.UserLoginData;
import bean.User;

import com.mysql.jdbc.jdbc2.optional.SuspendableXAConnection;
import com.opensymphony.xwork2.ActionSupport;

public class ModifyPassword extends ActionSupport {
	private String password;
	private String userPhone;
	private String checkCode;
	private CommonReturnData commonReturnData=new CommonReturnData();
	@Resource
	private UserService userService;
@Override
public String execute() throws Exception {
	// TODO Auto-generated method stub
	if(ServletActionContext.getRequest().getMethod().equals("GET")){
		   // userLoginData=(UserLoginData)getObjectBySpring.getObject("userLoginData");
		commonReturnData.setMsg("请求方式错误！");
		commonReturnData.setState(0);
			return SUCCESS;
		}
	else if (StringUtils.isNotBlank(userPhone)
			&& StringUtils.isNotBlank(password)
			&& StringUtils.isNotBlank(checkCode)){
		List<User> users = userService.findUsersByPhone(userPhone);
		if (users == null && users.size() == 0){
			commonReturnData.setMsg("手机号手机号不存在！");
			commonReturnData.setState(0);
			return SUCCESS;
		}else if(users.get(0).getCheckCode().isEmpty()||"".equals(users.get(0).getCheckCode())){
			
			commonReturnData.setMsg("验证码错误！");
			commonReturnData.setState(0);
				return SUCCESS;
		}else if(checkCode.equals(users.get(0).getCheckCode())){
			User user=users.get(0);
			MD5  md5=new MD5();
			user.setPassword(md5.encryptPassword(password));
			user.setPassword(password);
			user.setCheckCode("");
			userService.update(user);
			commonReturnData.setMsg("修改密码成功");
			commonReturnData.setState(1);
			/*ServletActionContext.getRequest().getSession()
			.setAttribute("ModifyPasswordModel", users.get(0));*/
				return SUCCESS;
		}
		else {
			commonReturnData.setMsg("验证码错误！");
			commonReturnData.setState(0);
			return SUCCESS;
		}
		}
	return super.execute();
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getUserPhone() {
	return userPhone;
}
public void setUserPhone(String userPhone) {
	this.userPhone = userPhone;
}

public CommonReturnData getCommonReturnData() {
	return commonReturnData;
}
public void setCommonReturnData(CommonReturnData commonReturnData) {
	this.commonReturnData = commonReturnData;
}
public String getCheckCode() {
	return checkCode;
}
public void setCheckCode(String checkCode) {
	this.checkCode = checkCode;
}


}
