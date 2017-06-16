/*
Navicat MySQL Data Transfer

Source Server         : recommend
Source Server Version : 50140
Source Host           : localhost:3306
Source Database       : recommenderdb

Target Server Type    : MYSQL
Target Server Version : 50140
File Encoding         : 65001

Date: 2017-06-15 12:15:35
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for inventory
-- ----------------------------
DROP TABLE IF EXISTS `inventory`;
CREATE TABLE `inventory` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user` varchar(255) DEFAULT NULL,
  `product` varchar(255) DEFAULT NULL,
  `sum` float DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of inventory
-- ----------------------------
INSERT INTO `inventory` VALUES ('2', 'kk', 'sd', '23');
INSERT INTO `inventory` VALUES ('3', 'asd', 'sdds', '1');
INSERT INTO `inventory` VALUES ('4', 's', 'sdds', '1');
INSERT INTO `inventory` VALUES ('5', 'fghj', 'df', '12');
INSERT INTO `inventory` VALUES ('6', 'dd', 'we', '23');

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user` varchar(255) DEFAULT NULL,
  `product` varchar(255) DEFAULT NULL,
  `number` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('1', 'wangmei', 'we', '12');
INSERT INTO `orders` VALUES ('2', 'qw', 'qw', '2');
INSERT INTO `orders` VALUES ('3', 'null', 'weqw', '2');
INSERT INTO `orders` VALUES ('4', 'jk', 'fghj', '576');

-- ----------------------------
-- Table structure for products
-- ----------------------------
DROP TABLE IF EXISTS `products`;
CREATE TABLE `products` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of products
-- ----------------------------
INSERT INTO `products` VALUES ('1', 'sandwichw', 'food', 'tastes good');

-- ----------------------------
-- Table structure for students
-- ----------------------------
DROP TABLE IF EXISTS `students`;
CREATE TABLE `students` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of students
-- ----------------------------
INSERT INTO `students` VALUES ('2', 'qw', '123');
INSERT INTO `students` VALUES ('3', 'tyu', '5678');
INSERT INTO `students` VALUES ('5', 'ee', '32');
INSERT INTO `students` VALUES ('7', 'hh', '12');
INSERT INTO `students` VALUES ('8', 'ddd', '111');
INSERT INTO `students` VALUES ('10', 'ww', '123');
INSERT INTO `students` VALUES ('12', 'eredd', '3');
INSERT INTO `students` VALUES ('13', 'er', '3');
INSERT INTO `students` VALUES ('14', 'df', 'qw');
INSERT INTO `students` VALUES ('17', 'ss', 'er');
INSERT INTO `students` VALUES ('19', 'wewe', 'we');
