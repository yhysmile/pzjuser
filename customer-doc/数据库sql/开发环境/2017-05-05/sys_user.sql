ALTER TABLE `core_deploment`.`sys_user`
ADD COLUMN `biee_token` VARCHAR(32) NOT NULL DEFAULT '' COMMENT '用于biee的token' AFTER `hotline_reseller`;

update sys_user set biee_token = REPLACE(uuid(), '-', '');