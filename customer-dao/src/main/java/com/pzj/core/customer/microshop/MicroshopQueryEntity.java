package com.pzj.core.customer.microshop;

import java.io.Serializable;

/**
 * Created by Administrator on 2017-6-8.
 */
public class MicroshopQueryEntity implements Serializable{
    private Long id;

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
