package com.pzj.core.customer.bankcard;

import com.pzj.core.customer.common.exception.CustomerException;
import com.pzj.core.customer.common.exception.CustomerExceptionCode;
import com.pzj.core.customer.entitys.BankCardEntity;
import com.pzj.core.customer.entitys.CustomerEntity;
import com.pzj.core.customer.write.BankCardWriteMapper;
import com.pzj.core.customer.write.CustomerWriteMapper;
import com.pzj.framework.idgen.IDGenerater;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by Administrator on 2017-3-3.
 */
@Component("bankCardWriteEngine")
public class BankCardWriteEngine {
    @Resource
    private BankCardWriteMapper bankCardWriteMapper;

    @Resource
    private CustomerWriteMapper customerWriteMapper;

    @Resource
    private IDGenerater idGenerater;

    private CustomerEntity getCustomerById(Long id){
        CustomerEntity operatorEntity = customerWriteMapper.selectById(id);
        return operatorEntity;
    }

    private BankCardEntity getBankCardById(Long id){
        BankCardEntity originalBankCardEntity = bankCardWriteMapper.selectById(id);
        return originalBankCardEntity;
    }

    /**
     *
     * @param bankCardEntity
     * @return
     */
    public Long createMicroshopBankCard(BankCardEntity bankCardEntity) {
        // 数据非空校验
        nonEmptyCheckForCreate(bankCardEntity);

        CustomerEntity operatorEntity = getCustomerById(bankCardEntity.getCreateBy());

        // 其它字段初始化
        initOtherFieldsForCreate(bankCardEntity, operatorEntity);

        // 执行插入
        int insert = bankCardWriteMapper.insert(bankCardEntity);

        if (insert == 1)
            return bankCardEntity.getId();

        return null;
    }

    /*
    创建银行卡时，验校一些非空字段
     */
    private void nonEmptyCheckForCreate(BankCardEntity entity){
        if (entity == null){
            throw new CustomerException(CustomerExceptionCode.PARAMETER_EMPTY);
        }
        if (entity.getAccountHolder() == null){
            throw new CustomerException(CustomerExceptionCode.BANKCARD_NULL_ACCOUNT_HOLDER);
        }
        if (entity.getBank() == null){
            throw new CustomerException(CustomerExceptionCode.BANKCARD_NULL_BANK);
        }
        if (entity.getIdNum() == null){
            throw new CustomerException(CustomerExceptionCode.BANKCARD_NULL_ID_NUM);
        }
        if (entity.getCardNum() == null){
            throw new CustomerException(CustomerExceptionCode.BANKCARD_NULL_CARD_NUM);
        }
        if (entity.getDataSource() == null){
            throw new CustomerException(CustomerExceptionCode.DATASOURCE_EMPTY);
        }
        if (entity.getCreateBy() == null){
            throw new CustomerException(CustomerExceptionCode.OPERATOR_NULL);
        }
    }

    /*
    创建银行卡时，初始化一些其它字段数据
     */
    private void initOtherFieldsForCreate(BankCardEntity bankCardEntity, CustomerEntity operatorEntity){
        long newId = idGenerater.nextId();
        bankCardEntity.setId(newId);
        Long ownerId = ownerIdOf(operatorEntity);
        bankCardEntity.setOwnerId(ownerId);
        bankCardEntity.setCreateDate(new Date());
    }

    /*
    获取某用户的主账号id
     */
    private Long ownerIdOf(CustomerEntity customerEntity){
        if ("1".equals(customerEntity.getIsRoot())){
            return customerEntity.getId();
        } else {
            return customerEntity.getSupplierId();
        }
    }

    /**
     *
     * @param bankCardEntity
     * @return
     */
    public Boolean modifyMicroshopBankCard(BankCardEntity bankCardEntity) {
        // 数据非空校验
        nonEmptyCheckForModify(bankCardEntity);

        BankCardEntity originalBankCardEntity = getBankCardById(bankCardEntity.getId());

        CustomerEntity operatorEntity = getCustomerById(bankCardEntity.getUpdateBy());

        // 操作人修改权限校验
        ruleCheckForModify(originalBankCardEntity, operatorEntity);

        // 其它字段初始化
        initOtherFieldsForModify(bankCardEntity);

        // 执行更新
        int insert = bankCardWriteMapper.update(bankCardEntity);

        return insert == 1;
    }

    private void nonEmptyCheckForModify(BankCardEntity entity){
        if (entity == null){
            throw new CustomerException(CustomerExceptionCode.PARAMETER_EMPTY);
        }
        if (entity.getId() == null){
            throw new CustomerException(CustomerExceptionCode.BANKCARD_NULL_ID);
        }
        if (entity.getUpdateBy() == null){
            throw new CustomerException(CustomerExceptionCode.OPERATOR_NULL);
        }

        // 是否存在可更新的数据
        boolean existModifyData = false;

        if (entity.getAccountHolder() != null){
            existModifyData = true;
        }
        if (entity.getBank() != null){
            existModifyData = true;
        }
        if (entity.getIdNum() != null){
            existModifyData = true;
        }
        if (entity.getCardNum() != null){
            existModifyData = true;
        }
        if (!existModifyData){
            throw new CustomerException(CustomerExceptionCode.MODIFY_DATA_EMPTY);
        }
    }

    /*
    修改银行卡时，按一些规则校验
     */
    private void ruleCheckForModify(BankCardEntity bankCardEntity, CustomerEntity operatorEntity) {
        Long ownerIdOfBankCard = bankCardEntity.getOwnerId();
        Long ownerIdOfOperator = ownerIdOf(operatorEntity);
        if (!(ownerIdOfBankCard != null && ownerIdOfOperator != null
                && ownerIdOfBankCard.equals(ownerIdOfOperator))){
            throw new CustomerException(CustomerExceptionCode.OPERATOR_SUPPLIER_MISMATCH);
        }
    }

    private void initOtherFieldsForModify(BankCardEntity bankCardEntity){
        bankCardEntity.setUpdateDate(new Date());
    }
}
