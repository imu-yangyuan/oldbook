package dao.impl;

import java.util.List;

import org.hibernate.Query;

import bean.Businessrecord;
import dao.BusinessrecordDao;

public class BusinessrecordDaoImpl extends BaseDaoImpl<Businessrecord>
		implements BusinessrecordDao {

	@Override
	public List<Businessrecord> findBusinessrecordbyGetUserId(String getUserid) {
		// TODO Auto-generated method stub
		Query query = getSession()
				.createQuery(
						"FROM Businessrecord WHERE getUserId=?");
		query.setParameter(0, getUserid);
		return query.list();
	}

	@Override
	public List<Businessrecord> findBusinessrecordbyGiveUserId(String giveUserid) {
		// TODO Auto-generated method stub
		Query query = getSession().createQuery(
				"FROM Businessrecord WHERE giveUserId=?");
		query.setParameter(0, giveUserid);
		return query.list();
	}

	@Override
	public List<Businessrecord> findBusinessrecordbyBookid(String bookid) {
		// TODO Auto-generated method stub
		Query query = getSession().createQuery(
				"FROM Businessrecord WHERE bookId=?");
		query.setParameter(0, bookid);
		return query.list();
	}

}
