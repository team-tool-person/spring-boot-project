package com.teamsea.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.teamsea.model.Admin;
import com.teamsea.service.AdminService;

/**
 * 管理员控制层
 *
 *
 **/
@Controller
@RequestMapping("/admin/")
public class AdminController {

	@Autowired
	private AdminService service;

	/**
	 * 通用页面跳转
	 */
	@RequestMapping("/{pageName}")
	public String toJsp(@PathVariable String pageName) {
		return "redirect:/admin/index";
	}

	/**
	 * 管理员登录
	 * 
	 * 管理员进行登录
	 * 登录成功则进行重定向
	 * 
	 * 登录失败则进行提示
	 * 
	 */

	@RequestMapping(value="login" ,method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public Admin adminLogin(Admin user) {

		Admin admin =  service.adminLogin(user);
		
		return admin;

	}

	/**
	 * 管理员主页面
	 * 
	 * */
	@RequestMapping("index")
	public String adminIndex(Integer id,String name) {
		
		Admin admin = new Admin();
		
		admin.setId(id);
		admin.setName(name);
		
		// 身份验证
		if ( service.adminIsExit(admin)) {
			return "adminIndex";
		}
		return "adminlogin";
		
	} 
	
}
