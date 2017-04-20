ALTER TABLE `product_release` ADD COLUMN `check_user_id` BIGINT(20)NULL COMMENT '审核产品ID';
ALTER TABLE `product_release` ADD COLUMN `check_user_name` VARCHAR(50)NULL COMMENT '审核用户名称';
ALTER TABLE `product_release` ADD COLUMN `check_date` DATE NULL COMMENT '审核时间';