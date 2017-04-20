/*
Navicat MySQL Data Transfer

Source Server         : 124.251.43.229
Source Server Version : 50518
Source Host           : 124.251.43.229:23306
Source Database       : core_deploment

Target Server Type    : MYSQL
Target Server Version : 50518
File Encoding         : 65001

Date: 2016-03-23 18:37:40
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `sys_settlement_rule`
-- ----------------------------
DROP TABLE IF EXISTS `sys_settlement_rule`;
CREATE TABLE `sys_settlement_rule` (
  `id` bigint(20) DEFAULT NULL,
  `product_id` bigint(20) DEFAULT NULL COMMENT '产品id',
  `strategy_id` bigint(20) DEFAULT NULL COMMENT '政策id',
  `not_total_settlement_type` int(20) DEFAULT NULL COMMENT '未满减结算规则类型 {2减少结算金额}',
  `reduce_settlement_money` double(20,0) DEFAULT NULL COMMENT '减少结算金额',
  `parent_product_id` bigint(20) DEFAULT NULL COMMENT '联票：主票id',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(16) DEFAULT NULL COMMENT '创建人',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `update_by` varchar(16) DEFAULT NULL COMMENT '更新人',
  `del_flag` char(1) NOT NULL COMMENT '删除标记：删除',
  `supplier_id` bigint(20) DEFAULT NULL COMMENT '创建供应商'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_settlement_rule
-- ----------------------------
