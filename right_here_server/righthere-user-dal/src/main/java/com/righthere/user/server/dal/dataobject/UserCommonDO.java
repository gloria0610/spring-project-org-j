package com.righthere.user.server.dal.dataobject;

/**
 * Created by jiangyayi on 16/8/28.
 */
public class UserCommonDO {

    private String telephone;
    private String authCode;

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAuthCode() {
        return authCode;
    }

    public String getTelephone() {
        return telephone;
    }
}
