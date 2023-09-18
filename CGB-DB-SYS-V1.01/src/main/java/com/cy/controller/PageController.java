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
