package dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import bean.School;
import dao.SchoolDao;

public class SchoolDaoImpl extends HibernateDaoSupport implements SchoolDao {

	@Override
	public School findSchoolById(Serializable id) {
		// TODO Auto-generated method stub
		try {
			//School school = (School) getSession().get("bean.School", id);
			School school =getHibernateTemplate().get(School.class, Integer.parseInt((String) id));
			return school;
		} catch (RuntimeException re) {
			throw re;
		}
	}

	@Override
	public List<School> findSchoolByName(String name) {
		// TODO Auto-generated method stub
		Query query = getSession().createQuery(
				"FROM School WHERE name=?");
		query.setParameter(0, name);
		return query.list();
	}

	
	

}
