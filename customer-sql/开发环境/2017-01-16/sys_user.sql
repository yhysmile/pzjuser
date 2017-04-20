# 给用户添加保存logo的字段
ALTER TABLE `sys_user`
ADD COLUMN `logo` VARCHAR(32) NULL DEFAULT '' COMMENT '企业logo' AFTER `qualification_audit`;
