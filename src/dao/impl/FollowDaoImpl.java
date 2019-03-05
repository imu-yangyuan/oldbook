package dao.impl;

import java.util.List;

import org.hibernate.Query;

import bean.Follow;
import bean.School;
import dao.FollowDao;

public class FollowDaoImpl extends BaseDaoImpl<Follow>
implements FollowDao {

	@Override
	public List<Follow> findFollowbyuserId(String userId) {
		// TODO Auto-generated method stub
		Query query = getSession().createQuery(
				"FROM Follow WHERE userId=?");
		query.setParameter(0, userId);
		return query.list();
	}

	@Override
	public List<Follow> findFollowbyuserIdAndFollowUseriId(String userId,
			String followUserId) {
		// TODO Auto-generated method stub
		Query query = getSession().createQuery(
				"FROM Follow WHERE userId=? and followUserId=?");
		query.setParameter(0, userId);
		query.setParameter(1, followUserId);
		return query.list();
	}

	
}
