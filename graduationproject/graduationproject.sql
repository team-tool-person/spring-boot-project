-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: graduationproject
-- ------------------------------------------------------
-- Server version	8.0.32

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '管理员id',
  `name` varchar(100) NOT NULL COMMENT '管理员名称',
  `password` varchar(100) DEFAULT NULL COMMENT '管理员密码',
  `isdelete` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL COMMENT '课程名称',
  `teacher` int NOT NULL COMMENT '教师id',
  `requirement` varchar(255) NOT NULL DEFAULT '无需求' COMMENT '毕业设计要求',
  `isdelete` tinyint(1) NOT NULL DEFAULT '0' COMMENT '删除标记',
  PRIMARY KEY (`id`),
  KEY `class_id_IDX` (`id`) USING BTREE,
  KEY `class_FK` (`teacher`),
  CONSTRAINT `class_FK` FOREIGN KEY (`teacher`) REFERENCES `teacher` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'sid',
  `name` char(10) NOT NULL COMMENT '名称',
  `age` tinyint NOT NULL COMMENT '年龄',
  `sex` char(1) NOT NULL COMMENT '性别',
  `category` char(5) NOT NULL COMMENT '培养等级',
  `enrollmenttime` date NOT NULL COMMENT '入学时间',
  `graduationtime` date NOT NULL COMMENT '毕业时间',
  `course` int NOT NULL COMMENT '班级id',
  `pushword` tinyint NOT NULL DEFAULT '0' COMMENT '是否提交作业\r\n0为未提交\r\n默认为0',
  `isdelete` tinyint NOT NULL DEFAULT '0' COMMENT '使用伪删除\r\n1为已删除\r\n默认为0',
  `password` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '123456' COMMENT '系统密码',
  PRIMARY KEY (`id`),
  KEY `student_FK` (`course`),
  CONSTRAINT `student_FK` FOREIGN KEY (`course`) REFERENCES `course` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher`
--

DROP TABLE IF EXISTS `teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `teacher` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '教师编号',
  `name` char(10) NOT NULL COMMENT '教师姓名',
  `age` tinyint NOT NULL COMMENT '教师年龄',
  `sex` char(1) NOT NULL COMMENT '教师性别',
  `category` char(5) NOT NULL COMMENT '教师等级',
  `password` varchar(100) NOT NULL DEFAULT '123456' COMMENT '管理系统密码',
  `isdelete` tinyint NOT NULL DEFAULT '0' COMMENT '伪删除0位未删除',
  `correctword` tinyint NOT NULL DEFAULT '0' COMMENT '是否批改作业',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher`
--

LOCK TABLES `teacher` WRITE;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `workfile`
--

DROP TABLE IF EXISTS `workfile`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `workfile` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '文件id',
  `name` varchar(50) NOT NULL COMMENT '文件名称',
  `type` char(10) NOT NULL COMMENT '文件类型',
  `student` int NOT NULL COMMENT '所属学生',
  `pushtime` datetime NOT NULL COMMENT '提交时间',
  `commit` varchar(100) NOT NULL COMMENT '提交描述',
  `url` varchar(255) NOT NULL COMMENT '在服务器中的所属位置',
  `score` int NOT NULL DEFAULT '0' COMMENT '作业分数',
  `firstscore` int NOT NULL DEFAULT '0' COMMENT '第一次分数',
  `second` int NOT NULL DEFAULT '0' COMMENT '第二次分数',
  PRIMARY KEY (`id`),
  KEY `workfile_FK` (`student`),
  CONSTRAINT `workfile_FK` FOREIGN KEY (`student`) REFERENCES `student` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='毕业设计文件管理类';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `workfile`
--

LOCK TABLES `workfile` WRITE;
/*!40000 ALTER TABLE `workfile` DISABLE KEYS */;
/*!40000 ALTER TABLE `workfile` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-06 14:52:53
