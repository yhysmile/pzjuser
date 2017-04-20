/*
Navicat MySQL Data Transfer

Source Server         : 124.251.43.228
Source Server Version : 50530
Source Host           : 124.251.43.228:3306
Source Database       : core_deploment

Target Server Type    : MYSQL
Target Server Version : 50530
File Encoding         : 65001

Date: 2015-12-07 10:55:50
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `app_equipment`
-- ----------------------------
DROP TABLE IF EXISTS `app_equipment`;
CREATE TABLE `app_equipment` (
  `id` bigint(20) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `device_token` varchar(500) DEFAULT NULL COMMENT '设备标识',
  `device_type` varchar(10) DEFAULT NULL COMMENT '设备类型',
  `status` tinyint(2) DEFAULT '0' COMMENT '状态',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='人员设备';

-- ----------------------------
-- Records of app_equipment
-- ----------------------------

-- ----------------------------
-- Table structure for `app_feedback`
-- ----------------------------
DROP TABLE IF EXISTS `app_feedback`;
CREATE TABLE `app_feedback` (
  `id` bigint(20) NOT NULL,
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  `content` varchar(5000) DEFAULT NULL COMMENT '内容',
  `phone` varchar(100) DEFAULT NULL COMMENT '电话',
  `create_time` datetime DEFAULT NULL,
  `feedbackScenario` varchar(200) DEFAULT NULL COMMENT '反馈意见',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='意见反馈';

-- ----------------------------
-- Records of app_feedback
-- ----------------------------

-- ----------------------------
-- Table structure for `app_message`
-- ----------------------------
DROP TABLE IF EXISTS `app_message`;
CREATE TABLE `app_message` (
  `id` bigint(20) NOT NULL,
  `title` varchar(100) DEFAULT NULL COMMENT '标题',
  `create_time` datetime DEFAULT NULL,
  `content` varchar(5000) DEFAULT NULL COMMENT '内容',
  `status` tinyint(2) DEFAULT '0' COMMENT '状态',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='信息通知';

-- ----------------------------
-- Records of app_message
-- ----------------------------

-- ----------------------------
-- Table structure for `product_combine_relation`
-- ----------------------------
DROP TABLE IF EXISTS `product_combine_relation`;
CREATE TABLE `product_combine_relation` (
  `id` bigint(20) NOT NULL,
  `product_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '组合产品id',
  `sub_product_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '组合产品中包含的产品id',
  `rebate_id` bigint(20) DEFAULT '0' COMMENT '子票返利规则id',
  `supplier_id` varchar(20) DEFAULT NULL COMMENT '供应商',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='组合产品和所包含的产品关系表';

-- ----------------------------
-- Records of product_combine_relation
-- ----------------------------

-- ----------------------------
-- Table structure for `product_dict`
-- ----------------------------
DROP TABLE IF EXISTS `product_dict`;
CREATE TABLE `product_dict` (
  `id` bigint(20) NOT NULL COMMENT '自增字段',
  `label` varchar(100) DEFAULT NULL COMMENT '显示名称',
  `value` varchar(100) DEFAULT NULL COMMENT '值',
  `type` varchar(100) DEFAULT NULL COMMENT '类型',
  `description` varchar(100) DEFAULT NULL COMMENT '纬度',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `create_date` datetime DEFAULT NULL,
  `create_by` varchar(100) DEFAULT NULL COMMENT '创建人',
  `update_by` varchar(100) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `remarks` varchar(200) DEFAULT NULL COMMENT '介绍',
  `flag` char(1) DEFAULT NULL COMMENT '使用状态1启用0禁用2删除',
  `data_source` varchar(45) DEFAULT NULL,
  `supplier_id` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='产品字典表';

-- ----------------------------
-- Records of product_dict
-- ----------------------------
INSERT INTO `product_dict` VALUES ('0', '积分规则', null, 'product:rules', null, null, null, null, null, null, null, '9', null, null);
INSERT INTO `product_dict` VALUES ('1', ' ', '1', 'product:ticketTies', '票种', '1', null, null, null, null, null, '1', null, null);
INSERT INTO `product_dict` VALUES ('2', '线下', '2', 'product:ticketTies', '票种', '2', null, null, null, null, null, '1', null, null);
INSERT INTO `product_dict` VALUES ('3', '团票', '1', 'product:ticketvarie', '票品', '1', null, null, null, null, null, '1', null, null);
INSERT INTO `product_dict` VALUES ('4', '散票', '2', 'product:ticketvarie', '票品', '2', null, null, null, null, null, '1', null, null);
INSERT INTO `product_dict` VALUES ('5', '普通票', '1', 'product:procategory', '产品分类', '1', null, null, null, null, null, '1', null, null);
INSERT INTO `product_dict` VALUES ('6', '演艺票', '2', 'product:procategory', '产品分类', '2', null, null, null, null, null, '1', null, null);
INSERT INTO `product_dict` VALUES ('7', '定向返利票', '3', 'product:procategory', '产品分类', '3', null, null, null, null, null, '1', null, null);
INSERT INTO `product_dict` VALUES ('8', '普通票联票', '4', 'product:procategory', '产品分类', '4', null, null, null, null, null, '1', null, null);
INSERT INTO `product_dict` VALUES ('9', '积分票联票', '5', 'product:procategory', '产品分类', '5', null, null, null, null, null, '1', null, null);
INSERT INTO `product_dict` VALUES ('13', '成人ff', '1', 'product:ticketType', '票型', '1', null, null, '1', '2015-12-04 10:10:09', '票型dd', '1', null, null);
INSERT INTO `product_dict` VALUES ('14', '儿童', '2', 'product:ticketType', '票型', '2', null, null, null, null, null, '1', null, null);
INSERT INTO `product_dict` VALUES ('15', '优惠', '3', 'product:ticketType', '票型', '3', null, null, null, null, null, '1', null, null);
INSERT INTO `product_dict` VALUES ('16', '老人', '4', 'product:ticketType', '票型', '4', null, null, null, null, null, '0', null, null);
INSERT INTO `product_dict` VALUES ('28', '线下窗口渠道', '4', 'product:sellingtool', '直销工具类型', '4', '0000-00-00 00:00:00', '', '', '0000-00-00 00:00:00', '', '1', null, null);
INSERT INTO `product_dict` VALUES ('29', '员工微店', '1', 'product:sellingtool', '直销工具类型', '1', null, null, null, null, null, '1', null, null);
INSERT INTO `product_dict` VALUES ('30', '自动售票机', '2', 'product:sellingtool', '直销工具类型', '2', null, null, null, null, null, '1', null, null);
INSERT INTO `product_dict` VALUES ('31', '二维码微店', '3', 'product:sellingtool', '直销工具类型', '3', null, null, null, null, null, '1', null, null);
INSERT INTO `product_dict` VALUES ('32', '团进团出', '1', 'product:checkInType', '团票检票方式', '1', null, null, null, null, '', '1', null, null);
INSERT INTO `product_dict` VALUES ('33', '非团进团出', '2', 'product:checkInType', '团票检票方式', '2', null, null, null, null, '', '1', null, null);
INSERT INTO `product_dict` VALUES ('34', '手持设备', '1', 'product:deviceType', '设备类型', '1', null, null, null, null, null, '1', null, null);
INSERT INTO `product_dict` VALUES ('35', '台式设备', '2', 'product:deviceType', '设备类型', '2', null, null, null, null, null, '1', null, null);
INSERT INTO `product_dict` VALUES ('36', '闸机', '3', 'product:deviceType', '设备类型', '3', null, null, null, null, null, '1', null, null);
INSERT INTO `product_dict` VALUES ('37', 'AAAAA', '1', 'product:scenicLevel', '景区等级', '1', null, null, null, null, null, '1', null, null);
INSERT INTO `product_dict` VALUES ('38', 'AAAA', '2', 'product:scenicLevel', '景区等级', '2', null, null, null, null, null, '1', null, null);
INSERT INTO `product_dict` VALUES ('39', 'AAA', '3', 'product:scenicLevel', '景区等级', '3', null, null, null, null, null, '1', null, null);
INSERT INTO `product_dict` VALUES ('40', 'AA', '4', 'product:scenicLevel', '景区等级', '4', null, null, null, null, null, '1', null, null);
INSERT INTO `product_dict` VALUES ('41', 'A', '5', 'product:scenicLevel', '景区等级', '5', null, null, null, null, null, '1', null, null);
INSERT INTO `product_dict` VALUES ('42', '非A', '6', 'product:scenicLevel', '景区等级', '6', null, null, null, null, null, '1', null, null);
INSERT INTO `product_dict` VALUES ('44', '身份证', '1', 'product:pattern', '验票凭证', '1', null, null, null, null, null, '1', null, null);
INSERT INTO `product_dict` VALUES ('45', 'channelType3-1', '2', 'product:pattern', '验票凭证', '2', null, null, null, null, null, '1', null, null);
INSERT INTO `product_dict` VALUES ('46', '指纹', '3', 'product:pattern', '验票凭证', '3', null, null, null, null, null, '1', null, null);
INSERT INTO `product_dict` VALUES ('53', '普通用户', '1', 'user:type', '用户类型', '1', '0000-00-00 00:00:00', '', '', '0000-00-00 00:00:00', '', '1', null, null);
INSERT INTO `product_dict` VALUES ('54', '旅行社', '2', 'user:type', '用户类型', '2', '0000-00-00 00:00:00', '', '', '0000-00-00 00:00:00', '', '1', null, null);
INSERT INTO `product_dict` VALUES ('55', '旅行社部门', '3', 'user:type', '用户类型', '3', '0000-00-00 00:00:00', '', '', '0000-00-00 00:00:00', '', '1', null, null);
INSERT INTO `product_dict` VALUES ('56', '导游', '4', 'user:type', '用户类型', '4', '0000-00-00 00:00:00', '', '', '0000-00-00 00:00:00', '', '1', null, null);
INSERT INTO `product_dict` VALUES ('57', '商户', '5', 'user:type', '用户类型', '5', '0000-00-00 00:00:00', '', '', '0000-00-00 00:00:00', '', '1', null, null);
INSERT INTO `product_dict` VALUES ('58', '分销商', '6', 'user:type', '用户类型', '6', '0000-00-00 00:00:00', '', '', '0000-00-00 00:00:00', '', '1', null, null);
INSERT INTO `product_dict` VALUES ('59', '供应商', '7', 'user:type', '用户类型', '7', '0000-00-00 00:00:00', '', '', '0000-00-00 00:00:00', '', '1', null, null);
INSERT INTO `product_dict` VALUES ('60', 'OTA', '8', 'user:type', '用户类型', '8', '0000-00-00 00:00:00', '', '', '0000-00-00 00:00:00', '', '1', null, null);
INSERT INTO `product_dict` VALUES ('61', '票之家', '9', 'user:type', '用户类型', null, '0000-00-00 00:00:00', '', '', '0000-00-00 00:00:00', '', '1', null, null);
INSERT INTO `product_dict` VALUES ('62', '商户', '5', 'user:type', '用户类型', null, '0000-00-00 00:00:00', '', '', '0000-00-00 00:00:00', '', '1', null, null);
INSERT INTO `product_dict` VALUES ('63', '旅行社', '1', 'channel:channeltype', '渠道类别', '1', '0000-00-00 00:00:00', '', '', '0000-00-00 00:00:00', '', '1', null, null);
INSERT INTO `product_dict` VALUES ('64', '导游', '2', 'channel:channeltype', '渠道类别', '2', '0000-00-00 00:00:00', '', '', '0000-00-00 00:00:00', '', '1', null, null);
INSERT INTO `product_dict` VALUES ('65', '旅行社部门', '3', 'channel:channeltype', '渠道类别', '3', '0000-00-00 00:00:00', '', '', '0000-00-00 00:00:00', '', '1', null, null);
INSERT INTO `product_dict` VALUES ('66', 'OTA', '4', 'channel:channeltype', '渠道类别', '4', '0000-00-00 00:00:00', '', '', '0000-00-00 00:00:00', '', '1', null, null);
INSERT INTO `product_dict` VALUES ('67', '商户', '5', 'channel:channeltype', '渠道类别', '5', '0000-00-00 00:00:00', '', '', '0000-00-00 00:00:00', '', '1', null, null);
INSERT INTO `product_dict` VALUES ('68', '魔方旅游', '6', 'channel:channeltype', '渠道类别', '6', '0000-00-00 00:00:00', '', '', '0000-00-00 00:00:00', '', '1', null, null);
INSERT INTO `product_dict` VALUES ('69', '停用', '0', 'user:statusType', '状态类别', null, '0000-00-00 00:00:00', '', '', '0000-00-00 00:00:00', '', '1', null, null);
INSERT INTO `product_dict` VALUES ('70', '开启', '1', 'user:statusType', '状态类别', '1', '0000-00-00 00:00:00', '', '', '0000-00-00 00:00:00', '', '1', null, null);
INSERT INTO `product_dict` VALUES ('71', '逻辑删除', '2', 'user:statusType', '状态类别', null, '0000-00-00 00:00:00', '', '', '0000-00-00 00:00:00', '', '1', null, null);
INSERT INTO `product_dict` VALUES ('72', '通过、同意', '3', 'user:statusType', '状态类别', null, '0000-00-00 00:00:00', '', '', '0000-00-00 00:00:00', '', '1', null, null);
INSERT INTO `product_dict` VALUES ('73', '拒绝', '4', 'user:statusType', '状态类别', null, '0000-00-00 00:00:00', '', '', '0000-00-00 00:00:00', '', '1', null, null);
INSERT INTO `product_dict` VALUES ('74', '待审核', '5', 'user:statusType', '状态类别', null, '0000-00-00 00:00:00', '', '', '0000-00-00 00:00:00', '', '1', null, null);
INSERT INTO `product_dict` VALUES ('75', '直销', '1', 'channel:type', '直销渠道', '1', '0000-00-00 00:00:00', '', '', '0000-00-00 00:00:00', '', '1', null, null);
INSERT INTO `product_dict` VALUES ('76', '分销', '2', 'channel:type', '直销渠道', '2', '0000-00-00 00:00:00', '', '', '0000-00-00 00:00:00', '', '1', null, null);
INSERT INTO `product_dict` VALUES ('78', '支撑平台', '1', 'user:datasource', '用户类型', '1', '0000-00-00 00:00:00', '', '', '0000-00-00 00:00:00', '', '1', null, null);
INSERT INTO `product_dict` VALUES ('79', '代供销平台', '2', 'user:datasource', '所属平台', '2', '0000-00-00 00:00:00', '', '', '0000-00-00 00:00:00', '', '1', null, null);
INSERT INTO `product_dict` VALUES ('81', '客栈', '3', 'user:datasource', '所属平台', '3', null, null, null, null, null, '1', null, null);
INSERT INTO `product_dict` VALUES ('82', '景区', '4', 'user:datasource', '所属平台', '4', null, null, null, null, null, '1', null, null);
INSERT INTO `product_dict` VALUES ('83', '导游', '7', 'user:datasource', '所属平台', '7', null, null, null, null, null, '1', null, null);
INSERT INTO `product_dict` VALUES ('84', '旅行社', '5', 'user:datasource', '所属平台', '5', null, null, null, null, null, '1', null, null);
INSERT INTO `product_dict` VALUES ('85', '部门', '6', 'user:datasource', '所属平台', '6', null, null, null, null, null, '1', null, null);
INSERT INTO `product_dict` VALUES ('86', '商户', '8', 'user:datasource', '所属平台', '8', null, null, null, null, null, '1', null, null);
INSERT INTO `product_dict` VALUES ('89', '注册未完成', '0', 'user:userstatus', '用户注册状态', '1', null, null, null, null, null, '1', null, null);
INSERT INTO `product_dict` VALUES ('90', '审核通过', '1', 'user:userstatus', '用户注册状态', '2', null, null, null, null, null, '1', null, null);
INSERT INTO `product_dict` VALUES ('91', '审核拒绝，重新提交', '2', 'user:userstatus', '用户注册状态', '3', null, null, null, null, null, '1', null, null);
INSERT INTO `product_dict` VALUES ('92', '注册完成待审核', '3', 'user:userstatus', '用户注册状态', '4', null, null, null, null, null, '1', null, null);
INSERT INTO `product_dict` VALUES ('93', '一级分销商', '1', 'user:reselltype', '分销商类型', '1', null, null, null, null, null, '1', null, null);
INSERT INTO `product_dict` VALUES ('94', '二级分销商', '2', 'user:reselltype', '分销商类型', '2', null, null, null, null, null, '1', null, null);
INSERT INTO `product_dict` VALUES ('95', '当日', '1', 'channel:useperiod', '政策使用有效期', '1', null, null, null, null, null, '1', null, null);
INSERT INTO `product_dict` VALUES ('96', '产品有效期内', '0', 'channel:useperiod', '政策使用有效期', '2', null, null, null, null, null, '1', null, null);
INSERT INTO `product_dict` VALUES ('99', '存在加点返利', '1', 'channel:haveExtraRebateType', '是否存在加点返利', '1', null, null, null, null, null, '1', null, null);
INSERT INTO `product_dict` VALUES ('100', '不存在加点返利', '0', 'channel:haveExtraRebateType', '是否存在加点返利', '2', null, null, null, null, null, '1', null, null);
INSERT INTO `product_dict` VALUES ('101', '周一', '1', 'channel:applicationdate', '政策适用日期', '1', null, null, null, null, null, '1', null, null);
INSERT INTO `product_dict` VALUES ('102', '周二', '2', 'channel:applicationdate', '政策适用日期', '2', null, null, null, null, null, '1', null, null);
INSERT INTO `product_dict` VALUES ('103', '周三', '3', 'channel:applicationdate', '政策适用日期', '3', null, null, null, null, null, '1', null, null);
INSERT INTO `product_dict` VALUES ('104', '周四', '4', 'channel:applicationdate', '政策适用日期', '4', null, null, null, null, null, '1', null, null);
INSERT INTO `product_dict` VALUES ('105', '周五', '5', 'channel:applicationdate', '政策适用日期', '5', null, null, null, null, null, '1', null, null);
INSERT INTO `product_dict` VALUES ('106', '周六', '6', 'channel:applicationdate', '政策适用日期', '6', null, null, null, null, null, '1', null, null);
INSERT INTO `product_dict` VALUES ('107', '周日', '7', 'channel:applicationdate', '政策适用日期', '7', null, null, null, null, null, '1', null, null);
INSERT INTO `product_dict` VALUES ('108', '现金返利', '0', 'channel:rebatemethod', '返利形式', '1', null, null, null, null, null, '1', null, null);
INSERT INTO `product_dict` VALUES ('109', '定向票返利', '1', 'channel:rebatemethod', '返利形式', '2', null, null, null, null, null, '1', null, null);
INSERT INTO `product_dict` VALUES ('110', '返利积分', '2', 'channel:rebatemethod', '返利形式', '3', null, null, null, null, null, '1', null, null);
INSERT INTO `product_dict` VALUES ('111', '前返', '1', 'channel:rebatetype', '返利类型', '1', null, null, null, null, null, '1', null, null);
INSERT INTO `product_dict` VALUES ('112', '后返', '2', 'channel:rebatetype', '返利类型', '2', null, null, null, null, null, '1', null, null);
INSERT INTO `product_dict` VALUES ('113', '旅行社', 'H', 'channel:rebateobject', '返利对象', '1', null, null, null, null, null, '1', null, null);
INSERT INTO `product_dict` VALUES ('114', '旅行社部门', 'D', 'channel:rebateobject', '返利对象', '2', null, null, null, null, null, '1', null, null);
INSERT INTO `product_dict` VALUES ('115', '导游', 'G', 'channel:rebateobject', '返利对象', '3', null, null, null, null, null, '1', null, null);
INSERT INTO `product_dict` VALUES ('116', '普通用户', '1', 'role:type', '角色类型', '1', null, null, null, null, null, '1', null, null);
INSERT INTO `product_dict` VALUES ('117', '供应商', '2', 'role:type', '角色类型', '2', null, null, null, null, null, '1', null, null);
INSERT INTO `product_dict` VALUES ('118', '即时返', '1', 'channel:rebateSettlement', '返利结算方式', '1', null, null, null, null, null, '1', null, null);
INSERT INTO `product_dict` VALUES ('119', '周期返', '0', 'channel:rebateSettlement', '返利结算方式', '2', null, null, null, null, null, '1', null, null);
INSERT INTO `product_dict` VALUES ('121', '定期返', '1', 'channel:rebateCycleType', '返利周期类型', '1', null, null, null, null, null, '1', null, null);
INSERT INTO `product_dict` VALUES ('122', '按月按天返', '2', 'channel:rebateCycleType', '返利周期类型', '2', null, null, null, null, null, '1', null, null);
INSERT INTO `product_dict` VALUES ('130', '魔方渠道', '0', 'channel:channeltype', '渠道类别', '1', null, null, null, null, null, '1', null, null);
INSERT INTO `product_dict` VALUES ('131', '年返', 'YEAR', 'channel:rebateCycle', '返利结算周期', '4', null, null, null, null, null, null, null, null);
INSERT INTO `product_dict` VALUES ('132', '月返', 'MONTH', 'channel:rebateCycle', '返利结算周期', '3', null, null, null, null, null, null, null, null);
INSERT INTO `product_dict` VALUES ('133', '周返', 'WEEK', 'channel:rebateCycle', '返利结算周期', '2', null, null, null, null, null, null, null, null);
INSERT INTO `product_dict` VALUES ('134', '天返', 'DAY', 'channel:rebateCycle', '返利结算周期', '1', null, null, null, null, null, null, null, null);
INSERT INTO `product_dict` VALUES ('135', '未通过', '1', 'channel:publishStatus', '发布状态', '1', null, null, null, null, null, '1', null, null);
INSERT INTO `product_dict` VALUES ('136', '已通过', '2', 'channel:publishStatus', '发布状态', '2', null, null, null, null, null, '1', null, null);
INSERT INTO `product_dict` VALUES ('137', '未审核', '3', 'channel:publishStatus', '发布状态', '3', null, null, null, null, null, '1', null, null);
INSERT INTO `product_dict` VALUES ('138', '优先部门', 'DH', 'channel:rebateobject', '返利对象', '4', null, null, null, null, null, '1', null, null);
INSERT INTO `product_dict` VALUES ('12345', '积分规则1', null, 'product:rules', null, null, null, null, null, null, null, '1', null, null);
INSERT INTO `product_dict` VALUES ('12346', '积分规则2', '', 'product:rules', '', null, '0000-00-00 00:00:00', '', '', '0000-00-00 00:00:00', '', '1', '', null);
INSERT INTO `product_dict` VALUES ('12347', '积分规则3', '', 'product:rules', '', null, '0000-00-00 00:00:00', '', '', '0000-00-00 00:00:00', '', '1', '', null);
INSERT INTO `product_dict` VALUES ('2215520224935947', '', '0', 'product:ticketType', null, null, '2015-11-25 16:21:17', 'test', 'test', '2015-11-25 16:21:17', '', '1', null, null);
INSERT INTO `product_dict` VALUES ('2215520224935948', '', '0', 'product:ticketType', null, null, '2015-11-25 16:21:20', 'test', 'test', '2015-11-25 16:21:20', '', '1', null, null);
INSERT INTO `product_dict` VALUES ('2215520224935949', '', '0', 'product:ticketType', null, null, '2015-11-25 16:21:22', 'test', 'test', '2015-11-25 16:21:22', '', '1', null, null);

-- ----------------------------
-- Table structure for `product_exchange_relation`
-- ----------------------------
DROP TABLE IF EXISTS `product_exchange_relation`;
CREATE TABLE `product_exchange_relation` (
  `id` bigint(20) NOT NULL,
  `objId` bigint(20) NOT NULL COMMENT '退换票规则id',
  `relId` bigint(20) NOT NULL COMMENT '产品id',
  `supplier_id` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='退换票规则与产品关联';

-- ----------------------------
-- Records of product_exchange_relation
-- ----------------------------
INSERT INTO `product_exchange_relation` VALUES ('2215520224935937', '2215520224935937', '2215520224936042', null);
INSERT INTO `product_exchange_relation` VALUES ('2215520224935938', '2215520224935937', '2215520224936049', null);
INSERT INTO `product_exchange_relation` VALUES ('2215520224935939', '2215520224935937', '2215520224936050', null);
INSERT INTO `product_exchange_relation` VALUES ('2215520224935940', '2215520224935938', '2215520224936043', null);
INSERT INTO `product_exchange_relation` VALUES ('2215520224935941', '2215520224935939', '2215520224936036', null);
INSERT INTO `product_exchange_relation` VALUES ('2215520224935942', '2215520224935940', '2215520224936036', null);
INSERT INTO `product_exchange_relation` VALUES ('2215520224935943', '2215520224935941', '2215520224936043', null);
INSERT INTO `product_exchange_relation` VALUES ('2215520224935944', '2215520224935942', '2215520224936042', null);
INSERT INTO `product_exchange_relation` VALUES ('2215520224935945', '2215520224935942', '2215520224936049', null);
INSERT INTO `product_exchange_relation` VALUES ('2215520224935946', '2215520224935942', '2215520224936050', null);

-- ----------------------------
-- Table structure for `product_exchange_strategy`
-- ----------------------------
DROP TABLE IF EXISTS `product_exchange_strategy`;
CREATE TABLE `product_exchange_strategy` (
  `id` bigint(20) NOT NULL,
  `name` varchar(50) DEFAULT NULL COMMENT '规则名称',
  `before_expire` int(10) DEFAULT '0' COMMENT '退换票时间，(产品有效期结束前的时间)',
  `expire_unit` varchar(1) DEFAULT NULL COMMENT '退换票时间单位（1小时 2天）',
  `return_type` varchar(1) DEFAULT '1' COMMENT '退票是否扣款（1不扣款 2扣款）',
  `return_deduct_type` varchar(1) DEFAULT NULL COMMENT '退票扣款方式（1固定金额，2产品零售价比例）',
  `return_deduct_quantity` int(10) DEFAULT '0' COMMENT '退票扣除数量',
  `change_type` varchar(1) DEFAULT '1' COMMENT '换票是否扣款（1不扣款 2扣款）',
  `change_deduct_type` varchar(10) DEFAULT '1' COMMENT '换票扣款方式（1固定金额，2产品零售价比例）',
  `change_deduct_quantity` int(10) DEFAULT NULL COMMENT '换票扣除数量',
  `flag` varchar(1) DEFAULT NULL,
  `supplier_id` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='退换票规则';

-- ----------------------------
-- Records of product_exchange_strategy
-- ----------------------------
INSERT INTO `product_exchange_strategy` VALUES ('2215520224935937', '123', '123', '1', '1', '1', '0', '1', 'on', '0', '1', null);
INSERT INTO `product_exchange_strategy` VALUES ('2215520224935938', '123', '123', '1', '2', '1', '123', '2', '1', '123', '1', null);
INSERT INTO `product_exchange_strategy` VALUES ('2215520224935939', '123', '123', '1', '2', '1', '123', '2', '1', '123', '1', null);
INSERT INTO `product_exchange_strategy` VALUES ('2215520224935940', '123', '123', '1', '1', '1', '0', '1', '1', null, '0', null);
INSERT INTO `product_exchange_strategy` VALUES ('2215520224935941', '123', '123', '1', '1', '1', '0', '1', '1', null, '0', null);
INSERT INTO `product_exchange_strategy` VALUES ('2215520224935942', '123', '123', '1', '2', '1', '123', '2', '1', '123', '0', null);

-- ----------------------------
-- Table structure for `product_group_relation`
-- ----------------------------
DROP TABLE IF EXISTS `product_group_relation`;
CREATE TABLE `product_group_relation` (
  `id` bigint(20) NOT NULL,
  `package_product_id` bigint(20) DEFAULT NULL COMMENT '组合产品id',
  `rel_product_id` bigint(20) DEFAULT NULL COMMENT '关联产品id',
  `supplier_id` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='产品组合关系表';

-- ----------------------------
-- Records of product_group_relation
-- ----------------------------

-- ----------------------------
-- Table structure for `product_info`
-- ----------------------------
DROP TABLE IF EXISTS `product_info`;
CREATE TABLE `product_info` (
  `id` bigint(20) NOT NULL,
  `name` varchar(45) DEFAULT NULL COMMENT '备注名称',
  `product_type` int(11) DEFAULT NULL COMMENT '产品类别1，普通 ，2，剧场 3，定向返利产品 ，4，普通票联票子票5，积分票联票子票',
  `release_thurl` varchar(100) DEFAULT NULL COMMENT '缩略图',
  `start_time` varchar(8) DEFAULT NULL COMMENT '开始时间',
  `end_time` varchar(8) DEFAULT NULL COMMENT '结束时间',
  `product_no` varchar(100) DEFAULT NULL COMMENT '内部序号',
  `minutes_node` bigint(2) DEFAULT NULL,
  `hour_node` bigint(2) DEFAULT NULL COMMENT '当日时间节点',
  `product_sum_repertory` int(8) DEFAULT NULL COMMENT '总库存',
  `product_usable_repertory` int(8) DEFAULT NULL COMMENT '可用库存',
  `create_by` varchar(100) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_by` varchar(100) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `flag` char(1) NOT NULL COMMENT '使用状态1启用0禁用2删除',
  `remarks` varchar(200) DEFAULT NULL COMMENT '介绍',
  `combination_name` varchar(45) DEFAULT NULL COMMENT '组合名称',
  `combination_code` varchar(45) DEFAULT NULL COMMENT '组合产品编号',
  `reease_message` varchar(256) DEFAULT NULL COMMENT '短信模板',
  `reease_info` varchar(1024) DEFAULT NULL COMMENT '产品介绍',
  `supplier_id` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='产品信息表';

-- ----------------------------
-- Records of product_info
-- ----------------------------
INSERT INTO `product_info` VALUES ('66666', '测试产品', '0', 'wwwww', '1125', '1129', '1111233443', '1', '1', '0', '0', null, '2015-11-25 19:23:09', null, '2015-11-25 19:23:16', '0', '', null, null, null, null, null, null);
INSERT INTO `product_info` VALUES ('2215520224935971', '大凯哥', '0', '', '1125', '1129', '1448432552144', '1', '1', '0', '0', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '', '', '', '', null, null, null);
INSERT INTO `product_info` VALUES ('2215520224935972', '', '0', 'wwwwwww', '', '', '1448439695371', '0', '0', '0', '0', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '', '', '', '', null, null, null);
INSERT INTO `product_info` VALUES ('2215520224935973', '', '0', 'wwwwwww', '', '', '1448439967069', '0', '0', '0', '0', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '', '', '', '', null, null, null);
INSERT INTO `product_info` VALUES ('2215520224935974', '', '0', 'wwwwwww', '', '', '1448440579417', '0', '0', '0', '0', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '', '', '', '', null, null, null);
INSERT INTO `product_info` VALUES ('2215520224935975', '', '0', 'wwwwwww', '', '', '1448441492416', '0', '0', '0', '0', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '', '', '', '', null, null, null);
INSERT INTO `product_info` VALUES ('2215520224935976', '', '0', 'wwwwwww', '', '', '1448444962256', '0', '0', '0', '0', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '', '', '', '', null, null, null);
INSERT INTO `product_info` VALUES ('2215520224935977', '', '0', 'wwwwwww', '', '', '1448445393820', '0', '0', '0', '0', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '', '', '', '', null, null, null);
INSERT INTO `product_info` VALUES ('2215520224935978', '', '0', 'wwwwwww', '', '', '1448453146887', '0', '0', '0', '0', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '', '', '', '', null, null, null);
INSERT INTO `product_info` VALUES ('2215520224935980', '', '0', 'wwwwwww', '', '', '1448458018456', '0', '0', '0', '0', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '', '', '', '', null, null, null);
INSERT INTO `product_info` VALUES ('2215520224935981', '', '0', 'wwwwwww', '', '', '1448504528857', '0', '0', '0', '0', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '', '', '', '', null, null, null);
INSERT INTO `product_info` VALUES ('2215520224935982', '', '0', 'wwwwwww', '', '', '1448508449767', '0', '0', '0', '0', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '', '', '', '', null, null, null);
INSERT INTO `product_info` VALUES ('2215520224935983', '', '0', 'wwwwwww', '', '', '1448530181503', '0', '0', '0', '0', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '', '', '', '', null, null, null);
INSERT INTO `product_info` VALUES ('2215520224935984', '', '0', 'wwwwwww', '', '', '1448695328604', '0', '0', '0', '0', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '', '', '', '', '', '', null);
INSERT INTO `product_info` VALUES ('2215520224935985', 'AT歌剧院', '0', '', '1125', '1130', '1448457253595', '1', '1', '0', '0', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '', '', '', '', null, null, null);
INSERT INTO `product_info` VALUES ('2215520224935986', '', '0', 'wwwwwww', '', '', '1448696880578', '0', '0', '0', '0', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '', '', '', '', '', '', null);
INSERT INTO `product_info` VALUES ('2215520224935987', '', '0', 'wwwwwww', '', '', '1448697329840', '0', '0', '0', '0', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '', '', '', '', '', '', null);
INSERT INTO `product_info` VALUES ('2215520224935988', '', '0', 'wwwwwww', '', '', '1448886664708', '0', '0', '0', '0', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '', '', '', '', '', '', null);
INSERT INTO `product_info` VALUES ('2215520224935989', '积分票', '3', 'wwwwwww', '', '', '1448886839717', '0', '0', '0', '0', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '', '', '', '', '', '', null);
INSERT INTO `product_info` VALUES ('2215520224935990', '', '0', 'wwwwwww', '', '', '1448942547047', '0', '0', '0', '0', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '', '', '', '', '', '', null);
INSERT INTO `product_info` VALUES ('2215520224935991', '', '0', 'wwwwwww', '', '', '1448952183453', '0', '0', '0', '0', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '', '', '', '', '', '', null);
INSERT INTO `product_info` VALUES ('2215520224935992', '', '0', 'wwwwwww', '', '', '1448952574181', '0', '0', '0', '0', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '', '', '', '', '', '', null);
INSERT INTO `product_info` VALUES ('2215520224935993', '1', '0', '', '1208', '1228', '1448954360089', '1', '1', '0', '0', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '', '', '', '', '1', '1', null);
INSERT INTO `product_info` VALUES ('2215520224935994', '', '0', 'wwwwwww', '', '', '1448959875352', '0', '0', '0', '0', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '', '', '', '', '', '', null);
INSERT INTO `product_info` VALUES ('2215520224935995', '1', '0', '', '1230', '1228', '1448961224794', '1', '1', '0', '0', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '', '', '', '', '11', '1', null);
INSERT INTO `product_info` VALUES ('2215520224935996', '1', '0', '', '1229', '1231', '1448964231609', '1', '1', '0', '0', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '', '', '', '', '11111', '11111111111', null);
INSERT INTO `product_info` VALUES ('2215520224935997', 'wuhui', '0', '', '1207', '1210', '1448964490176', '1', '1', '0', '0', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '', '', '', '', '999', '99999999', null);
INSERT INTO `product_info` VALUES ('2215520224935998', '', '0', 'wwwwwww', '', '', '1449020321159', '0', '0', '0', '0', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '', '', '', '', '', '', null);
INSERT INTO `product_info` VALUES ('2215520224935999', '123', '0', '', '1210', '1229', '1449028310358', '1', '1', '0', '0', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '', '', '', '', '123123', '123123', null);
INSERT INTO `product_info` VALUES ('2215520224936000', '333', '0', '', '1209', '1231', '1449039794380', '11', '11', '0', '0', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '', '', '', '', '333', '333', null);
INSERT INTO `product_info` VALUES ('2215520224936001', '0000', '0', '', '1209', '1231', '1449040198411', '1', '1', '0', '0', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '', '', '', '', '11', '11', null);
INSERT INTO `product_info` VALUES ('2215520224936002', '磊', '0', '', '1202', '1223', '1449040631912', '11', '11', '0', '0', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '', '', '', '', '44', '44', null);
INSERT INTO `product_info` VALUES ('2215520224936003', '88', '0', '', '1209', '1231', '1449040821206', '5', '5', '0', '0', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '', '', '', '', '55', '77', null);
INSERT INTO `product_info` VALUES ('2215520224936004', 'yan', '0', '', '1202', '1206', '1449040538107', '12', '12', '0', '0', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '', '', '', '', '12', '12', null);
INSERT INTO `product_info` VALUES ('2215520224936005', 'yan123', '0', '', '1202', '1231', '1449041737224', '11', '11', '0', '0', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '', '', '', '', '11', '11', null);
INSERT INTO `product_info` VALUES ('2215520224936006', 'yanyan', '0', '', '1202', '1231', '1449042494364', '18', '18', '0', '0', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '', '', '', '', '41', '41', null);
INSERT INTO `product_info` VALUES ('2215520224936007', '456', '0', '', '1202', '1231', '1449042893256', '11', '11', '0', '0', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '', '', '', '', 'ee', 'ee', null);
INSERT INTO `product_info` VALUES ('2215520224936008', '不地', '0', '', '1202', '1231', '1449042718140', '11', '11', '0', '0', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '', '', '', '', '44', '44', null);
INSERT INTO `product_info` VALUES ('2215520224936009', 'yan123456', '0', '', '1216', '1231', '1449042982778', '11', '11', '0', '0', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '', '', '', '', '333', '3333', null);
INSERT INTO `product_info` VALUES ('2215520224936010', 'yan111', '0', '', '1210', '1231', '1449043530387', '11', '11', '0', '0', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '', '', '', '', 'ee', 'ee', null);
INSERT INTO `product_info` VALUES ('2215520224936011', '1', '0', '', '1208', '1230', '1449043733984', '1', '1', '0', '0', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '', '', '', '', '111', '11111', null);
INSERT INTO `product_info` VALUES ('2215520224936012', '1', '0', '', '1226', '1231', '1449043992060', '1', '1', '0', '0', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '', '', '', '', '1111111', '111111', null);
INSERT INTO `product_info` VALUES ('2215520224936013', '1', '0', '', '1217', '1230', '1449044387802', '1', '1', '0', '0', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '', '', '', '', '11', '111', null);
INSERT INTO `product_info` VALUES ('2215520224936014', '1', '0', '', '1222', '1231', '1449044613118', '1', '1', '0', '0', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '', '', '', '', '11111', '1111111', null);
INSERT INTO `product_info` VALUES ('2215520224936015', '一日游玩', '0', '', '1202', '1231', '1449046013752', '10', '9', '0', '0', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '', '', '', '', '老人团票', '尊敬的用户，您好！', null);
INSERT INTO `product_info` VALUES ('2215520224936016', '444', '0', '', '1209', '1222', '1449045939168', '12', '12', '0', '0', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '', '', '', '', '22', '22', null);
INSERT INTO `product_info` VALUES ('2215520224936017', '11', '0', '', '1203', '1230', '1449048560703', '1', '1', '0', '0', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '', '', '', '', '11111', '111111111', null);
INSERT INTO `product_info` VALUES ('2215520224936018', '1', '0', '', '1216', '1230', '1449049274171', '1', '1', '0', '0', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '', '', '', '', '11111', '111111', null);
INSERT INTO `product_info` VALUES ('2215520224936019', 'ewqeq', '0', '', '1203', '1231', '1449116202868', '12', '12', '0', '0', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '', '', '', '', '123', '123', null);
INSERT INTO `product_info` VALUES ('2215520224936020', 'dd', '0', '', '1209', '1231', '1449121972565', '11', '11', '0', '0', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '', '', '', '', '1', '1', null);
INSERT INTO `product_info` VALUES ('2215520224936021', '张家界', '0', '', '1203', '1231', '1449122108164', '11', '11', '0', '0', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '', '', '', '', '23', '34', null);
INSERT INTO `product_info` VALUES ('2215520224936022', '34', '0', '', '1217', '1229', '1449123300489', '11', '11', '0', '0', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '', '', '', '', '11', '11', null);
INSERT INTO `product_info` VALUES ('2215520224936023', '34', '0', '', '1216', '1231', '1449123198067', '11', '11', '0', '0', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '', '', '', '', '33', '33', null);
INSERT INTO `product_info` VALUES ('2215520224936024', '34', '0', '', '1209', '1231', '1449126105651', '11', '11', '0', '0', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '', '', '', '', '33', '33', null);
INSERT INTO `product_info` VALUES ('2215520224936025', '1', '0', '', '1230', '1231', '1449132204243', '1', '1', '0', '0', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '', '', '', '', '1', '1', null);
INSERT INTO `product_info` VALUES ('2215520224936026', '生一', '0', '', '1208', '1231', '1449192325107', '11', '11', '0', '0', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '', '', '', '', '455', '555', null);
INSERT INTO `product_info` VALUES ('2215520224936027', '杨发测试', '0', '', '1204', '0229', '1449193193447', '0', '12', '0', '0', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '', '', '', '', '杨发测试产品', '杨发测试产品', null);
INSERT INTO `product_info` VALUES ('2215520224936028', '45', '0', '', '1209', '1231', '1449193282952', '11', '11', '0', '0', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '', '', '', '', '43', '33', null);
INSERT INTO `product_info` VALUES ('2215520224936029', '大大', '0', '', '1204', '0229', '1449195938372', '0', '12', '0', '0', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '', '', '', '', '123', '321', null);
INSERT INTO `product_info` VALUES ('2215520224936030', '青城山一日游玩', '0', '', '1204', '0108', '1449197024467', '0', '9', '0', '0', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '', '', '', '', '休闲度假避暑！', '尊敬您好', null);
INSERT INTO `product_info` VALUES ('2215520224936031', 'yfyfyf', '0', '', '1204', '1231', '1449199025666', '12', '12', '0', '0', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '', '', '', '', '12', '12', null);
INSERT INTO `product_info` VALUES ('2215520224936032', '1', '0', '', '1209', '1231', '1449200492783', '1', '1', '0', '0', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '', '', '', '', '1', '1', null);
INSERT INTO `product_info` VALUES ('2215520224936033', '45', '0', '', '1204', '1231', '1449206785392', '11', '11', '0', '0', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '', '', '', '', '33', '33', null);
INSERT INTO `product_info` VALUES ('2215520224936034', '杨发测试景区产品', '0', '', '1204', '0110', '1449209876395', '0', '23', '0', '0', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '', '', '', '', '213', '321', null);
INSERT INTO `product_info` VALUES ('2215520224936035', '456', '0', '', '1209', '1231', '1449211557066', '11', '11', '0', '0', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '', '', '', '', '11', '11', null);
INSERT INTO `product_info` VALUES ('2215520224936036', '32121', '0', '', '1204', '0131', '1449211346398', '0', '23', '0', '0', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '', '', '', '', '213', '321', null);
INSERT INTO `product_info` VALUES ('2215520224936037', '抵押搜哦', '0', '', '1204', '0110', '1449212818165', '0', '23', '0', '0', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '', '', '', '', '23', '23', null);
INSERT INTO `product_info` VALUES ('2215520224936038', '123', '0', '', '1204', '1223', '1449213277758', '1', '1', '0', '0', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '', '', '', '', '123', '123', null);
INSERT INTO `product_info` VALUES ('2215520224936039', '123', '0', '', '1231', '1231', '1449213418705', '1', '1', '0', '0', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '', '', '', '', '123', '13', null);
INSERT INTO `product_info` VALUES ('2215520224936040', 'qweqeq', '0', '', '1204', '1204', '1449213561717', '12', '12', '0', '0', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '', '', '', '', 'DDD', 'DDD', null);
INSERT INTO `product_info` VALUES ('2215520224936041', '啊发发啥', '0', '', '1204', '1231', '1449213436016', '12', '10', '0', '0', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '', '', '', '', 'XXXXXX', 'XXXX', null);
INSERT INTO `product_info` VALUES ('2215520224936042', '345', '0', '', '1217', '1218', '1449213897960', '11', '11', '0', '0', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '', '', '', '', '11', '11', null);
INSERT INTO `product_info` VALUES ('2215520224936043', 'SSS', '0', '', '1204', '0109', '1449219305648', '0', '10', '0', '0', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '', '', '', '', 'FGDFDF', 'DFGDD', null);
INSERT INTO `product_info` VALUES ('2215520224936044', '123', '0', '', '1204', '1204', '1449219074610', '1', '1', '0', '0', '', '2015-12-04 16:40:31', '', '0000-00-00 00:00:00', '0', '', '', '', '', '', '1111', null);
INSERT INTO `product_info` VALUES ('2215520224936045', '123', '0', '', '1204', '1204', '1449219074610', '2', '2', '0', '0', '', '2015-12-04 16:40:31', '', '0000-00-00 00:00:00', '0', '', '', '', '', '', '6666', null);
INSERT INTO `product_info` VALUES ('2215520224936048', '123', '0', '', '1204', '1204', '1449219054887', '1', '1', '0', '0', '', '2015-12-04 16:42:26', '', '0000-00-00 00:00:00', '0', '', '', '', '', '', '1111', null);
INSERT INTO `product_info` VALUES ('2215520224936049', '123', '0', '', '1204', '1204', '1449219054887', '2', '2', '0', '0', '', '2015-12-04 16:42:26', '', '0000-00-00 00:00:00', '0', '', '', '', '', '', '6666', null);
INSERT INTO `product_info` VALUES ('2215520224936050', '123', '0', '', '1204', '1204', '1449219418750', '1', '1', '0', '0', '', '2015-12-04 16:43:46', '', '0000-00-00 00:00:00', '0', '', '', '', '', '', '1111', null);
INSERT INTO `product_info` VALUES ('2215520224936051', '123', '0', '', '1204', '1204', '1449219418750', '2', '2', '0', '0', '', '2015-12-04 16:44:16', '', '0000-00-00 00:00:00', '0', '', '', '', '', '', '6666', null);
INSERT INTO `product_info` VALUES ('2215520224936052', '123', '0', '', '1204', '1204', '1449218979754', '1', '1', '0', '0', '', '2015-12-04 16:45:36', '', '0000-00-00 00:00:00', '0', '', '', '', '', '', '1111', null);
INSERT INTO `product_info` VALUES ('2215520224936053', '123', '0', '', '1204', '1204', '1449218979754', '2', '2', '0', '0', '', '2015-12-04 16:45:39', '', '0000-00-00 00:00:00', '0', '', '', '', '', '', '6666', null);
INSERT INTO `product_info` VALUES ('2215520224936054', '123', '0', '', '1204', '1204', '1449219258543', '1', '1', '0', '0', '', '2015-12-04 16:50:15', '', '0000-00-00 00:00:00', '0', '', '', '', '', '', '2222', null);
INSERT INTO `product_info` VALUES ('2215520224936055', '123', '0', '', '1204', '1204', '1449219258543', '2', '2', '0', '0', '', '2015-12-04 16:50:17', '', '0000-00-00 00:00:00', '0', '', '', '', '', '', '444', null);
INSERT INTO `product_info` VALUES ('2215520224936056', '123', '0', '', '1204', '1204', '1449220221869', '1', '1', '0', '0', '', '2015-12-04 17:00:05', '', '0000-00-00 00:00:00', '0', '', '', '', '', '', '123', null);
INSERT INTO `product_info` VALUES ('2215520224936057', '123', '4', '', '1204', '1204', '1449220775480', '1', '1', '0', '0', '', '2015-12-04 17:07:11', '', '0000-00-00 00:00:00', '0', '', '', '', '', '', '111', null);
INSERT INTO `product_info` VALUES ('2215520224936058', '1204发布', '0', '', '1204', '0110', '1449221971180', '0', '23', '0', '0', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '', '', '', '', '3214', '321321', null);
INSERT INTO `product_info` VALUES ('2215520224936059', '11', '0', '', '1210', '1231', '1449222663047', '1', '1', '0', '0', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '', '', '', '', '1111', '11111', null);
INSERT INTO `product_info` VALUES ('2215520224936060', '直销产品', '0', '', '1204', '1231', '1449223889895', '12', '12', '0', '0', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '', '', '', '', '34', '45', null);
INSERT INTO `product_info` VALUES ('2215520224936061', '123', '0', '', '1205', '1231', '1449283644051', '11', '11', '0', '0', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '', '', '', '', '12', '11', null);
INSERT INTO `product_info` VALUES ('2215520224936062', '张翔鹏测试景区', '0', '', '1205', '1231', '1449285112460', '10', '13', '0', '0', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '', '', '', '', 'XXXXXXXXXX', 'XXXXXXXXXX', null);
INSERT INTO `product_info` VALUES ('2215520224936063', '就要看看是哪个景区', '0', '', '1205', '1218', '1449286747375', '13', '13', '0', '0', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '', '', '', '', 'XXXXXXXXXXX', 'XXXXXXXXX', null);
INSERT INTO `product_info` VALUES ('2215520224936064', '333', '0', '', '1205', '1231', '1449286715143', '12', '12', '0', '0', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '', '', '', '', '11', '11', null);
INSERT INTO `product_info` VALUES ('2215520224936065', '只能用这个了让', '0', '', '1205', '1225', '1449287461128', '12', '14', '0', '0', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '', '', '', '', 'XXXXXXX', 'XXXXXXXX', null);
INSERT INTO `product_info` VALUES ('2215520224936066', '', '0', 'wwwwwww', '', '', '1449294262377', '0', '0', '0', '0', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '', '', '', '', '', '', null);
INSERT INTO `product_info` VALUES ('2215520224936067', '3455', '0', '', '1205', '1231', '1449295031403', '12', '12', '0', '0', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '', '', '', '', '55', '55', null);
INSERT INTO `product_info` VALUES ('2215520224936068', '67', '0', '', '1205', '1231', '1449295767447', '20', '20', '0', '0', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '', '', '', '', '99', '99', null);
INSERT INTO `product_info` VALUES ('2215520224936069', '', '0', 'wwwwwww', '', '', '1449296173373', '0', '0', '0', '0', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '', '', '', '', '', '', null);
INSERT INTO `product_info` VALUES ('2215520224936070', '56', '0', '', '1205', '1231', '1449296139437', '11', '11', '0', '0', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '', '', '', '', '11', '11', null);
INSERT INTO `product_info` VALUES ('2215520224936071', 'zxp222', '0', '', '1205', '0304', '1449296085539', '13', '13', '0', '0', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '', '', '', '', 'XXXXXXXX', 'XXXXXXXXXX', null);
INSERT INTO `product_info` VALUES ('2215520224936072', '45', '0', '', '1205', '1231', '1449296501507', '11', '11', '0', '0', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '', '', '', '', '77', '77', null);
INSERT INTO `product_info` VALUES ('2215520224936073', '', '0', 'wwwwwww', '', '', '1449298965621', '0', '0', '0', '0', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '', '', '', '', '', '', null);
INSERT INTO `product_info` VALUES ('2215520224936074', '777', '0', '', '1205', '1231', '1449300498852', '11', '11', '0', '0', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '', '', '', '', '33', '33', null);
INSERT INTO `product_info` VALUES ('2215520224936075', '123', '0', '', '1205', '1231', '1449302280272', '1', '1', '0', '0', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '', '', '', '', '11', '111', null);
INSERT INTO `product_info` VALUES ('2215520224936076', 'yan1636', '0', '', '1205', '1231', '1449305459529', '12', '12', '0', '0', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '', '', '', '', '66', '66', null);
INSERT INTO `product_info` VALUES ('2215520224936077', '222', '0', '', '1205', '1231', '1449306418180', '12', '12', '0', '0', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '', '', '', '', '45', '45', null);
INSERT INTO `product_info` VALUES ('2215520224936078', '线下团测试', '0', '', '1205', '0401', '1449307809365', '12', '12', '0', '0', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '', '', '', '', 'XXXXXXXXXX', 'XXXXXXXXXXXXXX', null);
INSERT INTO `product_info` VALUES ('2215520224936079', '杨发1206', '0', '', '1206', '0110', '1449380653074', '0', '23', '0', '0', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '', '', '', '', '而我却', '惹我', null);
INSERT INTO `product_info` VALUES ('2215520224936080', 'qw', '0', '', '1206', '0101', '1449381266624', '12', '12', '0', '0', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '', '', '', '', '1212', '1212', null);
INSERT INTO `product_info` VALUES ('2215520224936081', '1406', '0', '', '1206', '1231', '1449382612328', '12', '12', '0', '0', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '', '', '', '', '11', '111', null);
INSERT INTO `product_info` VALUES ('2215520224936082', 'sds', '4', '', '1225', '1225', '1449386673558', '11', '11', '0', '0', '', '2015-12-06 15:11:43', '', '0000-00-00 00:00:00', '0', '', '', '', '', '', '12121212', null);
INSERT INTO `product_info` VALUES ('2215520224936083', '45', '0', '', '1206', '1231', '1449388793369', '12', '12', '0', '0', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '', '', '', '', '222', '222', null);
INSERT INTO `product_info` VALUES ('2215520224936084', 'sfsd', '4', '', '1224', '1231', '1449390878586', '1', '1', '0', '0', '', '2015-12-06 16:21:12', '', '0000-00-00 00:00:00', '0', '', '', '', '', '', 'dfsdfsd', null);
INSERT INTO `product_info` VALUES ('2215520224936085', '233', '0', '', '1206', '1231', '1449390967116', '20', '20', '0', '0', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '', '', '', '', '45', '54', null);
INSERT INTO `product_info` VALUES ('2215520224936086', '123', '0', '', '1206', '1206', '1449391026715', '1', '1', '0', '0', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '', '', '', '', '1', '1', null);
INSERT INTO `product_info` VALUES ('2215520224936087', '123', '0', '', '1206', '1229', '1449406321904', '12', '12', '0', '0', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '', '', '', '', '12', '12', null);

-- ----------------------------
-- Table structure for `product_package`
-- ----------------------------
DROP TABLE IF EXISTS `product_package`;
CREATE TABLE `product_package` (
  `id` bigint(20) NOT NULL,
  `name` varchar(100) DEFAULT NULL COMMENT '子票名称',
  `sub_rebate_rule` varchar(6) DEFAULT NULL COMMENT '联票子票返利规则，所有规则都存到本字段中',
  `package_type` int(1) DEFAULT NULL COMMENT '子票类型（1普通票 2积分票）',
  `status` int(1) DEFAULT '0' COMMENT '状态（1启用0禁用2删除）',
  `create_by` varchar(100) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_by` varchar(100) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `product_id` bigint(20) DEFAULT NULL COMMENT '产品id',
  `supplier_id` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='联票子票主表';

-- ----------------------------
-- Records of product_package
-- ----------------------------

-- ----------------------------
-- Table structure for `product_package_sub`
-- ----------------------------
DROP TABLE IF EXISTS `product_package_sub`;
CREATE TABLE `product_package_sub` (
  `id` bigint(20) NOT NULL,
  `rebate_type` int(1) DEFAULT '1' COMMENT '返利方式（1现金 2积分）',
  `scenic_cnt` int(10) DEFAULT '0' COMMENT '关联景区数量',
  `rebate_sum` double(10,2) DEFAULT '0.00' COMMENT '返利金额/积分',
  `points_type` int(1) DEFAULT NULL COMMENT '积分类型',
  `remarks` varchar(500) DEFAULT NULL,
  `package_id` bigint(20) DEFAULT '0' COMMENT '联票子票id',
  `supplier_id` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='联票子票从表';

-- ----------------------------
-- Records of product_package_sub
-- ----------------------------

-- ----------------------------
-- Table structure for `product_rebate_rule`
-- ----------------------------
DROP TABLE IF EXISTS `product_rebate_rule`;
CREATE TABLE `product_rebate_rule` (
  `id` bigint(20) NOT NULL,
  `name` varchar(128) DEFAULT NULL COMMENT '名称',
  `product_id` bigint(20) DEFAULT NULL COMMENT '产品（子票）id',
  `product_name` varchar(128) DEFAULT NULL,
  `flag` char(1) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `create_by` varchar(20) DEFAULT NULL,
  `match_cnt` int(3) DEFAULT NULL COMMENT '期望配对书',
  `auditStatus` varchar(2) DEFAULT NULL COMMENT '审核状态',
  `supplier_id` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='加点返产品';

-- ----------------------------
-- Records of product_rebate_rule
-- ----------------------------
INSERT INTO `product_rebate_rule` VALUES ('1', '1', '1', '1', '1', '0000-00-00 00:00:00', '1', '1', '1', null);

-- ----------------------------
-- Table structure for `product_rebate_rule_relation`
-- ----------------------------
DROP TABLE IF EXISTS `product_rebate_rule_relation`;
CREATE TABLE `product_rebate_rule_relation` (
  `preposition_supplier_id` bigint(20) DEFAULT NULL COMMENT '前置景区产品所属的供应商id',
  `preposition_product_id` varchar(20) DEFAULT NULL COMMENT '前置景区产品id',
  `rebate_rule_id` bigint(20) DEFAULT NULL COMMENT '加点返id',
  `flag` varchar(2) DEFAULT NULL COMMENT '状态',
  `id` bigint(20) DEFAULT NULL,
  `supplier_id` varchar(20) DEFAULT NULL COMMENT '供应商id'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='加点返产品关联';

-- ----------------------------
-- Records of product_rebate_rule_relation
-- ----------------------------

-- ----------------------------
-- Table structure for `product_relation`
-- ----------------------------
DROP TABLE IF EXISTS `product_relation`;
CREATE TABLE `product_relation` (
  `id` bigint(20) NOT NULL,
  `obj_id` bigint(64) NOT NULL COMMENT '对象id',
  `obj_type` varchar(20) NOT NULL,
  `rel_id` bigint(64) NOT NULL COMMENT '关联id',
  `rel_type` varchar(20) NOT NULL COMMENT '关联类型，以表名作为类型',
  `create_by` varchar(100) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_by` varchar(100) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `sort` int(11) DEFAULT '0' COMMENT '排序',
  `flag` char(1) NOT NULL DEFAULT '1' COMMENT '使用状态1启用0禁用2删除',
  `remarks` varchar(64) DEFAULT NULL COMMENT '字段信息',
  `group_code` varchar(32) DEFAULT NULL COMMENT '一组数据的标识',
  `supplier_id` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='产品关系表';

-- ----------------------------
-- Records of product_relation
-- ----------------------------
INSERT INTO `product_relation` VALUES ('2215520224940937', '2215520224935937', 'proRelease', '2215520224935937', 'scenic', '', '2015-11-23 11:10:22', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224940938', '2215520224935937', 'proRelease', '2215520224935938', 'scenic', '', '2015-11-23 11:10:22', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224940939', '2215520224935938', 'proRelease', '1111111111', 'scenic', 'aaaaaa', '2015-11-23 14:04:32', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224940940', '2215520224935938', 'proRelease', '1111111111', 'scenic', 'aaaaaa', '2015-11-23 14:04:32', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224940941', '2215520224935939', 'proRelease', '1111111111', 'scenic', 'aaaaaa', '2015-11-23 14:29:56', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224940942', '2215520224935939', 'proRelease', '1111111111', 'scenic', 'aaaaaa', '2015-11-23 14:29:56', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224940943', '2215520224935940', 'proRelease', '2215520224935937', 'scenic', '', '2015-11-23 14:37:32', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224940944', '2215520224935940', 'proRelease', '2215520224935938', 'scenic', '', '2015-11-23 14:37:32', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224940945', '2215520224935941', 'proRelease', '2215520224935937', 'scenic', '', '2015-11-23 15:15:40', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224940946', '2215520224935941', 'proRelease', '2215520224935938', 'scenic', '', '2015-11-23 15:15:40', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224940947', '2215520224935942', 'proRelease', '2215520224935937', 'scenic', '', '2015-11-23 15:17:17', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224940948', '2215520224935942', 'proRelease', '2215520224935938', 'scenic', '', '2015-11-23 15:17:17', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224940949', '2215520224935943', 'proRelease', '2215520224935937', 'scenic', '', '2015-11-23 15:39:26', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224940950', '2215520224935944', 'proRelease', '2215520224935937', 'scenic', '', '2015-11-23 15:51:21', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224940951', '2215520224935945', 'proRelease', '2215520224935937', 'scenic', '', '2015-11-23 16:06:57', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224940952', '2215520224935946', 'proRelease', '2215520224935938', 'scenic', '', '2015-11-23 16:07:35', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224940953', '2215520224935947', 'proRelease', '1111111111', 'scenic', 'aaaaaa', '2015-11-23 16:13:38', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224940954', '2215520224935947', 'proRelease', '1111111111', 'scenic', 'aaaaaa', '2015-11-23 16:13:38', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224940955', '2215520224935948', 'proRelease', '1111111111', 'scenic', 'aaaaaa', '2015-11-23 16:26:46', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224940956', '2215520224935948', 'proRelease', '1111111111', 'scenic', 'aaaaaa', '2015-11-23 16:26:46', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224940957', '2215520224935949', 'proRelease', '2215520224935937', 'scenic', '', '2015-11-23 16:44:46', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224940958', '2215520224935950', 'proRelease', '2215520224935938', 'scenic', '', '2015-11-23 17:09:37', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224940959', '2215520224935951', 'proRelease', '2215520224935938', 'scenic', '', '2015-11-23 17:10:28', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224940960', '2215520224935952', 'proRelease', '2215520224935937', 'scenic', '', '2015-11-23 17:46:39', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224940961', '2215520224935953', 'proRelease', '2215520224935937', 'scenic', '', '2015-11-23 17:46:39', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224940962', '2215520224935954', 'proRelease', '2215520224935937', 'scenic', '', '2015-11-23 17:47:20', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224940963', '2215520224935955', 'proRelease', '2215520224935937', 'scenic', '', '2015-11-23 17:47:20', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224940964', '2215520224935956', 'proRelease', '1111111111', 'scenic', 'aaaaaa', '2015-11-23 19:29:30', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224940965', '2215520224935956', 'proRelease', '1111111111', 'scenic', 'aaaaaa', '2015-11-23 19:29:30', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224940966', '2215520224935957', 'proRelease', '2215520224935938', 'scenic', '', '2015-11-23 20:03:28', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224940967', '2215520224935958', 'proRelease', '2215520224935937', 'scenic', '', '2015-11-23 20:05:03', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224940968', '2215520224935959', 'proRelease', '2215520224935937', 'scenic', '', '2015-11-23 20:05:42', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224940969', '2215520224935960', 'proRelease', '2215520224935937', 'scenic', '', '2015-11-23 20:18:33', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224940970', '2215520224935960', 'proRelease', '2215520224935937', 'scenic', '', '2015-11-23 20:18:33', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224940971', '2215520224935961', 'proRelease', '2215520224935937', 'scenic', '', '2015-11-23 20:18:33', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224940972', '2215520224935961', 'proRelease', '2215520224935937', 'scenic', '', '2015-11-23 20:18:33', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224940973', '2215520224935962', 'proRelease', '2215520224935938', 'scenic', '', '2015-11-23 20:27:51', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224940974', '2215520224935963', 'proRelease', '1111111111', 'scenic', 'aaaaaa', '2015-11-23 20:48:47', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224940975', '2215520224935963', 'proRelease', '1111111111', 'scenic', 'aaaaaa', '2015-11-23 20:48:47', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224940976', '2215520224935964', 'proRelease', '1111111111', 'scenic', 'aaaaaa', '2015-11-23 20:49:24', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224940977', '2215520224935964', 'proRelease', '1111111111', 'scenic', 'aaaaaa', '2015-11-23 20:49:24', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224940978', '2215520224935965', 'proRelease', '2215520224935939', 'scenic', '', '2015-11-23 21:34:07', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224940979', '2215520224935966', 'proRelease', '2215520224935939', 'scenic', '', '2015-11-23 21:34:36', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224940980', '2215520224935967', 'proRelease', '2215520224935937', 'scenic', '', '2015-11-23 21:35:53', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224940981', '2215520224935968', 'proRelease', '2215520224935938', 'scenic', '', '2015-11-23 21:52:10', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224940982', '2215520224935969', 'proRelease', '2215520224935937', 'scenic', '', '2015-11-24 13:35:29', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224940983', '2215520224940938', 'proSiteData', '1', 'proDict', '', '2015-11-24 13:54:04', '', '0000-00-00 00:00:00', '0', '', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224940984', '2215520224940938', 'proSiteData', '2', 'proDict', '', '2015-11-24 13:54:04', '', '0000-00-00 00:00:00', '0', '', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224940985', '2215520224935970', 'proRelease', '1111111111', 'scenic', 'aaaaaa', '2015-11-24 16:41:10', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224940986', '2215520224935970', 'proRelease', '1111111111', 'scenic', 'aaaaaa', '2015-11-24 16:41:10', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224940987', '2215520224935971', 'proRelease', '2215520224935938', 'scenic', '', '2015-11-25 09:13:04', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224940988', '2215520224935972', 'proRelease', '2215520224935937', 'scenic', '', '2015-11-25 13:03:44', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224940989', '2215520224935972', 'proRelease', '2215520224935938', 'scenic', '', '2015-11-25 13:03:44', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224940990', '2215520224935972', 'proRelease', '2215520224935939', 'scenic', '', '2015-11-25 13:03:44', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224940991', '2215520224935972', 'proRelease', '2215520224935940', 'scenic', '', '2015-11-25 13:03:44', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224940992', '2215520224935973', 'proRelease', '2215520224935937', 'scenic', '', '2015-11-25 13:03:44', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224940993', '2215520224935973', 'proRelease', '2215520224935938', 'scenic', '', '2015-11-25 13:03:44', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224940994', '2215520224935973', 'proRelease', '2215520224935939', 'scenic', '', '2015-11-25 13:03:44', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224940995', '2215520224935973', 'proRelease', '2215520224935940', 'scenic', '', '2015-11-25 13:03:44', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224940996', '2215520224935974', 'proRelease', '2215520224935937', 'scenic', '', '2015-11-25 13:03:44', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224940997', '2215520224935974', 'proRelease', '2215520224935938', 'scenic', '', '2015-11-25 13:03:44', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224940998', '2215520224935974', 'proRelease', '2215520224935939', 'scenic', '', '2015-11-25 13:03:44', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224940999', '2215520224935974', 'proRelease', '2215520224935940', 'scenic', '', '2015-11-25 13:03:44', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941000', '2215520224935975', 'proRelease', '2215520224935937', 'scenic', '', '2015-11-25 13:03:44', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941001', '2215520224935975', 'proRelease', '2215520224935938', 'scenic', '', '2015-11-25 13:03:44', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941002', '2215520224935975', 'proRelease', '2215520224935939', 'scenic', '', '2015-11-25 13:03:44', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941003', '2215520224935975', 'proRelease', '2215520224935940', 'scenic', '', '2015-11-25 13:03:44', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941004', '2215520224935976', 'proRelease', '2215520224935937', 'scenic', '', '2015-11-25 13:03:44', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941005', '2215520224935976', 'proRelease', '2215520224935938', 'scenic', '', '2015-11-25 13:03:44', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941006', '2215520224935976', 'proRelease', '2215520224935939', 'scenic', '', '2015-11-25 13:03:44', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941007', '2215520224935976', 'proRelease', '2215520224935940', 'scenic', '', '2015-11-25 13:03:44', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941008', '2215520224935977', 'proRelease', '2215520224935937', 'scenic', '', '2015-11-25 13:03:44', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941009', '2215520224935977', 'proRelease', '2215520224935938', 'scenic', '', '2015-11-25 13:03:44', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941010', '2215520224935977', 'proRelease', '2215520224935939', 'scenic', '', '2015-11-25 13:03:44', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941011', '2215520224935977', 'proRelease', '2215520224935940', 'scenic', '', '2015-11-25 13:03:44', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941012', '2215520224935978', 'proRelease', '2215520224935937', 'scenic', '', '2015-11-25 13:03:44', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941013', '2215520224935978', 'proRelease', '2215520224935938', 'scenic', '', '2015-11-25 13:03:44', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941014', '2215520224935978', 'proRelease', '2215520224935939', 'scenic', '', '2015-11-25 13:03:44', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941015', '2215520224935978', 'proRelease', '2215520224935940', 'scenic', '', '2015-11-25 13:03:44', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941016', '2215520224935979', 'proRelease', '2215520224935937', 'scenic', '', '2015-11-25 13:03:44', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941017', '2215520224935979', 'proRelease', '2215520224935938', 'scenic', '', '2015-11-25 13:03:44', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941018', '2215520224935979', 'proRelease', '2215520224935939', 'scenic', '', '2015-11-25 13:03:44', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941019', '2215520224935979', 'proRelease', '2215520224935940', 'scenic', '', '2015-11-25 13:03:44', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941020', '2215520224935980', 'proRelease', '2215520224935937', 'scenic', '', '2015-11-25 13:03:44', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941021', '2215520224935980', 'proRelease', '2215520224935938', 'scenic', '', '2015-11-25 13:03:44', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941022', '2215520224935980', 'proRelease', '2215520224935939', 'scenic', '', '2015-11-25 13:03:44', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941023', '2215520224935980', 'proRelease', '2215520224935940', 'scenic', '', '2015-11-25 13:03:44', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941024', '2215520224935981', 'proRelease', '2215520224935937', 'scenic', '', '2015-11-25 13:03:44', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941025', '2215520224935981', 'proRelease', '2215520224935938', 'scenic', '', '2015-11-25 13:03:44', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941026', '2215520224935981', 'proRelease', '2215520224935939', 'scenic', '', '2015-11-25 13:03:44', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941027', '2215520224935981', 'proRelease', '2215520224935940', 'scenic', '', '2015-11-25 13:03:44', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941028', '2215520224935982', 'proRelease', '2215520224935937', 'scenic', '', '2015-11-25 13:03:44', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941029', '2215520224935982', 'proRelease', '2215520224935938', 'scenic', '', '2015-11-25 13:03:44', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941030', '2215520224935982', 'proRelease', '2215520224935939', 'scenic', '', '2015-11-25 13:03:44', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941031', '2215520224935982', 'proRelease', '2215520224935940', 'scenic', '', '2015-11-25 13:03:44', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941032', '2215520224935983', 'proRelease', '2215520224935937', 'scenic', '', '2015-11-25 13:03:44', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941033', '2215520224935983', 'proRelease', '2215520224935938', 'scenic', '', '2015-11-25 13:03:44', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941034', '2215520224935983', 'proRelease', '2215520224935939', 'scenic', '', '2015-11-25 13:03:44', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941035', '2215520224935983', 'proRelease', '2215520224935940', 'scenic', '', '2015-11-25 13:03:44', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941036', '2215520224935984', 'proRelease', '2215520224935937', 'scenic', '', '2015-11-25 13:03:44', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941037', '2215520224935984', 'proRelease', '2215520224935938', 'scenic', '', '2015-11-25 13:03:44', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941038', '2215520224935984', 'proRelease', '2215520224935939', 'scenic', '', '2015-11-25 13:03:44', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941039', '2215520224935984', 'proRelease', '2215520224935940', 'scenic', '', '2015-11-25 13:03:44', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941040', '2215520224935985', 'proRelease', '2215520224935937', 'scenic', '', '2015-11-25 14:11:59', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941041', '2215520224935986', 'proRelease', '2215520224935937', 'scenic', '', '2015-11-25 14:11:59', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941042', '2215520224935987', 'proRelease', '2215520224935937', 'scenic', '', '2015-11-25 14:11:59', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941043', '2215520224935988', 'proRelease', '2215520224935937', 'scenic', '', '2015-11-25 14:11:59', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941044', '2215520224935989', 'proRelease', '2215520224935937', 'scenic', '', '2015-11-25 14:11:59', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941045', '2215520224935990', 'proRelease', '2215520224935937', 'scenic', '', '2015-11-25 14:11:59', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941046', '2215520224935991', 'proRelease', '2215520224935937', 'scenic', '', '2015-11-25 14:11:59', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941047', '2215520224935992', 'proRelease', '2215520224935937', 'scenic', '', '2015-11-25 14:11:59', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941048', '2215520224935993', 'proRelease', '2215520224935937', 'scenic', '', '2015-11-25 14:11:59', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941049', '2215520224935994', 'proRelease', '2215520224935937', 'scenic', '', '2015-11-25 14:11:59', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941050', '2215520224935995', 'proRelease', '2215520224935937', 'scenic', '', '2015-11-25 14:11:59', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941051', '2215520224935996', 'proRelease', '2215520224935937', 'scenic', '', '2015-11-25 14:11:59', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941052', '2215520224935997', 'proRelease', '2215520224935937', 'scenic', '', '2015-11-25 14:11:59', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941053', '2215520224935998', 'proRelease', '2215520224935937', 'scenic', '', '2015-11-25 14:11:59', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941054', '2215520224935999', 'proRelease', '2215520224935937', 'scenic', '', '2015-11-25 14:11:59', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941055', '2215520224936000', 'proRelease', '2215520224935937', 'scenic', '', '2015-11-25 14:11:59', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941056', '2215520224936001', 'proRelease', '1111111111', 'scenic', 'aaaaaa', '2015-11-25 16:09:09', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941057', '2215520224936001', 'proRelease', '1111111111', 'scenic', 'aaaaaa', '2015-11-25 16:09:09', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941058', '2215520224936002', 'proRelease', '1111111111', 'scenic', 'aaaaaa', '2015-11-25 16:20:47', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941059', '2215520224936002', 'proRelease', '1111111111', 'scenic', 'aaaaaa', '2015-11-25 16:20:47', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941060', '2215520224936003', 'proRelease', '1111111111', 'scenic', 'aaaaaa', '2015-11-25 16:29:38', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941061', '2215520224936003', 'proRelease', '1111111111', 'scenic', 'aaaaaa', '2015-11-25 16:29:38', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941062', '2215520224936004', 'proRelease', '1111111111', 'scenic', 'aaaaaa', '2015-11-25 16:45:00', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941063', '2215520224936004', 'proRelease', '1111111111', 'scenic', 'aaaaaa', '2015-11-25 16:45:00', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941064', '2215520224936005', 'proRelease', '1111111111', 'scenic', 'aaaaaa', '2015-11-25 17:39:03', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941065', '2215520224936005', 'proRelease', '1111111111', 'scenic', 'aaaaaa', '2015-11-25 17:39:03', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941066', '2215520224936006', 'proRelease', '1111111111', 'scenic', 'aaaaaa', '2015-11-25 17:47:48', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941067', '2215520224936006', 'proRelease', '1111111111', 'scenic', 'aaaaaa', '2015-11-25 17:47:48', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941068', '2215520224940940', 'proSiteData', '2', 'proDict', '', '2015-11-25 19:02:25', '', '0000-00-00 00:00:00', '0', '', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941069', '2215520224936007', 'proRelease', '1111111111', 'scenic', 'aaaaaa', '2015-11-25 19:48:29', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941070', '2215520224936007', 'proRelease', '1111111111', 'scenic', 'aaaaaa', '2015-11-25 19:48:29', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941071', '2215520224936008', 'proRelease', '2215520224935937', 'scenic', '', '2015-11-25 21:01:10', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941072', '2215520224936009', 'proRelease', '1111111111', 'scenic', 'aaaaaa', '2015-11-25 21:14:45', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941073', '2215520224936009', 'proRelease', '1111111111', 'scenic', 'aaaaaa', '2015-11-25 21:14:45', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941074', '2215520224940938', 'proSiteData', '1', 'proDict', '', '0000-00-00 00:00:00', '', '2015-11-25 21:56:23', '0', '', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941075', '2215520224940938', 'proSiteData', '2', 'proDict', '', '0000-00-00 00:00:00', '', '2015-11-25 21:56:23', '0', '', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941076', '2215520224940938', 'proSiteData', '1', 'proDict', '', '0000-00-00 00:00:00', '', '2015-11-25 22:13:27', '0', '', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941077', '2215520224940938', 'proSiteData', '2', 'proDict', '', '0000-00-00 00:00:00', '', '2015-11-25 22:13:27', '0', '', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941078', '2215520224936010', 'proRelease', '1111111111', 'scenic', 'aaaaaa', '2015-11-26 10:11:47', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941079', '2215520224936010', 'proRelease', '1111111111', 'scenic', 'aaaaaa', '2015-11-26 10:11:47', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941080', '2215520224936011', 'proRelease', '1111111111', 'scenic', 'aaaaaa', '2015-11-26 11:20:45', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941081', '2215520224936011', 'proRelease', '1111111111', 'scenic', 'aaaaaa', '2015-11-26 11:20:45', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941082', '2215520224936012', 'proRelease', '1111111111', 'scenic', 'aaaaaa', '2015-11-26 17:28:50', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941083', '2215520224936012', 'proRelease', '1111111111', 'scenic', 'aaaaaa', '2015-11-26 17:28:50', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941084', '2215520224940938', 'proSiteData', '1', 'proDict', '', '0000-00-00 00:00:00', '', '2015-11-27 15:47:22', '0', '', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941085', '2215520224940938', 'proSiteData', '2', 'proDict', '', '0000-00-00 00:00:00', '', '2015-11-27 15:47:22', '0', '', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941086', '2215520224940938', 'proSiteData', '1', 'proDict', '', '0000-00-00 00:00:00', '', '2015-11-27 15:48:16', '0', '', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941087', '2215520224940938', 'proSiteData', '2', 'proDict', '', '0000-00-00 00:00:00', '', '2015-11-27 15:48:16', '0', '', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941088', '2215520224940938', 'proSiteData', '1', 'proDict', '', '0000-00-00 00:00:00', '', '2015-11-27 15:48:52', '0', '', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941089', '2215520224940938', 'proSiteData', '2', 'proDict', '', '0000-00-00 00:00:00', '', '2015-11-27 15:48:52', '0', '', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941090', '2215520224940938', 'proSiteData', '1', 'proDict', '', '0000-00-00 00:00:00', '', '2015-11-27 15:51:32', '0', '', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941091', '2215520224940938', 'proSiteData', '2', 'proDict', '', '0000-00-00 00:00:00', '', '2015-11-27 15:51:32', '0', '', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941092', '2215520224940938', 'proSiteData', '1', 'proDict', '', '0000-00-00 00:00:00', '', '2015-11-27 15:56:20', '0', '', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941093', '2215520224940938', 'proSiteData', '2', 'proDict', '', '0000-00-00 00:00:00', '', '2015-11-27 15:56:20', '0', '', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941094', '2215520224936013', 'proRelease', '1111111111', 'scenic', 'aaaaaa', '2015-11-28 15:17:39', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941095', '2215520224936013', 'proRelease', '1111111111', 'scenic', 'aaaaaa', '2015-11-28 15:17:39', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941096', '2215520224936014', 'proRelease', '1111111111', 'scenic', 'aaaaaa', '2015-11-28 15:36:27', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941097', '2215520224936014', 'proRelease', '1111111111', 'scenic', 'aaaaaa', '2015-11-28 15:36:27', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941098', '2215520224936015', 'proRelease', '1111111111', 'scenic', 'aaaaaa', '2015-11-28 15:41:01', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941099', '2215520224936015', 'proRelease', '1111111111', 'scenic', 'aaaaaa', '2015-11-28 15:41:01', '', '0000-00-00 00:00:00', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941100', '2215520224936016', 'proRelease', '1111111111', 'scenic', 'aaaaaa', '2015-11-30 20:26:50', '', '0000-00-00 00:00:00', '0', '1', '1448887196638', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941101', '2215520224936016', 'proRelease', '1111111111', 'scenic', 'aaaaaa', '2015-11-30 20:26:50', '', '0000-00-00 00:00:00', '0', '1', '1448887196638', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941102', '2215520224936017', 'proRelease', '1111111111', 'scenic', 'aaaaaa', '2015-11-30 20:29:02', '', '0000-00-00 00:00:00', '0', '1', '1448886699754', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941103', '2215520224936017', 'proRelease', '1111111111', 'scenic', 'aaaaaa', '2015-11-30 20:29:02', '', '0000-00-00 00:00:00', '0', '1', '1448886699754', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941104', '2215520224936018', 'proRelease', '1111111111', 'scenic', 'aaaaaa', '2015-12-01 11:55:49', '', '0000-00-00 00:00:00', '0', '1', '1448942911619', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941105', '2215520224936018', 'proRelease', '1111111111', 'scenic', 'aaaaaa', '2015-12-01 11:55:49', '', '0000-00-00 00:00:00', '0', '1', '1448942911619', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941106', '2215520224936019', 'proRelease', '1111111111', 'scenic', 'aaaaaa', '2015-12-01 14:28:56', '', '0000-00-00 00:00:00', '0', '1', '1448951750380', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941107', '2215520224936019', 'proRelease', '1111111111', 'scenic', 'aaaaaa', '2015-12-01 14:28:56', '', '0000-00-00 00:00:00', '0', '1', '1448951750380', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941108', '2215520224936020', 'proRelease', '1111111111', 'scenic', 'aaaaaa', '2015-12-01 14:39:47', '', '0000-00-00 00:00:00', '0', '1', '1448952468906', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941109', '2215520224936020', 'proRelease', '1111111111', 'scenic', 'aaaaaa', '2015-12-01 14:39:47', '', '0000-00-00 00:00:00', '0', '1', '1448952468906', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941110', '2215520224936021', 'proRelease', '2215520224935937', 'scenic', '', '2015-12-01 15:13:15', '', '0000-00-00 00:00:00', '0', '1', '1448954171738', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941111', '2215520224936022', 'proRelease', '1111111111', 'scenic', 'aaaaaa', '2015-12-01 16:39:45', '', '0000-00-00 00:00:00', '0', '1', '1448960038425', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941112', '2215520224936022', 'proRelease', '1111111111', 'scenic', 'aaaaaa', '2015-12-01 16:39:45', '', '0000-00-00 00:00:00', '0', '1', '1448960038425', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941113', '2215520224936023', 'proRelease', '2215520224935938', 'scenic', '', '2015-12-01 17:12:26', '', '0000-00-00 00:00:00', '0', '1', '1448961340737', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941114', '2215520224936024', 'proRelease', '2215520224935937', 'scenic', '', '2015-12-01 18:00:15', '', '0000-00-00 00:00:00', '0', '1', '1448964917626', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941115', '2215520224936025', 'proRelease', '2215520224935937', 'scenic', '', '2015-12-01 18:05:04', '', '0000-00-00 00:00:00', '0', '1', '1448964994905', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941116', '2215520224936026', 'proRelease', '2215520224935937', 'scenic', '', '2015-12-01 18:05:04', '', '0000-00-00 00:00:00', '0', '1', '1448964994905', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941117', '2215520224936027', 'proRelease', '2215520224935937', 'scenic', '', '2015-12-01 18:05:04', '', '0000-00-00 00:00:00', '0', '1', '1448964994905', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941118', '2215520224936028', 'proRelease', '2215520224935937', 'scenic', '', '2015-12-01 18:05:04', '', '0000-00-00 00:00:00', '0', '1', '1448964994905', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941119', '2215520224936029', 'proRelease', '1111111111', 'scenic', 'aaaaaa', '2015-12-02 09:23:49', '', '0000-00-00 00:00:00', '0', '1', '1449019847165', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941120', '2215520224936029', 'proRelease', '1111111111', 'scenic', 'aaaaaa', '2015-12-02 09:23:49', '', '0000-00-00 00:00:00', '0', '1', '1449019847165', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941121', '2215520224936030', 'proRelease', '2215520224935937', 'scenic', '', '2015-12-02 11:36:42', '', '0000-00-00 00:00:00', '0', '1', '1449027451476', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941122', '2215520224936031', 'proRelease', '2215520224935937', 'scenic', '', '2015-12-02 11:36:42', '', '0000-00-00 00:00:00', '0', '1', '1449027451476', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941123', '2215520224936032', 'proRelease', '2215520224935937', 'scenic', '', '2015-12-02 11:36:42', '', '0000-00-00 00:00:00', '0', '1', '1449027451476', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941124', '2215520224936033', 'proRelease', '2215520224935937', 'scenic', '', '2015-12-02 11:36:42', '', '0000-00-00 00:00:00', '0', '1', '1449027451476', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941125', '2215520224936034', 'proRelease', '2215520224935937', 'scenic', '', '2015-12-02 14:46:21', '', '0000-00-00 00:00:00', '0', '1', '1449039390077', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941126', '2215520224936035', 'proRelease', '2215520224935959', 'scenic', '', '2015-12-02 15:04:06', '', '0000-00-00 00:00:00', '0', '1', '1449040739385', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941127', '2215520224936036', 'proRelease', '2215520224935951', 'scenic', '', '2015-12-02 15:07:18', '', '0000-00-00 00:00:00', '0', '1', '1449040143685', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941128', '2215520224936037', 'proRelease', '2215520224935959', 'scenic', '', '2015-12-02 15:11:17', '', '0000-00-00 00:00:00', '0', '1', '1449041080728', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941129', '2215520224936037', 'proRelease', '2215520224935960', 'scenic', '', '2015-12-02 15:11:17', '', '0000-00-00 00:00:00', '0', '1', '1449041080728', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941130', '2215520224936038', 'proRelease', '2215520224935961', 'scenic', '', '2015-12-02 15:13:54', '', '0000-00-00 00:00:00', '0', '1', '1449041359588', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941131', '2215520224936039', 'proRelease', '2215520224935937', 'scenic', '', '2015-12-02 15:33:13', '', '0000-00-00 00:00:00', '0', '1', '1449042208462', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941132', '2215520224936040', 'proRelease', '2215520224935959', 'scenic', '', '2015-12-02 15:36:44', '', '0000-00-00 00:00:00', '0', '1', '1449041838918', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941133', '2215520224936041', 'proRelease', '2215520224935940', 'scenic', '', '2015-12-02 15:44:18', '', '0000-00-00 00:00:00', '0', '1', '1449042797974', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941134', '2215520224936042', 'proRelease', '2215520224935953', 'scenic', '', '2015-12-02 15:46:44', '', '0000-00-00 00:00:00', '0', '1', '1449042500706', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941135', '2215520224936043', 'proRelease', '2215520224935958', 'scenic', '', '2015-12-02 15:47:45', '', '0000-00-00 00:00:00', '0', '1', '1449043283235', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941136', '2215520224936044', 'proRelease', '2215520224935938', 'scenic', '', '2015-12-02 15:58:24', '', '0000-00-00 00:00:00', '0', '1', '1449043687408', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941137', '2215520224936045', 'proRelease', '2215520224935937', 'scenic', '', '2015-12-02 16:00:41', '', '0000-00-00 00:00:00', '0', '1', '1449043697093', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941138', '2215520224936046', 'proRelease', '2215520224935960', 'scenic', '', '2015-12-02 16:01:29', '', '0000-00-00 00:00:00', '0', '1', '1449043432193', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941139', '2215520224936047', 'proRelease', '2215520224935937', 'scenic', '', '2015-12-02 16:15:13', '', '0000-00-00 00:00:00', '0', '1', '1449044431580', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941140', '2215520224935976', 'proDict', '2215520224935985', 'proRelease', '1', '2015-12-02 16:15:31', '1', '2015-12-02 16:15:31', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941141', '2215520224935976', 'proDict', '2215520224935986', 'proRelease', '1', '2015-12-02 16:15:31', '1', '2015-12-02 16:15:31', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941142', '2215520224935976', 'proDict', '2215520224935987', 'proRelease', '1', '2015-12-02 16:15:31', '1', '2015-12-02 16:15:31', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941143', '2215520224936048', 'proRelease', '2215520224935960', 'scenic', '', '2015-12-02 16:15:46', '', '0000-00-00 00:00:00', '0', '1', '1449044281867', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941144', '2215520224936049', 'proRelease', '2215520224935953', 'scenic', '', '2015-12-02 16:34:37', '', '0000-00-00 00:00:00', '0', '1', '1449046174036', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941145', '2215520224936050', 'proRelease', '2215520224935953', 'scenic', '', '2015-12-02 16:35:39', '', '0000-00-00 00:00:00', '0', '1', '1449045723489', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941146', '2215520224936051', 'proRelease', '2215520224935937', 'scenic', '', '2015-12-02 17:27:15', '', '0000-00-00 00:00:00', '0', '1', '1449049134009', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941147', '2215520224936052', 'proRelease', '2215520224935940', 'scenic', '', '2015-12-02 17:28:39', '', '0000-00-00 00:00:00', '0', '1', '1449049103508', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941148', '2215520224936053', 'proRelease', '2215520224935937', 'scenic', '', '2015-12-03 12:03:15', '', '0000-00-00 00:00:00', '0', '1', '1449115698803', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941149', '2215520224936054', 'proRelease', '2215520224935937', 'scenic', '', '2015-12-03 12:03:15', '', '0000-00-00 00:00:00', '0', '1', '1449115698803', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941150', '2215520224936055', 'proRelease', '2215520224935939', 'scenic', '', '2015-12-03 13:37:39', '', '0000-00-00 00:00:00', '0', '1', '1449121467873', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941151', '2215520224936056', 'proRelease', '2215520224935965', 'scenic', '', '2015-12-03 13:44:32', '', '0000-00-00 00:00:00', '0', '1', '1449122334197', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941152', '2215520224936057', 'proRelease', '2215520224935937', 'scenic', '', '2015-12-03 14:03:03', '', '0000-00-00 00:00:00', '0', '1', '1449123386340', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941153', '2215520224936058', 'proRelease', '2215520224935937', 'scenic', '', '2015-12-03 14:09:55', '', '0000-00-00 00:00:00', '0', '1', '1449123363677', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941154', '2215520224936059', 'proRelease', '2215520224935967', 'scenic', '', '2015-12-03 15:00:00', '', '0000-00-00 00:00:00', '0', '1', '1449126754316', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941155', '2215520224936060', 'proRelease', '2215520224935938', 'scenic', '', '2015-12-03 16:28:11', '', '0000-00-00 00:00:00', '0', '1', '1449132137240', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941156', '2215520224936061', 'proRelease', '2215520224935967', 'scenic', '', '2015-12-04 09:12:26', '', '0000-00-00 00:00:00', '0', '1', '2215520224936026', '1449192174799', null);
INSERT INTO `product_relation` VALUES ('2215520224941157', '2215520224936062', 'proRelease', '2215520224935969', 'scenic', '', '2015-12-04 09:24:20', '', '0000-00-00 00:00:00', '0', '1', '2215520224936027', '1449192950046', null);
INSERT INTO `product_relation` VALUES ('2215520224941158', '2215520224936063', 'proRelease', '2215520224935969', 'scenic', '', '2015-12-04 09:24:20', '', '0000-00-00 00:00:00', '0', '1', '2215520224936027', '1449192950046', null);
INSERT INTO `product_relation` VALUES ('2215520224941159', '2215520224936064', 'proRelease', '2215520224935969', 'scenic', '', '2015-12-04 09:24:20', '', '0000-00-00 00:00:00', '0', '1', '2215520224936027', '1449192950046', null);
INSERT INTO `product_relation` VALUES ('2215520224941160', '2215520224936065', 'proRelease', '2215520224935969', 'scenic', '', '2015-12-04 09:24:20', '', '0000-00-00 00:00:00', '0', '1', '2215520224936027', '1449192950046', null);
INSERT INTO `product_relation` VALUES ('2215520224941161', '2215520224936066', 'proRelease', '2215520224935967', 'scenic', '', '2015-12-04 09:35:27', '', '0000-00-00 00:00:00', '0', '1', '2215520224936028', '1449193289389', null);
INSERT INTO `product_relation` VALUES ('2215520224941162', '2215520224936067', 'proRelease', '2215520224935969', 'scenic', '', '2015-12-04 10:13:31', '', '0000-00-00 00:00:00', '0', '1', '2215520224936029', '1449195679042', null);
INSERT INTO `product_relation` VALUES ('2215520224941163', '2215520224936068', 'proRelease', '2215520224935969', 'scenic', '', '2015-12-04 10:13:31', '', '0000-00-00 00:00:00', '0', '1', '2215520224936029', '1449195679042', null);
INSERT INTO `product_relation` VALUES ('2215520224941164', '2215520224936069', 'proRelease', '2215520224935969', 'scenic', '', '2015-12-04 10:13:31', '', '0000-00-00 00:00:00', '0', '1', '2215520224936029', '1449195679042', null);
INSERT INTO `product_relation` VALUES ('2215520224941165', '2215520224936070', 'proRelease', '2215520224935969', 'scenic', '', '2015-12-04 10:13:31', '', '0000-00-00 00:00:00', '0', '1', '2215520224936029', '1449195679042', null);
INSERT INTO `product_relation` VALUES ('2215520224941166', '2215520224936071', 'proRelease', '2215520224935952', 'scenic', '', '2015-12-04 10:28:32', '', '0000-00-00 00:00:00', '0', '1', '2215520224936030', '1449196219430', null);
INSERT INTO `product_relation` VALUES ('2215520224941167', '2215520224936072', 'proRelease', '2215520224935969', 'scenic', '', '2015-12-04 11:06:15', '', '0000-00-00 00:00:00', '0', '1', '2215520224936031', '1449198747690', null);
INSERT INTO `product_relation` VALUES ('2215520224941168', '2215520224936073', 'proRelease', '2215520224935969', 'scenic', '', '2015-12-04 11:06:15', '', '0000-00-00 00:00:00', '0', '1', '2215520224936031', '1449198747690', null);
INSERT INTO `product_relation` VALUES ('2215520224941169', '2215520224936074', 'proRelease', '2215520224935969', 'scenic', '', '2015-12-04 11:06:15', '', '0000-00-00 00:00:00', '0', '1', '2215520224936031', '1449198747690', null);
INSERT INTO `product_relation` VALUES ('2215520224941170', '2215520224936075', 'proRelease', '2215520224935969', 'scenic', '', '2015-12-04 11:06:15', '', '0000-00-00 00:00:00', '0', '1', '2215520224936031', '1449198747690', null);
INSERT INTO `product_relation` VALUES ('2215520224941171', '2215520224936076', 'proRelease', '2215520224935938', 'scenic', '', '2015-12-04 11:24:10', '', '0000-00-00 00:00:00', '0', '1', '2215520224936032', '1449200218908', null);
INSERT INTO `product_relation` VALUES ('2215520224941172', '2215520224936077', 'proRelease', '2215520224935967', 'scenic', '', '2015-12-04 13:19:11', '', '0000-00-00 00:00:00', '0', '1', '2215520224936033', '1449206986955', null);
INSERT INTO `product_relation` VALUES ('2215520224941173', '2215520224936078', 'proRelease', '2215520224935969', 'scenic', '', '2015-12-04 14:08:26', '', '0000-00-00 00:00:00', '0', '1', '2215520224936034', '1449210281240', null);
INSERT INTO `product_relation` VALUES ('2215520224941174', '2215520224936079', 'proRelease', '2215520224935969', 'scenic', '', '2015-12-04 14:08:26', '', '0000-00-00 00:00:00', '0', '1', '2215520224936034', '1449210281240', null);
INSERT INTO `product_relation` VALUES ('2215520224941175', '2215520224936080', 'proRelease', '2215520224935969', 'scenic', '', '2015-12-04 14:08:26', '', '0000-00-00 00:00:00', '0', '1', '2215520224936034', '1449210281240', null);
INSERT INTO `product_relation` VALUES ('2215520224941176', '2215520224936081', 'proRelease', '2215520224935969', 'scenic', '', '2015-12-04 14:08:26', '', '0000-00-00 00:00:00', '0', '1', '2215520224936034', '1449210281240', null);
INSERT INTO `product_relation` VALUES ('2215520224941177', '2215520224936082', 'proRelease', '2215520224935938', 'scenic', '', '2015-12-04 14:31:26', '', '0000-00-00 00:00:00', '0', '1', '2215520224936035', '1449210816077', null);
INSERT INTO `product_relation` VALUES ('2215520224941178', '2215520224936083', 'proRelease', '2215520224935969', 'scenic', '', '2015-12-04 14:34:47', '', '0000-00-00 00:00:00', '0', '1', '2215520224936036', '1449211824180', null);
INSERT INTO `product_relation` VALUES ('2215520224941179', '2215520224936084', 'proRelease', '2215520224935969', 'scenic', '', '2015-12-04 14:34:47', '', '0000-00-00 00:00:00', '0', '1', '2215520224936036', '1449211824180', null);
INSERT INTO `product_relation` VALUES ('2215520224941180', '2215520224936085', 'proRelease', '2215520224935969', 'scenic', '', '2015-12-04 14:34:47', '', '0000-00-00 00:00:00', '0', '1', '2215520224936036', '1449211824180', null);
INSERT INTO `product_relation` VALUES ('2215520224941181', '2215520224936086', 'proRelease', '2215520224935969', 'scenic', '', '2015-12-04 14:34:47', '', '0000-00-00 00:00:00', '0', '1', '2215520224936036', '1449211824180', null);
INSERT INTO `product_relation` VALUES ('2215520224941182', '2215520224936087', 'proRelease', '2215520224935969', 'scenic', '', '2015-12-04 14:59:37', '', '0000-00-00 00:00:00', '0', '1', '2215520224936037', '1449213358352', null);
INSERT INTO `product_relation` VALUES ('2215520224941183', '2215520224936088', 'proRelease', '2215520224935969', 'scenic', '', '2015-12-04 14:59:37', '', '0000-00-00 00:00:00', '0', '1', '2215520224936037', '1449213358352', null);
INSERT INTO `product_relation` VALUES ('2215520224941184', '2215520224936089', 'proRelease', '2215520224935939', 'scenic', '', '2015-12-04 15:06:13', '', '0000-00-00 00:00:00', '0', '1', '2215520224936038', '1449213134811', null);
INSERT INTO `product_relation` VALUES ('2215520224941185', '2215520224936090', 'proRelease', '2215520224935939', 'scenic', '', '2015-12-04 15:07:24', '', '0000-00-00 00:00:00', '0', '1', '2215520224936039', '1449213630119', null);
INSERT INTO `product_relation` VALUES ('2215520224941186', '2215520224936091', 'proRelease', '2215520224935969', 'scenic', '', '2015-12-04 15:09:25', '', '0000-00-00 00:00:00', '0', '1', '2215520224936040', '1449213919194', null);
INSERT INTO `product_relation` VALUES ('2215520224941187', '2215520224936092', 'proRelease', '2215520224935971', 'scenic', '', '2015-12-04 15:15:18', '', '0000-00-00 00:00:00', '0', '1', '2215520224936041', '1449213636122', null);
INSERT INTO `product_relation` VALUES ('2215520224941188', '2215520224936093', 'proRelease', '2215520224935967', 'scenic', '', '2015-12-04 15:17:16', '', '0000-00-00 00:00:00', '0', '1', '2215520224936042', '1449214044779', null);
INSERT INTO `product_relation` VALUES ('2215520224941189', '2215520224936094', 'proRelease', '2215520224935953', 'scenic', '', '2015-12-04 16:37:50', '', '0000-00-00 00:00:00', '0', '1', '2215520224936043', '1449218349223', null);
INSERT INTO `product_relation` VALUES ('2215520224941190', '2215520224936095', 'proRelease', '2215520224935937', 'scenic', '', '2015-12-04 16:40:25', '', '0000-00-00 00:00:00', '0', '1', '2215520224936044', '1449218896679', null);
INSERT INTO `product_relation` VALUES ('2215520224941191', '2215520224936096', 'proRelease', '2215520224935937', 'scenic', '', '2015-12-04 16:40:25', '', '0000-00-00 00:00:00', '0', '1', '2215520224936044', '1449218896679', null);
INSERT INTO `product_relation` VALUES ('2215520224941192', '2215520224936097', 'proRelease', '2215520224935937', 'scenic', '', '2015-12-04 16:40:25', '', '0000-00-00 00:00:00', '0', '1', '2215520224936044', '1449218896679', null);
INSERT INTO `product_relation` VALUES ('2215520224941193', '2215520224936098', 'proRelease', '2215520224935937', 'scenic', '', '2015-12-04 16:40:25', '', '0000-00-00 00:00:00', '0', '1', '2215520224936044', '1449218896679', null);
INSERT INTO `product_relation` VALUES ('2215520224941194', '2215520224936099', 'proRelease', '2215520224935937', 'scenic', '', '2015-12-04 16:40:25', '', '0000-00-00 00:00:00', '0', '1', '2215520224936044', '1449218896679', null);
INSERT INTO `product_relation` VALUES ('2215520224941195', '2215520224936100', 'proRelease', '2215520224935937', 'scenic', '', '2015-12-04 16:40:25', '', '0000-00-00 00:00:00', '0', '1', '2215520224936044', '1449218896679', null);
INSERT INTO `product_relation` VALUES ('2215520224941196', '2215520224936101', 'proRelease', '2215520224935937', 'scenic', '', '2015-12-04 16:40:25', '', '0000-00-00 00:00:00', '0', '1', '2215520224936045', '1449218896679', null);
INSERT INTO `product_relation` VALUES ('2215520224941197', '2215520224936102', 'proRelease', '2215520224935937', 'scenic', '', '2015-12-04 16:40:25', '', '0000-00-00 00:00:00', '0', '1', '2215520224936045', '1449218896679', null);
INSERT INTO `product_relation` VALUES ('2215520224941198', '2215520224936103', 'proRelease', '2215520224935937', 'scenic', '', '2015-12-04 16:40:25', '', '0000-00-00 00:00:00', '0', '1', '2215520224936045', '1449218896679', null);
INSERT INTO `product_relation` VALUES ('2215520224941199', '2215520224936104', 'proRelease', '2215520224935937', 'scenic', '', '2015-12-04 16:40:25', '', '0000-00-00 00:00:00', '0', '1', '2215520224936045', '1449218896679', null);
INSERT INTO `product_relation` VALUES ('2215520224941200', '2215520224936105', 'proRelease', '2215520224935937', 'scenic', '', '2015-12-04 16:40:25', '', '0000-00-00 00:00:00', '0', '1', '2215520224936045', '1449218896679', null);
INSERT INTO `product_relation` VALUES ('2215520224941201', '2215520224936106', 'proRelease', '2215520224935937', 'scenic', '', '2015-12-04 16:40:25', '', '0000-00-00 00:00:00', '0', '1', '2215520224936045', '1449218896679', null);
INSERT INTO `product_relation` VALUES ('2215520224941210', '12345', 'proDict', '2215520224936000', 'proRelease', null, '2015-12-01 15:59:31', null, '2015-12-01 15:59:34', '0', '1', null, null, null);
INSERT INTO `product_relation` VALUES ('2215520224941211', '12346', 'proDict', '2215520224936000', 'proRelease', '', '2015-12-01 15:59:31', '', '2015-12-01 15:59:34', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941212', '12347', 'proDict', '2215520224936000', 'proRelease', '', '2015-12-01 15:59:31', '', '2015-12-01 15:59:34', '0', '1', '', null, null);
INSERT INTO `product_relation` VALUES ('2215520224941214', '2215520224936119', 'proRelease', '2215520224935937', 'scenic', '', '2015-12-04 16:42:48', '', '0000-00-00 00:00:00', '0', '1', '2215520224936048', '1449219200147', null);
INSERT INTO `product_relation` VALUES ('2215520224941215', '2215520224936120', 'proRelease', '2215520224935937', 'scenic', '', '2015-12-04 16:42:48', '', '0000-00-00 00:00:00', '0', '1', '2215520224936048', '1449219200147', null);
INSERT INTO `product_relation` VALUES ('2215520224941216', '2215520224936121', 'proRelease', '2215520224935937', 'scenic', '', '2015-12-04 16:42:48', '', '0000-00-00 00:00:00', '0', '1', '2215520224936048', '1449219200147', null);
INSERT INTO `product_relation` VALUES ('2215520224941217', '2215520224936122', 'proRelease', '2215520224935937', 'scenic', '', '2015-12-04 16:42:48', '', '0000-00-00 00:00:00', '0', '1', '2215520224936048', '1449219200147', null);
INSERT INTO `product_relation` VALUES ('2215520224941218', '2215520224936123', 'proRelease', '2215520224935937', 'scenic', '', '2015-12-04 16:42:48', '', '0000-00-00 00:00:00', '0', '1', '2215520224936048', '1449219200147', null);
INSERT INTO `product_relation` VALUES ('2215520224941219', '2215520224936124', 'proRelease', '2215520224935937', 'scenic', '', '2015-12-04 16:42:48', '', '0000-00-00 00:00:00', '0', '1', '2215520224936048', '1449219200147', null);
INSERT INTO `product_relation` VALUES ('2215520224941220', '2215520224936125', 'proRelease', '2215520224935937', 'scenic', '', '2015-12-04 16:42:48', '', '0000-00-00 00:00:00', '0', '1', '2215520224936049', '1449219200147', null);
INSERT INTO `product_relation` VALUES ('2215520224941221', '2215520224936126', 'proRelease', '2215520224935937', 'scenic', '', '2015-12-04 16:42:48', '', '0000-00-00 00:00:00', '0', '1', '2215520224936049', '1449219200147', null);
INSERT INTO `product_relation` VALUES ('2215520224941222', '2215520224936127', 'proRelease', '2215520224935937', 'scenic', '', '2015-12-04 16:42:48', '', '0000-00-00 00:00:00', '0', '1', '2215520224936049', '1449219200147', null);
INSERT INTO `product_relation` VALUES ('2215520224941223', '2215520224936128', 'proRelease', '2215520224935937', 'scenic', '', '2015-12-04 16:42:48', '', '0000-00-00 00:00:00', '0', '1', '2215520224936049', '1449219200147', null);
INSERT INTO `product_relation` VALUES ('2215520224941224', '2215520224936129', 'proRelease', '2215520224935937', 'scenic', '', '2015-12-04 16:42:48', '', '0000-00-00 00:00:00', '0', '1', '2215520224936049', '1449219200147', null);
INSERT INTO `product_relation` VALUES ('2215520224941225', '2215520224936130', 'proRelease', '2215520224935937', 'scenic', '', '2015-12-04 16:42:48', '', '0000-00-00 00:00:00', '0', '1', '2215520224936049', '1449219200147', null);
INSERT INTO `product_relation` VALUES ('2215520224941226', '2215520224936131', 'proRelease', '2215520224935937', 'scenic', '', '2015-12-04 16:44:06', '', '0000-00-00 00:00:00', '0', '1', '2215520224936050', '1449219542465', null);
INSERT INTO `product_relation` VALUES ('2215520224941227', '2215520224936132', 'proRelease', '2215520224935937', 'scenic', '', '2015-12-04 16:44:06', '', '0000-00-00 00:00:00', '0', '1', '2215520224936050', '1449219542465', null);
INSERT INTO `product_relation` VALUES ('2215520224941228', '2215520224936133', 'proRelease', '2215520224935937', 'scenic', '', '2015-12-04 16:44:06', '', '0000-00-00 00:00:00', '0', '1', '2215520224936050', '1449219542465', null);
INSERT INTO `product_relation` VALUES ('2215520224941229', '2215520224936134', 'proRelease', '2215520224935937', 'scenic', '', '2015-12-04 16:44:06', '', '0000-00-00 00:00:00', '0', '1', '2215520224936050', '1449219542465', null);
INSERT INTO `product_relation` VALUES ('2215520224941230', '2215520224936135', 'proRelease', '2215520224935937', 'scenic', '', '2015-12-04 16:44:06', '', '0000-00-00 00:00:00', '0', '1', '2215520224936050', '1449219542465', null);
INSERT INTO `product_relation` VALUES ('2215520224941231', '2215520224936136', 'proRelease', '2215520224935937', 'scenic', '', '2015-12-04 16:44:06', '', '0000-00-00 00:00:00', '0', '1', '2215520224936050', '1449219542465', null);
INSERT INTO `product_relation` VALUES ('2215520224941232', '2215520224936137', 'proRelease', '2215520224935937', 'scenic', '', '2015-12-04 16:44:06', '', '0000-00-00 00:00:00', '0', '1', '2215520224936051', '1449219542465', null);
INSERT INTO `product_relation` VALUES ('2215520224941233', '2215520224936138', 'proRelease', '2215520224935937', 'scenic', '', '2015-12-04 16:44:06', '', '0000-00-00 00:00:00', '0', '1', '2215520224936051', '1449219542465', null);
INSERT INTO `product_relation` VALUES ('2215520224941234', '2215520224936139', 'proRelease', '2215520224935937', 'scenic', '', '2015-12-04 16:44:06', '', '0000-00-00 00:00:00', '0', '1', '2215520224936051', '1449219542465', null);
INSERT INTO `product_relation` VALUES ('2215520224941235', '2215520224936140', 'proRelease', '2215520224935937', 'scenic', '', '2015-12-04 16:44:06', '', '0000-00-00 00:00:00', '0', '1', '2215520224936051', '1449219542465', null);
INSERT INTO `product_relation` VALUES ('2215520224941236', '2215520224936141', 'proRelease', '2215520224935937', 'scenic', '', '2015-12-04 16:44:06', '', '0000-00-00 00:00:00', '0', '1', '2215520224936051', '1449219542465', null);
INSERT INTO `product_relation` VALUES ('2215520224941237', '2215520224936142', 'proRelease', '2215520224935937', 'scenic', '', '2015-12-04 16:44:06', '', '0000-00-00 00:00:00', '0', '1', '2215520224936051', '1449219542465', null);
INSERT INTO `product_relation` VALUES ('2215520224941238', '2215520224936143', 'proRelease', '2215520224935937', 'scenic', '', '2015-12-04 16:45:31', '', '0000-00-00 00:00:00', '0', '1', '2215520224936052', '1449219473170', null);
INSERT INTO `product_relation` VALUES ('2215520224941239', '2215520224936144', 'proRelease', '2215520224935937', 'scenic', '', '2015-12-04 16:45:31', '', '0000-00-00 00:00:00', '0', '1', '2215520224936052', '1449219473170', null);
INSERT INTO `product_relation` VALUES ('2215520224941240', '2215520224936145', 'proRelease', '2215520224935937', 'scenic', '', '2015-12-04 16:45:31', '', '0000-00-00 00:00:00', '0', '1', '2215520224936052', '1449219473170', null);
INSERT INTO `product_relation` VALUES ('2215520224941241', '2215520224936146', 'proRelease', '2215520224935937', 'scenic', '', '2015-12-04 16:45:31', '', '0000-00-00 00:00:00', '0', '1', '2215520224936052', '1449219473170', null);
INSERT INTO `product_relation` VALUES ('2215520224941242', '2215520224936147', 'proRelease', '2215520224935937', 'scenic', '', '2015-12-04 16:45:31', '', '0000-00-00 00:00:00', '0', '1', '2215520224936052', '1449219473170', null);
INSERT INTO `product_relation` VALUES ('2215520224941243', '2215520224936148', 'proRelease', '2215520224935937', 'scenic', '', '2015-12-04 16:45:31', '', '0000-00-00 00:00:00', '0', '1', '2215520224936052', '1449219473170', null);
INSERT INTO `product_relation` VALUES ('2215520224941244', '2215520224936149', 'proRelease', '2215520224935937', 'scenic', '', '2015-12-04 16:45:31', '', '0000-00-00 00:00:00', '0', '1', '2215520224936053', '1449219473170', null);
INSERT INTO `product_relation` VALUES ('2215520224941245', '2215520224936150', 'proRelease', '2215520224935937', 'scenic', '', '2015-12-04 16:45:31', '', '0000-00-00 00:00:00', '0', '1', '2215520224936053', '1449219473170', null);
INSERT INTO `product_relation` VALUES ('2215520224941246', '2215520224936151', 'proRelease', '2215520224935937', 'scenic', '', '2015-12-04 16:45:31', '', '0000-00-00 00:00:00', '0', '1', '2215520224936053', '1449219473170', null);
INSERT INTO `product_relation` VALUES ('2215520224941247', '2215520224936152', 'proRelease', '2215520224935937', 'scenic', '', '2015-12-04 16:45:31', '', '0000-00-00 00:00:00', '0', '1', '2215520224936053', '1449219473170', null);
INSERT INTO `product_relation` VALUES ('2215520224941248', '2215520224936153', 'proRelease', '2215520224935937', 'scenic', '', '2015-12-04 16:45:31', '', '0000-00-00 00:00:00', '0', '1', '2215520224936053', '1449219473170', null);
INSERT INTO `product_relation` VALUES ('2215520224941249', '2215520224936154', 'proRelease', '2215520224935937', 'scenic', '', '2015-12-04 16:45:31', '', '0000-00-00 00:00:00', '0', '1', '2215520224936053', '1449219473170', null);
INSERT INTO `product_relation` VALUES ('2215520224941250', '2215520224936155', 'proRelease', '2215520224935937', 'scenic', '', '2015-12-04 16:50:08', '', '0000-00-00 00:00:00', '0', '1', '2215520224936054', '1449219866170', null);
INSERT INTO `product_relation` VALUES ('2215520224941251', '2215520224936156', 'proRelease', '2215520224935937', 'scenic', '', '2015-12-04 16:50:08', '', '0000-00-00 00:00:00', '0', '1', '2215520224936054', '1449219866170', null);
INSERT INTO `product_relation` VALUES ('2215520224941252', '2215520224936157', 'proRelease', '2215520224935937', 'scenic', '', '2015-12-04 16:50:08', '', '0000-00-00 00:00:00', '0', '1', '2215520224936054', '1449219866170', null);
INSERT INTO `product_relation` VALUES ('2215520224941253', '2215520224936158', 'proRelease', '2215520224935937', 'scenic', '', '2015-12-04 16:50:08', '', '0000-00-00 00:00:00', '0', '1', '2215520224936054', '1449219866170', null);
INSERT INTO `product_relation` VALUES ('2215520224941254', '2215520224936159', 'proRelease', '2215520224935937', 'scenic', '', '2015-12-04 16:50:08', '', '0000-00-00 00:00:00', '0', '1', '2215520224936054', '1449219866170', null);
INSERT INTO `product_relation` VALUES ('2215520224941255', '2215520224936160', 'proRelease', '2215520224935937', 'scenic', '', '2015-12-04 16:50:08', '', '0000-00-00 00:00:00', '0', '1', '2215520224936055', '1449219866170', null);
INSERT INTO `product_relation` VALUES ('2215520224941256', '2215520224936161', 'proRelease', '2215520224935937', 'scenic', '', '2015-12-04 16:50:08', '', '0000-00-00 00:00:00', '0', '1', '2215520224936055', '1449219866170', null);
INSERT INTO `product_relation` VALUES ('2215520224941257', '2215520224936162', 'proRelease', '2215520224935937', 'scenic', '', '2015-12-04 16:50:08', '', '0000-00-00 00:00:00', '0', '1', '2215520224936055', '1449219866170', null);
INSERT INTO `product_relation` VALUES ('2215520224941258', '2215520224936163', 'proRelease', '2215520224935937', 'scenic', '', '2015-12-04 16:50:08', '', '0000-00-00 00:00:00', '0', '1', '2215520224936055', '1449219866170', null);
INSERT INTO `product_relation` VALUES ('2215520224941259', '2215520224936164', 'proRelease', '2215520224935937', 'scenic', '', '2015-12-04 16:50:08', '', '0000-00-00 00:00:00', '0', '1', '2215520224936055', '1449219866170', null);
INSERT INTO `product_relation` VALUES ('2215520224941260', '2215520224936165', 'proRelease', '2215520224935937', 'scenic', '', '2015-12-04 16:59:56', '', '0000-00-00 00:00:00', '0', '1', '2215520224936056', '1449220345297', null);
INSERT INTO `product_relation` VALUES ('2215520224941261', '2215520224936166', 'proRelease', '2215520224935937', 'scenic', '', '2015-12-04 17:07:01', '', '0000-00-00 00:00:00', '0', '1', '2215520224936057', '1449220114741', null);
INSERT INTO `product_relation` VALUES ('2215520224941262', '2215520224936167', 'proRelease', '2215520224935969', 'scenic', '', '2015-12-04 17:23:18', '', '0000-00-00 00:00:00', '0', '1', '2215520224936058', '1449221759501', null);
INSERT INTO `product_relation` VALUES ('2215520224941263', '2215520224936168', 'proRelease', '2215520224935969', 'scenic', '', '2015-12-04 17:23:18', '', '0000-00-00 00:00:00', '0', '1', '2215520224936058', '1449221759501', null);
INSERT INTO `product_relation` VALUES ('2215520224941264', '2215520224936169', 'proRelease', '2215520224935969', 'scenic', '', '2015-12-04 17:23:18', '', '0000-00-00 00:00:00', '0', '1', '2215520224936058', '1449221759501', null);
INSERT INTO `product_relation` VALUES ('2215520224941265', '2215520224936170', 'proRelease', '2215520224935969', 'scenic', '', '2015-12-04 17:23:18', '', '0000-00-00 00:00:00', '0', '1', '2215520224936058', '1449221759501', null);
INSERT INTO `product_relation` VALUES ('2215520224941266', '2215520224941003', 'proSiteData', '1', 'proDict', '1', '2015-12-04 17:37:37', '', '0000-00-00 00:00:00', '0', '', '', '', null);
INSERT INTO `product_relation` VALUES ('2215520224941267', '2215520224941003', 'proSiteData', '2', 'proDict', '1', '2015-12-04 17:37:37', '', '0000-00-00 00:00:00', '0', '', '', '', null);
INSERT INTO `product_relation` VALUES ('2215520224941268', '2215520224936171', 'proRelease', '2215520224935937', 'scenic', '', '2015-12-04 17:37:17', '', '0000-00-00 00:00:00', '0', '1', '2215520224936059', '1449222253332', null);
INSERT INTO `product_relation` VALUES ('2215520224941269', '2215520224941005', 'proSiteData', '2', 'proDict', '1', '2015-12-04 17:38:26', '', '0000-00-00 00:00:00', '0', '', '', '', null);
INSERT INTO `product_relation` VALUES ('2215520224941270', '2215520224941005', 'proSiteData', '1', 'proDict', '', '0000-00-00 00:00:00', '', '2015-12-04 17:41:18', '0', '', '', '', null);
INSERT INTO `product_relation` VALUES ('2215520224941271', '2215520224941005', 'proSiteData', '2', 'proDict', '', '0000-00-00 00:00:00', '', '2015-12-04 17:41:18', '0', '', '', '', null);
INSERT INTO `product_relation` VALUES ('2215520224941272', '2215520224936172', 'proRelease', '2215520224935938', 'scenic', '', '2015-12-04 18:04:40', '', '0000-00-00 00:00:00', '0', '1', '2215520224936060', '1449224446504', null);
INSERT INTO `product_relation` VALUES ('2215520224941273', '2215520224941010', 'proSiteData', '1', 'proDict', '1', '2015-12-05 10:35:36', '', '0000-00-00 00:00:00', '0', '', '', '', null);
INSERT INTO `product_relation` VALUES ('2215520224941274', '2215520224941010', 'proSiteData', '2', 'proDict', '1', '2015-12-05 10:35:36', '', '0000-00-00 00:00:00', '0', '', '', '', null);
INSERT INTO `product_relation` VALUES ('2215520224941275', '2215520224941010', 'proSiteData', '1', 'proDict', '', '0000-00-00 00:00:00', '', '2015-12-05 10:35:43', '0', '', '', '', null);
INSERT INTO `product_relation` VALUES ('2215520224941276', '2215520224941010', 'proSiteData', '2', 'proDict', '', '0000-00-00 00:00:00', '', '2015-12-05 10:35:43', '0', '', '', '', null);
INSERT INTO `product_relation` VALUES ('2215520224941277', '2215520224936173', 'proRelease', '2215520224935971', 'scenic', '', '2015-12-05 10:36:05', '', '0000-00-00 00:00:00', '0', '1', '2215520224936061', '1449283392873', null);
INSERT INTO `product_relation` VALUES ('2215520224941278', '2215520224941010', 'proSiteData', '1', 'proDict', '', '0000-00-00 00:00:00', '', '2015-12-05 10:38:58', '0', '', '', '', null);
INSERT INTO `product_relation` VALUES ('2215520224941279', '2215520224941010', 'proSiteData', '2', 'proDict', '', '0000-00-00 00:00:00', '', '2015-12-05 10:38:58', '0', '', '', '', null);
INSERT INTO `product_relation` VALUES ('2215520224941280', '2215520224941010', 'proSiteData', '1', 'proDict', '', '0000-00-00 00:00:00', '', '2015-12-05 10:46:09', '0', '', '', '', null);
INSERT INTO `product_relation` VALUES ('2215520224941281', '2215520224941010', 'proSiteData', '2', 'proDict', '', '0000-00-00 00:00:00', '', '2015-12-05 10:46:09', '0', '', '', '', null);
INSERT INTO `product_relation` VALUES ('2215520224941282', '2215520224936174', 'proRelease', '2215520224935937', 'scenic', '', '2015-12-05 11:01:18', '', '0000-00-00 00:00:00', '0', '1', '2215520224936062', '1449284507619', null);
INSERT INTO `product_relation` VALUES ('2215520224941283', '2215520224936175', 'proRelease', '2215520224935937', 'scenic', '', '2015-12-05 11:01:18', '', '0000-00-00 00:00:00', '0', '1', '2215520224936062', '1449284507619', null);
INSERT INTO `product_relation` VALUES ('2215520224941284', '2215520224936176', 'proRelease', '2215520224935937', 'scenic', '', '2015-12-05 11:01:18', '', '0000-00-00 00:00:00', '0', '1', '2215520224936062', '1449284507619', null);
INSERT INTO `product_relation` VALUES ('2215520224941285', '2215520224936177', 'proRelease', '2215520224935937', 'scenic', '', '2015-12-05 11:01:18', '', '0000-00-00 00:00:00', '0', '1', '2215520224936062', '1449284507619', null);
INSERT INTO `product_relation` VALUES ('2215520224941286', '2215520224936178', 'proRelease', '2215520224935937', 'scenic', '', '2015-12-05 11:23:31', '', '0000-00-00 00:00:00', '0', '1', '2215520224936063', '1449285968262', null);
INSERT INTO `product_relation` VALUES ('2215520224941287', '2215520224936179', 'proRelease', '2215520224935937', 'scenic', '', '2015-12-05 11:23:31', '', '0000-00-00 00:00:00', '0', '1', '2215520224936063', '1449285968262', null);
INSERT INTO `product_relation` VALUES ('2215520224941288', '2215520224936180', 'proRelease', '2215520224935971', 'scenic', '', '2015-12-05 11:30:17', '', '0000-00-00 00:00:00', '0', '1', '2215520224936064', '1449286950655', null);
INSERT INTO `product_relation` VALUES ('2215520224941289', '2215520224936181', 'proRelease', '2215520224935969', 'scenic', '', '2015-12-05 11:46:12', '', '0000-00-00 00:00:00', '0', '1', '2215520224936065', '1449287711156', null);
INSERT INTO `product_relation` VALUES ('2215520224941290', '2215520224936182', 'proRelease', '2215520224935969', 'scenic', '', '2015-12-05 11:46:12', '', '0000-00-00 00:00:00', '0', '1', '2215520224936065', '1449287711156', null);
INSERT INTO `product_relation` VALUES ('2215520224941291', '2215520224941010', 'proSiteData', '1', 'proDict', '', '0000-00-00 00:00:00', '', '2015-12-05 13:04:11', '0', '', '', '', null);
INSERT INTO `product_relation` VALUES ('2215520224941292', '2215520224941010', 'proSiteData', '2', 'proDict', '', '0000-00-00 00:00:00', '', '2015-12-05 13:04:11', '0', '', '', '', null);
INSERT INTO `product_relation` VALUES ('2215520224941293', '2215520224941010', 'proSiteData', '1', 'proDict', '', '0000-00-00 00:00:00', '', '2015-12-05 13:04:26', '0', '', '', '', null);
INSERT INTO `product_relation` VALUES ('2215520224941294', '2215520224941010', 'proSiteData', '2', 'proDict', '', '0000-00-00 00:00:00', '', '2015-12-05 13:04:26', '0', '', '', '', null);
INSERT INTO `product_relation` VALUES ('2215520224941295', '2215520224941010', 'proSiteData', '1', 'proDict', '', '0000-00-00 00:00:00', '', '2015-12-05 13:04:31', '0', '', '', '', null);
INSERT INTO `product_relation` VALUES ('2215520224941296', '2215520224941010', 'proSiteData', '2', 'proDict', '', '0000-00-00 00:00:00', '', '2015-12-05 13:04:31', '0', '', '', '', null);
INSERT INTO `product_relation` VALUES ('2215520224941297', '2215520224941010', 'proSiteData', '1', 'proDict', '', '0000-00-00 00:00:00', '', '2015-12-05 13:04:41', '0', '', '', '', null);
INSERT INTO `product_relation` VALUES ('2215520224941298', '2215520224941010', 'proSiteData', '2', 'proDict', '', '0000-00-00 00:00:00', '', '2015-12-05 13:04:41', '0', '', '', '', null);
INSERT INTO `product_relation` VALUES ('2215520224941299', '2215520224936183', 'proRelease', '1111111111', 'scenic', 'aaaaaa', '2015-12-05 13:28:07', '', '0000-00-00 00:00:00', '0', '1', '2215520224936066', '1449294048251', null);
INSERT INTO `product_relation` VALUES ('2215520224941300', '2215520224936183', 'proRelease', '1111111111', 'scenic', 'aaaaaa', '2015-12-05 13:28:07', '', '0000-00-00 00:00:00', '0', '1', '2215520224936066', '1449294048251', null);
INSERT INTO `product_relation` VALUES ('2215520224941301', '2215520224941014', 'proSiteData', '2', 'proDict', '1', '2015-12-05 13:37:14', '', '0000-00-00 00:00:00', '0', '', '', '', null);
INSERT INTO `product_relation` VALUES ('2215520224941302', '2215520224941016', 'proSiteData', '1', 'proDict', '1', '2015-12-05 13:49:08', '', '0000-00-00 00:00:00', '0', '', '', '', null);
INSERT INTO `product_relation` VALUES ('2215520224941303', '2215520224941016', 'proSiteData', '2', 'proDict', '1', '2015-12-05 13:49:08', '', '0000-00-00 00:00:00', '0', '', '', '', null);
INSERT INTO `product_relation` VALUES ('2215520224941304', '2215520224941016', 'proSiteData', '1', 'proDict', '', '0000-00-00 00:00:00', '', '2015-12-05 13:49:12', '0', '', '', '', null);
INSERT INTO `product_relation` VALUES ('2215520224941305', '2215520224941016', 'proSiteData', '2', 'proDict', '', '0000-00-00 00:00:00', '', '2015-12-05 13:49:12', '0', '', '', '', null);
INSERT INTO `product_relation` VALUES ('2215520224941306', '2215520224936184', 'proRelease', '2215520224935971', 'scenic', '', '2015-12-05 13:49:02', '', '0000-00-00 00:00:00', '0', '1', '2215520224936067', '1449294773022', null);
INSERT INTO `product_relation` VALUES ('2215520224941307', '2215520224936185', 'proRelease', '2215520224935971', 'scenic', '', '2015-12-05 14:01:12', '', '0000-00-00 00:00:00', '0', '1', '2215520224936068', '1449296168312', null);
INSERT INTO `product_relation` VALUES ('2215520224941308', '2215520224936186', 'proRelease', '1111111111', 'scenic', 'aaaaaa', '2015-12-05 14:10:14', '', '0000-00-00 00:00:00', '0', '1', '2215520224936069', '1449296691236', null);
INSERT INTO `product_relation` VALUES ('2215520224941309', '2215520224936186', 'proRelease', '1111111111', 'scenic', 'aaaaaa', '2015-12-05 14:10:14', '', '0000-00-00 00:00:00', '0', '1', '2215520224936069', '1449296691236', null);
INSERT INTO `product_relation` VALUES ('2215520224941310', '2215520224941018', 'proSiteData', '1', 'proDict', '1', '2015-12-05 14:11:23', '', '0000-00-00 00:00:00', '0', '', '', '', null);
INSERT INTO `product_relation` VALUES ('2215520224941311', '2215520224941018', 'proSiteData', '2', 'proDict', '1', '2015-12-05 14:11:23', '', '0000-00-00 00:00:00', '0', '', '', '', null);
INSERT INTO `product_relation` VALUES ('2215520224941312', '2215520224936187', 'proRelease', '2215520224935938', 'scenic', '', '2015-12-05 14:11:25', '', '0000-00-00 00:00:00', '0', '1', '2215520224936070', '1449296310259', null);
INSERT INTO `product_relation` VALUES ('2215520224941313', '2215520224936188', 'proRelease', '2215520224935969', 'scenic', '', '2015-12-05 14:11:56', '', '0000-00-00 00:00:00', '0', '1', '2215520224936071', '1449296510291', null);
INSERT INTO `product_relation` VALUES ('2215520224941314', '2215520224936189', 'proRelease', '2215520224935969', 'scenic', '', '2015-12-05 14:11:56', '', '0000-00-00 00:00:00', '0', '1', '2215520224936071', '1449296510291', null);
INSERT INTO `product_relation` VALUES ('2215520224941315', '2215520224936190', 'proRelease', '2215520224935967', 'scenic', '', '2015-12-05 14:13:21', '', '0000-00-00 00:00:00', '0', '1', '2215520224936072', '1449296347463', null);
INSERT INTO `product_relation` VALUES ('2215520224941316', '2215520224941021', 'proSiteData', '2', 'proDict', '1', '2015-12-05 14:24:32', '', '0000-00-00 00:00:00', '0', '', '', '', null);
INSERT INTO `product_relation` VALUES ('2215520224941317', '2215520224936191', 'proRelease', '1111111111', 'scenic', 'aaaaaa', '2015-12-05 14:51:33', '', '0000-00-00 00:00:00', '0', '1', '2215520224936073', '1449298574190', null);
INSERT INTO `product_relation` VALUES ('2215520224941318', '2215520224936191', 'proRelease', '1111111111', 'scenic', 'aaaaaa', '2015-12-05 14:51:33', '', '0000-00-00 00:00:00', '0', '1', '2215520224936073', '1449298574190', null);
INSERT INTO `product_relation` VALUES ('2215520224941319', '2215520224936192', 'proRelease', '2215520224935971', 'scenic', '', '2015-12-05 15:13:15', '', '0000-00-00 00:00:00', '0', '1', '2215520224936074', '1449299798699', null);
INSERT INTO `product_relation` VALUES ('2215520224941320', '2215520224936193', 'proRelease', '2215520224935939', 'scenic', '', '2015-12-05 15:41:01', '', '0000-00-00 00:00:00', '0', '1', '2215520224936075', '1449301912187', null);
INSERT INTO `product_relation` VALUES ('2215520224941321', '2215520224936194', 'proRelease', '2215520224935939', 'scenic', '', '2015-12-05 15:41:01', '', '0000-00-00 00:00:00', '0', '1', '2215520224936075', '1449301912187', null);
INSERT INTO `product_relation` VALUES ('2215520224941322', '2215520224936195', 'proRelease', '2215520224935939', 'scenic', '', '2015-12-05 15:41:01', '', '0000-00-00 00:00:00', '0', '1', '2215520224936075', '1449301912187', null);
INSERT INTO `product_relation` VALUES ('2215520224941323', '2215520224936196', 'proRelease', '2215520224935939', 'scenic', '', '2015-12-05 15:41:01', '', '0000-00-00 00:00:00', '0', '1', '2215520224936075', '1449301912187', null);
INSERT INTO `product_relation` VALUES ('2215520224941324', '2215520224936197', 'proRelease', '2215520224935971', 'scenic', '', '2015-12-05 16:36:26', '', '0000-00-00 00:00:00', '0', '1', '2215520224936076', '1449304954271', null);
INSERT INTO `product_relation` VALUES ('2215520224941325', '2215520224936198', 'proRelease', '2215520224935969', 'scenic', '', '2015-12-05 16:58:30', '', '0000-00-00 00:00:00', '0', '1', '2215520224936077', '1449306763840', null);
INSERT INTO `product_relation` VALUES ('2215520224941326', '2215520224936199', 'proRelease', '2215520224935969', 'scenic', '', '2015-12-05 17:13:43', '', '0000-00-00 00:00:00', '0', '1', '2215520224936078', '1449307519264', null);
INSERT INTO `product_relation` VALUES ('2215520224941327', '2215520224936200', 'proRelease', '2215520224935969', 'scenic', '', '2015-12-05 17:13:43', '', '0000-00-00 00:00:00', '0', '1', '2215520224936078', '1449307519264', null);
INSERT INTO `product_relation` VALUES ('2215520224941328', '2215520224941024', 'proSiteData', '2', 'proDict', '1', '2015-12-05 17:21:26', '', '0000-00-00 00:00:00', '0', '', '', '', null);
INSERT INTO `product_relation` VALUES ('2215520224941329', '2215520224936033', 'proDict', '2215520224936000', 'proRelease', '1', '2015-12-06 13:26:29', '1', '2015-12-06 13:26:29', '0', '1', '', '', null);
INSERT INTO `product_relation` VALUES ('2215520224941330', '2215520224936033', 'proDict', '2215520224936000', 'proRelease', '1', '2015-12-06 13:26:29', '1', '2015-12-06 13:26:29', '0', '1', '', '', null);
INSERT INTO `product_relation` VALUES ('2215520224941331', '2215520224936033', 'proDict', '2215520224936017', 'proRelease', '1', '2015-12-06 13:26:29', '1', '2015-12-06 13:26:29', '0', '1', '', '', null);
INSERT INTO `product_relation` VALUES ('2215520224941332', '2215520224936033', 'proDict', '2215520224936047', 'proRelease', '1', '2015-12-06 13:26:29', '1', '2015-12-06 13:26:29', '0', '1', '', '', null);
INSERT INTO `product_relation` VALUES ('2215520224941333', '2215520224936033', 'proDict', '2215520224936048', 'proRelease', '1', '2015-12-06 13:26:29', '1', '2015-12-06 13:26:29', '0', '1', '', '', null);
INSERT INTO `product_relation` VALUES ('2215520224941334', '2215520224941026', 'proSiteData', '1', 'proDict', '1', '2015-12-06 13:29:01', '', '0000-00-00 00:00:00', '0', '', '', '', null);
INSERT INTO `product_relation` VALUES ('2215520224941335', '2215520224941026', 'proSiteData', '2', 'proDict', '1', '2015-12-06 13:29:01', '', '0000-00-00 00:00:00', '0', '', '', '', null);
INSERT INTO `product_relation` VALUES ('2215520224941336', '2215520224936201', 'proRelease', '2215520224935969', 'scenic', '', '2015-12-06 13:37:45', '', '0000-00-00 00:00:00', '0', '1', '2215520224936079', '1449380580700', null);
INSERT INTO `product_relation` VALUES ('2215520224941337', '2215520224936202', 'proRelease', '2215520224935969', 'scenic', '', '2015-12-06 13:37:45', '', '0000-00-00 00:00:00', '0', '1', '2215520224936079', '1449380580700', null);
INSERT INTO `product_relation` VALUES ('2215520224941338', '2215520224936203', 'proRelease', '2215520224935969', 'scenic', '', '2015-12-06 13:39:04', '', '0000-00-00 00:00:00', '0', '1', '2215520224936080', '1449380604718', null);
INSERT INTO `product_relation` VALUES ('2215520224941339', '2215520224936204', 'proRelease', '2215520224935969', 'scenic', '', '2015-12-06 13:39:04', '', '0000-00-00 00:00:00', '0', '1', '2215520224936080', '1449380604718', null);
INSERT INTO `product_relation` VALUES ('2215520224941340', '2215520224936205', 'proRelease', '2215520224935969', 'scenic', '', '2015-12-06 13:39:04', '', '0000-00-00 00:00:00', '0', '1', '2215520224936080', '1449380604718', null);
INSERT INTO `product_relation` VALUES ('2215520224941341', '2215520224936206', 'proRelease', '2215520224935969', 'scenic', '', '2015-12-06 13:39:04', '', '0000-00-00 00:00:00', '0', '1', '2215520224936080', '1449380604718', null);
INSERT INTO `product_relation` VALUES ('2215520224941342', '2215520224936207', 'proRelease', '2215520224935971', 'scenic', '', '2015-12-06 14:05:46', '', '0000-00-00 00:00:00', '0', '1', '2215520224936081', '1449382582307', null);
INSERT INTO `product_relation` VALUES ('2215520224941343', '2215520224936208', 'proRelease', '2215520224935937', 'scenic', '', '2015-12-06 15:10:45', '', '0000-00-00 00:00:00', '0', '1', '2215520224936082', '1449385879761', null);
INSERT INTO `product_relation` VALUES ('2215520224941344', '2215520224936209', 'proRelease', '2215520224935938', 'scenic', '', '2015-12-06 15:44:15', '', '0000-00-00 00:00:00', '0', '1', '2215520224936083', '1449388701075', null);
INSERT INTO `product_relation` VALUES ('2215520224941345', '2215520224936209', 'proRelease', '2215520224935971', 'scenic', '', '2015-12-06 15:44:15', '', '0000-00-00 00:00:00', '0', '1', '2215520224936083', '1449388701075', null);
INSERT INTO `product_relation` VALUES ('2215520224941346', '2215520224941021', 'proSiteData', '1', 'proDict', '', '0000-00-00 00:00:00', '', '2015-12-06 15:59:07', '0', '', '', '', null);
INSERT INTO `product_relation` VALUES ('2215520224941347', '2215520224941021', 'proSiteData', '2', 'proDict', '', '0000-00-00 00:00:00', '', '2015-12-06 15:59:07', '0', '', '', '', null);
INSERT INTO `product_relation` VALUES ('2215520224941348', '2215520224941016', 'proSiteData', '1', 'proDict', '', '0000-00-00 00:00:00', '', '2015-12-06 15:59:32', '0', '', '', '', null);
INSERT INTO `product_relation` VALUES ('2215520224941349', '2215520224941021', 'proSiteData', '2', 'proDict', '', '0000-00-00 00:00:00', '', '2015-12-06 15:59:55', '0', '', '', '', null);
INSERT INTO `product_relation` VALUES ('2215520224941350', '2215520224941010', 'proSiteData', '2', 'proDict', '', '0000-00-00 00:00:00', '', '2015-12-06 16:00:52', '0', '', '', '', null);
INSERT INTO `product_relation` VALUES ('2215520224941351', '2215520224941010', 'proSiteData', '2', 'proDict', '', '0000-00-00 00:00:00', '', '2015-12-06 16:02:15', '0', '', '', '', null);
INSERT INTO `product_relation` VALUES ('2215520224941352', '2215520224941010', 'proSiteData', '1', 'proDict', '', '0000-00-00 00:00:00', '', '2015-12-06 16:02:18', '0', '', '', '', null);
INSERT INTO `product_relation` VALUES ('2215520224941353', '2215520224941016', 'proSiteData', '2', 'proDict', '', '0000-00-00 00:00:00', '', '2015-12-06 16:04:56', '0', '', '', '', null);
INSERT INTO `product_relation` VALUES ('2215520224941354', '2215520224941016', 'proSiteData', '1', 'proDict', '', '0000-00-00 00:00:00', '', '2015-12-06 16:04:59', '0', '', '', '', null);
INSERT INTO `product_relation` VALUES ('2215520224941355', '2215520224941016', 'proSiteData', '2', 'proDict', '', '0000-00-00 00:00:00', '', '2015-12-06 16:04:59', '0', '', '', '', null);
INSERT INTO `product_relation` VALUES ('2215520224941356', '2215520224941029', 'proSiteData', '1', 'proDict', '1', '2015-12-06 16:05:33', '', '0000-00-00 00:00:00', '0', '', '', '', null);
INSERT INTO `product_relation` VALUES ('2215520224941357', '2215520224941030', 'proSiteData', '2', 'proDict', '1', '2015-12-06 16:05:40', '', '0000-00-00 00:00:00', '0', '', '', '', null);
INSERT INTO `product_relation` VALUES ('2215520224941358', '2215520224941030', 'proSiteData', '2', 'proDict', '', '0000-00-00 00:00:00', '', '2015-12-06 16:07:26', '0', '', '', '', null);
INSERT INTO `product_relation` VALUES ('2215520224941359', '2215520224941029', 'proSiteData', '1', 'proDict', '', '0000-00-00 00:00:00', '', '2015-12-06 16:07:35', '0', '', '', '', null);
INSERT INTO `product_relation` VALUES ('2215520224941360', '2215520224941029', 'proSiteData', '1', 'proDict', '', '0000-00-00 00:00:00', '', '2015-12-06 16:08:06', '0', '', '', '', null);
INSERT INTO `product_relation` VALUES ('2215520224941361', '2215520224941029', 'proSiteData', '1', 'proDict', '', '0000-00-00 00:00:00', '', '2015-12-06 16:11:04', '0', '', '', '', null);
INSERT INTO `product_relation` VALUES ('2215520224941362', '2215520224941029', 'proSiteData', '1', 'proDict', '', '0000-00-00 00:00:00', '', '2015-12-06 16:11:19', '0', '', '', '', null);
INSERT INTO `product_relation` VALUES ('2215520224941363', '2215520224936210', 'proRelease', '2215520224935951', 'scenic', '', '2015-12-06 16:20:13', '', '0000-00-00 00:00:00', '0', '1', '2215520224936084', '1449390878747', null);
INSERT INTO `product_relation` VALUES ('2215520224941364', '2215520224936211', 'proRelease', '2215520224935937', 'scenic', '', '2015-12-06 16:21:02', '', '0000-00-00 00:00:00', '0', '1', '2215520224936085', '1449390816522', null);
INSERT INTO `product_relation` VALUES ('2215520224941365', '2215520224936211', 'proRelease', '2215520224935938', 'scenic', '', '2015-12-06 16:21:02', '', '0000-00-00 00:00:00', '0', '1', '2215520224936085', '1449390816522', null);
INSERT INTO `product_relation` VALUES ('2215520224941366', '2215520224936211', 'proRelease', '2215520224935939', 'scenic', '', '2015-12-06 16:21:02', '', '0000-00-00 00:00:00', '0', '1', '2215520224936085', '1449390816522', null);
INSERT INTO `product_relation` VALUES ('2215520224941367', '2215520224936211', 'proRelease', '2215520224935940', 'scenic', '', '2015-12-06 16:21:02', '', '0000-00-00 00:00:00', '0', '1', '2215520224936085', '1449390816522', null);
INSERT INTO `product_relation` VALUES ('2215520224941368', '2215520224936211', 'proRelease', '2215520224935941', 'scenic', '', '2015-12-06 16:21:02', '', '0000-00-00 00:00:00', '0', '1', '2215520224936085', '1449390816522', null);
INSERT INTO `product_relation` VALUES ('2215520224941369', '2215520224936211', 'proRelease', '2215520224935947', 'scenic', '', '2015-12-06 16:21:02', '', '0000-00-00 00:00:00', '0', '1', '2215520224936085', '1449390816522', null);
INSERT INTO `product_relation` VALUES ('2215520224941370', '2215520224936211', 'proRelease', '2215520224935948', 'scenic', '', '2015-12-06 16:21:02', '', '0000-00-00 00:00:00', '0', '1', '2215520224936085', '1449390816522', null);
INSERT INTO `product_relation` VALUES ('2215520224941371', '2215520224936211', 'proRelease', '2215520224935949', 'scenic', '', '2015-12-06 16:21:02', '', '0000-00-00 00:00:00', '0', '1', '2215520224936085', '1449390816522', null);
INSERT INTO `product_relation` VALUES ('2215520224941372', '2215520224936211', 'proRelease', '2215520224935950', 'scenic', '', '2015-12-06 16:21:02', '', '0000-00-00 00:00:00', '0', '1', '2215520224936085', '1449390816522', null);
INSERT INTO `product_relation` VALUES ('2215520224941373', '2215520224936211', 'proRelease', '2215520224935951', 'scenic', '', '2015-12-06 16:21:02', '', '0000-00-00 00:00:00', '0', '1', '2215520224936085', '1449390816522', null);
INSERT INTO `product_relation` VALUES ('2215520224941374', '2215520224936211', 'proRelease', '2215520224935952', 'scenic', '', '2015-12-06 16:21:02', '', '0000-00-00 00:00:00', '0', '1', '2215520224936085', '1449390816522', null);
INSERT INTO `product_relation` VALUES ('2215520224941375', '2215520224936211', 'proRelease', '2215520224935953', 'scenic', '', '2015-12-06 16:21:02', '', '0000-00-00 00:00:00', '0', '1', '2215520224936085', '1449390816522', null);
INSERT INTO `product_relation` VALUES ('2215520224941376', '2215520224936211', 'proRelease', '2215520224935958', 'scenic', '', '2015-12-06 16:21:02', '', '0000-00-00 00:00:00', '0', '1', '2215520224936085', '1449390816522', null);
INSERT INTO `product_relation` VALUES ('2215520224941377', '2215520224936211', 'proRelease', '2215520224935959', 'scenic', '', '2015-12-06 16:21:02', '', '0000-00-00 00:00:00', '0', '1', '2215520224936085', '1449390816522', null);
INSERT INTO `product_relation` VALUES ('2215520224941378', '2215520224936211', 'proRelease', '2215520224935960', 'scenic', '', '2015-12-06 16:21:02', '', '0000-00-00 00:00:00', '0', '1', '2215520224936085', '1449390816522', null);
INSERT INTO `product_relation` VALUES ('2215520224941379', '2215520224936211', 'proRelease', '2215520224935961', 'scenic', '', '2015-12-06 16:21:02', '', '0000-00-00 00:00:00', '0', '1', '2215520224936085', '1449390816522', null);
INSERT INTO `product_relation` VALUES ('2215520224941380', '2215520224936211', 'proRelease', '2215520224935962', 'scenic', '', '2015-12-06 16:21:02', '', '0000-00-00 00:00:00', '0', '1', '2215520224936085', '1449390816522', null);
INSERT INTO `product_relation` VALUES ('2215520224941381', '2215520224936211', 'proRelease', '2215520224935963', 'scenic', '', '2015-12-06 16:21:02', '', '0000-00-00 00:00:00', '0', '1', '2215520224936085', '1449390816522', null);
INSERT INTO `product_relation` VALUES ('2215520224941382', '2215520224936211', 'proRelease', '2215520224935964', 'scenic', '', '2015-12-06 16:21:02', '', '0000-00-00 00:00:00', '0', '1', '2215520224936085', '1449390816522', null);
INSERT INTO `product_relation` VALUES ('2215520224941383', '2215520224936211', 'proRelease', '2215520224935965', 'scenic', '', '2015-12-06 16:21:02', '', '0000-00-00 00:00:00', '0', '1', '2215520224936085', '1449390816522', null);
INSERT INTO `product_relation` VALUES ('2215520224941384', '2215520224936211', 'proRelease', '2215520224935966', 'scenic', '', '2015-12-06 16:21:02', '', '0000-00-00 00:00:00', '0', '1', '2215520224936085', '1449390816522', null);
INSERT INTO `product_relation` VALUES ('2215520224941385', '2215520224936211', 'proRelease', '2215520224935967', 'scenic', '', '2015-12-06 16:21:02', '', '0000-00-00 00:00:00', '0', '1', '2215520224936085', '1449390816522', null);
INSERT INTO `product_relation` VALUES ('2215520224941386', '2215520224936211', 'proRelease', '2215520224935968', 'scenic', '', '2015-12-06 16:21:02', '', '0000-00-00 00:00:00', '0', '1', '2215520224936085', '1449390816522', null);
INSERT INTO `product_relation` VALUES ('2215520224941387', '2215520224936211', 'proRelease', '2215520224935969', 'scenic', '', '2015-12-06 16:21:02', '', '0000-00-00 00:00:00', '0', '1', '2215520224936085', '1449390816522', null);
INSERT INTO `product_relation` VALUES ('2215520224941388', '2215520224936211', 'proRelease', '2215520224935970', 'scenic', '', '2015-12-06 16:21:02', '', '0000-00-00 00:00:00', '0', '1', '2215520224936085', '1449390816522', null);
INSERT INTO `product_relation` VALUES ('2215520224941389', '2215520224936211', 'proRelease', '2215520224935971', 'scenic', '', '2015-12-06 16:21:02', '', '0000-00-00 00:00:00', '0', '1', '2215520224936085', '1449390816522', null);
INSERT INTO `product_relation` VALUES ('2215520224941390', '2215520224936211', 'proRelease', '2215520224935972', 'scenic', '', '2015-12-06 16:21:02', '', '0000-00-00 00:00:00', '0', '1', '2215520224936085', '1449390816522', null);
INSERT INTO `product_relation` VALUES ('2215520224941391', '2215520224936211', 'proRelease', '2215520224935973', 'scenic', '', '2015-12-06 16:21:02', '', '0000-00-00 00:00:00', '0', '1', '2215520224936085', '1449390816522', null);
INSERT INTO `product_relation` VALUES ('2215520224941392', '2215520224936211', 'proRelease', '2215520224935974', 'scenic', '', '2015-12-06 16:21:02', '', '0000-00-00 00:00:00', '0', '1', '2215520224936085', '1449390816522', null);
INSERT INTO `product_relation` VALUES ('2215520224941393', '2215520224936211', 'proRelease', '2215520224935975', 'scenic', '', '2015-12-06 16:21:02', '', '0000-00-00 00:00:00', '0', '1', '2215520224936085', '1449390816522', null);
INSERT INTO `product_relation` VALUES ('2215520224941394', '2215520224936036', 'proDict', '2215520224936000', 'proRelease', '1', '2015-12-06 16:26:35', '1', '2015-12-06 16:26:35', '0', '1', '', '', null);
INSERT INTO `product_relation` VALUES ('2215520224941395', '2215520224936212', 'proRelease', '2215520224935939', 'scenic', '', '2015-12-06 16:30:47', '', '0000-00-00 00:00:00', '0', '1', '2215520224936086', '1449390706145', null);
INSERT INTO `product_relation` VALUES ('2215520224941396', '2215520224936213', 'proRelease', '2215520224935939', 'scenic', '', '2015-12-06 20:35:34', '', '0000-00-00 00:00:00', '0', '1', '2215520224936087', '1449405795371', null);

-- ----------------------------
-- Table structure for `product_release`
-- ----------------------------
DROP TABLE IF EXISTS `product_release`;
CREATE TABLE `product_release` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `product_id` bigint(20) NOT NULL COMMENT '产品id',
  `roduct_no` varchar(100) NOT NULL COMMENT '发布内部序号\n',
  `product_code` varchar(45) DEFAULT NULL COMMENT '产品code',
  `product_price` double(7,2) DEFAULT NULL COMMENT '发布价格',
  `product_type` varchar(64) DEFAULT NULL COMMENT '产品类型(票型)',
  `product_kind` varchar(200) DEFAULT NULL COMMENT '产品种类（票种）线上线下',
  `product_classify` varchar(200) DEFAULT NULL COMMENT '产品分类（票品） 团散',
  `reease_message` varchar(255) DEFAULT NULL COMMENT '短信模板',
  `reease_info` varchar(255) DEFAULT NULL COMMENT '产品介绍',
  `product_channel` varchar(20) DEFAULT NULL COMMENT '渠道来源(比如客栈渠道来源)',
  `region` varchar(50) DEFAULT NULL COMMENT '剧场区域',
  `ronda` varchar(50) DEFAULT NULL COMMENT '剧场场次',
  `create_by` varchar(100) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_by` varchar(100) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `flag` char(1) NOT NULL COMMENT '使用状态1启用0禁用2删除',
  `remarks` varchar(200) DEFAULT NULL COMMENT '介绍',
  `auditStatus` varchar(1) DEFAULT '5' COMMENT '审核状态',
  `pro_category` varchar(1) DEFAULT NULL COMMENT '产品类别1，普通 ，2，剧场 3，定向返利产品积分产品，4，普通票联票子票5，积分票联票子票',
  `reason` varchar(255) DEFAULT NULL COMMENT '拒绝理由',
  `supplierId` varchar(20) DEFAULT NULL COMMENT '供应商',
  `package_status` varchar(1) DEFAULT '1' COMMENT '联票子票状态（1未生成 2已生成）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='产品发布关系（产品）子表';

-- ----------------------------
-- Records of product_release
-- ----------------------------
INSERT INTO `product_release` VALUES ('2215520224935985', '成人(线上)(团)', '2215520224935985', '1448432552144', '', '11.00', '13', '1', '1', '111111111', '111111111', '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '0', '', '4', '', 'sdfsd', '', '');
INSERT INTO `product_release` VALUES ('2215520224935986', '儿童(线上)(团)', '2215520224935986', '1448432552144', '', '12.00', '14', '1', '1', '111111111', '111111111', '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '4', '', '价格偏高', '', '');
INSERT INTO `product_release` VALUES ('2215520224935987', '优惠(线上)(团)', '2215520224935987', '1448432552144', '', '12.00', '15', '1', '1', '111111111', '111111111', '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '4', '', '1454', '', '');
INSERT INTO `product_release` VALUES ('2215520224935988', '老人(线上)(团)', '2215520224935988', '1448432552144', '', '14.00', '16', '1', '1', '111111111', '111111111', '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '4', '', '1454', '', '');
INSERT INTO `product_release` VALUES ('2215520224935989', '成人(线下)(团)', '2215520224935971', '1448432552144', '', '11.00', '13', '2', '1', '111111111', '111111111', '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224935990', '儿童(线下)(团)', '2215520224935990', '1448432552144', '', '12.00', '14', '2', '1', '111111111', '111111111', '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '4', '', '1454', '', '');
INSERT INTO `product_release` VALUES ('2215520224935991', '优惠(线下)(团)', '2215520224935971', '1448432552144', '', '13.00', '15', '2', '1', '111111111', '111111111', '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224935992', '老人(线下)(团)', '2215520224935971', '1448432552144', '', '14.00', '16', '2', '1', '111111111', '111111111', '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224935993', '成人(线上)(散)', '2215520224935971', '1448432552144', '', '11.00', '13', '1', '2', '111111111', '111111111', '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224935994', '儿童(线上)(散)', '2215520224935994', '1448432552144', '', '12.00', '14', '1', '2', '111111111', '111111111', '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '3', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224935995', '优惠(线上)(散)', '2215520224935971', '1448432552144', '', '13.00', '15', '1', '2', '111111111', '111111111', '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224935996', '老人(线上)(散)', '2215520224935971', '1448432552144', '', '14.00', '16', '1', '2', '111111111', '111111111', '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224935997', '成人(线下)(散)', '2215520224935997', '1448432552144', '', '11.00', '13', '2', '2', '111111111', '111111111', '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '4', '', '1454', '', '');
INSERT INTO `product_release` VALUES ('2215520224935998', '儿童(线下)(散)', '2215520224935971', '1448432552144', '', '12.00', '14', '2', '2', '111111111', '111111111', '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224935999', '优惠(线下)(散)', '2215520224935999', '1448432552144', '', '131.00', '15', '2', '2', '111111111', '111111111', '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '4', '', '                               ', '', '');
INSERT INTO `product_release` VALUES ('2215520224936000', '积分票', '2215520224936000', '1448432552144', '', '14.00', '16', '2', '2', '111111111', '111111111', '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '4', '3', '              ', '', '');
INSERT INTO `product_release` VALUES ('2215520224936001', '啊啊啊啊啊', '2215520224935985', '1448439695371', '', '0.00', '', '', '', '', '', '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936002', '啊啊啊啊啊', '2215520224935973', '1448439967069', '', '0.00', '', '', '', '', '', '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936003', '啊啊啊啊啊', '2215520224935974', '1448440579417', '', '0.00', '', '', '', '', '', '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936004', '啊啊啊啊啊', '2215520224935975', '1448441492416', '', '0.00', '', '', '', '', '', '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936005', '啊啊啊啊啊', '2215520224935976', '1448444962256', '', '0.00', '', '', '', '', '', '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936006', '啊啊啊啊啊', '2215520224935977', '1448445393820', '', '0.00', '', '', '', '', '', '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936007', '啊啊啊啊啊', '2215520224935978', '1448453146887', '', '0.00', '', '', '', '', '', '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936008', '成人(线上)(团)', '2215520224935979', '1448457253595', '', '11.00', '13', '1', '1', '1111', '11', '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936009', '啊啊啊啊啊', '2215520224935980', '1448458018456', '', '0.00', '', '', '', '', '', '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936010', '啊啊啊啊啊', '2215520224935981', '1448504528857', '', '0.00', '', '', '', '', '', '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936011', '啊啊啊啊啊', '2215520224935982', '1448508449767', '', '0.00', '', '', '', '', '', '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936012', '啊啊啊啊啊', '2215520224935983', '1448530181503', '', '0.00', '', '', '', '', '', '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936013', '啊啊啊啊啊', '2215520224935984', '1448695328604', '', '0.00', '', '', '', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936014', '啊啊啊啊啊', '2215520224935986', '1448696880578', '', '0.00', '', '', '', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936015', '啊啊啊啊啊', '2215520224935987', '1448697329840', '', '0.00', '', '', '', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936016', '啊啊啊啊啊', '2215520224935988', '1448886664708', '', '0.00', '', '', '', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936017', '积分票', '2215520224935989', '1448886839717', '', '50.00', '', '', '', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '3', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936018', '啊啊啊啊啊', '2215520224935990', '1448942547047', '', '0.00', '', '', '', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936019', '啊啊啊啊啊', '2215520224935991', '1448952183453', '', '0.00', '', '', '', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936020', '啊啊啊啊啊', '2215520224935992', '1448952574181', '', '0.00', '', '', '', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936021', '优惠(线下)(团)', '2215520224935993', '1448954360089', '', '1.00', '3:优惠', '2', '1', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936022', '啊啊啊啊啊', '2215520224935994', '1448959875352', '', '0.00', '', '', '', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936023', '老人(线下)(团)', '2215520224935995', '1448961224794', '', '11.00', '4:老人', '2', '1', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936024', '老人(线下)(团)', '2215520224935996', '1448964231609', '', '11.00', '4:老人', '2', '1', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936025', '儿童(线上)(团)', '2215520224935997', '1448964490176', '', '99.00', '2:儿童', '1', '1', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936026', '武慧测试', '2215520224935997', '1448964490176', '', '99.00', '2:儿童', '2', '1', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936027', '儿童(线上)(散)', '2215520224935997', '1448964490176', '', '99.00', '2:儿童', '1', '2', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936028', '线下武慧测试', '2215520224935997', '1448964490176', '', '99.00', '2:儿童', '2', '2', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936029', '啊啊啊啊啊', '2215520224935998', '1449020321159', '', '0.00', '', '', '', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936030', '我的票型(线上)(团)', '2215520224935999', '1449028310358', '', '1.00', '9:我的票型', '1', '1', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936031', '我的票型(线下)(团)', '2215520224935999', '1449028310358', '', '1.00', '9:我的票型', '2', '1', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936032', '我的票型(线上)(散)', '2215520224935999', '1449028310358', '', '1.00', '9:我的票型', '1', '2', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936033', '我的票型(线下)(散)', '2215520224935999', '1449028310358', '', '1.00', '9:我的票型', '2', '2', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936034', '人人人(线下)(团)', '2215520224936000', '1449039794380', '', '10.00', '1:人人人', '2', '1', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936035', '人人人(线下)(团)', '2215520224936001', '1449040198411', '', '12.00', '1:人人人', '2', '1', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936036', '成人票(线下)(团)', '2215520224936002', '1449040631912', '', '45.00', '12:成人票', '2', '1', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936037', '成人票(线上)(团)', '2215520224936003', '1449040821206', '', '56.00', '12:成人票', '1', '1', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936038', '成人票(线上)(散)', '2215520224936004', '1449040538107', '', '12.00', '12:成人票', '1', '2', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936039', '成人票(线上)(团)', '2215520224936005', '1449041737224', '', '15.00', '12:成人票', '1', '1', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936040', '成才一的(线上)(团)', '2215520224936006', '1449042494364', '', '74.00', '13:成才一的', '1', '1', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936041', '新增票型(线下)(团)', '2215520224936007', '1449042893256', '', '11.00', '10:新增票型', '2', '1', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936042', '圭一上早(线上)(团)', '2215520224936008', '1449042718140', '', '120.00', '2:圭一上早', '1', '1', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936043', '成人票(线上)(团)', '2215520224936009', '1449042982778', '', '123.00', '12:成人票', '1', '1', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936044', '人人人(线上)(团)', '2215520224936010', '1449043530387', '', '33.00', '1:人人人', '1', '1', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936045', '积分票', '2215520224936011', '1449043733984', '', '11.00', '', '', '', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936046', '积分票', '2215520224936012', '1449043992060', '', '1.00', '', '', '', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936047', '积分票', '2215520224936013', '1449044387802', '', '1.00', '', '', '', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '3', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936048', '积分票', '2215520224936014', '1449044613118', '', '1111.00', '', '', '', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '3', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936049', '老人票(线上)(团)', '2215520224936049', '1449046013752', '', '50.00', '14:老人票', '1', '1', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '3', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936050', '老人票(线下)(团)', '2215520224936016', '1449045939168', '', '23.00', '14:老人票', '2', '1', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936051', '优惠(线下)(团)', '2215520224936017', '1449048560703', '', '111.00', '3:优惠', '2', '1', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '1', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936052', '儿童(线下)(团)', '2215520224936018', '1449049274171', '', '111.00', '2:儿童', '2', '1', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '1', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936053', '成人票(线上)(团)', '2215520224936019', '1449116202868', '', '123.00', '12:成人票', '1', '1', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936054', '成人票(线下)(团)', '2215520224936019', '1449116202868', '', '123.00', '12:成人票', '2', '1', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936055', '新功能(线上)(团)', '2215520224936020', '1449121972565', '', '11.00', '17:新功能', '1', '1', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936056', '张家界(线下)(团)', '2215520224936021', '1449122108164', '', '11.00', '19:张家界', '2', '1', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936057', '张家界(线下)(团)', '2215520224936022', '1449123300489', '', '11.00', '19:张家界', '2', '1', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936058', '成功盒(线下)(团)', '2215520224936023', '1449123198067', '', '45.00', '15:成功盒', '2', '1', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936059', '张家界(线下)(团)', '2215520224936024', '1449126105651', '', '33.00', '19:张家界', '2', '1', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936060', '成功盒(线下)(团)', '2215520224936025', '1449132204243', '', '1.00', '15:成功盒', '2', '1', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936061', '票之家(线下)(团)', '2215520224936026', '1449192325107', '', '110.00', '20:票之家', '2', '1', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936062', '成人(线上)(团)', '2215520224936027', '1449193193447', '', '80.00', '1:成人', '1', '1', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936063', '成人(线下)(团)', '2215520224936027', '1449193193447', '', '80.00', '1:成人', '2', '1', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936064', '成人(线上)(散)', '2215520224936027', '1449193193447', '', '80.00', '1:成人', '1', '2', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936065', '成人(线下)(散)', '2215520224936027', '1449193193447', '', '80.00', '1:成人', '2', '2', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936066', '张家界(线下)(团)', '2215520224936028', '1449193282952', '', '45.00', '19:张家界', '2', '1', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936067', '成人(线上)(团)', '2215520224936029', '1449195938372', '', '90.00', '1:成人', '1', '1', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936068', '成人(线下)(团)', '2215520224936029', '1449195938372', '', '90.00', '1:成人', '2', '1', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936069', '成人(线上)(散)', '2215520224936029', '1449195938372', '', '90.00', '1:成人', '1', '2', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936070', '成人(线下)(散)', '2215520224936029', '1449195938372', '', '90.00', '1:成人', '2', '2', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936071', '成人(线上)(团)', '2215520224936030', '1449197024467', '', '120.00', '1:成人', '1', '1', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936072', '老人票(线上)(团)', '2215520224936031', '1449199025666', '', '12.00', '14:老人票', '1', '1', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936073', '老人票(线下)(团)', '2215520224936031', '1449199025666', '', '12.00', '14:老人票', '2', '1', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936074', '老人票(线上)(散)', '2215520224936031', '1449199025666', '', '12.00', '14:老人票', '1', '2', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936075', '老人票(线下)(散)', '2215520224936031', '1449199025666', '', '12.00', '14:老人票', '2', '2', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936076', '儿童(线下)(团)', '2215520224936032', '1449200492783', '', '1.00', '2:儿童', '2', '1', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '0', '', '', '1', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936077', '张家界(线下)(团)', '2215520224936033', '1449206785392', '', '11.00', '19:张家界', '2', '1', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936078', '老人票(线上)(团)', '2215520224936034', '1449209876395', '', '21.00', '14:老人票', '1', '1', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '1', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936079', '老人票(线下)(团)', '2215520224936034', '1449209876395', '', '21.00', '14:老人票', '2', '1', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '1', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936080', '老人票(线上)(散)', '2215520224936034', '1449209876395', '', '21.00', '14:老人票', '1', '2', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '1', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936081', '老人票(线下)(散)', '2215520224936034', '1449209876395', '', '21.00', '14:老人票', '2', '2', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '1', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936082', '老人票(线下)(团)', '2215520224936035', '1449211557066', '', '11.00', '14:老人票', '2', '1', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '1', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936083', '老人票(线上)(团)', '2215520224936036', '1449211346398', '', '12.00', '14:老人票', '1', '1', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '1', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936084', '老人票(线下)(团)', '2215520224936036', '1449211346398', '', '12.00', '14:老人票', '2', '1', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '1', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936085', '老人票(线上)(散)', '2215520224936036', '1449211346398', '', '12.00', '14:老人票', '1', '2', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '1', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936086', '老人票(线下)(散)', '2215520224936036', '1449211346398', '', '12.00', '14:老人票', '2', '2', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '1', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936087', '人人人(线上)(团)', '2215520224936037', '1449212818165', '', '23.00', '1:人人人', '1', '1', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '1', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936088', '人人人(线上)(散)', '2215520224936037', '1449212818165', '', '23.00', '1:人人人', '1', '2', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '1', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936089', '优惠(线上)(团)', '2215520224936038', '1449213277758', '', '123.00', '3:优惠', '1', '1', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '1', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936090', '优惠(线上)(团)', '2215520224936039', '1449213418705', '', '1.00', '3:优惠', '1', '1', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '1', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936091', '优惠(线上)(团)', '2215520224936040', '1449213561717', '', '123.00', '3:优惠', '1', '1', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '1', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936092', '优惠(线上)(团)', '2215520224936041', '1449213436016', '', '12.00', '3:优惠', '1', '1', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '0', '', '', '1', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936093', '大人票(线下)(团)', '2215520224936042', '1449213897960', '', '11.00', '22:大人票', '2', '1', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '0', '', '', '1', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936094', '儿童(线上)(团)', '2215520224936094', '1449219305648', '', '52.00', '2:儿童', '1', '1', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '3', '1', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936095', '大人票(线下)(散)', '2215520224936044', '1449219074610', '', '333.00', '22:大人票', '2', '2', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936096', '大人票(线下)(散)', '2215520224936044', '1449219074610', '', '333.00', '22:大人票', '2', '2', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936097', '大人票(线下)(散)', '2215520224936044', '1449219074610', '', '333.00', '22:大人票', '2', '2', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936098', '大人票(线下)(散)', '2215520224936044', '1449219074610', '', '333.00', '22:大人票', '2', '2', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936099', '大人票(线下)(散)', '2215520224936044', '1449219074610', '', '333.00', '22:大人票', '2', '2', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936100', '大人票(线下)(散)', '2215520224936044', '1449219074610', '', '333.00', '22:大人票', '2', '2', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936101', '大人票(线下)(散)', '2215520224936045', '1449219074610', '', '333.00', '22:大人票', '2', '2', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936102', '大人票(线下)(散)', '2215520224936045', '1449219074610', '', '333.00', '22:大人票', '2', '2', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936103', '大人票(线下)(散)', '2215520224936045', '1449219074610', '', '333.00', '22:大人票', '2', '2', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936104', '大人票(线下)(散)', '2215520224936045', '1449219074610', '', '333.00', '22:大人票', '2', '2', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936105', '大人票(线下)(散)', '2215520224936045', '1449219074610', '', '333.00', '22:大人票', '2', '2', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936106', '大人票(线下)(散)', '2215520224936045', '1449219074610', '', '333.00', '22:大人票', '2', '2', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936119', '大人票(线下)(散)', '2215520224936048', '1449219054887', '', '333.00', '22:大人票', '2', '2', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936120', '大人票(线下)(散)', '2215520224936048', '1449219054887', '', '333.00', '22:大人票', '2', '2', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936121', '大人票(线下)(散)', '2215520224936048', '1449219054887', '', '333.00', '22:大人票', '2', '2', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936122', '大人票(线下)(散)', '2215520224936048', '1449219054887', '', '333.00', '22:大人票', '2', '2', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936123', '大人票(线下)(散)', '2215520224936048', '1449219054887', '', '333.00', '22:大人票', '2', '2', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936124', '大人票(线下)(散)', '2215520224936048', '1449219054887', '', '333.00', '22:大人票', '2', '2', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936125', '大人票(线下)(散)', '2215520224936049', '1449219054887', '', '333.00', '22:大人票', '2', '2', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936126', '大人票(线下)(散)', '2215520224936049', '1449219054887', '', '333.00', '22:大人票', '2', '2', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936127', '大人票(线下)(散)', '2215520224936049', '1449219054887', '', '333.00', '22:大人票', '2', '2', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936128', '大人票(线下)(散)', '2215520224936049', '1449219054887', '', '333.00', '22:大人票', '2', '2', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936129', '大人票(线下)(散)', '2215520224936049', '1449219054887', '', '333.00', '22:大人票', '2', '2', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936130', '大人票(线下)(散)', '2215520224936049', '1449219054887', '', '333.00', '22:大人票', '2', '2', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936131', '大人票(线下)(散)', '2215520224936050', '1449219418750', '', '333.00', '22:大人票', '2', '2', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936132', '大人票(线下)(散)', '2215520224936050', '1449219418750', '', '333.00', '22:大人票', '2', '2', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936133', '大人票(线下)(散)', '2215520224936050', '1449219418750', '', '333.00', '22:大人票', '2', '2', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936134', '大人票(线下)(散)', '2215520224936050', '1449219418750', '', '333.00', '22:大人票', '2', '2', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936135', '大人票(线下)(散)', '2215520224936050', '1449219418750', '', '333.00', '22:大人票', '2', '2', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936136', '大人票(线下)(散)', '2215520224936050', '1449219418750', '', '333.00', '22:大人票', '2', '2', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936137', '大人票(线下)(散)', '2215520224936051', '1449219418750', '', '333.00', '22:大人票', '2', '2', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936138', '大人票(线下)(散)', '2215520224936051', '1449219418750', '', '333.00', '22:大人票', '2', '2', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936139', '大人票(线下)(散)', '2215520224936051', '1449219418750', '', '333.00', '22:大人票', '2', '2', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936140', '大人票(线下)(散)', '2215520224936051', '1449219418750', '', '333.00', '22:大人票', '2', '2', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936141', '大人票(线下)(散)', '2215520224936051', '1449219418750', '', '333.00', '22:大人票', '2', '2', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936142', '大人票(线下)(散)', '2215520224936051', '1449219418750', '', '333.00', '22:大人票', '2', '2', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936143', '成功盒(线上)(团)', '2215520224936052', '1449218979754', '', '1.00', '15:成功盒', '1', '1', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936144', '成功盒(线上)(团)', '2215520224936052', '1449218979754', '', '111.00', '15:成功盒', '1', '1', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936145', '张家界(线下)(团)', '2215520224936052', '1449218979754', '', '222.00', '19:张家界', '2', '1', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936146', '大人票(线上)(散)', '2215520224936052', '1449218979754', '', '333.00', '22:大人票', '1', '2', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936147', '儿童票(线下)(散)', '2215520224936052', '1449218979754', '', '222.00', '18:儿童票', '2', '2', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936148', '大人票(线下)(散)', '2215520224936052', '1449218979754', '', '333.00', '22:大人票', '2', '2', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936149', '成功盒(线上)(团)', '2215520224936053', '1449218979754', '', '1.00', '15:成功盒', '1', '1', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936150', '成功盒(线上)(团)', '2215520224936053', '1449218979754', '', '111.00', '15:成功盒', '1', '1', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936151', '张家界(线下)(团)', '2215520224936053', '1449218979754', '', '222.00', '19:张家界', '2', '1', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936152', '大人票(线上)(散)', '2215520224936053', '1449218979754', '', '333.00', '22:大人票', '1', '2', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936153', '儿童票(线下)(散)', '2215520224936053', '1449218979754', '', '222.00', '18:儿童票', '2', '2', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936154', '大人票(线下)(散)', '2215520224936053', '1449218979754', '', '333.00', '22:大人票', '2', '2', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936155', '老人票(线下)(散)', '2215520224936054', '1449219258543', '', '11.00', '14:老人票', '2', '2', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936156', '新功能(线下)(团)', '2215520224936054', '1449219258543', '', '11.00', '17:新功能', '2', '1', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936157', '儿童票(线下)(团)', '2215520224936054', '1449219258543', '', '22.00', '18:儿童票', '2', '1', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936158', '老人票(线下)(散)', '2215520224936054', '1449219258543', '', '333.00', '14:老人票', '2', '2', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936159', '票之家(线下)(散)', '2215520224936054', '1449219258543', '', '44.00', '20:票之家', '2', '2', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936160', '老人票(线下)(散)', '2215520224936055', '1449219258543', '', '11.00', '14:老人票', '2', '2', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936161', '新功能(线下)(团)', '2215520224936055', '1449219258543', '', '11.00', '17:新功能', '2', '1', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936162', '儿童票(线下)(团)', '2215520224936055', '1449219258543', '', '22.00', '18:儿童票', '2', '1', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936163', '老人票(线下)(散)', '2215520224936055', '1449219258543', '', '333.00', '14:老人票', '2', '2', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936164', '票之家(线下)(散)', '2215520224936055', '1449219258543', '', '44.00', '20:票之家', '2', '2', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936165', '儿童(线下)(散)', '2215520224936056', '1449220221869', '', '123.00', '2:儿童', '2', '2', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '4', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936166', '儿童票(线上)(团)', '2215520224936057', '1449220775480', '', '1.00', '18:儿童票', '1', '1', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '4', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936167', '老人票(线上)(团)', '2215520224936058', '1449221971180', '', '23.00', '14:老人票', '1', '1', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '1', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936168', '老人票(线下)(团)', '2215520224936058', '1449221971180', '', '23.00', '14:老人票', '2', '1', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '1', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936169', '老人票(线上)(散)', '2215520224936058', '1449221971180', '', '23.00', '14:老人票', '1', '2', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '1', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936170', '老人票(线下)(散)', '2215520224936058', '1449221971180', '', '23.00', '14:老人票', '2', '2', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '1', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936171', '儿童(线下)(团)', '2215520224936059', '1449222663047', '', '11.00', '2:儿童', '2', '1', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '1', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936172', '大人票(线下)(散)', '2215520224936060', '1449223889895', '', '55.00', '22:大人票', '2', '2', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '1', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936173', '大人票(线下)(团)', '2215520224936061', '1449283644051', '', '60.00', '22:大人票', '2', '1', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '1', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936174', '优惠(线上)(团)', '2215520224936062', '1449285112460', '', '19.00', '3:优惠', '1', '1', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '1', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936175', '老人(线下)(团)', '2215520224936062', '1449285112460', '', '18.00', '4:老人', '2', '1', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '1', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936176', '儿童(线上)(散)', '2215520224936062', '1449285112460', '', '17.00', '2:儿童', '1', '2', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '1', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936177', '儿童(线下)(散)', '2215520224936062', '1449285112460', '', '16.00', '2:儿童', '2', '2', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '1', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936178', '优惠(线上)(散)', '2215520224936063', '1449286747375', '', '100.00', '3:优惠', '1', '2', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '1', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936179', '老人(线下)(散)', '2215520224936063', '1449286747375', '', '101.00', '4:老人', '2', '2', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '1', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936180', '大人票(线下)(散)', '2215520224936064', '1449286715143', '', '44.00', '22:大人票', '2', '2', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '1', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936181', '优惠(线上)(散)', '2215520224936065', '1449287461128', '', '333.00', '3:优惠', '1', '2', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '1', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936182', '优惠(线下)(散)', '2215520224936065', '1449287461128', '', '355.00', '3:优惠', '2', '2', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '1', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936183', '啊啊啊啊啊', '2215520224936066', '1449294262377', '', '0.00', '', '', '', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936184', '大人票(线下)(团)', '2215520224936067', '1449295031403', '', '65.00', '22:大人票', '2', '1', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '1', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936185', '大人票(线下)(散)', '2215520224936068', '1449295767447', '', '90.00', '22:大人票', '2', '2', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '1', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936186', '啊啊啊啊啊', '2215520224936069', '1449296173373', '', '0.00', '', '', '', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936187', '大人票(线上)(散)', '2215520224936070', '1449296139437', '', '33.00', '22:大人票', '1', '2', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '1', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936188', '儿童(线下)(团)', '2215520224936071', '1449296085539', '', '777.00', '2:儿童', '2', '1', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '1', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936189', '儿童(线下)(散)', '2215520224936071', '1449296085539', '', '888.00', '2:儿童', '2', '2', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '1', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936190', '大人票(线上)(散)', '2215520224936072', '1449296501507', '', '77.00', '22:大人票', '1', '2', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '1', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936191', '啊啊啊啊啊', '2215520224936073', '1449298965621', '', '0.00', '', '', '', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '', '', '', '', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936192', '大人票(线下)(散)', '2215520224936074', '1449300498852', '', '33.00', '22:大人票', '2', '2', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '1', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936193', '儿童(线上)(团)', '2215520224936075', '1449302280272', '', '1.00', '2:儿童', '1', '1', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '1', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936194', '儿童(线下)(团)', '2215520224936075', '1449302280272', '', '1.00', '2:儿童', '2', '1', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '1', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936195', '儿童(线上)(散)', '2215520224936075', '1449302280272', '', '1.00', '2:儿童', '1', '2', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '1', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936196', '儿童(线下)(散)', '2215520224936075', '1449302280272', '', '1.00', '2:儿童', '2', '2', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '1', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936197', '大人票(线下)(散)', '2215520224936076', '1449305459529', '', '66.00', '22:大人票', '2', '2', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '1', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936198', '大人票(线下)(散)', '2215520224936077', '1449306418180', '', '100.00', '22:大人票', '2', '2', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '1', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936199', '优惠(线下)(团)', '2215520224936078', '1449307809365', '', '312.00', '3:优惠', '2', '1', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '1', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936200', '优惠(线下)(散)', '2215520224936078', '1449307809365', '', '321.00', '3:优惠', '2', '2', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '1', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936201', '杨发票(线下)(团)', '2215520224936079', '1449380653074', '', '23.00', '28:杨发票', '2', '1', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '1', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936202', '杨发票(线下)(散)', '2215520224936079', '1449380653074', '', '23.00', '28:杨发票', '2', '2', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '1', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936203', '儿童(线下)(团)', '2215520224936080', '1449381266624', '', '156.00', '2:儿童', '2', '1', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '1', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936204', '优惠(线下)(团)', '2215520224936080', '1449381266624', '', '134.00', '3:优惠', '2', '1', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '1', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936205', '优惠(线下)(散)', '2215520224936080', '1449381266624', '', '201.00', '3:优惠', '2', '2', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '1', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936206', '老人(线下)(散)', '2215520224936080', '1449381266624', '', '151.00', '4:老人', '2', '2', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '1', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936207', '大人票(线下)(散)', '2215520224936081', '1449382612328', '', '112.00', '22:大人票', '2', '2', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '1', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936208', '成功盒(线上)(团)', '2215520224936082', '1449386673558', '', '111.00', '15:成功盒', '1', '1', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '4', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936209', '大人票(线下)(散)', '2215520224936083', '1449388793369', '', '125.00', '22:大人票', '2', '2', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '1', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936210', '圭一上早(线上)(团)', '2215520224936084', '1449390878586', '', '11.00', '2:圭一上早', '1', '1', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '4', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936211', '大人票(线下)(散)', '2215520224936085', '1449390967116', '', '150.00', '22:大人票', '2', '2', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '1', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936212', '优惠(线上)(团)', '2215520224936086', '1449391026715', '', '1.00', '3:优惠', '1', '1', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '1', '', '', '');
INSERT INTO `product_release` VALUES ('2215520224936213', '儿童(线上)(团)', '2215520224936087', '1449406321904', '', '12.00', '2:儿童', '1', '1', null, null, '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '0', '1', '', '', '1', '', '', '');

-- ----------------------------
-- Table structure for `product_sales_tool`
-- ----------------------------
DROP TABLE IF EXISTS `product_sales_tool`;
CREATE TABLE `product_sales_tool` (
  `id` bigint(20) NOT NULL COMMENT '自增id',
  `p_dict` varchar(20) NOT NULL COMMENT '工具类型',
  `tool_name` varchar(50) DEFAULT NULL COMMENT '工具名称',
  `wechat_uid` bigint(20) DEFAULT NULL COMMENT '微信用户\n',
  `wechat_account` varchar(50) DEFAULT NULL COMMENT '微信账户',
  `wechat_passwd` varchar(50) DEFAULT NULL COMMENT '账户密码',
  `self_service_address` varchar(50) DEFAULT NULL COMMENT '自动售货机地址',
  `self_service_ip` varchar(50) DEFAULT NULL COMMENT '自动售货机ip',
  `self_service_key` varchar(50) DEFAULT NULL COMMENT '自动售货机key',
  `dimension_code_address` varchar(50) DEFAULT NULL COMMENT '二维码地址',
  `create_by` varchar(100) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_by` varchar(100) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `remarks` varchar(50) DEFAULT NULL COMMENT '备注',
  `flag` char(1) DEFAULT '0' COMMENT '状态1启用0禁用2删除',
  `supplier_id` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='直销工具';

-- ----------------------------
-- Records of product_sales_tool
-- ----------------------------
INSERT INTO `product_sales_tool` VALUES ('2215520224935938', '1', '测试直销工具', '11', 'nn_1026', 'nn_1026', null, null, null, null, '111', null, '111', '2015-11-23 17:11:15', '1', '0', null);
INSERT INTO `product_sales_tool` VALUES ('2215520224935939', '1', '测试直销工具', '11', 'nn_1026', 'nn_1026', null, null, null, null, '111', null, '111', '2015-11-23 17:11:42', '1', '1', null);
INSERT INTO `product_sales_tool` VALUES ('2215520224935940', '1', '测试直销工具', '11', 'nn_1026', 'nn_1026', null, null, null, null, '111', null, '111', '2015-11-23 17:12:35', '1', '1', null);
INSERT INTO `product_sales_tool` VALUES ('2215520224935950', '2', null, null, null, null, 'adsfs', 'adfads', 'adsfasdf', null, 'admin', null, 'admin', null, 'asdfdasfadf', null, null);
INSERT INTO `product_sales_tool` VALUES ('2215520224935951', '4', null, null, null, null, null, null, null, null, '1', null, '1', null, 'asdfasdf', '0', null);
INSERT INTO `product_sales_tool` VALUES ('2215520224935952', '4', null, null, null, null, null, null, null, null, '1', null, '1', null, null, '0', null);
INSERT INTO `product_sales_tool` VALUES ('2215520224935953', '4', null, null, null, null, null, null, null, null, '1', null, '1', null, 'rrrrrrr', '1', null);
INSERT INTO `product_sales_tool` VALUES ('2215520224935954', '2', null, null, null, null, 'yyy', 'yyyy', 'yyy', null, '1', null, '1', null, '9999999999999', '0', null);
INSERT INTO `product_sales_tool` VALUES ('2215520224935955', '4', null, null, null, null, null, null, null, null, '1', null, '1', null, null, '0', null);
INSERT INTO `product_sales_tool` VALUES ('2215520224935956', '4', null, null, null, null, null, null, null, null, '1', null, '1', null, null, '0', null);
INSERT INTO `product_sales_tool` VALUES ('2215520224935957', '4', null, null, null, null, null, null, null, null, '1', null, '1', null, null, '0', null);
INSERT INTO `product_sales_tool` VALUES ('2215520224935958', '4', null, null, null, null, null, null, null, null, '1', null, '1', null, null, '0', null);
INSERT INTO `product_sales_tool` VALUES ('2215520224935959', '4', null, null, null, null, null, null, null, null, '1', null, '1', null, '磊', '0', null);
INSERT INTO `product_sales_tool` VALUES ('2215520224935960', '4', null, null, null, null, null, null, null, null, '1', null, '1', null, '线下线下线下线下线线下下', '0', null);
INSERT INTO `product_sales_tool` VALUES ('2215520224935961', '3', null, null, null, null, null, null, null, 'asdfsdf', '1', null, '1', null, 'asdfadf', '0', null);
INSERT INTO `product_sales_tool` VALUES ('2215520224935962', '4', null, null, null, null, null, null, null, null, '1', null, '1', null, 'ddddddddd', '0', null);
INSERT INTO `product_sales_tool` VALUES ('2215520224935963', '3', null, null, null, null, null, null, null, '机场二高速38公里处', '1', null, '1', null, null, '0', null);
INSERT INTO `product_sales_tool` VALUES ('2215520224935964', '4', null, null, null, null, null, null, null, null, '1', null, '1', null, 'qweqeeq', '0', null);
INSERT INTO `product_sales_tool` VALUES ('2215520224935965', '1', 'vivian', null, 'vivian', '123456', null, null, null, null, '1', null, '1', null, '123', '0', null);

-- ----------------------------
-- Table structure for `product_scenic`
-- ----------------------------
DROP TABLE IF EXISTS `product_scenic`;
CREATE TABLE `product_scenic` (
  `id` bigint(20) NOT NULL COMMENT 'id\r\n            ',
  `code` varchar(50) DEFAULT NULL COMMENT '编码（预留）',
  `name` varchar(100) DEFAULT NULL COMMENT '供应商名称',
  `province` varchar(50) DEFAULT NULL COMMENT '省   ',
  `city` varchar(50) DEFAULT NULL COMMENT '市',
  `county` varchar(50) DEFAULT NULL COMMENT '县',
  `grade` tinyint(1) DEFAULT NULL COMMENT '景区等级（字典）',
  `checkin_type` varchar(50) DEFAULT NULL COMMENT '检票方式（字典）多选',
  `address` varchar(200) DEFAULT NULL,
  `show_num` varchar(1000) DEFAULT NULL COMMENT '演出场次，类型为剧场时用到',
  `theater_zone` varchar(1000) DEFAULT NULL COMMENT '剧场分区，类型为剧场时用到',
  `info` varchar(1000) DEFAULT NULL COMMENT '供应商介绍',
  `img_url` varchar(100) DEFAULT NULL COMMENT '图片资料',
  `view_url` varchar(100) DEFAULT NULL COMMENT '视频资料',
  `data_url` varchar(100) DEFAULT NULL COMMENT '文字资料',
  `create_by` varchar(20) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_by` char(1) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `sort` tinyint(4) DEFAULT NULL COMMENT '排序',
  `status` tinyint(1) DEFAULT '0' COMMENT '状态（1启用0禁用2删除）',
  `type` tinyint(1) DEFAULT NULL COMMENT '类型（1景区 2剧场）',
  `source` varchar(45) DEFAULT NULL COMMENT '表示属于哪个平台',
  `parent_id` bigint(20) DEFAULT '0' COMMENT '所属供应商id',
  `supplier_id` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='景区表';

-- ----------------------------
-- Records of product_scenic
-- ----------------------------
INSERT INTO `product_scenic` VALUES ('2215520224935937', null, '景区哈哈哈好', '北京市', '东城区', '长安区', '1', null, '北京安徽省天津北京北京市', null, null, 'aaaaaaaaa', null, null, null, null, null, null, null, '2', '1', '1', null, '0', null);
INSERT INTO `product_scenic` VALUES ('2215520224935938', null, '景区2', '2,北京', '3,北京市', '4,东城区', '3', null, '景区222', null, null, null, null, null, null, null, null, null, null, null, '1', '2', null, '0', null);
INSERT INTO `product_scenic` VALUES ('2215520224935939', null, '凤凰古城', '北京市', '东城区', '4,东城区', '1', null, '北京北京湖南省北京北京市北京市北京市北京市东城区东城区西城区东城区', null, null, null, null, null, null, null, null, null, null, null, '1', '1', null, '0', null);
INSERT INTO `product_scenic` VALUES ('2215520224935940', null, '九寨沟', '46,河北省', '3,北京市', '4,东城区', '1', null, '北京北京四川省河北省北京市', null, null, null, null, null, null, null, null, null, null, null, '1', '2', null, '0', null);
INSERT INTO `product_scenic` VALUES ('2215520224935941', null, 'qwew', '天津市', '和平区', null, '1', null, null, null, null, null, null, null, null, null, null, null, null, null, '1', '1', null, '0', null);
INSERT INTO `product_scenic` VALUES ('2215520224935947', null, 'qeqwe890', '北京市', '东城区', null, '1', null, '水不 不同', null, null, '男早民民', null, null, null, null, null, null, '2015-12-02 14:32:03', null, '1', '1', null, '0', null);
INSERT INTO `product_scenic` VALUES ('2215520224935948', null, 'qeqwe', '北京市', '东城区', null, '1', null, null, null, null, null, null, null, null, null, null, null, null, null, '1', '1', null, '0', null);
INSERT INTO `product_scenic` VALUES ('2215520224935949', null, 'ss', '北京市', '北京市', '东城区', '2', '1,2,3', '1111', null, null, '1111', null, null, null, null, '2015-11-27 16:00:08', null, '2015-11-27 16:00:29', null, '1', '1', null, '0', null);
INSERT INTO `product_scenic` VALUES ('2215520224935950', null, 'ss', null, null, null, '1', '1', 'ss', null, null, 'sss', null, null, null, null, '2015-11-27 16:00:37', null, null, null, '1', '1', null, '0', null);
INSERT INTO `product_scenic` VALUES ('2215520224935951', null, 'www', '天津市', '天津市', '和平区', '1', '1', '444', null, null, 'aaaaRRR', null, null, null, null, '2015-11-30 11:01:30', null, '2015-12-01 17:17:17', null, '1', '1', null, '0', null);
INSERT INTO `product_scenic` VALUES ('2215520224935952', null, '人民公共公园', '北京市', '东城区', '锦江区', '1', null, null, null, null, '这是用于人民锻炼身体的好地方，可以在里面跳广场舞，可以老年KTV\r\n,儿童游乐，垂钓', null, null, null, null, null, null, null, null, '1', '1', null, '0', null);
INSERT INTO `product_scenic` VALUES ('2215520224935953', null, '天府广场', '四川省', '成都市', '锦江区', '6', null, null, null, null, null, null, null, null, null, null, null, null, null, '1', '2', null, '0', null);
INSERT INTO `product_scenic` VALUES ('2215520224935958', null, 'www', '北京市', '北京市', '西城区', '1', '1', 'wwwww', null, null, 'wwwwwww', null, null, null, null, '2015-12-01 17:31:15', null, null, null, '1', '2', null, '0', null);
INSERT INTO `product_scenic` VALUES ('2215520224935959', null, '白的', '北京市', null, null, '1', '1', '寺523', null, null, '土土土土土土土地', null, null, null, '1', '2015-12-02 14:24:21', null, null, null, '1', '1', null, '0', null);
INSERT INTO `product_scenic` VALUES ('2215520224935960', null, '五一百不890', '北京市', '北京市', '西城区', '1', '1', '本一一', null, null, '三一一一下', null, null, null, '1', '2015-12-02 14:28:35', null, '2015-12-02 14:31:36', null, '1', '1', null, '0', null);
INSERT INTO `product_scenic` VALUES ('2215520224935961', null, '投影仪', '北京市', '北京市', '东城区', '1', '1', '6666', null, null, '666666', null, null, null, '1', '2015-12-02 14:33:38', null, '2015-12-04 14:29:29', null, '1', '2', null, '0', null);
INSERT INTO `product_scenic` VALUES ('2215520224935962', null, '00000000000', '北京市', '北京市', '东城区', '1', '1', '999999', null, null, '99999999', null, null, null, '1', '2015-12-02 14:33:58', null, null, null, '1', '2', null, '0', null);
INSERT INTO `product_scenic` VALUES ('2215520224935963', null, '455', '北京市', '北京市', '东城区', '1', '1', '455455455', null, null, '455455455455455', null, null, null, '1', '2015-12-02 18:40:37', null, null, null, '1', '1', null, '0', null);
INSERT INTO `product_scenic` VALUES ('2215520224935964', null, 'qwe', '天津市', '天津市', '和平区', '1', '1', '5号加班测试地址', null, null, '5号加班景区简介', null, null, null, '1', '2015-12-02 19:43:58', null, '2015-12-05 10:28:51', null, '1', '1', null, '0', null);
INSERT INTO `product_scenic` VALUES ('2215520224935965', null, '张家界', '北京市', '东城区', '东城区', '1', '1', '张家界张家界', null, null, '张家界张家界张家界张家界张家界张家界张家界张家界', null, null, null, '1', '2015-12-03 13:42:34', null, '2015-12-06 17:01:03', null, '1', '1', null, '0', null);
INSERT INTO `product_scenic` VALUES ('2215520224935966', null, 'yan1', '北京市', '北京市', '东城区', '1', '1', 'yan1', null, null, 'yan1', null, null, null, '1', '2015-12-03 14:51:27', null, null, null, '1', '2', null, '0', null);
INSERT INTO `product_scenic` VALUES ('2215520224935967', null, 'yan2', '北京市', '北京市', '东城区', '1', '1', 'yan2', null, null, '选择游玩的时间时还能选择早于当前的时间', null, null, null, '1', '2015-12-03 14:51:52', null, '2015-12-06 17:00:53', null, '1', '1', null, '0', null);
INSERT INTO `product_scenic` VALUES ('2215520224935968', null, 'sad', null, null, null, '1', '1', 'dsa', null, null, 'dsa', null, null, null, '1', '2015-12-03 21:45:02', null, null, null, '1', '1', null, '0', null);
INSERT INTO `product_scenic` VALUES ('2215520224935969', null, '杨发测试景区', '北京市', '北京市', '海淀区', '1', '1,2', '杨发测试景区111', null, null, '杨发测试景区111', null, null, null, '1', '2015-12-04 09:18:20', null, '2015-12-04 14:30:45', null, '1', '1', null, '0', null);
INSERT INTO `product_scenic` VALUES ('2215520224935970', null, '55566', '北京市', '北京市', '东城区', '1', '1', '5556', null, null, '55666', null, null, null, '1', '2015-12-04 13:23:12', null, null, null, '1', '1', null, '0', null);
INSERT INTO `product_scenic` VALUES ('2215520224935971', null, 'yan3', null, null, null, '1', '1', '北京地区', null, null, '北京地区', null, null, null, '1', '2015-12-04 13:50:54', null, '2015-12-06 17:00:46', null, '1', '1', null, '0', null);
INSERT INTO `product_scenic` VALUES ('2215520224935972', null, '阿里', '北京市', '东城区', null, '1', null, null, null, null, '方法法国飞飞', null, null, null, null, null, null, null, null, '1', '1', null, '0', null);
INSERT INTO `product_scenic` VALUES ('2215520224935973', null, 'app', '北京市', '北京市', '东城区', '1', '1,2,3', '北京市海淀区复兴路丙12号中国铝业大厦4层', null, null, '北京市海淀区复兴路丙12号中国铝业大厦4层', null, null, null, '1', '2015-12-04 17:40:44', null, '2015-12-06 17:00:56', null, '1', '1', null, '0', null);
INSERT INTO `product_scenic` VALUES ('2215520224935974', null, '反复复凤飞阿里反反复', '北京市', '东城区', null, '5', null, null, null, null, '订单', null, null, null, null, null, null, null, null, '1', '2', null, '0', null);
INSERT INTO `product_scenic` VALUES ('2215520224935975', null, '道理', '北京市', '东城区', null, '5', null, null, null, null, null, null, null, null, null, null, null, null, null, '1', '1', null, '0', null);

-- ----------------------------
-- Table structure for `product_scenic_relation`
-- ----------------------------
DROP TABLE IF EXISTS `product_scenic_relation`;
CREATE TABLE `product_scenic_relation` (
  `id` bigint(20) NOT NULL,
  `scenicId` bigint(20) DEFAULT NULL COMMENT '景区id',
  `rel_id` bigint(20) DEFAULT NULL COMMENT '关联对象id',
  `rel_type` varchar(50) DEFAULT NULL COMMENT '关联对象类型（scenic其他景区,suppiler供应商）',
  `supplier_id` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `rel_index` (`rel_id`),
  KEY `scenicid_index` (`scenicId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='景区关系表';

-- ----------------------------
-- Records of product_scenic_relation
-- ----------------------------
INSERT INTO `product_scenic_relation` VALUES ('2215520224935983', '2215520224935948', '1', 'suppiler', null);
INSERT INTO `product_scenic_relation` VALUES ('2215520224935992', '2215520224935949', '1', 'suppiler', null);
INSERT INTO `product_scenic_relation` VALUES ('2215520224935997', '2215520224935951', '1', 'suppiler', null);
INSERT INTO `product_scenic_relation` VALUES ('2215520224935998', '2215520224935952', '1', 'suppiler', null);
INSERT INTO `product_scenic_relation` VALUES ('2215520224935999', '2215520224935953', '1', 'suppiler', null);
INSERT INTO `product_scenic_relation` VALUES ('2215520224936002', '2215520224935958', '1', 'suppiler', null);
INSERT INTO `product_scenic_relation` VALUES ('2215520224936021', '2215520224935939', '2215520224936329', 'suppiler', null);
INSERT INTO `product_scenic_relation` VALUES ('2215520224936022', '2215520224935937', '2215520224936179', 'suppiler', null);
INSERT INTO `product_scenic_relation` VALUES ('2215520224936038', '2215520224935952', '2215520224936284', 'suppiler', null);
INSERT INTO `product_scenic_relation` VALUES ('2215520224936112', '2215520224935939', '2215520224936482', 'suppiler', null);
INSERT INTO `product_scenic_relation` VALUES ('2215520224936113', '2215520224935947', '2215520224936482', 'suppiler', null);
INSERT INTO `product_scenic_relation` VALUES ('2215520224936114', '2215520224935948', '2215520224936482', 'suppiler', null);
INSERT INTO `product_scenic_relation` VALUES ('2215520224936115', '2215520224935949', '2215520224936482', 'suppiler', null);
INSERT INTO `product_scenic_relation` VALUES ('2215520224936116', '2215520224935951', '2215520224936482', 'suppiler', null);
INSERT INTO `product_scenic_relation` VALUES ('2215520224936117', '2215520224935952', '2215520224936482', 'suppiler', null);
INSERT INTO `product_scenic_relation` VALUES ('2215520224936118', '2215520224935960', '2215520224936482', 'suppiler', null);
INSERT INTO `product_scenic_relation` VALUES ('2215520224936120', '2215520224935967', '2215520224936482', 'suppiler', null);
INSERT INTO `product_scenic_relation` VALUES ('2215520224936121', '2215520224935969', '2215520224936482', 'suppiler', null);
INSERT INTO `product_scenic_relation` VALUES ('2215520224936122', '2215520224935971', '2215520224936482', 'suppiler', null);
INSERT INTO `product_scenic_relation` VALUES ('2215520224936123', '2215520224935937', '2215520224936499', 'suppiler', null);
INSERT INTO `product_scenic_relation` VALUES ('2215520224936124', '2215520224935939', '2215520224936499', 'suppiler', null);
INSERT INTO `product_scenic_relation` VALUES ('2215520224936133', '2215520224935972', '2215520224936284', 'suppiler', null);
INSERT INTO `product_scenic_relation` VALUES ('2215520224936137', '2215520224935974', '2215520224936284', 'suppiler', null);
INSERT INTO `product_scenic_relation` VALUES ('2215520224936138', '2215520224935965', '2215520224936314', 'suppiler', null);
INSERT INTO `product_scenic_relation` VALUES ('2215520224936139', '2215520224935975', '2215520224936314', 'suppiler', null);
INSERT INTO `product_scenic_relation` VALUES ('2215520224936140', '2215520224935937', '2215520224936510', 'suppiler', null);
INSERT INTO `product_scenic_relation` VALUES ('2215520224936141', '2215520224935939', '2215520224936510', 'suppiler', null);
INSERT INTO `product_scenic_relation` VALUES ('2215520224936142', '2215520224935947', '2215520224936510', 'suppiler', null);
INSERT INTO `product_scenic_relation` VALUES ('2215520224936143', '2215520224935975', '2215520224936510', 'suppiler', null);
INSERT INTO `product_scenic_relation` VALUES ('2215520224936156', '2215520224935937', '2215520224936175', 'suppiler', null);
INSERT INTO `product_scenic_relation` VALUES ('2215520224936157', '2215520224935939', '2215520224936175', 'suppiler', null);
INSERT INTO `product_scenic_relation` VALUES ('2215520224936158', '2215520224935941', '2215520224936175', 'suppiler', null);
INSERT INTO `product_scenic_relation` VALUES ('2215520224936159', '2215520224935947', '2215520224936175', 'suppiler', null);
INSERT INTO `product_scenic_relation` VALUES ('2215520224936160', '2215520224935948', '2215520224936175', 'suppiler', null);
INSERT INTO `product_scenic_relation` VALUES ('2215520224936161', '2215520224935949', '2215520224936175', 'suppiler', null);
INSERT INTO `product_scenic_relation` VALUES ('2215520224936162', '2215520224935960', '2215520224936175', 'suppiler', null);
INSERT INTO `product_scenic_relation` VALUES ('2215520224936163', '2215520224935964', '2215520224936175', 'suppiler', null);
INSERT INTO `product_scenic_relation` VALUES ('2215520224936164', '2215520224935966', '2215520224936175', 'suppiler', null);
INSERT INTO `product_scenic_relation` VALUES ('2215520224936165', '2215520224935967', '2215520224936175', 'suppiler', null);
INSERT INTO `product_scenic_relation` VALUES ('2215520224936166', '2215520224935968', '2215520224936175', 'suppiler', null);
INSERT INTO `product_scenic_relation` VALUES ('2215520224936167', '2215520224935969', '2215520224936175', 'suppiler', null);

-- ----------------------------
-- Table structure for `product_site_data`
-- ----------------------------
DROP TABLE IF EXISTS `product_site_data`;
CREATE TABLE `product_site_data` (
  `id` bigint(20) NOT NULL,
  `sd_name` varchar(50) DEFAULT NULL COMMENT '点位名称',
  `check_count` int(11) DEFAULT NULL COMMENT '检票使用次数',
  `equipment_code` varchar(50) DEFAULT NULL COMMENT '设备编号',
  `equipment_key` varchar(50) DEFAULT NULL COMMENT '设备key',
  `create_by` varchar(100) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(100) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL COMMENT '修改时间',
  `sort` int(11) DEFAULT '0' COMMENT '排序',
  `sd_flag` char(1) NOT NULL DEFAULT '1' COMMENT '状态 0禁用 1开启 2删除',
  `sd_info` varchar(255) DEFAULT NULL COMMENT '点位信息',
  `type` char(1) DEFAULT '0' COMMENT '检票设备类型 1手持设备 2台式设备 3闸机',
  `dataType` char(1) DEFAULT '1' COMMENT '数据类型 1检票点 2售票点 3检票设备',
  `belong` varchar(1) DEFAULT NULL COMMENT '所属景区',
  `parent_id` bigint(20) DEFAULT '0' COMMENT '检票设备时，保存检票点id',
  `scenic_id` bigint(20) DEFAULT '0' COMMENT '景区id',
  `suppiler_id` bigint(20) DEFAULT '0' COMMENT '供应商id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='点位表包含：检票点，检票点设备，售票点';

-- ----------------------------
-- Records of product_site_data
-- ----------------------------
INSERT INTO `product_site_data` VALUES ('2215520224940937', 'sdfas', null, null, null, null, null, '1', null, '0', '1', 'asdf', '0', '2', null, '0', '2215520224935940', '0');
INSERT INTO `product_site_data` VALUES ('2215520224940938', '凤凰检票点一', '0', '', '', null, '2015-11-24 13:54:04', null, '2015-11-27 15:56:20', '0', '1', null, '0', '1', null, '0', '2215520224935937', '0');
INSERT INTO `product_site_data` VALUES ('2215520224940939', '凤凰检票设备一', '0', '', '', '', '2015-11-24 13:54:04', '', '0000-00-00 00:00:00', '0', '2', '', '1', '3', '', '2215520224940938', '0', '0');
INSERT INTO `product_site_data` VALUES ('2215520224940940', '景区2检票点一', '100', null, null, null, '2015-11-25 19:02:25', null, '2015-12-04 15:37:45', '0', '1', null, '0', '1', null, '0', '2215520224935938', '0');
INSERT INTO `product_site_data` VALUES ('2215520224940941', '检票设备一', '0', '2215520224940939', '2215520224940939', '', '2015-11-25 22:13:27', '', '0000-00-00 00:00:00', '0', '1', '', '1', '3', '', '2215520224940940', '0', '0');
INSERT INTO `product_site_data` VALUES ('2215520224940945', 'test', null, 'ccccccccccccccc', 'sssssssssssssssssssssss', 'hahaha', '2015-11-26 11:04:03', 'hehehe', '2015-11-26 11:04:03', '2', '2', 'ttttttttttttttttt', '2', '3', null, '214', '10', '1010');
INSERT INTO `product_site_data` VALUES ('2215520224940946', 'fdfd', null, null, null, null, null, '1', null, '0', '0', 'sdfadfa', '0', '2', null, '0', '2215520224935937', '0');
INSERT INTO `product_site_data` VALUES ('2215520224940962', '111', '0', null, null, null, '2015-11-30 11:07:19', null, null, '0', '1', null, '0', '1', null, '0', '2215520224935937', '0');
INSERT INTO `product_site_data` VALUES ('2215520224940963', '111', '0', '', '', '', '2015-11-30 11:07:19', '', '2015-12-01 13:40:26', '0', '1', '', '1', '3', '', '2215520224940962', '0', '0');
INSERT INTO `product_site_data` VALUES ('2215520224940966', 'yiyiy', '0', null, null, null, '2015-12-01 17:40:54', null, null, '0', '0', null, '0', '1', null, '0', '2215520224935937', '0');
INSERT INTO `product_site_data` VALUES ('2215520224940967', '11', '0', '', '', '', '2015-12-01 17:40:54', '', '0000-00-00 00:00:00', '0', '1', '', '1', '3', '', '2215520224940966', '0', '0');
INSERT INTO `product_site_data` VALUES ('2215520224940968', '22', '0', '', '', '', '2015-12-01 17:40:54', '', '0000-00-00 00:00:00', '0', '1', '', '1', '3', '', '2215520224940966', '0', '0');
INSERT INTO `product_site_data` VALUES ('2215520224940970', '111', '0', '', '', '', '2015-12-02 09:23:12', '', '0000-00-00 00:00:00', '0', '1', '', '1', '3', '', '2215520224940940', '0', '0');
INSERT INTO `product_site_data` VALUES ('2215520224940971', '五言主主9000', null, null, null, null, '2015-12-02 13:37:46', null, '2015-12-02 14:46:39', '0', '2', '一一一 下上上77', '1', '3', null, '2215520224940940', '0', '0');
INSERT INTO `product_site_data` VALUES ('2215520224940972', '大在地', null, null, null, null, '2015-12-02 14:07:28', null, null, '0', '1', '在在在', '1', '3', null, '2215520224940962', '0', '0');
INSERT INTO `product_site_data` VALUES ('2215520224940973', '大大大', '0', null, null, '1', '2015-12-02 14:35:27', null, null, '0', '1', null, '0', '1', null, '0', '2215520224935937', '0');
INSERT INTO `product_site_data` VALUES ('2215520224940974', '大三', '0', null, null, '1', '2015-12-02 14:36:55', null, '2015-12-02 14:38:59', '0', '1', null, '0', '1', null, '0', '2215520224935938', '0');
INSERT INTO `product_site_data` VALUES ('2215520224940976', '1', '0', '', '', '', '2015-12-02 14:36:55', '', '0000-00-00 00:00:00', '0', '2', '', '1', '3', '', '2215520224940974', '0', '0');
INSERT INTO `product_site_data` VALUES ('2215520224940977', '2', '0', '', '', '', '2015-12-02 14:36:55', '', '0000-00-00 00:00:00', '0', '2', '', '1', '3', '', '2215520224940974', '0', '0');
INSERT INTO `product_site_data` VALUES ('2215520224940978', '3', '0', '', '', '', '2015-12-02 14:36:55', '', '0000-00-00 00:00:00', '0', '2', '', '1', '3', '', '2215520224940974', '0', '0');
INSERT INTO `product_site_data` VALUES ('2215520224940979', '4', '0', '', '', '', '2015-12-02 14:36:55', '', '0000-00-00 00:00:00', '0', '0', '', '2', '3', '', '2215520224940974', '0', '0');
INSERT INTO `product_site_data` VALUES ('2215520224940980', '5', '0', '', '', '', '2015-12-02 14:36:55', '', '0000-00-00 00:00:00', '0', '0', '', '2', '3', '', '2215520224940974', '0', '0');
INSERT INTO `product_site_data` VALUES ('2215520224940981', '6', '0', '', '', '', '2015-12-02 14:36:55', '', '0000-00-00 00:00:00', '0', '1', '', '2', '3', '', '2215520224940974', '0', '0');
INSERT INTO `product_site_data` VALUES ('2215520224940982', '7', '0', '', '', '', '2015-12-02 14:36:55', '', '0000-00-00 00:00:00', '0', '1', '', '3', '3', '', '2215520224940974', '0', '0');
INSERT INTO `product_site_data` VALUES ('2215520224940983', '8', '0', '', '', '', '2015-12-02 14:36:55', '', '0000-00-00 00:00:00', '0', '1', '', '3', '3', '', '2215520224940974', '0', '0');
INSERT INTO `product_site_data` VALUES ('2215520224940985', '555', null, null, null, '1', null, '1', null, '0', '0', '5555555', '0', '2', null, '0', '2215520224935938', '0');
INSERT INTO `product_site_data` VALUES ('2215520224940986', '俄而12', null, null, null, '1', null, '1', null, '0', '0', '俄而12俄而12俄而12俄而12俄而12俄而12俄而12俄而12俄而12俄而12俄而12俄而12俄而12俄而12', '0', '2', null, '0', '2215520224935939', '0');
INSERT INTO `product_site_data` VALUES ('2215520224940987', 'edddd', null, null, null, '1', null, '1', null, '0', '0', 'ddddddddg', '0', '2', null, '0', '2215520224935937', '0');
INSERT INTO `product_site_data` VALUES ('2215520224940988', '张家界', '10', null, null, '1', '2015-12-03 13:43:50', null, null, '0', '1', null, '0', '1', null, '0', '2215520224935937', '0');
INSERT INTO `product_site_data` VALUES ('2215520224940989', '34', '0', '', '', '', '2015-12-03 13:43:50', '', '0000-00-00 00:00:00', '0', '0', '', '1', '3', '', '2215520224940988', '0', '0');
INSERT INTO `product_site_data` VALUES ('2215520224940990', '78', '0', '', '', '', '2015-12-03 13:43:50', '', '0000-00-00 00:00:00', '0', '0', '', '2', '3', '', '2215520224940988', '0', '0');
INSERT INTO `product_site_data` VALUES ('2215520224940991', '56', '0', '', '', '', '2015-12-03 13:43:50', '', '0000-00-00 00:00:00', '0', '2', '', '3', '3', '', '2215520224940988', '0', '0');
INSERT INTO `product_site_data` VALUES ('2215520224940992', 'yanyan1', null, null, null, '1', null, '1', null, '0', '0', 'yanyanyanyanyanyan', '0', '2', null, '0', '2215520224935966', '0');
INSERT INTO `product_site_data` VALUES ('2215520224940993', 'yanyan2', null, null, null, '1', null, '1', null, '0', '0', 'yanyan2', '0', '2', null, '0', '2215520224935967', '0');
INSERT INTO `product_site_data` VALUES ('2215520224940994', '演艺', '0', null, null, '1', '2015-12-03 14:56:28', null, null, '0', '1', null, '0', '1', null, '0', '2215520224935966', '0');
INSERT INTO `product_site_data` VALUES ('2215520224940995', '演艺1', '0', '', '', '', '2015-12-03 14:56:28', '', '0000-00-00 00:00:00', '0', '0', '', '1', '3', '', '2215520224940994', '0', '0');
INSERT INTO `product_site_data` VALUES ('2215520224940996', '演艺1', '0', '', '', '', '2015-12-03 14:56:28', '', '0000-00-00 00:00:00', '0', '0', '', '2', '3', '', '2215520224940994', '0', '0');
INSERT INTO `product_site_data` VALUES ('2215520224940997', '景区', '0', null, null, '1', '2015-12-03 14:57:14', null, null, '0', '0', null, '0', '1', null, '0', '2215520224935967', '0');
INSERT INTO `product_site_data` VALUES ('2215520224940998', '景区', '0', '', '', '', '2015-12-03 14:57:14', '', '0000-00-00 00:00:00', '0', '0', '', '1', '3', '', '2215520224940997', '0', '0');
INSERT INTO `product_site_data` VALUES ('2215520224940999', '景区', '0', '', '', '', '2015-12-03 14:57:14', '', '0000-00-00 00:00:00', '0', '0', '', '2', '3', '', '2215520224940997', '0', '0');
INSERT INTO `product_site_data` VALUES ('2215520224941000', '景区', '0', '', '', '', '2015-12-03 14:57:14', '', '0000-00-00 00:00:00', '0', '0', '', '3', '3', '', '2215520224940997', '0', '0');
INSERT INTO `product_site_data` VALUES ('2215520224941001', '杨发测试检票点', '1', null, null, '1', '2015-12-04 09:19:20', null, '2015-12-04 09:21:04', '0', '1', null, '0', '1', null, '0', '2215520224935969', '1');
INSERT INTO `product_site_data` VALUES ('2215520224941002', '杨发测试检票机', '0', '867323029187273', '', '', '2015-12-04 09:19:20', '', '0000-00-00 00:00:00', '0', '0', '', '1', '3', '', '2215520224941001', '0', '0');
INSERT INTO `product_site_data` VALUES ('2215520224941003', '4444', '0', null, null, '1', '2015-12-04 17:37:37', null, null, '0', '1', null, '0', '1', null, '0', '2215520224935938', '1');
INSERT INTO `product_site_data` VALUES ('2215520224941004', 'aaaa', '0', '', '', '', '2015-12-04 17:37:37', '', '0000-00-00 00:00:00', '0', '1', '', '1', '3', '', '2215520224941003', '0', '0');
INSERT INTO `product_site_data` VALUES ('2215520224941005', 'zzzzzzz', '0', null, null, '1', '2015-12-04 17:38:26', null, '2015-12-04 17:41:18', '0', '1', null, '0', '1', null, '0', '2215520224935937', '1');
INSERT INTO `product_site_data` VALUES ('2215520224941006', 'zzzbbb', '0', '', '', '', '2015-12-04 17:38:26', '', '0000-00-00 00:00:00', '0', '1', '', '1', '3', '', '2215520224941005', '0', '0');
INSERT INTO `product_site_data` VALUES ('2215520224941007', '啊啊', null, null, null, '1', '2015-12-04 18:10:18', null, null, '0', '2', '啊啊啊', '1', '3', null, '0', '0', '1');
INSERT INTO `product_site_data` VALUES ('2215520224941008', '1111111111', null, null, null, '1', '2015-12-04 18:17:56', null, null, '0', '1', '11111', '1', '3', null, '2215520224940962', '0', '1');
INSERT INTO `product_site_data` VALUES ('2215520224941009', 'zxp检票设备', null, '', '867323029187273', '1', '2015-12-05 10:30:00', null, '2015-12-05 10:40:09', '0', '1', '张翔鹏', '2', '3', null, '2215520224941010', '0', '1');
INSERT INTO `product_site_data` VALUES ('2215520224941010', 'zxp检票点', '0', null, null, '1', '2015-12-05 10:35:36', null, '2015-12-06 16:02:18', '0', '1', null, '0', '1', null, '0', '2215520224935969', '1');
INSERT INTO `product_site_data` VALUES ('2215520224941012', '33', null, null, null, '1', '2015-12-05 12:05:37', null, null, '0', '2', '333', '1', '3', null, '2215520224940973', '0', '1');
INSERT INTO `product_site_data` VALUES ('2215520224941013', '设备1', null, null, null, '1', '2015-12-05 12:59:07', null, '2015-12-07 10:23:19', '0', '1', 'ss', '1', '3', null, '2215520224941010', '0', '1');
INSERT INTO `product_site_data` VALUES ('2215520224941014', '北门口', '0', null, null, '1', '2015-12-05 13:37:14', null, null, '0', '1', null, '0', '1', null, '0', '2215520224935971', '1');
INSERT INTO `product_site_data` VALUES ('2215520224941015', '1', '0', '', '', '', '2015-12-05 13:37:14', '', '0000-00-00 00:00:00', '0', '2', '', '1', '3', '', '2215520224941014', '0', '0');
INSERT INTO `product_site_data` VALUES ('2215520224941016', 'zxp检票点', '0', null, null, '1', '2015-12-05 13:49:08', null, '2015-12-06 16:04:59', '0', '1', null, '0', '1', null, '0', '2215520224935971', '1');
INSERT INTO `product_site_data` VALUES ('2215520224941017', '123', '0', '', '', '', '2015-12-05 13:49:08', '', '0000-00-00 00:00:00', '0', '1', '', '1', '3', '', '2215520224941016', '0', '0');
INSERT INTO `product_site_data` VALUES ('2215520224941018', 'zxp11111', '0', null, null, '1', '2015-12-05 14:11:23', null, null, '0', '1', null, '0', '1', null, '0', '2215520224935969', '1');
INSERT INTO `product_site_data` VALUES ('2215520224941019', 'asdas', '0', '', '', '', '2015-12-05 14:11:23', '', '0000-00-00 00:00:00', '0', '1', '', '2', '3', '', '2215520224941018', '0', '0');
INSERT INTO `product_site_data` VALUES ('2215520224941020', 'zxp111', null, null, null, '1', '2015-12-05 14:11:39', null, null, '0', '1', '啊实打实大', '2', '3', null, '2215520224941018', '0', '1');
INSERT INTO `product_site_data` VALUES ('2215520224941021', 'zxp检票点', '0', null, null, '1', '2015-12-05 14:24:32', null, '2015-12-06 15:59:55', '0', '1', null, '0', '1', null, '0', '2215520224935967', '1');
INSERT INTO `product_site_data` VALUES ('2215520224941022', 'zxp检票设备', '0', '', '', '', '2015-12-05 14:24:32', '', '0000-00-00 00:00:00', '0', '1', '', '2', '3', '', '2215520224941021', '0', '0');
INSERT INTO `product_site_data` VALUES ('2215520224941023', '售票1', null, null, null, '1', null, '1', null, '0', '1', '严售票点', '0', '2', null, '0', '2215520224935971', '0');
INSERT INTO `product_site_data` VALUES ('2215520224941024', '剧场', '0', null, '213', '1', '2015-12-05 17:21:26', null, null, '0', '1', null, '0', '1', null, '0', '2215520224935974', '1');
INSERT INTO `product_site_data` VALUES ('2215520224941025', '设备名称1', '0', '', '', '', '2015-12-05 17:21:26', '', '0000-00-00 00:00:00', '0', '1', '', '2', '3', '', '2215520224941024', '0', '0');
INSERT INTO `product_site_data` VALUES ('2215520224941026', 'WW1206', '0', null, null, '1', '2015-12-06 13:29:01', null, null, '0', '1', null, '0', '1', null, '0', '2215520224935969', '1');
INSERT INTO `product_site_data` VALUES ('2215520224941027', 'WW1111', '0', '', '', '', '2015-12-06 13:29:01', '', '0000-00-00 00:00:00', '0', '1', '', '2', '3', '', '2215520224941026', '0', '0');
INSERT INTO `product_site_data` VALUES ('2215520224941028', 'WW1206s', null, null, null, '1', '2015-12-06 13:29:28', null, null, '0', '1', 'ad', '2', '3', null, '2215520224941001', '0', '1');
INSERT INTO `product_site_data` VALUES ('2215520224941029', '周渊测试团进团出', '0', '111', '', '1', '2015-12-06 16:05:33', null, '2015-12-06 16:11:19', '0', '1', null, '0', '1', null, '0', '2215520224935969', '1');
INSERT INTO `product_site_data` VALUES ('2215520224941030', '周渊测试非团进团出', '0', '222', '', '1', '2015-12-06 16:05:40', null, '2015-12-06 16:07:26', '0', '1', null, '0', '1', null, '0', '2215520224935969', '1');
INSERT INTO `product_site_data` VALUES ('2215520224941031', '11', '0', '', '111', '', '2015-12-06 16:07:26', '', '0000-00-00 00:00:00', '0', '1', '', '1', '3', '', '2215520224941030', '0', '0');
INSERT INTO `product_site_data` VALUES ('2215520224941032', '22', '0', '', '', '', '2015-12-06 16:07:26', '', '0000-00-00 00:00:00', '0', '1', '', '2', '3', '', '2215520224941030', '0', '0');
INSERT INTO `product_site_data` VALUES ('2215520224941033', '33', '0', '', '', '', '2015-12-06 16:07:26', '', '0000-00-00 00:00:00', '0', '2', '', '3', '3', '', '2215520224941030', '0', '0');
INSERT INTO `product_site_data` VALUES ('2215520224941034', '1', '0', '', '', '', '2015-12-06 16:07:35', '', '0000-00-00 00:00:00', '0', '2', '', '1', '3', '', '2215520224941029', '0', '0');
INSERT INTO `product_site_data` VALUES ('2215520224941035', '2', '0', '', '222', '', '2015-12-06 16:07:35', '', '0000-00-00 00:00:00', '0', '2', '', '2', '3', '', '2215520224941029', '0', '0');
INSERT INTO `product_site_data` VALUES ('2215520224941036', '3', '0', '', '', '', '2015-12-06 16:07:35', '', '0000-00-00 00:00:00', '0', '2', '', '3', '3', '', '2215520224941029', '0', '0');
INSERT INTO `product_site_data` VALUES ('2215520224941037', '的说法是的撒发生', null, null, null, '1', '2015-12-07 10:24:12', null, null, '0', '2', '答复', '1', '3', null, '2215520224941001', '0', '1');

-- ----------------------------
-- Table structure for `sys_area`
-- ----------------------------
DROP TABLE IF EXISTS `sys_area`;
CREATE TABLE `sys_area` (
  `id` varchar(64) NOT NULL COMMENT '编号',
  `parent_id` varchar(64) NOT NULL COMMENT '父级编号',
  `parent_ids` varchar(2000) NOT NULL COMMENT '所有父级编号',
  `code` varchar(100) DEFAULT NULL COMMENT '区域编码',
  `name` varchar(100) NOT NULL COMMENT '区域名称',
  `type` char(1) DEFAULT NULL COMMENT '区域类型',
  `create_by` varchar(64) DEFAULT NULL COMMENT '创建者',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT NULL COMMENT '更新者',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标记',
  PRIMARY KEY (`id`),
  KEY `sys_area_parent_id` (`parent_id`),
  KEY `sys_area_del_flag` (`del_flag`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='区域表';

-- ----------------------------
-- Records of sys_area
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_channel`
-- ----------------------------
DROP TABLE IF EXISTS `sys_channel`;
CREATE TABLE `sys_channel` (
  `id` bigint(20) NOT NULL,
  `name` varchar(45) DEFAULT NULL COMMENT '渠道名称',
  `channel_principal` varchar(45) DEFAULT NULL COMMENT '渠道负责人',
  `city` varchar(64) DEFAULT NULL COMMENT '市',
  `county` varchar(64) DEFAULT NULL COMMENT '县',
  `province` varchar(64) DEFAULT NULL COMMENT '省',
  `spell` varchar(45) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `del_flag` char(1) NOT NULL DEFAULT '1' COMMENT '使用状态1启用0禁用2删除',
  `sort` int(11) DEFAULT '0' COMMENT '排序',
  `update_date` datetime DEFAULT NULL,
  `update_by` varchar(100) DEFAULT NULL,
  `create_by` varchar(100) DEFAULT NULL,
  `remark` varchar(2000) DEFAULT NULL COMMENT '备注',
  `channel_type` char(10) DEFAULT NULL COMMENT '渠道类型',
  `channel_category` char(10) DEFAULT NULL COMMENT '分销渠道类别',
  `data_source` varchar(45) DEFAULT NULL COMMENT '数据来源',
  `supplier_id` bigint(20) DEFAULT NULL COMMENT '创建供应商',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='渠道表';

-- ----------------------------
-- Records of sys_channel
-- ----------------------------
INSERT INTO `sys_channel` VALUES ('1', '魔方旅游', '管理员', '北京', '中国', '北京', 'BJ', '2015-11-25 14:10:13', '0', '0', '2015-12-04 17:48:14', 'admin', '1', '测试', '2', '0', '1', null);
INSERT INTO `sys_channel` VALUES ('2215520224935946', '北京票之家平台', '王俊南', null, null, null, 'bjpzj', null, '0', '0', '2015-12-03 11:50:42', null, '18980438853', null, '2', '9', null, null);
INSERT INTO `sys_channel` VALUES ('2215520224935947', null, null, null, null, null, null, '2015-11-26 18:48:50', '0', '0', '2015-12-03 11:50:42', null, '18980438853', '分销', '2', '5', null, null);
INSERT INTO `sys_channel` VALUES ('2215520224935948', null, null, null, null, null, null, '2015-11-26 18:49:36', '0', '0', '2015-12-03 11:50:42', null, '18980438853', null, '2', '5', null, null);
INSERT INTO `sys_channel` VALUES ('2215520224935949', null, null, null, null, null, null, '2015-11-26 18:50:55', '0', '0', '2015-12-03 11:50:42', null, '18980438853', null, '2', '5', null, null);
INSERT INTO `sys_channel` VALUES ('2215520224935950', null, null, null, null, null, null, null, '0', '0', '2015-12-03 11:50:42', null, '1', null, '2', '1', null, null);
INSERT INTO `sys_channel` VALUES ('2215520224935951', null, null, null, null, null, null, null, '0', '0', '2015-12-03 11:50:42', null, '1', null, '2', '1', null, null);
INSERT INTO `sys_channel` VALUES ('2215520224935952', '驴妈妈', '驴马', '北京市', '大兴区', '北京市', 'lmm', '2015-11-27 17:46:50', '0', '0', '2015-12-03 11:50:42', null, '1', '驴妈妈旅游，专注旅游三十年', '2', '3', null, null);
INSERT INTO `sys_channel` VALUES ('2215520224935953', 'qqqq', 'qqqq', '天津市', '河东区', '天津市', 'qqq', '2015-11-27 18:31:28', '0', '0', '2015-12-03 11:50:42', null, '1', 'qq', '2', '8', null, null);
INSERT INTO `sys_channel` VALUES ('2215520224935955', '去哪儿网', null, null, null, null, null, null, '0', '0', '2015-12-03 11:50:42', null, null, '', null, null, null, null);
INSERT INTO `sys_channel` VALUES ('2215520224935956', null, null, null, null, null, null, null, '0', '0', '2015-12-03 11:50:42', null, null, '', null, null, null, null);
INSERT INTO `sys_channel` VALUES ('2215520224935957', '123', null, null, null, null, null, null, '0', '0', '2015-12-03 11:50:42', null, null, '', null, null, '1', null);
INSERT INTO `sys_channel` VALUES ('2215520224935958', '分销1', null, null, null, null, null, null, '0', '0', '2015-12-03 11:50:42', null, null, '分销', '2', null, '1', null);
INSERT INTO `sys_channel` VALUES ('2215520224935959', null, null, null, null, null, null, null, '0', '0', '2015-12-03 11:50:42', null, null, '分销', '2', null, '1', null);
INSERT INTO `sys_channel` VALUES ('2215520224935960', null, null, null, null, null, null, null, '0', '0', '2015-12-03 11:50:42', null, null, '分销', '2', null, '1', null);
INSERT INTO `sys_channel` VALUES ('2215520224935961', '直销1', null, null, null, null, null, null, '0', '0', '2015-12-03 11:50:42', null, null, '直销', '1', null, '1', null);
INSERT INTO `sys_channel` VALUES ('2215520224935962', '直销2', null, null, null, null, null, null, '0', '0', '2015-12-03 11:50:42', null, null, '直销', '1', null, '1', null);
INSERT INTO `sys_channel` VALUES ('2215520224935963', null, null, null, null, null, null, null, '0', '0', '2015-12-03 11:50:42', null, null, '分销', '2', null, '1', null);
INSERT INTO `sys_channel` VALUES ('2215520224935964', null, null, null, null, null, null, null, '0', '0', '2015-12-03 11:50:42', null, null, '分销', '2', null, '1', null);
INSERT INTO `sys_channel` VALUES ('2215520224935965', null, null, null, null, null, null, null, '0', '0', '2015-12-03 11:50:42', null, null, '分销', '2', null, '1', null);
INSERT INTO `sys_channel` VALUES ('2215520224935966', null, null, null, null, null, null, null, '2', '0', '2015-12-04 14:00:08', null, null, '分销', '2', null, '1', null);
INSERT INTO `sys_channel` VALUES ('2215520224935967', null, null, null, null, null, null, null, '2', '0', '2015-12-04 13:53:07', null, null, '分销', '2', null, '1', null);
INSERT INTO `sys_channel` VALUES ('2215520224935968', null, null, null, null, null, null, null, '2', '0', '2015-12-04 11:42:39', null, null, '直销', '1', null, '1', null);
INSERT INTO `sys_channel` VALUES ('2215520224935969', null, null, null, null, null, null, null, '2', '0', '2015-12-04 13:59:42', null, null, '分销', '2', null, '1', null);
INSERT INTO `sys_channel` VALUES ('2215520224935970', null, null, null, null, null, null, null, '2', '0', '2015-12-04 11:42:32', null, null, '直销', '1', null, '1', null);
INSERT INTO `sys_channel` VALUES ('2215520224935971', null, null, null, null, null, null, null, '2', '0', '2015-12-04 13:59:39', null, null, '直销', '1', null, '1', null);
INSERT INTO `sys_channel` VALUES ('2215520224935972', null, null, null, null, null, null, null, '2', '0', '2015-12-04 11:42:55', null, null, '分销', '2', null, '1', null);
INSERT INTO `sys_channel` VALUES ('2215520224935973', null, null, null, null, null, null, null, '2', '0', '2015-12-04 11:42:41', null, null, '直销', '1', null, '1', null);
INSERT INTO `sys_channel` VALUES ('2215520224935974', null, null, null, null, null, null, null, '2', '0', '2015-12-04 13:53:03', null, null, '分销', '2', null, '1', null);
INSERT INTO `sys_channel` VALUES ('2215520224935975', null, null, null, null, null, null, null, '2', '0', '2015-12-04 13:53:11', null, null, '分销', '2', null, '1', null);
INSERT INTO `sys_channel` VALUES ('2215520224935976', null, null, null, null, null, null, null, '2', '0', '2015-12-04 13:59:46', null, null, '分销', '2', null, '1', null);
INSERT INTO `sys_channel` VALUES ('2215520224935977', null, null, null, null, null, null, null, '2', '0', '2015-12-04 13:59:50', null, null, '分销', '2', null, '1', null);
INSERT INTO `sys_channel` VALUES ('2215520224935978', null, null, null, null, null, null, null, '2', '0', '2015-12-04 13:59:59', null, null, '直销', '1', null, '1', null);
INSERT INTO `sys_channel` VALUES ('2215520224935979', null, null, null, null, null, null, null, '2', '0', '2015-12-04 13:59:53', null, null, '分销', '2', null, '1', null);
INSERT INTO `sys_channel` VALUES ('2215520224935980', null, null, null, null, null, null, null, '2', '0', '2015-12-04 11:42:50', null, null, '直销', '1', null, '1', null);
INSERT INTO `sys_channel` VALUES ('2215520224935981', null, null, null, null, null, null, null, '2', '0', '2015-12-04 13:52:32', null, null, '直销', '1', null, '1', null);
INSERT INTO `sys_channel` VALUES ('2215520224935982', '12345678901234567890', null, null, null, null, null, null, '1', '0', '2015-12-04 15:13:12', null, null, 'testchannelType1', '1', null, '1', null);
INSERT INTO `sys_channel` VALUES ('2215520224935983', null, null, null, null, null, null, null, '2', '0', '2015-12-04 14:00:15', null, null, '分销', '2', null, '1', null);
INSERT INTO `sys_channel` VALUES ('2215520224935984', null, null, null, null, null, null, null, '2', '0', '2015-12-04 13:52:25', null, null, '分销', '2', null, '1', null);
INSERT INTO `sys_channel` VALUES ('2215520224935985', null, null, null, null, null, null, null, '2', '0', '2015-12-04 11:42:36', null, null, '直销', '1', null, '1', null);
INSERT INTO `sys_channel` VALUES ('2215520224935986', null, null, null, null, null, null, null, '2', '0', '2015-12-01 17:25:30', null, null, '分销', '2', null, '1', null);
INSERT INTO `sys_channel` VALUES ('2215520224935987', null, null, null, null, null, null, null, '2', '0', '2015-12-01 17:25:28', null, null, '分销', '2', null, '1', null);
INSERT INTO `sys_channel` VALUES ('2215520224935988', null, null, null, null, null, null, null, '2', '0', '2015-12-01 17:25:36', null, null, '分销', '2', null, '1', null);
INSERT INTO `sys_channel` VALUES ('2215520224935989', null, null, null, null, null, null, null, '2', '0', '2015-12-01 17:25:33', null, null, '分销', '2', null, '1', null);
INSERT INTO `sys_channel` VALUES ('2215520224935990', null, null, null, null, null, null, null, '2', '0', '2015-12-01 17:25:25', null, null, '分销', '2', null, '1', null);
INSERT INTO `sys_channel` VALUES ('2215520224935991', '111', null, null, null, null, null, null, '2', '0', '2015-12-01 17:49:17', null, null, '', null, null, '1', null);
INSERT INTO `sys_channel` VALUES ('2215520224935992', null, null, null, null, null, null, null, '2', '0', '2015-12-01 17:49:27', null, null, '', null, null, '1', null);
INSERT INTO `sys_channel` VALUES ('2215520224935993', null, null, null, null, null, null, null, '2', '0', '2015-12-02 15:40:58', null, null, '', null, null, '1', null);
INSERT INTO `sys_channel` VALUES ('2215520224935994', null, null, null, null, null, null, null, '2', '0', '2015-12-01 17:58:41', null, null, '', null, null, '1', null);
INSERT INTO `sys_channel` VALUES ('2215520224935995', null, null, null, null, null, null, '2015-12-01 18:00:40', '1', '0', null, null, '1', null, null, null, null, null);
INSERT INTO `sys_channel` VALUES ('2215520224935996', 'wuhui', 'wuhui', '北京市', '东城区', '北京市', 'wuhui', '2015-12-01 18:02:31', '1', '0', '2015-12-01 18:06:43', null, null, 'wuhui', '2', '1', null, null);
INSERT INTO `sys_channel` VALUES ('2215520224935997', '415', null, null, null, null, null, null, '2', '0', '2015-12-02 15:41:00', null, null, '', null, null, '1', null);
INSERT INTO `sys_channel` VALUES ('2215520224935998', null, null, null, null, null, null, null, '2', '0', '2015-12-02 15:41:01', null, null, '', null, null, '1', null);
INSERT INTO `sys_channel` VALUES ('2215520224935999', null, null, null, null, null, null, null, '2', '0', '2015-12-02 15:41:37', null, null, '分销', '2', null, '1', null);
INSERT INTO `sys_channel` VALUES ('2215520224936000', null, null, null, null, null, null, null, '2', '0', '2015-12-02 15:41:39', null, null, '分销', '2', null, '1', null);
INSERT INTO `sys_channel` VALUES ('2215520224936001', null, null, null, null, null, null, null, '2', '0', '2015-12-02 15:41:41', null, null, '分销', '2', null, '1', null);
INSERT INTO `sys_channel` VALUES ('2215520224936002', '直销2', null, null, null, null, null, null, '2', '0', '2015-12-02 15:41:19', null, null, '直销', '1', null, '1', null);
INSERT INTO `sys_channel` VALUES ('2215520224936003', null, null, null, null, null, null, null, '2', '0', '2015-12-02 15:41:21', null, null, '直销', '1', null, '1', null);
INSERT INTO `sys_channel` VALUES ('2215520224936004', 'LN分销渠道', 'LN分销渠道', null, null, null, 'ln', '2015-12-01 19:47:35', '1', '0', '2015-12-02 10:24:58', '1', '1', 'LN分销渠道', '2', '1', null, null);
INSERT INTO `sys_channel` VALUES ('2215520224936005', '54', null, null, null, null, null, null, '2', '0', '2015-12-02 15:41:24', null, null, 'ç´é', '1', null, '1', null);
INSERT INTO `sys_channel` VALUES ('2215520224936006', null, null, null, null, null, null, null, '2', '0', '2015-12-02 15:41:27', null, null, 'ç´é', '1', null, '1', null);
INSERT INTO `sys_channel` VALUES ('2215520224936007', null, null, null, null, null, null, null, '2', '0', '2015-12-02 15:41:29', null, null, 'ç´é', '1', null, '1', null);
INSERT INTO `sys_channel` VALUES ('2215520224936008', null, null, null, null, null, null, null, '2', '0', '2015-12-02 15:41:05', null, null, '', null, null, '1', null);
INSERT INTO `sys_channel` VALUES ('2215520224936009', '3', null, null, null, null, null, null, '2', '0', '2015-12-02 15:41:08', null, null, '', null, null, '1', null);
INSERT INTO `sys_channel` VALUES ('2215520224936010', null, null, null, null, null, null, '2015-12-02 15:40:45', '1', '0', null, null, '1', null, null, null, null, null);
INSERT INTO `sys_channel` VALUES ('2215520224936011', 'testChannel1', null, null, null, null, null, null, '1', '0', '2015-12-07 10:29:25', null, null, '', null, null, '1', null);
INSERT INTO `sys_channel` VALUES ('2215520224936012', 'testChannel2', null, null, null, null, null, null, '1', '0', null, null, null, 'testchannelType1', '1', null, '1', null);
INSERT INTO `sys_channel` VALUES ('2215520224936013', 'mofangChannel1', null, null, null, null, null, null, '1', '0', null, null, null, '魔方渠道', '0', null, '1', null);
INSERT INTO `sys_channel` VALUES ('2215520224936014', 'test1', null, null, null, null, null, null, '1', '0', null, null, null, '', null, null, '1', null);
INSERT INTO `sys_channel` VALUES ('2215520224936015', 'testchannel32', null, null, null, null, null, null, '1', '0', '2015-12-04 17:20:35', null, null, '', null, null, '1', null);
INSERT INTO `sys_channel` VALUES ('2215520224936016', 'aaaa', null, null, null, null, null, null, '1', '0', null, null, null, '旅行社部门', '3', null, '1', null);
INSERT INTO `sys_channel` VALUES ('2215520224936017', 'a', null, null, null, null, null, null, '1', '0', null, null, null, '', null, null, '1', null);
INSERT INTO `sys_channel` VALUES ('2215520224936018', 'a1', null, null, null, null, null, null, '1', '0', null, null, null, '', null, null, '1', null);
INSERT INTO `sys_channel` VALUES ('2215520224936019', 'a2', null, null, null, null, null, null, '1', '0', null, null, null, '魔方旅游', '6', null, '1', null);
INSERT INTO `sys_channel` VALUES ('2215520224936020', 'a2', null, null, null, null, null, null, '1', '0', null, null, null, '魔方渠道', '0', null, '1', null);
INSERT INTO `sys_channel` VALUES ('2215520224936021', 'a3ddd', null, null, null, null, null, null, '1', '0', '2015-12-04 17:20:09', null, null, '魔方渠道', '0', null, '1', null);
INSERT INTO `sys_channel` VALUES ('2215520224936022', '北京旅行社', '方向', '北京市', '东城区', '北京市', 'bj', '2015-12-02 20:04:51', '1', '0', '2015-12-06 13:40:18', null, '1', '北京旅行社北京旅行社北京旅行社', '2', '2', null, null);
INSERT INTO `sys_channel` VALUES ('2215520224936023', null, null, null, null, null, null, null, '2', '0', '2015-12-04 15:16:39', null, null, 'é­æ¹æ¸ é', '0', null, '1', null);
INSERT INTO `sys_channel` VALUES ('2215520224936024', null, null, null, null, null, null, null, '2', '0', '2015-12-04 11:28:22', null, null, '魔方渠道', '0', null, '1', null);
INSERT INTO `sys_channel` VALUES ('2215520224936025', null, null, null, null, null, null, null, '2', '0', '2015-12-04 11:28:18', null, null, '魔方渠道', '0', null, '1', null);
INSERT INTO `sys_channel` VALUES ('2215520224936026', '渠道名称1', null, null, null, null, null, null, '2', '0', '2015-12-04 09:59:32', null, null, '魔方渠道', '0', null, '1', null);
INSERT INTO `sys_channel` VALUES ('2215520224936027', '渠道名称1', null, null, null, null, null, null, '2', '0', '2015-12-04 10:10:15', null, null, '新增渠道分类1', '3', null, '1', null);
INSERT INTO `sys_channel` VALUES ('2215520224936028', '111', null, null, null, null, null, null, '2', '0', '2015-12-04 10:00:08', null, null, '新增渠道分类1', '3', null, '1', null);
INSERT INTO `sys_channel` VALUES ('2215520224936029', '222', null, null, null, null, null, null, '2', '0', '2015-12-04 10:11:08', null, null, '111', '4', null, '1', null);
INSERT INTO `sys_channel` VALUES ('2215520224936030', null, null, null, null, null, null, null, '2', '0', '2015-12-04 11:28:25', null, null, '魔方渠道', '0', null, '1', null);
INSERT INTO `sys_channel` VALUES ('2215520224936031', null, null, null, null, null, null, null, '2', '0', '2015-12-04 11:28:28', null, null, '魔方渠道', '0', null, '1', null);
INSERT INTO `sys_channel` VALUES ('2215520224936032', null, null, null, null, null, null, null, '2', '0', '2015-12-04 11:28:30', null, null, '魔方渠道', '0', null, '1', null);
INSERT INTO `sys_channel` VALUES ('2215520224936033', '999', null, null, null, null, null, null, '2', '0', '2015-12-04 11:02:28', null, null, '111', '4', null, '1', null);
INSERT INTO `sys_channel` VALUES ('2215520224936034', null, null, null, null, null, null, null, '2', '0', '2015-12-04 11:28:32', null, null, '魔方渠道', '0', null, '1', null);
INSERT INTO `sys_channel` VALUES ('2215520224936035', '110', null, null, null, null, null, null, '1', '0', null, null, null, '9', '5', null, '1', null);
INSERT INTO `sys_channel` VALUES ('2215520224936036', '1', null, null, null, null, null, null, '2', '0', '2015-12-04 13:52:57', null, null, 'testChannelType1', '2', null, '1', null);
INSERT INTO `sys_channel` VALUES ('2215520224936037', '44', '44', '北京市', '东城区', '北京市', '44', '2015-12-04 10:50:54', '1', '0', null, null, '1', '44', '2', '4', null, null);
INSERT INTO `sys_channel` VALUES ('2215520224936038', null, null, null, null, null, null, null, '2', '0', '2015-12-04 11:28:34', null, null, '魔方渠道', '0', null, '1', null);
INSERT INTO `sys_channel` VALUES ('2215520224936039', null, null, null, null, null, null, null, '2', '0', '2015-12-04 11:28:37', null, null, '魔方渠道', '0', null, '1', null);
INSERT INTO `sys_channel` VALUES ('2215520224936040', null, null, null, null, null, null, null, '2', '0', '2015-12-04 11:28:39', null, null, '魔方渠道', '0', null, '1', null);
INSERT INTO `sys_channel` VALUES ('2215520224936041', null, null, null, null, null, null, null, '2', '0', '2015-12-04 11:28:42', null, null, '魔方渠道', '0', null, '1', null);
INSERT INTO `sys_channel` VALUES ('2215520224936042', null, null, null, null, null, null, null, '2', '0', '2015-12-04 11:28:47', null, null, '魔方渠道', '0', null, '1', null);
INSERT INTO `sys_channel` VALUES ('2215520224936043', null, null, null, null, null, null, null, '2', '0', '2015-12-04 11:28:44', null, null, '魔方渠道', '0', null, '1', null);
INSERT INTO `sys_channel` VALUES ('2215520224936044', null, null, null, null, null, null, null, '2', '0', '2015-12-04 11:28:52', null, null, '魔方渠道', '0', null, '1', null);
INSERT INTO `sys_channel` VALUES ('2215520224936045', null, null, null, null, null, null, null, '2', '0', '2015-12-04 11:28:49', null, null, '魔方渠道', '0', null, '1', null);
INSERT INTO `sys_channel` VALUES ('2215520224936046', null, null, null, null, null, null, null, '2', '0', '2015-12-04 11:29:04', null, null, '魔方渠道', '0', null, '1', null);
INSERT INTO `sys_channel` VALUES ('2215520224936047', null, null, null, null, null, null, null, '2', '0', '2015-12-04 11:28:54', null, null, '魔方渠道', '0', null, '1', null);
INSERT INTO `sys_channel` VALUES ('2215520224936048', null, null, null, null, null, null, null, '2', '0', '2015-12-04 11:29:02', null, null, '魔方渠道', '0', null, '1', null);
INSERT INTO `sys_channel` VALUES ('2215520224936049', null, null, null, null, null, null, null, '2', '0', '2015-12-04 11:28:56', null, null, '魔方渠道', '0', null, '1', null);
INSERT INTO `sys_channel` VALUES ('2215520224936050', null, null, null, null, null, null, null, '2', '0', '2015-12-04 11:28:59', null, null, '魔方渠道', '0', null, '1', null);
INSERT INTO `sys_channel` VALUES ('2215520224936051', null, null, null, null, null, null, null, '2', '0', '2015-12-04 11:29:00', null, null, '魔方渠道', '0', null, '1', null);
INSERT INTO `sys_channel` VALUES ('2215520224936052', null, null, null, null, null, null, null, '2', '0', '2015-12-04 11:29:07', null, null, '魔方渠道', '0', null, '1', null);
INSERT INTO `sys_channel` VALUES ('2215520224936053', null, null, null, null, null, null, null, '2', '0', '2015-12-04 11:28:14', null, null, '魔方渠道', '0', null, '1', null);
INSERT INTO `sys_channel` VALUES ('2215520224936054', '123', null, null, null, null, null, null, '1', '0', '2015-12-04 17:20:21', null, null, '魔方渠道', '0', null, '1', null);
INSERT INTO `sys_channel` VALUES ('2215520224936055', '哈哈', null, null, null, null, null, null, '1', '0', null, null, null, 'é­æ¹æ¸ é', '0', null, '1', null);
INSERT INTO `sys_channel` VALUES ('2215520224936056', null, null, null, null, null, null, null, '2', '0', '2015-12-04 13:52:39', null, null, 'é­æ¹æ¸ é', '0', null, '1', null);
INSERT INTO `sys_channel` VALUES ('2215520224936057', null, null, null, null, null, null, null, '2', '0', '2015-12-04 13:52:35', null, null, 'é­æ¹æ¸ é', '0', null, '1', null);
INSERT INTO `sys_channel` VALUES ('2215520224936058', '1111', null, null, null, null, null, null, '1', '0', null, null, null, '12~！cnk 中文', '15', null, '1', null);
INSERT INTO `sys_channel` VALUES ('2215520224936059', null, null, null, null, null, null, null, '2', '0', '2015-12-04 14:00:12', null, null, 'é­æ¹æ¸ é', '0', null, '1', null);
INSERT INTO `sys_channel` VALUES ('2215520224936060', null, null, null, null, null, null, null, '2', '0', '2015-12-04 13:52:42', null, null, 'é­æ¹æ¸ é', '0', null, '1', null);
INSERT INTO `sys_channel` VALUES ('2215520224936061', null, null, null, null, null, null, null, '2', '0', '2015-12-04 13:52:45', null, null, 'é­æ¹æ¸ é', '0', null, '1', null);
INSERT INTO `sys_channel` VALUES ('2215520224936062', '111', null, null, null, null, null, null, '2', '0', '2015-12-04 14:18:22', null, null, '一二三四五六七八九十零', '29', null, '1', null);
INSERT INTO `sys_channel` VALUES ('2215520224936063', '111', null, null, null, null, null, null, '2', '0', '2015-12-04 14:17:29', null, null, '一二三四五六七八九十', '28', null, '1', null);
INSERT INTO `sys_channel` VALUES ('2215520224936064', '111', null, null, null, null, null, null, '2', '0', '2015-12-04 14:18:25', null, null, '一二三四五六七八九十零', '29', null, '1', null);
INSERT INTO `sys_channel` VALUES ('2215520224936065', '111', null, null, null, null, null, null, '2', '0', '2015-12-04 14:18:18', null, null, '一二三四五六七八九十', '28', null, '1', null);
INSERT INTO `sys_channel` VALUES ('2215520224936066', '魔方渠道', null, null, null, null, null, null, '1', '0', '2015-12-04 16:56:47', null, null, '魔方渠道', '0', null, '1', null);
INSERT INTO `sys_channel` VALUES ('2215520224936067', '魔方渠道', null, null, null, null, null, null, '1', '0', null, null, null, '魔方渠道', '0', null, '1', null);
INSERT INTO `sys_channel` VALUES ('2215520224936068', '0', null, null, null, null, null, null, '2', '0', '2015-12-04 15:16:44', null, null, '魔方渠道', '0', null, '1', null);
INSERT INTO `sys_channel` VALUES ('2215520224936069', '12345678901234567890', null, null, null, null, null, null, '1', '0', null, null, null, '魔方渠道', '0', null, '1', null);
INSERT INTO `sys_channel` VALUES ('2215520224936070', '一二三四五六七八九十一二三四五六七八九十', null, null, null, null, null, null, '1', '0', null, null, null, '魔方渠道', '0', null, '1', null);
INSERT INTO `sys_channel` VALUES ('2215520224936071', 'abcdefghijklmnopqrst', null, null, null, null, null, null, '1', '0', null, null, null, '魔方渠道', '0', null, '1', null);
INSERT INTO `sys_channel` VALUES ('2215520224936072', '~!@#$%^&*():\"?><', null, null, null, null, null, null, '2', '0', '2015-12-04 14:36:40', null, null, '魔方渠道', '0', null, '1', null);
INSERT INTO `sys_channel` VALUES ('2215520224936073', '~`!@#$%^&*()><?\":;\'/', null, null, null, null, null, null, '2', '0', '2015-12-04 14:36:35', null, null, '魔方渠道', '0', null, '1', null);
INSERT INTO `sys_channel` VALUES ('2215520224936074', '/', null, null, null, null, null, null, '2', '0', '2015-12-04 14:36:32', null, null, '魔方渠道', '0', null, '1', null);
INSERT INTO `sys_channel` VALUES ('2215520224936075', '`~!@#$%^&*()-=_+\":?>', null, null, null, null, null, null, '2', '0', '2015-12-04 14:41:48', null, null, '魔方渠道', '0', null, '1', null);
INSERT INTO `sys_channel` VALUES ('2215520224936076', '<>,.?/:\";\'', null, null, null, null, null, null, '2', '0', '2015-12-04 14:41:53', null, null, '魔方渠道', '0', null, '1', null);
INSERT INTO `sys_channel` VALUES ('2215520224936077', '~!!@#abcd1234呵呵呵', null, null, null, null, null, null, '2', '0', '2015-12-04 14:41:57', null, null, '魔方渠道', '0', null, '1', null);
INSERT INTO `sys_channel` VALUES ('2215520224936078', '~！@#￥%……&*（）——+”：“》', null, null, null, null, null, null, '2', '0', '2015-12-04 14:42:02', null, null, '魔方渠道', '0', null, '1', null);
INSERT INTO `sys_channel` VALUES ('2215520224936079', '《》？：”{}——+|，。、；‘【】、-', null, null, null, null, null, null, '2', '0', '2015-12-04 14:41:43', null, null, '魔方渠道', '0', null, '1', null);
INSERT INTO `sys_channel` VALUES ('2215520224936080', '12345678901234567890', null, null, null, null, null, null, '1', '0', '2015-12-04 15:13:24', null, null, '魔方渠道', '0', null, '1', null);
INSERT INTO `sys_channel` VALUES ('2215520224936081', '援助在中国进行', '阿斯达', '北京市', '东城区', '北京市', 'aweadas', '2015-12-04 16:01:18', '1', '0', null, null, '1', 'XXXXXXXXXsadasd阿斯达', '2', '3', null, null);
INSERT INTO `sys_channel` VALUES ('2215520224936082', null, null, null, null, null, null, null, '1', '0', null, null, null, '魔方渠道', '0', null, '1', null);
INSERT INTO `sys_channel` VALUES ('2215520224936083', null, null, null, null, null, null, null, '1', '0', null, null, null, '魔方渠道', '0', null, '1', null);
INSERT INTO `sys_channel` VALUES ('2215520224936084', null, null, null, null, null, null, null, '1', '0', null, null, null, '魔方渠道', '0', null, '1', null);
INSERT INTO `sys_channel` VALUES ('2215520224936085', null, null, null, null, null, null, null, '1', '0', null, null, null, '魔方渠道', '0', null, '1', null);
INSERT INTO `sys_channel` VALUES ('2215520224936086', null, null, null, null, null, null, null, '1', '0', null, null, null, '魔方渠道', '0', null, '1', null);
INSERT INTO `sys_channel` VALUES ('2215520224936087', null, null, null, null, null, null, null, '1', '0', null, null, null, '魔方渠道', '0', null, '1', null);
INSERT INTO `sys_channel` VALUES ('2215520224936088', null, null, null, null, null, null, null, '2', '0', '2015-12-04 18:24:21', null, null, '', null, null, '1', null);
INSERT INTO `sys_channel` VALUES ('2215520224936089', '12041801', '张三', '北京市', '东城区', '北京市', 'zs', '2015-12-04 18:02:52', '1', '0', null, null, '1', 'zs', '2', '6', null, null);
INSERT INTO `sys_channel` VALUES ('2215520224936090', 'sdf', null, null, null, null, null, null, '1', '0', null, null, null, '魔方渠道', '0', null, '1', null);
INSERT INTO `sys_channel` VALUES ('2215520224936091', 'zxp旅行社分销渠道', '张翔鹏', '北京市', '东城区', '北京市', 'zxp', '2015-12-05 10:51:14', '1', '0', '2015-12-06 20:41:07', null, '1', '张翔鹏渠道简介', '2', '2', null, null);
INSERT INTO `sys_channel` VALUES ('2215520224936092', '23', '23', '北京市', '东城区', '北京市', 'bj', '2015-12-05 11:12:02', '1', '0', null, null, '1', 'bj', '2', '6', null, null);
INSERT INTO `sys_channel` VALUES ('2215520224936093', '测试渠道nn ', 'createnn', '北京', '北京', '北京', '1', '2015-12-05 13:35:52', '1', '0', null, '测试', '测试nn', '1', '1', '1', null, null);
INSERT INTO `sys_channel` VALUES ('2215520224936094', '测试渠道nn ', 'updatenn', 'beijing', 'beijing', '北京', '1', '2015-12-05 13:45:24', '1', '0', '2015-12-05 13:50:18', '测试', '测试nn', '1', '1', '0', null, null);
INSERT INTO `sys_channel` VALUES ('2215520224936095', '测试createBatch1', 'createnn', '北京', '北京', '北京', '1', '2015-12-05 13:46:44', '1', '0', '0000-00-00 00:00:00', '测试', '测试nn', '1', '1', '1', '', '0');
INSERT INTO `sys_channel` VALUES ('2215520224936096', '测试createBatch2', 'createnn', '北京', '北京', '北京', '1', '2015-12-05 13:46:44', '1', '0', '0000-00-00 00:00:00', '测试', '测试nn', '1', '1', '1', '', '0');
INSERT INTO `sys_channel` VALUES ('2215520224936097', '测试createBatch1', 'createnn', '北京', '北京', '北京', '1', '2015-12-05 13:53:57', '0', '0', '2015-12-05 14:40:27', '测试', '测试nn', '1', '1', '1', '', '1');
INSERT INTO `sys_channel` VALUES ('2215520224936098', '测试createBatch2', 'createnn', '北京', '北京', '北京', '1', '2015-12-05 13:53:57', '0', '0', '2015-12-05 14:40:27', '测试', '测试nn', '1', '1', '1', '', '1');
INSERT INTO `sys_channel` VALUES ('2215520224936099', null, null, null, null, null, null, '2015-12-05 14:13:56', '1', '0', null, null, '1', null, null, null, null, null);
INSERT INTO `sys_channel` VALUES ('2215520224936100', '测试update', 'updatenn', '', '', '', '', '2015-12-05 14:53:48', '1', '0', '0000-00-00 00:00:00', '测试update', '测试nn', '', '2', '1', '', '0');
INSERT INTO `sys_channel` VALUES ('2215520224936101', 'yan123', '严青', '北京市', '东城区', '北京市', '123', '2015-12-05 18:26:15', '1', '0', '2015-12-05 18:26:31', '1', '1', '123', '2', '3', null, null);
INSERT INTO `sys_channel` VALUES ('2215520224936102', '张翔鹏OTA分销渠道', '张翔鹏', '北京市', '丰台区', '北京市', 'zxpjqfxqd', '2015-12-06 11:44:58', '1', '0', '2015-12-06 16:45:30', '1', '1', '张翔鹏景区分销渠道简介', '2', '9', null, null);
INSERT INTO `sys_channel` VALUES ('2215520224936103', 'WW1206', 'WW', '北京市', '东城区', '北京市', null, '2015-12-06 13:43:46', '1', '0', '2015-12-06 14:06:25', null, '1', null, '2', '6', null, null);
INSERT INTO `sys_channel` VALUES ('2215520224936104', '自治区旅行社', '于涛', '湘潭市', '湘乡市', '湖南省', 'zzxlxs', '2015-12-06 15:31:39', '1', '0', null, null, '1', '自治区内旅行社分销商', '2', '2', null, null);
INSERT INTO `sys_channel` VALUES ('2215520224936105', '测试渠道1', null, null, null, null, null, null, '1', '0', null, null, null, 'channelType3', '45', null, '2', null);

-- ----------------------------
-- Table structure for `sys_channel_strategy`
-- ----------------------------
DROP TABLE IF EXISTS `sys_channel_strategy`;
CREATE TABLE `sys_channel_strategy` (
  `id` bigint(20) NOT NULL,
  `name` varchar(100) DEFAULT NULL COMMENT '政策名称',
  `remark` varchar(1000) DEFAULT NULL COMMENT '备注',
  `price` double(10,2) DEFAULT '0.00' COMMENT '渠道价',
  `quantity` int(10) DEFAULT '0' COMMENT '购买数量',
  `begin_date` date DEFAULT NULL COMMENT '政策起始时间',
  `end_date` date DEFAULT NULL COMMENT '政策结束时间',
  `pre_sale` int(10) DEFAULT '0' COMMENT '预售天数',
  `pre_sale_mode` tinyint(1) DEFAULT '1' COMMENT '预售计时方式（1小时，2日）',
  `expire` int(10) DEFAULT '0' COMMENT '有效期天数',
  `expire_mode` tinyint(1) DEFAULT '0' COMMENT '有效期计时方式（1小时，2日）',
  `scope` varchar(50) DEFAULT '0' COMMENT '适用范围、可多选(1周一 2周二 3周三 4周四 5周五 6周六 7周日)',
  `status` tinyint(1) DEFAULT '1' COMMENT '状态（1启用 0停用）',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `create_by` varchar(64) DEFAULT NULL COMMENT '创建人',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `update_by` varchar(64) DEFAULT NULL COMMENT '更新人',
  `type` char(10) DEFAULT NULL COMMENT '渠道政策类型1直销2分销',
  `del_flag` char(1) NOT NULL COMMENT '删除标记：删除',
  `publish_date` date DEFAULT NULL COMMENT '发布时间',
  `data_source` varchar(45) DEFAULT NULL COMMENT '数据来源',
  `publish_by` varchar(100) DEFAULT NULL COMMENT '发布人',
  `publish_status` tinyint(1) DEFAULT '0' COMMENT '发布状态 1:已发布 0:未发布',
  `dict_value` varchar(100) DEFAULT '直销渠道数据字典',
  `is_open_multi_rebate` char(1) DEFAULT NULL COMMENT '是否开启多级返利 ',
  `supplier_id` bigint(20) DEFAULT NULL COMMENT '创建供应商',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='渠道政策表';

-- ----------------------------
-- Records of sys_channel_strategy
-- ----------------------------
INSERT INTO `sys_channel_strategy` VALUES ('2215520224935951', '测试北京魔方', '123456', '12.00', '1', '2015-11-26', '2015-11-30', '2', '1', '0', '2', '7,5,1,6,4,3', '1', '2015-11-26 13:54:05', '1', '2015-12-04 16:29:04', '1', '1', '1', '2015-12-04', null, 'edre#@#@#$', '2', 'product:sellingtool#4,product:sellingtool#1', null, null);
INSERT INTO `sys_channel_strategy` VALUES ('2215520224935956', '12', '12', '2.00', '1', '2015-11-26', '2015-11-30', '1', '1', '1', '1', '1,2,3,4,5,6,7', '1', '2015-11-26 17:26:41', '18980438853', '2015-12-03 11:00:12', null, '2', '1', null, null, null, '0', '直销渠道数据字典', null, null);
INSERT INTO `sys_channel_strategy` VALUES ('2215520224935957', '11', '1111111', '3.00', '1', '2015-11-26', '2015-11-30', '11', '1', '0', '0', '1,2,3,4,5,6,7', '1', '2015-11-26 17:47:33', null, '2015-12-03 11:00:12', null, '1', '1', null, null, null, '0', 'product:sellingtool#4', null, null);
INSERT INTO `sys_channel_strategy` VALUES ('2215520224935958', '111', '111111111', '4.00', '11111', '2015-11-26', '2015-11-30', '11', '1', '1', '2', '1,2,3,4,5,6,7', '1', '2015-11-26 18:30:30', null, '2015-12-03 11:00:12', null, '1', '1', null, null, null, '0', '直销渠道数据字典', null, null);
INSERT INTO `sys_channel_strategy` VALUES ('2215520224935959', '111', '111111111', '5.00', '11111', '2015-11-26', '2015-11-30', '11', '1', '1', '2', '1,2,3,4,5,6,7', '1', '2015-11-26 18:30:31', null, '2015-12-03 11:00:12', null, '1', '1', null, null, null, '0', '直销渠道数据字典', null, null);
INSERT INTO `sys_channel_strategy` VALUES ('2215520224935961', '1212', '12', '6.00', '1', '2015-11-27', '2015-11-30', '1', '1', '1', '1', '1,2,6,4,5,3,7', '1', '2015-11-27 14:34:34', '18980438853', '2015-12-03 11:00:12', null, '2', '1', null, null, null, '0', '直销渠道数据字典', null, null);
INSERT INTO `sys_channel_strategy` VALUES ('2215520224935962', '31', '1212', '7.00', '1', '2015-11-27', '2015-11-27', '1', '1', '1', '1', '4,5,2,6,3,7,1', '1', '2015-11-27 14:49:33', '18980438853', '2015-12-03 11:00:12', null, '2', '1', null, null, null, '0', '直销渠道数据字典', null, null);
INSERT INTO `sys_channel_strategy` VALUES ('2215520224935963', '123', '12', '8.00', '1', '2015-11-27', '2015-11-30', '1', '1', '1', '1', '3,4,2,5,6,1,7', '1', '2015-11-27 14:58:24', '18980438853', '2015-12-03 11:00:12', null, '2', '1', null, null, null, '0', '直销渠道数据字典', null, null);
INSERT INTO `sys_channel_strategy` VALUES ('2215520224935964', 'eeee', 'we', '9.00', '1', '2015-11-27', '2015-11-30', '1', '1', '1', '1', '4,7,5,6,3,1,2', '1', '2015-11-27 15:14:39', '18980438853', '2015-12-03 11:00:12', null, '2', '1', null, null, null, '0', '直销渠道数据字典', null, null);
INSERT INTO `sys_channel_strategy` VALUES ('2215520224935965', 'tttt', 'tt', '10.00', '3', '2015-11-27', '2015-11-30', '3', '1', '1', '1', '5,3,6,2,7,4,1', '1', '2015-11-27 15:17:12', '18980438853', '2015-12-03 11:00:12', null, '2', '1', null, null, null, '0', '直销渠道数据字典', null, null);
INSERT INTO `sys_channel_strategy` VALUES ('2215520224935966', 'dfas', 'fdas', '11.00', '1', '2015-11-27', '2015-11-30', '1', '1', '0', '2', '5,6,2,3,1,7,4', '1', '2015-11-27 15:52:22', '18980438853', '2015-12-03 11:00:12', null, '2', '1', null, null, null, '0', '直销渠道数据字典', null, null);
INSERT INTO `sys_channel_strategy` VALUES ('2215520224935967', 'aaa', 'aaa', '12.00', '1', '2015-11-27', '2015-11-30', '1', '1', '1', '1', '2,7,3,4,6,1,5', '1', '2015-11-27 15:55:53', '18980438853', '2015-12-03 11:00:12', '18980438853', '2', '1', null, null, null, '0', '直销渠道数据字典', null, null);
INSERT INTO `sys_channel_strategy` VALUES ('2215520224935968', 'testzx', 'zx', '13.00', '1', '2015-11-27', '2015-11-30', '2', '1', '1', '1', '2,3,4,5,7,1,6', '1', '2015-11-27 17:07:08', '1', '2015-12-04 14:25:06', null, '1', '1', null, null, null, '1', 'product:sellingtool#3', null, null);
INSERT INTO `sys_channel_strategy` VALUES ('2215520224935969', 'testss', 'testss', '14.00', '1', '2015-11-27', '2015-11-30', '1', '1', '1', '1', '5,4,7,6,2,3', '1', '2015-11-27 17:13:48', '1', '2015-12-04 14:25:06', null, '1', '1', null, null, null, '1', 'product:sellingtool#4', null, null);
INSERT INTO `sys_channel_strategy` VALUES ('2215520224935970', 'test1', '1', '15.00', '1', '2015-11-27', '2015-11-30', '1', '1', '0', '2', '6,2,4,7,1,3,5', '1', '2015-11-27 17:16:30', '1', '2015-12-04 14:25:06', null, '1', '1', '2015-12-03', null, '法人', '1', 'product:sellingtool#1', null, null);
INSERT INTO `sys_channel_strategy` VALUES ('2215520224935971', 'fdas', 'fsda', '16.00', '1', '2015-11-27', '2015-11-30', '1', '1', '1', '1', '3', '1', '2015-11-27 17:23:35', '1', '2015-12-04 14:25:06', null, '1', '1', '2015-11-27', null, '18980438853', '2', 'product:sellingtool#1', null, null);
INSERT INTO `sys_channel_strategy` VALUES ('2215520224935972', '无悔测试', '无悔测试', '66.00', '99', '2015-12-28', '2015-12-31', '1', '1', '1', '2', '2,3,6,4,5,7,1', '1', '2015-12-01 18:06:35', '1', '2015-12-04 14:25:06', null, '2', '1', '2015-12-01', null, 'rrgfterg', '2', '直销渠道数据字典', null, null);
INSERT INTO `sys_channel_strategy` VALUES ('2215520224935973', '线下窗口直销', '线下窗口直销', '58.00', '55', '2015-12-30', '2015-12-31', '1', '1', '1', '2', '1,7,2,3,4,6,5', '1', '2015-12-02 09:28:17', '1', '2015-12-04 14:25:06', null, '1', '1', '2015-12-02', null, 'rrgfterg', '2', 'product:sellingtool#4', null, null);
INSERT INTO `sys_channel_strategy` VALUES ('2215520224935974', null, null, '101.00', '0', null, null, '0', '1', '0', '0', '0', '1', '2015-12-02 11:09:15', null, null, null, null, '1', null, null, null, '0', '直销渠道数据字典', '0', null);
INSERT INTO `sys_channel_strategy` VALUES ('2215520224935975', null, null, '101.00', '0', null, null, '0', '1', '0', '0', '0', '1', '2015-12-02 11:55:46', null, null, null, null, '1', null, null, null, '0', '直销渠道数据字典', '0', null);
INSERT INTO `sys_channel_strategy` VALUES ('2215520224935976', null, null, '101.00', '0', null, null, '0', '1', '0', '0', '0', '1', '2015-12-02 14:17:14', null, null, null, null, '1', null, null, null, '0', '直销渠道数据字典', '0', null);
INSERT INTO `sys_channel_strategy` VALUES ('2215520224935977', null, null, '102.00', '0', null, null, '0', '1', '0', '0', '0', '1', '2015-12-02 14:20:02', null, null, null, null, '1', null, null, null, '0', '直销渠道数据字典', '0', null);
INSERT INTO `sys_channel_strategy` VALUES ('2215520224935978', null, null, '1.00', '0', null, null, '0', '1', '0', '0', '0', '1', '2015-12-02 14:49:44', null, null, null, null, '1', null, null, null, '0', '直销渠道数据字典', '0', null);
INSERT INTO `sys_channel_strategy` VALUES ('2215520224935979', null, null, '103.00', '0', null, null, '0', '1', '0', '0', '0', '1', '2015-12-02 14:56:09', null, '2015-12-03 11:24:44', '1', null, '1', null, null, null, '3', '直销渠道数据字典', '0', null);
INSERT INTO `sys_channel_strategy` VALUES ('2215520224935980', '测试1202', '之前卡在产品上，这是第一次测政策', '123.00', '12', '2015-12-02', '2015-12-31', '12', '1', '1', '2', '5,6,1,4,2,7,3', '1', '2015-12-02 15:13:00', '1', '2015-12-04 14:25:06', null, '1', '1', '2015-12-02', null, '法人', '2', 'product:sellingtool#4', null, null);
INSERT INTO `sys_channel_strategy` VALUES ('2215520224935981', null, null, '1.00', '0', null, null, '0', '1', '0', '0', '0', '1', '2015-12-02 17:09:45', null, '2015-12-03 11:00:12', null, null, '1', null, null, null, '0', '直销渠道数据字典', '0', null);
INSERT INTO `sys_channel_strategy` VALUES ('2215520224935982', null, null, '1.00', '0', null, null, '0', '1', '0', '0', '0', '1', '2015-12-02 17:24:27', null, '2015-12-03 11:00:12', null, null, '1', null, null, null, '0', '直销渠道数据字典', '0', null);
INSERT INTO `sys_channel_strategy` VALUES ('2215520224935983', null, null, '1.00', '0', null, null, '0', '1', '0', '0', '0', '1', '2015-12-02 18:27:32', null, '2015-12-03 11:00:12', null, null, '1', null, null, null, '0', '直销渠道数据字典', '0', null);
INSERT INTO `sys_channel_strategy` VALUES ('2215520224935984', null, null, '101.00', '0', null, null, '0', '1', '0', '0', '0', '1', '2015-12-03 09:50:59', null, '2015-12-03 11:00:12', null, null, '1', null, null, null, '0', '直销渠道数据字典', '0', null);
INSERT INTO `sys_channel_strategy` VALUES ('2215520224935985', '测试能否添加渠道', '测试能否添加渠道 备注', '123.00', '1', '2015-12-03', '2015-12-31', '1', '1', '1', '2', '1,5,3,7,6,4,2', '1', '2015-12-03 11:01:00', '1', '2015-12-04 14:25:06', null, '1', '1', null, null, null, '3', 'product:sellingtool#1,product:sellingtool#2,product:sellingtool#3', null, null);
INSERT INTO `sys_channel_strategy` VALUES ('2215520224935986', '分销查看测试', '请问轻轻额外', '123.00', '1', '2015-12-03', '2015-12-31', '1', '1', '1', '1', '3,6,1,2,5,7,4', '1', '2015-12-03 11:07:26', '1', '2015-12-04 14:25:06', null, '2', '1', null, null, null, '3', '直销渠道数据字典', null, null);
INSERT INTO `sys_channel_strategy` VALUES ('2215520224935987', null, null, '0.00', '0', null, null, '0', '1', '0', '0', '0', '1', '2015-12-03 11:44:37', '1', '2015-12-04 14:25:06', null, '1', '1', null, null, null, '3', '直销渠道数据字典', null, null);
INSERT INTO `sys_channel_strategy` VALUES ('2215520224935988', 'ewq', 'ewq', '1233.00', '1', '2015-12-03', '2015-12-31', '12', '1', '1', '2', '4,1,6,7,5,3,2', '1', '2015-12-03 20:52:12', '1', '2015-12-04 14:25:06', '1', '1', '1', null, null, null, '3', 'product:sellingtool#4', null, null);
INSERT INTO `sys_channel_strategy` VALUES ('2215520224935990', null, null, '1.00', '0', null, null, '0', '1', '0', '0', '0', '1', '2015-12-03 21:27:56', null, null, null, null, '1', null, null, null, '0', '直销渠道数据字典', null, null);
INSERT INTO `sys_channel_strategy` VALUES ('2215520224935991', null, null, '0.00', '0', null, null, '0', '1', '0', '0', '0', '1', '2015-12-04 09:55:21', null, null, null, null, '1', null, null, null, '0', '直销渠道数据字典', null, null);
INSERT INTO `sys_channel_strategy` VALUES ('2215520224935992', '杨发测试政策', '大', '90.00', '1', '2015-12-04', '2015-12-31', '12', '1', '1', '2', '4,6,7,3,5,2,1', '1', '2015-12-04 10:18:35', '1', '2015-12-04 14:25:06', null, '1', '1', '2015-12-04', null, 'edre#@#@#$', '2', 'product:sellingtool#4', null, null);
INSERT INTO `sys_channel_strategy` VALUES ('2215520224935993', '杨发测试政策123456', '秦莞尔推哦', '100.00', '1', '2015-12-04', '2015-12-31', '12', '1', '1', '2', '2,1,4,3,6,7,5', '1', '2015-12-04 10:22:42', '1', '2015-12-04 14:25:06', null, '1', '1', '2015-12-04', null, 'edre#@#@#$', '2', 'product:sellingtool#4', null, null);
INSERT INTO `sys_channel_strategy` VALUES ('2215520224935994', '321321', '321', '100.00', '1', '2015-12-04', '2016-02-29', '12', '1', '1', '2', '6,4,1,2,3,7,5', '1', '2015-12-04 10:30:33', '1', '2015-12-04 14:25:06', null, '1', '1', '2015-12-04', null, 'edre#@#@#$', '2', 'product:sellingtool#4', null, null);
INSERT INTO `sys_channel_strategy` VALUES ('2215520224935995', null, null, '1.00', '0', null, null, '0', '1', '0', '0', '0', '1', '2015-12-04 11:03:59', null, null, null, null, '1', null, null, null, '0', '直销渠道数据字典', null, null);
INSERT INTO `sys_channel_strategy` VALUES ('2215520224935996', null, null, '0.00', '0', null, null, '0', '1', '0', '0', '0', '1', '2015-12-04 11:04:00', null, null, null, null, '1', null, null, null, '0', '直销渠道数据字典', null, null);
INSERT INTO `sys_channel_strategy` VALUES ('2215520224935997', null, null, '0.00', '0', null, null, '0', '1', '0', '0', '0', '1', '2015-12-04 11:04:00', null, null, null, null, '1', null, null, null, '0', '直销渠道数据字典', null, null);
INSERT INTO `sys_channel_strategy` VALUES ('2215520224935998', null, null, '1.00', '0', null, null, '0', '1', '0', '0', '0', '1', '2015-12-04 11:25:21', null, null, null, null, '1', null, null, null, '0', '直销渠道数据字典', null, null);
INSERT INTO `sys_channel_strategy` VALUES ('2215520224935999', 'WUHUI', 'WUHUI', '11.00', '1', '2015-12-16', '2015-12-31', '1', '1', '111', '2', '3,2,6,1,7,5,4', '1', '2015-12-04 13:37:00', '1', '2015-12-04 14:25:06', null, '1', '1', null, null, null, '3', 'product:sellingtool#4', null, null);
INSERT INTO `sys_channel_strategy` VALUES ('2215520224936000', '1', '1', '11.00', '1', '2015-12-04', '2015-12-24', '1', '1', '1', '2', '4,5,2,1,6,3,7', '1', '2015-12-04 13:38:14', '1', '2015-12-04 14:25:06', null, '2', '1', null, null, null, '3', '直销渠道数据字典', null, null);
INSERT INTO `sys_channel_strategy` VALUES ('2215520224936001', '笔', '笔', '12.00', '1', '2015-12-04', '2015-12-31', '0', '1', '1', '2', '3,2,1,7,6,4,5', '1', '2015-12-04 13:38:32', '1', '2015-12-04 14:25:06', '1', '1', '1', '2015-12-04', null, 'edre#@#@#$', '2', 'product:sellingtool#4', null, null);
INSERT INTO `sys_channel_strategy` VALUES ('2215520224936002', '我去额我去', '而我却', '1233.00', '1', '2015-12-04', '2016-01-10', '12', '1', '1', '2', '2,1,4,6,3,7,5', '1', '2015-12-04 13:39:50', '1', '2015-12-04 14:25:06', null, '1', '1', '2015-12-04', null, 'edre#@#@#$', '2', 'product:sellingtool#4', null, null);
INSERT INTO `sys_channel_strategy` VALUES ('2215520224936003', '测试政策', '测试政策', '23.00', '1', '2015-12-04', '2016-01-10', '23', '1', '1', '2', '7,4,2,6,1,5,3', '1', '2015-12-04 14:12:06', '1', '2015-12-04 17:45:47', null, '1', '1', '2015-12-04', null, '晚归问', '2', 'product:sellingtool#4', null, null);
INSERT INTO `sys_channel_strategy` VALUES ('2215520224936004', 'DSA', '打算', '34.00', '1', '2015-12-04', '2016-01-10', '23', '1', '1', '2', '3,2,5,7,4,6,1', '0', '2015-12-04 14:45:21', '1', null, null, '1', '1', null, null, null, '3', 'product:sellingtool#4', null, null);
INSERT INTO `sys_channel_strategy` VALUES ('2215520224936005', null, null, '0.00', '0', null, null, '0', '1', '0', '0', '0', '1', '2015-12-04 22:53:06', null, null, null, null, '1', null, null, null, '0', '直销渠道数据字典', null, null);
INSERT INTO `sys_channel_strategy` VALUES ('2215520224936006', null, null, '0.00', '0', null, null, '0', '1', '0', '0', '0', '1', '2015-12-04 22:53:19', null, null, null, null, '1', null, null, null, '0', '直销渠道数据字典', null, null);
INSERT INTO `sys_channel_strategy` VALUES ('2215520224936007', 'yan04', '44', '22.00', '1', '2015-12-04', '2015-12-31', '0', '1', '1', '2', '5,2,7,6,4,3,1', '0', '2015-12-04 15:21:40', '1', null, null, '1', '1', null, null, null, '3', 'product:sellingtool#4', null, null);
INSERT INTO `sys_channel_strategy` VALUES ('2215520224936008', null, null, '99999.00', '0', null, null, '0', '1', '0', '0', '0', '1', '2015-12-04 23:24:55', null, null, null, null, '1', null, null, null, '0', '直销渠道数据字典', null, null);
INSERT INTO `sys_channel_strategy` VALUES ('2215520224936009', '专题摘要', '专题摘要阿斯达', '123.00', '1', '2015-12-04', '2015-12-31', '1', '1', '1', '2', '1,5,2,3,7,6,4', '0', '2015-12-04 15:51:27', '1', null, null, '2', '1', null, null, null, '3', '直销渠道数据字典', null, null);
INSERT INTO `sys_channel_strategy` VALUES ('2215520224936010', null, null, '1.00', '0', null, null, '0', '1', '0', '0', '0', '1', '2015-12-04 16:57:55', null, null, null, null, '1', null, null, null, '0', '直销渠道数据字典', null, null);
INSERT INTO `sys_channel_strategy` VALUES ('2215520224936011', '测试001', '测试001', '20.00', '1', '2015-12-04', '2016-01-02', '0', '1', '0', '2', '1,3,7,5,6,4,2', '0', '2015-12-04 17:30:53', '1', '2015-12-04 17:32:08', null, '2', '1', '2015-12-04', null, '晚归问', '2', '直销渠道数据字典', null, null);
INSERT INTO `sys_channel_strategy` VALUES ('2215520224936012', '直销1204', '直销1204', '25.00', '1', '2015-12-04', '2016-02-07', '0', '1', '1', '2', '4,3,7,6,5,1,2', '0', '2015-12-04 17:39:01', '1', '2015-12-04 17:38:09', null, '1', '1', '2015-12-04', null, '晚归问', '2', 'product:sellingtool#4', null, null);
INSERT INTO `sys_channel_strategy` VALUES ('2215520224936013', '分销政策1204', '第三代', '25.00', '1', '2015-12-04', '2016-02-07', '0', '1', '1', '2', '5,2,1,7,4,3,6', '0', '2015-12-04 17:42:53', '1', '2015-12-04 17:42:03', null, '2', '1', '2015-12-04', null, '晚归问', '2', '直销渠道数据字典', null, null);
INSERT INTO `sys_channel_strategy` VALUES ('2215520224936014', '给魔方政策', '52儿童', '30.00', '2', '2015-12-04', '2016-01-16', '2', '1', '1', '2', '7,4,2,5,6,3,1', '1', '2015-12-04 17:43:24', '1', '2015-12-04 17:44:32', '1', '2', '1', null, null, null, '3', '直销渠道数据字典', null, null);
INSERT INTO `sys_channel_strategy` VALUES ('2215520224936015', '张晶', '张晶', '111.00', '0', '2015-12-04', '2016-01-01', '0', '1', '1', '2', '4,1,6,2,7,3,5', '0', '2015-12-04 17:48:04', '1', '2015-12-04 17:48:42', null, '2', '1', '2015-12-04', null, '晚归问', '2', '直销渠道数据字典', null, null);
INSERT INTO `sys_channel_strategy` VALUES ('2215520224936016', null, null, '0.00', '0', null, null, '0', '1', '0', '0', '0', '1', '2015-12-05 02:14:59', null, null, null, null, '1', null, null, null, '0', '直销渠道数据字典', null, null);
INSERT INTO `sys_channel_strategy` VALUES ('2215520224936017', '直销1815', '朋', '41.00', '1', '2015-12-04', '2015-12-23', '0', '1', '1', '2', '5,7,4,6,3,1,2', '0', '2015-12-04 18:16:23', '1', '2015-12-04 18:16:08', null, '1', '1', '2015-12-04', null, '晚归问', '2', 'product:sellingtool#4', null, null);
INSERT INTO `sys_channel_strategy` VALUES ('2215520224936018', '直销1821', '朋', '50.00', '1', '2015-12-04', '2015-12-30', '0', '1', '1', '2', '6,4,1,3,7,5,2', '0', '2015-12-04 18:22:17', '1', '2015-12-04 18:21:40', null, '1', '1', '2015-12-04', null, '晚归问', '2', 'product:sellingtool#4', null, null);
INSERT INTO `sys_channel_strategy` VALUES ('2215520224936019', null, null, '100.00', '0', null, null, '0', '1', '0', '0', '0', '1', '2015-12-04 18:26:17', null, null, null, null, '1', null, null, null, '0', '直销渠道数据字典', null, null);
INSERT INTO `sys_channel_strategy` VALUES ('2215520224936020', null, null, '100.00', '0', null, null, '0', '1', '0', '0', '0', '1', '2015-12-04 18:26:38', null, null, null, null, '1', null, null, null, '0', '直销渠道数据字典', null, null);
INSERT INTO `sys_channel_strategy` VALUES ('2215520224936021', null, null, '40.00', '0', null, null, '0', '1', '0', '0', '0', '1', '2015-12-05 02:26:38', null, null, null, null, '1', null, null, null, '0', '直销渠道数据字典', null, null);
INSERT INTO `sys_channel_strategy` VALUES ('2215520224936022', 'yan1044', 'yan1044', '55.00', '1', '2015-12-05', '2015-12-31', '0', '1', '1', '2', '3,6,7,5,1,2,4', '0', '2015-12-05 10:44:51', '1', '2015-12-05 10:44:26', null, '2', '1', '2015-12-05', null, '晚归问', '2', '直销渠道数据字典', null, null);
INSERT INTO `sys_channel_strategy` VALUES ('2215520224936023', 'zxp分销政策', 'zxp分销政策备注', '20.00', '1', '2015-12-05', '2015-12-29', '0', '1', '1', '2', '3,5,6,4,7,1,2', '0', '2015-12-05 11:17:12', '1', '2015-12-05 11:16:23', null, '2', '1', '2015-12-05', null, '晚归问', '2', '直销渠道数据字典', null, null);
INSERT INTO `sys_channel_strategy` VALUES ('2215520224936024', '新增产品全是yf测试景区', '凑合着测吧 发现最严重的问题', '500.00', '1', '2015-12-05', '2016-01-01', '0', '1', '1', '2', '2,5,3,6,1,7,4', '0', '2015-12-05 11:50:05', '1', '2015-12-05 11:49:20', null, '2', '1', '2015-12-05', null, '晚归问', '2', '直销渠道数据字典', null, null);
INSERT INTO `sys_channel_strategy` VALUES ('2215520224936025', 'zxp线下出票测试', 'zxp线下出票测试备注', '555.00', '1', '2015-12-05', '2016-02-01', '0', '1', '1', '2', '3,5,6,7,4,1,2', '0', '2015-12-05 12:01:44', '1', '2015-12-05 14:30:35', null, '1', '1', '2015-12-05', null, '晚归问', '2', 'product:sellingtool#4', null, null);
INSERT INTO `sys_channel_strategy` VALUES ('2215520224936026', '1357', '1357', '50.00', '1', '2015-12-05', '2015-12-31', '0', '1', '1', '2', '4,2,6,7,1,5,3', '0', '2015-12-05 13:58:17', '1', '2015-12-05 13:57:29', null, '2', '1', '2015-12-05', null, '晚归问', '2', '直销渠道数据字典', null, null);
INSERT INTO `sys_channel_strategy` VALUES ('2215520224936027', '23', '23', '80.00', '1', '2015-12-05', '2015-12-31', '0', '1', '1', '2', '2,7,1,5,6,4,3', '0', '2015-12-05 14:11:16', '1', '2015-12-05 14:18:11', null, '1', '1', '2015-12-05', null, '晚归问', '2', 'product:sellingtool#4', null, null);
INSERT INTO `sys_channel_strategy` VALUES ('2215520224936028', '测试update3', '2', '1.00', '1', '2015-12-05', '2015-12-05', '0', '1', '1', '1', '1', '2', '2015-12-05 15:03:36', '测试', '2015-12-05 15:11:35', null, '1', '1', null, null, null, '0', '直销渠道数据字典', null, null);
INSERT INTO `sys_channel_strategy` VALUES ('2215520224936029', '测试update3', '2', '1.00', '1', '2015-12-05', '2015-12-05', '0', '1', '1', '1', '1', '0', '2015-12-05 15:03:36', '测试', '2015-12-05 15:11:35', null, '1', '0', null, null, null, '0', '直销渠道数据字典', null, null);
INSERT INTO `sys_channel_strategy` VALUES ('2215520224936030', '56', '55', '33.00', '1', '2015-12-05', '2015-12-31', '0', '1', '1', '2', '1,2,5,7,3,6,4', '0', '2015-12-05 15:18:51', '2215520224936277', '2015-12-05 15:17:55', null, '1', '1', '2015-12-05', null, '晚归问', '2', 'product:sellingtool#4', null, null);
INSERT INTO `sys_channel_strategy` VALUES ('2215520224936031', 'yan12', 'dd', '62.00', '1', '2015-12-05', '2015-12-31', '0', '1', '1', '2', '3,1,7,6,5,4,2', '0', '2015-12-05 16:40:40', '1', null, null, '1', '1', null, null, null, '3', 'product:sellingtool#4', null, null);
INSERT INTO `sys_channel_strategy` VALUES ('2215520224936032', 'yan12', 'dd', '62.00', '1', '2015-12-05', '2015-12-31', '0', '1', '1', '2', '3,1,7,6,5,4,2', '0', '2015-12-05 16:40:41', '1', null, null, '1', '1', null, null, null, '3', 'product:sellingtool#4', null, null);
INSERT INTO `sys_channel_strategy` VALUES ('2215520224936033', 'yan12', 'dd', '62.00', '1', '2015-12-05', '2015-12-31', '0', '1', '1', '2', '3,1,7,6,5,4,2', '0', '2015-12-05 16:40:41', '1', null, null, '1', '1', null, null, null, '3', 'product:sellingtool#4', null, null);
INSERT INTO `sys_channel_strategy` VALUES ('2215520224936034', 'yan12', 'dd', '62.00', '1', '2015-12-05', '2015-12-31', '0', '1', '1', '2', '3,1,7,6,5,4,2', '0', '2015-12-05 16:40:41', '1', null, null, '1', '1', null, null, null, '3', 'product:sellingtool#4', null, null);
INSERT INTO `sys_channel_strategy` VALUES ('2215520224936035', 'yan12', 'dd', '62.00', '1', '2015-12-05', '2015-12-31', '0', '1', '1', '2', '3,1,7,6,5,4,2', '0', '2015-12-05 16:40:52', '1', '2015-12-05 16:45:16', null, '1', '1', '2015-12-05', null, '晚归问', '1', 'product:sellingtool#4', null, null);
INSERT INTO `sys_channel_strategy` VALUES ('2215520224936036', 'yan12', 'dd', '62.00', '1', '2015-12-05', '2015-12-31', '0', '1', '1', '2', '3,1,7,6,5,4,2', '0', '2015-12-05 16:41:02', '1', null, null, '1', '1', null, null, null, '3', 'product:sellingtool#4', null, null);
INSERT INTO `sys_channel_strategy` VALUES ('2215520224936037', 'yan12', 'dd', '62.00', '1', '2015-12-05', '2015-12-31', '0', '1', '1', '2', '3,1,7,6,5,4,2', '0', '2015-12-05 16:41:19', '1', null, null, '1', '1', null, null, null, '3', 'product:sellingtool#4', null, null);
INSERT INTO `sys_channel_strategy` VALUES ('2215520224936038', 'yan12', 'dd', '62.00', '1', '2015-12-05', '2015-12-31', '0', '1', '1', '2', '3,1,7,6,5,4,2', '0', '2015-12-05 16:42:26', '1', '2015-12-05 16:45:54', null, '1', '1', '2015-12-05', null, '晚归问', '2', 'product:sellingtool#4', null, null);
INSERT INTO `sys_channel_strategy` VALUES ('2215520224936039', '123123', '123123', '123.00', '1', '2015-12-31', '2015-12-31', '1', '1', '1', '1', '4,5,3,6,7,1,2', '0', '2015-12-05 16:54:31', '1', null, null, '1', '1', null, null, null, '3', 'product:sellingtool#4', null, null);
INSERT INTO `sys_channel_strategy` VALUES ('2215520224936040', '123123', '123123', '123.00', '1', '2015-12-31', '2015-12-31', '1', '1', '1', '1', '4,5,3,6,7,1,2', '0', '2015-12-05 16:55:25', '1', null, null, '1', '1', null, null, null, '3', 'product:sellingtool#4', null, null);
INSERT INTO `sys_channel_strategy` VALUES ('2215520224936041', null, null, '99.00', '1', '2015-12-05', '2015-12-31', '0', '1', '1', '2', '4,7,1,6,3,2,5', '0', '2015-12-05 17:02:47', '1', null, null, '1', '1', null, null, null, '3', 'product:sellingtool#4', null, null);
INSERT INTO `sys_channel_strategy` VALUES ('2215520224936042', null, null, '99.00', '1', '2015-12-05', '2015-12-31', '0', '1', '1', '2', '4,7,1,6,3,2,5', '0', '2015-12-05 17:02:51', '1', null, null, '1', '1', null, null, null, '3', 'product:sellingtool#4', null, null);
INSERT INTO `sys_channel_strategy` VALUES ('2215520224936043', null, null, '99.00', '1', '2015-12-05', '2015-12-31', '0', '1', '1', '2', '4,7,1,6,3,2,5', '0', '2015-12-05 17:02:52', '1', null, null, '1', '1', null, null, null, '3', 'product:sellingtool#4', null, null);
INSERT INTO `sys_channel_strategy` VALUES ('2215520224936044', null, null, '99.00', '1', '2015-12-05', '2015-12-31', '0', '1', '1', '2', '4,7,1,6,3,2,5', '0', '2015-12-05 17:02:52', '1', null, null, '1', '1', null, null, null, '3', 'product:sellingtool#4', null, null);
INSERT INTO `sys_channel_strategy` VALUES ('2215520224936045', null, null, '99.00', '1', '2015-12-05', '2015-12-31', '0', '1', '1', '2', '4,7,1,6,3,2,5', '0', '2015-12-05 17:02:53', '1', null, null, '1', '1', null, null, null, '3', 'product:sellingtool#4', null, null);
INSERT INTO `sys_channel_strategy` VALUES ('2215520224936046', null, null, '99.00', '1', '2015-12-05', '2015-12-31', '0', '1', '1', '2', '4,7,1,6,3,2,5', '0', '2015-12-05 17:02:53', '1', null, null, '1', '1', null, null, null, '3', 'product:sellingtool#4', null, null);
INSERT INTO `sys_channel_strategy` VALUES ('2215520224936047', null, null, '99.00', '1', '2015-12-05', '2015-12-31', '0', '1', '1', '2', '4,7,1,6,3,2,5', '0', '2015-12-05 17:02:53', '1', null, null, '1', '1', null, null, null, '3', 'product:sellingtool#4', null, null);
INSERT INTO `sys_channel_strategy` VALUES ('2215520224936048', '33', '22', '99.00', '1', '2015-12-05', '2015-12-31', '0', '1', '1', '2', '4,7,1,6,3,2,5', '0', '2015-12-05 17:03:03', '1', null, null, '1', '1', null, null, null, '3', 'product:sellingtool#4', null, null);
INSERT INTO `sys_channel_strategy` VALUES ('2215520224936049', '33', '22', '99.00', '1', '2015-12-05', '2015-12-31', '0', '1', '1', '2', '4,7,1,6,3,2,5', '0', '2015-12-05 17:03:04', '1', null, null, '1', '1', null, null, null, '3', 'product:sellingtool#4', null, null);
INSERT INTO `sys_channel_strategy` VALUES ('2215520224936050', '121333', '123', '123.00', '123', '2015-12-05', '2015-12-31', '123', '1', '1', '2', '7,5,6,1,4,2,3', '0', '2015-12-05 17:13:39', '1', null, null, '1', '1', null, null, null, '3', 'product:sellingtool#4', null, null);
INSERT INTO `sys_channel_strategy` VALUES ('2215520224936051', '张翔鹏测试线下团票', '张翔鹏测试线下团票', '666.00', '1', '2015-12-05', '2016-03-18', '0', '1', '1', '2', '5,7,1,2,3,6,4', '0', '2015-12-05 18:04:02', '1', '2015-12-06 13:25:50', '1', '2', '1', '2015-12-06', null, '晚归问', '2', '直销渠道数据字典', null, null);
INSERT INTO `sys_channel_strategy` VALUES ('2215520224936052', '杨发1206', '杨发1206', '78.00', '1', '2015-12-06', '2016-01-10', '0', '1', '1', '2', '4,1,3,7,2,6,5', '0', '2015-12-06 13:40:13', '1', '2015-12-06 13:39:22', null, '1', '1', '2015-12-06', null, '晚归问', '2', 'product:sellingtool#4', null, null);
INSERT INTO `sys_channel_strategy` VALUES ('2215520224936053', '杨发1206分销', '的撒打算', '78.00', '1', '2015-12-06', '2016-01-10', '0', '1', '1', '2', '2,5,7,4,6,1,3', '0', '2015-12-06 13:41:31', '1', '2015-12-06 13:40:30', null, '2', '1', '2015-12-06', null, '晚归问', '2', '直销渠道数据字典', null, null);
INSERT INTO `sys_channel_strategy` VALUES ('2215520224936054', 'WW1206', 'WW1206', '150.00', '1', '2015-12-06', '2015-12-24', '12', '1', '0', '1', '1,2,3,5,4,7,6', '0', '2015-12-06 14:07:38', '1', '2015-12-06 14:07:11', null, '2', '1', '2015-12-06', null, '晚归问', '2', '直销渠道数据字典', null, null);
INSERT INTO `sys_channel_strategy` VALUES ('2215520224936055', '1553', '1553', '101.00', '1', '2015-12-06', '2015-12-31', '0', '1', '1', '2', '4,7,1,2,5,3,6', '0', '2015-12-06 15:53:54', '1', '2015-12-06 15:53:09', null, '1', '1', '2015-12-06', null, '晚归问', '2', 'product:sellingtool#4', null, null);
INSERT INTO `sys_channel_strategy` VALUES ('2215520224936056', '张翔鹏测试政策团票', '张翔鹏测试政策团票11', '123.00', '1', '2015-12-06', '2016-02-11', '0', '1', '1', '2', '2,7,6,3,1,4,5', '0', '2015-12-06 20:26:12', '1', '2015-12-06 20:25:21', null, '2', '1', '2015-12-06', null, '合计北', '2', '直销渠道数据字典', null, null);
INSERT INTO `sys_channel_strategy` VALUES ('2215520224936057', '天然羊肉汤', '请问企鹅王', '123.00', '1', '2015-12-06', '2015-12-31', '0', '1', '1', '2', '6,2,5,3,1,7,4', '0', '2015-12-06 20:31:04', '1', '2015-12-06 20:30:01', null, '2', '1', '2015-12-06', null, '合计北', '2', '直销渠道数据字典', null, null);

-- ----------------------------
-- Table structure for `sys_extra_rebate_strategy`
-- ----------------------------
DROP TABLE IF EXISTS `sys_extra_rebate_strategy`;
CREATE TABLE `sys_extra_rebate_strategy` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `rebate_object` varchar(10) DEFAULT NULL COMMENT '返利对象(总社H、地接部门D、优先部门DH、导游G)',
  `rebate_cycle` varchar(10) DEFAULT NULL COMMENT '返利周期(YEAR/MONTH/WEEK/DAY/CURRENT)',
  `rebate_amount` double DEFAULT '0' COMMENT '返利金额(每人)',
  `rebate_type` int(11) DEFAULT '2' COMMENT '返利形式(0为现金返利，1为按票返利，2返利积分)',
  `status` int(11) DEFAULT '1' COMMENT '规则状态（1：启动、 0 ：禁用   2: 删除）参照GlobalParam.FLAG',
  `integral_id` bigint(20) DEFAULT NULL COMMENT '积分类型ID',
  `integral_value` int(11) DEFAULT '0' COMMENT '返利积分数量',
  `front_rebate_rule_id` bigint(20) DEFAULT NULL COMMENT '前置返利规则ID',
  `front_product_id` bigint(20) DEFAULT NULL COMMENT '前置产品ID',
  `validity_period` int(11) DEFAULT NULL COMMENT '时效（单位：小时）',
  `create_by` varchar(64) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT NULL COMMENT '更新人',
  `updata_date` datetime DEFAULT NULL COMMENT '更新时间',
  `p_version` varchar(45) DEFAULT NULL COMMENT '数据来源',
  `validity_type` int(11) DEFAULT NULL COMMENT '时效类型：0小时，1天<对比后加>',
  `extra_rebate_name` varchar(255) DEFAULT NULL COMMENT '加点返利名称<对比后加>',
  `rebate_status` int(11) DEFAULT '0' COMMENT '0:有效，1：无效<对比后加>',
  `supplier_id` bigint(20) DEFAULT NULL COMMENT '创建供应商',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2215520224935940 DEFAULT CHARSET=utf8 COMMENT='加点返利规则表渠道';

-- ----------------------------
-- Records of sys_extra_rebate_strategy
-- ----------------------------
INSERT INTO `sys_extra_rebate_strategy` VALUES ('2215520224935937', 'ffffaaaa', 'cccc', '0', '0', '0', '0', '0', '2215520224935952', '0', '0', 'ext', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '', null, null, '0', null);
INSERT INTO `sys_extra_rebate_strategy` VALUES ('2215520224935938', 'ffffqqqqq', 'cccc', '0', '0', '0', '0', '0', '2215520224935952', '0', '0', 'ext', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '', null, null, '0', null);
INSERT INTO `sys_extra_rebate_strategy` VALUES ('2215520224935939', '111', '111', '0', '0', '1', '0', '0', '2215520224936068', '1', '1', 'ex', '2015-12-05 14:52:52', '', '0000-00-00 00:00:00', '', null, null, '0', '0');

-- ----------------------------
-- Table structure for `sys_label`
-- ----------------------------
DROP TABLE IF EXISTS `sys_label`;
CREATE TABLE `sys_label` (
  `id` bigint(20) NOT NULL,
  `name` varchar(100) DEFAULT NULL COMMENT '标签名称',
  `pid` bigint(20) DEFAULT '0' COMMENT '父id，0表示标签分类',
  `create_date` datetime DEFAULT NULL,
  `flag` char(1) NOT NULL COMMENT '使用状态1启用0禁用2删除3已生成联票4未生成联票',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `update_date` datetime DEFAULT NULL,
  `update_by` varchar(100) DEFAULT NULL,
  `create_by` varchar(100) DEFAULT NULL,
  `remarks` varchar(45) DEFAULT NULL,
  `data_source` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='渠道标签表';

-- ----------------------------
-- Records of sys_label
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_label_relation`
-- ----------------------------
DROP TABLE IF EXISTS `sys_label_relation`;
CREATE TABLE `sys_label_relation` (
  `id` bigint(20) NOT NULL,
  `obj_id` bigint(20) DEFAULT NULL COMMENT '主对象id',
  `rel_id` bigint(20) DEFAULT NULL COMMENT '关联对象id',
  `rel_type` varchar(20) DEFAULT NULL COMMENT '对象关联标签类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='渠道关系表';

-- ----------------------------
-- Records of sys_label_relation
-- ----------------------------
INSERT INTO `sys_label_relation` VALUES ('2215520224935991', '2215520224935946', '2215520224936014', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224935992', '2215520224935946', '2215520224936171', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224935993', '2215520224935946', '2215520224936174', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224935994', '2215520224935946', '2215520224936176', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224935995', '2215520224935946', '2215520224936177', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224935996', '2215520224935951', '2215520224935997', 'strategyProduct');
INSERT INTO `sys_label_relation` VALUES ('2215520224936009', '2215520224935956', '2215520224935997', 'strategyProduct');
INSERT INTO `sys_label_relation` VALUES ('2215520224936010', '2215520224935956', '2215520224935946', 'strategyChannel');
INSERT INTO `sys_label_relation` VALUES ('2215520224936011', '2215520224935956', '2215520224935998', 'strategyChannel');
INSERT INTO `sys_label_relation` VALUES ('2215520224936012', '2215520224935956', '2215520224935965', 'strategyRebate');
INSERT INTO `sys_label_relation` VALUES ('2215520224936013', '2215520224935956', '2215520224935966', 'strategyRebate');
INSERT INTO `sys_label_relation` VALUES ('2215520224936014', '2215520224935957', '2215520224935993', 'strategyProduct');
INSERT INTO `sys_label_relation` VALUES ('2215520224936015', '2215520224935958', '2215520224935998', 'strategyProduct');
INSERT INTO `sys_label_relation` VALUES ('2215520224936016', '2215520224935959', '2215520224935998', 'strategyProduct');
INSERT INTO `sys_label_relation` VALUES ('2215520224936017', '2215520224935946', '2215520224936180', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936018', '2215520224935946', '2215520224936181', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936019', '2215520224935946', '2215520224936182', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936020', '2215520224935946', '2215520224936183', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936021', '2215520224935946', '2215520224936184', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936022', '2215520224935946', '2215520224936185', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936023', '2215520224935946', '2215520224936186', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936024', '2215520224935946', '2215520224936187', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936025', '2215520224935946', '2215520224936188', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936026', '2215520224935946', '2215520224936189', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936027', '2215520224935946', '2215520224936190', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936028', '2215520224935946', '2215520224936191', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936029', '2215520224935946', '2215520224936192', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936030', '2215520224935946', '2215520224936193', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936031', '2215520224935946', '2215520224936194', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936032', '2215520224935946', '2215520224936195', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936033', '2215520224935946', '2215520224936196', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936034', '2215520224935946', '2215520224936197', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936035', '2215520224935946', '2215520224936198', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936036', '2215520224935946', '2215520224936199', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936037', '2215520224935946', '2215520224936200', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936038', '2215520224935946', '2215520224936201', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936039', '2215520224935946', '2215520224936202', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936040', '2215520224935946', '2215520224936203', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936041', '2215520224935946', '2215520224936204', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936042', '2215520224935946', '2215520224936205', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936043', '2215520224935946', '2215520224936206', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936044', '2215520224935946', '2215520224936207', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936045', '2215520224935946', '2215520224936208', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936046', '2215520224935946', '2215520224936209', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936047', '2215520224935946', '2215520224936210', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936048', '2215520224935946', '2215520224936211', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936049', '2215520224935946', '2215520224936212', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936050', '2215520224935946', '2215520224936213', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936051', '2215520224935946', '2215520224936214', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936052', '2215520224935946', '2215520224936215', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936053', '2215520224935946', '2215520224936216', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936054', '2215520224935946', '2215520224936217', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936055', '2215520224935946', '2215520224936218', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936056', '2215520224935946', '2215520224936219', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936057', '2215520224935946', '2215520224936220', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936058', '2215520224935946', '2215520224936221', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936059', '2215520224935946', '2215520224936222', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936060', '2215520224935946', '2215520224936223', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936061', '2215520224935946', '2215520224936224', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936062', '2215520224935946', '2215520224936225', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936063', '2215520224935946', '2215520224936226', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936064', '2215520224935946', '2215520224936227', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936065', '2215520224935946', '2215520224936228', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936066', '2215520224935946', '2215520224936229', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936067', '2215520224935946', '2215520224936230', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936068', '2215520224935946', '2215520224936231', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936069', '2215520224935946', '2215520224936232', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936070', '2215520224935946', '2215520224936233', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936071', '2215520224935946', '2215520224936234', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936072', '2215520224935946', '2215520224936235', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936073', '2215520224935946', '2215520224936236', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936074', '2215520224935946', '2215520224936237', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936075', '2215520224935946', '2215520224936238', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936076', '2215520224935946', '2215520224936239', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936077', '2215520224935946', '2215520224936240', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936078', '2215520224935946', '2215520224936241', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936079', '2215520224935946', '2215520224936242', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936080', '2215520224935946', '2215520224936243', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936081', '2215520224935946', '2215520224936244', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936082', '2215520224935946', '2215520224936245', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936083', '2215520224935946', '2215520224936246', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936084', '2215520224935946', '2215520224936247', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936085', '2215520224935946', '2215520224936248', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936086', '2215520224935946', '2215520224936249', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936087', '2215520224935946', '2215520224936250', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936088', '2215520224935946', '2215520224936251', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936089', '2215520224935946', '2215520224936252', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936090', '2215520224935946', '2215520224936253', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936091', '2215520224935946', '2215520224936254', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936092', '2215520224935946', '2215520224936255', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936093', '2215520224935946', '2215520224936256', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936094', '2215520224935946', '2215520224936257', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936095', '2215520224935946', '2215520224936258', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936096', '2215520224935946', '2215520224936259', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936097', '1', '2215520224936260', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936098', '2215520224935946', '2215520224936261', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936099', '2215520224935946', '2215520224936262', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936100', '2215520224935946', '2215520224936263', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936101', '2215520224935946', '2215520224936264', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936102', '2215520224935946', '2215520224936265', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936103', '2215520224935946', '2215520224936266', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936104', '2215520224935946', '2215520224936267', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936105', '2215520224935946', '2215520224936268', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936106', '2215520224935946', '2215520224936269', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936107', '2215520224935946', '2215520224936270', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936108', '2215520224935946', '2215520224936271', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936109', '2215520224935946', '2215520224936272', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936110', '2215520224935946', '2215520224936273', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936111', '2215520224935946', '2215520224936274', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936112', '2215520224935946', '2215520224936275', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936113', '2215520224935946', '2215520224936276', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936116', '2215520224935961', '2215520224935985', 'strategyProduct');
INSERT INTO `sys_label_relation` VALUES ('2215520224936117', '2215520224935961', '1', 'strategyChannel');
INSERT INTO `sys_label_relation` VALUES ('2215520224936118', '2215520224935961', '2215520224935946', 'strategyChannel');
INSERT INTO `sys_label_relation` VALUES ('2215520224936119', '2215520224935961', '2215520224935967', 'strategyRebate');
INSERT INTO `sys_label_relation` VALUES ('2215520224936120', '2215520224935961', '2215520224935968', 'strategyRebate');
INSERT INTO `sys_label_relation` VALUES ('2215520224936121', '2215520224935962', '2215520224935985', 'strategyProduct');
INSERT INTO `sys_label_relation` VALUES ('2215520224936122', '2215520224935962', '1', 'strategyChannel');
INSERT INTO `sys_label_relation` VALUES ('2215520224936123', '2215520224935962', '2215520224935946', 'strategyChannel');
INSERT INTO `sys_label_relation` VALUES ('2215520224936124', '2215520224935962', '2215520224935969', 'strategyRebate');
INSERT INTO `sys_label_relation` VALUES ('2215520224936125', '2215520224935962', '2215520224935970', 'strategyRebate');
INSERT INTO `sys_label_relation` VALUES ('2215520224936126', '2215520224935963', '2215520224935985', 'strategyProduct');
INSERT INTO `sys_label_relation` VALUES ('2215520224936127', '2215520224935963', '1', 'strategyChannel');
INSERT INTO `sys_label_relation` VALUES ('2215520224936128', '2215520224935963', '2215520224935946', 'strategyChannel');
INSERT INTO `sys_label_relation` VALUES ('2215520224936129', '2215520224935963', '2215520224935971', 'strategyRebate');
INSERT INTO `sys_label_relation` VALUES ('2215520224936130', '2215520224935963', '2215520224935972', 'strategyRebate');
INSERT INTO `sys_label_relation` VALUES ('2215520224936131', '2215520224935964', '2215520224935985', 'strategyProduct');
INSERT INTO `sys_label_relation` VALUES ('2215520224936132', '2215520224935964', '1', 'strategyChannel');
INSERT INTO `sys_label_relation` VALUES ('2215520224936133', '2215520224935964', '2215520224935946', 'strategyChannel');
INSERT INTO `sys_label_relation` VALUES ('2215520224936134', '2215520224935964', '2215520224935976', 'strategyRebate');
INSERT INTO `sys_label_relation` VALUES ('2215520224936135', '2215520224935964', '2215520224935977', 'strategyRebate');
INSERT INTO `sys_label_relation` VALUES ('2215520224936136', '2215520224935965', '2215520224936000', 'strategyProduct');
INSERT INTO `sys_label_relation` VALUES ('2215520224936137', '2215520224935965', '1', 'strategyChannel');
INSERT INTO `sys_label_relation` VALUES ('2215520224936138', '2215520224935965', '2215520224935946', 'strategyChannel');
INSERT INTO `sys_label_relation` VALUES ('2215520224936139', '2215520224935965', '2215520224935978', 'strategyRebate');
INSERT INTO `sys_label_relation` VALUES ('2215520224936140', '2215520224935965', '2215520224935979', 'strategyRebate');
INSERT INTO `sys_label_relation` VALUES ('2215520224936141', '2215520224935966', '2215520224935985', 'strategyProduct');
INSERT INTO `sys_label_relation` VALUES ('2215520224936142', '2215520224935966', '1', 'strategyChannel');
INSERT INTO `sys_label_relation` VALUES ('2215520224936143', '2215520224935966', '2215520224935946', 'strategyChannel');
INSERT INTO `sys_label_relation` VALUES ('2215520224936144', '2215520224935966', '2215520224935980', 'strategyRebate');
INSERT INTO `sys_label_relation` VALUES ('2215520224936145', '2215520224935966', '2215520224935981', 'strategyRebate');
INSERT INTO `sys_label_relation` VALUES ('2215520224936146', '2215520224935967', '2215520224935985', 'strategyProduct');
INSERT INTO `sys_label_relation` VALUES ('2215520224936147', '2215520224935967', '1', 'strategyChannel');
INSERT INTO `sys_label_relation` VALUES ('2215520224936148', '2215520224935967', '2215520224935946', 'strategyChannel');
INSERT INTO `sys_label_relation` VALUES ('2215520224936151', '2215520224935967', '2215520224935984', 'strategyRebate');
INSERT INTO `sys_label_relation` VALUES ('2215520224936152', '2215520224935967', '2215520224935985', 'strategyRebate');
INSERT INTO `sys_label_relation` VALUES ('2215520224936153', '2215520224935968', '2215520224935993', 'strategyProduct');
INSERT INTO `sys_label_relation` VALUES ('2215520224936154', '2215520224935969', '2215520224935993', 'strategyProduct');
INSERT INTO `sys_label_relation` VALUES ('2215520224936155', '2215520224935970', '2215520224935993', 'strategyProduct');
INSERT INTO `sys_label_relation` VALUES ('2215520224936156', '2215520224935971', '2215520224935993', 'strategyProduct');
INSERT INTO `sys_label_relation` VALUES ('2215520224936157', '2215520224935947', '2215520224936292', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936158', '2215520224935953', '2215520224936320', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936159', '2215520224935952', '2215520224936324', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936160', '2215520224935952', '2215520224936331', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936161', '2215520224935952', '2215520224936332', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936162', '2215520224935952', '2215520224936337', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936163', '2215520224935958', '2215520224936327', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936164', '2215520224935958', '2215520224936355', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936165', '2215520224935972', '2215520224936026', 'strategyProduct');
INSERT INTO `sys_label_relation` VALUES ('2215520224936166', '2215520224935972', '2215520224935996', 'strategyChannel');
INSERT INTO `sys_label_relation` VALUES ('2215520224936167', '2215520224935972', '2215520224935986', 'strategyRebate');
INSERT INTO `sys_label_relation` VALUES ('2215520224936168', '2215520224935996', '2215520224936357', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936169', '2215520224935973', '2215520224936028', 'strategyProduct');
INSERT INTO `sys_label_relation` VALUES ('2215520224936170', '2215520224935974', '2215520224935952', 'strategyChannel');
INSERT INTO `sys_label_relation` VALUES ('2215520224936171', '2215520224935974', '2215520224935987', 'strategyRebate');
INSERT INTO `sys_label_relation` VALUES ('2215520224936172', '2215520224935975', '2215520224935952', 'strategyChannel');
INSERT INTO `sys_label_relation` VALUES ('2215520224936173', '2215520224935975', '2215520224935988', 'strategyRebate');
INSERT INTO `sys_label_relation` VALUES ('2215520224936174', '2215520224935976', '2215520224935952', 'strategyChannel');
INSERT INTO `sys_label_relation` VALUES ('2215520224936175', '2215520224935976', '2215520224935989', 'strategyRebate');
INSERT INTO `sys_label_relation` VALUES ('2215520224936176', '2215520224935977', '2215520224935952', 'strategyChannel');
INSERT INTO `sys_label_relation` VALUES ('2215520224936177', '2215520224935977', '2215520224935990', 'strategyRebate');
INSERT INTO `sys_label_relation` VALUES ('2215520224936178', '2215520224935978', '2215520224935991', 'strategyRebate');
INSERT INTO `sys_label_relation` VALUES ('2215520224936179', '2215520224935979', '2215520224935986', 'strategyProduct');
INSERT INTO `sys_label_relation` VALUES ('2215520224936180', '2215520224935979', '2215520224935952', 'strategyChannel');
INSERT INTO `sys_label_relation` VALUES ('2215520224936181', '2215520224935979', '2215520224935992', 'strategyRebate');
INSERT INTO `sys_label_relation` VALUES ('2215520224936182', '2215520224935980', '2215520224935993', 'strategyProduct');
INSERT INTO `sys_label_relation` VALUES ('2215520224936183', '2215520224935981', '2215520224935987', 'strategyProduct');
INSERT INTO `sys_label_relation` VALUES ('2215520224936184', '2215520224935981', '2215520224935993', 'strategyRebate');
INSERT INTO `sys_label_relation` VALUES ('2215520224936185', '2215520224935982', '2215520224935988', 'strategyProduct');
INSERT INTO `sys_label_relation` VALUES ('2215520224936186', '2215520224935982', '2215520224935994', 'strategyRebate');
INSERT INTO `sys_label_relation` VALUES ('2215520224936187', '2215520224935983', '2215520224936001', 'strategyProduct');
INSERT INTO `sys_label_relation` VALUES ('2215520224936188', '2215520224935983', '2215520224935995', 'strategyRebate');
INSERT INTO `sys_label_relation` VALUES ('2215520224936189', '1', '2215520224936369', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936190', '1', '2215520224936370', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936191', '2215520224935984', '2215520224936006', 'strategyProduct');
INSERT INTO `sys_label_relation` VALUES ('2215520224936192', '2215520224935984', '2215520224935952', 'strategyChannel');
INSERT INTO `sys_label_relation` VALUES ('2215520224936193', '2215520224935984', '2215520224935996', 'strategyRebate');
INSERT INTO `sys_label_relation` VALUES ('2215520224936196', '2215520224935985', '2215520224935994', 'strategyProduct');
INSERT INTO `sys_label_relation` VALUES ('2215520224936197', '2215520224935986', '2215520224935985', 'strategyProduct');
INSERT INTO `sys_label_relation` VALUES ('2215520224936198', '2215520224935986', '1', 'strategyChannel');
INSERT INTO `sys_label_relation` VALUES ('2215520224936199', '2215520224935986', '2215520224935946', 'strategyChannel');
INSERT INTO `sys_label_relation` VALUES ('2215520224936200', '2215520224935986', '2215520224935997', 'strategyRebate');
INSERT INTO `sys_label_relation` VALUES ('2215520224936201', '2215520224936022', '2215520224936371', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936202', '2215520224936014', '2215520224936361', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936203', '2215520224935987', '2215520224935993', 'strategyProduct');
INSERT INTO `sys_label_relation` VALUES ('2215520224936206', '2215520224935996', '2215520224936362', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936209', '2215520224936013', '2215520224936359', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936210', '2215520224936012', '2215520224936410', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936212', '2215520224936019', '2215520224935992', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936213', '2215520224936004', '2215520224936425', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936214', '2215520224935988', '2215520224935993', 'strategyProduct');
INSERT INTO `sys_label_relation` VALUES ('2215520224936217', '2215520224935990', '2215520224935991', 'strategyProduct');
INSERT INTO `sys_label_relation` VALUES ('2215520224936218', '2215520224935990', '2215520224936022', 'strategyChannel');
INSERT INTO `sys_label_relation` VALUES ('2215520224936219', '2215520224935990', '2215520224936001', 'strategyRebate');
INSERT INTO `sys_label_relation` VALUES ('2215520224936220', '2215520224935990', '2215520224936002', 'strategyRebate');
INSERT INTO `sys_label_relation` VALUES ('2215520224936221', '2215520224935990', '2215520224936003', 'strategyRebate');
INSERT INTO `sys_label_relation` VALUES ('2215520224936222', '2215520224935991', '2215520224935991', 'strategyProduct');
INSERT INTO `sys_label_relation` VALUES ('2215520224936223', '2215520224935991', '2215520224936022', 'strategyChannel');
INSERT INTO `sys_label_relation` VALUES ('2215520224936224', '2215520224935991', '2215520224936004', 'strategyRebate');
INSERT INTO `sys_label_relation` VALUES ('2215520224936225', '2215520224935991', '2215520224936005', 'strategyRebate');
INSERT INTO `sys_label_relation` VALUES ('2215520224936226', '2215520224935991', '2215520224936006', 'strategyRebate');
INSERT INTO `sys_label_relation` VALUES ('2215520224936227', '2215520224935992', '2215520224936064', 'strategyProduct');
INSERT INTO `sys_label_relation` VALUES ('2215520224936228', '2215520224935993', '2215520224936070', 'strategyProduct');
INSERT INTO `sys_label_relation` VALUES ('2215520224936229', '2215520224935994', '2215520224936070', 'strategyProduct');
INSERT INTO `sys_label_relation` VALUES ('2215520224936231', '2215520224935995', '2215520224935991', 'strategyProduct');
INSERT INTO `sys_label_relation` VALUES ('2215520224936232', '2215520224935995', '2215520224936022', 'strategyChannel');
INSERT INTO `sys_label_relation` VALUES ('2215520224936233', '2215520224935995', '2215520224936007', 'strategyRebate');
INSERT INTO `sys_label_relation` VALUES ('2215520224936234', '2215520224935995', '2215520224936008', 'strategyRebate');
INSERT INTO `sys_label_relation` VALUES ('2215520224936235', '2215520224935995', '2215520224936009', 'strategyRebate');
INSERT INTO `sys_label_relation` VALUES ('2215520224936236', '2215520224935995', '2215520224936010', 'strategyRebate');
INSERT INTO `sys_label_relation` VALUES ('2215520224936237', '2215520224935995', '2215520224936011', 'strategyRebate');
INSERT INTO `sys_label_relation` VALUES ('2215520224936238', '2215520224935995', '2215520224936012', 'strategyRebate');
INSERT INTO `sys_label_relation` VALUES ('2215520224936239', '2215520224935995', '2215520224936013', 'strategyRebate');
INSERT INTO `sys_label_relation` VALUES ('2215520224936240', '2215520224935995', '2215520224936014', 'strategyRebate');
INSERT INTO `sys_label_relation` VALUES ('2215520224936241', '2215520224935995', '2215520224936015', 'strategyRebate');
INSERT INTO `sys_label_relation` VALUES ('2215520224936242', '2215520224935996', '2215520224935991', 'strategyProduct');
INSERT INTO `sys_label_relation` VALUES ('2215520224936243', '2215520224935996', '2215520224936022', 'strategyChannel');
INSERT INTO `sys_label_relation` VALUES ('2215520224936244', '2215520224935996', '2215520224936016', 'strategyRebate');
INSERT INTO `sys_label_relation` VALUES ('2215520224936245', '2215520224935996', '2215520224936017', 'strategyRebate');
INSERT INTO `sys_label_relation` VALUES ('2215520224936246', '2215520224935996', '2215520224936018', 'strategyRebate');
INSERT INTO `sys_label_relation` VALUES ('2215520224936247', '2215520224935996', '2215520224936019', 'strategyRebate');
INSERT INTO `sys_label_relation` VALUES ('2215520224936248', '2215520224935996', '2215520224936020', 'strategyRebate');
INSERT INTO `sys_label_relation` VALUES ('2215520224936249', '2215520224935996', '2215520224936021', 'strategyRebate');
INSERT INTO `sys_label_relation` VALUES ('2215520224936250', '2215520224935996', '2215520224936022', 'strategyRebate');
INSERT INTO `sys_label_relation` VALUES ('2215520224936251', '2215520224935996', '2215520224936023', 'strategyRebate');
INSERT INTO `sys_label_relation` VALUES ('2215520224936252', '2215520224935996', '2215520224936024', 'strategyRebate');
INSERT INTO `sys_label_relation` VALUES ('2215520224936253', '2215520224935997', '2215520224935991', 'strategyProduct');
INSERT INTO `sys_label_relation` VALUES ('2215520224936254', '2215520224935997', '2215520224936022', 'strategyChannel');
INSERT INTO `sys_label_relation` VALUES ('2215520224936255', '2215520224935997', '2215520224936025', 'strategyRebate');
INSERT INTO `sys_label_relation` VALUES ('2215520224936256', '2215520224935997', '2215520224936026', 'strategyRebate');
INSERT INTO `sys_label_relation` VALUES ('2215520224936257', '2215520224935997', '2215520224936027', 'strategyRebate');
INSERT INTO `sys_label_relation` VALUES ('2215520224936258', '2215520224935997', '2215520224936028', 'strategyRebate');
INSERT INTO `sys_label_relation` VALUES ('2215520224936259', '2215520224935997', '2215520224936029', 'strategyRebate');
INSERT INTO `sys_label_relation` VALUES ('2215520224936260', '2215520224935997', '2215520224936030', 'strategyRebate');
INSERT INTO `sys_label_relation` VALUES ('2215520224936261', '2215520224935997', '2215520224936031', 'strategyRebate');
INSERT INTO `sys_label_relation` VALUES ('2215520224936262', '2215520224935997', '2215520224936032', 'strategyRebate');
INSERT INTO `sys_label_relation` VALUES ('2215520224936263', '2215520224935997', '2215520224936033', 'strategyRebate');
INSERT INTO `sys_label_relation` VALUES ('2215520224936264', '2215520224935998', '2215520224935995', 'strategyProduct');
INSERT INTO `sys_label_relation` VALUES ('2215520224936265', '2215520224935998', '2215520224936011', 'strategyChannel');
INSERT INTO `sys_label_relation` VALUES ('2215520224936266', '2215520224935998', '2215520224936034', 'strategyRebate');
INSERT INTO `sys_label_relation` VALUES ('2215520224936267', '2215520224935999', '2215520224935993', 'strategyProduct');
INSERT INTO `sys_label_relation` VALUES ('2215520224936268', '2215520224936000', '2215520224935985', 'strategyProduct');
INSERT INTO `sys_label_relation` VALUES ('2215520224936269', '2215520224936000', '1', 'strategyChannel');
INSERT INTO `sys_label_relation` VALUES ('2215520224936270', '2215520224936000', '2215520224936035', 'strategyRebate');
INSERT INTO `sys_label_relation` VALUES ('2215520224936271', '2215520224936001', '2215520224936075', 'strategyProduct');
INSERT INTO `sys_label_relation` VALUES ('2215520224936272', '2215520224936002', '2215520224936075', 'strategyProduct');
INSERT INTO `sys_label_relation` VALUES ('2215520224936273', '2215520224936003', '2215520224936081', 'strategyProduct');
INSERT INTO `sys_label_relation` VALUES ('2215520224936274', '2215520224936004', '2215520224936081', 'strategyProduct');
INSERT INTO `sys_label_relation` VALUES ('2215520224936275', '2215520224936005', '2215520224936071', 'strategyProduct');
INSERT INTO `sys_label_relation` VALUES ('2215520224936276', '2215520224936005', '2215520224936066', 'strategyChannel');
INSERT INTO `sys_label_relation` VALUES ('2215520224936277', '2215520224936005', '2215520224936036', 'strategyRebate');
INSERT INTO `sys_label_relation` VALUES ('2215520224936278', '2215520224936005', '2215520224936037', 'strategyRebate');
INSERT INTO `sys_label_relation` VALUES ('2215520224936279', '2215520224936005', '2215520224936038', 'strategyRebate');
INSERT INTO `sys_label_relation` VALUES ('2215520224936280', '2215520224936006', '2215520224936071', 'strategyProduct');
INSERT INTO `sys_label_relation` VALUES ('2215520224936281', '2215520224936006', '2215520224936066', 'strategyChannel');
INSERT INTO `sys_label_relation` VALUES ('2215520224936282', '2215520224936006', '2215520224936039', 'strategyRebate');
INSERT INTO `sys_label_relation` VALUES ('2215520224936283', '2215520224936006', '2215520224936040', 'strategyRebate');
INSERT INTO `sys_label_relation` VALUES ('2215520224936284', '2215520224936006', '2215520224936041', 'strategyRebate');
INSERT INTO `sys_label_relation` VALUES ('2215520224936286', '2215520224935995', '2215520224936354', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936289', '2215520224936071', '2215520224936349', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936290', '2215520224936007', '2215520224935997', 'strategyProduct');
INSERT INTO `sys_label_relation` VALUES ('2215520224936291', '2215520224936008', '2215520224936002', 'strategyProduct');
INSERT INTO `sys_label_relation` VALUES ('2215520224936292', '2215520224936008', '2215520224936042', 'strategyRebate');
INSERT INTO `sys_label_relation` VALUES ('2215520224936294', '2215520224936022', '2215520224936478', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936295', '2215520224936022', '2215520224936481', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936296', '2215520224936009', '2215520224936093', 'strategyProduct');
INSERT INTO `sys_label_relation` VALUES ('2215520224936297', '2215520224936009', '1', 'strategyChannel');
INSERT INTO `sys_label_relation` VALUES ('2215520224936298', '2215520224936009', '2215520224936043', 'strategyRebate');
INSERT INTO `sys_label_relation` VALUES ('2215520224936299', '1', '2215520224936484', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936300', '2215520224936022', '2215520224936485', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936301', '2215520224936022', '2215520224936487', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936302', '1', '2215520224936495', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936303', '2215520224936022', '2215520224936500', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936304', '2215520224936010', '2215520224936049', 'strategyProduct');
INSERT INTO `sys_label_relation` VALUES ('2215520224936305', '2215520224936010', '2215520224936066', 'strategyChannel');
INSERT INTO `sys_label_relation` VALUES ('2215520224936306', '2215520224936010', '2215520224936044', 'strategyRebate');
INSERT INTO `sys_label_relation` VALUES ('2215520224936307', '2215520224936010', '2215520224936045', 'strategyRebate');
INSERT INTO `sys_label_relation` VALUES ('2215520224936308', '2215520224936010', '2215520224936046', 'strategyRebate');
INSERT INTO `sys_label_relation` VALUES ('2215520224936309', '2215520224936058', '2215520224936483', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936310', '1', '2215520224936511', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936311', '2215520224936011', '2215520224935985', 'strategyProduct');
INSERT INTO `sys_label_relation` VALUES ('2215520224936312', '2215520224936011', '1', 'strategyChannel');
INSERT INTO `sys_label_relation` VALUES ('2215520224936313', '2215520224936011', '2215520224936047', 'strategyRebate');
INSERT INTO `sys_label_relation` VALUES ('2215520224936314', '2215520224935982', '2215520224936458', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936315', '2215520224936012', '2215520224936170', 'strategyProduct');
INSERT INTO `sys_label_relation` VALUES ('2215520224936316', '2215520224936013', '2215520224936168', 'strategyProduct');
INSERT INTO `sys_label_relation` VALUES ('2215520224936317', '2215520224936013', '2215520224936022', 'strategyChannel');
INSERT INTO `sys_label_relation` VALUES ('2215520224936318', '2215520224936013', '2215520224936048', 'strategyRebate');
INSERT INTO `sys_label_relation` VALUES ('2215520224936319', '2215520224936014', '2215520224936094', 'strategyProduct');
INSERT INTO `sys_label_relation` VALUES ('2215520224936320', '2215520224936014', '1', 'strategyChannel');
INSERT INTO `sys_label_relation` VALUES ('2215520224936323', '2215520224936014', '2215520224936051', 'strategyRebate');
INSERT INTO `sys_label_relation` VALUES ('2215520224936324', '2215520224936014', '2215520224936052', 'strategyRebate');
INSERT INTO `sys_label_relation` VALUES ('2215520224936325', '2215520224936014', '2215520224936303', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936327', '2215520224936015', '2215520224935986', 'strategyProduct');
INSERT INTO `sys_label_relation` VALUES ('2215520224936328', '2215520224936015', '1', 'strategyChannel');
INSERT INTO `sys_label_relation` VALUES ('2215520224936329', '2215520224936015', '2215520224936053', 'strategyRebate');
INSERT INTO `sys_label_relation` VALUES ('2215520224936331', '2215520224936070', '2215520224936512', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936332', '2215520224936016', '2215520224935990', 'strategyProduct');
INSERT INTO `sys_label_relation` VALUES ('2215520224936333', '2215520224936016', '2215520224936054', 'strategyRebate');
INSERT INTO `sys_label_relation` VALUES ('2215520224936334', '2215520224936016', '2215520224936055', 'strategyRebate');
INSERT INTO `sys_label_relation` VALUES ('2215520224936335', '2215520224936016', '2215520224936056', 'strategyRebate');
INSERT INTO `sys_label_relation` VALUES ('2215520224936336', '2215520224936017', '2215520224936172', 'strategyProduct');
INSERT INTO `sys_label_relation` VALUES ('2215520224936337', '2215520224936018', '2215520224936172', 'strategyProduct');
INSERT INTO `sys_label_relation` VALUES ('2215520224936338', '2215520224936019', '2215520224935992', 'strategyProduct');
INSERT INTO `sys_label_relation` VALUES ('2215520224936339', '2215520224936019', '2215520224936057', 'strategyRebate');
INSERT INTO `sys_label_relation` VALUES ('2215520224936340', '2215520224936019', '2215520224936058', 'strategyRebate');
INSERT INTO `sys_label_relation` VALUES ('2215520224936341', '2215520224936019', '2215520224936059', 'strategyRebate');
INSERT INTO `sys_label_relation` VALUES ('2215520224936342', '2215520224936020', '2215520224935989', 'strategyProduct');
INSERT INTO `sys_label_relation` VALUES ('2215520224936343', '2215520224936020', '2215520224936060', 'strategyRebate');
INSERT INTO `sys_label_relation` VALUES ('2215520224936344', '2215520224936020', '2215520224936061', 'strategyRebate');
INSERT INTO `sys_label_relation` VALUES ('2215520224936345', '2215520224936020', '2215520224936062', 'strategyRebate');
INSERT INTO `sys_label_relation` VALUES ('2215520224936346', '2215520224936021', '2215520224936004', 'strategyProduct');
INSERT INTO `sys_label_relation` VALUES ('2215520224936347', '2215520224936021', '2215520224936063', 'strategyRebate');
INSERT INTO `sys_label_relation` VALUES ('2215520224936348', '2215520224936022', '2215520224936173', 'strategyProduct');
INSERT INTO `sys_label_relation` VALUES ('2215520224936349', '2215520224936022', '2215520224936022', 'strategyChannel');
INSERT INTO `sys_label_relation` VALUES ('2215520224936350', '2215520224936022', '2215520224936064', 'strategyRebate');
INSERT INTO `sys_label_relation` VALUES ('2215520224936351', '2215520224936023', '2215520224936176', 'strategyProduct');
INSERT INTO `sys_label_relation` VALUES ('2215520224936352', '2215520224936023', '2215520224936091', 'strategyChannel');
INSERT INTO `sys_label_relation` VALUES ('2215520224936353', '2215520224936023', '2215520224936065', 'strategyRebate');
INSERT INTO `sys_label_relation` VALUES ('2215520224936354', '2215520224936024', '2215520224936181', 'strategyProduct');
INSERT INTO `sys_label_relation` VALUES ('2215520224936355', '2215520224936024', '2215520224936098', 'strategyChannel');
INSERT INTO `sys_label_relation` VALUES ('2215520224936356', '2215520224936024', '2215520224936066', 'strategyRebate');
INSERT INTO `sys_label_relation` VALUES ('2215520224936358', '2215520224936025', '2215520224936182', 'strategyProduct');
INSERT INTO `sys_label_relation` VALUES ('2215520224936359', '2215520224936026', '2215520224936184', 'strategyProduct');
INSERT INTO `sys_label_relation` VALUES ('2215520224936360', '2215520224936026', '2215520224936022', 'strategyChannel');
INSERT INTO `sys_label_relation` VALUES ('2215520224936361', '2215520224936026', '2215520224936067', 'strategyRebate');
INSERT INTO `sys_label_relation` VALUES ('2215520224936362', '2215520224936027', '2215520224936185', 'strategyProduct');
INSERT INTO `sys_label_relation` VALUES ('2215520224936363', '2215520224936028', '517', 'strategyChannel');
INSERT INTO `sys_label_relation` VALUES ('2215520224936364', '2215520224936029', '1', 'strategyProduct');
INSERT INTO `sys_label_relation` VALUES ('2215520224936366', '2215520224936029', '2215520224936068', 'strategyRebate');
INSERT INTO `sys_label_relation` VALUES ('2215520224936367', '2215520224936029', '2215520224936100', 'strategyChannel');
INSERT INTO `sys_label_relation` VALUES ('2215520224936368', '2215520224936030', '2215520224936192', 'strategyProduct');
INSERT INTO `sys_label_relation` VALUES ('2215520224936369', '2215520224936031', '2215520224936197', 'strategyProduct');
INSERT INTO `sys_label_relation` VALUES ('2215520224936370', '2215520224936032', '2215520224936197', 'strategyProduct');
INSERT INTO `sys_label_relation` VALUES ('2215520224936371', '2215520224936033', '2215520224936197', 'strategyProduct');
INSERT INTO `sys_label_relation` VALUES ('2215520224936372', '2215520224936034', '2215520224936197', 'strategyProduct');
INSERT INTO `sys_label_relation` VALUES ('2215520224936373', '2215520224936035', '2215520224936197', 'strategyProduct');
INSERT INTO `sys_label_relation` VALUES ('2215520224936374', '2215520224936036', '2215520224936197', 'strategyProduct');
INSERT INTO `sys_label_relation` VALUES ('2215520224936375', '2215520224936037', '2215520224936197', 'strategyProduct');
INSERT INTO `sys_label_relation` VALUES ('2215520224936376', '2215520224936038', '2215520224936197', 'strategyProduct');
INSERT INTO `sys_label_relation` VALUES ('2215520224936377', '2215520224936039', '2215520224935993', 'strategyProduct');
INSERT INTO `sys_label_relation` VALUES ('2215520224936378', '2215520224936040', '2215520224935993', 'strategyProduct');
INSERT INTO `sys_label_relation` VALUES ('2215520224936379', '2215520224936041', '2215520224936198', 'strategyProduct');
INSERT INTO `sys_label_relation` VALUES ('2215520224936380', '2215520224936042', '2215520224936198', 'strategyProduct');
INSERT INTO `sys_label_relation` VALUES ('2215520224936381', '2215520224936043', '2215520224936198', 'strategyProduct');
INSERT INTO `sys_label_relation` VALUES ('2215520224936382', '2215520224936044', '2215520224936198', 'strategyProduct');
INSERT INTO `sys_label_relation` VALUES ('2215520224936383', '2215520224936045', '2215520224936198', 'strategyProduct');
INSERT INTO `sys_label_relation` VALUES ('2215520224936384', '2215520224936046', '2215520224936198', 'strategyProduct');
INSERT INTO `sys_label_relation` VALUES ('2215520224936385', '2215520224936047', '2215520224936198', 'strategyProduct');
INSERT INTO `sys_label_relation` VALUES ('2215520224936386', '2215520224936048', '2215520224936198', 'strategyProduct');
INSERT INTO `sys_label_relation` VALUES ('2215520224936387', '2215520224936049', '2215520224936198', 'strategyProduct');
INSERT INTO `sys_label_relation` VALUES ('2215520224936388', '2215520224936050', '2215520224935993', 'strategyProduct');
INSERT INTO `sys_label_relation` VALUES ('2215520224936389', '1', '2215520224936520', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936390', '2215520224936022', '2215520224936521', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936391', '516', '79', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936392', '517', '79', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936393', '516', '80', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936394', '517', '80', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936395', '516', '47', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936396', '517', '47', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936397', '2215520224936051', '2215520224936199', 'strategyProduct');
INSERT INTO `sys_label_relation` VALUES ('2215520224936398', '2215520224936051', '2215520224936091', 'strategyChannel');
INSERT INTO `sys_label_relation` VALUES ('2215520224936402', '2215520224936051', '2215520224936070', 'strategyRebate');
INSERT INTO `sys_label_relation` VALUES ('2215520224936403', '2215520224936052', '2215520224936202', 'strategyProduct');
INSERT INTO `sys_label_relation` VALUES ('2215520224936404', '2215520224936053', '2215520224936201', 'strategyProduct');
INSERT INTO `sys_label_relation` VALUES ('2215520224936405', '2215520224936053', '2215520224936022', 'strategyChannel');
INSERT INTO `sys_label_relation` VALUES ('2215520224936406', '2215520224936053', '2215520224936071', 'strategyRebate');
INSERT INTO `sys_label_relation` VALUES ('2215520224936407', '2215520224936054', '2215520224936204', 'strategyProduct');
INSERT INTO `sys_label_relation` VALUES ('2215520224936408', '2215520224936054', '2215520224936103', 'strategyChannel');
INSERT INTO `sys_label_relation` VALUES ('2215520224936409', '2215520224936054', '2215520224936072', 'strategyRebate');
INSERT INTO `sys_label_relation` VALUES ('2215520224936411', '1', '2215520224936525', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936412', '2215520224936055', '2215520224936209', 'strategyProduct');
INSERT INTO `sys_label_relation` VALUES ('2215520224936413', '2215520224935952', '2215520224936427', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936414', '2215520224935952', '2215520224936436', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936415', '2215520224936091', '2215520224936477', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936416', '1', '2215520224936529', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936417', '2215520224936102', '2215520224936530', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936418', '2215520224936102', '2215520224936531', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936419', '2215520224936102', '2215520224936532', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936420', '2215520224936102', '2215520224936533', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936421', '2215520224936102', '2215520224936534', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936422', '2215520224936102', '2215520224936535', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936423', '2215520224936102', '2215520224936536', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936424', '2215520224936102', '2215520224936537', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936425', '2215520224936102', '2215520224936538', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936426', '1', '2215520224936539', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936427', '2215520224936091', '2215520224936517', 'channelUser');
INSERT INTO `sys_label_relation` VALUES ('2215520224936428', '2215520224936056', '2215520224936212', 'strategyProduct');
INSERT INTO `sys_label_relation` VALUES ('2215520224936429', '2215520224936056', '2215520224936091', 'strategyChannel');
INSERT INTO `sys_label_relation` VALUES ('2215520224936430', '2215520224936056', '2215520224936073', 'strategyRebate');
INSERT INTO `sys_label_relation` VALUES ('2215520224936431', '2215520224936057', '2215520224936204', 'strategyProduct');
INSERT INTO `sys_label_relation` VALUES ('2215520224936432', '2215520224936057', '2215520224936091', 'strategyChannel');
INSERT INTO `sys_label_relation` VALUES ('2215520224936433', '2215520224936057', '2215520224936074', 'strategyRebate');
INSERT INTO `sys_label_relation` VALUES ('2215520224936434', '2215520224936517', '2215520224936213', 'strategyProduct');
INSERT INTO `sys_label_relation` VALUES ('2215520224936435', '2215520224936517', '2215520224936091', 'strategyChannel');
INSERT INTO `sys_label_relation` VALUES ('2215520224936437', '2215520224936517', '2215520224936076', 'strategyRebate');

-- ----------------------------
-- Table structure for `sys_log`
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log` (
  `id` bigint(20) NOT NULL COMMENT '编号',
  `type` char(1) DEFAULT '1' COMMENT '日志类型',
  `create_by` varchar(64) DEFAULT NULL COMMENT '创建者',
  `create_id` bigint(20) DEFAULT NULL COMMENT '创建者id',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `remote_addr` varchar(255) DEFAULT NULL COMMENT '操作IP地址',
  `user_agent` varchar(255) DEFAULT NULL COMMENT '用户代理',
  `request_uri` varchar(255) DEFAULT NULL COMMENT '请求URI',
  `method` varchar(5) DEFAULT NULL COMMENT '操作方式',
  `params` text COMMENT '操作提交的数据',
  `exception` text COMMENT '异常信息',
  `data_source` varchar(45) DEFAULT NULL COMMENT '系统来源',
  `position` varchar(100) DEFAULT NULL COMMENT '操作岗位',
  `telephone` varchar(32) DEFAULT NULL COMMENT '电话',
  `client` varchar(100) DEFAULT NULL COMMENT '操作客户端',
  PRIMARY KEY (`id`),
  KEY `sys_log_create_by` (`create_by`) USING BTREE,
  KEY `sys_log_request_uri` (`request_uri`) USING BTREE,
  KEY `sys_log_type` (`type`) USING BTREE,
  KEY `sys_log_create_date` (`create_date`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='日志表';

-- ----------------------------
-- Records of sys_log
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_menu`
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` bigint(20) NOT NULL COMMENT '编号',
  `parent_id` varchar(64) NOT NULL COMMENT '父级编号',
  `parent_ids` varchar(2000) NOT NULL COMMENT '所有父级编号',
  `name` varchar(100) NOT NULL COMMENT '菜单名称',
  `href` varchar(255) DEFAULT NULL COMMENT '链接',
  `target` varchar(20) DEFAULT NULL COMMENT '目标',
  `icon` varchar(100) DEFAULT NULL COMMENT '图标',
  `sort` int(11) NOT NULL COMMENT '排序（升序）',
  `is_show` char(1) NOT NULL COMMENT '是否在菜单中显示',
  `is_activiti` char(1) DEFAULT NULL COMMENT '是否同步工作流',
  `permission` varchar(200) DEFAULT NULL COMMENT '权限标识',
  `create_by` varchar(64) DEFAULT NULL COMMENT '创建者',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT NULL COMMENT '更新者',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  `del_flag` char(1) NOT NULL DEFAULT '0' COMMENT '删除标记1：删除',
  `position` varchar(255) DEFAULT NULL COMMENT '位置',
  `style` varchar(255) DEFAULT NULL COMMENT '样式',
  `data_source` varchar(45) DEFAULT NULL COMMENT '数据来源',
  PRIMARY KEY (`id`),
  KEY `sys_menu_parent_id` (`parent_id`) USING BTREE,
  KEY `sys_menu_del_flag` (`del_flag`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜单表';

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('0', '0', '0', '0', '', '0', '0', '0', '0', '0', '0', '0', '0000-00-00 00:00:00', '0', '0000-00-00 00:00:00', '0', '1', null, null, null);
INSERT INTO `sys_menu` VALUES ('2215520224936812', '0', '0', '财务中心', null, null, null, '6', '1', null, null, 'JQ', '2015-11-26 18:23:43', null, '2015-12-07 10:19:30', '数据初始化', '1', null, '&#xe619;', '数据初始化');
INSERT INTO `sys_menu` VALUES ('2215520224936813', '0', '0', '票务中心', '', null, '1', '1', '1', null, null, 'JQ', '2015-11-26 18:23:43', null, '2015-12-07 10:19:30', '数据初始化', '1', '1', '&#xe607;', '数据初始化');
INSERT INTO `sys_menu` VALUES ('2215520224936814', '0', '0', '订单中心', '', null, null, '2', '1', null, '1', 'JQ', '2015-11-26 18:23:43', null, '2015-12-07 10:19:30', '数据初始化', '1', null, '&#xe60c;', '数据初始化');
INSERT INTO `sys_menu` VALUES ('2215520224936815', '0', '0', '产品中心', '', null, null, '3', '1', null, null, 'JQ', '2015-11-26 18:23:43', null, '2015-12-07 10:19:30', '数据初始化', '1', null, '&#xe609;', '数据初始化');
INSERT INTO `sys_menu` VALUES ('2215520224936816', '0', '0', '渠道中心', '', '', '', '4', '1', '', '', 'JQ', '2015-11-26 18:23:43', '', '2015-12-07 10:19:30', '数据初始化', '1', '', '&#xe60e;', '数据初始化');
INSERT INTO `sys_menu` VALUES ('2215520224936817', '0', '0', '企业中心', '', '', '', '5', '1', '', '', 'JQ', '2015-11-26 18:23:43', '', '2015-12-07 10:19:30', '数据初始化', '1', '', '&#xe60b;', '数据初始化');
INSERT INTO `sys_menu` VALUES ('2215520224936818', '2215520224936813', '2215520224936813', '演艺票售票', '/ticket/seat/index', '', '', '1', '1', '', '', 'JQ', '2015-11-26 18:23:43', '', '2015-12-07 10:10:31', '数据初始化', '1', '', '', '数据初始化');
INSERT INTO `sys_menu` VALUES ('2215520224936819', '2215520224936813', '2215520224936813', '演艺预占座订单列表', '', '', '', '2', '1', '', '', 'JQ', '2015-11-26 18:23:43', '', '2015-12-07 10:19:30', '数据初始化', '1', '', '', '数据初始化');
INSERT INTO `sys_menu` VALUES ('2215520224936820', '2215520224936813', '2215520224936813', '门票售票', '/ticket/sale/index', '', '', '3', '1', '', '', 'JQ', '2015-11-26 18:23:43', '', '2015-12-07 10:16:42', '数据初始化', '1', '', '', '数据初始化');
INSERT INTO `sys_menu` VALUES ('2215520224936821', '2215520224936813', '2215520224936813', '积分票售票', '/integralTicket/sale/index', '', '', '4', '1', '', '', 'JQ', '2015-11-26 18:23:43', '', '2015-12-07 10:10:31', '数据初始化', '1', '', '', '数据初始化');
INSERT INTO `sys_menu` VALUES ('2215520224936822', '2215520224936813', '2215520224936813', '特价票出票', '/specialVoucher/specialVoucherTicketList', '', '', '5', '1', '', '', 'JQ', '2015-11-26 18:23:43', '', '2015-12-07 10:10:31', '数据初始化', '1', '', '', '数据初始化');
INSERT INTO `sys_menu` VALUES ('2215520224936823', '2215520224936813', '2215520224936813', '特价票凭证管理', '/specialVoucher/specialVoucherList', '', '', '6', '1', '', '', 'JQ', '2015-11-26 18:23:43', '', '2015-12-07 10:10:31', '数据初始化', '1', '', '', '数据初始化');
INSERT INTO `sys_menu` VALUES ('2215520224936824', '2215520224936813', '2215520224936813', '免票出票', '/freeVoucher/freeVoucherTicketList', '', '', '7', '1', '', '', 'JQ', '2015-11-26 18:23:43', '', '2015-12-07 10:10:31', '数据初始化', '1', '', '', '数据初始化');
INSERT INTO `sys_menu` VALUES ('2215520224936825', '2215520224936813', '2215520224936813', '免票凭证管理', '/freeVoucher/freeVoucherList', '', '', '8', '1', '', '', 'JQ', '2015-11-26 18:23:43', '', '2015-12-07 10:19:30', '数据初始化', '1', '', '', '数据初始化');
INSERT INTO `sys_menu` VALUES ('2215520224936826', '2215520224936813', '2215520224936813', '特种票模板列表', '/voucher/list', '', '', '9', '1', '', '', 'JQ', '2015-11-26 18:23:43', '', '2015-12-07 10:16:42', '数据初始化', '1', '', '', '数据初始化');
INSERT INTO `sys_menu` VALUES ('2215520224936827', '2215520224936813', '2215520224936813', '退票审核', '/ticket/refundList', '', '', '10', '1', '', '', 'JQ', '2015-11-26 18:23:43', '', '2015-12-07 10:10:31', '数据初始化', '1', '', '', '数据初始化');
INSERT INTO `sys_menu` VALUES ('2215520224936828', '2215520224936813', '2215520224936813', '我的退票审核结果', '/ticket/refundResultList', '', '', '11', '1', '', '', 'JQ', '2015-11-26 18:23:43', '', '2015-12-07 10:10:31', '数据初始化', '1', '', '', '数据初始化');
INSERT INTO `sys_menu` VALUES ('2215520224936829', '2215520224936814', '2215520224936814', '线下订单统计', '/orders/biz/selectOutLineOrdersList?is_online=0', '', '', '1', '1', '', '', 'JQ', '2015-11-26 18:23:43', '', '2015-12-07 10:19:30', '数据初始化', '1', '', '', '数据初始化');
INSERT INTO `sys_menu` VALUES ('2215520224936830', '2215520224936814', '2215520224936814', '我的线下订单统计', '/orders/biz/selectOutLineOrdersList?user=myList', '', '', '2', '1', '', '', 'JQ', '2015-11-26 18:23:43', '', '2015-12-07 10:10:31', '数据初始化', '1', '', '', '数据初始化');
INSERT INTO `sys_menu` VALUES ('2215520224936831', '2215520224936814', '2215520224936814', '线上订单统计', '/orders/biz/selectOutLineOrdersList?is_online=1', '', '', '3', '1', '', '', 'JQ', '2015-11-26 18:23:43', '', '2015-12-07 10:10:31', '数据初始化', '1', '', '', '数据初始化');
INSERT INTO `sys_menu` VALUES ('2215520224936832', '2215520224936814', '2215520224936814', '当日售票员统计', '', '', '', '4', '1', '', '', 'JQ', '2015-11-26 18:23:43', '', '2015-12-07 10:16:42', '数据初始化', '1', '', '', '数据初始化');
INSERT INTO `sys_menu` VALUES ('2215520224936833', '2215520224936815', '2215520224936815', '票型列表', '/product/ticketType/index', '', '', '1', '1', '', '', 'JQ', '2015-11-26 18:23:43', '', '2015-12-07 10:10:31', '数据初始化', '1', '', '', '数据初始化');
INSERT INTO `sys_menu` VALUES ('2215520224936834', '2215520224936815', '2215520224936815', '产品列表', '/product/list?type=1', '', '', '2', '1', '', '', 'JQ', '2015-11-26 18:23:43', '', '2015-12-07 10:19:30', '数据初始化', '1', '', '', '数据初始化');
INSERT INTO `sys_menu` VALUES ('2215520224936835', '2215520224936815', '2215520224936815', '积分规则列表', '/product/rulesIntegral/index', '', '', '4', '1', '', '', 'JQ', '2015-11-26 18:23:43', '', '2015-12-07 10:10:31', '数据初始化', '1', '', '', '数据初始化');
INSERT INTO `sys_menu` VALUES ('2215520224936836', '2215520224936815', '2215520224936815', '积分产品列表', '/product/list?type=3', '', '', '5', '1', '', '', 'JQ', '2015-11-26 18:23:43', '', '2015-12-07 10:10:31', '数据初始化', '1', '', '', '数据初始化');
INSERT INTO `sys_menu` VALUES ('2215520224936837', '2215520224936815', '2215520224936815', '普通票联票子票列表', '/product/joinTicket/normalJoinTicketList', '', '', '6', '1', '', '', 'JQ', '2015-11-26 18:23:43', '', '2015-12-07 10:16:42', '数据初始化', '1', '', '', '数据初始化');
INSERT INTO `sys_menu` VALUES ('2215520224936838', '2215520224936815', '2215520224936815', '积分票联票子票列表', '', '', '', '7', '1', '', '', 'JQ', '2015-11-26 18:23:43', '', '2015-12-07 10:10:31', '数据初始化', '1', '', '', '数据初始化');
INSERT INTO `sys_menu` VALUES ('2215520224936839', '2215520224936815', '2215520224936815', '加点返利景区关联表', '', '', '', '8', '1', '', '', 'JQ', '2015-11-26 18:23:43', '', '2015-12-07 10:10:31', '数据初始化', '1', '', '', '数据初始化');
INSERT INTO `sys_menu` VALUES ('2215520224936840', '2215520224936815', '2215520224936815', '产品加点返关系表', '/profitRebateRuleProduct/queryProductList', '', '', '9', '1', '', '', 'JQ', '2015-11-26 18:23:43', '', '2015-12-07 10:19:30', '数据初始化', '1', '', '', '数据初始化');
INSERT INTO `sys_menu` VALUES ('2215520224936841', '2215520224936815', '2215520224936815', '退换票规则列表', '/ticketBackRule/queryTicketBackRuleList', '', '', '10', '1', '', '', 'JQ', '2015-11-26 18:23:43', '', '2015-12-07 10:10:31', '数据初始化', '1', '', '', '数据初始化');
INSERT INTO `sys_menu` VALUES ('2215520224936842', '2215520224936816', '2215520224936816', '渠道列表', '/fromtype/channel/index', '', '', '1', '1', '', '', 'JQ', '2015-11-26 18:23:43', '', '2015-12-07 10:19:30', '数据初始化', '1', '', '', '数据初始化');
INSERT INTO `sys_menu` VALUES ('2215520224936843', '2215520224936816', '2215520224936816', '分销商管理', '/fromtype/reseller/queryResellerList', '', '', '2', '1', '', '', 'JQ', '2015-11-26 18:23:43', '', '2015-12-07 10:10:31', '数据初始化', '1', '', '', '数据初始化');
INSERT INTO `sys_menu` VALUES ('2215520224936857', '0', '0', '成员', 'www.baidu.com', null, '22', '11', '1', null, '2', null, '2015-11-27 15:27:23', null, '2015-12-01 15:59:27', '哈哈', '0', '33', '44', '2');
INSERT INTO `sys_menu` VALUES ('2215520224936862', '2215520224936816', '2215520224936816', '导游管理\r\n', '/fromtype/reseller/queryGuideList', null, null, '2', '1', null, null, 'JQ', '2015-12-01 14:37:36', null, '2015-12-07 10:10:31', '数据初始化', '1', null, null, '数据初始化');
INSERT INTO `sys_menu` VALUES ('2215520224936863', '0', '0', '44', '334', null, '44', '11', '1', null, '2', null, '2015-11-27 15:35:10', null, '2015-12-01 15:59:27', '152', '0', '55', '22', '2');
INSERT INTO `sys_menu` VALUES ('2215520224936864', '0', '0', '1', '6', null, '3', '2', '1', null, '0', null, '2015-11-27 15:42:58', null, '2015-12-01 15:59:27', '7', '0', '4', '5', '2');
INSERT INTO `sys_menu` VALUES ('2215520224936865', '0', '0', '天涯生化', null, null, null, '0', '1', null, '0', null, '2015-11-30 10:08:32', null, '2015-12-01 15:59:27', null, '0', null, null, null);
INSERT INTO `sys_menu` VALUES ('2215520224936866', '2215520224936816', '2215520224936816', '协议单位列表', '/protocolUnit/protocolUnitList', '', '', '12', '1', '', '', 'JQ', '2015-11-30 13:57:41', '', '2015-12-07 10:10:31', '数据初始化', '1', '', '', '数据初始化');
INSERT INTO `sys_menu` VALUES ('2215520224936867', '0', '0', '大众拒绝赔偿欧洲\"作弊\"车车主 理由奇葩', '/ddd/ddd', 't', 'ddd', '1', '1', '', '', '', '2015-11-30 13:57:41', '', '2015-12-01 15:59:27', '', '0', '', '', '');
INSERT INTO `sys_menu` VALUES ('2215520224936952', '2215520224936953', '0', '123', '5', null, '2', '1', '1', null, '1', null, '2015-12-01 01:51:40', null, '2015-11-30 18:28:22', '55', '1', '3', '4', '4');
INSERT INTO `sys_menu` VALUES ('2215520224936953', '0', '0', '456', null, null, null, '0', '1', null, '0', null, '2015-12-01 02:03:36', null, '2015-12-01 15:59:27', null, '1', null, null, '2');
INSERT INTO `sys_menu` VALUES ('2215520224936954', '0', '0', '123', null, null, null, '0', '1', null, '0', null, '2015-12-01 02:15:16', null, '2015-12-01 15:59:27', null, '1', null, null, '2');
INSERT INTO `sys_menu` VALUES ('2215520224936995', '2', '2,1', '1', '/aa', 't', 'c', '2', '2', '2', 'fdsaf:fdsaf:fdsafa', '1', '2015-12-01 11:38:20', '1', '0000-00-00 00:00:00', 'test', '1', 'test', 'test', '');
INSERT INTO `sys_menu` VALUES ('2215520224937073', '0', '0', '成员', 'www.baidu.com', '', '22', '11', '1', '', '2', '', '2015-11-27 15:27:23', '', '2015-12-01 15:59:27', '哈哈', '0', '33', '44', '2');
INSERT INTO `sys_menu` VALUES ('2215520224937074', '0', '0', '44', '334', '', '44', '11', '1', '', '2', '', '2015-11-27 15:35:10', '', '2015-12-01 15:59:27', '152', '0', '55', '22', '2');
INSERT INTO `sys_menu` VALUES ('2215520224937075', '0', '0', '1', '6', '', '3', '2', '1', '', '0', '', '2015-11-27 15:42:58', '', '2015-12-01 15:59:27', '7', '0', '4', '5', '2');
INSERT INTO `sys_menu` VALUES ('2215520224937076', '0', '0', '天涯生化', '', '', '', '0', '1', '', '0', '', '2015-11-30 10:08:32', '', '2015-12-01 15:59:27', '', '0', '', '', '');
INSERT INTO `sys_menu` VALUES ('2215520224937077', '0', '0', '个税改革：减轻工薪阶层个税负担', '/ddd/ddd', 't', 'ddd', '1', '1', '', '', '', '2015-11-30 13:57:41', '', '2015-12-01 15:59:27', '', '0', '', '', '');
INSERT INTO `sys_menu` VALUES ('2215520224937078', '0', '0', '大众拒绝赔偿欧洲\"作弊\"车车主 理由奇葩', '/ddd/ddd', 't', 'ddd', '1', '1', '', '', '', '2015-11-30 13:57:41', '', '2015-12-01 15:59:27', '', '0', '', '', '');
INSERT INTO `sys_menu` VALUES ('2215520224937079', '2215520224936953', '0', '123', '6', '', '2', '1', '1', '', '1', '', '2015-12-01 01:51:40', '', '2015-12-04 16:40:54', '55', '1', '3', '4', '4');
INSERT INTO `sys_menu` VALUES ('2215520224937080', '0', '0', '456', '', '', '', '0', '1', '', '0', '', '2015-12-01 02:03:36', '', '2015-12-01 15:59:27', '', '1', '', '', '2');
INSERT INTO `sys_menu` VALUES ('2215520224937081', '0', '0', '123', '', '', '', '0', '1', '', '0', '', '2015-12-01 02:15:16', '', '2015-12-01 15:59:27', '', '1', '', '', '2');
INSERT INTO `sys_menu` VALUES ('2215520224937082', '2', '2,1', '1', '/aa', 't', 'c', '2', '2', '2', 'fdsaf:fdsaf:fdsafa', '1', '2015-12-01 11:38:20', '1', '2015-12-01 14:33:01', 'test', '1', 'test', 'test', '');
INSERT INTO `sys_menu` VALUES ('2215520224937123', '2215520224936816', '2215520224936816', '政策列表(审核)', '/fromtype/strategy/queryStrategyList', '', '', '3', '1', '', '', 'JQ', '2015-11-26 18:23:43', '', '2015-12-07 10:10:31', '数据初始化', '1', '', '', '数据初始化');
INSERT INTO `sys_menu` VALUES ('2215520224937124', '2215520224936816', '2215520224936816', '政策列表(发布)', '/fromtype/strategy/makeStrategyList', '', '', '4', '1', '', '', 'JQ', '2015-11-26 18:23:43', '', '2015-12-07 10:16:42', '数据初始化', '1', '', '', '数据初始化');
INSERT INTO `sys_menu` VALUES ('2215520224937125', '2215520224936817', '2215520224936817', '企业基础设置', '/user/enterpriseIndex', '', '', '1', '1', '', '', 'JQ', '2015-11-26 18:23:43', '', '2015-12-07 10:10:31', '数据初始化', '1', '', '', '数据初始化');
INSERT INTO `sys_menu` VALUES ('2215520224937126', '2215520224936817', '2215520224936817', '景区管理', '/scenic/list', '', '', '2', '1', '', '', 'JQ', '2015-11-26 18:23:43', '', '2015-12-07 10:19:30', '数据初始化', '1', '', '', '数据初始化');
INSERT INTO `sys_menu` VALUES ('2215520224937127', '2215520224936817', '2215520224936817', '剧场管理', '/screen/list', '', '', '3', '1', '', '', 'JQ', '2015-11-26 18:23:43', '', '2015-12-07 10:10:31', '数据初始化', '1', '', '', '数据初始化');
INSERT INTO `sys_menu` VALUES ('2215520224937128', '2215520224936817', '2215520224936817', '检票点管理', '/checkInSite/list', '', '', '4', '1', '', '', 'JQ', '2015-11-26 18:23:43', '', '2015-12-07 10:10:31', '数据初始化', '1', '', '', '数据初始化');
INSERT INTO `sys_menu` VALUES ('2215520224937129', '2215520224936814', '2215520224936814', '积分订单统计', '/orders/biz/selectOutLineOrdersList?ticketCategory\r\n=4', null, null, '5', '1', null, null, 'JQ', '2015-11-26 18:23:43', null, '2015-12-07 10:10:31', '数据初始化', '1', null, null, '数据初始化');
INSERT INTO `sys_menu` VALUES ('2215520224937136', '0', '0', '成员', 'www.baidu.com', '', '22', '11', '1', '', '2', '', '2015-11-27 15:27:23', '', '2015-12-01 15:59:27', '哈哈', '0', '33', '44', '2');
INSERT INTO `sys_menu` VALUES ('2215520224937137', '0', '0', '44', '334', '', '44', '11', '1', '', '2', '', '2015-11-27 15:35:10', '', '2015-12-01 15:59:27', '152', '0', '55', '22', '2');
INSERT INTO `sys_menu` VALUES ('2215520224937138', '0', '0', '1', '6', '', '3', '2', '1', '', '0', '', '2015-11-27 15:42:58', '', '2015-12-01 15:59:27', '7', '0', '4', '5', '2');
INSERT INTO `sys_menu` VALUES ('2215520224937139', '0', '0', '天涯生化', '', '', '', '0', '1', '', '0', '', '2015-11-30 10:08:32', '', '2015-12-01 15:59:27', '', '0', '', '', '');
INSERT INTO `sys_menu` VALUES ('2215520224937140', '0', '0', '个税改革：减轻工薪阶层个税负担', '/ddd/ddd', 't', 'ddd', '1', '1', '', '', '', '2015-11-30 13:57:41', '', '2015-12-01 15:59:27', '', '0', '', '', '');
INSERT INTO `sys_menu` VALUES ('2215520224937141', '0', '0', '大众拒绝赔偿欧洲\"作弊\"车车主 理由奇葩', '/ddd/ddd', 't', 'ddd', '1', '1', '', '', '', '2015-11-30 13:57:41', '', '2015-12-01 15:59:27', '', '0', '', '', '');
INSERT INTO `sys_menu` VALUES ('2215520224937142', '2215520224936953', '0', '123', '5', '', '2', '1', '1', '', '1', '', '2015-12-01 01:51:40', '', '2015-11-30 18:28:22', '55', '1', '3', '4', '4');
INSERT INTO `sys_menu` VALUES ('2215520224937143', '0', '0', '456', '', '', '', '0', '1', '', '0', '', '2015-12-01 02:03:36', '', '2015-12-01 15:59:27', '', '1', '', '', '2');
INSERT INTO `sys_menu` VALUES ('2215520224937144', '0', '0', '123', '', '', '', '0', '1', '', '0', '', '2015-12-01 02:15:16', '', '2015-12-01 15:59:27', '', '1', '', '', '2');
INSERT INTO `sys_menu` VALUES ('2215520224937145', '2', '2,1', '1', '/aa', 't', 'c', '2', '2', '2', 'fdsaf:fdsaf:fdsafa', '1', '2015-12-01 11:38:20', '1', '2015-12-01 14:34:24', 'test', '1', 'test', 'test', '');
INSERT INTO `sys_menu` VALUES ('2215520224937154', '2215520224936817', '2215520224936817', '检票设备管理', '/checkInDevice/list', '', '', '5', '1', '', '', 'JQ', '2015-11-26 18:23:43', '', '2015-12-07 10:16:42', '数据初始化', '1', '', '', '数据初始化');
INSERT INTO `sys_menu` VALUES ('2215520224937155', '2215520224936817', '2215520224936817', '售票点管理', '/enterprise/point/index', '', '', '6', '1', '', '', 'JQ', '2015-11-26 18:23:43', '', '2015-12-07 10:10:31', '数据初始化', '1', '', '', '数据初始化');
INSERT INTO `sys_menu` VALUES ('2215520224937156', '2215520224936817', '2215520224936817', '直销工具管理', '/enterprise/tool/index', '', '', '7', '1', '', '', 'JQ', '2015-11-26 18:23:43', '', '2015-12-07 10:10:31', '数据初始化', '1', '', '', '数据初始化');
INSERT INTO `sys_menu` VALUES ('2215520224937157', '2215520224936817', '2215520224936817', '部门管理', '/department/pagelistRole', '', '', '8', '1', '', '', 'JQ', '2015-11-26 18:23:43', '', '2015-12-07 10:19:30', '数据初始化', '1', '', '', '数据初始化');
INSERT INTO `sys_menu` VALUES ('2215520224937158', '2215520224936817', '2215520224936817', '员工管理', '/enterprise/customer/index', '', '', '9', '1', '', '', 'JQ', '2015-11-26 18:23:43', '', '2015-12-07 10:10:31', '数据初始化', '1', '', '', '数据初始化');
INSERT INTO `sys_menu` VALUES ('2215520224937159', '2215520224936817', '2215520224936817', '修改密码', '/user/changePs', '', '', '10', '1', '', '', 'JQ', '2015-11-26 18:23:43', '', '2015-12-07 10:10:31', '数据初始化', '1', '', '', '数据初始化');
INSERT INTO `sys_menu` VALUES ('2215520224937160', '2215520224936817', '2215520224936817', '操作日志', '/log/pagelistLog', '', '', '11', '1', '', '', 'JQ', '2015-11-26 18:23:43', '', '2015-12-07 10:16:42', '数据初始化', '1', '', '', '数据初始化');
INSERT INTO `sys_menu` VALUES ('2215520224937246', '2', '2,1', '1', '/aa', 't', 'c', '2', '2', '2', 'fdsaf:fdsaf:fdsafa', '1', '2015-12-04 14:00:12', '1', '0000-00-00 00:00:00', 'test', '1', 'test', 'test', '');
INSERT INTO `sys_menu` VALUES ('2215520224937294', '0', '0', '789', '456', null, '456', '456', '1', null, '0', null, '2015-12-05 00:57:04', null, null, null, '1', '456', '456', '2');
INSERT INTO `sys_menu` VALUES ('2215520224937295', '0', '0', '一二三四五六七八九十', '5', null, '2', '1', '1', null, '0', null, '2015-12-05 00:58:24', null, '2015-12-04 16:58:33', null, '1', '3', '4', '2');
INSERT INTO `sys_menu` VALUES ('2215520224937313', '0', '0', '一二三四五六七八九十', '77777', null, '88888', '99999', '1', null, '0', null, '2015-12-05 01:19:36', null, '2015-12-04 17:21:30', null, '1', '55555', '66666', '2');
INSERT INTO `sys_menu` VALUES ('2215520224937322', '2', '2,1', '1', '/aa', 't', 'c', '2', '2', '2', 'fdsaf:fdsaf:fdsafa', '1', '2015-12-04 17:26:24', '1', '0000-00-00 00:00:00', 'test', '1', 'test', 'test', '');
INSERT INTO `sys_menu` VALUES ('2215520224937327', '0', '0', '1234567890', '5', null, '2', '1', '1', null, '0', null, '2015-12-05 01:39:07', null, null, null, '1', '3', '4', '2');
INSERT INTO `sys_menu` VALUES ('2215520224937332', '0', '0', '123abc一二三', '7', null, '4', '3', '1', null, '0', null, '2015-12-05 01:45:19', null, null, null, '1', '5', '6', '2');
INSERT INTO `sys_menu` VALUES ('2215520224937333', '0', '0', '~！@#￥%', '8', null, '5', '4', '1', null, '0', null, '2015-12-05 01:45:55', null, null, null, '1', '6', '7', '2');
INSERT INTO `sys_menu` VALUES ('2215520224937334', '0', '0', '123abc一二三', '7', null, '3', '2', '1', null, '0', null, '2015-12-05 01:46:38', null, null, null, '1', '4', '5', '2');
INSERT INTO `sys_menu` VALUES ('2215520224937359', '0', '0', '希望成功1', '67', null, '34', '9874', '1', null, '0', null, '2015-12-05 02:05:29', null, '2015-12-04 18:05:30', null, '1', '45', '56', '2');
INSERT INTO `sys_menu` VALUES ('2215520224937360', '0', '0', '34343', '434', null, '434', '43', '1', null, '0', null, '2015-12-05 02:19:18', null, null, null, '1', '4343', '4343', '2');
INSERT INTO `sys_menu` VALUES ('2215520224937361', '0', '0', '101010', '121', null, '454', '123456', '1', null, '0', null, '2015-12-05 02:19:59', null, null, null, '1', '78', '54', '2');
INSERT INTO `sys_menu` VALUES ('2215520224937362', '2215520224937359', '0', '1233555555', '/*/*****', null, '1', '7898', '1', null, '3', null, '2015-12-05 02:20:52', null, '2015-12-04 18:23:46', '56666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666', '1', '**********', '1', '4');
INSERT INTO `sys_menu` VALUES ('2215520224937364', '0', '0', '审核', null, null, '<i class=\"fa fa-ticket\"></i>', '3', '1', null, '0', null, '2015-12-04 18:25:50', null, '2015-12-04 18:24:43', '支撑平台审核', '1', null, '', '1');
INSERT INTO `sys_menu` VALUES ('2215520224937365', '2215520224937364', '0', '客户审核', '/audit/toAuditUserList', null, '', '1', '1', null, '1', null, '2015-12-04 18:25:50', null, '2015-12-04 18:24:43', '支撑平台客户审核', '1', null, '', '1');
INSERT INTO `sys_menu` VALUES ('2215520224937366', '0', '0', '用户管理', null, null, '<i class=\"fa fa-ticket\"></i>', '2', '1', null, '0', null, '2015-12-04 18:25:51', null, '2015-12-04 18:24:43', '支撑平台用户管理', '1', null, '', '1');
INSERT INTO `sys_menu` VALUES ('2215520224937367', '2215520224937366', '0', '景区审核', '/audit/toManageUserList', null, '', '1', '1', null, '1', null, '2015-12-04 18:25:51', null, '2015-12-04 18:24:43', '支撑平台景区审核', '1', null, '', '1');
INSERT INTO `sys_menu` VALUES ('2215520224937368', '0', '0', '设置', null, null, '<i class=\"fa fa-ticket\"></i>', '1', '1', null, '0', null, '2015-12-04 18:25:51', null, '2015-12-04 18:24:43', '支撑平台设置', '1', null, '', '1');
INSERT INTO `sys_menu` VALUES ('2215520224937369', '2215520224937368', '0', '成员管理', '/auth/employeeList', null, '', '3', '1', null, '1', null, '2015-12-04 18:25:51', null, '2015-12-04 18:24:43', '支撑平台成员管理', '1', null, '', '1');
INSERT INTO `sys_menu` VALUES ('2215520224937370', '2215520224937368', '0', '岗位管理', '/auth/roleList', null, '', '2', '1', null, '1', null, '2015-12-04 18:25:51', null, '2015-12-04 18:24:43', '支撑平台岗位管理', '1', null, '', '1');
INSERT INTO `sys_menu` VALUES ('2215520224937371', '2215520224937368', '0', '权限管理', '/auth/menuList', null, '', '1', '1', null, '1', null, '2015-12-04 18:25:51', null, '2015-12-04 18:24:43', '支撑平台权限管理', '1', null, '', '1');
INSERT INTO `sys_menu` VALUES ('2215520224937381', '0', '0', '我', '5', null, '2', '1', '1', null, '0', null, '2015-12-05 02:29:09', null, null, null, '1', '3', '4', null);
INSERT INTO `sys_menu` VALUES ('2215520224937382', '0', '0', '1', '1', null, '1', '1', '1', null, '0', null, '2015-12-05 02:29:21', null, null, null, '1', '1', '1', null);
INSERT INTO `sys_menu` VALUES ('2215520224937383', '0', '0', '2', '3', null, '3', '3', '1', null, '0', null, '2015-12-05 02:29:33', null, null, null, '1', '3', '3', null);
INSERT INTO `sys_menu` VALUES ('2215520224937384', '2', '2,1', 'nn_test', '', '', '', '2', '2', '2', 'fdsaf:fdsaf:fdsafa', '1', '2015-12-05 17:49:08', '1', '0000-00-00 00:00:00', 'test', '2', 'test', 'test', '');
INSERT INTO `sys_menu` VALUES ('2215520224937386', '2', '2,1', '1', '/aa', 't', 'c', '2', '2', '2', 'fdsaf:fdsaf:fdsafa', '1', '2015-12-05 17:49:11', '1', '0000-00-00 00:00:00', 'test', '1', 'test', 'test', '');
INSERT INTO `sys_menu` VALUES ('2215520224937395', '0', '0', '渠道', null, null, '<i class=\"fa\">&#xe60a;</i>', '3', '1', null, '0', null, '2015-12-06 16:30:42', null, '2015-12-06 16:29:23', '代供销平台渠道', '1', null, '', '2');
INSERT INTO `sys_menu` VALUES ('2215520224937396', '2215520224937395', '0', '渠道管理', '/channel/channelList', null, '', '1', '1', null, '1', null, '2015-12-06 16:30:42', null, '2015-12-06 16:29:23', '代供销平台渠道管理', '1', null, '', '2');
INSERT INTO `sys_menu` VALUES ('2215520224937397', '0', '0', '产品', null, null, '<i class=\"fa\">&#xe608;</i>', '2', '1', null, '0', null, '2015-12-06 16:30:42', null, '2015-12-06 16:29:23', '代供销平台产品', '1', null, '', '2');
INSERT INTO `sys_menu` VALUES ('2215520224937398', '2215520224937397', '0', '产品审核', '/product/auditProductTab', null, '', '2', '1', null, '1', null, '2015-12-06 16:30:42', null, '2015-12-06 16:29:23', '代供销平台产品审核', '1', null, '', '2');
INSERT INTO `sys_menu` VALUES ('2215520224937399', '2215520224937397', '0', '产品管理', '/product/manageProductTab', null, '', '1', '1', null, '1', null, '2015-12-06 16:30:42', null, '2015-12-06 16:29:23', '代供销平台产品管理', '1', null, '', '2');
INSERT INTO `sys_menu` VALUES ('2215520224937400', '0', '0', '设置', null, null, '<i class=\"fa fa-ticket\"></i>', '1', '1', null, '0', null, '2015-12-06 16:30:43', null, '2015-12-06 16:29:23', '代供销平台设置', '1', null, '', '2');
INSERT INTO `sys_menu` VALUES ('2215520224937401', '2215520224937400', '0', '成员管理', '/auth/employeeList', null, '', '3', '1', null, '1', null, '2015-12-06 16:30:43', null, '2015-12-06 16:29:23', '代供销平台成员管理', '1', null, '', '2');
INSERT INTO `sys_menu` VALUES ('2215520224937402', '2215520224937400', '0', '岗位管理', '/auth/roleList', null, '', '2', '1', null, '1', null, '2015-12-06 16:30:43', null, '2015-12-06 16:29:23', '代供销平台岗位管理', '1', null, '', '2');
INSERT INTO `sys_menu` VALUES ('2215520224937403', '2215520224937400', '0', '权限管理', '/auth/menuList', null, '', '1', '1', null, '1', null, '2015-12-06 16:30:43', null, '2015-12-06 16:29:23', '代供销平台权限管理', '1', null, '', '2');
INSERT INTO `sys_menu` VALUES ('2215520224937405', '2215520224936812', '2215520224936812', '地接社统计', '/report/resellerOperate/getSaleRebateData', '', '', '1', '1', '', '', 'JQ', '2015-12-06 19:40:07', '', '2015-12-07 10:19:30', '数据初始化', '1', '', '', '数据初始化');
INSERT INTO `sys_menu` VALUES ('2215520224937406', '2215520224936812', '2215520224936812', '销售统计', 'report1/resellerOperate/querySellReport', '', '', '2', '1', '', '', 'JQ', '2015-12-06 19:40:07', '', '2015-12-07 10:16:42', '数据初始化', '1', '', '', '数据初始化');
INSERT INTO `sys_menu` VALUES ('2215520224937407', '2215520224936812', '2215520224936812', '线上渠道报表', 'report1/newfinaceTicket/statisticsByDistributionByFromtype', '', '', '3', '1', '', '', 'JQ', '2015-12-06 19:40:07', '', '2015-12-07 10:14:02', '数据初始化', '1', '', '', '数据初始化');
INSERT INTO `sys_menu` VALUES ('2215520224937408', '2215520224936812', '2215520224936812', '线下售票总计', 'report1/newticketStatistics/getTicketStatisticsAll', '', '', '4', '1', '', '', 'JQ', '2015-12-06 19:40:07', '', '2015-12-07 10:14:02', '数据初始化', '1', '', '', '数据初始化');
INSERT INTO `sys_menu` VALUES ('2215520224937409', '2215520224936812', '2215520224936812', '地接社部门订单统计报表', 'report1/newDepartTicketDay/getDepartTicketDay?typeinfo=2', '', '', '5', '1', '', '', 'JQ', '2015-12-06 19:40:07', '', '2015-12-07 10:14:02', '数据初始化', '1', '', '', '数据初始化');
INSERT INTO `sys_menu` VALUES ('2215520224937410', '2215520224936812', '2215520224936812', '导游订单统计报表', 'report1/newDepartTicketDay/getDepartTicketDay?typeinfo=3', '', '', '6', '1', '', '', 'JQ', '2015-12-06 19:40:07', '', '2015-12-07 10:14:02', '数据初始化', '1', '', '', '数据初始化');
INSERT INTO `sys_menu` VALUES ('2215520224937411', '2215520224936812', '2215520224936812', '委托应收(代售)', 'report1/newfhbch-report/jointTicketBookingReport?typeinfo=1', '', '', '7', '1', '', '', 'JQ', '2015-12-06 19:40:07', '', '2015-12-07 10:14:02', '数据初始化', '1', '', '', '数据初始化');
INSERT INTO `sys_menu` VALUES ('2215520224937412', '2215520224936812', '2215520224936812', '委托应收', 'report1/newfhbch-report/jointTicketBookingReport?typeinfo=2', '', '', '8', '1', '', '', 'JQ', '2015-12-06 19:40:07', '', '2015-12-07 10:19:30', '数据初始化', '1', '', '', '数据初始化');
INSERT INTO `sys_menu` VALUES ('2215520224937413', '2215520224936812', '2215520224936812', '代售应付', 'report1/newfhbch-report/jointTicketBookingReport?typeinfo=3', '', '', '9', '1', '', '', 'JQ', '2015-12-06 19:40:07', '', '2015-12-07 10:16:42', '数据初始化', '1', '', '', '数据初始化');
INSERT INTO `sys_menu` VALUES ('2215520224937423', '0', '0,1', '测试菜单', '/ddd/ddd', 't', 'ddd', '1', '1', '1', 'fdsaf:fdsaf:fdsafa', '', '2015-12-07 10:30:09', '', '0000-00-00 00:00:00', 'ghjkluio', '0', 'jfidsaf', 'fdsafdsa', '');
INSERT INTO `sys_menu` VALUES ('2215520224937424', '0', '0,1', '测试菜单', '/ddd/ddd', 't', 'ddd', '1', '1', '1', 'fdsaf:fdsaf:fdsafa', '', '2015-12-07 10:37:25', '', '0000-00-00 00:00:00', 'ghjkluio', '0', 'jfidsaf', 'fdsafdsa', '');
INSERT INTO `sys_menu` VALUES ('2215520224937425', '0', '0,1', '测试菜单', '/ddd/ddd', 't', 'ddd', '1', '1', '1', 'fdsaf:fdsaf:fdsafa', '', '2015-12-07 10:48:23', '', '0000-00-00 00:00:00', 'ghjkluio', '0', 'jfidsaf', 'fdsafdsa', '');
INSERT INTO `sys_menu` VALUES ('2215520224937426', '0', '0,1', '测试菜单', '/ddd/ddd', 't', 'ddd', '1', '1', '1', 'fdsaf:fdsaf:fdsafa', '', '2015-12-07 10:48:48', '', '0000-00-00 00:00:00', 'ghjkluio', '0', 'jfidsaf', 'fdsafdsa', '');
INSERT INTO `sys_menu` VALUES ('2215520224937427', '2215520224936815', '2215520224936815', '演艺产品列表', '/product/list?type=2', null, null, '3', '1', null, null, 'JQ', '2015-12-07 10:49:17', null, '2015-12-07 10:49:20', '数据初始化', '1', null, null, null);

-- ----------------------------
-- Table structure for `sys_office`
-- ----------------------------
DROP TABLE IF EXISTS `sys_office`;
CREATE TABLE `sys_office` (
  `id` bigint(20) NOT NULL COMMENT '编号',
  `parent_id` varchar(64) NOT NULL COMMENT '父级编号',
  `parent_ids` varchar(1000) NOT NULL COMMENT '所有父级编号',
  `area_id` varchar(64) DEFAULT NULL COMMENT '归属区域',
  `code` varchar(100) DEFAULT NULL COMMENT '区域编码',
  `name` varchar(100) NOT NULL COMMENT '机构名称',
  `type` char(1) DEFAULT NULL COMMENT '机构类型',
  `grade` char(1) DEFAULT NULL COMMENT '机构等级',
  `address` varchar(255) DEFAULT NULL COMMENT '联系地址',
  `zip_code` varchar(100) DEFAULT NULL COMMENT '邮政编码',
  `master` varchar(100) DEFAULT NULL COMMENT '负责人',
  `phone` varchar(200) DEFAULT NULL COMMENT '电话',
  `fax` varchar(200) DEFAULT NULL COMMENT '传真',
  `email` varchar(200) DEFAULT NULL COMMENT '邮箱',
  `create_by` varchar(64) DEFAULT NULL COMMENT '创建者',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT NULL COMMENT '更新者',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  `del_flag` char(1) NOT NULL DEFAULT '0' COMMENT '删除标记1：删除',
  `business_name` varchar(100) DEFAULT NULL,
  `business_person` varchar(100) DEFAULT NULL,
  `business_address` varchar(255) DEFAULT NULL,
  `business_telephone` varchar(100) DEFAULT NULL,
  `business_id` varchar(100) DEFAULT NULL,
  `audit_status` varchar(1) DEFAULT NULL,
  `reason_rejection` varchar(500) DEFAULT NULL,
  `data_source` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `sys_office_parent_id` (`parent_id`) USING BTREE,
  KEY `sys_office_del_flag` (`del_flag`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='机构表';

-- ----------------------------
-- Records of sys_office
-- ----------------------------
INSERT INTO `sys_office` VALUES ('1', '1', '1', '1', '1', '1', '1', '1', '1', '11', '1', '1', '1', '1', '1', '0000-00-00 00:00:00', '1', '0000-00-00 00:00:00', '1', '1', null, null, null, null, null, null, null, null);
INSERT INTO `sys_office` VALUES ('2215520224935937', '1', '1', '4', '', '测试分店', '1', '4', '', '', '', '', '', '', '', '2015-11-23 20:36:49', '', '0000-00-00 00:00:00', '', '1', null, null, null, null, null, '', null, '');
INSERT INTO `sys_office` VALUES ('2215520224935938', '111', '111', '1', '', 'test_test', '1', '1', '', '', '', '', '', '', '111', '2015-11-23 20:36:49', '', '2015-12-04 14:12:16', '', '1', null, null, null, null, null, '', null, '');
INSERT INTO `sys_office` VALUES ('2215520224935939', '0', '0', null, null, '地方', null, null, null, null, null, null, null, null, null, '2015-11-26 16:17:20', null, '2015-12-05 15:09:00', null, '1', null, null, null, null, null, null, null, null);
INSERT INTO `sys_office` VALUES ('2215520224935940', '0', '0', null, null, '未亡人', null, null, null, null, null, null, null, null, null, '2015-11-26 16:20:01', null, '2015-12-05 15:09:00', null, '1', null, null, null, null, null, null, null, null);
INSERT INTO `sys_office` VALUES ('2215520224935941', '0', '0', null, null, 'zz', null, null, null, null, null, null, null, null, null, '2015-11-27 16:56:01', null, null, null, '1', null, null, null, null, null, null, null, null);
INSERT INTO `sys_office` VALUES ('2215520224935942', '0', '0', null, null, 'ew', null, null, null, null, null, null, null, null, null, '2015-11-27 17:00:25', null, '2015-12-04 14:12:16', null, '1', null, null, null, null, null, null, null, null);
INSERT INTO `sys_office` VALUES ('2215520224935943', '0', '0', null, null, 'ds', null, null, null, null, null, null, null, null, null, '2015-11-27 17:02:47', null, null, null, '1', null, null, null, null, null, null, null, null);
INSERT INTO `sys_office` VALUES ('2215520224935944', '0', '0', null, null, 'test1111', null, null, null, null, null, null, null, null, null, '2015-11-30 11:15:50', null, null, null, '1', null, null, null, null, null, null, null, null);
INSERT INTO `sys_office` VALUES ('2215520224935946', '0', '0', '2', '', '[INFO] Downloading', '2', '2', '', '', '', '', '', '2', '', '0000-00-00 00:00:00', '', '2015-12-03 18:45:10', '', '1', null, null, null, null, null, '', null, 'ffff');
INSERT INTO `sys_office` VALUES ('2215520224935947', '0', '0', null, null, '[INFO] Downloading', null, null, null, null, null, null, null, null, null, null, null, null, null, '1', null, null, null, null, null, null, null, null);
INSERT INTO `sys_office` VALUES ('2215520224935948', '0', '0', '', '', 'GMT+08:00] Dubbo', '', '', '', '', '', '', '', '', '', '0000-00-00 00:00:00', '', '2015-12-05 14:37:24', '', '1', null, null, null, null, null, '', null, '');
INSERT INTO `sys_office` VALUES ('2215520224935949', '0', '0', '', '', 'tment num', '', '', '', '', '', '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '', '1', null, null, null, null, null, '', null, '');
INSERT INTO `sys_office` VALUES ('2215520224935950', '1', '1', '4', null, '测试分店@@@', '1', '4', null, null, null, null, null, null, null, '2015-11-30 11:22:52', '测试', null, null, '1', null, null, null, null, null, null, null, null);
INSERT INTO `sys_office` VALUES ('2215520224935951', '1', '1', '4', null, '测试分店@@@', '1', '4', null, null, null, null, null, null, null, '2015-11-30 11:23:27', '测试', null, null, '1', null, null, null, null, null, null, null, null);
INSERT INTO `sys_office` VALUES ('2215520224935952', '1', '1', '4', null, '测试分店@@@', '1', '4', null, null, null, null, null, null, null, '2015-11-30 11:25:05', '测试', null, null, '1', null, null, null, null, null, null, null, null);
INSERT INTO `sys_office` VALUES ('2215520224935953', '1', '1', '4', null, '测试分店@@@', '1', '4', null, null, null, null, null, null, null, '2015-11-30 11:25:12', '测试', null, null, '1', null, null, null, null, null, null, null, null);
INSERT INTO `sys_office` VALUES ('2215520224935954', '1', '1', '4', null, '测试分店@@@', '1', '4', null, null, null, null, null, null, null, '2015-11-30 11:26:22', '测试', null, null, '1', null, null, null, null, null, null, null, null);
INSERT INTO `sys_office` VALUES ('2215520224935955', '1', '1', '4', null, '测试分店@@@', '1', '4', null, null, null, null, null, null, null, '2015-11-30 11:43:12', '测试', null, null, '1', null, null, null, null, null, null, null, null);
INSERT INTO `sys_office` VALUES ('2215520224935956', '1', '1', '4', null, '测试分店!@!@', '1', '4', null, null, null, null, null, null, null, '2015-11-30 11:44:06', '测试', null, null, '1', null, null, null, null, null, null, null, null);
INSERT INTO `sys_office` VALUES ('2215520224935957', '0', '0', null, null, 'wqeqe', null, null, null, null, null, null, null, null, null, '2015-11-30 13:42:24', null, null, null, '1', null, null, null, null, null, null, null, null);
INSERT INTO `sys_office` VALUES ('2215520224935958', '1', '1', '4', '', 'nn_10161400', '1', '4', '', '', '', '', '', '', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', '', '1', null, null, null, null, null, '', null, '');
INSERT INTO `sys_office` VALUES ('2215520224935959', '0', '0', null, null, '部门名称1', null, null, null, null, null, null, null, null, '……*&（……*%', '2015-12-02 15:41:13', null, '2015-12-05 15:09:00', null, '1', null, null, null, null, null, null, null, null);
INSERT INTO `sys_office` VALUES ('2215520224935960', '0', '0', null, null, '合计北', null, null, null, null, null, null, null, null, '法人', '2015-12-02 18:27:34', null, '2015-12-07 10:16:42', null, '1', null, null, null, null, null, null, null, null);
INSERT INTO `sys_office` VALUES ('2215520224935961', '0', '0', null, null, '发阿斯顿', null, null, null, null, null, null, null, null, '法人', '2015-12-02 18:33:32', null, '2015-12-07 09:48:20', null, '1', null, null, null, null, null, null, null, null);
INSERT INTO `sys_office` VALUES ('2215520224935962', '0', '0', null, null, '部门1204-10:53', null, null, null, null, null, null, null, null, '法人', '2015-12-03 10:54:50', null, '2015-12-04 11:13:30', null, '1', null, null, null, null, null, null, null, null);
INSERT INTO `sys_office` VALUES ('2215520224935963', '0', '0', null, null, '客服部', null, null, null, null, null, null, null, null, 'edre#@#@#$', '2015-12-03 21:24:33', null, '2015-12-05 15:09:00', null, '1', null, null, null, null, null, null, null, null);
INSERT INTO `sys_office` VALUES ('2215520224935964', '0', '0', null, null, '西门测试', null, null, null, null, null, null, null, null, 'edre#@#@#$', '2015-12-04 13:16:27', '合计北', '2015-12-06 22:21:56', null, '1', null, null, null, null, null, null, null, null);
INSERT INTO `sys_office` VALUES ('2215520224935965', '0', '0', null, null, '东门测试', null, null, null, null, null, null, null, null, 'edre#@#@#$', '2015-12-04 13:18:25', '晚归问', '2015-12-07 10:10:19', null, '1', null, null, null, null, null, null, null, null);
INSERT INTO `sys_office` VALUES ('2215520224935966', '1', '1', '4', '', 'nn_10161400', '1', '4', '', '', '', '', '', '', '', '2015-12-04 14:00:12', '', '0000-00-00 00:00:00', '', '1', null, null, null, null, null, '', null, '');
INSERT INTO `sys_office` VALUES ('2215520224935967', '0', '0', null, null, '部门名称1', null, null, null, null, null, null, null, null, 'edre#@#@#$', '2015-12-04 15:14:59', null, null, null, '1', null, null, null, null, null, null, null, null);
INSERT INTO `sys_office` VALUES ('2215520224935968', '1', '1', '4', '', 'nn_10161400', '1', '4', '', '', '', '', '', '', '', '2015-12-04 17:26:24', '', '0000-00-00 00:00:00', '', '1', null, null, null, null, null, '', null, '');
INSERT INTO `sys_office` VALUES ('2215520224935969', '0', '0', null, null, '客服部', null, null, null, null, null, null, null, null, '晚归问', '2015-12-04 21:25:46', null, null, null, '1', null, null, null, null, null, null, null, null);
INSERT INTO `sys_office` VALUES ('2215520224935970', '0', '0', null, null, '啊', null, null, null, null, null, null, null, null, '晚归问', '2015-12-04 21:41:26', null, null, null, '1', null, null, null, null, null, null, null, null);
INSERT INTO `sys_office` VALUES ('2215520224935971', '0', '0', null, null, '部门名称1205', null, null, null, null, null, null, null, null, '晚归问', '2015-12-05 16:57:49', null, null, null, '1', null, null, null, null, null, null, null, null);
INSERT INTO `sys_office` VALUES ('2215520224935972', '1', '1', '4', '', 'nn_10161400', '1', '4', '', '', '', '', '', '', '', '2015-12-05 17:49:11', '', '0000-00-00 00:00:00', '', '1', null, null, null, null, null, '', null, 'ffff');
INSERT INTO `sys_office` VALUES ('2215520224935973', '0', '0', null, null, '张翔鹏6号部门', null, null, null, null, null, null, null, null, '晚归问', '2015-12-06 15:26:06', null, '2015-12-07 10:19:30', null, '1', null, null, null, null, null, null, null, null);
INSERT INTO `sys_office` VALUES ('2215520224935974', '1', '1', '4', '', '测试分店', '1', '4', '', '', '', '', '', '', '', '2015-12-07 10:30:09', '', '0000-00-00 00:00:00', '', '1', null, null, null, null, null, '', null, '');
INSERT INTO `sys_office` VALUES ('2215520224935975', '1', '1', '4', '', '测试分店', '1', '4', '', '', '', '', '', '', '', '2015-12-07 10:37:25', '', '0000-00-00 00:00:00', '', '1', null, null, null, null, null, '', null, '');
INSERT INTO `sys_office` VALUES ('2215520224935976', '1', '1', '4', '', '测试分店', '1', '4', '', '', '', '', '', '', '', '2015-12-07 10:48:23', '', '0000-00-00 00:00:00', '', '1', null, null, null, null, null, '', null, '');
INSERT INTO `sys_office` VALUES ('2215520224935977', '1', '1', '4', '', '测试分店', '1', '4', '', '', '', '', '', '', '', '2015-12-07 10:48:48', '', '0000-00-00 00:00:00', '', '1', null, null, null, null, null, '', null, '');

-- ----------------------------
-- Table structure for `sys_office_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_office_role`;
CREATE TABLE `sys_office_role` (
  `id` bigint(20) NOT NULL,
  `office_id` varchar(45) NOT NULL,
  `role_id` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_office_role
-- ----------------------------
INSERT INTO `sys_office_role` VALUES ('1', '1', '1');

-- ----------------------------
-- Table structure for `sys_rebate_strategy`
-- ----------------------------
DROP TABLE IF EXISTS `sys_rebate_strategy`;
CREATE TABLE `sys_rebate_strategy` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `scene_id` bigint(20) DEFAULT NULL COMMENT '景区ID',
  `product_id` bigint(20) DEFAULT NULL COMMENT '产品ID（返利票种ID）',
  `product_name` varchar(255) DEFAULT NULL COMMENT '产品名称（返利票种）',
  `rebate_price` double DEFAULT '0' COMMENT '返利价格',
  `rebate_object` varchar(10) DEFAULT NULL COMMENT '返利对象返利对象(总社H、地接部门D、优先部门DH、导游G)',
  `rebate_cycle_type` int(11) DEFAULT NULL COMMENT '返利周期类型',
  `rebate_cycle` varchar(10) DEFAULT NULL COMMENT '返利周期(YEAR/MONTH/WEEK/DAY/CURRENT)',
  `rebate_cycle_value` int(11) DEFAULT '0' COMMENT '线上返利周期数',
  `rebate_per_month` int(11) DEFAULT NULL COMMENT '返利固定月',
  `rebate_settlement` int(11) DEFAULT NULL COMMENT '结算方式（即时返1/周期返2）',
  `rebate_amount` double DEFAULT '0' COMMENT '返利金额(每人)',
  `rebate_type` int(11) DEFAULT '1' COMMENT '返利形式(0为现金返利，1为按票返利，2返利积分)',
  `status` int(11) DEFAULT NULL COMMENT '规则状态（1：启动、 0 ：禁用   2: 删除）参照GlobalParam.FLAG',
  `type` int(11) DEFAULT '2' COMMENT '返利类型（1 前置， 2， 后置    默认2）',
  `p_version` int(11) DEFAULT NULL COMMENT '所属平台',
  `supplier_id` bigint(20) DEFAULT NULL COMMENT '创建供应商',
  `integral_id` bigint(20) DEFAULT NULL COMMENT '积分类型ID',
  `integral_value` int(11) DEFAULT NULL COMMENT '返利积分数量',
  `create_by` varchar(10) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(10) DEFAULT NULL COMMENT '修改人',
  `update_date` datetime DEFAULT NULL COMMENT '修改时间',
  `data_source` varchar(45) DEFAULT NULL COMMENT '数据来源',
  `is_extra_rebate` int(1) DEFAULT '0' COMMENT '是否存在加点返利(0否，1是)',
  `rebate_product_id` bigint(255) DEFAULT NULL COMMENT '返利票种ID<对比后加>',
  `rebate_product_name` varchar(36) DEFAULT NULL COMMENT '返利折票产品名称（返利折票票种）<对比后加>',
  `rebate_conditions` varchar(255) DEFAULT NULL COMMENT '返利条件描述<对比后加>',
  `is_online` int(1) DEFAULT '0' COMMENT '是否线上(0是线下，1是线上)<对比后加>',
  `from_type` varchar(100) DEFAULT NULL COMMENT '订单来源<对比后加>',
  `reseller_supplier_id` bigint(20) DEFAULT NULL COMMENT '分销商所属的供应商id<对比后加>',
  `front_rebate_rule_id` bigint(20) DEFAULT NULL COMMENT '前置返利规则ID<对比后加>',
  `rebate_rule_type` int(11) DEFAULT '0' COMMENT '返利规则类型(0 普通返利； 1 加点返利)<对比后加>',
  `front_product_id` bigint(20) DEFAULT NULL COMMENT '前置产品ID<对比后加>',
  `validity_period` int(11) DEFAULT NULL COMMENT '时效<对比后加>',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idnew_table_UNIQUE` (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2215520224936077 DEFAULT CHARSET=utf8 COMMENT='渠道返利规则';

-- ----------------------------
-- Records of sys_rebate_strategy
-- ----------------------------
INSERT INTO `sys_rebate_strategy` VALUES ('2215520224935952', null, '3', 'procdut', '0', null, null, null, '1315', null, null, '0', '1', null, '2', null, null, null, null, 'fffffff', null, null, null, null, '1', null, null, null, '0', null, null, null, '0', null, null);
INSERT INTO `sys_rebate_strategy` VALUES ('2215520224935957', null, null, null, '121', '3', null, null, '1315', null, null, '0', '3', null, '5', null, null, null, null, null, null, null, null, null, '0', null, null, null, '0', null, null, null, '0', null, null);
INSERT INTO `sys_rebate_strategy` VALUES ('2215520224935958', null, null, null, '123.123', '3', null, null, '1316', null, null, '0', '3', null, '5', null, null, null, null, null, null, null, null, null, '0', null, null, null, '0', null, null, null, '0', null, null);
INSERT INTO `sys_rebate_strategy` VALUES ('2215520224935959', '0', '0', '', '0', '3', null, '', '1317', null, null, '0', '3', '0', '5', '0', '0', '0', '0', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', null, '0', null, null, null, '0', null, null, null, '0', null, null);
INSERT INTO `sys_rebate_strategy` VALUES ('2215520224935960', '0', '0', '', '0', '3', null, '', '1318', null, null, '0', '3', '0', '5', '0', '0', '0', '0', '', '0000-00-00 00:00:00', '', '0000-00-00 00:00:00', null, '0', null, null, null, '0', null, null, null, '0', null, null);
INSERT INTO `sys_rebate_strategy` VALUES ('2215520224935965', '0', '0', '', '0', '2', null, '', '0', null, null, '2', '2', '0', '2', '0', '0', '0', '0', '', null, '', null, null, '0', null, null, null, '0', null, null, null, '0', null, null);
INSERT INTO `sys_rebate_strategy` VALUES ('2215520224935966', '0', '0', '', '0', '2', null, '', '0', null, null, '3', '3', '0', '2', '0', '0', '0', '0', '', null, '', null, null, '0', null, null, null, '0', null, null, null, '0', null, null);
INSERT INTO `sys_rebate_strategy` VALUES ('2215520224935967', '0', '0', '', '0', '3', null, 'DAY', '1', '1', '2', '1', '1', '0', '2', '0', '0', '0', '0', '', null, '', null, null, '0', null, null, null, '0', null, null, null, '0', null, null);
INSERT INTO `sys_rebate_strategy` VALUES ('2215520224935968', '0', '0', '', '0', '2', null, 'DAY', '0', '1', '2', '3', '3', '0', '2', '0', '0', '0', '0', '', null, '', null, null, '0', null, null, null, '0', null, null, null, '0', null, null);
INSERT INTO `sys_rebate_strategy` VALUES ('2215520224935969', '0', '0', '', '0', '2', null, 'WEEK', '3', '1', '2', '2', '1', '0', '2', '0', '0', '0', '0', '', null, '', null, null, '0', null, null, null, '0', null, null, null, '0', null, null);
INSERT INTO `sys_rebate_strategy` VALUES ('2215520224935970', '0', '0', '', '0', '2', null, 'DAY', '4', '1', '2', '2', '1', '0', '2', '0', '0', '0', '0', '', null, '', null, null, '0', null, null, null, '0', null, null, null, '0', null, null);
INSERT INTO `sys_rebate_strategy` VALUES ('2215520224935971', '0', '0', '', '0', '3', null, 'MONTH', '2', '1', '2', '2', '1', '0', '2', '0', '0', '0', '0', '', null, '', null, null, '0', null, null, null, '0', null, null, null, '0', null, null);
INSERT INTO `sys_rebate_strategy` VALUES ('2215520224935972', '0', '0', '', '0', '1', null, 'MONTH', '0', '1', '2', '2', '3', '0', '2', '0', '0', '0', '0', '', null, '', null, null, '0', null, null, null, '0', null, null, null, '0', null, null);
INSERT INTO `sys_rebate_strategy` VALUES ('2215520224935973', null, null, null, '0', '3', '33', null, '2316', '4', '5', '0', '3', null, '5', null, null, null, null, null, null, null, null, null, '0', null, null, null, '0', null, null, null, '0', null, null);
INSERT INTO `sys_rebate_strategy` VALUES ('2215520224935974', '0', '0', '', '0', '3', '33', '', '2316', '4', '5', '1417', '3', '0', '5', '0', '0', '0', '0', '', null, '', null, null, '0', null, null, null, '0', null, null, null, '0', null, null);
INSERT INTO `sys_rebate_strategy` VALUES ('2215520224935975', '0', '0', '', '0', '3', '33', '', '2316', '4', '5', '1417', '3', '0', '5', '0', '0', '0', '0', '', null, '', null, null, '0', null, null, null, '0', null, null, null, '0', null, null);
INSERT INTO `sys_rebate_strategy` VALUES ('2215520224935976', '0', '0', '', '0', '2', null, 'CURRENT', '3', '1', '2', '3', '1', '0', '2', '0', '0', '0', '0', '', null, '', null, null, '0', null, null, null, '0', null, null, null, '0', null, null);
INSERT INTO `sys_rebate_strategy` VALUES ('2215520224935977', '0', '0', '', '0', '2', null, 'CURRENT', '0', '1', '2', '3', '2', '0', '2', '0', '0', '0', '0', '', null, '', null, null, '0', null, null, null, '0', null, null, null, '0', null, null);
INSERT INTO `sys_rebate_strategy` VALUES ('2215520224935978', '0', '0', '', '0', '1', null, 'MONTH', '3', '1', '2', '3', '2', '0', '2', '0', '0', '0', '0', '', null, '', null, null, '0', null, null, null, '0', null, null, null, '0', null, null);
INSERT INTO `sys_rebate_strategy` VALUES ('2215520224935979', '0', '0', '', '0', '1', null, 'WEEK', '0', '1', '2', '3', '1', '0', '2', '0', '0', '0', '0', '', null, '', null, null, '0', null, null, null, '0', null, null, null, '0', null, null);
INSERT INTO `sys_rebate_strategy` VALUES ('2215520224935980', '0', '0', '', '0', '3', null, 'MONTH', '1', '1', '2', '2', '1', '0', '2', '0', '0', '0', '0', '', null, '', null, null, '0', null, null, null, '0', null, null, null, '0', null, null);
INSERT INTO `sys_rebate_strategy` VALUES ('2215520224935981', '0', '0', '', '0', '3', null, 'MONTH', '0', '1', '2', '2', '3', '0', '2', '0', '0', '0', '0', '', null, '', null, null, '0', null, null, null, '0', null, null, null, '0', null, null);
INSERT INTO `sys_rebate_strategy` VALUES ('2215520224935982', '0', '0', '', '0', '3', '1', 'YEAR', '3', '1', '2', '3', '2', '0', '2', '0', '0', '0', '0', '', null, '', null, null, '0', null, null, null, '0', null, null, null, '0', null, null);
INSERT INTO `sys_rebate_strategy` VALUES ('2215520224935983', '0', '0', '', '0', '3', '2', 'YEAR', '0', '1', '2', '3', '3', '0', '2', '0', '0', '0', '0', '', null, '', null, null, '0', null, null, null, '0', null, null, null, '0', null, null);
INSERT INTO `sys_rebate_strategy` VALUES ('2215520224935984', '0', '0', '', '0', '3', '1', 'YEAR', '3', '1', '2', '3', '2', '0', '2', '0', '0', '0', '0', '', null, '', null, null, '0', null, null, null, '0', null, null, null, '0', null, null);
INSERT INTO `sys_rebate_strategy` VALUES ('2215520224935985', '0', '0', '', '0', '3', '1', 'MONTH', '3', '1', '2', '3', '3', '0', '2', '0', '0', '0', '0', '', null, '', null, null, '0', null, null, null, '0', null, null, null, '0', null, null);
INSERT INTO `sys_rebate_strategy` VALUES ('2215520224935986', '0', '0', '', '0', null, null, '', '0', '1', null, '0', '0', '0', '0', '0', '0', '0', '0', '', null, '', null, null, '0', null, null, null, '0', null, null, null, '0', null, null);
INSERT INTO `sys_rebate_strategy` VALUES ('2215520224935987', '0', '0', '', '0', null, '1', 'DAY', '0', null, '1', '200', '1', '1', '1', '0', '0', '0', '0', '', null, '', null, null, '0', null, null, null, '0', null, null, null, '0', null, null);
INSERT INTO `sys_rebate_strategy` VALUES ('2215520224935988', '0', '2215520224935985', '成人(线上)(团)', '0', null, null, '', '0', null, '1', '100', '3', '1', '1', '0', '0', '0', '0', '', null, '', null, null, '0', null, null, null, '0', null, null, null, '0', null, null);
INSERT INTO `sys_rebate_strategy` VALUES ('2215520224935989', '0', '2215520224935986', '儿童(线上)(团)', '0', null, null, '', '0', null, '1', '100', '3', '1', '1', '0', '0', '0', '0', '', null, '', null, null, '0', null, null, null, '0', null, null, null, '0', null, null);
INSERT INTO `sys_rebate_strategy` VALUES ('2215520224935990', '0', '2215520224935986', '儿童(线上)(团)', '0', null, null, '', '0', null, '1', '11', '1', '1', '1', '0', '0', '0', '0', '', null, '', null, null, '0', null, null, null, '0', null, null, null, '0', null, null);
INSERT INTO `sys_rebate_strategy` VALUES ('2215520224935991', '0', '2215520224935985', '成人(线上)(团)', '0', null, '1', 'DAY', '0', null, '1', '4', '1', '1', '1', '0', '0', '0', '0', '', null, '', null, null, '0', null, null, null, '0', null, null, null, '0', null, null);
INSERT INTO `sys_rebate_strategy` VALUES ('2215520224935992', '0', '2215520224935986', '儿童(线上)(团)', '0', null, null, '', '0', null, '1', '13', '1', '1', '1', '0', '0', '0', '0', '', null, '', null, null, '0', null, null, null, '0', null, null, null, '0', null, null);
INSERT INTO `sys_rebate_strategy` VALUES ('2215520224935993', '0', '2215520224935987', '优惠(线上)(团)', '0', null, '2', '', '5', '1', '2', '2', '2', '1', '2', '0', '0', '0', '0', '', null, '', null, null, '0', null, null, null, '0', null, null, null, '0', null, null);
INSERT INTO `sys_rebate_strategy` VALUES ('2215520224935994', '0', '2215520224935988', '老人(线上)(团)', '0', null, null, '', '0', null, '1', '3', '1', '1', '1', '0', '0', '0', '0', '', null, '', null, null, '0', null, null, null, '0', null, null, null, '0', null, null);
INSERT INTO `sys_rebate_strategy` VALUES ('2215520224935995', '0', '2215520224936001', '啊啊啊啊啊', '0', null, null, '', '0', null, '1', '2', '1', '1', '1', '0', '0', '0', '0', '', null, '', null, null, '0', null, null, null, '0', null, null, null, '0', null, null);
INSERT INTO `sys_rebate_strategy` VALUES ('2215520224935996', '0', '2215520224936006', '啊啊啊啊啊', '0', null, null, '', '0', null, '1', '10', '1', '1', '1', '0', '0', '0', '0', '', null, '', null, null, '0', null, null, null, '0', null, null, null, '0', null, null);
INSERT INTO `sys_rebate_strategy` VALUES ('2215520224935997', '0', '0', '', '0', '1,2', null, '', '0', '1', null, '10', '3', '0', '1', '0', '0', '0', '0', '', null, '', null, null, '0', null, null, null, '0', null, null, null, '0', null, null);
INSERT INTO `sys_rebate_strategy` VALUES ('2215520224936001', '0', '2215520224935991', '优惠(线下)(团)', '0', 'H', null, '', '0', null, '1', '1', '1', '1', '1', '0', '0', '0', '0', '', null, '', null, null, '0', null, null, null, '0', null, null, null, '0', null, null);
INSERT INTO `sys_rebate_strategy` VALUES ('2215520224936002', '0', '2215520224935991', '优惠(线下)(团)', '0', 'DH', null, '', '0', null, '1', '2', '1', '1', '1', '0', '0', '0', '0', '', null, '', null, null, '0', null, null, null, '0', null, null, null, '0', null, null);
INSERT INTO `sys_rebate_strategy` VALUES ('2215520224936003', '0', '2215520224935991', '优惠(线下)(团)', '0', 'G', '1', 'DAY', '2', null, '2', '5', '1', '1', '1', '0', '0', '0', '0', '', null, '', null, null, '0', null, null, null, '0', null, null, null, '0', null, null);
INSERT INTO `sys_rebate_strategy` VALUES ('2215520224936004', '0', '2215520224935991', '优惠(线下)(团)', '0', 'H', '1', '', '0', null, '1', '0', '1', '0', '1', '0', '0', '0', '0', '', null, '', null, null, '0', null, null, null, '0', null, null, null, '0', null, null);
INSERT INTO `sys_rebate_strategy` VALUES ('2215520224936005', '0', '2215520224935991', '优惠(线下)(团)', '0', 'DH', null, '', '0', null, '1', '2', '1', '1', '1', '0', '0', '0', '0', '', null, '', null, null, '0', null, null, null, '0', null, null, null, '0', null, null);
INSERT INTO `sys_rebate_strategy` VALUES ('2215520224936006', '0', '2215520224935991', '优惠(线下)(团)', '0', 'G', '1', 'DAY', '0', null, '2', '5', '1', '1', '1', '0', '0', '0', '0', '', null, '', null, null, '0', null, null, null, '0', null, null, null, '0', null, null);
INSERT INTO `sys_rebate_strategy` VALUES ('2215520224936007', '0', '2215520224935991', '优惠(线下)(团)', '0', 'H', null, '', '0', null, '1', '1', '1', '1', '1', '0', '0', '0', '0', '', null, '', null, null, '0', null, null, null, '0', null, null, null, '0', null, null);
INSERT INTO `sys_rebate_strategy` VALUES ('2215520224936008', '0', '2215520224935991', '优惠(线下)(团)', '0', 'DH', null, '', '0', null, '1', '2', '1', '1', '1', '0', '0', '0', '0', '', null, '', null, null, '0', null, null, null, '0', null, null, null, '0', null, null);
INSERT INTO `sys_rebate_strategy` VALUES ('2215520224936009', '0', '2215520224935991', '优惠(线下)(团)', '0', 'G', '1', 'DAY', '0', null, '2', '5', '1', '1', '1', '0', '0', '0', '0', '', null, '', null, null, '0', null, null, null, '0', null, null, null, '0', null, null);
INSERT INTO `sys_rebate_strategy` VALUES ('2215520224936010', '0', '2215520224935991', '优惠(线下)(团)', '0', 'H', '1', '', '0', null, '1', '0', '1', '0', '1', '0', '0', '0', '0', '', null, '', null, null, '0', null, null, null, '0', null, null, null, '0', null, null);
INSERT INTO `sys_rebate_strategy` VALUES ('2215520224936011', '0', '2215520224935991', '优惠(线下)(团)', '0', 'DH', null, '', '0', null, '1', '2', '1', '1', '1', '0', '0', '0', '0', '', null, '', null, null, '0', null, null, null, '0', null, null, null, '0', null, null);
INSERT INTO `sys_rebate_strategy` VALUES ('2215520224936012', '0', '2215520224935991', '优惠(线下)(团)', '0', 'G', '1', 'DAY', '0', null, '2', '5', '1', '1', '1', '0', '0', '0', '0', '', null, '', null, null, '0', null, null, null, '0', null, null, null, '0', null, null);
INSERT INTO `sys_rebate_strategy` VALUES ('2215520224936013', '0', '2215520224935991', '优惠(线下)(团)', '0', 'H', '1', '', '0', null, '1', '0', '1', '0', '1', '0', '0', '0', '0', '', null, '', null, null, '0', null, null, null, '0', null, null, null, '0', null, null);
INSERT INTO `sys_rebate_strategy` VALUES ('2215520224936014', '0', '2215520224935991', '优惠(线下)(团)', '0', 'DH', '1', '', '0', null, '1', '0', '1', '0', '1', '0', '0', '0', '0', '', null, '', null, null, '0', null, null, null, '0', null, null, null, '0', null, null);
INSERT INTO `sys_rebate_strategy` VALUES ('2215520224936015', '0', '2215520224935991', '优惠(线下)(团)', '0', 'G', '1', '', '0', null, '1', '0', '1', '0', '1', '0', '0', '0', '0', '', null, '', null, null, '0', null, null, null, '0', null, null, null, '0', null, null);
INSERT INTO `sys_rebate_strategy` VALUES ('2215520224936016', '0', '2215520224935991', '优惠(线下)(团)', '0', 'H', null, '', '0', null, '1', '1', '1', '1', '1', '0', '0', '0', '0', '', null, '', null, null, '0', null, null, null, '0', null, null, null, '0', null, null);
INSERT INTO `sys_rebate_strategy` VALUES ('2215520224936017', '0', '2215520224935991', '优惠(线下)(团)', '0', 'DH', null, '', '0', null, '1', '2', '1', '1', '1', '0', '0', '0', '0', '', null, '', null, null, '0', null, null, null, '0', null, null, null, '0', null, null);
INSERT INTO `sys_rebate_strategy` VALUES ('2215520224936018', '0', '2215520224935991', '优惠(线下)(团)', '0', 'G', '1', 'DAY', '0', null, '2', '5', '1', '1', '1', '0', '0', '0', '0', '', null, '', null, null, '0', null, null, null, '0', null, null, null, '0', null, null);
INSERT INTO `sys_rebate_strategy` VALUES ('2215520224936019', '0', '2215520224935991', '优惠(线下)(团)', '0', 'H', '1', '', '0', null, '1', '0', '1', '0', '1', '0', '0', '0', '0', '', null, '', null, null, '0', null, null, null, '0', null, null, null, '0', null, null);
INSERT INTO `sys_rebate_strategy` VALUES ('2215520224936020', '0', '2215520224935991', '优惠(线下)(团)', '0', 'DH', null, '', '0', null, '1', '2', '1', '1', '1', '0', '0', '0', '0', '', null, '', null, null, '0', null, null, null, '0', null, null, null, '0', null, null);
INSERT INTO `sys_rebate_strategy` VALUES ('2215520224936021', '0', '2215520224935991', '优惠(线下)(团)', '0', 'G', '1', 'DAY', '0', null, '2', '5', '1', '1', '1', '0', '0', '0', '0', '', null, '', null, null, '0', null, null, null, '0', null, null, null, '0', null, null);
INSERT INTO `sys_rebate_strategy` VALUES ('2215520224936022', '0', '2215520224935991', '优惠(线下)(团)', '0', 'H', '1', '', '0', null, '1', '0', '1', '0', '1', '0', '0', '0', '0', '', null, '', null, null, '0', null, null, null, '0', null, null, null, '0', null, null);
INSERT INTO `sys_rebate_strategy` VALUES ('2215520224936023', '0', '2215520224935991', '优惠(线下)(团)', '0', 'DH', '1', '', '0', null, '1', '0', '1', '0', '1', '0', '0', '0', '0', '', null, '', null, null, '0', null, null, null, '0', null, null, null, '0', null, null);
INSERT INTO `sys_rebate_strategy` VALUES ('2215520224936024', '0', '2215520224935991', '优惠(线下)(团)', '0', 'G', '1', '', '0', null, '1', '0', '1', '0', '1', '0', '0', '0', '0', '', null, '', null, null, '0', null, null, null, '0', null, null, null, '0', null, null);
INSERT INTO `sys_rebate_strategy` VALUES ('2215520224936025', '0', '2215520224935991', '优惠(线下)(团)', '0', 'H', null, '', '0', null, '1', '1', '1', '1', '1', '0', '0', '0', '0', '', null, '', null, null, '0', null, null, null, '0', null, null, null, '0', null, null);
INSERT INTO `sys_rebate_strategy` VALUES ('2215520224936026', '0', '2215520224935991', '优惠(线下)(团)', '0', 'DH', null, '', '0', null, '1', '2', '1', '1', '1', '0', '0', '0', '0', '', null, '', null, null, '0', null, null, null, '0', null, null, null, '0', null, null);
INSERT INTO `sys_rebate_strategy` VALUES ('2215520224936027', '0', '2215520224935991', '优惠(线下)(团)', '0', 'G', '1', 'DAY', '0', null, '2', '5', '1', '1', '1', '0', '0', '0', '0', '', null, '', null, null, '0', null, null, null, '0', null, null, null, '0', null, null);
INSERT INTO `sys_rebate_strategy` VALUES ('2215520224936028', '0', '2215520224935991', '优惠(线下)(团)', '0', 'H', '1', '', '0', null, '1', '0', '1', '0', '1', '0', '0', '0', '0', '', null, '', null, null, '0', null, null, null, '0', null, null, null, '0', null, null);
INSERT INTO `sys_rebate_strategy` VALUES ('2215520224936029', '0', '2215520224935991', '优惠(线下)(团)', '0', 'DH', null, '', '0', null, '1', '2', '1', '1', '1', '0', '0', '0', '0', '', null, '', null, null, '0', null, null, null, '0', null, null, null, '0', null, null);
INSERT INTO `sys_rebate_strategy` VALUES ('2215520224936030', '0', '2215520224935991', '优惠(线下)(团)', '0', 'G', '1', 'DAY', '0', null, '2', '5', '1', '1', '1', '0', '0', '0', '0', '', null, '', null, null, '0', null, null, null, '0', null, null, null, '0', null, null);
INSERT INTO `sys_rebate_strategy` VALUES ('2215520224936031', '0', '2215520224935991', '优惠(线下)(团)', '0', 'H', '1', '', '0', null, '1', '0', '1', '0', '1', '0', '0', '0', '0', '', null, '', null, null, '0', null, null, null, '0', null, null, null, '0', null, null);
INSERT INTO `sys_rebate_strategy` VALUES ('2215520224936032', '0', '2215520224935991', '优惠(线下)(团)', '0', 'DH', '1', '', '0', null, '1', '0', '1', '0', '1', '0', '0', '0', '0', '', null, '', null, null, '0', null, null, null, '0', null, null, null, '0', null, null);
INSERT INTO `sys_rebate_strategy` VALUES ('2215520224936033', '0', '2215520224935991', '优惠(线下)(团)', '0', 'G', '1', '', '0', null, '1', '0', '1', '0', '1', '0', '0', '0', '0', '', null, '', null, null, '0', null, null, null, '0', null, null, null, '0', null, null);
INSERT INTO `sys_rebate_strategy` VALUES ('2215520224936034', '0', '2215520224935995', '优惠(线上)(散)', '0', 'P', null, '', '0', null, '1', '2', '1', '1', '1', '0', '0', '0', '0', '', null, '', null, null, '0', null, null, null, '0', null, null, null, '0', null, null);
INSERT INTO `sys_rebate_strategy` VALUES ('2215520224936035', '0', '0', '', '0', 'H', null, '', '0', '1', '1', '1', '3', '0', '2', '0', '0', '0', '0', '', null, '', null, null, '0', null, null, null, '0', null, null, null, '0', null, null);
INSERT INTO `sys_rebate_strategy` VALUES ('2215520224936036', '0', '2215520224936071', '成人(线上)(团)', '0', 'H', '2', '', '0', null, '1', '0', '1', '0', '1', '0', '0', '0', '0', '', null, '', null, null, '0', null, null, null, '0', null, null, null, '0', null, null);
INSERT INTO `sys_rebate_strategy` VALUES ('2215520224936037', '0', '2215520224936071', '成人(线上)(团)', '0', 'DH', '1', '', '0', null, '2', '0', '1', '0', '2', '0', '0', '0', '0', '', null, '', null, null, '0', null, null, null, '0', null, null, null, '0', null, null);
INSERT INTO `sys_rebate_strategy` VALUES ('2215520224936038', '0', '2215520224936071', '成人(线上)(团)', '0', 'G', null, '', '0', null, '1', '20', '3', '1', '2', '0', '0', '0', '0', '', null, '', null, null, '0', null, null, null, '0', null, null, null, '0', null, null);
INSERT INTO `sys_rebate_strategy` VALUES ('2215520224936039', '0', '2215520224936071', '成人(线上)(团)', '0', 'H', '2', '', '0', null, '1', '0', '1', '0', '1', '0', '0', '0', '0', '', null, '', null, null, '0', null, null, null, '0', null, null, null, '0', null, null);
INSERT INTO `sys_rebate_strategy` VALUES ('2215520224936040', '0', '2215520224936071', '成人(线上)(团)', '0', 'DH', '1', '', '0', null, '2', '0', '2', '0', '1', '0', '0', '0', '0', '', null, '', null, null, '0', null, null, null, '0', null, null, null, '0', null, null);
INSERT INTO `sys_rebate_strategy` VALUES ('2215520224936041', '0', '2215520224936071', '成人(线上)(团)', '0', 'G', null, '', '0', null, '1', '20', '2', '1', '1', '0', '0', '0', '0', '', null, '', null, null, '0', null, null, null, '0', null, null, null, '0', null, null);
INSERT INTO `sys_rebate_strategy` VALUES ('2215520224936042', '0', '2215520224936002', '啊啊啊啊啊', '0', 'P', null, '', '0', null, '1', '10000', '2', '1', '2', '0', '0', '0', '0', '', null, '', null, null, '0', null, null, null, '0', null, null, null, '0', null, null);
INSERT INTO `sys_rebate_strategy` VALUES ('2215520224936043', '0', '0', '', '0', 'H', null, '', '0', '1', '1', '1', '1', '0', '1', '0', '0', '0', '0', '', null, '', null, null, '0', null, null, null, '0', null, null, null, '0', null, null);
INSERT INTO `sys_rebate_strategy` VALUES ('2215520224936044', '0', '2215520224936049', '老人票(线上)(团)', '0', 'H', null, '', '0', null, '1', '1', '0', '1', '1', '0', '0', '0', '0', '', null, '', null, null, '0', null, null, null, '0', null, null, null, '0', null, null);
INSERT INTO `sys_rebate_strategy` VALUES ('2215520224936045', '0', '2215520224936049', '老人票(线上)(团)', '0', 'DH', '1', '', '0', null, '1', '0', '0', '0', '1', '0', '0', '0', '0', '', null, '', null, null, '0', null, null, null, '0', null, null, null, '0', null, null);
INSERT INTO `sys_rebate_strategy` VALUES ('2215520224936046', '0', '2215520224936049', '老人票(线上)(团)', '0', 'G', '1', '', '0', null, '1', '0', '0', '0', '1', '0', '0', '0', '0', '', null, '', null, null, '0', null, null, null, '0', null, null, null, '0', null, null);
INSERT INTO `sys_rebate_strategy` VALUES ('2215520224936047', '0', '0', '', '0', null, null, '', '0', '1', null, '0', '0', '0', '0', '0', '0', '0', '0', '', null, '', null, null, '0', null, null, null, '0', null, null, null, '0', null, null);
INSERT INTO `sys_rebate_strategy` VALUES ('2215520224936048', '0', '0', '', '0', null, null, '', '0', '1', null, '0', '0', '0', '0', '0', '0', '0', '0', '', null, '', null, null, '0', null, null, null, '0', null, null, null, '0', null, null);
INSERT INTO `sys_rebate_strategy` VALUES ('2215520224936049', '0', '0', '', '0', 'D', null, '', '0', '1', null, '20', '1', '0', '1', '0', '0', '0', '0', '', null, '', null, null, '0', null, null, null, '0', null, null, null, '0', null, null);
INSERT INTO `sys_rebate_strategy` VALUES ('2215520224936050', '0', '0', '', '0', 'G', null, 'YEAR', '0', '1', '1', '20', '3', '0', '2', '0', '0', '0', '0', '', null, '', null, null, '0', null, null, null, '0', null, null, null, '0', null, null);
INSERT INTO `sys_rebate_strategy` VALUES ('2215520224936051', '0', '0', '', '0', 'D', null, '', '0', '1', null, '10', '1', '0', '1', '0', '0', '0', '0', '', null, '', null, null, '0', null, null, null, '0', null, null, null, '0', null, null);
INSERT INTO `sys_rebate_strategy` VALUES ('2215520224936052', '0', '0', '', '0', 'G', null, 'YEAR', '0', '1', '1', '20', '3', '0', '2', '0', '0', '0', '0', '', null, '', null, null, '0', null, null, null, '0', null, null, null, '0', null, null);
INSERT INTO `sys_rebate_strategy` VALUES ('2215520224936053', '0', '0', '', '0', null, null, '', '0', '1', null, '0', '0', '0', '0', '0', '0', '0', '0', '', null, '', null, null, '0', null, null, null, '0', null, null, null, '0', null, null);
INSERT INTO `sys_rebate_strategy` VALUES ('2215520224936054', '0', '2215520224935990', '儿童(线下)(团)', '0', 'H', '1', '', '0', null, '1', '0', '1', '0', '1', '0', '0', '0', '0', '', null, '', null, null, '0', null, null, null, '0', null, null, null, '0', null, null);
INSERT INTO `sys_rebate_strategy` VALUES ('2215520224936055', '0', '2215520224935990', '儿童(线下)(团)', '0', 'DH', '1', '', '0', null, '1', '0', '1', '0', '1', '0', '0', '0', '0', '', null, '', null, null, '0', null, null, null, '0', null, null, null, '0', null, null);
INSERT INTO `sys_rebate_strategy` VALUES ('2215520224936056', '0', '2215520224935990', '儿童(线下)(团)', '0', 'G', '1', '', '0', null, '1', '0', '1', '0', '1', '0', '0', '0', '0', '', null, '', null, null, '0', null, null, null, '0', null, null, null, '0', null, null);
INSERT INTO `sys_rebate_strategy` VALUES ('2215520224936057', '0', '2215520224935992', '老人(线下)(团)', '0', 'H', null, '', '0', null, '1', '100', '0', '1', '1', '0', '0', '0', '0', '', null, '', null, null, '0', null, null, null, '0', null, null, null, '0', null, null);
INSERT INTO `sys_rebate_strategy` VALUES ('2215520224936058', '0', '2215520224935992', '老人(线下)(团)', '0', 'DH', '1', '', '0', null, '1', '0', '0', '0', '1', '0', '0', '0', '0', '', null, '', null, null, '0', null, null, null, '0', null, null, null, '0', null, null);
INSERT INTO `sys_rebate_strategy` VALUES ('2215520224936059', '0', '2215520224935992', '老人(线下)(团)', '0', 'G', '1', '', '0', null, '1', '0', '0', '0', '1', '0', '0', '0', '0', '', null, '', null, null, '0', null, null, null, '0', null, null, null, '0', null, null);
INSERT INTO `sys_rebate_strategy` VALUES ('2215520224936060', '0', '2215520224935989', '成人(线下)(团)', '0', 'H', null, '', '0', null, '1', '100', '0', '1', '1', '0', '0', '0', '0', '', null, '', null, null, '0', null, null, null, '0', null, null, null, '0', null, null);
INSERT INTO `sys_rebate_strategy` VALUES ('2215520224936061', '0', '2215520224935989', '成人(线下)(团)', '0', 'DH', '1', '', '0', null, '1', '0', '0', '0', '1', '0', '0', '0', '0', '', null, '', null, null, '0', null, null, null, '0', null, null, null, '0', null, null);
INSERT INTO `sys_rebate_strategy` VALUES ('2215520224936062', '0', '2215520224935989', '成人(线下)(团)', '0', 'G', '1', '', '0', null, '1', '0', '0', '0', '1', '0', '0', '0', '0', '', null, '', null, null, '0', null, null, null, '0', null, null, null, '0', null, null);
INSERT INTO `sys_rebate_strategy` VALUES ('2215520224936063', '0', '2215520224936004', '啊啊啊啊啊', '0', 'P', null, '', '0', null, '1', '30', '1', '1', '1', '0', '0', '0', '0', '', null, '', null, null, '0', null, null, null, '0', null, null, null, '0', null, null);
INSERT INTO `sys_rebate_strategy` VALUES ('2215520224936064', '0', '0', '', '0', null, null, '', '0', '1', null, '0', '0', '0', '0', '0', '0', '0', '0', '', null, '', null, null, '0', null, null, null, '0', null, null, null, '0', null, null);
INSERT INTO `sys_rebate_strategy` VALUES ('2215520224936065', '0', '0', '', '0', null, null, '', '0', '1', null, '0', '0', '0', '0', '0', '0', '0', '0', '', null, '', null, null, '0', null, null, null, '0', null, null, null, '0', null, null);
INSERT INTO `sys_rebate_strategy` VALUES ('2215520224936066', '0', '0', '', '0', null, null, '', '0', '1', null, '0', '0', '0', '0', '0', '0', '0', '0', '', null, '', null, null, '0', null, null, null, '0', null, null, null, '0', null, null);
INSERT INTO `sys_rebate_strategy` VALUES ('2215520224936067', '0', '0', '', '0', null, null, '', '0', '1', null, '0', '0', '0', '0', '0', '0', '0', '0', '', null, '', null, null, '0', null, null, null, '0', null, null, null, '0', null, null);
INSERT INTO `sys_rebate_strategy` VALUES ('2215520224936068', '0', '0', '', '0', '地接部门D', null, '', '0', null, null, '5', '0', '1', '2', '1', '0', '0', '0', 'bate', '2015-12-05 14:52:52', '', null, null, '1', null, null, null, '0', null, null, null, '0', null, null);
INSERT INTO `sys_rebate_strategy` VALUES ('2215520224936069', '0', '0', '', '0', null, null, '', '0', '1', null, '0', '0', '0', '0', '0', '0', '0', '0', '', null, '', null, null, '0', null, null, null, '0', null, null, null, '0', null, null);
INSERT INTO `sys_rebate_strategy` VALUES ('2215520224936070', '0', '0', '', '0', null, null, '', '0', '1', null, '0', '0', '0', '0', '0', '0', '0', '0', '', null, '', null, null, '0', null, null, null, '0', null, null, null, '0', null, null);
INSERT INTO `sys_rebate_strategy` VALUES ('2215520224936071', '0', '0', '', '0', null, null, '', '0', '1', null, '0', '0', '0', '0', '0', '0', '0', '0', '', null, '', null, null, '0', null, null, null, '0', null, null, null, '0', null, null);
INSERT INTO `sys_rebate_strategy` VALUES ('2215520224936072', '0', '0', '', '0', null, null, '', '0', '1', null, '0', '0', '0', '0', '0', '0', '0', '0', '', null, '', null, null, '0', null, null, null, '0', null, null, null, '0', null, null);
INSERT INTO `sys_rebate_strategy` VALUES ('2215520224936073', '0', '0', '', '0', null, null, '', '0', '1', null, '0', '0', '0', '0', '0', '0', '0', '0', '', null, '', null, null, '0', null, null, null, '0', null, null, null, '0', null, null);
INSERT INTO `sys_rebate_strategy` VALUES ('2215520224936074', '0', '0', '', '0', null, null, '', '0', '1', null, '0', '0', '0', '0', '0', '0', '0', '0', '', null, '', null, null, '0', null, null, null, '0', null, null, null, '0', null, null);
INSERT INTO `sys_rebate_strategy` VALUES ('2215520224936075', '0', '0', '', '0', null, null, '', '0', '1', null, '0', '0', '0', '0', '0', '0', '0', '0', '', null, '', null, null, '0', null, null, null, '0', null, null, null, '0', null, null);
INSERT INTO `sys_rebate_strategy` VALUES ('2215520224936076', '0', '0', '', '0', null, null, '', '0', '1', null, '0', '0', '0', '0', '0', '0', '0', '0', '', null, '', null, null, '0', null, null, null, '0', null, null, null, '0', null, null);

-- ----------------------------
-- Table structure for `sys_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` bigint(20) NOT NULL COMMENT '编号',
  `name` varchar(100) NOT NULL COMMENT '角色名称',
  `type` varchar(45) DEFAULT NULL COMMENT '角色类型',
  `data_scope` char(1) DEFAULT NULL COMMENT '数据范围/角色级别',
  `create_by` varchar(64) DEFAULT NULL COMMENT '创建者',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT NULL COMMENT '更新者',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  `del_flag` char(1) NOT NULL DEFAULT '0' COMMENT '删除标记1：删除',
  `data_source` varchar(45) DEFAULT NULL COMMENT '数据来源',
  `is_bingding` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `sys_role_del_flag` (`del_flag`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('2215520224936031', '西门（勿删谢谢）', '1', null, '管理员', '2015-12-04 13:16:53', null, '2015-12-07 10:16:42', '2', '1', null, null);
INSERT INTO `sys_role` VALUES ('2215520224936032', '2', '1', null, '管理员', '2015-12-04 13:17:01', null, '2015-12-05 14:42:39', '2', '1', null, null);
INSERT INTO `sys_role` VALUES ('2215520224936033', '3', '1', null, '管理员', '2015-12-04 13:17:09', null, '2015-12-05 14:42:39', '3', '1', null, null);
INSERT INTO `sys_role` VALUES ('2215520224936034', '4', '1', null, '管理员', '2015-12-04 13:17:17', null, '2015-12-05 14:42:39', '4', '1', null, null);
INSERT INTO `sys_role` VALUES ('2215520224936035', '5', '1', null, '管理员', '2015-12-04 13:17:27', null, '2015-12-05 14:42:39', '5', '1', null, null);
INSERT INTO `sys_role` VALUES ('2215520224936036', '6', '1', null, '管理员', '2015-12-04 13:17:39', null, '2015-12-05 14:42:39', '6', '1', null, null);
INSERT INTO `sys_role` VALUES ('2215520224936037', '7', '1', null, '管理员', '2015-12-04 13:17:44', null, '2015-12-07 10:16:42', '7', '1', null, null);
INSERT INTO `sys_role` VALUES ('2215520224936038', '8', '1', null, '管理员', '2015-12-04 13:17:50', null, '2015-12-05 14:42:39', '8', '1', null, null);
INSERT INTO `sys_role` VALUES ('2215520224936039', '9', '1', null, '管理员', '2015-12-04 13:17:55', null, '2015-12-06 22:21:56', '9', '1', null, null);
INSERT INTO `sys_role` VALUES ('2215520224936040', '10', '1', null, '管理员', '2015-12-04 13:18:04', null, '2015-12-06 22:21:56', '10', '1', null, null);
INSERT INTO `sys_role` VALUES ('2215520224936041', '11', '1', null, '管理员', '2015-12-04 13:18:12', null, '2015-12-05 14:42:46', '11', '1', null, null);
INSERT INTO `sys_role` VALUES ('2215520224936042', '12', '1', null, '管理员', '2015-12-04 13:18:21', null, '2015-12-05 14:42:46', '12', '1', null, null);
INSERT INTO `sys_role` VALUES ('2215520224936043', 'nn_10161400', '1', '', 'admin2', '2015-12-04 14:00:12', 'admin2', '2015-12-05 14:42:46', '', '1', '', null);
INSERT INTO `sys_role` VALUES ('2215520224936044', '岗位名称1', '1', null, '管理员', '2015-12-04 14:59:46', null, '2015-12-05 14:42:46', '岗位信息1', '1', null, null);
INSERT INTO `sys_role` VALUES ('2215520224936049', '岗位名称2', '1', null, '管理员', '2015-12-04 15:17:03', null, null, '无', '1', null, null);
INSERT INTO `sys_role` VALUES ('2215520224936050', '岗位名称3', '1', null, '管理员', '2015-12-04 15:22:23', null, null, '无', '1', null, null);
INSERT INTO `sys_role` VALUES ('2215520224936051', '岗位名称4', '1', null, '管理员', '2015-12-04 15:23:18', null, '2015-12-04 15:57:40', '无', '1', null, null);
INSERT INTO `sys_role` VALUES ('2215520224936053', 'abcdefghij', '2', null, null, '2015-12-05 00:07:36', null, '2015-12-04 16:07:34', null, '1', '4', null);
INSERT INTO `sys_role` VALUES ('2215520224936054', '哈哈哈哈哈哈哈哈哈哈', '1', null, null, '2015-12-05 00:12:44', null, null, null, '1', '1', null);
INSERT INTO `sys_role` VALUES ('2215520224936055', '1', '2', null, null, '2015-12-05 00:12:54', null, '2015-12-04 16:23:00', null, '1', '4', null);
INSERT INTO `sys_role` VALUES ('2215520224936056', '1', '1', null, null, '2015-12-05 00:13:18', null, null, null, '1', '1', null);
INSERT INTO `sys_role` VALUES ('2215520224936065', '再顺便说一句nn_10161400', '1', '', 'admin2', '2015-12-04 17:26:24', 'admin2', '2015-12-05 14:42:46', '', '1', '', null);
INSERT INTO `sys_role` VALUES ('2215520224936067', '测试测试', '1', null, null, '2015-12-04 17:49:38', null, null, null, '1', '1', null);
INSERT INTO `sys_role` VALUES ('2215520224936068', '客栈供应商', '2', '3', null, '2015-12-04 18:25:50', null, null, null, '1', '1', null);
INSERT INTO `sys_role` VALUES ('2215520224936069', '景区供应商', '2', '4', null, '2015-12-04 18:25:50', null, null, null, '1', '1', null);
INSERT INTO `sys_role` VALUES ('2215520224936070', '支撑平台管理员', '1', '1', null, '2015-12-04 18:25:56', null, '2015-12-04 18:24:44', null, '1', '1', null);
INSERT INTO `sys_role` VALUES ('2215520224936071', '客服巡查', '1', null, '管理员', '2015-12-04 21:24:17', null, '2015-12-04 21:24:36', '无', '1', null, null);
INSERT INTO `sys_role` VALUES ('2215520224936072', '南门', '1', null, '管理员', '2015-12-05 14:43:13', null, '2015-12-05 14:42:06', '单元没问题', '1', null, null);
INSERT INTO `sys_role` VALUES ('2215520224936073', '岗位名称1205', '1', null, '管理员', '2015-12-05 16:57:32', null, '2015-12-05 16:57:00', '岗位信息1205', '1', null, null);
INSERT INTO `sys_role` VALUES ('2215520224936074', 'test_test', '1', '', 'admin22', '2015-12-05 17:49:08', 'admin22', '0000-00-00 00:00:00', '333', '1', '', null);
INSERT INTO `sys_role` VALUES ('2215520224936075', 'test_test', '1', '', 'admin22', '2015-12-05 17:49:08', 'admin22', '0000-00-00 00:00:00', '333', '1', '', null);
INSERT INTO `sys_role` VALUES ('2215520224936076', 'nn_10161400', '1', '', 'admin2', '2015-12-05 17:49:11', 'admin2', '0000-00-00 00:00:00', '', '1', '', null);
INSERT INTO `sys_role` VALUES ('2215520224936077', '张翔鹏6号1岗位', '1', null, '管理员', '2015-12-06 15:25:39', null, '2015-12-07 10:19:30', '张翔鹏6号1岗位信息', '1', null, null);
INSERT INTO `sys_role` VALUES ('2215520224936078', '张翔鹏6号2岗位', '1', null, '管理员', '2015-12-06 15:25:48', null, '2015-12-07 10:19:30', '张翔鹏6号2岗位', '1', null, null);
INSERT INTO `sys_role` VALUES ('2215520224936080', '代供销平台管理员', '1', '2', null, '2015-12-06 16:30:43', null, '2015-12-06 16:30:18', null, '1', '2', null);
INSERT INTO `sys_role` VALUES ('2215520224936081', '测试角色', '1', '1', 'admin2', '2015-12-07 10:30:09', 'admin2', '0000-00-00 00:00:00', '111', '1', '', null);
INSERT INTO `sys_role` VALUES ('2215520224936082', '测试角色', '1', '1', 'admin2', '2015-12-07 10:37:25', 'admin2', '0000-00-00 00:00:00', '111', '1', '', null);
INSERT INTO `sys_role` VALUES ('2215520224936083', '测试角色', '1', '1', 'admin2', '2015-12-07 10:48:23', 'admin2', '0000-00-00 00:00:00', '111', '1', '', null);
INSERT INTO `sys_role` VALUES ('2215520224936084', '测试角色', '1', '1', 'admin2', '2015-12-07 10:48:48', 'admin2', '0000-00-00 00:00:00', '111', '1', '', null);

-- ----------------------------
-- Table structure for `sys_role_menu`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `id` bigint(20) NOT NULL,
  `role_id` varchar(64) NOT NULL COMMENT '角色编号',
  `menu_id` varchar(64) NOT NULL COMMENT '菜单编号',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色-菜单';

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES ('2215520224935939', '2215520224935939', '2215520224935939');
INSERT INTO `sys_role_menu` VALUES ('2215520224935942', '2215520224935957', '2215520224936506');
INSERT INTO `sys_role_menu` VALUES ('2215520224935943', '2215520224935957', '2215520224936508');
INSERT INTO `sys_role_menu` VALUES ('2215520224935944', '2215520224935957', '2215520224936513');
INSERT INTO `sys_role_menu` VALUES ('2215520224935945', '2215520224935957', '2215520224936523');
INSERT INTO `sys_role_menu` VALUES ('2215520224935946', '2215520224935957', '2215520224936526');
INSERT INTO `sys_role_menu` VALUES ('2215520224935947', '2215520224935960', '2215520224936574');
INSERT INTO `sys_role_menu` VALUES ('2215520224935948', '2215520224935961', '2215520224936574');
INSERT INTO `sys_role_menu` VALUES ('2215520224935949', '2215520224935961', '2215520224936577');
INSERT INTO `sys_role_menu` VALUES ('2215520224935950', '2215520224935961', '2215520224936582');
INSERT INTO `sys_role_menu` VALUES ('2215520224935951', '2215520224935964', '2215520224936818');
INSERT INTO `sys_role_menu` VALUES ('2215520224935952', '2215520224935964', '2215520224936819');
INSERT INTO `sys_role_menu` VALUES ('2215520224935953', '2215520224935964', '2215520224936825');
INSERT INTO `sys_role_menu` VALUES ('2215520224935954', '2215520224935964', '2215520224936826');
INSERT INTO `sys_role_menu` VALUES ('2215520224935955', '2215520224935938', '2215520224936813');
INSERT INTO `sys_role_menu` VALUES ('2215520224935956', '2215520224935974', '2215520224936846');
INSERT INTO `sys_role_menu` VALUES ('2215520224935957', '2215520224935974', '2215520224936847');
INSERT INTO `sys_role_menu` VALUES ('2215520224935958', '2215520224935974', '2215520224936848');
INSERT INTO `sys_role_menu` VALUES ('2215520224935960', '2215520224935976', '2215520224936836');
INSERT INTO `sys_role_menu` VALUES ('2215520224935963', '2215520224935977', '2215520224936813');
INSERT INTO `sys_role_menu` VALUES ('2215520224935964', '2215520224935977', '2215520224936815');
INSERT INTO `sys_role_menu` VALUES ('2215520224935965', '2215520224935977', '2215520224936814');
INSERT INTO `sys_role_menu` VALUES ('2215520224935966', '2215520224935977', '2215520224936816');
INSERT INTO `sys_role_menu` VALUES ('2215520224935967', '2215520224935977', '2215520224936817');
INSERT INTO `sys_role_menu` VALUES ('2215520224935968', '2215520224935978', '2215520224936813');
INSERT INTO `sys_role_menu` VALUES ('2215520224935969', '2215520224935979', '2215520224936813');
INSERT INTO `sys_role_menu` VALUES ('2215520224935970', '2215520224935978', '2215520224936817');
INSERT INTO `sys_role_menu` VALUES ('2215520224935971', '2215520224935983', '2215520224936955');
INSERT INTO `sys_role_menu` VALUES ('2215520224935972', '2215520224935983', '2215520224936956');
INSERT INTO `sys_role_menu` VALUES ('2215520224935973', '2215520224935983', '2215520224936957');
INSERT INTO `sys_role_menu` VALUES ('2215520224935974', '2215520224935983', '2215520224936958');
INSERT INTO `sys_role_menu` VALUES ('2215520224935975', '2215520224935983', '2215520224936959');
INSERT INTO `sys_role_menu` VALUES ('2215520224935976', '2215520224935983', '2215520224936960');
INSERT INTO `sys_role_menu` VALUES ('2215520224935977', '2215520224935983', '2215520224936961');
INSERT INTO `sys_role_menu` VALUES ('2215520224935978', '2215520224935983', '2215520224936962');
INSERT INTO `sys_role_menu` VALUES ('2215520224935979', '2215520224935984', '2215520224936963');
INSERT INTO `sys_role_menu` VALUES ('2215520224935980', '2215520224935984', '2215520224936964');
INSERT INTO `sys_role_menu` VALUES ('2215520224935981', '2215520224935984', '2215520224936965');
INSERT INTO `sys_role_menu` VALUES ('2215520224935982', '2215520224935984', '2215520224936966');
INSERT INTO `sys_role_menu` VALUES ('2215520224935983', '2215520224935984', '2215520224936967');
INSERT INTO `sys_role_menu` VALUES ('2215520224935984', '2215520224935984', '2215520224936968');
INSERT INTO `sys_role_menu` VALUES ('2215520224935985', '2215520224935984', '2215520224936969');
INSERT INTO `sys_role_menu` VALUES ('2215520224935986', '2215520224935984', '2215520224936970');
INSERT INTO `sys_role_menu` VALUES ('2215520224936007', '2215520224935948', '499');
INSERT INTO `sys_role_menu` VALUES ('2215520224936008', '2215520224935948', '498');
INSERT INTO `sys_role_menu` VALUES ('2215520224936009', '2215520224935937', '551');
INSERT INTO `sys_role_menu` VALUES ('2215520224936010', '2215520224935937', '552');
INSERT INTO `sys_role_menu` VALUES ('2215520224936011', '2215520224935937', '553');
INSERT INTO `sys_role_menu` VALUES ('2215520224936029', '2215520224935995', '2215520224936818');
INSERT INTO `sys_role_menu` VALUES ('2215520224936030', '2215520224935995', '2215520224936819');
INSERT INTO `sys_role_menu` VALUES ('2215520224936031', '2215520224935995', '2215520224936820');
INSERT INTO `sys_role_menu` VALUES ('2215520224936032', '2215520224935995', '2215520224936821');
INSERT INTO `sys_role_menu` VALUES ('2215520224936033', '2215520224935995', '2215520224936822');
INSERT INTO `sys_role_menu` VALUES ('2215520224936034', '2215520224935995', '2215520224936823');
INSERT INTO `sys_role_menu` VALUES ('2215520224936035', '2215520224935995', '2215520224936824');
INSERT INTO `sys_role_menu` VALUES ('2215520224936036', '2215520224935995', '2215520224936825');
INSERT INTO `sys_role_menu` VALUES ('2215520224936037', '2215520224935995', '2215520224936826');
INSERT INTO `sys_role_menu` VALUES ('2215520224936038', '2215520224935995', '2215520224936827');
INSERT INTO `sys_role_menu` VALUES ('2215520224936039', '2215520224935995', '2215520224936828');
INSERT INTO `sys_role_menu` VALUES ('2215520224936040', '2215520224935995', '2215520224936829');
INSERT INTO `sys_role_menu` VALUES ('2215520224936041', '2215520224935995', '2215520224936830');
INSERT INTO `sys_role_menu` VALUES ('2215520224936042', '2215520224935995', '2215520224936831');
INSERT INTO `sys_role_menu` VALUES ('2215520224936043', '2215520224935995', '2215520224936832');
INSERT INTO `sys_role_menu` VALUES ('2215520224936044', '2215520224935995', '2215520224936833');
INSERT INTO `sys_role_menu` VALUES ('2215520224936045', '2215520224935995', '2215520224936834');
INSERT INTO `sys_role_menu` VALUES ('2215520224936046', '2215520224935995', '2215520224936835');
INSERT INTO `sys_role_menu` VALUES ('2215520224936047', '2215520224935995', '2215520224936836');
INSERT INTO `sys_role_menu` VALUES ('2215520224936048', '2215520224935995', '2215520224936837');
INSERT INTO `sys_role_menu` VALUES ('2215520224936049', '2215520224935995', '2215520224936838');
INSERT INTO `sys_role_menu` VALUES ('2215520224936050', '2215520224935995', '2215520224936839');
INSERT INTO `sys_role_menu` VALUES ('2215520224936051', '2215520224935995', '2215520224936840');
INSERT INTO `sys_role_menu` VALUES ('2215520224936052', '2215520224935995', '2215520224936841');
INSERT INTO `sys_role_menu` VALUES ('2215520224936053', '2215520224935995', '2215520224936842');
INSERT INTO `sys_role_menu` VALUES ('2215520224936054', '2215520224935995', '2215520224936843');
INSERT INTO `sys_role_menu` VALUES ('2215520224936055', '2215520224935995', '2215520224936862');
INSERT INTO `sys_role_menu` VALUES ('2215520224936056', '2215520224935995', '2215520224937123');
INSERT INTO `sys_role_menu` VALUES ('2215520224936057', '2215520224935995', '2215520224937124');
INSERT INTO `sys_role_menu` VALUES ('2215520224936058', '2215520224935995', '2215520224937179');
INSERT INTO `sys_role_menu` VALUES ('2215520224936059', '2215520224935995', '2215520224937125');
INSERT INTO `sys_role_menu` VALUES ('2215520224936060', '2215520224935995', '2215520224937126');
INSERT INTO `sys_role_menu` VALUES ('2215520224936061', '2215520224935995', '2215520224937127');
INSERT INTO `sys_role_menu` VALUES ('2215520224936062', '2215520224935995', '2215520224937128');
INSERT INTO `sys_role_menu` VALUES ('2215520224936063', '2215520224935995', '2215520224937154');
INSERT INTO `sys_role_menu` VALUES ('2215520224936064', '2215520224935995', '2215520224937155');
INSERT INTO `sys_role_menu` VALUES ('2215520224936065', '2215520224935995', '2215520224937156');
INSERT INTO `sys_role_menu` VALUES ('2215520224936066', '2215520224935995', '2215520224937157');
INSERT INTO `sys_role_menu` VALUES ('2215520224936067', '2215520224935995', '2215520224937158');
INSERT INTO `sys_role_menu` VALUES ('2215520224936068', '2215520224935995', '2215520224937159');
INSERT INTO `sys_role_menu` VALUES ('2215520224936069', '2215520224935995', '2215520224937160');
INSERT INTO `sys_role_menu` VALUES ('2215520224936070', '2215520224935996', '2215520224936818');
INSERT INTO `sys_role_menu` VALUES ('2215520224936071', '2215520224935996', '2215520224936819');
INSERT INTO `sys_role_menu` VALUES ('2215520224936072', '2215520224935996', '2215520224936820');
INSERT INTO `sys_role_menu` VALUES ('2215520224936073', '2215520224935996', '2215520224936821');
INSERT INTO `sys_role_menu` VALUES ('2215520224936074', '2215520224935996', '2215520224936822');
INSERT INTO `sys_role_menu` VALUES ('2215520224936075', '2215520224935996', '2215520224936823');
INSERT INTO `sys_role_menu` VALUES ('2215520224936076', '2215520224935996', '2215520224936824');
INSERT INTO `sys_role_menu` VALUES ('2215520224936077', '2215520224935996', '2215520224936825');
INSERT INTO `sys_role_menu` VALUES ('2215520224936078', '2215520224935996', '2215520224936826');
INSERT INTO `sys_role_menu` VALUES ('2215520224936079', '2215520224935996', '2215520224936827');
INSERT INTO `sys_role_menu` VALUES ('2215520224936080', '2215520224935996', '2215520224936828');
INSERT INTO `sys_role_menu` VALUES ('2215520224936081', '2215520224935996', '2215520224936829');
INSERT INTO `sys_role_menu` VALUES ('2215520224936082', '2215520224935996', '2215520224936830');
INSERT INTO `sys_role_menu` VALUES ('2215520224936083', '2215520224935996', '2215520224936831');
INSERT INTO `sys_role_menu` VALUES ('2215520224936084', '2215520224935996', '2215520224936832');
INSERT INTO `sys_role_menu` VALUES ('2215520224936085', '2215520224935996', '2215520224936833');
INSERT INTO `sys_role_menu` VALUES ('2215520224936086', '2215520224935996', '2215520224936834');
INSERT INTO `sys_role_menu` VALUES ('2215520224936087', '2215520224935996', '2215520224936835');
INSERT INTO `sys_role_menu` VALUES ('2215520224936088', '2215520224935996', '2215520224936836');
INSERT INTO `sys_role_menu` VALUES ('2215520224936089', '2215520224935996', '2215520224936837');
INSERT INTO `sys_role_menu` VALUES ('2215520224936090', '2215520224935996', '2215520224936838');
INSERT INTO `sys_role_menu` VALUES ('2215520224936091', '2215520224935996', '2215520224936839');
INSERT INTO `sys_role_menu` VALUES ('2215520224936092', '2215520224935996', '2215520224936840');
INSERT INTO `sys_role_menu` VALUES ('2215520224936093', '2215520224935996', '2215520224936841');
INSERT INTO `sys_role_menu` VALUES ('2215520224936094', '2215520224935996', '2215520224936842');
INSERT INTO `sys_role_menu` VALUES ('2215520224936095', '2215520224935996', '2215520224936843');
INSERT INTO `sys_role_menu` VALUES ('2215520224936097', '2215520224935996', '2215520224937123');
INSERT INTO `sys_role_menu` VALUES ('2215520224936098', '2215520224935996', '2215520224937124');
INSERT INTO `sys_role_menu` VALUES ('2215520224936100', '2215520224935996', '2215520224937125');
INSERT INTO `sys_role_menu` VALUES ('2215520224936101', '2215520224935996', '2215520224937126');
INSERT INTO `sys_role_menu` VALUES ('2215520224936102', '2215520224935996', '2215520224937127');
INSERT INTO `sys_role_menu` VALUES ('2215520224936103', '2215520224935996', '2215520224937128');
INSERT INTO `sys_role_menu` VALUES ('2215520224936104', '2215520224935996', '2215520224937154');
INSERT INTO `sys_role_menu` VALUES ('2215520224936105', '2215520224935996', '2215520224937155');
INSERT INTO `sys_role_menu` VALUES ('2215520224936106', '2215520224935996', '2215520224937156');
INSERT INTO `sys_role_menu` VALUES ('2215520224936107', '2215520224935996', '2215520224937157');
INSERT INTO `sys_role_menu` VALUES ('2215520224936108', '2215520224935996', '2215520224937158');
INSERT INTO `sys_role_menu` VALUES ('2215520224936109', '2215520224935996', '2215520224937159');
INSERT INTO `sys_role_menu` VALUES ('2215520224936110', '2215520224935996', '2215520224937160');
INSERT INTO `sys_role_menu` VALUES ('2215520224936111', '2215520224935997', '2215520224936818');
INSERT INTO `sys_role_menu` VALUES ('2215520224936112', '2215520224935997', '2215520224936819');
INSERT INTO `sys_role_menu` VALUES ('2215520224936113', '2215520224935997', '2215520224936820');
INSERT INTO `sys_role_menu` VALUES ('2215520224936114', '2215520224935997', '2215520224936821');
INSERT INTO `sys_role_menu` VALUES ('2215520224936115', '2215520224935997', '2215520224936822');
INSERT INTO `sys_role_menu` VALUES ('2215520224936116', '2215520224935997', '2215520224936823');
INSERT INTO `sys_role_menu` VALUES ('2215520224936117', '2215520224935997', '2215520224936824');
INSERT INTO `sys_role_menu` VALUES ('2215520224936118', '2215520224935997', '2215520224936825');
INSERT INTO `sys_role_menu` VALUES ('2215520224936119', '2215520224935997', '2215520224936826');
INSERT INTO `sys_role_menu` VALUES ('2215520224936120', '2215520224935997', '2215520224936827');
INSERT INTO `sys_role_menu` VALUES ('2215520224936121', '2215520224935997', '2215520224936828');
INSERT INTO `sys_role_menu` VALUES ('2215520224936122', '2215520224935997', '2215520224936829');
INSERT INTO `sys_role_menu` VALUES ('2215520224936123', '2215520224935997', '2215520224936830');
INSERT INTO `sys_role_menu` VALUES ('2215520224936124', '2215520224935997', '2215520224936831');
INSERT INTO `sys_role_menu` VALUES ('2215520224936125', '2215520224935997', '2215520224936832');
INSERT INTO `sys_role_menu` VALUES ('2215520224936126', '2215520224935997', '2215520224936833');
INSERT INTO `sys_role_menu` VALUES ('2215520224936127', '2215520224935997', '2215520224936834');
INSERT INTO `sys_role_menu` VALUES ('2215520224936128', '2215520224935997', '2215520224936835');
INSERT INTO `sys_role_menu` VALUES ('2215520224936129', '2215520224935997', '2215520224936836');
INSERT INTO `sys_role_menu` VALUES ('2215520224936130', '2215520224935997', '2215520224936837');
INSERT INTO `sys_role_menu` VALUES ('2215520224936131', '2215520224935997', '2215520224936838');
INSERT INTO `sys_role_menu` VALUES ('2215520224936132', '2215520224935997', '2215520224936839');
INSERT INTO `sys_role_menu` VALUES ('2215520224936133', '2215520224935997', '2215520224936840');
INSERT INTO `sys_role_menu` VALUES ('2215520224936134', '2215520224935997', '2215520224936841');
INSERT INTO `sys_role_menu` VALUES ('2215520224936135', '2215520224935997', '2215520224936842');
INSERT INTO `sys_role_menu` VALUES ('2215520224936136', '2215520224935997', '2215520224936843');
INSERT INTO `sys_role_menu` VALUES ('2215520224936137', '2215520224935997', '2215520224936862');
INSERT INTO `sys_role_menu` VALUES ('2215520224936138', '2215520224935997', '2215520224937123');
INSERT INTO `sys_role_menu` VALUES ('2215520224936139', '2215520224935997', '2215520224937124');
INSERT INTO `sys_role_menu` VALUES ('2215520224936140', '2215520224935997', '2215520224937179');
INSERT INTO `sys_role_menu` VALUES ('2215520224936141', '2215520224935997', '2215520224937125');
INSERT INTO `sys_role_menu` VALUES ('2215520224936142', '2215520224935997', '2215520224937126');
INSERT INTO `sys_role_menu` VALUES ('2215520224936143', '2215520224935997', '2215520224937127');
INSERT INTO `sys_role_menu` VALUES ('2215520224936144', '2215520224935997', '2215520224937128');
INSERT INTO `sys_role_menu` VALUES ('2215520224936145', '2215520224935997', '2215520224937154');
INSERT INTO `sys_role_menu` VALUES ('2215520224936146', '2215520224935997', '2215520224937155');
INSERT INTO `sys_role_menu` VALUES ('2215520224936147', '2215520224935997', '2215520224937156');
INSERT INTO `sys_role_menu` VALUES ('2215520224936148', '2215520224935997', '2215520224937157');
INSERT INTO `sys_role_menu` VALUES ('2215520224936149', '2215520224935997', '2215520224937158');
INSERT INTO `sys_role_menu` VALUES ('2215520224936150', '2215520224935997', '2215520224937159');
INSERT INTO `sys_role_menu` VALUES ('2215520224936151', '2215520224935997', '2215520224937160');
INSERT INTO `sys_role_menu` VALUES ('2215520224936152', '2215520224935998', '2215520224936818');
INSERT INTO `sys_role_menu` VALUES ('2215520224936153', '2215520224935998', '2215520224936819');
INSERT INTO `sys_role_menu` VALUES ('2215520224936154', '2215520224935998', '2215520224936820');
INSERT INTO `sys_role_menu` VALUES ('2215520224936155', '2215520224935998', '2215520224936821');
INSERT INTO `sys_role_menu` VALUES ('2215520224936156', '2215520224935998', '2215520224936822');
INSERT INTO `sys_role_menu` VALUES ('2215520224936157', '2215520224935998', '2215520224936823');
INSERT INTO `sys_role_menu` VALUES ('2215520224936158', '2215520224935998', '2215520224936824');
INSERT INTO `sys_role_menu` VALUES ('2215520224936159', '2215520224935998', '2215520224936825');
INSERT INTO `sys_role_menu` VALUES ('2215520224936160', '2215520224935998', '2215520224936826');
INSERT INTO `sys_role_menu` VALUES ('2215520224936161', '2215520224935998', '2215520224936827');
INSERT INTO `sys_role_menu` VALUES ('2215520224936162', '2215520224935998', '2215520224936828');
INSERT INTO `sys_role_menu` VALUES ('2215520224936163', '2215520224935998', '2215520224936829');
INSERT INTO `sys_role_menu` VALUES ('2215520224936164', '2215520224935998', '2215520224936830');
INSERT INTO `sys_role_menu` VALUES ('2215520224936165', '2215520224935998', '2215520224936831');
INSERT INTO `sys_role_menu` VALUES ('2215520224936166', '2215520224935998', '2215520224936832');
INSERT INTO `sys_role_menu` VALUES ('2215520224936167', '2215520224935998', '2215520224936833');
INSERT INTO `sys_role_menu` VALUES ('2215520224936168', '2215520224935998', '2215520224936834');
INSERT INTO `sys_role_menu` VALUES ('2215520224936169', '2215520224935998', '2215520224936835');
INSERT INTO `sys_role_menu` VALUES ('2215520224936170', '2215520224935998', '2215520224936836');
INSERT INTO `sys_role_menu` VALUES ('2215520224936171', '2215520224935998', '2215520224936837');
INSERT INTO `sys_role_menu` VALUES ('2215520224936172', '2215520224935998', '2215520224936838');
INSERT INTO `sys_role_menu` VALUES ('2215520224936173', '2215520224935998', '2215520224936839');
INSERT INTO `sys_role_menu` VALUES ('2215520224936174', '2215520224935998', '2215520224936840');
INSERT INTO `sys_role_menu` VALUES ('2215520224936175', '2215520224935998', '2215520224936841');
INSERT INTO `sys_role_menu` VALUES ('2215520224936176', '2215520224935998', '2215520224936842');
INSERT INTO `sys_role_menu` VALUES ('2215520224936177', '2215520224935998', '2215520224936843');
INSERT INTO `sys_role_menu` VALUES ('2215520224936178', '2215520224935998', '2215520224936862');
INSERT INTO `sys_role_menu` VALUES ('2215520224936179', '2215520224935998', '2215520224937123');
INSERT INTO `sys_role_menu` VALUES ('2215520224936180', '2215520224935998', '2215520224937124');
INSERT INTO `sys_role_menu` VALUES ('2215520224936182', '2215520224935998', '2215520224937125');
INSERT INTO `sys_role_menu` VALUES ('2215520224936183', '2215520224935998', '2215520224937126');
INSERT INTO `sys_role_menu` VALUES ('2215520224936184', '2215520224935998', '2215520224937127');
INSERT INTO `sys_role_menu` VALUES ('2215520224936185', '2215520224935998', '2215520224937128');
INSERT INTO `sys_role_menu` VALUES ('2215520224936186', '2215520224935998', '2215520224937154');
INSERT INTO `sys_role_menu` VALUES ('2215520224936187', '2215520224935998', '2215520224937155');
INSERT INTO `sys_role_menu` VALUES ('2215520224936188', '2215520224935998', '2215520224937156');
INSERT INTO `sys_role_menu` VALUES ('2215520224936189', '2215520224935998', '2215520224937157');
INSERT INTO `sys_role_menu` VALUES ('2215520224936190', '2215520224935998', '2215520224937158');
INSERT INTO `sys_role_menu` VALUES ('2215520224936191', '2215520224935998', '2215520224937159');
INSERT INTO `sys_role_menu` VALUES ('2215520224936192', '2215520224935998', '2215520224937160');
INSERT INTO `sys_role_menu` VALUES ('2215520224936193', '2215520224935999', '2215520224936818');
INSERT INTO `sys_role_menu` VALUES ('2215520224936194', '2215520224935999', '2215520224936819');
INSERT INTO `sys_role_menu` VALUES ('2215520224936195', '2215520224935999', '2215520224936820');
INSERT INTO `sys_role_menu` VALUES ('2215520224936196', '2215520224935999', '2215520224936821');
INSERT INTO `sys_role_menu` VALUES ('2215520224936197', '2215520224935999', '2215520224936822');
INSERT INTO `sys_role_menu` VALUES ('2215520224936198', '2215520224935999', '2215520224936823');
INSERT INTO `sys_role_menu` VALUES ('2215520224936199', '2215520224935999', '2215520224936824');
INSERT INTO `sys_role_menu` VALUES ('2215520224936200', '2215520224935999', '2215520224936825');
INSERT INTO `sys_role_menu` VALUES ('2215520224936201', '2215520224935999', '2215520224936826');
INSERT INTO `sys_role_menu` VALUES ('2215520224936202', '2215520224935999', '2215520224936827');
INSERT INTO `sys_role_menu` VALUES ('2215520224936203', '2215520224935999', '2215520224936828');
INSERT INTO `sys_role_menu` VALUES ('2215520224936204', '2215520224935999', '2215520224936829');
INSERT INTO `sys_role_menu` VALUES ('2215520224936205', '2215520224935999', '2215520224936830');
INSERT INTO `sys_role_menu` VALUES ('2215520224936206', '2215520224935999', '2215520224936831');
INSERT INTO `sys_role_menu` VALUES ('2215520224936207', '2215520224935999', '2215520224936832');
INSERT INTO `sys_role_menu` VALUES ('2215520224936208', '2215520224935999', '2215520224936833');
INSERT INTO `sys_role_menu` VALUES ('2215520224936209', '2215520224935999', '2215520224936834');
INSERT INTO `sys_role_menu` VALUES ('2215520224936210', '2215520224935999', '2215520224936835');
INSERT INTO `sys_role_menu` VALUES ('2215520224936211', '2215520224935999', '2215520224936836');
INSERT INTO `sys_role_menu` VALUES ('2215520224936212', '2215520224935999', '2215520224936837');
INSERT INTO `sys_role_menu` VALUES ('2215520224936213', '2215520224935999', '2215520224936838');
INSERT INTO `sys_role_menu` VALUES ('2215520224936214', '2215520224935999', '2215520224936839');
INSERT INTO `sys_role_menu` VALUES ('2215520224936215', '2215520224935999', '2215520224936840');
INSERT INTO `sys_role_menu` VALUES ('2215520224936216', '2215520224935999', '2215520224936841');
INSERT INTO `sys_role_menu` VALUES ('2215520224936217', '2215520224935999', '2215520224936842');
INSERT INTO `sys_role_menu` VALUES ('2215520224936218', '2215520224935999', '2215520224936843');
INSERT INTO `sys_role_menu` VALUES ('2215520224936219', '2215520224935999', '2215520224936862');
INSERT INTO `sys_role_menu` VALUES ('2215520224936220', '2215520224935999', '2215520224937123');
INSERT INTO `sys_role_menu` VALUES ('2215520224936221', '2215520224935999', '2215520224937124');
INSERT INTO `sys_role_menu` VALUES ('2215520224936222', '2215520224935999', '2215520224937179');
INSERT INTO `sys_role_menu` VALUES ('2215520224936223', '2215520224935999', '2215520224937125');
INSERT INTO `sys_role_menu` VALUES ('2215520224936224', '2215520224935999', '2215520224937126');
INSERT INTO `sys_role_menu` VALUES ('2215520224936225', '2215520224935999', '2215520224937127');
INSERT INTO `sys_role_menu` VALUES ('2215520224936226', '2215520224935999', '2215520224937128');
INSERT INTO `sys_role_menu` VALUES ('2215520224936227', '2215520224935999', '2215520224937154');
INSERT INTO `sys_role_menu` VALUES ('2215520224936228', '2215520224935999', '2215520224937155');
INSERT INTO `sys_role_menu` VALUES ('2215520224936229', '2215520224935999', '2215520224937156');
INSERT INTO `sys_role_menu` VALUES ('2215520224936230', '2215520224935999', '2215520224937157');
INSERT INTO `sys_role_menu` VALUES ('2215520224936231', '2215520224935999', '2215520224937158');
INSERT INTO `sys_role_menu` VALUES ('2215520224936232', '2215520224935999', '2215520224937159');
INSERT INTO `sys_role_menu` VALUES ('2215520224936233', '2215520224935999', '2215520224937160');
INSERT INTO `sys_role_menu` VALUES ('2215520224936234', '2215520224936000', '2215520224936818');
INSERT INTO `sys_role_menu` VALUES ('2215520224936235', '2215520224936000', '2215520224936819');
INSERT INTO `sys_role_menu` VALUES ('2215520224936236', '2215520224936000', '2215520224936820');
INSERT INTO `sys_role_menu` VALUES ('2215520224936237', '2215520224936000', '2215520224936821');
INSERT INTO `sys_role_menu` VALUES ('2215520224936238', '2215520224936000', '2215520224936822');
INSERT INTO `sys_role_menu` VALUES ('2215520224936239', '2215520224936000', '2215520224936823');
INSERT INTO `sys_role_menu` VALUES ('2215520224936240', '2215520224936000', '2215520224936824');
INSERT INTO `sys_role_menu` VALUES ('2215520224936241', '2215520224936000', '2215520224936825');
INSERT INTO `sys_role_menu` VALUES ('2215520224936242', '2215520224936000', '2215520224936826');
INSERT INTO `sys_role_menu` VALUES ('2215520224936243', '2215520224936000', '2215520224936827');
INSERT INTO `sys_role_menu` VALUES ('2215520224936244', '2215520224936000', '2215520224936828');
INSERT INTO `sys_role_menu` VALUES ('2215520224936245', '2215520224936000', '2215520224936829');
INSERT INTO `sys_role_menu` VALUES ('2215520224936246', '2215520224936000', '2215520224936830');
INSERT INTO `sys_role_menu` VALUES ('2215520224936247', '2215520224936000', '2215520224936831');
INSERT INTO `sys_role_menu` VALUES ('2215520224936248', '2215520224936000', '2215520224936832');
INSERT INTO `sys_role_menu` VALUES ('2215520224936249', '2215520224936000', '2215520224936833');
INSERT INTO `sys_role_menu` VALUES ('2215520224936250', '2215520224936000', '2215520224936834');
INSERT INTO `sys_role_menu` VALUES ('2215520224936251', '2215520224936000', '2215520224936835');
INSERT INTO `sys_role_menu` VALUES ('2215520224936252', '2215520224936000', '2215520224936836');
INSERT INTO `sys_role_menu` VALUES ('2215520224936253', '2215520224936000', '2215520224936837');
INSERT INTO `sys_role_menu` VALUES ('2215520224936254', '2215520224936000', '2215520224936838');
INSERT INTO `sys_role_menu` VALUES ('2215520224936255', '2215520224936000', '2215520224936839');
INSERT INTO `sys_role_menu` VALUES ('2215520224936256', '2215520224936000', '2215520224936840');
INSERT INTO `sys_role_menu` VALUES ('2215520224936257', '2215520224936000', '2215520224936841');
INSERT INTO `sys_role_menu` VALUES ('2215520224936258', '2215520224936000', '2215520224936842');
INSERT INTO `sys_role_menu` VALUES ('2215520224936259', '2215520224936000', '2215520224936843');
INSERT INTO `sys_role_menu` VALUES ('2215520224936261', '2215520224936000', '2215520224937123');
INSERT INTO `sys_role_menu` VALUES ('2215520224936262', '2215520224936000', '2215520224937124');
INSERT INTO `sys_role_menu` VALUES ('2215520224936264', '2215520224936000', '2215520224937125');
INSERT INTO `sys_role_menu` VALUES ('2215520224936265', '2215520224936000', '2215520224937126');
INSERT INTO `sys_role_menu` VALUES ('2215520224936266', '2215520224936000', '2215520224937127');
INSERT INTO `sys_role_menu` VALUES ('2215520224936267', '2215520224936000', '2215520224937128');
INSERT INTO `sys_role_menu` VALUES ('2215520224936268', '2215520224936000', '2215520224937154');
INSERT INTO `sys_role_menu` VALUES ('2215520224936269', '2215520224936000', '2215520224937155');
INSERT INTO `sys_role_menu` VALUES ('2215520224936270', '2215520224936000', '2215520224937156');
INSERT INTO `sys_role_menu` VALUES ('2215520224936271', '2215520224936000', '2215520224937157');
INSERT INTO `sys_role_menu` VALUES ('2215520224936272', '2215520224936000', '2215520224937158');
INSERT INTO `sys_role_menu` VALUES ('2215520224936273', '2215520224936000', '2215520224937159');
INSERT INTO `sys_role_menu` VALUES ('2215520224936274', '2215520224936000', '2215520224937160');
INSERT INTO `sys_role_menu` VALUES ('2215520224936283', '2215520224936002', '2215520224936818');
INSERT INTO `sys_role_menu` VALUES ('2215520224936284', '2215520224936002', '2215520224936819');
INSERT INTO `sys_role_menu` VALUES ('2215520224936285', '2215520224936002', '2215520224936820');
INSERT INTO `sys_role_menu` VALUES ('2215520224936286', '2215520224936002', '2215520224936821');
INSERT INTO `sys_role_menu` VALUES ('2215520224936287', '2215520224936002', '2215520224936822');
INSERT INTO `sys_role_menu` VALUES ('2215520224936288', '2215520224936002', '2215520224936823');
INSERT INTO `sys_role_menu` VALUES ('2215520224936289', '2215520224936002', '2215520224936824');
INSERT INTO `sys_role_menu` VALUES ('2215520224936290', '2215520224936002', '2215520224936825');
INSERT INTO `sys_role_menu` VALUES ('2215520224936291', '2215520224936002', '2215520224936826');
INSERT INTO `sys_role_menu` VALUES ('2215520224936292', '2215520224936002', '2215520224936827');
INSERT INTO `sys_role_menu` VALUES ('2215520224936293', '2215520224936002', '2215520224936828');
INSERT INTO `sys_role_menu` VALUES ('2215520224936294', '2215520224936002', '2215520224936829');
INSERT INTO `sys_role_menu` VALUES ('2215520224936295', '2215520224936002', '2215520224936830');
INSERT INTO `sys_role_menu` VALUES ('2215520224936296', '2215520224936002', '2215520224936831');
INSERT INTO `sys_role_menu` VALUES ('2215520224936297', '2215520224936002', '2215520224936832');
INSERT INTO `sys_role_menu` VALUES ('2215520224936298', '2215520224936002', '2215520224936833');
INSERT INTO `sys_role_menu` VALUES ('2215520224936299', '2215520224936002', '2215520224936834');
INSERT INTO `sys_role_menu` VALUES ('2215520224936300', '2215520224936002', '2215520224936835');
INSERT INTO `sys_role_menu` VALUES ('2215520224936301', '2215520224936002', '2215520224936836');
INSERT INTO `sys_role_menu` VALUES ('2215520224936302', '2215520224936002', '2215520224936837');
INSERT INTO `sys_role_menu` VALUES ('2215520224936303', '2215520224936002', '2215520224936838');
INSERT INTO `sys_role_menu` VALUES ('2215520224936304', '2215520224936002', '2215520224936839');
INSERT INTO `sys_role_menu` VALUES ('2215520224936305', '2215520224936002', '2215520224936840');
INSERT INTO `sys_role_menu` VALUES ('2215520224936306', '2215520224936002', '2215520224936841');
INSERT INTO `sys_role_menu` VALUES ('2215520224936307', '2215520224936002', '2215520224936842');
INSERT INTO `sys_role_menu` VALUES ('2215520224936308', '2215520224936002', '2215520224936843');
INSERT INTO `sys_role_menu` VALUES ('2215520224936309', '2215520224936002', '2215520224936862');
INSERT INTO `sys_role_menu` VALUES ('2215520224936310', '2215520224936002', '2215520224937123');
INSERT INTO `sys_role_menu` VALUES ('2215520224936311', '2215520224936002', '2215520224937124');
INSERT INTO `sys_role_menu` VALUES ('2215520224936312', '2215520224936002', '2215520224937125');
INSERT INTO `sys_role_menu` VALUES ('2215520224936313', '2215520224936002', '2215520224937126');
INSERT INTO `sys_role_menu` VALUES ('2215520224936314', '2215520224936002', '2215520224937127');
INSERT INTO `sys_role_menu` VALUES ('2215520224936315', '2215520224936002', '2215520224937128');
INSERT INTO `sys_role_menu` VALUES ('2215520224936316', '2215520224936002', '2215520224937154');
INSERT INTO `sys_role_menu` VALUES ('2215520224936317', '2215520224936002', '2215520224937155');
INSERT INTO `sys_role_menu` VALUES ('2215520224936318', '2215520224936002', '2215520224937156');
INSERT INTO `sys_role_menu` VALUES ('2215520224936319', '2215520224936002', '2215520224937157');
INSERT INTO `sys_role_menu` VALUES ('2215520224936320', '2215520224936002', '2215520224937158');
INSERT INTO `sys_role_menu` VALUES ('2215520224936321', '2215520224936002', '2215520224937159');
INSERT INTO `sys_role_menu` VALUES ('2215520224936322', '2215520224936002', '2215520224937160');
INSERT INTO `sys_role_menu` VALUES ('2215520224936323', '2215520224936003', '2215520224936818');
INSERT INTO `sys_role_menu` VALUES ('2215520224936324', '2215520224936003', '2215520224936819');
INSERT INTO `sys_role_menu` VALUES ('2215520224936325', '2215520224936003', '2215520224936820');
INSERT INTO `sys_role_menu` VALUES ('2215520224936326', '2215520224936003', '2215520224936821');
INSERT INTO `sys_role_menu` VALUES ('2215520224936327', '2215520224936003', '2215520224936822');
INSERT INTO `sys_role_menu` VALUES ('2215520224936328', '2215520224936003', '2215520224936823');
INSERT INTO `sys_role_menu` VALUES ('2215520224936329', '2215520224936003', '2215520224936824');
INSERT INTO `sys_role_menu` VALUES ('2215520224936330', '2215520224936003', '2215520224936825');
INSERT INTO `sys_role_menu` VALUES ('2215520224936331', '2215520224936003', '2215520224936826');
INSERT INTO `sys_role_menu` VALUES ('2215520224936332', '2215520224936003', '2215520224936827');
INSERT INTO `sys_role_menu` VALUES ('2215520224936333', '2215520224936003', '2215520224936828');
INSERT INTO `sys_role_menu` VALUES ('2215520224936334', '2215520224936003', '2215520224936829');
INSERT INTO `sys_role_menu` VALUES ('2215520224936335', '2215520224936003', '2215520224936830');
INSERT INTO `sys_role_menu` VALUES ('2215520224936336', '2215520224936003', '2215520224936831');
INSERT INTO `sys_role_menu` VALUES ('2215520224936337', '2215520224936003', '2215520224936832');
INSERT INTO `sys_role_menu` VALUES ('2215520224936418', '2215520224935996', '2215520224937188');
INSERT INTO `sys_role_menu` VALUES ('2215520224936419', '2215520224935996', '2215520224936862');
INSERT INTO `sys_role_menu` VALUES ('2215520224936444', '2215520224936027', '2215520224937237');
INSERT INTO `sys_role_menu` VALUES ('2215520224936445', '2215520224936027', '2215520224937238');
INSERT INTO `sys_role_menu` VALUES ('2215520224936446', '2215520224936027', '2215520224937239');
INSERT INTO `sys_role_menu` VALUES ('2215520224936447', '2215520224936027', '2215520224937240');
INSERT INTO `sys_role_menu` VALUES ('2215520224936448', '2215520224936027', '2215520224937241');
INSERT INTO `sys_role_menu` VALUES ('2215520224936449', '2215520224936027', '2215520224937242');
INSERT INTO `sys_role_menu` VALUES ('2215520224936450', '2215520224936027', '2215520224937243');
INSERT INTO `sys_role_menu` VALUES ('2215520224936451', '2215520224936027', '2215520224937244');
INSERT INTO `sys_role_menu` VALUES ('2215520224936452', '2215520224935949', '2215520224936818');
INSERT INTO `sys_role_menu` VALUES ('2215520224936453', '2215520224935949', '2215520224936819');
INSERT INTO `sys_role_menu` VALUES ('2215520224936454', '2215520224935949', '2215520224936820');
INSERT INTO `sys_role_menu` VALUES ('2215520224936455', '2215520224935949', '2215520224936821');
INSERT INTO `sys_role_menu` VALUES ('2215520224936456', '2215520224935949', '2215520224936822');
INSERT INTO `sys_role_menu` VALUES ('2215520224936457', '2215520224935949', '2215520224936823');
INSERT INTO `sys_role_menu` VALUES ('2215520224936458', '2215520224935949', '2215520224936824');
INSERT INTO `sys_role_menu` VALUES ('2215520224936459', '2215520224935949', '2215520224936825');
INSERT INTO `sys_role_menu` VALUES ('2215520224936460', '2215520224935949', '2215520224936826');
INSERT INTO `sys_role_menu` VALUES ('2215520224936461', '2215520224935949', '2215520224936827');
INSERT INTO `sys_role_menu` VALUES ('2215520224936462', '2215520224935949', '2215520224936828');
INSERT INTO `sys_role_menu` VALUES ('2215520224936463', '2215520224935949', '2215520224936829');
INSERT INTO `sys_role_menu` VALUES ('2215520224936464', '2215520224935949', '2215520224936830');
INSERT INTO `sys_role_menu` VALUES ('2215520224936465', '2215520224935949', '2215520224936831');
INSERT INTO `sys_role_menu` VALUES ('2215520224936466', '2215520224935949', '2215520224936832');
INSERT INTO `sys_role_menu` VALUES ('2215520224936467', '2215520224935949', '2215520224936833');
INSERT INTO `sys_role_menu` VALUES ('2215520224936468', '2215520224935949', '2215520224936834');
INSERT INTO `sys_role_menu` VALUES ('2215520224936469', '2215520224935949', '2215520224936835');
INSERT INTO `sys_role_menu` VALUES ('2215520224936470', '2215520224935949', '2215520224936836');
INSERT INTO `sys_role_menu` VALUES ('2215520224936471', '2215520224935949', '2215520224936837');
INSERT INTO `sys_role_menu` VALUES ('2215520224936472', '2215520224935949', '2215520224936838');
INSERT INTO `sys_role_menu` VALUES ('2215520224936473', '2215520224935949', '2215520224936839');
INSERT INTO `sys_role_menu` VALUES ('2215520224936474', '2215520224935949', '2215520224936840');
INSERT INTO `sys_role_menu` VALUES ('2215520224936475', '2215520224935949', '2215520224936841');
INSERT INTO `sys_role_menu` VALUES ('2215520224936476', '2215520224935949', '2215520224937188');
INSERT INTO `sys_role_menu` VALUES ('2215520224936477', '2215520224935949', '2215520224936842');
INSERT INTO `sys_role_menu` VALUES ('2215520224936478', '2215520224935949', '2215520224936843');
INSERT INTO `sys_role_menu` VALUES ('2215520224936479', '2215520224935949', '2215520224936862');
INSERT INTO `sys_role_menu` VALUES ('2215520224936480', '2215520224935949', '2215520224937123');
INSERT INTO `sys_role_menu` VALUES ('2215520224936481', '2215520224935949', '2215520224937124');
INSERT INTO `sys_role_menu` VALUES ('2215520224936482', '2215520224935949', '2215520224937125');
INSERT INTO `sys_role_menu` VALUES ('2215520224936483', '2215520224935949', '2215520224937126');
INSERT INTO `sys_role_menu` VALUES ('2215520224936484', '2215520224935949', '2215520224937127');
INSERT INTO `sys_role_menu` VALUES ('2215520224936485', '2215520224935949', '2215520224937128');
INSERT INTO `sys_role_menu` VALUES ('2215520224936486', '2215520224935949', '2215520224937154');
INSERT INTO `sys_role_menu` VALUES ('2215520224936487', '2215520224935949', '2215520224937155');
INSERT INTO `sys_role_menu` VALUES ('2215520224936488', '2215520224935949', '2215520224937156');
INSERT INTO `sys_role_menu` VALUES ('2215520224936489', '2215520224935949', '2215520224937157');
INSERT INTO `sys_role_menu` VALUES ('2215520224936490', '2215520224935949', '2215520224937158');
INSERT INTO `sys_role_menu` VALUES ('2215520224936491', '2215520224935949', '2215520224937159');
INSERT INTO `sys_role_menu` VALUES ('2215520224936492', '2215520224935949', '2215520224937160');
INSERT INTO `sys_role_menu` VALUES ('2215520224936493', '2215520224936000', '2215520224937188');
INSERT INTO `sys_role_menu` VALUES ('2215520224936494', '2215520224935971', '2215520224936818');
INSERT INTO `sys_role_menu` VALUES ('2215520224936495', '2215520224935971', '2215520224936819');
INSERT INTO `sys_role_menu` VALUES ('2215520224936496', '2215520224935971', '2215520224936820');
INSERT INTO `sys_role_menu` VALUES ('2215520224936497', '2215520224935971', '2215520224936821');
INSERT INTO `sys_role_menu` VALUES ('2215520224936498', '2215520224935971', '2215520224936822');
INSERT INTO `sys_role_menu` VALUES ('2215520224936499', '2215520224935971', '2215520224936823');
INSERT INTO `sys_role_menu` VALUES ('2215520224936500', '2215520224935971', '2215520224936824');
INSERT INTO `sys_role_menu` VALUES ('2215520224936501', '2215520224935971', '2215520224936825');
INSERT INTO `sys_role_menu` VALUES ('2215520224936502', '2215520224935971', '2215520224936826');
INSERT INTO `sys_role_menu` VALUES ('2215520224936503', '2215520224935971', '2215520224936827');
INSERT INTO `sys_role_menu` VALUES ('2215520224936504', '2215520224935971', '2215520224936828');
INSERT INTO `sys_role_menu` VALUES ('2215520224936505', '2215520224935971', '2215520224936829');
INSERT INTO `sys_role_menu` VALUES ('2215520224936506', '2215520224935971', '2215520224936830');
INSERT INTO `sys_role_menu` VALUES ('2215520224936507', '2215520224935971', '2215520224936831');
INSERT INTO `sys_role_menu` VALUES ('2215520224936508', '2215520224935971', '2215520224936832');
INSERT INTO `sys_role_menu` VALUES ('2215520224936509', '2215520224935971', '2215520224936833');
INSERT INTO `sys_role_menu` VALUES ('2215520224936510', '2215520224935971', '2215520224936834');
INSERT INTO `sys_role_menu` VALUES ('2215520224936511', '2215520224935971', '2215520224936835');
INSERT INTO `sys_role_menu` VALUES ('2215520224936512', '2215520224935971', '2215520224936836');
INSERT INTO `sys_role_menu` VALUES ('2215520224936513', '2215520224935971', '2215520224936837');
INSERT INTO `sys_role_menu` VALUES ('2215520224936514', '2215520224935971', '2215520224936838');
INSERT INTO `sys_role_menu` VALUES ('2215520224936515', '2215520224935971', '2215520224936839');
INSERT INTO `sys_role_menu` VALUES ('2215520224936516', '2215520224935971', '2215520224936840');
INSERT INTO `sys_role_menu` VALUES ('2215520224936517', '2215520224935971', '2215520224936841');
INSERT INTO `sys_role_menu` VALUES ('2215520224936518', '2215520224935971', '2215520224937188');
INSERT INTO `sys_role_menu` VALUES ('2215520224936519', '2215520224935971', '2215520224936842');
INSERT INTO `sys_role_menu` VALUES ('2215520224936520', '2215520224935971', '2215520224936843');
INSERT INTO `sys_role_menu` VALUES ('2215520224936521', '2215520224935971', '2215520224936862');
INSERT INTO `sys_role_menu` VALUES ('2215520224936522', '2215520224935971', '2215520224937123');
INSERT INTO `sys_role_menu` VALUES ('2215520224936523', '2215520224935971', '2215520224937124');
INSERT INTO `sys_role_menu` VALUES ('2215520224936524', '2215520224935971', '2215520224937125');
INSERT INTO `sys_role_menu` VALUES ('2215520224936525', '2215520224935971', '2215520224937126');
INSERT INTO `sys_role_menu` VALUES ('2215520224936526', '2215520224935971', '2215520224937127');
INSERT INTO `sys_role_menu` VALUES ('2215520224936527', '2215520224935971', '2215520224937128');
INSERT INTO `sys_role_menu` VALUES ('2215520224936528', '2215520224935971', '2215520224937154');
INSERT INTO `sys_role_menu` VALUES ('2215520224936529', '2215520224935971', '2215520224937155');
INSERT INTO `sys_role_menu` VALUES ('2215520224936530', '2215520224935971', '2215520224937156');
INSERT INTO `sys_role_menu` VALUES ('2215520224936531', '2215520224935971', '2215520224937157');
INSERT INTO `sys_role_menu` VALUES ('2215520224936532', '2215520224935971', '2215520224937158');
INSERT INTO `sys_role_menu` VALUES ('2215520224936533', '2215520224935971', '2215520224937159');
INSERT INTO `sys_role_menu` VALUES ('2215520224936534', '2215520224935971', '2215520224937160');
INSERT INTO `sys_role_menu` VALUES ('2215520224936535', '2215520224936028', '2215520224936818');
INSERT INTO `sys_role_menu` VALUES ('2215520224936536', '2215520224936028', '2215520224936819');
INSERT INTO `sys_role_menu` VALUES ('2215520224936537', '2215520224936028', '2215520224936820');
INSERT INTO `sys_role_menu` VALUES ('2215520224936538', '2215520224936028', '2215520224936821');
INSERT INTO `sys_role_menu` VALUES ('2215520224936539', '2215520224936028', '2215520224936822');
INSERT INTO `sys_role_menu` VALUES ('2215520224936540', '2215520224936028', '2215520224936823');
INSERT INTO `sys_role_menu` VALUES ('2215520224936541', '2215520224936028', '2215520224936824');
INSERT INTO `sys_role_menu` VALUES ('2215520224936542', '2215520224936028', '2215520224936825');
INSERT INTO `sys_role_menu` VALUES ('2215520224936543', '2215520224936028', '2215520224936826');
INSERT INTO `sys_role_menu` VALUES ('2215520224936544', '2215520224936028', '2215520224936827');
INSERT INTO `sys_role_menu` VALUES ('2215520224936545', '2215520224936028', '2215520224936828');
INSERT INTO `sys_role_menu` VALUES ('2215520224936546', '2215520224936028', '2215520224937155');
INSERT INTO `sys_role_menu` VALUES ('2215520224936547', '2215520224936028', '2215520224937156');
INSERT INTO `sys_role_menu` VALUES ('2215520224936548', '2215520224935940', '2215520224936814');
INSERT INTO `sys_role_menu` VALUES ('2215520224936549', '2215520224935998', '2215520224937188');
INSERT INTO `sys_role_menu` VALUES ('2215520224936550', '2215520224935969', '2215520224936818');
INSERT INTO `sys_role_menu` VALUES ('2215520224936551', '2215520224935969', '2215520224936819');
INSERT INTO `sys_role_menu` VALUES ('2215520224936552', '2215520224935969', '2215520224936820');
INSERT INTO `sys_role_menu` VALUES ('2215520224936553', '2215520224935969', '2215520224936821');
INSERT INTO `sys_role_menu` VALUES ('2215520224936554', '2215520224935969', '2215520224936822');
INSERT INTO `sys_role_menu` VALUES ('2215520224936555', '2215520224935969', '2215520224936823');
INSERT INTO `sys_role_menu` VALUES ('2215520224936556', '2215520224935969', '2215520224936824');
INSERT INTO `sys_role_menu` VALUES ('2215520224936557', '2215520224935969', '2215520224936825');
INSERT INTO `sys_role_menu` VALUES ('2215520224936558', '2215520224935969', '2215520224936826');
INSERT INTO `sys_role_menu` VALUES ('2215520224936559', '2215520224935969', '2215520224936827');
INSERT INTO `sys_role_menu` VALUES ('2215520224936560', '2215520224935969', '2215520224936828');
INSERT INTO `sys_role_menu` VALUES ('2215520224936561', '2215520224935969', '2215520224936866');
INSERT INTO `sys_role_menu` VALUES ('2215520224936562', '2215520224935969', '2215520224936829');
INSERT INTO `sys_role_menu` VALUES ('2215520224936563', '2215520224935969', '2215520224936830');
INSERT INTO `sys_role_menu` VALUES ('2215520224936564', '2215520224935969', '2215520224936831');
INSERT INTO `sys_role_menu` VALUES ('2215520224936565', '2215520224935969', '2215520224936832');
INSERT INTO `sys_role_menu` VALUES ('2215520224936566', '2215520224935969', '2215520224936833');
INSERT INTO `sys_role_menu` VALUES ('2215520224936567', '2215520224935969', '2215520224936834');
INSERT INTO `sys_role_menu` VALUES ('2215520224936568', '2215520224935969', '2215520224936835');
INSERT INTO `sys_role_menu` VALUES ('2215520224936569', '2215520224935969', '2215520224936836');
INSERT INTO `sys_role_menu` VALUES ('2215520224936570', '2215520224935969', '2215520224936837');
INSERT INTO `sys_role_menu` VALUES ('2215520224936571', '2215520224935969', '2215520224936838');
INSERT INTO `sys_role_menu` VALUES ('2215520224936572', '2215520224935969', '2215520224936839');
INSERT INTO `sys_role_menu` VALUES ('2215520224936573', '2215520224935969', '2215520224936840');
INSERT INTO `sys_role_menu` VALUES ('2215520224936574', '2215520224935969', '2215520224936841');
INSERT INTO `sys_role_menu` VALUES ('2215520224936575', '2215520224935969', '2215520224937188');
INSERT INTO `sys_role_menu` VALUES ('2215520224936576', '2215520224935969', '2215520224936842');
INSERT INTO `sys_role_menu` VALUES ('2215520224936577', '2215520224935969', '2215520224936843');
INSERT INTO `sys_role_menu` VALUES ('2215520224936578', '2215520224935969', '2215520224936862');
INSERT INTO `sys_role_menu` VALUES ('2215520224936579', '2215520224935969', '2215520224937123');
INSERT INTO `sys_role_menu` VALUES ('2215520224936580', '2215520224935969', '2215520224937124');
INSERT INTO `sys_role_menu` VALUES ('2215520224936581', '2215520224935969', '2215520224937125');
INSERT INTO `sys_role_menu` VALUES ('2215520224936582', '2215520224935969', '2215520224937126');
INSERT INTO `sys_role_menu` VALUES ('2215520224936583', '2215520224935969', '2215520224937127');
INSERT INTO `sys_role_menu` VALUES ('2215520224936584', '2215520224935969', '2215520224937128');
INSERT INTO `sys_role_menu` VALUES ('2215520224936585', '2215520224935969', '2215520224937154');
INSERT INTO `sys_role_menu` VALUES ('2215520224936586', '2215520224935969', '2215520224937155');
INSERT INTO `sys_role_menu` VALUES ('2215520224936587', '2215520224935969', '2215520224937156');
INSERT INTO `sys_role_menu` VALUES ('2215520224936588', '2215520224935969', '2215520224937157');
INSERT INTO `sys_role_menu` VALUES ('2215520224936589', '2215520224935969', '2215520224937158');
INSERT INTO `sys_role_menu` VALUES ('2215520224936590', '2215520224935969', '2215520224937159');
INSERT INTO `sys_role_menu` VALUES ('2215520224936591', '2215520224935969', '2215520224937160');
INSERT INTO `sys_role_menu` VALUES ('2215520224936604', '2215520224936040', '2215520224936818');
INSERT INTO `sys_role_menu` VALUES ('2215520224936605', '2215520224936040', '2215520224936819');
INSERT INTO `sys_role_menu` VALUES ('2215520224936606', '2215520224936040', '2215520224936820');
INSERT INTO `sys_role_menu` VALUES ('2215520224936607', '2215520224936040', '2215520224936821');
INSERT INTO `sys_role_menu` VALUES ('2215520224936608', '2215520224936040', '2215520224936822');
INSERT INTO `sys_role_menu` VALUES ('2215520224936609', '2215520224936040', '2215520224936823');
INSERT INTO `sys_role_menu` VALUES ('2215520224936610', '2215520224936040', '2215520224936824');
INSERT INTO `sys_role_menu` VALUES ('2215520224936611', '2215520224936040', '2215520224936825');
INSERT INTO `sys_role_menu` VALUES ('2215520224936612', '2215520224936040', '2215520224936826');
INSERT INTO `sys_role_menu` VALUES ('2215520224936613', '2215520224936040', '2215520224936827');
INSERT INTO `sys_role_menu` VALUES ('2215520224936614', '2215520224936040', '2215520224936828');
INSERT INTO `sys_role_menu` VALUES ('2215520224936615', '2215520224936040', '2215520224936866');
INSERT INTO `sys_role_menu` VALUES ('2215520224936616', '2215520224936041', '2215520224936818');
INSERT INTO `sys_role_menu` VALUES ('2215520224936617', '2215520224936041', '2215520224936819');
INSERT INTO `sys_role_menu` VALUES ('2215520224936618', '2215520224936041', '2215520224936820');
INSERT INTO `sys_role_menu` VALUES ('2215520224936619', '2215520224936041', '2215520224936821');
INSERT INTO `sys_role_menu` VALUES ('2215520224936620', '2215520224936041', '2215520224936822');
INSERT INTO `sys_role_menu` VALUES ('2215520224936621', '2215520224936041', '2215520224936823');
INSERT INTO `sys_role_menu` VALUES ('2215520224936622', '2215520224936041', '2215520224936824');
INSERT INTO `sys_role_menu` VALUES ('2215520224936623', '2215520224936041', '2215520224936825');
INSERT INTO `sys_role_menu` VALUES ('2215520224936624', '2215520224936041', '2215520224936826');
INSERT INTO `sys_role_menu` VALUES ('2215520224936625', '2215520224936041', '2215520224936827');
INSERT INTO `sys_role_menu` VALUES ('2215520224936626', '2215520224936041', '2215520224936828');
INSERT INTO `sys_role_menu` VALUES ('2215520224936627', '2215520224936041', '2215520224936866');
INSERT INTO `sys_role_menu` VALUES ('2215520224936628', '2215520224936041', '2215520224936829');
INSERT INTO `sys_role_menu` VALUES ('2215520224936629', '2215520224936041', '2215520224936830');
INSERT INTO `sys_role_menu` VALUES ('2215520224936630', '2215520224936041', '2215520224936831');
INSERT INTO `sys_role_menu` VALUES ('2215520224936631', '2215520224936041', '2215520224936832');
INSERT INTO `sys_role_menu` VALUES ('2215520224936632', '2215520224936042', '2215520224936818');
INSERT INTO `sys_role_menu` VALUES ('2215520224936633', '2215520224936042', '2215520224936819');
INSERT INTO `sys_role_menu` VALUES ('2215520224936634', '2215520224936042', '2215520224936820');
INSERT INTO `sys_role_menu` VALUES ('2215520224936635', '2215520224936042', '2215520224936821');
INSERT INTO `sys_role_menu` VALUES ('2215520224936636', '2215520224936042', '2215520224936822');
INSERT INTO `sys_role_menu` VALUES ('2215520224936637', '2215520224936042', '2215520224936823');
INSERT INTO `sys_role_menu` VALUES ('2215520224936638', '2215520224936042', '2215520224936824');
INSERT INTO `sys_role_menu` VALUES ('2215520224936639', '2215520224936042', '2215520224936825');
INSERT INTO `sys_role_menu` VALUES ('2215520224936640', '2215520224936042', '2215520224936826');
INSERT INTO `sys_role_menu` VALUES ('2215520224936641', '2215520224936042', '2215520224936827');
INSERT INTO `sys_role_menu` VALUES ('2215520224936642', '2215520224936042', '2215520224936828');
INSERT INTO `sys_role_menu` VALUES ('2215520224936643', '2215520224936042', '2215520224936866');
INSERT INTO `sys_role_menu` VALUES ('2215520224936644', '2215520224936042', '2215520224936829');
INSERT INTO `sys_role_menu` VALUES ('2215520224936645', '2215520224936042', '2215520224936830');
INSERT INTO `sys_role_menu` VALUES ('2215520224936646', '2215520224936042', '2215520224936831');
INSERT INTO `sys_role_menu` VALUES ('2215520224936647', '2215520224936042', '2215520224936832');
INSERT INTO `sys_role_menu` VALUES ('2215520224936648', '2215520224936044', '2215520224936818');
INSERT INTO `sys_role_menu` VALUES ('2215520224936649', '2215520224936044', '2215520224936819');
INSERT INTO `sys_role_menu` VALUES ('2215520224936650', '2215520224936044', '2215520224936820');
INSERT INTO `sys_role_menu` VALUES ('2215520224936651', '2215520224936044', '2215520224936821');
INSERT INTO `sys_role_menu` VALUES ('2215520224936652', '2215520224936044', '2215520224936822');
INSERT INTO `sys_role_menu` VALUES ('2215520224936653', '2215520224936044', '2215520224936823');
INSERT INTO `sys_role_menu` VALUES ('2215520224936654', '2215520224936044', '2215520224936824');
INSERT INTO `sys_role_menu` VALUES ('2215520224936655', '2215520224936044', '2215520224936825');
INSERT INTO `sys_role_menu` VALUES ('2215520224936656', '2215520224936044', '2215520224936826');
INSERT INTO `sys_role_menu` VALUES ('2215520224936657', '2215520224936044', '2215520224936827');
INSERT INTO `sys_role_menu` VALUES ('2215520224936658', '2215520224936044', '2215520224936828');
INSERT INTO `sys_role_menu` VALUES ('2215520224936659', '2215520224936044', '2215520224936829');
INSERT INTO `sys_role_menu` VALUES ('2215520224936660', '2215520224936044', '2215520224936830');
INSERT INTO `sys_role_menu` VALUES ('2215520224936661', '2215520224936044', '2215520224936831');
INSERT INTO `sys_role_menu` VALUES ('2215520224936662', '2215520224936044', '2215520224936832');
INSERT INTO `sys_role_menu` VALUES ('2215520224936680', '2215520224936049', '2215520224936818');
INSERT INTO `sys_role_menu` VALUES ('2215520224936681', '2215520224936049', '2215520224936819');
INSERT INTO `sys_role_menu` VALUES ('2215520224936682', '2215520224936049', '2215520224936820');
INSERT INTO `sys_role_menu` VALUES ('2215520224936683', '2215520224936049', '2215520224936821');
INSERT INTO `sys_role_menu` VALUES ('2215520224936684', '2215520224936049', '2215520224936822');
INSERT INTO `sys_role_menu` VALUES ('2215520224936685', '2215520224936049', '2215520224936823');
INSERT INTO `sys_role_menu` VALUES ('2215520224936686', '2215520224936049', '2215520224936824');
INSERT INTO `sys_role_menu` VALUES ('2215520224936687', '2215520224936049', '2215520224936825');
INSERT INTO `sys_role_menu` VALUES ('2215520224936688', '2215520224936049', '2215520224936826');
INSERT INTO `sys_role_menu` VALUES ('2215520224936689', '2215520224936049', '2215520224936827');
INSERT INTO `sys_role_menu` VALUES ('2215520224936690', '2215520224936049', '2215520224936828');
INSERT INTO `sys_role_menu` VALUES ('2215520224936691', '2215520224936049', '2215520224936829');
INSERT INTO `sys_role_menu` VALUES ('2215520224936692', '2215520224936049', '2215520224936830');
INSERT INTO `sys_role_menu` VALUES ('2215520224936693', '2215520224936049', '2215520224936831');
INSERT INTO `sys_role_menu` VALUES ('2215520224936694', '2215520224936049', '2215520224936832');
INSERT INTO `sys_role_menu` VALUES ('2215520224936695', '2215520224936050', '2215520224936818');
INSERT INTO `sys_role_menu` VALUES ('2215520224936696', '2215520224936050', '2215520224936819');
INSERT INTO `sys_role_menu` VALUES ('2215520224936697', '2215520224936050', '2215520224936820');
INSERT INTO `sys_role_menu` VALUES ('2215520224936698', '2215520224936050', '2215520224936821');
INSERT INTO `sys_role_menu` VALUES ('2215520224936699', '2215520224936050', '2215520224936822');
INSERT INTO `sys_role_menu` VALUES ('2215520224936700', '2215520224936050', '2215520224936823');
INSERT INTO `sys_role_menu` VALUES ('2215520224936701', '2215520224936050', '2215520224936824');
INSERT INTO `sys_role_menu` VALUES ('2215520224936702', '2215520224936050', '2215520224936825');
INSERT INTO `sys_role_menu` VALUES ('2215520224936703', '2215520224936050', '2215520224936826');
INSERT INTO `sys_role_menu` VALUES ('2215520224936704', '2215520224936050', '2215520224936827');
INSERT INTO `sys_role_menu` VALUES ('2215520224936705', '2215520224936050', '2215520224936828');
INSERT INTO `sys_role_menu` VALUES ('2215520224936706', '2215520224936051', '2215520224936818');
INSERT INTO `sys_role_menu` VALUES ('2215520224936707', '2215520224936051', '2215520224936819');
INSERT INTO `sys_role_menu` VALUES ('2215520224936708', '2215520224936051', '2215520224936820');
INSERT INTO `sys_role_menu` VALUES ('2215520224936709', '2215520224936051', '2215520224936821');
INSERT INTO `sys_role_menu` VALUES ('2215520224936710', '2215520224936051', '2215520224936822');
INSERT INTO `sys_role_menu` VALUES ('2215520224936711', '2215520224936051', '2215520224936823');
INSERT INTO `sys_role_menu` VALUES ('2215520224936712', '2215520224936051', '2215520224936824');
INSERT INTO `sys_role_menu` VALUES ('2215520224936713', '2215520224936051', '2215520224936825');
INSERT INTO `sys_role_menu` VALUES ('2215520224936714', '2215520224936051', '2215520224936826');
INSERT INTO `sys_role_menu` VALUES ('2215520224936715', '2215520224936051', '2215520224936827');
INSERT INTO `sys_role_menu` VALUES ('2215520224936716', '2215520224936051', '2215520224936828');
INSERT INTO `sys_role_menu` VALUES ('2215520224936717', '2215520224936051', '2215520224936829');
INSERT INTO `sys_role_menu` VALUES ('2215520224936718', '2215520224936051', '2215520224936830');
INSERT INTO `sys_role_menu` VALUES ('2215520224936719', '2215520224936051', '2215520224936831');
INSERT INTO `sys_role_menu` VALUES ('2215520224936720', '2215520224936051', '2215520224936832');
INSERT INTO `sys_role_menu` VALUES ('2215520224936722', '2215520224936053', '1');
INSERT INTO `sys_role_menu` VALUES ('2215520224936723', '2215520224936053', '2215520224936813');
INSERT INTO `sys_role_menu` VALUES ('2215520224936724', '2215520224936053', '2215520224936814');
INSERT INTO `sys_role_menu` VALUES ('2215520224936725', '2215520224936053', '2215520224936815');
INSERT INTO `sys_role_menu` VALUES ('2215520224936726', '2215520224936053', '2215520224936816');
INSERT INTO `sys_role_menu` VALUES ('2215520224936727', '2215520224936053', '2215520224936817');
INSERT INTO `sys_role_menu` VALUES ('2215520224936728', '2215520224936054', '2215520224936813');
INSERT INTO `sys_role_menu` VALUES ('2215520224936753', '2215520224936067', '1');
INSERT INTO `sys_role_menu` VALUES ('2215520224936754', '2215520224936067', '2215520224936813');
INSERT INTO `sys_role_menu` VALUES ('2215520224936755', '2215520224936070', '2215520224937364');
INSERT INTO `sys_role_menu` VALUES ('2215520224936756', '2215520224936070', '2215520224937365');
INSERT INTO `sys_role_menu` VALUES ('2215520224936757', '2215520224936070', '2215520224937366');
INSERT INTO `sys_role_menu` VALUES ('2215520224936758', '2215520224936070', '2215520224937367');
INSERT INTO `sys_role_menu` VALUES ('2215520224936759', '2215520224936070', '2215520224937368');
INSERT INTO `sys_role_menu` VALUES ('2215520224936760', '2215520224936070', '2215520224937369');
INSERT INTO `sys_role_menu` VALUES ('2215520224936761', '2215520224936070', '2215520224937370');
INSERT INTO `sys_role_menu` VALUES ('2215520224936762', '2215520224936070', '2215520224937371');
INSERT INTO `sys_role_menu` VALUES ('2215520224936763', '2215520224936034', '2215520224936813');
INSERT INTO `sys_role_menu` VALUES ('2215520224936764', '2215520224936034', '2215520224936816');
INSERT INTO `sys_role_menu` VALUES ('2215520224936765', '2215520224936071', '2215520224936818');
INSERT INTO `sys_role_menu` VALUES ('2215520224936766', '2215520224936071', '2215520224936819');
INSERT INTO `sys_role_menu` VALUES ('2215520224936767', '2215520224936071', '2215520224936820');
INSERT INTO `sys_role_menu` VALUES ('2215520224936768', '2215520224936071', '2215520224936821');
INSERT INTO `sys_role_menu` VALUES ('2215520224936769', '2215520224936071', '2215520224936822');
INSERT INTO `sys_role_menu` VALUES ('2215520224936770', '2215520224936071', '2215520224936823');
INSERT INTO `sys_role_menu` VALUES ('2215520224936771', '2215520224936071', '2215520224936824');
INSERT INTO `sys_role_menu` VALUES ('2215520224936772', '2215520224936071', '2215520224936825');
INSERT INTO `sys_role_menu` VALUES ('2215520224936773', '2215520224936071', '2215520224936826');
INSERT INTO `sys_role_menu` VALUES ('2215520224936774', '2215520224936071', '2215520224936827');
INSERT INTO `sys_role_menu` VALUES ('2215520224936775', '2215520224936071', '2215520224936828');
INSERT INTO `sys_role_menu` VALUES ('2215520224936776', '2215520224936071', '2215520224936829');
INSERT INTO `sys_role_menu` VALUES ('2215520224936777', '2215520224936071', '2215520224936830');
INSERT INTO `sys_role_menu` VALUES ('2215520224936778', '2215520224936071', '2215520224936831');
INSERT INTO `sys_role_menu` VALUES ('2215520224936779', '2215520224936071', '2215520224936832');
INSERT INTO `sys_role_menu` VALUES ('2215520224936780', '2215520224936072', '2215520224936818');
INSERT INTO `sys_role_menu` VALUES ('2215520224936781', '2215520224936072', '2215520224936819');
INSERT INTO `sys_role_menu` VALUES ('2215520224936782', '2215520224936072', '2215520224936820');
INSERT INTO `sys_role_menu` VALUES ('2215520224936783', '2215520224936072', '2215520224936821');
INSERT INTO `sys_role_menu` VALUES ('2215520224936784', '2215520224936072', '2215520224936822');
INSERT INTO `sys_role_menu` VALUES ('2215520224936785', '2215520224936072', '2215520224936823');
INSERT INTO `sys_role_menu` VALUES ('2215520224936786', '2215520224936072', '2215520224936824');
INSERT INTO `sys_role_menu` VALUES ('2215520224936787', '2215520224936072', '2215520224936825');
INSERT INTO `sys_role_menu` VALUES ('2215520224936788', '2215520224936072', '2215520224936826');
INSERT INTO `sys_role_menu` VALUES ('2215520224936789', '2215520224936072', '2215520224936827');
INSERT INTO `sys_role_menu` VALUES ('2215520224936790', '2215520224936072', '2215520224936828');
INSERT INTO `sys_role_menu` VALUES ('2215520224936791', '2215520224936072', '2215520224936829');
INSERT INTO `sys_role_menu` VALUES ('2215520224936792', '2215520224936072', '2215520224936830');
INSERT INTO `sys_role_menu` VALUES ('2215520224936793', '2215520224936072', '2215520224936831');
INSERT INTO `sys_role_menu` VALUES ('2215520224936794', '2215520224936072', '2215520224936832');
INSERT INTO `sys_role_menu` VALUES ('2215520224936795', '2215520224936072', '1');
INSERT INTO `sys_role_menu` VALUES ('2215520224936796', '2215520224936072', '2215520224936833');
INSERT INTO `sys_role_menu` VALUES ('2215520224936797', '2215520224936072', '2215520224936834');
INSERT INTO `sys_role_menu` VALUES ('2215520224936798', '2215520224936072', '2215520224936835');
INSERT INTO `sys_role_menu` VALUES ('2215520224936799', '2215520224936072', '2215520224936836');
INSERT INTO `sys_role_menu` VALUES ('2215520224936800', '2215520224936072', '2215520224936837');
INSERT INTO `sys_role_menu` VALUES ('2215520224936801', '2215520224936072', '2215520224936838');
INSERT INTO `sys_role_menu` VALUES ('2215520224936802', '2215520224936072', '2215520224936839');
INSERT INTO `sys_role_menu` VALUES ('2215520224936803', '2215520224936072', '2215520224936840');
INSERT INTO `sys_role_menu` VALUES ('2215520224936804', '2215520224936072', '2215520224936841');
INSERT INTO `sys_role_menu` VALUES ('2215520224936805', '2215520224936072', '2215520224936842');
INSERT INTO `sys_role_menu` VALUES ('2215520224936806', '2215520224936072', '2215520224936843');
INSERT INTO `sys_role_menu` VALUES ('2215520224936807', '2215520224936072', '2215520224936862');
INSERT INTO `sys_role_menu` VALUES ('2215520224936808', '2215520224936072', '2215520224936866');
INSERT INTO `sys_role_menu` VALUES ('2215520224936809', '2215520224936072', '2215520224937123');
INSERT INTO `sys_role_menu` VALUES ('2215520224936810', '2215520224936072', '2215520224937124');
INSERT INTO `sys_role_menu` VALUES ('2215520224936811', '2215520224936072', '2215520224937125');
INSERT INTO `sys_role_menu` VALUES ('2215520224936812', '2215520224936072', '2215520224937126');
INSERT INTO `sys_role_menu` VALUES ('2215520224936813', '2215520224936072', '2215520224937127');
INSERT INTO `sys_role_menu` VALUES ('2215520224936814', '2215520224936072', '2215520224937128');
INSERT INTO `sys_role_menu` VALUES ('2215520224936815', '2215520224936072', '2215520224937154');
INSERT INTO `sys_role_menu` VALUES ('2215520224936816', '2215520224936072', '2215520224937155');
INSERT INTO `sys_role_menu` VALUES ('2215520224936817', '2215520224936072', '2215520224937156');
INSERT INTO `sys_role_menu` VALUES ('2215520224936818', '2215520224936072', '2215520224937157');
INSERT INTO `sys_role_menu` VALUES ('2215520224936819', '2215520224936072', '2215520224937158');
INSERT INTO `sys_role_menu` VALUES ('2215520224936820', '2215520224936072', '2215520224937159');
INSERT INTO `sys_role_menu` VALUES ('2215520224936821', '2215520224936072', '2215520224937160');
INSERT INTO `sys_role_menu` VALUES ('2215520224936822', '2215520224936073', '2215520224936818');
INSERT INTO `sys_role_menu` VALUES ('2215520224936823', '2215520224936073', '2215520224936819');
INSERT INTO `sys_role_menu` VALUES ('2215520224936824', '2215520224936073', '2215520224936820');
INSERT INTO `sys_role_menu` VALUES ('2215520224936825', '2215520224936073', '2215520224936821');
INSERT INTO `sys_role_menu` VALUES ('2215520224936826', '2215520224936073', '2215520224936822');
INSERT INTO `sys_role_menu` VALUES ('2215520224936827', '2215520224936073', '2215520224936823');
INSERT INTO `sys_role_menu` VALUES ('2215520224936828', '2215520224936073', '2215520224936824');
INSERT INTO `sys_role_menu` VALUES ('2215520224936829', '2215520224936073', '2215520224936825');
INSERT INTO `sys_role_menu` VALUES ('2215520224936830', '2215520224936073', '2215520224936826');
INSERT INTO `sys_role_menu` VALUES ('2215520224936831', '2215520224936073', '2215520224936827');
INSERT INTO `sys_role_menu` VALUES ('2215520224936832', '2215520224936073', '2215520224936828');
INSERT INTO `sys_role_menu` VALUES ('2215520224936833', '2215520224936073', '2215520224936829');
INSERT INTO `sys_role_menu` VALUES ('2215520224936834', '2215520224936073', '2215520224936830');
INSERT INTO `sys_role_menu` VALUES ('2215520224936835', '2215520224936073', '2215520224936831');
INSERT INTO `sys_role_menu` VALUES ('2215520224936836', '2215520224936073', '2215520224936832');
INSERT INTO `sys_role_menu` VALUES ('2215520224936837', '2215520224936073', '1');
INSERT INTO `sys_role_menu` VALUES ('2215520224936838', '2215520224936073', '2215520224936833');
INSERT INTO `sys_role_menu` VALUES ('2215520224936839', '2215520224936073', '2215520224936834');
INSERT INTO `sys_role_menu` VALUES ('2215520224936840', '2215520224936073', '2215520224936835');
INSERT INTO `sys_role_menu` VALUES ('2215520224936841', '2215520224936073', '2215520224936836');
INSERT INTO `sys_role_menu` VALUES ('2215520224936842', '2215520224936073', '2215520224936837');
INSERT INTO `sys_role_menu` VALUES ('2215520224936843', '2215520224936073', '2215520224936838');
INSERT INTO `sys_role_menu` VALUES ('2215520224936844', '2215520224936073', '2215520224936839');
INSERT INTO `sys_role_menu` VALUES ('2215520224936845', '2215520224936073', '2215520224936840');
INSERT INTO `sys_role_menu` VALUES ('2215520224936846', '2215520224936073', '2215520224936841');
INSERT INTO `sys_role_menu` VALUES ('2215520224936847', '2215520224936073', '2215520224936842');
INSERT INTO `sys_role_menu` VALUES ('2215520224936848', '2215520224936073', '2215520224936843');
INSERT INTO `sys_role_menu` VALUES ('2215520224936849', '2215520224936073', '2215520224936862');
INSERT INTO `sys_role_menu` VALUES ('2215520224936850', '2215520224936073', '2215520224936866');
INSERT INTO `sys_role_menu` VALUES ('2215520224936851', '2215520224936073', '2215520224937123');
INSERT INTO `sys_role_menu` VALUES ('2215520224936852', '2215520224936073', '2215520224937124');
INSERT INTO `sys_role_menu` VALUES ('2215520224936853', '2215520224936073', '2215520224937125');
INSERT INTO `sys_role_menu` VALUES ('2215520224936854', '2215520224936073', '2215520224937126');
INSERT INTO `sys_role_menu` VALUES ('2215520224936855', '2215520224936073', '2215520224937127');
INSERT INTO `sys_role_menu` VALUES ('2215520224936856', '2215520224936073', '2215520224937128');
INSERT INTO `sys_role_menu` VALUES ('2215520224936857', '2215520224936073', '2215520224937154');
INSERT INTO `sys_role_menu` VALUES ('2215520224936858', '2215520224936073', '2215520224937155');
INSERT INTO `sys_role_menu` VALUES ('2215520224936859', '2215520224936073', '2215520224937156');
INSERT INTO `sys_role_menu` VALUES ('2215520224936860', '2215520224936073', '2215520224937157');
INSERT INTO `sys_role_menu` VALUES ('2215520224936861', '2215520224936073', '2215520224937158');
INSERT INTO `sys_role_menu` VALUES ('2215520224936862', '2215520224936073', '2215520224937159');
INSERT INTO `sys_role_menu` VALUES ('2215520224936863', '2215520224936073', '2215520224937160');
INSERT INTO `sys_role_menu` VALUES ('2215520224936864', '2215520224936077', '2215520224936818');
INSERT INTO `sys_role_menu` VALUES ('2215520224936865', '2215520224936077', '2215520224936819');
INSERT INTO `sys_role_menu` VALUES ('2215520224936866', '2215520224936077', '2215520224936820');
INSERT INTO `sys_role_menu` VALUES ('2215520224936867', '2215520224936077', '2215520224936821');
INSERT INTO `sys_role_menu` VALUES ('2215520224936868', '2215520224936077', '2215520224936822');
INSERT INTO `sys_role_menu` VALUES ('2215520224936869', '2215520224936077', '2215520224936823');
INSERT INTO `sys_role_menu` VALUES ('2215520224936870', '2215520224936077', '2215520224936824');
INSERT INTO `sys_role_menu` VALUES ('2215520224936871', '2215520224936077', '2215520224936825');
INSERT INTO `sys_role_menu` VALUES ('2215520224936872', '2215520224936077', '2215520224936826');
INSERT INTO `sys_role_menu` VALUES ('2215520224936873', '2215520224936077', '2215520224936827');
INSERT INTO `sys_role_menu` VALUES ('2215520224936874', '2215520224936077', '2215520224936828');
INSERT INTO `sys_role_menu` VALUES ('2215520224936875', '2215520224936077', '2215520224936829');
INSERT INTO `sys_role_menu` VALUES ('2215520224936876', '2215520224936077', '2215520224936830');
INSERT INTO `sys_role_menu` VALUES ('2215520224936877', '2215520224936077', '2215520224936831');
INSERT INTO `sys_role_menu` VALUES ('2215520224936878', '2215520224936077', '2215520224936832');
INSERT INTO `sys_role_menu` VALUES ('2215520224936879', '2215520224936077', '1');
INSERT INTO `sys_role_menu` VALUES ('2215520224936880', '2215520224936077', '2215520224936833');
INSERT INTO `sys_role_menu` VALUES ('2215520224936881', '2215520224936077', '2215520224936834');
INSERT INTO `sys_role_menu` VALUES ('2215520224936882', '2215520224936077', '2215520224936835');
INSERT INTO `sys_role_menu` VALUES ('2215520224936883', '2215520224936077', '2215520224936836');
INSERT INTO `sys_role_menu` VALUES ('2215520224936884', '2215520224936077', '2215520224936837');
INSERT INTO `sys_role_menu` VALUES ('2215520224936885', '2215520224936077', '2215520224936838');
INSERT INTO `sys_role_menu` VALUES ('2215520224936886', '2215520224936077', '2215520224936839');
INSERT INTO `sys_role_menu` VALUES ('2215520224936887', '2215520224936077', '2215520224936840');
INSERT INTO `sys_role_menu` VALUES ('2215520224936888', '2215520224936077', '2215520224936841');
INSERT INTO `sys_role_menu` VALUES ('2215520224936889', '2215520224936077', '2215520224936842');
INSERT INTO `sys_role_menu` VALUES ('2215520224936890', '2215520224936077', '2215520224936843');
INSERT INTO `sys_role_menu` VALUES ('2215520224936891', '2215520224936077', '2215520224936862');
INSERT INTO `sys_role_menu` VALUES ('2215520224936892', '2215520224936077', '2215520224936866');
INSERT INTO `sys_role_menu` VALUES ('2215520224936893', '2215520224936077', '2215520224937123');
INSERT INTO `sys_role_menu` VALUES ('2215520224936894', '2215520224936077', '2215520224937124');
INSERT INTO `sys_role_menu` VALUES ('2215520224936895', '2215520224936077', '2215520224937125');
INSERT INTO `sys_role_menu` VALUES ('2215520224936896', '2215520224936077', '2215520224937126');
INSERT INTO `sys_role_menu` VALUES ('2215520224936897', '2215520224936077', '2215520224937127');
INSERT INTO `sys_role_menu` VALUES ('2215520224936898', '2215520224936077', '2215520224937128');
INSERT INTO `sys_role_menu` VALUES ('2215520224936899', '2215520224936077', '2215520224937154');
INSERT INTO `sys_role_menu` VALUES ('2215520224936900', '2215520224936077', '2215520224937155');
INSERT INTO `sys_role_menu` VALUES ('2215520224936901', '2215520224936077', '2215520224937156');
INSERT INTO `sys_role_menu` VALUES ('2215520224936902', '2215520224936077', '2215520224937157');
INSERT INTO `sys_role_menu` VALUES ('2215520224936903', '2215520224936077', '2215520224937158');
INSERT INTO `sys_role_menu` VALUES ('2215520224936904', '2215520224936077', '2215520224937159');
INSERT INTO `sys_role_menu` VALUES ('2215520224936905', '2215520224936077', '2215520224937160');
INSERT INTO `sys_role_menu` VALUES ('2215520224936906', '2215520224936078', '2215520224936818');
INSERT INTO `sys_role_menu` VALUES ('2215520224936907', '2215520224936078', '2215520224936819');
INSERT INTO `sys_role_menu` VALUES ('2215520224936908', '2215520224936078', '2215520224936820');
INSERT INTO `sys_role_menu` VALUES ('2215520224936909', '2215520224936078', '2215520224936821');
INSERT INTO `sys_role_menu` VALUES ('2215520224936910', '2215520224936078', '2215520224936822');
INSERT INTO `sys_role_menu` VALUES ('2215520224936911', '2215520224936078', '2215520224936823');
INSERT INTO `sys_role_menu` VALUES ('2215520224936912', '2215520224936078', '2215520224936824');
INSERT INTO `sys_role_menu` VALUES ('2215520224936913', '2215520224936078', '2215520224936825');
INSERT INTO `sys_role_menu` VALUES ('2215520224936914', '2215520224936078', '2215520224936826');
INSERT INTO `sys_role_menu` VALUES ('2215520224936915', '2215520224936078', '2215520224936827');
INSERT INTO `sys_role_menu` VALUES ('2215520224936916', '2215520224936078', '2215520224936828');
INSERT INTO `sys_role_menu` VALUES ('2215520224936917', '2215520224936078', '2215520224936829');
INSERT INTO `sys_role_menu` VALUES ('2215520224936918', '2215520224936078', '2215520224936830');
INSERT INTO `sys_role_menu` VALUES ('2215520224936919', '2215520224936078', '2215520224936831');
INSERT INTO `sys_role_menu` VALUES ('2215520224936920', '2215520224936078', '2215520224936832');
INSERT INTO `sys_role_menu` VALUES ('2215520224936921', '2215520224936078', '1');
INSERT INTO `sys_role_menu` VALUES ('2215520224936922', '2215520224936078', '2215520224936833');
INSERT INTO `sys_role_menu` VALUES ('2215520224936923', '2215520224936078', '2215520224936834');
INSERT INTO `sys_role_menu` VALUES ('2215520224936924', '2215520224936078', '2215520224936835');
INSERT INTO `sys_role_menu` VALUES ('2215520224936925', '2215520224936078', '2215520224936836');
INSERT INTO `sys_role_menu` VALUES ('2215520224936926', '2215520224936078', '2215520224936837');
INSERT INTO `sys_role_menu` VALUES ('2215520224936927', '2215520224936078', '2215520224936838');
INSERT INTO `sys_role_menu` VALUES ('2215520224936928', '2215520224936078', '2215520224936839');
INSERT INTO `sys_role_menu` VALUES ('2215520224936929', '2215520224936078', '2215520224936840');
INSERT INTO `sys_role_menu` VALUES ('2215520224936930', '2215520224936078', '2215520224936841');
INSERT INTO `sys_role_menu` VALUES ('2215520224936931', '2215520224936078', '2215520224936842');
INSERT INTO `sys_role_menu` VALUES ('2215520224936932', '2215520224936078', '2215520224936843');
INSERT INTO `sys_role_menu` VALUES ('2215520224936933', '2215520224936078', '2215520224936862');
INSERT INTO `sys_role_menu` VALUES ('2215520224936934', '2215520224936078', '2215520224936866');
INSERT INTO `sys_role_menu` VALUES ('2215520224936935', '2215520224936078', '2215520224937123');
INSERT INTO `sys_role_menu` VALUES ('2215520224936936', '2215520224936078', '2215520224937124');
INSERT INTO `sys_role_menu` VALUES ('2215520224936937', '2215520224936078', '2215520224937125');
INSERT INTO `sys_role_menu` VALUES ('2215520224936938', '2215520224936078', '2215520224937126');
INSERT INTO `sys_role_menu` VALUES ('2215520224936939', '2215520224936078', '2215520224937127');
INSERT INTO `sys_role_menu` VALUES ('2215520224936940', '2215520224936078', '2215520224937128');
INSERT INTO `sys_role_menu` VALUES ('2215520224936941', '2215520224936078', '2215520224937154');
INSERT INTO `sys_role_menu` VALUES ('2215520224936942', '2215520224936078', '2215520224937155');
INSERT INTO `sys_role_menu` VALUES ('2215520224936943', '2215520224936078', '2215520224937156');
INSERT INTO `sys_role_menu` VALUES ('2215520224936944', '2215520224936078', '2215520224937157');
INSERT INTO `sys_role_menu` VALUES ('2215520224936945', '2215520224936078', '2215520224937158');
INSERT INTO `sys_role_menu` VALUES ('2215520224936946', '2215520224936078', '2215520224937159');
INSERT INTO `sys_role_menu` VALUES ('2215520224936947', '2215520224936078', '2215520224937160');
INSERT INTO `sys_role_menu` VALUES ('2215520224936957', '2215520224936080', '2215520224937395');
INSERT INTO `sys_role_menu` VALUES ('2215520224936958', '2215520224936080', '2215520224937396');
INSERT INTO `sys_role_menu` VALUES ('2215520224936959', '2215520224936080', '2215520224937397');
INSERT INTO `sys_role_menu` VALUES ('2215520224936960', '2215520224936080', '2215520224937398');
INSERT INTO `sys_role_menu` VALUES ('2215520224936961', '2215520224936080', '2215520224937399');
INSERT INTO `sys_role_menu` VALUES ('2215520224936962', '2215520224936080', '2215520224937400');
INSERT INTO `sys_role_menu` VALUES ('2215520224936963', '2215520224936080', '2215520224937401');
INSERT INTO `sys_role_menu` VALUES ('2215520224936964', '2215520224936080', '2215520224937402');
INSERT INTO `sys_role_menu` VALUES ('2215520224936965', '2215520224936080', '2215520224937403');

-- ----------------------------
-- Table structure for `sys_role_office_user`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_office_user`;
CREATE TABLE `sys_role_office_user` (
  `id` bigint(20) NOT NULL,
  `role_id` varchar(64) NOT NULL COMMENT '角色编号',
  `office_id` varchar(64) NOT NULL COMMENT '机构编号',
  `user_id` varchar(64) NOT NULL COMMENT '用户主键ID',
  `rel_type` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色-机构';

-- ----------------------------
-- Records of sys_role_office_user
-- ----------------------------
INSERT INTO `sys_role_office_user` VALUES ('2215520224935938', '606', '220', '308', null);
INSERT INTO `sys_role_office_user` VALUES ('2215520224935942', '2215520224935949', '2215520224935946', '', null);
INSERT INTO `sys_role_office_user` VALUES ('2215520224935943', '2215520224935950', '2215520224935946', '', null);
INSERT INTO `sys_role_office_user` VALUES ('2215520224935949', '2215520224935969', '2215520224935955', '', null);
INSERT INTO `sys_role_office_user` VALUES ('2215520224935950', '2215520224935970', '2215520224935955', '', null);
INSERT INTO `sys_role_office_user` VALUES ('2215520224935951', '2215520224935971', '2215520224935956', '', null);
INSERT INTO `sys_role_office_user` VALUES ('2215520224935952', '2215520224935972', '2215520224935956', '', null);
INSERT INTO `sys_role_office_user` VALUES ('2215520224935953', '2215520224935973', '2215520224935957', '', null);
INSERT INTO `sys_role_office_user` VALUES ('2215520224935954', '2215520224935974', '2215520224935957', '', null);
INSERT INTO `sys_role_office_user` VALUES ('2215520224935959', '2215520224935995', '2215520224935959', '', null);
INSERT INTO `sys_role_office_user` VALUES ('2215520224935960', '2215520224935996', '2215520224935959', '', null);
INSERT INTO `sys_role_office_user` VALUES ('2215520224935963', '2215520224935997', '2215520224935960', '', null);
INSERT INTO `sys_role_office_user` VALUES ('2215520224935964', '2215520224935998', '2215520224935960', '', null);
INSERT INTO `sys_role_office_user` VALUES ('2215520224935965', '2215520224935999', '2215520224935961', '', null);
INSERT INTO `sys_role_office_user` VALUES ('2215520224935966', '2215520224936000', '2215520224935961', '', null);
INSERT INTO `sys_role_office_user` VALUES ('2215520224935967', '2215520224936002', '2215520224935962', '', null);
INSERT INTO `sys_role_office_user` VALUES ('2215520224935974', '2215520224935997', '2215520224935960', '2215520224936426', null);
INSERT INTO `sys_role_office_user` VALUES ('2215520224935975', '2215520224935998', '2215520224935960', '2215520224936426', null);
INSERT INTO `sys_role_office_user` VALUES ('2215520224935976', '2215520224936028', '2215520224935963', '', null);
INSERT INTO `sys_role_office_user` VALUES ('2215520224935977', '2215520224935997', '2215520224935960', '2215520224936367', null);
INSERT INTO `sys_role_office_user` VALUES ('2215520224935978', '2215520224935998', '2215520224935960', '2215520224936367', null);
INSERT INTO `sys_role_office_user` VALUES ('2215520224935982', '2215520224935997', '2215520224935960', '2215520224936433', null);
INSERT INTO `sys_role_office_user` VALUES ('2215520224935983', '2215520224935998', '2215520224935960', '2215520224936433', null);
INSERT INTO `sys_role_office_user` VALUES ('2215520224935992', '2215520224935997', '2215520224935948', '2215520224936433', null);
INSERT INTO `sys_role_office_user` VALUES ('2215520224935993', '2215520224935998', '2215520224935948', '2215520224936433', null);
INSERT INTO `sys_role_office_user` VALUES ('2215520224936003', '2215520224936031', '2215520224935965', '', null);
INSERT INTO `sys_role_office_user` VALUES ('2215520224936004', '2215520224936032', '2215520224935965', '', null);
INSERT INTO `sys_role_office_user` VALUES ('2215520224936005', '2215520224936033', '2215520224935965', '', null);
INSERT INTO `sys_role_office_user` VALUES ('2215520224936006', '2215520224936034', '2215520224935965', '', null);
INSERT INTO `sys_role_office_user` VALUES ('2215520224936007', '2215520224936035', '2215520224935965', '', null);
INSERT INTO `sys_role_office_user` VALUES ('2215520224936008', '2215520224936036', '2215520224935965', '', null);
INSERT INTO `sys_role_office_user` VALUES ('2215520224936009', '2215520224936037', '2215520224935965', '', null);
INSERT INTO `sys_role_office_user` VALUES ('2215520224936010', '2215520224936038', '2215520224935965', '', null);
INSERT INTO `sys_role_office_user` VALUES ('2215520224936011', '2215520224936039', '2215520224935965', '', null);
INSERT INTO `sys_role_office_user` VALUES ('2215520224936012', '2215520224936040', '2215520224935965', '', null);
INSERT INTO `sys_role_office_user` VALUES ('2215520224936013', '2215520224936041', '2215520224935965', '', null);
INSERT INTO `sys_role_office_user` VALUES ('2215520224936014', '2215520224936042', '2215520224935965', '', null);
INSERT INTO `sys_role_office_user` VALUES ('2215520224936015', '2215520224936043', '2215520224935966', '2215520224936452', null);
INSERT INTO `sys_role_office_user` VALUES ('2215520224936022', '2215520224936040', '2215520224936813', '2215520224935985', null);
INSERT INTO `sys_role_office_user` VALUES ('2215520224936024', '2215520224936040', '2215520224936814', '2215520224935985', null);
INSERT INTO `sys_role_office_user` VALUES ('2215520224936027', '2215520224936044', '2215520224935967', '', null);
INSERT INTO `sys_role_office_user` VALUES ('2215520224936028', '2215520224936031', '2215520224935960', '2215520224936349', null);
INSERT INTO `sys_role_office_user` VALUES ('2215520224936029', '2215520224936031', '2215520224935961', '2215520224936349', null);
INSERT INTO `sys_role_office_user` VALUES ('2215520224936031', '2215520224936037', '2215520224935960', '2215520224936431', null);
INSERT INTO `sys_role_office_user` VALUES ('2215520224936033', '2215520224936065', '2215520224935968', '2215520224936508', null);
INSERT INTO `sys_role_office_user` VALUES ('2215520224936034', '2215520224936071', '2215520224935969', '', null);
INSERT INTO `sys_role_office_user` VALUES ('2215520224936040', '2215520224936072', '2215520224935965', '', null);
INSERT INTO `sys_role_office_user` VALUES ('2215520224936041', '2215520224936031', '2215520224935939', '1', null);
INSERT INTO `sys_role_office_user` VALUES ('2215520224936042', '2215520224936039', '2215520224935939', '1', null);
INSERT INTO `sys_role_office_user` VALUES ('2215520224936043', '2215520224936040', '2215520224935939', '1', null);
INSERT INTO `sys_role_office_user` VALUES ('2215520224936044', '2215520224936031', '2215520224935940', '1', null);
INSERT INTO `sys_role_office_user` VALUES ('2215520224936045', '2215520224936039', '2215520224935940', '1', null);
INSERT INTO `sys_role_office_user` VALUES ('2215520224936046', '2215520224936040', '2215520224935940', '1', null);
INSERT INTO `sys_role_office_user` VALUES ('2215520224936047', '2215520224936031', '2215520224935959', '1', null);
INSERT INTO `sys_role_office_user` VALUES ('2215520224936048', '2215520224936039', '2215520224935959', '1', null);
INSERT INTO `sys_role_office_user` VALUES ('2215520224936049', '2215520224936040', '2215520224935959', '1', null);
INSERT INTO `sys_role_office_user` VALUES ('2215520224936050', '2215520224936031', '2215520224935963', '1', null);
INSERT INTO `sys_role_office_user` VALUES ('2215520224936051', '2215520224936039', '2215520224935963', '1', null);
INSERT INTO `sys_role_office_user` VALUES ('2215520224936052', '2215520224936040', '2215520224935963', '1', null);
INSERT INTO `sys_role_office_user` VALUES ('2215520224936056', '2215520224936031', '2215520224935965', '1', null);
INSERT INTO `sys_role_office_user` VALUES ('2215520224936057', '2215520224936039', '2215520224935965', '1', null);
INSERT INTO `sys_role_office_user` VALUES ('2215520224936058', '2215520224936040', '2215520224935965', '1', null);
INSERT INTO `sys_role_office_user` VALUES ('2215520224936059', '2215520224936073', '2215520224935971', '', null);
INSERT INTO `sys_role_office_user` VALUES ('2215520224936061', '313', '106', '13', null);
INSERT INTO `sys_role_office_user` VALUES ('2215520224936062', '310', '100', '110', null);
INSERT INTO `sys_role_office_user` VALUES ('2215520224936063', '2215520224936076', '2215520224935972', '2215520224936524', null);
INSERT INTO `sys_role_office_user` VALUES ('2215520224936064', '2215520224936077', '2215520224935973', '', null);
INSERT INTO `sys_role_office_user` VALUES ('2215520224936065', '2215520224936078', '2215520224935973', '', null);
INSERT INTO `sys_role_office_user` VALUES ('2215520224936066', '2215520224936031', '2215520224935964', '', null);
INSERT INTO `sys_role_office_user` VALUES ('2215520224936067', '2215520224936039', '2215520224935964', '', null);
INSERT INTO `sys_role_office_user` VALUES ('2215520224936068', '2215520224936040', '2215520224935964', '', null);
INSERT INTO `sys_role_office_user` VALUES ('2215520224936069', '2215520224936037', '2215520224935960', '2215520224936518', null);
INSERT INTO `sys_role_office_user` VALUES ('2215520224936070', '2215520224936031', '2215520224935960', '2215520224936518', null);
INSERT INTO `sys_role_office_user` VALUES ('2215520224936071', '2215520224936031', '2215520224935961', '2215520224936540', null);
INSERT INTO `sys_role_office_user` VALUES ('2215520224936072', '2215520224936037', '2215520224935965', '2215520224936431', null);
INSERT INTO `sys_role_office_user` VALUES ('2215520224936073', '2215520224936031', '2215520224935960', '2215520224936432', null);
INSERT INTO `sys_role_office_user` VALUES ('2215520224936074', '2215520224936037', '2215520224935960', '2215520224936432', null);
INSERT INTO `sys_role_office_user` VALUES ('2215520224936075', '2215520224936077', '2215520224935973', '2215520224936541', null);
INSERT INTO `sys_role_office_user` VALUES ('2215520224936076', '2215520224936078', '2215520224935973', '2215520224936541', null);
INSERT INTO `sys_role_office_user` VALUES ('2215520224936077', '2215520224936081', '2215520224935974', '2215520224936542', null);
INSERT INTO `sys_role_office_user` VALUES ('2215520224936078', '2215520224936082', '2215520224935975', '2215520224936543', null);
INSERT INTO `sys_role_office_user` VALUES ('2215520224936079', '2215520224936083', '2215520224935976', '2215520224936544', null);
INSERT INTO `sys_role_office_user` VALUES ('2215520224936080', '2215520224936084', '2215520224935977', '2215520224936545', null);

-- ----------------------------
-- Table structure for `sys_spcre_relation`
-- ----------------------------
DROP TABLE IF EXISTS `sys_spcre_relation`;
CREATE TABLE `sys_spcre_relation` (
  `id` bigint(20) NOT NULL COMMENT '主键Id',
  `strategy_id` varchar(20) NOT NULL COMMENT '政策ID',
  `product_id` varchar(20) NOT NULL COMMENT '产品ID',
  `channel_id` varchar(20) NOT NULL COMMENT '渠道ID',
  `rebate_id` varchar(20) NOT NULL COMMENT '返利ID',
  `extra_rebate_id` varchar(20) NOT NULL COMMENT '加点返利ID',
  `status` char(1) NOT NULL DEFAULT '0' COMMENT '是否通过 1：是 0：否',
  `refuse_reason` varchar(500) DEFAULT NULL COMMENT '拒绝理由',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='渠道政策产品及返利规则对应表';

-- ----------------------------
-- Records of sys_spcre_relation
-- ----------------------------
INSERT INTO `sys_spcre_relation` VALUES ('2215520224935937', '2215520224936029', '1', '517', '2215520224936068', '2215520224935939', '0', '');

-- ----------------------------
-- Table structure for `sys_user`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` bigint(20) NOT NULL,
  `root_id` bigint(20) DEFAULT NULL COMMENT '根对象ID（用于保存各运行系统的所属根供应商ID）',
  `login_name` varchar(64) NOT NULL COMMENT '登陆名称',
  `login_passwd` varchar(64) NOT NULL COMMENT '登陆密码',
  `sys_code` varchar(64) DEFAULT NULL COMMENT '用户编号',
  `user_type` varchar(64) DEFAULT NULL COMMENT '用户类型',
  `oper_charger_mobile` varchar(32) DEFAULT NULL COMMENT '手机号',
  `oper_charger_phone` varchar(32) DEFAULT NULL COMMENT '电话',
  `oper_charger_fax` varchar(32) DEFAULT NULL COMMENT '传真',
  `oper_charger_email` varchar(32) DEFAULT NULL COMMENT '邮箱',
  `last_login_time` datetime DEFAULT NULL COMMENT '最后登陆时间',
  `last_login_ip` varchar(16) DEFAULT NULL COMMENT '最后登陆ip',
  `account_state` int(2) DEFAULT NULL COMMENT '用户状态 1 正常、0禁用,2删除',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `office_id` char(10) DEFAULT NULL COMMENT '部门id',
  `company_id` bigint(20) DEFAULT NULL COMMENT '公司id',
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父类id',
  `wx_openid` varchar(32) DEFAULT NULL COMMENT '微信绑定账号',
  `login_source` int(2) DEFAULT NULL COMMENT '1:平台；2:手机APP；3:手机和平台 登陆来源',
  `name` varchar(50) DEFAULT NULL COMMENT '结构名称\n',
  `reseller_type` varchar(16) DEFAULT NULL COMMENT '分销商类型',
  `is_buygroup` int(2) DEFAULT NULL COMMENT '1:是0:否 是否团购',
  `is_buysingle` int(2) DEFAULT NULL COMMENT '1:是0:否 是否散票',
  `reseller_level` int(2) DEFAULT NULL COMMENT '分销商等级',
  `province` varchar(64) DEFAULT NULL COMMENT '省',
  `city` varchar(64) DEFAULT NULL COMMENT '市',
  `county` varchar(64) DEFAULT NULL COMMENT '县',
  `corporater` varchar(64) DEFAULT NULL COMMENT '法人名称',
  `credentials_type` int(2) DEFAULT NULL COMMENT '1、居民身份证2、护照3、军人证 证件类型',
  `corporater_credentials` varchar(20) DEFAULT NULL COMMENT '证件号',
  `corporater_mobile` varchar(16) DEFAULT NULL COMMENT '法人手机',
  `corporater_phone` varchar(16) DEFAULT NULL COMMENT '法人电话',
  `corporater_email` varchar(32) DEFAULT NULL COMMENT '法人邮箱',
  `business_certificate` varchar(300) DEFAULT NULL COMMENT '经营许可证',
  `business_license` varchar(300) DEFAULT NULL COMMENT '营业执照',
  `org_code_certificate` varchar(32) DEFAULT NULL COMMENT '机构代码证',
  `tax_certificate` varchar(32) DEFAULT NULL COMMENT '税务登记证',
  `other_files` varchar(32) DEFAULT NULL COMMENT '其他资料',
  `address` varchar(32) DEFAULT NULL COMMENT '分销商地址',
  `reseller_state` int(2) DEFAULT NULL COMMENT '1申请2通过3拒绝4补材料-1,失效 分销商状态',
  `request_date` datetime DEFAULT NULL COMMENT '分销商申请日期',
  `approve_date` datetime DEFAULT NULL COMMENT '分销商批准日期',
  `approve_result` varchar(64) DEFAULT NULL COMMENT '审核结构',
  `contract_num` varchar(32) DEFAULT NULL COMMENT '合同号',
  `description` varchar(1024) DEFAULT NULL COMMENT '分销商描述',
  `wx_open_flag` int(2) DEFAULT NULL COMMENT '0否1是 是否可以开微店',
  `isCReseller` int(2) DEFAULT NULL COMMENT ' 0为否 1为是 默认为0 是否为c商',
  `about_us` varchar(1024) DEFAULT NULL COMMENT '关于',
  `contact_way` varchar(1024) DEFAULT NULL COMMENT '联系方式',
  `reseller_phonetic_shorthand` varchar(128) DEFAULT NULL COMMENT '分销商拼写',
  `supplier_level` varchar(100) DEFAULT NULL COMMENT '默认AAAAA 供应商级别',
  `is_manage` int(2) DEFAULT NULL COMMENT '1:是0:否 是否被上级供应商管理',
  `other_file` varchar(256) DEFAULT NULL COMMENT '其他资料1',
  `other_file2` varchar(256) DEFAULT NULL COMMENT '其他资料2',
  `supplier_address` varchar(256) DEFAULT NULL COMMENT '供应商地址\n景区发票地址，客栈地址',
  `supplier_state` int(2) DEFAULT NULL COMMENT '1申请2通过3拒绝4补材料-1,失效',
  `supplier_description` varchar(1024) DEFAULT NULL COMMENT '供应商介绍',
  `supplier_py` varchar(128) DEFAULT NULL COMMENT '拼音缩写',
  `supplier_normal` varchar(64) DEFAULT NULL COMMENT '俗称',
  `supplier_discount_value` double(5,2) DEFAULT NULL COMMENT '具体扣点数值',
  `from_date` date DEFAULT NULL COMMENT '开始结算日期',
  `period` int(4) DEFAULT NULL COMMENT '结算周期',
  `settle_date` date DEFAULT NULL COMMENT '应结算周期',
  `contract_remarks` varchar(1024) DEFAULT NULL COMMENT '合同规则',
  `contract_notes` varchar(1024) DEFAULT NULL COMMENT '合同备注',
  `verification_codes` varchar(16) DEFAULT NULL COMMENT '供应商code',
  `user_source` varchar(45) DEFAULT NULL COMMENT '用户来源',
  `create_by` varchar(45) DEFAULT NULL COMMENT '创建用户',
  `update_by` varchar(45) DEFAULT NULL COMMENT '更新用户',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `leader_flag` int(2) DEFAULT NULL,
  `ticket_rule` varchar(200) DEFAULT NULL COMMENT '票规',
  `sys_usercol` varchar(45) DEFAULT NULL,
  `check_status` char(1) DEFAULT NULL COMMENT '0注册未完成\n1审核通过\n2审核拒绝，重新提交\n3注册完成待审核',
  `reason_rejection` varchar(500) DEFAULT NULL COMMENT '拒绝理由',
  `business_license_picture` varchar(300) DEFAULT NULL,
  `business_qualification_picture` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='是否是总店长 1.总店长 2店长 3一般员工 ';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', null, 'admin', 'c4ca4238a0b923820dcc509a6f75849b', '0034', '1', '18515122369', '18515194770', null, '111111@qq.com', '2015-12-07 10:54:27', '0:0:0:0:0:0:0:1', '1', null, null, null, null, null, null, '合计北', null, null, null, null, null, null, null, '第三方', null, '454455198505235665', null, null, 'aaaa@163.com', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '加班', null, null, null, null, null, null, null, null, null, null, null, '3', null, '2215520224936277', '2015-12-07 10:34:25', '1', '1', null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224935985', null, '13856846864', 'c4ca4238a0b923820dcc509a6f75849b', null, '1', '13856846864', null, null, null, '2015-12-03 10:59:59', '0:0:0:0:0:0:0:1', null, null, null, null, null, null, null, '测试用户', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-12-04 15:09:38', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224935986', null, '13855555555', 'c4ca4238a0b923820dcc509a6f75849b', null, '1', '13855555555', null, null, null, null, null, null, null, null, null, null, null, null, '13855555555', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-23 14:17:53', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224935987', null, '15756229350', 'c4ca4238a0b923820dcc509a6f75849b', null, '1', '15756229350', '02184522225', null, null, null, null, null, null, null, null, null, null, null, '龙门客栈', null, null, null, null, '46,河北省', '72,唐山市', '74,路北区', '佟湘玉', null, '454455198505235665', null, null, '1871484481@qq.com', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '河北省唐山市路北区', null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-23 14:28:43', null, null, null, null, '3', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224935988', null, '13113131313', 'c4ca4238a0b923820dcc509a6f75849b', null, '1', '13113131313', null, null, null, null, null, null, null, null, null, null, null, null, '13113131313', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-23 14:21:48', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224935989', null, '13511111111', 'c4ca4238a0b923820dcc509a6f75849b', null, '1', '13511111111', '08265478548', null, null, null, null, null, null, null, null, null, null, null, '111', null, null, null, null, '2,北京', '3,北京市', '4,东城区', '313', null, '511621199008197319', null, null, '31313@163.com', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '北京北京市东城区', null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-23 14:22:56', null, null, null, null, '3', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224935990', null, '15756229350', 'c4ca4238a0b923820dcc509a6f75849b', null, '1', '15756229350', null, null, null, null, null, null, null, null, null, null, null, null, '15756229350', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-23 14:29:57', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224935991', null, '13438015554', '96e79218965eb72c92a549dd5a330112', null, '1', '13438015554', null, null, null, null, null, null, null, null, null, null, null, null, '13438015554', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-23 14:35:15', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224935992', null, '15756229350,cyts', '9f7bf6b97af2147a507e8131d45ad1b2', null, '5', '15756229350', '02105052323,1', '1,1', '1,1', null, null, '1', '2015-11-26 11:24:30', null, null, null, null, null, '旅行社,中青旅', '2', null, null, null, '46,河北省', '93,秦皇岛市', '95,山海关区', 'txy_1', null, '340824198906033221', null, null, '1871484481@qq.com', '1,cyts', null, null, null, null, '1,1', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '河北省秦皇岛市山海关区', null, null, '1,cyts', null, null, null, null, null, null, null, null, '3', null, 'rrgfterg', '2015-12-03 20:16:51', '0', '0', 'product:ticketvarie#2,product:ticketvarie#1,product:ticketType#1,product:ticketType#2,product:ticketType#3', null, '1', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224935994', null, '13438015554', '96e79218965eb72c92a549dd5a330112', null, '7', '13438015554', null, null, null, null, null, null, null, null, null, null, null, null, '导游', null, null, null, null, null, null, null, null, null, '340824198905123333', null, null, null, null, null, '54654654654465465', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-23 14:42:38', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224935995', null, '15756229350', 'e10adc3949ba59abbe56e057f20f883e', null, '1', '15756229350', '02105556444', null, null, null, null, null, null, null, null, null, null, null, 'xxxx', null, null, null, null, '46,河北省', '93,秦皇岛市', '96,北戴河区', 'xxxx', null, '340824198905123224', null, null, '15756229350@qq.com', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '河北省秦皇岛市北戴河区', null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-23 14:47:02', null, null, null, null, '3', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224935996', null, '15756229110', 'e10adc3949ba59abbe56e057f20f883e', null, '1', '15756229110', '02123235656', null, null, null, null, null, null, null, null, null, null, null, 'xxxx', null, null, null, null, '22,天津', '23,天津市', '26,河西区', 'xxxx', null, '355519880512356', null, null, '15756229350@qq.com', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '天津天津市河西区', null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-23 14:55:51', null, null, null, null, '3', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224935997', null, '15812345678', 'e10adc3949ba59abbe56e057f20f883e', null, '2215520224935937,3', '15812345678', '028-12345678', null, null, null, null, '2', null, null, null, null, null, null, 'aaaaa', null, null, null, null, '2,北京', '3,北京市', '4,东城区', 'aaa', null, '420802198401010016', null, null, 'haha@163.com', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '北京北京市东城区', null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-27 18:15:27', null, null, null, null, '1', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224935998', null, '13438015554', '96e79218965eb72c92a549dd5a330112', null, '1', '13438015554', null, null, null, null, null, null, null, null, null, null, null, null, '13438015554', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-23 15:16:19', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224935999', null, '15444888888', '3517f9301f64414d50c079e994d70126', null, '1', '15444888888', null, null, null, null, null, '1', null, null, null, null, null, null, '15444888888', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-23 15:30:50', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936000', null, '15444888888', '3517f9301f64414d50c079e994d70126', null, '1', '15444888888', null, null, null, null, null, '1', null, null, null, null, null, null, '15444888888', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-12-03 18:56:14', null, null, null, null, '2', '请填写完整', null, null);
INSERT INTO `sys_user` VALUES ('2215520224936001', null, '15002023333', '3517f9301f64414d50c079e994d70126', null, '1', '15002023333', null, null, null, null, null, '1', null, null, null, null, null, null, '15002023333', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-23 15:31:37', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936002', null, '13888888888', '3517f9301f64414d50c079e994d70126', null, '1', '13888888888', null, null, null, null, null, '1', null, null, null, null, null, null, '13888888888', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-12-04 16:03:45', null, null, null, null, '2', '顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶', null, null);
INSERT INTO `sys_user` VALUES ('2215520224936003', null, '13888888888', '3517f9301f64414d50c079e994d70126', null, '1', '13888888888', null, null, null, null, null, '1', null, null, null, null, null, null, '13888888888', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-23 15:33:41', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936004', null, '15233333333', '3517f9301f64414d50c079e994d70126', null, '1', '15233333333', null, null, null, null, null, '1', null, null, null, null, null, null, '15233333333', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-23 15:42:41', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936005', null, '15756229350', '3517f9301f64414d50c079e994d70126', null, '1', '15756229350', null, null, null, null, null, '1', null, null, null, null, null, null, '15756229350', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-23 15:47:45', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936006', null, '15756223333', '3517f9301f64414d50c079e994d70126', null, '1', '15756223333', null, null, null, null, null, '1', null, null, null, null, null, null, '15756223333', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-23 15:49:16', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936007', null, '15756229350', '3517f9301f64414d50c079e994d70126', null, '', '15756229350', null, null, null, null, null, '1', null, null, null, null, null, null, '15756229350', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-12-03 20:48:29', null, null, null, null, '1', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936008', null, '15756229350', '3517f9301f64414d50c079e994d70126', null, '1', '15756229350', null, null, null, null, null, '1', null, null, null, null, null, null, '15756229350', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-23 15:54:28', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936009', null, '15756229350', '3517f9301f64414d50c079e994d70126', null, '1', '15756229350', null, null, null, null, null, '1', null, null, null, null, null, null, '15756229350', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-23 15:55:24', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936010', null, '15756229350', '3517f9301f64414d50c079e994d70126', null, '1', '15756229350', null, null, null, null, null, '1', null, null, null, null, null, null, '15756229350', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-23 15:56:07', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936011', null, '15756229350', '3517f9301f64414d50c079e994d70126', null, '1', '15756229350', null, null, null, null, null, '1', null, null, null, null, null, null, '15756229350', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-23 16:04:54', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936012', null, '12312345612', 'e10adc3949ba59abbe56e057f20f883e', null, '2215520224935937', '12312345612', '028', null, null, null, null, '1', null, null, null, null, null, null, 'aaaa', null, null, null, null, '2,北京', '3,北京市', '4,东城区', 'aaaa', null, 'aaaa', null, null, 'ff', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '北京北京市东城区', null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-24 10:44:36', null, null, null, null, '1', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936013', null, '13438015554', '96e79218965eb72c92a549dd5a330112', null, '1', '13438015554', null, null, null, null, null, '1', null, null, null, null, null, null, '13438015554', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-23 17:53:12', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936015', null, '13438015557', '96e79218965eb72c92a549dd5a330112', null, '1', '13438015557', null, null, null, null, null, '1', null, null, null, null, null, null, '13438015557', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-23 18:22:44', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936016', null, '13438015554', '96e79218965eb72c92a549dd5a330112', null, '1', '13438015554', null, null, null, null, null, '2', null, null, null, null, null, null, '13438015554', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-24 14:16:11', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936017', null, '13438015554', '96e79218965eb72c92a549dd5a330112', null, '1', '13438015554', null, null, null, null, null, '2', null, null, null, null, null, null, '13438015554', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-24 14:16:21', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936018', null, '13438015554', '96e79218965eb72c92a549dd5a330112', null, '1', '13438015554', null, null, null, null, null, '1', null, null, null, null, null, null, '13438015554', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-23 18:28:05', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936019', null, '13438015554', '96e79218965eb72c92a549dd5a330112', null, '1', '13438015554', null, null, null, null, null, '1', null, null, null, null, null, null, '13438015554', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-23 18:28:24', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936020', null, '13438015554', '96e79218965eb72c92a549dd5a330112', null, '1', '13438015554', null, null, null, null, null, '1', null, null, null, null, null, null, '13438015554', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-23 18:29:00', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936026', null, '13512345612', 'e10adc3949ba59abbe56e057f20f883e', null, '1', '13512345612', '0281-2345678', null, null, null, null, '1', null, null, null, null, null, null, 'zdm', null, null, null, null, '2,北京', '3,北京市', '4,东城区', 'aaaa', null, '420802198401010016', null, null, 'zdmtest@163.com', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '北京北京市东城区', null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-24 10:36:38', null, null, null, null, '2', '就是不爽拒绝了', null, null);
INSERT INTO `sys_user` VALUES ('2215520224936029', null, '13512345613', 'e10adc3949ba59abbe56e057f20f883e', null, '1', '13512345613', null, null, null, null, null, '1', null, null, null, null, null, null, '13512345613', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-24 10:48:16', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936054', null, 'zxp123', '96e79218965eb72c92a549dd5a330112', null, '6', '13438015554', '15987854595', '123123', '74331333@qq.com', null, null, '1', null, null, null, null, null, null, 'zxp旅行社分销商测试,WW1206', null, null, null, null, '北京市', '北京市', '东城区', null, null, null, null, null, null, '123456', null, null, null, null, '123123', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 'zxpzxp', null, null, null, null, null, null, null, null, '3', null, '1', '2015-12-06 14:11:57', '0', '0', 'product:ticketvarie#2,product:ticketvarie#1', null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936068', null, '13438015554', '96e79218965eb72c92a549dd5a330112', null, '1', '13438015554', null, null, null, null, null, '1', null, null, null, null, null, null, '13438015554', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-24 11:07:57', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936070', null, '13438015554', '96e79218965eb72c92a549dd5a330112', null, '1', '13438015554', null, null, null, null, null, '1', null, null, null, null, null, null, '13438015554', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-24 11:10:53', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936071', null, '13438015554', '96e79218965eb72c92a549dd5a330112', null, '1', '13438015554', null, null, null, null, null, '1', null, null, null, null, null, null, '13438015554', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-24 11:22:10', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936072', null, '13438015554', '96e79218965eb72c92a549dd5a330112', null, '1', '13438015554', null, null, null, null, null, '1', null, null, null, null, null, null, '13438015554', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-24 11:22:49', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936073', null, '13438015554', '96e79218965eb72c92a549dd5a330112', null, '1', '13438015554', null, null, null, null, null, '1', null, null, null, null, null, null, '13438015554', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-24 11:23:40', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936074', null, '13438015554', '96e79218965eb72c92a549dd5a330112', null, '1', '13438015554', null, null, null, null, null, '1', null, null, null, null, null, null, '13438015554', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-24 11:25:24', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936075', null, '13438015554', '96e79218965eb72c92a549dd5a330112', null, '1', '13438015554', null, null, null, null, null, '1', null, null, null, null, null, null, '13438015554', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-24 11:30:28', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936076', null, '13438015554', '96e79218965eb72c92a549dd5a330112', null, '1', '13438015554', null, null, null, null, null, '1', null, null, null, null, null, null, '13438015554', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-24 11:30:31', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936077', null, '13438015554', '96e79218965eb72c92a549dd5a330112', null, '1', '13438015554', null, null, null, null, null, '1', null, null, null, null, null, null, '13438015554', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-24 11:31:15', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936078', null, '13438015554', '96e79218965eb72c92a549dd5a330112', null, '1', '13438015554', null, null, null, null, null, '1', null, null, null, null, null, null, '13438015554', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-24 11:31:27', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936079', null, '13438015554', '96e79218965eb72c92a549dd5a330112', null, '1', '13438015554', null, null, null, null, null, '1', null, null, null, null, null, null, '13438015554', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-24 11:37:17', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936080', null, '15756336666', '3517f9301f64414d50c079e994d70126', null, '1', '15756336666', null, null, null, null, null, '1', null, null, null, null, null, null, '15756336666', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-24 11:55:43', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936081', null, '13438015554', '96e79218965eb72c92a549dd5a330112', null, '1', '13438015554', null, null, null, null, null, '1', null, null, null, null, null, null, '13438015554', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-24 12:04:51', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936082', null, '13438015444', '96e79218965eb72c92a549dd5a330112', null, '1', '13438015444', null, null, null, null, null, '1', null, null, null, null, null, null, '13438015444', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-24 12:05:15', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936083', null, '13438015554', '96e79218965eb72c92a549dd5a330112', null, '1', '13438015554', null, null, null, null, null, '1', null, null, null, null, null, null, '13438015554', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-24 12:05:38', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936084', null, '15756229350', 'e10adc3949ba59abbe56e057f20f883e', null, '1', '15756229350', '02188415444', null, null, null, null, '1', null, null, null, null, null, null, 'longmkez', null, null, null, null, '46,河北省', '47,石家庄市', '48,长安区', 'yur', null, '356801198503065656', null, null, '64017888@qq.com', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '河北省石家庄市长安区', null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-24 12:23:51', null, null, null, null, '2', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936085', null, '13438015554', '96e79218965eb72c92a549dd5a330112', null, '1', '13438015554', null, null, null, null, null, '1', null, null, null, null, null, null, '13438015554', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-24 12:22:47', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936086', null, '13438015554', '96e79218965eb72c92a549dd5a330112', null, '1', '13438015554', null, null, null, null, null, '1', null, null, null, null, null, null, '13438015554', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-24 12:24:54', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936087', null, '13438015554', '96e79218965eb72c92a549dd5a330112', null, '1', '13438015554', null, null, null, null, null, '1', null, null, null, null, null, null, '13438015554', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-24 12:26:46', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936088', null, '13438015554', '96e79218965eb72c92a549dd5a330112', null, '1', '13438015554', null, null, null, null, null, '1', null, null, null, null, null, null, '13438015554', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-24 12:30:03', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936089', null, '13438015554', '96e79218965eb72c92a549dd5a330112', null, '2', '13438015554', '02844545454', null, null, null, null, '1', null, null, null, null, null, null, 'fdf', null, null, null, null, '天津市', '和平区', null, '34343', null, '511024199012301768', null, null, '21545454@qq.com', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-24 12:37:03', null, null, null, null, '1', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936090', null, '15021109255', '3517f9301f64414d50c079e994d70126', null, '1', '15021109255', '02156568989', null, null, null, null, '1', null, null, null, null, null, null, '155sdfs', null, null, null, null, '46,河北省', '47,石家庄市', '48,长安区', '155sdfs', null, '340824198905123565', null, null, '455@qq.com', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '河北省石家庄市长安区', null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-24 12:38:34', null, null, null, null, '2', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936091', null, '13438015554', '96e79218965eb72c92a549dd5a330112', null, '1', '13438015554', null, null, null, null, null, '1', null, null, null, null, null, null, '13438015554', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-24 12:35:58', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936092', null, '13511111111', '3517f9301f64414d50c079e994d70126', null, '1', '13511111111', '028-12345678', null, null, null, null, '1', null, null, null, null, null, null, '1351111', null, null, null, null, '2,北京', '3,北京市', '4,东城区', '111', null, '420208198401010011', null, null, 'haha@test.com', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '北京北京市东城区', null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-24 13:09:45', null, null, null, null, '2', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936093', null, '15888888888', '3517f9301f64414d50c079e994d70126', null, '1', '15888888888', '02156565656', null, null, null, null, '1', null, null, null, null, null, null, '1588888888', null, null, null, null, '22,天津', '23,天津市', '24,和平区', '158888888', null, '340824198905123224', null, null, 'ewqe@qq.com', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '天津天津市和平区', null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-24 13:12:45', null, null, null, null, '2', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936094', null, '13438015554', '96e79218965eb72c92a549dd5a330112', null, '1', '13438015554', null, null, null, null, null, '1', null, null, null, null, null, null, '13438015554', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-24 13:19:27', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936095', null, '13438015554', '96e79218965eb72c92a549dd5a330112', null, '1', '13438015554', null, null, null, null, null, '1', null, null, null, null, null, null, '13438015554', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-24 13:20:18', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936096', null, '13438015554', '96e79218965eb72c92a549dd5a330112', null, '1', '13438015554', null, null, null, null, null, '1', null, null, null, null, null, null, '13438015554', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-12-03 18:55:58', null, null, null, null, '2', '请填写完整', null, null);
INSERT INTO `sys_user` VALUES ('2215520224936097', null, '13438015554', '96e79218965eb72c92a549dd5a330112', null, '1', '13438015554', null, null, null, null, null, '1', null, null, null, null, null, null, '13438015554', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-24 13:28:05', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936098', null, '13438015554', '96e79218965eb72c92a549dd5a330112', null, '1', '13438015554', null, null, null, null, null, '1', null, null, null, null, null, null, '13438015554', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-24 13:28:39', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936099', null, '13438015554', '96e79218965eb72c92a549dd5a330112', null, '1', '13438015554', null, null, null, null, null, '1', null, null, null, null, null, null, '13438015554', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-24 13:29:45', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936100', null, '15788745555', 'efe6398127928f1b2e9ef3207fb82663', null, '2', '15788745555', '0214578256', null, null, null, null, '1', null, null, null, null, null, null, 'wqe', null, null, null, null, '486,辽宁省', '487,沈阳市', '488,和平区', 'qweq', null, '340824198905123224', null, null, '778@qq.com', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '辽宁省沈阳市和平区', null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-24 14:30:20', null, null, null, null, '2', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936101', null, '15898998455', 'dbd4e4486fbf56473f359efb9047f021', null, '1', '15898998455', '05416888565', null, null, null, null, '1', null, null, null, null, null, null, 'wqe', null, null, null, null, '371,内蒙古自治区', '372,呼和浩特市', '373,回民区', 'qweqwe', null, '340824198905123227', null, null, 'qwqee@qq.com', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '内蒙古自治区呼和浩特市回民区', null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-24 13:32:30', null, null, null, null, '2', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936102', null, '13438015554', '96e79218965eb72c92a549dd5a330112', null, '1', '13438015554', null, null, null, null, null, '1', null, null, null, null, null, null, '13438015554', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-24 13:33:58', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936103', null, '15788998888', '3517f9301f64414d50c079e994d70126', null, '1', '15788998888', '02189898989', null, null, null, null, '1', null, null, null, null, null, null, 'dsa', null, null, null, null, '680,黑龙江省', '681,哈尔滨市', '682,道里区', 'we55', null, '340824198905123220', null, null, 'qweqw@ll.com', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '黑龙江省哈尔滨市道里区', null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-24 13:36:33', null, null, null, null, '2', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936104', null, '15689897777', '3517f9301f64414d50c079e994d70126', null, '1', '15689897777', '021898985656', null, null, null, null, '1', null, null, null, null, null, null, 'wqewqw', null, null, null, null, '680,黑龙江省', '681,哈尔滨市', '682,道里区', 'ewqee', null, '340824198905123228', null, null, 'qwe@55.com', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '黑龙江省哈尔滨市道里区', null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-24 13:40:09', null, null, null, null, '2', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936105', null, '15633898989', '3517f9301f64414d50c079e994d70126', null, '2', '15633898989', '02156563333', null, null, null, null, '1', null, null, null, null, null, null, 'llff', null, null, null, null, '46,河北省', '47,石家庄市', '48,长安区', 'eqweq', null, '340824198905123224', null, null, 'qe@opo.com', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '河北省石家庄市长安区', null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-24 13:55:47', null, null, null, null, '2', 'fdf ', null, null);
INSERT INTO `sys_user` VALUES ('2215520224936108', null, '15789898988', '3517f9301f64414d50c079e994d70126', null, '1', '15789898988', '02155569999', null, null, null, null, '1', null, null, null, null, null, null, 'eqwe', null, null, null, null, '46,河北省', '47,石家庄市', '48,长安区', 'qeqwe', null, '340856198906031212', null, null, 'qwewq@qq.com', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '河北省石家庄市长安区', null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-24 14:26:26', null, null, null, null, '2', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936109', null, '15789898989', '3517f9301f64414d50c079e994d70126', null, '1', '15789898989', '02166666666', null, null, null, null, '1', null, null, null, null, null, null, 'wqeqw', null, null, null, null, '2,北京', '3,北京市', '4,东城区', 'qweqwe', null, '340812198905053333', null, null, 'weqe@qq.com', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '北京北京市东城区', null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-24 14:27:44', null, null, null, null, '2', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936110', null, '15756669999', '3517f9301f64414d50c079e994d70126', null, '1', '15756669999', '02123232323', null, null, null, null, '1', null, null, null, null, null, null, 'qeqw', null, null, null, null, '2,北京', '3,北京市', '4,东城区', 'qweqw', null, '340812198905123333', null, null, 'qweqw@qq.com', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '北京北京市东城区', null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-24 14:32:25', null, null, null, null, '2', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936111', null, '15889898989', '3517f9301f64414d50c079e994d70126', null, '1', '15889898989', '02156565656', null, null, null, null, '1', null, null, null, null, null, null, 'weqweeqwe', null, null, null, null, '2,北京', '3,北京市', '4,东城区', 'qeqwe', null, '340812198906065656', null, null, 'qweqw@qq.com', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '北京北京市东城区', null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-24 14:58:01', null, null, null, null, '2', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936112', null, '13438015554', '96e79218965eb72c92a549dd5a330112', null, '1', '13438015554', null, null, null, null, null, '1', null, null, null, null, null, null, '13438015554', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-24 15:19:27', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936113', null, '15689888888', '3517f9301f64414d50c079e994d70126', null, '1', '15689888888', '02156566888', null, null, null, null, '1', null, null, null, null, null, null, 'wrwer', null, null, null, null, '北京市', '东城区', null, 'wrwe', null, '340824198905085656', null, null, 'ewqe@qq.com', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-24 15:34:14', null, null, null, null, '2', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936114', null, '18956457878', '3517f9301f64414d50c079e994d70126', null, '2', '18956457878', '021788788898', null, null, null, null, '1', null, null, null, null, null, null, 'qweqwe', null, null, null, null, '北京市', '东城区', null, 'qewqe', null, '357805198705064545', null, null, 'qewq@77.com', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-24 15:40:43', null, null, null, null, '2', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936115', null, '18524246666', '3517f9301f64414d50c079e994d70126', null, '1', '18524246666', '02156897878', null, null, null, null, '1', null, null, null, null, null, null, 'qeqwe', null, null, null, null, '北京市', '东城区', null, 'eqw', null, '340821198905043565', null, null, 'qwewq@qq.com', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-24 15:44:21', null, null, null, null, '2', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936116', null, '15689777856', '3517f9301f64414d50c079e994d70126', null, '1', '15689777856', '02156789496', null, null, null, null, '1', null, null, null, null, null, null, 'qweqwe', null, null, null, null, '天津市', '和平区', null, 'eqe', null, '340824197705063556', null, null, 'qweqw@qq.com', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-24 15:45:02', null, null, null, null, '2', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936117', null, '18989877888', '3517f9301f64414d50c079e994d70126', null, '2', '18989877888', '02156897889', null, null, null, null, '1', null, null, null, null, null, null, 'eqweqw', null, null, null, null, '北京市', '东城区', null, 'eqwe', null, '340815198905053226', null, null, 'ewewq@qq.com', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-24 15:47:49', null, null, null, null, '1', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936119', null, '13438015554', '96e79218965eb72c92a549dd5a330112', null, '1', '13438015554', null, null, null, null, null, '1', null, null, null, null, null, null, '13438015554', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-24 16:39:29', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936121', null, '13438015554', '96e79218965eb72c92a549dd5a330112', null, '1', '13438015554', null, null, null, null, null, '1', null, null, null, null, null, null, '13438015554', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-24 19:39:02', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936122', null, '13438015554', '96e79218965eb72c92a549dd5a330112', null, '1', '13438015554', null, null, null, null, null, '1', null, null, null, null, null, null, '13438015554', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-25 09:42:55', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936123', null, '18228128472', '96e79218965eb72c92a549dd5a330112', null, '1', '18228128472', null, null, null, null, null, '1', null, null, null, null, null, null, '18228128472', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-25 09:49:22', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936124', null, '13438015554', '96e79218965eb72c92a549dd5a330112', null, '1', '13438015554', null, null, null, null, null, '1', null, null, null, null, null, null, '13438015554', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-25 09:49:50', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936125', null, '13438015554', '96e79218965eb72c92a549dd5a330112', null, '1', '13438015554', null, null, null, null, null, '1', null, null, null, null, null, null, '13438015554', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-25 09:49:50', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936126', null, '13438015554', '96e79218965eb72c92a549dd5a330112', null, '1', '13438015554', null, null, null, null, null, '1', null, null, null, null, null, null, '13438015554', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-25 09:49:51', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936127', null, '13438015554', '96e79218965eb72c92a549dd5a330112', null, '1', '13438015554', null, null, null, null, null, '1', null, null, null, null, null, null, '13438015554', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-25 09:49:53', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936128', null, '13438015554', '96e79218965eb72c92a549dd5a330112', null, '1', '13438015554', null, null, null, null, null, '1', null, null, null, null, null, null, '13438015554', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-25 09:49:53', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936129', null, '13438015554', '96e79218965eb72c92a549dd5a330112', null, '1', '13438015554', null, null, null, null, null, '1', null, null, null, null, null, null, '13438015554', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-25 09:49:55', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936130', null, '13438015554', '96e79218965eb72c92a549dd5a330112', null, '1', '13438015554', null, null, null, null, null, '1', null, null, null, null, null, null, '13438015554', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-25 10:00:41', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936131', null, '18228128472', '96e79218965eb72c92a549dd5a330112', null, '1', '18228128472', null, null, null, null, null, '1', null, null, null, null, null, null, '18228128472', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-25 10:02:13', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936132', null, '18228128472', '96e79218965eb72c92a549dd5a330112', null, '1', '18228128472', null, null, null, null, null, '1', null, null, null, null, null, null, '18228128472', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-25 10:03:06', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936133', null, '18228128472', '96e79218965eb72c92a549dd5a330112', null, '1', '18228128472', null, null, null, null, null, '1', null, null, null, null, null, null, '18228128472', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-25 10:03:21', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936134', null, '13438015554', '96e79218965eb72c92a549dd5a330112', null, '1', '13438015554', null, null, null, null, null, '1', null, null, null, null, null, null, '13438015554', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-25 10:09:31', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936135', null, '18583645221', '86ded8d09e50acc536b511e668264d17', null, '1', '18583645221', null, null, null, null, null, '1', null, null, null, null, null, null, '18583645221', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-25 10:34:05', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936136', null, '18583645221', '86ded8d09e50acc536b511e668264d17', null, '1', '18583645221', null, null, null, null, null, '1', null, null, null, null, null, null, '18583645221', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-25 10:39:57', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936137', null, '18583645221', '86ded8d09e50acc536b511e668264d17', null, '1', '18583645221', null, null, null, null, null, '1', null, null, null, null, null, null, '18583645221', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-25 10:43:00', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936138', null, '18535465221', '86ded8d09e50acc536b511e668264d17', null, '1', '18535465221', null, null, null, null, null, '1', null, null, null, null, null, null, '18535465221', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-25 10:52:55', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936139', null, '18564521111', '86ded8d09e50acc536b511e668264d17', null, '1', '18564521111', null, null, null, null, null, '1', null, null, null, null, null, null, '18564521111', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-25 10:53:37', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936140', null, '18563545221', '86ded8d09e50acc536b511e668264d17', null, '1', '18563545221', null, null, null, null, null, '1', null, null, null, null, null, null, '18563545221', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-25 10:54:14', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936141', null, '15255555555', '86ded8d09e50acc536b511e668264d17', null, '1', '15255555555', null, null, null, null, null, '1', null, null, null, null, null, null, '15255555555', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-25 10:54:27', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936142', null, '18564545214', '86ded8d09e50acc536b511e668264d17', null, '1', '18564545214', null, null, null, null, null, '1', null, null, null, null, null, null, '18564545214', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-25 11:06:28', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936143', null, '15255555555', '86ded8d09e50acc536b511e668264d17', null, '1', '15255555555', null, null, null, null, null, '1', null, null, null, null, null, null, '15255555555', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-25 11:07:44', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936144', null, '15266666666', '86ded8d09e50acc536b511e668264d17', null, '1', '15266666666', null, null, null, null, null, '1', null, null, null, null, null, null, '15266666666', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-25 11:09:07', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936145', null, '15444444444', '86ded8d09e50acc536b511e668264d17', null, '1', '15444444444', null, null, null, null, null, '1', null, null, null, null, null, null, '15444444444', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-25 11:09:56', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936146', null, '18586354551', '86ded8d09e50acc536b511e668264d17', null, '1', '18586354551', null, null, null, null, null, '1', null, null, null, null, null, null, '18586354551', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-25 11:12:33', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936147', null, '18586485552', '86ded8d09e50acc536b511e668264d17', null, '1', '18586485552', null, null, null, null, null, '1', null, null, null, null, null, null, '18586485552', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-25 11:14:44', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936148', null, '15266666666', '86ded8d09e50acc536b511e668264d17', null, '1', '15266666666', null, null, null, null, null, '1', null, null, null, null, null, null, '15266666666', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-25 11:16:09', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936149', null, '15244444444', '86ded8d09e50acc536b511e668264d17', null, '1', '15244444444', null, null, null, null, null, '1', null, null, null, null, null, null, '15244444444', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-25 11:16:42', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936150', null, '13438015554', '96e79218965eb72c92a549dd5a330112', null, '1', '13438015554', null, null, null, null, null, '1', null, null, null, null, null, null, '13438015554', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-25 11:32:04', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936151', null, '13438015554', '96e79218965eb72c92a549dd5a330112', null, '1', '13438015554', null, null, null, null, null, '1', null, null, null, null, null, null, '13438015554', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-25 11:32:23', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936152', null, '18586452221', '9aa335fb702c9b758f52ac0a77ccbde0', null, '1', '18586452221', null, null, null, null, null, '1', null, null, null, null, null, null, '18586452221', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-25 11:32:31', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936153', null, '15222222222', 'e5742b5d5a6c96fdc3f3afcf39be6b61', null, '1', '15222222222', null, null, null, null, null, '1', null, null, null, null, null, null, '15222222222', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-25 13:56:25', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936154', null, '15244442524', '96e79218965eb72c92a549dd5a330112', null, '1', '15244442524', null, null, null, null, null, '1', null, null, null, null, null, null, '15244442524', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-25 13:56:58', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936155', null, '15244444444', '13723a026a1a9b499f0e9f9fb8f4f6ad', null, '1', '15244444444', null, null, null, null, null, '1', null, null, null, null, null, null, '15244444444', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-25 13:59:53', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936156', null, '18564646464', '617e0bcd18322e13b934bcd49a750e15', null, '1', '18564646464', null, null, null, null, null, '1', null, null, null, null, null, null, '18564646464', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-25 14:05:10', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936157', null, '15244442222', 'ea90622fa6e23cf933bfdf5db28473fb', null, '1', '15244442222', null, null, null, null, null, '1', null, null, null, null, null, null, '15244442222', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-25 14:06:10', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936158', null, '15222222222', 'dae928de8305b0e471d5c09fa792b502', null, '1', '15222222222', '05161551514', null, null, null, null, '1', null, null, null, null, null, null, '哈哈啊哈', null, null, null, null, '北京市', '东城区', null, '哈呵', null, '511621199008194784', null, null, '1213@163.com', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-26 10:53:57', null, null, null, null, '2', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936159', null, '15534345354', '95574432c9dec32b2c46acff9dab78d9', null, '1', '15534345354', null, null, null, null, null, '1', null, null, null, null, null, null, '15534345354', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-25 14:13:07', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936160', null, '18564646464', '86670706f71dec920a2a122b3637dc3d', null, '1', '18564646464', null, null, null, null, null, '1', null, null, null, null, null, null, '18564646464', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-25 14:14:00', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936161', null, '18564521245', '5620b62f5e148bb4ebbfce5a6eb664ad', null, '2', '18564521245', '0826154525', null, null, null, null, '1', null, null, null, null, null, null, '哈哈哈', null, null, null, null, '北京市', '东城区', null, '哈额哈额', null, '511621199008197319', null, null, '165@163.com', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-26 10:54:04', null, null, null, null, '1', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936162', null, '18583655221', '323ad1042798f6154c60c8af950a4903', null, '1', '18583655221', null, null, null, null, null, '1', null, null, null, null, null, null, '18583655221', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-25 14:18:29', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936163', null, '18268684685', 'b51e8dbebd4ba8a8f342190a4b9f08d7', null, '1', '18268684685', null, null, null, null, null, '1', null, null, null, null, null, null, '18268684685', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-25 14:22:38', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936164', null, '18564686864', 'db79977913a22100d5b0a7622deb2905', null, '1', '18564686864', null, null, null, null, null, '1', null, null, null, null, null, null, '18564686864', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-25 14:23:01', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936165', null, '18568458764', '05baf07e4f51ab7ebd47585eef01c03c', null, '1', '18568458764', null, null, null, null, null, '1', null, null, null, null, null, null, '18568458764', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-25 14:23:19', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936166', null, '18648686868', 'db79977913a22100d5b0a7622deb2905', null, '1', '18648686868', null, null, null, null, null, '1', null, null, null, null, null, null, '18648686868', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-25 14:24:29', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936167', null, '18583655221', '21e18c754026689f9cd604f9d295e924', null, '1', '18583655221', null, null, null, null, null, '1', null, null, null, null, null, null, '18583655221', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-25 14:36:00', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936168', null, '18568684868', '950224c02f92724c7afe70417c1e4380', null, '1', '18568684868', null, null, null, null, null, '1', null, null, null, null, null, null, '18568684868', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-25 15:45:55', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936169', null, '18546464646', '875b2fb478ffd91c7241073b97674e19', null, '1', '18546464646', null, null, null, null, null, '1', null, null, null, null, null, null, '18546464646', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-25 15:46:19', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936171', null, 'cyts,wangjunnan', 'e867b6e8b8fa4d3e4540a54ed3e2aafb', null, '6,4', '18611114126', '1', '1', '1,1', null, null, '1', '2015-11-26 11:29:47', null, null, null, null, null, '中青旅,,王俊南,', '2', null, null, null, null, null, null, null, null, '130731199204170910', null, null, null, '1,1', null, null, null, null, '2', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 'cyts', null, null, null, null, null, null, null, null, null, null, null, '2015-11-26 11:29:54', '0', '0', 'product:ticketvarie#1,product:ticketType#1,product:ticketType#3,product:ticketvarie#1,product:ticketvarie#2', null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936172', null, '13438015554', '96e79218965eb72c92a549dd5a330112', null, '1', '13438015554', null, null, null, null, null, '1', null, null, null, null, null, null, '13438015554', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-26 11:33:16', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936173', null, '15021109280', 'e10adc3949ba59abbe56e057f20f883e', null, '2', '15021109280', '021256568997', null, null, null, null, '1', null, null, null, null, null, null, '同福客栈', null, null, null, null, '内蒙古自治区', '包头市', '东河区', '佟掌柜', null, '340824198603025656', null, null, '56688@qq.com', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-26 18:04:48', null, null, null, null, '1', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936174', null, 'bcyf001', 'e10adc3949ba59abbe56e057f20f883e', null, '6', null, '11', '11', '111', null, null, '1', '2015-11-26 11:58:45', null, null, null, null, null, '湘西自治州凤凰县阳光旅游旅行社', '2', null, null, null, null, null, null, null, null, null, null, null, null, '111', null, null, null, null, '11', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '111', null, null, null, null, null, null, null, null, null, null, null, '2015-11-26 11:58:36', '0', '0', 'product:ticketvarie#1,product:ticketvarie#2,product:ticketType#2', null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936175', null, '王企鹅', '518ed29525738cebdac49c49e60ea9d3', null, '1', '13333333333', '0288888888', null, null, null, null, '1', null, null, null, null, null, null, '是的问问问问', null, null, null, null, '北京市', '东城区', '海勃湾区', '中国人', null, null, null, null, '409744444@163.com', null, '1sds速度多少', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '4', null, null, '2015-12-07 10:15:00', null, null, null, null, '1', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936176', null, 'mflxs', 'c4ca4238a0b923820dcc509a6f75849b', null, '6', null, '1', '1', '1', null, null, '1', '2015-11-26 13:51:19', null, null, null, null, null, '魔方旅行社', '2', null, null, null, null, null, null, null, null, null, null, null, null, '1', null, null, null, null, '1', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', null, null, null, null, null, null, null, null, null, null, null, '2015-11-26 13:51:26', '0', '0', 'product:ticketvarie#1,product:ticketvarie#2,product:ticketType#3', null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936177', null, '111', '698d51a19d8a121ce581499d7b701668', null, '4', '111', null, null, '11', null, null, '1', '2015-11-26 13:53:01', null, null, null, null, null, '魔方王俊南', null, null, null, null, null, null, null, null, null, '111', null, null, null, '111', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '2015-11-26 13:53:08', '0', '0', 'product:ticketvarie#1', null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936178', null, '887488', 'af6d11b562fee1e9faeff29339ee72ee', null, '1', 'qeqweewqe', 'wqeqwe', null, null, null, null, '1', null, null, null, null, null, null, '555', null, null, null, null, '北京市', '东城区', '路南区', '我去额为', null, null, null, null, 'ewqeq', null, '阿萨斯的', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '4', null, null, '2015-11-27 15:04:45', null, null, null, null, '1', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936179', null, 'wqeqq', 'a6050b508a21fbcfa1248c3d8ad4ec4d', null, '1', 'eqwewqe', 'qeqwewq', null, null, null, null, '1', null, null, null, null, null, null, 'eweqweeq', null, null, null, null, '内蒙古自治区', '呼和浩特市', '新城区', 'qweqwee', null, null, null, null, 'dsadasda', null, 'weqweq', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '4', null, null, '2015-11-26 16:31:47', null, null, null, null, '1', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936192', null, '1', 'c4ca4238a0b923820dcc509a6f75849b', null, '6', null, '1', '1', '1', null, null, '1', '2015-11-26 19:55:10', null, null, null, null, null, '1', '1', null, null, null, null, null, null, null, null, null, null, null, null, '1', null, null, null, null, '1', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', null, null, null, null, null, null, null, null, null, null, null, '2015-11-26 19:55:17', '0', '0', 'product:ticketvarie#1,product:ticketvarie#2,product:ticketType#1,product:ticketType#2,product:ticketType#3,product:ticketType#4', null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936260', null, 'qqqq', 'c20ad4d76fe97759aa27a0c99bff6710', null, '6', null, '12', '12', '12', null, null, '0', '2015-11-26 19:56:50', null, null, null, null, null, '12', '1', null, null, null, null, null, null, null, null, null, null, null, null, '12', null, null, null, null, '2', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '12', null, null, null, null, null, null, null, null, null, null, null, '2015-12-05 13:43:12', '0', '0', 'product:ticketvarie#2,product:ticketType#1', null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936277', null, 'admin1', 'c4ca4238a0b923820dcc509a6f75849b', '0034', '7', null, '18511683080', null, null, '2015-12-06 20:13:52', '218.241.163.2', '1', null, null, null, '1', null, null, 'admin1', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', '2015-12-03 14:42:01', '111', '1', null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936278', null, '15888888888', 'e10adc3949ba59abbe56e057f20f883e', null, '1', '15888888888', null, null, null, null, null, '1', null, null, null, null, null, null, '15888888888', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-27 11:50:59', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936279', null, '15888888888', '3517f9301f64414d50c079e994d70126', null, '1', '15888888888', null, null, null, null, null, '1', null, null, null, null, null, null, '15888888888', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-27 11:54:08', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936280', null, '15888888888', '3517f9301f64414d50c079e994d70126', null, '1', '15888888888', null, null, null, null, null, '1', null, null, null, null, null, null, '15888888888', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-27 12:19:58', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936281', null, '18989877888', '3517f9301f64414d50c079e994d70126', null, '1', '18989877888', null, null, null, null, null, '1', null, null, null, null, null, null, '18989877888', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-27 14:08:49', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936282', null, '15888888888', '3517f9301f64414d50c079e994d70126', null, '2', '15888888888', '02155688978', null, null, null, null, '1', null, null, null, null, null, null, '同福可榨', null, null, null, null, '天津市', '和平区', null, '统统', null, '340824198205063556', null, null, 'qeqwe@qq.com', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-30 14:49:07', null, null, null, null, '1', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936283', null, '15789898988', '3517f9301f64414d50c079e994d70126', null, '1', '15789898988', null, null, null, null, null, '1', null, null, null, null, null, null, '15789898988', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-27 15:05:36', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936284', null, '请问请问', 'e10adc3949ba59abbe56e057f20f883e', null, '1', '15456887565', '028-8888888', null, null, null, null, '1', null, null, null, null, null, null, '晕死了哈哈哈哈哈', null, null, null, null, '北京市', '东城区', '海勃湾区', '而且', null, null, null, null, null, null, '54596e6q65e', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '4', null, null, '2015-12-03 20:10:34', null, null, null, null, '1', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936285', null, '你好', '4ba36d23a78c7393b4900ef38019d8ff', null, '1', null, null, null, null, null, null, '2', null, null, null, null, null, null, '旅行社啊', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '2', null, null, '2015-12-07 10:40:17', null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936286', null, '呵呵呵', '96e79218965eb72c92a549dd5a330112', null, '1', null, null, null, null, null, null, '2', null, null, null, null, null, null, '41414', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '2', null, null, '2015-12-03 19:04:10', null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936287', null, '旅行社', '1bbd886460827015e5d605ed44252251', null, '1', null, null, null, null, null, null, '1', null, null, null, null, null, null, '和哈和', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '2', null, null, '2015-11-27 19:21:07', null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936288', null, '测试用户', 'e10adc3949ba59abbe56e057f20f883e', null, '1', null, null, null, null, null, null, '2', null, null, null, null, null, null, 'zdm123', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '2', null, null, '2015-11-27 19:40:05', null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936289', null, 'zdm1', 'e10adc3949ba59abbe56e057f20f883e', null, '1', null, null, null, null, null, null, '1', null, null, null, null, null, null, '测试用户', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '2', null, null, '2015-11-27 19:35:38', null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936291', null, 'test123', 'e10adc3949ba59abbe56e057f20f883e', '0034', '管理团', null, '15624555555', null, null, null, null, '1', null, null, null, null, null, null, 'test123', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '2015-11-28 13:42:43', '111', '1', null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936292', null, '13512345612', 'e10adc3949ba59abbe56e057f20f883e', null, '2', '13512345612', '02812345678', null, null, null, null, '1', null, null, null, null, null, null, '中文客栈', null, null, null, null, '四川省', '成都市', '锦江区', '掌柜就是我', null, '420802198401010017', null, null, 'haha@163.com', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-30 15:30:07', null, null, null, null, '1', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936293', null, '15756229350', '3517f9301f64414d50c079e994d70126', null, '1', '15756229350', '02174788778', null, null, null, null, '1', null, null, null, null, null, null, '呵呵呵', null, null, null, null, '北京市', '东城区', null, '急急急', null, '340821198905043556', null, null, '6ewqe@qq.com', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-30 10:41:16', null, null, null, null, '2', '不用', null, null);
INSERT INTO `sys_user` VALUES ('2215520224936294', null, '15888888888', '3517f9301f64414d50c079e994d70126', null, '1', '15888888888', '021566557778', null, null, null, null, '1', null, null, null, null, null, null, '无情二七', null, null, null, null, '辽宁省', '沈阳市', '和平区', '额外全额', null, '340815198905053226', null, null, '1988@qq.com', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-30 14:49:13', null, null, null, null, '2', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936296', null, '15888888888', '3517f9301f64414d50c079e994d70126', null, '1', '15888888888', null, null, null, null, null, '1', null, null, null, null, null, null, '15888888888', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-30 10:42:15', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936297', null, '15756229351', 'e10adc3949ba59abbe56e057f20f883e', null, '1', '15756229351', '02156897878', null, null, null, null, '1', null, null, null, null, null, null, '超好吃', null, null, null, null, '北京市', '东城区', null, '为轻微', null, '340824198901013225', null, null, 'wq@qq.com', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '景区公司', null, null, '2015-11-30 14:44:34', null, null, null, null, '3', '死吧', null, null);
INSERT INTO `sys_user` VALUES ('2215520224936300', null, '15756229352', '3517f9301f64414d50c079e994d70126', null, '1', '15756229352', null, null, null, null, null, '1', null, null, null, null, null, null, '15756229352', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-30 12:39:42', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936301', null, '15756229353', '3517f9301f64414d50c079e994d70126', null, '1', '15756229353', null, null, null, null, null, '1', null, null, null, null, null, null, '15756229353', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-30 14:25:27', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936302', null, '15756229355', '3517f9301f64414d50c079e994d70126', null, '1', '15756229355', '02156589999', null, null, null, null, '1', null, null, null, null, null, null, '通天塔', null, null, null, null, '北京市', '东城区', null, '切切', null, '340815198905053226', null, null, 'qwewq@qq.com', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-30 14:50:21', null, null, null, null, '2', 'wewq ', null, null);
INSERT INTO `sys_user` VALUES ('2215520224936303', null, '15756229356', 'e10adc3949ba59abbe56e057f20f883e', null, '3', '15756229356', '02156897878', null, null, null, null, '1', null, null, null, null, null, null, '统统我去', null, null, null, null, '山西省', '太原市', '小店区', '位去', null, '340821198905043565', null, null, 'qwewq@qq.com', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-12-04 17:45:31', null, null, null, null, '1', '大乖的', null, null);
INSERT INTO `sys_user` VALUES ('2215520224936304', null, '123223', '734203881b84efbf8ca1daa1a00b6db8', null, '1', null, null, null, null, null, null, '1', null, null, null, null, null, null, '打', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '2', null, null, '2015-11-30 14:57:40', null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936305', null, '123223', '734203881b84efbf8ca1daa1a00b6db8', null, '1', null, null, null, null, null, null, '1', null, null, null, null, null, null, '打', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '2', null, null, '2015-11-30 14:57:46', null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936306', null, '123223', '734203881b84efbf8ca1daa1a00b6db8', null, '1', null, null, null, null, null, null, '1', null, null, null, null, null, null, '打', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '2', null, null, '2015-11-30 14:57:51', null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936307', null, '221552022', 'e10adc3949ba59abbe56e057f20f883e', null, '1', null, null, null, null, null, null, '1', null, null, null, null, null, null, '魔方', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '2', null, null, '2015-11-30 14:58:41', null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936308', null, '221552022', 'e10adc3949ba59abbe56e057f20f883e', null, '1', null, null, null, null, null, null, '1', null, null, null, null, null, null, '魔方', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '2', null, null, '2015-11-30 14:58:44', null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936309', null, '15928479903', 'e10adc3949ba59abbe56e057f20f883e', null, '1', '15928479903', null, null, null, null, null, '1', null, null, null, null, null, null, '15928479903', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-30 15:09:57', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936310', null, '13211111111', 'e10adc3949ba59abbe56e057f20f883e', null, '1', '13211111111', null, null, null, null, null, '1', null, null, null, null, null, null, '13211111111', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-30 15:16:21', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936311', null, '221552022', 'e10adc3949ba59abbe56e057f20f883e', null, '1', null, null, null, null, null, null, '1', null, null, null, null, null, null, '魔方', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '2', null, null, '2015-11-30 15:24:33', null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936312', null, '13212345678', 'e10adc3949ba59abbe56e057f20f883e', null, '1', '13212345678', null, null, null, null, null, '1', null, null, null, null, null, null, '13212345678', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-30 15:26:21', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936313', null, 'supplyTest1', 'e10adc3949ba59abbe56e057f20f883e', null, '1', null, null, null, null, null, null, '1', null, null, null, null, null, null, '测试一', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '2', null, null, '2015-11-30 15:30:43', null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936314', null, '万达', '13bbf54a6850c393fb8d1b2b3bba997b', null, '1', '13086111234', '010-12345678', null, null, null, null, '1', null, null, null, null, null, null, '万达集团有限公司', null, null, null, null, '北京市', '东城区', '长安区', '王思葱', null, null, null, null, '8@7.com', null, '123456', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '4', null, null, '2015-12-04 18:06:50', null, null, null, null, '1', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936315', null, 'test2', 'e10adc3949ba59abbe56e057f20f883e', null, '1', null, null, null, null, null, null, '1', null, null, null, null, null, null, '测试二', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '2', null, null, '2015-11-30 15:37:28', null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936316', null, '13212341234', 'e10adc3949ba59abbe56e057f20f883e', null, '1', '13212341234', null, null, null, null, null, '1', null, null, null, null, null, null, '13212341234', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-30 16:32:04', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936317', null, '13512345619', 'e10adc3949ba59abbe56e057f20f883e', null, '1', '13512345619', null, null, null, null, null, '1', null, null, null, null, null, null, '13512345619', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-30 16:32:57', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936318', null, '123456', '5cb6d49a939cd011920469768ef3e837', null, '1', null, null, null, null, null, null, '2', null, null, null, null, null, null, '小张', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '2', null, null, '2015-11-30 16:44:16', null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936319', null, 'gggg', 'bf572b3449eaa0c0e6c78ed604a021f8', null, '1', null, null, null, null, null, null, '2', null, null, null, null, null, null, '嘿嘿', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '2', null, null, '2015-12-01 09:42:08', null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936320', null, '13512452312', '96e79218965eb72c92a549dd5a330112', null, '3', '13512452312', '020-51232154', null, null, null, null, '1', null, null, null, null, null, null, '丽江古镇', null, null, null, null, '四川省', '成都市', '锦江区', '丽江', null, '512125198512104454', null, null, 'sd@qq.com', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-30 17:44:44', null, null, null, null, '1', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936321', null, '13101010101', '2e771fe4f4354532dbc49c9c9a45e81f', null, '1', '13101010101', '089-2135566', null, null, null, null, '1', null, null, null, null, null, null, '古镇客栈', null, null, null, null, '天津市', '和平区', null, '古镇', null, '101111197810121111', null, null, '84@qq.com', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-30 17:49:34', null, null, null, null, '2', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936322', null, '13101010101', 'e10adc3949ba59abbe56e057f20f883e', null, '3', '13101010101', '012345678912', null, null, null, null, '1', null, null, null, null, null, null, '环龙客栈', null, null, null, null, '四川省', '成都市', '锦江区', '佟掌柜', null, '110123196810151789', null, null, '01234567891234567890@qq.com', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-30 17:45:16', null, null, null, null, '1', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936323', null, '555', 'e10adc3949ba59abbe56e057f20f883e', null, '1', null, null, null, null, null, null, '2', null, null, null, null, null, null, '张三', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '2', null, null, '2015-11-30 18:12:30', null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936324', null, '13502020202', 'e10adc3949ba59abbe56e057f20f883e', null, '5', '13502020202', '01234567891', null, null, null, null, '1', null, null, null, null, null, null, '大点的', null, null, null, null, '北京市', '东城区', null, '顶顶顶顶', null, '10100019891013123', null, null, '89@qq.com', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-30 18:00:48', null, null, null, null, '1', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936325', null, '13502020202', 'e10adc3949ba59abbe56e057f20f883e', null, '1', '13502020202', '0123456789', null, null, null, null, '1', null, null, null, null, null, null, '小七客栈', null, null, null, null, '北京市', '东城区', null, '掌柜', null, '10100019891013123', null, null, 'qq@qq.com', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-30 18:03:16', null, null, null, null, '2', 'wqeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃呃额鹅鹅鹅饿呃呃呃呃呃呃额呃呃呃呃呃呃呃呃呃鹅鹅鹅呃呃呃呃呃呃呃呃呃额呃呃呃鹅鹅鹅鹅鹅鹅鹅鹅鹅谔谔', null, null);
INSERT INTO `sys_user` VALUES ('2215520224936326', null, '13502020202', 'e10adc3949ba59abbe56e057f20f883e', null, '1', '13502020202', null, null, null, null, null, '1', null, null, null, null, null, null, '13502020202', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-30 18:01:41', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936327', null, '15756229357', 'e10adc3949ba59abbe56e057f20f883e', null, '2', '15756229357', '02156897878', null, null, null, null, '1', null, null, null, null, null, null, '佟湘玉', null, null, null, null, '天津市', '河东区', null, '佟湘玉', null, '340821198905043565', null, null, 'qwewq@qq.com', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-12-04 15:16:36', null, null, null, null, '2', '资料不通过', null, null);
INSERT INTO `sys_user` VALUES ('2215520224936328', null, '13502020203', 'e10adc3949ba59abbe56e057f20f883e', null, '1', '13502020203', '012345678912', null, null, null, null, '1', null, null, null, null, null, null, '长江客栈', null, null, null, null, '北京市', '东城区', null, '小七客栈', null, '10100019891013123', null, null, 'q@qq.com', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-30 18:09:46', null, null, null, null, '2', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936329', null, '淘宝', '13bbf54a6850c393fb8d1b2b3bba997b', null, '1', '13478945612', '0123456781', null, null, null, null, '1', null, null, null, null, null, null, '阿里巴巴吧阿里巴巴吧阿里巴巴吧阿里巴巴吧阿里巴巴吧阿里巴巴吧', null, null, null, null, '北京市', '东城区', '长安区', '张少娜张少娜', null, null, null, null, 'q@qq.com', null, '789453363', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '4', null, null, '2015-12-03 13:44:33', null, null, null, null, '1', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936330', null, '13502020202', 'e10adc3949ba59abbe56e057f20f883e', null, '1', '13502020202', null, null, null, null, null, '1', null, null, null, null, null, null, '13502020202', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-30 18:16:45', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936331', null, '13502020205', 'e10adc3949ba59abbe56e057f20f883e', null, '3', '13502020205', '010-2581473', null, null, null, null, '1', null, null, null, null, null, null, '小吧客栈', null, null, null, null, '上海市', '黄浦区', null, '胡巴', null, '10100019891013123', null, null, 'w@qq.com', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-30 18:21:43', null, null, null, null, '1', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936332', null, '18620508066', '96e79218965eb72c92a549dd5a330112', null, '2', '18620508066', '028-27035093', null, null, null, null, '1', null, null, null, null, null, null, '凤凰客栈', null, null, null, null, '四川省', '成都市', '锦江区', '王长老', null, '513902199910092500', null, null, '111@qq.com', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-11-30 18:24:56', null, null, null, null, '1', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936335', null, '18620505066', '96e79218965eb72c92a549dd5a330112', null, '1', '18620505066', '0123456897', null, null, null, null, '1', null, null, null, null, null, null, '龙门客栈', null, null, null, null, '天津市', '和平区', null, '佟湘玉', null, '10100019891013123', null, null, 's@qq.com', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-12-01 10:44:54', null, null, null, null, '2', '该页面主要展示现有平台上的所有景区的列表\r\n主要包含字段：\r\n1、景区名字（两排，多余字符用省略号展示，如果有景区直签，取值来自私有云；如果没有景区直签，取值来自公有云）\r\n2、展示图（一张，不可滑动，不可点击放大，如果有景区直签，取值来自私有云；如果没有景区直签，取值来自公有云）\r\n\r\n规则：\r\n1、下拉刷新，上划最后一条数据时自动加载更多，上拉一次加载10条数据\r\n2、如果该商户第一次使用该应用购票并且没有', null, null);
INSERT INTO `sys_user` VALUES ('2215520224936337', null, '13310086110', 'e10adc3949ba59abbe56e057f20f883e', null, '2', '13310086110', '022-21789789', null, null, null, null, '1', null, null, null, null, null, null, '龙门客栈', null, null, null, null, '重庆市', '沙坪坝区', null, '郭芙蓉', null, '10100019891013123', null, null, 'ff@qq.com', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-12-01 09:52:38', null, null, null, null, '1', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936338', null, '666', 'e10adc3949ba59abbe56e057f20f883e', null, '1', null, null, null, null, null, null, '2', null, null, null, null, null, null, '接口', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '2', null, null, '2015-12-01 10:06:38', null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936339', null, '13522012532', '96e79218965eb72c92a549dd5a330112', null, '1', '13522012532', '01231251251', null, null, null, null, '1', null, null, null, null, null, null, '丽江古镇', null, null, null, null, '辽宁省', '沈阳市', '和平区', '张三', null, '512356198605121245', null, null, '123@qq.com', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-12-01 10:36:28', null, null, null, null, '2', '该页面主要展示现有平台上的所有景区的列表\r\n主要包含字段：\r\n1、景区名字（两排，多余字符用省略号展示，如果有景区直签，取值来自私有云；如果没有景区直签，取值来自公有云）\r\n2、展示图（一张，不可滑动，不可点击放大，如果有景区直签，取值来自私有云；如果没有景区直签，取值来自公有云）\r\n\r\n规则：\r\n1、下拉刷新，上划最后一条数据时自动加载更多，上拉一次加载10条数据\r\n2、如果该商户第一次使用该应用购票并且没有', null, null);
INSERT INTO `sys_user` VALUES ('2215520224936340', null, '18228047315', 'e10adc3949ba59abbe56e057f20f883e', null, '1', '18228047315', '028-27035093', null, null, null, null, '1', null, null, null, null, null, null, '淮安客栈', null, null, null, null, '宁夏回族自治区', '中卫市', '沙坡头区', '张三', null, '110902199910090000', null, null, '11@163.com', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-12-01 10:35:05', null, null, null, null, '2', '该页面用以用户注册新账户\r\n需要输入字段：\r\n1、手机号（正确的11位手机号）\r\n2、验证码（等待系统向用户发送刚才填入的手机发送验证码，点击获取验证码后，用户需等待60s才能再次点击获取）\r\n3、密码（新密码，8~16位，数字、字母任意组合，不区分大小写）\r\n4、密码确认（新密码，8~16位，数字、字母任意组合，不区分大小写，必须与新密码输入一致）\r\n\r\n点击功能：\r\n1、点击获取验证码，获得6位验证码\r\n2、点', null, null);
INSERT INTO `sys_user` VALUES ('2215520224936341', null, '13101010101', '670b14728ad9902aecba32e22fa4f6bd', null, '1', '13101010101', null, null, null, null, null, '1', null, null, null, null, null, null, '13101010101', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-12-01 10:28:57', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936342', null, '111', 'abeac07d3c28c1bef9e730002c753ed4', null, '1', null, null, null, null, null, null, '2', null, null, null, null, null, null, '李四王五赵', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '2', null, null, '2015-12-04 18:17:00', null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936346', null, '18228047315', 'e10adc3949ba59abbe56e057f20f883e', null, '2', '18228047315', '028-27035093', null, null, null, null, '1', null, null, null, null, null, null, '成都客栈', null, null, null, null, '广西壮族自治区', '防城港市', '港口区', '王二', null, '110902199910090000', null, null, '11@163.com', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-12-01 17:25:33', null, null, null, null, '1', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936347', null, '18228047315', 'e10adc3949ba59abbe56e057f20f883e', null, '1', '18228047315', '028-27035093', null, null, null, null, '1', null, null, null, null, null, null, '成都客栈', null, null, null, null, '广西壮族自治区', '防城港市', '港口区', '王二', null, '110902199910090000', null, null, '11@163.com', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-12-02 14:04:45', null, null, null, null, '2', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936349', null, 'test_nn', '1e7baeef956f0dfe96014bd18f07e50a', '1', '7', '12222222222', '13698759648', '22222', 'test@mytour.com', '2015-12-01 11:38:20', null, '1', '2015-12-03 13:51:13', null, null, '1', null, null, '测试用户', null, null, null, null, '河北省', 'beijing', 'beijing', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', '2015-12-04 16:32:57', '1', '1', null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936353', null, '15756229358', '3517f9301f64414d50c079e994d70126', null, '1', '15756229358', null, null, null, null, null, '1', null, null, null, null, null, null, '15756229358', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-12-01 13:56:14', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936354', null, '18900000000', 'e10adc3949ba59abbe56e057f20f883e', null, '2', '18900000000', '028-8985898', null, null, null, null, '1', null, null, null, null, null, null, '大蓉和', null, null, null, null, '四川省', '成都市', '青羊区', '融合', null, '10100019891013120', null, null, '789@qq.com', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-12-04 15:15:32', null, null, null, null, '1', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936355', null, '13520215212', '96e79218965eb72c92a549dd5a330112', null, '2', '13520215212', '012454845211', null, null, null, null, '1', null, null, null, null, null, null, '丽江古镇', null, null, null, null, '北京市', '东城区', null, '张三', null, '512152198610012256', null, null, 'sdf@qq.com', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-12-01 17:16:22', null, null, null, null, '1', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936356', null, '131010101016', 'e10adc3949ba59abbe56e057f20f883e', null, '1', '13101010101', '08955562221', null, null, null, null, '1', null, null, null, null, null, null, '驴妈妈驴妈妈', null, null, null, null, '河北省', '石家庄市', '长安区', '大涨小张宜家', null, null, null, null, 'm@qq.com', null, '788985', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '4', null, null, '2015-12-01 18:14:58', null, null, null, null, '1', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936357', null, 'wuhui', '343170df8c608269f88fe331898cc93f', null, '6', null, '10000', '10', '10', null, null, '1', '2015-12-01 19:30:06', null, null, null, null, null, '武慧', '2', null, null, null, null, null, null, null, null, null, null, null, null, '10000', null, null, null, null, '10', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 'wh', null, null, null, null, null, null, null, null, null, 'rrgfterg', null, '2015-12-01 19:30:15', '0', '0', 'product:ticketvarie#2,product:ticketvarie#1,product:ticketType#1,product:ticketType#0,product:ticketType#4,product:ticketType#3,product:ticketType#2', null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936358', null, '13598444514', '3517f9301f64414d50c079e994d70126', null, '1', '13598444514', null, null, null, null, null, '1', null, null, null, null, null, null, '13598444514', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-12-02 10:25:46', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936360', null, '111111', 'e10adc3949ba59abbe56e057f20f883e', null, '7', null, '18511683080', null, null, null, null, null, null, null, null, '1', null, null, '111111', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', '1', '2015-12-02 13:54:52', null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936361', null, '15989897888', '3517f9301f64414d50c079e994d70126', null, '2', '15989897888', '02156897878', null, null, null, null, '1', null, null, null, null, null, null, '喜来乐', null, null, null, null, '内蒙古自治区', '呼和浩特市', '新城区', '西掌柜', null, '340824198906063555', null, null, 'qwewq@qq.com', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-12-03 11:35:47', null, null, null, null, '1', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936362', null, '15689778888', '3517f9301f64414d50c079e994d70126', null, '2', '15689778888', '02156897878', null, null, null, null, '1', null, null, null, null, null, null, '天涯生化', null, null, null, null, '黑龙江省', '哈尔滨市', '道里区', '急急急', null, '340815198905053226', null, null, '610148670@qq.ccom', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '东苑小区', null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-12-03 13:51:15', null, null, null, null, '1', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936363', null, '15756229350', '3517f9301f64414d50c079e994d70126', null, '1', '15756229350', null, null, null, null, null, '1', null, null, null, null, null, null, '15756229350', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-12-02 14:23:50', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936364', null, 'qwe123', 'e10adc3949ba59abbe56e057f20f883e', null, '7', null, '18687956875', null, null, null, null, null, null, null, null, '1', null, null, '爱仕达', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', '1', '2015-12-02 15:01:49', null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936365', null, '15888888888', '3517f9301f64414d50c079e994d70126', null, '1', '15888888888', null, null, null, null, null, '1', null, null, null, null, null, null, '15888888888', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-12-02 15:16:23', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936366', null, '15888888888', '3517f9301f64414d50c079e994d70126', null, '1', '15888888888', null, null, null, null, null, '1', null, null, null, null, null, null, '15888888888', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-12-02 15:16:41', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936367', null, '员工账号1', 'e10adc3949ba59abbe56e057f20f883e', null, '7', null, '13698758964', null, null, null, null, '1', null, null, null, '1', null, null, '员工姓名1', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', '1', '2015-12-04 10:04:01', null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936369', null, 'yan', 'e10adc3949ba59abbe56e057f20f883e', null, '4', '13522071740', null, null, null, null, null, '1', '2015-12-02 19:51:43', null, null, null, null, null, '严青焕', null, null, null, null, null, null, null, null, null, '110101198610019856', null, null, null, '4512', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '法人', '法人', '2015-12-02 19:59:05', '0', '0', 'product:ticketvarie#1,product:ticketvarie#2', null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936370', null, 'yan', 'e10adc3949ba59abbe56e057f20f883e', null, '6', null, '13522071740', '110101135', 'yanqinghuan@mftour.cn', null, null, '1', '2015-12-02 20:09:00', null, null, null, null, null, '北京旅行社', '3', null, null, null, null, null, null, null, null, null, null, null, null, '123456789', null, null, null, null, 'ddd', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 'bj', null, null, null, null, null, null, null, null, null, '法人', '法人', '2015-12-02 20:09:16', '0', '0', null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936371', null, '18228128472', '96e79218965eb72c92a549dd5a330112', null, '5', '18228128472', '028-8888888', null, null, null, null, '1', null, null, null, null, null, null, '啥地方搜地方', null, null, null, null, '四川省', '成都市', '武侯区', '陈河文', null, '513432198808303613', null, null, '409744756@qq.com', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-12-03 11:27:18', null, null, null, null, '1', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936372', null, '18228128472', '96e79218965eb72c92a549dd5a330112', null, '1', '18228128472', null, null, null, null, null, '1', null, null, null, null, null, null, '18228128472', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-12-03 10:28:10', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936373', null, '18228128472', '96e79218965eb72c92a549dd5a330112', null, '1', '18228128472', null, null, null, null, null, '1', null, null, null, null, null, null, '18228128472', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-12-03 10:58:03', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936374', null, '18228128472', '96e79218965eb72c92a549dd5a330112', null, '1', '18228128472', null, null, null, null, null, '1', null, null, null, null, null, null, '18228128472', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-12-03 11:00:01', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936375', null, '18228128472', '96e79218965eb72c92a549dd5a330112', null, '1', '18228128472', null, null, null, null, null, '1', null, null, null, null, null, null, '18228128472', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-12-03 11:01:00', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936376', null, '18228128472', '96e79218965eb72c92a549dd5a330112', null, '1', '18228128472', null, null, null, null, null, '1', null, null, null, null, null, null, '18228128472', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-12-03 11:01:21', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936377', null, '18228128472', '96e79218965eb72c92a549dd5a330112', null, '1', '18228128472', null, null, null, null, null, '1', null, null, null, null, null, null, '18228128472', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-12-03 11:03:11', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936378', null, '18228128472', '96e79218965eb72c92a549dd5a330112', null, '1', '18228128472', null, null, null, null, null, '1', null, null, null, null, null, null, '18228128472', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-12-03 11:03:31', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936379', null, '18228128472', '96e79218965eb72c92a549dd5a330112', null, '1', '18228128472', null, null, null, null, null, '1', null, null, null, null, null, null, '18228128472', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-12-03 11:04:25', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936380', null, '18228128472', '96e79218965eb72c92a549dd5a330112', null, '1', '18228128472', null, null, null, null, null, '1', null, null, null, null, null, null, '18228128472', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-12-03 11:05:13', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936381', null, '18228128472', '96e79218965eb72c92a549dd5a330112', null, '1', '18228128472', null, null, null, null, null, '1', null, null, null, null, null, null, '18228128472', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-12-03 11:06:16', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936382', null, '18228128472', '96e79218965eb72c92a549dd5a330112', null, '1', '18228128472', null, null, null, null, null, '1', null, null, null, null, null, null, '18228128472', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-12-03 11:09:06', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936383', null, '18228128472', '96e79218965eb72c92a549dd5a330112', null, '1', '18228128472', null, null, null, null, null, '1', null, null, null, null, null, null, '18228128472', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-12-03 11:10:45', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936384', null, '18228128472', 'e10adc3949ba59abbe56e057f20f883e', null, '1', '18228128472', null, null, null, null, null, '1', null, null, null, null, null, null, '18228128472', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-12-03 11:11:32', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936385', null, '18228128472', 'e10adc3949ba59abbe56e057f20f883e', null, '1', '18228128472', null, null, null, null, null, '1', null, null, null, null, null, null, '18228128472', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-12-03 11:12:28', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936386', null, '18228128472', 'e10adc3949ba59abbe56e057f20f883e', null, '1', '18228128472', null, null, null, null, null, '1', null, null, null, null, null, null, '18228128472', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-12-03 11:19:45', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936387', null, '18228128472', 'c4ca4238a0b923820dcc509a6f75849b', null, '1', '18228128472', null, null, null, null, null, '1', null, null, null, null, null, null, '18228128472', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-12-03 11:42:48', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936388', null, '18228128472', 'c20ad4d76fe97759aa27a0c99bff6710', null, '1', '18228128472', null, null, null, null, null, '1', null, null, null, null, null, null, '18228128472', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-12-03 11:43:35', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936389', null, '18228128472', '96e79218965eb72c92a549dd5a330112', null, '1', '18228128472', null, null, null, null, null, '1', null, null, null, null, null, null, '18228128472', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-12-03 11:52:27', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936390', null, '18228128472', 'e10adc3949ba59abbe56e057f20f883e', null, '1', '18228128472', null, null, null, null, null, '1', null, null, null, null, null, null, '18228128472', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-12-03 11:54:08', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936391', null, '18228128472', '96e79218965eb72c92a549dd5a330112', null, '1', '18228128472', null, null, null, null, null, '1', null, null, null, null, null, null, '18228128472', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-12-03 13:59:36', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936392', null, '18228128472', '96e79218965eb72c92a549dd5a330112', null, '1', '18228128472', null, null, null, null, null, '1', null, null, null, null, null, null, '18228128472', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-12-03 14:01:14', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936393', null, '18228128472', '96e79218965eb72c92a549dd5a330112', null, '1', '18228128472', null, null, null, null, null, '1', null, null, null, null, null, null, '18228128472', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-12-03 14:28:46', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936394', null, '18228128472', '96e79218965eb72c92a549dd5a330112', null, '1', '18228128472', null, null, null, null, null, '1', null, null, null, null, null, null, '18228128472', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-12-03 14:29:24', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936395', null, '18228128472', 'e10adc3949ba59abbe56e057f20f883e', null, '1', '18228128472', null, null, null, null, null, '1', null, null, null, null, null, null, '18228128472', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-12-03 14:39:24', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936397', null, '15756229388', '96e79218965eb72c92a549dd5a330112', null, '1', '15756229388', '0288888885', null, null, null, null, '1', null, null, null, null, null, null, '陈河文', null, null, null, null, '北京市', '东城区', null, '陈河文', null, '513432198808303613', null, null, '409744756@qq.com', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 'sdfsdf', null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-12-03 16:20:25', null, null, null, null, '2', '当然非官方', null, null);
INSERT INTO `sys_user` VALUES ('2215520224936398', null, '15756229389', 'e10adc3949ba59abbe56e057f20f883e', null, '1', '15756229389', '0328888888', null, null, null, null, '1', null, null, null, null, null, null, '陈河文', null, null, null, null, '北京市', '东城区', null, '陈河文', null, '513432198808303613', null, null, '409744@qq.com', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 'sdf', null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-12-03 16:22:20', null, null, null, null, '2', 'bvhjjgj', null, null);
INSERT INTO `sys_user` VALUES ('2215520224936399', null, '15756229389', 'e10adc3949ba59abbe56e057f20f883e', null, '1', '15756229389', null, null, null, null, null, '1', null, null, null, null, null, null, '15756229389', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-12-03 16:26:55', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936400', null, '18228128472', 'e10adc3949ba59abbe56e057f20f883e', null, '1', '18228128472', null, null, null, null, null, '1', null, null, null, null, null, null, '18228128472', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-12-03 16:27:52', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936401', null, '13333333333', 'e10adc3949ba59abbe56e057f20f883e', null, '1', '13333333333', '0288888888', null, null, null, null, '1', null, null, null, null, null, null, '陈赫恩', null, null, null, null, '北京市', '东城区', null, '陈河文', null, '513432198808303613', null, null, '490@qq.com', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 'sdf', null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-12-03 16:32:46', null, null, null, null, '2', 'sdfsdfsdf', null, null);
INSERT INTO `sys_user` VALUES ('2215520224936402', null, '18228128472', 'e10adc3949ba59abbe56e057f20f883e', null, '1', '18228128472', null, null, null, null, null, '1', null, null, null, null, null, null, '18228128472', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-12-03 16:35:35', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936403', null, '18888888888', 'e10adc3949ba59abbe56e057f20f883e', null, '', '18888888888', '0288888888', null, null, null, null, '1', null, null, null, null, null, null, '陈河文', null, null, null, null, '北京市', '东城区', null, '陈河文', null, '513432198808303613', null, null, '4@qq.com', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 'sf', null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-12-03 16:58:09', null, null, null, null, '1', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936405', null, '13512345678', 'e10adc3949ba59abbe56e057f20f883e', null, '', '13512345678', '02812345678', null, null, null, null, '1', null, null, null, null, null, null, '中文客栈', null, null, null, null, '山西省', '大同市', '矿区', '掌柜就是我', null, '420802198401010017', null, null, 'haha@163.com', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 'abcdefg', null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-12-04 18:09:46', null, null, null, null, '1', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936406', null, '13512345671', 'e10adc3949ba59abbe56e057f20f883e', null, '1', '13512345671', null, null, null, null, null, '1', null, null, null, null, null, null, '13512345671', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-12-03 17:53:31', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936407', null, '13512345672', 'e10adc3949ba59abbe56e057f20f883e', null, '1', '13512345672', null, null, null, null, null, '1', null, null, null, null, null, null, '13512345672', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-12-03 17:56:33', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936408', null, '13512345674', 'e10adc3949ba59abbe56e057f20f883e', null, '1', '13512345674', null, null, null, null, null, '1', null, null, null, null, null, null, '13512345674', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-12-03 17:57:41', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936409', null, '13512345675', 'e10adc3949ba59abbe56e057f20f883e', null, '1', '13512345675', null, null, null, null, null, '1', null, null, null, null, null, null, '13512345675', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-12-03 18:00:15', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936410', null, '18228128472', 'e10adc3949ba59abbe56e057f20f883e', null, '4', '18228128472', '0288888888', null, null, null, null, '1', null, null, null, null, null, null, '陈河文', null, null, null, null, '北京市', '东城区', null, '陈河文', null, '513432198808303613', null, null, '409744@qq.com', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 'sdfsdf', null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-12-03 18:31:21', null, null, null, null, '1', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936411', null, '18228128472', 'e10adc3949ba59abbe56e057f20f883e', null, '1', '18228128472', null, null, null, null, null, '1', null, null, null, null, null, null, '18228128472', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-12-03 18:33:23', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936412', null, '18228128472', 'e10adc3949ba59abbe56e057f20f883e', null, '1', '18228128472', null, null, null, null, null, '1', null, null, null, null, null, null, '18228128472', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-12-03 18:33:50', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936413', null, '18228128472', 'e10adc3949ba59abbe56e057f20f883e', null, '1', '18228128472', null, null, null, null, null, '1', null, null, null, null, null, null, '18228128472', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-12-03 18:35:20', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936414', null, '18228128472', 'e10adc3949ba59abbe56e057f20f883e', null, '1', '18228128472', null, null, null, null, null, '1', null, null, null, null, null, null, '18228128472', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-12-03 18:35:44', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936415', null, '18228128472', 'e10adc3949ba59abbe56e057f20f883e', null, '1', '18228128472', null, null, null, null, null, '1', null, null, null, null, null, null, '18228128472', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-12-03 18:39:04', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936416', null, '18228128472', 'e10adc3949ba59abbe56e057f20f883e', null, '1', '18228128472', null, null, null, null, null, '1', null, null, null, null, null, null, '18228128472', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-12-03 18:39:04', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936417', null, '18228128472', 'e10adc3949ba59abbe56e057f20f883e', null, '1', '18228128472', null, null, null, null, null, '1', null, null, null, null, null, null, '18228128472', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-12-03 18:39:04', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936418', null, '18228128472', 'e10adc3949ba59abbe56e057f20f883e', null, '1', '18228128472', null, null, null, null, null, '1', null, null, null, null, null, null, '18228128472', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-12-03 18:39:04', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936419', null, '18228128472', 'e10adc3949ba59abbe56e057f20f883e', null, '1', '18228128472', null, null, null, null, null, '1', null, null, null, null, null, null, '18228128472', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-12-03 18:39:05', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936425', null, '15756229359', 'e10adc3949ba59abbe56e057f20f883e', null, '3', '15756229359', '02156897878', null, null, null, null, '1', null, null, null, null, null, null, '一桶客栈', null, null, null, null, '河北省', '石家庄市', '长安区', '猪八戒', null, '340824195606035456', null, null, 'qwewq@qq.com', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '桂林路地铁站', null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-12-03 20:48:14', null, null, null, null, '1', '双方所发生的', null, null);
INSERT INTO `sys_user` VALUES ('2215520224936426', null, 'qweasd', 'e10adc3949ba59abbe56e057f20f883e', null, '7', null, '13896587584', null, null, null, null, '1', null, null, null, '1', null, null, '3号晚测试', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', '1', '2015-12-03 21:10:47', null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936427', null, 'lxs123', 'e10adc3949ba59abbe56e057f20f883e', null, '6', null, '18501378230', '010-88888888', null, null, null, '1', '2015-12-03 23:03:13', null, null, null, null, null, '旅行社', '2', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 'lxs', null, null, null, null, null, null, null, null, null, '1', '1', '2015-12-05 17:24:15', '0', '0', 'product:ticketvarie#2,product:ticketvarie#1,product:ticketType#18,product:ticketType#20', null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936428', null, '18228128472', 'e10adc3949ba59abbe56e057f20f883e', null, '1', '18228128472', null, null, null, null, null, '1', null, null, null, null, null, null, '18228128472', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-12-04 09:43:08', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936429', null, '18228128472', 'e10adc3949ba59abbe56e057f20f883e', null, '1', '18228128472', null, null, null, null, null, '1', null, null, null, null, null, null, '18228128472', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-12-04 09:43:48', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936430', null, '18228128472', 'e10adc3949ba59abbe56e057f20f883e', null, '1', '18228128472', null, null, null, null, null, '1', null, null, null, null, null, null, '18228128472', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-12-04 09:45:13', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936431', null, 'yangfa', 'e10adc3949ba59abbe56e057f20f883e', null, '7', null, '18501378230', null, null, null, null, '1', null, null, null, '1', null, null, 'yangfa', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', '1', '2015-12-07 10:10:19', null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936432', null, 'qwe', 'e10adc3949ba59abbe56e057f20f883e', null, '7', null, '13678954875', null, null, null, null, '1', null, null, null, '1', null, null, 'qwe', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '12', '1', '1', '2015-12-07 10:16:42', null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936433', null, 'zxp578995478', 'e10adc3949ba59abbe56e057f20f883e', null, '7', null, '15987954785', null, null, null, null, '1', null, null, null, '1', null, null, '04早上测试第一次', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', '1', '2015-12-04 14:26:30', null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936434', null, '13000000000', 'e10adc3949ba59abbe56e057f20f883e', null, '1', '13000000000', null, null, null, null, null, '1', null, null, null, null, null, null, '13000000000', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-12-04 10:17:15', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936435', null, '15555555555', '6537e99af2c2223642df9f70a0b5afca', null, '1', '15555555555', null, null, null, null, null, '1', null, null, null, null, null, null, '15555555555', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-12-04 10:28:26', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936436', null, 'wxf', 'c4ca4238a0b923820dcc509a6f75849b', null, '6', null, '12345678912', 'df', null, null, null, '1', '2015-12-04 10:32:50', null, null, null, null, null, '王兴飞', '5', null, null, null, null, null, null, null, null, null, null, null, null, 'abc', null, null, null, null, 'dfds', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 'wxf', null, null, null, null, null, null, null, null, null, '1', null, '2015-12-04 10:32:59', '0', '0', 'product:ticketvarie#2,product:ticketvarie#1', null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936437', null, '13345678945', 'e10adc3949ba59abbe56e057f20f883e', null, '1', '13345678945', null, null, null, null, null, '1', null, null, null, null, null, null, '13345678945', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-12-04 10:35:44', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936438', null, '13010086111', '1f686eebbbe0a41c94b938e7114cf2c3', null, '1', '13010086111', null, null, null, null, null, '1', null, null, null, null, null, null, '13010086111', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-12-04 10:41:35', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936440', null, '2467824077', 'e10adc3949ba59abbe56e057f20f883e', null, '7', null, '15846879545', null, null, null, null, '1', null, null, null, '1', null, null, '张翔鹏', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', '1', '2015-12-04 14:09:21', null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936441', null, '15928479903', 'e10adc3949ba59abbe56e057f20f883e', null, '1', '15928479903', null, null, null, null, null, '1', null, null, null, null, null, null, '15928479903', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-12-04 10:58:44', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936442', null, 'csssskz', 'e99a18c428cb38d5f260853678922e03', null, '7', null, '15210147644', null, null, null, null, '1', null, null, null, '1', null, null, '日本国产客机成功首飞', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', '1', '2015-12-04 14:38:13', null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936443', null, '15612312312', '293f6338b046d65e437b7ca39ba90136', null, '1', '15612312312', null, null, null, null, null, '1', null, null, null, null, null, null, '15612312312', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-12-04 11:14:39', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936444', null, 'test_nn', '1e7baeef956f0dfe96014bd18f07e50a', null, '一般用户', '12222222222', '12222222222', '22222', 'test@mytour.com', '2015-12-04 11:21:36', null, null, '2015-12-04 11:21:36', null, null, null, null, null, 'cccccc用户', null, null, null, null, '河北省', 'beijing', 'beijing', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '2015-12-04 11:17:08', '1', '1', null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936445', null, 'test_nn', '1e7baeef956f0dfe96014bd18f07e50a', null, '一般用户', '12222222222', '12222222222', '22222', 'test@mytour.com', '2015-12-04 11:22:59', null, '1', '2015-12-04 11:22:59', null, null, null, null, null, 'cccccc用户', null, null, null, null, '河北省', 'beijing', 'beijing', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '2015-12-04 11:20:48', '1', '1', null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936446', null, '13612341234', 'a9588aa82388c0579d8f74b4d02b895f', null, '1', '13612341234', null, null, null, null, null, '1', null, null, null, null, null, null, '13612341234', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-12-04 11:29:00', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936447', null, '13612341234', '54e8e33298f80d80de23cfd6debc932b', null, '1', '13612341234', null, null, null, null, null, '1', null, null, null, null, null, null, '13612341234', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-12-04 11:39:37', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936448', null, '13514141414', 'e10adc3949ba59abbe56e057f20f883e', null, '1', '13514141414', null, null, null, null, null, '1', null, null, null, null, null, null, '13514141414', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-12-04 11:52:41', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936449', null, '15756229355', 'e10adc3949ba59abbe56e057f20f883e', null, '1', '15756229355', '02156897878', null, null, null, null, '1', null, null, null, null, null, null, '阿诗丹顿', null, null, null, null, '北京市', '东城区', null, '我去额为', null, '340824198603025656', null, null, 'ewewq@qq.com', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '哈哈哈', null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-12-04 18:21:37', null, null, null, null, '2', '是的发生的 ', null, null);
INSERT INTO `sys_user` VALUES ('2215520224936450', null, '13201010101', 'e10adc3949ba59abbe56e057f20f883e', null, '1', '13201010101', null, null, null, null, null, '1', null, null, null, null, null, null, '13201010101', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-12-04 13:44:21', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936451', null, '13202020202', '670b14728ad9902aecba32e22fa4f6bd', null, '1', '13202020202', null, null, null, null, null, '1', null, null, null, null, null, null, '13202020202', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-12-04 13:52:52', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936452', null, 'test_nn', '1e7baeef956f0dfe96014bd18f07e50a', '1', '一般用户', '12222222222', '12222222222', '22222', 'test@mytour.com', '2015-12-04 14:00:12', null, '1', '2015-12-04 14:00:12', null, null, null, null, null, '测试用户', null, null, null, null, '河北省', 'beijing', 'beijing', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '2015-12-04 13:55:43', '1', '1', null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936453', null, '15888888888', 'e10adc3949ba59abbe56e057f20f883e', null, '1', '15888888888', null, null, null, null, null, '1', null, null, null, null, null, null, '15888888888', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-12-04 13:56:05', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936454', null, '15888888888', 'e10adc3949ba59abbe56e057f20f883e', null, '1', '15888888888', null, null, null, null, null, '1', null, null, null, null, null, null, '15888888888', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-12-04 14:18:39', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936455', null, '15756229350', 'e10adc3949ba59abbe56e057f20f883e', null, '1', '15756229350', null, null, null, null, null, '1', null, null, null, null, null, null, '15756229350', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-12-04 14:22:44', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936456', null, '15263201231', 'e10adc3949ba59abbe56e057f20f883e', null, '1', '15263201231', null, null, null, null, null, '1', null, null, null, null, null, null, '15263201231', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-12-04 14:43:27', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936457', null, '15888888888', 'e10adc3949ba59abbe56e057f20f883e', null, '1', '15888888888', null, null, null, null, null, '1', null, null, null, null, null, null, '15888888888', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-12-04 14:49:02', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936458', null, '15888888888', 'e10adc3949ba59abbe56e057f20f883e', null, '2', '15888888888', null, null, null, null, null, '1', null, null, null, null, null, null, '15888888888', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-12-04 17:35:22', null, null, null, null, '1', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936459', null, '15888888888', 'e10adc3949ba59abbe56e057f20f883e', null, '1', '15888888888', null, null, null, null, null, '1', null, null, null, null, null, null, '15888888888', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-12-04 14:52:29', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936460', null, '15888888888', 'e10adc3949ba59abbe56e057f20f883e', null, '1', '15888888888', null, null, null, null, null, '1', null, null, null, null, null, null, '15888888888', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-12-04 14:54:52', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936461', null, '15888888888', 'e10adc3949ba59abbe56e057f20f883e', null, '1', '15888888888', null, null, null, null, null, '1', null, null, null, null, null, null, '15888888888', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-12-04 14:55:32', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936462', null, '13689756421', 'e10adc3949ba59abbe56e057f20f883e', null, '1', '13689756421', null, null, null, null, null, '1', null, null, null, null, null, null, '13689756421', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-12-04 14:57:42', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936465', null, '13214567890', 'e10adc3949ba59abbe56e057f20f883e', null, '1', '13214567890', '055-8954894', null, null, null, null, '1', null, null, null, null, null, null, '老坎客栈', null, null, null, null, '四川省', '成都市', '锦江区', '陈黔贵', null, '150111195201023125', null, null, '123@qq.com', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '桐梓林', null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-12-04 15:11:28', null, null, null, null, '3', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936466', null, '13522012532', 'e10adc3949ba59abbe56e057f20f883e', null, '1', '13522012532', null, null, null, null, null, '1', null, null, null, null, null, null, '13522012532', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-12-04 15:03:59', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936467', null, '15756229350', 'e10adc3949ba59abbe56e057f20f883e', null, '1', '15756229350', null, null, null, null, null, '1', null, null, null, null, null, null, '15756229350', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-12-04 15:04:25', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936468', null, '13522012532', '96e79218965eb72c92a549dd5a330112', null, '1', '13522012532', null, null, null, null, null, '1', null, null, null, null, null, null, '13522012532', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-12-04 15:04:57', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936469', null, '15878787878', 'e10adc3949ba59abbe56e057f20f883e', null, '1', '15878787878', null, null, null, null, null, '1', null, null, null, null, null, null, '15878787878', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-12-04 15:08:20', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936470', null, '15756229350', 'e10adc3949ba59abbe56e057f20f883e', null, '1', '15756229350', null, null, null, null, null, '1', null, null, null, null, null, null, '15756229350', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-12-04 15:10:43', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936471', null, '15888888888', 'e10adc3949ba59abbe56e057f20f883e', null, '', '15888888888', null, null, null, null, null, '1', null, null, null, null, null, null, '15888888888', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-12-04 17:23:04', null, null, null, null, '1', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936472', null, '15928479903', 'e10adc3949ba59abbe56e057f20f883e', null, '', '15928479903', '028-52223636', null, null, null, null, '1', null, null, null, null, null, null, '老坎客栈', null, null, null, null, '河北省', '石家庄市', '长安区', '陈黔贵', null, '150111195201023125', null, null, 'cd@sina.vip.com', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '小路', null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-12-04 15:36:11', null, null, null, null, '1', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936473', null, '15756229350', 'e10adc3949ba59abbe56e057f20f883e', null, '1', '15756229350', null, null, null, null, null, '1', null, null, null, null, null, null, '15756229350', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-12-04 15:19:24', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936474', null, '15888888888', 'e10adc3949ba59abbe56e057f20f883e', null, '1', '15888888888', null, null, null, null, null, '1', null, null, null, null, null, null, '15888888888', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-12-04 15:20:12', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936475', null, '13012301230', '670b14728ad9902aecba32e22fa4f6bd', null, '1', '13012301230', '028-12345678', null, null, null, null, '1', null, null, null, null, null, null, '掌上客栈', null, null, null, null, '四川省', '成都市', '青羊区', '老张', null, '510111195612301235', null, null, '0000@qq.coom', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '马鞍北路44好', null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-12-04 15:42:52', null, null, null, null, '2', '直接拒绝顶顶顶顶', null, null);
INSERT INTO `sys_user` VALUES ('2215520224936476', null, '15888888888', 'e10adc3949ba59abbe56e057f20f883e', null, '1', '15888888888', null, null, null, null, null, '1', null, null, null, null, null, null, '15888888888', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-12-04 15:21:50', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936477', null, 'yan', 'e10adc3949ba59abbe56e057f20f883e', null, '6', null, '13522071740', '68954785', null, null, null, '2', '2015-12-04 15:26:30', null, null, null, null, null, '青年旅行社', '2', null, null, null, null, null, null, null, null, null, null, null, null, '1000', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 'qn', null, null, null, null, null, null, null, null, null, '1', '1', '2015-12-06 20:46:06', '0', '0', 'product:ticketType#22', null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936478', null, '123456', 'e10adc3949ba59abbe56e057f20f883e', null, '6', null, '111111', '1111111', null, null, null, '1', '2015-12-04 15:36:10', null, null, null, null, null, '发哥', '3', null, null, null, null, null, null, null, null, null, null, null, null, '001', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 'fg', null, null, null, null, null, null, null, null, null, '1', '1', '2015-12-04 15:39:14', '0', '0', 'product:ticketvarie#2,product:ticketvarie#1', null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936479', null, '15888888888', 'e10adc3949ba59abbe56e057f20f883e', null, '1', '15888888888', null, null, null, null, null, '1', null, null, null, null, null, null, '15888888888', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-12-04 15:37:02', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936480', null, '15888888888', 'e10adc3949ba59abbe56e057f20f883e', null, '1', '15888888888', null, null, null, null, null, '1', null, null, null, null, null, null, '15888888888', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-12-04 17:04:06', null, null, null, null, '2', 'dddddddddddddddddddddddddd', null, null);
INSERT INTO `sys_user` VALUES ('2215520224936481', null, '123456', 'e10adc3949ba59abbe56e057f20f883e', null, '6', null, '131', '13', '13', null, null, '1', '2015-12-04 15:40:11', null, null, null, null, null, '发哥哥', '2', null, null, null, null, null, null, null, null, null, null, null, null, 'GFF', null, null, null, null, '13', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 'FGG', null, null, null, null, null, null, null, null, null, '1', null, '2015-12-04 15:39:02', '0', '0', 'product:ticketvarie#2,product:ticketvarie#1', null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936482', null, '123456', '13bbf54a6850c393fb8d1b2b3bba997b', null, '1', '13545612301', '028-21364567', null, null, null, null, '1', null, null, null, null, null, null, '大众点评有限公司', null, null, null, null, '北京市', '东城区', null, '没什么事吧', null, null, null, null, 'qq@qq.com', null, '123456789012345678901234567890', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '4', null, null, '2015-12-04 16:34:24', null, null, null, null, '1', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936483', null, '18620508066', 'e10adc3949ba59abbe56e057f20f883e', null, '', '18620508066', '028-27035093', null, null, null, null, '1', null, null, null, null, null, null, '龙门客栈', null, null, null, null, '四川省', '成都市', '锦江区', '王二麻子', null, '110902199910090000', null, null, '11@163.com', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '大业路20号', null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-12-04 17:03:54', null, null, null, null, '1', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936484', null, '123', '202cb962ac59075b964b07152d234b70', null, '6', null, '123', '123', '123', null, null, '1', '2015-12-04 16:11:58', null, null, null, null, null, '123', '1', null, null, null, null, null, null, null, null, null, null, null, null, '123', null, null, null, null, '123', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '123', null, null, null, null, null, null, null, null, null, '1', null, '2015-12-04 16:10:49', '0', '0', 'product:ticketvarie#1', null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936485', null, '12345667', 'e10adc3949ba59abbe56e057f20f883e', null, '6', null, '52435324', '5423543', '5435432', null, null, '1', '2015-12-04 16:12:11', null, null, null, null, null, '主部门', '3', null, null, null, null, null, null, null, null, null, null, null, null, '3213432', null, null, null, null, '5423532', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 'zbm', null, null, null, null, null, null, null, null, null, '1', null, '2015-12-04 16:10:59', '0', '0', 'product:ticketvarie#1,product:ticketvarie#2', null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936486', null, '18620508066', 'e10adc3949ba59abbe56e057f20f883e', null, '', '18620508066', null, null, null, null, null, '1', null, null, null, null, null, null, '18620508066', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-12-04 16:37:58', null, null, null, null, '2', 'ffffffffffffffffffff ', null, null);
INSERT INTO `sys_user` VALUES ('2215520224936487', null, '12543543', 'e10adc3949ba59abbe56e057f20f883e', null, '6', null, '241312', '432432', '432', null, null, '1', '2015-12-04 16:13:08', null, null, null, null, null, '不远万里', '4', null, null, null, null, null, null, null, null, null, null, null, null, '134324', null, null, null, null, '432', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 'bywl', null, null, null, null, null, null, null, null, null, '1', null, '2015-12-04 16:11:56', '0', '0', 'product:ticketvarie#2,product:ticketvarie#1', null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936488', null, '123123', '4297f44b13955235245b2497399d7a93', null, '6', null, '123123', '12312', '1231231231@qq.com', null, null, '1', '2015-12-04 16:18:25', null, null, null, null, null, '123123', '2', null, null, null, null, null, null, null, null, null, null, null, null, '123132', null, null, null, null, '123123', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '123123', null, null, null, null, null, null, null, null, null, '1', '1', '2015-12-04 16:20:45', '0', '0', 'product:ticketvarie#2,product:ticketvarie#1,product:ticketType#7,product:ticketType#6,product:ticketType#4,product:ticketType#13', null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936494', null, 'qwe', '76d80224611fc919a5d54f0ff9fba446', null, '6', null, 'qe', 'qe', 'qew', null, null, '1', '2015-12-04 16:21:05', null, null, null, null, null, 'qwe', '4', null, null, null, null, null, null, null, null, null, null, null, null, 'qe', null, null, null, null, 'qe', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 'qwe', null, null, null, null, null, null, null, null, null, '1', null, '2015-12-04 16:19:56', '0', '0', 'product:ticketvarie#1,product:ticketvarie#2', null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936495', null, 'qwe', '76d80224611fc919a5d54f0ff9fba446', null, '6', null, 'qew', 'qwe', 'qwe', null, null, '1', '2015-12-04 16:21:37', null, null, null, null, null, 'qweqwe', '10', null, null, null, null, null, null, null, null, null, null, null, null, 'qwe', null, null, null, null, 'qwe', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 'qwe', null, null, null, null, null, null, null, null, null, '1', null, '2015-12-04 16:20:28', '0', '0', 'product:ticketvarie#1,product:ticketvarie#2', null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936496', null, 'qwe', '76d80224611fc919a5d54f0ff9fba446', null, '6', null, 'qwe', 'qwe', null, null, null, '1', '2015-12-04 16:22:09', null, null, null, null, null, 'qwe', '5', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 'qwe', null, null, null, null, null, null, null, null, null, '1', null, '2015-12-04 16:21:00', '0', '0', 'product:ticketType#5,product:ticketType#8,product:ticketType#7', null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936497', null, '18620508066', 'e10adc3949ba59abbe56e057f20f883e', null, '1', '18620508066', null, null, null, null, null, '1', null, null, null, null, null, null, '18620508066', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-12-04 18:00:59', null, null, null, null, '2', '该页面用以用户注册新账户\r\n需要输入字段：\r\n1、手机号（正确的11位手机号）\r\n2、验证码（等待系统向用户发送刚才填入的手机发送验证码，点击获取验证码后，用户需等待60s才能再次点击获取）\r\n3、密码（新密码，8~16位，数字、字母任意组合，不区分大小写）不区分大小写）不区分大小写）\r\n不区分大小写）', null, null);
INSERT INTO `sys_user` VALUES ('2215520224936498', null, '18620508066', 'e10adc3949ba59abbe56e057f20f883e', null, '', '18620508066', '028-27035093', null, null, null, null, '1', null, null, null, null, null, null, '所得到的', null, null, null, null, '北京市', '东城区', null, '顶顶顶顶', null, '110902199910090000', null, null, '11@163.com', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '333333333', null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-12-04 16:52:31', null, null, null, null, '1', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936499', null, '我是新管理人我是新管理人我是新管理人我是新管理人我是新管理人', 'e10adc3949ba59abbe56e057f20f883e', null, '1', '13564789522', '010-14789123', null, null, null, null, '1', null, null, null, null, null, null, '可可可可公司', null, null, null, null, '北京市', '东城区', null, '张先生', null, null, null, null, '789@qq.com', null, '1008611', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '4', null, null, '2015-12-04 17:11:53', null, null, null, null, '1', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936500', null, 'yangfa001', 'e10adc3949ba59abbe56e057f20f883e', null, '6', '18501378230', null, null, '打开', null, null, '1', '2015-12-04 16:38:22', null, null, null, null, null, '杨发', '4', null, null, null, null, null, null, null, null, '530427198905120018', null, null, null, 'D-9999-888888', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', null, '2015-12-04 16:37:13', '0', '0', 'product:ticketvarie#2,product:ticketvarie#1', null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936501', null, '13514566222', '1bbd886460827015e5d605ed44252251', null, '', '13514566222', '028-22521222', null, null, null, null, '1', null, null, null, null, null, null, '报损客栈', null, null, null, null, '北京市', '东城区', null, '报损', null, '101111198910251111', null, null, '45@qq.com', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '个发广告', null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-12-04 18:05:43', null, null, null, null, '2', '该页面d!@@', null, null);
INSERT INTO `sys_user` VALUES ('2215520224936502', null, '15756229350', 'e10adc3949ba59abbe56e057f20f883e', null, '1', '15756229350', null, null, null, null, null, '1', null, null, null, null, null, null, '15756229350', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-12-04 16:49:54', null, null, null, null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936503', null, '15756229350', 'e10adc3949ba59abbe56e057f20f883e', null, '1', '15756229350', null, null, null, null, null, '1', null, null, null, null, null, null, '15756229350', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-12-04 17:57:21', null, null, null, null, '2', '该页面用以用户注册新账户\r\n需要输入字段：\r\n1、手机号（正确的11位手机号）\r\n2、验证码（等待系统向用户发送刚才填入的手机发送验证码，点击获取验证码后，用户需等待60s才能再次点击获取）\r\n3、密码（新密码，8~16位，数字、字母任意组合，不区分大小写）大小写）大小写）大小写）', null, null);
INSERT INTO `sys_user` VALUES ('2215520224936505', null, '18620508065', 'e10adc3949ba59abbe56e057f20f883e', null, '', '18620508065', '028-27035093', null, null, null, null, '1', null, null, null, null, null, null, '张家界客栈', null, null, null, null, '四川省', '成都市', '锦江区', '李国民', null, '110902199910090000', null, null, '11@163.com', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '大业路20号', null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-12-04 17:14:27', null, null, null, null, '1', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936507', null, '123', '96e79218965eb72c92a549dd5a330112', null, '1', null, null, null, null, null, null, '2', null, null, null, null, null, null, '张和好', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '2', null, null, '2015-12-04 17:53:38', null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936508', null, 'test_nn', '1e7baeef956f0dfe96014bd18f07e50a', '1', '一般用户', '12222222222', '12222222222', '22222', 'test@mytour.com', '2015-12-04 17:26:24', null, '1', '2015-12-04 17:26:24', null, null, null, null, null, '再顺便说一句', null, null, null, null, '河北省', 'beijing', 'beijing', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '2015-12-04 17:21:55', '1', '1', null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936510', null, '说得对', 'e10adc3949ba59abbe56e057f20f883e', null, '1', '13654875522', '010-2134567', null, null, null, null, '1', null, null, null, null, null, null, '可可可可公司', null, null, null, null, '北京市', '东城区', null, '得得得', null, null, null, null, 'zzz@sina.com', null, '123456', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '4', null, null, '2015-12-04 18:07:01', null, null, null, null, '1', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936511', null, 'wk', 'c4ca4238a0b923820dcc509a6f75849b', null, '6', null, '18301282102', '1', '1', null, null, '1', '2015-12-04 17:28:20', null, null, null, null, null, '测试0011234', '6', null, null, null, null, null, null, null, null, null, null, null, null, 'cs', null, null, null, null, '1212131313', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 'cs', null, null, null, null, null, null, null, null, null, '1', '1', '2015-12-06 12:59:15', '0', '0', 'product:ticketvarie#2,product:ticketvarie#1', null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936512', null, '18620508064', 'e10adc3949ba59abbe56e057f20f883e', null, '5', '18620508064', '028-27035093', null, null, null, null, '1', null, null, null, null, null, null, '祥云客栈', null, null, null, null, '四川省', '成都市', '锦江区', '李国强', null, '110902199910090000', null, null, '11@163.com', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '大业路100号', null, null, null, null, null, null, null, null, null, null, null, '3', null, null, '2015-12-04 17:48:35', null, null, null, null, '1', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936513', null, 'zhangsan', 'e10adc3949ba59abbe56e057f20f883e', null, '4', '13522071740', null, null, null, null, null, '1', '2015-12-04 17:50:16', null, null, null, null, null, '张三', null, null, null, null, null, null, null, null, null, '110101199712019657', null, null, null, '1101011', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', '1', '2015-12-05 11:39:54', '0', '0', 'product:ticketvarie#2,product:ticketvarie#1', null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936514', null, '131', '96e79218965eb72c92a549dd5a330112', null, '1', null, null, null, null, null, null, '1', null, null, null, null, null, null, '哈哈哈', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '2', null, null, '2015-12-04 17:49:09', null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936515', null, 'supportAdmin', 'e10adc3949ba59abbe56e057f20f883e', null, '1', null, null, null, null, null, null, '1', null, null, null, '1', null, null, 'supportAdmin', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', null, null, '2015-12-04 18:24:44', null, null, null, null, '1', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936516', null, 'zhangsan', 'e10adc3949ba59abbe56e057f20f883e', null, '7', null, '13244444444', null, null, null, null, null, null, null, null, '1', null, null, '张三', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', '1', '2015-12-04 22:10:31', null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936517', null, 'zxp123', 'e10adc3949ba59abbe56e057f20f883e', null, '6', null, '15987854595', '123123', '74331333@qq.com', '2015-12-07 09:30:53', '218.241.163.2', '1', '2015-12-05 11:52:01', null, null, null, null, null, 'zxp旅行社分销商测试', '2', null, null, null, null, null, null, null, null, null, null, null, null, '123456', null, null, null, null, '123123', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 'zxpzxp', null, null, null, null, null, null, null, null, null, '1', '1', '2015-12-06 20:22:06', '0', '0', 'product:ticketvarie#1,product:ticketvarie#2', null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936518', null, 'zxp111', 'e10adc3949ba59abbe56e057f20f883e', null, '7', null, '13545782545', null, null, null, null, '1', null, null, null, '1', null, null, '和济南', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', '1', '2015-12-07 09:47:17', null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936519', null, 'ross', 'e10adc3949ba59abbe56e057f20f883e', null, '6', '15652313192', null, null, null, null, null, '1', '2015-12-05 16:20:41', null, null, null, null, null, 'ross', '4', null, null, null, null, null, null, null, null, '513701199001243812', null, null, null, '6665548884557', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '2015-12-05 16:19:29', '0', '0', 'product:ticketvarie#1,product:ticketvarie#2', null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936520', null, 'zxp123456', 'e10adc3949ba59abbe56e057f20f883e', null, '6', '13244405080', null, null, '578992179@qq.com', null, null, '1', '2015-12-05 17:18:48', null, null, null, null, null, '张测试导游', '4', null, null, null, null, null, null, null, null, '220621199212041119', null, null, null, '21312342', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '2015-12-05 17:17:33', '0', '0', 'product:ticketvarie#1,product:ticketvarie#2', null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936521', null, '123', '202cb962ac59075b964b07152d234b70', null, '6', null, '123', '123', '123', null, null, '1', '2015-12-05 17:28:21', null, null, null, null, null, '123', '4', null, null, null, null, null, null, null, null, null, null, null, null, '123', null, null, null, null, '123', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '123', null, null, null, null, null, null, null, null, null, '1', '1', '2015-12-06 12:55:37', '0', '0', 'product:ticketvarie#1,product:ticketvarie#2', null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936522', null, '13739022421', 'b881c505ef54cac59dfdf61538693bd3', null, '4', '13739022421', null, null, '', null, null, '1', null, null, '2215520224935943', null, null, null, '付定军', null, null, null, null, null, null, null, '', '1', '43312319751011031X', '13739022421', null, '', '13739022421', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '2015-12-05 17:31:32', null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936523', null, 'abc', 'e99a18c428cb38d5f260853678922e03', '1', '一般用户', null, null, null, null, null, null, '1', null, null, null, null, null, null, '洲际导弹', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '2015-12-05 17:50:18', '1', '1', null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936524', null, 'abc', 'e99a18c428cb38d5f260853678922e03', '1', '一般用户', null, null, null, null, null, null, '1', null, null, null, null, null, null, '洲际导弹', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '2015-12-05 17:50:18', '1', '1', null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936525', null, '15711021375', 'e807f1fcf82d132f9bb018ca6738a19f', null, '5', '15711021375', null, null, '', null, null, '1', null, null, '2215520224935943', null, null, null, 'shixhe', null, null, null, null, null, null, null, 'shixhe', '1', '130133199012010998', '15711021375', null, '', null, null, null, null, null, 'dghjkkk', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '2015-12-06 15:27:02', null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936527', null, '123', '202cb962ac59075b964b07152d234b70', null, '6', null, '123', '123', '123', null, null, '1', '2015-12-06 16:02:38', null, null, null, null, null, '123', '6', null, null, null, null, null, null, null, null, null, null, null, null, '123', null, null, null, null, '123', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '123', null, null, null, null, null, null, null, null, null, '1', null, '2015-12-06 16:01:15', '0', '0', 'product:ticketvarie#1,product:ticketvarie#2', null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936528', null, 'supplyAdmin', 'e10adc3949ba59abbe56e057f20f883e', null, '1', null, null, null, null, null, null, '1', null, null, null, null, null, null, 'supplyAdmin', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '2', null, null, '2015-12-06 16:30:18', null, null, null, null, '1', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936529', null, '13739022422', 'c4ca4238a0b923820dcc509a6f75849b', null, '4', '13739022422', null, null, '', null, null, '1', null, null, '2215520224935943', null, null, null, '付定军', null, null, null, null, null, null, null, '', '1', '43312319751011031X', '13739022422', null, '', '13739022421', null, null, null, null, '', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '2015-12-06 18:01:56', null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936530', null, '123', '202cb962ac59075b964b07152d234b70', null, '6', null, '123', '123', '123', null, null, '1', '2015-12-06 18:45:55', null, null, null, null, null, '123', '11', null, null, null, null, null, null, null, null, null, null, null, null, '123', null, null, null, null, '123', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '123', null, null, null, null, null, null, null, null, null, '1', null, '2015-12-06 18:44:42', '0', '0', 'product:ticketvarie#1,product:ticketType#12', null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936531', null, '123', '202cb962ac59075b964b07152d234b70', null, '6', null, '123', '123', '123', null, null, '1', '2015-12-06 18:45:57', null, null, null, null, null, '123', '11', null, null, null, null, null, null, null, null, null, null, null, null, '123', null, null, null, null, '123', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '123', null, null, null, null, null, null, null, null, null, '1', null, '2015-12-06 18:44:44', '0', '0', 'product:ticketvarie#1,product:ticketType#12', null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936532', null, '123', '202cb962ac59075b964b07152d234b70', null, '6', null, '123', '123', '123', null, null, '1', '2015-12-06 18:46:03', null, null, null, null, null, '123', '11', null, null, null, null, null, null, null, null, null, null, null, null, '123', null, null, null, null, '123', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '123', null, null, null, null, null, null, null, null, null, '1', null, '2015-12-06 18:44:50', '0', '0', 'product:ticketvarie#1,product:ticketType#12', null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936533', null, '123', '202cb962ac59075b964b07152d234b70', null, '6', null, '123', '123', '123', null, null, '1', '2015-12-06 20:05:39', null, null, null, null, null, '123', '2', null, null, null, null, null, null, null, null, null, null, null, null, '123', null, null, null, null, '123', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '123', null, null, null, null, null, null, null, null, null, '1', null, '2015-12-06 20:04:26', '0', '0', 'product:ticketvarie#1,product:ticketvarie#2', null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936534', null, '123', '202cb962ac59075b964b07152d234b70', null, '6', null, '123', '123', '123', null, null, '1', '2015-12-06 20:05:40', null, null, null, null, null, '123', '2', null, null, null, null, null, null, null, null, null, null, null, null, '123', null, null, null, null, '123', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '123', null, null, null, null, null, null, null, null, null, '1', null, '2015-12-06 20:04:27', '0', '0', 'product:ticketvarie#1,product:ticketvarie#2', null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936535', null, '123', '202cb962ac59075b964b07152d234b70', null, '6', null, '123', '123', '123', null, null, '1', '2015-12-06 20:05:40', null, null, null, null, null, '123', '2', null, null, null, null, null, null, null, null, null, null, null, null, '123', null, null, null, null, '123', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '123', null, null, null, null, null, null, null, null, null, '1', null, '2015-12-06 20:04:27', '0', '0', 'product:ticketvarie#1,product:ticketvarie#2', null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936536', null, '123', '202cb962ac59075b964b07152d234b70', null, '6', null, '123', '123', '123', null, null, '1', '2015-12-06 20:05:40', null, null, null, null, null, '123', '2', null, null, null, null, null, null, null, null, null, null, null, null, '123', null, null, null, null, '123', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '123', null, null, null, null, null, null, null, null, null, '1', null, '2015-12-06 20:04:27', '0', '0', 'product:ticketvarie#1,product:ticketvarie#2', null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936537', null, '123', '202cb962ac59075b964b07152d234b70', null, '6', '123', null, null, '123', null, null, '1', '2015-12-06 20:06:34', null, null, null, null, null, '123', '4', null, null, null, null, null, null, null, null, '123', null, null, null, '123', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', null, '2015-12-06 20:05:21', '0', '0', 'product:ticketvarie#1,product:ticketvarie#2', null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936538', null, 'zxp999', '74c43b7ec689955c9c1517294e92500f', null, '6', null, '123123', '123', '123', null, null, '1', '2015-12-06 20:08:51', null, null, null, null, null, '张翔鹏供应商', '5', null, null, null, null, null, null, null, null, null, null, null, null, 'qw123123', null, null, null, null, '123', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 'zxp000', null, null, null, null, null, null, null, null, null, '1', null, '2015-12-06 20:07:38', '0', '0', 'product:ticketvarie#1,product:ticketvarie#2', null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936539', null, '123', '202cb962ac59075b964b07152d234b70', null, '6', null, '123', '123', '123', null, null, '1', '2015-12-06 20:20:25', null, null, null, null, null, '123', '3', null, null, null, null, null, null, null, null, null, null, null, null, '123', null, null, null, null, '123', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '123', null, null, null, null, null, null, null, null, null, '1', null, '2015-12-06 20:19:12', '0', '0', 'product:ticketvarie#2,product:ticketvarie#1', null, '0', null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936540', null, 'zxp123456', 'e10adc3949ba59abbe56e057f20f883e', null, '7', null, '13545684587', null, null, null, null, '1', null, null, null, '1', null, null, '张翔鹏', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', '1', '2015-12-07 09:48:20', null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936541', null, 'grdzjyswfcpc', 'e99a18c428cb38d5f260853678922e03', null, '7', null, '18515122369', null, null, null, null, null, null, null, null, '1', null, null, '国人对转基因食物非常排斥', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', '1', '2015-12-07 10:19:30', null, null, null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936542', null, 'nn_10161400', '31fe46cd6403dcde6ff93c0d5c4e1b8f', '1', '一般用户', null, null, null, null, null, null, '1', '2015-12-07 10:30:09', null, null, null, null, null, '转基因水稻，转基因玉米', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '2015-12-07 10:25:33', '1', '1', null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936543', null, 'nn_10161400', '31fe46cd6403dcde6ff93c0d5c4e1b8f', '1', '一般用户', null, null, null, null, null, null, '1', '2015-12-07 10:37:25', null, null, null, null, null, '转基因水稻，转基因玉米', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '2015-12-07 10:41:17', '1', '1', null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936544', null, 'nn_10161400', '31fe46cd6403dcde6ff93c0d5c4e1b8f', '1', '一般用户', null, null, null, null, null, null, '1', '2015-12-07 10:48:23', null, null, null, null, null, '转基因水稻，转基因玉米', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '2015-12-07 10:43:54', '1', '1', null, null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('2215520224936545', null, 'nn_10161400', '31fe46cd6403dcde6ff93c0d5c4e1b8f', '1', '一般用户', null, null, null, null, null, null, '1', '2015-12-07 10:48:48', null, null, null, null, null, '转基因水稻，转基因玉米', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '2015-12-07 10:44:14', '1', '1', null, null, null, null, null, null);

-- ----------------------------
-- Table structure for `sys_user_menu`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_menu`;
CREATE TABLE `sys_user_menu` (
  `id` bigint(20) NOT NULL,
  `menu_id` varchar(64) NOT NULL,
  `user_id` varchar(64) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_menu
-- ----------------------------
INSERT INTO `sys_user_menu` VALUES ('0', '2215520224936862', '1');
INSERT INTO `sys_user_menu` VALUES ('2215520224935939', '2215520224935944', '308');
INSERT INTO `sys_user_menu` VALUES ('2215520224935940', '2215520224936813', '1');
INSERT INTO `sys_user_menu` VALUES ('2215520224935942', '2215520224936814', '1');
INSERT INTO `sys_user_menu` VALUES ('2215520224935943', '2215520224936815', '1');
INSERT INTO `sys_user_menu` VALUES ('2215520224936094', '2215520224936816', '1');
INSERT INTO `sys_user_menu` VALUES ('2215520224936095', '2215520224936817', '1');
INSERT INTO `sys_user_menu` VALUES ('2215520224936176', '2215520224936813', '2215520224936291');
INSERT INTO `sys_user_menu` VALUES ('2215520224936177', '2215520224936818', '2215520224936291');
INSERT INTO `sys_user_menu` VALUES ('2215520224936178', '2215520224936819', '2215520224936291');
INSERT INTO `sys_user_menu` VALUES ('2215520224936179', '2215520224936814', '2215520224936291');
INSERT INTO `sys_user_menu` VALUES ('2215520224936180', '2215520224936815', '2215520224936291');
INSERT INTO `sys_user_menu` VALUES ('2215520224936181', '2215520224936816', '2215520224936291');
INSERT INTO `sys_user_menu` VALUES ('2215520224936182', '2215520224936817', '2215520224936291');
INSERT INTO `sys_user_menu` VALUES ('2215520224936183', '2215520224936857', '2215520224936291');
INSERT INTO `sys_user_menu` VALUES ('2215520224936184', '2215520224936863', '2215520224936291');
INSERT INTO `sys_user_menu` VALUES ('2215520224936185', '2215520224936864', '2215520224936291');
INSERT INTO `sys_user_menu` VALUES ('2215520224936190', '2215520224936813', '2215520224936299');
INSERT INTO `sys_user_menu` VALUES ('2215520224936191', '2215520224936818', '2215520224936299');
INSERT INTO `sys_user_menu` VALUES ('2215520224936192', '2215520224936819', '2215520224936299');
INSERT INTO `sys_user_menu` VALUES ('2215520224936193', '2215520224936820', '2215520224936299');
INSERT INTO `sys_user_menu` VALUES ('2215520224936194', '2215520224936821', '2215520224936299');
INSERT INTO `sys_user_menu` VALUES ('2215520224936195', '2215520224936822', '2215520224936299');
INSERT INTO `sys_user_menu` VALUES ('2215520224936196', '2215520224936823', '2215520224936299');
INSERT INTO `sys_user_menu` VALUES ('2215520224936197', '2215520224936824', '2215520224936299');
INSERT INTO `sys_user_menu` VALUES ('2215520224936198', '2215520224936825', '2215520224936299');
INSERT INTO `sys_user_menu` VALUES ('2215520224936199', '2215520224936826', '2215520224936299');
INSERT INTO `sys_user_menu` VALUES ('2215520224936200', '2215520224936827', '2215520224936299');
INSERT INTO `sys_user_menu` VALUES ('2215520224936201', '2215520224936828', '2215520224936299');
INSERT INTO `sys_user_menu` VALUES ('2215520224936202', '2215520224936814', '2215520224936299');
INSERT INTO `sys_user_menu` VALUES ('2215520224936203', '2215520224936829', '2215520224936299');
INSERT INTO `sys_user_menu` VALUES ('2215520224936204', '2215520224936830', '2215520224936299');
INSERT INTO `sys_user_menu` VALUES ('2215520224936205', '2215520224936831', '2215520224936299');
INSERT INTO `sys_user_menu` VALUES ('2215520224936206', '2215520224936832', '2215520224936299');
INSERT INTO `sys_user_menu` VALUES ('2215520224936207', '2215520224936815', '2215520224936299');
INSERT INTO `sys_user_menu` VALUES ('2215520224936208', '2215520224936833', '2215520224936299');
INSERT INTO `sys_user_menu` VALUES ('2215520224936209', '2215520224936834', '2215520224936299');
INSERT INTO `sys_user_menu` VALUES ('2215520224936210', '2215520224936835', '2215520224936299');
INSERT INTO `sys_user_menu` VALUES ('2215520224936211', '2215520224936836', '2215520224936299');
INSERT INTO `sys_user_menu` VALUES ('2215520224936212', '2215520224936837', '2215520224936299');
INSERT INTO `sys_user_menu` VALUES ('2215520224936213', '2215520224936838', '2215520224936299');
INSERT INTO `sys_user_menu` VALUES ('2215520224936214', '2215520224936839', '2215520224936299');
INSERT INTO `sys_user_menu` VALUES ('2215520224936215', '2215520224936840', '2215520224936299');
INSERT INTO `sys_user_menu` VALUES ('2215520224936216', '2215520224936841', '2215520224936299');
INSERT INTO `sys_user_menu` VALUES ('2215520224936217', '2215520224936816', '2215520224936299');
INSERT INTO `sys_user_menu` VALUES ('2215520224936218', '2215520224936842', '2215520224936299');
INSERT INTO `sys_user_menu` VALUES ('2215520224936219', '2215520224936843', '2215520224936299');
INSERT INTO `sys_user_menu` VALUES ('2215520224936220', '2215520224936844', '2215520224936299');
INSERT INTO `sys_user_menu` VALUES ('2215520224936221', '2215520224936845', '2215520224936299');
INSERT INTO `sys_user_menu` VALUES ('2215520224936222', '2215520224936817', '2215520224936299');
INSERT INTO `sys_user_menu` VALUES ('2215520224936223', '2215520224936846', '2215520224936299');
INSERT INTO `sys_user_menu` VALUES ('2215520224936224', '2215520224936847', '2215520224936299');
INSERT INTO `sys_user_menu` VALUES ('2215520224936225', '2215520224936848', '2215520224936299');
INSERT INTO `sys_user_menu` VALUES ('2215520224936226', '2215520224936849', '2215520224936299');
INSERT INTO `sys_user_menu` VALUES ('2215520224936227', '2215520224936850', '2215520224936299');
INSERT INTO `sys_user_menu` VALUES ('2215520224936228', '2215520224936851', '2215520224936299');
INSERT INTO `sys_user_menu` VALUES ('2215520224936229', '2215520224936852', '2215520224936299');
INSERT INTO `sys_user_menu` VALUES ('2215520224936230', '2215520224936853', '2215520224936299');
INSERT INTO `sys_user_menu` VALUES ('2215520224936231', '2215520224936854', '2215520224936299');
INSERT INTO `sys_user_menu` VALUES ('2215520224936232', '2215520224936855', '2215520224936299');
INSERT INTO `sys_user_menu` VALUES ('2215520224936233', '2215520224936856', '2215520224936299');
INSERT INTO `sys_user_menu` VALUES ('2215520224936234', '2215520224936857', '2215520224936299');
INSERT INTO `sys_user_menu` VALUES ('2215520224936235', '2215520224936863', '2215520224936299');
INSERT INTO `sys_user_menu` VALUES ('2215520224936236', '2215520224936864', '2215520224936299');
INSERT INTO `sys_user_menu` VALUES ('2215520224936237', '2215520224936865', '2215520224936299');
INSERT INTO `sys_user_menu` VALUES ('2215520224936245', '2215520224936831', '1');
INSERT INTO `sys_user_menu` VALUES ('2215520224936246', '2215520224936832', '1');
INSERT INTO `sys_user_menu` VALUES ('2215520224936250', '2215520224936836', '1');
INSERT INTO `sys_user_menu` VALUES ('2215520224936251', '2215520224936837', '1');
INSERT INTO `sys_user_menu` VALUES ('2215520224936252', '2215520224936838', '1');
INSERT INTO `sys_user_menu` VALUES ('2215520224936259', '2215520224937123', '1');
INSERT INTO `sys_user_menu` VALUES ('2215520224936260', '2215520224937124', '1');
INSERT INTO `sys_user_menu` VALUES ('2215520224936346', '2215520224936813', '2215520224936277');
INSERT INTO `sys_user_menu` VALUES ('2215520224936347', '2215520224936814', '2215520224936277');
INSERT INTO `sys_user_menu` VALUES ('2215520224936348', '2215520224936815', '2215520224936277');
INSERT INTO `sys_user_menu` VALUES ('2215520224936349', '2215520224936816', '2215520224936277');
INSERT INTO `sys_user_menu` VALUES ('2215520224936354', '2215520224936817', '2215520224936277');
INSERT INTO `sys_user_menu` VALUES ('2215520224936410', '2215520224936813', '2215520224936360');
INSERT INTO `sys_user_menu` VALUES ('2215520224936411', '2215520224936818', '2215520224936360');
INSERT INTO `sys_user_menu` VALUES ('2215520224936412', '2215520224936819', '2215520224936360');
INSERT INTO `sys_user_menu` VALUES ('2215520224936413', '2215520224936820', '2215520224936360');
INSERT INTO `sys_user_menu` VALUES ('2215520224936414', '2215520224936821', '2215520224936360');
INSERT INTO `sys_user_menu` VALUES ('2215520224936415', '2215520224936822', '2215520224936360');
INSERT INTO `sys_user_menu` VALUES ('2215520224936416', '2215520224936823', '2215520224936360');
INSERT INTO `sys_user_menu` VALUES ('2215520224936417', '2215520224936824', '2215520224936360');
INSERT INTO `sys_user_menu` VALUES ('2215520224936418', '2215520224936825', '2215520224936360');
INSERT INTO `sys_user_menu` VALUES ('2215520224936419', '2215520224936826', '2215520224936360');
INSERT INTO `sys_user_menu` VALUES ('2215520224936420', '2215520224936827', '2215520224936360');
INSERT INTO `sys_user_menu` VALUES ('2215520224936421', '2215520224936828', '2215520224936360');
INSERT INTO `sys_user_menu` VALUES ('2215520224936422', '2215520224936814', '2215520224936360');
INSERT INTO `sys_user_menu` VALUES ('2215520224936423', '2215520224936829', '2215520224936360');
INSERT INTO `sys_user_menu` VALUES ('2215520224936424', '2215520224936830', '2215520224936360');
INSERT INTO `sys_user_menu` VALUES ('2215520224936425', '2215520224936831', '2215520224936360');
INSERT INTO `sys_user_menu` VALUES ('2215520224936426', '2215520224936832', '2215520224936360');
INSERT INTO `sys_user_menu` VALUES ('2215520224936427', '2215520224936815', '2215520224936360');
INSERT INTO `sys_user_menu` VALUES ('2215520224936428', '2215520224936833', '2215520224936360');
INSERT INTO `sys_user_menu` VALUES ('2215520224936429', '2215520224936834', '2215520224936360');
INSERT INTO `sys_user_menu` VALUES ('2215520224936430', '2215520224936835', '2215520224936360');
INSERT INTO `sys_user_menu` VALUES ('2215520224936431', '2215520224936836', '2215520224936360');
INSERT INTO `sys_user_menu` VALUES ('2215520224936432', '2215520224936837', '2215520224936360');
INSERT INTO `sys_user_menu` VALUES ('2215520224936433', '2215520224936838', '2215520224936360');
INSERT INTO `sys_user_menu` VALUES ('2215520224936434', '2215520224936839', '2215520224936360');
INSERT INTO `sys_user_menu` VALUES ('2215520224936435', '2215520224936840', '2215520224936360');
INSERT INTO `sys_user_menu` VALUES ('2215520224936436', '2215520224936841', '2215520224936360');
INSERT INTO `sys_user_menu` VALUES ('2215520224936437', '2215520224936816', '2215520224936360');
INSERT INTO `sys_user_menu` VALUES ('2215520224936438', '2215520224936842', '2215520224936360');
INSERT INTO `sys_user_menu` VALUES ('2215520224936439', '2215520224936843', '2215520224936360');
INSERT INTO `sys_user_menu` VALUES ('2215520224936440', '2215520224936862', '2215520224936360');
INSERT INTO `sys_user_menu` VALUES ('2215520224936441', '2215520224937123', '2215520224936360');
INSERT INTO `sys_user_menu` VALUES ('2215520224936442', '2215520224937124', '2215520224936360');
INSERT INTO `sys_user_menu` VALUES ('2215520224936443', '2215520224937179', '2215520224936360');
INSERT INTO `sys_user_menu` VALUES ('2215520224936444', '2215520224936817', '2215520224936360');
INSERT INTO `sys_user_menu` VALUES ('2215520224936445', '2215520224937125', '2215520224936360');
INSERT INTO `sys_user_menu` VALUES ('2215520224936446', '2215520224937126', '2215520224936360');
INSERT INTO `sys_user_menu` VALUES ('2215520224936447', '2215520224937127', '2215520224936360');
INSERT INTO `sys_user_menu` VALUES ('2215520224936448', '2215520224937128', '2215520224936360');
INSERT INTO `sys_user_menu` VALUES ('2215520224936449', '2215520224937154', '2215520224936360');
INSERT INTO `sys_user_menu` VALUES ('2215520224936450', '2215520224937155', '2215520224936360');
INSERT INTO `sys_user_menu` VALUES ('2215520224936451', '2215520224937156', '2215520224936360');
INSERT INTO `sys_user_menu` VALUES ('2215520224936452', '2215520224937157', '2215520224936360');
INSERT INTO `sys_user_menu` VALUES ('2215520224936453', '2215520224937158', '2215520224936360');
INSERT INTO `sys_user_menu` VALUES ('2215520224936454', '2215520224937159', '2215520224936360');
INSERT INTO `sys_user_menu` VALUES ('2215520224936455', '2215520224937160', '2215520224936360');
INSERT INTO `sys_user_menu` VALUES ('2215520224936456', '2215520224936813', '2215520224936364');
INSERT INTO `sys_user_menu` VALUES ('2215520224936457', '2215520224936818', '2215520224936364');
INSERT INTO `sys_user_menu` VALUES ('2215520224936458', '2215520224936819', '2215520224936364');
INSERT INTO `sys_user_menu` VALUES ('2215520224936459', '2215520224936820', '2215520224936364');
INSERT INTO `sys_user_menu` VALUES ('2215520224936460', '2215520224936821', '2215520224936364');
INSERT INTO `sys_user_menu` VALUES ('2215520224936461', '2215520224936822', '2215520224936364');
INSERT INTO `sys_user_menu` VALUES ('2215520224936462', '2215520224936823', '2215520224936364');
INSERT INTO `sys_user_menu` VALUES ('2215520224936463', '2215520224936824', '2215520224936364');
INSERT INTO `sys_user_menu` VALUES ('2215520224936464', '2215520224936825', '2215520224936364');
INSERT INTO `sys_user_menu` VALUES ('2215520224936465', '2215520224936826', '2215520224936364');
INSERT INTO `sys_user_menu` VALUES ('2215520224936466', '2215520224936827', '2215520224936364');
INSERT INTO `sys_user_menu` VALUES ('2215520224936467', '2215520224936828', '2215520224936364');
INSERT INTO `sys_user_menu` VALUES ('2215520224936468', '2215520224936814', '2215520224936364');
INSERT INTO `sys_user_menu` VALUES ('2215520224936469', '2215520224936829', '2215520224936364');
INSERT INTO `sys_user_menu` VALUES ('2215520224936470', '2215520224936830', '2215520224936364');
INSERT INTO `sys_user_menu` VALUES ('2215520224936471', '2215520224936831', '2215520224936364');
INSERT INTO `sys_user_menu` VALUES ('2215520224936472', '2215520224936832', '2215520224936364');
INSERT INTO `sys_user_menu` VALUES ('2215520224936473', '2215520224936815', '2215520224936364');
INSERT INTO `sys_user_menu` VALUES ('2215520224936474', '2215520224936833', '2215520224936364');
INSERT INTO `sys_user_menu` VALUES ('2215520224936475', '2215520224936834', '2215520224936364');
INSERT INTO `sys_user_menu` VALUES ('2215520224936476', '2215520224936835', '2215520224936364');
INSERT INTO `sys_user_menu` VALUES ('2215520224936477', '2215520224936836', '2215520224936364');
INSERT INTO `sys_user_menu` VALUES ('2215520224936478', '2215520224936837', '2215520224936364');
INSERT INTO `sys_user_menu` VALUES ('2215520224936479', '2215520224936838', '2215520224936364');
INSERT INTO `sys_user_menu` VALUES ('2215520224936480', '2215520224936839', '2215520224936364');
INSERT INTO `sys_user_menu` VALUES ('2215520224936481', '2215520224936840', '2215520224936364');
INSERT INTO `sys_user_menu` VALUES ('2215520224936482', '2215520224936841', '2215520224936364');
INSERT INTO `sys_user_menu` VALUES ('2215520224936483', '2215520224936816', '2215520224936364');
INSERT INTO `sys_user_menu` VALUES ('2215520224936484', '2215520224936842', '2215520224936364');
INSERT INTO `sys_user_menu` VALUES ('2215520224936485', '2215520224936843', '2215520224936364');
INSERT INTO `sys_user_menu` VALUES ('2215520224936486', '2215520224936862', '2215520224936364');
INSERT INTO `sys_user_menu` VALUES ('2215520224936487', '2215520224937123', '2215520224936364');
INSERT INTO `sys_user_menu` VALUES ('2215520224936488', '2215520224937124', '2215520224936364');
INSERT INTO `sys_user_menu` VALUES ('2215520224936489', '2215520224937179', '2215520224936364');
INSERT INTO `sys_user_menu` VALUES ('2215520224936490', '2215520224936817', '2215520224936364');
INSERT INTO `sys_user_menu` VALUES ('2215520224936491', '2215520224937125', '2215520224936364');
INSERT INTO `sys_user_menu` VALUES ('2215520224936492', '2215520224937126', '2215520224936364');
INSERT INTO `sys_user_menu` VALUES ('2215520224936493', '2215520224937127', '2215520224936364');
INSERT INTO `sys_user_menu` VALUES ('2215520224936494', '2215520224937128', '2215520224936364');
INSERT INTO `sys_user_menu` VALUES ('2215520224936495', '2215520224937154', '2215520224936364');
INSERT INTO `sys_user_menu` VALUES ('2215520224936496', '2215520224937155', '2215520224936364');
INSERT INTO `sys_user_menu` VALUES ('2215520224936497', '2215520224937156', '2215520224936364');
INSERT INTO `sys_user_menu` VALUES ('2215520224936498', '2215520224937157', '2215520224936364');
INSERT INTO `sys_user_menu` VALUES ('2215520224936499', '2215520224937158', '2215520224936364');
INSERT INTO `sys_user_menu` VALUES ('2215520224936500', '2215520224937159', '2215520224936364');
INSERT INTO `sys_user_menu` VALUES ('2215520224936501', '2215520224937160', '2215520224936364');
INSERT INTO `sys_user_menu` VALUES ('2215520224936502', '2215520224936813', '2215520224936367');
INSERT INTO `sys_user_menu` VALUES ('2215520224936514', '2215520224936814', '2215520224936367');
INSERT INTO `sys_user_menu` VALUES ('2215520224936519', '2215520224936815', '2215520224936367');
INSERT INTO `sys_user_menu` VALUES ('2215520224936529', '2215520224936816', '2215520224936367');
INSERT INTO `sys_user_menu` VALUES ('2215520224936536', '2215520224936817', '2215520224936367');
INSERT INTO `sys_user_menu` VALUES ('2215520224936564', '2215520224936820', '2215520224936277');
INSERT INTO `sys_user_menu` VALUES ('2215520224936565', '2215520224936826', '2215520224936277');
INSERT INTO `sys_user_menu` VALUES ('2215520224936590', '2215520224937189', '2215520224936396');
INSERT INTO `sys_user_menu` VALUES ('2215520224936591', '2215520224937190', '2215520224936396');
INSERT INTO `sys_user_menu` VALUES ('2215520224936592', '2215520224937191', '2215520224936396');
INSERT INTO `sys_user_menu` VALUES ('2215520224936593', '2215520224937192', '2215520224936396');
INSERT INTO `sys_user_menu` VALUES ('2215520224936594', '2215520224937193', '2215520224936396');
INSERT INTO `sys_user_menu` VALUES ('2215520224936595', '2215520224937194', '2215520224936396');
INSERT INTO `sys_user_menu` VALUES ('2215520224936596', '2215520224937195', '2215520224936396');
INSERT INTO `sys_user_menu` VALUES ('2215520224936597', '2215520224937196', '2215520224936396');
INSERT INTO `sys_user_menu` VALUES ('2215520224936622', '2215520224937205', '2215520224936420');
INSERT INTO `sys_user_menu` VALUES ('2215520224936623', '2215520224937206', '2215520224936420');
INSERT INTO `sys_user_menu` VALUES ('2215520224936624', '2215520224937207', '2215520224936420');
INSERT INTO `sys_user_menu` VALUES ('2215520224936625', '2215520224937208', '2215520224936420');
INSERT INTO `sys_user_menu` VALUES ('2215520224936626', '2215520224937209', '2215520224936420');
INSERT INTO `sys_user_menu` VALUES ('2215520224936627', '2215520224937210', '2215520224936420');
INSERT INTO `sys_user_menu` VALUES ('2215520224936628', '2215520224937211', '2215520224936420');
INSERT INTO `sys_user_menu` VALUES ('2215520224936629', '2215520224937212', '2215520224936420');
INSERT INTO `sys_user_menu` VALUES ('2215520224936630', '2215520224936813', '2215520224936349');
INSERT INTO `sys_user_menu` VALUES ('2215520224936642', '2215520224936814', '2215520224936349');
INSERT INTO `sys_user_menu` VALUES ('2215520224936647', '2215520224936815', '2215520224936349');
INSERT INTO `sys_user_menu` VALUES ('2215520224936658', '2215520224936816', '2215520224936349');
INSERT INTO `sys_user_menu` VALUES ('2215520224936664', '2215520224936817', '2215520224936349');
INSERT INTO `sys_user_menu` VALUES ('2215520224936676', '2215520224937213', '2215520224936421');
INSERT INTO `sys_user_menu` VALUES ('2215520224936677', '2215520224937214', '2215520224936421');
INSERT INTO `sys_user_menu` VALUES ('2215520224936678', '2215520224937215', '2215520224936421');
INSERT INTO `sys_user_menu` VALUES ('2215520224936679', '2215520224937216', '2215520224936421');
INSERT INTO `sys_user_menu` VALUES ('2215520224936680', '2215520224937217', '2215520224936421');
INSERT INTO `sys_user_menu` VALUES ('2215520224936681', '2215520224937218', '2215520224936421');
INSERT INTO `sys_user_menu` VALUES ('2215520224936682', '2215520224937219', '2215520224936421');
INSERT INTO `sys_user_menu` VALUES ('2215520224936683', '2215520224937220', '2215520224936421');
INSERT INTO `sys_user_menu` VALUES ('2215520224936686', '2215520224937221', '2215520224936422');
INSERT INTO `sys_user_menu` VALUES ('2215520224936687', '2215520224937222', '2215520224936422');
INSERT INTO `sys_user_menu` VALUES ('2215520224936688', '2215520224937223', '2215520224936422');
INSERT INTO `sys_user_menu` VALUES ('2215520224936689', '2215520224937224', '2215520224936422');
INSERT INTO `sys_user_menu` VALUES ('2215520224936690', '2215520224937225', '2215520224936422');
INSERT INTO `sys_user_menu` VALUES ('2215520224936691', '2215520224937226', '2215520224936422');
INSERT INTO `sys_user_menu` VALUES ('2215520224936692', '2215520224937227', '2215520224936422');
INSERT INTO `sys_user_menu` VALUES ('2215520224936693', '2215520224937228', '2215520224936422');
INSERT INTO `sys_user_menu` VALUES ('2215520224936694', '2215520224937229', '2215520224936423');
INSERT INTO `sys_user_menu` VALUES ('2215520224936695', '2215520224937230', '2215520224936423');
INSERT INTO `sys_user_menu` VALUES ('2215520224936696', '2215520224937231', '2215520224936423');
INSERT INTO `sys_user_menu` VALUES ('2215520224936697', '2215520224937232', '2215520224936423');
INSERT INTO `sys_user_menu` VALUES ('2215520224936698', '2215520224937233', '2215520224936423');
INSERT INTO `sys_user_menu` VALUES ('2215520224936699', '2215520224937234', '2215520224936423');
INSERT INTO `sys_user_menu` VALUES ('2215520224936700', '2215520224937235', '2215520224936423');
INSERT INTO `sys_user_menu` VALUES ('2215520224936701', '2215520224937236', '2215520224936423');
INSERT INTO `sys_user_menu` VALUES ('2215520224936702', '2215520224937237', '2215520224936424');
INSERT INTO `sys_user_menu` VALUES ('2215520224936703', '2215520224937238', '2215520224936424');
INSERT INTO `sys_user_menu` VALUES ('2215520224936704', '2215520224937239', '2215520224936424');
INSERT INTO `sys_user_menu` VALUES ('2215520224936705', '2215520224937240', '2215520224936424');
INSERT INTO `sys_user_menu` VALUES ('2215520224936706', '2215520224937241', '2215520224936424');
INSERT INTO `sys_user_menu` VALUES ('2215520224936707', '2215520224937242', '2215520224936424');
INSERT INTO `sys_user_menu` VALUES ('2215520224936708', '2215520224937243', '2215520224936424');
INSERT INTO `sys_user_menu` VALUES ('2215520224936709', '2215520224937244', '2215520224936424');
INSERT INTO `sys_user_menu` VALUES ('2215520224936710', '2215520224936813', '2215520224936426');
INSERT INTO `sys_user_menu` VALUES ('2215520224936711', '2215520224936818', '2215520224936426');
INSERT INTO `sys_user_menu` VALUES ('2215520224936712', '2215520224936819', '2215520224936426');
INSERT INTO `sys_user_menu` VALUES ('2215520224936713', '2215520224936820', '2215520224936426');
INSERT INTO `sys_user_menu` VALUES ('2215520224936714', '2215520224936821', '2215520224936426');
INSERT INTO `sys_user_menu` VALUES ('2215520224936715', '2215520224936822', '2215520224936426');
INSERT INTO `sys_user_menu` VALUES ('2215520224936716', '2215520224936823', '2215520224936426');
INSERT INTO `sys_user_menu` VALUES ('2215520224936717', '2215520224936824', '2215520224936426');
INSERT INTO `sys_user_menu` VALUES ('2215520224936718', '2215520224936825', '2215520224936426');
INSERT INTO `sys_user_menu` VALUES ('2215520224936719', '2215520224936826', '2215520224936426');
INSERT INTO `sys_user_menu` VALUES ('2215520224936720', '2215520224936827', '2215520224936426');
INSERT INTO `sys_user_menu` VALUES ('2215520224936721', '2215520224936828', '2215520224936426');
INSERT INTO `sys_user_menu` VALUES ('2215520224936722', '2215520224936814', '2215520224936426');
INSERT INTO `sys_user_menu` VALUES ('2215520224936723', '2215520224936829', '2215520224936426');
INSERT INTO `sys_user_menu` VALUES ('2215520224936724', '2215520224936830', '2215520224936426');
INSERT INTO `sys_user_menu` VALUES ('2215520224936725', '2215520224936831', '2215520224936426');
INSERT INTO `sys_user_menu` VALUES ('2215520224936726', '2215520224936832', '2215520224936426');
INSERT INTO `sys_user_menu` VALUES ('2215520224936727', '2215520224936815', '2215520224936426');
INSERT INTO `sys_user_menu` VALUES ('2215520224936728', '2215520224936833', '2215520224936426');
INSERT INTO `sys_user_menu` VALUES ('2215520224936729', '2215520224936834', '2215520224936426');
INSERT INTO `sys_user_menu` VALUES ('2215520224936730', '2215520224936835', '2215520224936426');
INSERT INTO `sys_user_menu` VALUES ('2215520224936731', '2215520224936836', '2215520224936426');
INSERT INTO `sys_user_menu` VALUES ('2215520224936732', '2215520224936837', '2215520224936426');
INSERT INTO `sys_user_menu` VALUES ('2215520224936733', '2215520224936838', '2215520224936426');
INSERT INTO `sys_user_menu` VALUES ('2215520224936734', '2215520224936839', '2215520224936426');
INSERT INTO `sys_user_menu` VALUES ('2215520224936735', '2215520224936840', '2215520224936426');
INSERT INTO `sys_user_menu` VALUES ('2215520224936736', '2215520224936841', '2215520224936426');
INSERT INTO `sys_user_menu` VALUES ('2215520224936737', '2215520224937188', '2215520224936426');
INSERT INTO `sys_user_menu` VALUES ('2215520224936738', '2215520224936816', '2215520224936426');
INSERT INTO `sys_user_menu` VALUES ('2215520224936739', '2215520224936842', '2215520224936426');
INSERT INTO `sys_user_menu` VALUES ('2215520224936740', '2215520224936843', '2215520224936426');
INSERT INTO `sys_user_menu` VALUES ('2215520224936741', '2215520224936862', '2215520224936426');
INSERT INTO `sys_user_menu` VALUES ('2215520224936742', '2215520224937123', '2215520224936426');
INSERT INTO `sys_user_menu` VALUES ('2215520224936743', '2215520224937124', '2215520224936426');
INSERT INTO `sys_user_menu` VALUES ('2215520224936744', '2215520224936817', '2215520224936426');
INSERT INTO `sys_user_menu` VALUES ('2215520224936745', '2215520224937125', '2215520224936426');
INSERT INTO `sys_user_menu` VALUES ('2215520224936746', '2215520224937126', '2215520224936426');
INSERT INTO `sys_user_menu` VALUES ('2215520224936747', '2215520224937127', '2215520224936426');
INSERT INTO `sys_user_menu` VALUES ('2215520224936748', '2215520224937128', '2215520224936426');
INSERT INTO `sys_user_menu` VALUES ('2215520224936749', '2215520224937154', '2215520224936426');
INSERT INTO `sys_user_menu` VALUES ('2215520224936750', '2215520224937155', '2215520224936426');
INSERT INTO `sys_user_menu` VALUES ('2215520224936751', '2215520224937156', '2215520224936426');
INSERT INTO `sys_user_menu` VALUES ('2215520224936752', '2215520224937157', '2215520224936426');
INSERT INTO `sys_user_menu` VALUES ('2215520224936753', '2215520224937158', '2215520224936426');
INSERT INTO `sys_user_menu` VALUES ('2215520224936754', '2215520224937159', '2215520224936426');
INSERT INTO `sys_user_menu` VALUES ('2215520224936755', '2215520224937160', '2215520224936426');
INSERT INTO `sys_user_menu` VALUES ('2215520224936756', '2215520224937179', '2215520224936426');
INSERT INTO `sys_user_menu` VALUES ('2215520224936760', '2215520224936813', '2215520224936431');
INSERT INTO `sys_user_menu` VALUES ('2215520224936762', '2215520224936814', '2215520224936431');
INSERT INTO `sys_user_menu` VALUES ('2215520224936764', '2215520224936815', '2215520224936431');
INSERT INTO `sys_user_menu` VALUES ('2215520224936765', '2215520224936816', '2215520224936431');
INSERT INTO `sys_user_menu` VALUES ('2215520224936766', '2215520224936817', '2215520224936431');
INSERT INTO `sys_user_menu` VALUES ('2215520224936779', '2215520224936813', '2215520224936432');
INSERT INTO `sys_user_menu` VALUES ('2215520224936791', '2215520224936814', '2215520224936432');
INSERT INTO `sys_user_menu` VALUES ('2215520224936796', '2215520224936815', '2215520224936432');
INSERT INTO `sys_user_menu` VALUES ('2215520224936807', '2215520224936816', '2215520224936432');
INSERT INTO `sys_user_menu` VALUES ('2215520224936813', '2215520224936817', '2215520224936432');
INSERT INTO `sys_user_menu` VALUES ('2215520224936873', '2215520224936866', '1');
INSERT INTO `sys_user_menu` VALUES ('2215520224936920', '2215520224936813', '2215520224936440');
INSERT INTO `sys_user_menu` VALUES ('2215520224936932', '2215520224936866', '2215520224936440');
INSERT INTO `sys_user_menu` VALUES ('2215520224936933', '2215520224936814', '2215520224936440');
INSERT INTO `sys_user_menu` VALUES ('2215520224936938', '2215520224936815', '2215520224936440');
INSERT INTO `sys_user_menu` VALUES ('2215520224936949', '2215520224936816', '2215520224936440');
INSERT INTO `sys_user_menu` VALUES ('2215520224936955', '2215520224936817', '2215520224936440');
INSERT INTO `sys_user_menu` VALUES ('2215520224937243', '2215520224937246', '2215520224936452');
INSERT INTO `sys_user_menu` VALUES ('2215520224937244', '1', '2215520224936440');
INSERT INTO `sys_user_menu` VALUES ('2215520224937245', '2215520224937245', '2215520224936440');
INSERT INTO `sys_user_menu` VALUES ('2215520224937264', '2215520224936813', '2215520224936433');
INSERT INTO `sys_user_menu` VALUES ('2215520224937265', '2215520224936814', '2215520224936433');
INSERT INTO `sys_user_menu` VALUES ('2215520224937266', '2215520224936829', '2215520224936433');
INSERT INTO `sys_user_menu` VALUES ('2215520224937267', '2215520224936830', '2215520224936433');
INSERT INTO `sys_user_menu` VALUES ('2215520224937268', '2215520224936831', '2215520224936433');
INSERT INTO `sys_user_menu` VALUES ('2215520224937269', '2215520224936832', '2215520224936433');
INSERT INTO `sys_user_menu` VALUES ('2215520224937270', '2215520224936815', '2215520224936433');
INSERT INTO `sys_user_menu` VALUES ('2215520224937271', '2215520224936816', '2215520224936433');
INSERT INTO `sys_user_menu` VALUES ('2215520224937272', '2215520224936817', '2215520224936433');
INSERT INTO `sys_user_menu` VALUES ('2215520224937282', '2215520224936813', '2215520224936442');
INSERT INTO `sys_user_menu` VALUES ('2215520224937283', '2215520224936814', '2215520224936442');
INSERT INTO `sys_user_menu` VALUES ('2215520224937286', '2215520224936815', '2215520224936442');
INSERT INTO `sys_user_menu` VALUES ('2215520224937287', '2215520224936816', '2215520224936442');
INSERT INTO `sys_user_menu` VALUES ('2215520224937288', '2215520224936817', '2215520224936442');
INSERT INTO `sys_user_menu` VALUES ('2215520224937291', '2215520224936829', '2215520224936442');
INSERT INTO `sys_user_menu` VALUES ('2215520224937292', '2215520224936830', '2215520224936442');
INSERT INTO `sys_user_menu` VALUES ('2215520224937293', '2215520224936831', '2215520224936442');
INSERT INTO `sys_user_menu` VALUES ('2215520224937294', '2215520224936832', '2215520224936442');
INSERT INTO `sys_user_menu` VALUES ('2215520224937295', '2215520224937247', '2215520224936463');
INSERT INTO `sys_user_menu` VALUES ('2215520224937296', '2215520224937248', '2215520224936463');
INSERT INTO `sys_user_menu` VALUES ('2215520224937297', '2215520224937249', '2215520224936463');
INSERT INTO `sys_user_menu` VALUES ('2215520224937298', '2215520224937250', '2215520224936463');
INSERT INTO `sys_user_menu` VALUES ('2215520224937299', '2215520224937251', '2215520224936463');
INSERT INTO `sys_user_menu` VALUES ('2215520224937300', '2215520224937252', '2215520224936463');
INSERT INTO `sys_user_menu` VALUES ('2215520224937301', '2215520224937253', '2215520224936463');
INSERT INTO `sys_user_menu` VALUES ('2215520224937302', '2215520224937254', '2215520224936463');
INSERT INTO `sys_user_menu` VALUES ('2215520224937303', '2215520224937255', '2215520224936463');
INSERT INTO `sys_user_menu` VALUES ('2215520224937304', '2215520224937256', '2215520224936464');
INSERT INTO `sys_user_menu` VALUES ('2215520224937305', '2215520224937257', '2215520224936464');
INSERT INTO `sys_user_menu` VALUES ('2215520224937306', '2215520224937258', '2215520224936464');
INSERT INTO `sys_user_menu` VALUES ('2215520224937307', '2215520224937259', '2215520224936464');
INSERT INTO `sys_user_menu` VALUES ('2215520224937308', '2215520224937260', '2215520224936464');
INSERT INTO `sys_user_menu` VALUES ('2215520224937309', '2215520224937261', '2215520224936464');
INSERT INTO `sys_user_menu` VALUES ('2215520224937310', '2215520224937262', '2215520224936464');
INSERT INTO `sys_user_menu` VALUES ('2215520224937311', '2215520224937263', '2215520224936464');
INSERT INTO `sys_user_menu` VALUES ('2215520224937342', '2215520224936818', '2215520224936342');
INSERT INTO `sys_user_menu` VALUES ('2215520224937343', '2215520224936819', '2215520224936342');
INSERT INTO `sys_user_menu` VALUES ('2215520224937344', '2215520224936820', '2215520224936342');
INSERT INTO `sys_user_menu` VALUES ('2215520224937345', '2215520224936821', '2215520224936342');
INSERT INTO `sys_user_menu` VALUES ('2215520224937346', '2215520224936822', '2215520224936342');
INSERT INTO `sys_user_menu` VALUES ('2215520224937347', '2215520224936823', '2215520224936342');
INSERT INTO `sys_user_menu` VALUES ('2215520224937348', '2215520224936824', '2215520224936342');
INSERT INTO `sys_user_menu` VALUES ('2215520224937349', '2215520224936825', '2215520224936342');
INSERT INTO `sys_user_menu` VALUES ('2215520224937350', '2215520224936826', '2215520224936342');
INSERT INTO `sys_user_menu` VALUES ('2215520224937351', '2215520224936827', '2215520224936342');
INSERT INTO `sys_user_menu` VALUES ('2215520224937352', '2215520224936828', '2215520224936342');
INSERT INTO `sys_user_menu` VALUES ('2215520224937353', '2215520224936829', '2215520224936342');
INSERT INTO `sys_user_menu` VALUES ('2215520224937354', '2215520224936830', '2215520224936342');
INSERT INTO `sys_user_menu` VALUES ('2215520224937355', '2215520224936831', '2215520224936342');
INSERT INTO `sys_user_menu` VALUES ('2215520224937356', '2215520224936832', '2215520224936342');
INSERT INTO `sys_user_menu` VALUES ('2215520224937365', '2215520224937322', '2215520224936508');
INSERT INTO `sys_user_menu` VALUES ('2215520224937366', '2215520224937364', '2215520224936515');
INSERT INTO `sys_user_menu` VALUES ('2215520224937367', '2215520224937365', '2215520224936515');
INSERT INTO `sys_user_menu` VALUES ('2215520224937368', '2215520224937366', '2215520224936515');
INSERT INTO `sys_user_menu` VALUES ('2215520224937369', '2215520224937367', '2215520224936515');
INSERT INTO `sys_user_menu` VALUES ('2215520224937370', '2215520224937368', '2215520224936515');
INSERT INTO `sys_user_menu` VALUES ('2215520224937371', '2215520224937369', '2215520224936515');
INSERT INTO `sys_user_menu` VALUES ('2215520224937372', '2215520224937370', '2215520224936515');
INSERT INTO `sys_user_menu` VALUES ('2215520224937373', '2215520224937371', '2215520224936515');
INSERT INTO `sys_user_menu` VALUES ('2215520224937374', '2215520224936813', '2215520224936516');
INSERT INTO `sys_user_menu` VALUES ('2215520224937375', '2215520224936818', '2215520224936516');
INSERT INTO `sys_user_menu` VALUES ('2215520224937376', '2215520224936819', '2215520224936516');
INSERT INTO `sys_user_menu` VALUES ('2215520224937377', '2215520224936820', '2215520224936516');
INSERT INTO `sys_user_menu` VALUES ('2215520224937378', '2215520224936821', '2215520224936516');
INSERT INTO `sys_user_menu` VALUES ('2215520224937379', '2215520224936822', '2215520224936516');
INSERT INTO `sys_user_menu` VALUES ('2215520224937380', '2215520224936823', '2215520224936516');
INSERT INTO `sys_user_menu` VALUES ('2215520224937381', '2215520224936824', '2215520224936516');
INSERT INTO `sys_user_menu` VALUES ('2215520224937382', '2215520224936825', '2215520224936516');
INSERT INTO `sys_user_menu` VALUES ('2215520224937383', '2215520224936826', '2215520224936516');
INSERT INTO `sys_user_menu` VALUES ('2215520224937384', '2215520224936827', '2215520224936516');
INSERT INTO `sys_user_menu` VALUES ('2215520224937385', '2215520224936828', '2215520224936516');
INSERT INTO `sys_user_menu` VALUES ('2215520224937386', '2215520224936814', '2215520224936516');
INSERT INTO `sys_user_menu` VALUES ('2215520224937387', '2215520224936815', '2215520224936516');
INSERT INTO `sys_user_menu` VALUES ('2215520224937388', '2215520224936816', '2215520224936516');
INSERT INTO `sys_user_menu` VALUES ('2215520224937389', '2215520224936817', '2215520224936516');
INSERT INTO `sys_user_menu` VALUES ('2215520224937451', '2215520224936818', '1');
INSERT INTO `sys_user_menu` VALUES ('2215520224937452', '2215520224936819', '1');
INSERT INTO `sys_user_menu` VALUES ('2215520224937453', '2215520224936820', '1');
INSERT INTO `sys_user_menu` VALUES ('2215520224937454', '2215520224936821', '1');
INSERT INTO `sys_user_menu` VALUES ('2215520224937455', '2215520224936822', '1');
INSERT INTO `sys_user_menu` VALUES ('2215520224937456', '2215520224936823', '1');
INSERT INTO `sys_user_menu` VALUES ('2215520224937457', '2215520224936824', '1');
INSERT INTO `sys_user_menu` VALUES ('2215520224937458', '2215520224936825', '1');
INSERT INTO `sys_user_menu` VALUES ('2215520224937459', '2215520224936826', '1');
INSERT INTO `sys_user_menu` VALUES ('2215520224937460', '2215520224936827', '1');
INSERT INTO `sys_user_menu` VALUES ('2215520224937461', '2215520224936828', '1');
INSERT INTO `sys_user_menu` VALUES ('2215520224937462', '2215520224936829', '1');
INSERT INTO `sys_user_menu` VALUES ('2215520224937463', '2215520224936830', '1');
INSERT INTO `sys_user_menu` VALUES ('2215520224937464', '1', '1');
INSERT INTO `sys_user_menu` VALUES ('2215520224937465', '2215520224936833', '1');
INSERT INTO `sys_user_menu` VALUES ('2215520224937466', '2215520224936834', '1');
INSERT INTO `sys_user_menu` VALUES ('2215520224937467', '2215520224936835', '1');
INSERT INTO `sys_user_menu` VALUES ('2215520224937468', '2215520224936839', '1');
INSERT INTO `sys_user_menu` VALUES ('2215520224937469', '2215520224936840', '1');
INSERT INTO `sys_user_menu` VALUES ('2215520224937470', '2215520224936841', '1');
INSERT INTO `sys_user_menu` VALUES ('2215520224937471', '2215520224936842', '1');
INSERT INTO `sys_user_menu` VALUES ('2215520224937472', '2215520224936843', '1');
INSERT INTO `sys_user_menu` VALUES ('2215520224937473', '2215520224937125', '1');
INSERT INTO `sys_user_menu` VALUES ('2215520224937474', '2215520224937126', '1');
INSERT INTO `sys_user_menu` VALUES ('2215520224937475', '2215520224937127', '1');
INSERT INTO `sys_user_menu` VALUES ('2215520224937476', '2215520224937128', '1');
INSERT INTO `sys_user_menu` VALUES ('2215520224937477', '2215520224937154', '1');
INSERT INTO `sys_user_menu` VALUES ('2215520224937478', '2215520224937155', '1');
INSERT INTO `sys_user_menu` VALUES ('2215520224937479', '2215520224937156', '1');
INSERT INTO `sys_user_menu` VALUES ('2215520224937480', '2215520224937157', '1');
INSERT INTO `sys_user_menu` VALUES ('2215520224937481', '2215520224937158', '1');
INSERT INTO `sys_user_menu` VALUES ('2215520224937482', '2215520224937159', '1');
INSERT INTO `sys_user_menu` VALUES ('2215520224937483', '2215520224937160', '1');
INSERT INTO `sys_user_menu` VALUES ('2215520224937485', '2215520224937384', '2215520224935961');
INSERT INTO `sys_user_menu` VALUES ('2215520224937486', '481', '110');
INSERT INTO `sys_user_menu` VALUES ('2215520224937487', '498', '13');
INSERT INTO `sys_user_menu` VALUES ('2215520224937488', '2215520224937385', '2215520224936524');
INSERT INTO `sys_user_menu` VALUES ('2215520224937490', '2215520224936818', '2215520224936518');
INSERT INTO `sys_user_menu` VALUES ('2215520224937491', '2215520224936819', '2215520224936518');
INSERT INTO `sys_user_menu` VALUES ('2215520224937492', '2215520224936814', '2215520224936518');
INSERT INTO `sys_user_menu` VALUES ('2215520224937493', '2215520224936815', '2215520224936518');
INSERT INTO `sys_user_menu` VALUES ('2215520224937495', '2215520224936817', '2215520224936518');
INSERT INTO `sys_user_menu` VALUES ('2215520224937496', '2215520224937386', '2215520224936526');
INSERT INTO `sys_user_menu` VALUES ('2215520224937497', '2215520224937387', '2215520224936526');
INSERT INTO `sys_user_menu` VALUES ('2215520224937498', '2215520224937388', '2215520224936526');
INSERT INTO `sys_user_menu` VALUES ('2215520224937499', '2215520224937389', '2215520224936526');
INSERT INTO `sys_user_menu` VALUES ('2215520224937500', '2215520224937390', '2215520224936526');
INSERT INTO `sys_user_menu` VALUES ('2215520224937501', '2215520224937391', '2215520224936526');
INSERT INTO `sys_user_menu` VALUES ('2215520224937502', '2215520224937392', '2215520224936526');
INSERT INTO `sys_user_menu` VALUES ('2215520224937503', '2215520224937393', '2215520224936526');
INSERT INTO `sys_user_menu` VALUES ('2215520224937504', '2215520224937394', '2215520224936526');
INSERT INTO `sys_user_menu` VALUES ('2215520224937505', '2215520224937395', '2215520224936528');
INSERT INTO `sys_user_menu` VALUES ('2215520224937506', '2215520224937396', '2215520224936528');
INSERT INTO `sys_user_menu` VALUES ('2215520224937507', '2215520224937397', '2215520224936528');
INSERT INTO `sys_user_menu` VALUES ('2215520224937508', '2215520224937398', '2215520224936528');
INSERT INTO `sys_user_menu` VALUES ('2215520224937509', '2215520224937399', '2215520224936528');
INSERT INTO `sys_user_menu` VALUES ('2215520224937510', '2215520224937400', '2215520224936528');
INSERT INTO `sys_user_menu` VALUES ('2215520224937511', '2215520224937401', '2215520224936528');
INSERT INTO `sys_user_menu` VALUES ('2215520224937512', '2215520224937402', '2215520224936528');
INSERT INTO `sys_user_menu` VALUES ('2215520224937513', '2215520224937403', '2215520224936528');
INSERT INTO `sys_user_menu` VALUES ('2215520224937514', '2215520224936812', '2215520224936518');
INSERT INTO `sys_user_menu` VALUES ('2215520224937515', '2215520224937405', '2215520224936518');
INSERT INTO `sys_user_menu` VALUES ('2215520224937516', '2215520224937406', '2215520224936518');
INSERT INTO `sys_user_menu` VALUES ('2215520224937517', '2215520224937407', '2215520224936518');
INSERT INTO `sys_user_menu` VALUES ('2215520224937518', '2215520224937408', '2215520224936518');
INSERT INTO `sys_user_menu` VALUES ('2215520224937519', '2215520224937409', '2215520224936518');
INSERT INTO `sys_user_menu` VALUES ('2215520224937520', '2215520224937410', '2215520224936518');
INSERT INTO `sys_user_menu` VALUES ('2215520224937521', '2215520224937411', '2215520224936518');
INSERT INTO `sys_user_menu` VALUES ('2215520224937522', '2215520224937412', '2215520224936518');
INSERT INTO `sys_user_menu` VALUES ('2215520224937523', '2215520224937413', '2215520224936518');
INSERT INTO `sys_user_menu` VALUES ('2215520224937524', '2215520224936820', '2215520224936518');
INSERT INTO `sys_user_menu` VALUES ('2215520224937525', '2215520224936821', '2215520224936518');
INSERT INTO `sys_user_menu` VALUES ('2215520224937526', '2215520224936822', '2215520224936518');
INSERT INTO `sys_user_menu` VALUES ('2215520224937527', '2215520224936823', '2215520224936518');
INSERT INTO `sys_user_menu` VALUES ('2215520224937528', '2215520224936824', '2215520224936518');
INSERT INTO `sys_user_menu` VALUES ('2215520224937529', '2215520224936825', '2215520224936518');
INSERT INTO `sys_user_menu` VALUES ('2215520224937530', '2215520224936826', '2215520224936518');
INSERT INTO `sys_user_menu` VALUES ('2215520224937531', '2215520224936827', '2215520224936518');
INSERT INTO `sys_user_menu` VALUES ('2215520224937532', '2215520224936828', '2215520224936518');
INSERT INTO `sys_user_menu` VALUES ('2215520224937533', '2215520224936829', '2215520224936518');
INSERT INTO `sys_user_menu` VALUES ('2215520224937534', '2215520224936830', '2215520224936518');
INSERT INTO `sys_user_menu` VALUES ('2215520224937535', '2215520224936831', '2215520224936518');
INSERT INTO `sys_user_menu` VALUES ('2215520224937536', '2215520224936832', '2215520224936518');
INSERT INTO `sys_user_menu` VALUES ('2215520224937537', '2215520224937129', '2215520224936518');
INSERT INTO `sys_user_menu` VALUES ('2215520224937538', '2215520224936833', '2215520224936518');
INSERT INTO `sys_user_menu` VALUES ('2215520224937539', '2215520224936834', '2215520224936518');
INSERT INTO `sys_user_menu` VALUES ('2215520224937540', '2215520224936835', '2215520224936518');
INSERT INTO `sys_user_menu` VALUES ('2215520224937541', '2215520224936836', '2215520224936518');
INSERT INTO `sys_user_menu` VALUES ('2215520224937542', '2215520224936837', '2215520224936518');
INSERT INTO `sys_user_menu` VALUES ('2215520224937543', '2215520224936838', '2215520224936518');
INSERT INTO `sys_user_menu` VALUES ('2215520224937544', '2215520224936839', '2215520224936518');
INSERT INTO `sys_user_menu` VALUES ('2215520224937545', '2215520224936840', '2215520224936518');
INSERT INTO `sys_user_menu` VALUES ('2215520224937546', '2215520224936841', '2215520224936518');
INSERT INTO `sys_user_menu` VALUES ('2215520224937547', '2215520224936842', '2215520224936518');
INSERT INTO `sys_user_menu` VALUES ('2215520224937548', '2215520224936843', '2215520224936518');
INSERT INTO `sys_user_menu` VALUES ('2215520224937549', '2215520224936862', '2215520224936518');
INSERT INTO `sys_user_menu` VALUES ('2215520224937550', '2215520224936866', '2215520224936518');
INSERT INTO `sys_user_menu` VALUES ('2215520224937551', '2215520224937123', '2215520224936518');
INSERT INTO `sys_user_menu` VALUES ('2215520224937552', '2215520224937124', '2215520224936518');
INSERT INTO `sys_user_menu` VALUES ('2215520224937553', '2215520224937125', '2215520224936518');
INSERT INTO `sys_user_menu` VALUES ('2215520224937554', '2215520224937126', '2215520224936518');
INSERT INTO `sys_user_menu` VALUES ('2215520224937555', '2215520224937127', '2215520224936518');
INSERT INTO `sys_user_menu` VALUES ('2215520224937556', '2215520224937128', '2215520224936518');
INSERT INTO `sys_user_menu` VALUES ('2215520224937557', '2215520224937154', '2215520224936518');
INSERT INTO `sys_user_menu` VALUES ('2215520224937558', '2215520224937155', '2215520224936518');
INSERT INTO `sys_user_menu` VALUES ('2215520224937559', '2215520224937156', '2215520224936518');
INSERT INTO `sys_user_menu` VALUES ('2215520224937560', '2215520224937157', '2215520224936518');
INSERT INTO `sys_user_menu` VALUES ('2215520224937561', '2215520224937158', '2215520224936518');
INSERT INTO `sys_user_menu` VALUES ('2215520224937562', '2215520224937159', '2215520224936518');
INSERT INTO `sys_user_menu` VALUES ('2215520224937563', '2215520224937160', '2215520224936518');
INSERT INTO `sys_user_menu` VALUES ('2215520224937564', '2215520224936812', '2215520224936540');
INSERT INTO `sys_user_menu` VALUES ('2215520224937565', '2215520224937405', '2215520224936540');
INSERT INTO `sys_user_menu` VALUES ('2215520224937566', '2215520224937406', '2215520224936540');
INSERT INTO `sys_user_menu` VALUES ('2215520224937567', '2215520224937407', '2215520224936540');
INSERT INTO `sys_user_menu` VALUES ('2215520224937568', '2215520224937408', '2215520224936540');
INSERT INTO `sys_user_menu` VALUES ('2215520224937569', '2215520224937409', '2215520224936540');
INSERT INTO `sys_user_menu` VALUES ('2215520224937570', '2215520224937410', '2215520224936540');
INSERT INTO `sys_user_menu` VALUES ('2215520224937571', '2215520224937411', '2215520224936540');
INSERT INTO `sys_user_menu` VALUES ('2215520224937572', '2215520224937412', '2215520224936540');
INSERT INTO `sys_user_menu` VALUES ('2215520224937573', '2215520224937413', '2215520224936540');
INSERT INTO `sys_user_menu` VALUES ('2215520224937574', '2215520224936813', '2215520224936540');
INSERT INTO `sys_user_menu` VALUES ('2215520224937575', '2215520224936818', '2215520224936540');
INSERT INTO `sys_user_menu` VALUES ('2215520224937576', '2215520224936819', '2215520224936540');
INSERT INTO `sys_user_menu` VALUES ('2215520224937577', '2215520224936820', '2215520224936540');
INSERT INTO `sys_user_menu` VALUES ('2215520224937578', '2215520224936821', '2215520224936540');
INSERT INTO `sys_user_menu` VALUES ('2215520224937579', '2215520224936822', '2215520224936540');
INSERT INTO `sys_user_menu` VALUES ('2215520224937580', '2215520224936823', '2215520224936540');
INSERT INTO `sys_user_menu` VALUES ('2215520224937581', '2215520224936824', '2215520224936540');
INSERT INTO `sys_user_menu` VALUES ('2215520224937582', '2215520224936825', '2215520224936540');
INSERT INTO `sys_user_menu` VALUES ('2215520224937583', '2215520224936826', '2215520224936540');
INSERT INTO `sys_user_menu` VALUES ('2215520224937584', '2215520224936827', '2215520224936540');
INSERT INTO `sys_user_menu` VALUES ('2215520224937585', '2215520224936828', '2215520224936540');
INSERT INTO `sys_user_menu` VALUES ('2215520224937586', '2215520224936814', '2215520224936540');
INSERT INTO `sys_user_menu` VALUES ('2215520224937587', '2215520224936829', '2215520224936540');
INSERT INTO `sys_user_menu` VALUES ('2215520224937588', '2215520224936830', '2215520224936540');
INSERT INTO `sys_user_menu` VALUES ('2215520224937589', '2215520224936831', '2215520224936540');
INSERT INTO `sys_user_menu` VALUES ('2215520224937590', '2215520224936832', '2215520224936540');
INSERT INTO `sys_user_menu` VALUES ('2215520224937591', '2215520224937129', '2215520224936540');
INSERT INTO `sys_user_menu` VALUES ('2215520224937592', '2215520224936815', '2215520224936540');
INSERT INTO `sys_user_menu` VALUES ('2215520224937593', '2215520224936833', '2215520224936540');
INSERT INTO `sys_user_menu` VALUES ('2215520224937594', '2215520224936834', '2215520224936540');
INSERT INTO `sys_user_menu` VALUES ('2215520224937595', '2215520224936835', '2215520224936540');
INSERT INTO `sys_user_menu` VALUES ('2215520224937596', '2215520224936836', '2215520224936540');
INSERT INTO `sys_user_menu` VALUES ('2215520224937597', '2215520224936837', '2215520224936540');
INSERT INTO `sys_user_menu` VALUES ('2215520224937598', '2215520224936838', '2215520224936540');
INSERT INTO `sys_user_menu` VALUES ('2215520224937599', '2215520224936839', '2215520224936540');
INSERT INTO `sys_user_menu` VALUES ('2215520224937600', '2215520224936840', '2215520224936540');
INSERT INTO `sys_user_menu` VALUES ('2215520224937601', '2215520224936841', '2215520224936540');
INSERT INTO `sys_user_menu` VALUES ('2215520224937602', '2215520224936816', '2215520224936540');
INSERT INTO `sys_user_menu` VALUES ('2215520224937603', '2215520224936842', '2215520224936540');
INSERT INTO `sys_user_menu` VALUES ('2215520224937604', '2215520224936843', '2215520224936540');
INSERT INTO `sys_user_menu` VALUES ('2215520224937605', '2215520224936862', '2215520224936540');
INSERT INTO `sys_user_menu` VALUES ('2215520224937606', '2215520224936866', '2215520224936540');
INSERT INTO `sys_user_menu` VALUES ('2215520224937607', '2215520224937123', '2215520224936540');
INSERT INTO `sys_user_menu` VALUES ('2215520224937608', '2215520224937124', '2215520224936540');
INSERT INTO `sys_user_menu` VALUES ('2215520224937609', '2215520224936817', '2215520224936540');
INSERT INTO `sys_user_menu` VALUES ('2215520224937610', '2215520224937125', '2215520224936540');
INSERT INTO `sys_user_menu` VALUES ('2215520224937611', '2215520224937126', '2215520224936540');
INSERT INTO `sys_user_menu` VALUES ('2215520224937612', '2215520224937127', '2215520224936540');
INSERT INTO `sys_user_menu` VALUES ('2215520224937613', '2215520224937128', '2215520224936540');
INSERT INTO `sys_user_menu` VALUES ('2215520224937614', '2215520224937154', '2215520224936540');
INSERT INTO `sys_user_menu` VALUES ('2215520224937615', '2215520224937155', '2215520224936540');
INSERT INTO `sys_user_menu` VALUES ('2215520224937616', '2215520224937156', '2215520224936540');
INSERT INTO `sys_user_menu` VALUES ('2215520224937617', '2215520224937157', '2215520224936540');
INSERT INTO `sys_user_menu` VALUES ('2215520224937618', '2215520224937158', '2215520224936540');
INSERT INTO `sys_user_menu` VALUES ('2215520224937619', '2215520224937159', '2215520224936540');
INSERT INTO `sys_user_menu` VALUES ('2215520224937620', '2215520224937160', '2215520224936540');
INSERT INTO `sys_user_menu` VALUES ('2215520224937621', '2215520224936812', '2215520224936431');
INSERT INTO `sys_user_menu` VALUES ('2215520224937624', '2215520224937127', '2215520224936431');
INSERT INTO `sys_user_menu` VALUES ('2215520224937625', '2215520224937158', '2215520224936431');
INSERT INTO `sys_user_menu` VALUES ('2215520224937628', '2215520224937128', '2215520224936431');
INSERT INTO `sys_user_menu` VALUES ('2215520224937629', '2215520224937159', '2215520224936431');
INSERT INTO `sys_user_menu` VALUES ('2215520224937630', '2215520224936843', '2215520224936431');
INSERT INTO `sys_user_menu` VALUES ('2215520224937631', '2215520224936862', '2215520224936431');
INSERT INTO `sys_user_menu` VALUES ('2215520224937632', '2215520224936836', '2215520224936431');
INSERT INTO `sys_user_menu` VALUES ('2215520224937633', '2215520224936841', '2215520224936431');
INSERT INTO `sys_user_menu` VALUES ('2215520224937634', '2215520224936830', '2215520224936431');
INSERT INTO `sys_user_menu` VALUES ('2215520224937635', '2215520224936831', '2215520224936431');
INSERT INTO `sys_user_menu` VALUES ('2215520224937636', '2215520224936823', '2215520224936431');
INSERT INTO `sys_user_menu` VALUES ('2215520224937637', '2215520224936827', '2215520224936431');
INSERT INTO `sys_user_menu` VALUES ('2215520224937638', '2215520224936828', '2215520224936431');
INSERT INTO `sys_user_menu` VALUES ('2215520224937650', '2215520224936812', '2215520224936432');
INSERT INTO `sys_user_menu` VALUES ('2215520224937654', '2215520224937406', '2215520224936432');
INSERT INTO `sys_user_menu` VALUES ('2215520224937661', '2215520224937413', '2215520224936432');
INSERT INTO `sys_user_menu` VALUES ('2215520224937662', '2215520224936820', '2215520224936432');
INSERT INTO `sys_user_menu` VALUES ('2215520224937663', '2215520224936826', '2215520224936432');
INSERT INTO `sys_user_menu` VALUES ('2215520224937664', '2215520224936832', '2215520224936432');
INSERT INTO `sys_user_menu` VALUES ('2215520224937665', '2215520224936837', '2215520224936432');
INSERT INTO `sys_user_menu` VALUES ('2215520224937666', '2215520224937124', '2215520224936432');
INSERT INTO `sys_user_menu` VALUES ('2215520224937667', '2215520224937154', '2215520224936432');
INSERT INTO `sys_user_menu` VALUES ('2215520224937668', '2215520224937160', '2215520224936432');
INSERT INTO `sys_user_menu` VALUES ('2215520224937669', '2215520224936812', '2215520224936541');
INSERT INTO `sys_user_menu` VALUES ('2215520224937670', '2215520224937405', '2215520224936541');
INSERT INTO `sys_user_menu` VALUES ('2215520224937671', '2215520224937412', '2215520224936541');
INSERT INTO `sys_user_menu` VALUES ('2215520224937672', '2215520224936813', '2215520224936541');
INSERT INTO `sys_user_menu` VALUES ('2215520224937673', '2215520224936819', '2215520224936541');
INSERT INTO `sys_user_menu` VALUES ('2215520224937674', '2215520224936825', '2215520224936541');
INSERT INTO `sys_user_menu` VALUES ('2215520224937675', '2215520224936814', '2215520224936541');
INSERT INTO `sys_user_menu` VALUES ('2215520224937676', '2215520224936829', '2215520224936541');
INSERT INTO `sys_user_menu` VALUES ('2215520224937677', '2215520224936815', '2215520224936541');
INSERT INTO `sys_user_menu` VALUES ('2215520224937678', '2215520224936834', '2215520224936541');
INSERT INTO `sys_user_menu` VALUES ('2215520224937679', '2215520224936840', '2215520224936541');
INSERT INTO `sys_user_menu` VALUES ('2215520224937680', '2215520224936816', '2215520224936541');
INSERT INTO `sys_user_menu` VALUES ('2215520224937681', '2215520224936842', '2215520224936541');
INSERT INTO `sys_user_menu` VALUES ('2215520224937682', '2215520224936817', '2215520224936541');
INSERT INTO `sys_user_menu` VALUES ('2215520224937683', '2215520224937126', '2215520224936541');
INSERT INTO `sys_user_menu` VALUES ('2215520224937684', '2215520224937157', '2215520224936541');
INSERT INTO `sys_user_menu` VALUES ('2215520224937685', '2215520224936818', '2215520224936541');
INSERT INTO `sys_user_menu` VALUES ('2215520224937686', '2215520224936820', '2215520224936541');
INSERT INTO `sys_user_menu` VALUES ('2215520224937687', '2215520224936821', '2215520224936541');
INSERT INTO `sys_user_menu` VALUES ('2215520224937688', '2215520224936822', '2215520224936541');
INSERT INTO `sys_user_menu` VALUES ('2215520224937689', '2215520224936823', '2215520224936541');
INSERT INTO `sys_user_menu` VALUES ('2215520224937690', '2215520224936824', '2215520224936541');
INSERT INTO `sys_user_menu` VALUES ('2215520224937691', '2215520224936826', '2215520224936541');
INSERT INTO `sys_user_menu` VALUES ('2215520224937692', '2215520224936827', '2215520224936541');
INSERT INTO `sys_user_menu` VALUES ('2215520224937693', '2215520224936828', '2215520224936541');
INSERT INTO `sys_user_menu` VALUES ('2215520224937694', '2215520224936830', '2215520224936541');
INSERT INTO `sys_user_menu` VALUES ('2215520224937695', '2215520224936831', '2215520224936541');
INSERT INTO `sys_user_menu` VALUES ('2215520224937696', '2215520224936832', '2215520224936541');
INSERT INTO `sys_user_menu` VALUES ('2215520224937697', '1', '2215520224936541');
INSERT INTO `sys_user_menu` VALUES ('2215520224937698', '2215520224936833', '2215520224936541');
INSERT INTO `sys_user_menu` VALUES ('2215520224937699', '2215520224936835', '2215520224936541');
INSERT INTO `sys_user_menu` VALUES ('2215520224937700', '2215520224936836', '2215520224936541');
INSERT INTO `sys_user_menu` VALUES ('2215520224937701', '2215520224936837', '2215520224936541');
INSERT INTO `sys_user_menu` VALUES ('2215520224937702', '2215520224936838', '2215520224936541');
INSERT INTO `sys_user_menu` VALUES ('2215520224937703', '2215520224936839', '2215520224936541');
INSERT INTO `sys_user_menu` VALUES ('2215520224937704', '2215520224936841', '2215520224936541');
INSERT INTO `sys_user_menu` VALUES ('2215520224937705', '2215520224936843', '2215520224936541');
INSERT INTO `sys_user_menu` VALUES ('2215520224937706', '2215520224936862', '2215520224936541');
INSERT INTO `sys_user_menu` VALUES ('2215520224937707', '2215520224936866', '2215520224936541');
INSERT INTO `sys_user_menu` VALUES ('2215520224937708', '2215520224937123', '2215520224936541');
INSERT INTO `sys_user_menu` VALUES ('2215520224937709', '2215520224937124', '2215520224936541');
INSERT INTO `sys_user_menu` VALUES ('2215520224937710', '2215520224937125', '2215520224936541');
INSERT INTO `sys_user_menu` VALUES ('2215520224937711', '2215520224937127', '2215520224936541');
INSERT INTO `sys_user_menu` VALUES ('2215520224937712', '2215520224937128', '2215520224936541');
INSERT INTO `sys_user_menu` VALUES ('2215520224937713', '2215520224937154', '2215520224936541');
INSERT INTO `sys_user_menu` VALUES ('2215520224937714', '2215520224937155', '2215520224936541');
INSERT INTO `sys_user_menu` VALUES ('2215520224937715', '2215520224937156', '2215520224936541');
INSERT INTO `sys_user_menu` VALUES ('2215520224937716', '2215520224937158', '2215520224936541');
INSERT INTO `sys_user_menu` VALUES ('2215520224937717', '2215520224937159', '2215520224936541');
INSERT INTO `sys_user_menu` VALUES ('2215520224937718', '2215520224937160', '2215520224936541');
INSERT INTO `sys_user_menu` VALUES ('2215520224937719', '2215520224937423', '2215520224936542');
INSERT INTO `sys_user_menu` VALUES ('2215520224937720', '2215520224937424', '2215520224936543');
INSERT INTO `sys_user_menu` VALUES ('2215520224937721', '2215520224937425', '2215520224936544');
INSERT INTO `sys_user_menu` VALUES ('2215520224937722', '2215520224937426', '2215520224936545');
INSERT INTO `sys_user_menu` VALUES ('2215520224937723', '2215520224937427', '1');

-- ----------------------------
-- Table structure for `sys_user_office`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_office`;
CREATE TABLE `sys_user_office` (
  `id` bigint(20) NOT NULL,
  `user_id` varchar(64) NOT NULL COMMENT '用户主键ID',
  `office_id` varchar(64) NOT NULL COMMENT '部门主键ID',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_office
-- ----------------------------
INSERT INTO `sys_user_office` VALUES ('2215520224935943', '1', '2215520224935939');
INSERT INTO `sys_user_office` VALUES ('2215520224935947', '2215520224936291', '2215520224935939');
INSERT INTO `sys_user_office` VALUES ('2215520224935949', '2215520224936299', '2215520224935939');
INSERT INTO `sys_user_office` VALUES ('2215520224935951', '2215520224936360', '2215520224935939');
INSERT INTO `sys_user_office` VALUES ('2215520224935952', '2215520224936360', '2215520224935940');
INSERT INTO `sys_user_office` VALUES ('2215520224935953', '2215520224936364', '2215520224935939');
INSERT INTO `sys_user_office` VALUES ('2215520224935955', '2215520224936277', '2215520224935942');
INSERT INTO `sys_user_office` VALUES ('2215520224935958', '2215520224936349', '2215520224935961');
INSERT INTO `sys_user_office` VALUES ('2215520224935959', '2215520224936426', '2215520224935960');
INSERT INTO `sys_user_office` VALUES ('2215520224935960', '2215520224936367', '2215520224935960');
INSERT INTO `sys_user_office` VALUES ('2215520224935962', '2215520224936432', '2215520224935960');
INSERT INTO `sys_user_office` VALUES ('2215520224935970', '2215520224936431', '2215520224935960');
INSERT INTO `sys_user_office` VALUES ('2215520224935971', '2215520224936452', '2215520224935966');
INSERT INTO `sys_user_office` VALUES ('2215520224935972', '2215520224936440', '2215520224935964');
INSERT INTO `sys_user_office` VALUES ('2215520224935977', '2215520224936442', '2215520224935965');
INSERT INTO `sys_user_office` VALUES ('2215520224935978', '2215520224935985', '2215520224936813');
INSERT INTO `sys_user_office` VALUES ('2215520224935979', '2215520224935985', '2215520224936814');
INSERT INTO `sys_user_office` VALUES ('2215520224935980', '2215520224936349', '2215520224935960');
INSERT INTO `sys_user_office` VALUES ('2215520224935981', '2215520224936349', '2215520224935965');
INSERT INTO `sys_user_office` VALUES ('2215520224935982', '2215520224936431', '2215520224935965');
INSERT INTO `sys_user_office` VALUES ('2215520224935983', '2215520224936508', '2215520224935968');
INSERT INTO `sys_user_office` VALUES ('2215520224935984', '2215520224936516', '2215520224935939');
INSERT INTO `sys_user_office` VALUES ('2215520224935989', '1', '2215520224935940');
INSERT INTO `sys_user_office` VALUES ('2215520224935990', '1', '2215520224935959');
INSERT INTO `sys_user_office` VALUES ('2215520224935991', '1', '2215520224935963');
INSERT INTO `sys_user_office` VALUES ('2215520224935992', '1', '2215520224935964');
INSERT INTO `sys_user_office` VALUES ('2215520224935993', '1', '2215520224935965');
INSERT INTO `sys_user_office` VALUES ('2215520224935994', '110', '100');
INSERT INTO `sys_user_office` VALUES ('2215520224935995', '13', '106');
INSERT INTO `sys_user_office` VALUES ('2215520224935996', '2215520224936524', '2215520224935972');
INSERT INTO `sys_user_office` VALUES ('2215520224935997', '2215520224936518', '2215520224935960');
INSERT INTO `sys_user_office` VALUES ('2215520224935998', '2215520224936540', '2215520224935961');
INSERT INTO `sys_user_office` VALUES ('2215520224935999', '2215520224936541', '2215520224935973');
INSERT INTO `sys_user_office` VALUES ('2215520224936000', '2215520224936542', '2215520224935974');
INSERT INTO `sys_user_office` VALUES ('2215520224936001', '2215520224936543', '2215520224935975');
INSERT INTO `sys_user_office` VALUES ('2215520224936002', '2215520224936544', '2215520224935976');
INSERT INTO `sys_user_office` VALUES ('2215520224936003', '2215520224936545', '2215520224935977');

-- ----------------------------
-- Table structure for `sys_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` bigint(20) NOT NULL,
  `user_id` varchar(64) NOT NULL COMMENT '用户编号',
  `role_id` varchar(64) NOT NULL COMMENT '角色编号',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户-角色';

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('2215520224935943', '1', '2215520224936031');
INSERT INTO `sys_user_role` VALUES ('2215520224935945', '2215520224936305', '2215520224935947');
INSERT INTO `sys_user_role` VALUES ('2215520224935947', '2215520224936306', '2215520224935947');
INSERT INTO `sys_user_role` VALUES ('2215520224935948', '2215520224936307', '2215520224935940');
INSERT INTO `sys_user_role` VALUES ('2215520224935949', '2215520224936308', '2215520224935940');
INSERT INTO `sys_user_role` VALUES ('2215520224935950', '2215520224936311', '2215520224935940');
INSERT INTO `sys_user_role` VALUES ('2215520224935951', '2215520224936315', '2215520224935939');
INSERT INTO `sys_user_role` VALUES ('2215520224935952', '2215520224936315', '2215520224935940');
INSERT INTO `sys_user_role` VALUES ('2215520224935958', '2215520224936319', '2215520224935939');
INSERT INTO `sys_user_role` VALUES ('2215520224935960', '2215520224936285', '2215520224935940');
INSERT INTO `sys_user_role` VALUES ('2215520224935965', '2215520224936323', '2215520224935939');
INSERT INTO `sys_user_role` VALUES ('2215520224935966', '2215520224936333', '2215520224935980');
INSERT INTO `sys_user_role` VALUES ('2215520224935967', '2215520224936334', '2215520224935981');
INSERT INTO `sys_user_role` VALUES ('2215520224935968', '2215520224936336', '2215520224935982');
INSERT INTO `sys_user_role` VALUES ('2215520224935970', '2215520224936338', '2215520224935961');
INSERT INTO `sys_user_role` VALUES ('2215520224935971', '2215520224936338', '2215520224935963');
INSERT INTO `sys_user_role` VALUES ('2215520224935972', '2215520224936338', '2215520224935964');
INSERT INTO `sys_user_role` VALUES ('2215520224935973', '2215520224936343', '2215520224935983');
INSERT INTO `sys_user_role` VALUES ('2215520224935974', '2215520224936344', '2215520224935984');
INSERT INTO `sys_user_role` VALUES ('2215520224935975', '2215520224936345', '2215520224935984');
INSERT INTO `sys_user_role` VALUES ('2215520224936004', '2215520224936424', '2215520224936027');
INSERT INTO `sys_user_role` VALUES ('2215520224936005', '2215520224935992', '2215520224936025');
INSERT INTO `sys_user_role` VALUES ('2215520224936006', '2215520224936425', '2215520224936025');
INSERT INTO `sys_user_role` VALUES ('2215520224936007', '2215520224936007', '2215520224936025');
INSERT INTO `sys_user_role` VALUES ('2215520224936008', '2215520224936426', '2215520224935997');
INSERT INTO `sys_user_role` VALUES ('2215520224936009', '2215520224936426', '2215520224935998');
INSERT INTO `sys_user_role` VALUES ('2215520224936010', '2215520224936367', '2215520224935997');
INSERT INTO `sys_user_role` VALUES ('2215520224936011', '2215520224936367', '2215520224935998');
INSERT INTO `sys_user_role` VALUES ('2215520224936027', '2215520224936452', '2215520224936043');
INSERT INTO `sys_user_role` VALUES ('2215520224936031', '2215520224936442', '2215520224936031');
INSERT INTO `sys_user_role` VALUES ('2215520224936032', '2215520224936442', '2215520224936032');
INSERT INTO `sys_user_role` VALUES ('2215520224936040', '2215520224936342', '2215520224936051');
INSERT INTO `sys_user_role` VALUES ('2215520224936041', '2215520224936349', '2215520224936031');
INSERT INTO `sys_user_role` VALUES ('2215520224936042', '2215520224936431', '2215520224936037');
INSERT INTO `sys_user_role` VALUES ('2215520224936044', '2215520224936483', '2215520224936046');
INSERT INTO `sys_user_role` VALUES ('2215520224936046', '2215520224936505', '2215520224936057');
INSERT INTO `sys_user_role` VALUES ('2215520224936047', '2215520224936505', '2215520224936058');
INSERT INTO `sys_user_role` VALUES ('2215520224936048', '2215520224936508', '2215520224936065');
INSERT INTO `sys_user_role` VALUES ('2215520224936050', '2215520224936471', '2215520224936060');
INSERT INTO `sys_user_role` VALUES ('2215520224936054', '2215520224936514', '2215520224936042');
INSERT INTO `sys_user_role` VALUES ('2215520224936055', '2215520224936515', '2215520224936070');
INSERT INTO `sys_user_role` VALUES ('2215520224936060', '1', '2215520224936039');
INSERT INTO `sys_user_role` VALUES ('2215520224936061', '1', '2215520224936040');
INSERT INTO `sys_user_role` VALUES ('2215520224936062', '2215520224935961', '2215520224936074');
INSERT INTO `sys_user_role` VALUES ('2215520224936063', '2215520224935961', '2215520224936075');
INSERT INTO `sys_user_role` VALUES ('2215520224936064', '110', '4');
INSERT INTO `sys_user_role` VALUES ('2215520224936065', '13', '313');
INSERT INTO `sys_user_role` VALUES ('2215520224936066', '2215520224936524', '2215520224936076');
INSERT INTO `sys_user_role` VALUES ('2215520224936068', '2215520224936528', '2215520224936080');
INSERT INTO `sys_user_role` VALUES ('2215520224936069', '2215520224936518', '2215520224936037');
INSERT INTO `sys_user_role` VALUES ('2215520224936070', '2215520224936518', '2215520224936031');
INSERT INTO `sys_user_role` VALUES ('2215520224936071', '2215520224936540', '2215520224936031');
INSERT INTO `sys_user_role` VALUES ('2215520224936072', '2215520224936432', '2215520224936031');
INSERT INTO `sys_user_role` VALUES ('2215520224936073', '2215520224936432', '2215520224936037');
INSERT INTO `sys_user_role` VALUES ('2215520224936074', '2215520224936541', '2215520224936077');
INSERT INTO `sys_user_role` VALUES ('2215520224936075', '2215520224936541', '2215520224936078');
INSERT INTO `sys_user_role` VALUES ('2215520224936076', '2215520224936542', '2215520224936081');
INSERT INTO `sys_user_role` VALUES ('2215520224936077', '2215520224936543', '2215520224936082');
INSERT INTO `sys_user_role` VALUES ('2215520224936078', '2215520224936544', '2215520224936083');
INSERT INTO `sys_user_role` VALUES ('2215520224936079', '2215520224936545', '2215520224936084');
