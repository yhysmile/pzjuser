
# 微店相关所需的字段

# 之前 2016-11-30 在 sys_user 上增加字段不使用了，新方案使用新表保存

CREATE TABLE `core_deploment`.`sys_user_microshop` (
  `id` BIGINT(20) NOT NULL COMMENT '',
  `user_id` BIGINT(20) DEFAULT 0 COMMENT '用户id',
  `name` VARCHAR(64) DEFAULT '' COMMENT '微店名称',
  `intro` VARCHAR(500) DEFAULT '' COMMENT '微店简介',
  `avatar` VARCHAR(50) DEFAULT '' COMMENT '微店头像',
  `create_date` VARCHAR(20) DEFAULT '0000-00-00' COMMENT '创建时间',
  `update_date` VARCHAR(20) DEFAULT '0000-00-00' COMMENT '修改时间',
  PRIMARY KEY (`id`)  COMMENT '',
  INDEX `IX_USER_MICROSHOP_USER_ID` (`user_id` ASC)  COMMENT '',
  INDEX `IX_USER_MICROSHOP_NAME` (`name` ASC)  COMMENT '');

