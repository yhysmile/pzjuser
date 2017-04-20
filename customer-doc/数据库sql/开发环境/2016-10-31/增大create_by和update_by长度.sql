-- 由于切换成的ID生成器，所以要增大一些字段的长度。

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