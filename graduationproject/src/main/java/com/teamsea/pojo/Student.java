package com.teamsea.pojo;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 学生类
 *
 *
 * 
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class Student extends Person {

	private String classname; // 班级
	private String category; // 培养等级
	private LocalDate enrollmentTime; // 入学时间
	private LocalDate graduationTime; // 毕业时间
}
