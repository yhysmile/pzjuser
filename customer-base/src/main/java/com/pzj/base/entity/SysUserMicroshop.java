package com.pzj.base.entity;

import java.io.Serializable;
import java.util.Date;

import com.pzj.base.common.BaseEntity;

/**
 * Created by Administrator on 2016-12-7.
 */
public class SysUserMicroshop extends BaseEntity implements Serializable {
	private Long userId;
	/**
	 * 微店名称
	 */
	private String name;

	/**
	 * 微店简介
	 */
	private String intro;

	/**
	 * 微店头像
	 */
	private String avatar;

	private Date createDate;

	private Date updateDate;

	private String phoneNum;

	public SysUserMicroshop() {
		super();
	};

	public SysUserMicroshop(Long id, Long userId, String name, String intro, String avatar, Date createDate) {
		setId(id);
		this.userId = userId;
		this.name = name;
		this.intro = intro;
		this.avatar = avatar;
		this.createDate = createDate;
	};

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
}
