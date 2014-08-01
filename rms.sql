/*
SQLyog Ultimate v11.24 (32 bit)
MySQL - 5.0.85-community-nt : Database - rms
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`rms` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `rms`;

/*Table structure for table `r_data_obj` */

DROP TABLE IF EXISTS `r_data_obj`;

CREATE TABLE `r_data_obj` (
  `do_id` int(11) NOT NULL auto_increment,
  `dt_id` int(11) NOT NULL,
  `group_name` varchar(50) NOT NULL,
  PRIMARY KEY  (`do_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `r_data_obj` */

/*Table structure for table `r_data_permission` */

DROP TABLE IF EXISTS `r_data_permission`;

CREATE TABLE `r_data_permission` (
  `do_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  `sf_id` int(11) NOT NULL,
  PRIMARY KEY  (`do_id`,`role_id`,`sf_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `r_data_permission` */

/*Table structure for table `r_data_type` */

DROP TABLE IF EXISTS `r_data_type`;

CREATE TABLE `r_data_type` (
  `dt_id` int(11) NOT NULL auto_increment,
  `type_name` varchar(50) NOT NULL,
  PRIMARY KEY  (`dt_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `r_data_type` */

/*Table structure for table `r_datatype_res` */

DROP TABLE IF EXISTS `r_datatype_res`;

CREATE TABLE `r_datatype_res` (
  `dt_id` int(11) NOT NULL,
  `sr_id` int(11) NOT NULL,
  PRIMARY KEY  (`dt_id`,`sr_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `r_datatype_res` */

/*Table structure for table `r_role` */

DROP TABLE IF EXISTS `r_role`;

CREATE TABLE `r_role` (
  `role_id` int(11) NOT NULL auto_increment,
  `role_name` varchar(50) NOT NULL,
  PRIMARY KEY  (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

/*Data for the table `r_role` */

insert  into `r_role`(`role_id`,`role_name`) values (1,'销售人员'),(2,'运营人员'),(3,'产品经理'),(4,'PM'),(5,'售后'),(6,'超级管理员'),(7,'大区经理'),(8,'客服人员'),(9,'百度人员'),(10,'腾讯人员'),(11,'阿里人员'),(12,'BAT');

/*Table structure for table `r_role_permission` */

DROP TABLE IF EXISTS `r_role_permission`;

CREATE TABLE `r_role_permission` (
  `role_id` int(11) NOT NULL,
  `sf_id` int(11) NOT NULL,
  PRIMARY KEY  (`role_id`,`sf_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `r_role_permission` */

insert  into `r_role_permission`(`role_id`,`sf_id`) values (6,3),(6,4),(6,6),(6,7),(6,8),(9,9),(9,10),(9,11),(10,15),(10,16),(11,12),(11,13),(11,14),(12,9),(12,10),(12,11),(12,12),(12,13),(12,14),(12,15),(12,16),(12,18),(12,19);

/*Table structure for table `r_sys_function` */

DROP TABLE IF EXISTS `r_sys_function`;

CREATE TABLE `r_sys_function` (
  `sf_id` int(11) NOT NULL auto_increment,
  `sr_id` int(11) NOT NULL,
  `operate_code` varchar(20) NOT NULL,
  `func_name` varchar(50) NOT NULL,
  PRIMARY KEY  (`sf_id`,`operate_code`,`sr_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

/*Data for the table `r_sys_function` */

insert  into `r_sys_function`(`sf_id`,`sr_id`,`operate_code`,`func_name`) values (3,5,'view','用户管理.查看(view)'),(4,4,'view','后台管理.查看(view)'),(6,7,'view','操作管理.查看(view)'),(7,6,'view','角色管理.查看(view)'),(8,8,'view','菜单管理.查看(view)'),(9,9,'view','百度.查看(view)'),(10,11,'view','百度贴吧.查看(view)'),(11,10,'view','百度首页.查看(view)'),(12,14,'view','阿里菜单.查看(view)'),(13,16,'view','淘宝网.查看(view)'),(14,15,'view','阿里首页.查看(view)'),(15,12,'view','腾讯菜单.查看(view)'),(16,13,'view','腾讯首页.查看(view)'),(18,10,'update','百度首页.修改(update)'),(19,11,'qiaoqiaohua','百度贴吧.悄悄话(qiaoqiaohua)');

/*Table structure for table `r_sys_operate` */

DROP TABLE IF EXISTS `r_sys_operate`;

CREATE TABLE `r_sys_operate` (
  `so_id` int(11) NOT NULL auto_increment,
  `operate_name` varchar(50) NOT NULL,
  `operate_code` varchar(20) NOT NULL,
  PRIMARY KEY  (`so_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `r_sys_operate` */

insert  into `r_sys_operate`(`so_id`,`operate_name`,`operate_code`) values (1,'查看','view'),(2,'修改','update'),(3,'删除','del'),(4,'添加','add'),(5,'悄悄话','qiaoqiaohua');

/*Table structure for table `r_sys_res` */

DROP TABLE IF EXISTS `r_sys_res`;

CREATE TABLE `r_sys_res` (
  `sr_id` int(11) NOT NULL auto_increment,
  `parent_id` int(11) default NULL,
  `res_name` varchar(50) NOT NULL,
  `url` varchar(100) default NULL,
  PRIMARY KEY  (`sr_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

/*Data for the table `r_sys_res` */

insert  into `r_sys_res`(`sr_id`,`parent_id`,`res_name`,`url`) values (4,0,'后台管理',''),(5,4,'用户管理','manager/user.jsp'),(6,4,'角色管理','manager/role.jsp'),(7,4,'操作管理','manager/sysOperate.jsp'),(8,4,'菜单管理','manager/sysRes.jsp'),(9,0,'百度菜单',''),(10,9,'百度首页','baidu/index.jsp'),(11,9,'百度贴吧','baidu/tieba.jsp'),(12,0,'腾讯菜单',''),(13,12,'腾讯首页','qq/index.jsp'),(14,0,'阿里菜单',''),(15,14,'阿里首页','alibaba/index.jsp'),(16,14,'淘宝网','alibaba/taobao.jsp');

/*Table structure for table `r_user` */

DROP TABLE IF EXISTS `r_user`;

CREATE TABLE `r_user` (
  `username` varchar(50) NOT NULL,
  `password` varchar(200) NOT NULL,
  `add_time` datetime NOT NULL,
  `last_login_date` datetime default NULL,
  PRIMARY KEY  (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `r_user` */

insert  into `r_user`(`username`,`password`,`add_time`,`last_login_date`) values ('admin','1000:7377e47393d04c49afc7bd02eeab77fa93e92f847d62316f:ebfe6fde6b64b18ea1ed938b0b66a2937c058d56830a09bc','2014-07-21 15:01:18','2014-07-31 09:58:12'),('Jack','1000:7a160a510f8ca5e68f491117f87c221448d3e2f83bc619a2:fdac266c302345014cb2ed5d87276500b0188314be335834','2014-07-21 17:42:15','2014-07-21 17:43:44'),('Toom','1000:7579ca45d74386b6f628d21dfc195040628b16a5a7108b8e:7f037e7cb1bd4b36b969ca602f65758086ec0da2c26bc24c','2014-07-21 16:32:12',NULL),('user_ali','1000:069a760ed3ab5493e3261f9493038c4d4ec2447235b8b69e:43e9dba3eeaae73a5f094f72662eca3c73e5c07bbb4c9c85','2014-07-29 17:02:51','2014-07-29 17:22:08'),('user_baidu','1000:21e8d2013ab3777086ea804673804a21c50d790ccf2fc857:a19f5124721fdeaa63fc210382ef7a18f1dd9596d3f71fad','2014-07-29 16:47:21','2014-07-30 16:32:21'),('user_baidu2','1000:66a1968e3be1e87faf4b61680fb3167059574ba040d3a17b:93cf0abe18a3a055cea4aa1a0c8f1602344b0fafc2fca52e','2014-07-30 15:01:25','2014-07-30 15:02:17'),('user_BAT','1000:2ecc01bff75d8e68390e3fd4547a2ad250181221ab796302:63f03efb32ee55b5f7a71ea4dc7e7013373bd452f4a450ae','2014-07-29 17:03:05','2014-07-30 16:32:03'),('user_qq','1000:a52ec23aaa533ae1642da3186a4687e70eb80afd4584f30c:d90e33a3f60f31f3b2eb06165eb7cd544b0bdbc397bc2d09','2014-07-29 17:02:41','2014-07-29 17:21:58');

/*Table structure for table `r_user_role` */

DROP TABLE IF EXISTS `r_user_role`;

CREATE TABLE `r_user_role` (
  `username` varchar(50) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY  (`username`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `r_user_role` */

insert  into `r_user_role`(`username`,`role_id`) values ('admin',6),('Jack',1),('Toom',3),('Toom',4),('user_ali',11),('user_baidu',9),('user_baidu2',9),('user_BAT',12),('user_qq',10);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
