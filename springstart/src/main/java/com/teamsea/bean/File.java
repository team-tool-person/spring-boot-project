package com.teamsea.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component
public class File {
	
	private String name;
	
	private String path;
	
	private File file;
	
	
	@PostConstruct
	private void init() {
		System.out.println("File	已经创建");
	}
	
	
	@PreDestroy
	private void destroy() {
		System.out.println("File	已经销毁");
	}
}
