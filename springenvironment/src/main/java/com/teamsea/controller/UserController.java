package com.teamsea.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *  使用注解@Controller 声明这个类是 Controller
 *  
 *  使用注解@RequestMapping 表示这个类访问地址的前缀
 *  
 *  在方法的注解@@RequestMapping 表示 
 * */

@Controller

@RequestMapping("/user/")
public class UserController {

	@RequestMapping("userlist")
	public String UsersController() {
		return "userlist";
	}
}
