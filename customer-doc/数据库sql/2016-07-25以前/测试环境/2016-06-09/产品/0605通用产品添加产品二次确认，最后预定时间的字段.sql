ALTER TABLE `product_release`

ADD COLUMN `twice_sure`  varchar(2) NULL COMMENT '�Ƿ����ȷ�� 1�ǣ�0�� ' AFTER `package_discount`,
ADD COLUMN `latest_preset`  varchar(2) NULL COMMENT '����Ԥ������  0�����ã�1����Ԥ��ʱ��' AFTER `twice_sure`,
ADD COLUMN `latest_preset_days`  int(5) NULL COMMENT '����Ԥ������ ��ǰ����' AFTER `latest_preset`,
ADD COLUMN `latest_preset_time`  varchar(10) NULL COMMENT '����Ԥ������ Ԥ��ʱ��' AFTER `latest_preset_days`,
ADD COLUMN `province`  varchar(100) NULL COMMENT 'ʡ' AFTER `latest_preset_time`,
ADD COLUMN `city`  varchar(100) NULL COMMENT '��' AFTER `province`,
ADD COLUMN `county`  varchar(100) NULL COMMENT '��' AFTER `city`;