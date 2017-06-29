package com.pzj.core.customer.profile;

import javax.annotation.Resource;

import com.pzj.core.customer.entitys.CustomerExtendsEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.pzj.core.customer.common.exception.CustomerException;
import com.pzj.core.customer.common.exception.CustomerExceptionCode;
import com.pzj.core.customer.read.CustomerExtendsReadMapper;
import com.pzj.core.customer.write.CustomerExtendsWriteMapper;
import com.pzj.framework.converter.JSONConverter;
import com.pzj.framework.toolkit.Check;

/**
 * Created by Administrator on 2017-2-16.
 * 营销信息service
 */
@Service("customerExtendsService")
public class CustomerExtendsService {
	private static final Logger logger = LoggerFactory.getLogger(CustomerExtendsService.class);
	@Resource
	private CustomerExtendsReadMapper customerExtendsReadMapper;
	@Resource
	private CustomerExtendsWriteMapper customerExtendsWriteMapper;

	/**
	 * 新增用户扩展信息
	 * @param customerExtendsEntity
	 * @return
	 */
	public void intserCustomerExtends(CustomerExtendsEntity customerExtendsEntity) {
		Integer insterResult = customerExtendsWriteMapper.insertCustomerExtends(customerExtendsEntity);
		if (logger.isInfoEnabled()) {
			logger.info("新增用户扩展信息操作返回{}", insterResult);
		}
		if (insterResult != 1) {
			logger.error("新增用户扩展信息失败,用户信息为{}", JSONConverter.toJson(customerExtendsEntity));
			throw new CustomerException(CustomerExceptionCode.ADD_EXTENDS_ERROR);
		}
	}

	/**
	 * 修改用户扩展信息
	 * @param customerExtendsEntity
	 * @return
	 */
	public void updateCustomerExtends(CustomerExtendsEntity customerExtendsEntity) {
		Integer updateResult = customerExtendsWriteMapper.updateCustomerExtends(customerExtendsEntity);
		if (logger.isInfoEnabled()) {
			logger.info("修改用户扩展信息返回{}", updateResult);
		}
		if (updateResult != 1) {
			logger.error("修改用户扩展信息失败,用户信息为{}", JSONConverter.toJson(customerExtendsEntity));
			throw new CustomerException(CustomerExceptionCode.EDIT_EXTENDS_ERROR);
		}
	}

	public CustomerExtendsEntity queryCustomerExtendsByCustomerId(Long customerId, Long supplierId) {
		CustomerExtendsEntity customerExtendsEntity = customerExtendsReadMapper.queryCustomerExtendsByCustomerId(
				customerId, supplierId);
		if (Check.NuNObject(customerExtendsEntity)) {
			logger.warn("查询用户扩展信息出错，用户id为{}", customerId);
			//			throw new CustomerException(CustomerExceptionCode.QUERY_EXTENDS_ERROR);
		}
		return customerExtendsEntity;
	}

}
