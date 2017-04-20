package com.pzj.base.common.global;

public class UserGlobalDict {

    public static final String USER = "user:";

    /*
     * ======================================================
     * 设置Customer.userType的。表示用户在业务上的类型，比如一个 用户可以就是普通的人类用户，也可心表示公司单位用户，等。
     * ======================================================
     */
    /** 用户类型 **/
    public static String userType() {
        return USER + "type";
    }

    /** 普通用户 **/
    public static String generUserType() {
        return "1";
    }

    /** 分销商 **/
    public static String resellUserType() {
        return "6";
    }

    /** 供应商 **/
    public static String supplierUserType() {
        return "7";
    }

    /** 分销商-OTA **/
    public static String otaUserType() {
        return "8";
    }

    /**
     * 票之家
     * <p/>
     * 用于财务账户
     **/
    public static String pzjUserType() {
        return "9";
    }

    /**
     * 魔方用户
     * <p/>
     * 用于财务账户
     * @return
     */
    public static String mftourUserType(){
        return "10";
    }

    /** 分销商-旅行社 **/
    public static String travelUserType() {
        return "2";
    }

    /** 分销商-旅行社部门 **/
    public static String travelDeptUserType() {
        return "3";
    }

    /** 分销商-导游 **/
    public static String guideUserType() {
        return "4";
    }

    /** 分销商-商户 **/
    public static String businessUserType() {
        return "5";
    }

    /** 代理商用户常量 **/
    public static String agentsType() {
        return "11";
    }

    /**
     * 销售人员
     * @return
     */
    public static String salespersonType() {
        return "12";
    }

    /**
     * SaaS用户类型常量
     * @return
     */
    public static String saasUserType() {
        return "13";
    }

    /** 分销商类型字典常量 **/
    public static String checkType() {
        return "3";
    }

    /*
     * ================================================================
     * 设置Customer.checkStatus的分销商类型
     * 
     * ================================================================
     */

    /** 用户注册状态 **/
    public static String userStatus() {
        return USER + "userstatus";
    }

    /** 注册未完成 **/
    public static String registeredStatus() {
        return "0";
    }

    /** 审核通过 **/
    public static String passStatus() {
        return "1";
    }

    /** 审核拒绝，重新提交 **/
    public static String rejustStatus() {
        return "2";
    }

    /** 注册完成待审核 **/
    public static String checkStatus() {
        return "3";
    }

    /** 第二次待审核 **/
    public static String secondCheckStatus = "4";

    /** 第二次审核通过 **/
    public static String secondPassStatus = "5";

    /** 第二次审核拒绝 **/
    public static String secondRejustStatus = "6";

    /**
     * 主帐号标识
     */
    public static String mainAccount() {
        return "1";
    }

    /**
     * 子账户标识
     */
    public static String subAccount() {
        return "0";
    }

    /**
     * 子管理账户
     */
    public static String subMainAccount() {
        return "2";
    }

    /*
     * =====================================================================
     * 设置Customer.resellerType的分销商类型
     * 
     * ======================================================================
     */

    /** 分销商类型 **/
    public static String resellType() {
        return USER + "reselltype";
    }

    /** 一级分销商 */
    public static String resellTypeLevel1() {
        return "1";
    }

    /** 二级分销商 **/
    public static String resellTypeLevel2() {
        return "2";
    }

    /** 数据字典类型，获取票归：团票，散票 **/
    public static String ticketType() {
        return "product:ticketvarie";
    }

    /** 数据字典类型，获取票种：成人，儿童 **/
    public static String ticketPerson() {
        return "product:ticketType";
    }

    /*
     * ==========================================================
     * 区分数据创建来自于哪个系统，可以用到所有实体的 dataSource属性上
     * ==========================================================
     */
    /** 数据字典类型，数据来源类型 **/
    public static String dataSource() {
        return USER + "datasource";
    }

    /** 支撑平台 **/
    public static String dataSourceSupport() {
        return "1";
    }

    /** 代供销平台 **/
    public static String dataSourceSupplyMarketing() {
        return "2";
    }

    /** 客栈/住宿（e-booking） **/
    public static String dataSourceLodge() {
        return "3";
    }

    /** 数据来自景区 **/
    public static String dataSourceSpot() {
        return "4";
    }

    /** 旅行社 **/
    public static String dataSourceTravel() {
        return "5";
    }

    /** 部门 **/
    public static String dataSourceDept() {
        return "6";
    }

    /** 导游 **/
    public static String dataSourceGuide() {
        return "7";
    }

    /** 商户 **/
    public static String dataSourceBusiness() {
        return "8";
    }

    /** 个人 */
    public static String dataSourceSingle() {
        return "9";
    }

    /** 小交通 */
    public static String dataSourceSmallTraffic() {
        return "10";
    }

    /** 客栈/住宿（本地管理+e-booking） **/
    public static String dataSourceLodgeManage() {
        return "11";
    }

    /** 演艺门票 **/
    public static String dataSourcePerform() {
        return "12";
    }

    /** 特产 **/
    public static String dataSourceSpecial() {
        return "13";
    }

    /** 线路 **/
    public static String dataSourceRoute() {
        return "14";
    }

    /** 清结算系统 **/
    public static String dataSourceSettlement() {
        return "15";
    }
    /** 通用产品供应端 **/
    public static String dataSourceComPro() {
        return "16";
    }

    /**
     * Appapi系统
     * @return
     */
    public static String dataSourceAppapi() {
        return "17";
    }

    /**
     * 餐饮
     * @return
     */
    public static String dataSourceFood() {
        return "17";
    }

    /**
     * SaaS系统
     * @return
     */
    public static String dataSourceSaaS() {
        return "19";
    }

    public static class ChannelGlobalDict {
        public static final String CHANNEL = "channel:";

        /** 渠道类别 **/
        public static String channelType() {
            return CHANNEL + "channeltype";
        }

        /** 大平台渠道类别 */
        public static String ChannelTypeDPT() {
            return CHANNEL + "channeltypeDPT";
        }

        /** 渠道类别自增KEY **/
        public static String channelTypeKey() {
            return ChannelTypeDPT() + GlobalDict.INCR;
        }

        /** 魔方渠道类别 **/
        public static String channelMF() {
            return "0";
        }

        /** 旅行社渠道类别 **/
        public static String channelTravel() {
            return "1";
        }

        /** 渠道类型 **/
        public static String channelModel() {
            return CHANNEL + "type";
        }

        /** 直销渠道 **/
        public static String directStrategy() {
            return "1";
        }

        /** 分销渠道 **/
        public static String distributionStrategy() {
            return "2";
        }

        /** 数据字典类型，返利形式 **/
        public static String rebateMethod() {
            return CHANNEL + "rebatemethod";
        }
        
        /** 返利形式 :返还款 */
        public static Integer rebateMethodMoney(){
        	return 0;
        }
        

        /** 数据字典类型，返利类型 **/
        public static String rebateType() {
            return CHANNEL + "rebatetype";
        }
        
         
        

        /** 数据字典类型，返利对象 **/
        public static String rebateObject() {
            return CHANNEL + "rebateobject";
        }
        
        /**返利对象: 分销商*/
        public static String rebateObjectDistributor(){
        	return "P";
        }
        

        /**
         * 返利结算方式字典类型
         * 
         * @return
         */
        public static String rebateSettlement() {
            return CHANNEL + "rebateSettlement";
        }

        /**
         * 返利结算方式：即时返
         * 
         * @return
         */
        public static Integer rebateSettlementNow() {
            return 1;
        }

        /**
         * 返利结算方式：周期返
         * 
         * @return
         */
        public static Integer rebateSettlementCycle() {
            return 0;
        }

        /**
         * 返利结算周期
         * 
         * @return
         */
        public static String rebateCycle() {
            return CHANNEL + "rebateCycle";
        }

        /**
         * 年返
         * 
         * @return
         */
        public static String rebateCycleYear() {
            return "YEAR";
        }

        /**
         * 月返
         * 
         * @return
         */
        public static String rebateCycleMonth() {
            return "MONTH";
        }

        /**
         * 周返
         * 
         * @return
         */
        public static String rebateCycleWeek() {
            return "WEEK";
        }

        /**
         * 天返
         * 
         * @return
         */
        public static String rebateCycleDay() {
            return "DAY";
        }

        /**
         * 即时返
         * 
         * @return
         */
        public static String rebateCycleCurrent() {
            return "CURRENT";
        }

        /**
         * 返利周期类型字典类型
         * 
         * @return
         */
        public static String rebateCycleType() {
            return CHANNEL + "rebateCycleType";
        }

        /**
         * 按照具体时间返利结算
         * 
         * @return
         */

        public static Integer rebateCycleTypeTMWD() {
            return 1;
        }

        /**
         * 按照每隔一段时间返利结算
         * 
         * @return
         */
        public static Integer rebateCycleTypePerMonth() {
            return 2;
        }

        /**
         * 是否存在加点返利常量字典类型
         * 
         * @return
         */
        public static String haveExtraRebateType() {
            return "channel:haveExtraRebateType";
        }

        /**
         * 是否存在加点返利常量：存在加点返利
         */
        public static Integer haveExtraRebateYes() {
            return 1;
        }

        /**
         * 是否存在加点返利常量：不存在加点返利
         */
        public static Integer haveExtraRebateNo() {
            return 0;
        };

    }

    public static class StrategyGlobalDict {
    	
    	/** 是微店政策*/
    	public static final Integer is_microshop_strategy = 1;
    	
    	/** 不是微店政策*/
    	public static final Integer is_not_microshop_strategy = 0;
    	
    	
        public static final String STRATEGY = "strategy:";

        /**
         * 业务上结算规则没有政策时设置此值
         */
        public static final Long NullStrategy = -1L;

        /** 直销渠道政策 **/
        public static String directStrategy() {
            return "1";
        }

        /** 分销渠道政策 **/
        public static String distributionStrategy() {
            return "2";
        }

        /** 直连渠道政策 **/
        public static String directDistributionStrategy() {
            return "3";
        }

        /** 政策状态 **/
        public static String strategyStatus() {
            return STRATEGY + "status";
        }

        /** 政策状态：已启用 */
        public static Integer strategyStatusEnbaled() {
            return 1;
        }

        /** 政策状态：已禁用 */
        public static Integer strategyStatusDisbaled() {
            return 0;
        }

        /** 政策发布和审核状态：未审核 */
        public static Integer publishStatusNotreviewed() {
            return 0;
        }

        /** 政策发布和审核状态：已通过 */

        public static Integer publishStatusPassed() {
            return 1;
        }

        /** 政策发布和审核状态：拒绝通过 */
        public static Integer publishStatusNotpass() {
            return 2;
        }

        /** 数据字典类型：政策有效期类型 **/
        public static String strategyExpireType() {
            return STRATEGY + "expiretype";
        }

        /** 政策有效期:永久 */
        public static Integer finalStrategyExpire() {
            return 1;
        }

        /** 政策有效期:设置时长 */
        public static Integer dynamicStrategyExpire() {
            return 2;
        }

        /** 数据字典类型：首检及游玩时间 **/
        public static String checkinExpireType() {
            return STRATEGY + "checkinexpiretype";
        }

        /** 使用有效期：当日 */
        public static Integer checkinExpireToday() {
            return 1;
        }

        /** 使用有效期：产品有效期内 */
        public static Integer checkinExpirePeriod() {
            return 2;
        }

        /** 使用有效期：具体日期内 */
        public static Integer checkinExpireSpecific() {
            return 3;
        }

        /** 数据字典类型：产品有效期计时单位 */
        public static String checkinExpireUnit() {
            return STRATEGY + "checkinexpireunit";
        }

        /** 数据字典类型：票品 */
        public static String ticketVarie() {
            return STRATEGY + "ticketvarie";
        }

        /** 政策票品：团票 */
        public static Integer groupTicketVarie() {
            return 1;
        }

        /** 政策票品：散票 */
        public static Integer scatterTicketVarie() {
            return 0;
        }

        /** 数据字典类型：政策销售端口 */
        public static String salesType() {
            return STRATEGY + "salesType";
        }

        /** 政策销售端口：线下窗口 */
        public static Integer windowLinePort() {
            return 1;
        }

        /** 政策销售端口：二维码微店 */
        public static Integer windowQRMicroshop() {
            return 2;
        }

        /** 政策销售端口：旅行社PC端 */
        public static Integer windowPC() {
            return 3;
        }

        /** 政策销售端口：导游APP */
        public static Integer windowGuideApp() {
            return 4;
        }

        /** 政策销售端口：商户APP */
        public static Integer windowTenantApp() {
            return 5;
        }

        /** 政策销售端口：导游微店 */
        public static Integer windowGuideMicroshop() {
            return 6;
        }

        /** 政策销售端口：商户微店 */
        public static Integer windowTenantMicroshop() {
            return 7;
        }

        /** 政策销售端口：OTA */
        public static Integer windowOTA() {
            return 8;
        }
        
        /** 政策销售端口：微店端口*/
        public static Integer windowMicroshop() {
            return 7;
        }

        /** 数据字典类型:购买时限计时单位 */
        public static String expireMode() {
            return STRATEGY + "expireMode";
        }

        /** 购买时限计时单位：时 */
        public static Integer expireModeHour() {
            return 1;
        }

        /** 购买时限计时单位：日 */
        public static Integer expireModeDay() {
            return 2;
        }

        /** 数据字典类型：适用范围 */
        public static String scope() {
            return STRATEGY + "scope";
        }

        /** 适用范围:周一 */
        public static Integer monday() {
            return 1;
        }

        /** 适用范围:周二 */
        public static Integer tuesday() {
            return 2;
        }

        /** 适用范围:周三 */
        public static Integer wednesday() {
            return 3;
        }

        /** 适用范围:周四 */
        public static Integer thursday() {
            return 4;
        }

        /** 适用范围:周五 */
        public static Integer friday() {
            return 5;
        }

        /** 适用范围:周六 */
        public static Integer saturday() {
            return 6;
        }

        /** 适用范围:周日 */
        public static Integer sunday() {
            return 7;
        }

        /** 是否是魔方:是 */
        public static Integer isMF() {
            return 1;
        }

        /** 是否是魔方:否 */
        public static Integer isNotMF() {
            return 0;
        }

        /** 未满结算规则类型 */
        public static String notTotalSettlementType() {
            return STRATEGY + "notTotalSettlementType";
        }

        /** 未满结算规则类型:全额结算 */
        public static Integer totalSettlement() {
            return 1;
        }

        /** 未满结算规则类型:减少结算金额 */
        public static Integer notTotalSettlement() {
            return 2;
        }

    }

    /**
     * <h3>角色类型常量</h3>
     * <p>
     * 使用于Role类的type属性上。
     * </p>
     * 
     * @author Administrator
     * 
     */
    public static class RoleType {
        public static final String roleType = "role:type";

        /**
         * <h3>普通用户</h3>
         */
        public static final String GENERAL = "1";
        /**
         * <h3>供应商</h3>
         */
        public static final String SUPPLIER = "2";

        /**
         * SaaS用户权限
         */
        public static final String SAAS_AUTHORITY = "3";
    }

    /**
     * 岗位是否绑定检票点
     * 
     * 使用于Role.setBinding(Integer)上。
     * 
     * @author Administrator
     * 
     */
    public static class RoleBingType {
        /**
         * 不绑定
         */
        public static final Integer BindingNo = 0;
        /**
         * 绑定
         */
        public static final Integer BindingYes = 1;
    }

    /**
     * 用户关系类型
     * 
     */
    public static class UserRelation {
        /**
         * 供应商
         */
        public static final String SUPPLIER = "1";

        /**
         * 旅行社与旅行社部门
         */
        public static final String DEPT = "2";

        /**
         * 旅行社与导游
         */
        public static final String GUIDE = "3";

        /**
         * 分销商
         */
        public static final String RESELLER = "4";

        /**
         * 销售人员与分销商
         */
        public static final String SALESPESON_RESELLER = "5";

        /**
         * 供应商与直签分销商
         */
        public static final String SUPPLIER_DIRECTS_RESELLER = "6";
    }

    /**
     * 登陆来源
     */
    public static class UserLoginSource {
        /**
         * 登陆来源在字典中的常量
         */
        public static final String userLoginSource = USER + "loginSource";

        /**
         * 平台
         */
        public static final String platformSource = "1";

        /**
         * 手机APP
         */
        public static final String phoneSource = "2";

        /**
         * 手机和平台
         */
        public static final String phoneAndPlatformSource = "2";
    }

    /**
     * 加点返利的时效类型，用于ExtraRebateStrategyVo类上的ValidityType属性上。
     */
    public static class ExtraRebateStrategyValidityType {
        /**
         * 小时
         */
        public final static Integer hour = 0;

        /**
         * 天
         */
        public final static Integer day = 1;
    }
    /**
     * 客栈类型
     */
    /** 客栈 */
    public static final Integer lodge=1;
    /** 酒店 */
    public static final Integer grogshop=2;
    /**
     * 身份属性
     */
    /** 个人 */
    public static final String personal="p";
    /** 企业 */
    public static final String company="q";

    public static class AddressType {
        /**
         * 上车地址
         */
        public final static int BOARDING = 1;

        /**
         * 下车地址
         */
        public final static int GETOFF = 2;

        /**
         * 收货地址
         */
        public final static int RECEPIT = 3;

        /**
         * 普通地址
         */
        public final static int GENERAL = 4;
    }

    /**
     * 注册来源
     */
    public static class RegistrationSource {
        /**
         * PC端注册
         */
        public final static int PC = 1;

        /**
         * APP注册
         */
        public final static int APP = 2;

        /**
         * 微信
         */
        public final static int WECHAT = 3;

        /**
         * 移动端浏览器
         */
        public final static int MOBILE_SIDE_BROWSER = 4;

    }

    /**
     * 用户审核类型
     */
    public static class UserCheckType {
        /**
         * 无需审核
         */
        public final static int NOT_CHECK = 1;

        /**
         * 用户审核
         */
        public final static int USER_AUDIT = 2;

        /**
         * 资质审核
         */
        public final static int QUALIFICATION_AUDIT = 3;

    }

    /**
     * 资质审核类型
     */
    public static class QualificationAudit {
        /**
         * 待审核
         */
        public final static int PENDING = 1;

        /**
         * 审核通过
         */
        public final static int PASS = 2;

        /**
         * 审核拒绝
         */
        public final static int REJECTED = 3;

    }

    /**
     * 注册来源
     */
    public static class RegSource {
        /**
         * PC端注册
         */
        public final static int PC = 1;

        /**
         * APP注册
         */
        public final static int APP = 2;

        /**
         * 微信
         */
        public final static int WECHAT = 3;

        /**
         * 移动端浏览器
         */
        public final static int MOBILE_BROWSER = 4;
    }
}
