# 给用户添加交易服务费收款方的字段
ALTER TABLE `sys_user`
ADD COLUMN `trade_payee` int(2) NULL DEFAULT 0 COMMENT '交易服务费收款方' ;
