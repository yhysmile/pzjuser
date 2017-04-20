-- ---------------------
-- 在用户表中增加二维码(two_Dimension_Code)、accountingUnitName、
-- 同时将accountingUnit的字符类型修改为BIGINT类型
-- ---------------------
ALTER TABLE `sys_user`
ADD COLUMN `two_Dimension_Code` VARCHAR(100) NULL COMMENT '二维码';
ADD COLUMN `accountingUnitName` VARCHAR(25) NULL COMMENT '单位名称';
modify column accountingUnit BIGINT(20);
