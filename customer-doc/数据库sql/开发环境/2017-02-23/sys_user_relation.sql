alter table sys_user_relation add column status tinyint(2) unsigned not null default 1 comment '1:启用；2：禁用'; 
alter table sys_user_relation add column update_by bigint(20) unsigned comment '修改人'; 
alter table sys_user_relation add column update_date datetime COMMENT '修改时间';

update sys_user_relation set status=1 where status is null;