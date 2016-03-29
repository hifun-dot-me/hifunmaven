
-- 功能：查询连续签到天数SQL
-- 时间：2016年3月4日14:39:55
-- 描述：
-- 	1 判断昨天或今天是否有签到，没签到则连续签到为0
-- 	2 昨天或今天有签到
--	   2.1 签到表自身关联，查找前一天是否有签到
--	   2.2 查找前一天未签到的最后一条数据
--	   2.3 上一步查找的时间与最大签到时间之差为连续签到时间
SELECT t.username, CASE WHEN t.flag = 2 THEN 0 
-- when t.flag = 1 then 
-- DATEDIFF(DATE_FORMAT(NOW(), '%Y-%m-%d'), DATE_FORMAT(MAX(t.signTime1), '%Y-%m-%d'))
ELSE 
DATEDIFF(DATE_FORMAT(NOW(), '%Y-%m-%d'), DATE_FORMAT(MAX(t.signTime1), '%Y-%m-%d')) + 1 - t.flag END AS daynum FROM
(
	SELECT s1.id, u.username, 
		DATE_FORMAT(s1.signTime, '%Y-%m-%d') signTime1, 
		DATE_FORMAT(s2.signTime, '%Y-%m-%d') signTime2,
		DATEDIFF(DATE_FORMAT(s1.signTime, '%Y-%m-%d'), DATE_FORMAT(s2.signTime, '%Y-%m-%d')) sign_datediff,
		CASE WHEN ins3.flag <= 1 THEN flag ELSE 2 END AS flag
	FROM user u
	left join signWeb s1 on u.username = s1.username
	LEFT JOIN signWeb s2 ON s1.username = s2.username 
		AND DATEDIFF(DATE_FORMAT(s1.signTime, '%Y-%m-%d'), DATE_FORMAT(s2.signTime, '%Y-%m-%d')) = 1
	LEFT JOIN (
		SELECT DATEDIFF(DATE_FORMAT(NOW(), '%Y-%m-%d'), DATE_FORMAT(MAX(s3.signTime), '%Y-%m-%d')) flag, s3.username 
			FROM signWeb s3
			WHERE 1 = 1
--			and s4.username = 'powlin'
			GROUP BY s3.username
	) ins3 ON ins3.username = s1.username
	WHERE 1 = 1 
--	and u.username = 'powlin' 
	GROUP BY u.username, s1.id
) t 
WHERE t.signTime2 IS NULL GROUP BY t.username;

create table shop(
	id int primary key auto_increment,
	username varchar(20) comment '用户名',
	shopName varchar(20) comment '商家名称',
	shopDesc varchar(50) comment '商家描述',
	shopAddr varchar(100) comment '商家地址',
	status int default 0 comment '状态 0-未验证 1-已验证',
	passTime datetime comment '验证时间',
	remark varchar(50) DEFAULT NULL COMMENT '备注',
	createTime datetime DEFAULT NULL COMMENT '创建时间',
	createBy varchar(20) DEFAULT NULL COMMENT '创建人',
	updateTime datetime DEFAULT NULL COMMENT '修改时间',
	updateBy varchar(20) DEFAULT NULL COMMENT '修改人',
	effectiveFrom datetime DEFAULT NULL COMMENT '生效时间起',
	effectiveTo datetime DEFAULT NULL COMMENT '生效时间止'
);

insert into shop values (1, 'waipojia', '外婆家西湖店', '杭帮菜家族杭帮菜杭帮菜哈哈哈哈哈哈', '...', 1, now(), '', now(), 'waipojia', now(), 'waipojia', now(), NULL);
insert into shop values (2, 'xinbailu', '新白鹿庆春店', '我也是杭帮菜家族杭帮菜杭帮菜哈哈哈哈哈哈', '...', 1, now(), '', now(), 'xinbailu', now(), 'xinbailu', now(), NULL);

update menu set linkTo = 'firstpage' where id = 1;
update menu set linkTo = 'hifunplayground' where id = 2;
update menu set linkTo = 'hibar' where id = 3;
update menu set linkTo = 'hisupermarket' where id = 5;
update menu set linkTo = 'donate' where id = 6;

update banner set path = '../components/image/png/hifunplayground20160325.png' where id = 6;
update banner set linkType = 1, linkTo = 'hifunplayground' where id = 6;

insert into banner values (6, '嗨翻广场', '../components/image/png/hifunplayground20160325.png', 1, 'hifunplayground', now(), 'admin', now(), 'admin', now(), null);



create table applyFriend(
	id int primary key auto_increment,
	applyTo varchar(20) NOT NULL comment '接收人',
	applyTime datetime comment '申请时间',
	username varchar(20) NOT NULL comment '用户名',
	remark varchar(50) DEFAULT NULL COMMENT '备注',
	createTime datetime DEFAULT NULL COMMENT '创建时间',
	createBy varchar(20) DEFAULT NULL COMMENT '创建人',
	updateTime datetime DEFAULT NULL COMMENT '修改时间',
	updateBy varchar(20) DEFAULT NULL COMMENT '修改人',
	effectiveFrom datetime DEFAULT NULL COMMENT '生效时间起',
	effectiveTo datetime DEFAULT NULL COMMENT '生效时间止'
);



