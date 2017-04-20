package com.pzj.service.Impl;

import java.util.*;

import com.pzj.base.common.UserServiceException;
import com.pzj.common.error.UserErrorCode;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.pzj.base.common.impl.BaseServiceImpl;
import com.pzj.base.common.utils.PageList;
import com.pzj.base.common.utils.PageModel;
import com.pzj.base.entity.SysContacts;
import com.pzj.base.entity.query.SysContactsQueryParam;
import com.pzj.base.service.sys.IContactsService;
import com.pzj.core.customer.dao.SysContactMapper;
import com.pzj.framework.context.Result;
import com.pzj.framework.context.ServiceContext;

/**
 * Created by Administrator on 2016-10-12.
 */
@Service("iCntactsService")
public class ContactsServiceImpl extends BaseServiceImpl<SysContacts, SysContactMapper> implements IContactsService {
    private static final Logger logger = LoggerFactory.getLogger(ContactsServiceImpl.class);

    private void checkWhenCreate(SysContacts contacts){
        if (contacts == null){
            throw new UserServiceException(UserErrorCode.Contacts_NUll.getErrorCode(), UserErrorCode.Contacts_NUll.getErrorMessage());
        }

        if (StringUtils.isBlank(contacts.getName())){
            throw new UserServiceException("联系人的名称（name）不能为空");
        }
        if (StringUtils.isBlank(contacts.getPhoneNumber())){
            throw new UserServiceException("联系人的手机号（phoneNumber）不能为空");
        }
        if (StringUtils.isBlank(contacts.getDataSource())){
            throw new UserServiceException("联系人的所属平台（dataSource）不能为空");
        }
        if (contacts.getSupplierId() == null){
            throw new UserServiceException("联系人的所属供应商（supplierId）不能为空");
        }
        if (contacts.getCreateDate() == null){
            contacts.setCreateDate(new Date());
        }
        if (contacts.getIsDefault() == null){
            contacts.setIsDefault(false);
        }
    }

    private void checkWhenCreate(List<SysContacts> contactsList){
        if (CollectionUtils.isEmpty(contactsList)){
            throw new UserServiceException(UserErrorCode.Contacts_NUll.getErrorCode(), UserErrorCode.Contacts_NUll.getErrorMessage());
        }
        for (SysContacts contacts : contactsList){
            checkWhenCreate(contacts);
        }
    }

    private void checkWhenModify(SysContacts contacts){
        if (contacts == null){
            throw new UserServiceException("联系人不能为 null");
        }
        if (contacts.getId() == null){
            throw new UserServiceException("联系人的ID不能为空");
        }
        if (contacts.getSupplierId() == null){
            throw new UserServiceException("联系人的SupplierId不能为空");
        }
        if (contacts.getUpdateDate() == null){
            contacts.setUpdateDate(new Date());
        }
    }

    private void checkWhenModify(List<SysContacts> contactsList){
        if (CollectionUtils.isEmpty(contactsList)){
            throw new UserServiceException("联系人集合不能为空");
        }
        for (SysContacts contacts : contactsList){
            checkWhenModify(contacts);
        }
    }

    @Override
    public Result<Long> createContact(SysContacts contacts, ServiceContext serviceContext) {

        logger.trace("日志ID：{}；创建联系人开始", serviceContext.getLogId());

        checkWhenCreate(contacts);

        List<SysContacts> nonDefaultContactsList = asDefaultAndExcludeOther(contacts);

        if (CollectionUtils.isNotEmpty(nonDefaultContactsList)){
            super.updateBatchByPrimaryKey(nonDefaultContactsList);
        }
        Long insert = super.insert(contacts);

        logger.trace("日志ID：{}；新建联系人ID：{}", serviceContext.getLogId(), insert);
        logger.trace("日志ID：{}；创建联系人结束", serviceContext.getLogId());

        Result<Long> result = new Result<>();
        result.setData(insert);


        return result;
    }

    @Override
    public Result<Integer> createContact(List<SysContacts> contacts, ServiceContext serviceContext) {

        logger.trace("日志ID：{}；创建联系人开始", serviceContext.getLogId());

        checkWhenCreate(contacts);

        List<SysContacts> nonDefaultContactsList = asDefaultAndExcludeOther(contacts);

        if (CollectionUtils.isNotEmpty(nonDefaultContactsList)){
            super.updateBatchByPrimaryKey(nonDefaultContactsList);
        }

        int insert = 0;
        Long insertResult = super.insertBatch(contacts);
        if (insertResult == contacts.size())
            insert = contacts.size();

        logger.trace("日志ID：{}；新建联系人数量：{}", serviceContext.getLogId(), insert);
        logger.trace("日志ID：{}；创建联系人结束", serviceContext.getLogId());

        Result<Integer> result = new Result<>();
        result.setData(insert);

        return result;
    }

    @Override
    public Result<Integer> modifyContact(SysContacts contacts, ServiceContext serviceContext) {
        checkWhenModify(contacts);

        List<SysContacts> nonDefaultContactsList = asDefaultAndExcludeOther(contacts);

        if (CollectionUtils.isNotEmpty(nonDefaultContactsList)){
            super.updateBatchByPrimaryKey(nonDefaultContactsList);
        }

        Integer modify = super.updateByPrimaryKey(contacts);

        Result<Integer> result = new Result<>();
        result.setData(modify);

        return result;
    }

    @Override
    public Result<Integer> modifyContact(List<SysContacts> contacts, ServiceContext serviceContext) {
        checkWhenModify(contacts);

        List<SysContacts> nonDefaultContactsList = asDefaultAndExcludeOther(contacts);

        if (CollectionUtils.isNotEmpty(nonDefaultContactsList)){
            super.updateBatchByPrimaryKey(nonDefaultContactsList);
        }

        Integer modify = super.updateBatchByPrimaryKey(contacts);

        Result<Integer> result = new Result<>();
        result.setData(modify);

        return result;
    }

    @Override
    public Result<Integer> deleteContact(Long id, ServiceContext serviceContext) {

        Integer delete = super.delete(id);

        Result<Integer> result = new Result<>();
        result.setData(delete);

        return result;
    }

    @Override
    public Result<Integer> deleteContact(List<Long> ids, ServiceContext serviceContext) {

        Integer delete = mapper.deleteBatchByPrimaryKey(ids);
        if (delete == 1)
            delete = ids.size();

        Result<Integer> result = new Result<>();
        result.setData(delete);

        return result;
    }

    @Override
    public Result<Integer> deleteAndCreateContact(SysContactsQueryParam deleteContact, List<SysContacts> createContacts, ServiceContext serviceContext) {
        Result<Integer> result = new Result<>();
        try {
            logger.trace("日志ID：{}；删除、创建联系人开始", serviceContext.getLogId());

            int delete = 0;
            if (deleteContact != null && deleteContact.getSupplierId() != null){
                delete = mapper.deleteBatchByParam(deleteContact);
            }

            logger.trace("日志ID：{}；删除联系人数量：{}", serviceContext.getLogId(), delete);

            int insert = 0;
            if (CollectionUtils.isNotEmpty(createContacts)) {
                checkWhenCreate(createContacts);

                List<SysContacts> nonDefaultContactsList = asDefaultAndExcludeOther(createContacts);

                if (CollectionUtils.isNotEmpty(nonDefaultContactsList)){
                    super.updateBatchByPrimaryKey(nonDefaultContactsList);
                }

                Long insertCount = super.insertBatch(createContacts);
                if (insertCount == createContacts.size())
                    insert = createContacts.size();
            }

            logger.trace("日志ID：{}；创建联系人数量：{}", serviceContext.getLogId(), insert);
            logger.trace("日志ID：{}；删除、创建联系人结束", serviceContext.getLogId());
            result.setData(insert);
        } catch (UserServiceException e){
            logger.error(e.getMessage(), e);
            result.setData(0);
            result.setErrorCode(e.getErrorCode());
            result.setErrorMsg(e.getMessage());
        }

        return result;
    }

    @Override
    public Result<ArrayList<SysContacts>> queryByParam(SysContactsQueryParam contactQueryParam, ServiceContext serviceContext) {
        List<SysContacts> findResult = super.findListByParams(contactQueryParam);

        Result<ArrayList<SysContacts>> result = new Result<>();
        if (findResult != null){
            result.setData((ArrayList<SysContacts>)findResult);
        }

        return result;
    }

    @Override
    public Result<PageList<SysContacts>> queryByParam(SysContactsQueryParam contactQueryParam, PageModel pageModel, ServiceContext serviceContext) {

        PageList<SysContacts> queryResult = super.queryPageByParamMap(pageModel, contactQueryParam);

        Result<PageList<SysContacts>> result = new Result<>();
        result.setData(queryResult);
        return result;
    }

    @Override
    public Result<SysContacts> queryDefault(SysContactsQueryParam contactQueryParam, ServiceContext serviceContext) {
        Result<SysContacts> result = new Result<>();

        if (contactQueryParam == null){
            return result;
        }
        if (contactQueryParam.getSupplierId() == null){
            return result;
        }
        contactQueryParam.setIsDefault(true);

        List<SysContacts> sysContactsList = super.findListByParams(contactQueryParam);
        if (CollectionUtils.isNotEmpty(sysContactsList)){
            SysContacts contacts = sysContactsList.get(0);
            result.setData(contacts);
        }

        return result;
    }

    @Override
    public Result<Integer> asDefault(Long id, ServiceContext serviceContext) {
        Result<Integer> result = new Result<>();
        result.setData(0);

        if (id == null){
            return result;
        }

        SysContacts sysContactsTarget = getById(id);
        if (sysContactsTarget == null){
            return result;
        }

        SysContacts sysContacts1 = new SysContacts();
        sysContacts1.setId(id);
        sysContacts1.setSupplierId(sysContactsTarget.getSupplierId());
        sysContacts1.setIsDefault(true);

        List<SysContacts> nonDefaultAddressList = asDefaultAndExcludeOther(sysContacts1);

        int update = 0;
        if (CollectionUtils.isNotEmpty(nonDefaultAddressList)){
            update = super.updateBatchByPrimaryKey(nonDefaultAddressList);
        }
        update = update + super.updateByPrimaryKey(sysContacts1);

        result.setData(update);
        return result;
    }

    private List<SysContacts> asDefaultAndExcludeOther(SysContacts contacts){
        Boolean isDefault = contacts.getIsDefault();
        if (isDefault != null && isDefault){
            return allContactsAsNonDefault(contacts.getSupplierId());
        }
        return null;
    }

    private List<SysContacts> allContactsAsNonDefault(Long supplierId){
        if (supplierId == null)
            throw new UserServiceException("设置所有联系人为非默认时，supplierId 不能为 null");

        SysContactsQueryParam contactQueryParam = new SysContactsQueryParam();
        contactQueryParam.setSupplierId(supplierId);
        contactQueryParam.setIsDefault(true);
        List<SysContacts> sysContactsList = super.findListByParams(contactQueryParam);

        List<SysContacts> nonDefaultAddressList = asNonDefaultAddress(sysContactsList);

        return nonDefaultAddressList;
    }

    private List<SysContacts> asDefaultAndExcludeOther(List<SysContacts> contactsList) {
        if (CollectionUtils.isEmpty(contactsList))
            throw new UserServiceException("设置所有地址为非默认时，地址集合不能为空。");

        Set<Long> plane = new HashSet<>();
        for (SysContacts contacts : contactsList){
            if (contacts == null)
                continue;
            if (contacts.getSupplierId() == null)
                throw new UserServiceException("设置所有联系人为非默认时，supplierId 不能为 null。");

            Boolean isDefault = contacts.getIsDefault();
            if (plane.contains(contacts.getSupplierId())){
                contacts.setIsDefault(false);
            } else if(isDefault != null && isDefault){
                plane.add(contacts.getSupplierId());
                contacts.setIsDefault(true);
            }
        }

        return allAddressAsNonDefault(plane);
    }

    private List<SysContacts> allAddressAsNonDefault(Set<Long> supplierIds){
        if (supplierIds.isEmpty()){
            return null;
        }

        SysContactsQueryParam contactQueryParam = new SysContactsQueryParam();
        contactQueryParam.setSupplierIds(supplierIds);
        contactQueryParam.setIsDefault(true);

        List<SysContacts> sysAddressList = super.findListByParams(contactQueryParam);

        List<SysContacts> nonDefaultAddressList = asNonDefaultAddress(sysAddressList);

        return nonDefaultAddressList;
    }

    private List<SysContacts> asNonDefaultAddress(List<SysContacts> sysContactsList) {
        List<SysContacts> nonDefaultAddressList = null;
        if (CollectionUtils.isNotEmpty(sysContactsList)){
            nonDefaultAddressList = new ArrayList<>(sysContactsList.size());
            for (SysContacts sysAddress : sysContactsList){
                SysContacts updateContacts = new SysContacts();
                updateContacts.setId(sysAddress.getId());
                updateContacts.setIsDefault(false);
                nonDefaultAddressList.add(updateContacts);
            }
        }

        return nonDefaultAddressList;
    }

}
