-- 清结算
ALTER TABLE `core_deploment`.`sys_user`
ADD COLUMN `accountingUnit` INT(5) NULL COMMENT '核算单位(1成都魔方旅游 2、北京魔方旅游)' AFTER `notify_update_state`,
ADD COLUMN `supplierBillingMode` INT(5) NULL COMMENT '供应商能否开票(1 可以 2 不可)' AFTER `accountingUnit`,
ADD COLUMN `supplierCreditPayMode` INT(5) NULL COMMENT '供应商佣金支付方式(1、内扣 2、后付)' AFTER `supplierBillingMode`,
ADD COLUMN `supplierPlatformPayMode` INT(5) NULL COMMENT '供应商佣金支付方式(1、内扣 2、后付)' AFTER `supplierCreditPayMode`;

-- 用户与代理人关联表
CREATE TABLE `sys_user_agent` (
  `id` bigint(20) NOT NULL,
  `userId` bigint(20) NOT NULL COMMENT '用户ID（供应商ID、分销商ID）',
  `agentId` bigint(20) NOT NULL COMMENT '代理商ID（也是用户ID）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户与代理商关系';