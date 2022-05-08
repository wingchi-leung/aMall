
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
   `id` bigint(20) NOT NULL AUTO_INCREMENT,
   `username` varchar(32) NOT NULL COMMENT '用户名',
   `password` varchar(60) NOT NULL COMMENT '密码，加密存储',
   `phone` varchar(11) DEFAULT NULL COMMENT '注册手机号',
   `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
   `update_time` timestamp NULL DEFAULT NULL COMMENT '更新时间',
   PRIMARY KEY (`id`),
   UNIQUE KEY `username` (`username`) USING BTREE,
   UNIQUE KEY `phone` (`phone`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8 COMMENT='用户表';

DROP TABLE IF EXISTS `role`;
create table role (
    `id` bigint(20) NOT NULL PRIMARY KEY  AUTO_INCREMENT,
    `name` varchar(20) NOT NULL,
    `description` varchar(60) DEFAULT '' COMMENT '角色描述',
    `create_time` timestamp ,
    `update_time` timestamp
)ENGINE=InnoDB AUTO_INCREMENT=12  DEFAULT CHARSET=utf8 COMMENT='角色表';

insert into `role` (`id`,`name`,`description` ,`create_time`,`update_time`)values (9,'member','会员', (SELECT FROM_UNIXTIME(unix_timestamp(now()), '%Y-%m-%d %H:%i:%S')),NULL );
insert into `role` (`id`,`name`,`description` ,`create_time`,`update_time`)values (10,'user','普通用户', (SELECT FROM_UNIXTIME(unix_timestamp(now()), '%Y-%m-%d %H:%i:%S')),NULL );
insert into `role` (`id`,`name`,`description` ,`create_time`,`update_time`)values (11,'store_manager','商家', (SELECT FROM_UNIXTIME(unix_timestamp(now()), '%Y-%m-%d %H:%i:%S')),NULL );



DROP TABLE IF EXISTS `role_user`;
create table role_user(
    `role_id` bigint(20) ,
    `user_id` bigint(20) ,
    `create_time` timestamp ,
    `update_time` timestamp,
    primary key  (`role_id`,`user_id`)
)ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='角色和用户关系表,多对多的关系' ;
insert into `role_user` (`role_id`,`user_id`,`create_time`,`update_time`)values (10,28,(SELECT FROM_UNIXTIME(unix_timestamp(now()), '%Y-%m-%d %H:%i:%S')),NULL );
insert into `role_user` (`role_id`,`user_id`,`create_time`,`update_time`)values (10,29,(SELECT FROM_UNIXTIME(unix_timestamp(now()), '%Y-%m-%d %H:%i:%S')),NULL );
insert into `role_user` (`role_id`,`user_id`,`create_time`,`update_time`)values (11,31,(SELECT FROM_UNIXTIME(unix_timestamp(now()), '%Y-%m-%d %H:%i:%S')),NULL );
insert into `role_user` (`role_id`,`user_id`,`create_time`,`update_time`)values (9,32, (SELECT FROM_UNIXTIME(unix_timestamp(now()), '%Y-%m-%d %H:%i:%S')) , NULL );


DROP TABLE IF EXISTS `image`;
create table image (
    `url` varchar(255) not null ,
    `name` varchar(50),
    `category` varchar(20)  NOT NULL COMMENT '图片类别，查询的关键',
    `sku_id` bigint(20) not null ,
    `isMain` tinyint (1) not null default '1' COMMENT '是否为sku 的主图，0：不是  1：是 '
)ENGINE=InnoDB  DEFAULT CHARSET=utf8 COMMENT='图片表' ;

insert into `image` values ('https://raw.githubusercontent.com/wingchi-leung/imageTemporay/main/cms_1.jpg','cms_1.jpg','cms',1) ;
insert into `image` values ('https://raw.githubusercontent.com/wingchi-leung/imageTemporay/main/cms_2.jpg','cms_2.jpg','cms',1) ;
insert into `image` values ('https://raw.githubusercontent.com/wingchi-leung/imageTemporay/main/cms_3.jpg','cms_3.jpg','cms',1) ;
insert into `image` values('https://raw.githubusercontent.com/wingchi-leung/imageTemporay/main/cms_4.jpg','cms_4.jpg','cms',1) ;

insert into `image` values('https://raw.githubusercontent.com/wingchi-leung/imageTemporay/main/Redmi-k30.png','Redmi-k30','手机',2735902121,'1') ;
insert into `image` values('https://raw.githubusercontent.com/wingchi-leung/imageTemporay/main/Redmi-k30-1.png','Redmi-k30','手机',2735902121,'0') ;
insert into `image` values('https://raw.githubusercontent.com/wingchi-leung/imageTemporay/main/Redmi-k30-2.png','Redmi-k30','手机',2735902121,'0') ;
insert into `image` values('https://raw.githubusercontent.com/wingchi-leung/imageTemporay/main/Redmi-k30-3.png','Redmi-k30','手机',2735902121,'0') ;
insert into `image` values('https://raw.githubusercontent.com/wingchi-leung/imageTemporay/main/Redmi-k30-4.png','Redmi-k30','手机',2735902121,'0') ;



insert into `image` values('https://raw.githubusercontent.com/wingchi-leung/imageTemporay/main/Redmi-k30-5G.png','Redmi-k30-5G','手机',2735902122,'1') ;
insert into `image` values('https://raw.githubusercontent.com/wingchi-leung/imageTemporay/main/Mi-CC9.png','Mi-CC9','手机',2735902123,'1') ;
insert into `image` values('https://raw.githubusercontent.com/wingchi-leung/imageTemporay/main/Redmi-8.png','Redmi-8','手机',2735902124,'1') ;
insert into `image` values('https://raw.githubusercontent.com/wingchi-leung/imageTemporay/main/Redmi-8A.png','Redmi-8A','手机',2735902125,'1') ;
insert into `image` values('https://raw.githubusercontent.com/wingchi-leung/imageTemporay/main/Redmi-Note8-pro.png','Redmi-Note8-pro','手机',2735902127,'1') ;
insert into `image` values('https://github.com/wingchi-leung/imageTemporay/blob/main/Redmi-Note8.png','Redmi-Note8','手机',2735902128,'1') ;

insert into `image` values('https://raw.githubusercontent.com/wingchi-leung/imageTemporay/main/protectingMen-Mi-CC9.png','protectingMen-Mi-CC9','保护膜',1) ;
insert into `image` values('https://raw.githubusercontent.com/wingchi-leung/imageTemporay/main/protectingMen-Mi-CC9e.png','protectingMen-Mi-CC9e','保护膜',1) ;


insert into `image` values('https://raw.githubusercontent.com/wingchi-leung/imageTemporay/main/protectingShell-Mi-9.png','protectingShell-Mi-9','保护套',1) ;
insert into `image` values('https://raw.githubusercontent.com/wingchi-leung/imageTemporay/main/protectingShell-RedMi-K20&pro.png','protectingShell-RedMi-K20&pro','保护套',1) ;
insert into `image` values('https://raw.githubusercontent.com/wingchi-leung/imageTemporay/main/protectingShell-Mi-9SE.png','protectingShell-Mi-9SE.png','保护套',1) ;
insert into `image` values('https://raw.githubusercontent.com/wingchi-leung/imageTemporay/main/protectingShell-Mi-CC9Pro.png','protectingShell-Mi-CC9Pro.png','保护套',1 ;
insert into `image` values('https://raw.githubusercontent.com/wingchi-leung/imageTemporay/main/protectingShell-Mix-3.png','protectingShell-Mix-3','保护套',1) ;
insert into `image` values('https://raw.githubusercontent.com/wingchi-leung/imageTemporay/main/protectingShell-RedMi-K20.png','protectingShell-RedMi-K20','保护套',1) ;

insert into `image` values('https://raw.githubusercontent.com/wingchi-leung/imageTemporay/main/MiTv-4A-32.png','MiTv-4A-32','电视机',1) ;
insert into `image` values('https://raw.githubusercontent.com/wingchi-leung/imageTemporay/main/MiTv-4X-43.png','MiTv-4X-43','电视机',1) ;
insert into `image` values('https://raw.githubusercontent.com/wingchi-leung/imageTemporay/main/MiTv-E55A.png','MiTv-E55A','电视机',1) ;
insert into `image` values('https://raw.githubusercontent.com/wingchi-leung/imageTemporay/main/MiTv-E65A.png','MiTv-E65A','电视机',1) ;

insert into `image` values('https://raw.githubusercontent.com/wingchi-leung/imageTemporay/main/MiTv-4X-65.png','MiTv-4X-65','电视机',1) ;
insert into `image` values('https://raw.githubusercontent.com/wingchi-leung/imageTemporay/main/MiTv-4X-55.png','MiTv-4X-55','电视机',1) ;
insert into `image` values('https://raw.githubusercontent.com/wingchi-leung/imageTemporay/main/MiTv-ArtTv-65.png','MiTv-ArtTv-65','电视机',1) ;

insert into `image` values('https://raw.githubusercontent.com/wingchi-leung/imageTemporay/main/AirCondition-V1C1.png','AirCondition-V1C1','空调',1) ;
insert into `image` values('https://raw.githubusercontent.com/wingchi-leung/imageTemporay/main/AirCondition-F3W1.png','AirCondition-F3W1','空调',1) ;

insert into `image` values('https://raw.githubusercontent.com/wingchi-leung/imageTemporay/main/Washer-Pro-10.png','Washer-Pro-10','洗衣机',1) ;

insert into `image` values('https://raw.githubusercontent.com/wingchi-leung/imageTemporay/blob/main/accessory-promo1.png','accessory-promo1','耳机',1) ;
insert into `image` values('https://raw.githubusercontent.com/imageTemporay/blob/main/accessory-promo2.png','accessory-promo2','耳机',1) ;

insert into `image` values('https://raw.githubusercontent.com/wingchi-leung/imageTemporay/main/appliance-promo1.png','appliance-promo1','净水器',1);
insert into `image` values('https://raw.githubusercontent.com/wingchi-leung/imageTemporay/blob/main/appliance-promo2.png','appliance-promo2','净水器',1);


insert into `image` values('https://raw.githubusercontent.com/wingchi-leung/imageTemporay/main/charger-10000mAh.png','charger-10000mAh','充电器',1);
insert into `image` values('https://raw.githubusercontent.com/wingchi-leung/imageTemporay/main/charger-18w.png','charger-18w','充电器',1);
insert into `image` values('https://raw.githubusercontent.com/wingchi-leung/imageTemporay/main/charger-30w.png','charger-30w','充电器',1);

insert into `image` values('https://raw.githubusercontent.com/wingchi-leung/imageTemporay/main/charger-36w.png','charger-30w','充电器',1);
insert into `image` values('https://raw.githubusercontent.com/wingchi-leung/imageTemporay/main/charger-60w.png','charger-60w','充电器',1);
insert into `image` values('https://raw.githubusercontent.com/wingchi-leung/imageTemporay/main/charger-car-37w.png','charger-car-37w','充电器',1);
insert into `image` values('https://raw.githubusercontent.com/wingchi-leung/imageTemporay/main/charger-car.png','charger-car','充电器',1);
insert into `image` values('https://raw.githubusercontent.com/wingchi-leung/imageTemporay/main/charger-tio.png','charger-tio','充电器',1);


-- ----------------------------
-- Table structure for `tb_category`
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
                               `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '类目id',
                               `name` varchar(32) NOT NULL COMMENT '类目名称',
                               `parent_id` bigint(20) NOT NULL COMMENT '父类目id,顶级类目填0',
                               `is_parent` tinyint(1) NOT NULL COMMENT '是否为父节点，0为否，1为是',
                               `sort` tinyint(2) NOT NULL COMMENT '排序指数，越小越靠前',
                               `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '数据创建时间',
                               `update_time` timestamp NULL DEFAULT NULL COMMENT '数据更新时间',
                               PRIMARY KEY (`id`),
                               KEY `key_parent_id` (`parent_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=84 DEFAULT CHARSET=utf8 COMMENT='商品类目表，类目和商品(spu)是一对多关系，类目与品牌是多对多关系';

-- ----------------------------
-- Records of tb_category
-- ----------------------------
INSERT INTO `category` VALUES ('76', '手机', '0', '1', '2', (SELECT FROM_UNIXTIME(unix_timestamp(now()), '%Y-%m-%d %H:%i:%S')), NULL);
INSERT INTO `category` VALUES ('77', '充电宝', '0', '1', '1', (SELECT FROM_UNIXTIME(unix_timestamp(now()), '%Y-%m-%d %H:%i:%S'))  ,NULL);
INSERT INTO `category` values ('78', '洗衣机', '0', '1', '1', (SELECT FROM_UNIXTIME(unix_timestamp(now()), '%Y-%m-%d %H:%i:%S')),NULL );
INSERT INTO `category` VALUES ('79', '空调', '0', '1', '1', (SELECT FROM_UNIXTIME(unix_timestamp(now()), '%Y-%m-%d %H:%i:%S'))  ,NULL);
INSERT INTO `category` VALUES ('80', '电视机', '0', '1', '1', (SELECT FROM_UNIXTIME(unix_timestamp(now()), '%Y-%m-%d %H:%i:%S'))  ,NULL);
INSERT INTO `category` VALUES ('81', '保护膜', '0', '1', '1', (SELECT FROM_UNIXTIME(unix_timestamp(now()), '%Y-%m-%d %H:%i:%S'))  ,NULL);
INSERT INTO `category` VALUES ('82', '保护套', '0', '1', '1', (SELECT FROM_UNIXTIME(unix_timestamp(now()), '%Y-%m-%d %H:%i:%S'))  ,NULL);
INSERT INTO `category` VALUES ('83', '充电器', '0', '1', '1', (SELECT FROM_UNIXTIME(unix_timestamp(now()), '%Y-%m-%d %H:%i:%S'))  ,NULL);


DROP TABLE IF EXISTS `tb_spu`;
CREATE TABLE `tb_spu` (
                          `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'spu id',
                          `name` varchar(256) NOT NULL DEFAULT '' COMMENT '商品名称',
                          `sub_title` varchar(256) DEFAULT '' COMMENT '副标题，一般是促销信息',
                          `cid1` bigint(20) NOT NULL COMMENT '1级类目id',
                          `cid2` bigint(20) NOT NULL COMMENT '2级类目id',
                          `cid3` bigint(20) NOT NULL COMMENT '3级类目id',
                          `brand_id` bigint(20) NOT NULL COMMENT '商品所属品牌id',
                          `saleable` tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否上架，0下架，1上架',
                          `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
                          `update_time` timestamp NULL DEFAULT NULL COMMENT '最后修改时间',
                          PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=95 DEFAULT CHARSET=utf8 COMMENT='spu表，该表描述的是一个抽象性的商品，比如 iphone8';



DROP TABLE IF EXISTS `sku`;
create table `sku` (
    `id` bigint(20) primary key AUTO_INCREMENT,
    `spu_id` bigint(20) ,
    `name` varchar(20) not null ,
    `images` varchar(1024)  COMMENT '图片url,多个url以 , 分隔',
    `title` varchar(20) ,
    `description` text ,
    `price`  bigint(16)  COMMENT '以分为单位' ,
    `selling_price` bigint(16) COMMENT '以分为单位' ,
    `stock` int(8) COMMENT '库存' ,
    `enable` tinyint(1)  ,
    `category_name` varchar(20) ,
    `create_time` timestamp  ,
    `update_time` timestamp
)ENGINE=InnoDB AUTO_INCREMENT=27359021560  DEFAULT CHARSET=utf8 COMMENT='sku' ;

insert into `sku` values(2735902121,  NULL ,'Redmi K30',  NULL,'120Hz流速屏，全速热爱', '120Hz高帧率流速屏/ 索尼6400万前后六摄 / 6.67 小孔径全面屏 / 最高可选8GB+256GB大存储 / 高通骁龙730G处理器 / 3D四曲面玻璃机身 / 4500mAh+27W快充 / 多功能NFC',
                         200000,  159900,10000,1, '手机' , (SELECT FROM_UNIXTIME(unix_timestamp(now()), '%Y-%m-%d %H:%i:%S')),NULL) ;

insert into `sku` values(2735902122,  NULL ,'Redmi K30 5G',  NULL,'双模5G,120Hz流速屏', '双模5G / 三路并发 / 高通骁龙765G / 7nm 5G低功耗处理器 / 120Hz高帧率流速屏 / 6.67 小孔径全面屏 / 索尼6400万前后六摄 / 最高可选8GB+256GB大存储 / 4500mAh+30W快充 / 3D四曲面玻璃机身 / 多功能NFC',
                         159900,  159900,900,1,'手机' ,(SELECT FROM_UNIXTIME(unix_timestamp(now()), '%Y-%m-%d %H:%i:%S')),NULL) ;

insert into `sku` values(2735902123,  NULL ,'小米CC9 Pro',  NULL,'1亿像素,五摄四闪', '双模5G / 三路并发 / 高通骁龙765G / 7nm 5G低功耗处理器 / 120Hz高帧率流速屏 / 6.67 小孔径全面屏 / 索尼6400万前后六摄 / 最高可选8GB+256GB大存储 / 4500mAh+30W快充 / 3D四曲面玻璃机身 / 多功能NFC',
                         259900,  259900,900,1,'手机' ,(SELECT FROM_UNIXTIME(unix_timestamp(now()), '%Y-%m-%d %H:%i:%S')),NULL) ;


insert into `sku` values(2735902124,  NULL ,'Redmi 8',  NULL,'5000mAh超长续航', '5000mAh超长续航 / 高通骁龙439八核处理器 / 4GB+64GB',
                         79900,  69900,900,1,'手机' ,(SELECT FROM_UNIXTIME(unix_timestamp(now()), '%Y-%m-%d %H:%i:%S')),NULL) ;

insert into `sku` values(2735902125,  NULL ,'Redmi 8A',  NULL,'5000mAh超长续航', '5000mAh超长续航 / 高通骁龙439八核处理器 / 4GB+64GB',
                         69900,  59900,900,1,'手机' ,(SELECT FROM_UNIXTIME(unix_timestamp(now()), '%Y-%m-%d %H:%i:%S')),NULL) ;


-- insert into `sku` values(2735902126,  NULL ,'Redmi 8A',  NULL,'5000mAh超长续航', '5000mAh超长续航 / 高通骁龙439八核处理器 / 4GB+64GB',
--                          69900,  59900,900,1,'手机' ,(SELECT FROM_UNIXTIME(unix_timestamp(now()), '%Y-%m-%d %H:%i:%S')),NULL) ;

insert into `sku` values(2735902127,  NULL ,'Redmi Note8 Pro',  NULL,'6400万全场景四摄', '6400万四摄小金刚拍照新旗舰超强解析力，超震撼',
                         139900,  119900,900,1,'手机' ,(SELECT FROM_UNIXTIME(unix_timestamp(now()), '%Y-%m-%d %H:%i:%S')),NULL) ;

insert into `sku` values(2735902128,  NULL ,'Redmi Note8',  NULL,'千元4800万四摄', '千元4800万四摄 | 高通骁龙665 | 小金刚品质保证',
                         99900,  99900,900,1,'手机' ,(SELECT FROM_UNIXTIME(unix_timestamp(now()), '%Y-%m-%d %H:%i:%S')),NULL) ;



DROP TABLE IF EXISTS `shoppingcart`;
CREATE TABLE `shoppingcart` (
                                   `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
                                   `user_id` bigint(20) NOT NULL COMMENT '用户ID' ,
                                   `sku_id` bigint(20) NOT NULL COMMENT 'skuid',
                                   `quanty` decimal(18,2) DEFAULT NULL COMMENT '数量',
                                   `price` decimal(18,2) DEFAULT NULL COMMENT '单价',
                                   `amount` decimal(18,2) DEFAULT NULL COMMENT '金额',
                                   `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                   `update_time` timestamp NULL DEFAULT NULL COMMENT '更新时间',
                                   `canceled` tinyint(1) DEFAULT 0 NULL COMMENT '是否取消',
                                   PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ;

insert into `shoppingcart` values(1,28,2735902121,1,1599,1599,(SELECT FROM_UNIXTIME(unix_timestamp(now()), '%Y-%m-%d %H:%i:%S')),NULL,'1') ;
insert into `shoppingcart` values(2,28,2735902122,1,2000,2000,(SELECT FROM_UNIXTIME(unix_timestamp(now()), '%Y-%m-%d %H:%i:%S')),NULL,'1') ;
insert into `shoppingcart` values(3,28,2735902123,2,2599,2599*2,(SELECT FROM_UNIXTIME(unix_timestamp(now()), '%Y-%m-%d %H:%i:%S')),NULL,'1') ;


DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
                            `order_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '订单id',
                            `total_fee` decimal(18,2) NOT NULL COMMENT '总费用',
                            `actual_fee` decimal(18,2) NOT NULL COMMENT '实际支付费用',
                            `promotion_id` varchar(256) COLLATE utf8_bin DEFAULT '' COMMENT '优惠活动id，多个以，隔开',
                            `payment_type` tinyint(1) unsigned zerofill NOT NULL COMMENT '支付类型，1、在线支付，2、货到付款',
                            `post_fee` decimal(18,2) NOT NULL COMMENT '邮费。',
                            `user_id` bigint(20) NOT NULL COMMENT '用户id',
                            `invoice_type` int(1) DEFAULT '0' COMMENT '发票类型(0无发票1普通发票，2电子发票，3增值税发票)',
                            `source_type` int(1) DEFAULT '2' COMMENT '订单来源：1:app端，2：pc端，3：微信端',
                            `status` tinyint(1) DEFAULT NULL COMMENT '订单的状态，1、未付款 2、已付款,未发货 3、已发货,未确认 4、确认收货，交易成功 5、交易取消，订单关闭 6、交易结束，已评价',
                            `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                            `pay_time` timestamp NULL DEFAULT NULL COMMENT '支付时间',
                            `consign_time` timestamp NULL DEFAULT NULL COMMENT '发货时间',
                            `end_time` timestamp NULL DEFAULT NULL COMMENT '交易完成时间',
                            `close_time` timestamp NULL DEFAULT NULL COMMENT '交易关闭时间',
                            `comment_time` timestamp NULL DEFAULT NULL COMMENT '评价时间',
                            `update_time` timestamp NULL DEFAULT NULL COMMENT '更新时间',
                            PRIMARY KEY (`order_id`),
                            KEY `multi_key_status_time` (`status`,`create_time`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1011819872783007745 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;


DROP TABLE IF EXISTS `order_detail`;
CREATE TABLE `order_detail` (
                                   `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '订单详情id ',
                                   `order_id` bigint(20) NOT NULL COMMENT '订单id',
                                   `sku_id` bigint(20) NOT NULL COMMENT 'sku商品id',
                                   `num` int(4) NOT NULL COMMENT '购买数量',
                                   `title` varchar(256) NOT NULL COMMENT '商品标题',
                                   `own_spec` varchar(1024) DEFAULT '' COMMENT '商品动态属性键值集',
                                   `price` int(16) NOT NULL COMMENT '价格,单位：分',
                                   `image` varchar(256) DEFAULT '' COMMENT '商品图片',
                                   `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                                   `update_time` timestamp NULL DEFAULT NULL COMMENT '更新时间',
                                   PRIMARY KEY (`id`),
                                   KEY `key_order_id` (`order_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8 COMMENT='订单详情表';



select b.order_id,b.create_time,b.total_fee, a.sku_id,a.num,a.title,a.price,a.image,a.id
        from `order_detail` a,`order` b
        where  a.order_id=b.order_id and b.user_id=28;


select b.order_id,b.create_time,b.total_fee, a.sku_id,a.num,a.title,a.price,a.image,a.id
from `order_detail` a,`order` b
where  a.order_id=b.order_id and b.user_id=#{userId}