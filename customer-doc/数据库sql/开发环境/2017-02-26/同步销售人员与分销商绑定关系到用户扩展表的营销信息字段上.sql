# 同步sys_user_relation表中销售人员与分销商关系数据：rel_type=5的数据。
# 目标是：将sys_user_relation中rel_user_id是分销商id，user_id（销售人员id）的supplier_id（供应商id）做为主键，
# 保存到customer_extends表的customer_id和supplier_id上，user_id（销售人员id）作为referee_id和business_id。

# 可能会有主键冲突
INSERT INTO customer_extends (customer_id, supplier_id, referee_id, business_id)
  SELECT
    rel.rel_user_id,
    u.supplier_id,
    rel.user_id,
    rel.user_id
  FROM sys_user_relation rel
    INNER JOIN sys_user u ON u.id = rel.user_id
    LEFT JOIN customer_extends ext ON rel.rel_user_id = ext.customer_id AND u.supplier_id = ext.supplier_id
  WHERE ext.customer_id IS NULL
  GROUP BY rel.rel_user_id, u.supplier_id, rel.user_id;

# 验证重复关系
SELECT
  rel.rel_user_id,
  u.supplier_id,
  rel.user_id,
  count(*)
FROM sys_user_relation rel
  INNER JOIN sys_user u ON u.id = rel.user_id
GROUP BY rel.rel_user_id, u.supplier_id, rel.user_id
HAVING count(*) > 1;

# 验证重复主键
SELECT
  rel_user_id,
  supplier_id,
  count(*)
FROM (
       SELECT
         rel.rel_user_id,
         u.supplier_id,
         rel.user_id
       FROM sys_user_relation rel
         INNER JOIN sys_user u ON u.id = rel.user_id
       GROUP BY rel.rel_user_id, u.supplier_id, rel.user_id
     ) abc
GROUP BY rel_user_id, supplier_id
HAVING count(*) > 1;


# 同步后验证对比数据
# 1 营销信息的总数量
select count(*) from customer_extends;

# 2 关系表的的总数量（包括分销商id的统计）
SELECT count(*)
FROM (
       SELECT
         rel.rel_user_id,
         ext.customer_id,
         rel.user_id,
         u.id,
         u.supplier_id
       FROM sys_user_relation rel
         INNER JOIN customer_extends ext ON rel.rel_user_id = ext.customer_id AND rel_type = 5
         INNER JOIN sys_user u ON rel.user_id = u.id
       GROUP BY rel.rel_user_id, ext.customer_id, rel.user_id, u.id, u.supplier_id
     ) aa;

# 3 关系表的的总数量（不！包括分销商id的统计）
SELECT count(*)
FROM (
       SELECT
         rel.rel_user_id,
         ext.customer_id,
         u.supplier_id
       FROM sys_user_relation rel
         INNER JOIN customer_extends ext ON rel.rel_user_id = ext.customer_id AND rel_type = 5
         INNER JOIN sys_user u ON rel.user_id = u.id
       GROUP BY rel.rel_user_id, ext.customer_id, u.supplier_id
     ) aa;

# 4 如果关系表的总数量比营销信息表的总数量多，查询多出来的
SELECT *
FROM customer_extends
WHERE (customer_id, supplier_id, referee_id) NOT IN (
  SELECT
    rel_user_id,
    supplier_id,
    user_id
  FROM (
         SELECT
           rel.rel_user_id,
           ext.customer_id,
           rel.user_id,
           u.id,
           u.supplier_id
         FROM sys_user_relation rel
           INNER JOIN customer_extends ext ON rel.rel_user_id = ext.customer_id AND rel_type = 5
           INNER JOIN sys_user u ON rel.user_id = u.id
         GROUP BY rel.rel_user_id, ext.customer_id, rel.user_id, u.id, u.supplier_id
       ) aa
);