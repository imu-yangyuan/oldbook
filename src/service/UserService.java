package service;

import java.util.List;

import model.UserModel;
import bean.User;

public interface UserService extends BaseService<User> {
	public List<User> findUsersByPhoneAndPass(String phone, String password);

	public List<User> findUsersByPhoneAndSecretKey(String phone,
			String secretKey);
	public List<User> findUsersByPhone(String phone);
	public List<UserModel> findUserModelById(String id);
}
