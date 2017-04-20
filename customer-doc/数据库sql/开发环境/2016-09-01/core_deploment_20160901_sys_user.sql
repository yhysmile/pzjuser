--

ALTER TABLE `core_deploment`.`sys_user`
CHANGE COLUMN `user_type` `user_type` VARCHAR(64) NULL DEFAULT NULL COMMENT '用户类型（1：普通用户；6：分销商；8：OTA；9：票之家；10：魔方用户；11：代理商；12：销售人员）' ;



ALTER TABLE `core_deploment`.`sys_user` 
CHANGE COLUMN `reseller_type` `reseller_type` VARCHAR(16) NULL DEFAULT NULL COMMENT '分销商类型（2：旅行社；3：旅行社部门；4：导游；5：商户）' ;

 

