package com.pzj.base.entity;

import com.pzj.base.common.BaseEntity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2016-11-29.
 */
public class SysUserDraft extends BaseEntity implements Serializable {
    private Long userId;

    private Long createBy;

    private Date createDate;

    private Integer checkType;

    private Long checkUserId;

    private Integer checkStatus;

    private Date checkDate;

    private String reasonsForRefusal;

    private String draftData;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public Integer getCheckType() {
        return checkType;
    }

    public void setCheckType(Integer checkType) {
        this.checkType = checkType;
    }

    public Long getCheckUserId() {
        return checkUserId;
    }

    public void setCheckUserId(Long checkUserId) {
        this.checkUserId = checkUserId;
    }

    public Integer getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(Integer checkStatus) {
        this.checkStatus = checkStatus;
    }

    public Date getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(Date checkDate) {
        this.checkDate = checkDate;
    }

    public String getReasonsForRefusal() {
        return reasonsForRefusal;
    }

    public void setReasonsForRefusal(String reasonsForRefusal) {
        this.reasonsForRefusal = reasonsForRefusal;
    }

    public String getDraftData() {
        return draftData;
    }

    public void setDraftData(String draftData) {
        this.draftData = draftData;
    }
}
