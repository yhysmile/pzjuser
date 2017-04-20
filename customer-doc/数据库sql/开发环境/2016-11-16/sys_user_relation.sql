-- 记录关系创建时间、创建人。

ALTER TABLE `core_deploment`.`sys_user_relation`
ADD COLUMN `create_by` BIGINT(20) NULL COMMENT '' AFTER `rel_type`,
ADD COLUMN `create_date` DATETIME NULL COMMENT '' AFTER `create_by`;
