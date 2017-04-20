package com.pzj.base.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.pzj.base.common.BaseEntity;
import com.pzj.base.common.global.UserGlobalDict;
import com.pzj.base.entity.common.ObjectDictRelationParam;
import com.pzj.base.entity.common.SysObjectDictRelation;
import com.pzj.base.entity.query.NumericQueryVo;
import com.pzj.base.entity.query.SysDateQuery;

public class SysUser extends BaseEntity implements Serializable {

	private Long rootId;

	/**
	 * 登录名
	 */
	private String loginName;

	/**
	 * 密码
	 */
	private String loginPasswd;

	/** 用户编码 */
	private String sysCode;
	/**二维码*/
	private String twoDimensionCode;

	/** 用户类型 （旅行社；旅行社部门；导游；商户） */
	private String userType;

	/** 身份属性 （个人 或 企业） */
	private String identifyType;

	/** 手机号 */
	@Deprecated
	private String operChargerMobile;

	/** 电话 */
	private String operChargerPhone;

	/** 传真 */
	private String operChargerFax;

	/** 邮件 */
	private String operChargerEmail;

	/** 最后登录时间 */
	private Date lastLoginTime;

	/** 最后登录IP */
	private String lastLoginIp;

	/** 默认登录地址 */
	private String defaultLoginAddress;

	/** 用户状态 1 正常、0禁用 */
	private Integer accountState;

	/** 机构ID */
	private String officeId;

	/** 公司ID */
	private Long companyId;

	/** 父级ID */
	private Long parentId;

	/** 微信绑定账号 */
	private String wxOpenid;

	/** 登录来源 */
	private Integer loginSource;

	/** 公司名称 */
	private String name;

	/** 分销商ID */
	private Long resellerId;

	/** 分销商类型 */
	private String resellerType;

	/** 分销商多个类型，只用于查询 */
	private List<String> resellerTypes;

	/** 是否可买团票 1:是0:否 */
	private Integer isBuygroup;

	/** 是否可买散票 1:是0:否 */
	private Integer isBuysingle;

	/** 分销商等级 */
	private Integer resellerLevel;

	/** 省 */
	private String province;

	/** 市 */
	private String city;

	/** 县 */
	private String county;

	/** 法人名称 */
	private String corporater;

	/** 认证类型：1身份证，2护照，3军人证件 */
	private Integer credentialsType;

	/** 证件号 */
	private String corporaterCredentials;

	/** 法人手机 */
	private String corporaterMobile;

	/** 法人电话 */
	@Deprecated
	private String corporaterPhone;

	/** 法人邮箱 */
	@Deprecated
	private String corporaterEmail;

	/** 导游证号 */
	private String guideCertificate;

	/** 经营许可证 */
	private String businessCertificate;

	/** 营业执照 */
	private String businessLicense;

	/** 经营资质 */
	private String businessQualification;

	/** 机构代码证 */
	private String orgCodeCertificate;

	/** 税务登记证 */
	private String taxCertificate;

	/** 其他资料 */
	private String otherFiles;

	/** 分销商地址 */
	private String address;

	/** 分销商状态：1.申请 2.通过 3.拒绝 4.补材料 -1 失效 */
	private Integer resellerState;

	/** 分销商申请日期 */
	private Date requestDate;

	/** 分销商批准日期 */
	private Date approveDate;

	/** 审核结构 */
	private String approveResult;

	/** 合同号 */
	private String contractNum;

	/** 分销商描述 */
	private String description;

	/** 是否有开微店的权利 0否1是 ？ */
	private Integer wxOpenFlag;

	/** 是否为C商 0否1是 ？ */
	private Integer iscreseller;

	/** 关于 */
	private String aboutUs;

	/** 联系方式 */
	private String contactWay;

	/** 分销商拼写 */
	private String resellerPhoneticShorthand;

	/** 默认AAAAAA供应商级别 */
	private String supplierLevel;

	/** 是否被上级供应商管理 0否 1是 */
	private Integer isManage;

	/** 其他资料1 */
	private String otherFile;

	/** 其他资料2 */
	private String otherFile2;

	/** 供应商ID */
	private Long supplierPk;

	/** 供应商地址 */
	private String supplierAddress;

	/** 供应商状态：1.申请 2.通过 3.拒绝 4.补材料 -1 失效 */
	private Integer supplierState;

	/** 供应商介绍，客栈简介 */
	private String supplierDescription;

	/** 拼音缩写 */
	private String supplierPy;

	/** 俗称 */
	private String supplierNormal;

	/** 代注册公司名称 */
	private String directCompany;

	/** 代注册时间 */
	private Date directTime;

	/** 具体扣点数值 */
	private Double supplierDiscountValue;

	/** 开始结算日期 */
	private Date fromDate;

	/** 结算周期 */
	private Integer period;

	/** 应结算周期 */
	private Date settleDate;

	/** 合同规则 */
	private String contractRemarks;

	/** 合同备注 */
	private String contractNotes;

	/** 供应商Code */
	private String verificationCodes;

	/** 用户来源 */
	private String userSource;

	/** 是否是总店长 1.总店长 2店长 3一般员工 */
	private Integer leaderFlag;

	/** 创建人 */
	private String createBy;

	private Date createDate;

	/**
	 * 创建时间最大值
	 * <p/>
	 * 用于查询，createDate为最小时间，createDateEnd为最大时间，根据此范围查询。
	 */
	private Date createDateEnd;

	/** 更新人 */
	private String updateBy;

	/** 更新人 */
	private Date updateDate;

	/**
	 * 更新时间最大值
	 * <p/>
	 * 用于查询，updateDate为最小时间，updateDateEnd为最大时间，根据此范围查询。
	 */
	private Date updateDateEnd;

	/** 排序（升序） */
	private Integer sort;

	/**
	 * 审核状态
	 */
	private String checkStatus;

	/**
	 * 审核人ID
	 */
	private Long checkUserId;

	/**
	 * 审核人名称
	 */

	private String checkUserName;

	/**
	 * 审核时间
	 */
	private Date checkDate;

	/**
	 * 审核时间最大值
	 * <p/>
	 * 用于查询，checkDate为最小时间，checkDateEnd为最大时间，根据此范围查询。
	 */
	private Date checkDateEnd;

	/**
	 * 票规
	 */
	private String ticketRule;

	/**
	 * 拒绝理由
	 */
	private String reasonRejection;

	/**
	 * 通用标记01
	 */
	private String commonFlag01;

	/**
	 * 通用标记02
	 */
	private String commonFlag02;

	/**
	 * 是否是主帐户
	 */
	private String isRoot;

	/**
	 * 创建供应商ID
	 */
	private Long supplierId;

	private BaseEntity parentRef;

	private List<SysRole> roleList;

	private List<SysMenu> menuList;

	/************************************** start_pms客栈的特有属性字段 **********************************************/
	/** 客栈所属景区Id */
	private Long belongScenicId;

	/** 客栈类型 */
	private Integer hotelType;

	/** 客栈地图 :经度 */
	private Double hotelMapLongitude;

	/** 客栈地图 ：纬度 */
	private Double hotelMapLatitude;

	/** 客栈区域 */
	private String region;

	/** 客栈附近景区 */
	private String scenicInfo;

	/** 客栈时间规定：开始时间 */
	private String hotelStartDate;

	/** 客栈时间规定：结束时间 */
	private String hotelEndDate;

	/** 客栈房间数 */
	private Integer hotelNum;

	/** 客栈可接待人数 */
	private Integer treatPeopelNum;

	/** 客栈特点 */
	private String hotelFeature;

	/** 客栈风光 */
	private String hotelPirture;

	/** 老板故事 */
	private String bossStory;

	/** 老板靓照 */
	private String bossPirture;

	/** 客栈设施 */
	private String hotelFacility;

	/** pms用户更新通知状态 ：1 目前与业务段数据一致 2 需要更新业务端数据 */
	private String notifyUpdateState;

	/** 查询参数: 数值按大于等于，小于等于参数查询 */
	private List<NumericQueryVo> queryNumericList;

	/** 查询参数： 时间段 */
	private List<SysDateQuery> queryDateList;

	/** 查询参数：id集合 */
	private List<Long> queryIdList;

	/** 查询参数：客栈类型集合 */
	private List<Integer> queryHotelType;

	/** 查询参数：全文检索 */
	private String searchRemark;

	/** 推荐人关键字信息*/
	private String refereeInfo;

	/************************************** end_pms客栈的特有属性字段 **********************************************/

	/**
	 * 用户的清洁算信息
	 */
	private SysUserSettlement settlement;

	/**
	 * 是否代注册，只用于查询
	 */
	private Boolean isDirect;

	/** 代注册结束时间，只用于查询 */
	private Date directTimeEnd;

	/**
	 * 邀请码、推荐码
	 */
	private String invitationCode;

	/**
	 * 用户与用户关系
	 */
	private List<SysUserRelation> userRelationList;

	/**
	 * 用户审核状态，多值查询，只用于查询
	 */
	private List<String> checkStatusQuery;

	/**
	 * 用户关联关系创建时间
	 *
	 * 只用于与sys_user_relation表关联查询的接口。
	 */
	private Date userRelationCreateDate;

	/**
	 * 注册来源
	 */
	private Integer regSource;

	/**
	 * 审核类型
	 *
	 * 使用{@link UserGlobalDict.UserCheckType}
	 */
	private Integer checkType;

	/**
	 * 用户审核类型，多值，只用于查询
	 */
	private List<Integer> checkTypeQuery;

	/**
	 * 资质审核状态
	 */
	private Integer qualificationAudit;

	/**
	 * 资质审核状态，多值，只用于查询
	 */
	private List<Integer> qualificationAuditQuery;

	/**
	 * 企业logo
	 */
	private String logo;

	/**
	 * 绑定时间开始点
	 */
	private Date bindDateBegin;

	/**
	 * 绑定时间结束点
	 */
	private Date bindDateEnd;

	/**
	 * 公司名或品牌名查询条件，or的关系
	 */
	private String nameOrNormal;

	/**
	 * 推荐人id
	 */
	private Long refereeId;

	/**
	 * 推荐码
	 */
	private String refereeCode;

	/**
	 * 商务负责人id
	 */
	private Long businessId;
	/**
	 * 服务热线供应商
	 */
	private String hotlineSupplier;
	/**
	 * 服务热线分销商
	 */
	private String hotlineReseller;

	/**
	 * 销售人员所属单位
	 */
	private String department;

	/**
	 * 获取客栈地图 :经度
	 *
	 * @return hotelMapLongitude
	 */
	public Double getHotelMapLongitude() {
		return this.hotelMapLongitude;
	}

	/**
	 * 设置客栈地图 :经度
	 *
	 * @param hotelMapLongitude
	 */
	public void setHotelMapLongitude(Double hotelMapLongitude) {
		this.hotelMapLongitude = hotelMapLongitude;
	}

	/**
	 * 获取客栈地图：纬度
	 *
	 * @return hotelMapLatitude 客栈地图：纬度
	 */
	public Double getHotelMapLatitude() {
		return this.hotelMapLatitude;
	}

	/**
	 * 设置客栈地图：纬度
	 *
	 * @param hotelMapLatitude
	 *            客栈地图：纬度
	 */
	public void setHotelMapLatitude(Double hotelMapLatitude) {
		this.hotelMapLatitude = hotelMapLatitude;
	}

	/**
	 * 获取客栈区域
	 *
	 * @return region
	 */
	public String getRegion() {
		return this.region;
	}

	/**
	 * 设置客栈区域
	 *
	 * @param region
	 */
	public void setRegion(String region) {
		this.region = region;
	}

	/**
	 * 获取客栈附近景区
	 *
	 * @return scenicInfo 客栈附近景区
	 */
	public String getScenicInfo() {
		return this.scenicInfo;
	}

	/**
	 * 设置客栈附近景区
	 *
	 * @param scenicInfo
	 *            客栈附近景区
	 */
	public void setScenicInfo(String scenicInfo) {
		this.scenicInfo = scenicInfo;
	}

	/**
	 * 获取客栈时间规定：开始时间
	 *
	 * @return hotelStartDate 客栈时间规定：开始时间
	 */
	public String getHotelStartDate() {
		return this.hotelStartDate;
	}

	/**
	 * 设置客栈时间规定：开始时间
	 *
	 * @param hotelStartDate
	 *            客栈时间规定：开始时间
	 */
	public void setHotelStartDate(String hotelStartDate) {
		this.hotelStartDate = hotelStartDate;
	}

	/**
	 * 获取客栈时间规定：结束时间
	 *
	 * @return hotelEndDate 客栈时间规定：结束时间
	 */
	public String getHotelEndDate() {
		return this.hotelEndDate;
	}

	/**
	 * 设置客栈时间规定：结束时间
	 *
	 * @param hotelEndDate
	 *            客栈时间规定：结束时间
	 */
	public void setHotelEndDate(String hotelEndDate) {
		this.hotelEndDate = hotelEndDate;
	}

	/**
	 * 获取客栈房间数
	 *
	 * @return hotelNum 客栈房间数
	 */
	public Integer getHotelNum() {
		return this.hotelNum;
	}

	/**
	 * 设置客栈房间数
	 *
	 * @param hotelNum
	 *            客栈房间数
	 */
	public void setHotelNum(Integer hotelNum) {
		this.hotelNum = hotelNum;
	}

	/**
	 * 获取客栈可接待人数
	 *
	 * @return treatPeopelNum 客栈可接待人数
	 */
	public Integer getTreatPeopelNum() {
		return this.treatPeopelNum;
	}

	/**
	 * 设置客栈可接待人数
	 *
	 * @param treatPeopelNum
	 *            客栈可接待人数
	 */
	public void setTreatPeopelNum(Integer treatPeopelNum) {
		this.treatPeopelNum = treatPeopelNum;
	}

	/**
	 * 获取客栈设施
	 *
	 * @return hotelFacility 客栈设施
	 */
	public String getHotelFacility() {
		return this.hotelFacility;
	}

	/**
	 * 设置客栈设施
	 *
	 * @param hotelFacility
	 *            客栈设施
	 */
	public void setHotelFacility(String hotelFacility) {
		this.hotelFacility = hotelFacility;
	}

	/**
	 * 获取客栈特点
	 *
	 * @return hotelFeature 客栈特点
	 */
	public String getHotelFeature() {
		return this.hotelFeature;
	}

	/**
	 * 设置客栈特点
	 *
	 * @param hotelFeature
	 *            客栈特点
	 */
	public void setHotelFeature(String hotelFeature) {
		this.hotelFeature = hotelFeature;
	}

	/**
	 * 获取客栈风光
	 *
	 * @return hotelPirture 客栈风光
	 */
	public String getHotelPirture() {
		return this.hotelPirture;
	}

	/**
	 * 设置客栈风光
	 *
	 * @param hotelPirture
	 *            客栈风光
	 */
	public void setHotelPirture(String hotelPirture) {
		this.hotelPirture = hotelPirture;
	}

	/**
	 * 获取老板故事
	 *
	 * @return bossStory 老板故事
	 */
	public String getBossStory() {
		return this.bossStory;
	}

	/**
	 * 设置老板故事
	 *
	 * @param bossStory
	 *            老板故事
	 */
	public void setBossStory(String bossStory) {
		this.bossStory = bossStory;
	}

	/**
	 * 获取老板靓照
	 *
	 * @return bossPirture 老板靓照
	 */
	public String getBossPirture() {
		return this.bossPirture;
	}

	/**
	 * 设置老板靓照
	 *
	 * @param bossPirture
	 *            老板靓照
	 */
	public void setBossPirture(String bossPirture) {
		this.bossPirture = bossPirture;
	}

	/**
	 * 获取pms用户更新通知状态：1目前与业务段数据一致2需要更新业务端数据
	 *
	 * @return notifyUpdateState pms用户更新通知状态：1目前与业务段数据一致2需要更新业务端数据
	 */
	public String getNotifyUpdateState() {
		return this.notifyUpdateState;
	}

	/**
	 * 设置pms用户更新通知状态：1目前与业务段数据一致2需要更新业务端数据
	 *
	 * @param notifyUpdateState
	 *            pms用户更新通知状态：1目前与业务段数据一致2需要更新业务端数据
	 */
	public void setNotifyUpdateState(String notifyUpdateState) {
		this.notifyUpdateState = notifyUpdateState;
	}

	public Integer getLeaderFlag() {
		return this.leaderFlag;
	}

	public Integer getSort() {
		return this.sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public void setLeaderFlag(Integer leaderFlag) {
		this.leaderFlag = leaderFlag;
	}

	public String getLoginName() {
		return this.loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName == null ? null : loginName.trim();
	}

	public String getLoginPasswd() {
		return this.loginPasswd;
	}

	public void setLoginPasswd(String loginPasswd) {
		this.loginPasswd = loginPasswd == null ? null : loginPasswd.trim();
	}

	public String getSysCode() {
		return this.sysCode;
	}

	public void setSysCode(String sysCode) {
		this.sysCode = sysCode == null ? null : sysCode.trim();
	}

	public String getUserType() {
		return this.userType;
	}

	public void setUserType(String userType) {
		this.userType = userType == null ? null : userType.trim();
	}

	public String getOperChargerMobile() {
		return this.operChargerMobile;
	}

	public void setOperChargerMobile(String operChargerMobile) {
		this.operChargerMobile = operChargerMobile == null ? null : operChargerMobile.trim();
	}

	public String getOperChargerPhone() {
		return this.operChargerPhone;
	}

	public void setOperChargerPhone(String operChargerPhone) {
		this.operChargerPhone = operChargerPhone == null ? null : operChargerPhone.trim();
	}

	public String getOperChargerFax() {
		return this.operChargerFax;
	}

	public void setOperChargerFax(String operChargerFax) {
		this.operChargerFax = operChargerFax == null ? null : operChargerFax.trim();
	}

	public String getOperChargerEmail() {
		return this.operChargerEmail;
	}

	public void setOperChargerEmail(String operChargerEmail) {
		this.operChargerEmail = operChargerEmail == null ? null : operChargerEmail.trim();
	}

	public Date getLastLoginTime() {
		return this.lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public String getLastLoginIp() {
		return this.lastLoginIp;
	}

	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp == null ? null : lastLoginIp.trim();
	}

	public Integer getAccountState() {
		return this.accountState;
	}

	public void setAccountState(Integer accountState) {
		this.accountState = accountState;
	}

	public String getOfficeId() {
		return this.officeId;
	}

	public void setOfficeId(String officeId) {
		this.officeId = officeId == null ? null : officeId.trim();
	}

	public Long getCompanyId() {
		return this.companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public Long getParentId() {
		return this.parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getWxOpenid() {
		return this.wxOpenid;
	}

	public void setWxOpenid(String wxOpenid) {
		this.wxOpenid = wxOpenid == null ? null : wxOpenid.trim();
	}

	public Integer getLoginSource() {
		return this.loginSource;
	}

	public void setLoginSource(Integer loginSource) {
		this.loginSource = loginSource;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public String getResellerType() {
		return this.resellerType;
	}

	public void setResellerType(String resellerType) {
		this.resellerType = resellerType == null ? null : resellerType.trim();
	}

	public Integer getIsBuygroup() {
		return this.isBuygroup;
	}

	public void setIsBuygroup(Integer isBuygroup) {
		this.isBuygroup = isBuygroup;
	}

	public Integer getIsBuysingle() {
		return this.isBuysingle;
	}

	public void setIsBuysingle(Integer isBuysingle) {
		this.isBuysingle = isBuysingle;
	}

	public Integer getResellerLevel() {
		return this.resellerLevel;
	}

	public void setResellerLevel(Integer resellerLevel) {
		this.resellerLevel = resellerLevel;
	}

	public String getProvince() {
		return this.province;
	}

	public void setProvince(String province) {
		this.province = province == null ? null : province.trim();
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city == null ? null : city.trim();
	}

	public String getCounty() {
		return this.county;
	}

	public void setCounty(String county) {
		this.county = county == null ? null : county.trim();
	}

	public String getCorporater() {
		return this.corporater;
	}

	public void setCorporater(String corporater) {
		this.corporater = corporater == null ? null : corporater.trim();
	}

	public Integer getCredentialsType() {
		return this.credentialsType;
	}

	public void setCredentialsType(Integer credentialsType) {
		this.credentialsType = credentialsType;
	}

	public String getCorporaterCredentials() {
		return this.corporaterCredentials;
	}

	public void setCorporaterCredentials(String corporaterCredentials) {
		this.corporaterCredentials = corporaterCredentials == null ? null : corporaterCredentials.trim();
	}

	public String getCorporaterMobile() {
		return this.corporaterMobile;
	}

	public void setCorporaterMobile(String corporaterMobile) {
		this.corporaterMobile = corporaterMobile == null ? null : corporaterMobile.trim();
	}

	public String getCorporaterPhone() {
		return this.corporaterPhone;
	}

	public void setCorporaterPhone(String corporaterPhone) {
		this.corporaterPhone = corporaterPhone == null ? null : corporaterPhone.trim();
	}

	public String getCorporaterEmail() {
		return this.corporaterEmail;
	}

	public void setCorporaterEmail(String corporaterEmail) {
		this.corporaterEmail = corporaterEmail == null ? null : corporaterEmail.trim();
	}

	public String getBusinessCertificate() {
		return this.businessCertificate;
	}

	public void setBusinessCertificate(String businessCertificate) {
		this.businessCertificate = businessCertificate == null ? null : businessCertificate.trim();
	}

	public String getBusinessLicense() {
		return this.businessLicense;
	}

	public void setBusinessLicense(String businessLicense) {
		this.businessLicense = businessLicense == null ? null : businessLicense.trim();
	}

	public String getOrgCodeCertificate() {
		return this.orgCodeCertificate;
	}

	public void setOrgCodeCertificate(String orgCodeCertificate) {
		this.orgCodeCertificate = orgCodeCertificate == null ? null : orgCodeCertificate.trim();
	}

	public String getTaxCertificate() {
		return this.taxCertificate;
	}

	public void setTaxCertificate(String taxCertificate) {
		this.taxCertificate = taxCertificate == null ? null : taxCertificate.trim();
	}

	public String getOtherFiles() {
		return this.otherFiles;
	}

	public void setOtherFiles(String otherFiles) {
		this.otherFiles = otherFiles == null ? null : otherFiles.trim();
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address == null ? null : address.trim();
	}

	public Integer getResellerState() {
		return this.resellerState;
	}

	public void setResellerState(Integer resellerState) {
		this.resellerState = resellerState;
	}

	public Date getRequestDate() {
		return this.requestDate;
	}

	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}

	public Date getApproveDate() {
		return this.approveDate;
	}

	public void setApproveDate(Date approveDate) {
		this.approveDate = approveDate;
	}

	public String getApproveResult() {
		return this.approveResult;
	}

	public void setApproveResult(String approveResult) {
		this.approveResult = approveResult == null ? null : approveResult.trim();
	}

	public String getContractNum() {
		return this.contractNum;
	}

	public void setContractNum(String contractNum) {
		this.contractNum = contractNum == null ? null : contractNum.trim();
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description == null ? null : description.trim();
	}

	public Integer getWxOpenFlag() {
		return this.wxOpenFlag;
	}

	public void setWxOpenFlag(Integer wxOpenFlag) {
		this.wxOpenFlag = wxOpenFlag;
	}

	public Integer getIscreseller() {
		return this.iscreseller;
	}

	public void setIscreseller(Integer iscreseller) {
		this.iscreseller = iscreseller;
	}

	public String getAboutUs() {
		return this.aboutUs;
	}

	public void setAboutUs(String aboutUs) {
		this.aboutUs = aboutUs == null ? null : aboutUs.trim();
	}

	public String getContactWay() {
		return this.contactWay;
	}

	public void setContactWay(String contactWay) {
		this.contactWay = contactWay == null ? null : contactWay.trim();
	}

	public String getResellerPhoneticShorthand() {
		return this.resellerPhoneticShorthand;
	}

	public void setResellerPhoneticShorthand(String resellerPhoneticShorthand) {
		this.resellerPhoneticShorthand = resellerPhoneticShorthand == null ? null : resellerPhoneticShorthand.trim();
	}

	public String getSupplierLevel() {
		return this.supplierLevel;
	}

	public void setSupplierLevel(String supplierLevel) {
		this.supplierLevel = supplierLevel == null ? null : supplierLevel.trim();
	}

	public Integer getIsManage() {
		return this.isManage;
	}

	public void setIsManage(Integer isManage) {
		this.isManage = isManage;
	}

	public String getOtherFile() {
		return this.otherFile;
	}

	public void setOtherFile(String otherFile) {
		this.otherFile = otherFile == null ? null : otherFile.trim();
	}

	public String getOtherFile2() {
		return this.otherFile2;
	}

	public void setOtherFile2(String otherFile2) {
		this.otherFile2 = otherFile2 == null ? null : otherFile2.trim();
	}

	public String getSupplierAddress() {
		return this.supplierAddress;
	}

	public void setSupplierAddress(String supplierAddress) {
		this.supplierAddress = supplierAddress == null ? null : supplierAddress.trim();
	}

	public Integer getSupplierState() {
		return this.supplierState;
	}

	public void setSupplierState(Integer supplierState) {
		this.supplierState = supplierState;
	}

	public String getSupplierDescription() {
		return this.supplierDescription;
	}

	public void setSupplierDescription(String supplierDescription) {
		this.supplierDescription = supplierDescription == null ? null : supplierDescription.trim();
	}

	public String getSupplierPy() {
		return this.supplierPy;
	}

	public void setSupplierPy(String supplierPy) {
		this.supplierPy = supplierPy == null ? null : supplierPy.trim();
	}

	public String getSupplierNormal() {
		return this.supplierNormal;
	}

	public void setSupplierNormal(String supplierNormal) {
		this.supplierNormal = supplierNormal == null ? null : supplierNormal.trim();
	}

	public Double getSupplierDiscountValue() {
		return this.supplierDiscountValue;
	}

	public void setSupplierDiscountValue(Double supplierDiscountValue) {
		this.supplierDiscountValue = supplierDiscountValue;
	}

	public Date getFromDate() {
		return this.fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Integer getPeriod() {
		return this.period;
	}

	public void setPeriod(Integer period) {
		this.period = period;
	}

	public Date getSettleDate() {
		return this.settleDate;
	}

	public void setSettleDate(Date settleDate) {
		this.settleDate = settleDate;
	}

	public String getContractRemarks() {
		return this.contractRemarks;
	}

	public void setContractRemarks(String contractRemarks) {
		this.contractRemarks = contractRemarks == null ? null : contractRemarks.trim();
	}

	public String getContractNotes() {
		return this.contractNotes;
	}

	public void setContractNotes(String contractNotes) {
		this.contractNotes = contractNotes == null ? null : contractNotes.trim();
	}

	public String getVerificationCodes() {
		return this.verificationCodes;
	}

	public void setVerificationCodes(String verificationCodes) {
		this.verificationCodes = verificationCodes == null ? null : verificationCodes.trim();
	}

	public String getUserSource() {
		return this.userSource;
	}

	public void setUserSource(String userSource) {
		this.userSource = userSource == null ? null : userSource.trim();
	}

	public String getCreateBy() {
		return this.createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getUpdateBy() {
		return this.updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	/**
	 * 获取票规
	 *
	 * @return
	 */
	public String getTicketRule() {
		return this.ticketRule;
	}

	/**
	 * 设置票规
	 *
	 * @param ticketRule
	 */
	public void setTicketRule(String ticketRule) {
		this.ticketRule = ticketRule;
	}

	public String getCheckStatus() {
		return this.checkStatus;
	}

	public void setCheckStatus(String checkStatus) {
		this.checkStatus = checkStatus;
	}

	public String getReasonRejection() {
		return this.reasonRejection;
	}

	public void setReasonRejection(String reasonRejection) {
		this.reasonRejection = reasonRejection;
	}

	public String getCommonFlag01() {
		return this.commonFlag01;
	}

	public void setCommonFlag01(String commonFlag01) {
		this.commonFlag01 = commonFlag01;
	}

	public String getCommonFlag02() {
		return this.commonFlag02;
	}

	public void setCommonFlag02(String commonFlag02) {
		this.commonFlag02 = commonFlag02;
	}

	public BaseEntity getParentRef() {
		return this.parentRef;
	}

	public void setParentRef(BaseEntity parentRef) {
		this.parentRef = parentRef;
	}

	public List<SysRole> getRoleList() {
		return this.roleList;
	}

	public void setRoleList(List<SysRole> roleList) {
		this.roleList = roleList;
	}

	public List<SysMenu> getMenuList() {
		return this.menuList;
	}

	public void setMenuList(List<SysMenu> menuList) {
		this.menuList = menuList;
	}

	public Long getRootId() {
		return this.rootId;
	}

	public void setRootId(Long rootId) {
		this.rootId = rootId;
	}

	/**
	 * 获取是否是主帐户
	 *
	 * @return isRoot 是否是主帐户
	 */
	public String getIsRoot() {
		return this.isRoot;
	}

	/**
	 * 设置是否是主帐户
	 *
	 * @param isRoot
	 *            是否是主帐户
	 */
	public void setIsRoot(String isRoot) {
		this.isRoot = isRoot;
	}

	/**
	 * 获取创建供应商ID
	 *
	 * @return supplierId 创建供应商ID
	 */
	public Long getSupplierId() {
		return this.supplierId;
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

	public Long getCheckUserId() {
		return this.checkUserId;
	}

	public void setCheckUserId(Long checkUserId) {
		this.checkUserId = checkUserId;
	}

	public String getCheckUserName() {
		return this.checkUserName;
	}

	public void setCheckUserName(String checkUserName) {
		this.checkUserName = checkUserName;
	}

	public Date getCheckDate() {
		return this.checkDate;
	}

	public void setCheckDate(Date checkDate) {
		this.checkDate = checkDate;
	}

	public Date getCreateDateEnd() {
		return this.createDateEnd;
	}

	public void setCreateDateEnd(Date createDateEnd) {
		this.createDateEnd = createDateEnd;
	}

	public Date getUpdateDateEnd() {
		return this.updateDateEnd;
	}

	public void setUpdateDateEnd(Date updateDateEnd) {
		this.updateDateEnd = updateDateEnd;
	}

	public Date getCheckDateEnd() {
		return this.checkDateEnd;
	}

	public void setCheckDateEnd(Date checkDateEnd) {
		this.checkDateEnd = checkDateEnd;
	}

	public String getBusinessQualification() {
		return this.businessQualification;
	}

	public void setBusinessQualification(String businessQualification) {
		this.businessQualification = businessQualification;
	}

	public SysUserSettlement getSettlement() {
		return this.settlement;
	}

	public void setSettlement(SysUserSettlement settlement) {
		this.settlement = settlement;
	}

	public String getIdentifyType() {
		return this.identifyType;
	}

	public void setIdentifyType(String identifyType) {
		this.identifyType = identifyType;
	}

	public String getDefaultLoginAddress() {
		return this.defaultLoginAddress;
	}

	public void setDefaultLoginAddress(String defaultLoginAddress) {
		this.defaultLoginAddress = defaultLoginAddress;
	}

	public String getGuideCertificate() {
		return this.guideCertificate;
	}

	public void setGuideCertificate(String guideCertificate) {
		this.guideCertificate = guideCertificate;
	}

	public Long getBelongScenicId() {
		return this.belongScenicId;
	}

	public void setBelongScenicId(Long belongScenicId) {
		this.belongScenicId = belongScenicId;
	}

	public Integer getHotelType() {
		return this.hotelType;
	}

	public void setHotelType(Integer hotelType) {
		this.hotelType = hotelType;
	}

	public String getDirectCompany() {
		return this.directCompany;
	}

	public void setDirectCompany(String directCompany) {
		this.directCompany = directCompany;
	}

	public Date getDirectTime() {
		return this.directTime;
	}

	public void setDirectTime(Date directTime) {
		this.directTime = directTime;
	}

	public Long getResellerId() {
		return this.resellerId;
	}

	public void setResellerId(Long resellerId) {
		this.resellerId = resellerId;
	}

	public Long getSupplierPk() {
		return this.supplierPk;
	}

	public void setSupplierPk(Long supplierPk) {
		this.supplierPk = supplierPk;
	}

	/**
	 * 获取查询参数:数值按大于等于，小于等于参数查询
	 *
	 * @return queryNumericList 查询参数:数值按大于等于，小于等于参数查询
	 */
	public List<NumericQueryVo> getQueryNumericList() {
		return this.queryNumericList;
	}

	/**
	 * 设置查询参数:数值按大于等于，小于等于参数查询
	 *
	 * @param queryNumericList
	 *            查询参数:数值按大于等于，小于等于参数查询
	 */
	public void setQueryNumericList(List<NumericQueryVo> queryNumericList) {
		this.queryNumericList = queryNumericList;
	}

	/**
	 * 获取查询参数：时间段
	 *
	 * @return queryDateList 查询参数：时间段
	 */
	public List<SysDateQuery> getQueryDateList() {
		return this.queryDateList;
	}

	/**
	 * 设置查询参数：时间段
	 *
	 * @param queryDateList
	 *            查询参数：时间段
	 */
	public void setQueryDateList(List<SysDateQuery> queryDateList) {
		this.queryDateList = queryDateList;
	}

	/**
	 * 获取查询参数：id集合
	 *
	 * @return queryIdList 查询参数：id集合
	 */
	public List<Long> getQueryIdList() {
		return this.queryIdList;
	}

	/**
	 * 设置查询参数：id集合
	 *
	 * @param queryIdList
	 *            查询参数：id集合
	 */
	public void setQueryIdList(List<Long> queryIdList) {
		this.queryIdList = queryIdList;
	}

	/**
	 * 获取查询参数：客栈类型集合
	 *
	 * @return queryHotelType 查询参数：客栈类型集合
	 */
	public List<Integer> getQueryHotelType() {
		return this.queryHotelType;
	}

	/**
	 * 设置查询参数：客栈类型集合
	 *
	 * @param queryHotelType
	 *            查询参数：客栈类型集合
	 */
	public void setQueryHotelType(List<Integer> queryHotelType) {
		this.queryHotelType = queryHotelType;
	}

	/**
	 * 获取查询参数：全文检索
	 *
	 * @return searchRemark 查询参数：全文检索
	 */
	public String getSearchRemark() {
		return this.searchRemark;
	}

	/**
	 * 设置查询参数：全文检索
	 *
	 * @param searchRemark
	 *            查询参数：全文检索
	 */
	public void setSearchRemark(String searchRemark) {
		this.searchRemark = searchRemark;
	}

	public Boolean getDirect() {
		return this.isDirect;
	}

	public void setDirect(Boolean direct) {
		this.isDirect = direct;
	}

	public Date getDirectTimeEnd() {
		return this.directTimeEnd;
	}

	public void setDirectTimeEnd(Date directTimeEnd) {
		this.directTimeEnd = directTimeEnd;
	}

	@Override
	public List<SysObjectDictRelation> getDictRelationList() {
		List<SysObjectDictRelation> result = new ArrayList<>();

		String hotelFacility = this.getHotelFacility();
		result.add(SysObjectDictRelation.convertTSysBean(hotelFacility,
				ObjectDictRelationParam.UserDictRelationParam.DICT_OBJECT,
				ObjectDictRelationParam.UserDictRelationParam.DICT__HOTEL_FACILITY, this.getId()));
		String scenicInfo = this.getScenicInfo();
		result.add(SysObjectDictRelation.convertTSysBean(scenicInfo,
				ObjectDictRelationParam.UserDictRelationParam.DICT_OBJECT,
				ObjectDictRelationParam.UserDictRelationParam.DICT_SCENIC_INFO, this.getId()));
		String hotelFeature = this.getHotelFeature();
		result.add(SysObjectDictRelation.convertTSysBean(hotelFeature,
				ObjectDictRelationParam.UserDictRelationParam.DICT_OBJECT,
				ObjectDictRelationParam.UserDictRelationParam.DICT_HOTEL_FEATURE, this.getId()));
		return result;
	}

	public String getTwoDimensionCode() {
		return this.twoDimensionCode;
	}

	public void setTwoDimensionCode(String twoDimensionCode) {
		this.twoDimensionCode = twoDimensionCode;
	}

	public String getInvitationCode() {
		return invitationCode;
	}

	public void setInvitationCode(String invitationCode) {
		this.invitationCode = invitationCode;
	}

	public List<SysUserRelation> getUserRelationList() {
		return userRelationList;
	}

	public void setUserRelationList(List<SysUserRelation> userRelationList) {
		this.userRelationList = userRelationList;
	}

	public List<String> getCheckStatusQuery() {
		return checkStatusQuery;
	}

	public void setCheckStatusQuery(List<String> checkStatusQuery) {
		this.checkStatusQuery = checkStatusQuery;
	}

	public Date getUserRelationCreateDate() {
		return userRelationCreateDate;
	}

	public void setUserRelationCreateDate(Date userRelationCreateDate) {
		this.userRelationCreateDate = userRelationCreateDate;
	}

	public List<String> getResellerTypes() {
		return resellerTypes;
	}

	public void setResellerTypes(List<String> resellerTypes) {
		this.resellerTypes = resellerTypes;
	}

	public Integer getCheckType() {
		return checkType;
	}

	public void setCheckType(Integer checkType) {
		this.checkType = checkType;
	}

	public List<Integer> getCheckTypeQuery() {
		return checkTypeQuery;
	}

	public void setCheckTypeQuery(List<Integer> checkTypeQuery) {
		this.checkTypeQuery = checkTypeQuery;
	}

	public Integer getQualificationAudit() {
		return qualificationAudit;
	}

	public void setQualificationAudit(Integer qualificationAudit) {
		this.qualificationAudit = qualificationAudit;
	}

	public List<Integer> getQualificationAuditQuery() {
		return qualificationAuditQuery;
	}

	public void setQualificationAuditQuery(List<Integer> qualificationAuditQuery) {
		this.qualificationAuditQuery = qualificationAuditQuery;
	}

	public Integer getRegSource() {
		return regSource;
	}

	public void setRegSource(Integer regSource) {
		this.regSource = regSource;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getRefereeInfo() {
		return refereeInfo;
	}

	public void setRefereeInfo(String refereeInfo) {
		this.refereeInfo = refereeInfo;
	}

	public Date getBindDateBegin() {
		return bindDateBegin;
	}

	public void setBindDateBegin(Date bindDateBegin) {
		this.bindDateBegin = bindDateBegin;
	}

	public Date getBindDateEnd() {
		return bindDateEnd;
	}

	public void setBindDateEnd(Date bindDateEnd) {
		this.bindDateEnd = bindDateEnd;
	}

	public String getNameOrNormal() {
		return nameOrNormal;
	}

	public void setNameOrNormal(String nameOrNormal) {
		this.nameOrNormal = nameOrNormal;
	}

	public Long getRefereeId() {
		return refereeId;
	}

	public void setRefereeId(Long refereeId) {
		this.refereeId = refereeId;
	}

	public String getRefereeCode() {
		return refereeCode;
	}

	public void setRefereeCode(String refereeCode) {
		this.refereeCode = refereeCode;
	}

	public Long getBusinessId() {
		return businessId;
	}

	public void setBusinessId(Long businessId) {
		this.businessId = businessId;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Boolean getIsDirect() {
		return isDirect;
	}

	public void setIsDirect(Boolean isDirect) {
		this.isDirect = isDirect;
	}

	public String getHotlineSupplier() {
		return hotlineSupplier;
	}

	public void setHotlineSupplier(String hotlineSupplier) {
		this.hotlineSupplier = hotlineSupplier;
	}

	public String getHotlineReseller() {
		return hotlineReseller;
	}

	public void setHotlineReseller(String hotlineReseller) {
		this.hotlineReseller = hotlineReseller;
	}

	public SysUser() {
		super();
	};

	public SysUser(String loginName, String name, String supplierNormal, String identifyType, String corporaterMobile,
			String corporater, String corporaterCredentials, String businessCertificate, String businessLicense,
			String guideCertificate, String address, String operChargerPhone, String operChargerFax,
			String operChargerEmail, String createBy, Long refereeId, Long businessId, String refereeCode,
			String province, String city, String county, String resellerType) {
		this.loginName = loginName;
		this.name = name;
		this.supplierNormal = supplierNormal;
		this.identifyType = identifyType;
		this.corporaterMobile = corporaterMobile;
		this.corporater = corporater;
		this.corporaterCredentials = corporaterCredentials;
		this.businessCertificate = businessCertificate;
		this.businessLicense = businessLicense;
		this.guideCertificate = guideCertificate;
		this.address = address;
		this.operChargerPhone = operChargerPhone;
		this.operChargerFax = operChargerFax;
		this.operChargerEmail = operChargerEmail;
		this.createBy = createBy;
		this.refereeId = refereeId;
		this.businessId = businessId;
		this.refereeCode = refereeCode;
		this.province = province;
		this.city = city;
		this.county = county;
		this.resellerType = resellerType;
	};

	public SysUser(String corporaterMobile, String corporater, String name, Long id) {
		this.corporaterMobile = corporaterMobile;
		this.corporater = corporater;
		this.name = name;
		setId(id);
	}

}