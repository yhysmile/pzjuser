-- ---------------------
-- 给产品添加剧场ID 2016-01-26 17:37
-- ---------------------
ALTER TABLE `product_release`
ADD COLUMN `theater_id` BIGINT(20) NULL COMMENT '剧场ID。同region（剧场区域）、ronda（剧场场次）属于相同的业务。';