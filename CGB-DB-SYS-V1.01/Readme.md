# 项目介绍
Spring综合项目——动吧项目

本项目实现后台记录管理不同用户行为

# 环境依赖

+ 工作区编码: 	UTF-8
+ JDK :	17
+ MAEN:	3.6.3
+ MySQL:   8.0
+ BootStrap3

# 开发工具 #

+ STS Eclipse
+ VS Code

# 起步依赖 #

+ Lombok 
+ Spring Boot Actuator
+ Spring Boot DevTools 
+  JDBC API 
+ MySQL Driver 
+ MyBatis Framework 
+ Thymeleaf 
+ Spring Web

# 目录结构描述

```
├─src
│  ├─main
│  │  ├─java
│  │  │  └─com.cy.pj
│  │  │       ├─common
│  │  │       │  ├─exception   
│  │  │       │  │       
│  │  │       │  ├─vo      
│  │  │       │  │      
│  │  │       │  └─web        
│  │  │       │        
│  │  │       └─sys             
│  │  │       ├─controller       
│  │  │       │      
│  │  │         ├─dao
│  │  │         │      
│  │  │         ├─entity
│  │  │         │      
│  │  │         └─service
│  │  │             │  
│  │  │             └─impl                              
│  │  │                              
│  │  └─resources
│  │  │   │  application.yml
│  │  │   │  jtsys.sql
│  │  │   │  
│  │  │   ├─mapper
│  │  │   │  └─sys
│  │  │   │          SysLogMapper.xml
│  │  │   │      
│  │  │   ├─serializable
│  │  │   │      SysLogObject.out
│  │  │   │      
│  │  │   ├─static
│  │  │              
│     └─templates
│         └─pages
│             │  
│             ├─common
│             │      
│             └─sys                  
│                          
└─程序设计与分析
```

# 使用说明

请仔细阅读程序设计与分析中的内容

`###`标记为新技术(之前的项目没有使用到,这个技术刚刚接触),请重点查看

阅读顺序

1. 环境整合与配置
2. 模块分析设计与实现

# 更新

```
2023/9/27	日志查询模块
```

