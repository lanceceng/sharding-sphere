/*
Navicat MySQL Data Transfer

Source Server         : cat
Source Server Version : 80018
Source Host           : localhost:3306
Source Database       : ds0

Target Server Type    : MYSQL
Target Server Version : 80018
File Encoding         : 65001

Date: 2020-11-12 21:29:57
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for dist
-- ----------------------------
DROP TABLE IF EXISTS `dist`;
CREATE TABLE `dist` (
                      `id` bigint(11) NOT NULL AUTO_INCREMENT,
                      `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
                      PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1326879635804078082 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_order_0
-- ----------------------------
DROP TABLE IF EXISTS `t_order_0`;
CREATE TABLE `t_order_0` (
                           `order_id` bigint(11) NOT NULL DEFAULT '0',
                           `user_id` bigint(1) DEFAULT NULL,
                           `amount` decimal(18,2) DEFAULT NULL,
                           `discount` decimal(10,2) DEFAULT NULL,
                           `create_time` datetime DEFAULT NULL,
                           PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_order_1
-- ----------------------------
DROP TABLE IF EXISTS `t_order_1`;
CREATE TABLE `t_order_1` (
                           `order_id` bigint(11) NOT NULL DEFAULT '0',
                           `user_id` bigint(1) DEFAULT NULL,
                           `amount` decimal(18,2) DEFAULT NULL,
                           `discount` decimal(10,2) DEFAULT NULL,
                           `create_time` datetime DEFAULT NULL,
                           PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_order_item_0
-- ----------------------------
DROP TABLE IF EXISTS `t_order_item_0`;
CREATE TABLE `t_order_item_0` (
                                `product_id` bigint(11) NOT NULL AUTO_INCREMENT,
                                `product_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
                                `order_id` bigint(11) DEFAULT '0',
                                `price` decimal(10,2) DEFAULT NULL,
                                `discount` decimal(10,2) DEFAULT NULL,
                                `count` int(11) DEFAULT NULL,
                                PRIMARY KEY (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2009 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_order_item_1
-- ----------------------------
DROP TABLE IF EXISTS `t_order_item_1`;
CREATE TABLE `t_order_item_1` (
                                `product_id` bigint(11) NOT NULL AUTO_INCREMENT,
                                `product_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
                                `order_id` bigint(11) NOT NULL DEFAULT '0',
                                `price` decimal(10,2) DEFAULT NULL,
                                `discount` decimal(10,2) DEFAULT NULL,
                                `count` int(11) DEFAULT NULL,
                                PRIMARY KEY (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user_0
-- ----------------------------
DROP TABLE IF EXISTS `user_0`;
CREATE TABLE `user_0` (
                        `id` bigint(11) NOT NULL AUTO_INCREMENT,
                        `name` varchar(10) DEFAULT NULL,
                        `age` int(11) DEFAULT NULL,
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=117 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user_1
-- ----------------------------
DROP TABLE IF EXISTS `user_1`;
CREATE TABLE `user_1` (
                        `id` bigint(11) NOT NULL AUTO_INCREMENT,
                        `name` varchar(10) DEFAULT NULL,
                        `age` int(11) DEFAULT NULL,
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;
