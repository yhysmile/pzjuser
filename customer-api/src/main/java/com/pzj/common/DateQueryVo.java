package com.pzj.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.pzj.base.entity.query.SysDateQuery;

public class DateQueryVo implements Serializable {
    /** 查询开始时间 */
    private Date startDate;
    /** 查询结束时间 */
    private Date endDate;
    /** 查询的字段名字 */
    private String queryFieldName;

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

    /**
     * 获取查询的时间字段
     * 
     * @return queryFieldName 查询的时间字段
     */
    public String getQueryFieldName() {
        return queryFieldName;
    }

    /**
     * 设置查询的时间字段
     * 
     * @param queryFieldName
     *            查询的时间字段
     */
    public void setQueryFieldName(String queryFieldName) {
        this.queryFieldName = queryFieldName;
    }

    public static SysDateQuery changeTSysBean(DateQueryVo vo) throws Exception {

        SysDateQuery dateQuery = new SysDateQuery();
        dateQuery.setStartDate(vo.getStartDate());
        dateQuery.setEndDate(vo.getEndDate());
        dateQuery.setQueryFieldName(vo.getQueryFieldName());

        return dateQuery;
    }

    public static DateQueryVo changeTAPIBean(SysDateQuery bean)
            throws Exception {
        DateQueryVo vo = new DateQueryVo();

        bean.setStartDate(vo.getEndDate());
        bean.setEndDate(vo.getEndDate());
        bean.setQueryFieldName(vo.getQueryFieldName());
        return vo;
    }

    public static List<SysDateQuery> cList2SList(List<DateQueryVo> voList)
            throws Exception {
        List<SysDateQuery> List = null;
        if (voList != null) {
            List = new ArrayList<SysDateQuery>();
            for (DateQueryVo vo : voList) {
                SysDateQuery sysBean = changeTSysBean(vo);
                List.add(sysBean);
            }
        }
        return List;
    }

    public static List<DateQueryVo> sList2CList(List<SysDateQuery> sysList)
            throws Exception {
        List<DateQueryVo> list = null;
        if (sysList != null) {
            list = new ArrayList<DateQueryVo>();
            for (SysDateQuery bean : sysList) {
                DateQueryVo vo = changeTAPIBean(bean);
                list.add(vo);
            }
        }
        return list;
    }
}
