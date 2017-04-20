package com.pzj.contacts.entity;

import org.apache.commons.lang.StringUtils;

import com.pzj.base.common.ServiceException;
import com.pzj.base.entity.query.SysContactsQueryParam;
import com.pzj.util.CommonBuiler;
import com.pzj.util.CommonCheck;

/**
 * Created by Administrator on 2016-10-12.
 */
public class ContactsParamBuilder extends CommonBuiler<SysContactsQueryParam, ContactsParam> {
    @Override
    public ContactsParam convertFrom(SysContactsQueryParam entityParam) {
        if (entityParam == null)
            return null;

        ContactsParam contacts = new ContactsParam();
        contacts.setId(entityParam.getId());
        contacts.setName(entityParam.getName());
        contacts.setPhoneNumber(entityParam.getPhoneNumber());
        contacts.setTypeDesc(entityParam.getTypeDesc());
        contacts.setSupplierId(entityParam.getSupplierId());
        contacts.setDataSource(entityParam.getDataSource());
        contacts.setCreateBy(entityParam.getCreateBy());
        contacts.setCreateDate(entityParam.getCreateDate());
        contacts.setUpdateBy(entityParam.getUpdateBy());
        contacts.setUpdateDate(entityParam.getUpdateDate());

        contacts.setIdNumber(entityParam.getIdNumber());
        contacts.setNameEn(entityParam.getNameEn());
        contacts.setEmail(entityParam.getEmail());
        contacts.setDefault(entityParam.getIsDefault());
        contacts.setNamePinyin(entityParam.getNamePinyin());

        contacts.setIds(entityParam.getIds());

        return contacts;
    }

    @Override
    public SysContactsQueryParam convertTo(ContactsParam contactsParam) {
        if (contactsParam == null)
            return null;

        SysContactsQueryParam entity = new SysContactsQueryParam();
        entity.setId(contactsParam.getId());
        entity.setName(contactsParam.getName());
        entity.setPhoneNumber(contactsParam.getPhoneNumber());
        entity.setTypeDesc(contactsParam.getTypeDesc());
        entity.setSupplierId(contactsParam.getSupplierId());
        entity.setDataSource(contactsParam.getDataSource());
        if (StringUtils.isNotBlank(contactsParam.getCreateBy())) {
            entity.setCreateBy(Long.valueOf(contactsParam.getCreateBy()));
        }
        entity.setCreateDate(contactsParam.getCreateDate());
        if (StringUtils.isNotBlank(contactsParam.getUpdateBy())) {
            entity.setUpdateBy(Long.valueOf(contactsParam.getUpdateBy()));
        }
        entity.setUpdateDate(contactsParam.getUpdateDate());

        entity.setIdNumber(contactsParam.getIdNumber());
        entity.setNameEn(contactsParam.getNameEn());
        entity.setEmail(contactsParam.getEmail());
        entity.setIsDefault(contactsParam.getDefault());
        entity.setNamePinyin(contactsParam.getNamePinyin());

        entity.setIds(contactsParam.getIds());
        return entity;
    }

    @Override
    protected void validtionValueWhenCreate(ContactsParam entity, CommonCheck check) throws ServiceException {

    }

    @Override
    protected void customValueWhenCreate(ContactsParam entity) {

    }

    @Override
    protected void customValueWhenModify(ContactsParam entity) {

    }
}
