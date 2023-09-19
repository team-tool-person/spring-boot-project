# 第三阶段前部分内容整合 #

# 环境整合与配置 #

## 1. 创建数据库和数据表 ##

打开MySQL运行窗口

1. 设置窗口字符集
2. 导入数据库文件

```mysql
set names uft8;
source jtsys.sql
```

## 2. 配置开发环境

### 2.1 统一开法环境

首先我们需要统一开发环境,设置环境为统一的版本

+ 工作区编码: 	UTF-8
+ JDK :	1.8
+ MAEN:	3.6.3
	
### 2.2 创建项目

1. 项目名称:CGB-DB-SYS-V3.01
2. 组ID: com.cy
3. 打包方式:jar

![image4-2023-9-1814:32:55.png](https://gitee.com/teamsea/tuchuang/raw/master/tuchuang/image4-2023-9-1814:32:55.png)


### 2.3 添加依赖

![image3-2023-9-1814:33:58.png](https://gitee.com/teamsea/tuchuang/raw/master/tuchuang/image3-2023-9-1814:33:58.png)

### 2.4 修改配置文件

使用`yml`来进行配置,不再使用`properties`进行配置

```yml
# server配置

server:
 port: 8080
 servlet:
  context-path: / 
 tomcat:
    threads:
      max: 300
      min-spare-thread: 50
      
# Spring框架 数据库连接池配置 thymeleaf配置

spring:
 #数据库连接配置
  datasource:
    url: jdbc:mysql://127.0.0.1:3306/jtsys?serverTimezore=UTC&characterEncoding=utf8
    username: root
    password: lilium
  
  # thymeleaf配置
  thymeleaf:
   cache: false
   prefix: classpath:/templates/pages/
   #注意这个地方,结尾一定是要使用'/'否则无法解析到pages文件夹

# mybatis配置

mybatis:
  mapper-locations:
  - classpath:/mapper/*/*.xml
  configuration:
    default-statement-timeout: 60
    map-underscore-to-camel-case: true
    
# log 配置
logging:
  level:
    com.cy: debug

```

## 3. 初始化首页 ##

### 3.1 配置静态资源和页面 ###

准备一些初始化资源

包括一些`js,css,image`文件

这些内容要放置到`static`目录中

#### 3.1.1 前端页面 ####

前端页面的主要来源是来与

[AdminLTE|https://adminlte.io/](https://adminlte.io/)

来使用其中的模板,来使用自己的前端

[Free Bootstrap Admin Template - AdminLTE.IO|](https://adminlte.io/)

AdminLTE 网站使用的Bootstrap框架来实现的

Bootstrap可以来适用于不同的设备,来 

#### 3.2 创建页面Controller ####

创建一个页面Controller来检查配置是否有问题

```java
package com.cy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 页面Controller 将路径访问跳转到对应的页面
 * 
 * 
 * 
 * */


@Controller
@RequestMapping("/")
public class PageController {

	/**
	 * 主页跳转
	 * 
	 * */
	@RequestMapping("doIndexUI")
	public String doIndexUI() {
		return "starter";
	}
	
}
```

运行项目,测试配置环境是否正确

+++

<!--
	上述内容将项目的环境配置和检查完毕
	接下来开始对程序进行设计和开发
-->

# 模块设计与开发 #

## 4. 日志管理模块 ##

### 4.1 日志展示模块 ###

本模块要实现**记录用户的行为日志**

记录某个用户在什么时间点执行了什么操作,使用了什么方法,传递了什么参数,执行时长等

对用户的行为进行记录,查询,删除等操作

#### 4.1.1 数据库设计 ####

用户行为记录表`sys_log`

| 字段名     | 类型     | 约束                | 说明         |
| ---------- | -------- | ------------------- | ------------ |
| id         | bigint   | **PRIMARY** **KEY** | id主键       |
| username   | varchar  |                     | 用户名       |
| operation  | varchar  |                     | 用户操作     |
| method     | varchar  |                     | 请求方法     |
| params     | varchar  |                     | 请求参数     |
| time       | bigint   |                     | 执行时长(ms) |
| createTime | datetime |                     | 创建时间     |

#### 4.1.2 原型设计 ####

基于用户需求，实现静态页面(html/css/js)，通过静态页面为用户呈现基本需求实现

**说明:假如客户对此原型进行了确认,后续则可以基于此原型进行研发。**

我们要实现的业务和需求

当我们单击主页面`日志管理`按钮后,页面可以加载出日志管理的界面对日志进行增删改查等操作



#### 4.1.3 API设计 ####

对日志业务的流程和API关系进行分析

![image26-2023-9-1816:59:19.png](https://gitee.com/teamsea/tuchuang/raw/master/tuchuang/image26-2023-9-1816:59:19.png)

经典的三层构造

#### 4.1.4 日志管理列表页面呈现 ####

用户获取日志信息的管理

![image24-2023-9-1817:00:36.png](https://gitee.com/teamsea/tuchuang/raw/master/tuchuang/image24-2023-9-1817:00:36.png)

根据时序图我们进行设计和开发程序

1. 用户单击`日志管理`按钮
2. 主页开始加载日志管理界面
3. 日志管理界面呈现数据

##### 服务器端代码实现 #####

```java
/**
 * Log数据展示页面,这个页用来盛放数据的操作
 * */
@RequestMapping("log/log_list")
public String doLogUI() {
	return "sys/log_list";
}

/**
 * Log查询页面,这个页面用来盛放数据
 * */
@RequestMapping("doPageUI")
public String doPageUI() {
	return "common/page";
}
```

##### 前端页面 #####

这个网页有三层套壳,第一层是starter页面
第二层是doLogUI页面
第三层是common下的page页面

1. 先加载加载页面`doLogIU`将这个页面放置到`starter`上

   使用JQuery中`load()`函数

   在`starter`中

   ```javascript
   // 当页面加载完毕后,将添加按钮单击的事件
   $(function(){
       // 使用这个函数为来对不同的页面进行显示
       doLoadUI("load-log-id","log/log_list");
   })
   
   // 当用户单击哪一个按钮时中加入哪一个网页
   // 按钮元素id , 出入网页的地址
   function doLoadUI(id,url){
   	// 当这个按钮被点击时
       $("#"+id).click(function(){
                $("#mainContentId").load(url); 
           }
       )}
   ```

2. 将`comcon/page`放置到`log/log_list`中

   在`log/log_list`中

   ```javascript
   // 页面加载时开始加入 comcon/page页面
   $(function(){
       // 在pageId中展示page
       $("#pageId").load("doPageUI");
   })
   ```

##### FAQ: #####

1. Q:	如直接去访问地址`log/logList`和`doPageUI`会怎样

   A:	这个页面的样式和JQ无法加载进来,加载的页面会是一个非完整页面,因为这两个网页就不是完整的

2. Q:	`log/logList`和`doPageUI`是非完整页面,没有引入JQ和CSS样式为什么还带有样式

   A:	因为引入的页面`starter`引入了CSS样式和JQ,所以这两个不完整页面可以使用样式和JQ

3. Q:	这样设计开发的好处是什么
	
   A:	数据加载通常是一个相对比较耗时操作，为了改善用户体验，可以先为用户呈现一个页面，数据加载时，显示数据正在加载中,数据加载完成以后再呈现数据。这样也可满足现阶段不同类型客户端需求(例如手机端,电脑端,电视端,手表端。)

#### 4.1.5 日志管理列表数据呈现 ####

##### 数据架构分析 #####

日志查询服务端数据基本架构

![image28-2023-9-1914:49:29.png](https://gitee.com/teamsea/tuchuang/raw/master/tuchuang/image28-2023-9-1914:49:29.png)

这个模块需要查询很多东西如, 查询数据库中的记录,查询总数,总页数等

我们查询的条目和数据可封装到`pojo`对象中,所查询的数据可以放置到`PageObject`业务层对象中

将查询的信息条目发送到前端页面,有前端进行分析

我们传递到前端的数据要有正确的查询信息,也要有错误的提示信息前端

##### 服务器API架构及业务时序图 #####

AIP架构图

![image12-2023-9-1915:44:14.png](https://gitee.com/teamsea/tuchuang/raw/master/tuchuang/image12-2023-9-1915:44:14.png)

+ 浏览器开始访问服务器,进入`DispatherServlet`来访问`Controller`
+  当我们的`Controller`有异常抛出的时候,会抛给`DispatherServlet`来解决
+ `DispatherServlet`会调用`GlobalExceptionHandler`来解决异常
+ 我们可以通过注解`@ControllerAdvice`来定义全局的异常处理类型,来处理`Controller`抛出的异常

时序图

![image5-2023-9-1916:18:10.png](https://gitee.com/teamsea/tuchuang/raw/master/tuchuang/image5-2023-9-1916:18:10.png)

##### 服务端代码实现 #####

+ 实体类实现

  ```java
  public class SysLog implements Serializable {
  
  	/**
  	 * 序列化的id值,这个id值是实体类序列化的唯一表示
  	 * 
  	 * 我们可以使用这个id来进行序列化和反序列化
  	 * 
  	 */
  	private static final long serialVersionUID = 1L;
  	/**
  	* 和数据库进行一一对应的数据
  	*/
  }
  ```

  

