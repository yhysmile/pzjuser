ALTER TABLE `sys_channel_strategy`
MODIFY COLUMN `del_flag`  char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '1' COMMENT '删除标记：删除' AFTER `type`;