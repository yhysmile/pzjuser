package com.pzj.core.customer.bankcard;

import com.pzj.core.customer.commons.exception.CustomerException;
import com.pzj.core.customer.commons.exception.CustomerExceptionCode;
import com.pzj.core.customer.profile.BankCardEntity;
import com.pzj.core.customer.read.BankCardReadMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017-3-3.
 */
@Component("bankCardReadEngine")
public class BankCardReadEngine {
    @Resource
    private BankCardReadMapper bankCardReadMapper;

    public BankCardEntity queryMicroshopBankCardByOwnerid(Long ownerId){
        if (ownerId == null){
            throw new CustomerException(CustomerExceptionCode.PARAMETER_EMPTY);
        }

        List<BankCardEntity> bankCardEntities = bankCardReadMapper.selectByOwnerId(ownerId);
        if (bankCardEntities != null && bankCardEntities.size() > 0){
            return bankCardEntities.get(0);
        } else {
            throw new CustomerException(CustomerExceptionCode.BANKCARD_NOT_EXIST);
        }
    }



}
