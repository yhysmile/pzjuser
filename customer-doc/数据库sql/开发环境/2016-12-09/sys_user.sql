ALTER TABLE `core_deploment`.`sys_user`
ADD COLUMN `check_type` INT(2) NULL DEFAULT 2 COMMENT '审核类型（1、无需审核；2、用户审核；3、资质审核）' ,
ADD COLUMN `reg_source` INT(2) NULL DEFAULT 0 COMMENT '注册来源（1、PC端注册；2、APP注册；3、微信；4、移动端浏览器）' AFTER `check_type`,
ADD COLUMN `qualification_audit` INT(2) NULL DEFAULT 0 COMMENT '资质审核类型（1、资质待审核；2、资质审核通过；3、资质审核拒绝）' AFTER `reg_source`;
