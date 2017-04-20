package com.pzj.core.customer.write;

import org.apache.ibatis.annotations.Param;

import com.pzj.core.customer.profile.CustomerExtendsEntity;

/**
 * Created by Administrator on 2017-2-16.
 * 营销信息写mapper
 */
public interface CustomerExtendsWriteMapper {

	Integer insertCustomerExtends(@Param(value = "customerExtends") CustomerExtendsEntity customerExtendsEntity);

	Integer updateCustomerExtends(@Param(value = "customerExtends") CustomerExtendsEntity customerExtendsEntity);
}
