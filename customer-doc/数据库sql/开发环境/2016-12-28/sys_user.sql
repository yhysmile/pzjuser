ALTER TABLE `core_deploment`.`sys_user`
CHANGE COLUMN `wx_openid` `wx_openid` VARCHAR(50) NULL DEFAULT NULL COMMENT '微信绑定账号' ;


-- 为老用户（分销商）生成默认的微店信息
insert sys_user_microshop (id, user_id, name, intro, avatar)
SELECT id, id, '魔方旅游微店', '淳朴地道的本地人，给你最具性价比的本地游', 'ab6c59e533869afc65baf8ce6963ccc9'  FROM core_deploment.sys_user where user_type = 6 and check_status = 1;
