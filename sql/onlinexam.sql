/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50714
Source Host           : localhost:3306
Source Database       : onlinexam

Target Server Type    : MYSQL
Target Server Version : 50714
File Encoding         : 65001

Date: 2018-01-19 15:16:09
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `courseName` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('1', '程序设计基础');
INSERT INTO `course` VALUES ('2', '数据结构');
INSERT INTO `course` VALUES ('3', '编译原理');
INSERT INTO `course` VALUES ('4', '计算机网络');
INSERT INTO `course` VALUES ('5', 'JavaWeb');

-- ----------------------------
-- Table structure for paper
-- ----------------------------
DROP TABLE IF EXISTS `paper`;
CREATE TABLE `paper` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `testId` int(11) DEFAULT NULL,
  `courseId` int(11) DEFAULT NULL,
  `time` varchar(100) DEFAULT NULL,
  `score` double DEFAULT NULL,
  `wrongQueId` varchar(1000) DEFAULT NULL,
  `wrongAns` varchar(1000) DEFAULT NULL,
  `studentId` int(11) DEFAULT NULL,
  `createDate` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of paper
-- ----------------------------
INSERT INTO `paper` VALUES ('1', '1', '3', '00:00:51', '25', '1,2,19', 'A,B,B', '2', '2018-01-19 07:32:33');
INSERT INTO `paper` VALUES ('2', '1', '3', '00:00:15', '25', '1,2,19', 'C,C,A', '1', '2018-01-19 07:33:13');
INSERT INTO `paper` VALUES ('3', '1', '3', '00:00:49', '100', '', '', '6', '2018-01-19 07:34:36');
INSERT INTO `paper` VALUES ('4', '3', '5', '00:00:34', '100', '', '', '2', '2018-01-19 11:38:05');

-- ----------------------------
-- Table structure for question
-- ----------------------------
DROP TABLE IF EXISTS `question`;
CREATE TABLE `question` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `courseId` int(11) DEFAULT NULL,
  `queType` int(11) DEFAULT NULL,
  `queTitle` varchar(1000) DEFAULT NULL,
  `choiceA` varchar(1000) DEFAULT NULL,
  `choiceB` varchar(1000) DEFAULT NULL,
  `choiceC` varchar(1000) DEFAULT NULL,
  `choiceD` varchar(1000) DEFAULT NULL,
  `ans` varchar(100) DEFAULT NULL,
  `queExist` int(11) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of question
-- ----------------------------
INSERT INTO `question` VALUES ('1', '3', '1', '一个句型中最左的（___）称为该句型的句柄。', '短语', '非终结符号', '终结符号', '直接短语', 'D', '1');
INSERT INTO `question` VALUES ('2', '3', '1', '设文法为：S→SA|AA→a|b，则对句子aba，下面（___）是规范推导。', 'S＝＝＞SA＝＝＞SAA＝＝＞SAa＝＝＞Sba＝＝＞Aba＝＝＞aba', 'S＝＝＞SA＝＝＞SAA＝＝＞AAA＝＝＞aAA＝＝＞abA＝＝＞aba', 'S＝＝＞SA＝＝＞SAA＝＝＞AAA＝＝＞AAa＝＝＞Aba＝＝＞aba', 'S＝＝＞SA＝＝＞Sa＝＝＞SAa＝＝＞Sba＝＝＞Aba＝＝＞aba', 'D', '1');
INSERT INTO `question` VALUES ('3', '3', '1', '最左简单子树的末端结点构成的符号串称为（___）。', '简单短语', '句柄', '最左素短语', '素短语', 'B', '1');
INSERT INTO `question` VALUES ('4', '1', '1', '在Visual Studio NET的集成开发环境中，下面不属于该环境编程语言的是（___）。', 'VB ', 'C++', 'Pascal', 'C#', 'C', '1');
INSERT INTO `question` VALUES ('5', '1', '1', '下面哪个字符串是合法的变量名？', 'X_yz', '123abc', ' integer', ' x-y', 'A', '1');
INSERT INTO `question` VALUES ('6', '1', '1', '\\、/、mod、*四个算术运算符中，优先级别最低的是（___）。', '\\', '/', 'mod', '*', 'C', '1');
INSERT INTO `question` VALUES ('7', '2', '1', '下列常量说明中合法的是（___）。', 'CONST color=red..blue;', 'CONST CONST=10*5;', 'CONST x1:=3.9;', 'CONST abc=\'abc\';', 'D', '1');
INSERT INTO `question` VALUES ('8', '2', '1', '设a、b、c、d、e均为整型变量，且a=13、b=2、c=10、d=3、e=2，则表达式a-b*c DIV d MOD e的值是：（___）。', '13', '-7', '11', '0', 'A', '1');
INSERT INTO `question` VALUES ('9', '2', '1', '下面合法的常量是（___）。', '.25', '\"RED\"', '\'%\'', '3E-2.5', 'C', '1');
INSERT INTO `question` VALUES ('10', '4', '1', '财务部用户bill使用的计算机为Windows Server 2003 系统，为了提高安全性，他设置 启用了密码复杂性策略，则他可以使用以下（___）作为密码。', 'bill123', 'asdo1862351', 'afcasfGhilm', '2b^9L2i', 'D', '1');
INSERT INTO `question` VALUES ('11', '4', '1', '在T568B的标准里，RJ-45连接器的管脚号和颜色编码一一对应，管脚6对应颜色是（___）。', '绿', '白绿', '橙', '白橙', 'A', '1');
INSERT INTO `question` VALUES ('12', '4', '1', 'TCP/IP的应用层对应OSI参考模型的（___）。', '应用层', '应用层、表示层', '应用层、表示层、会话层', '应用层、表示层、会话层、传输层', 'C', '1');
INSERT INTO `question` VALUES ('13', '5', '1', '编写一个Filter，需要（___）。', '继承Filter类', '实现Filter接口', '继承HttpFilter类', '实现HttpFilter接口', 'B', '1');
INSERT INTO `question` VALUES ('14', '5', '1', '自定义标签的配置文件放在（___）。', 'WebRoot', 'lib', 'classes', 'WEB-INF', 'D', '1');
INSERT INTO `question` VALUES ('15', '5', '1', 'EL表达式，${10mod3}，执行结果为（___）。', '10mod3', '1', '3', 'null', 'B', '1');
INSERT INTO `question` VALUES ('16', '5', '1', '自定义标签的作用是（___）。', '编写和使用方便', '规定是这样的，如果不用，别人会说我们不专业', '可以减少jsp中的java代码,将代码与界面标签分离,简化前台开发', '连数据库', 'C', '1');
INSERT INTO `question` VALUES ('17', '4', '1', '网卡是完成(___)功能的。', '物理层', '数据链路层', '物理和数据链路层', '数据链路层和网络层', 'C', '1');
INSERT INTO `question` VALUES ('18', '1', '1', 'If语句后面的表达式应该是（___）。', '逻辑表达式', '条件表达式', '算术表达式', '任意表达式', 'A', '1');
INSERT INTO `question` VALUES ('19', '3', '1', '设G是一个给定的文法，S是文法的开始符号，如果S x（其中x∈V*）, 则称x是文法G的一个（___）。', '产生式', '单词', '候选式', '句型', 'D', '1');
INSERT INTO `question` VALUES ('20', '2', '1', '线性表若采用链表存储结构时，要求内存中可用存储单元的地址（___）。', '必须是连续的', '部分地址必须是连续的', '一定是不连续的', '连续不连续都可以', 'D', '1');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `studentName` varchar(100) DEFAULT NULL,
  `pwd` varchar(1000) DEFAULT NULL,
  `school` varchar(100) DEFAULT NULL,
  `sex` varchar(100) DEFAULT NULL,
  `born` date DEFAULT NULL,
  `classId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', '陈宇航', '52b6c596b84c3d1c8418c8730dee4f9303257ec7be4e8da3f721147c7b02a57c6b2eb1981c3c5fcb9ae760ffbd56b2865b84bbc96f9358b788fd567cdc5cb372', '计算机科学与技术学院', '男', '1997-01-01', '1');
INSERT INTO `student` VALUES ('2', '彭柏皓', 'a8f173cfbe53521181ef97a5e48aa2b438dfdcee65027c39d761fc5235c5d4923694432d88a4898bffec73de073e3980a70af662ea59eee1422d777c0a95e17a', '计算机科学与技术学院', '男', '1997-01-01', '2');
INSERT INTO `student` VALUES ('3', '陈衍凯', '14f16b6fe4a5ca2e0c3586ab0c98c55f6bd2ce7aa595e44787ad47f2066b65e8e9b8c689c90b3ad3a478e7a5359b0fb4da73cc6256c4f35623fb055cf02bebf1', '计算机科学与技术学院', '男', '1997-01-01', '3');
INSERT INTO `student` VALUES ('4', '高丰泽', '4e07b456cb65904927bc4ddfbda04aa999cdd9686ee4087fe2fedde9fb538b57b5ef6ac55ce0343394eed2baa96f8ccdf3e1472458ae2eee49cb6234ed9ea1c9', '计算机科学与技术学院', '男', '1997-01-01', '4');
INSERT INTO `student` VALUES ('5', '刘洋', '152f6cce62f77a6c0df4ac834013a103f64bce560ee2969cac053a9372cbd35325861797177e3cf5949d730e8a4fe291235557e48a4a2f5d925d18d23594f26c', '计算机科学与技术学院', '男', '1997-01-01', '5');
INSERT INTO `student` VALUES ('6', '陈薇羽', '3a09c27b2b4dbcbb7de63c59821f024e0c169ba6fe095a6b97cbcd4b32a68829aec317238a8cdf48fd8389db39085c4a59f0129476917472c0ae133defc144d3', '计算机科学与技术学院', '女', '1997-01-01', '1');
INSERT INTO `student` VALUES ('7', '张仁敏', 'f7529d2c41d8e0621ae056f1bee43fefdfd2d9e06cf5e538131a821088a9815aa7d67cbd72fda9ee7596082dd3ff7d05fee405b9da6659c9e4c798f35e606beb', '计算机科学与技术学院', '女', '1997-01-01', '5');

-- ----------------------------
-- Table structure for studentclass
-- ----------------------------
DROP TABLE IF EXISTS `studentclass`;
CREATE TABLE `studentclass` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `className` varchar(100) DEFAULT NULL,
  `deptName` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of studentclass
-- ----------------------------
INSERT INTO `studentclass` VALUES ('1', '计科1501', '测试');
INSERT INTO `studentclass` VALUES ('2', '计科1502', '开发');
INSERT INTO `studentclass` VALUES ('3', '软件1501', '测试');
INSERT INTO `studentclass` VALUES ('4', '软件1502', '开发');
INSERT INTO `studentclass` VALUES ('5', '计科1507', '开发');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `teacherName` varchar(100) DEFAULT NULL,
  `pwd` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('1', '刘晓红', '6c77250efe44d3e45f7f020235e268aa0037996b660cb479c9b07bb7be0a10f6425d3c344fb51598a9b5619b1a6b7ae4a51d169636dd62f449de7308a8995e8a');
INSERT INTO `teacher` VALUES ('2', '张先伟', 'e910514be5c3f779e8d72affcd7dc374b43acc31dabf70b259e9367bbcc09c386e25638254b234ba689031cfd96c56e210a7f28fca2ace51658495490e80e8c6');
INSERT INTO `teacher` VALUES ('3', '张立红', '40023771defce080c15105f57324d29135199c26a6f462471c4b6d3de9e8adfa5a49ff90c4c940956f07e8bbf9174e9da0a0cff84ff9a3ba51c100332ae0e7c8');
INSERT INTO `teacher` VALUES ('4', '徐军', 'db1003ffa11a19b3b1c8adf15459b1505dd9ed24a313a28cc23bddd8995cc4013c184fd06e498bd6d1384607b392364c6dc6e676fbb86f961e8d20ecded6227e');
INSERT INTO `teacher` VALUES ('5', '崔鑫', 'b1cb92b02d9487a0b6d5af061c7bbdd98d50b4c60c14e0d3ea393f809e2aefa33f3175bead4b091cc9b39efc66bd7705eb105fbe1830c1d5cb9d01dcdedc714e');

-- ----------------------------
-- Table structure for teachercourse
-- ----------------------------
DROP TABLE IF EXISTS `teachercourse`;
CREATE TABLE `teachercourse` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `courseId` int(11) DEFAULT NULL,
  `teacherId` int(11) DEFAULT NULL,
  `classId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teachercourse
-- ----------------------------
INSERT INTO `teachercourse` VALUES ('1', '3', '1', '1');
INSERT INTO `teachercourse` VALUES ('2', '3', '1', '2');
INSERT INTO `teachercourse` VALUES ('3', '2', '2', '1');
INSERT INTO `teachercourse` VALUES ('4', '2', '2', '2');
INSERT INTO `teachercourse` VALUES ('5', '1', '3', '3');
INSERT INTO `teachercourse` VALUES ('6', '1', '3', '4');
INSERT INTO `teachercourse` VALUES ('7', '4', '4', '1');
INSERT INTO `teachercourse` VALUES ('8', '4', '4', '2');
INSERT INTO `teachercourse` VALUES ('9', '5', '5', '1');
INSERT INTO `teachercourse` VALUES ('10', '5', '5', '2');
INSERT INTO `teachercourse` VALUES ('11', '1', '1', '5');
INSERT INTO `teachercourse` VALUES ('12', '2', '2', '5');

-- ----------------------------
-- Table structure for test
-- ----------------------------
DROP TABLE IF EXISTS `test`;
CREATE TABLE `test` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `testName` varchar(100) DEFAULT NULL,
  `courseId` int(11) DEFAULT NULL,
  `endDate` timestamp NULL DEFAULT NULL,
  `testTime` int(11) DEFAULT NULL,
  `questions` varchar(1000) DEFAULT NULL,
  `teacherId` int(11) DEFAULT NULL,
  `classIds` varchar(1000) DEFAULT NULL,
  `scores` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of test
-- ----------------------------
INSERT INTO `test` VALUES ('1', '编译原理期末测试', '3', '2018-01-31 00:00:00', '100', '19,1,3,2', '1', '1,2', '100');
INSERT INTO `test` VALUES ('2', '程序设计基础期末测试', '1', '2018-01-31 00:00:00', '100', '6,5,18,4', '1', '5', '100');
INSERT INTO `test` VALUES ('3', 'JavaWeb期末测试', '5', '2018-01-31 00:00:00', '100', '13,15,14,16', '5', '1,2', '100');
INSERT INTO `test` VALUES ('4', '计算机网络期末测试', '4', '2018-01-31 00:00:00', '100', '10,11,17,12', '4', '1,2', '100');
INSERT INTO `test` VALUES ('5', '数据结构期末测试', '2', '2018-01-31 00:00:00', '100', '7,8,20,9', '2', '1,2,5', '100');
INSERT INTO `test` VALUES ('6', '程序设计基础期末测试', '1', '2018-01-31 00:00:00', '100', '18,4,6,5', '3', '3,4', '100');
SET FOREIGN_KEY_CHECKS=1;
