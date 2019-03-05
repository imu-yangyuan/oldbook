package rongutils;

import io.rong.RongCloud;
import io.rong.models.TokenReslut;

import java.io.Reader;

public class RongTools {
public static TokenReslut getRongTokenReslut(String userId,String userName,String userPhoto) throws Exception{
	String appKey = "cpj2xarljcrmn";
	String appSecret = "xqalPaMlwFoRG";
	RongCloud rongCloud = RongCloud.getInstance(appKey, appSecret);
	return rongCloud.user.getToken(userId, userName, userPhoto);
}
}
