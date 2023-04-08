package com.teamsea.bean;

import javax.annotation.PostConstruct; 
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 这个工具类使用来对User进行管理和操作的
 * 设定为单例,但是要懒加载
 * 
 * */

@Component
@Scope("singleton")
@Lazy
public class UserToolBean {

	@PostConstruct
	private void init() {
		System.out.println("UserTools创建");
	}
	
	@PreDestroy
	private void destroy() {
		System.out.println("UserTools销毁");
	}
	
}
