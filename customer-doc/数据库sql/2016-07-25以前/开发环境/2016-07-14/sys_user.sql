-- 添加邀请码、推荐码字段  by 武利庆 2016-07-14
ALTER TABLE `core_deploment`.`sys_user`
ADD COLUMN `invitationCode` VARCHAR(255) NULL COMMENT '邀请码、推荐码' AFTER `AccountingUnitName`;




-- 在用户与角色关系中添加dataSource，用于区分不同平台的数据  by 武利庆 2016-07-14
ALTER TABLE `core_deploment`.`sys_user_role`
ADD COLUMN `dataSource` VARCHAR(45) NULL COMMENT 'role_id所属的data_source' AFTER `role_id`;
-- 在用户与角色关系中添加dataSource后，需要修数据
-- 查询
select role_id, dataSource, ro.id, ro.name, ro.data_source from sys_user_role re, sys_role ro where re.role_id = ro.id and ro.data_source is not null and ro.data_source <> '';
-- 修改
update sys_user_role re, sys_role ro  set dataSource = ro.data_source  where re.role_id = ro.id and ro.data_source is not null and ro.data_source <> '';



ALTER TABLE `core_deploment`.`sys_user_menu`
ADD COLUMN `data_source` VARCHAR(45) NULL COMMENT '所属的data_source';