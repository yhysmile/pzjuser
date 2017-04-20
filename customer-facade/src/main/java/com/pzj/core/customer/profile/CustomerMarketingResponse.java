package com.pzj.core.customer.profile;

public class CustomerMarketingResponse extends QueryDetailCustomerResponse {

	private static final long serialVersionUID = 147569773163121996L;
	/**
	 * 推荐人id
	 */
	private Long refereeId;
	/**
	 * 商务负责人id
	 */
	private Long businessId;

	/**
	 * 推荐人名称
	 */
	private String refereeName;
	/**
	 * 商务负责人名称
	 */
	private String businessName;

	/**
	 * 推荐码
	 */
	private String refereeCode;

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

	public String getRefereeName() {
		return refereeName;
	}

	public void setRefereeName(String refereeName) {
		this.refereeName = refereeName;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public String getRefereeCode() {
		return refereeCode;
	}

	public void setRefereeCode(String refereeCode) {
		this.refereeCode = refereeCode;
	}

}
