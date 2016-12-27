package com.righthere.user.server.dal.dataobject;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by jiangyayi on 16/8/5.
 */
public class UserCardDO implements Serializable {

        private String id;
        private String merchantAccount;
        private String accountId;
        private String bankId;
        private String bankCardNo;
        private String bankCardName;
        private int identityType;
        private String identityNumber;
        private String mobilePhone;
        private Date bindTime;
        private int status;

    public String getId() {
        return id;
    }

    public String getAccountId() {return accountId;}

    public void setBankCardName(String bankCardName) {
        this.bankCardName = bankCardName;
    }

    public void setBankCardNo(String bankCardNo) {
        this.bankCardNo = bankCardNo;
    }

    public void setBankId(String bankId) {
        this.bankId = bankId;
    }

    public void setBindTime(Date bindTime) {
        this.bindTime = bindTime;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    public void setMerchantAccount(String merchantAccount) {
        this.merchantAccount = merchantAccount;
    }

    public String getMerchantAccount() {
        return merchantAccount;
    }



    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }



    public void setStatus(int status) {
        this.status = status;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public Date getBindTime() {
        return bindTime;
    }

    public String getBankCardName() {
        return bankCardName;
    }

    public String getBankCardNo() {
        return bankCardNo;
    }

    public int getStatus() {
        return status;
    }

    public String getBankId() {
        return bankId;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }



    public String getMobilePhone() {
        return mobilePhone;
    }

    public int getIdentityType() {
        return identityType;
    }

    public void setIdentityType(int identityType) {
        this.identityType = identityType;
    }
}




