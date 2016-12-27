package com.righthere.user.server.utils.serverutil;


import com.gbanker.base.rpc.api.interceptor.ServiceApiRequest;
import com.gbanker.base.rpc.api.interceptor.ServiceApiResponse;
import com.gbanker.base.util.date.DateStyle;
import com.gbanker.base.util.date.DateUtils;
import com.gbanker.order.server.service.deal.IOrderDealService;
import com.gbanker.order.server.service.withdraw.IWithdrawOrderService;

import java.util.Date;

/**
* Created by jiangyayi on 16/9/5.
*/
public class OrderUtil extends BaseServiceTest {

    // 服务接口的uri地址
    private static final String ORDER_SERVICE_URI = "http://123.56.152.168:8080/";

    // 生成Order服务接口
    private IOrderDealService iOrderDealService= super.createServiceInterface(ORDER_SERVICE_URI,
            IOrderDealService.class);
    private IWithdrawOrderService iWithdrawOrderService=super.createServiceInterface(ORDER_SERVICE_URI,
            IWithdrawOrderService.class);


    public void createOrderSellGold(String userId,String accountId,String orderNo) {
        /**
         *case4 卖金
         ** *** 生成订单，根据订单类型找到实现类，执行相应操作
         * <p>
         * 参数<br>
         * 这个需要controller里面生成传入， 服务器端可以实现重试写入方案， 多次写入因为orderNo是唯一索引只能插入一次
         *
         * <code>orderNo</code>: 订单号<br>
         * <code>orderType</code>: 订单类型(1:买金，2:卖金，3:存金，4:提金，5:充值，6:提现，7:活转定，8:保本金)<br>
         * <code>userId</code>: 用户id<br>
         * <code>accountId</code>: 账户id<br>
         * <code>orderMoney</code>: 订单金额<br>
         * <code>orderGoldWeight</code>: 订单金重<br>
         * <code>orderGoldPrice</code>: 订单金价<br>
         * <code>params</code>: 具体业务的参数
         * </p>
         * <p>
         * 返回自定义code的意义 :<br>
         * 1:保存失败
         * </p>
         *
         * */



            System.out.println("-------------------------case03-1 卖金订单 ------------------------");
        //caseNum += 1;
        Date transferDate = DateUtils.StringToDate("2016-04-25", DateStyle.YYYY_MM_DD);

        //发送请求
        ServiceApiRequest request = super.getRequest();
        request.put("orderType", 2);
        request.put("orderNo",orderNo);
        request.put("accountId", accountId);
        request.put("userId", userId);
        //***
        //request.put("orderMoney", 1111L);
        request.put("orderGoldWeight", 2L);
        request.put("orderGoldPrice", 26000l);
        request.put("orderMoney", 100l);
        request.put("orderDescription","活期黄金");
        request.putObj("params", "feeMoney", 1L);
        request.putObj("params", "endTime", "2016-09-25 20:00:00");

        ServiceApiResponse response = iOrderDealService.executeCreateOrder(request);
        System.out.println(response);
    }


    public void createOrderBuyGold(String userId,String accountId,String orderNo) {
        /**
         *case4 卖金
         ** *** 生成订单，根据订单类型找到实现类，执行相应操作
         * <p>
         * 参数<br>
         * 这个需要controller里面生成传入， 服务器端可以实现重试写入方案， 多次写入因为orderNo是唯一索引只能插入一次
         *
         * <code>orderNo</code>: 订单号<br>
         * <code>orderType</code>: 订单类型(1:买金，2:卖金，3:存金，4:提金，5:充值，6:提现，7:活转定，8:保本金)<br>
         * <code>userId</code>: 用户id<br>
         * <code>accountId</code>: 账户id<br>
         * <code>orderMoney</code>: 订单金额<br>
         * <code>orderGoldWeight</code>: 订单金重<br>
         * <code>orderGoldPrice</code>: 订单金价<br>
         * <code>params</code>: 具体业务的参数
         * </p>
         * <p>
         * 返回自定义code的意义 :<br>
         * 1:保存失败
         * </p>
         *
         * */
    System.out.println("-------------------------case03-2 买金订单 ------------------------");
    //caseNum += 1;
    Date transferDate = DateUtils.StringToDate("2016-04-25", DateStyle.YYYY_MM_DD);

    //发送请求
        ServiceApiRequest request = super.getRequest();
        request.put("orderType", 1);
        request.put("orderNo",orderNo);
        request.put("accountId", accountId);
        request.put("userId", userId);
        request.put("orderMoney", 250L);
        request.put("orderGoldWeight",10L);
        request.put("orderGoldPrice",25000L);
        request.put("orderDescription","压测买活期黄金");
        request.put("orderCancelTimesLimit","{\"limitMinute\":\"30\",\"limitTimes\":\"500000000\"}");
        request.putObj("params", "productType", 0);//0是活期1是定期
        request.putObj("params", "waterNo", "wa"+orderNo);
        request.putObj("params", "goldProductType", 0); //现金和黄金全是0
        request.putObj("params", "goldBidType", 0);
        request.putObj("params", "clearRate", 2l);
        request.putObj("params", "clearStartDate", new Date());

        request.putObj("params", "clearEndDate", new Date());
        request.putObj("params", "totalInterest", 100l);
        request.putObj("params", "investWay", 1);
        request.putObj("params", "clearWay", 1);
        request.putObj("params", "settleWay", 1);
        request.putObj("params", "renewFlag", 1);
        request.putObj("params", "parentRecordId", "");
        request.putObj("params", "status", 1);
        request.putObj("params", "realGoldPrice", 26000l);
        request.putObj("params", "buyWay", 1);
        request.putObj("params", "provideType", 1); //provideType 0 钱 1金
        request.putObj("params", "endTime", "2016-09-25 20:00:00");
        ServiceApiResponse response = iOrderDealService.executeCreateOrder(request);
    System.out.println(response);
}


    public static void main(String args[]) throws InterruptedException {
        OrderUtil orderUtil= new OrderUtil();


        for(int i=10000;i<99999;i++) {
            String Ustr = "user" + Integer.toString(i);
            String Astr = "account" + Integer.toString(i);
            //String Ostr = "Tsyc_00000000002" + Integer.toString(i);
            String OstrBuy = "Tsbyc_000000000001" + Integer.toString(i);

            //System.out.println(Ostr);
            //orderUtil.createOrderSellGold(Ustr,Astr,Ostr);
            System.out.println(OstrBuy);
            orderUtil.createOrderBuyGold(Ustr, Astr, OstrBuy);
        }


    }
    }

