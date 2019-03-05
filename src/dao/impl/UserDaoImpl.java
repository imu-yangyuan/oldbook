package dao.impl;

import java.util.List;

import model.UserModel;

import org.hibernate.Query;

import bean.User;
import dao.UserDao;

public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

	/*
	 * @Override public List<User> findUserByAccountAndId(String id, String
	 * account) { String hql = "FROM User WHERE phone = ?"; if
	 * (StringUtils.isNotBlank(id)) { hql += " AND id!=?"; } Query query =
	 * getSession().createQuery(hql); query.setParameter(0, account); if
	 * (StringUtils.isNotBlank(id)) { query.setParameter(1, id); }
	 * 
	 * return query.list(); }
	 */
	@Override
	public List<User> findUsersByPhoneAndPass(String phone, String password) {
		Query query = getSession().createQuery(
				"FROM User WHERE phone=? AND password=?");
		query.setParameter(0, phone);
		query.setParameter(1, password);
		return query.list();
	}

	@Override
	public List<User> findUsersByPhoneAndSecretKey(String phone,
			String secretKey) {
		Query query = getSession().createQuery(
				"FROM User WHERE phone=? AND secretKey=?");
		query.setParameter(0, phone);
		query.setParameter(1, secretKey);
		return query.list();
	}

	@Override
	public List<User> findUsersByPhone(String phone) {
		// TODO Auto-generated method stub
		Query query = getSession().createQuery(
				"FROM User WHERE phone=?");
		query.setParameter(0, phone);
		return query.list();
	}

	@Override
	public List<UserModel> findUserModelById(String id) {
		// TODO Auto-generated method stub
		//Query query = getSession().createQuery(
			//	"select U.id,U.secretKey,U.username,U.phone,U.address,U.birthday，S.name,U.userPhotoUrl,U.token,U.sex form User as U,School as S where U.university=S.id and U.id=?");
//		Query query = getSession().createQuery(
//				"SELECT U.id,S.name FROM User as U,School as S WHERE  U.id=S.id");
//		//query.setParameter(0,id );
//		List list=query.list();
//		if(list!=null&&list.size()>0){
//			List<UserModel> userModeList=new LinkedList<UserModel>();
//			UserModel userModel;
//			for (int i = 0; i < list.size(); i++) {
//				userModel=new UserModel();
//				Object[] objects=(Object[])list.get(i);
//				userModel.setId((String)objects[0]);
//				/*userModel.setSecretKey((String)objects[1]);
//				userModel.setUsername((String)objects[2]);
//				userModel.setPhone((String)objects[3]);
//				userModel.setAddress((String)objects[4]);
//				userModel.setBirthday((String)objects[5]);*/
//				userModel.setUniversity((String)objects[1]);
//				/*userModel.setUserPhotoUrl((String)objects[7]);
//				userModel.setToken((String)objects[8]);
//				userModel.setSex((String)objects[9]);
//				userModeList.add(userModel);*/
//			}
//			return userModeList;
//		}
		return null;
	}
	
}
