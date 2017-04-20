ALTER TABLE `product_release`
ADD COLUMN `compose_mark` VARCHAR(100) NULL COMMENT '存放组合标记。因为多个子票期望互相关联，它们之前的条件互相匹配（互相有供应商），可以视为是共同的特质。' AFTER `is_composed`;
