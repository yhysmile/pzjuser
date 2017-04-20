ALTER TABLE `product_release`
ADD COLUMN `sku_id`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'skuId' AFTER `bedNum`,
ADD COLUMN `category_id`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'sku分类id' AFTER `sku_id`,
ADD COLUMN `inventory`  int(10) NULL DEFAULT NULL COMMENT '库存数量' AFTER `category_id`,
ADD COLUMN `inventory_fk_id`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '动态库存id' AFTER `inventory`,
ADD COLUMN `unlimited_inventory`  tinyint(1) NULL DEFAULT NULL COMMENT '是否是无限库存' AFTER `inventory_fk_id`,
ADD COLUMN `is_simple`  tinyint(1) NULL DEFAULT NULL COMMENT '是否是简单产品' AFTER `unlimited_inventory`,
ADD COLUMN `allocation`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '产品时间类型（天、晚、时分、时间段)' AFTER `is_simple`,
ADD COLUMN `visibility`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '可见权限' AFTER `allocation`,
ADD COLUMN `maintenance_time`  int(11) NULL DEFAULT NULL COMMENT '保留时间' AFTER `visibility`,
ADD COLUMN `price_per`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '计费方式' AFTER `maintenance_time`,
ADD COLUMN `sku_grouping`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'SKU分组类型（父产品、组合产品）' AFTER `price_per`,
ADD COLUMN `location`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地址信(地址或坐标)' AFTER `sku_grouping`,
ADD COLUMN `marker_title`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地图坐标标题' AFTER `location`,
ADD COLUMN `marker_description`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地图坐标描述' AFTER `marker_title`,
ADD COLUMN `marker_link_text`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '窗口链接文本' AFTER `marker_description`,
ADD COLUMN `map_zoom`  int(11) NULL DEFAULT NULL COMMENT '地图缩放级别' AFTER `marker_link_text`,
ADD COLUMN `email_notification`  varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮件通知内容' AFTER `map_zoom`,
ADD COLUMN `more_info_url`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更多信息' AFTER `email_notification`,
ADD COLUMN `video_url`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '视频URL' AFTER `more_info_url`,
ADD COLUMN `video_start_time`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '视频开始播放时间' AFTER `video_url`,
ADD COLUMN `details`  text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '详细信息' AFTER `video_start_time`,
ADD COLUMN `photoinfo_id`  varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片信息列表' AFTER `details`,
ADD COLUMN `dync_prop_id`  varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '动态属性id集合' AFTER `photoinfo_id`,
ADD COLUMN `pkg_id`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '套餐ID' AFTER `dync_prop_id`,
ADD COLUMN `pkg_name`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '套餐名称' AFTER `pkg_id`,
ADD COLUMN `time_slots_id`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '时间属性id' AFTER `pkg_name`,
ADD COLUMN `start_time`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '开始时间' AFTER `time_slots_id`,
ADD COLUMN `end_time`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '结束时间' AFTER `start_time`,
ADD COLUMN `time_length`  double(11,2) NULL DEFAULT NULL COMMENT 'startTime和endTime之间差值（单位与pricePer对应）' AFTER `end_time`,
ADD COLUMN `time_unit`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '长度默认单位（天、晚、时分）' AFTER `time_length`,
ADD COLUMN `attr_info_id`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '价格属性id' AFTER `time_unit`,
ADD COLUMN `default_value`  int(11) NULL DEFAULT NULL COMMENT '默认值' AFTER `attr_info_id`,
ADD COLUMN `has_price`  tinyint(1) NULL DEFAULT NULL COMMENT '是否有价格' AFTER `default_value`,
ADD COLUMN `is_display_range`  tinyint(1) NULL DEFAULT NULL COMMENT '是否显示价格范围' AFTER `has_price`,
ADD COLUMN `is_required`  tinyint(1) NULL DEFAULT NULL COMMENT '是否必选' AFTER `is_display_range`,
ADD COLUMN `sku_params_name`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '参数名称' AFTER `is_required`,
ADD COLUMN `param_is_group`  tinyint(1) NULL DEFAULT NULL COMMENT '基础价格-参数-是否分组' AFTER `sku_params_name`,
ADD COLUMN `min_number`  int(11) NULL DEFAULT NULL COMMENT '基础价格-参数-分组-最小数' AFTER `param_is_group`,
ADD COLUMN `max_number`  int(11) NULL DEFAULT NULL COMMENT '基础价格-参数-分组-最大数' AFTER `min_number`,
ADD COLUMN `schedule_id`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '事件id' AFTER `max_number`,
ADD COLUMN `schedule_name`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '事件名称' AFTER `schedule_id`,
ADD COLUMN `week_available`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '按星期设置' AFTER `schedule_name`,
ADD COLUMN `weights`  int(2) NULL DEFAULT NULL COMMENT '权重' AFTER `week_available`,
ADD COLUMN `start_date`  timestamp NULL DEFAULT NULL COMMENT '适用日期-开始' AFTER `weights`,
ADD COLUMN `end_date`  timestamp NULL DEFAULT NULL COMMENT '适用日期-结束' AFTER `start_date`,
ADD COLUMN `original_price`  double(7,2) NULL DEFAULT NULL COMMENT '原价' AFTER `end_date`,
ADD COLUMN `sku_pkg_id`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '打包关系ID' AFTER `original_price`,
ADD COLUMN `package_type`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '一起买类型（强制、可选）' AFTER `sku_pkg_id`,
ADD COLUMN `package_discount`  double(7,2) NULL DEFAULT NULL COMMENT '一起买时，折扣信息' AFTER `package_type`;