# 这是为了修复线上的一个Bug。
# 错误现象：在平台管理分销商权限时，可以为其配置渠道，这里的渠道是分销类型的渠道。而在直签分销商管理中，还可为分销商分配直签类型的渠道。
# 这是两种不同的分配，应该互不干扰的，实际会互相冲掉对方的分配。
# 原因：因为共用了同一个关系类型。
# 修复方式：这两种分配应使用不同的关系类型，所以将直签渠道关联改为新的类型directChannelUser。程序保存和查询做相应的调整和兼容。
update sys_label_relation rel , sys_channel chan set rel.rel_type = 'directChannelUser'
where rel.obj_id = chan.id and rel.rel_type = 'channelUser' and chan.channel_type = 1;