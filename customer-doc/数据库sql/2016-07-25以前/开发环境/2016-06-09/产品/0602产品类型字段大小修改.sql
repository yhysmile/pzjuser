ALTER TABLE `product_release`
MODIFY COLUMN `pro_category`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '产品类别\n1：普通票;5：普通联票子票;12：积分票联票子票;13：演艺联票子票;4：积分票;9：房型;10：剧场（演艺票）;11：组合票' AFTER `auditStatus`;

