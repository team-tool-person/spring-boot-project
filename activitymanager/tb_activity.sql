-- 创建表

-- springboot.tb_activity definition

CREATE TABLE `tb_activity` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `title` varchar(100) NOT NULL,
  `category` varchar(100) NOT NULL,
  `startTime` datetime NOT NULL,
  `endTime` datetime NOT NULL,
  `remark` text,
  `state` tinyint DEFAULT NULL,
  `createdTime` datetime NOT NULL,
  `createUser` varchar(100) NOT NULL,
  `isdelete` tinyint NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- 插入两条数据
INSERT INTO springboot.tb_activity (title,category,startTime,endTime,remark,state,createdTime,createUser) VALUES
	 ('phone','促销','2020-02-02 15:00:00','2020-02-03 15:00:00','...',1,'2020-02-01 15:00:00','TeamSea'),
	 ('computer','促销','2020-02-02 15:00:00','2020-02-03 15:00:00','...',1,'2020-02-01 15:00:00','TeamSea');
