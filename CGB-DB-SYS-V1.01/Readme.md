# 环境整合与配置 #

# 1. 创建数据库和数据表 #

打开MySQL运行窗口

1. 设置窗口字符集
2. 导入数据库文件

```mysql
set names uft8;
source jtsys.sql
```

# 2. 配置开发环境

## 2.1 统一开法环境

首先我们需要统一开发环境,设置环境为统一的版本

+ 工作区编码: 	UTF-8
+ JDK :	1.8
+ MAEN:	3.6.3
	
## 2.2 创建项目

1. 项目名称:CGB-DB-SYS-V3.01
2. 组ID: com.cy
3. 打包方式:jar

![image4-2023-9-1814:32:55.png](https://gitee.com/teamsea/tuchuang/raw/master/tuchuang/image4-2023-9-1814:32:55.png)


## 2.3 添加依赖

![image3-2023-9-1814:33:58.png](https://gitee.com/teamsea/tuchuang/raw/master/tuchuang/image3-2023-9-1814:33:58.png)

## 2.4 修改配置文件

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

# 3. 初始化首页 #

## 3.1 配置静态资源和页面 ##

准备一些初始化资源

包括一些`js,css,image`文件

这些内容要放置到`static`目录中

### 3.1.1 前端页面 ###

前端页面的主要来源是来与

[AdminLTE|https://adminlte.io/](https://adminlte.io/)

来使用其中的模板,来使用自己的前端

[Free Bootstrap Admin Template - AdminLTE.IO|](https://adminlte.io/)

AdminLTE 网站使用的Bootstrap框架来实现的

Bootstrap可以来适用于不同的设备,来 

### 3.2 创建页面Controller ###

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

# 4. 日志管理模块 #

## 4.1 日志展示模块 ##

本模块要实现**记录用户的行为日志**

记录某个用户在什么时间点执行了什么操作,使用了什么方法,传递了什么参数,执行时长等

对用户的行为进行记录,查询,删除等操作

### 4.1.1 数据库设计 ###

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

### 4.1.2 原型设计 ###

基于用户需求，实现静态页面(html/css/js)，通过静态页面为用户呈现基本需求实现

**说明:假如客户对此原型进行了确认,后续则可以基于此原型进行研发。**

我们要实现的业务和需求

当我们单击主页面`日志管理`按钮后,页面可以加载出日志管理的界面对日志进行增删改查等操作

### 4.1.3 API设计 ###

对日志业务的流程和API关系进行分析

![image26-2023-9-1816:59:19.png](https://gitee.com/teamsea/tuchuang/raw/master/tuchuang/image26-2023-9-1816:59:19.png)

经典的三层构造

### 4.1.4 日志管理列表页面呈现 ###

用户获取日志信息的管理

![image24-2023-9-1817:00:36.png](https://gitee.com/teamsea/tuchuang/raw/master/tuchuang/image24-2023-9-1817:00:36.png)

根据时序图我们进行设计和开发程序

1. 用户单击`日志管理`按钮
2. 主页开始加载日志管理界面
3. 日志管理界面呈现数据

#### 服务器端代码实现 ####

```java
/**
 * Log数据展示页面,用来展示数据信息和对数据的操作
 * */
@RequestMapping("log/log_list")
public String doLogUI() {
	return "sys/log_list";
}

/**
 * 分页菜单,用来实现分页操作
 * */
@RequestMapping("doPageUI")
public String doPageUI() {
	return "common/page";
}
```

#### 前端页面 ####

这个网页有三层套壳,第一层是starter页面
第二层是doLogUI页面
第三层是common下的page页面

1. 先加载加载页面`doLogIU`将这个页面放置到`starter`上

   使用JQuery中`load()`函数,**载入远程 HTML 文件代码并插入至 DOM 中。**

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

#### FAQ: ####

1. Q:	如直接去访问地址`log/logList`和`doPageUI`会怎样

   A:	这个页面的样式和JQ无法加载进来,加载的页面会是一个非完整页面,因为这两个网页就不是完整的

2. Q:	`log/logList`和`doPageUI`是非完整页面,没有引入JQ和CSS样式为什么还带有样式

   A:	因为引入的页面`starter`引入了CSS样式和JQ,所以这两个不完整页面可以使用样式和JQ

3. Q:	这样设计开发的好处是什么

   A:	数据加载通常是一个相对比较耗时操作，为了改善用户体验，可以先为用户呈现一个页面，数据加载时，显示数据正在加载中,数据加载完成以后再呈现数据。这样也可满足现阶段不同类型客户端需求(例如手机端,电脑端,电视端,手表端。)

4. Q:	`common`是要用来干什么用的

   A:	这个是一个通用的包,程序的共有的一些工具类型

### 4.1.5 日志管理列表数据呈现 ###

#### 数据架构分析 ####

日志查询服务端数据基本架构

![image28-2023-9-1914:49:29.png](https://gitee.com/teamsea/tuchuang/raw/master/tuchuang/image28-2023-9-1914:49:29.png)

这里我们解释两个地方

1. `PageObject`类

   这个类封装可在数据库查询到的信息

   包括总行数,总页数,分页数,查询到的记录等

   实现了分析查询的操作

   在Service业务层中完成封装,传递到Controller控制层

2. `JsonResult`类

   这个类中封装了向前端传递的数据

   包括状态,信息,异常处理,和查询信息等

   实现了向前端传递数据的安全性和准确性

#### 服务器API架构及业务时序图 ####

API架构图

![image12-2023-9-1915:44:14.png](https://gitee.com/teamsea/tuchuang/raw/master/tuchuang/image12-2023-9-1915:44:14.png)

+ 浏览器开始访问服务器,进入`DispatherServlet`来访问`Controller`
+  当我们的`Controller`有异常抛出的时候,会抛给`DispatherServlet`来解决
+ `DispatherServlet`会调用`GlobalExceptionHandler`来解决异常
+ 我们可以通过注解`@ControllerAdvice`来定义全局的异常处理类型,来处理`Controller`抛出的异常
+ 在`GlobalExceptionHandler`类中有被`@ExceptionHandler`注解描述的方法就是异常处理方法
+ `@ExceptionHandler`可以提供参数,表示为能处理的异常类型和起子类型异常

时序图

![image5-2023-9-1916:18:10.png](https://gitee.com/teamsea/tuchuang/raw/master/tuchuang/image5-2023-9-1916:18:10.png)

### 4.1.6 服务端代码实现 ###

<font color='red'>所有的代码实现,都是根据数据架构分析图来的</font>

<font color='red'>这个图包含了对整个模块的所以业务分析</font>

<font color='red'>理解和分析数据架构图,会代码实现时会非常的清晰</font>

#### 实体类实现 ####

  ```java
  public class SysLog implements Serializable {
  
  	/**
  	 * 序列化的id值,这个id值是实体类序列化的唯一表示
  	 * 
  	 * 我们可以使用这个id来进行序列化和反序列化
  	 * 
  	 * 序列化id最好是应用编译器进行自动生成
  	 */
  	private static final long serialVersionUID = 1L;
  	/**
  	* 和数据库进行一一对应的属性
  	*/
  }
  ```

   关于序列化

  + 序列化与反序列化功能实现:可以参考这个篇文章
    [全方位解析Java的序列化 - 知乎 (zhihu.com)](https://zhuanlan.zhihu.com/p/235394296)
  + 在Java中一般有关于存储的类(如String,ArrayList等)都会可实现序列化
  + 序列化的多应用在对象的保存,对象的网络传输等

  序列化测试

  ```java
  // 确定序列化文件的路径
  String fileName = "D:\\Java\\spring-boot-project\\CGB-DB-SYS-V1.01\\src\\main\\resources\\serializable\\SysLogObject.out";
  @Test
  	public void SerializableTest() throws Exception {
  		
  		// 创建一个SysLog对象 并 给予数据
  		SysLog log = new SysLog();
  		/**
  		*	为log对象属性赋值
  		*/
  		
  		// 对这个对象进行序列化
  		
  		//设置序列化文件
  		FileOutputStream fileOutputStream = new FileOutputStream(fileName);
  		
  		// 使用ObjectOutStream进行序列化
  		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
  		objectOutputStream.writeObject(log); // 将对象序列化到制定的文件
  		
  		objectOutputStream.close();
  		System.out.println("序列化完毕");
  		
  	}
  
  ```

  反序列化测试

  ```java
  @Test
  	public void deserialization() throws Exception {
  		
  		// 获取序列化文件
  		FileInputStream fileInputStream = new FileInputStream(fileName);
  		
  		// 使用Object
  		ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
  		Object object = objectInputStream.readObject();// 将序列化文件转化为对象保存在内存中
  		
  		System.out.println(object);
  		
  	}
  ```

当我们将序列化id删除后,会出现反序列化出现问题

#### 持久层设计与实现 ####

  我们在设计时有很多的业务,我们要在持久层中一一实现

  这里我将代码分成了几个部分

  1. update型SQL

  2. select型SQL

     其中select型SQL中要查询的结果有两部分

     1. 查询log条目
     2. 查询指定的值

  将代码使用注释分割线进行分割开了让代码更加整洁和易懂

  ```java
  package com.cy.pj.sys.dao;
  
  import java.util.List;
  
  import org.apache.ibatis.annotations.Mapper;
  
  import com.cy.pj.sys.entity.SysLog;
  
  /**
   * 日志持久层操作接口
   * 
   */
  @Mapper
  public interface SysLogDao {
  
  	/*
  	 * ***********************按条件统计记录总数*******************************************
  	 */
  
  	/**
  	 * 查询指定用户日志条总数
  	 * 
  	 * 这里的查询条件为模糊查询
  	 * 
  	 * @param username 指定用户名
  	 * 
  	 */
  	int getRowCount(String username);
  
  	/*
  	 * ***********************按条件查询Log条目********************************************
  	 */
  	/**
  	 * 查询指定用户的日志
  	 * 
  	 * @param username   指定的用户名
  	 * @param startIndex 起始索引位置
  	 * @param pageSize   一页要显示的行数
  	 * 
  	 */
  	List<SysLog> findPageObject(String username, long startIndex, int pageSize);
  }
  ```

##### Mapper文件设计与实现 #####

mapper文件的位置在`src/main/resource/mapper/sys`文件夹中

在配置时配置了

```yml
mapper-locations:
  - classpath:/mapper/*/*.xml
```

如果我们直接将mapper文件放置到mapper文件夹中会出现异常

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">


<mapper namespace="com.cy.pj.sys.dao.SysLogDao">


	<!-- 
		查询指定用户名日志总数
		用户名为模糊查询
		当用户名为空是,查询所有数据
	-->
	<select id="getRowCount" resultType="int"> 
		select count(*) from sys_logs 
		<where>
			<if test="username!=null and username!=''">
				username like concat("%",#{username},"%")
			</if>
		</where>
	</select>
	
	<!-- 
		查询指定用户的操作日志
	-->
	<select id="findPageObject" resultType="com.cy.pj.sys.entity.SysLog">
		
		SELECT id, username, operation, `method`, params, `time`, ip, createdTime 
		FROM sys_logs
		<where>
			<if test="username!=null and username!=''">
				username like concat("%",#{username},"%")
			</if>
		</where>
		limit #{startIndex},#{pageSize}
	</select>
	
	
</mapper>
```

##### 测试持久层是否可用 #####

```java
/***
 * 获取总行数测试
 */
@Test
public void getRowTest() {
	// 获取全部的列数
    int row = logDao.getRowCount("");
	log.info(row);
    
    // 根据条件查询指定的列数
	row = logDao.getRowCount("l");
	log.info(row);
}
/**
 * 获取指定用户的日志信息
 * 
 */
@Test
public void findPageObject() {
    // 获取全部的记录
	List<SysLog> logs = logDao.findPageObject("", 1, 100);

	for (Iterator iterator = logs.iterator(); iterator.hasNext();) {
		SysLog sysLog = (SysLog) iterator.next();
		log.info(sysLog);
	}
    
    // 根据条件查询指定目录
	log.info(logDao.findPageObject("xiao", 0, 10));

}
```

#### 业务层设计与实现 ####

由于我们传递的数据不仅仅包括查询到的记录,还包括页数,总页数,等数据

所以我们需要定义一个业务值对象`vo(Value Object)`

##### 定义PageObject对象 #####

```java
public class PageObject<T> implements Serializable {

	/**
	 * 序列化ID
	 */
	private static final long serialVersionUID = 1536631092048817285L;

	/**
	 * 当前页码数,默认值为1
	 */
	private Integer pageCurrent = 1;

	/**
	 * 页面展示数据数,默认值为3
	 */
	private Integer pageSize = 3;

	/**
	 * 总数据数
	 */
	private Integer rowCount = 0;

	/**
	 * 总页数
	 */
	private Integer pageCount = 0;

	/**
	 * 查询的数据
	 */
	private List<T> records;
    
    public PageObject(Integer pageCurrent, Integer pageSize, Integer rowCount, List<T> records) {
		super();
		this.pageCurrent = pageCurrent;
		this.pageSize = pageSize;
		this.rowCount = rowCount;
		this.records = records; 
        
		this.pageCount= (rowCount-1)/pageSize+1;
	}
}
```

这个vo类型,可适用于各种查询到的类型,包括log和user等

使用泛型来进行约束

其中总页数,和总页数通过总数据数和展示数来进行计算

##### 业务层实现 #####

业务层接口设计

```java
public interface SysLogService {	
	PageObject<SysLog> finPageObject(String username, Long pageCurrent);	
}
```

业务层实现类

```java
@Service
public class SysLogServiceImpl implements SysLogService {
    /**
 	* 页面最多显示10行数据
 	*/
	private static final Integer pageSize = 10;

	/**
	* 这个方法分为四部分
 	* 1. 校验参数
 	* 2. 查询总数,校验参数
 	* 3. 查询记录
 	* 4. 封装数据
 	*/
    public PageObject<SysLog> finPageObject(String username, Long pageCurrent) {}
}
```

这里有一个小问题

```java
Long rowCount = sysLogDao.getRowCount(username).longValue();
```

这个地方,MySQL`select count(*)`语句出入的值为int,这里进行类型转换

##### 自定义异常 #####

在程序运行过程总,需要抛出很多的异常类型

我们可以自定义一些异常来进行使用

自定义的异常一般要继承`RuntimeException`异常类

```java
package com.cy.pj.common.exception;

public class ServiceException extends RuntimeException {
	private static final long serialVersionUID = -5598865415547474216L;
}
```

#### 控制层设计与实现 ####

控制层对象主要负责请求和响应数据的处理，例如，本模块首先要通过控制层对象处理请求参数，然后通过业务层对象执行业务逻辑，再通过VO对象封装响应结果(主要对业务层数据添加状态信息)，最后将响应结果转换为JSON格式的字符串响应到客户端

##### 定义JsonResult对象 #####

这个类型对数据进行封装,主要对查询的数据进行了格式化

不同的用户和不同的前端可以根据这个标准来进行解析数据

```java
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JsonResult implements Serializable {

    private static final long serialVersionUID = 2080943344863436345L;

    /**
     * 状态码
     * 1表示SUCCESS
     * 0表示ERROR
     */
    private byte state = 1;

    /**
     * 传递的信息
     */
    private String message = "ok";

    /**
     * 正确的数据
     */
    private Object data;

    /**
     * 当业务层抛出异常
     * 获取信息失败
     */
    public JsonResult(Throwable t){
        this.state = 0;
        this.message = t.getMessage();
    }

    /**
     * 获取信息成功
     * 直接将信息进行写入
     */
    public JsonResult(Object data){
        this.data = data; 
    }
}
```

##### 控制层实现 #####

我们在这里值进行了对正确信息的处理

错误信息的处理放置到了全局异常处理类中

```java
@RequestMapping("doFindPageObjects")
@ResponseBody
public JsonResult findPageObject(String username, Integer pageCurrent) {
        
	PageObject<SysLog> data = service.finPageObject(username, pageCurrent.longValue());
        
	JsonResult result = new JsonResult(data);
    
    return result;
        
    }
}
```

##### 全局异常处理类 #####

使用注解`@ControllerAdvice`来定义一个全局异常处理类型

这个注解由SpringMVC提供

<font color='red'>这里需要理解服务器API架构图</font>

```java
@ControllerAdvice
public class GlobalExceptionHandler {
	// 可以处理RuntimeException类型及其子类型
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public JsonResult doHandleRuntimeException(RuntimeException exception) {

        // 在控制台上打印输出异常信息
        exception.printStackTrace();

        // 将结果传递到前端
        return new JsonResult(exception);
    }

}
```

#### 前端接收和处理数据 ####

加载`dopageUI`页面,加载数据

```js
$(function(){
   //在log_list.html页面的pageId位置，加载page.html,合二为一。
   $("#pageId").load("doPageUI",function(){//资源加载完成执行
	   doGetObjects();//异步加载日志信息
   })
   // 上述代码可以进行简化
   $("#pageId").load("doPageUI",doGetObjects)
   //这里的回调函数参数不可以加'()'否则会立刻执行
})
```

##### load()函数 #####

> 载入远程 HTML 文件代码并插入至 DOM 中。
>
> 默认使用 GET 方式 - 传递附加参数时自动转换为 POST 方式。jQuery 1.2 中，可以指定选择符，来筛选载入的 HTML 文档，DOM 中将仅插入筛选出的 HTML 代码。语法形如 "url #some > selector"。请查看示例。

| 参数     | 解释                     |
| -------- | ------------------------ |
| url      | 远程HTML地址             |
| data     | 向远程地址传递的参数     |
| callback | 加载完毕后执行的回调函数 |

##### 获取值 #####

当我们加载页面时需要取值

```js
//执行分页查询
function doGetObject(){
    //1. 定义参数
    var params = {"pageCurrent" : 1}
    
    //2. 定义请求地址url
    var url = 'doFindPageObject'
    
    //3. 发送异步请求
    $.getJSON(url,params,function(result){
        console.log(result);
 		// 将数据放置到页面上
        doHandleResponseResult(result);
    })
}
```

##### 将数据放置到页面上 #####

```js
function doHandleResponseResult(result){
    //验证状态信息
    if(result.state == 1 ){// 获取为正确的数据
        
        // 1.更新日志列表信息
        doSetTableBodyRows(result.data.records)
        // 2.更分页信息
        
    }else{// 获取为正确的数据
        alert(result.message);
    }
}

// 更新tbody日志列表信息
function doSetTableBodyRows(records){
    //1. 获取tbody,清空原有内容
    var tBody=$("#tbodyId");
    tBody.empty();
    //2. 迭代records对象并将内容追加到tbody中
    for(const r of records){
         
    }
}
```

 



