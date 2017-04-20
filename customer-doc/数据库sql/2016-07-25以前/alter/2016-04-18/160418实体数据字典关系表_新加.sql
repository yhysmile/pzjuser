/*
Navicat MySQL Data Transfer

Source Server         : 124.251.43.229
Source Server Version : 50518
Source Host           : 124.251.43.229:23306
Source Database       : core_deploment

Target Server Type    : MYSQL
Target Server Version : 50518
File Encoding         : 65001

Date: 2016-04-18 11:22:37
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `sys_object_dict_relation`
-- ----------------------------
DROP TABLE IF EXISTS `sys_object_dict_relation`;
CREATE TABLE `sys_object_dict_relation` (
  `id` bigint(20) NOT NULL COMMENT '主键id',
  `type` varchar(100) DEFAULT NULL COMMENT '数据字典key',
  `value` varchar(100) DEFAULT NULL COMMENT '数据字典value',
  `object` varchar(100) DEFAULT NULL COMMENT '对应表',
  `attribute` varchar(100) DEFAULT NULL COMMENT '对应列',
  `object_id` bigint(20) DEFAULT NULL COMMENT '对应数据列主键Id',
  `label` varchar(500) DEFAULT NULL COMMENT '数据字典标签',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `del_flag` char(1) DEFAULT '1' COMMENT '使用状态1启用0禁用2删除',
  `sort` int(11) DEFAULT '0' COMMENT '排序',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `update_by` varchar(16) DEFAULT NULL COMMENT '最新更新人',
  `create_by` varchar(16) DEFAULT NULL COMMENT '创建人',
  `supplier_id` bigint(20) DEFAULT NULL COMMENT '创建供应商',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_object_dict_relation
-- ----------------------------
