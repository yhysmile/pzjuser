package com.pzj.base.common.global;

/**
 * 清结算相关常量
 * Created by Administrator on 2016-3-29.
 */
public final class SettlementDict {
    /**
     * 结算单位
     */
    public static final class AccountingUnit {
        /**
         * 成都魔方旅游
         */
        public static final int ChengDuMFtour = 1;
        /**
         * 北京魔方旅游
         */
        public static final int BeijingMFtour = 2;

        /**
         * 票之家
         */
        public static final int PZJ = 3;

    }

    /**
     * 供应商开票方式
     */
    public static final class SupplierBillingMode {
        /**
         * 允许开票
         */
        public static final int AllowBilling = 1;
        /**
         * 禁止开票
         */
        public static final int DisableBilling = 2;
    }

    /**
     * 支付方式
     */
    public static final class PayMode{
        /**
         * 内扣
         */
        public static final int InternalDeduction = 1;
        /**
         * 后付
         */
        public static final int AfterPaying = 2;
    }
    /**
     * 交易服务费费用类型
     */
    public static final class FeeType{
        /**
         * 按百分比支付
         */
        public static final int FeePercent = 1;
        /**
         * 整体支付
         */
        public static final int FeeTotal = 2;
    }

    public static final class SupplierTradeServiceFeeType{
        /**
         * 百分比
         */
        public static final int percentage = 1;

        /**
         * 整体统一支付
         */
        public static final int OverallUnifiedPayment = 2;
    }
}
