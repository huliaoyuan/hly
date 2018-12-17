/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50556
Source Host           : localhost:3306
Source Database       : hlytest

Target Server Type    : MYSQL
Target Server Version : 50556
File Encoding         : 65001

Date: 2018-12-17 15:21:26
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_class
-- ----------------------------
DROP TABLE IF EXISTS `t_class`;
CREATE TABLE `t_class` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `class` varchar(255) DEFAULT NULL,
  `userid` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `userid` (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_class
-- ----------------------------
INSERT INTO `t_class` VALUES ('11', '三年二班', '21321', '2');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `userid` varchar(50) NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `classid` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1c8798f464df4cdba31504db95ce4e9d', '盖伦啊啊啊1', '80082088201', '1', '11');
INSERT INTO `t_user` VALUES ('2', '盖伦', '123', '234', '11');
INSERT INTO `t_user` VALUES ('294a2957d53d48d4a677dc975297048d', null, '123', '234', '11');
INSERT INTO `t_user` VALUES ('29913213551f47ac8849068ca6891e5e', null, '123', '5', '11');
INSERT INTO `t_user` VALUES ('3', '盖伦', '123', '4', '11');
INSERT INTO `t_user` VALUES ('3081a691b95f4a72a42361b27448704c', '盖伦啊啊啊1', '80082088201', '567', '11');
INSERT INTO `t_user` VALUES ('4', '盖伦', '123', '678', '11');
INSERT INTO `t_user` VALUES ('5', '123', '123', '678', '11');
INSERT INTO `t_user` VALUES ('5335da102c3740a2849ea0f8d9d5b62b', null, '123', 'yu', '11');
INSERT INTO `t_user` VALUES ('54a40868c50047ca8595425df751c5f3', null, '123', '6', '11');
INSERT INTO `t_user` VALUES ('6', '342', '234', '45', '11');
INSERT INTO `t_user` VALUES ('7', '2334', '23432', '234', '11');
INSERT INTO `t_user` VALUES ('70160576ed964ac5a97ba68432b3f8d8', null, '123', '23', '11');
INSERT INTO `t_user` VALUES ('8', '盖伦', '123', '123', '11');
INSERT INTO `t_user` VALUES ('8597d8a9bacd4c5aa122cfaeffb16801', '盖伦啊啊啊1', '80082088201', '12', '11');
INSERT INTO `t_user` VALUES ('881809904d904839b250f65f938fa8d2', null, '123', '34', '11');
INSERT INTO `t_user` VALUES ('a51d068e7ff14c8dae3149e0fde2023a', null, '123', '234', '11');
INSERT INTO `t_user` VALUES ('a82e28f92b804996b8397412e93402e4', null, '123', '234', '11');
INSERT INTO `t_user` VALUES ('abb55e9f2a6c4ba7910b81c3f12c6055', null, '123', '234', '11');
INSERT INTO `t_user` VALUES ('b4a25a6a53f14ccfa691af464817db2b', null, '123', '234', '11');
INSERT INTO `t_user` VALUES ('b5e84a6f473a4423a73378ece46381f8', null, '123', '3444', '11');
INSERT INTO `t_user` VALUES ('d956ce029f7e4160a09c0f836fc45de8', null, '123', '23', '11');
