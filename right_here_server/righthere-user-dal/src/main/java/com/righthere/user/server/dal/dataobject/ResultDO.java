package com.righthere.user.server.dal.dataobject;

import com.righthere.user.server.dal.enums.ResultCode;

import java.io.Serializable;

/**
 * Created by user on 15-11-11.
 */
public class ResultDO<T> implements Serializable {

    private static final long serialVersionUID = 5241599578798108550L;
    /** 执行是否成功 */
    private boolean success = false;
    private ResultCode retCode;
    private String  errTrace;
    /** 实际的返回结果 */
    private T module;
    public boolean isSuccess() {
        return success;
    }
    public void setSuccess(boolean success) {
        this.success = success;
    }

    public ResultCode getRetCode() {
        return retCode;
    }
    public void setRetCode(ResultCode retCode) {
        this.retCode = retCode;
    }
    public T getModule() {
        return module;
    }
    public void setModule(T module) {
        this.module = module;
    }
    public String getErrTrace() {
        return errTrace;
    }
    public void setErrTrace(String errTrace) {
        this.errTrace = errTrace;
    }
    public String getErrMsg() {
        StringBuilder content = new StringBuilder();
        content.append(retCode).append(". ErrTrace:").append(errTrace);
        return content.toString();
    }
}