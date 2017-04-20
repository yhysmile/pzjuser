package com.pzj.address.entity;

import java.util.Set;

/**
 * Created by Administrator on 2016-10-18.
 */
public class AddressParam extends Address {
    private Set<Long> ids;

    public Set<Long> getIds() {
        return ids;
    }

    public void setIds(Set<Long> ids) {
        this.ids = ids;
    }
}
