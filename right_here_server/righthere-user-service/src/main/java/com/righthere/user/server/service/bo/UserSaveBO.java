package com.righthere.user.server.service.bo;

import com.gbanker.account.server.service.basic.IAccountBasicService;
import com.gbanker.account.server.service.batch.IAccountBatchTradeService;
import com.gbanker.base.rpc.api.interceptor.ServiceApiRequest;
import com.gbanker.base.rpc.api.interceptor.ServiceApiResponse;
import com.gbanker.user.server.service.info.IUserInfoService;
import com.gbanker.user.server.service.password.IUserPasswordService;
import com.gbanker.user.server.service.realname.IUserRealNameService;
import com.gbanker.user.server.service.regist.IUserRegistService;
import com.righthere.user.server.service.common.BaseServiceTest;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
* Created by jiangyayi on 16/8/28.
*/
@Service("userSaveBO")
public class UserSaveBO  extends BaseServiceTest {

//
//    /**
//     * Created by jiangyayi on 16/8/18.
//     * 测试工具类 保存用户账户 充值
//     */
    @Autowired
    private UserQueryBO userQueryBO;

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

        private IUserPasswordService iUserPasswordService = super.createServiceInterface(USER_SERVICE_URI,
                IUserPasswordService.class);

    // 生成账户服务接口
        private IAccountBasicService iAccountBasicService = super.createServiceInterface(ACCOUNT_SERVICE_URI,
                IAccountBasicService.class);

        // 生成充值接口
        private IAccountBatchTradeService iAccountBatchTradeService = super.createServiceInterface(ACCOUNT_SERVICE_URI,
                IAccountBatchTradeService.class);


    //用户注册
    public void userRegist(String telphone){

        //发送请求
        ServiceApiRequest request = super.getRequest();
        request.put("telephone", telphone);
        request.put("inviterUserId","");
        ServiceApiResponse response = iUserRegistService.executeRegist(request);
        System.out.println(response);
    }

    public void userRegist(String telephone,String inviter){

        //发送请求
        ServiceApiRequest request = super.getRequest();
        request.put("telephone", telephone);
        request.put("inviterUserId", inviter);
        ServiceApiResponse response = iUserRegistService.executeRegist(request);
        System.out.println(response);
    }



    //实名认证
    //传userId的实名
    public void setUserReal(String userId) {
        //发送请求
        ServiceApiRequest request = super.getRequest();
        request.put("userId", userId);
        request.put("realName", "王测试");
        request.put("idNumber", "110103199010021800");
        request.put("idNumberIMG", "xxxxxxxxwangxiaoer.jpg");

        ServiceApiResponse response = iUserRealNameService.executeVerifyRealName(request);
        System.out.println(response);
    }

    //批量实名认证
    public void setUserReal(int start, int end){

        for(int i=start;i<end;i++){
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

    //传参实名
    public void setUserReal(String userId,String realName,String idNumber,String idNumberIMG){
        //发送请求
        ServiceApiRequest request = super.getRequest();
        request.put("userId", userId);
        request.put("realName", realName);
        request.put("idNumber", idNumber);
        request.put("idNumberIMG", idNumberIMG);
        ServiceApiResponse response = iUserRealNameService.executeVerifyRealName(request);
    }


    //实名检查
    public void checkUserReal(String userid){

        //发送请求
        ServiceApiRequest request = super.getRequest();
        request.put("userId", userid);
        request.put("realName", "王小二");
        request.put("idNumber", "110103198210021800");
        request.put("idNumberIMG", "xxxxxxxxwangxiaoer.jpg");

        ServiceApiResponse response = iUserRealNameService.executeValidateRealName(request);
        System.out.println(response.getData().toString());
        Assert.assertEquals("{validatResult=true}", response.getData().toString());
        System.out.println("测试通过");
    }


    //设置用户登录密码

    public void setUserPassReg(String userid,String password) {
        //发送请求
        ServiceApiRequest request = super.getRequest();
        request.put("userId", userid);
        request.put("password", password);
        request.put("passwordType", "1");

        ServiceApiResponse response = iUserPasswordService.updateUserPassword(request);
        System.out.println(response);

    }



    public void setUserPassReg(String userid) {
        //发送请求
        ServiceApiRequest request = super.getRequest();
        request.put("userId", userid);
        request.put("password", "000000");
        request.put("passwordType", "1");

        ServiceApiResponse response = iUserPasswordService.updateUserPassword(request);
        System.out.println(response);

    }


    public void setUserPassReg(int start,int end) {
        //发送请求
        ServiceApiRequest request = super.getRequest();
        for (int i = start; i < end; i++) {
            String Ustr = "user" + Integer.toString(i);
            request.put("userId", Ustr);
            request.put("password", "111111");
            request.put("passwordType", "1");

            ServiceApiResponse response = iUserPasswordService.updateUserPassword(request);
            System.out.println(response);
        }
    }



    //设置用户支付密码
    public void setUserPassPay(String userid) {

        //发送请求
        ServiceApiRequest request = super.getRequest();

        String Ustr = userid;
        request.put("userId", Ustr);
        request.put("password", "111111");
        request.put("passwordType", "2");

        ServiceApiResponse response = iUserPasswordService.updateUserPassword(request);
        System.out.println(response);

    }


    public void setUserPassPay(String userid,String password) {

        //发送请求
        ServiceApiRequest request = super.getRequest();

        String Ustr = userid;
        request.put("userId", Ustr);
        request.put("password", password);
        request.put("passwordType", "2");

        ServiceApiResponse response = iUserPasswordService.updateUserPassword(request);
        System.out.println(response);

    }

    public void setUserPassPay(int start,int end) {
        //发送请求
        ServiceApiRequest request = super.getRequest();
        for (int i = start; i < end; i++) {
            String Ustr = "user" + Integer.toString(i);
            request.put("userId", Ustr);
            request.put("password", "111111");
            request.put("passwordType", "2");

            ServiceApiResponse response = iUserPasswordService.updateUserPassword(request);
            System.out.println(response);
        }
    }


    public String getUserByTelephone(String telephone) {
            //发送请求
            ServiceApiRequest request = super.getRequest();
            request.put("telephone", telephone);
            ServiceApiResponse response = iUserInfoService.getUserByTelephone(request);
            return response.getData().get("userId").toString();

        }

        public String getAccountTelephone(String telephone) {
            //发送请求
            ServiceApiRequest request = super.getRequest();
            request.put("telephone", telephone);
            ServiceApiResponse response = iUserInfoService.getUserByTelephone(request);
            return response.getData().get("accountId").toString();

        }


    }


