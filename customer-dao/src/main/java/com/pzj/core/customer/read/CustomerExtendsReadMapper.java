package com.pzj.core.customer.read;

import org.apache.ibatis.annotations.Param;

import com.pzj.core.customer.entitys.CustomerExtendsEntity;

/**
 * Created by Administrator on 2017-2-16.
 * 营销信息读mapper
 */
public interface CustomerExtendsReadMapper {
	CustomerExtendsEntity queryCustomerExtendsByCustomerId(@Param(value = "customerId") Long customerId, @Param(value = "supplierId") Long supplierId);
}
