package com.pzj.base.common.global;

/**
 * 全局参数
 * 
 * @author apple
 * 
 */
public class GlobalParam {

	/**
	 * 使用状态
	 * 
	 * @author apple
	 * 
	 */
	public static class FLAG {

		public static String statusType() {
			return "user:statusType";
		}

		/**
		 * 停用
		 * 
		 * @return 0
		 */
		public static Integer off() {
			return 0;
		}

		/**
		 * 开启
		 * 
		 * @return 1
		 */
		public static Integer start() {
			return 1;
		}

		/**
		 * 逻辑删除
		 * 
		 * @return 2
		 */
		public static Integer del() {
			return 2;
		}

		/**
		 * 通过、同意
		 * 
		 * @return 3
		 */
		public static Integer agree() {
			return 3;
		}

		/**
		 * 拒绝
		 * 
		 * @return 4
		 */
		public static Integer refuse() {
			return 4;
		}

		/**
		 * 待审核
		 * 
		 * @return 5
		 */
		public static Integer pending() {
			return 5;
		}

		/**
		 * 已发布
		 * 
		 * @return 6
		 */
		public static Integer release() {
			return 6;
		}

		/**
		 * 二次待审核
		 */
		public static Integer secondPending = 7;

		/**
		 * 二次通过、同意
		 */
		public static Integer secondAgree = 8;

		/**
		 * 二次拒绝
		 */
		public static Integer secondRefuse = 9;
	}

	public static final String ONE = "1";

	/** 产品字典表 */
	public static final String DICTTABLE = "proDict";

	/** 产品基本信息表 */
	public static final String PROINFOTABEL = "proInfo";

	/** 产品详情表 */
	public static final String PRORELEASETABEL = "proRelease";

	/** 产品站点信息表 */
	public static final String PRODUCT_SITE_DATA = "proSiteData";

	/** 供应商 */
	public static final String SUPPLIER = "supplier";

	/** 景区 */
	public static final String SCENIC = "scenic";

	/** 改版增加景点关系 */
	public static final String SCENICSPOT = "scenicspot";

	/** 联票子票主表 */
	public static final String PACKAGE_MAIN = "package";

	/** 联票子票从表 */
	public static final String PACKAGE_SUB = "package_sub";

	public static final String SUPPILER_TBL = "SUPPILER";

	/** 大平台供应商 */
	public static final Long SUPPILER = 123456789l;

	/** token生效时长3天 */
	public static final long TOKEN_TIME = 259200l;

	/**
	 * 分页常量
	 */
	public static class Page {

		public static Integer pageNo() {
			return 1;
		}

		public static Integer pageSize() {
			return 20;
		}

		public static Integer pageStart() {
			return 0;
		}
	}

	public static class UserMapKeyParam {

		public static String USER_MAP_KEY = "userIds";

		public static String DEPT_MAP_KEY = "officeIds";

		public static String ROLE_MAP_KEY = "roleIds";

		public static String MENU_MAP_KEY = "menuIds";

		public static String DELE_MAP_KEY = "delFlag";
	}

	public static class ExceptionCode {

		public static final int IsNull = 100;

		public static final int IsEmpty = 101;

		public static final int IsLong = 102;

		public static final int UserNameIsNull = 200;

		public static final int UserLoginPasswdIsNull = 201;

		public static final int UserNameIsError = 202;

		public static final int UserLoginPasswdIsError = 203;
	}

	/**
	 * 供应商 本地、其他
	 * 
	 */
	public static class SuppilerLocation {

		/**
		 * 本地供应商
		 * 
		 * @return
		 */
		public static String local() {
			return "local";
		}

		/**
		 * 其他供应商
		 * 
		 * @return
		 */
		public static String other() {
			return "other";
		}
	}

	/**
	 * 三方关系类型
	 * 
	 * @author Administrator
	 */
	public static class ThreeRelType {

		/**
		 * 用户与部门与角色关系类型
		 */
		public static final String USER_OFFICE_ROLE = "user:userOffficeRole";
	}

	/**
	 * 联票子票状态
	 * 
	 * @author Administrator
	 * 
	 */
	public static class PackageStatus {

		/** 已生成 */
		public static final String generated() {
			return "2";
		}

		/** 未生成 */
		public static final String empty() {
			return "1";
		}
	}

	/**
	 * pms数据是否需要更新标识
	 */
	public static class NotifyUpdateState {

		public static final String needUpdate() {
			return "2";
		}

		public static final String noUpdate() {
			return "1";
		}
	}

	/**
	 * 游玩时间模式
	 * 从什么时候开始计算游玩时间
	 */
	public static class PlayTimeMode {
		/**
		 * 字典类型
		 */
		public static final String PlayTimeModeDict = "product:playTimeMode";
		/**
		 * 首检后
		 */
		public static final int AfterTheFirstInspection = 0;

		/**
		 * 游玩时间后
		 */
		public static final int AfterThePlayTime = 1;

	}

	/**
	 * 时间单位
	 */
	public static class DateTime {
		public static final String dateTimeDict = "commons:dateTime";

		/**
		 * 毫秒
		 */
		public static final int millisecond = 0;
		/**
		 * 秒
		 */
		public static final int second = 1;
		/**
		 * 分钟
		 */
		public static final int minute = 2;
		/**
		 * 小时
		 */
		public static final int hour = 3;
		/**
		 * 天
		 */
		public static final int day = 4;
		/**
		 * 星期
		 */
		public static final int week = 5;
		/**
		 * 旬
		 */
		public static final int ten = 6;
		/**
		 * 月
		 */
		public static final int month = 7;
		/**
		 * 季度
		 */
		public static final int quarter = 8;
		/**
		 * 年
		 */
		public static final int year = 9;

	}

	/**
	 * 产品附属类型
	 */
	public static class SubsidiaryType {
		public static final String SubsidiaryTypeDict = "product:subsidiaryType";

		/**
		 * 需要检查检票次数
		 */
		public static int isNeedTicketNumber = 0;
		/**
		 * 不需要检查检票次数
		 */
		public static int noNeedTicketNumber = 1;

	}

	/**
	 * 查询类型
	 */
	public static class QueryType {
		public static int exists = 1;
		public static int not_exists = 2;

		public static boolean check(int value){
			return exists == value || not_exists == value;
		}
	}
}
