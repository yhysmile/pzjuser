ALTER TABLE `core_deploment`.`sys_label_relation`
ADD COLUMN `s_id` BIGINT(20) NULL COMMENT '渠道供应商ID，用于区分不同的渠道来源';


-- ---------------------
-- 在用户表中增加二维码(two_Dimension_Code)、accountingUnitName、
-- 同时将accountingUnit的字符类型修改为BIGINT类型
-- ---------------------
ALTER TABLE `sys_user`
ADD COLUMN `two_Dimension_Code` VARCHAR(100) NULL COMMENT '二维码';

ALTER TABLE `core_deploment`.`sys_user`
ADD COLUMN `accountingUnitName` VARCHAR(25) NULL COMMENT '单位名称';

ALTER TABLE `core_deploment`.`sys_user`
modify column accountingUnit BIGINT(20);
