## 查询sql
SELECT * from  sys_channel_strategy  where is_open_multi_rebate = 1 and ticket_varie = 1 ;
SELECT * from  sys_channel_strategy s inner join sys_label_relation sc on sc.obj_id = s.id and sc.rel_type = 'strategyChannel' and sc.rel_id =1 and s.is_open_multi_rebate = 1;
SELECT * from  sys_channel_strategy s where s.is_open_multi_rebate = 1 and s.data_source = 4;



## 修改语句

-- 第1步
备份sys_channel_strategy表

-- 第2步
-- 给普通政策设置is_open_multi_rebate为0。好像启用is_open_multi_rebate表示微店政策前，有些普通政策是没此值的。
update sys_channel_strategy set  is_open_multi_rebate = 0  where is_open_multi_rebate is null ;

-- 第3步
-- 给微店政策设置is_open_multi_rebate为1。好像启用is_open_multi_rebate表示微店政策前，有些微店政策是没此值的。
update sys_channel_strategy set  is_open_multi_rebate = 1  where name like '%（微店）' and dict_value is not null;



-- 第4步
update sys_channel_strategy set del_flag = '0',status = '0' where is_open_multi_rebate = 1 and ticket_varie = 1 ;
update sys_channel_strategy s inner join sys_label_relation sc on sc.obj_id = s.id and sc.rel_type = 'strategyChannel' and sc.rel_id =1 and s.is_open_multi_rebate = 1 set s.del_flag = '0',s.status = '0';
update sys_channel_strategy s set s.del_flag = '0',s.status = '0' where s.is_open_multi_rebate = 1 and s.data_source = 4;

## 回滚语句
dba备份