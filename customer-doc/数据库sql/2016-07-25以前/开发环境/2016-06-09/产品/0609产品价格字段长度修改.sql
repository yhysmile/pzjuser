ALTER TABLE `product_release`
MODIFY COLUMN `product_price`  double(10,2) NULL DEFAULT NULL COMMENT '发布价格' AFTER `product_code`,
MODIFY COLUMN `retail_price`  double(10,2) NULL DEFAULT NULL COMMENT '零售价' AFTER `checkIn_type`,
MODIFY COLUMN `mf_price`  double(10,2) NULL DEFAULT NULL COMMENT '魔方价' AFTER `retail_price`,
MODIFY COLUMN `original_price`  double(10,2) NULL DEFAULT NULL COMMENT '原价' AFTER `end_date`;

