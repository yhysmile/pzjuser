ALTER TABLE `product_release`

ADD COLUMN `twice_sure`  varchar(2) NULL COMMENT '是否二次确认 1是，0否 ' AFTER `package_discount`,
ADD COLUMN `latest_preset`  varchar(2) NULL COMMENT '最晚预定设置  0不设置，1最晚预定时间' AFTER `twice_sure`,
ADD COLUMN `latest_preset_days`  int(5) NULL COMMENT '最晚预定设置 提前天数' AFTER `latest_preset`,
ADD COLUMN `latest_preset_time`  varchar(10) NULL COMMENT '最晚预定设置 预定时间' AFTER `latest_preset_days`,
ADD COLUMN `province`  varchar(100) NULL COMMENT '省' AFTER `latest_preset_time`,
ADD COLUMN `city`  varchar(100) NULL COMMENT '市' AFTER `province`,
ADD COLUMN `county`  varchar(100) NULL COMMENT '县' AFTER `city`;