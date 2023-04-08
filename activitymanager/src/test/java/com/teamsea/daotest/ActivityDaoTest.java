package com.teamsea.daotest;

import java.util.List;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.teamsea.dao.ActivityDao;
import com.teamsea.pojo.Activity;

@SpringBootTest
public class ActivityDaoTest {

	/**
	 * 众所周知在Java中sout语句是一个非常屎山的东西.
	 * 
	 * 所以我们使用Logger 日志框架对一些数据打印输入到控制台
	 */

	@Autowired
	private ActivityDao mapper;

	/**
	 * 添加测试
	 */
	@Test
	public void createActivityTest() {
		Activity activity = new Activity();
		// 自己写一个新的活动太累了,拿一个改一下
		List<Activity> activities = mapper.getActivityts();
		activity = activities.get(0);
		activity.setId(null);
		activity.setTitle("打折");
		System.out.println(mapper.createActivity(activity));

	}

	/**
	 * 删除测试
	 */
	@Test
	public void deleteActivityTest() {
		Integer id = 4;
		System.out.println(mapper.deleteActivity(id));
	}

	/**
	 * 修改测试
	 * 
	 */
	@Test
	public void updateActivityTest() {
		Activity activity = new Activity();
		// 自己写一个新的活动太累了,拿一个改一下
		List<Activity> activities = mapper.getActivityts();
		activity = activities.get(2);
		activity.setTitle("抚慰机魂");
		activity.setCategory("产品上线");
		System.out.println(mapper.updateActivity(activity));
	}

	/**
	 * 存在测试
	 */
	@Test
	public void isExistTest() {
		System.out.println(mapper.isExist(4, "抚慰机魂"));
	}

}
