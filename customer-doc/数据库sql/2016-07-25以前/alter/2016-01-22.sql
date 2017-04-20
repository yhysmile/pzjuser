-- ---------------------
-- 给子票添加组合票ID 2016-01-22 11:17
-- ---------------------
ALTER TABLE `product_release`
ADD COLUMN `compose_id` BIGINT(20) NULL COMMENT '当产品作为子票时，所属于组合票的ID';
