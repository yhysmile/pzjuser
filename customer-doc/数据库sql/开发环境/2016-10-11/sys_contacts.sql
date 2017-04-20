CREATE TABLE `core_deploment`.`sys_contacts` (
  `id` BIGINT NOT NULL COMMENT '',
  `name` VARCHAR(32) NULL COMMENT '名称',
  `phone_number` VARCHAR(32) NULL COMMENT '手机号',
  `type_desc` VARCHAR(32) NULL COMMENT '类型说明',
  `supplier_id` BIGINT NOT NULL COMMENT '所属供应商ID',
  `create_by` BIGINT NULL COMMENT '创建人ID',
  `create_date` DATETIME NULL COMMENT '创建时间',
  `update_by` BIGINT NULL COMMENT '更新人ID',
  `update_date` DATETIME NULL COMMENT '更新时间',
  `data_source` VARCHAR(45) NULL COMMENT '所属平台',
  PRIMARY KEY (`id`)  COMMENT '')
COMMENT = '联系人';
