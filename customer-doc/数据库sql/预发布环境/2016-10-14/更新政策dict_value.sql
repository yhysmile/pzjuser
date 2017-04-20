drop PROCEDURE if exists sp_sys_channel_strategy_dictvalue;
CREATE PROCEDURE `sp_sys_channel_strategy_dictvalue`()
BEGIN
declare strId BIGINT;
declare stop int default 0;
declare cur cursor for(
select s.id from sys_channel_strategy_bk1012 s where s.id >10000000000000000 and s.is_open_multi_rebate = 1 and (dict_value is null or dict_value = '')
);
declare CONTINUE HANDLER FOR SQLSTATE '02000' SET stop = null;
/*开游标*/
OPEN cur;
/*游标向下走一步，将查询出来的值付给定义的变量*/
    FETCH cur INTO strId;
    WHILE ( stop is not null) DO

update sys_channel_strategy_bk1012 set dict_value = strId where id = strId;
update sys_channel_strategy_bk1012 set dict_value = strId where id = (strId-10000000000000000); 




FETCH cur INTO strId;
select strId from dual;
END WHILE;
/*游标向下走一步*/
CLOSE cur;
END;

call `sp_sys_channel_strategy_dictvalue`;





