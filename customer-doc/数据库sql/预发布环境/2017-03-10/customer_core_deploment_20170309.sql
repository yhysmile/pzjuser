alter table sys_label_relation add column status tinyint(2) unsigned not null default 1 comment '状态；1:启用；2：禁用';
alter table sys_label_relation add column create_by bigint(20) unsigned comment '创建人'; 
alter table sys_label_relation add column create_date datetime COMMENT '创建时间';
alter table sys_label_relation add column update_by bigint(20) unsigned comment '修改人'; 
alter table sys_label_relation add column update_date datetime COMMENT '修改时间';

update sys_label_relation set status=1 where status is null;

alter table sys_user_relation add column status tinyint(2) unsigned not null default 1 comment '1:启用；2：禁用'; 
alter table sys_user_relation add column update_by bigint(20) unsigned comment '修改人'; 
alter table sys_user_relation add column update_date datetime COMMENT '修改时间';

update sys_user_relation set status=1 where status is null;

CREATE TABLE `visitor` (
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
  PRIMARY KEY (`id`)
  )ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='客户表';
  
CREATE TABLE `customer_extends` (
  `customer_id` bigint(20) NOT NULL COMMENT '分销商id',
  `supplier_id` bigint(20) NOT NULL COMMENT '供应商id',
  `referee_id` bigint(20) DEFAULT NULL COMMENT '推荐人id',
  `business_id` bigint(20) DEFAULT NULL COMMENT '商务负责人id'
  PRIMARY KEY (`customer_id`,`supplier_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户营销信息';

ALTER TABLE `sys_user`
ADD COLUMN `department` VARCHAR(45) NULL default '' COMMENT '销售人员的部门' AFTER `trade_payee`;

alter table sys_user add column hotline_supplier varchar(20) DEFAULT '' COMMENT '供应商服务热线';
alter table sys_user add column hotline_reseller varchar(20) DEFAULT '' COMMENT '供应商服务热线';

CREATE TABLE `bank_card` (
  `id` bigint(20) NOT NULL,
  `owner_id` bigint(20) NOT NULL COMMENT '拥有者id（主账号id）',
  `account_holder` varchar(32) DEFAULT '' COMMENT '开户人',
  `id_num` varchar(18) DEFAULT '' COMMENT '身份证号',
  `bank` varchar(64) DEFAULT '' COMMENT '银行名称',
  `card_num` varchar(19) DEFAULT '' COMMENT '银行卡号',
  `data_source` tinyint(2) NOT NULL COMMENT '创建系统',
  `create_by` bigint(20) NOT NULL COMMENT '创建人id',
  `create_date` varchar(45) NOT NULL COMMENT '创建时间',
  `update_by` bigint(20) DEFAULT '-1' COMMENT '更新人id',
  `update_date` varchar(45) DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='银行卡表';


alter table sys_user modify corporater varchar(100) default '' comment '公司名称'; 
alter table sys_user modify name varchar(100) default '' comment '公司名称';  


# 同步sys_user_relation表中销售人员与分销商关系数据：rel_type=5的数据。
# 目标是：将sys_user_relation中rel_user_id是分销商id，user_id（销售人员id）的supplier_id（供应商id）做为主键，
# 保存到customer_extends表的customer_id和supplier_id上，user_id（销售人员id）作为referee_id和business_id。

# 可能会有主键冲突
INSERT INTO customer_extends (customer_id, supplier_id, referee_id, business_id)
  SELECT
    rel.rel_user_id,
    u.supplier_id,
    rel.user_id,
    rel.user_id
  FROM sys_user_relation rel
    INNER JOIN sys_user u ON u.id = rel.user_id
    LEFT JOIN customer_extends ext ON rel.rel_user_id = ext.customer_id AND u.supplier_id = ext.supplier_id
  WHERE ext.customer_id IS NULL and rel.id
  GROUP BY rel.rel_user_id, u.supplier_id, rel.user_id;

