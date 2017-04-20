package com.pzj.base.entity.product.query;

import java.io.Serializable;
import java.util.Date;

public class DateQuery implements Serializable {

    /**查询时间段：开始时间*/
    private Date startDate;

    /**查询时间段：结束时间*/
    private Date endDate;

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

}
