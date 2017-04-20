package com.pzj.base.common.global;

/**
 * 
 * 约定的key 值（字典表中设定的key）
 * 
 */
public class GlobalDict {

    public static final String  Login_Password_Exclude = "@@@@@@@@@@";

    public static final String  INCR                   = "INCR";

    /**
     * 标记值
     */
    public static final String  MARK_VAL               = "";

    @SuppressWarnings("unused")
    private static final String SPLIT_CHAR             = ":";

    /**
     * 用户字典类型
     * 
     * @author apple
     * 
     */
    public static class USER {

        public static final String USER = "user:";

        public static String hash(Object uid) {
            return USER + uid;
        }

        /**
         * 用户类型景区
         * 
         * @return
         */
        public static String USERTYPESCENIC() {
            return USER + "scenic";
        }

    }

    /**
     * 产品字典类型
     * 
     * @author apple
     * 
     */
    public static class PRODUCT {

        public static final String PRODUCT  = "product:";

        public static final String SUPPLIER = "supplier:";

        public static final String checked  = "checked:";

        /** 景区等级 **/
        public static String scenicLevel() {
            return PRODUCT + "scenicLevel";
        }

        /** 供应商等级 **/
        public static String supplierLevel() {
            return SUPPLIER + "level";
        }

        /** 供应商验票凭证 **/
        public static String supplierfCredentials() {
            return SUPPLIER + "credentials";
        }

        /** 检票次数 **/
        public static String checkedNum() {
            return checked + "num";
        }

        /** 检票凭证 **/
        public static String checkedPattern() {
            return checked + "pattern";
        }

        /** 检票设备类型 **/
        public static String deviceType() {
            return checked + "deviceType";
        }

        /** 直销工具类型 **/
        public static String sellingTool() {
            return PRODUCT + "sellingtool";
        }

        /** 票品 */
        public static String ticketVarie() {
            return PRODUCT + "ticketvarie";
        }

        /** 票种 */
        public static String ticketTies() {
            return PRODUCT + "ticketTies";
        }

        /** 票型 */
        public static String ticketType() {
            return PRODUCT + "ticketType";
        }

        /** 区域 */
        public static String theaterArea() {
            return PRODUCT + "theaterarea";
        }

        /** 场次 */
        public static String theatercnum() {
            return PRODUCT + "theatercnum";
        }

        /** 产品分类 */
        public static String proCategory() {
            return PRODUCT + "procategory";
        }
        
        /** 通用产品分类 */
        public static String proSKUCategory() {
            return PRODUCT + "proSkucategory";
        }

        /** 返利积分规则 */
        public static String ticketRules() {
            return PRODUCT + "rules";
        }

        /** 检票方式 **/
        public static String checkInType() {
            return PRODUCT + "checkInType";
        }
    }

    /**
     * 检票设备类型
     * 
     */
    public static class DeviceType {

        /** 手持 */
        public static String hand() {
            return "1";
        }

        /** 台式 */
        public static String deskTop() {
            return "2";
        }

        /** 闸机 */
        public static String turntile() {
            return "3";
        }
    }

    /**
     * 景区、剧场
     * 
     */
    public static class ScenicType {

        /** 景区 */
        public static String scenic() {
            return "1";
        }

        /** 剧场 */
        public static String theater() {
            return "2";
        }
    }

    /**
     * 站点类型
     * 
     */
    public static class SiteType {

        /** 检票点 */
        public static String checkPoint() {
            return "1";
        }

        /** 售票点 */
        public static String ticketOffice() {
            return "2";
        }

        /** 检票设备 */
        public static String device() {
            return "3";
        }
    }

    /**
     * 直销方式
     * 
     */
    public static class SalesTool {
        /** 线下窗口渠道 */
        public static String window() {
            return "1";
        }

        /** 员工微店 */
        public static String user() {
            return "2";
        }

        /** 自动售票机 */
        public static String machine() {
            return "3";
        }

        /** 二维码微店 */
        public static String code() {
            return "4";
        }

    }

    /**
     * 
     * 景区类型
     */
    public static class ScenicLevel {

        public static String AAAAA() {
            return "1";
        }

        public static String AAAA() {
            return "2";
        }

        public static String AAA() {
            return "3";
        }

        public static String AA() {
            return "4";
        }

        public static String A() {
            return "5";
        }

        /**
         * 非A
         */
        public static String NA() {
            return "6";
        }
    }

    public static final String TICKET = "ticket:";

    /** 票类型 **/
    public static String ticketType() {
        return TICKET + "ticketType";
    }

    /** 特种票模版类型 **/
    public static String templateType() {
        return TICKET + "templateType";
    }

    /** 客户类型 **/
    public static String clientType() {
        return TICKET + "clientType";
    }

    /** 特种票类型 **/
    public static String voucherType() {
        return TICKET + "voucherType";
    }

    /** 特种票状态 **/
    public static String status() {
        return TICKET + "status";
    }

    /** 特种票介质 **/
    public static String voucherMedium() {
        return TICKET + "voucherMedium";
    }

    /**
     * 
     * 票类型
     */
    public static class TicketType {

        /**
         * 
         * 普通票
         */
        public static String normal() {
            return "1";
        }

        /**
         * 
         * 免票
         */
        public static String free() {
            return "2";
        }

        /**
         * 
         * 特价票
         */
        public static String special() {
            return "3";
        }

        /**
         * 
         * 返利票
         */
        public static String rebate() {
            return "4";
        }
    }

    /**
     * 
     * 特种票模版类型
     */
    public static class TemplateType {

        /**
         * 
         * 特价票
         */
        public static String tspecial() {
            return "1";
        }

        /**
         * 
         * 免票
         */
        public static String tfree() {
            return "2";
        }
    }

    /**
     * 
     * 客户类型
     */
    public static class ClientType {

        /**
         * 
         * 地接社
         */
        public static String dijie() {
            return "1";
        }

        /**
         * 
         * 协议单位
         */
        public static String xieyi() {
            return "2";
        }

        /**
         * 
         * 地接社部门
         */
        public static String dijieDeparment() {
            return "3";
        }

        /**
         * 
         * 协议单位部门
         */
        public static String xieyiDeparment() {
            return "4";
        }
    }

    /**
     * 
     * 特种票类型
     */
    public static class VoucherType {

        /**
         * 
         * 政府单位
         */
        public static String government() {
            return "1";
        }

        /**
         * 
         * 公司客人
         */
        public static String guest() {
            return "2";
        }
    }

    /**
     * 
     * 特种票及特种票模版状态
     */
    public static class Status {

        /**
         * 
         * 未使用
         */
        public static String unUsed() {
            return "0";
        }

        /**
         * 
         * 已使用
         */
        public static String hasUsed() {
            return "1";
        }

        /**
         * 
         * 部分使用
         */
        public static String someUsed() {
            return "2";
        }

        /**
         * 
         * 已删除
         */
        public static String delete() {
            return "-1";
        }
    }

    /**
     * 
     * 特种票介质
     */
    public static class VoucherMedium {

        /**
         * 
         * 电子票
         */
        public static String electron() {
            return "1";
        }

        /**
         * 
         * 纸质票
         */
        public static String paper() {
            return "2";
        }
    }

    /**
     * 产品类型
     * 
     */
    public static class ProductCategory {
        /** 普通 */
        public static String normal() {
            return "1";
        }
        public final static int normal = 1;

        /** 定向返利产品,即积分产品 */
        public static String rebate() {
            return "4";
        }
        public final static int rebate = 4;

        /** 普通票联票子票 */
        public static String pack() {
            return "5";
        }
        public final static int pack = 5;

        /** 剧场 */
        public static String scenic() {
            return "10";
        }
        public final static int scenic = 10;

        /** 组合票 */
        public static String compose() {
            return "11";
        }
        public final static int compose = 11;

        /** 积分票联票子票 */
        public static String scorePack() {
            return "12";
        }
        public final static int scorePack = 12;

        /** 演艺联票子票 */
        public static String performingPack() {
            return "13";
        }
        public final static int performingPack = 13;

        /** 旅游产品 **/
        public static String tourismProduct() {
            return "14";
        }
        public final static int tourismProduct = 14;

        /** 小交通 **/
        public static String littleTraffic() {
            return "16";
        }
        public final static int littleTraffic = 16;

        /** 一日游 **/
        public static String dayTour() {
            return "17";
        }
        public final static int dayTour = 17;

        /** 线路 **/
        public static String lineProduct() {
            return "1000";
        }
        public final static int lineProduct = 1000;

        /** 旅拍 **/
        public static String tripPhotos() {
            return "7000";
        }
        public final static int tripPhotos  = 7000;

        /** 班车接驳(包车) **/
        public static String busCharter() {
            return "4002";
        }
        public final static int busCharter = 4002;

        /** 新奇(班车) **/
        public static String shuttleBus() {
            return "4001";
        }
        public final static int shuttleBus = 4001;

        /** 土特产 **/
        public static String nativeProduct() {
            return "5000";
        }
        public final static int nativeProduct = 5000;

        /** 导游 **/
        public static String guideProduct() {
            return "8000";
        }
        public final static int guideProduct = 8000;

        /** 住宿 */
        public static String room() {
            return "9";
        }
        public final static int room = 9;

        /** 美食(特色餐饮) */
        public static String restaurant() {
            return "9000";
        }
        public final static int restaurant = 9000;

    }

    /**
     * 团散，线上线下
     */
    public static class KindClassify {

        /**
         * 线上||团
         */
        public static String online  = "1";

        /**
         * 线下||散
         */
        public static String offline = "0";
    }

    public static class PmsProductDict {
        public static final String ROOM = "room:";

        public static String roomPriceRuleType() {
            return ROOM + "priceRuleType";
        }

        public static String usualPriceType() {
            return "1";
        }

        public static String weekPriceType() {
            return "2";
        }

        public static String holidayPriceType() {
            return "3";
        }

        /** 数据字典：违约金类型 */
        public static String roomPenaltyCategory() {
            return ROOM + "penaltyCategory";
        }

        /** 通用违约金 */
        public static Integer penaltyCategoryAll() {
            return 1;
        }

        /** 单产品违约金 */
        public static Integer penaltyCategorySingle() {
            return 2;
        }

        /** 数据字典：违约金取消方式 */
        public static String roomPenaltyCancelType() {
            return ROOM + "penaltyCancel";
        }

        /** 不可取消 */
        public static Integer penaltyCancelNo() {
            return 1;
        }

        /** 限时取消 */
        public static Integer penaltyCancelLimitedTime() {
            return 2;
        }

        /** 免费取消 */
        public static Integer penaltyCancelFree() {
            return 3;
        }

        /** 数据字典：违约金收取方式 */
        public static String penaltyCollectType() {
            return ROOM + "penaltyCollectType";
        }

        /** 收取首单 */
        public static Integer penaltyCollectFirst() {
            return 1;
        }

        /** 收取全单 */
        public static Integer penaltyCollectAll() {
            return 2;
        }

    }

    /***
     * 领票时身份证和姓名是否必填 
     * 
     * 第一个数值代表身份证是否必填
     * 第二个数值代表姓名是否必填
     * 
     * 1：代表必填，0：代表不填
     */
    public static class GainType {
        /** 手机号必填，身份证不填，姓名不填**/
        public static final Integer requiredP   = 0;

        /** 手机号必填，身份证不填，姓名必填**/
        public static final Integer requiredPN  = 1;

        /** 手机号必填，身份证必填，姓名不填**/
        public static final Integer requiredPC  = 2;

        /** 手机号必填，身份证必填，姓名必填**/
        public static final Integer requiredAll = 3;

    }

    public static class GainTypeNew {

    }
}
