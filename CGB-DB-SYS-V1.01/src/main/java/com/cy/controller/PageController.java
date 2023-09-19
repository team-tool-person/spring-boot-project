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
	
}
