package com.pzj.address.entity;

import com.pzj.base.common.ServiceException;
import com.pzj.base.entity.SysAddress;
import com.pzj.util.CommonBuiler;
import com.pzj.util.CommonCheck;

/**
 * Created by Administrator on 2016-10-20.
 */
public class AddressBuilder extends CommonBuiler<SysAddress, Address> {
    public final static AddressBuilder AAddressBuilder = new AddressBuilder();

    @Override
    public Address convertFrom(SysAddress entity) {
        if (entity == null)
            return null;

        Address address = new Address();
        address.setId(entity.getId());
        address.setProvince(entity.getProvince());
        address.setCity(entity.getCity());
        address.setCounty(entity.getCounty());
        address.setAddress(entity.getAddress());
        address.setType(entity.getType());
        address.setPostcode(entity.getPostcode());
        address.setSupplierId(entity.getSupplierId());
        address.setIsDefault(entity.getIsDefault());
        address.setCreateBy(entity.getCreateBy());
        address.setCreateDate(entity.getCreateDate());
        address.setUpdateBy(entity.getUpdateBy());
        address.setUpdateDate(entity.getUpdateDate());
        address.setDataSource(entity.getDataSource());
        address.setName(entity.getName());

        return address;
    }

    @Override
    public SysAddress convertTo(Address address) {
        if (address == null)
            return null;

        SysAddress entity = new SysAddress();
        entity.setId(address.getId());
        entity.setProvince(address.getProvince());
        entity.setCity(address.getCity());
        entity.setCounty(address.getCounty());
        entity.setAddress(address.getAddress());
        entity.setType(address.getType());
        entity.setPostcode(address.getPostcode());
        entity.setSupplierId(address.getSupplierId());
        entity.setIsDefault(address.getIsDefault());
        if (address.getCreateBy() != null){
            entity.setCreateBy(Long.valueOf(address.getCreateBy()));
        }
        entity.setCreateDate(address.getCreateDate());
        if (address.getUpdateBy() != null){
            entity.setUpdateBy(Long.valueOf(address.getUpdateBy()));
        }
        entity.setUpdateDate(address.getUpdateDate());
        entity.setDataSource(address.getDataSource());
        entity.setName(address.getName());

        return entity;
    }

    @Override
    protected void validtionValueWhenCreate(Address entity, CommonCheck check) throws ServiceException {

    }

    @Override
    protected void customValueWhenCreate(Address entity) {

    }

    @Override
    protected void customValueWhenModify(Address entity) {

    }
}
