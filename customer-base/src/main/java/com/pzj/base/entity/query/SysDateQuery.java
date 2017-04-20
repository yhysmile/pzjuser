package com.pzj.base.entity.query;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;

public class SysDateQuery implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 647068207242940836L;

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

    @SuppressWarnings("rawtypes")
    public static String changeSQL(List<SysDateQuery> dateList, Class obj) {

        StringBuffer buff = new StringBuffer();
        if (dateList == null || dateList.isEmpty()) {
            return null;
        }
        Field[] fields = obj.getDeclaredFields();
        if (fields == null || fields.length == 0) {
            return null;
        }
        for (SysDateQuery vo : dateList) {
            String queryFieldName = vo.getQueryFieldName();
            Date startDate = vo.getStartDate();
            Date endDate = vo.getEndDate();
            if (StringUtils.isBlank(queryFieldName)) {
                continue;
            }
            for (Field f : fields) {
                String fieldName = f.getName();
                if (queryFieldName.equals(fieldName)) {
                    if (startDate != null) {
                        buff.append(" and FROM_UNIXTIME(").append(fieldName)
                                .append(") >=").append(startDate.getTime());
                    }
                    if (endDate != null) {
                        buff.append(" and FROM_UNIXTIME(").append(fieldName)
                                .append(") <=").append(endDate.getTime());
                    }

                }
            }
        }

        return buff.toString();

    }

}
