package com.teamsea.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.teamsea.pojo.Activity;
import com.teamsea.service.ActivityService;

/**
 * 活动的 Controller
 * 
 * 
 */

@Controller
@RequestMapping("/activity/")
public class ActivityController {

	@Autowired
	private ActivityService service;

	/**
	 * 获取所有的活动列表
	 * 
	 */
	@RequestMapping("activitieslist")
	public String getActivitiesList(Model model) {
		List<Activity> list = service.getActivities();

		model.addAttribute("activities", list);

		return "activitieslist";
	}

	/**
	 * 异步请求页面
	 * 
	 * 
	 */
	@RequestMapping("a_list")
	public String getA_list() {
		return "a_list";
	}

	@RequestMapping("createactivity")
	public String createActivity(Activity activity) {

		try {
			service.createActivity(activity);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:/activity/activitieslist";
	}

	/***
	 * 删除活动信息
	 * 
	 * 
	 */
	@RequestMapping("deleteactivity")
	public String deleteActivity(int id, String title) {

		Activity activity = new Activity();

		activity.setId(id);

		activity.setTitle(title);

		try {
			service.deleteActivity(activity);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:/activity/activitieslist";
	}

	/**
	 * 更新活动信息
	 * 
	 */
	@RequestMapping("updateactivity")
	public String updateActivity(Activity activity) {

		try {
			service.updateActivity(activity);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:/activity/activitieslist";
	}

	/***
	 * 使用dofindactivities地址来进行访问 使用@Response注解,springMVC会将输出的值转化为JSOn格式
	 * 
	 * 
	 */

	@RequestMapping("dofindactivities")
	@ResponseBody
	public List<Activity> doFindActivities() {
		List<Activity> list = service.getActivities();
		return list;
	}

}
