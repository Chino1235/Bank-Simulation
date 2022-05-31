/*
 Navicat Premium Data Transfer

 Source Server         : MySQL
 Source Server Type    : MySQL
 Source Server Version : 50520
 Source Host           : localhost:3306
 Source Schema         : bank_log

 Target Server Type    : MySQL
 Target Server Version : 50520
 File Encoding         : 65001

 Date: 28/05/2022 13:17:09
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for banklog
-- ----------------------------
DROP TABLE IF EXISTS `banklog`;
CREATE TABLE `banklog`  (
  `id` int(11) NOT NULL DEFAULT 0,
  `account` varchar(19) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `profile` double NULL DEFAULT NULL,
  `option` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
