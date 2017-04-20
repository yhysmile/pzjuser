ALTER TABLE `core_deploment`.`sys_address`
ADD COLUMN `name` VARCHAR(45) NULL COMMENT '地址名称' AFTER `is_default`;
