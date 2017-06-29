/**
 * piaozhijia.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.pzj.core.customer.profile.mq;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.pzj.core.customer.common.exception.CustomerException;
import com.pzj.core.customer.common.exception.CustomerExceptionCode;
import com.pzj.core.customer.utils.OperatInfo;

/**
 * 创建用户消息实体
 * @author Administrator
 * @version $Id: ModifyCustomer.java, v 0.1 2017年4月7日 下午3:01:02 Administrator Exp $
 */
public class CreateCustomer extends OperatInfo implements Serializable {
	/**  */
	private static final long serialVersionUID = -4076394767123391202L;
	private List<Long> customerIds;
	private Long supplierId;

	public CreateCustomer() {
		super();
	};

	/**
	 * Getter method for property <tt>customerIds</tt>.
	 * 
	 * @return property value of customerIds
	 */
	public List<Long> getCustomerIds() {
		return customerIds;
	}

	/**
	 * Setter method for property <tt>customerIds</tt>.
	 * 
	 * @param customerIds value to be assigned to property customerIds
	 */
	public void setCustomerIds(List<Long> customerIds) {
		this.customerIds = customerIds;
	}

	/**
	 * Getter method for property <tt>supplierId</tt>.
	 * 
	 * @return property value of supplierId
	 */
	public Long getSupplierId() {
		return supplierId;
	}

	/**
	 * Setter method for property <tt>supplierId</tt>.
	 * 
	 * @param supplierId value to be assigned to property supplierId
	 */
	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}

	public CreateCustomer(List<Long> customerIds, Long supplierId, Long operatorId, Date operatingDate) {
		super();
		this.customerIds = customerIds;
		this.supplierId = supplierId;
		setOperatorId(operatorId);
		setOperatingDate(operatingDate);
	};

	public byte[] createMsgData(CreateCustomer customer) {
		try {
			String json = JSONObject.toJSONString(customer);
			return json.getBytes();
		} catch (Exception e) {
			throw new CustomerException(CustomerExceptionCode.SERIALIZE_DATA_ERROR);
		}

	}
}
