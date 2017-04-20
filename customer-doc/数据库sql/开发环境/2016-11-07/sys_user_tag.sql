CREATE TABLE `core_deploment`.`sys_user_tag` (
  `id` BIGINT NOT NULL COMMENT '',
  `user_id` BIGINT NOT NULL COMMENT '用户ID',
  `tag_id` BIGINT NOT NULL COMMENT '标签id',
  `create_date` DATETIME NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)  COMMENT '',
  INDEX `IX_USER_TAG_USERID` (`user_id` ASC)  COMMENT '用户与标签关系表，用户ID索引')
  COMMENT = '用户与标签关系表';

ALTER TABLE `core_deploment`.`sys_user_tag`
ADD COLUMN `type` INT NULL COMMENT '类型' AFTER `tag_id`;
