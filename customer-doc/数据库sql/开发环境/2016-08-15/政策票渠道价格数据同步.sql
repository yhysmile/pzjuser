update sys_channel_strategy s
inner join sys_label_relation r on s.id = r.obj_id
inner join product_release p on p.id = r.rel_id and s.id =r.obj_id and r.rel_type = 'strategyProduct' and p.pro_category  in 
(1,5,12,13,4,10,11)
set s.advice_price = s.price ;


update sys_channel_strategy s
inner join sys_label_relation r on s.id = r.obj_id
inner join product_release p on p.id = r.rel_id and s.id =r.obj_id and r.rel_type = 'strategyProduct' and p.pro_category  in 
(1,5,12,13,4,10,11)
set s.market_price = p.product_price ;


update sys_channel_strategy s set s.is_limit_advance_due = 0 where s.is_limit_advance_due is null;

update sys_channel_strategy s set s.is_limit_delay_consume = 0 where s.is_limit_delay_consume is null;

