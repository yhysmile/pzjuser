ALTER TABLE `sys_user_microshop`
CHANGE COLUMN `create_date` `create_date` DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间' ,
CHANGE COLUMN `update_date` `update_date` DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间' ;