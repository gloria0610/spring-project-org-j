package com.righthere.user.server.service.bo;

import com.righthere.user.server.dal.dataobject.UserInfoDO;
import com.righthere.user.server.dal.mapper.UserInfoMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;


/**
* Created by yayi.jyy
 * 查询用户信息服务
*/

@Service("merchantInfoBO")
public class MerchantInfoBO {
    @Resource
    private UserInfoMapper userInfoMapper;

    public String getUserIdByTel (String telephone){
        return userInfoMapper.getUserIdByTel(telephone);
    }
    public String getAccountIdByTel(String telephone){
        return userInfoMapper.getAccountIdByTel(telephone);
    }

    public Date getRegistTime(String telephone){
        return userInfoMapper.getRegistTime(telephone);
    }

    public Integer getOpenAccount(String telephone){
        return userInfoMapper.getOpenAccount(telephone);
    }

    public Integer getStatus(String telephone){
        return userInfoMapper.getStatus(telephone);
    }

    public UserInfoDO getUserInfo(String telephone){
        return userInfoMapper.getUserInfo(telephone);
    }
}
