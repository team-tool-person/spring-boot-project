package com.teamsea.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * User用户Bean种子
 * 为多例模式
 * */

@Component
@Scope("prototype")
public class User {

	private String name;
	private String id;

	@PostConstruct
	private void init() {
		System.out.println("User	已经创建");
	}
	
	@PreDestroy
	private void destroy() {
		System.out.println("User	已经销毁");
	}
}
