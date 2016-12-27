package com.righthere.user.server.utils.serverutil;

import com.gbanker.base.dal.common.IBaseDao;
import com.gbanker.base.rpc.api.interceptor.ServiceApiRequest;
import com.gbanker.base.rpc.api.interceptor.ServiceApiResponse;
import com.gbanker.user.server.service.password.IUserPasswordService;
import com.gbanker.user.server.service.realname.IUserRealNameService;
import com.gbanker.user.server.service.regist.IUserRegistService;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by jiangyayi on 16/9/1.
 */
public class Userutil extends BaseServiceTest {

      /*库操作实例
        SqlConn sqlConn=new SqlConn();
        String sqlin="select * from user_address";
        sqlConn.getConnSql(sqlin);
        */


    // 服务接口的uri地址
   // private static final String USER_INFO_SERVICE_URI = "http://182.92.10.201:8082/";

    private static final String USER_INFO_SERVICE_URI = "http://123.57.141.46:8080/";

    private IUserRegistService iUserRegistService = super.createServiceInterface(USER_INFO_SERVICE_URI, IUserRegistService.class);

    private IUserPasswordService iUserPasswordService = super.createServiceInterface(USER_INFO_SERVICE_URI, IUserPasswordService.class);

    private IUserRealNameService iUserRealNameService = super.createServiceInterface(USER_INFO_SERVICE_URI, IUserRealNameService.class);

    @Autowired
    private IBaseDao baseDao;


    public void setUserRealName(String userId) {


        //发送请求
        ServiceApiRequest request = super.getRequest();
        request.put("userId", "userrealid001");
        request.put("realName", "王小二");
        request.put("idNumber", "110103198210021800");
        request.put("idNumberIMG", "xxxxxxxxwangxiaoer.jpg");

        ServiceApiResponse response = iUserRealNameService.executeVerifyRealName(request);
        System.out.println(response);
    }

    public void setUserReal(){

        for(int i=10000;i<99999;i++){
            String Ustr = "user" + Integer.toString(i);
            ServiceApiRequest request = super.getRequest();
            request.put("userId", Ustr);
            request.put("realName", "王小二");
            request.put("idNumber", "110103198210021800");
            request.put("idNumberIMG", "xxxxxxxxwangxiaoer.jpg");
            System.out.println(i);
            ServiceApiResponse response = iUserRealNameService.executeVerifyRealName(request);
            System.out.println(response);
        }

    }

    public void checkUserReal(){


        //发送请求
        ServiceApiRequest request = super.getRequest();
        request.put("userId", "user99998");
        request.put("realName", "王小二");
        request.put("idNumber", "110103198210021800");
        request.put("idNumberIMG", "xxxxxxxxwangxiaoer.jpg");

        ServiceApiResponse response = iUserRealNameService.executeValidateRealName(request);
        System.out.println(response.getData().toString());
        Assert.assertEquals("{validatResult=true}", response.getData().toString());
        System.out.println("测试通过");
    }


    public void setUserPass2() {
        //发送请求
        ServiceApiRequest request = super.getRequest();
        for (int i = 10001; i < 99999; i++) {
            String Ustr = "user" + Integer.toString(i);
            request.put("userId", Ustr);
            request.put("password", "111111");
            request.put("passwordType", "2");

            ServiceApiResponse response = iUserPasswordService.updateUserPassword(request);
            System.out.println(response);
        }
    }



    public static void main(String args[]){
        Userutil userutil= new Userutil();
          //userutil.setUserReal();
        //userutil.setUserPass2();
        //userutil.setUserReal();
         userutil.checkUserReal();
    }


}
