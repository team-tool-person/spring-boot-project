package com.teamsea.pojo;

import java.io.File;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectFile {

	private Integer id; // 编号
	private String name;// 名称
	private Integer studentId; // 所属学生编号
	private File file; // 文件类
}
