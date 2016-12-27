package com.righthere.user.server.dal.mapper;


import com.righthere.user.server.dal.dataobject.MerchantInfoDO;
import org.apache.ibatis.annotations.Param;


/**
 * Created by yayi.jyy on 2016/08/05.
 */


public interface MerchantInfoMapper {

    //使用accountId 查询商户信息
    public MerchantInfoDO getMerchantNameByAccountId(@Param("accountId") String accountId);

    public MerchantInfoDO getMerchantBasicByAccountId(@Param("accountId") String accountId);

    public MerchantInfoDO getMerchantAccountByAccountId(@Param("accountId") String accountId);

    //使用accountId 创建商户信息

    public void setMerchant(@Param("merchantCode") String merchantCode, @Param("merchantName") String merchantName, @Param("accountId") String accountId);

    public void setMerchantAccount(@Param("merchantCode") String merchantCode, @Param("accountId") String accountId);

    public void setMerchantSettle(@Param("merchantCode") String merchantCode);

}