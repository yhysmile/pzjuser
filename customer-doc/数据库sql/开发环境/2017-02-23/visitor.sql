CREATE TABLE `core_deploment`.`visitor` (
  `id` BIGINT(20) NOT NULL COMMENT 'id主键',
  `status` TINYINT(2) NOT NULL DEFAULT 1 COMMENT '状态（1：启用，0：禁用）',
  `name` VARCHAR(30) NOT NULL DEFAULT '' COMMENT '名称',
  `phone_num` VARCHAR(11) NULL DEFAULT '' COMMENT '手机号',
  `id_number` VARCHAR(18) NULL DEFAULT '' COMMENT '身份证号',
  `remark` VARCHAR(30) NULL DEFAULT '' COMMENT '备注',
  `owner_id` BIGINT(20) NOT NULL COMMENT '拥有者id（所属主账号）',
  `create_by` BIGINT(20) NOT NULL COMMENT '创建人id',
  `create_date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_by` BIGINT(20) NULL DEFAULT -1 COMMENT '更新人id',
  `update_date` DATETIME NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
  PRIMARY KEY (`id`)  COMMENT '')
  COMMENT = '客户表';