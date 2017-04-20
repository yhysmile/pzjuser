ALTER TABLE `product_release`
MODIFY COLUMN `remarks`  varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '介绍' AFTER `flag`;

ALTER TABLE `product_release`
CHANGE COLUMN `start_time` `sku_start_time`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '开始时间' AFTER `time_slots_id`,
CHANGE COLUMN `end_time` `sku_end_time`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '结束时间' AFTER `sku_start_time`;

