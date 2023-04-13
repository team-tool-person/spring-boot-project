package com.teamsea.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.teamsea.pojo.Student;

/**
 * 学生持久层操作类
 * 
 * 执行学生的增删改查等功能
 * 
 */

@Mapper
public interface StudentMapper {

	// 添加学生信息
	public int addStudent(Student student);

	// 删除学生信息
	public int deleteStudent(Student student);

	// 修改学生信息
	public int updataStudent(Student student);

	/**
	 * 查询所有学生信息 使用分页查询
	 * 
	 * @param 偏移量=页数*pageSize
	 * @param 展示的数据量
	 */
	public List<Student> studentsList(Integer pageNumber, Integer pageSize);

	/**
	 * 通过学生id查询学生信息
	 * 
	 */
	@Select("select * from student where id = #{id}")
	public List<Student> getStudentsById(Integer id);

	/**
	 * 通过学生id查询学生信息
	 *
	 * */
	@Select("select * from student where name = #{name}")
	public List<Student> getStudentsByName(String name);

	/** 
	 * 通过班级查询学生信息
	 * 
	 * @param 班级名称
	 */
	
	@Select("select * from student where class = #{className}")
	public List<Student> getStudentsByClass(String className);

	
	
	
	
	// 查询提交作业的同学

	// 查询未提交作业的同学

	// 查询学生是否存在

}
