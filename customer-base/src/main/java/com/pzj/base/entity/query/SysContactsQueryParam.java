package com.pzj.base.entity.query;

import com.pzj.base.entity.SysContacts;

import java.util.Set;

/**
 * 联系人查询参数
 * Created by wuliqing on 2016-10-11.
 */
public class SysContactsQueryParam extends SysContacts {
    private Set<Long> ids;

    private Set<Long> supplierIds;

    public Set<Long> getIds() {
        return ids;
    }

    public void setIds(Set<Long> ids) {
        this.ids = ids;
    }
    public Set<Long> getSupplierIds() {
        return supplierIds;
    }

    public void setSupplierIds(Set<Long> supplierIds) {
        this.supplierIds = supplierIds;
    }
}
