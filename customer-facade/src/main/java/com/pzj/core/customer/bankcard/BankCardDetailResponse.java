package com.pzj.core.customer.bankcard;

import java.io.Serializable;

/**
 * Created by Administrator on 2017-3-3.
 */
public class BankCardDetailResponse implements Serializable {
    /**
     * 逻辑主键
     */
    private Long id;
    /**
     * 拥有者id（主账号id）
     */
    private Long ownerId;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
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
}
