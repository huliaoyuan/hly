/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50556
Source Host           : localhost:3306
Source Database       : hlytest

Target Server Type    : MYSQL
Target Server Version : 50556
File Encoding         : 65001

Date: 2019-01-18 11:56:43
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for attachment
-- ----------------------------
DROP TABLE IF EXISTS `attachment`;
CREATE TABLE `attachment` (
  `id` varchar(50) NOT NULL,
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `state` varchar(10) DEFAULT NULL COMMENT '状态',
  `path` varchar(1000) DEFAULT NULL COMMENT '地址',
  `caseid` varchar(50) DEFAULT NULL,
  `createtime` bigint(50) DEFAULT NULL COMMENT '创建时间',
  `type` varchar(10) DEFAULT NULL,
  `text1` varchar(255) DEFAULT NULL,
  `text2` varchar(255) DEFAULT NULL,
  `text3` varchar(255) DEFAULT NULL,
  `text4` varchar(255) DEFAULT NULL,
  `text5` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of attachment
-- ----------------------------
INSERT INTO `attachment` VALUES ('0239bdc163d041769232cbdf05c7ec0e', null, null, '2019/01/17/1547715442072.png', 'c494020943cb4745bdb8c5e87c28460b', '1547715442074', null, null, null, null, null, null);
INSERT INTO `attachment` VALUES ('0d387d8913a24866b228228d03f39425', null, null, '2019/01/17/1547713055918.png', null, '1547713055923', null, null, null, null, null, null);
INSERT INTO `attachment` VALUES ('125daa164e004275ac647e55552e99a8', null, null, '2019/01/17/1547715915452.png', 'ea7427db2f744f8e8b96c8994fac0201', '1547715915454', null, null, null, null, null, null);
INSERT INTO `attachment` VALUES ('151ff832b0c84512b6c8370ca908f1e9', null, null, '2019/01/17/1547712978027.jpg', null, '1547712978032', null, null, null, null, null, null);
INSERT INTO `attachment` VALUES ('1963da341f8d43e79d8f02f0ac60f41d', null, null, '2019/01/17/1547715932703.png', 'ea7427db2f744f8e8b96c8994fac0201', '1547715932704', null, null, null, null, null, null);
INSERT INTO `attachment` VALUES ('23380838d1e6481390bc2e19663aa567', null, null, '2019/01/16/1547630957417.jpg', null, '1547630957419', null, null, null, null, null, null);
INSERT INTO `attachment` VALUES ('236c0b2eba754491abe6099b4680f2bf', null, null, '2019/01/17/1547716042198.png', '12c60cba592c4a86b6f9b924e033cc1e', '1547716042199', null, null, null, null, null, null);
INSERT INTO `attachment` VALUES ('2b1031c87a3f44f793c83b84ec71acb7', null, null, '2019/01/16/1547627475537.png', null, '1547627475541', null, null, null, null, null, null);
INSERT INTO `attachment` VALUES ('30b17046beba424c8dc4c2ab0d19900f', null, null, '2019/01/17/1547713122642.png', 'd9ffbf9598fd43cfbc8d0752ee363ec0', '1547713122645', null, null, null, null, null, null);
INSERT INTO `attachment` VALUES ('3c5902929463433ab815453eb12720ad', null, null, '2019/01/16/1547627907446.png', '84e0583d2e9244889eead3f64ed0c78f', '1547627907449', null, null, null, null, null, null);
INSERT INTO `attachment` VALUES ('42187b1abc7245259e565cb5695f3668', null, null, '2019/01/16/1547627907417.png', '84e0583d2e9244889eead3f64ed0c78f', '1547627907418', null, null, null, null, null, null);
INSERT INTO `attachment` VALUES ('4ae63bdce8bd4f22bb64b2d9bfa64574', null, null, '2019/01/17/1547713055918.png', null, '1547713055923', null, null, null, null, null, null);
INSERT INTO `attachment` VALUES ('52cba2c8a83047afadf964c559138f6e', null, null, '2019/01/17/1547713122656.png', 'd9ffbf9598fd43cfbc8d0752ee363ec0', '1547713122658', null, null, null, null, null, null);
INSERT INTO `attachment` VALUES ('6c48cbc395cc4b848dc8084b65fe9725', null, null, null, '11114f407a8d43689223701f71a78f94', null, null, null, null, null, null, null);
INSERT INTO `attachment` VALUES ('7012c1ab916a4fa9b9bbf9eea40340c6', null, null, '2019/01/17/1547712978034.png', null, '1547712978039', null, null, null, null, null, null);
INSERT INTO `attachment` VALUES ('72007a07486a44fcb4badfc66792b56f', null, null, '2019/01/17/1547716042210.png', '12c60cba592c4a86b6f9b924e033cc1e', '1547716042212', null, null, null, null, null, null);
INSERT INTO `attachment` VALUES ('78e4da1a79a4455a9e2104f3bfef7059', null, null, '2019/01/17/1547716004809.png', '12c60cba592c4a86b6f9b924e033cc1e', '1547716004812', null, null, null, null, null, null);
INSERT INTO `attachment` VALUES ('8206e85d14434ee9a8ce2fb068656cd2', null, null, '2019/01/16/1547630704693.png', '9a7e096f66f14156bf15cc33812e20a9', '1547630704717', null, null, null, null, null, null);
INSERT INTO `attachment` VALUES ('a075536303dd467d870ce63529a55ab8', null, null, null, '11114f407a8d43689223701f71a78f94', null, null, null, null, null, null, null);
INSERT INTO `attachment` VALUES ('a1343e370a5141a798f475045aea06e5', null, null, '2019/01/17/1547715894142.png', '0a2123dfd95c414c9cf7dfc6650f812a', '1547715894145', null, null, null, null, null, null);
INSERT INTO `attachment` VALUES ('aa8d50f34f2c4e83826b957a6d1c7c8e', null, null, '2019/01/16/1547632716616.png', null, '1547632716617', null, null, null, null, null, null);
INSERT INTO `attachment` VALUES ('aff72073a2f94536b78d2770465fd78e', null, null, '2019/01/16/1547630704691.png', '9a7e096f66f14156bf15cc33812e20a9', '1547630704717', null, null, null, null, null, null);
INSERT INTO `attachment` VALUES ('b66b038452fc47b88cdf4723ed318196', null, null, '2019/01/16/1547627907419.png', '84e0583d2e9244889eead3f64ed0c78f', '1547627907447', null, null, null, null, null, null);
INSERT INTO `attachment` VALUES ('c079e25b3ee84a159fadbdceb962ef8d', null, null, '2019/01/17/1547715894159.png', '0a2123dfd95c414c9cf7dfc6650f812a', '1547715894162', null, null, null, null, null, null);
INSERT INTO `attachment` VALUES ('c20de4ba33284995939f801b8049e0f2', null, null, null, '11114f407a8d43689223701f71a78f94', null, null, null, null, null, null, null);
INSERT INTO `attachment` VALUES ('d2a008c2388c433aa182a58439cf43ab', null, null, '2019/01/17/1547712978026.jpg', null, '1547712978029', null, null, null, null, null, null);
INSERT INTO `attachment` VALUES ('d5db2b8e57984a319c36e1dc23824bae', null, null, '2019/01/17/1547715932730.png', 'ea7427db2f744f8e8b96c8994fac0201', '1547715932732', null, null, null, null, null, null);
INSERT INTO `attachment` VALUES ('d7575310ea2145ef90e74c6c3ba5df73', null, null, '2019/01/16/1547630815027.png', null, '1547630815027', null, null, null, null, null, null);
INSERT INTO `attachment` VALUES ('d8da31af94c9447c8573be901a27361c', null, null, '2019/01/17/1547713055918.png', null, '1547713055923', null, null, null, null, null, null);
INSERT INTO `attachment` VALUES ('e1429430610f482d8aec16e54a035ed1', null, null, '2019/01/16/1547632686352.png', '04c7c0d007124a85bf4a5cf1b47fe3d5', '1547632686356', null, null, null, null, null, null);
INSERT INTO `attachment` VALUES ('ee69990960ca4a9598388a2c5a52e928', null, null, '2019/01/16/1547627475154.png', null, '1547627475155', null, null, null, null, null, null);
INSERT INTO `attachment` VALUES ('ef33cc0f9cb045708a97cea8c855a8ac', null, null, '2019/01/17/1547715605575.png', null, '1547715605577', null, null, null, null, null, null);
INSERT INTO `attachment` VALUES ('f7635b12cfc442d6b4972f6bc0ad9d15', null, null, '2019/01/16/1547627474518.png', null, '1547627474540', null, null, null, null, null, null);

-- ----------------------------
-- Table structure for class
-- ----------------------------
DROP TABLE IF EXISTS `class`;
CREATE TABLE `class` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `class` varchar(255) DEFAULT NULL,
  `userid` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `userid` (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of class
-- ----------------------------
INSERT INTO `class` VALUES ('11', '三年二班', '21321', '2');

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `id` varchar(50) NOT NULL,
  `permission` varchar(255) DEFAULT NULL,
  `permissionname` varchar(255) DEFAULT NULL,
  `text1` varchar(255) DEFAULT NULL,
  `text2` varchar(255) DEFAULT NULL,
  `text3` varchar(255) DEFAULT NULL,
  `text4` varchar(255) DEFAULT NULL,
  `text5` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES ('1', 'view', 'view', null, null, null, null, null);

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` varchar(50) NOT NULL,
  `role` varchar(255) DEFAULT NULL,
  `rolename` varchar(255) DEFAULT NULL,
  `text1` varchar(255) DEFAULT NULL,
  `text2` varchar(255) DEFAULT NULL,
  `text3` varchar(255) DEFAULT NULL,
  `text4` varchar(255) DEFAULT NULL,
  `text5` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', 'ordinary', 'ordinary', '', null, null, null, null);

-- ----------------------------
-- Table structure for role_permission
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission` (
  `id` varchar(50) NOT NULL,
  `permissionid` varchar(255) DEFAULT NULL,
  `roleid` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_permission
-- ----------------------------
INSERT INTO `role_permission` VALUES ('1', '1', '1');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` varchar(50) NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `createtime` bigint(30) DEFAULT NULL,
  `classid` varchar(50) DEFAULT NULL,
  `state` varchar(10) DEFAULT NULL COMMENT '状态',
  `text1` varchar(255) DEFAULT NULL,
  `text2` varchar(255) DEFAULT NULL,
  `text3` varchar(255) DEFAULT NULL,
  `text4` varchar(255) DEFAULT NULL,
  `text5` varchar(255) DEFAULT NULL,
  `text6` varchar(255) DEFAULT NULL,
  `text7` varchar(255) DEFAULT NULL,
  `text8` varchar(255) DEFAULT NULL,
  `text9` varchar(255) DEFAULT NULL,
  `text10` varchar(255) DEFAULT NULL,
  `text11` varchar(255) DEFAULT NULL,
  `text12` varchar(255) DEFAULT NULL,
  `text13` varchar(255) DEFAULT NULL,
  `text14` varchar(255) DEFAULT NULL,
  `text15` varchar(255) DEFAULT NULL,
  `text16` varchar(255) DEFAULT NULL,
  `text17` varchar(255) DEFAULT NULL,
  `text18` varchar(255) DEFAULT NULL,
  `text19` varchar(255) DEFAULT NULL,
  `text20` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1c8798f464df4cdba31504db95ce4e9d', '盖伦啊啊啊1', '48d3239a34ec0e5a376795eeb175d8ba', '18668437101', '1547568000000', '11', '2', '密码是123456', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `user` VALUES ('7240fa690321435082113536e86b7acb', '天天向上', '48d3239a34ec0e5a376795eeb175d8ba', null, '1547783640000', null, '1', '密码是123456', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` varchar(50) NOT NULL,
  `roleid` varchar(255) DEFAULT NULL,
  `userid` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('1', '1', '1c8798f464df4cdba31504db95ce4e9d');
