package com.teamsea.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.teamsea.model.Admin;
import com.teamsea.model.Student;
import com.teamsea.model.Teacher;

/**
 * 管理员业务层
 * 
 * 管理员要执行的功能有:
 * 
 * 1. 管理员的登录
 * 
 * 2. 教师的增删改查
 * 
 * 3. 学生的增删改查
 * 
 */

public interface AdminService {

	/**
	 * 管理员登录
	 * 
	 * @param 这个管理员参数应该包括两个值 1. name 2. password
	 * 
	 * @return 返还一个完整的admin参数
	 */
	public Admin adminLogin(Admin admin);
	
	/**
	 * 验证管理员是否存在
	 * */
	public boolean adminIsExit(Admin admin);
	
	
	/**
	 * 对教师的操作
	 */
	
	/**
	 * 获取教师
	 * 
	 * */
	public List<Teacher> getTeachers();
	
	
	/**
	 * 增加教师
	 * 
	 */
	public boolean insertTeacher(Teacher teacher);

	/**
	 * 修改教师信息
	 * 
	 */
	public boolean updateTeacher(Teacher teacher);

	/**
	 * 删除教师信息
	 * 伪删除
	 */
	public boolean deleteTeacher(Teacher teacher);

	/**
	 * 删除教师
	 * 真删除
	 * 
	 */
	public boolean removeTeacher(Teacher teacher);

	/**
	 * 对学生的管理
	 */
	
	
	/**
	 * 查找学生信息
	 * 
	 * */
	public List<Student> getStudents();
	
	/**
	 * 增加学生
	 * 
	 */
	public boolean insertStudent(Student student);

	/**
	 * 修改学生信息
	 * 
	 */
	public boolean updateStudent(Student student);

	/**
	 * 删除学生
	 * 伪删除
	 * 
	 */
	public boolean deleteStudent(Student student);

	/**
	 * 删除学生
	 * 真删除
	 * 
	 */
	public boolean removeStudent(Student student);

	
}
