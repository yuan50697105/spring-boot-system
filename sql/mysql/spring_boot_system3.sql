/*
 Navicat Premium Data Transfer

 Source Server         : localhost-mysql
 Source Server Type    : MySQL
 Source Server Version : 80012
 Source Host           : localhost:3306
 Source Schema         : spring_boot_system3

 Target Server Type    : MySQL
 Target Server Version : 80012
 File Encoding         : 65001

 Date: 16/07/2019 23:24:11
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`
(
    `id`          bigint(20)                                                NULL DEFAULT NULL,
    `create_by`   bigint(20)                                                NULL DEFAULT NULL,
    `update_by`   bigint(20)                                                NULL DEFAULT NULL,
    `create_date` timestamp(0)                                              NULL DEFAULT NULL,
    `update_date` timestamp(0)                                              NULL DEFAULT NULL,
    `username`    tinytext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
    `name`        tinytext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
    `password`    tinytext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
    `enabled`     int(11)                                                   NULL DEFAULT NULL
) ENGINE = InnoDB
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT = '系统用户'
  ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
