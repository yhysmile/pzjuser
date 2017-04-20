/*
Navicat MySQL Data Transfer

Source Server         : 124.251.43.242
Source Server Version : 50518
Source Host           : 124.251.43.242:38860
Source Database       : core_pro

Target Server Type    : MYSQL
Target Server Version : 50518
File Encoding         : 65001

Date: 2015-12-18 19:48:35
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `app_equipment`
-- ----------------------------
DROP TABLE IF EXISTS `app_equipment`;
CREATE TABLE `app_equipment` (
`id`  bigint(20) NOT NULL ,
`create_time`  datetime NULL DEFAULT NULL ,
`update_time`  datetime NULL DEFAULT NULL ,
`device_token`  varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '设备标识' ,
`device_type`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '设备类型' ,
`status`  tinyint(2) NULL DEFAULT 0 COMMENT '状态' ,
`user_id`  bigint(20) NULL DEFAULT NULL COMMENT '用户id' ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='人员设备'

;

-- ----------------------------
-- Table structure for `app_feedback`
-- ----------------------------
DROP TABLE IF EXISTS `app_feedback`;
CREATE TABLE `app_feedback` (
`id`  bigint(20) NOT NULL ,
`user_id`  bigint(20) NULL DEFAULT NULL COMMENT '用户id' ,
`content`  varchar(5000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '内容' ,
`phone`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话' ,
`create_time`  datetime NULL DEFAULT NULL ,
`feedbackScenario`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '反馈意见' ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='意见反馈'

;

-- ----------------------------
-- Table structure for `app_message`
-- ----------------------------
DROP TABLE IF EXISTS `app_message`;
CREATE TABLE `app_message` (
`id`  bigint(20) NOT NULL ,
`title`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标题' ,
`create_time`  datetime NULL DEFAULT NULL ,
`content`  varchar(5000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '内容' ,
`status`  tinyint(2) NULL DEFAULT 0 COMMENT '状态' ,
`user_id`  bigint(20) NULL DEFAULT NULL COMMENT '用户id' ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='信息通知'

;

-- ----------------------------
-- Table structure for `product_combine_relation`
-- ----------------------------
DROP TABLE IF EXISTS `product_combine_relation`;
CREATE TABLE `product_combine_relation` (
`id`  bigint(20) NOT NULL ,
`product_id`  bigint(20) NOT NULL DEFAULT 0 COMMENT '组合产品id' ,
`sub_product_id`  bigint(20) NOT NULL DEFAULT 0 COMMENT '组合产品中包含的产品id' ,
`rebate_id`  bigint(20) NULL DEFAULT 0 COMMENT '子票返利规则id' ,
`supplier_id`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '供应商' ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='组合产品和所包含的产品关系表'

;

-- ----------------------------
-- Table structure for `product_dict`
-- ----------------------------
DROP TABLE IF EXISTS `product_dict`;
CREATE TABLE `product_dict` (
`id`  bigint(20) NOT NULL COMMENT '自增字段' ,
`label`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '显示名称' ,
`value`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '值' ,
`type`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类型' ,
`description`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '纬度' ,
`sort`  int(11) NULL DEFAULT NULL COMMENT '排序' ,
`create_date`  datetime NULL DEFAULT NULL ,
`create_by`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人' ,
`update_by`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`update_date`  datetime NULL DEFAULT NULL ,
`remarks`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '介绍' ,
`flag`  char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '使用状态1启用0禁用2删除' ,
`data_source`  varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`supplier_id`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='产品字典表'

;

-- ----------------------------
-- Table structure for `product_exchange_relation`
-- ----------------------------
DROP TABLE IF EXISTS `product_exchange_relation`;
CREATE TABLE `product_exchange_relation` (
`id`  bigint(20) NOT NULL ,
`objId`  bigint(20) NOT NULL COMMENT '退换票规则id' ,
`relId`  bigint(20) NOT NULL COMMENT '产品id' ,
`supplier_id`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='退换票规则与产品关联'

;

-- ----------------------------
-- Table structure for `product_exchange_strategy`
-- ----------------------------
DROP TABLE IF EXISTS `product_exchange_strategy`;
CREATE TABLE `product_exchange_strategy` (
`id`  bigint(20) NOT NULL ,
`name`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '规则名称' ,
`before_expire`  int(10) NULL DEFAULT 0 COMMENT '退换票时间，(产品有效期结束前的时间)' ,
`expire_unit`  varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '退换票时间单位（1小时 2天）' ,
`return_type`  varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '1' COMMENT '退票是否扣款（1不扣款 2扣款）' ,
`return_deduct_type`  varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '退票扣款方式（1固定金额，2产品零售价比例）' ,
`return_deduct_quantity`  int(10) NULL DEFAULT 0 COMMENT '退票扣除数量' ,
`change_type`  varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '1' COMMENT '换票是否扣款（1不扣款 2扣款）' ,
`change_deduct_type`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '1' COMMENT '换票扣款方式（1固定金额，2产品零售价比例）' ,
`change_deduct_quantity`  int(10) NULL DEFAULT NULL COMMENT '换票扣除数量' ,
`flag`  varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`supplier_id`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='退换票规则'

;

-- ----------------------------
-- Table structure for `product_group_relation`
-- ----------------------------
DROP TABLE IF EXISTS `product_group_relation`;
CREATE TABLE `product_group_relation` (
`id`  bigint(20) NOT NULL ,
`package_product_id`  bigint(20) NULL DEFAULT NULL COMMENT '组合产品id' ,
`rel_product_id`  bigint(20) NULL DEFAULT NULL COMMENT '关联产品id' ,
`supplier_id`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='产品组合关系表'

;

-- ----------------------------
-- Table structure for `product_info`
-- ----------------------------
DROP TABLE IF EXISTS `product_info`;
CREATE TABLE `product_info` (
`id`  bigint(20) NOT NULL ,
`name`  varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注名称' ,
`product_type`  int(11) NULL DEFAULT NULL COMMENT '产品类别1，普通 ，2，剧场 3，定向返利产品 ，4，普通票联票子票5，积分票联票子票' ,
`release_thurl`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '缩略图' ,
`start_time`  varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '开始时间' ,
`end_time`  varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '结束时间' ,
`product_no`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '内部序号' ,
`minutes_node`  int(2) NULL DEFAULT NULL ,
`hour_node`  int(2) NULL DEFAULT NULL COMMENT '当日时间节点' ,
`product_sum_repertory`  int(8) NULL DEFAULT NULL COMMENT '总库存' ,
`product_usable_repertory`  int(8) NULL DEFAULT NULL COMMENT '可用库存' ,
`create_by`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`create_date`  datetime NULL DEFAULT NULL ,
`update_by`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`update_date`  datetime NULL DEFAULT NULL ,
`sort`  int(11) NULL DEFAULT NULL COMMENT '排序' ,
`flag`  char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '使用状态1启用0禁用2删除' ,
`remarks`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '介绍' ,
`combination_name`  varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '组合名称' ,
`combination_code`  varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '组合产品编号' ,
`reease_message`  varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '短信模板' ,
`reease_info`  varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '产品介绍' ,
`supplier_id`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='产品信息表'

;

-- ----------------------------
-- Table structure for `product_package`
-- ----------------------------
DROP TABLE IF EXISTS `product_package`;
CREATE TABLE `product_package` (
`id`  bigint(20) NOT NULL ,
`name`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '子票名称' ,
`sub_rebate_rule`  varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联票子票返利规则，所有规则都存到本字段中' ,
`package_type`  int(1) NULL DEFAULT NULL COMMENT '子票类型（1普通票 2积分票）' ,
`status`  int(1) NULL DEFAULT 0 COMMENT '状态（1启用0禁用2删除）' ,
`create_by`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`create_date`  datetime NULL DEFAULT NULL ,
`update_by`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`update_date`  datetime NULL DEFAULT NULL ,
`product_id`  bigint(20) NULL DEFAULT NULL COMMENT '产品id' ,
`supplier_id`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='联票子票主表'

;

-- ----------------------------
-- Table structure for `product_package_sub`
-- ----------------------------
DROP TABLE IF EXISTS `product_package_sub`;
CREATE TABLE `product_package_sub` (
`id`  bigint(20) NOT NULL ,
`rebate_type`  int(1) NULL DEFAULT 1 COMMENT '返利方式（1现金 2积分）' ,
`scenic_cnt`  int(10) NULL DEFAULT 0 COMMENT '关联景区数量' ,
`rebate_sum`  double(10,2) NULL DEFAULT 0.00 COMMENT '返利金额/积分' ,
`points_type`  int(1) NULL DEFAULT NULL COMMENT '积分类型' ,
`remarks`  varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`package_id`  bigint(20) NULL DEFAULT 0 COMMENT '联票子票id' ,
`supplier_id`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='联票子票从表'

;

-- ----------------------------
-- Table structure for `product_rebate_rule`
-- ----------------------------
DROP TABLE IF EXISTS `product_rebate_rule`;
CREATE TABLE `product_rebate_rule` (
`id`  bigint(20) NOT NULL ,
`name`  varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称' ,
`product_id`  bigint(20) NULL DEFAULT NULL COMMENT '产品（子票）id' ,
`product_name`  varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`flag`  char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`create_date`  datetime NULL DEFAULT NULL ,
`create_by`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`match_cnt`  int(3) NULL DEFAULT NULL COMMENT '期望配对书' ,
`auditStatus`  varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '审核状态' ,
`supplier_id`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='加点返产品'

;

-- ----------------------------
-- Table structure for `product_rebate_rule_relation`
-- ----------------------------
DROP TABLE IF EXISTS `product_rebate_rule_relation`;
CREATE TABLE `product_rebate_rule_relation` (
`preposition_supplier_id`  bigint(20) NULL DEFAULT NULL COMMENT '前置景区产品所属的供应商id' ,
`preposition_product_id`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '前置景区产品id' ,
`rebate_rule_id`  bigint(20) NULL DEFAULT NULL COMMENT '加点返id' ,
`flag`  varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '状态' ,
`id`  bigint(20) NOT NULL DEFAULT 0 ,
`supplier_id`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '供应商id' ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='加点返产品关联'

;

-- ----------------------------
-- Table structure for `product_relation`
-- ----------------------------
DROP TABLE IF EXISTS `product_relation`;
CREATE TABLE `product_relation` (
`id`  bigint(20) NOT NULL ,
`obj_id`  bigint(64) NOT NULL COMMENT '对象id' ,
`obj_type`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`rel_id`  bigint(64) NOT NULL COMMENT '关联id' ,
`rel_type`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '关联类型，以表名作为类型' ,
`create_by`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`create_date`  datetime NULL DEFAULT NULL ,
`update_by`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`update_date`  datetime NULL DEFAULT NULL ,
`sort`  int(11) NULL DEFAULT 0 COMMENT '排序' ,
`flag`  char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '1' COMMENT '使用状态1启用0禁用2删除' ,
`remarks`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '字段信息' ,
`group_code`  varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '一组数据的标识' ,
`supplier_id`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='产品关系表'

;

-- ----------------------------
-- Table structure for `product_release`
-- ----------------------------
DROP TABLE IF EXISTS `product_release`;
CREATE TABLE `product_release` (
`id`  bigint(20) NOT NULL ,
`name`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`product_id`  bigint(20) NOT NULL COMMENT '产品id' ,
`roduct_no`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '发布内部序号\n' ,
`product_code`  varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '产品code' ,
`product_price`  double(7,2) NULL DEFAULT NULL COMMENT '发布价格' ,
`product_type`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '产品类型(票型)' ,
`product_kind`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '产品种类（票种）线上线下' ,
`product_classify`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '产品分类（票品） 团散' ,
`product_channel`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '渠道来源(比如客栈渠道来源)' ,
`region`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '剧场区域' ,
`ronda`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '剧场场次' ,
`create_by`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`create_date`  datetime NULL DEFAULT NULL ,
`update_by`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`update_date`  datetime NULL DEFAULT NULL ,
`sort`  int(11) NULL DEFAULT NULL COMMENT '排序' ,
`flag`  char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '使用状态1启用0禁用2删除' ,
`remarks`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '介绍' ,
`auditStatus`  varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '5' COMMENT '审核状态' ,
`pro_category`  varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '产品类别1，普通 ，2，剧场 3，定向返利产品积分产品，4，普通票联票子票5，积分票联票子票，6，组合票，7：演艺联票子票' ,
`reason`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '拒绝理由' ,
`supplier_id`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '供应商' ,
`package_status`  varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '1' COMMENT '联票子票状态（1未生成 2已生成）' ,
`checkIn_type`  varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '2' COMMENT '（1团进团出 2非团进团出）' ,
`is_composed` TINYINT(1) NULL DEFAULT NULL COMMENT '当前如果是子票，则是否被组合过，1：是，0否。',
`compose_mark` VARCHAR(100) NULL COMMENT '存放组合标记。因为多个子票期望互相关联，它们之前的条件互相匹配（互相有供应商），可以视为是共同的特质。',
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='产品发布关系（产品）子表'

;

-- ----------------------------
-- Table structure for `product_sales_tool`
-- ----------------------------
DROP TABLE IF EXISTS `product_sales_tool`;
CREATE TABLE `product_sales_tool` (
`id`  bigint(20) NOT NULL COMMENT '自增id' ,
`p_dict`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '工具类型（p_dict=2表示员工微店）' ,
`tool_name`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '工具名称' ,
`wechat_uid`  bigint(20) NULL DEFAULT NULL COMMENT '微信用户\n' ,
`wechat_account`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '微信账户' ,
`wechat_passwd`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '账户密码' ,
`self_service_address`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '自动售货机地址' ,
`self_service_ip`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '自动售货机ip' ,
`self_service_key`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '自动售货机key' ,
`dimension_code_address`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '二维码地址' ,
`create_by`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`create_date`  datetime NULL DEFAULT NULL ,
`update_by`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`update_date`  datetime NULL DEFAULT NULL ,
`remarks`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注' ,
`flag`  char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '状态1启用0禁用2删除' ,
`supplier_id`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='直销工具'

;

-- ----------------------------
-- Table structure for `product_scenic`
-- ----------------------------
DROP TABLE IF EXISTS `product_scenic`;
CREATE TABLE `product_scenic` (
`id`  bigint(20) NOT NULL COMMENT 'id\r\n            ' ,
`code`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '编码（预留）' ,
`name`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '供应商名称' ,
`province`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '省   ' ,
`city`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '市' ,
`county`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '县' ,
`grade`  int(1) NULL DEFAULT NULL COMMENT '景区等级（字典）' ,
`checkin_type`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '检票方式（字典）多选' ,
`address`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`show_num`  varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '演出场次，类型为剧场时用到' ,
`theater_zone`  varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '剧场分区，类型为剧场时用到' ,
`info`  varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '供应商介绍' ,
`img_url`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片资料' ,
`view_url`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '视频资料' ,
`data_url`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文字资料' ,
`create_by`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`create_date`  datetime NULL DEFAULT NULL ,
`update_by`  char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`update_date`  datetime NULL DEFAULT NULL ,
`sort`  tinyint(4) NULL DEFAULT NULL COMMENT '排序' ,
`status`  int(1) NULL DEFAULT 0 COMMENT '状态（1启用0禁用2删除）' ,
`type`  int(1) NULL DEFAULT NULL COMMENT '类型（1景区 2剧场）' ,
`source`  varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '表示属于哪个平台' ,
`supplier_id`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '本条记录所属供应商id' ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='景区表'

;

-- ----------------------------
-- Table structure for `product_scenic_relation`
-- ----------------------------
DROP TABLE IF EXISTS `product_scenic_relation`;
CREATE TABLE `product_scenic_relation` (
`id`  bigint(20) NOT NULL ,
`scenicId`  bigint(20) NULL DEFAULT NULL COMMENT '景区id' ,
`rel_id`  bigint(20) NULL DEFAULT NULL COMMENT '关联对象id' ,
`rel_type`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '关联对象类型，scenic其他景区，suppiler供应商' ,
`supplier_id`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`target_supplier_id`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '期望关联供应商id' ,
PRIMARY KEY (`id`),
INDEX `rel_index` (`rel_id`) USING BTREE ,
INDEX `scenicid_index` (`scenicId`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='景区关系表'

;

-- ----------------------------
-- Table structure for `product_site_data`
-- ----------------------------
DROP TABLE IF EXISTS `product_site_data`;
CREATE TABLE `product_site_data` (
`id`  bigint(20) NOT NULL ,
`sd_name`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '点位名称' ,
`check_count`  int(11) NULL DEFAULT NULL COMMENT '检票使用次数' ,
`equipment_code`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '设备编号' ,
`equipment_key`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '设备key' ,
`create_by`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`create_date`  datetime NULL DEFAULT NULL COMMENT '创建时间' ,
`update_by`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`update_date`  datetime NULL DEFAULT NULL COMMENT '修改时间' ,
`sort`  int(11) NULL DEFAULT 0 COMMENT '排序' ,
`sd_flag`  char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '1' COMMENT '状态 0禁用 1开启 2删除' ,
`sd_info`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '点位信息' ,
`type`  char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '检票设备类型 1手持设备 2台式设备 3闸机' ,
`dataType`  char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '1' COMMENT '数据类型 1检票点 2售票点 3检票设备' ,
`belong`  varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所属景区' ,
`parent_id`  bigint(20) NULL DEFAULT 0 COMMENT '检票设备时，保存检票点id' ,
`scenic_id`  bigint(20) NULL DEFAULT 0 COMMENT '景区id' ,
`suppiler_id`  bigint(20) NULL DEFAULT 0 COMMENT '供应商id' ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='点位表包含：检票点，检票点设备，售票点'

;

-- ----------------------------
-- Table structure for `sys_area`
-- ----------------------------
DROP TABLE IF EXISTS `sys_area`;
CREATE TABLE `sys_area` (
`id`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '编号' ,
`parent_id`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '父级编号' ,
`parent_ids`  varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '所有父级编号' ,
`code`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '区域编码' ,
`name`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '区域名称' ,
`type`  char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '区域类型' ,
`create_by`  varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建者' ,
`create_date`  datetime NULL DEFAULT NULL COMMENT '创建时间' ,
`update_by`  varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新者' ,
`update_date`  datetime NULL DEFAULT NULL COMMENT '更新时间' ,
`remarks`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注信息' ,
`del_flag`  char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '删除标记' ,
PRIMARY KEY (`id`),
INDEX `sys_area_parent_id` (`parent_id`) USING BTREE ,
INDEX `sys_area_del_flag` (`del_flag`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='区域表'

;

-- ----------------------------
-- Table structure for `sys_channel`
-- ----------------------------
DROP TABLE IF EXISTS `sys_channel`;
CREATE TABLE `sys_channel` (
`id`  bigint(20) NOT NULL ,
`name`  varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '渠道名称' ,
`channel_principal`  varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '渠道负责人' ,
`city`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '市' ,
`county`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '县' ,
`province`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '省' ,
`spell`  varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`create_date`  datetime NULL DEFAULT NULL ,
`del_flag`  char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '1' COMMENT '使用状态1启用0禁用2删除' ,
`sort`  int(11) NULL DEFAULT 0 COMMENT '排序' ,
`update_date`  datetime NULL DEFAULT NULL ,
`update_by`  varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`create_by`  varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`remark`  varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注' ,
`channel_type`  char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '渠道类型' ,
`channel_category`  char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '分销渠道类别' ,
`data_source`  varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '数据来源' ,
`supplier_id`  bigint(20) NULL DEFAULT NULL COMMENT '创建供应商' ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='渠道表'

;

-- ----------------------------
-- Table structure for `sys_channel_strategy`
-- ----------------------------
DROP TABLE IF EXISTS `sys_channel_strategy`;
CREATE TABLE `sys_channel_strategy` (
`id`  bigint(20) NOT NULL ,
`name`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '政策名称' ,
`remark`  varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注' ,
`price`  double(10,2) NULL DEFAULT 0.00 COMMENT '渠道价' ,
`quantity`  int(10) NULL DEFAULT 0 COMMENT '购买数量' ,
`begin_date`  date NULL DEFAULT NULL COMMENT '政策起始时间' ,
`end_date`  date NULL DEFAULT NULL COMMENT '政策结束时间' ,
`pre_sale`  int(10) NULL DEFAULT 0 COMMENT '预售天数' ,
`pre_sale_mode`  tinyint(1) NULL DEFAULT 1 COMMENT '预售计时方式（1小时，2日）' ,
`expire`  int(10) NULL DEFAULT 0 COMMENT '有效期天数' ,
`expire_mode`  tinyint(1) NULL DEFAULT 0 COMMENT '有效期计时方式（1小时，2日）' ,
`scope`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '适用范围、可多选(1周一 2周二 3周三 4周四 5周五 6周六 7周日)' ,
`status`  tinyint(1) NULL DEFAULT 1 COMMENT '状态（1启用 0停用）' ,
`create_date`  datetime NULL DEFAULT NULL COMMENT '创建时间' ,
`create_by`  varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人' ,
`update_date`  datetime NULL DEFAULT NULL COMMENT '更新时间' ,
`update_by`  varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人' ,
`type`  char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '渠道政策类型1直销2分销' ,
`del_flag`  char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '删除标记：删除' ,
`publish_date`  date NULL DEFAULT NULL COMMENT '发布时间' ,
`data_source`  varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '数据来源' ,
`publish_by`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '发布人' ,
`publish_status`  tinyint(1) NULL DEFAULT 0 COMMENT '发布状态 1:已发布 0:未发布' ,
`dict_value`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '直销渠道数据字典' ,
`is_open_multi_rebate`  char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否开启多级返利 ' ,
`supplier_id`  bigint(20) NULL DEFAULT NULL COMMENT '创建供应商' ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='渠道政策表'

;

-- ----------------------------
-- Table structure for `sys_extra_rebate_strategy`
-- ----------------------------
DROP TABLE IF EXISTS `sys_extra_rebate_strategy`;
CREATE TABLE `sys_extra_rebate_strategy` (
`id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID' ,
`rebate_object`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '返利对象(总社H、地接部门D、优先部门DH、导游G)' ,
`rebate_cycle`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '返利周期(YEAR/MONTH/WEEK/DAY/CURRENT)' ,
`rebate_amount`  double NULL DEFAULT 0 COMMENT '返利金额(每人)' ,
`rebate_type`  int(11) NULL DEFAULT 2 COMMENT '返利形式(0为现金返利，1为按票返利，2返利积分)' ,
`status`  int(11) NULL DEFAULT 1 COMMENT '规则状态（1：启动、 0 ：禁用   2: 删除）参照GlobalParam.FLAG' ,
`integral_id`  bigint(20) NULL DEFAULT NULL COMMENT '积分类型ID' ,
`integral_value`  int(11) NULL DEFAULT 0 COMMENT '返利积分数量' ,
`front_rebate_rule_id`  bigint(20) NULL DEFAULT NULL COMMENT '前置返利规则ID' ,
`front_product_id`  bigint(20) NULL DEFAULT NULL COMMENT '前置产品ID' ,
`validity_period`  int(11) NULL DEFAULT NULL COMMENT '时效（单位：小时）' ,
`create_by`  varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人' ,
`create_time`  datetime NULL DEFAULT NULL COMMENT '创建时间' ,
`update_by`  varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人' ,
`updata_date`  datetime NULL DEFAULT NULL COMMENT '更新时间' ,
`p_version`  varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '数据来源' ,
`validity_type`  int(11) NULL DEFAULT NULL COMMENT '时效类型：0小时，1天<对比后加>' ,
`extra_rebate_name`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '加点返利名称<对比后加>' ,
`rebate_status`  int(11) NULL DEFAULT 0 COMMENT '0:有效，1：无效<对比后加>' ,
`supplier_id`  bigint(20) NULL DEFAULT NULL COMMENT '创建供应商' ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='加点返利规则表渠道'
AUTO_INCREMENT=13

;

-- ----------------------------
-- Table structure for `sys_label`
-- ----------------------------
DROP TABLE IF EXISTS `sys_label`;
CREATE TABLE `sys_label` (
`id`  bigint(20) NOT NULL ,
`name`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标签名称' ,
`pid`  bigint(20) NULL DEFAULT 0 COMMENT '父id，0表示标签分类' ,
`create_date`  datetime NULL DEFAULT NULL ,
`flag`  char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '使用状态1启用0禁用2删除3已生成联票4未生成联票' ,
`sort`  int(11) NULL DEFAULT NULL COMMENT '排序' ,
`update_date`  datetime NULL DEFAULT NULL ,
`update_by`  varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`create_by`  varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`remarks`  varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`data_source`  varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='渠道标签表'

;

-- ----------------------------
-- Table structure for `sys_label_relation`
-- ----------------------------
DROP TABLE IF EXISTS `sys_label_relation`;
CREATE TABLE `sys_label_relation` (
`id`  bigint(20) NOT NULL ,
`obj_id`  bigint(20) NULL DEFAULT NULL COMMENT '主对象id' ,
`rel_id`  bigint(20) NULL DEFAULT NULL COMMENT '关联对象id' ,
`rel_type`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '对象关联标签类型' ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='渠道关系表'

;

-- ----------------------------
-- Table structure for `sys_log`
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log` (
`id`  bigint(20) NOT NULL COMMENT '编号' ,
`type`  char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '1' COMMENT '日志类型' ,
`create_by`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建者' ,
`create_id`  bigint(20) NULL DEFAULT NULL COMMENT '创建者id' ,
`create_date`  datetime NULL DEFAULT NULL COMMENT '创建时间' ,
`remote_addr`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作IP地址' ,
`user_agent`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户代理' ,
`request_uri`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '请求URI' ,
`method`  varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作方式' ,
`params`  text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '操作提交的数据' ,
`exception`  text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '异常信息' ,
`data_source`  varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '系统来源' ,
`position`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作岗位' ,
`telephone`  varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话' ,
`client`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作客户端' ,
PRIMARY KEY (`id`),
INDEX `sys_log_create_by` (`create_by`) USING BTREE ,
INDEX `sys_log_request_uri` (`request_uri`) USING BTREE ,
INDEX `sys_log_type` (`type`) USING BTREE ,
INDEX `sys_log_create_date` (`create_date`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='日志表'

;

-- ----------------------------
-- Table structure for `sys_menu`
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
`id`  bigint(20) NOT NULL COMMENT '编号' ,
`parent_id`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '父级编号' ,
`parent_ids`  varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '所有父级编号' ,
`name`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '菜单名称' ,
`href`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '链接' ,
`target`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '目标' ,
`icon`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图标' ,
`sort`  int(11) NOT NULL COMMENT '排序（升序）' ,
`is_show`  char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '是否在菜单中显示' ,
`is_activiti`  char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否同步工作流' ,
`permission`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限标识' ,
`create_by`  varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建者' ,
`create_date`  datetime NULL DEFAULT NULL COMMENT '创建时间' ,
`update_by`  varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新者' ,
`update_date`  datetime NULL DEFAULT NULL COMMENT '更新时间' ,
`remarks`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注信息' ,
`del_flag`  char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '0' COMMENT '删除标记1：删除' ,
`position`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '位置' ,
`style`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '样式' ,
`data_source`  varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '数据来源' ,
`supplier_id`  bigint(20) NULL DEFAULT NULL COMMENT '供应商ID（用于保存各运行系统用户所属根供应商ID）' ,
PRIMARY KEY (`id`),
INDEX `sys_menu_parent_id` (`parent_id`) USING BTREE ,
INDEX `sys_menu_del_flag` (`del_flag`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='菜单表'

;

-- ----------------------------
-- Table structure for `sys_office`
-- ----------------------------
DROP TABLE IF EXISTS `sys_office`;
CREATE TABLE `sys_office` (
`id`  bigint(20) NOT NULL COMMENT '编号' ,
`parent_id`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '父级编号' ,
`parent_ids`  varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '所有父级编号' ,
`area_id`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '归属区域' ,
`code`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '区域编码' ,
`name`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '机构名称' ,
`type`  char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '机构类型' ,
`grade`  char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '机构等级' ,
`address`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系地址' ,
`zip_code`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮政编码' ,
`master`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '负责人' ,
`phone`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话' ,
`fax`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '传真' ,
`email`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱' ,
`create_by`  varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建者' ,
`create_date`  datetime NULL DEFAULT NULL COMMENT '创建时间' ,
`update_by`  varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新者' ,
`update_date`  datetime NULL DEFAULT NULL COMMENT '更新时间' ,
`remarks`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注信息' ,
`del_flag`  char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '0' COMMENT '删除标记1：删除' ,
`business_name`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`business_person`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`business_address`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`business_telephone`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`business_id`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`audit_status`  varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`reason_rejection`  varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`data_source`  varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`supplier_id`  bigint(20) NULL DEFAULT NULL COMMENT '供应商ID（用于保存各运行系统用户所属根供应商ID）' ,
PRIMARY KEY (`id`),
INDEX `sys_office_parent_id` (`parent_id`) USING BTREE ,
INDEX `sys_office_del_flag` (`del_flag`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='机构表'

;

-- ----------------------------
-- Table structure for `sys_office_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_office_role`;
CREATE TABLE `sys_office_role` (
`id`  bigint(20) NOT NULL ,
`office_id`  varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`role_id`  varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`id`),
UNIQUE INDEX `id_UNIQUE` (`id`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Table structure for `sys_rebate_strategy`
-- ----------------------------
DROP TABLE IF EXISTS `sys_rebate_strategy`;
CREATE TABLE `sys_rebate_strategy` (
`id`  bigint(20) NOT NULL AUTO_INCREMENT ,
`scene_id`  bigint(20) NULL DEFAULT NULL COMMENT '景区ID' ,
`product_id`  bigint(20) NULL DEFAULT NULL COMMENT '产品ID（返利票种ID）' ,
`product_name`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '产品名称（返利票种）' ,
`rebate_price`  double NULL DEFAULT 0 COMMENT '返利价格' ,
`rebate_object`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '返利对象返利对象(总社H、地接部门D、优先部门DH、导游G)' ,
`rebate_cycle_type`  int(11) NULL DEFAULT NULL COMMENT '返利周期类型' ,
`rebate_cycle`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '返利周期(YEAR/MONTH/WEEK/DAY/CURRENT)' ,
`rebate_cycle_value`  int(11) NULL DEFAULT 0 COMMENT '线上返利周期数' ,
`rebate_per_month`  int(11) NULL DEFAULT NULL COMMENT '返利固定月' ,
`rebate_settlement`  int(11) NULL DEFAULT NULL COMMENT '结算方式（即时返/周期返）' ,
`rebate_amount`  double NULL DEFAULT 0 COMMENT '返利金额(每人)' ,
`rebate_type`  int(11) NULL DEFAULT 1 COMMENT '返利形式(0为现金返利，1为按票返利，2返利积分)' ,
`status`  int(11) NULL DEFAULT NULL COMMENT '规则状态（1：启动、 0 ：禁用   2: 删除）参照GlobalParam.FLAG' ,
`type`  int(11) NULL DEFAULT 2 COMMENT '返利类型（1 前置， 2， 后置    默认2）' ,
`p_version`  int(11) NULL DEFAULT NULL COMMENT '所属平台' ,
`supplier_id`  bigint(20) NULL DEFAULT NULL COMMENT '创建供应商' ,
`integral_id`  bigint(20) NULL DEFAULT NULL COMMENT '积分类型ID' ,
`integral_value`  int(11) NULL DEFAULT NULL COMMENT '返利积分数量' ,
`create_by`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人' ,
`create_time`  datetime NULL DEFAULT NULL COMMENT '创建时间' ,
`update_by`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改人' ,
`update_date`  datetime NULL DEFAULT NULL COMMENT '修改时间' ,
`data_source`  varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '数据来源' ,
`is_extra_rebate`  int(1) NULL DEFAULT 0 COMMENT '是否存在加点返利(0否，1是)' ,
`rebate_product_id`  bigint(255) NULL DEFAULT NULL COMMENT '返利票种ID<对比后加>' ,
`rebate_product_name`  varchar(36) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '返利折票产品名称（返利折票票种）<对比后加>' ,
`rebate_conditions`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '返利条件描述<对比后加>' ,
`is_online`  int(1) NULL DEFAULT 0 COMMENT '是否线上(0是线下，1是线上)<对比后加，有用>' ,
`from_type`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单来源<对比后加>' ,
`reseller_supplier_id`  bigint(20) NULL DEFAULT NULL COMMENT '分销商所属的供应商id<对比后加>' ,
`front_rebate_rule_id`  bigint(20) NULL DEFAULT NULL COMMENT '前置返利规则ID<对比后加>' ,
`rebate_rule_type`  int(11) NULL DEFAULT 0 COMMENT '返利规则类型(0 普通返利； 1 加点返利)<对比后加>' ,
`front_product_id`  bigint(20) NULL DEFAULT NULL COMMENT '前置产品ID<对比后加>' ,
`validity_period`  int(11) NULL DEFAULT NULL COMMENT '时效<对比后加>' ,
PRIMARY KEY (`id`),
UNIQUE INDEX `idnew_table_UNIQUE` (`id`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='渠道返利规则'
AUTO_INCREMENT=264

;

-- ----------------------------
-- Table structure for `sys_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
`id`  bigint(20) NOT NULL COMMENT '编号' ,
`name`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色名称' ,
`type`  varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色类型' ,
`data_scope`  char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '数据范围/角色级别' ,
`create_by`  varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建者' ,
`create_date`  datetime NULL DEFAULT NULL COMMENT '创建时间' ,
`update_by`  varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新者' ,
`update_date`  datetime NULL DEFAULT NULL COMMENT '更新时间' ,
`remarks`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注信息' ,
`del_flag`  char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '0' COMMENT '删除标记1：删除' ,
`data_source`  varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '数据来源' ,
`is_bingding`  int(11) NULL DEFAULT NULL ,
`supplier_id`  bigint(20) NULL DEFAULT NULL COMMENT '供应商ID（用于保存各运行系统用户所属根供应商ID）' ,
PRIMARY KEY (`id`),
INDEX `sys_role_del_flag` (`del_flag`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='角色表'

;

-- ----------------------------
-- Table structure for `sys_role_menu`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
`id`  bigint(20) NOT NULL ,
`role_id`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色编号' ,
`menu_id`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '菜单编号' ,
PRIMARY KEY (`id`),
UNIQUE INDEX `id_UNIQUE` (`id`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='角色-菜单'

;

-- ----------------------------
-- Table structure for `sys_role_office_user`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_office_user`;
CREATE TABLE `sys_role_office_user` (
`id`  bigint(20) NOT NULL ,
`role_id`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色编号' ,
`office_id`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '机构编号' ,
`user_id`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户主键ID' ,
`rel_type`  varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`id`),
UNIQUE INDEX `id_UNIQUE` (`id`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='角色-机构'

;

-- ----------------------------
-- Table structure for `sys_spcre_relation`
-- ----------------------------
DROP TABLE IF EXISTS `sys_spcre_relation`;
CREATE TABLE `sys_spcre_relation` (
`id`  bigint(20) NOT NULL COMMENT '主键Id' ,
`strategy_id`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '政策ID' ,
`product_id`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '产品ID' ,
`channel_id`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '渠道ID' ,
`rebate_id`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '返利ID' ,
`extra_rebate_id`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '加点返利ID' ,
`status`  char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '0' COMMENT '是否通过 1：是 0：否' ,
`refuse_reason`  varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '拒绝理由' ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='渠道政策产品及返利规则对应表'

;

-- ----------------------------
-- Table structure for `sys_user`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
`id`  bigint(20) NOT NULL ,
`supplier_id`  bigint(20) NULL DEFAULT NULL COMMENT '供应商ID（用于保存各运行系统用户所属根供应商ID）' ,
`login_name`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '登陆名称' ,
`login_passwd`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '登陆密码' ,
`sys_code`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户编号' ,
`user_type`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户类型' ,
`oper_charger_mobile`  varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号' ,
`oper_charger_phone`  varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话' ,
`oper_charger_fax`  varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '传真' ,
`oper_charger_email`  varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱' ,
`last_login_time`  datetime NULL DEFAULT NULL COMMENT '最后登陆时间' ,
`last_login_ip`  varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最后登陆ip' ,
`account_state`  int(2) NULL DEFAULT NULL COMMENT '用户状态 1 正常、0禁用,2删除' ,
`create_date`  datetime NULL DEFAULT NULL COMMENT '创建时间' ,
`office_id`  char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门id' ,
`company_id`  bigint(20) NULL DEFAULT NULL COMMENT '公司id' ,
`parent_id`  bigint(20) NULL DEFAULT NULL COMMENT '父类id' ,
`wx_openid`  varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '微信绑定账号' ,
`login_source`  int(2) NULL DEFAULT NULL COMMENT '1:平台；2:手机APP；3:手机和平台 登陆来源' ,
`name`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '结构名称\n' ,
`reseller_type`  varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '分销商类型' ,
`is_buygroup`  int(2) NULL DEFAULT NULL COMMENT '1:是0:否 是否团购' ,
`is_buysingle`  int(2) NULL DEFAULT NULL COMMENT '1:是0:否 是否散票' ,
`reseller_level`  int(2) NULL DEFAULT NULL COMMENT '分销商等级' ,
`province`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '省' ,
`city`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '市' ,
`county`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '县' ,
`corporater`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '法人名称' ,
`credentials_type`  int(2) NULL DEFAULT NULL COMMENT '1、居民身份证2、护照3、军人证 证件类型' ,
`corporater_credentials`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '证件号' ,
`corporater_mobile`  varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '法人手机' ,
`corporater_phone`  varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '法人电话' ,
`corporater_email`  varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '法人邮箱' ,
`business_certificate`  varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '经营许可证' ,
`business_license`  varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '营业执照' ,
`org_code_certificate`  varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '机构代码证' ,
`tax_certificate`  varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '税务登记证' ,
`other_files`  varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '其他资料' ,
`address`  varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '分销商地址' ,
`reseller_state`  int(2) NULL DEFAULT NULL COMMENT '1申请2通过3拒绝4补材料-1,失效 分销商状态' ,
`request_date`  datetime NULL DEFAULT NULL COMMENT '分销商申请日期' ,
`approve_date`  datetime NULL DEFAULT NULL COMMENT '分销商批准日期' ,
`approve_result`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '审核结构' ,
`contract_num`  varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '合同号' ,
`description`  varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '分销商描述' ,
`wx_open_flag`  int(2) NULL DEFAULT NULL COMMENT '0否1是 是否可以开微店' ,
`isCReseller`  int(2) NULL DEFAULT NULL COMMENT ' 0为否 1为是 默认为0 是否为c商' ,
`about_us`  varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '关于' ,
`contact_way`  varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系方式' ,
`reseller_phonetic_shorthand`  varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '分销商拼写' ,
`supplier_level`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '默认AAAAA 供应商级别' ,
`is_manage`  int(2) NULL DEFAULT NULL COMMENT '1:是0:否 是否被上级供应商管理' ,
`other_file`  varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '其他资料1' ,
`other_file2`  varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '其他资料2' ,
`supplier_address`  varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '供应商地址\n景区发票地址，客栈地址' ,
`supplier_state`  int(2) NULL DEFAULT NULL COMMENT '1申请2通过3拒绝4补材料-1,失效' ,
`supplier_description`  varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '供应商介绍' ,
`supplier_py`  varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '拼音缩写' ,
`supplier_normal`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '俗称' ,
`supplier_discount_value`  double(5,2) NULL DEFAULT NULL COMMENT '具体扣点数值' ,
`from_date`  date NULL DEFAULT NULL COMMENT '开始结算日期' ,
`period`  int(4) NULL DEFAULT NULL COMMENT '结算周期' ,
`settle_date`  date NULL DEFAULT NULL COMMENT '应结算周期' ,
`contract_remarks`  varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '合同规则' ,
`contract_notes`  varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '合同备注' ,
`verification_codes`  varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '供应商code' ,
`user_source`  varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户来源' ,
`create_by`  varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建用户' ,
`update_by`  varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新用户' ,
`update_date`  datetime NULL DEFAULT NULL COMMENT '更新时间' ,
`sort`  int(11) NULL DEFAULT NULL COMMENT '排序' ,
`leader_flag`  int(2) NULL DEFAULT NULL ,
`ticket_rule`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '票规' ,
`sys_usercol`  varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`check_status`  char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '0注册未完成\n1审核通过\n2审核拒绝，重新提交\n3注册完成待审核' ,
`check_user_id` bigint(20) DEFAULT NULL COMMENT '审核用户ID',
`check_user_name` varchar(50) DEFAULT NULL COMMENT '审核用户名称',
`check_date` datetime DEFAULT NULL COMMENT '审核时间',
`reason_rejection`  varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '拒绝理由' ,
`business_license_picture`  varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`business_qualification_picture`  varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`is_root`  char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否是主帐号（1：主帐号，0：子账号）' ,
`root_id`  bigint(20) NULL DEFAULT NULL ,
PRIMARY KEY (`id`),
UNIQUE INDEX `id_UNIQUE` (`id`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='是否是总店长 1.总店长 2店长 3一般员工 '

;

-- ----------------------------
-- Table structure for `sys_user_menu`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_menu`;
CREATE TABLE `sys_user_menu` (
`id`  bigint(20) NOT NULL ,
`menu_id`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`user_id`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
PRIMARY KEY (`id`),
UNIQUE INDEX `id_UNIQUE` (`id`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Table structure for `sys_user_office`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_office`;
CREATE TABLE `sys_user_office` (
`id`  bigint(20) NOT NULL ,
`user_id`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户主键ID' ,
`office_id`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '部门主键ID' ,
PRIMARY KEY (`id`),
UNIQUE INDEX `id_UNIQUE` (`id`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci

;

-- ----------------------------
-- Table structure for `sys_user_relation`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_relation`;
CREATE TABLE `sys_user_relation` (
`id`  bigint(20) NOT NULL DEFAULT 0 ,
`user_id`  bigint(20) NULL DEFAULT NULL COMMENT '供应商id' ,
`rel_user_id`  bigint(20) NULL DEFAULT NULL COMMENT '关联供应商id' ,
`rel_type`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '2' COMMENT '关联类型（1供应商关系，2常用部门）' ,
PRIMARY KEY (`id`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='供应商关系表'

;

-- ----------------------------
-- Table structure for `sys_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
`id`  bigint(20) NOT NULL ,
`user_id`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户编号' ,
`role_id`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色编号' ,
PRIMARY KEY (`id`),
UNIQUE INDEX `id_UNIQUE` (`id`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
COMMENT='用户-角色'

;

-- ----------------------------
-- Auto increment value for `sys_extra_rebate_strategy`
-- ----------------------------
ALTER TABLE `sys_extra_rebate_strategy` AUTO_INCREMENT=13;

-- ----------------------------
-- Auto increment value for `sys_rebate_strategy`
-- ----------------------------
ALTER TABLE `sys_rebate_strategy` AUTO_INCREMENT=264;

-- ---------------------
-- 给用户添加经营资质属性 2016-01-11 16:10
-- ---------------------
ALTER TABLE `sys_user`
ADD COLUMN `business_qualification` VARCHAR(500) NULL COMMENT '经营资质' AFTER `is_root`;


-- 用户与代理人关联表
CREATE TABLE `sys_user_agent` (
  `id` bigint(20) NOT NULL,
  `userId` bigint(20) NOT NULL COMMENT '用户ID（供应商ID、分销商ID）',
  `agentId` bigint(20) NOT NULL COMMENT '代理商ID（也是用户ID）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户与代理商关系';

