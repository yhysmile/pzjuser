# 将威海交通场站管理有限公司惠威汽车租赁分公司更改为SaaS类型用户

# 查询
select id, user_type, name, is_root from sys_user where id in (3591305985720321);

select id, user_type, name, is_root from sys_user where supplier_id in (3591305985720321) and is_root = 0;

# 执行

update sys_user set user_type = 13 where id in (3591305985720321);

update sys_user set user_type = 13 where supplier_id in (3591305985720321) and is_root = 0;


# 验证
select id, user_type, name, is_root from sys_user where id in (3591305985720321) and usr_type = 13;

select id, user_type, name, is_root from sys_user where supplier_id in (3591305985720321) and is_root = 0 and usr_type = 13;


# 回滚
update sys_user set user_type = 1 where id in (3591305985720321);

update sys_user set user_type = 7 where supplier_id in (3591305985720321) and is_root = 0;