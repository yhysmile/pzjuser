ALTER TABLE `product_release` ADD COLUMN `room_type` VARCHAR(50) NULL COMMENT '房型类型';

ALTER TABLE `product_release` MODIFY COLUMN `pro_category` VARCHAR(1) NULL COMMENT '产品类别1，普通 ，2，剧场 3，定向返利产品积分产品，4，普通票联票子票5，积分票联票子票6，组合票，7：演艺联票子票，8：房型';
