package service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import dao.CommentDao;
import dao.FollowDao;
import service.FollowService;
import bean.Follow;
@Service("followService")
public class FollowServiceImpl extends BaseServiceImpl<Follow>
implements FollowService {
	private FollowDao followDao;
	@Resource
	public void setFollowDao(FollowDao followDao ) {
		super.setBaseDao(followDao);
		this.followDao = followDao;
	}
	@Override
	public List<Follow> findFollowbyuserId(String userId) {
		// TODO Auto-generated method stub
		return followDao.findFollowbyuserId(userId);
	}
	@Override
	public List<Follow> findFollowbyuserIdAndFollowUseriId(String userId,
			String followUserId) {
		// TODO Auto-generated method stub
		return followDao.findFollowbyuserIdAndFollowUseriId(userId, followUserId);
	}
}
