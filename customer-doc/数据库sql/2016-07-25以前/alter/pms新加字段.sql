ALTER TABLE `sys_user` ADD COLUMN `hotel_map_longitude` DOUBLE(10,2) NULL COMMENT '客栈地图:经度';

ALTER TABLE `sys_user` ADD COLUMN `hotel_map_latitude` DOUBLE(10,2) NULL COMMENT '客栈地图:纬度';

ALTER TABLE `sys_user` ADD COLUMN `region` VARCHAR(200) NULL COMMENT '客栈区域';

ALTER TABLE `sys_user` ADD COLUMN `scenic_info` VARCHAR(200) NULL COMMENT '客栈附近景区';

ALTER TABLE `sys_user` ADD COLUMN `hotel_facility` VARCHAR(200) NULL COMMENT '客栈设施';

ALTER TABLE `sys_user` ADD COLUMN `hotel_feature` VARCHAR(200) NULL COMMENT '客栈特点';

ALTER TABLE `sys_user` ADD COLUMN `hotel_pirture` VARCHAR(200) NULL COMMENT '客栈风光';

ALTER TABLE `sys_user` ADD COLUMN `boss_story` VARCHAR(500) NULL COMMENT '老板故事';

ALTER TABLE `sys_user` ADD COLUMN `boss_pirture` VARCHAR(200) NULL COMMENT '老板靓照';

ALTER TABLE `sys_user` ADD COLUMN `hotel_start_date` VARCHAR(50) NULL COMMENT '客栈时间规定：开始时间';

ALTER TABLE `sys_user` ADD COLUMN `hotel_end_date` VARCHAR(50) NULL COMMENT '客栈时间规定：结束时间';

ALTER TABLE `sys_user` ADD COLUMN `hotel_num` int(10) NULL COMMENT '客栈房间数';

ALTER TABLE `sys_user` ADD COLUMN `treat_people_num` int(5) NULL COMMENT '客栈可接待人数';

ALTER TABLE `sys_user` ADD COLUMN `notify_update_state` VARCHAR(10) COMMENT 'pms用户更新通知状态 ：1 目前与业务段数据一致 2 需要更新业务端数据';



ALTER TABLE `sys_channel_strategy` ADD COLUMN `rebate_rate` DOUBLE(10,2) NULL COMMENT 'PMS:返利比';


ALTER TABLE `product_release` ADD COLUMN `floor` VARCHAR(200) NULL COMMENT '楼层';
ALTER TABLE `product_release` ADD COLUMN `area` VARCHAR(200) NULL COMMENT '面积';
ALTER TABLE `product_release` ADD COLUMN `head_Count` VARCHAR(200) NULL COMMENT '可住人数';
ALTER TABLE `product_release` ADD COLUMN `windows` VARCHAR(200) NULL COMMENT '窗户';
ALTER TABLE `product_release` ADD COLUMN `facilities` VARCHAR(200) NULL COMMENT '房间设施';
ALTER TABLE `product_release` ADD COLUMN `intro` VARCHAR(200) NULL COMMENT '房型简介';
ALTER TABLE `product_release` ADD COLUMN `photos` VARCHAR(200) NULL COMMENT '房型照片，多个以,分隔';
ALTER TABLE `product_release` ADD COLUMN `notify_update_state` VARCHAR(10) COMMENT 'pms房型更新通知状态 ：1 目前与业务段数据一致 2 需要更新业务端数据';
