package com.pzj.base.entity;

import java.util.Date;
import java.util.List;

import com.pzj.base.common.BaseEntity;

public class SysChannel extends BaseEntity {

	private static final long serialVersionUID = 7410899434774946119L;

	/**
	 * 渠道名称
	 */
	private String name;

	/**
	 * 渠道负责人
	 */
	private String channelPrincipal;
	/**
	 * 市
	 */
	private String city;
	/**
	 * 县
	 */
	private String county;
	/**
	 * 省
	 */
	private String province;

	private String spell;

	/**
	 * 备注
	 */
	private String remark;

	/**
	 * 渠道类型
	 */
	private String channelType;
	/**
	 * 分销渠道类别
	 */
	private String channelCategory;

	/**
	 * 使用状态1启用0禁用2删除
	 */
	private String delFlag;
	/**
	 * 排序
	 */
	private Integer sort;

	/** 创建日期 */
	private Date createDate;

	/** 创建日期结束范围（只用于查询） */
	private Date createDateEnd;

	/** 更新日期 */
	private Date updateDate;
	/** 更新人 */
	private String updateBy;
	/** 创建人 */
	private String createBy;

	/**
	 * 数据来源
	 */
	private String dataSource;

	/**
	 * 创建供应商ID
	 */
	private Long supplierId;

	/**
	 * 查询参数：id集合
	 */
	private List<Long> queryIds;

	/**
	 * 查询参数：用户id集合
	 */
	private List<Long> queryUserIds;

	/**
	 * 获取渠道名称
	 * 
	 * @return name 渠道名称
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置渠道名称
	 * 
	 * @param name
	 *            渠道名称
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 获取渠道负责人
	 * 
	 * @return channelPrincipal 渠道负责人
	 */
	public String getChannelPrincipal() {
		return channelPrincipal;
	}

	/**
	 * 设置渠道负责人
	 * 
	 * @param channelPrincipal
	 *            渠道负责人
	 */
	public void setChannelPrincipal(String channelPrincipal) {
		this.channelPrincipal = channelPrincipal;
	}

	/**
	 * 获取市
	 * 
	 * @return city 市
	 */
	public String getCity() {
		return city;
	}

	/**
	 * 设置市
	 * 
	 * @param city
	 *            市
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * 获取县
	 * 
	 * @return county 县
	 */
	public String getCounty() {
		return county;
	}

	/**
	 * 设置县
	 * 
	 * @param county
	 *            县
	 */
	public void setCounty(String county) {
		this.county = county;
	}

	/**
	 * 获取省
	 * 
	 * @return province 省
	 */
	public String getProvince() {
		return province;
	}

	/**
	 * 设置省
	 * 
	 * @param province
	 *            省
	 */
	public void setProvince(String province) {
		this.province = province;
	}

	/**
	 * 获取spell
	 * 
	 * @return spell spell
	 */
	public String getSpell() {
		return spell;
	}

	/**
	 * 设置spell
	 * 
	 * @param spell
	 *            spell
	 */
	public void setSpell(String spell) {
		this.spell = spell;
	}

	/**
	 * 获取备注
	 * 
	 * @return remark 备注
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * 设置备注
	 * 
	 * @param remark
	 *            备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * 获取渠道类型
	 * 
	 * @return channelType 渠道类型
	 */
	public String getChannelType() {
		return channelType;
	}

	/**
	 * 设置渠道类型
	 * 
	 * @param channelType
	 *            渠道类型
	 */
	public void setChannelType(String channelType) {
		this.channelType = channelType;
	}

	/**
	 * 获取分销渠道类别
	 * 
	 * @return channelCategory 分销渠道类别
	 */
	public String getChannelCategory() {
		return channelCategory;
	}

	/**
	 * 设置分销渠道类别
	 * 
	 * @param channelCategory
	 *            分销渠道类别
	 */
	public void setChannelCategory(String channelCategory) {
		this.channelCategory = channelCategory;
	}

	/**
	 * 获取使用状态1启用0禁用2删除
	 * 
	 * @return delFlag 使用状态1启用0禁用2删除
	 */
	public String getDelFlag() {
		return delFlag;
	}

	/**
	 * 设置使用状态1启用0禁用2删除
	 * 
	 * @param delFlag
	 *            使用状态1启用0禁用2删除
	 */
	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

	/**
	 * 获取排序
	 * 
	 * @return sort 排序
	 */
	public Integer getSort() {
		return sort;
	}

	/**
	 * 设置排序
	 * 
	 * @param sort
	 *            排序
	 */
	public void setSort(Integer sort) {
		this.sort = sort;
	}

	/**
	 * 获取创建日期
	 * 
	 * @return createDate 创建日期
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * 设置创建日期
	 * 
	 * @param createDate
	 *            创建日期
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * 获取更新日期
	 * 
	 * @return updateDate 更新日期
	 */
	public Date getUpdateDate() {
		return updateDate;
	}

	/**
	 * 设置更新日期
	 * 
	 * @param updateDate
	 *            更新日期
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	/**
	 * 获取更新人
	 * 
	 * @return updateBy 更新人
	 */
	public String getUpdateBy() {
		return updateBy;
	}

	/**
	 * 设置更新人
	 * 
	 * @param updateBy
	 *            更新人
	 */
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	/**
	 * 获取创建人
	 * 
	 * @return createBy 创建人
	 */
	public String getCreateBy() {
		return createBy;
	}

	/**
	 * 设置创建人
	 * 
	 * @param createBy
	 *            创建人
	 */
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	/**
	 * 获取数据来源
	 * 
	 * @return dataSource 数据来源
	 */
	public String getDataSource() {
		return dataSource;
	}

	/**
	 * 设置数据来源
	 * 
	 * @param dataSource
	 *            数据来源
	 */
	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
	}

	/**
	 * 获取创建供应商ID
	 * 
	 * @return supplierId 创建供应商ID
	 */
	public Long getSupplierId() {
		return supplierId;
	}

	/**
	 * 设置创建供应商ID
	 * 
	 * @param supplierId
	 *            创建供应商ID
	 */
	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}

	/**
	 * 获取查询参数：id集合
	 * 
	 * @return queryIds 查询参数：id集合
	 */
	public List<Long> getQueryIds() {
		return queryIds;
	}

	/**
	 * 设置查询参数：id集合
	 * 
	 * @param queryIds
	 *            查询参数：id集合
	 */
	public void setQueryIds(List<Long> queryIds) {
		this.queryIds = queryIds;
	}

	/**
	 * 获取查询参数：用户id集合
	 * 
	 * @return queryUserIds 查询参数：用户id集合
	 */
	public List<Long> getQueryUserIds() {
		return queryUserIds;
	}

	/**
	 * 设置查询参数：用户id集合
	 * 
	 * @param queryUserIds
	 *            查询参数：用户id集合
	 */
	public void setQueryUserIds(List<Long> queryUserIds) {
		this.queryUserIds = queryUserIds;
	}

	@Override
	public String toString() {
		return "SysChannel [name=" + name + ", channelPrincipal=" + channelPrincipal + ", city=" + city + ", county="
				+ county + ", province=" + province + ", spell=" + spell + ", remark=" + remark + ", channelType="
				+ channelType + ", channelCategory=" + channelCategory + ", delFlag=" + delFlag + ", sort=" + sort
				+ ", createDate=" + createDate + ", updateDate=" + updateDate + ", updateBy=" + updateBy
				+ ", createBy=" + createBy + ", dataSource=" + dataSource + ", supplierId=" + supplierId + "]";
	}

	@Override
	public int hashCode() {
		return this.toString().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return this.toString().equals(obj.toString());
	}

	public Date getCreateDateEnd() {
		return createDateEnd;
	}

	public void setCreateDateEnd(Date createDateEnd) {
		this.createDateEnd = createDateEnd;
	}

	public SysChannel() {
		super();
	};

	public SysChannel(Long supplierId, Long id, String name, Date createDate, Date createEndDate, Integer delFlag) {
		this.supplierId = supplierId;
		setId(id);
		this.name = name;
		this.createDate = createDate;
		this.createDateEnd = createEndDate;
		this.delFlag = delFlag.toString();
	};
}
