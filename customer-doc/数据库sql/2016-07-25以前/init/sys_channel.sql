start transaction;

INSERT INTO `sys_channel`(`id`,`name`,`channel_principal`,`city`,`county`,`province`,`spell`,`create_date`,`del_flag`,`sort`,`update_date`,`update_by`,`create_by`,`remark`,`channel_type`,`channel_category`,`data_source`,`supplier_id`) VALUES (1, '魔方旅游', '管理员', '北京', '中国', '北京', 'BJ', '2015-11-25 14:10:13', '1', 0, '2015-11-25 14:10:17', 'admin', 'admin', '测试', '2', '0', '1',NULL);
INSERT INTO `sys_channel`(`id`,`name`,`channel_principal`,`city`,`county`,`province`,`spell`,`create_date`,`del_flag`,`sort`,`update_date`,`update_by`,`create_by`,`remark`,`channel_type`,`channel_category`,`data_source`,`supplier_id`) VALUES (1111111111111111, '默认直销渠道', '管理员', '北京', '中国', '北京', 'BJ', '2015-11-25 14:10:13', '1', 0, '2015-12-30 11:54:12', 'admin', 'admin', '初始化', '1', NULL, '4', 1);

commit;