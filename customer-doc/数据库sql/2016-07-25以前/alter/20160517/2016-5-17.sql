
	drop PROCEDURE if EXISTS sys_strategy_alter;

	CREATE PROCEDURE sys_strategy_alter() BEGIN 
	
		 IF NOT EXISTS (SELECT * FROM information_schema.columns WHERE  table_name = 'sys_channel_strategy' AND column_name = 'market_price') THEN  
			ALTER TABLE `sys_channel_strategy`
				ADD COLUMN `market_price` DOUBLE(10,2) DEFAULT NULL COMMENT '门市价' AFTER `parent_id`;
		 END IF;  
		
		 IF NOT EXISTS (SELECT * FROM information_schema.columns WHERE  table_name = 'sys_channel_strategy' AND column_name = 'advice_price') THEN  
			ALTER TABLE `sys_channel_strategy`
				ADD COLUMN `advice_price` Double(10,2) DEFAULT NULL COMMENT '建议零售价' AFTER `market_price`;
		 END IF;
		 
	 END

	 CALL sys_strategy_alter();