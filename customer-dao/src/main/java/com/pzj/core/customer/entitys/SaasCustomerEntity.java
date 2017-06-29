package com.pzj.core.customer.entitys;

import com.pzj.base.common.global.UserGlobalDict;

import java.util.Date;

/**
 * Created by mf-pc on 2017/6/27.
 */
public class SaasCustomerEntity extends CustomerEntity{
    /**
     * 企业logo
     */
    private String logo;
    /**
     * 排序
     */
    private Integer sort;
    /**
     *
     */
    private Integer leaderFlag;


    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getLeaderFlag() {
        return leaderFlag;
    }

    public void setLeaderFlag(Integer leaderFlag) {
        this.leaderFlag = leaderFlag;
    }

    public void setDefaultData(){
        if (null == this.getAccountState()) {
            this.setAccountState(Integer.valueOf(UserGlobalDict.passStatus()));
        }
        if (null == this.getLeaderFlag()) {
            this.setLeaderFlag(3);
        }
        if (null == this.getCreateDate()) {
            this.setCreateDate(new Date());
        }
        if (null == this.getSort()) {
            this.setSort(0);
        }
        if (null == this.getUserType()) {
            this.setUserType(UserGlobalDict.generUserType());
        }
        if (null == this.getIsRoot()) {
            this.setIsRoot(UserGlobalDict.mainAccount());
        }
    }
}
