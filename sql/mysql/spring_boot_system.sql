/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 50528
 Source Host           : localhost:3306
 Source Schema         : spring_boot_system

 Target Server Type    : MySQL
 Target Server Version : 50528
 File Encoding         : 65001

 Date: 17/07/2019 17:31:21
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`
(
    `id`                bigint(20)                                                  NOT NULL DEFAULT 0,
    `create_by`         bigint(20)                                                  NULL     DEFAULT NULL,
    `update_by`         bigint(20)                                                  NULL     DEFAULT NULL,
    `create_date`       datetime                                                    NULL     DEFAULT NULL,
    `update_date`       datetime                                                    NULL     DEFAULT NULL,
    `name`              varchar(100) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL     DEFAULT NULL,
    `name_spell_full`   varchar(100) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL     DEFAULT NULL,
    `name_spell_simple` varchar(100) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL     DEFAULT NULL,
    `enabled`           tinyint(4)                                                  NULL     DEFAULT 0,
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE INDEX `sys_role_id_uindex` (`id`) USING BTREE,
    INDEX `sys_role_create_date_index` (`create_date`) USING BTREE,
    INDEX `sys_role_name_name_spell_simple_name_spell_full_index` (`name`, `name_spell_simple`, `name_spell_full`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = latin1
  COLLATE = latin1_swedish_ci COMMENT = '系统角色'
  ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`
(
    `id`                bigint(20)                                              NOT NULL,
    `create_by`         bigint(20)                                              NULL DEFAULT NULL,
    `update_by`         bigint(20)                                              NULL DEFAULT NULL,
    `create_date`       datetime                                                NULL DEFAULT NULL,
    `update_date`       datetime                                                NULL DEFAULT NULL,
    `username`          varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    `name`              varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    `name_spell_full`   varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    `name_spell_simple` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    `password`          varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
    `enabled`           int(11)                                                 NULL DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE INDEX `syser_user_id_uindex` (`id`) USING BTREE,
    INDEX `sys_user_create_date_index` (`create_date`) USING BTREE,
    INDEX `sys_user_name_name_spell_full_name_spell_simple_username_index` (`name`, `name_spell_full`, `name_spell_simple`, `username`) USING BTREE
) ENGINE = InnoDB
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '系统用户'
  ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;
