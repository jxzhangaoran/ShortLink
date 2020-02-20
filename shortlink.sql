/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80013
 Source Host           : localhost:3306
 Source Schema         : shortlink

 Target Server Type    : MySQL
 Target Server Version : 80013
 File Encoding         : 65001

 Date: 11/02/2020 10:47:17
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for linkmap
-- ----------------------------
DROP TABLE IF EXISTS `linkmap`;
CREATE TABLE `linkmap`  (
  `no` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `shortlink` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `originlink` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`no`) USING BTREE,
  UNIQUE INDEX `noIndex`(`no`) USING BTREE,
  UNIQUE INDEX `shortLinkIndex`(`shortlink`) USING BTREE,
  FULLTEXT INDEX `originLinkIndex`(`originlink`)
) ENGINE = InnoDB AUTO_INCREMENT = 100000010 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of linkmap
-- ----------------------------
INSERT INTO `linkmap` VALUES (100000000, 'base', 'base');

SET FOREIGN_KEY_CHECKS = 1;

-- ----------------------------
-- Create Customer User
-- ----------------------------

CREATE USER `USER`@`%` IDENTIFIED BY 'USER';

GRANT Insert, Select ON `shortlink`.* TO `USER`@`%`;

GRANT Insert, Select ON TABLE `shortlink`.`linkmap` TO `USER`@`%`;
