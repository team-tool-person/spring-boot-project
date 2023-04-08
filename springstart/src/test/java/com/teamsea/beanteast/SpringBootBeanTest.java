package com.teamsea.beanteast;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.teamsea.bean.User;
import com.teamsea.bean.UserToolBean;


/**
 * 这个用户测试Spring Boot注入依赖,生命周期,Bean组件管理
 * 	
 * 创建两个工具Bean种子类,两个都是单例模式
 * 其中一个进行懒加载,一个直接进行加载
 * 
 * 创建一个User类和一个File类
 * 其中User修饰为多例模式,File设计为单例模式
 * 
 * 这四个类同事声明声明周期方法
 *  
 *  */
@SpringBootTest
public class SpringBootBeanTest {
	
	
	@Autowired
	private User user;
	
//	@Autowired 
//	private UserToolBean userToolBean;
	
	@Test
	public void beanTest() {
		
		System.out.println(user);
		
	}
	
	@Test
	public void userToolsTest() {
//		System.out.println(userToolBean);
	}
	
	
	
	
}
