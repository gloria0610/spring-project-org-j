package com.righthere.user.server.utils.datautil;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by jiangyayi on 16/9/1.
 * 创建全套压测数据的工具 批量注册已可以支持 此代码保留
 */
public class SqlUtils {


    String sqlinsertUserBasic = null;
    String sqlinsertUserCard = null;

    public void setSqlinUserBasic() throws IOException{

        for (int i = 20001; i < 99999; i++) {

            sqlinsertUserBasic = "insert `user_basic`(`id`,`account_id`,`telephone`,`regist_time`,`user_code`,`invite_code`,`check_open_account`,`status`) values('user" +
                    i + "','account" + i + "','100000" + i + "','2016-09-01 16:48:03','" + i + "','x" + i + "',1,1);";
            System.out.println(sqlinsertUserBasic);
            FileWriter fileWriter=new FileWriter("/Users/jiangyayi/Documents/黄金钱包/userbasic10w.txt", true);
            try {
                fileWriter.write(sqlinsertUserBasic);
                fileWriter.flush();
                fileWriter.close();
            }catch (Exception e){
                System.out.println("there is an error occurred");
            }


        }
    }



    public void setSqlinUserCard(){
        for(int i = 10000;i<20001;i++){
            sqlinsertUserCard = "insert `gbanker_trans`.`bank_card`(`id`,`merchant_account`,`account_id`,`bank_id`,`bank_card_no`,`bank_card_name`,`identity_type`,`identity_number`,`mobile_phone`,`bind_time`,`status`) values" +
                    "('card"+i+"','00000001','account"+i+"','001','6225880329341243','yace',1,'1111111111111111111','100000" + i + "','2016-09-01 18:40:55',1)";
            System.out.println(sqlinsertUserCard);

        }
    }


    public void setBuyGoldReq(){
        String buyReq =null;
        for(int i = 10000;i<20001;i++){
            buyReq = "{\"telephone\":\"100000"+i+"\",\"money\":\"100\"}";
            System.out.println(buyReq);

        }
    }

    public void setBuyGoldOrder(){
        String buyReq =null;
        for(int i = 10000;i<10884;i++) {
            buyReq = "insert `order_basic`(`id`,`user_id`,`account_id`,`order_no`,`order_type`,`order_time`,`order_timeout`,`order_gold_price`,`order_money`,`pay_money`,`order_gold_weight`,`order_description`,`status`) values('"+i+"','user"+i+"','account"+i+"','Tyc_0000000000000"+i+"',1,'2016-09-02 17:17:37','2016-09-30 17:17:44','28000','100','100','1','压测数据',1);";
            System.out.println(buyReq);
        }
    }

    public void setConformBuyReq() throws IOException {
        String conformReq = null;
        for(int i = 10000;i<99999;i++) {
            conformReq = "{\"password\": \"111111\",\"telephone\": \"100000" + i + "\",\"isUseCashBalance\": \"true\",\"orderNo\": \"Tsyc_00000000001" + i + "\",\"couponId\": \"\"}\n";
            System.out.println(conformReq);
            FileWriter fileWriter=new FileWriter("/Users/jiangyayi/Documents/黄金钱包/buyconfirm10000.txt", true);
            try {
                fileWriter.write(conformReq);
                fileWriter.flush();
                fileWriter.close();
            }catch (Exception e){
                System.out.println("there is an error occurred");
            }
        }

    }


    public void setOrderSub(){
        String ordersub = null;
        for(int i = 10000;i<14303;i++) {
            ordersub ="insert `gbanker_order`.`order_buy`(`id`,`order_id`,`gold_product_record_id`,`order_gold_price`,`real_gold_price`,`buy_way`) values('id"+i+"','"+i+"','product"+i+"','28000','28000',2);";
            System.out.println(ordersub);
        }
    }



    public void setOrderProductrecord(){
        String Productrecord = null;
        for(int i = 10000;i<11825;i++) {
            Productrecord ="insert `invest_gold_product_record`(`id`,`user_id`,`account_id`,`order_no`,`water_no`,`product_type`,`gold_product_type`,`gold_bid_type`,`invest_time`,`clear_start_date`,`clear_end_date`,`gold_weight`,`clear_rate`,`total_interest_money`,`invest_way`,`clear_way`,`settle_way`,`provide_type`,`renew_flag`,`status`,`total_interest_gold_weight`) values('product"+i+"','user"+i+"','account"+i+"','Tyc_0000000000000" +i+"','water"+i+"',0,0,0,'2016-09-02 19:41:49','2016-09-02','2016-09-02','1','0','0',1,0,0,0,0,1,'0');";
            System.out.println(Productrecord);
        }

    }


//    public void setSaleGoldReq() {
//        String salereq = null;
//
//        for(int i = 10000;i<20001;i++) {
//            salereq = "insert `order_basic`(`id`,`user_id`,`account_id`,`order_no`,`order_type`,`order_time`,`order_timeout`,`order_gold_price`,`order_money`,`pay_money`,`order_gold_weight`,`order_description`,`status`) values('"+i+"','user"+i+"','account"+i+"','Tyc_0000000000000"+i+"',1,'2016-09-02 17:17:37','2016-09-30 17:17:44','28000','100','100','1','压测数据',1);";
//            System.out.println(salereq);
//        }
//
//    }



    public void setMerchantBuyReq() throws IOException {

        String conformReq = null;
        for(int i = 10000;i<99999;i++) {
            conformReq = "{\"version\":\"20160801\",\"merchantCode\":\"MC508\",\"orderTime\":\"2016-08-13 18:52:53\",\"goldWeight\": 1,\"orderAmount\":1,\"reqNo\":\"abc"+i+"\",\"buyType\": 2,\"sign\": \"ac7d93a9baeb776c29b886282286d217\"}\n";
            System.out.println(conformReq);
            FileWriter fileWriter=new FileWriter("/Users/jiangyayi/Documents/黄金钱包/maijin1.dat", true);
            try {
                fileWriter.write(conformReq);
                fileWriter.flush();
                fileWriter.close();
            }catch (Exception e){
                System.out.println("there is an error occurred");
            }

        }

    }




    public void setConformSaleReq() throws IOException {

        String conformReq = null;
        for(int i = 10000;i<99999;i++) {
            conformReq = "{\"password\": \"111111\",\"telephone\": \"100000" + i + "\",\"orderNo\": \"Tsyc_00000000001" + i + "\"}"+"\n";
            System.out.println(conformReq);
            FileWriter fileWriter=new FileWriter("/Users/jiangyayi/Documents/黄金钱包/saleconfirm10000.txt", true);
            try {
                fileWriter.write(conformReq);
                fileWriter.flush();
                fileWriter.close();
            }catch (Exception e){
                System.out.println("there is an error occurred");
            }

        }

    }

    public void setMerchantBuyComfirmReq() throws IOException {

        String conformReq = null;
        for(int i = 10000;i<99999;i++) {
            conformReq = "{\"version\":\"20160801\",\"merchantCode\":\"MC508\",\"orderTime\":\"2016-08-13 18:52:53\",\"confirmWeight\": 1,\"confirmAmount\":29,\"reqNo\":\"abc"+i+"\",\"confirmPrice\":28623,\"sign\": \"ac7d93a9baeb776c29b886282286d217\"}\n";
            System.out.println(conformReq);
            FileWriter fileWriter=new FileWriter("/Users/jiangyayi/Documents/黄金钱包/maijin3.dat", true);
            try {
                fileWriter.write(conformReq);
                fileWriter.flush();
                fileWriter.close();
            }catch (Exception e){
                System.out.println("there is an error occurred");
            }

        }

    }



    public static  void main(String args[]) throws IOException {
        SqlUtils sqlUtil=new SqlUtils();
        //sqlUtil.setSqlinUserBasic();
        //sqlUtil.setSqlinUserCard();
        //sqlUtil.setBuyGoldOrder();
        //sqlUtil.setBuyGoldReq();
        sqlUtil.setConformBuyReq();
        //sqlUtil.setOrderSub();
        //sqlUtil.setOrderProductrecord();
        //sqlUtil.setConformSaleReq();
        //sqlUtil.setMerchantBuyReq();
        //sqlUtil.setMerchantBuyComfirmReq();
    }
}