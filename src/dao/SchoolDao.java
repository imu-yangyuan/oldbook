package dao;

import java.io.Serializable;
import java.util.List;

import bean.School;

public interface SchoolDao  {
	public School findSchoolById(Serializable id);
	public List<School> findSchoolByName(String name);
}
