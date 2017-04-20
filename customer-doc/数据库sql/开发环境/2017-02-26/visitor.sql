CREATE TABLE `visitor` (
  `id` bigint(20) NOT NULL,
  `status` tinyint(2) NOT NULL DEFAULT '1' COMMENT '状态（1：启用，0：禁用）',
  `name` varchar(30) NOT NULL COMMENT '名称',
  `phone_num` varchar(11) DEFAULT NULL COMMENT '手机号',
  `id_num` varchar(18) DEFAULT NULL COMMENT '身份证号',
  `remark` varchar(30) DEFAULT NULL COMMENT '备注',
  `owner_id` bigint(20) NOT NULL COMMENT '拥有者id（所属主账号）',
  `create_by` bigint(20) NOT NULL COMMENT '创建人id',
  `create_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_by` bigint(20) DEFAULT '-1' COMMENT '更新人id',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='客户表';