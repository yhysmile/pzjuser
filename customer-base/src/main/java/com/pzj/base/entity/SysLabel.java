package com.pzj.base.entity;

import java.util.Date;

import com.pzj.base.common.BaseEntity;

public class SysLabel extends BaseEntity {

    private static final long serialVersionUID = -3761010638044028113L;
    /**
     * 标签名称
     */
    private String            name;

    /**
     * 父id
     */
    private Long              pid;

    /**
     * 排序
     */
    private Integer           sort;

    /**
     * 介绍
     */
    private String            remarks;
    /**
     * 使用状态1启用0禁用2删除
     */
    private String            flag;

    /** 创建日期 */
    private Date              createDate;
    /** 更新日期 */
    private Date              updateDate;
    /** 更新人 */
    private String            updateBy;
    /** 创建人 */
    private String            createBy;

    /**
     * 数据来源
     */
    private String            dataSource;

    /**
     * 获取标签名称
     * 
     * @return name 标签名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置标签名称
     * 
     * @param name
     *            标签名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取父id
     * 
     * @return pid 父id
     */
    public Long getPid() {
        return pid;
    }

    /**
     * 设置父id
     * 
     * @param pid
     *            父id
     */
    public void setPid(Long pid) {
        this.pid = pid;
    }

    /**
     * 获取排序
     * 
     * @return sort 排序
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 设置排序
     * 
     * @param sort
     *            排序
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * 获取创建日期
     * 
     * @return createDate 创建日期
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 设置创建日期
     * 
     * @param createDate
     *            创建日期
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 获取更新日期
     * 
     * @return updateDate 更新日期
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * 设置更新日期
     * 
     * @param updateDate
     *            更新日期
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 获取更新人
     * 
     * @return updateBy 更新人
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * 设置更新人
     * 
     * @param updateBy
     *            更新人
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    /**
     * 获取创建人
     * 
     * @return createBy 创建人
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * 设置创建人
     * 
     * @param createBy
     *            创建人
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    /**
     * 获取介绍
     * 
     * @return remarks 介绍
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * 设置介绍
     * 
     * @param remarks
     *            介绍
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    /**
     * 获取使用状态1启用0禁用2删除
     * 
     * @return flag 使用状态1启用0禁用2删除
     */
    public String getFlag() {
        return flag;
    }

    /**
     * 设置使用状态1启用0禁用2删除
     * 
     * @param flag
     *            使用状态1启用0禁用2删除
     */
    public void setFlag(String flag) {
        this.flag = flag;
    }

    /**
     * 获取数据来源
     * 
     * @return dataSource 数据来源
     */
    public String getDataSource() {
        return dataSource;
    }

    /**
     * 设置数据来源
     * 
     * @param dataSource
     *            数据来源
     */
    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }

}
