/**
 * piaozhijia.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.pzj.core.customer.channel.mq;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.pzj.core.customer.commons.exception.CustomerException;
import com.pzj.core.customer.commons.exception.CustomerExceptionCode;
import com.pzj.core.customer.profile.mq.ModifyCustomer;
import com.pzj.core.customer.utils.OperatInfo;

/**
 * 渠道用户关系表
 * @author Administrator
 * @version $Id: DirectChannelUser.java, v 0.1 2017年4月7日 下午3:30:21 Administrator Exp $
 */
public class DirectChannelUser extends OperatInfo implements Serializable {

	/**  */
	private static final long serialVersionUID = -4778187161846809158L;
	private List<Relation> relations;
	private Long supplierId;

	public DirectChannelUser() {
		super();
	}

	public DirectChannelUser(List<Relation> relations, Long supplierId, Long operatorId, Date operatingDate) {
		super();
		this.relations = relations;
		this.supplierId = supplierId;
		setOperatingDate(operatingDate);
		setOperatorId(operatorId);
	}

	/**
	 * Getter method for property <tt>relations</tt>.
	 * 
	 * @return property value of relations
	 */
	public List<Relation> getRelations() {
		return relations;
	}

	/**
	 * Setter method for property <tt>relations</tt>.
	 * 
	 * @param relations value to be assigned to property relations
	 */
	public void setRelations(List<Relation> relations) {
		this.relations = relations;
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
	};

	public byte[] createMsgData(ModifyCustomer customer) {
		try {
			String json = JSONObject.toJSONString(customer);
			return json.getBytes();
		} catch (Exception e) {
			throw new CustomerException(CustomerExceptionCode.SERIALIZE_DATA_ERROR);
		}

	}

}
