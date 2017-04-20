/**    
 * 文件名：KeyParam.java     
 */
package com.pzj.base.common.global;

/**
 * 
 * 项目名称：service.pzj.redis 类名称：GlobalParam 类描述： 公共静态参数类 创建人：shiyue 创建时间：2014-6-10
 * 上午10_10_53 修改人：shiyue 修改时间：2014-6-10 上午10_10_53 修改备注：
 * 
 * @version
 * 
 */
public class KeyParam {

    /** 用户 */
    public static final String USER_PREFIX = "user";

    /** 产品 */
    public static final String PRODUCT_PREFIX = "product";

    /** 供应商 */
    public static final String SUPPLIER_PREFIX = "supplier";
    
    /** 系统 */
    public static final String SYS_PREFIX = "sys";

    @SuppressWarnings("unused")
    private static final String SPLIT_CHAR = ":";
    
    
    /**
     * 系统缓存常量
     * @author apple
     *
     */
    public static class Sys{
        
        private static final String DICTSTRING="dict";
        
        /**
         * 数据字典key
         * @param type
         * @return
         */
        public static String dict(String type){
            return  SYS_PREFIX+SPLIT_CHAR+type;
        }
        
        
        
    }
    
    

    /**
     * 用户常量，USER_KEY在UserGlobalParam.java中
     */
    public static class User {

        private static final String CODE = "code";

        /**
         * 验证码
         * 
         * @param keyParameter
         * @return
         */
        public static String code(String keyParameter) {
            return USER_PREFIX + SPLIT_CHAR + CODE + SPLIT_CHAR + keyParameter;
        }
        

    }

    /**
     * 产品常量
     */
    public static class Product {

        private final static String SEAT = "seat";//座位
        private final static String DEVICE="device";//设备

        /**
         * 产品座位锁
         * 
         * @param keyParameter
         * @return
         */
        public static String seatlock(String supplierType, String keyParameter) {
            return supplierType+SPLIT_CHAR+PRODUCT_PREFIX + SPLIT_CHAR + SEAT + SPLIT_CHAR
                    + keyParameter ;
        }

        /**
         * 设备key
         * @param deviceid
         * @return
         */
        public static String deviceKey(String deviceid,String supplierType){
            return supplierType+SPLIT_CHAR+PRODUCT_PREFIX + SPLIT_CHAR + DEVICE+deviceid;
        }
    }
}
