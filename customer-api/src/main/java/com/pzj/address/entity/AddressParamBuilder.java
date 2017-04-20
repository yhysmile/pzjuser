package com.pzj.address.entity;

import com.pzj.base.common.ServiceException;
import com.pzj.base.entity.query.SysAddressQueryParam;
import com.pzj.util.CommonBuiler;
import com.pzj.util.CommonCheck;

/**
 * Created by Administrator on 2016-10-20.
 */
public class AddressParamBuilder extends CommonBuiler<SysAddressQueryParam, AddressParam> {
    public final static AddressParamBuilder AAddressParamBuilder = new AddressParamBuilder();

    @Override
    public AddressParam convertFrom(SysAddressQueryParam entity) {
        if (entity == null)
            return null;

        AddressParam addressParam = new AddressParam();
        addressParam.setId(entity.getId());
        addressParam.setProvince(entity.getProvince());
        addressParam.setCity(entity.getCity());
        addressParam.setCounty(entity.getCounty());
        addressParam.setAddress(entity.getAddress());
        addressParam.setType(entity.getType());
        addressParam.setPostcode(entity.getPostcode());
        addressParam.setSupplierId(entity.getSupplierId());
        addressParam.setIsDefault(entity.getIsDefault());
        addressParam.setCreateBy(entity.getCreateBy());
        addressParam.setCreateDate(entity.getCreateDate());
        addressParam.setUpdateBy(entity.getUpdateBy());
        addressParam.setUpdateDate(entity.getUpdateDate());
        addressParam.setDataSource(entity.getDataSource());
        addressParam.setName(entity.getName());

        return addressParam;
    }

    @Override
    public SysAddressQueryParam convertTo(AddressParam addressParam) {
        if (addressParam == null)
            return null;

        SysAddressQueryParam entity = new SysAddressQueryParam();
        entity.setId(addressParam.getId());
        entity.setProvince(addressParam.getProvince());
        entity.setCity(addressParam.getCity());
        entity.setCounty(addressParam.getCounty());
        entity.setAddress(addressParam.getAddress());
        entity.setType(addressParam.getType());
        entity.setPostcode(addressParam.getPostcode());
        entity.setSupplierId(addressParam.getSupplierId());
        entity.setIsDefault(addressParam.getIsDefault());
        if (addressParam.getCreateBy() != null){
            entity.setCreateBy(Long.valueOf(addressParam.getCreateBy()));
        }
        entity.setCreateDate(addressParam.getCreateDate());
        if (addressParam.getUpdateBy() != null){
            entity.setUpdateBy(Long.valueOf(addressParam.getUpdateBy()));
        }
        entity.setUpdateDate(addressParam.getUpdateDate());
        entity.setDataSource(addressParam.getDataSource());
        entity.setName(addressParam.getName());
        entity.setIds(addressParam.getIds());

        return entity;
    }

    @Override
    protected void validtionValueWhenCreate(AddressParam entity, CommonCheck check) throws ServiceException {

    }

    @Override
    protected void customValueWhenCreate(AddressParam entity) {

    }

    @Override
    protected void customValueWhenModify(AddressParam entity) {

    }
}
