/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50531
Source Host           : 127.0.0.1:3306
Source Database       : ecspring

Target Server Type    : MYSQL
Target Server Version : 50531
File Encoding         : 65001

Date: 2017-06-12 03:55:05
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for students
-- ----------------------------
DROP TABLE IF EXISTS `students`;
CREATE TABLE `students` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL,
  `password` varchar(32) DEFAULT NULL,
  `firstname` varchar(32) DEFAULT NULL,
  `lastname` varchar(32) DEFAULT NULL,
  `phone` varchar(32) DEFAULT NULL,
  `email` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of students
-- ----------------------------
INSERT INTO `students` VALUES ('10', 'zs', '123321', 'zhang', 'san', '132213131121', null);
INSERT INTO `students` VALUES ('11', 'lisi', '111111', 'li', 'si', '131232123123', 'test@xupt.edu.cn');
INSERT INTO `students` VALUES ('13', 'zhangsantest', '123321', 'zhangsan', 'test', '11112222', 'test@xupt.edu.cn');
