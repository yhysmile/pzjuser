-- ---------------------
-- 无用户名及密码进行登陆   2016-04-12 10:30
-- 设置 login_name 列可以为空
-- ---------------------
alter table sys_user change login_name login_name VARCHAR(64)  null ;

alter table sys_user change login_passwd login_passwd VARCHAR(64)  null ;


-- create by wuliqing 2016-04-14
ALTER TABLE `core_deploment`.`sys_menu`
ADD COLUMN `catalog` VARCHAR(50) NULL COMMENT '分类' AFTER `supplier_id` ;
