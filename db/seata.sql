/*
 Navicat Premium Data Transfer

 Source Server         : 192.168.1.12(Home)
 Source Server Type    : MySQL
 Source Server Version : 50730
 Source Host           : 192.168.1.12:3306
 Source Schema         : seata

 Target Server Type    : MySQL
 Target Server Version : 50730
 File Encoding         : 65001

 Date: 10/07/2020 22:19:47
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for branch_table
-- ----------------------------
DROP TABLE IF EXISTS `branch_table`;
CREATE TABLE `branch_table` (
  `branch_id` bigint(20) NOT NULL,
  `xid` varchar(128) COLLATE utf8_unicode_ci NOT NULL,
  `transaction_id` bigint(20) DEFAULT NULL,
  `resource_group_id` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `resource_id` varchar(256) COLLATE utf8_unicode_ci DEFAULT NULL,
  `lock_key` varchar(128) COLLATE utf8_unicode_ci DEFAULT NULL,
  `branch_type` varchar(8) COLLATE utf8_unicode_ci DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL,
  `client_id` varchar(64) COLLATE utf8_unicode_ci DEFAULT NULL,
  `application_data` varchar(2000) COLLATE utf8_unicode_ci DEFAULT NULL,
  `gmt_create` datetime DEFAULT NULL,
  `gmt_modified` datetime DEFAULT NULL,
  PRIMARY KEY (`branch_id`),
  KEY `idx_xid` (`xid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of branch_table
-- ----------------------------
BEGIN;
INSERT INTO `branch_table` VALUES (2047664315, '192.168.1.10:8091:2047664291', 2047664291, NULL, 'jdbc:mysql://192.168.1.12:3306/seata_order', 't_order:16', 'AT', 2, 'seata-order-service:192.168.1.10:65313', NULL, '2020-07-05 08:06:58', '2020-07-05 08:06:58');
COMMIT;

-- ----------------------------
-- Table structure for global_table
-- ----------------------------
DROP TABLE IF EXISTS `global_table`;
CREATE TABLE `global_table` (
  `xid` varchar(128) COLLATE utf8_unicode_ci NOT NULL,
  `transaction_id` bigint(20) DEFAULT NULL,
  `status` tinyint(4) NOT NULL,
  `application_id` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `transaction_service_group` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `transaction_name` varchar(128) COLLATE utf8_unicode_ci DEFAULT NULL,
  `timeout` int(11) DEFAULT NULL,
  `begin_time` bigint(20) DEFAULT NULL,
  `application_data` varchar(2000) COLLATE utf8_unicode_ci DEFAULT NULL,
  `gmt_create` datetime DEFAULT NULL,
  `gmt_modified` datetime DEFAULT NULL,
  PRIMARY KEY (`xid`),
  KEY `idx_gmt_modified_status` (`gmt_modified`,`status`),
  KEY `idx_transaction_id` (`transaction_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of global_table
-- ----------------------------
BEGIN;
INSERT INTO `global_table` VALUES ('192.168.1.10:8091:2047664291', 2047664291, 6, 'seata-order-service', 'fsp_tx_group', 'fsp-create-order', 60000, 1593936397020, NULL, '2020-07-05 08:06:37', '2020-07-05 08:07:37');
COMMIT;

-- ----------------------------
-- Table structure for lock_table
-- ----------------------------
DROP TABLE IF EXISTS `lock_table`;
CREATE TABLE `lock_table` (
  `row_key` varchar(128) COLLATE utf8_unicode_ci NOT NULL,
  `xid` varchar(96) COLLATE utf8_unicode_ci DEFAULT NULL,
  `transaction_id` mediumtext COLLATE utf8_unicode_ci,
  `branch_id` mediumtext COLLATE utf8_unicode_ci,
  `resource_id` varchar(256) COLLATE utf8_unicode_ci DEFAULT NULL,
  `table_name` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `pk` varchar(36) COLLATE utf8_unicode_ci DEFAULT NULL,
  `gmt_create` datetime DEFAULT NULL,
  `gmt_modified` datetime DEFAULT NULL,
  PRIMARY KEY (`row_key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of lock_table
-- ----------------------------
BEGIN;
INSERT INTO `lock_table` VALUES ('jdbc:mysql://192.168.1.12:3306/seata_order^^^t_order^^^16', '192.168.1.10:8091:2047664291', '2047664291', '2047664315', 'jdbc:mysql://192.168.1.12:3306/seata_order', 't_order', '16', '2020-07-05 08:06:58', '2020-07-05 08:06:58');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
