//package com.righthere.user.server.controller;
//
//import com.righthere.user.server.common.AjaxResult;
//import com.righthere.user.server.service.bo.UserQueryBO;
//import com.righthere.user.server.service.bo.UserSaveBO;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import javax.annotation.Resource;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// * Created by jiangyayi on 16/9/7.
// */
//@Controller
//@RequestMapping("/testserver/testUtil")
//public class TestUtilController {
//
////        @Resource
////        private UserUtilBO userUtilBO;
//        @Resource
//        private UserSaveBO userSaveBO;
//        @Resource
//        private UserQueryBO userQueryBO;
//        @Resource
//        private AccountSaveBO accountSaveBO;
//        @Resource
//        private UserCardBO userCardBO;
//
//
//        @RequestMapping
//        public String index(){
//            return "/testserver/testUtil";
//        }
//
//    @RequestMapping("/userRegOnly")
//    @ResponseBody
//    public String userRegOnly(HttpServletRequest request, HttpServletResponse response){
//
//            String telephone = request.getParameter("telephone");
//
//            String inviter =null;
//
//            if (null!=request.getParameter("inviter")){
//                 inviter = request.getParameter("inviter");
//                 userSaveBO.userRegist(telephone,inviter);
//            }else userSaveBO.userRegist(telephone);
//
//            //userSaveBO.registRealAddCash(telephone);
//            response.addHeader("Access-Control-Allow-Origin", "*");
//            System.out.println(response);
//            String result=response.toString();
////                JsonResult result = new JsonResult(true, null, response);
////                System.out.println(result);
//            return result;
//
//        }
//
//    @RequestMapping("/userRegRealPass")
//    @ResponseBody
//    public void userRegRealPass(HttpServletRequest request, HttpServletResponse response){
//
//        String telephone = request.getParameter("telephone");
//        String inviter =null;
//        String userId=userQueryBO.getUserByTelephone(telephone);
//        String accountId=userQueryBO.getAccountByTelephone(telephone);
//
//
//        if (null!=request.getParameter("inviter")){
//            inviter = request.getParameter("inviter");
//            userSaveBO.userRegist(telephone,inviter);
//        }else userSaveBO.userRegist(telephone);
//
//        userSaveBO.setUserReal(userId);
//        userSaveBO.setUserPassPay(userId);
//        userSaveBO.setUserPassReg(userId);
//        userCardBO.setUserCardBase(accountId);
//        response.addHeader("Access-Control-Allow-Origin", "*");
//        System.out.println(response);
//        //JsonResult result = new JsonResult(true, null, response);
//        //System.out.println(result);
//        //return result;
//
//    }
//
//
//    @RequestMapping("/userRegAccoutCashMoney")
//    @ResponseBody
//    public AjaxResult userRegAccoutCashMoney(HttpServletRequest request, HttpServletResponse response){
//
//        String telephone = request.getParameter("telephone");
//        String type = request.getParameter("type");
//        String inviter =null;
//
//        if (null!=request.getParameter("inviter")){
//            inviter = request.getParameter("inviter");
//            userSaveBO.userRegist(telephone,inviter);
//        }else userSaveBO.userRegist(telephone);
//
//        String userId=userQueryBO.getUserByTelephone(telephone);
//        String accountId=userQueryBO.getAccountByTelephone(telephone);
//
//        userSaveBO.setUserReal(userId);
//        userSaveBO.setUserPassReg(userId);
//        userSaveBO.setUserPassPay(userId);
//        userCardBO.setUserCardBase(accountId);
//        accountSaveBO.saveAccountBasic(userId,accountId);
//        if(type.equals("1")){
//            accountSaveBO.addCash(accountId);
//        }
//        if(type.equals("2")){
//            accountSaveBO.addCash(accountId,5000000l);
//        }
//        if(type.equals("3")){
//            accountSaveBO.addCash(accountId);
//            accountSaveBO.addGold(accountId);
//        }
//
//        response.addHeader("Access-Control-Allow-Origin", "*");
//        System.out.println(response);
//        return AjaxResult.succResult();
//    }
//
//
//    @RequestMapping("/userRegAccoutCashMoneyData")
//    @ResponseBody
//    public AjaxResult userRegAccoutCashMoneyData(HttpServletRequest request, HttpServletResponse response) {
//
//        String start =request.getParameter("start");
//        String end= request.getParameter("end");
//
//
//        for (Long i =Long.parseLong(start); i <= Long.parseLong(end); i++) {
//
//            String telephone = String.valueOf(i);
//            System.out.println(telephone);
//            String inviter = null;
//
//            if (null != request.getParameter("inviter")) {
//                inviter = request.getParameter("inviter");
//                userSaveBO.userRegist(telephone, inviter);
//            } else userSaveBO.userRegist(telephone);
//
//            String userId = userQueryBO.getUserByTelephone(telephone);
//            String accountId = userQueryBO.getAccountByTelephone(telephone);
//            System.out.println(accountId);
//
//            //实名认证,交易密码 登录密码 绑卡 建账户 加钱 加金
//            userSaveBO.setUserReal(userId);
//            userSaveBO.setUserPassReg(userId);
//            userSaveBO.setUserPassPay(userId);
//            userCardBO.setUserCardBase(accountId);
//            accountSaveBO.saveAccountBasic(userId, accountId);
//            accountSaveBO.addCash(accountId);
//            accountSaveBO.addGold(accountId);
//        }
//
//        response.addHeader("Access-Control-Allow-Origin", "*");
//        System.out.println(response);
//        return AjaxResult.succResult();
//        }
//
//}
//
//
//
//
//
