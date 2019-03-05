package service;

import java.util.List;

import bean.Businessrecord;

public interface BusinessrecordService extends BaseService<Businessrecord> {
	public List<Businessrecord> findBusinessrecordbyGetUserId(String getUserid);

	public List<Businessrecord> findBusinessrecordbyGiveUserId(String giveUserid);

	public List<Businessrecord> findBusinessrecordbyBookid(String bookid);
}
