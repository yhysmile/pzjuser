package com.pzj.customer.entity;

import static com.pzj.customer.entity.CustomerBuilder.ACustomerBuilder;
import static com.pzj.util.ServiceUtil.checkLengthMax;
import static com.pzj.util.ServiceUtil.checkLengthMin;
import static com.pzj.util.ServiceUtil.checkNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.pzj.base.common.global.UserGlobalDict;
import org.apache.commons.lang3.StringUtils;

import com.pzj.authority.entity.DepartmentAuthCustomerRole;
import com.pzj.base.common.ServiceException;
import com.pzj.base.common.security.MD5Utils;
import com.pzj.base.entity.SysUser;
import com.pzj.channel.entity.ChannelVo;
import com.pzj.department.entity.Department;
import com.pzj.menu.entity.Menu;
import com.pzj.role.entity.Role;
import com.pzj.util.CommonEntity;
import com.pzj.util.KeyValueVo;

/**
 * 用户
 * 
 * @author huxiaona
 * 
 */
public class Customer extends CommonEntity implements Serializable {

	private static final long serialVersionUID = 4655830426045978118L;

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

	/** 结构名称 */
	private String name;

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

	/** 经营许可证 */
	private String businessCertificate;

	/** 导游证号 */
	private String guideCertificate;

	/**
	 * 是否代注册，只用于查询
	 */
	private Boolean isDirect;

	/** 代注册公司名称 */
	private String directCompany;

	/** 代注册时间 */
	private Date directTime;

	/** 代注册结束时间，只用于查询 */
	private Date directTimeEnd;

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

	/** 分销商ID */
	private Long resellerId;

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
	@Deprecated
	private String userSource;

	/** 是否是总店长 1.总店长 2店长 3一般员工 */
	private Integer leaderFlag;

	/** 创建人 */
	private String createBy;

	/**
	 * 创建时间最大值
	 * <p/>
	 * 用于查询，createDate为最小时间，createDateEnd为最大时间，根据此范围查询。
	 */
	private Date createDateEnd;

	/** 更新人 */
	private String updateBy;

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

	/** 票规则 ， 需要再db和服务层增加票规字段，存储方式为 字典表类型:value，区分 */
	private List<KeyValueVo> rule;

	/**
	 * Token
	 */
	private String token;

	/** 用户下的菜单列表 */
	private List<Menu> menuList;

	/** 用户下的角色列表 */
	private List<Role> roleList;

	/** 用户下的部门列表 */
	private List<Department> departmentList;

	/** 用户部门 角色的对应关系列表 */
	private List<DepartmentAuthCustomerRole> dcrList;

	/** 渠道 */
	private List<ChannelVo> channelVoList;

	/** 景区主键集合 （查询） **/
	private List<Long> scenicList;

	/** 微店集合(查询) **/
	private List<Long> wdList;

	/** 用户常用信息 */
	private List<Customer> commonInfoList;

	/**
	 * 用户关联的售票点集合
	 */
	private List<Long> salePointList;

	/**
	 * 审核人ID
	 */
	private Long checkCustomerId;

	/**
	 * 审核人名称
	 */

	private String checkCustomerName;

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
	 * 是否模糊查询
	 *
	 * 用于API接口在使用，当为true时查询接口会将参数添加上模糊匹配符。
	 */
	private boolean isNeedLike = false;

	/**
	 * 用于查询，表示条件之前是并且的关系。
	 * <p/>
	 * 在SysUserMapper.xml的selectUserExclusiveUserRelation中使用
	 */
	private Boolean whereIsAnd = true;
	/**
	 * 用于查询，表示查询关联的用户，否则查询没有关联的用户。
	 * <p/>
	 * 在SysUserMapper.xml的selectUserExclusiveUserRelation中使用
	 */
	private Boolean inclusiveRelationUser = true;

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
	private List<KeyValueVo> scenicInfo;

	/** 客栈时间规定：开始时间 */
	private String hotelStartDate;

	/** 客栈时间规定：结束时间 */
	private String hotelEndDate;

	/** 客栈房间数 */
	private Integer hotelNum;

	/** 客栈可接待人数 */
	private Integer treatPeopelNum;

	/** 新建/查询参数：客栈设施 */
	private List<KeyValueVo> hotelFacility;

	/** 客栈特点 */
	private List<KeyValueVo> hotelFeature;

	/** 客栈风光,多地址用,隔开 */
	private String hotelPirture;

	/** 老板故事 */
	private String bossStory;

	/** 老板靓照 */
	private String bossPirture;

	/** pms用户更新通知状态 ：1 目前与业务段数据一致 2 需要更新业务端数据 */
	private String notifyUpdateState;

	/************************************** end_pms客栈的特有属性字段 **********************************************/

	/**
	 * 邀请码、推荐码
	 */
	private String invitationCode;

	/**
	 * 邀请人名字、推荐人名字
	 *
	 * 数据库中无对应字段，服务也不使用，冗余的，由前端自己拼数据使用。
	 */
	private String invitationName;

	/**
	 * 用户清结算信息
	 */
	private CustomerSettlement settlement;

	/**
	 * 用户与用户关系
	 */
	private List<CustomerRelation> customerRelationList;

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


    public Long getBelongScenicId() {
		return belongScenicId;
	}

	public void setBelongScenicId(Long belongScenicId) {
		this.belongScenicId = belongScenicId;
	}

	public Integer getHotelType() {
		return hotelType;
	}

	public void setHotelType(Integer hotelType) {
		this.hotelType = hotelType;
	}

	/**
	 * 获取客栈区域
	 *
	 * @return region
	 */
	public String getRegion() {
		return region;
	}

	/**
	 * 获取 客栈地图：经度
	 *
	 * @return hotelMapLongitude
	 */
	public Double getHotelMapLongitude() {
		return hotelMapLongitude;
	}

	/**
	 * 设置客栈地图：经度
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
		return hotelMapLatitude;
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
	public List<KeyValueVo> getScenicInfo() {
		return scenicInfo;
	}

	/**
	 * 设置客栈附近景区
	 *
	 * @param scenicInfo
	 *            客栈附近景区
	 */
	public void setScenicInfo(List<KeyValueVo> scenicInfo) {
		this.scenicInfo = scenicInfo;
	}

	/**
	 * 获取客栈时间规定：开始时间
	 *
	 * @return hotelStartDate 客栈时间规定：开始时间
	 */
	public String getHotelStartDate() {
		return hotelStartDate;
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
		return hotelEndDate;
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
		return hotelNum;
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
        return treatPeopelNum;
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
    public List<KeyValueVo> getHotelFacility() {
        return hotelFacility;
    }

    /**
     * 设置客栈设施
     * 
     * @param hotelFacility
     *            客栈设施
     */
    public void setHotelFacility(List<KeyValueVo> hotelFacility) {
        this.hotelFacility = hotelFacility;
    }

    /**
     * 获取客栈特点
     * 
     * @return hotelFeature 客栈特点
     */
    public List<KeyValueVo> getHotelFeature() {
        return hotelFeature;
    }

    /**
     * 设置客栈特点
     * 
     * @param hotelFeature
     *            客栈特点
     */
    public void setHotelFeature(List<KeyValueVo> hotelFeature) {
        this.hotelFeature = hotelFeature;
    }

    /**
     * 获取客栈风光
     * 
     * @return hotelPirture 客栈风光
     */
    public String getHotelPirture() {
        return hotelPirture;
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
        return bossStory;
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
        return bossPirture;
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
     * 设置是否模糊查询用于API接口在使用，当为true时查询接口会将参数添加上模糊匹配符。
     * 
     * @param isNeedLike
     *            是否模糊查询用于API接口在使用，当为true时查询接口会将参数添加上模糊匹配符。
     */
    public void setNeedLike(boolean isNeedLike) {
        this.isNeedLike = isNeedLike;
    }

    /**
     * 获取排序（升序）
     * 
     * @return sort 排序（升序）
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 设置排序（升序）
     * 
     * @param sort
     *            排序（升序）
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

	public List<KeyValueVo> getRule() {
		return rule;
	}

	public void setRule(List<KeyValueVo> rule) {
		this.rule = rule;
	}

	/**
	 * 获取Token
	 *
	 * @return token Token
	 */
	public String getToken() {
		return token;
	}

	/**
	 * 设置Token
	 *
	 * @param token
	 *            Token
	 */
	public void setToken(String token) {
		this.token = token;
	}

	/**
	 * 获取用户部门角色的对应关系列表
	 *
	 * @return dcrList 用户部门角色的对应关系列表
	 */
	public List<DepartmentAuthCustomerRole> getDcrList() {
		return dcrList;
	}

	/**
	 * 设置用户部门角色的对应关系列表
	 *
	 * @param dcrList
	 *            用户部门角色的对应关系列表
	 */
	public void setDcrList(List<DepartmentAuthCustomerRole> dcrList) {
		this.dcrList = dcrList;
	}

	public Integer getLeaderFlag() {
		return leaderFlag;
	}

	public void setLeaderFlag(Integer leaderFlag) {
		this.leaderFlag = leaderFlag;
	}

	/**
	 * 获取登录名
	 *
	 * @return loginName 登录名
	 */
	public String getLoginName() {
		return loginName;
	}

	/**
	 * 设置登录名
	 *
	 * @param loginName
	 *            登录名
	 */
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	/**
	 * 获取密码
	 *
	 * @return loginPasswd 密码
	 */
	public String getLoginPasswd() {
		return loginPasswd;
	}

	/**
	 * 设置密码
	 *
	 * @param loginPasswd
	 *            密码
	 */
	public void setLoginPasswd(String loginPasswd) {
		this.loginPasswd = loginPasswd;
	}

	/**
	 * 获取用户编码
	 *
	 * @return sysCode 用户编码
	 */
	@Deprecated
	public String getSysCode() {
		return sysCode;
	}

	/**
	 * 设置用户编码
	 *
	 * @param sysCode
	 *            用户编码
	 */
	@Deprecated
	public void setSysCode(String sysCode) {
		this.sysCode = sysCode;
	}

    /**
     * 获取用户类型
     * 
     * @return userType 用户类型
     */
    public String getUserType() {
        return userType;
    }

    /**
     * 设置用户类型
     * 
     * @param userType
     *            用户类型
     */
    public void setUserType(String userType) {
        this.userType = userType;
    }

    /**
     * 获取手机号
     * 
     * @return operChargerMobile 手机号
     */
    @Deprecated
    public String getOperChargerMobile() {
        return operChargerMobile;
    }

    /**
     * 设置手机号
     * 
     * @param operChargerMobile
     *            手机号
     */
    @Deprecated
    public void setOperChargerMobile(String operChargerMobile) {
        this.operChargerMobile = operChargerMobile;
    }

    /**
     * 获取电话
     * 
     * @return operChargerPhone 电话
     */
    public String getOperChargerPhone() {
        return operChargerPhone;
    }

    /**
     * 设置电话
     * 
     * @param operChargerPhone
     *            电话
     */
    public void setOperChargerPhone(String operChargerPhone) {
        this.operChargerPhone = operChargerPhone;
    }

    /**
     * 获取传真
     * 
     * @return operChargerFax 传真
     */
    public String getOperChargerFax() {
        return operChargerFax;
    }

    /**
     * 设置传真
     * 
     * @param operChargerFax
     *            传真
     */
    public void setOperChargerFax(String operChargerFax) {
        this.operChargerFax = operChargerFax;
    }

    /**
     * 获取邮件
     * 
     * @return operChargerEmail 邮件
     */
    public String getOperChargerEmail() {
        return operChargerEmail;
    }

    /**
     * 设置邮件
     * 
     * @param operChargerEmail
     *            邮件
     */
    public void setOperChargerEmail(String operChargerEmail) {
        this.operChargerEmail = operChargerEmail;
    }

    /**
     * 获取最后登录时间
     * 
     * @return lastLoginTime 最后登录时间
     */
    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    /**
     * 设置最后登录时间
     * 
     * @param lastLoginTime
     *            最后登录时间
     */
    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    /**
     * 获取最后登录IP
     * 
     * @return lastLoginIp 最后登录IP
     */
    public String getLastLoginIp() {
        return lastLoginIp;
    }

    /**
     * 设置最后登录IP
     * 
     * @param lastLoginIp
     *            最后登录IP
     */
    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }

    /**
     * 获取用户状态1正常、0禁用
     * 
     * @return accountState 用户状态1正常、0禁用
     */
    public Integer getAccountState() {
        return accountState;
    }

    /**
     * 设置用户状态1正常、0禁用
     * 
     * @param accountState
     *            用户状态1正常、0禁用
     */
    public void setAccountState(Integer accountState) {
        this.accountState = accountState;
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
     * 获取机构ID
     * 
     * @return officeId 机构ID
     */
    public String getOfficeId() {
        return officeId;
    }

    /**
     * 设置机构ID
     * 
     * @param officeId
     *            机构ID
     */
    public void setOfficeId(String officeId) {
        this.officeId = officeId;
    }

    /**
     * 获取公司ID
     * 
     * @return companyId 公司ID
     */
    public Long getCompanyId() {
        return companyId;
    }

    /**
     * 设置公司ID
     * 
     * @param companyId
     *            公司ID
     */
    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    /**
     * 获取父级ID
     * 
     * @return parentId 父级ID
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * 设置父级ID
     * 
     * @param parentId
     *            父级ID
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取微信绑定账号
     * 
     * @return wxOpenid 微信绑定账号
     */
    public String getWxOpenid() {
        return wxOpenid;
    }

    /**
     * 设置微信绑定账号
     * 
     * @param wxOpenid
     *            微信绑定账号
     */
    public void setWxOpenid(String wxOpenid) {
        this.wxOpenid = wxOpenid;
    }

    /**
     * 获取登录来源
     * 
     * @return loginSource 登录来源
     */
    public Integer getLoginSource() {
        return loginSource;
    }

    /**
     * 设置登录来源
     * 
     * @param loginSource
     *            登录来源
     */
    public void setLoginSource(Integer loginSource) {
        this.loginSource = loginSource;
    }

    /**
     * 获取结构名称
     * 
     * @return name 结构名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置结构名称
     * 
     * @param name
     *            结构名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取分销商类型
     * 
     * @return resellerType 分销商类型
     */
    public String getResellerType() {
        return resellerType;
    }

    /**
     * 设置分销商类型
     * 
     * @param resellerType
     *            分销商类型
     */
    public void setResellerType(String resellerType) {
        this.resellerType = resellerType;
    }

    /**
     * 获取是否可买团票1:是0:否
     * 
     * @return isBuygroup 是否可买团票1:是0:否
     */
    public Integer getIsBuygroup() {
        return isBuygroup;
    }

    /**
     * 设置是否可买团票1:是0:否
     * 
     * @param isBuygroup
     *            是否可买团票1:是0:否
     */
    public void setIsBuygroup(Integer isBuygroup) {
        this.isBuygroup = isBuygroup;
    }

    /**
     * 获取是否可买散票1:是0:否
     * 
     * @return isBuysingle 是否可买散票1:是0:否
     */
    public Integer getIsBuysingle() {
        return isBuysingle;
    }

    /**
     * 设置是否可买散票1:是0:否
     * 
     * @param isBuysingle
     *            是否可买散票1:是0:否
     */
    public void setIsBuysingle(Integer isBuysingle) {
        this.isBuysingle = isBuysingle;
    }

    /**
     * 获取resellerLevel
     * 
     * @return resellerLevel resellerLevel
     */
    public Integer getResellerLevel() {
        return resellerLevel;
    }

    /**
     * 设置resellerLevel
     * 
     * @param resellerLevel
     *            resellerLevel
     */
    public void setResellerLevel(Integer resellerLevel) {
        this.resellerLevel = resellerLevel;
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
     * 获取法人名称
     * 
     * @return corporater 法人名称
     */
    public String getCorporater() {
        return corporater;
    }

    /**
     * 设置法人名称
     * 
     * @param corporater
     *            法人名称
     */
    public void setCorporater(String corporater) {
        this.corporater = corporater;
    }

    /**
     * 获取认证类型：1身份证，2护照，3军人证件
     * 
     * @return credentialsType 认证类型：1身份证，2护照，3军人证件
     */
    public Integer getCredentialsType() {
        return credentialsType;
    }

    /**
     * 设置认证类型：1身份证，2护照，3军人证件
     * 
     * @param credentialsType
     *            认证类型：1身份证，2护照，3军人证件
     */
    public void setCredentialsType(Integer credentialsType) {
        this.credentialsType = credentialsType;
    }

    /**
     * 获取证件号
     * 
     * @return corporaterCredentials 证件号
     */
    public String getCorporaterCredentials() {
        return corporaterCredentials;
    }

    /**
     * 设置证件号
     * 
     * @param corporaterCredentials
     *            证件号
     */
    public void setCorporaterCredentials(String corporaterCredentials) {
        this.corporaterCredentials = corporaterCredentials;
    }

    /**
     * 获取法人手机
     * 
     * @return corporaterMobile 法人手机
     */
    public String getCorporaterMobile() {
        return corporaterMobile;
    }

    /**
     * 设置法人手机
     * 
     * @param corporaterMobile
     *            法人手机
     */
    public void setCorporaterMobile(String corporaterMobile) {
        this.corporaterMobile = corporaterMobile;
    }

    /**
     * 获取法人电话
     * 
     * @return corporaterPhone 法人电话
     */
    @Deprecated
    public String getCorporaterPhone() {
        return corporaterPhone;
    }

    /**
     * 设置法人电话
     * 
     * @param corporaterPhone
     *            法人电话
     */
    @Deprecated
    public void setCorporaterPhone(String corporaterPhone) {
        this.corporaterPhone = corporaterPhone;
    }

    /**
     * 获取法人邮箱
     * 
     * @return corporaterEmail 法人邮箱
     */
    @Deprecated
    public String getCorporaterEmail() {
        return corporaterEmail;
    }

    /**
     * 设置法人邮箱
     * 
     * @param corporaterEmail
     *            法人邮箱
     */
    @Deprecated
    public void setCorporaterEmail(String corporaterEmail) {
        this.corporaterEmail = corporaterEmail;
    }

    /**
     * 获取经营许可证
     * 
     * @return businessCertificate 经营许可证
     */
    public String getBusinessCertificate() {
        return businessCertificate;
    }

    /**
     * 设置经营许可证
     * 
     * @param businessCertificate
     *            经营许可证
     */
    public void setBusinessCertificate(String businessCertificate) {
        this.businessCertificate = businessCertificate;
    }

    /**
     * 获取营业执照
     * 
     * @return businessLicense 营业执照
     */
    public String getBusinessLicense() {
        return businessLicense;
    }

    /**
     * 设置营业执照
     * 
     * @param businessLicense
     *            营业执照
     */
    public void setBusinessLicense(String businessLicense) {
        this.businessLicense = businessLicense;
    }

    /**
     * 获取机构代码证
     * 
     * @return orgCodeCertificate 机构代码证
     */
    public String getOrgCodeCertificate() {
        return orgCodeCertificate;
    }

    /**
     * 设置机构代码证
     * 
     * @param orgCodeCertificate
     *            机构代码证
     */
    public void setOrgCodeCertificate(String orgCodeCertificate) {
        this.orgCodeCertificate = orgCodeCertificate;
    }

    /**
     * 获取税务登记证
     * 
     * @return taxCertificate 税务登记证
     */
    public String getTaxCertificate() {
        return taxCertificate;
    }

    /**
     * 设置税务登记证
     * 
     * @param taxCertificate
     *            税务登记证
     */
    public void setTaxCertificate(String taxCertificate) {
        this.taxCertificate = taxCertificate;
    }

    /**
     * 获取其他资料
     * 
     * @return otherFiles 其他资料
     */
    public String getOtherFiles() {
        return otherFiles;
    }

    /**
     * 设置其他资料
     * 
     * @param otherFiles
     *            其他资料
     */
    public void setOtherFiles(String otherFiles) {
        this.otherFiles = otherFiles;
    }

    /**
     * 获取分销商地址
     * 
     * @return address 分销商地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置分销商地址
     * 
     * @param address
     *            分销商地址
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取分销商状态：1.申请2.通过3.拒绝4.补材料-1失效
     * 
     * @return resellerState 分销商状态：1.申请2.通过3.拒绝4.补材料-1失效
     */
    public Integer getResellerState() {
        return resellerState;
    }

    /**
     * 设置分销商状态：1.申请2.通过3.拒绝4.补材料-1失效
     * 
     * @param resellerState
     *            分销商状态：1.申请2.通过3.拒绝4.补材料-1失效
     */
    public void setResellerState(Integer resellerState) {
        this.resellerState = resellerState;
    }

    /**
     * 获取分销商申请日期
     * 
     * @return requestDate 分销商申请日期
     */
    public Date getRequestDate() {
        return requestDate;
    }

    /**
     * 设置分销商申请日期
     * 
     * @param requestDate
     *            分销商申请日期
     */
    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    /**
     * 获取分销商批准日期
     * 
     * @return approveDate 分销商批准日期
     */
    public Date getApproveDate() {
        return approveDate;
    }

    /**
     * 设置分销商批准日期
     * 
     * @param approveDate
     *            分销商批准日期
     */
    public void setApproveDate(Date approveDate) {
        this.approveDate = approveDate;
    }

    /**
     * 获取审核结构
     * 
     * @return approveResult 审核结构
     */
    public String getApproveResult() {
        return approveResult;
    }

    /**
     * 设置审核结构
     * 
     * @param approveResult
     *            审核结构
     */
    public void setApproveResult(String approveResult) {
        this.approveResult = approveResult;
    }

    /**
     * 获取合同号
     * 
     * @return contractNum 合同号
     */
    public String getContractNum() {
        return contractNum;
    }

    /**
     * 设置合同号
     * 
     * @param contractNum
     *            合同号
     */
    public void setContractNum(String contractNum) {
        this.contractNum = contractNum;
    }

    /**
     * 获取分销商描述
     * 
     * @return description 分销商描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置分销商描述
     * 
     * @param description
     *            分销商描述
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 获取是否有开微店的权利0否1是？
     * 
     * @return wxOpenFlag 是否有开微店的权利0否1是？
     */
    public Integer getWxOpenFlag() {
        return wxOpenFlag;
    }

    /**
     * 设置是否有开微店的权利0否1是？
     * 
     * @param wxOpenFlag
     *            是否有开微店的权利0否1是？
     */
    public void setWxOpenFlag(Integer wxOpenFlag) {
        this.wxOpenFlag = wxOpenFlag;
    }

    /**
     * 获取是否为C商0否1是？
     * 
     * @return iscreseller 是否为C商0否1是？
     */
    public Integer getIscreseller() {
        return iscreseller;
    }

    /**
     * 设置是否为C商0否1是？
     * 
     * @param iscreseller
     *            是否为C商0否1是？
     */
    public void setIscreseller(Integer iscreseller) {
        this.iscreseller = iscreseller;
    }

    /**
     * 获取关于
     * 
     * @return aboutUs 关于
     */
    public String getAboutUs() {
        return aboutUs;
    }

    /**
     * 设置关于
     * 
     * @param aboutUs
     *            关于
     */
    public void setAboutUs(String aboutUs) {
        this.aboutUs = aboutUs;
    }

    /**
     * 获取联系方式
     * 
     * @return contactWay 联系方式
     */
    public String getContactWay() {
        return contactWay;
    }

    /**
     * 设置联系方式
     * 
     * @param contactWay
     *            联系方式
     */
    public void setContactWay(String contactWay) {
        this.contactWay = contactWay;
    }

    /**
     * 获取分销商拼写
     * 
     * @return resellerPhoneticShorthand 分销商拼写
     */
    public String getResellerPhoneticShorthand() {
        return resellerPhoneticShorthand;
    }

    /**
     * 设置分销商拼写
     * 
     * @param resellerPhoneticShorthand
     *            分销商拼写
     */
    public void setResellerPhoneticShorthand(String resellerPhoneticShorthand) {
        this.resellerPhoneticShorthand = resellerPhoneticShorthand;
    }

    /**
     * 获取默认AAAAAA供应商级别
     * 
     * @return supplierLevel 默认AAAAAA供应商级别
     */
    public String getSupplierLevel() {
        return supplierLevel;
    }

    /**
     * 设置默认AAAAAA供应商级别
     * 
     * @param supplierLevel
     *            默认AAAAAA供应商级别
     */
    public void setSupplierLevel(String supplierLevel) {
        this.supplierLevel = supplierLevel;
    }

    /**
     * 获取是否被上级供应商管理0否1是
     * 
     * @return isManage 是否被上级供应商管理0否1是
     */
    public Integer getIsManage() {
        return isManage;
    }

    /**
     * 设置是否被上级供应商管理0否1是
     * 
     * @param isManage
     *            是否被上级供应商管理0否1是
     */
    public void setIsManage(Integer isManage) {
        this.isManage = isManage;
    }

    /**
     * 获取其他资料1
     * 
     * @return otherFile 其他资料1
     */
    public String getOtherFile() {
        return otherFile;
    }

    /**
     * 设置其他资料1
     * 
     * @param otherFile
     *            其他资料1
     */
    public void setOtherFile(String otherFile) {
        this.otherFile = otherFile;
    }

    /**
     * 获取其他资料2
     * 
     * @return otherFile2 其他资料2
     */
    public String getOtherFile2() {
        return otherFile2;
    }

    /**
     * 设置其他资料2
     * 
     * @param otherFile2
     *            其他资料2
     */
    public void setOtherFile2(String otherFile2) {
        this.otherFile2 = otherFile2;
    }

    /**
     * 获取供应商地址
     * 
     * @return supplierAddress 供应商地址
     */
    public String getSupplierAddress() {
        return supplierAddress;
    }

    /**
     * 设置供应商地址
     * 
     * @param supplierAddress
     *            供应商地址
     */
    public void setSupplierAddress(String supplierAddress) {
        this.supplierAddress = supplierAddress;
    }

    /**
     * 获取供应商状态：1.申请2.通过3.拒绝4.补材料-1失效
     * 
     * @return supplierState 供应商状态：1.申请2.通过3.拒绝4.补材料-1失效
     */
    public Integer getSupplierState() {
        return supplierState;
    }

    /**
     * 设置供应商状态：1.申请2.通过3.拒绝4.补材料-1失效
     * 
     * @param supplierState
     *            供应商状态：1.申请2.通过3.拒绝4.补材料-1失效
     */
    public void setSupplierState(Integer supplierState) {
        this.supplierState = supplierState;
    }

    /**
     * 获取供应商介绍
     * 
     * @return supplierDescription 供应商介绍
     */
    public String getSupplierDescription() {
        return supplierDescription;
    }

    /**
     * 设置供应商介绍
     * 
     * @param supplierDescription
     *            供应商介绍
     */
    public void setSupplierDescription(String supplierDescription) {
        this.supplierDescription = supplierDescription;
    }

    /**
     * 获取拼音缩写
     * 
     * @return supplierPy 拼音缩写
     */
    public String getSupplierPy() {
        return supplierPy;
    }

    /**
     * 设置拼音缩写
     * 
     * @param supplierPy
     *            拼音缩写
     */
    public void setSupplierPy(String supplierPy) {
        this.supplierPy = supplierPy;
    }

    /**
     * 获取俗称
     * 
     * @return supplierNormal 俗称
     */
    public String getSupplierNormal() {
        return supplierNormal;
    }

    /**
     * 设置俗称
     * 
     * @param supplierNormal
     *            俗称
     */
    public void setSupplierNormal(String supplierNormal) {
        this.supplierNormal = supplierNormal;
    }

    /**
     * 获取具体扣点数值
     * 
     * @return supplierDiscountValue 具体扣点数值
     */
    public Double getSupplierDiscountValue() {
        return supplierDiscountValue;
    }

    /**
     * 设置具体扣点数值
     * 
     * @param supplierDiscountValue
     *            具体扣点数值
     */
    public void setSupplierDiscountValue(Double supplierDiscountValue) {
        this.supplierDiscountValue = supplierDiscountValue;
    }

    /**
     * 获取开始结算日期
     * 
     * @return fromDate 开始结算日期
     */
    public Date getFromDate() {
        return fromDate;
    }

    /**
     * 设置开始结算日期
     * 
     * @param fromDate
     *            开始结算日期
     */
    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    /**
     * 获取结算周期
     * 
     * @return period 结算周期
     */
    public Integer getPeriod() {
        return period;
    }

    /**
     * 设置结算周期
     * 
     * @param period
     *            结算周期
     */
    public void setPeriod(Integer period) {
        this.period = period;
    }

    /**
     * 获取应结算周期
     * 
     * @return settleDate 应结算周期
     */
    public Date getSettleDate() {
        return settleDate;
    }

    /**
     * 设置应结算周期
     * 
     * @param settleDate
     *            应结算周期
     */
    public void setSettleDate(Date settleDate) {
        this.settleDate = settleDate;
    }

    /**
     * 获取合同规则
     * 
     * @return contractRemarks 合同规则
     */
    public String getContractRemarks() {
        return contractRemarks;
    }

    /**
     * 设置合同规则
     * 
     * @param contractRemarks
     *            合同规则
     */
    public void setContractRemarks(String contractRemarks) {
        this.contractRemarks = contractRemarks;
    }

    /**
     * 获取合同备注
     * 
     * @return contractNotes 合同备注
     */
    public String getContractNotes() {
        return contractNotes;
    }

    /**
     * 设置合同备注
     * 
     * @param contractNotes
     *            合同备注
     */
    public void setContractNotes(String contractNotes) {
        this.contractNotes = contractNotes;
    }

    /**
     * 获取供应商Code
     * 
     * @return verificationCodes 供应商Code
     */
    public String getVerificationCodes() {
        return verificationCodes;
    }

    /**
     * 设置供应商Code
     * 
     * @param verificationCodes
     *            供应商Code
     */
    public void setVerificationCodes(String verificationCodes) {
        this.verificationCodes = verificationCodes;
    }

    /**
     * 获取用户来源
     * 
     * @return userSource 用户来源
     */
    @Deprecated
    public String getUserSource() {
        return userSource;
    }

    /**
     * 设置用户来源
     * 
     * @param userSource
     *            用户来源
     */
    @Deprecated
    public void setUserSource(String userSource) {
        this.userSource = userSource;
    }

    /**
     * 获取是否是主帐户
     * 
     * @return isRoot 是否是主帐户
     */
    public String getIsRoot() {
        return isRoot;
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
     * 获取用户菜单对应关系
     * 
     * @return menuList 用户菜单对应关系
     */
    public List<Menu> getMenuList() {
        return menuList;
    }

    /**
     * 设置用户菜单对应关系
     * 
     * @param menuList
     *            用户菜单对应关系
     */
    public void setMenuList(List<Menu> menuList) {
        this.menuList = menuList;
    }

    /**
     * 获取用户角色对应关系
     * 
     * @return roleList 用户角色对应关系
     */
    public List<Role> getRoleList() {
        return roleList;
    }

    /**
     * 设置用户角色对应关系
     * 
     * @param roleList
     *            用户角色对应关系
     */
    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    /**
     * 获取用户部门对应关系
     * 
     * @return departmentList 用户部门对应关系
     */
    public List<Department> getDepartmentList() {
        return departmentList;
    }

    /**
     * 设置用户部门对应关系
     * 
     * @param departmentList
     *            用户部门对应关系
     */
    public void setDepartmentList(List<Department> departmentList) {
        this.departmentList = departmentList;
    }

    /**
     * 获取审核状态
     * 
     * @return
     */
    public String getCheckStatus() {
        return checkStatus;
    }

    /**
     * 设置审核状态
     * 
     * @param checkStatus
     */
    public void setCheckStatus(String checkStatus) {
        this.checkStatus = checkStatus;
    }

    /**
     * 获取景区主键集合（查询）
     * 
     * @return scenicList 景区主键集合（查询）
     */
    public List<Long> getScenicList() {
        return scenicList;
    }

    /**
     * 设置景区主键集合（查询）
     * 
     * @param scenicList
     *            景区主键集合（查询）
     */
    public void setScenicList(List<Long> scenicList) {
        this.scenicList = scenicList;
    }

	/**
	 * <h3>转化加验证和设置默认值</h3>
	 * <ul>
	 * <li>给一些值为null的属性设置默认参数；</li>
	 * <li>验证必要的属性不能为null</li>
	 * <li>将Customer类型转化为SysUsr类型；</li>
	 * <li>如果isNeedEncrypt为true，将加密用户的loginPasswd。</li>
	 * </ul>
	 *
	 * @param customer
	 *            需要转化的Customer类型的对象
	 * @param isNeedEncrypt
	 *            是否需要加密用户密码
	 * @return
	 * @throws Exception
	 */
	public static SysUser createNewSysUser(Customer customer, boolean isNeedEncrypt) throws Exception {
		checkNull(customer, "Customer不能为null");

		if (null == customer.getId()) {
			// 给一些值为null的属性设置默认参数
			setDefaultData(customer);
			// 验证必要的属性不能为null
			validData(customer);
		}

		SysUser user = changeTSysUser(customer);

		return user;
	}

	/**
	 * <h3>仅转化对应关系</h3>
	 * <p>
	 * 将Customer类型转化为SysUser类型。
	 *
	 * @param customer
	 * @return
	 * @throws Exception
	 */
	public static SysUser changeTSysUser(Customer customer) throws Exception {
		return ACustomerBuilder.convertTo(customer);
	}

	public static void changeTSysUser(Customer customer, SysUser user) throws Exception {
		ACustomerBuilder.convertTo(customer, user);
	}

	public static Customer sysUser2Customer(SysUser sysUser) throws Exception {
		return ACustomerBuilder.convertFrom(sysUser);
	}

	public static List<SysUser> cList2SList(List<Customer> customerList) throws Exception {
		List<SysUser> sysUserList = null;
		if (customerList != null) {
			sysUserList = new ArrayList<SysUser>();
			for (Customer customer : customerList) {
				Long userId = customer.getId();
				SysUser sysUser = null;
				if (userId == null || userId < 1) {
					sysUser = createNewSysUser(customer, true);
				} else {
					sysUser = changeTSysUser(customer);
				}
				sysUserList.add(sysUser);
			}
		}
		return sysUserList;
	}

	public static List<Customer> sList2CList(List<SysUser> sysUserList) throws Exception {
		List<Customer> customerList = null;
		if (sysUserList != null) {
			customerList = new ArrayList<Customer>();
			for (SysUser sysUser : sysUserList) {
				Customer customer = sysUser2Customer(sysUser);
				customerList.add(customer);
			}
		}
		return customerList;
	}

	public static void validData(Customer customer) throws ServiceException {
		ACustomerBuilder.validtionValueWhenCreate(customer, null);
	}

	public static void validDataAll(Customer customer) throws ServiceException {
		validData(customer);

		checkLengthMax(customer.getLoginName(), 64, "Customer.LoginName超过最大长度，最大为64");
		checkLengthMin(customer.getLoginPasswd(), 6, "Customer.LoginPasswd最小长度为6位");
		checkLengthMax(customer.getLoginPasswd(), 64, "Customer.LoginPasswd超过最大长度，最大为64");
		checkLengthMax(customer.getSysCode(), 64, "Customer.SysCode超过最大长度，最大为64");
		checkLengthMax(customer.getUserType(), 64, "Customer.UserType超过最大长度，最大为64");
		checkLengthMax(customer.getOperChargerMobile(), 32, "Customer.OperChargerMobile超过最大长度，最大为32");
		checkLengthMax(customer.getOperChargerPhone(), 32, "Customer.OperChargerPhone超过最大长度，最大为32");
		checkLengthMax(customer.getOperChargerFax(), 32, "Customer.ChargerFax超过最大长度，最大为32");
		checkLengthMax(customer.getOperChargerEmail(), 32, "Customer.ChargerFax超过最大长度，最大为32");
		checkLengthMax(customer.getLastLoginIp(), 16, "Customer.ChargerFax超过最大长度，最大为32");
		checkLengthMax(customer.getOfficeId(), 10, "Customer.OfficeId超过最大长度，最大为32");
		checkLengthMax(customer.getWxOpenid(), 32, "Customer.WxOpenid超过最大长度，最大为32");
		checkLengthMax(customer.getName(), 50, "Customer.Name超过最大长度，最大为32");
		checkLengthMax(customer.getResellerType(), 16, "Customer.ResellerType超过最大长度，最大为32");
		checkLengthMax(customer.getProvince(), 64, "Customer.Province超过最大长度，最大为32");
		checkLengthMax(customer.getCity(), 64, "Customer.City超过最大长度，最大为32");
		checkLengthMax(customer.getCounty(), 64, "Customer.County超过最大长度，最大为32");
		checkLengthMax(customer.getCorporater(), 64, "Customer.Corporater超过最大长度，最大为32");
		checkLengthMax(customer.getCorporaterCredentials(), 16, "Customer.CorporaterCredentials超过最大长度，最大为32");
		checkLengthMax(customer.getCorporaterMobile(), 16, "Customer.CorporaterMobile超过最大长度，最大为32");
		checkLengthMax(customer.getCorporaterPhone(), 16, "Customer.CorporaterPhone超过最大长度，最大为32");
		checkLengthMax(customer.getCorporaterEmail(), 32, "Customer.CorporaterEmail超过最大长度，最大为32");
		checkLengthMax(customer.getBusinessCertificate(), 32, "Customer.BusinessCertificate超过最大长度，最大为32");
		checkLengthMax(customer.getBusinessLicense(), 32, "Customer.BusinessLicense超过最大长度，最大为32");
		checkLengthMax(customer.getOrgCodeCertificate(), 32, "Customer.OrgCodeCertificate超过最大长度，最大为32");
		checkLengthMax(customer.getTaxCertificate(), 32, "Customer.TaxCertificate超过最大长度，最大为32");
		checkLengthMax(customer.getOtherFiles(), 32, "Customer.OtherFiles超过最大长度，最大为32");
		checkLengthMax(customer.getAddress(), 32, "Customer.Address超过最大长度，最大为32");
		checkLengthMax(customer.getApproveResult(), 64, "Customer.ApproveResult超过最大长度，最大为64");
		checkLengthMax(customer.getContractNum(), 32, "Customer.ContractNum超过最大长度，最大为32");
		checkLengthMax(customer.getDescription(), 1024, "Customer.Description超过最大长度，最大为1024");
		checkLengthMax(customer.getAboutUs(), 1024, "Customer.AboutUs超过最大长度，最大为1024");
		checkLengthMax(customer.getContactWay(), 1024, "Customer.ContactWay超过最大长度，最大为1024");
		checkLengthMax(customer.getResellerPhoneticShorthand(), 128, "Customer.ResellerPhoneticShorthand超过最大长度，最大为128");
		checkLengthMax(customer.getSupplierLevel(), 100, "Customer.SupplierLevel超过最大长度，最大为100");
		checkLengthMax(customer.getOtherFile(), 256, "Customer.OtherFile超过最大长度，最大为256");
		checkLengthMax(customer.getOtherFile2(), 256, "Customer.OtherFile2超过最大长度，最大为256");
		checkLengthMax(customer.getSupplierAddress(), 256, "Customer.SupplierAddress超过最大长度，最大为256");
		checkLengthMax(customer.getSupplierDescription(), 1024, "Customer.SupplierDescription超过最大长度，最大为1024");
		checkLengthMax(customer.getSupplierPy(), 128, "Customer.SupplierPy超过最大长度，最大为128");
		checkLengthMax(customer.getSupplierNormal(), 64, "Customer.SupplierNorma超过最大长度，最大为64");
		checkLengthMax(customer.getContractRemarks(), 1024, "Customer.ContractRemarks超过最大长度，最大为1024");
		checkLengthMax(customer.getContractNotes(), 1024, "Customer.ContractNotes超过最大长度，最大为1024");
		checkLengthMax(customer.getVerificationCodes(), 16, "Customer.VerificationCodes超过最大长度，最大为16");
		checkLengthMax(customer.getUserSource(), 45, "Customer.UserSource超过最大长度，最大为45");
		checkLengthMax(customer.getCreateBy(), 45, "Customer.CreateBy超过最大长度，最大为45");
		checkLengthMax(customer.getUpdateBy(), 45, "Customer.OrgCodeCertificate超过最大长度，最大为45");
	}

	public static void setDefaultData(Customer customer) {
		ACustomerBuilder.customValueWhenCreate(customer);
	}

	public String getReasonRejection() {
		return reasonRejection;
	}

	public void setReasonRejection(String reasonRejection) {
		this.reasonRejection = reasonRejection;
	}

	/**
	 * 获取通用标记01
	 *
	 * @return
	 */
	public String getCommonFlag01() {
		return commonFlag01;
	}

	/**
	 * 设置通用标记01
	 *
	 * @param commonFlag01
	 */
	public void setCommonFlag01(String commonFlag01) {
		this.commonFlag01 = commonFlag01;
	}

	/**
	 * 获取通用标记02
	 *
	 * @return
	 */
	public String getCommonFlag02() {
		return commonFlag02;
	}

	/**
	 * 设置通用标记02
	 *
	 * @param commonFlag02
	 */
	public void setCommonFlag02(String commonFlag02) {
		this.commonFlag02 = commonFlag02;
	}

	/**
	 * 获取渠道
	 *
	 * @return channelVoList 渠道
	 */
	public List<ChannelVo> getChannelVoList() {
		return channelVoList;
	}

	/**
	 * 设置渠道
	 *
	 * @param channelVoList
	 *            渠道
	 */
	public void setChannelVoList(List<ChannelVo> channelVoList) {
		this.channelVoList = channelVoList;
	}

	/**
	 * 获取微店集合(查询)
	 *
	 * @return wdList 微店集合(查询)
	 */
	public List<Long> getWdList() {
		return wdList;
	}

	/**
	 * 设置微店集合(查询)
	 *
	 * @param wdList
	 *            微店集合(查询)
	 */
	public void setWdList(List<Long> wdList) {
		this.wdList = wdList;
	}

	/**
	 * 获取用户常用信息
	 *
	 * @return commonInfoList 用户常用信息
	 */
	public List<Customer> getCommonInfoList() {
		return commonInfoList;
	}

	/**
	 * 设置用户常用信息
	 *
	 * @param commonInfoList
	 *            用户常用信息
	 */
	public void setCommonInfoList(List<Customer> commonInfoList) {
		this.commonInfoList = commonInfoList;
	}

	public static String generdatePassword(String password) throws Exception {
		// 设置用户密码
		if (StringUtils.isNotBlank(password))
			return MD5Utils.getMD5DigestHex(password);
		return "";
	}

	public List<Long> getSalePointList() {
		return salePointList;
	}

	public void setSalePointList(List<Long> salePointList) {
		this.salePointList = salePointList;
	}

	public boolean isNeedLike() {
		return isNeedLike;
	}

	public void setIsNeedLike(boolean isNeedLike) {
		this.isNeedLike = isNeedLike;
	}

	public Long getCheckCustomerId() {
		return checkCustomerId;
	}

	public void setCheckCustomerId(Long checkCustomerId) {
		this.checkCustomerId = checkCustomerId;
	}

	public String getCheckCustomerName() {
		return checkCustomerName;
	}

	public void setCheckCustomerName(String checkCustomerName) {
		this.checkCustomerName = checkCustomerName;
	}

	public Date getCheckDate() {
		return checkDate;
	}

	public void setCheckDate(Date checkDate) {
		this.checkDate = checkDate;
	}

	public Date getCreateDateEnd() {
		return createDateEnd;
	}

	public void setCreateDateEnd(Date createDateEnd) {
		this.createDateEnd = createDateEnd;
	}

	public Date getUpdateDateEnd() {
		return updateDateEnd;
	}

	public void setUpdateDateEnd(Date updateDateEnd) {
		this.updateDateEnd = updateDateEnd;
	}

	public Date getCheckDateEnd() {
		return checkDateEnd;
	}

	public void setCheckDateEnd(Date checkDateEnd) {
		this.checkDateEnd = checkDateEnd;
	}

	public String getBusinessQualification() {
		return businessQualification;
	}

	public void setBusinessQualification(String businessQualification) {
		this.businessQualification = businessQualification;
	}

	public Boolean getWhereIsAnd() {
		return whereIsAnd;
	}

	public void setWhereIsAnd(Boolean whereIsAnd) {
		this.whereIsAnd = whereIsAnd;
	}

	public Boolean getInclusiveRelationUser() {
		return inclusiveRelationUser;
	}

	public void setInclusiveRelationUser(Boolean inclusiveRelationUser) {
		this.inclusiveRelationUser = inclusiveRelationUser;
	}

    /**
     * 获取pms用户更新通知状态：1目前与业务段数据一致2需要更新业务端数据
     * 
     * @return notifyUpdateState pms用户更新通知状态：1目前与业务段数据一致2需要更新业务端数据
     */
    public String getNotifyUpdateState() {
        return notifyUpdateState;
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

	public CustomerSettlement getSettlement() {
		return settlement;
	}

	public void setSettlement(CustomerSettlement settlement) {
		this.settlement = settlement;
	}

	public String getIdentifyType() {
		return identifyType;
	}

	public void setIdentifyType(String identifyType) {
		this.identifyType = identifyType;
	}

	public String getDefaultLoginAddress() {
		return defaultLoginAddress;
	}

	public void setDefaultLoginAddress(String defaultLoginAddress) {
		this.defaultLoginAddress = defaultLoginAddress;
	}

	public String getGuideCertificate() {
		return guideCertificate;
	}

	public void setGuideCertificate(String guideCertificate) {
		this.guideCertificate = guideCertificate;
	}

	public String getDirectCompany() {
		return directCompany;
	}

	public void setDirectCompany(String directCompany) {
		this.directCompany = directCompany;
	}

	public Date getDirectTime() {
		return directTime;
	}

	public void setDirectTime(Date directTime) {
		this.directTime = directTime;
	}

	public Long getResellerId() {
		return resellerId;
	}

	public void setResellerId(Long resellerId) {
		this.resellerId = resellerId;
	}

	public Long getSupplierPk() {
		return supplierPk;
	}

	public void setSupplierPk(Long supplierPk) {
		this.supplierPk = supplierPk;
	}

	public Boolean getDirect() {
		return isDirect;
	}

	public void setDirect(Boolean direct) {
		isDirect = direct;
	}

	public Date getDirectTimeEnd() {
		return directTimeEnd;
	}

	public void setDirectTimeEnd(Date directTimeEnd) {
		this.directTimeEnd = directTimeEnd;
	}

	public String getTwoDimensionCode() {
		return twoDimensionCode;
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

	public List<CustomerRelation> getCustomerRelationList() {
		return customerRelationList;
	}

	public void setCustomerRelationList(List<CustomerRelation> customerRelationList) {
		this.customerRelationList = customerRelationList;
	}

	public String getInvitationName() {
		return invitationName;
	}

	public void setInvitationName(String invitationName) {
		this.invitationName = invitationName;
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
}