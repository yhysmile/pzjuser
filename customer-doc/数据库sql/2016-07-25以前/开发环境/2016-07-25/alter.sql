-- 添加7月迭代政策新字段 by 武利庆 2016-07-25

ALTER TABLE `core_deploment`.`sys_channel_strategy`
ADD COLUMN `isLimitAdvanceDue` TINYINT NULL COMMENT '提前预订时间限制' AFTER `most_perdue_number`,
ADD COLUMN `advanceDueDays` INT NULL COMMENT '日期前天数可预订' AFTER `isLimitAdvanceDue`,
ADD COLUMN `advanceDueHour` INT NULL COMMENT '日期前时刻-（时）可预订' AFTER `advanceDueDays`,
ADD COLUMN `advanceDueMinute` INT NULL COMMENT '日期前时刻-（分）可预订' AFTER `advanceDueHour`,
ADD COLUMN `isLimitDelayConsume` TINYINT NULL COMMENT '延迟消费时间限制' AFTER `advanceDueMinute`,
ADD COLUMN `delayConsumeHour` INT NULL COMMENT '预订时刻-（时）可兑换' AFTER `isLimitDelayConsume`,
ADD COLUMN `leastPerdueNumber` INT NULL COMMENT '每单最少购买份数' AFTER `delayConsumeHour`,
ADD COLUMN `mostPerdueNumber` INT NULL COMMENT '每单最多购买份数' AFTER `leastPerdueNumber`;
