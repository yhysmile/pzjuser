package com.pzj.core.customer.write;

import com.pzj.base.common.persistence.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;

import com.pzj.core.customer.profile.CustomerExtendsEntity;

/**
 * Created by Administrator on 2017-2-16.
 * 营销信息写mapper
 */
@MyBatisDao
public interface CustomerExtendsWriteMapper {

	Integer insertCustomerExtends(@Param(value = "customerExtends") CustomerExtendsEntity customerExtendsEntity);

	Integer updateCustomerExtends(@Param(value = "customerExtends") CustomerExtendsEntity customerExtendsEntity);
}
