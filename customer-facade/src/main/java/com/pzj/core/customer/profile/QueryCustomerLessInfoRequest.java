package com.pzj.core.customer.profile;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017-3-29.
 */
public class QueryCustomerLessInfoRequest implements Serializable{
    /**
     * 用户id
     */
    private List<Long> ids;

    /**
     * 公司名
     */
    private String name;

    public List<Long> getIds() {
        return ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
