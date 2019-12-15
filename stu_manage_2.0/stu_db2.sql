/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50515
Source Host           : localhost:3306
Source Database       : stu_db2

Target Server Type    : MYSQL
Target Server Version : 50515
File Encoding         : 65001

Date: 2019-03-26 10:23:54
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `admin`
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int(11) NOT NULL,
  `account` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'bing', '123');

-- ----------------------------
-- Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `sno` int(11) NOT NULL,
  `sname` varchar(255) DEFAULT NULL,
  `sage` int(11) DEFAULT NULL,
  `saddress` varchar(255) DEFAULT NULL,
  `photo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`sno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', '张三', '18', '安徽芜湖', '1540857263287');
INSERT INTO `student` VALUES ('2', '李四', '20', '安徽亳州', '1540857284930');
INSERT INTO `student` VALUES ('3', '王五', '21', '安徽合肥', '1540857305806');
INSERT INTO `student` VALUES ('4', '赵六', '22', '安徽利辛', '1540857331021');
INSERT INTO `student` VALUES ('5', 'bomb', '20', '安徽亳州', null);
INSERT INTO `student` VALUES ('6', 'boom', '18', '浙江杭州', null);
INSERT INTO `student` VALUES ('7', '赵七', '32', '江苏南京', null);
