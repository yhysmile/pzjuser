ALTER TABLE `core_deploment`.`sys_user`
CHANGE COLUMN `address` `address` VARCHAR(60) NULL DEFAULT NULL COMMENT '分销商地址' ,
CHANGE COLUMN `business_qualification` `business_qualification` VARCHAR(700) NULL DEFAULT NULL COMMENT '经营资质' ;

ALTER TABLE `core_deploment`.`sys_user`
CHANGE COLUMN `address` `address` VARCHAR(120) NULL DEFAULT NULL COMMENT '分销商地址' ;