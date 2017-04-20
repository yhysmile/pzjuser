# 更新个人类型的用户的联系人到公司名上

update sys_user set name = corporater where identifyType = 'p' and name is null and corporater is not null;