-- 2016年03月01日22:08:19
create table hiPlayground(
	id int primary key auto_increment,
	username varchar(20) comment '用户名',
	content text comment '内容',
	status int default 0 comment '状态',
	remark varchar(50) comment '备注',
	createTime datetime comment '创建时间',
	createBy varchar(20) comment '创建人',
	updateTime datetime comment '修改时间',
	updateBy varchar(20) comment '修改人',
	effectiveFrom datetime comment '生效时间起',
	effectiveTo datetime comment '生效时间止'
);