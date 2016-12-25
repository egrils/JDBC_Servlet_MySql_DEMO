/*
Navicat MySQL Data Transfer

Source Server         : testDemo
Source Server Version : 50140
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50140
File Encoding         : 65001

Date: 2016-12-25 21:24:34
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for userinfo
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo` (
  `ID` varchar(8) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `publicKey` varchar(1024) DEFAULT NULL,
  `DDA` varchar(255) DEFAULT NULL,
  `ACA` varchar(255) DEFAULT NULL,
  `message` varchar(1024) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
