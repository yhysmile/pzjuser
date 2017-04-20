package com.pzj.service.Impl;

import org.springframework.stereotype.Service;

import com.pzj.core.customer.bankcard.*;
import com.pzj.core.customer.profile.BankCardEntity;
import com.pzj.framework.context.Result;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017-3-3.
 */
@Service("bankCardServiceImpl")
public class BankCardServiceImpl implements BankCardService {
    @Resource
    private BankCardReadEngine bankCardReadEngine;
    @Resource
    private BankCardWriteEngine bankCardWriteEngine;


    @Override
    public Result<BankCardDetailResponse> queryMicroshopBankCardByOwnerid(Long ownerId) {
        Result<BankCardDetailResponse> result = new Result<>();
        try {
            BankCardEntity entity = this.bankCardReadEngine.queryMicroshopBankCardByOwnerid(ownerId);

            BankCardDetailResponse response = convert(entity);
            result.setData(response);
        } catch (Throwable throwable){
            RpcCaller.catchThrowableAndCustomerException(result, throwable);
        }
        return result;
    }

    private BankCardDetailResponse convert(BankCardEntity entity){
        if (entity == null){
            return null;
        }
        BankCardDetailResponse response = new BankCardDetailResponse();
        response.setId(entity.getId());
        response.setAccountHolder(entity.getAccountHolder());
        response.setBank(entity.getBank());
        response.setIdNum(entity.getIdNum());
        response.setCardNum(entity.getCardNum());
        return response;
    }

    @Override
    public Result<Long> createMicroshopBankCard(CreateBankCardRequest request) {
        Result<Long> result = new Result<>();
        try {
            BankCardEntity entity = convert(request);

            Long newId = this.bankCardWriteEngine.createMicroshopBankCard(entity);

            result.setData(newId);
        } catch (Throwable throwable){
            RpcCaller.catchThrowableAndCustomerException(result, throwable);
        }
        return result;
    }

    private BankCardEntity convert(CreateBankCardRequest request){
        if (request == null){
            return null;
        }

        BankCardEntity entity = new BankCardEntity();
        entity.setAccountHolder(request.getAccountHolder());
        entity.setBank(request.getBank());
        entity.setIdNum(request.getIdNum());
        entity.setCardNum(request.getCardNum());
        entity.setCreateBy(request.getOperator());
        entity.setDataSource(request.getDataSource());
        return entity;
    }

    @Override
    public Result<Boolean> modifyMicroshopBankCard(ModifyBankCardRequest request) {
        Result<Boolean> result = new Result<>();
        try {
            BankCardEntity entity = convert(request);

            Boolean modify = this.bankCardWriteEngine.modifyMicroshopBankCard(entity);

            result.setData(modify);
        } catch (Throwable throwable){
            RpcCaller.catchThrowableAndCustomerException(result, throwable);
        }
        return result;
    }

    private BankCardEntity convert(ModifyBankCardRequest request){
        if (request == null){
            return null;
        }

        BankCardEntity entity = new BankCardEntity();
        entity.setAccountHolder(request.getAccountHolder());
        entity.setBank(request.getBank());
        entity.setIdNum(request.getIdNum());
        entity.setCardNum(request.getCardNum());
        entity.setUpdateBy(request.getOperator());
        entity.setId(request.getId());
        return entity;
    }
}
