package com.pzj.core.customer.bankcard;

import java.io.Serializable;

/**
 * Created by Administrator on 2017-3-3.
 */
public class ModifyBankCardRequest implements Serializable{
    private Long id;
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
     * 创建人id
     */
    private Long operator;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Long getOperator() {
        return operator;
    }

    public void setOperator(Long operator) {
        this.operator = operator;
    }
}
