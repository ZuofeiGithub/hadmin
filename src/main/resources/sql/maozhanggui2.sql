/*
SQLyog Ultimate v11.33 (64 bit)
MySQL - 5.6.42 : Database - catshopkeeper
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`catshopkeeper` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `catshopkeeper`;

/*Table structure for table `business` */

DROP TABLE IF EXISTS `business`;

CREATE TABLE `business` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '商家id',
  `businessName` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '商家名称',
  `businessPhone` varchar(11) COLLATE utf8_bin DEFAULT NULL COMMENT '商家电话',
  `businessAddress` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '商家地址',
  `imgUrl` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '商家logo',
  `creationTime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC COMMENT='商家表';

/*Data for the table `business` */

insert  into `business`(`id`,`businessName`,`businessPhone`,`businessAddress`,`imgUrl`,`creationTime`) values (1,'汇客通','11111111111','1','http://localhost:8080/File/image/upload/4d404ff4bedb4133a0aded99b55a0ab6.png','2019-01-23 14:25:35'),(14,'九鼎商家','11111111111','33','http://localhost:8080/File/image/upload/2c9254c6e42b4d4d9ba87b77ff96261e.jpg','2019-01-23 14:26:00');

/*Table structure for table `customer` */

DROP TABLE IF EXISTS `customer`;

CREATE TABLE `customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '客户id',
  `customer_name` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '客户姓名',
  `customer_phone` varchar(11) COLLATE utf8_bin DEFAULT NULL COMMENT '客户电话',
  `customer__address` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '客户地址',
  `businessId` int(11) DEFAULT NULL COMMENT '关联商家ID',
  `addTime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '添加时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC COMMENT='客户表';

/*Data for the table `customer` */

insert  into `customer`(`id`,`customer_name`,`customer_phone`,`customer__address`,`businessId`,`addTime`) values (4,'张三555','11133333333','单身快乐即可将',14,'2019-01-30 11:15:29'),(5,'123','11111111111','213',14,'2019-01-30 11:23:00');

/*Table structure for table `design_management` */

DROP TABLE IF EXISTS `design_management`;

CREATE TABLE `design_management` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '设计图id',
  `design_area` int(4) DEFAULT NULL COMMENT '设计图面积',
  `design_style` int(4) DEFAULT NULL COMMENT '设计图风格',
  `design_budget` int(4) DEFAULT NULL COMMENT '设计图预算',
  `design_url` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '设计图预览地址',
  `businessId` int(11) DEFAULT NULL COMMENT '商家id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC COMMENT='设计图管理';

/*Data for the table `design_management` */

insert  into `design_management`(`id`,`design_area`,`design_style`,`design_budget`,`design_url`,`businessId`) values (4,3,8,13,'http://localhost:8080/File/image/upload/ec6cb33e05e94dc881fcd5fdcfbb274d.jpg',14),(5,2,6,12,'http://localhost:8080/File/image/upload/c2c357dce5ce4240ae58571fba907942.png',14),(6,4,10,15,'http://localhost:8080/File/image/upload/2b84b13962394bd3b176e91d2113113d.png',1);

/*Table structure for table `device_management` */

DROP TABLE IF EXISTS `device_management`;

CREATE TABLE `device_management` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '设备id',
  `deviceCode` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '设备编号',
  `deviceName` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '设备名称',
  `deviceStatus` int(4) DEFAULT NULL COMMENT '设备状态',
  `deviceAddress` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '设备地址',
  `device_longitude` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '设备经度',
  `device_dimension` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '设备维度',
  `businessId` int(11) DEFAULT NULL COMMENT '商家ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC COMMENT='设备管理表';

/*Data for the table `device_management` */

insert  into `device_management`(`id`,`deviceCode`,`deviceName`,`deviceStatus`,`deviceAddress`,`device_longitude`,`device_dimension`,`businessId`) values (1,'001','猫掌柜56',1,'中江电商港',NULL,NULL,14),(6,'005','鞍山市',NULL,'dfdf',NULL,NULL,1);

/*Table structure for table `role_menu` */

DROP TABLE IF EXISTS `role_menu`;

CREATE TABLE `role_menu` (
  `role_id` varchar(32) DEFAULT NULL COMMENT '角色ID',
  `menu_id` varchar(32) DEFAULT NULL COMMENT '菜单ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='角色和菜单关联表';

/*Data for the table `role_menu` */

insert  into `role_menu`(`role_id`,`menu_id`) values ('1','3'),('1','1'),('1','4'),('1','5'),('1','6'),('1','7'),('2','11'),('2','2'),('1','2'),('2','3'),('1','12');

/*Table structure for table `role_user` */

DROP TABLE IF EXISTS `role_user`;

CREATE TABLE `role_user` (
  `user_id` int(32) DEFAULT NULL COMMENT '用户ID',
  `role_id` int(32) DEFAULT NULL COMMENT '角色ID',
  `id` int(32) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='用户和角色关联表';

/*Data for the table `role_user` */

insert  into `role_user`(`user_id`,`role_id`,`id`) values (5,1,1);

/*Table structure for table `sys_dictionaries` */

DROP TABLE IF EXISTS `sys_dictionaries`;

CREATE TABLE `sys_dictionaries` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '字典id',
  `parentId` int(11) DEFAULT NULL COMMENT '父类id',
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '字典名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC COMMENT='系统字典表';

/*Data for the table `sys_dictionaries` */

insert  into `sys_dictionaries`(`id`,`parentId`,`name`) values (1,0,'面积'),(2,1,'70-90平'),(3,1,'90-110平'),(4,1,'110平以上'),(5,0,'风格'),(6,5,'美式'),(7,5,'欧式经典'),(8,5,'日系小清新'),(9,5,'北欧极简'),(10,5,'新中式'),(11,0,'预算'),(12,11,'20w以内'),(13,11,'20w-30w'),(14,11,'30w-50w'),(15,11,'50w以上');

/*Table structure for table `sys_menu` */

DROP TABLE IF EXISTS `sys_menu`;

CREATE TABLE `sys_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '菜单id',
  `title` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '菜单名称',
  `parent_id` int(11) DEFAULT NULL COMMENT '父菜单ID',
  `href` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '请求地址',
  `icon` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '菜单图标',
  `menu_type` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '菜单类型（M目录 C菜单 ）',
  `sort` int(11) DEFAULT '0',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC COMMENT='菜单权限表';

/*Data for the table `sys_menu` */

insert  into `sys_menu`(`id`,`title`,`parent_id`,`href`,`icon`,`menu_type`,`sort`) values (1,'商家管理',0,'/business/businessHtml','fa fa-home','M',2),(2,'设备管理',0,'/deviceManagement/deviceHtml','fa  fa-chrome','M',3),(3,'设计图管理',0,'/designManagemen/designHtml','fa  fa-chrome','M',4),(4,'系统管理',0,NULL,'fa  fa-chrome','admin',5),(5,'后台账号管理',4,'/userInfo/userInfoHtml',NULL,'admin',6),(6,'角色管理',4,'https://www.baidu.com/',NULL,'admin',7),(7,'管理员操作日志',4,'https://www.baidu.com/',NULL,'admin',8),(11,'客户管理',0,'/customer/customerHtml','fa  fa-chrome','M',9),(12,'主页',0,'home','layui-icon-home','M',0);

/*Table structure for table `sys_role` */

DROP TABLE IF EXISTS `sys_role`;

CREATE TABLE `sys_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `role_name` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '角色名称',
  `role` varchar(11) COLLATE utf8_bin DEFAULT 'ROLE_USER',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC COMMENT='角色表';

/*Data for the table `sys_role` */

insert  into `sys_role`(`id`,`role_name`,`role`) values (1,'超级管理员','ROLE_ADMIN'),(2,'商家用户','ROLE_USER');

/*Table structure for table `sys_user` */

DROP TABLE IF EXISTS `sys_user`;

CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '用户密码',
  `businessId` int(11) DEFAULT NULL COMMENT '关联商家id',
  `imgUrl` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '商家管理员头像',
  `salt` varchar(32) COLLATE utf8_bin DEFAULT '',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC COMMENT='用户表';

/*Data for the table `sys_user` */

insert  into `sys_user`(`id`,`username`,`password`,`businessId`,`imgUrl`,`salt`) values (5,'admin','7b75a212d47b6b2d9df0a7571c8f9394',0,'','[B@76f77709');

/*Table structure for table `token_manager` */

DROP TABLE IF EXISTS `token_manager`;

CREATE TABLE `token_manager` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `access_token` varchar(1024) NOT NULL DEFAULT '',
  `update_time` datetime DEFAULT NULL,
  `device_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

/*Data for the table `token_manager` */

insert  into `token_manager`(`id`,`access_token`,`update_time`,`device_id`) values (1,'23123','2019-02-14 12:47:17','123123'),(3,'24.228d1b352c1bafcd39a364e911b4ce7b.2592000.1552715611.282335-15485182','2019-02-14 13:53:26','b5e0da1a-aa51-4df1-bd65-36b271b1126e'),(4,'24.8771b6b3b336d8aef6aec0bf19ce06f2.2592000.1552724878.282335-15485182','2019-02-14 16:27:54','12a2ea9a-c4ac-4772-922e-27b1798f3f89'),(5,'24.d890be29069328d2bd8ab8f805fe7c99.2592000.1552800268.282335-15485182','2019-02-15 13:24:26','0a602365-7791-47b8-a6e5-0de543ab97fc'),(6,'24.38c32143092e74d251eb56928e73b5b7.2592000.1552805427.282335-15485182','2019-02-15 14:50:25','f8768af5-d148-4242-904a-a23821d37c1c'),(7,'24.199faaf3805db0a66e585cdc17d559f7.2592000.1552875910.282335-15485182','2019-02-16 10:25:05','7853ef95-a547-4085-a164-b1dddc758ace'),(8,'24.ec6eafeaad36b17bc470bf765ebc7d79.2592000.1552878442.282335-15485182','2019-02-16 11:07:18','dacbb066-ab77-4770-99bb-23ab765311bd'),(9,'24.4f3237a2cb84143768fa49b02493db2c.2592000.1553138819.282335-15485182','2019-02-19 11:26:59','3b92dcce-579d-41b5-9c57-5f68ba5dbf0f'),(10,'24.cafdd6564f69a2aabb151d682e4832f0.2592000.1553139604.282335-15485182','2019-02-19 11:40:03','07f43bed-6e3e-4737-9e05-383942a83419'),(11,'24.667cdfcdfd8a8104a80feda596c97e31.2592000.1553410081.282335-15485182','2019-02-22 14:48:00','836d5d835648f0c2'),(12,'24.c6a844921ad0297abdb1bfd96774b302.2592000.1553415670.282335-15485182','2019-02-22 16:21:10','2a3c6ccc88941ce7');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
