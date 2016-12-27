package com.righthere.user.server.controller;



import com.righthere.user.server.dal.dataobject.UserInfoDO;
import com.righthere.user.server.service.bo.UserInfoBO;

import com.righthere.user.server.service.bo.UserQueryBO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
* Created by yayi.jyy on 15-11-6.
*/

@Controller
@RequestMapping("/testserver/userInfo")
public class UserInfoController {
    @Resource
    private UserInfoBO userInfoBO;
    @Resource
    private UserQueryBO userQueryBO;

    @RequestMapping
    public String index(){
        return "/testserver/userInfo";
    }

    @RequestMapping("/getUserBasicInfo")
    @ResponseBody
    public JsonResult getUserBasicInfo(HttpServletRequest request, HttpServletResponse response) {

        String telephone = request.getParameter("telephone");
        String id = userInfoBO.getUserIdByTel(telephone);
        String accountId= userInfoBO.getAccountIdByTel(telephone);
        Date registTime = userInfoBO.getRegistTime(telephone);
        Integer openAccount = userInfoBO.getOpenAccount(telephone);
        Integer status = userInfoBO.getStatus(telephone);

        UserInfoDO userInfoDO = new UserInfoDO();
        userInfoDO.setUserId(id);
        userInfoDO.setAccountId(accountId);
        userInfoDO.setTelephone(telephone);
        userInfoDO.setRegistTime(registTime);
        userInfoDO.setCheckOpenAccount(openAccount);
        userInfoDO.setStatus(status);

        System.out.println(userInfoDO.getAccountId());
        response.addHeader("Access-Control-Allow-Origin", "*");
        JsonResult resultUserInfo = new JsonResult(true, null, userInfoDO);
        return resultUserInfo;

    }


    @RequestMapping("/getUserByTel")
    @ResponseBody
    public JsonResult getUserByTel(HttpServletRequest request, HttpServletResponse response) {

        String telephone = request.getParameter("telephone");
        String userId = userQueryBO.getUserByTelephone(telephone);
        String accountId = userQueryBO.getAccountByTelephone(telephone);

        response.addHeader("Access-Control-Allow-Origin", "*");
        UserInfoDO userInfoDO = new UserInfoDO();

        userInfoDO.setTelephone(telephone);
        userInfoDO.setUserId(userId);
        userInfoDO.setAccountId(accountId);
        response.addHeader("Access-Control-Allow-Origin", "*");
        JsonResult resultUserInfo = new JsonResult(true, null, userInfoDO);
        System.out.println(resultUserInfo);
        return resultUserInfo;
    }

    }

