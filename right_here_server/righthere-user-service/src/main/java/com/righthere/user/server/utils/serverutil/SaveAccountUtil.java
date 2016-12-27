package com.righthere.user.server.utils.serverutil;

import com.gbanker.account.server.helper.code.OperationTypeCode;
import com.gbanker.account.server.service.basic.IAccountBasicService;
import com.gbanker.account.server.service.batch.IAccountBatchTradeService;
import com.gbanker.base.dal.common.IBaseDao;
import com.gbanker.base.rpc.api.interceptor.ServiceApiRequest;
import com.gbanker.base.rpc.api.interceptor.ServiceApiResponse;
import com.gbanker.base.util.json.JSONUtils;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jiangyayi on 16/8/18.
 * 测试工具类 保存用户账户 充值
 */
public class SaveAccountUtil extends BaseServiceTest {

      /*库操作实例
        SqlConn sqlConn=new SqlConn();
        String sqlin="select * from user_address";
        sqlConn.getConnSql(sqlin);
        */


    // 服务接口的uri地址
    //private static final String ACCOUNT_SERVICE_URI = "http://182.92.10.201:8083/";
    private static final String ACCOUNT_SERVICE_URI = "http://123.57.145.58:8080/";


    // 生成用户服务接口
    private IAccountBasicService iAccountBasicService = super.createServiceInterface(ACCOUNT_SERVICE_URI,
            IAccountBasicService.class);

    //
    // 生成充值接口
    private IAccountBatchTradeService iAccountBatchTradeService = super.createServiceInterface(ACCOUNT_SERVICE_URI,
            IAccountBatchTradeService.class);

    @Autowired
    private IBaseDao baseDao;


    //保存账户的方法
    public void saveAccountBasic() {
        ServiceApiRequest request = super.getRequest();
        ServiceApiResponse response = null;
        String registTime = "2016-04-06 23:59:59";

        // 录入数据
        request = new ServiceApiRequest(ServiceApiRequest.DEFAULT_APP_VERSION);
        request.put("userId", "MC9999");
        request.put("accountId", "MA9999");
        request.put("registTime", registTime);


        response = iAccountBasicService.saveAccountBasic(request);
        System.out.println(response);
        Assert.assertEquals(ServiceApiResponse.SUCCESS, response.getCode());

    }



    //保存账户的方法
    public void saveAccountBasicIn(String userid,String accountid) {
        ServiceApiRequest request = super.getRequest();
        ServiceApiResponse response = null;
        String registTime = "2016-04-06 23:59:59";

        // 录入数据
        request = new ServiceApiRequest(ServiceApiRequest.DEFAULT_APP_VERSION);
        request.put("userId", userid);
        request.put("accountId", accountid);
        request.put("registTime", registTime);


        response = iAccountBasicService.saveAccountBasic(request);
        System.out.println(response);
       // Assert.assertEquals(ServiceApiResponse.SUCCESS, response.getCode());

    }


    //给账户充值 传入充值金额
    public void accountCashAdd(Long money) {

        ServiceApiRequest request = super.getRequest();
        ServiceApiResponse response = null;
        Map<String, Object> map = new HashMap<String, Object>();
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

        map = new HashMap<String, Object>();
        map.put("component", IAccountBatchTradeService.IN_MONEY);// 指定helper组件
        map.put("operationTypeCode", OperationTypeCode.充值.toString());// 业务类型编码
        map.put("tradeMoney", money);// 交易金额
        map.put("tradeExplain", "充值");// 交易说明
        map.put("productType", 0);// 产品类型
        map.put("orderNo", "MA9998order001");// 订单号
        map.put("operationNo", "MA9998oper");// 业务编号
        map.put("thingId", "MA9998thing");// 事物ID
        map.put("batchNo", "MA9998batch");// 批次号
        list.add(map);
        String processParams = JSONUtils.objectToJSONString(list);
        request = super.getRequest();
        request.put("processParams", processParams);
        request.put("accountId", "MA9998");
        response = iAccountBatchTradeService.executeBatchTrade(request);
        System.out.println(response);

    }


    public void accountCashAdd(Long money,String accountid,String operationNo) {

        ServiceApiRequest request = super.getRequest();
        ServiceApiResponse response = null;
        Map<String, Object> map = new HashMap<String, Object>();
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

        map = new HashMap<String, Object>();
        map.put("component", IAccountBatchTradeService.IN_MONEY);// 指定helper组件
        map.put("operationTypeCode", OperationTypeCode.充值.toString());// 业务类型编码
        map.put("tradeMoney", money);// 交易金额
        map.put("tradeExplain", "充值");// 交易说明
        map.put("productType", 0);// 产品类型
        map.put("orderNo", "order");// 订单号
        map.put("operationNo", operationNo);// 业务编号
        map.put("thingId", "thing");// 事物ID
        map.put("batchNo", "batch");// 批次号
        list.add(map);
        String processParams = JSONUtils.objectToJSONString(list);
        request = super.getRequest();
        request.put("processParams", processParams);
        request.put("accountId", accountid);
        response = iAccountBatchTradeService.executeBatchTrade(request);
        System.out.println(response);

    }


    //批量加金
    public void accountIngold(Long gold,String accountid,String operationNo) {

        ServiceApiRequest request = super.getRequest();
        ServiceApiResponse response = null;
        Map<String, Object> map = new HashMap<String, Object>();
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        map = new HashMap<String, Object>();
        map.put("accountType", 0);// 账户类型(0：活期，1：定期；)
        map.put("component", IAccountBatchTradeService.IN_GOLD);// 指定helper组件
        map.put("operationTypeCode", OperationTypeCode.买金.toString());// 业务类型编码// 业务类型编码
        map.put("orderNo", "yace");// 订单号
        map.put("operationNo", operationNo);// 业务编号
        map.put("tradeGoldWeight", gold);// 交易金重
        map.put("goldPrice", 260);// 实时金价
        map.put("productType", 0);// 产品类型(产品id)
        map.put("detailNumber", "yace");// 明细编号(标的id)
        map.put("transferDate", "2016-08-10");// 转入日期
        map.put("tradeExplain", "yace");// 交易说明
        map.put("batchNo", operationNo);// 批次号
        map.put("payMoney", 5000l);
        //map.put("realGoldPrice",260);
        // 支付金额

        list.add(map);

        String processParams = JSONUtils.objectToJSONString(list);
        request = super.getRequest();
        request.put("processParams", processParams);
        request.put("accountId", accountid);
        //request.put("realGoldPrice",260l);
        response = iAccountBatchTradeService.executeBatchTrade(request);
        System.out.println(response);

    }


    public void addCash(){
        //批量加钱

        SaveAccountUtil saveAccountUtil=new SaveAccountUtil();

        //批量加金
        for(int i=20000;i<99999;i++){
            String Ustr="user"+Integer.toString(i);
            String Astr="account"+Integer.toString(i);
            String Ostr="operationIN"+Integer.toString(i);

            //saveAccountUtil.saveAccountBasicIn(Ustr, Astr);
            saveAccountUtil.accountCashAdd(20000000l, Astr, Ostr);

}
    }

    public void addGold(){
        SaveAccountUtil saveAccountUtil=new SaveAccountUtil();

        //批量加金
        for(int i=20000;i<99999;i++) {
            String Ustr = "user" + Integer.toString(i);
            String Astr = "account" + Integer.toString(i);
            String Ostr = "operationIN" + Integer.toString(i);

            System.out.println(i);
            saveAccountUtil.accountIngold(20000000l, Astr, Ostr);
        }
    }


    public void addAccount(){
        SaveAccountUtil saveAccountUtil=new SaveAccountUtil();

        //批量加金
        for(int i=20000;i<99999;i++) {
            String Ustr = "user" + Integer.toString(i);
            String Astr = "account" + Integer.toString(i);
            String Ostr = "operationIN" + Integer.toString(i);


            saveAccountUtil.saveAccountBasicIn(Ustr, Astr);
        }
    }
    public static void main(String args[]){


        //调用批量保存
        SaveAccountUtil saveAccountUtil=new SaveAccountUtil();

            saveAccountUtil.addAccount();
            saveAccountUtil.addCash();
            saveAccountUtil.addGold();


    }

}
