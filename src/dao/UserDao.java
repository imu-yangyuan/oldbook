package dao;

import java.util.List;

import model.UserModel;
import bean.User;

public interface UserDao extends BaseDao<User> {

	/**
	 * 根据帐号和用户id查询用户
	 * 
	 * @param id
	 *            用户ID
	 * @return 用户列表
	 */

	// 根据用户的帐号和密码查询用户列表
	public List<User> findUsersByPhoneAndPass(String phone, String password);

	public List<User> findUsersByPhoneAndSecretKey(String phone,
			String secretKey);
	public List<User> findUsersByPhone(String phone);
	public List<UserModel> findUserModelById(String id);
}
