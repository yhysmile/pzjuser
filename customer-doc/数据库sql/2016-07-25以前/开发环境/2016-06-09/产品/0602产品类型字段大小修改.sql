ALTER TABLE `product_release`
MODIFY COLUMN `pro_category`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '��Ʒ���\n1����ͨƱ;5����ͨ��Ʊ��Ʊ;12������Ʊ��Ʊ��Ʊ;13��������Ʊ��Ʊ;4������Ʊ;9������;10���糡������Ʊ��;11�����Ʊ' AFTER `auditStatus`;

