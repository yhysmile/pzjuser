package com.pzj.core.customer.profile.event;

import com.pzj.core.customer.common.work.support.AbstractEvent;

import java.util.Date;

/**
 * Created by Administrator on 2017-6-6.
 */
public class UnbindDirectDistributorEvent extends AbstractEvent {
    private Long supplierId;
    private Long distributorId;
    private Long operatorId;
    private Date operatingDate;

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public Long getDistributorId() {
        return distributorId;
    }

    public void setDistributorId(Long distributorId) {
        this.distributorId = distributorId;
    }

    public Long getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Long operatorId) {
        this.operatorId = operatorId;
    }

    public Date getOperatingDate() {
        return operatingDate;
    }

    public void setOperatingDate(Date operatingDate) {
        this.operatingDate = operatingDate;
    }
}
