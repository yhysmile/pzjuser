package com.pzj.core.customer.operator;

import com.pzj.core.customer.common.exception.CustomerException;
import com.pzj.core.customer.common.exception.CustomerExceptionCode;

import java.util.Date;

/**
 * Created by Administrator on 2017-5-26.
 */
public class Modifier {
    private Long modifyUserId;

    private Date modifyDate;

    public Modifier(Long modifyUserId){
        this(modifyUserId, new Date());
    }

    public Modifier(Long modifyUserId , Date modifyDate){
        if (modifyUserId == null){
            throw new CustomerException(CustomerExceptionCode.OPERATOR_ID_NULL);
        }

        this.modifyUserId = modifyUserId;
        this.modifyDate = modifyDate;
    }


    public Long modifyUserId() {
        return modifyUserId;
    }
    public Date modifyDate() {
        return modifyDate;
    }
}
