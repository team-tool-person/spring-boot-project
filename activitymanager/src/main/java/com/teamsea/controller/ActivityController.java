package com.teamsea.controller;

import java.util.List;

import org.apache.naming.ServiceRef;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
