package com.pzj.base.entity;

import com.pzj.base.common.BaseEntity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2016-11-7.
 */
public class SysTag extends BaseEntity implements Serializable {

    /**
     * 名称
     */
    private String name;

    /**
     * 类型
     */
    private Integer type;

    /**
     * 创建时间
     */
    private Date createDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
