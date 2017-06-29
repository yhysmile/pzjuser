package com.pzj.core.customer.entitys;

import java.io.Serializable;
import java.util.Date;

/**
 * 银行卡查询条件
 * Created by Administrator on 2017-3-3.
 */
public class BankCardQueryParam implements Serializable {
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
    /**
     * 创建人id
     */
    private Long createBy;
    /**
     * 创建时间开始
     */
    private Date createDateBegin;
    /**
     * 创建时间结束
     */
    private Date createDateEnd;

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

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public Date getCreateDateBegin() {
        return createDateBegin;
    }

    public void setCreateDateBegin(Date createDateBegin) {
        this.createDateBegin = createDateBegin;
    }

    public Date getCreateDateEnd() {
        return createDateEnd;
    }

    public void setCreateDateEnd(Date createDateEnd) {
        this.createDateEnd = createDateEnd;
    }
}
