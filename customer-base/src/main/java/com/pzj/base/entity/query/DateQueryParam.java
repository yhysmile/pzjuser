package com.pzj.base.entity.query;

import java.io.Serializable;
import java.util.Date;

public class DateQueryParam implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = -4156699581014090057L;

    /** 查询开始时间 */
    private Date startDate;

    /** 查询结束时间 */
    private Date endDate;

    /**
     * 获取查询开始时间
     * 
     * @return startDate 查询开始时间
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * 设置查询开始时间
     * 
     * @param startDate
     *            查询开始时间
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * 获取查询结束时间
     * 
     * @return endDate 查询结束时间
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * 设置查询结束时间
     * 
     * @param endDate
     *            查询结束时间
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

}
