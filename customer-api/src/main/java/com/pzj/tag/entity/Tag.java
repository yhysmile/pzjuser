package com.pzj.tag.entity;

import com.pzj.util.CommonEntity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2016-11-7.
 */
public class Tag extends CommonEntity implements Serializable {
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public Date getCreateDate() {
        return createDate;
    }

    @Override
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
