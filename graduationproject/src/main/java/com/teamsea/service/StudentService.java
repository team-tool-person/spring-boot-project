package com.teamsea.service;

import java.io.File;

import com.teamsea.model.Student;

/**
 * 学生业务层
 * 
 * 1. 学生登录
 * 
 * 2. 提交作业
 * 
 */
public interface StudentService {

	/**
	 * 学生登录
	 * 
	 * 学生使用id和密码进行登录
	 * 
	 * @param 教师要有两个参数 1. id 2.password
	 */
	public Student studentLogin(Student student);
	
	
	/**
	 * 提交作业
	 * 
	 * 学生提交指定自己课程的毕业设计
	 * 
	 * 学生使用这个方法可以进行更新毕业设计
	 * 
	 * 使用学生id 和课程id 对这个行为进行约束
	 * 
	 * @param 学生id
	 * @param 课程id
	 * @param 毕业设计文件 
	 *
	 * */
	public boolean updataWork(Integer studentId,Integer courseId,File workFile);
	
}
