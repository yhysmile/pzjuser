-- ---------------------
-- 用户二次重构天加的以下字段   2016-04-11 13:00
-- ---------------------
drop PROCEDURE if EXISTS sys_user_alter;

CREATE PROCEDURE sys_user_alter() BEGIN 
	 IF NOT EXISTS (SELECT * FROM information_schema.columns WHERE  table_name = 'sys_user' AND column_name = 'identifyType') THEN  
		ALTER TABLE `sys_user`
			ADD COLUMN `identifyType` VARCHAR(10) DEFAULT NULL COMMENT '身份属性' AFTER `user_type`;
	 END IF;  
	 IF NOT EXISTS (SELECT * FROM information_schema.columns WHERE  table_name = 'sys_user' AND column_name = 'guideCertificate') THEN  
		ALTER TABLE `sys_user`
			ADD COLUMN `guideCertificate` VARCHAR(32) DEFAULT NULL COMMENT '导游证号' AFTER `business_certificate`;
	 END IF;
	 IF NOT EXISTS (SELECT * FROM information_schema.columns WHERE  table_name = 'sys_user' AND column_name = 'directCompany') THEN  
		ALTER TABLE `sys_user`
			ADD COLUMN `directCompany` VARCHAR(200)  DEFAULT NULL COMMENT '代注册公司名称' AFTER `guideCertificate`;
	 END IF;
	 IF NOT EXISTS (SELECT * FROM information_schema.columns WHERE  table_name = 'sys_user' AND column_name = 'directTime') THEN  
		ALTER TABLE `sys_user`
			ADD COLUMN `directTime` TIMESTAMP  DEFAULT 0 COMMENT '代注册时间' AFTER `directCompany`;
	 END IF;
	 IF NOT EXISTS (SELECT * FROM information_schema.columns WHERE  table_name = 'sys_user' AND column_name = 'belongScenicId') THEN  
		ALTER TABLE `sys_user`
			ADD COLUMN `belongScenicId` bigint(20) DEFAULT NULL COMMENT '客栈所属景区Id' AFTER `is_root`;
	 END IF;
	 IF NOT EXISTS (SELECT * FROM information_schema.columns WHERE  table_name = 'sys_user' AND column_name = 'hotelType') THEN  
		ALTER TABLE `sys_user`
			ADD COLUMN `hotelType` int(5) DEFAULT NULL COMMENT '客栈类型' AFTER `belongScenicId`;
	 END IF;
	 IF NOT EXISTS (SELECT * FROM information_schema.columns WHERE  table_name = 'sys_user' AND column_name = 'defaultLoginAddress') 	THEN  
		ALTER TABLE `sys_user`
			ADD COLUMN `defaultLoginAddress`  VARCHAR(100) DEFAULT NULL COMMENT '默认登录地址' AFTER `last_login_ip`;
	 END IF;
	 IF NOT EXISTS (SELECT * FROM information_schema.columns WHERE  table_name = 'sys_user' AND column_name = 'resellerId') THEN  
		ALTER TABLE `sys_user`
			ADD COLUMN `resellerId` BIGINT(20) DEFAULT NULL COMMENT '分销商ID' AFTER `other_files`;
	 END IF;
	 IF NOT EXISTS (SELECT * FROM information_schema.columns WHERE  table_name = 'sys_user' AND column_name = 'supplierPk') THEN  
		ALTER TABLE `sys_user`
			ADD COLUMN `supplierPk` BIGINT(20) DEFAULT NULL COMMENT '供应商ID' AFTER `other_file2`;
	 END IF;
	 IF NOT EXISTS (SELECT * FROM information_schema.columns WHERE  table_name = 'sys_user' AND column_name = 	'supplierTradeServiceFeeType') THEN  
		ALTER TABLE `sys_user`
			ADD COLUMN `supplierTradeServiceFeeType` INTEGER  DEFAULT NULL COMMENT '交易服务费费用类型' AFTER `supplierPlatformPayMode`;
	 END IF;
	 IF NOT EXISTS (SELECT * FROM information_schema.columns WHERE  table_name = 'sys_user' AND column_name = 	'supplierTradeServiceFee') THEN  
		ALTER TABLE `sys_user`
			ADD COLUMN `supplierTradeServiceFee` DOUBLE  DEFAULT NULL COMMENT '按百分比支付数值' AFTER `supplierTradeServiceFeeType`;
	 END IF;
	 IF NOT EXISTS (SELECT * FROM information_schema.columns WHERE  table_name = 'sys_user' AND column_name = 	'supplierTradeServiceRemark') THEN  
		ALTER TABLE `sys_user`
			ADD COLUMN `supplierTradeServiceRemark` VARCHAR(200) DEFAULT NULL COMMENT '整体统一支付信息说明' AFTER `supplierTradeServiceFee`;
	 END IF;
	 IF NOT EXISTS (SELECT * FROM information_schema.columns WHERE  table_name = 'sys_user' AND column_name = 	'supplierServiceFeePeriod') THEN  
		ALTER TABLE `sys_user`
			ADD COLUMN `supplierServiceFeePeriod` INTEGER DEFAULT NULL COMMENT '交易服务费结算周期' AFTER `supplierTradeServiceRemark`;
	 END IF;
	 IF NOT EXISTS (SELECT * FROM information_schema.columns WHERE  table_name = 'sys_user' AND column_name = 	'supplierBrokeragePeriod') THEN  
		ALTER TABLE `sys_user`
			ADD COLUMN `supplierBrokeragePeriod` INTEGER DEFAULT NULL COMMENT '佣金结算周期' AFTER `supplierServiceFeePeriod`;
	 END IF;
 END
 CALL sys_user_alter();
