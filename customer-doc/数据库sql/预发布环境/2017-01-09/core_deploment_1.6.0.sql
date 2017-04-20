# Stage环境和Online环境执行
ALTER TABLE `sys_user_relation`
ADD COLUMN `create_by` BIGINT(20) NULL COMMENT '创建人id' AFTER `rel_type`,
ADD COLUMN `create_date` DATETIME NULL COMMENT '创建时间' AFTER `create_by`;

ALTER TABLE `sys_contacts`
CHANGE COLUMN `email` `email` VARCHAR(64) NULL DEFAULT NULL COMMENT '邮箱' ;


CREATE TABLE `sys_user_draft` (
  `id` BIGINT(20) NOT NULL COMMENT '',
  `user_id` BIGINT(20) NULL COMMENT '用户id',
  `create_by` BIGINT(20) NULL COMMENT '创建人id',
  `create_date` DATETIME NULL COMMENT '创建时间',
  `check_type` INT NULL COMMENT '审核类型',
  `check_user_id` BIGINT(20) NULL COMMENT '审核人id',
  `check_status` INT NULL COMMENT '审核状态',
  `check_date` DATETIME NULL COMMENT '审核时间',
  `reasons_for_refusal` VARCHAR(500) NULL COMMENT '拒绝理由',
  `draft_data` TEXT NULL COMMENT '用户修改的数据',
  PRIMARY KEY (`id`)  COMMENT '',
  INDEX `IX_USER_DRAFT_USERID` (`user_id` ASC)  COMMENT '用户草稿表用户ID索引')
COMMENT = '用户草稿表';


ALTER TABLE `sys_user`
ADD COLUMN `check_type` INT(2) NULL DEFAULT 2 COMMENT '审核类型（1、无需审核；2、用户审核；3、资质审核）' ,
ADD COLUMN `reg_source` INT(2) NULL DEFAULT 2 COMMENT '注册来源（1、PC端注册；2、APP注册；3、微信；4、移动端浏览器）' AFTER `check_type`,
ADD COLUMN `qualification_audit` INT(2) NULL DEFAULT 0 COMMENT '资质审核类型（1、资质待审核；2、资质审核通过；3、资质审核拒绝）' AFTER `reg_source`;


CREATE TABLE `sys_user_microshop` (
  `id` BIGINT(20) NOT NULL COMMENT '',
  `user_id` BIGINT(20) DEFAULT 0 COMMENT '用户id',
  `name` VARCHAR(64) DEFAULT '' COMMENT '微店名称',
  `intro` VARCHAR(500) DEFAULT '' COMMENT '微店简介',
  `avatar` VARCHAR(50) DEFAULT '' COMMENT '微店头像',
  `create_date` VARCHAR(20) DEFAULT '0000-00-00' COMMENT '创建时间',
  `update_date` VARCHAR(20) DEFAULT '0000-00-00' COMMENT '修改时间',
  PRIMARY KEY (`id`)  COMMENT '',
  INDEX `IX_USER_MICROSHOP_USER_ID` (`user_id` ASC)  COMMENT '',
  INDEX `IX_USER_MICROSHOP_NAME` (`name` ASC)  COMMENT '')
COMMENT = '微店表' ;



  
ALTER TABLE `sys_user`
CHANGE COLUMN `wx_openid` `wx_openid` VARCHAR(50) NULL DEFAULT NULL COMMENT '微信绑定账号' ;


-- 为老用户（分销商）生成默认的微店信息
insert sys_user_microshop (id, user_id, name, intro, avatar)
SELECT id, id, '魔方旅游微店', '淳朴地道的本地人，给你最具性价比的本地游', '6769ac617fde205eba93c7b235d2a3da'  FROM core_deploment.sys_user where user_type = 6 and check_status = 1;



ALTER TABLE `sys_channel` 
CHANGE COLUMN `name` `name` VARCHAR(64) NULL DEFAULT '' COMMENT '渠道名称' ;


