package com.righthere.user.server.utils.signutil;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by jiangyayi on 16/8/17.
 */
public class SignUtil {

    public void SignMaker(){

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("version", "20160818");
        jsonObject.put("orderTime", "2016-08-18 10:00:00");
        jsonObject.put("reqNo", "MC9999cash-013");
        jsonObject.put("merchantCode", "MC505");
        jsonObject.put("amount", "");
        jsonObject.put("ext", "创建提现订单" );//备注
        System.out.println(MerchantSignHelp.sign(jsonObject.toJSONString(),
                "thisistestsignkey4merchantjyytestcash"));

    }



    public void SignMakerConform(){

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("version", "20160818");
        jsonObject.put("orderTime", "2016-08-18 10:00:00");
        jsonObject.put("reqNo", "MC505buygold-001");
        jsonObject.put("merchantCode", "MC505");
        jsonObject.put("confirmWeight", "70");
        jsonObject.put("confirmAmount", "1988");
        jsonObject.put("ext", "确认买金订单" );//备注
        System.out.println(MerchantSignHelp.sign(jsonObject.toJSONString(),
                "thisistestsignkey4merchantjyytestcash"));

    }

    public static void main(String[] args) {
        SignUtil signUtil=new SignUtil();
        signUtil.SignMakerConform();

    }
}
