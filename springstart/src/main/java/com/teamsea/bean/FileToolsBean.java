package com.teamsea.bean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 	文件管理类用于对文件的一些操作和管理
 * 	
 * 	单例
 * */


@Component
@Scope("singleton")
public class FileToolsBean {
	@PostConstruct
	private void init() {
		System.out.println("FileTool创建");
	}
	
	@PreDestroy
	private void destroy() {
		System.out.println("FileTool销毁");
	}
	
}
