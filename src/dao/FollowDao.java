package dao;

import java.util.List;

import bean.Follow;

public interface FollowDao extends BaseDao<Follow> {
public List<Follow> findFollowbyuserId(String userId) ;
public List<Follow> findFollowbyuserIdAndFollowUseriId(String userId,String followUserId) ;
}
