package com.teamsea.service;

import com.teamsea.model.Teacher;

/**
 * 教师业务层
 * 
 * 教师的功能方法
 * 
 * 1. 教师登录
 * 
 * 2. 发布课题
 * 
 * 3. 批改作业
 */
public interface TeacherService {

	/**
	 * 教师登陆
	 * 
	 * 教师使用id和密码进行登录
	 * 
	 * @param 教师要有两个参数 1. id 2.password
	 */
	public Teacher teacherLogin(Teacher teacher);

	/**
	 * 发布课题
	 * 
	 * 对指定的课程的课题要求进行修改
	 * 
	 * 使用教师id和课程id对这个行为进行约束
	 * 
	 * 对课题的大小进行约束
	 * 
	 * @param 教师id
	 * @param 课程id
	 * @param 课题要求
	 */
	public boolean updataRequirement(Integer teacherId, Integer courseId, String string);

	/**
	 * 批改作业
	 * 
	 * 根据教师的登记属性来给作业进行赋值
	 * 
	 * @param 教师id
	 * @param 分数
	 */
	public boolean correctWork(Integer teacherId, Integer score);

}
