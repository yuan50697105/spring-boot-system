/*
 Navicat Premium Data Transfer

 Source Server         : localhost-postgres
 Source Server Type    : PostgreSQL
 Source Server Version : 110002
 Source Host           : localhost:5432
 Source Catalog        : spring_boot_system
 Source Schema         : public

 Target Server Type    : PostgreSQL
 Target Server Version : 110002
 File Encoding         : 65001

 Date: 16/07/2019 23:31:24
*/


-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS "public"."sys_user";
CREATE TABLE "public"."sys_user"
(
    "id" int8,
    "create_by" int8,
    "update_by" int8,
    "create_date" timestamp(6),
    "update_date" timestamp(6),
    "username"    varchar(200) COLLATE "pg_catalog"."default",
    "name"        varchar(200) COLLATE "pg_catalog"."default",
    "password"    varchar(200) COLLATE "pg_catalog"."default",
    "enabled" int4
)
;
COMMENT ON TABLE "public"."sys_user" IS '系统用户';
