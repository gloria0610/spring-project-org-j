package com.righthere.user.server.utils.serverutil;

import com.caucho.hessian.client.HessianProxyFactory;
import com.gbanker.base.rpc.api.interceptor.ServiceApiRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;

public abstract class BaseServiceTest {
	
	private static final Logger LOG = LoggerFactory.getLogger(BaseServiceTest.class);
	
	/**
	 * 创建服务接口
	 * 
	 * @param baseUri 服务uri
	 * @param clazz 接口类
	 * @return
	 * @throws java.net.MalformedURLException
	 */
	@SuppressWarnings("unchecked")
	protected <T> T createServiceInterface(String baseUri, Class<T> clazz) {
		HessianProxyFactory factory = new HessianProxyFactory();
		String url = baseUri + clazz.getName();
		try {
			return (T) factory.create(clazz, url);
		} catch (MalformedURLException e) {
			LOG.error("create service interface error. url error.", e);
		}
		return null;
	}
	
	/**
	 * 获取请求对象
	 * 
	 * @return
	 */
	protected ServiceApiRequest getRequest() {
		return new ServiceApiRequest(ServiceApiRequest.DEFAULT_APP_VERSION);
	}
	
}
