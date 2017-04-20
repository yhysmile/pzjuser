# 用于供应商关联直签分销商绑定同，记录绑定时间和操作人ID。

ALTER TABLE `core_deploment`.`sys_user_relation`
ADD COLUMN `create_date` DATETIME NULL COMMENT '创建时间' AFTER `rel_type`,
ADD COLUMN `create_by` BIGINT(20) NULL COMMENT '创建人ID' AFTER `create_date`;
