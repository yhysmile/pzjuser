package com.pzj.core.customer.profile;

import java.io.Serializable;
import java.util.Date;

/**
 * 银行卡实体
 * Created by Administrator on 2017-3-3.
 */
public class BankCardEntity implements Serializable{
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
     * 创建系统
     */
    private Integer dataSource;
    /**
     * 创建人id
     */
    private Long createBy;
    /**
     * 创建时间
     */
    private Date createDate;
    /**
     * 更新人id
     */
    private Long updateBy;
    /**
     * 更新时间
     */
    private Date updateDate;

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

    public Integer getDataSource() {
        return dataSource;
    }

    public void setDataSource(Integer dataSource) {
        this.dataSource = dataSource;
    }

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Long getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
