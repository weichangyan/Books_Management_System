/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80025
 Source Host           : localhost:3306
 Source Schema         : springboot-vue

 Target Server Type    : MySQL
 Target Server Version : 80025
 File Encoding         : 65001

 Date: 09/11/2021 15:05:45
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for area
-- ----------------------------
DROP TABLE IF EXISTS `area`;
CREATE TABLE `area`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `label` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `pid` int(0) NULL DEFAULT NULL,
  `value` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of area
-- ----------------------------
INSERT INTO `area` VALUES (1, '安徽省', NULL, 'Anhui');
INSERT INTO `area` VALUES (2, '合肥市', 1, 'Hefei');
INSERT INTO `area` VALUES (3, '政务区', 2, 'Zhengwu');

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '名称',
  `price` decimal(10, 2) NULL DEFAULT NULL COMMENT '价格',
  `author` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '作者',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '出版日期',
  `cover` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '封面地址',
  `user_id` int(0) NULL DEFAULT NULL COMMENT '用户id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES (1, '明朝那些事', 60.00, 'xxx', '2010-07-01 00:00:00', 'http://localhost:9090/files/eb7942935c294ca1bc2a07d24b554d36', 13);

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '名称',
  `pid` int(0) NULL DEFAULT NULL COMMENT '父节点id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES (1, '文学', NULL);
INSERT INTO `category` VALUES (2, '童书', 1);
INSERT INTO `category` VALUES (3, '社会科学', 1);
INSERT INTO `category` VALUES (4, '经济学', 1);
INSERT INTO `category` VALUES (5, '科普百科', 2);
INSERT INTO `category` VALUES (7, '法律', 3);

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '内容',
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '评论人',
  `time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '评论时间',
  `parent_id` bigint(0) NULL DEFAULT NULL COMMENT '父ID',
  `foreign_id` bigint(0) NULL DEFAULT 0 COMMENT '关联id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '留言表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES (20, '哈哈哈', 'admin', '2020-05-22 10:48:55', NULL, 0);
INSERT INTO `message` VALUES (21, '哦豁', 'admin', '2020-05-22 10:49:48', NULL, 0);
INSERT INTO `message` VALUES (22, '老弟', 'admin', '2020-05-22 10:51:07', 21, 0);
INSERT INTO `message` VALUES (23, '哈哈哈', 'zhang', '2020-05-24 17:13:45', 22, 0);
INSERT INTO `message` VALUES (24, '我们都爱吃大西瓜', 'zhang', '2020-05-24 17:13:58', NULL, 0);

-- ----------------------------
-- Table structure for news
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '标题',
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL COMMENT '内容',
  `author` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '作者',
  `time` datetime(0) NULL DEFAULT NULL COMMENT '发布时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of news
-- ----------------------------
INSERT INTO `news` VALUES (4, '4444', '<p>444444</p><p><br/></p><p>44444</p><p><br/></p><p><br/></p><p>555555<img src=\"https://img1.baidu.com/it/u=4110196045,3829597861&amp;fm=26&amp;fmt=auto&amp;gp=0.jpg\" contenteditable=\"false\" style=\"font-size: 14px; max-width: 100%;\"/></p>', '管理员', '2020-05-13 18:55:27');
INSERT INTO `news` VALUES (5, '77777', '<p>7777</p><p><br/></p><p><img src=\"http://localhost:9090/files/c536f6f2f0e94983951240d73d740601\" style=\"max-width:100%;\" contenteditable=\"false\" width=\"388\" height=\"388\"/><br/></p><p>8888</p><p><br/></p><p><img src=\"http://localhost:9090/files/b344314319f047cf9192ce64ca454674\" style=\"max-width:100%;\" contenteditable=\"false\"/></p>', '管理员', '2020-05-15 19:14:14');

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '名称',
  `total_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '总价',
  `pay_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '实付款',
  `discount` decimal(10, 2) NULL COMMENT '优惠金额',
  `transport_price` decimal(10, 2) NULL COMMENT '运费',
  `order_no` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '订单编号',
  `user_id` int(0) NULL DEFAULT NULL COMMENT '用户id',
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '用户账户',
  `create_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `pay_time` timestamp(0) NULL DEFAULT NULL COMMENT '支付时间',
  `state` int(0) NOT NULL DEFAULT 0 COMMENT '状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_order
-- ----------------------------
INSERT INTO `t_order` VALUES (14, '明朝那些事', 60.00, 60.00, 0.00, 0.00, '1434521785293873152', 1, 'admin', '2020-05-05 22:20:20', NULL, 0);
INSERT INTO `t_order` VALUES (15, '明朝那些事', 60.00, 60.00, 0.00, 0.00, '1434522270700761088', 1, 'admin', '2020-05-05 15:04:52', '2020-05-05 22:22:37', 1);
INSERT INTO `t_order` VALUES (16, '明朝那些事', 60.00, 60.00, 0.00, 0.00, '1434522590331891712', 1, 'admin', '2020-05-06 15:04:57', '2020-05-06 22:23:57', 1);
INSERT INTO `t_order` VALUES (17, '明朝那些事', 60.00, 60.00, 0.00, 0.00, '1436963760559362048', 1, 'admin', '2020-05-08 16:03:52', NULL, 0);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '密码',
  `nick_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '昵称',
  `age` int(0) NULL DEFAULT NULL COMMENT '年龄',
  `sex` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '性别',
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '地址',
  `role` int(0) NULL DEFAULT NULL COMMENT '角色，1：管理员，2：普通用户',
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '头像',
  `account` decimal(10, 2) NULL COMMENT '账户余额',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '用户信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', 'admin', '管理员', 32, '男', '火星', 1, 'http://localhost:9090/files/888f2d39d0724816a738a716d56ad58a', 100000.00);
INSERT INTO `user` VALUES (13, 'zhang', '123', '张三', 20, '男', '木星', 2, 'http://localhost:9090/files/a73d05129bc247dc98951c7f4cfbbaf1', 200.00);
INSERT INTO `user` VALUES (14, 'wang', '123', '王梦晨', 24, '女', '地球', 2, NULL, 300.00);
INSERT INTO `user` VALUES (15, 'li', '123', '李雪', 22, '女', '银河系', 2, NULL, 500.00);
INSERT INTO `user` VALUES (16, 'qian', '123', '钱江', 22, '男', '地球', NULL, NULL, 700.00);

SET FOREIGN_KEY_CHECKS = 1;
