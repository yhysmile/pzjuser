package com.pzj.core.customer.profile;

import java.io.Serializable;

/**
 * Created by Administrator on 2017-3-29.
 */
public class QueryCustomerLessInfoResponse implements Serializable {
    /**
     * id
     */
    private Long id;

    /**
     * 公司名
     */
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
