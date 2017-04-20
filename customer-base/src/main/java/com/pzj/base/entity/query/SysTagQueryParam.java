package com.pzj.base.entity.query;

import com.pzj.base.entity.SysTag;

import java.util.Set;

/**
 * Created by Administrator on 2016-11-8.
 */
public class SysTagQueryParam extends SysTag {
    private Set<Long> ids;

    private Set<String> names;

    public Set<Long> getIds() {
        return ids;
    }

    public void setIds(Set<Long> ids) {
        this.ids = ids;
    }

    public Set<String> getNames() {
        return names;
    }

    public void setNames(Set<String> names) {
        this.names = names;
    }
}
