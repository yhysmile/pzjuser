/*
Navicat MySQL Data Transfer

Source Server         : 124.251.43.229
Source Server Version : 50518
Source Host           : 124.251.43.229:23306
Source Database       : core_deploment

Target Server Type    : MYSQL
Target Server Version : 50518
File Encoding         : 65001

Date: 2016-03-15 11:40:11
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `product_bed`
-- ----------------------------
DROP TABLE IF EXISTS `product_bed`;
CREATE TABLE `product_bed` (
  `id` bigint(20) NOT NULL,
  `product_release_id` bigint(20) DEFAULT NULL COMMENT '房型主键Id',
  `bed_type` varchar(50) DEFAULT NULL COMMENT '床类型',
  `bed_nums` int(10) DEFAULT NULL COMMENT '床数量',
  `bed_sizes` varchar(200) DEFAULT NULL COMMENT '床规格',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product_bed
-- ----------------------------




/*
Navicat MySQL Data Transfer

Source Server         : 124.251.43.229
Source Server Version : 50518
Source Host           : 124.251.43.229:23306
Source Database       : core_deploment

Target Server Type    : MYSQL
Target Server Version : 50518
File Encoding         : 65001

Date: 2016-03-15 11:39:27
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `product_penalty`
-- ----------------------------
DROP TABLE IF EXISTS `product_penalty`;
CREATE TABLE `product_penalty` (
  `id` bigint(20) NOT NULL,
  `category` int(10) DEFAULT NULL COMMENT '违约金类型（1：通用违约金 2：单产品违约金）',
  `penalty_cancel` int(10) DEFAULT NULL COMMENT '违约金取消类型（1.不可取消 2.限时取消 3免费取消）',
  `penalty_collect_type` int(10) DEFAULT NULL COMMENT '违约金收取方式(1 收取首单 2 收取全单)',
  `cancel_time_type` varchar(20) DEFAULT NULL,
  `penalty_collect_money` double(10,2) DEFAULT NULL,
  `product_id` bigint(20) DEFAULT NULL COMMENT '单产品违约金关联的产品id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product_penalty
-- ----------------------------



/*
Navicat MySQL Data Transfer

Source Server         : 124.251.43.229
Source Server Version : 50518
Source Host           : 124.251.43.229:23306
Source Database       : core_deploment

Target Server Type    : MYSQL
Target Server Version : 50518
File Encoding         : 65001

Date: 2016-03-15 11:39:44
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `product_price_rule`
-- ----------------------------
DROP TABLE IF EXISTS `product_price_rule`;
CREATE TABLE `product_price_rule` (
  `id` bigint(20) NOT NULL COMMENT '主键id',
  `priority` int(10) DEFAULT NULL COMMENT '优先级',
  `type` varchar(10) DEFAULT NULL COMMENT '政策价格类型（1平日价 2周末价 3节日价）',
  `start_date` date DEFAULT NULL COMMENT '节日开始时间',
  `end_date` date DEFAULT NULL COMMENT '节日结束时间',
  `weekday` int(1) DEFAULT NULL COMMENT '周',
  `market_price` double(10,2) DEFAULT NULL COMMENT '挂牌价',
  `product_id` bigint(20) DEFAULT NULL COMMENT '产品主键Id',
  `supplier_id` varchar(20) DEFAULT NULL COMMENT '创建供应商id',
  `retail_price` double(10,2) DEFAULT NULL COMMENT '卖价',
  `mf_price` double(10,2) DEFAULT NULL COMMENT '固定佣金比例',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product_price_rule
-- ----------------------------
