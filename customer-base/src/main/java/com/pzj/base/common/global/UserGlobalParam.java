package com.pzj.base.common.global;

public class UserGlobalParam {
    public static class UserMapKeyParam {

        public static String USER_MAP_KEY = "userIds";

        public static String TAG_MAP_KEY = "tagIds";

        public static String DEPT_MAP_KEY = "officeIds";

        public static String ROLE_MAP_KEY = "roleIds";

        public static String AGENT_MAP_KEY = "agentIds";

        public static String MENU_MAP_KEY = "menuIds";

        public static String DELE_MAP_KEY = "delFlag";

        public static String RELT_MAP_KEY = "relTypes";

        public static String DATASOURCES_KEY = "dataSources";

        public static String USER_KEY = "USER:TOKEN:";
        
        public static String PMS_KEY = "PMS:SPACE";
    }

    public static class ChannelMapKeyParam {

        public static String CHANNEL_MAP_KEY = "channelIds";

        public static String LABEL_MAP_KEY = "labelIds";

        public static String STRATEGY_MAP_KEY = "strategyIds";

        public static String REBATE_MAP_KEY = "rebateIds";

        public static String EXTRA_REBATE_MAP_KEY = "extraRebateIds";

        public static String PRODUCT_MAP_KEY = "productIds";

        /**
         * LabelRelation关系：主对象ID
         */
        public static String OBJ_MAP_KEY = "objIds";

        /**
         * LabelRelation关系：关联对象ID
         */
        public static String REF_MAP_KEY = "relIds";

        /**
         * LabelRelation关系：关系类型
         */
        public static String RELATION_TYPE_KEY = "relType";

        public static String USER_LABEL_RELATION_TYPE = "userLable";

        public static String STRATEGY_PROCUDT_RELATION_TYPE = "strategyProduct";

        public static String STRATEGY_CHANNEL_RELATION_TYPE = "strategyChannel";

        public static String STRATEGY_REBATE_RELATION_TYPE = "strategyRebate";

        public static String REBATE_EXTRA_RELATION_TYPE = "rebateExtra";

        public static String CHANNEL_LABEL_RELATION_TYPE = "channelLabel";

        /**
         * 分销渠道与分销商关系
         */
        public static String CHANNEL_USER_RELATION_TYPE = "channelUser";
        /**
         * 直签渠道与分销商关系
         */
        public static String DIRECT_CHANNEL_USER_TYPE = "directChannelUser";

        /**
         * 用户与售票点关系
         */
        public static String CHANNEL_USER_TICKET_TYPE = "userSalePoint";
    }

    public static class LabelRelationType {
        /**
         * 与标签关联的数据为用户。
         */
        public static final String UserType = "user";
    }
}
