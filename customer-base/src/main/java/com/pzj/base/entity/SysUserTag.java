package com.pzj.base.entity;

import com.pzj.base.common.BaseDataSourceEntity;
import com.pzj.base.common.BaseEntity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2016-11-7.
 */
public class SysUserTag extends BaseDataSourceEntity implements Serializable {
    private Long userId;
    private Long tagId;
    /**
     * 类型
     */
    private Integer type;
    private Date createDate;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getTagId() {
        return tagId;
    }

    public void setTagId(Long tagId) {
        this.tagId = tagId;
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
