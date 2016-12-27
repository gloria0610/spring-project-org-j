package com.righthere.user.server.dal.dao;

import com.righthere.user.server.dal.model.basic.UserBasic;

import java.util.Date;
import java.util.List;

/**
 * 用户基础信Dao
 * 
 * @author bing.dong
 * @since 1.0.0
 */
public interface IUserBasicDao {
	
	/**
	 * 根据手机号查询用户基础信息
	 * 
	 * @author bing.dong
	 * 
	 * @param telephone
	 * @return
	 */
	UserBasic getUserBasicByTelephone(String telephone);
	
	/**
	 * 根据用户Id查询用户基础信息
	 * 
	 * @author YangDongzhen
	 * 
	 * @param userId
	 * @return UserBasic
	 */
	public UserBasic getUserBasicByUserId(String userId);
	
	/**
	 * 根据账户Id查询用户基础信息
	 * 
	 * @author YangDongzhen
	 * 
	 * @param accountId
	 * @return UserBasic
	 */
	public UserBasic getUserBasicByAccountId(String accountId);
	
	/**
	 * 根据用户编码查询用户基础信息
	 * 
	 * @author YangDongzhen
	 * 
	 * @param userCode
	 * @return UserBasic
	 */
	public UserBasic getUserBasicByUserCode(String userCode);
	
	/**
	 * 根据用户邀请码询用户基础信息
	 * 
	 * @author YangDongzhen
	 * 
	 * @param inviteCode
	 * @return UserBasic
	 */
	public UserBasic getUserBasicByInviteCode(String inviteCode);
	
	/**
	 * 根据多个userid查询注册信息
	 * 
	 * @author YangDongzhen
	 * 
	 * @param userIdList
	 * @return List<UserRegist>
	 */
	List<UserBasic> getUserListByUserIds(List<String> userIdList);
	
	/**
	 * 分页查询注册信息
	 * 
	 * @author YangDongzhen
	 * 
	 * @param start
	 * @param size
	 * @param beginTime
	 * @param endTime
	 * @return List<UserRegist>
	 */
	List<UserBasic> getUserList(Integer start, Integer size, Date beginTime, Date endTime);
	
	/**
	 * 查询注册用户数
	 * 
	 * @author YangDongzhen
	 * 
	 * @param beginTime
	 * @param endTime
	 * @return Long
	 */
	Long getUserCount(Date beginTime, Date endTime);
	
	/**
	 * 更新用户状态
	 * 
	 * @param userId
	 * @param status
	 * @return
	 */
	boolean updateUserStatus(String userId, Integer status);
}
