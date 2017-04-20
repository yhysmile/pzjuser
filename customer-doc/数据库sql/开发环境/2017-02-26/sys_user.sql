ALTER TABLE `core_deploment`.`sys_user`
ADD COLUMN `department` VARCHAR(45) NULL default '' COMMENT '销售人员的部门' AFTER `trade_payee`;
