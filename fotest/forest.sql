/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 80019
 Source Host           : localhost:3306
 Source Schema         : forest

 Target Server Type    : MySQL
 Target Server Version : 80019
 File Encoding         : 65001

 Date: 02/07/2020 09:35:59
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for for_role
-- ----------------------------
DROP TABLE IF EXISTS `for_role`;
CREATE TABLE `for_role`  (
  `rid` int(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`rid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of for_role
-- ----------------------------
INSERT INTO `for_role` VALUES (3, 'ROLE_USER', '个人账号');
INSERT INTO `for_role` VALUES (6, 'ROLE_USER1', '普通用户');
INSERT INTO `for_role` VALUES (7, 'ROLE_GUEST', '管理员');

-- ----------------------------
-- Table structure for for_user
-- ----------------------------
DROP TABLE IF EXISTS `for_user`;
CREATE TABLE `for_user`  (
  `uid` int(0) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `nickname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of for_user
-- ----------------------------
INSERT INTO `for_user` VALUES (1, 'deng', '$2a$10$XthuYdDmdkljTK7eUxmn2uWo21uO8YzmiuTjx318lQ1uGZ7jMog6O', NULL);
INSERT INTO `for_user` VALUES (10, 'admin', '$2a$10$Pp4s3Tg7ZdZcSynXuICRhOsi.Cmk2MuOMhUZue19rwGdEaC9UgGje', '员工');

-- ----------------------------
-- Table structure for for_user_role
-- ----------------------------
DROP TABLE IF EXISTS `for_user_role`;
CREATE TABLE `for_user_role`  (
  `user_id` int(0) NOT NULL,
  `role_id` int(0) NOT NULL,
  PRIMARY KEY (`user_id`, `role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of for_user_role
-- ----------------------------
INSERT INTO `for_user_role` VALUES (1, 7);
INSERT INTO `for_user_role` VALUES (10, 3);

-- ----------------------------
-- Table structure for persistent_logins
-- ----------------------------
DROP TABLE IF EXISTS `persistent_logins`;
CREATE TABLE `persistent_logins`  (
  `username` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `series` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `token` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `last_used` timestamp(0) NOT NULL,
  PRIMARY KEY (`series`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of persistent_logins
-- ----------------------------
INSERT INTO `persistent_logins` VALUES ('deng', 'IJj6IJ3ELMEf2cdWgsNOoA==', 'E+ZvzfK62T8fdQBs5ICoVg==', '2020-07-02 08:31:07');
INSERT INTO `persistent_logins` VALUES ('deng', 'UUW6Sox7VCnmDQ/dcZnUlA==', 'Lr5NbEKTvDt3XM/SysHXCA==', '2020-07-02 08:30:08');

SET FOREIGN_KEY_CHECKS = 1;
