/*
 * SysUserRelation.java
 
 * www.piaozhijia.com
 */
package com.pzj.customer.entity;

import java.io.Serializable;

import com.pzj.base.common.BaseVO;

/**
 * vo.供应商关系
 * 
 * @author 票之家
 */

public class CustomerRelation extends BaseVO implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = -5303800455965390932L;
    /** 供应商id */
    private Long userId;
    /** 关联供应商id */
    private Long relUserId;
    /** 关联类型（1供应商关系，2常用部门） */
    private String relType;

    /** 供应商名称 */
    private String userName;

    /** 关联供应商名称 */
    private String relUserName;

    /** 设置 供应商id */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /** 得到 供应商id */
    public Long getUserId() {
        return userId;
    }

    /** 设置 关联供应商id */
    public void setRelUserId(Long relUserId) {
        this.relUserId = relUserId;
    }

    /** 得到 关联供应商id */
    public Long getRelUserId() {
        return relUserId;
    }

    /** 设置 关联类型（1供应商关系，2常用部门） */
    public void setRelType(String relType) {
        this.relType = relType;
    }

    /** 得到 关联类型（1供应商关系，2常用部门） */
    public String getRelType() {
        return relType;
    }

    /**
     * 获取供应商名称
     * 
     * @return userName 供应商名称
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置供应商名称
     * 
     * @param userName
     *            供应商名称
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取关联供应商名称
     * 
     * @return relUserName 关联供应商名称
     */
    public String getRelUserName() {
        return relUserName;
    }

    /**
     * 设置关联供应商名称
     * 
     * @param relUserName
     *            关联供应商名称
     */
    public void setRelUserName(String relUserName) {
        this.relUserName = relUserName;
    }

    @Override
    public String toString() {
        StringBuilder strBuff = new StringBuilder();
        strBuff.append(this.getClass().getName() + ":{");
        strBuff.append("id:").append(this.getId()).append(",");
        strBuff.append("userId:").append(this.getUserId()).append(",");
        strBuff.append("relUserId:").append(this.getRelUserId()).append(",");
        strBuff.append("relType:").append(this.getRelType());
        strBuff.append("}");
        return strBuff.toString();
    }
}
