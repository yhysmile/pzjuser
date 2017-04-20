# 新创建用户成功后，密码要发送短信给用户，所以需要在短信平台添加一个业务线。

ALTER TABLE `smp`.`business`
CHANGE COLUMN `busin_name` `busin_name` VARCHAR(40) NOT NULL COMMENT '业务系统名称' ;

INSERT INTO `smp`.`business` (`busin_id`, `busin_name`, `busin_describe`, `state`) VALUES ('21', 'customer:password_inform', '新用户创建成功时通知其密码', '1');
