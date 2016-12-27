package com.righthere.user.server.dal.dataobject;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by jiangyayi on 16/8/5.
 */

public class MerchantInfoDO implements Serializable

    {
        private String id;
        private String merchantCode;
        private String merchantName;
        private String accountId;
        private String description;
        private Integer status;
        private Date creatTime;
        private Date updateTime;
        private String signKey;
        private String licenceNo;
        private String contractNo;
        private String legalPerson;
        private String bankCode;
        private String bankCodeNo;
        private String checkFileEmail;
        private Long rate;
        private Long buyFee;
        private Long saleFee;
        private Long taxFeeRate;
        private Long processFeeRate;
        private Long insuranceFeeRate;
        private Long expressFeeRate;
        private Long insuranceFeeWave;
        private Long totalMoney;
        private Long totalGoldWeight;
        private Long totalFinanceMoney;


        public void setAccountId(String accountId) {
            this.accountId = accountId;
        }

        public void setBankCode(String bankCode) {
            this.bankCode = bankCode;
        }

        public void setBuyFee(Long buyFee) {
            this.buyFee = buyFee;
        }

        public void setCheckFileEmail(String checkFileEmail) {
            this.checkFileEmail = checkFileEmail;
        }

        public void setContractNo(String contractNo) {
            this.contractNo = contractNo;
        }

        public void setCreatTime(Date creatTime) {
            this.creatTime = creatTime;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public void setExpressFeeRate(Long expressFeeRate) {
            this.expressFeeRate = expressFeeRate;
        }

        public void setId(String id) {
            this.id = id;
        }

        public void setInsuranceFeeRate(Long insuranceFeeRate) {
            this.insuranceFeeRate = insuranceFeeRate;
        }

        public void setInsuranceFeeWave(Long insuranceFeeWave) {
            this.insuranceFeeWave = insuranceFeeWave;
        }

        public void setLegalPerson(String legalPerson) {
            this.legalPerson = legalPerson;
        }

        public String getSignKey() {
            return signKey;
        }

        public void setLicenceNo(String licenceNo) {
            this.licenceNo = licenceNo;
        }

        public void setMerchantCode(String merchantCode) {
            this.merchantCode = merchantCode;
        }

        public void setMerchantName(String merchantName) {
            this.merchantName = merchantName;
        }

        public void setProcessFeeRate(Long processFeeRate) {
            this.processFeeRate = processFeeRate;
        }

        public void setRate(Long rate) {
            this.rate = rate;
        }

        public void setSaleFee(Long saleFee) {
            this.saleFee = saleFee;
        }

        public void setSignKey(String signKey) {
            this.signKey = signKey;
        }

        public void setStatus(Integer status) {
            this.status = status;
        }

        public void setTaxFeeRate(Long taxFeeRate) {
            this.taxFeeRate = taxFeeRate;
        }

        public void setUpdateTime(Date updateTime) {
            this.updateTime = updateTime;
        }

        public Date getCreatTime() {
            return creatTime;
        }

        public Date getUpdateTime() {
            return updateTime;
        }

        public Integer getStatus() {
            return status;
        }

        public Long getBuyFee() {
            return buyFee;
        }

        public Long getExpressFeeRate() {
            return expressFeeRate;
        }

        public Long getInsuranceFeeRate() {
            return insuranceFeeRate;
        }

        public Long getInsuranceFeeWave() {
            return insuranceFeeWave;
        }

        public Long getProcessFeeRate() {
            return processFeeRate;
        }

        public Long getRate() {
            return rate;
        }

        public Long getSaleFee() {
            return saleFee;
        }

        public Long getTaxFeeRate() {
            return taxFeeRate;
        }

        public String getAccountId() {
            return accountId;
        }

        public String getBankCode() {
            return bankCode;
        }

        public String getCheckFileEmail() {
            return checkFileEmail;
        }

        public String getContractNo() {
            return contractNo;
        }

        public String getDescription() {
            return description;
        }

        public String getId() {
            return id;
        }

        public String getLegalPerson() {
            return legalPerson;
        }

        public String getLicenceNo() {
            return licenceNo;
        }

        public String getMerchantCode() {
            return merchantCode;
        }

        public String getMerchantName() {
            return merchantName;
        }

        public String getMerchantBasicByAccountId() {
            return accountId ;
        }
    }


