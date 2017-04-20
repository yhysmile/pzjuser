-- ---------------------
-- 给子票添加零售价、魔方价 2016-01-21 11:24
-- ---------------------
ALTER TABLE `product_release`
ADD COLUMN `retail_price` DOUBLE(7,2) NULL COMMENT '零售价',
ADD COLUMN `mf_price` DOUBLE(7,2) NULL COMMENT '魔方价';
