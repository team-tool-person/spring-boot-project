package com.teamsea.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.teamsea.pojo.Activity;



/**
 *	活动数据操作类
 *  
 * */
@Mapper
public interface ActivityDao {
	
	
	/**
	 * 新建活动
	 * */
	public int createActivity(Activity activity);
	
	/**
	 * 删除活动
	 * 伪删除
	 * */
	public int deleteActivity(Integer id);
	
	/***
	 * 	修改活动
	 * */
	public int updateActivity(Activity activity);
	
	
	/**
	 *  获取活动列表
	 * */
	public List<Activity> getActivityts();
	
	/**
	 * 查询活动是否存在
	 * */
	public int isExist(Integer id,String title);
	
}
