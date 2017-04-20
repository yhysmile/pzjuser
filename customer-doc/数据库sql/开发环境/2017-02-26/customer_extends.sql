CREATE TABLE `customer_extends` (
  `customer_id` bigint(20) NOT NULL COMMENT '分销商id',
  `supplier_id` bigint(20) NOT NULL COMMENT '供应商id',
  `referee_id` bigint(20) DEFAULT NULL COMMENT '推荐人id',
  `business_id` bigint(20) DEFAULT NULL COMMENT '商务负责人id',
  `hotline_supplier` varchar(20) DEFAULT '' COMMENT '供应商服务热线',
  `hotline_reseller` varchar(20) DEFAULT '' COMMENT '分销商服务热线',
  PRIMARY KEY (`customer_id`,`supplier_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户营销信息';