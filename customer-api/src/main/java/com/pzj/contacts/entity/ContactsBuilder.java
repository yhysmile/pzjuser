package com.pzj.contacts.entity;

import com.pzj.base.common.ServiceException;
import com.pzj.base.entity.SysContacts;
import com.pzj.util.CommonBuiler;
import com.pzj.util.CommonCheck;
import org.apache.commons.lang.StringUtils;

/**
 * Created by Administrator on 2016-10-12.
 */
public class ContactsBuilder extends CommonBuiler<SysContacts, Contacts> {

    @Override
    public Contacts convertFrom(SysContacts entity) {
        if (entity == null)
            return null;

        Contacts contacts = new Contacts();
        contacts.setId(entity.getId());
        contacts.setName(entity.getName());
        contacts.setPhoneNumber(entity.getPhoneNumber());
        contacts.setTypeDesc(entity.getTypeDesc());
        contacts.setSupplierId(entity.getSupplierId());
        contacts.setDataSource(entity.getDataSource());
        contacts.setCreateBy(entity.getCreateBy());
        contacts.setCreateDate(entity.getCreateDate());
        contacts.setUpdateBy(entity.getUpdateBy());
        contacts.setUpdateDate(entity.getUpdateDate());

        contacts.setIdNumber(entity.getIdNumber());
        contacts.setNameEn(entity.getNameEn());
        contacts.setEmail(entity.getEmail());
        contacts.setDefault(entity.getIsDefault());
        contacts.setNamePinyin(entity.getNamePinyin());

        return contacts;
    }

    @Override
    public SysContacts convertTo(Contacts contacts) {
        if (contacts == null)
            return null;

        SysContacts entity = new SysContacts();
        entity.setId(contacts.getId());
        entity.setName(contacts.getName());
        entity.setPhoneNumber(contacts.getPhoneNumber());
        entity.setTypeDesc(contacts.getTypeDesc());
        entity.setSupplierId(contacts.getSupplierId());
        entity.setDataSource(contacts.getDataSource());
        if (StringUtils.isNotBlank(contacts.getCreateBy())) {
            entity.setCreateBy(Long.valueOf(contacts.getCreateBy()));
        }
        entity.setCreateDate(contacts.getCreateDate());
        if (StringUtils.isNotBlank(contacts.getUpdateBy())) {
            entity.setUpdateBy(Long.valueOf(contacts.getUpdateBy()));
        }
        entity.setUpdateDate(contacts.getUpdateDate());

        entity.setIdNumber(contacts.getIdNumber());
        entity.setNameEn(contacts.getNameEn());
        entity.setEmail(contacts.getEmail());
        entity.setIsDefault(contacts.getDefault());
        entity.setNamePinyin(contacts.getNamePinyin());

        return entity;
    }

    @Override
    protected void validtionValueWhenCreate(Contacts entity, CommonCheck check) throws ServiceException {

    }

    @Override
    protected void customValueWhenCreate(Contacts entity) {

    }

    @Override
    protected void customValueWhenModify(Contacts entity) {

    }
}
