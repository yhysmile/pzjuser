-- 2016-03-14 by wuliqing
-- 景区使用中报数据太大，
ALTER TABLE `sys_user`
CHANGE COLUMN `ticket_rule` `ticket_rule` VARCHAR(2000) NULL DEFAULT NULL COMMENT '票规' ;

-- 2016-03-16 by wuliqing
-- 产品新加功能：游玩时间。
ALTER TABLE `product_info`
ADD COLUMN `playtimeMode` INT NULL COMMENT '游玩时间的开始时间的方式' AFTER `supplier_id`,
ADD COLUMN `playtimeValue` INT NULL COMMENT '游玩时间的数量' AFTER `playtimeMode`,
ADD COLUMN `playtimeUnit` INT NULL COMMENT '游玩时间的单位' AFTER `playtimeValue`;

ALTER TABLE `product_release`
ADD COLUMN `ticketNumber` INT NULL COMMENT '检票次数' AFTER `room_type`,
ADD COLUMN `reduceSettlementMoney` INT NULL COMMENT '减少结算金额' AFTER `ticketNumber`;

ALTER TABLE `product_site_data`
ADD COLUMN `subsidiaryType` VARCHAR(45) NULL COMMENT '缆车票标示' AFTER `jqrk_id`;

ALTER TABLE `core_deploment`.`product_release`
CHANGE COLUMN `reduceSettlementMoney` `reduceSettlementMoney` DOUBLE(10,2) NULL DEFAULT NULL COMMENT '减少结算金额（团）' ,
ADD COLUMN `notTotalSettlementType` INT(10) NULL COMMENT '未满减结算规则类型（团）' AFTER `reduceSettlementMoney`;




INSERT INTO `core_deploment`.`product_dict` (`id`, `label`, `value`, `type`, `description`, `create_by`, `flag`) VALUES ('442', '首检后', '0', 'product:playTimeMode', '游玩时间模式', 'admin', '1');
INSERT INTO `core_deploment`.`product_dict` (`id`, `label`, `value`, `type`, `description`, `create_by`, `flag`) VALUES ('443', '游玩时间后', '1', 'product:playTimeMode', '游玩时间模式', 'admin', '1');


ALTER TABLE `core_deploment`.`product_release`
ADD COLUMN `reduceSettlementMoney2nd` DOUBLE(10,2) NULL COMMENT '减少结算金额（散）' AFTER `notTotalSettlementType`,
ADD COLUMN `notTotalSettlementType2nd` INT(10) NULL COMMENT '未满减结算规则类型（散）' AFTER `reduceSettlementMoney2nd`;

ALTER TABLE `core_deploment`.`product_scenic`
CHANGE COLUMN `img_url` `img_url` VARCHAR(1000) NULL DEFAULT NULL COMMENT '图片资料' ;

ALTER TABLE `core_deploment`.`product_release`
CHANGE COLUMN `pro_category` `pro_category` VARCHAR(2) NULL DEFAULT NULL COMMENT '产品类别\n1：普通票;5：普通联票子票;12：积分票联票子票;13：演艺联票子票;4：积分票;9：房型;10：剧场（演艺票）;11：组合票' ;

-- 更新产品类型，需按顺序执行。
update core_deploment.product_release set pro_category = '11' where pro_category = '6';
update core_deploment.product_release set pro_category = '10' where pro_category = '2';
update core_deploment.product_release set pro_category = '9' where pro_category = '8';
update core_deploment.product_release set pro_category = '12' where pro_category = '5';
update core_deploment.product_release set pro_category = '13' where pro_category = '7';
update core_deploment.product_release set pro_category = '5' where pro_category = '4';
update core_deploment.product_release set pro_category = '4' where pro_category = '3';

UPDATE `core_deploment`.`product_dict` SET `value`='10' WHERE `id`='32';
UPDATE `core_deploment`.`product_dict` SET `label`='积分票', `value`='4' WHERE `id`='33';
UPDATE `core_deploment`.`product_dict` SET `value`='5' WHERE `id`='34';
UPDATE `core_deploment`.`product_dict` SET `value`='12' WHERE `id`='35';

