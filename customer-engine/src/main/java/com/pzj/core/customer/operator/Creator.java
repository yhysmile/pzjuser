package com.pzj.core.customer.operator;

import com.pzj.core.customer.common.exception.CustomerException;
import com.pzj.core.customer.common.exception.CustomerExceptionCode;

import java.util.Date;

/**
 * Created by Administrator on 2017-5-26.
 */
public class Creator {
    private Long createUserId;

    private Date createDate;

    public Creator(Long createUserId){
        this(createUserId, new Date());
    }

    public Creator(Long createUserId, Date createDate){
        if (createUserId == null){
            throw new CustomerException(CustomerExceptionCode.OPERATOR_ID_NULL);
        }

        this.createUserId = createUserId;
        this.createDate = createDate;
    }

    public Long createUserId(){
        return createUserId;
    }

    public Date createDate(){
        return createDate;
    }
}
