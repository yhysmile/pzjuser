package com.pzj.core.customer.entitys;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017-5-22.
 */
public class CustomerQuery extends CustomerEntity {
    /**
     * 用户ids
     */
    private List<Long> userIds;

    /**
     * 公司名或品牌名
     */
    private String nameOrNormal;
    /**
     * 公司名或联系或手机号
     */
    private String nameOrCorporaterOrMobile;

    /**
     * 用户关系类型
     */
    private String userRelType;

    /**
     * 查询类型  GlobalParam.QueryType
     */
    private Integer queryType;

    /**
     * 绑定时间开始点
     */
    private Date bindDateBegin;

    /**
     * 绑定时间结束点
     */
    private Date bindDateEnd;

    public List<Long> getUserIds() {
        return userIds;
    }

    public void setUserIds(List<Long> userIds) {
        this.userIds = userIds;
    }

    public Integer getQueryType() {
        return queryType;
    }

    public void setQueryType(Integer queryType) {
        this.queryType = queryType;
    }

    public Date getBindDateBegin() {
        return bindDateBegin;
    }

    public void setBindDateBegin(Date bindDateBegin) {
        this.bindDateBegin = bindDateBegin;
    }

    public Date getBindDateEnd() {
        return bindDateEnd;
    }

    public void setBindDateEnd(Date bindDateEnd) {
        this.bindDateEnd = bindDateEnd;
    }

    public String getUserRelType() {
        return userRelType;
    }

    public void setUserRelType(String userRelType) {
        this.userRelType = userRelType;
    }

    public String getNameOrNormal() {
        return nameOrNormal;
    }

    public void setNameOrNormal(String nameOrNormal) {
        this.nameOrNormal = nameOrNormal;
    }

    public String getNameOrCorporaterOrMobile() {
        return nameOrCorporaterOrMobile;
    }

    public void setNameOrCorporaterOrMobile(String nameOrCorporaterOrMobile) {
        this.nameOrCorporaterOrMobile = nameOrCorporaterOrMobile;
    }
}
