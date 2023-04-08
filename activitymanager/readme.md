# Spring Boot 第二个综合项目

## 1. 本项目中使用的特殊AIP和框架

### 1.1 使用 LocalDateTime 工具类

本项目使用`LocalDateTime`工具类来作为时间管理类,放弃了Date

使用位置:	`com.teamsea.pojo.Activity`

```java
private LocalDateTime startTime; // 开始时间
private LocalDateTime endTime; // 结束时间
```

### 1.2 使用 Logger 日志框架

本项目使用了`org.slf4j.Logger`框架来进行控制台输出,并没有完全拒绝sout语句

使用位置:	`com.teamsea.servicetest.ActivityTest`

```java

```


## 2. 关于一个万能的参数纠错方法

参数获取的方法都是一致的,对参数的判断条件不一致

所以这个方法有两个设计

1. 和监听器的处理方式一致,写一个抽象方法让使用者去编写这个方法

2. 传递一个`Method`对象,执行这个方法

最终我们选择第一个设计方案

```java

public boolean fieldInRule(Object object){}

/**
* 这个方法就是要被扩充的方法,由于本人能力有限,建议改进
*/
public abstract boolean rule(String name, Object value);

```

## 关于纠错使用的方法问题

报错信息应该万能还是要省略

抛出异常的确实万能但是有安全性问题

而且不应给将异常返还给前端,所以我决定Service接口的update方法类型进行异常抛出

Controller类应该获取其中异常信息并返回给前端








