package com.pzj.core.customer.entitys;

/**
 * Created by Administrator on 2017-2-16.
 * 营销信息数据库模型
 */
public class CustomerExtendsEntity {
	//用户id
	private Long customerId;
	// 所属供应商id
	private Long supplierId;
	//负责人id
	private Long refereeId;
	//商务负责人id
	private Long businessId;

	public CustomerExtendsEntity() {
	};

	public CustomerExtendsEntity(Long customerId, Long supplierId, Long refereeId, Long businessId) {
		this.customerId = customerId;
		this.supplierId = supplierId;
		this.refereeId = refereeId;
		this.businessId = businessId;
	}

	public Long getCustomerId() {

		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Long getRefereeId() {
		return refereeId;
	}

	public void setRefereeId(Long refereeId) {
		this.refereeId = refereeId;
	}

	public Long getBusinessId() {
		return businessId;
	}

	public void setBusinessId(Long businessId) {
		this.businessId = businessId;
	}

	public Long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}
}
