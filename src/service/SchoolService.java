package service;

import java.io.Serializable;
import java.util.List;

import bean.School;

public interface SchoolService {
	public School findSchoolById(Serializable id) ;
	public List<School> findSchoolByName(String name);
}
