package com.righthere.user.server.common;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AjaxResult {
	private Info info;

	private Map<?, ?> data;

	private AjaxResult(boolean isOk) {
		this.info = new Info(isOk);
	}

	public Info getInfo() {
		return info;
	}

	public Map<?, ?> getData() {
		if (data == null) {
			data = new HashMap<Object, Object>();
		}
		return data;
	}

	public void setData(Map<?, ?> data) {
		this.data = data;
	}

	public static AjaxResult succResult() {
		return new AjaxResult(true);
	}

    public static AjaxResult succResult(String message) {
        AjaxResult ajaxResult = new AjaxResult(true);
        ajaxResult.getInfo().setMessage(message);
        return ajaxResult;
    }

    public static AjaxResult succResult(Object data) {
        return succResult("data",data);
    }

	public static AjaxResult succResult(String key, Object value) {
		AjaxResult ajaxResult = new AjaxResult(true);
		Map<String, Object> data = new HashMap<String, Object>();
		data.put(key, value);
		ajaxResult.setData(data);
		return ajaxResult;
	}

	public static AjaxResult succResult(Map<?, ?> dataMap) {
		AjaxResult ajaxResult = new AjaxResult(true);
		ajaxResult.setData(dataMap);
		return ajaxResult;
	}

	public static AjaxResult succPageResult(Object pager, List<?> list) {
		AjaxResult ajaxResult = new AjaxResult(true);
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("pager", pager);
		data.put("list", list);
		ajaxResult.setData(data);
		return ajaxResult;
	}

	public static AjaxResult errorResult(String message) {
		AjaxResult result = new AjaxResult(false);
		result.getInfo().setMessage(message);
		return result;
	}

	public static AjaxResult errorResult(String message, ErrorCodeEmun errorCodeEmun) {
		AjaxResult result = new AjaxResult(false);
		result.getInfo().setMessage(message);
		Map<String, String> map = new HashMap<String, String>();
		map.put("errorCode", String.valueOf(errorCodeEmun.getCode()));
		map.put("errorMsg", String.valueOf(errorCodeEmun.getMsg()));
		result.setData(map);
		return result;
	}

	public static AjaxResult errorResult() {
		AjaxResult ajaxResult = new AjaxResult(false);
		ajaxResult.getInfo().setMessage("system.error");
		return ajaxResult;
	}

	public String toSimpleJsonString() {
		return "{\"info\":{\"message\":\"" + info.getMessage() + "\",\"ok\":" + info.isOk() + "},\"data\":{}}";
	}

	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}
}