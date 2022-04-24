/*
 Navicat Premium Data Transfer

 Source Server         : docker
 Source Server Type    : MySQL
 Source Server Version : 50737
 Source Host           : 192.168.12.4:3307
 Source Schema         : yygh_hosp

 Target Server Type    : MySQL
 Target Server Version : 50737
 File Encoding         : 65001

 Date: 24/04/2022 21:11:01
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for hospital_set
-- ----------------------------
DROP TABLE IF EXISTS `hospital_set`;
CREATE TABLE `hospital_set`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `hosname` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '医院名称',
  `hoscode` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '医院编号',
  `api_url` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'api基础路径',
  `sign_key` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '签名秘钥',
  `contacts_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系人',
  `contacts_phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系人手机',
  `status` tinyint(3) NOT NULL DEFAULT 0 COMMENT '状态',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted` tinyint(3) NOT NULL DEFAULT 0 COMMENT '逻辑删除(1:已删除，0:未删除)',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_hoscode`(`hoscode`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '医院设置表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of hospital_set
-- ----------------------------
INSERT INTO `hospital_set` VALUES (1, '北京协和医院', '123456789', 'http://localhost:9998', 'ba27058f8dcbf42c1523b4b7881a1c07', '小王', '15115447254', 1, '2021-08-20 08:07:43', '2022-04-22 02:07:44', 0);
INSERT INTO `hospital_set` VALUES (3, '陆丰市人民医院', '123456222', 'http://localhost:8888', NULL, '小郑', '15477785658', 1, '2021-08-21 14:58:09', '2022-04-03 14:26:40', 0);
INSERT INTO `hospital_set` VALUES (4, '上海人民医院', '123456666', 'http://localhost:8555', NULL, '小李', '18554456484', 1, '2021-08-21 14:58:46', '2022-04-03 14:26:42', 0);
INSERT INTO `hospital_set` VALUES (5, '中山协和医院', '123546486', 'http://localhost:8844', NULL, '小刚', '15477785658', 1, '2021-08-21 14:59:14', '2022-04-03 02:13:58', 0);
INSERT INTO `hospital_set` VALUES (6, '东海高级医院', '788888888', 'http://jiaxianniubi.com', 'a100b98afd6afa687c760f6f6af5ef5f', '张天纯', '14744684861', 1, '2021-08-22 08:57:39', '2022-04-03 14:26:45', 0);
INSERT INTO `hospital_set` VALUES (7, '1111', '111', '111', 'ba27058f8dcbf42c1523b4b6629a1c07', '11', '11', 1, '2021-08-22 08:58:53', '2021-08-22 08:58:53', 0);
INSERT INTO `hospital_set` VALUES (8, '11353', '353', '3543', '42f9d93d44e46f44a8c451ca0ffb3693', '5345', '5435', 1, '2021-08-22 08:59:49', '2021-08-22 08:59:49', 0);
INSERT INTO `hospital_set` VALUES (9, '535433', '53453453', '543543', '86077eb5c6b4963c73d4320f9d3c96ba', '5435345', '3453534', 1, '2021-08-22 09:04:25', '2021-08-22 09:04:25', 0);
INSERT INTO `hospital_set` VALUES (10, '0000', '00', '00', '458616ff6386801c36c9e57e75061d4a', '00', '00', 1, '2021-08-22 10:13:57', '2021-08-22 10:13:57', 0);
INSERT INTO `hospital_set` VALUES (11, '北京天河医院', '1001_21', 'http://localhost:7888', 'e9761246c4b7ae2673dc68fc3de5f4a8', '唐人', '14571145214', 1, '2022-03-31 07:18:20', '2022-03-31 07:42:44', 0);
INSERT INTO `hospital_set` VALUES (12, '的鹅蛋医院', '234234', 'sdfsfs', 'ab30a5df7108bd8ce3b04d66451e9cd6', '带开采', '1525233511', 1, '2022-04-05 02:02:11', '2022-04-05 02:02:11', 0);
INSERT INTO `hospital_set` VALUES (13, '3333', 'ddd', '带扥扥', 'a4ca18407ee300d8c692f459cf6d4ff4', '奥赛发森', '点点滴滴', 1, '2022-04-05 03:16:53', '2022-04-05 03:16:53', 0);

SET FOREIGN_KEY_CHECKS = 1;
