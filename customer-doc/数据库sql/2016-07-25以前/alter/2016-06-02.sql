-- ---------------------
-- 在渠道关系表中增加s_id,区分渠道的不同来源
-- ---------------------
ALTER TABLE `sys_label_relation`
ADD COLUMN `s_id` VARCHAR(20) NULL COMMENT '渠道供应商ID，用于区分不同的渠道来源';
