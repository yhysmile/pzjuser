
-- 给微店政策设置is_open_multi_rebate为1。好像启用is_open_multi_rebate表示微店政策前，有些微店政策是没此值的。
update sys_channel_strategy set  is_open_multi_rebate = 1  where name like '%（微店）' and dict_value is not null;


-- 给普通政策设置is_open_multi_rebate为0。好像启用is_open_multi_rebate表示微店政策前，有些普通政策是没此值的。
update sys_channel_strategy set  is_open_multi_rebate = 0  where  is_open_multi_rebate is null ;