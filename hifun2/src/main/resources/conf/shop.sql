-- -----------------------------------------------------
-- Table `hifun`.`shop`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hifun`.`shop` (
  `id` INT PRIMARY KEY AUTO_INCREMENT,
  `username` VARCHAR(20) NOT NULL COMMENT '用户名',
  `shopName` VARCHAR(20) NOT NULL COMMENT '商家名称',
  `shopType` INT NOT NULL COMMENT '商家类型 对应shop_type',
  `shopLevel` INT NOT NULL COMMENT '商家级别 对应shop_level',
  `shopDesc` VARCHAR(50) NOT NULL COMMENT '商家描述',
  `shopAddr` VARCHAR(100) NOT NULL COMMENT '商家地址',
  `status` INT NOT NULL DEFAULT 0 COMMENT '状态 0-未验证 1-已验证',
  `passTime` DATETIME NULL COMMENT '验证时间',
  `remark` VARCHAR(50) NULL COMMENT '备注',
  `createTime` DATETIME NULL COMMENT '创建时间',
  `createBy` VARCHAR(20) NULL COMMENT '创建人',
  `updateTime` DATETIME NULL COMMENT '修改时间',
  `updateBy` VARCHAR(20) NULL COMMENT '修改人',
  `effectiveFrom` DATETIME NULL COMMENT '生效时间起',
  `effectiveTo` DATETIME NULL COMMENT '生效时间止'
);


-- -----------------------------------------------------
-- Table `hifun`.`shop_type`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hifun`.`dictionary` (
  `id` INT PRIMARY KEY AUTO_INCREMENT,
  `dictionaryDesc` varchar(20),
  `typeId` INT NOT NULL,
  `typeName` VARCHAR(25) NOT NULL,
  `orderNum` int default 0,
  `createTime` DATETIME NULL COMMENT '创建时间',
  `createBy` VARCHAR(20) NULL COMMENT '创建人',
  `updateTime` DATETIME NULL COMMENT '修改时间',
  `updateBy` VARCHAR(20) NULL COMMENT '修改人',
  `effectiveFrom` DATETIME NULL COMMENT '生效时间起',
  `effectiveTo` DATETIME NULL COMMENT '生效时间止'
);

insert into dictionary values (1, 'shopType', 1, '美食', 1, NOW(), 'admin', NOW(), 'admin', NOW(), NULL);
insert into dictionary values (2, 'shopType', 2, '酒店/客栈', 2, NOW(), 'admin', NOW(), 'admin', NOW(), NULL);
insert into dictionary values (3, 'shopType', 3, '电影/在线选座', 3, NOW(), 'admin', NOW(), 'admin', NOW(), NULL);
insert into dictionary values (4, 'shopType', 4, 'KTV', 4, NOW(), 'admin', NOW(), 'admin', NOW(), NULL);
insert into dictionary values (5, 'shopType', 5, '休闲娱乐', 5, NOW(), 'admin', NOW(), 'admin', NOW(), NULL);
insert into dictionary values (6, 'shopType', 6, '周边游/旅游', 6, NOW(), 'admin', NOW(), 'admin', NOW(), NULL);
insert into dictionary values (7, 'shopType', 7, '生活服务', 7, NOW(), 'admin', NOW(), 'admin', NOW(), NULL);
insert into dictionary values (8, 'shopType', 8, '购物', 8, NOW(), 'admin', NOW(), 'admin', NOW(), NULL);
insert into dictionary values (9, 'shopType', 9, '丽人', 9, NOW(), 'admin', NOW(), 'admin', NOW(), NULL);

insert into dictionary values (10, 'shopLevel', 1, '授权商家', 1, NOW(), 'admin', NOW(), 'admin', NOW(), NULL);
insert into dictionary values (11, 'shopLevel', 2, '银牌商家', 2, NOW(), 'admin', NOW(), 'admin', NOW(), NULL);
insert into dictionary values (12, 'shopLevel', 3, '金牌商家', 3, NOW(), 'admin', NOW(), 'admin', NOW(), NULL);
insert into dictionary values (13, 'shopLevel', 4, '白金商家', 4, NOW(), 'admin', NOW(), 'admin', NOW(), NULL);


-- -----------------------------------------------------
-- Table `hifun`.`shop_level`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hifun`.`shop_level` (
  `id` INT PRIMARY KEY AUTO_INCREMENT,
  `levelId` INT NOT NULL COMMENT '级别编码',
  `levelName` VARCHAR(10) NOT NULL COMMENT '级别名称',
  `createTime` DATETIME NULL COMMENT '创建时间',
  `createBy` VARCHAR(20) NULL COMMENT '创建人',
  `updateTime` DATETIME NULL COMMENT '修改时间',
  `updateBy` VARCHAR(20) NULL COMMENT '修改人',
  `effectiveFrom` DATETIME NULL COMMENT '生效时间起',
  `effectiveTo` DATETIME NULL COMMENT '生效时间止'
);


-- -----------------------------------------------------
-- Table `hifun`.`hiPlayground`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hifun`.`hiPlayground` (
  `id` INT PRIMARY KEY AUTO_INCREMENT,
  `shopId` INT NOT NULL COMMENT '商家编码',
  `shopEvaluate` VARCHAR(50) NOT NULL COMMENT '评价',
  `status` INT NOT NULL COMMENT '验证状态 为商家验证用户的状态',
  `remark` VARCHAR(45) NULL COMMENT '备注',
  `createTime` DATETIME NULL COMMENT '创建时间',
  `createBy` VARCHAR(20) NULL COMMENT '创建人',
  `updateTime` DATETIME NULL COMMENT '修改时间',
  `updateBy` VARCHAR(20) NULL COMMENT '修改人',
  `effectiveFrom` DATETIME NULL COMMENT '生效时间起',
  `effectiveTo` DATETIME NULL COMMENT '生效时间止'
);


-- -----------------------------------------------------
-- Table `hifun`.`total_img`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hifun`.`total_img` (
  `id` INT PRIMARY KEY AUTO_INCREMENT,
  `type` INT NOT NULL COMMENT '图片类型 对应img_type',
  `shopId` INT NOT NULL COMMENT '商家编码',
  `shopImg` VARCHAR(50) NOT NULL COMMENT '商家图片路径',
  `createTime` DATETIME NULL COMMENT '创建时间',
  `createBy` VARCHAR(20) NULL COMMENT '创建人',
  `updateTime` DATETIME NULL COMMENT '修改时间',
  `updateBy` VARCHAR(20) NULL COMMENT '修改人',
  `effectiveFrom` DATETIME NULL COMMENT '生效时间起',
  `effectiveTo` DATETIME NULL COMMENT '生效时间止'
);


-- -----------------------------------------------------
-- Table `hifun`.`type_img`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hifun`.`type_img` (
  `id` INT PRIMARY KEY AUTO_INCREMENT,
  `imgTypeId` INT NOT NULL COMMENT '图片类型编码',
  `imgTypeName` VARCHAR(20) NOT NULL COMMENT '图片类型名称',
  `createTime` DATETIME NULL COMMENT '创建时间',
  `createBy` VARCHAR(20) NULL COMMENT '创建人',
  `updateTime` DATETIME NULL COMMENT '修改时间',
  `updateBy` VARCHAR(20) NULL COMMENT '修改人',
  `effectiveFrom` DATETIME NULL COMMENT '生效时间起',
  `effectiveTo` DATETIME NULL COMMENT '生效时间止'
);