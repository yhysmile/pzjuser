ALTER TABLE `sys_channel_strategy`
ADD COLUMN `sub_product_id` BIGINT(20) NULL COMMENT '联票子产品id' AFTER `supplier_id`;
