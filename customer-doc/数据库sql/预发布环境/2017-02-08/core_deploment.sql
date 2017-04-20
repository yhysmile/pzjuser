# 给用户添加保存logo的字段
ALTER TABLE `sys_user`
ADD COLUMN `logo` VARCHAR(32) NULL DEFAULT '' COMMENT '企业logo' AFTER `qualification_audit`;


ALTER TABLE `sys_user_microshop`
CHANGE COLUMN `create_date` `create_date` DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间' ,
CHANGE COLUMN `update_date` `update_date` DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间' ;


# 给用户添加交易服务费收款方的字段
ALTER TABLE `sys_user`
ADD COLUMN `trade_payee` int(2) NULL DEFAULT 0 COMMENT '交易服务费收款方' ;
