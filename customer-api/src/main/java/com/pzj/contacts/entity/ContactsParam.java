package com.pzj.contacts.entity;

import java.util.Set;

/**
 * Created by Administrator on 2016-10-12.
 */
public class ContactsParam extends Contacts {
    private Set<Long> ids;

    public Set<Long> getIds() {
        return ids;
    }

    public void setIds(Set<Long> ids) {
        this.ids = ids;
    }
}
