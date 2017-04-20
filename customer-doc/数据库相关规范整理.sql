数据库数据库规范文档

	1 命名规范事项
		建议用程序模块名_核心单词为命名模板
		如：产品表下的属性 products_attribute
		2.1.1 数据库功能命名
			建议使用程序模块前缀_数据库功能缩写_核心单词
		库名表名统用小写字母命名
		
	表命名前缀:products _xxx
	存储过程命名:products _proc_xxx
	视图命名:products _vs_xxx
	存储函数:products _func_xxx
	触发器:products _tg_xxx
	
	2 使用细节规范
	前提：
		1.越小的数据类型通常更好：越小的数据类型通常在磁盘、内存和CPU缓存中都需要更少的空间，处理起来更快。
			Eg: 
			能用int的就不用char或者varchar;  
			能用tinyint的就不用int; 
			能用varchar(20)的就不用varchar(255)

		2.简单的数据类型更好：整型数据比起字符，处理开销更小，因为字符串的比较更复杂。在MySQL中，应该用内置
			的日期和时间数据类型，而不是用字符串来存储时间；以及用整型数据类型存储IP地址。
		a> 建议所有字段都需要加上not null关键字,如需要特殊处理可使用default ‘’关键字；
			原因：在MySQL中，含有空值的列很难进行查询优化，因为它们使得索引、索引的统计信息以及比较运算更加复杂。
			你应该用0、一个特殊的值或者一个空串代替空值。
		b> 整型分以下五种(tinyint/smallint/mediumint/int/bigint)，使用整型，如不需要负数一律规定加上unsigned关键字
		c> 字符串类型分为char和varchar，varchar根据编码不同，最多可以存储65532个字符，在utf8编码下，最多可以存储21844个
		字符,建议在该范围内的字符串，统一使用varchar替代text类型

	3：Mysql  join  & in 
		in  
			select * from t1 where f1 in ('a','b')；
			select * from t1 where f1='a' or f1='b'； 
			select * from t1 where f1 ='a' union all select * from t1 f1='b'；
			select * from t1 where f1 in (select f1 from t2 where t2.fx='x')；
			= select * from t1 where exist (select f1 from t2 where t2.fx='x');
		Join  
			多表连接类型
			i> 笛卡尔积(交叉连接) 在MySQL中可以为CROSS JOIN或者省略CROSS即JOIN，或者使用','  如： 
				SELECT * FROM table1 CROSS JOIN table2   ;
				SELECT * FROM table1 JOIN table2   ;
				SELECT * FROM table1,table2  ;
	      		由于其返回的结果为被连接的两个数据表的乘积，因此当有WHERE,ON或USING条件的时候一般不建议使用，因为
				当数据表项目太多的时候，会非常慢。一般使用LEFT [OUTER] JOIN或者RIGHT [OUTER] JOIN
			ii> 内连接INNER JOIN 在MySQL中把INNER JOIN叫做等值连接，即需要指定等值连接条件，在MySQL中CROSS和INNER JOIN被划分在一起。 
			iii> MySQL中的外连接，分为左外连接和右连接，即除了返回符合连接条件的结果之外，还要返回左表(左连接)或者右表(右连接)中不
				符合连接条件的结果，相对应的使用NULL对应。
			原理：从左表读出一条，选出所有与on匹配的右表纪录(n条)进行连接，形成n条纪录(包括重复的行)，如果右边没有与on条件匹配的表，
			那连接的字段都是null.然后继续读下一条。

			规则：能交不in 、  能内不外

				select col1 from tab1 where col2 in (select col2 from tab2);
				改: 	select col1 from tab1 a  inner join tab2 b on a.clo2=b.clo2;
				select col1 from tab1 where col2 not in (select col2 from tab2);
				改:  select col1 from tab1 a left join tab2 b on a.clo2=b.clo2 where b.clo2 is null;
				原理分析: 简单理解为(a+b) 然后查询,但in是a*b

		附加：还有一种连接叫STRAIGHT_JOIN 【直交】 以第一个表为驱动表；
			Mysql 优化器会选择结果集较小的表为驱动表
			Eg:
			1.  SELECT post.* FROM post INNER JOIN post_tag 
			ON post.id = post_tag.post_id WHERE post. STATUS = 1 AND post_tag.tag_id = 123 
			ORDER BY post.created DESC;
			如上语句：
			Post表status_create有索引，通过这个来过滤需要结果集119340行   
			以post_tag为驱动表，通过tag_id索引过滤，结果集71220行  
			Mysql 优化器会选择post_tag作为驱动表，但问题是ORDER BY post.created DESC，最终的排序不在驱动表上，所以又会涉及到file sort 、copying to tmp table操作。
	
	4、更新表时事先判断表中是否已存在某列，避免报错：
	-- 删除已存在的储存过程
	drop PROCEDURE if EXISTS sys_user_alter;
	-- 创建存储过程
	CREATE PROCEDURE sys_user_alter() BEGIN 
		 -- 判断某列是否存在
		 IF NOT EXISTS (SELECT * FROM information_schema.columns WHERE  table_name = 'sys_user' AND column_name = 'identifyType') THEN  
			ALTER TABLE `sys_user`
				ADD COLUMN `identifyType` VARCHAR(10) DEFAULT NULL COMMENT '身份属性' AFTER `user_type`;
		 END IF;  
		 -- 同时可以定义多个语句
		 IF NOT EXISTS (SELECT * FROM information_schema.columns WHERE  table_name = 'sys_user' AND column_name = 'guideCertificate') THEN  
			ALTER TABLE `sys_user`
				ADD COLUMN `guideCertificate` VARCHAR(32) DEFAULT NULL COMMENT '导游证号' AFTER `business_certificate`;
		 END IF
		 
	 END
	 -- 调用存储过程
	 CALL sys_user_alter();


