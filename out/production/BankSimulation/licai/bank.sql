/*
 Navicat Premium Data Transfer

 Source Server         : MySQL
 Source Server Type    : MySQL
 Source Server Version : 50520
 Source Host           : localhost:3306
 Source Schema         : bank

 Target Server Type    : MySQL
 Target Server Version : 50520
 File Encoding         : 65001

 Date: 28/05/2022 13:17:27
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for client
-- ----------------------------
DROP TABLE IF EXISTS `client`;
CREATE TABLE `client`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '户名',
  `account` varchar(19) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `profile` double(32, 4) NULL DEFAULT 0.0000,
  `password` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of client
-- ----------------------------
INSERT INTO `client` VALUES (1, '张三', '6127200219568426559', 10000.1200, '123456');
INSERT INTO `client` VALUES (2, '李四', '6217200219548546233', 0.0000, '654321');

-- ----------------------------
-- Table structure for client_loan
-- ----------------------------
DROP TABLE IF EXISTS `client_loan`;
CREATE TABLE `client_loan`  (
  `id` int(11) NOT NULL DEFAULT 0,
  `clientAccount` varchar(19) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `loanProfile` double(20, 0) NULL DEFAULT NULL,
  `loanTime` date NULL DEFAULT NULL,
  `returnTime` date NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of client_loan
-- ----------------------------

-- ----------------------------
-- Table structure for client_position
-- ----------------------------
DROP TABLE IF EXISTS `client_position`;
CREATE TABLE `client_position`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clientAccount` varchar(19) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `productName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `positions` double(20, 0) NULL DEFAULT NULL COMMENT '持仓量',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of client_position
-- ----------------------------

-- ----------------------------
-- Table structure for financial_products
-- ----------------------------
DROP TABLE IF EXISTS `financial_products`;
CREATE TABLE `financial_products`  (
  `id` int(11) NOT NULL COMMENT '理财产品编号',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '理财产品名称',
  `annual_yield` double(20, 2) NULL DEFAULT NULL COMMENT '总发行量',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of financial_products
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
