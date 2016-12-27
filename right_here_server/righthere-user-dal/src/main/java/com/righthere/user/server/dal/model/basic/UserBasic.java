package com.righthere.user.server.dal.model.basic;

import com.gbanker.base.dal.annotation.Column;
import com.gbanker.base.dal.annotation.Entity;
import com.gbanker.base.dal.annotation.Id;
import com.gbanker.base.dal.model.IBaseHandlerModel;
import com.gbanker.base.dal.model.IBaseQueryModel;

import java.util.Date;

/**
 * 用户基础信息
 * 
 * @author bing.dong
 * @since 1.0.0
 */
@Entity(name = "user_basic")
public class UserBasic {
	
	/**
	 * serialId
	 */
	private static final long serialVersionUID = -7063964402171396518L;
	
	/**
	 * 账号正常
	 */
	public static final Integer STATUS_NORMAL = 1;
	/**
	 * 账号锁定
	 */
	public static final Integer STATUS_LOCK = 2;
	
	/**
	 * 已经校验 
	 */
	public static final Integer ACCOUNT_CHECKED = 1;
	
	/**
	 * 未校验
	 */
	public static final Integer ACCOUNT_UNCHECK = 0;
	
	// id
	private String id;
	
	// 账户Id
	private String accountId;
	
	// 手机号
	private String telephone;
	
	// 注册时间
	private Date registTime;
	
	// 首次登陆时间
	private Date firstLoginTime;
	
	// 用户识别码
	private String userCode;
	
	// 用户邀请码
	private String inviteCode;
	
	// 账户开设校验
	private int checkOpenAccount;
	
	// 状态
	private Integer status;
	

	@Id
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	@Column(name = "account_id")
	public String getAccountId() {
		return accountId;
	}
	
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	
	@Column(name = "telephone")
	public String getTelephone() {
		return telephone;
	}
	
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	@Column(name = "regist_time")
	public Date getRegistTime() {
		return registTime;
	}
	
	public void setRegistTime(Date registTime) {
		this.registTime = registTime;
	}
	
	@Column(name = "first_login_time")
	public Date getFirstLoginTime() {
		return firstLoginTime;
	}
	
	public void setFirstLoginTime(Date firstLoginTime) {
		this.firstLoginTime = firstLoginTime;
	}
	
	@Column(name = "user_code")
	public String getUserCode() {
		return userCode;
	}
	
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	
	@Column(name = "invite_code")
	public String getInviteCode() {
		return inviteCode;
	}
	
	public void setInviteCode(String inviteCode) {
		this.inviteCode = inviteCode;
	}
	
	@Column(name = "check_open_account")
	public int getCheckOpenAccount() {
		return checkOpenAccount;
	}

	public void setCheckOpenAccount(int checkOpenAccount) {
		this.checkOpenAccount = checkOpenAccount;
	}

	@Column(name = "status")
	public Integer getStatus() {
		return status;
	}
	
	public void setStatus(Integer status) {
		this.status = status;
	}
}
