CREATE TABLE `core_deploment`.`sys_tag` (
  `id` BIGINT NOT NULL COMMENT '',
  `name` VARCHAR(200) NOT NULL COMMENT '标签名称',
  `create_date` DATETIME NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)  COMMENT '',
  UNIQUE INDEX `UK_TAG_NAME` (`name` ASC)  COMMENT '标签表，标签名称索引')
  COMMENT = '标签表';


ALTER TABLE `core_deploment`.`sys_tag`
ADD COLUMN `type` INT NULL COMMENT '类型' AFTER `name`;
