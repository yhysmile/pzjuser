package com.pzj.base.entity.query;

import com.pzj.base.entity.SysAddress;

import java.util.Set;

/**
 * 联系人查询参数
 * Created by wuliqing on 2016-10-11.
 */
public class SysAddressQueryParam extends SysAddress {
    private Set<Long> ids;

    public Set<Long> getIds() {
        return ids;
    }

    public void setIds(Set<Long> ids) {
        this.ids = ids;
    }
}
