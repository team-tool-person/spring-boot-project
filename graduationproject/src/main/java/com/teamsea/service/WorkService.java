package com.teamsea.service;

import java.util.Map;

import com.teamsea.model.Course;
import com.teamsea.model.Student;
import com.teamsea.model.Teacher;
import com.teamsea.model.Work;

/**
 * 毕业设计业务层
 * 
 * 这个业务层针对毕业设计进行查询的方法
 * 
 */
public interface WorkService {

	/**
	 * 教师查看指定班级的毕业设计信息
	 * 
	 * 
	 * 
	 * 使用教师id和班级id来对这个行为进行约束
	 * 
	 * @param 教师id
	 * @param 班级id
	 * 
	 */
	public Map<Student,Work> teacherGetWorks(Teacher teacher, Course course);

	/**
	 * 学生查看毕业设计
	 * 
	 * 使用学生
	 * */
	
	
}
