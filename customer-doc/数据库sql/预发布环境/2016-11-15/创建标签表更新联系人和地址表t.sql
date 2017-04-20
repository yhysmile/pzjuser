ALTER TABLE `core_deploment`.`sys_address`
ADD COLUMN `name` VARCHAR(45) NULL COMMENT '地址名称' AFTER `is_default`;
ALTER TABLE `core_deploment`.`sys_contacts`
ADD COLUMN `name_pinyin` VARCHAR(80) NULL COMMENT '拼音' AFTER `is_default`;





ALTER TABLE `core_deploment`.`sys_address`
DROP PRIMARY KEY,
ADD PRIMARY KEY (`id`)  COMMENT '';




ALTER TABLE `core_deploment`.`sys_channel_strategy`
CHANGE COLUMN `create_by` `create_by` VARCHAR(20) NULL DEFAULT '' COMMENT '创建人ID' ,
CHANGE COLUMN `update_by` `update_by` VARCHAR(20) NULL DEFAULT '' COMMENT '更新人ID' ;


ALTER TABLE `core_deploment`.`sys_extra_rebate_strategy`
CHANGE COLUMN `create_by` `create_by` VARCHAR(20) NULL DEFAULT '' COMMENT '创建人ID' ,
CHANGE COLUMN `update_by` `update_by` VARCHAR(20) NULL DEFAULT '' COMMENT '更新人ID' ;

ALTER TABLE `core_deploment`.`sys_area`
CHANGE COLUMN `create_by` `create_by` VARCHAR(20) NULL DEFAULT '' COMMENT '创建人ID' ,
CHANGE COLUMN `update_by` `update_by` VARCHAR(20) NULL DEFAULT '' COMMENT '更新人ID' ;

ALTER TABLE `core_deploment`.`sys_channel`
CHANGE COLUMN `create_by` `create_by` VARCHAR(20) NULL DEFAULT '' COMMENT '创建人ID' ,
CHANGE COLUMN `update_by` `update_by` VARCHAR(20) NULL DEFAULT '' COMMENT '更新人ID' ;

ALTER TABLE `core_deploment`.`sys_label`
CHANGE COLUMN `create_by` `create_by` VARCHAR(20) NULL DEFAULT '' COMMENT '创建人ID' ,
CHANGE COLUMN `update_by` `update_by` VARCHAR(20) NULL DEFAULT '' COMMENT '更新人ID' ;

ALTER TABLE `core_deploment`.`sys_menu`
CHANGE COLUMN `create_by` `create_by` VARCHAR(20) NULL DEFAULT '' COMMENT '创建人ID' ,
CHANGE COLUMN `update_by` `update_by` VARCHAR(20) NULL DEFAULT '' COMMENT '更新人ID' ;

ALTER TABLE `core_deploment`.`sys_object_dict_relation`
CHANGE COLUMN `create_by` `create_by` VARCHAR(20) NULL DEFAULT '' COMMENT '创建人ID' ,
CHANGE COLUMN `update_by` `update_by` VARCHAR(20) NULL DEFAULT '' COMMENT '更新人ID' ;

ALTER TABLE `core_deploment`.`sys_office`
CHANGE COLUMN `create_by` `create_by` VARCHAR(20) NULL DEFAULT '' COMMENT '创建人ID' ,
CHANGE COLUMN `update_by` `update_by` VARCHAR(20) NULL DEFAULT '' COMMENT '更新人ID' ;

ALTER TABLE `core_deploment`.`sys_role`
CHANGE COLUMN `create_by` `create_by` VARCHAR(20) NULL DEFAULT '' COMMENT '创建人ID' ,
CHANGE COLUMN `update_by` `update_by` VARCHAR(20) NULL DEFAULT '' COMMENT '更新人ID' ;

ALTER TABLE `core_deploment`.`sys_settlement_rule`
CHANGE COLUMN `create_by` `create_by` VARCHAR(20) NULL DEFAULT '' COMMENT '创建人ID' ,
CHANGE COLUMN `update_by` `update_by` VARCHAR(20) NULL DEFAULT '' COMMENT '更新人ID' ;

ALTER TABLE `core_deploment`.`sys_strategy`
CHANGE COLUMN `create_by` `create_by` VARCHAR(20) NULL DEFAULT '' COMMENT '创建人ID' ,
CHANGE COLUMN `update_by` `update_by` VARCHAR(20) NULL DEFAULT '' COMMENT '更新人ID' ;

ALTER TABLE `core_deploment`.`sys_user`
CHANGE COLUMN `create_by` `create_by` VARCHAR(20) NULL DEFAULT '' COMMENT '创建人ID' ,
CHANGE COLUMN `update_by` `update_by` VARCHAR(20) NULL DEFAULT '' COMMENT '更新人ID' ;

ALTER TABLE `core_deploment`.`sys_user`
CHANGE COLUMN `create_by` `create_by` VARCHAR(20) NULL DEFAULT '' COMMENT '创建人ID' ,
CHANGE COLUMN `update_by` `update_by` VARCHAR(20) NULL DEFAULT '' COMMENT '更新人ID' ;






CREATE TABLE `core_deploment`.`sys_tag` (
  `id` BIGINT NOT NULL COMMENT '',
  `name` VARCHAR(200) NOT NULL COMMENT '标签名称',
  `create_date` DATETIME NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)  COMMENT '',
  UNIQUE INDEX `UK_TAG_NAME` (`name` ASC)  COMMENT '标签表，标签名称索引')
  COMMENT = '标签表';


ALTER TABLE `core_deploment`.`sys_tag`
ADD COLUMN `type` INT NULL COMMENT '类型' AFTER `name`;


ALTER TABLE `core_deploment`.`sys_contacts`
CHANGE COLUMN `name` `name` VARCHAR(64) NULL DEFAULT NULL COMMENT '名称' ;


CREATE TABLE `core_deploment`.`sys_user_tag` (
  `id` BIGINT NOT NULL COMMENT '',
  `user_id` BIGINT NOT NULL COMMENT '用户ID',
  `tag_id` BIGINT NOT NULL COMMENT '标签id',
  `create_date` DATETIME NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)  COMMENT '',
  INDEX `IX_USER_TAG_USERID` (`user_id` ASC)  COMMENT '用户与标签关系表，用户ID索引')
  COMMENT = '用户与标签关系表';

ALTER TABLE `core_deploment`.`sys_user_tag`
ADD COLUMN `type` INT NULL COMMENT '类型' AFTER `tag_id`;



ALTER TABLE `core_deploment`.`sys_tag`
CHANGE COLUMN `name` `name` VARCHAR(200) BINARY NOT NULL COMMENT '标签名称' ;







