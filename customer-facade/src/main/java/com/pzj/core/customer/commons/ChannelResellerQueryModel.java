package com.pzj.core.customer.commons;

import java.util.Date;
import java.util.List;

public class ChannelResellerQueryModel implements java.io.Serializable {

	private static final long serialVersionUID = 3652774963753887956L;

	/**
	 * 渠道id
	 */
	private Long channelId;
	/**
	 * 主账号id
	 */
	private Long rootId;
	/**
	 * 用户名
	 */
	private String loginName;
	/**
	 * 公司名
	 */
	private String name;
	/**
	 * 联系人
	 */
	private String concat;
	/**
	 * 手机
	 */
	private String mobile;
	/**
	 * 地址区域
	 */
	private String address;
	/**
	 * 省
	 */
	private String province;
	/**
	 * 市
	 */
	private String city;
	/**
	 * 县
	 */
	private String county;
	/**
	 * 分销商类型
	 */
	private String resellerType;
	/**
	 * 绑定开始时间
	 */
	private Date bindSDate;
	/**
	 * 绑定结束时间
	 */
	private Date bindEDate;
	/**
	 * 临时关联的分销商id集合
	 */
	private List<Long> tempRelResellers;
	/**
	 * 临时移除的分销商id集合
	 */
	private List<Long> tempRemoveResellers;
	/**
	 * 推荐人id
	 */
	private Long refereeId;
	/**
	 * 用户类型
	 */
	private String userType;

	public Long getChannelId() {
		return channelId;
	}

	public void setChannelId(Long channelId) {
		this.channelId = channelId;
	}

	public Long getRootId() {
		return rootId;
	}

	public void setRootId(Long rootId) {
		this.rootId = rootId;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getConcat() {
		return concat;
	}

	public void setConcat(String concat) {
		this.concat = concat;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getResellerType() {
		return resellerType;
	}

	public void setResellerType(String resellerType) {
		this.resellerType = resellerType;
	}

	public Date getBindSDate() {
		return bindSDate;
	}

	public void setBindSDate(Date bindSDate) {
		this.bindSDate = bindSDate;
	}

	public Date getBindEDate() {
		return bindEDate;
	}

	public void setBindEDate(Date bindEDate) {
		this.bindEDate = bindEDate;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public List<Long> getTempRelResellers() {
		return tempRelResellers;
	}

	public void setTempRelResellers(List<Long> tempRelResellers) {
		this.tempRelResellers = tempRelResellers;
	}

	public List<Long> getTempRemoveResellers() {
		return tempRemoveResellers;
	}

	public void setTempRemoveResellers(List<Long> tempRemoveResellers) {
		this.tempRemoveResellers = tempRemoveResellers;
	}

	public Long getRefereeId() {
		return refereeId;
	}

	public void setRefereeId(Long refereeId) {
		this.refereeId = refereeId;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

}
