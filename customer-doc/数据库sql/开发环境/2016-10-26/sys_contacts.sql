ALTER TABLE `core_deploment`.`sys_contacts`
ADD COLUMN `name_pinyin` VARCHAR(80) NULL COMMENT '拼音' AFTER `is_default`;
