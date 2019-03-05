package service.impl;

import java.util.List;

import javax.annotation.Resource;

import model.UserModel;

import org.springframework.stereotype.Service;

import service.UserService;
import bean.User;
import dao.UserDao;

@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements
		UserService {
	private UserDao userDao;

	@Resource
	public void setUserDao(UserDao userDao) {
		super.setBaseDao(userDao);
		this.userDao = userDao;
	}

	@Override
	public List<User> findUsersByPhoneAndPass(String phone, String password) {
		return userDao.findUsersByPhoneAndPass(phone, password);
	}

	@Override
	public List<User> findUsersByPhoneAndSecretKey(String phone,
			String secretKey) {
		// TODO Auto-generated method stub
		return userDao.findUsersByPhoneAndSecretKey(phone, secretKey);
	}

	@Override
	public List<User> findUsersByPhone(String phone) {
		// TODO Auto-generated method stub
		return userDao.findUsersByPhone(phone);
	}

	@Override
	public List<UserModel> findUserModelById(String id) {
		// TODO Auto-generated method stub
		return userDao.findUserModelById(id);
	}

}
