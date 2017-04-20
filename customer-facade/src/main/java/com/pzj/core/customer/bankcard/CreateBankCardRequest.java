package com.pzj.core.customer.bankcard;

import java.io.Serializable;

/**
 * Created by Administrator on 2017-3-3.
 */
public class CreateBankCardRequest implements Serializable {
    /**
     * 开户人
     */
    private String accountHolder;
    /**
     * 身份证号
     */
    private String idNum;
    /**
     * 银行名称
     */
    private String bank;
    /**
     * 银行卡号
     */
    private String cardNum;
    /**
     * 创建系统
     */
    private Integer dataSource;
    /**
     * 创建人id
     */
    private Long operator;

    public String getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    public String getIdNum() {
        return idNum;
    }

    public void setIdNum(String idNum) {
        this.idNum = idNum;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public Integer getDataSource() {
        return dataSource;
    }

    public void setDataSource(Integer dataSource) {
        this.dataSource = dataSource;
    }

    public Long getOperator() {
        return operator;
    }

    public void setOperator(Long operator) {
        this.operator = operator;
    }
}
