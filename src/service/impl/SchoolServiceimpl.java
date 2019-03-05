package service.impl;

import java.io.Serializable;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import dao.SchoolDao;
import service.SchoolService;
import bean.School;

@Service("schoolService")
public class SchoolServiceimpl  implements
SchoolService {
	private SchoolDao schoolDao;
	@Resource
	public void setSchoolDao(SchoolDao schoolDao) {
		this.schoolDao = schoolDao;
	}

	@Override
	public School findSchoolById(Serializable id) {
		// TODO Auto-generated method stub
		return schoolDao.findSchoolById(id);
	}

	@Override
	public List<School> findSchoolByName(String name) {
		// TODO Auto-generated method stub
		return schoolDao.findSchoolByName(name);
	}

}
