package com.teamsea.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.teamsea.model.Admin;
import com.teamsea.model.MsgShow;
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

	@Autowired
	private MsgService msgService;

	/**
	 * 管理员主页请求的信息
	 * 
	 **/

	/**
	 * 
	 * 获取Msg信息
	 */
	@RequestMapping("getMsgs")
	@ResponseBody
	public List<MsgShow> getMsgs() {

		return msgService.getMsgShows();

	}

	
	
	
	
	/**
	 * 通用页面跳转
	 */
	@RequestMapping("/{pageName}")
	public String toJsp(@PathVariable String pageName) {
		return "redirect:/admin/index";
	}

	/**
	 * 管理员主页面
	 * 
	 */
	@RequestMapping("index")
	public String adminIndex(Integer id, String name) {

		Admin admin = new Admin();

		admin.setId(id);
		admin.setName(name);

		// 身份验证
		if (service.adminIsExit(admin)) {
			return "adminIndex";
		}
		return "adminlogin";
	}

	/**
	 * 管理员主界面获取数据
	 * 
	 * 管理员主界面获取上报信息
	 * 
	 */

	/**
	 * 管理员登录
	 * 
	 * 管理员进行登录 登录成功则进行重定向
	 * 
	 * 登录失败则进行提示
	 * 
	 */

	@RequestMapping(value = "login", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public Admin adminLogin(Admin user) {

		Admin admin = service.adminLogin(user);

		return admin;
	}

}
