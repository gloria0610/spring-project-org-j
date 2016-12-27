package com.righthere.user.server.controller;


import com.google.common.collect.Maps;

import java.util.Map;

public class JsonResult<T> {
	
	/**
	 * json序列化的主对象
	 */
	private T data;

	/**
	 * 暂时只放 是否成功 和 消息  
	 * json序列化的 成功失败和消息对象
	 */
	private Map<String,Object> info;

	
	/**********只提供2个get方法n*************/
	
	public Map<String, Object> getInfo() {
		return info;
	}

	public T getData() {
		return data;
	}
	
	public JsonResult(boolean ok, String message, T data){
		info = Maps.newHashMap();
		if(ok){
			info.put("suc", true);
			info.put("msg", null);
		}else{
			info = Maps.newHashMapWithExpectedSize(2);
			info.put("suc", false);
			info.put("msg", message);
		}
		this.data=data;
	}
}
