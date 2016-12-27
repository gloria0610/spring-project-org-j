package com.righthere.user.server.common;

/**
 * ErrorCodeEmun
 * 
 * @Author ZKT
 * @CreateDate 2013-5-6
 */
public enum ErrorCodeEmun {
	ERROR_ARGUMENT(400, IllegalArgumentException.class, "参数错误", true),

//	ERROR_BIZ(401, BOException.class, "业务异常", true),
//
//	ERROR_HSF(402, HSFRemoteException.class, "HSF接口错误", false),
//
//	ERROR_PERMISSION(403, PermissonException.class, "权限异常", true),

	ERROR_UNKNOW(409, Exception.class, "系统错误", false);

//    ERROR_BIZ_INTERACTION(410, BOException.class, "业务异常,交互询问", true);

	/** 错误码 */
	private int code;

	/** 异常类. */
	private Class<?> clazz;

	/** 简要错误信息. */
	private String msg;

	/** 是否显示详细的错误信息. */
	private boolean isShowError;

	private ErrorCodeEmun(int code, Class<?> clazz, String msg, boolean isShowError) {
		this.code = code;
		this.clazz = clazz;
		this.msg = msg;
		this.isShowError = isShowError;
	}

	public static ErrorCodeEmun getByClass(Class<?> clazz) {
		for (ErrorCodeEmun errorCodeEmun : ErrorCodeEmun.values()) {
			if (errorCodeEmun.getClazz().equals(clazz)) {
				return errorCodeEmun;
			}
		}
		return ErrorCodeEmun.ERROR_UNKNOW;
	}

	public Class<?> getClazz() {
		return clazz;
	}

	public void setClazz(Class<?> clazz) {
		this.clazz = clazz;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public boolean isShowError() {
		return isShowError;
	}

	public void setShowError(boolean isShowError) {
		this.isShowError = isShowError;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
}