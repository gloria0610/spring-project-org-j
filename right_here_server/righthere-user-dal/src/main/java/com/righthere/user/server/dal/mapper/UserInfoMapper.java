package com.righthere.user.server.dal.mapper;


import com.righthere.user.server.dal.dataobject.UserInfoDO;
import org.apache.ibatis.annotations.Param;

import java.util.Date;


/**
 * Created by yayi.jyy on 2016/08/05.
 */


public interface UserInfoMapper {

    //使用telephone 取userbasic用户信息

    public String getUserIdByTel(@Param("telephone") String telephone);

    public String getAccountIdByTel(@Param("telephone") String telephone);

    public Date getRegistTime(@Param("telephone") String telephone);

    public Integer getOpenAccount(@Param("telephone") String telephone);

    public Integer getStatus(@Param("telephone") String telephone);

    public UserInfoDO getUserInfo(@Param("telephone") String telephone);

}