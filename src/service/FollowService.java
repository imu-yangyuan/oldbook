package service;

import java.util.List;

import bean.Follow;



public interface FollowService extends BaseService<Follow> {
	public List<Follow> findFollowbyuserId(String userId) ;
	public List<Follow> findFollowbyuserIdAndFollowUseriId(String userId,String followUserId) ;
}
