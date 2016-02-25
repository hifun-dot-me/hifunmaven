-- 嗨信
CREATE TABLE hiChat(
	id INT PRIMARY KEY AUTO_INCREMENT,
	username VARCHAR(20) COMMENT '用户名',
	sendContent VARCHAR(200) COMMENT '发送内容',
	sendTo VARCHAR(20) COMMENT '发送至',
	sendTime DATETIME COMMENT '发送时间',
	openFlag INT DEFAULT 0 COMMENT '打开标识 1表示打开',
	openTime DATETIME COMMENT '打开时间',
	remark VARCHAR(200) COMMENT '备注',
	createTime DATETIME COMMENT '创建时间',
	createBy VARCHAR(20) COMMENT '创建人',
	updateTime DATETIME COMMENT '修改时间',
	updateBy VARCHAR(20) COMMENT '修改人',
	effectiveFrom DATETIME COMMENT '生效时间起',
	effectiveTo DATETIME COMMENT '生效时间止'
);

ALTER TABLE banner ADD linkType INT DEFAULT 0 COMMENT '跳转类型' AFTER path;
ALTER TABLE banner ADD linkTo VARCHAR(20) DEFAULT NULL COMMENT '跳转链接' AFTER linkType;

ALTER TABLE menu ADD linkTo VARCHAR(20) DEFAULT NULL COMMENT '跳转链接' AFTER remark;

UPDATE banner SET linkType = 1, linkTo = 'hithings' WHERE id = 5;
UPDATE menu SET linkTo = 'hithings' WHERE id = 4;