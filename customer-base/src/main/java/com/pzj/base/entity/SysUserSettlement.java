package com.pzj.base.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2016-3-29.
 */
public class SysUserSettlement implements Serializable {
    private static final long serialVersionUID = -2818459245002477416L;
    /**
     * 核算单位
     * <p/>
     * 相关常量查阅{@link com.pzj.base.common.global.SettlementDict.AccountingUnit}
     */
    private Long              accountingUnit;

    /**
     * 新加字段
     */
    private String            accountingUnitName;
    /**
     * 供应商能否开票
     * <p/>
     * 相关常量查阅{@link com.pzj.base.common.global.SettlementDict.SupplierBillingMode}
     */
    private Integer           supplierBillingMode;
    /**
     * 供应商佣金支付方式
     * <p/>
     * 相关常量查阅{@link com.pzj.base.common.global.SettlementDict.PayMode}
     */
    private Integer           supplierCreditPayMode;
    /**
     * 供应商平台支付方式
     * <p/>
     * 相关常量查阅{@link com.pzj.base.common.global.SettlementDict.PayMode}
     */
    private Integer           supplierPlatformPayMode;

    /**
     * 交易服务费费用类型
     */
    private Integer           supplierTradeServiceFeeType;
    /**
     * 交易服务费费用（百分比/金额）
     */
    private Double            supplierTradeServiceFee;
    /**
     * 整体统一支付信息说明
     */
    private String            supplierTradeServiceRemark;
    /**
     * 服务费结算周期
     */
    private Integer           supplierServiceFeePeriod;
    /**
     * 佣金结算周期
     */
    private Integer           supplierBrokeragePeriod;

    /**
     * 货币类型
     */
    private Integer           currencyType;

    /**
     * 交易服务费收款方
     *
     * 相关常量查阅{@link com.pzj.base.common.global.SettlementDict.AccountingUnit}
     */
    private Integer tradePayee;

    public Long getAccountingUnit() {
        return accountingUnit;
    }

    public void setAccountingUnit(Long accountingUnit) {
        this.accountingUnit = accountingUnit;
    }

    public Integer getSupplierBillingMode() {
        return supplierBillingMode;
    }

    public void setSupplierBillingMode(Integer supplierBillingMode) {
        this.supplierBillingMode = supplierBillingMode;
    }

    public Integer getSupplierCreditPayMode() {
        return supplierCreditPayMode;
    }

    public void setSupplierCreditPayMode(Integer supplierCreditPayMode) {
        this.supplierCreditPayMode = supplierCreditPayMode;
    }

    public Integer getSupplierPlatformPayMode() {
        return supplierPlatformPayMode;
    }

    public void setSupplierPlatformPayMode(Integer supplierPlatformPayMode) {
        this.supplierPlatformPayMode = supplierPlatformPayMode;
    }

    public Integer getSupplierTradeServiceFeeType() {
        return supplierTradeServiceFeeType;
    }

    public void setSupplierTradeServiceFeeType(Integer supplierTradeServiceFeeType) {
        this.supplierTradeServiceFeeType = supplierTradeServiceFeeType;
    }

    public Double getSupplierTradeServiceFee() {
        return supplierTradeServiceFee;
    }

    public void setSupplierTradeServiceFee(Double supplierTradeServiceFee) {
        this.supplierTradeServiceFee = supplierTradeServiceFee;
    }

    public String getSupplierTradeServiceRemark() {
        return supplierTradeServiceRemark;
    }

    public void setSupplierTradeServiceRemark(String supplierTradeServiceRemark) {
        this.supplierTradeServiceRemark = supplierTradeServiceRemark;
    }

    public Integer getSupplierServiceFeePeriod() {
        return supplierServiceFeePeriod;
    }

    public void setSupplierServiceFeePeriod(Integer supplierServiceFeePeriod) {
        this.supplierServiceFeePeriod = supplierServiceFeePeriod;
    }

    public Integer getSupplierBrokeragePeriod() {
        return supplierBrokeragePeriod;
    }

    public void setSupplierBrokeragePeriod(Integer supplierBrokeragePeriod) {
        this.supplierBrokeragePeriod = supplierBrokeragePeriod;
    }

    public Integer getCurrencyType() {
        return currencyType;
    }

    public void setCurrencyType(Integer currencyType) {
        this.currencyType = currencyType;
    }

    public String getAccountingUnitName() {
        return accountingUnitName;
    }

    public void setAccountingUnitName(String accountingUnitName) {
        this.accountingUnitName = accountingUnitName;
    }

    public Integer getTradePayee() {
        return tradePayee;
    }

    public void setTradePayee(Integer tradePayee) {
        this.tradePayee = tradePayee;
    }
}
