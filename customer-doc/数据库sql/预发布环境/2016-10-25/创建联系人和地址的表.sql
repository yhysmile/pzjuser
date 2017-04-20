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



ALTER TABLE `core_deploment`.`sys_contacts`
ADD COLUMN `name_en` VARCHAR(45) NULL DEFAULT NULL COMMENT '英文名' ,
ADD COLUMN `id_number` VARCHAR(20) NULL DEFAULT NULL COMMENT '身份证号' ,
ADD COLUMN `email` VARCHAR(60) NULL COMMENT '邮箱',
ADD COLUMN `is_default` TINYINT NULL COMMENT '是否为默认';


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
