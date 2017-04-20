ALTER TABLE `core_deploment`.`product_release`
ADD COLUMN `reasonRejection` VARCHAR(45) NULL COMMENT '审核不通过的拒绝理由' AFTER `check_date`;


ALTER TABLE `core_deploment`.`product_release`
ADD COLUMN `newMfPrice` DOUBLE(7,2) NULL COMMENT '住宿单产品新佣金比例' AFTER `reasonRejection`;


ALTER TABLE `core_deploment`.`product_release`
ADD COLUMN `bedNum` SMALLINT(3) NULL COMMENT '房间数量' AFTER `newMfPrice`;

ALTER TABLE `core_deploment`.`product_info`
ADD COLUMN `gainType` INT(5) NULL COMMENT '领票类型（1、二维码；2、身份证）',
ADD COLUMN `gainPeopleNum` INT(5) NULL COMMENT '领票人数限制，如果为-1表示不限制';



ALTER TABLE `core_deploment`.`product_info`
ADD COLUMN `gainPeopleTimeLimitUnit` INT(5) NULL COMMENT '同取票人领票时间范围单位（3：小时；4：天）' AFTER `gainPeopleNum`,
ADD COLUMN `gainPeopleTimeLimitValue` INT(5) NULL COMMENT '同取票人领票时间范围数量' AFTER `gainPeopleTimeLimitUnit`,
ADD COLUMN `gainPeopleTimePurchaseNum` INT(5) NULL COMMENT '同取票人领票时间范围值，如果为-1，则不限制' AFTER `gainPeopleTimeLimitValue`,
ADD COLUMN `minPurchaseNumInOrder` INT(5) NULL COMMENT '同订单最小起定量' AFTER `gainPeopleTimePurchaseNum`;



ALTER TABLE `core_deploment`.`product_scenic`
CHANGE COLUMN `info` `info` VARCHAR(2100) NULL DEFAULT NULL COMMENT '供应商介绍' ;
