ALTER TABLE `product_release`
MODIFY COLUMN `product_price`  double(10,2) NULL DEFAULT NULL COMMENT '�����۸�' AFTER `product_code`,
MODIFY COLUMN `retail_price`  double(10,2) NULL DEFAULT NULL COMMENT '���ۼ�' AFTER `checkIn_type`,
MODIFY COLUMN `mf_price`  double(10,2) NULL DEFAULT NULL COMMENT 'ħ����' AFTER `retail_price`,
MODIFY COLUMN `original_price`  double(10,2) NULL DEFAULT NULL COMMENT 'ԭ��' AFTER `end_date`;

