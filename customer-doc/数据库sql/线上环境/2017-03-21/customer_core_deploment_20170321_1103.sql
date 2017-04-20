# 将索路漫文化传播（上海）有限公司、上海丽趣国际旅行社有限公司更改为SaaS类型用户

# 查询
select id, user_type, name, is_root from sys_user where supplier_id in (3607958781886465, 3544150792994817);

# 执行

update sys_user set user_type = 13 where supplier_id in (3607958781886465, 3544150792994817);

# 验证
select id, user_type, name, is_root from sys_user where supplier_id in (3607958781886465, 3544150792994817) and usr_type = 13;

# 回滚
update sys_user set user_type = 1 where supplier_id in (3607958781886465, 3544150792994817) and is_root = 1;

update sys_user set user_type = 7 where supplier_id in (3607958781886465, 3544150792994817) and is_root = 0;