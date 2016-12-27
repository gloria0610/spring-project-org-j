package com.righthere.user.server.dal.dataobject;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by jiangyayi on 16/8/5.
 */
public class UserInfoDO implements Serializable

    {
        private String userId;
        private String accountId;
        private String telephone;
        private Date registTime;
        private Date firstLoginTime;
        private String userCode;
        private String inviteCode;
        private Integer checkOpenAccount;
        private Integer status;


        public void setUserId(String userId) {
        this.userId = userId;
        }

        public void setAccountId(String accountId) {
            this.accountId = accountId;
        }

        public void setCheckOpenAccount(Integer checkOpenAccount) {
            this.checkOpenAccount = checkOpenAccount;
        }

        public void setFirstLoginTime(Date firstLoginTime) {
            this.firstLoginTime = firstLoginTime;
        }

        public void setInviteCode(String inviteCode) {
            this.inviteCode = inviteCode;
        }

        public void setRegistTime(Date registTime) {
            this.registTime = registTime;
        }

        public void setStatus(Integer status) {
            this.status = status;
        }

        public void setTelephone(String telephone) {
            this.telephone = telephone;
        }

        public void setUserCode(String userCode) {
            this.userCode = userCode;
        }

        public Date getFirstLoginTime() {
            return firstLoginTime;
        }

        public Date getRegistTime() {
            return registTime;
        }

        public Integer getCheckOpenAccount() {
            return checkOpenAccount;
        }

        public Integer getStatus() {
            return status;
        }

        public String getAccountId() {
            return accountId;
        }

        public String getInviteCode() {
            return inviteCode;
        }

        public String getTelephone() {
            return telephone;
        }

        public String getUserCode() {
            return userCode;
        }

        public String getUserId() {
            return userId;
        }
    }


