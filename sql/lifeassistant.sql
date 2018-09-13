/*
Navicat MySQL Data Transfer

Source Server         : Szc
Source Server Version : 50552
Source Host           : localhost:3306
Source Database       : lifeassistant

Target Server Type    : MYSQL
Target Server Version : 50552
File Encoding         : 65001

Date: 2018-04-10 14:33:14
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_life
-- ----------------------------
DROP TABLE IF EXISTS `sys_life`;
CREATE TABLE `sys_life` (
  `id` varchar(64) NOT NULL,
  `imgUrl` varchar(200) DEFAULT NULL,
  `title` varchar(200) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `message` varchar(200) DEFAULT NULL,
  `number` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_life
-- ----------------------------
INSERT INTO `sys_life` VALUES ('1', 'http://127.0.0.1:8080/lifeAssistant/picture/timg.jpg', '橘子皮', '2018-04-09 17:16:37', '橘子皮橘子皮橘子皮橘子皮橘子皮橘子皮橘子皮橘子皮橘子皮', '1');

-- ----------------------------
-- Table structure for sys_shop
-- ----------------------------
DROP TABLE IF EXISTS `sys_shop`;
CREATE TABLE `sys_shop` (
  `id` varchar(64) NOT NULL,
  `title` varchar(200) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `startDate` datetime DEFAULT NULL,
  `endDate` datetime DEFAULT NULL,
  `imgUrl` varchar(200) DEFAULT NULL,
  `message` varchar(200) DEFAULT NULL,
  `number` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_shop
-- ----------------------------
INSERT INTO `sys_shop` VALUES ('213', 'sadas', '2018-04-09 21:45:48', null, null, 'http://127.0.0.1:8080/lifeAssistant/picture/10799348,2560,1600.jpg', 'asdasda', '4');
INSERT INTO `sys_shop` VALUES ('313', 'test', '2018-04-09 21:45:51', null, null, 'http://127.0.0.1:8080/lifeAssistant/picture/10078658,2560,1600.jpg', 'testtesttesttesttesttest', '1');
INSERT INTO `sys_shop` VALUES ('422', '清仓大甩卖', '2018-04-10 14:32:31', null, null, 'http://127.0.0.1:8080/lifeAssistant/picture/13022455,2560,1600.jpg', '清仓大甩卖白送了', '2');
INSERT INTO `sys_shop` VALUES ('425', 'wer', '2018-04-09 21:46:01', '2018-04-11 00:00:00', '2018-04-13 00:00:00', 'http://127.0.0.1:8080/lifeAssistant/picture/10747628,2560,1600.jpg', 'sdqewq', '5');
INSERT INTO `sys_shop` VALUES ('897', 'sdf', '2018-04-09 21:46:27', '2018-04-04 00:00:00', '2018-04-10 00:00:00', 'http://127.0.0.1:8080/lifeAssistant/picture/13015598,2560,1600.jpg', 'e1dasdsad', '6');
INSERT INTO `sys_shop` VALUES ('914', '清仓大甩卖', '2018-04-09 21:41:02', '2018-04-10 00:00:00', '2018-04-13 00:00:00', 'http://127.0.0.1:8080/lifeAssistant/picture/13015598,2560,1600.jpg', '清仓大甩卖清仓大甩卖清仓大甩卖清仓大甩卖清仓大甩卖清仓大甩卖', '3');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` varchar(64) NOT NULL,
  `userName` varchar(200) NOT NULL,
  `phone` varchar(200) DEFAULT NULL,
  `passWord` varchar(100) NOT NULL,
  `type` char(1) DEFAULT NULL,
  `eamil` varchar(200) DEFAULT NULL,
  `headImg` varchar(200) DEFAULT NULL,
  `price` decimal(23,4) DEFAULT NULL,
  `startTime` datetime DEFAULT NULL,
  `endTime` datetime DEFAULT NULL,
  `number` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'administrator', '110', '123456', '0', '82120479@qq.com', null, null, null, null, '1');
INSERT INTO `sys_user` VALUES ('2', 'admin', '112', 'e10adc3949ba59abbe56e057f20f883e', '1', '936626012@qq.com', null, null, null, null, '2');

-- ----------------------------
-- Table structure for sys_vip
-- ----------------------------
DROP TABLE IF EXISTS `sys_vip`;
CREATE TABLE `sys_vip` (
  `id` varchar(64) NOT NULL,
  `name` varchar(30) DEFAULT NULL,
  `headImg` varchar(200) DEFAULT NULL,
  `birthday` datetime DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `phone` varchar(200) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `number` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_vip
-- ----------------------------
INSERT INTO `sys_vip` VALUES ('1', '小时光', null, '2011-04-10 00:00:00', '苏州市', '13911211243', '2018-04-09 17:02:12', '1');
INSERT INTO `sys_vip` VALUES ('574', '小小时光', null, '2018-04-10 00:00:00', '雨花台', '123142342566', null, '3');
INSERT INTO `sys_vip` VALUES ('888', '小时光谷', null, '2008-04-10 00:00:00', '苏州大学123', '1239001274', '2018-04-09 16:08:03', '2');
