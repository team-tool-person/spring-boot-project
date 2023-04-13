package com.teamsea.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/***
 * 学生,教师,管理员的父类
 * 
 * 有集成属性
 * 
 * id,name,age,sex
 * 
 * 
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Person {

	private Integer id; // 编号
	private String name; // 姓名
	private Integer age; // 年龄
	private String sex; // 性别
	
}
