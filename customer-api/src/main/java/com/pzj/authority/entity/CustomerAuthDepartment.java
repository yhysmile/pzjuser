package com.pzj.authority.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.pzj.base.entity.SysUserOfficeKey;
import com.pzj.util.PojoUtil;

/**
 * 用户的菜单权限
 * 
 * @author zhangdianliang
 * @email zhangdianliang@mftour.cn
 * @date 2015-8-27 下午2:05:09
 */
public class CustomerAuthDepartment implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2426843032793767936L;

	/** 用户主键id */
	private Long userId;

	/** 菜单主键id */
	private Long officeId;

	public CustomerAuthDepartment() {
		super();
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getOfficeId() {
		return officeId;
	}

	public void setOfficeId(Long officeId) {
		this.officeId = officeId;
	}

	public static SysUserOfficeKey customerAuthDepartment2UserOffice(
			CustomerAuthDepartment record) throws Exception {
		SysUserOfficeKey userOffice = new SysUserOfficeKey();
		PojoUtil.copyProperties(record, userOffice);
		return userOffice;
	}

	public static CustomerAuthDepartment userOffice2CustomerAuthDepartment(
			SysUserOfficeKey record) throws Exception {
		CustomerAuthDepartment customerDepartment = new CustomerAuthDepartment();
		PojoUtil.copyProperties(record, customerDepartment);
		return customerDepartment;
	}

	public static List<SysUserOfficeKey> cList2SList(
			List<CustomerAuthDepartment> cList) throws Exception {
		List<SysUserOfficeKey> sList = null;
		if (cList != null) {
			sList = new ArrayList<SysUserOfficeKey>();
			for (CustomerAuthDepartment record : cList) {
				SysUserOfficeKey userOffice = customerAuthDepartment2UserOffice(record);
				sList.add(userOffice);
			}
		}
		return sList;
	}

	public static List<CustomerAuthDepartment> sList2CList(
			List<SysUserOfficeKey> sList) throws Exception {
		List<CustomerAuthDepartment> cList = null;
		if (sList != null) {
			cList = new ArrayList<CustomerAuthDepartment>();
			for (SysUserOfficeKey userOffice : sList) {
				CustomerAuthDepartment record = userOffice2CustomerAuthDepartment(userOffice);
				cList.add(record);
			}
		}
		return cList;
	}

}
