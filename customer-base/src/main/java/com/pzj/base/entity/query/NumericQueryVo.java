package com.pzj.base.entity.query;

public class NumericQueryVo {

    /** 大于等于 */
    private Double lowerNumeric;
    /** 小于等于 */
    private Double higherNumeric;
    /** 查询的字段名字 */
    private String queryFieldName;

    public NumericQueryVo(String queryFieldName, Double lowerNumeric, Double higherNumeric) {
        this.queryFieldName = queryFieldName;
        this.lowerNumeric = lowerNumeric;
        this.higherNumeric = higherNumeric;
    }

    /**
     * 获取大于等于
     * 
     * @return lowerNumeric 大于等于
     */
    public Double getLowerNumeric() {
        return lowerNumeric;
    }

    /**
     * 设置大于等于
     * 
     * @param lowerNumeric
     *            大于等于
     */
    public void setLowerNumeric(Double lowerNumeric) {
        this.lowerNumeric = lowerNumeric;
    }

    /**
     * 获取小于等于
     * 
     * @return higherNumeric 小于等于
     */
    public Double getHigherNumeric() {
        return higherNumeric;
    }

    /**
     * 设置小于等于
     * 
     * @param higherNumeric
     *            小于等于
     */
    public void setHigherNumeric(Double higherNumeric) {
        this.higherNumeric = higherNumeric;
    }

    /**
     * 获取查询的字段名字
     * 
     * @return queryFieldName 查询的字段名字
     */
    public String getQueryFieldName() {
        return queryFieldName;
    }

    /**
     * 设置查询的字段名字
     * 
     * @param queryFieldName
     *            查询的字段名字
     */
    public void setQueryFieldName(String queryFieldName) {
        this.queryFieldName = queryFieldName;
    }

}
