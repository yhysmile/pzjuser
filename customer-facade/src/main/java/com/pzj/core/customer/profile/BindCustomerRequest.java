package com.pzj.core.customer.profile;

public class BindCustomerRequest implements java.io.Serializable {

	private static final long serialVersionUID = 358937408050821714L;
	/**
	 * 被绑定分销商id
	 */
	private Long resellerId;
	/**
	 * 主账号id
	 */
	private Long supplierId;
	/**
	 * 操作人id
	 */
	private Long operateId;

	public Long getResellerId() {
		return resellerId;
	}

	public void setResellerId(Long resellerId) {
		this.resellerId = resellerId;
	}

	public Long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}

	public Long getOperateId() {
		return operateId;
	}

	public void setOperateId(Long operateId) {
		this.operateId = operateId;
	}

}
