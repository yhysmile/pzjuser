ALTER TABLE `sys_rebate_strategy` ADD COLUMN `rebate_rate_type` int(2)NULL COMMENT 'PMS:返利比类型';
ALTER TABLE `sys_rebate_strategy` ADD COLUMN `rebate_rate` DOUBLE(10,2) NULL COMMENT 'PMS:返利比';