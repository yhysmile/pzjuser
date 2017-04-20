package com.pzj.core.customer.profile;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017-2-27.
 */
public class CreateManyCustomerRequest implements Serializable {
    private List<CreateCustomerRequest> createCustomerRequests;

    private Long createBy;

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public List<CreateCustomerRequest> getCreateCustomerRequests() {
        return createCustomerRequests;
    }

    public void setCreateCustomerRequests(List<CreateCustomerRequest> createCustomerRequests) {
        this.createCustomerRequests = createCustomerRequests;
    }
}
