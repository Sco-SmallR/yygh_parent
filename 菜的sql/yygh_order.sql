/*
 Navicat Premium Data Transfer

 Source Server         : docker
 Source Server Type    : MySQL
 Source Server Version : 50737
 Source Host           : 192.168.12.4:3307
 Source Schema         : yygh_order

 Target Server Type    : MySQL
 Target Server Version : 50737
 File Encoding         : 65001

 Date: 24/04/2022 21:11:24
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for order_info
-- ----------------------------
DROP TABLE IF EXISTS `order_info`;
CREATE TABLE `order_info`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `user_id` bigint(20) NULL DEFAULT NULL,
  `out_trade_no` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单交易号',
  `hoscode` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '医院编号',
  `hosname` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '医院名称',
  `depcode` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '科室编号',
  `depname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '科室名称',
  `title` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '医生职称',
  `schedule_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '排班编号（医院自己的排班主键）',
  `reserve_date` date NULL DEFAULT NULL COMMENT '安排日期',
  `reserve_time` tinyint(3) NULL DEFAULT 0 COMMENT '安排时间（0：上午 1：下午）',
  `patient_id` bigint(20) NULL DEFAULT NULL COMMENT '就诊人id',
  `patient_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '就诊人名称',
  `patient_phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '就诊人手机',
  `hos_record_id` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '预约记录唯一标识（医院预约记录主键）',
  `number` int(11) NULL DEFAULT NULL COMMENT '预约号序',
  `fetch_time` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '建议取号时间',
  `fetch_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '取号地点',
  `amount` decimal(10, 0) NULL DEFAULT NULL COMMENT '医事服务费',
  `quit_time` datetime NULL DEFAULT NULL COMMENT '退号时间',
  `order_status` tinyint(3) NULL DEFAULT NULL COMMENT '订单状态',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted` tinyint(3) NOT NULL DEFAULT 0 COMMENT '逻辑删除(1:已删除，0:未删除)',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_out_trade_no`(`out_trade_no`) USING BTREE,
  INDEX `idx_user_id`(`user_id`) USING BTREE,
  INDEX `idx_hoscode`(`hoscode`) USING BTREE,
  INDEX `idx_hos_schedule_id`(`schedule_id`) USING BTREE,
  INDEX `idx_hos_record_id`(`hos_record_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 43 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '订单表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order_info
-- ----------------------------
INSERT INTO `order_info` VALUES (8, 8, '165062401471455', '123456789', '北京协和医院', '200040878', '多发性硬化专科门诊', '医师', '625245440be10763f4b2b1ae', '2022-04-24', 0, 1, '张晓琪', '2276701333@qq.com', '19', 26, '2022-04-2409:00前', '一层114窗口', 100, '2022-04-23 15:30:00', 0, '2022-04-22 10:40:16', '2022-04-22 10:49:12', 0);
INSERT INTO `order_info` VALUES (34, 8, '16506243033886', '123456789', '北京协和医院', '200040878', '多发性硬化专科门诊', '医师', '625245440be10763f4b2b1ae', '2022-04-25', 0, 1, '张晓琪', '2276701333@qq.com', NULL, NULL, NULL, NULL, 100, '2022-04-23 15:30:00', 0, '2022-04-22 10:45:12', '2022-04-24 08:27:12', 0);
INSERT INTO `order_info` VALUES (35, 8, '165062538968276', '123456789', '北京协和医院', '200040878', '多发性硬化专科门诊', '医师', '625245440be10763f4b2b1ae', '2022-04-25', 0, 1, '张晓琪', '2276701333@qq.com', NULL, NULL, NULL, NULL, 100, '2022-04-23 15:30:00', 0, '2022-04-22 11:03:38', '2022-04-24 08:27:17', 0);
INSERT INTO `order_info` VALUES (36, 8, '165062556389745', '123456789', '北京协和医院', '200040878', '多发性硬化专科门诊', '医师', '625245440be10763f4b2b1ae', '2022-04-25', 0, 1, '张晓琪', '2276701333@qq.com', NULL, NULL, NULL, NULL, 100, '2022-04-23 15:30:00', 0, '2022-04-22 11:06:09', '2022-04-24 08:27:20', 0);
INSERT INTO `order_info` VALUES (37, 8, '165062571383571', '123456789', '北京协和医院', '200040878', '多发性硬化专科门诊', '医师', '625245440be10763f4b2b1ae', '2022-04-27', 0, 1, '张晓琪', '2276701333@qq.com', '23', 28, '2022-04-2409:00前', '一层114窗口', 100, '2022-04-23 15:30:00', 0, '2022-04-22 11:08:34', '2022-04-24 08:27:25', 0);
INSERT INTO `order_info` VALUES (38, 8, '165062618555391', '123456789', '北京协和医院', '200040878', '多发性硬化专科门诊', '医师', '625245440be10763f4b2b1ae', '2022-04-27', 0, 1, '张晓琪', '2276701333@qq.com', '24', 29, '2022-04-2409:00前', '一层114窗口', 100, '2022-04-23 15:30:00', 0, '2022-04-22 11:16:28', '2022-04-24 08:27:28', 0);
INSERT INTO `order_info` VALUES (39, 8, '16506353593562', '123456789', '北京协和医院', '200040878', '多发性硬化专科门诊', '医师', '625245440be10763f4b2b1ae', '2022-04-27', 0, 1, '张晓琪', '2276701333@qq.com', '25', 30, '2022-04-2409:00前', '一层114窗口', 100, '2022-04-23 15:30:00', 0, '2022-04-22 13:49:19', '2022-04-24 08:27:31', 0);
INSERT INTO `order_info` VALUES (40, 8, '165063537648072', '123456789', '北京协和医院', '200040878', '多发性硬化专科门诊', '医师', '625245440be10763f4b2b1ae', '2022-04-27', 0, 1, '张晓琪', '2276701333@qq.com', '26', 31, '2022-04-2409:00前', '一层114窗口', 100, '2022-04-23 15:30:00', 0, '2022-04-22 13:49:37', '2022-04-24 08:27:35', 0);
INSERT INTO `order_info` VALUES (41, 8, '16506358206835', '123456789', '北京协和医院', '200040878', '多发性硬化专科门诊', '医师', '625245440be10763f4b2b1ae', '2022-04-28', 0, 1, '张晓琪', '2276701333@qq.com', '27', -6, '2022-04-2409:00前', '一层114窗口', 100, '2022-04-23 15:30:00', 0, '2022-04-22 13:57:01', '2022-04-24 08:27:38', 0);
INSERT INTO `order_info` VALUES (42, 8, '165063671030697', '123456789', '北京协和医院', '200040878', '多发性硬化专科门诊', '医师', '625245440be10763f4b2b1ae', '2022-04-28', 0, 1, '张晓琪', '2276701333@qq.com', '28', -5, '2022-04-2409:00前', '一层114窗口', 100, '2022-04-23 15:30:00', 0, '2022-04-22 14:11:50', '2022-04-24 08:27:43', 0);

-- ----------------------------
-- Table structure for payment_info
-- ----------------------------
DROP TABLE IF EXISTS `payment_info`;
CREATE TABLE `payment_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `out_trade_no` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '对外业务编号',
  `order_id` bigint(20) NULL DEFAULT NULL COMMENT '订单id',
  `payment_type` tinyint(1) NULL DEFAULT NULL COMMENT '支付类型（微信 支付宝）',
  `trade_no` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '交易编号',
  `total_amount` decimal(10, 2) NULL DEFAULT NULL COMMENT '支付金额',
  `subject` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '交易内容',
  `payment_status` tinyint(3) NULL DEFAULT NULL COMMENT '支付状态',
  `callback_time` datetime NULL DEFAULT NULL COMMENT '回调时间',
  `callback_content` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '回调信息',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted` tinyint(3) NOT NULL DEFAULT 0 COMMENT '逻辑删除(1:已删除，0:未删除)',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_out_trade_no`(`out_trade_no`) USING BTREE,
  INDEX `idx_order_id`(`order_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '支付信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of payment_info
-- ----------------------------
INSERT INTO `payment_info` VALUES (1, '165062401471455', 8, 2, NULL, 100.00, '2022-04-24|北京协和医院|多发性硬化专科门诊|医师', 1, NULL, NULL, '2022-04-23 17:45:21', '2022-04-23 09:45:20', 0);
INSERT INTO `payment_info` VALUES (2, '165062556389745', 36, 2, NULL, 100.00, '2022-04-24|北京协和医院|多发性硬化专科门诊|医师', 1, NULL, NULL, '2022-04-23 17:51:41', '2022-04-23 09:51:40', 0);

-- ----------------------------
-- Table structure for refund_info
-- ----------------------------
DROP TABLE IF EXISTS `refund_info`;
CREATE TABLE `refund_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `out_trade_no` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '对外业务编号',
  `order_id` bigint(20) NULL DEFAULT NULL COMMENT '订单编号',
  `payment_type` tinyint(3) NULL DEFAULT NULL COMMENT '支付类型（微信 支付宝）',
  `trade_no` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '交易编号',
  `total_amount` decimal(10, 2) NULL DEFAULT NULL COMMENT '退款金额',
  `subject` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '交易内容',
  `refund_status` tinyint(3) NULL DEFAULT NULL COMMENT '退款状态',
  `callback_content` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '回调信息',
  `callback_time` datetime NULL DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted` tinyint(3) NOT NULL DEFAULT 0 COMMENT '逻辑删除(1:已删除，0:未删除)',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `idx_out_trade_no`(`out_trade_no`) USING BTREE,
  INDEX `idx_order_id`(`order_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '退款信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of refund_info
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
