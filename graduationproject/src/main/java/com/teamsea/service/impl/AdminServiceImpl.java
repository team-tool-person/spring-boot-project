package com.teamsea.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamsea.mapper.AdminMapper;
import com.teamsea.mapper.StudentMapper;
import com.teamsea.mapper.TeacherMapper;
import com.teamsea.model.Admin;
import com.teamsea.model.Student;
import com.teamsea.model.Teacher;
import com.teamsea.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminMapper mapper;

	@Autowired
	private TeacherMapper teacherMapper;

	@Autowired
	private StudentMapper studentMapper;

	/**
	 * 管理员登录
	 * 
	 */
	@Override
	public Admin adminLogin(Admin admin) {

		Admin user = mapper.adminLogin(admin);

		return user;

	}

	/**
	 * 验证管路员是否存在
	 * 
	 */
	@Override
	public boolean adminIsExit(Admin admin) {

		int row = mapper.isExit(admin);

		if (row <= 0) {
			return false;
		}

		return true;
	}

	@Override
	public boolean insertTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insertStudent(Student student) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateStudent(Student student) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteStudent(Student student) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeStudent(Student student) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Teacher> getTeachers() {

		List<Teacher> teachers = teacherMapper.selectAll();

		return teachers;
	}

	@Override
	public List<Student> getStudents() {

		List<Student> students = studentMapper.selectAll();

		return students;
	}

}
