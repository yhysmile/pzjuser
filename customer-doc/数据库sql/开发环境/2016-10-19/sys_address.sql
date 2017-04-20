CREATE TABLE `core_deploment`.`sys_address` (
  `id` BIGINT NOT NULL COMMENT '',
  `province` VARCHAR(45) NULL COMMENT '省',
  `city` VARCHAR(45) NULL COMMENT '市',
  `county` VARCHAR(45) NULL COMMENT '县',
  `address` VARCHAR(200) NULL COMMENT '详细地址',
  `postcode` VARCHAR(10) NULL COMMENT '邮政编码',
  `type` INT NULL COMMENT '类型',
  `supplier_id` BIGINT NOT NULL COMMENT '所属供应商ID',
  `create_by` VARCHAR(45) NULL COMMENT '创建人ID',
  `create_date` DATETIME NOT NULL COMMENT '创建时间',
  `update_by` VARCHAR(45) NULL COMMENT '更新人ID',
  `update_date` DATETIME NULL COMMENT '更新时间',
  `data_source` VARCHAR(45) NULL COMMENT '所属平台',
  `is_default` TINYINT NULL COMMENT '是否为默认',
  PRIMARY KEY (`id`, `supplier_id`, `create_date`)  COMMENT '',
  INDEX `IX_sys_address_suppplier_id` (`supplier_id` ASC, `type` ASC)  COMMENT '一个供应商supplier_id下有多个类型type的地址')
COMMENT = '地址';
