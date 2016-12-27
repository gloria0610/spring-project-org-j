package com.righthere.user.server.service.bo;

import com.gbanker.base.rpc.api.interceptor.ServiceApiRequest;
import com.gbanker.base.rpc.api.interceptor.ServiceApiResponse;
import com.gbanker.user.server.service.info.IUserInfoService;
import com.gbanker.user.server.service.realname.IUserRealNameService;
import com.gbanker.user.server.service.regist.IUserRegistService;
import com.righthere.user.server.service.common.BaseServiceTest;
import org.springframework.stereotype.Service;

/**
* Created by jiangyayi on 16/8/28.
*/

@Service("userQueryBO")
public class UserQueryBO extends BaseServiceTest {

    // 服务接口的uri地址
    private static final String ACCOUNT_SERVICE_URI = "http://182.92.10.201:8083/";
    // 服务接口的uri地址
    private static final String USER_SERVICE_URI = "http://182.92.10.201:8082/";


    // 生成用户服务接口
    private IUserRegistService iUserRegistService = super.createServiceInterface(USER_SERVICE_URI,
            IUserRegistService.class);

    private IUserRealNameService iUserRealNameService =super.createServiceInterface(USER_SERVICE_URI,
            IUserRealNameService.class);

    private IUserInfoService iUserInfoService = super.createServiceInterface(USER_SERVICE_URI,
            IUserInfoService.class);


    public String getUserByTelephone(String telephone) {
        //发送请求
        ServiceApiRequest request = super.getRequest();
        request.put("telephone", telephone);
        ServiceApiResponse response = iUserInfoService.getUserByTelephone(request);
        return response.getData().get("userId").toString();

    }

    public String getAccountByTelephone(String telephone) {
        //发送请求
        ServiceApiRequest request = super.getRequest();
        request.put("telephone", telephone);
        ServiceApiResponse response = iUserInfoService.getUserByTelephone(request);
        return response.getData().get("accountId").toString();

    }

}
