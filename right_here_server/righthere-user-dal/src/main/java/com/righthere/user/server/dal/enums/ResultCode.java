package com.righthere.user.server.dal.enums;

/**
 * Created by jiangyayi on 16/8/8.
 */


public enum ResultCode {
    SUCCESS (0, "success"),
    /**
     * 1~1000
     */
    ERROR_PARAMETERS_IS_INVALID(1,"parameters is invalid or value is over length"),
    ERROR_UID32_IS_INVALID (2,"uid32 is invalid "),
    ERROR_EMAIL_IS_INVALID (3,"email is invalid"),
    ERROR_NICK_IS_INVALID (4,"nick is invalid"),
    ERROR_USERID_IS_INVALID (5,"userId is invalid"),
    ERROR_UID32_ARRAY_IS_INVALID(6,"uid32s is invalid"),
    ERROR_USERID_ARRAY_IS_INVALID (7,"userIds is invalid"),
    ERROR_MOBILE_IS_INVALID (8,"mobile is invalid"),
    ERROR_TYPE_IS_INVALID (9,"type is invalid"),
    ERROR_USERTAG_IS_INVALID (10,"userTag is invalid");



    private int code;

    private String msg;

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    @Override
    public String toString() {
        return code + ":" + msg;
    }

    private ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
