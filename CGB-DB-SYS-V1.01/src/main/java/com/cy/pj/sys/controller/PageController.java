package com.cy.pj.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 页面Controller 将路径访问跳转到对应的页面
 * 
 * 
 * 
 */

@Controller
@RequestMapping("/")
public class PageController {

	/**
	 * 主页跳转
	 * 
	 */
	@RequestMapping("doIndexUI")
	public String doIndexUI() {
		return "starter";
	}

	/**
	 * 分页菜单,用来实现分页操作
	 */
	@RequestMapping("doPageUI")
	public String doPageUI() {
		return "common/page";
	}
/*
	/**
	 * Log数据展示页面,用来展示数据信息和对数据的操作
	 
	 
	@RequestMapping("log/log_list")
	public String doLogUI() {
		return "sys/log_list";
	}

	/**
	 * Menu菜单数据展示页面,用来展示数据信息和数据操作
	 
	@RequestMapping("menu/menu_list")
	public String doMenusUI() {
		return "sys/menu_list";

	}
 */

	/**
	 * REST风格的URL映射
	 * REST是一种软件架构编码风格,在这种风格下的url定义,可以使用变量的方法让url更加简单
	 * 在方法参数中需要url中的{变量}值时,使用注解`@pathVariable`进行获取
	 * 并且要求被修饰的变量名,和{变量}表达式中的变量名相同
	 * 
	 * 页面加载的通用方法
	 * 
	 * @param moduleUI 模块页面名称
	 */
	@RequestMapping("/{module}/{moduleUI}")
	public String ModuleUI(@PathVariable String moduleUI) {
		return "sys/"+moduleUI;
	}
		
}
