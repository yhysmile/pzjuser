ALTER TABLE `product_release`
CHANGE COLUMN `pro_category` `pro_category` VARCHAR(1) NULL DEFAULT NULL COMMENT '产品类别1，普通 ，2，剧场 3，定向返利产品积分产品，4，普通票联票子票5，积分票联票子票6，组合票，7：演艺联票子票' ;


ALTER TABLE `product_release`
CHANGE COLUMN `compose_id` `is_composed` TINYINT(1) NULL DEFAULT NULL COMMENT '当前如果是子票，则是否被组合过，1：是，0否。' ;