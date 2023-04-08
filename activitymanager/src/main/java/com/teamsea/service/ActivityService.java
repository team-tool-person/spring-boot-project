package com.teamsea.service;

import java.util.List; 

import com.teamsea.pojo.Activity;

/**
 * Activity业务接口,针对Activity的业务处理
 * 
 * 所用的update系方法都应给抛出异常
 * 
 * 前端 Controller 应该获取这些异常信息
 * 
 * 所有的update系方法设计:
 * 
 * 1. 先验证参数是否存在
 * 
 * 2. 验证值是否存在
 * 
 * 3. 进行update
 * 
 */
public interface ActivityService {

	/**
	 * 获取活动列表
	 * 
	 */
	public List<Activity> getActivities();

	/**
	 * 创建新的活动
	 *	
	 */
	public boolean createActivity(Activity activity) throws Exception;

	/**
	 * 删除活动
	 * 
	 */
	public boolean deleteActivity(Activity activity)throws Exception;

	/**
	 * 修改活动
	 * 
	 */
	public boolean updateActivity(Activity activity)throws Exception;

}
