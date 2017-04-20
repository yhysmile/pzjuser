CREATE TABLE `core_deploment`.`sys_user_draft` (
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

