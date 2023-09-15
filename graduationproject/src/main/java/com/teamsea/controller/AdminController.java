package com.teamsea.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.teamsea.model.Admin;
import com.teamsea.model.MsgShow;
import com.teamsea.model.Student;
import com.teamsea.model.Teacher;
import com.teamsea.service.AdminService;
import com.teamsea.service.MsgService;

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

//*****管理员主页请求的信息************************************************************************************************************************************

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
	 * 删除信息
	 * 
	 */
	@RequestMapping("deleteMsg")
	@ResponseBody
	public String deleteMsg(Integer id) {

		Integer row = msgService.deleteMsg(id);

		return row.toString();
	}

//*****管理员对教师进行管理*********************************************************************************************************************

	/**
	 * 获取教师信息
	 * 
	 */
	@RequestMapping("getTeacher")
	@ResponseBody
	public List<Teacher> getTeachers() {

		List<Teacher> teachers = service.getTeachers();

		return teachers;
	}

	/**
	 * 删除教师
	 * 
	 */
	@RequestMapping("deleteTeacher")
	@ResponseBody
	public String deleteTeacher(Integer id) {
		Teacher teacher = new Teacher();
		teacher.setId(id);
		Boolean flag = service.deleteTeacher(teacher);
		return flag.toString();
	}

//*****对学生的管理***********************************************************************************************************************************

	/**
	 * 获取所有的学生
	 * 
	 */
	@RequestMapping("getStudents")
	@ResponseBody
	public List<Student> getStudents() {

		List<Student> students = service.getStudents();
		
		return students;

	}

//****************************************************************************************************************************************

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
