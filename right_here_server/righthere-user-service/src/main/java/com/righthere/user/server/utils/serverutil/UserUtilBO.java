package com.righthere.user.server.utils.serverutil;

import com.gbanker.user.server.service.realname.IUserRealNameService;
import com.gbanker.user.server.service.regist.IUserRegistService;
import org.springframework.stereotype.Service;

/**
* Created by jiangyayi on 16/9/1.
*/
@Service("userUtilBO")
public class UserUtilBO extends BaseServiceTest {

      /*库操作实例
        SqlConn sqlConn=new SqlConn();
        String sqlin="select * from user_address";
        sqlConn.getConnSql(sqlin);
        */


    // 服务接口的uri地址
   // private static final String USER_INFO_SERVICE_URI = "http://182.92.10.201:8082/";

    private static final String USER_INFO_SERVICE_URI = "http://123.57.141.46:8080/";

    private IUserRegistService iUserRegistService = super.createServiceInterface(USER_INFO_SERVICE_URI, IUserRegistService.class);


    private IUserRealNameService iUserRealNameService = super.createServiceInterface(USER_INFO_SERVICE_URI, IUserRealNameService.class);







}
