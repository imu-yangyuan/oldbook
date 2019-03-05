package service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import service.BusinessrecordService;
import bean.Businessrecord;
import dao.BusinessrecordDao;

@Service("businessrecordService")
public class BusinessrecordServiceImpl extends BaseServiceImpl<Businessrecord>
		implements BusinessrecordService {

	private BusinessrecordDao businessrecordDao;

	@Resource
	public void setBusinessrecordDao(BusinessrecordDao businessrecordDao) {
		super.setBaseDao(businessrecordDao);
		this.businessrecordDao = businessrecordDao;
	}

	@Override
	public List<Businessrecord> findBusinessrecordbyGetUserId(String getUserid) {
		// TODO Auto-generated method stub
		return businessrecordDao.findBusinessrecordbyGetUserId(getUserid);
	}

	@Override
	public List<Businessrecord> findBusinessrecordbyGiveUserId(String giveUserid) {
		// TODO Auto-generated method stub
		return businessrecordDao.findBusinessrecordbyGiveUserId(giveUserid);
	}

	@Override
	public List<Businessrecord> findBusinessrecordbyBookid(String bookid) {
		// TODO Auto-generated method stub
		return businessrecordDao.findBusinessrecordbyBookid(bookid);
	}

}
