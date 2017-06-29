package com.pzj.core.customer.microshop;

/**
 * Created by Administrator on 2017-6-8.
 */
public class MicroshopInfo extends MicroshopContent{
    /**
     * 微店id
     */
    private Long id;
    /**
     * 所属用户id
     */
    private Long masterId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMasterId() {
        return masterId;
    }

    public void setMasterId(Long masterId) {
        this.masterId = masterId;
    }
}
