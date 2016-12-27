package com.righthere.user.server.common;

/**
 * Info
 * 
 * @Author ZKT
 * @CreateDate 2013-5-6
 */
public class Info {
	private boolean ok;

	private String message;

	public Info(boolean isOk) {
		this.ok = isOk;
	}

	public Info(boolean isOk, String message) {
		this.ok = isOk;
		this.message = message;
	}

	public boolean isOk() {
		return ok;
	}

	public void setOk(boolean ok) {
		this.ok = ok;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}