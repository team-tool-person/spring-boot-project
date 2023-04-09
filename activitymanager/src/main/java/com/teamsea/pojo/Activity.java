package com.teamsea.pojo;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 活动类 使用LomBok插件进行优化
 * 
 * 使用注解@Data生成Getter and Setter ToString
 * 
 * 使用注解@NoArgsConstructor生成无参构造
 * 
 * 使用注解@AllArgsConstructor生成全参构造
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Activity {

	private Integer id; // id属性
	private String title; // 标题
	private String category; // 等级

	// 因为Date 是一个过期的类型(有各种个样的问题)
	// 现在使用的日期类型是 JDK8 中出现的 LocalDateTime 工具类
	private LocalDateTime startTime; // 开始时间
	private LocalDateTime endTime; // 结束时间
	private Byte state; // 状态
	private String remark;// 内容正文
	private String createUser; // 创建用户
	private LocalDateTime createdTime; // 创建时间

}
