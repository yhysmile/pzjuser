-- 更新表结构
ALTER TABLE `core_deploment`.`sys_user_menu`
ADD COLUMN `data_source` VARCHAR(45) NULL COMMENT '所属的data_source';

ALTER TABLE `sys_channel_strategy`
ADD COLUMN `is_limit_advance_due`  tinyint NULL default 0 COMMENT '提前预订时间限制' AFTER `advice_price`,
ADD COLUMN `advance_due_days`  integer NULL COMMENT '日期前天数可预订' AFTER `is_limit_advance_due`,
ADD COLUMN `advance_due_hour`  integer NULL COMMENT '日期前时刻-（时）可预订' AFTER `advance_due_days`,
ADD COLUMN `advance_due_minute`  integer NULL COMMENT '日期前时刻-（分）可预订' AFTER `advance_due_hour`,
ADD COLUMN `is_limit_delay_consume`  tinyint NULL default 0 COMMENT '延迟消费时间限制' AFTER `advance_due_minute`,
ADD COLUMN `delay_consume_hour`  integer NULL COMMENT '预订时刻-（时）可兑换' AFTER `is_limit_delay_consume`,
ADD COLUMN `least_perdue_number`  integer NULL COMMENT '每单最少购买份数' AFTER `delay_consume_hour`,
ADD COLUMN `most_perdue_number`  integer NULL COMMENT '每单最多购买份数' AFTER `least_perdue_number`;

ALTER TABLE `core_deploment`.`sys_channel_strategy`
ADD COLUMN `advance_due_unit` TINYINT(4) NULL COMMENT '日期前可预订单位' AFTER `most_perdue_number`;


ALTER TABLE `core_deploment`.`sys_channel_strategy`
ADD COLUMN `product_id` BIGINT(20) NULL COMMENT '产品id';

ALTER TABLE `core_deploment`.`sys_rebate_strategy`
ADD COLUMN `strategy_id` BIGINT NULL COMMENT '返利所属政策id' AFTER `rebate_rate`;


ALTER TABLE `sys_spcre_relation`
MODIFY COLUMN `id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键Id' FIRST ;


ALTER TABLE `core_deploment`.`sys_user`
CHANGE COLUMN `user_type` `user_type` VARCHAR(64) NULL DEFAULT NULL COMMENT '用户类型（1：普通用户；6：分销商；8：OTA；9：票之家；10：魔方用户；11：代理商；12：销售人员）' ;

ALTER TABLE `core_deploment`.`sys_user` 
CHANGE COLUMN `reseller_type` `reseller_type` VARCHAR(16) NULL DEFAULT NULL COMMENT '分销商类型（2：旅行社；3：旅行社部门；4：导游；5：商户）' ;


-- 更新数据

insert into sys_spcre_relation (strategy_id,channel_id, product_id)
select r1.obj_id,r1.rel_id,r2.rel_id from sys_label_relation r1,sys_label_relation r2
where r1.obj_id = r2.obj_id and r1.rel_type = 'strategyChannel' and r2.rel_type = 'strategyProduct' ;


-- 请先备份 sys_channel_strategy 表数据
update sys_channel_strategy s
inner join sys_label_relation r on s.id = r.obj_id
inner join product_release p on p.id = r.rel_id and s.id =r.obj_id and r.rel_type = 'strategyProduct' and p.pro_category  in
(1,5,12,13,4,10,11)
set s.advice_price = s.price ;


update sys_channel_strategy s
inner join sys_label_relation r on s.id = r.obj_id
inner join product_release p on p.id = r.rel_id and s.id =r.obj_id and r.rel_type = 'strategyProduct' and p.pro_category  in
(1,5,12,13,4,10,11)
set s.market_price = p.product_price ;



update sys_channel_strategy s set s.is_limit_advance_due = 0 where s.is_limit_advance_due is null;


update sys_channel_strategy s set s.is_limit_delay_consume = 0 where s.is_limit_delay_consume is null;


update sys_channel_strategy s
inner join sys_label_relation r on s.id = r.obj_id
inner join product_release p on p.id = r.rel_id and s.id =r.obj_id and r.rel_type = 'strategyProduct' and p.pro_category  in
(1,5,12,13,4,10,11)
set s.advice_price = s.price, s.market_price = p.product_price  ;



update sys_channel_strategy stra, sys_label_relation rela
set stra.product_id = rela.rel_id
where stra.id = rela.obj_id and rela.rel_type = 'strategyProduct';




-- 同步销售人员与分销商关联

-- 开启主键自增
ALTER TABLE `core_deploment`.`sys_user_relation`
CHANGE COLUMN `id` `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '' ;

-- 同步数据
insert into sys_user_relation (user_id, rel_user_id, rel_type)
select userId, relUserId, '5' rel_type from (
	select user.id userId, reluser.id relUserId from sys_user user, sys_user reluser
	where user.user_Type= 12 and reluser.user_type != 12 and user.invitationCode = reluser.invitationCode
) allrelation where (userId, relUserId) not in (
	select user_Id, rel_user_id from sys_user_relation where rel_type = 5
)

-- 关闭主键自增
ALTER TABLE `core_deploment`.`sys_user_relation`
CHANGE COLUMN `id` `id` BIGINT(20) NOT NULL COMMENT '' ;