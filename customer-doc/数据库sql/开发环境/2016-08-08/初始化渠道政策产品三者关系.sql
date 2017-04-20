
insert into sys_spcre_relation (strategy_id,channel_id, product_id) 
select r1.obj_id,r1.rel_id,r2.rel_id from sys_label_relation r1,sys_label_relation r2
where r1.obj_id = r2.obj_id and r1.rel_type = 'strategyChannel' and r2.rel_type = 'strategyProduct' ;

update sys_channel_strategy s 
inner join sys_label_relation r on  r.obj_id = s.id and r.rel_type = 'strategyProduct' and s.product_id is not null
set s.product_id = r.rel_id;

update sys_rebate_strategy rs set rs.strategy_id = (select r.obj_id from sys_label_relation r where r.rel_id = rs.id and r.rel_type = 'strategyRebate');