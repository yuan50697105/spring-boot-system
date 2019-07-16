/*
 Navicat Premium Data Transfer

 Source Server         : localhost-mysql
 Source Server Type    : MySQL
 Source Server Version : 80012
 Source Host           : localhost:3306
 Source Schema         : spring_boot_system

 Target Server Type    : MySQL
 Target Server Version : 80012
 File Encoding         : 65001

 Date: 16/07/2019 23:23:51
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`
(
    `id`          bigint(20)                                              NOT NULL,
    `create_by`   bigint(20)                                              NULL DEFAULT NULL,
    `update_by`   bigint(20)                                              NULL DEFAULT NULL,
    `create_date` datetime(0)                                             NULL DEFAULT CURRENT_TIMESTAMP(0),
    `update_date` datetime(0)                                             NULL DEFAULT NULL,
    `username`    varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    `name`        varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    `password`    varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    `enabled`     int(11)                                                 NULL DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE INDEX `syser_user_id_uindex` (`id`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '系统用户'
  ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
