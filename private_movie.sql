/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 80025
Source Host           : localhost:3306
Source Database       : private_movie

Target Server Type    : MYSQL
Target Server Version : 80025
File Encoding         : 65001

Date: 2022-10-21 01:24:00
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for appointment_info
-- ----------------------------
DROP TABLE IF EXISTS `appointment_info`;
CREATE TABLE `appointment_info` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '预定ID',
  `user_id` int DEFAULT NULL COMMENT '用户ID',
  `movie_id` int DEFAULT NULL COMMENT '电影ID',
  `room_id` int DEFAULT NULL COMMENT '房间ID',
  `start_time` datetime DEFAULT NULL COMMENT '开始时间',
  `end_time` datetime DEFAULT NULL COMMENT '结束时间',
  `process` int DEFAULT NULL COMMENT '预约进程，1为未开始，2为正在进行，3为已完成',
  `status` int DEFAULT NULL COMMENT '状态，1为正常，2为删除',
  PRIMARY KEY (`id`),
  KEY `1` (`user_id`),
  KEY `2` (`movie_id`),
  KEY `3` (`room_id`),
  CONSTRAINT `1` FOREIGN KEY (`user_id`) REFERENCES `user_info` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `2` FOREIGN KEY (`movie_id`) REFERENCES `movie_info` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `3` FOREIGN KEY (`room_id`) REFERENCES `room_info` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of appointment_info
-- ----------------------------
INSERT INTO `appointment_info` VALUES ('1', '1', '3', '1', '2022-02-10 08:00:00', '2022-02-10 10:00:00', '3', '2');
INSERT INTO `appointment_info` VALUES ('3', '2', '2', '1', '2022-02-13 16:00:00', '2022-02-13 18:00:00', '3', '2');
INSERT INTO `appointment_info` VALUES ('4', '1', '2', '2', '2022-02-13 18:00:00', '2022-02-13 20:00:00', '3', '1');
INSERT INTO `appointment_info` VALUES ('5', '2', '3', '3', '2022-02-13 18:00:00', '2022-02-13 20:00:00', '3', '1');
INSERT INTO `appointment_info` VALUES ('6', '2', '6', '1', '2022-02-13 20:00:00', '2022-02-13 22:00:00', '3', '1');
INSERT INTO `appointment_info` VALUES ('11', '2', '4', '3', '2022-02-13 16:00:00', '2022-02-13 18:00:00', '2', '1');
INSERT INTO `appointment_info` VALUES ('12', '2', '2', '1', '2022-03-03 10:00:00', '2022-03-03 12:00:00', '1', '1');

-- ----------------------------
-- Table structure for feedback_info
-- ----------------------------
DROP TABLE IF EXISTS `feedback_info`;
CREATE TABLE `feedback_info` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '反馈ID',
  `feedback_type` varchar(40) DEFAULT NULL COMMENT '问题类型',
  `feedback_description` longtext COMMENT '反馈描述',
  `feedback_time` datetime DEFAULT NULL COMMENT '反馈时间',
  `status` int DEFAULT NULL COMMENT '状态，1为正常，2为删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of feedback_info
-- ----------------------------
INSERT INTO `feedback_info` VALUES ('1', '501房间不干净', '房间内部存在的大量的垃圾，而且灯光效果不是很好，电影看的很模糊，而且房间隔音效果一般般。希望得到改善处理', '2022-02-09 15:34:03', '1');
INSERT INTO `feedback_info` VALUES ('2', '前台服务不到位', '前台的服务一点都不到位，随便大吼大叫，而且服务没有一点耐心， 随便帮你打开一下设备然后把遥控器丢给你就直接走了，希望得到解决，不然下次不会再来了！', '2022-02-16 15:35:46', '1');
INSERT INTO `feedback_info` VALUES ('17', '1', '123', '2022-02-12 19:45:24', '2');
INSERT INTO `feedback_info` VALUES ('18', '', '', '2022-02-12 19:45:37', '2');
INSERT INTO `feedback_info` VALUES ('19', '1', '1', '2022-02-12 19:46:20', '2');
INSERT INTO `feedback_info` VALUES ('20', '123', '1221321313', '2022-02-13 16:02:22', '2');

-- ----------------------------
-- Table structure for movie_info
-- ----------------------------
DROP TABLE IF EXISTS `movie_info`;
CREATE TABLE `movie_info` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '电影ID',
  `movie_name` varchar(40) DEFAULT NULL COMMENT '电影名称',
  `movie_description` longtext COMMENT '电影简介',
  `movie_region` varchar(20) DEFAULT NULL COMMENT '电影地区',
  `movie_type` int DEFAULT NULL COMMENT '电影类型',
  `movie_score` decimal(10,1) DEFAULT '0.0' COMMENT '电影评分',
  `movie_author` varchar(40) DEFAULT NULL COMMENT '电影主演',
  `movie_time` int DEFAULT '0' COMMENT '总时长',
  `movie_img` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT '' COMMENT '宣传海报',
  `status` int DEFAULT NULL COMMENT '状态，1位正常，2为删除',
  `movie_year` int DEFAULT NULL COMMENT '年份',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of movie_info
-- ----------------------------
INSERT INTO `movie_info` VALUES ('1', '李茂扮太子', '富家女杨家珍与小捕快李茂成婚，虽夫妻恩爱，但始终得不到家珍父母的认可。李茂意外发现自己竟与当朝太子相貌相同，一个想进...', '华语', '3', '8.4', '玛丽/常远/魏翔', '98', 'https://pic4.iqiyipic.com/image/20220128/ba/d1/v_164895727_m_601_m3_260_360.jpg?caplist=jpg,webp,avif', '1', '2022');
INSERT INTO `movie_info` VALUES ('2', '误杀2', '林日朗与妻子阿玲、儿子小虫一直过着清贫但幸福的生活，直到儿子小虫突发意外急需救治，几经周折，走投无路的林日朗为了救儿...', '华语', '11', '8.9', '肖央/任达华/文咏珊/陈雨锶', '126', 'https://pic7.iqiyipic.com/image/20220128/02/7e/v_162204124_m_601_m4_260_360.jpg?caplist=jpg,webp,avif', '1', '2022');
INSERT INTO `movie_info` VALUES ('3', '长津湖', '以抗美援朝战争第二次战役中的长津湖战役为背景，讲述了一段波澜壮阔的历史：71年前，中国人民志愿军赴朝作战，在极寒严酷...', '华语', '2', '9.2', '吴京/易烊千玺/段奕宏', '186', 'https://pic6.iqiyipic.com/image/20220105/6c/5f/v_157645717_m_601_m12_260_360.jpg?caplist=jpg,webp,avif', '1', '2021');
INSERT INTO `movie_info` VALUES ('4', '007：无暇赴死', '世界局势波诡云谲，再度出山的邦德面临有史以来空前的危机，传奇特工007的故事在本片中达到高潮。新老角色集结亮相，蕾雅...', '美国', '6', '8.3', '丹尼尔·克雷格/安娜·德·阿玛斯', '118', 'https://pic0.iqiyipic.com/image/20220117/5a/08/v_124563738_m_601_m9_260_360.jpg?caplist=jpg,webp,avif', '1', '2021');
INSERT INTO `movie_info` VALUES ('5', '木兰：横空出世', '该片是全球首次以三维动画形式讲述花木兰故事。故事基于原著但做出改编，木兰从小怀抱女侠梦想，可在替父从军后屡次遭受打击...', '华语', '7', '7.4', ' 张琦（配音）/赵路', '124', 'https://pic6.iqiyipic.com/image/20220206/9e/71/v_139418337_m_601_m11_260_360.jpg?caplist=jpg,webp,avif', '1', '2021');
INSERT INTO `movie_info` VALUES ('6', '毒液：致命守护者', '艾迪是一位深受观众喜爱的新闻记者，和女友安妮相恋多年，彼此之间感情十分要好。安妮是一名律师，接手了生命基金会的案件...', '美国', '4', '8.5', '汤姆·哈迪/米歇尔·威廉姆斯', '117', 'https://pic5.iqiyipic.com/image/20210826/a8/d9/v_114158068_m_601_m17_260_360.jpg?caplist=jpg,webp,avif', '1', '2019');
INSERT INTO `movie_info` VALUES ('7', '爱情神话', '李小姐，带着女儿过着单身生活。蓓蓓，离婚后热衷跳探戈。格洛瑞亚，有钱有闲老公失踪。三个完全不同的女人因为老白而产生了...', '华语', '1', '8.2', '徐峥/马伊琍/吴越/倪虹洁', '102', 'https://pic9.iqiyipic.com/image/20220124/55/14/v_162419256_m_601_m6_260_360.jpg?caplist=jpg,webp,avif', '1', '2021');
INSERT INTO `movie_info` VALUES ('8', '古董局中局', '一尊价值连城的佛头，牵扯出古玩界惊天骗局！民国年间文物界权威组织“五脉”掌门许一城，将武则天明堂佛头送至海外，被定罪...', '华语', '3', '8.7', ' 雷佳音/李现/辛芷蕾/葛优', '134', 'https://pic1.iqiyipic.com/image/20220116/21/86/v_156116349_m_601_m5_260_360.jpg?caplist=jpg,webp,avif', '1', '2022');
INSERT INTO `movie_info` VALUES ('9', '1', '1', '美国', '5', '1.0', '1', '1', '21', '2', '1');
INSERT INTO `movie_info` VALUES ('10', '1', '1', '华语', '1', '1.0', '1', '1', '1', '2', '1');

-- ----------------------------
-- Table structure for room_info
-- ----------------------------
DROP TABLE IF EXISTS `room_info`;
CREATE TABLE `room_info` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '房间ID',
  `room_name` varchar(40) DEFAULT NULL COMMENT '房间名称',
  `room_type` varchar(40) DEFAULT NULL COMMENT '房间类型',
  `room_number` int DEFAULT NULL COMMENT '房间号',
  `status` int DEFAULT NULL COMMENT '状态，1为正常，2为删除',
  `room_price` int DEFAULT NULL COMMENT '房间价格',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of room_info
-- ----------------------------
INSERT INTO `room_info` VALUES ('1', '魔蝎座', '经济小包', '501', '1', '200');
INSERT INTO `room_info` VALUES ('2', '射手座', '浪漫中包', '502', '1', '400');
INSERT INTO `room_info` VALUES ('3', '双子座', '豪华大包', '503', '1', '600');
INSERT INTO `room_info` VALUES ('4', '金牛座', '浪漫中包', '504', '1', '400');
INSERT INTO `room_info` VALUES ('5', '处女座', '经济小包', '505', '1', '200');
INSERT INTO `room_info` VALUES ('6', '水瓶座', '豪华大包', '506', '1', '600');
INSERT INTO `room_info` VALUES ('8', '1', '1', '1', '1', '1');

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `username` varchar(40) NOT NULL COMMENT '账号',
  `password` varchar(100) NOT NULL COMMENT '密码',
  `salt` varchar(100) DEFAULT NULL COMMENT '盐值',
  `nickname` varchar(40) DEFAULT NULL COMMENT '用户名',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(20) DEFAULT NULL COMMENT '点好',
  `role` int DEFAULT NULL COMMENT '角色，1为用户，2为管理员',
  `status` int DEFAULT NULL COMMENT '状态，1位正常，2位删除',
  `register_date` datetime DEFAULT NULL COMMENT '注册时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES ('1', '616316004', '346c76e51b090e86326dd6916365a2fb', 'X1316k6soR9fqrM7pEDUFxoRAQeJFank', '波波', '616316004@qq.com', '13576005583', '1', '1', '2022-02-17 18:00:12');
INSERT INTO `user_info` VALUES ('2', '1', '6292cf901cdec59dbfba52d43a073fa8', '0sQ6GMTHFSAP1j71bw34etmxfXCn9B9C', 'rourou123', '1770832083@qq.com', '17622736441', '2', '1', '2022-01-31 18:00:17');
INSERT INTO `user_info` VALUES ('3', '17622736441', '70c5f8bfec39cfe8b6680c5a5478130f', 'Fl4HbqUp9nRVOKlrY1Js5TIloFF79o79', '123', '1977346634@qq.com', '12345664654', '1', '3', '2022-03-04 18:00:21');
