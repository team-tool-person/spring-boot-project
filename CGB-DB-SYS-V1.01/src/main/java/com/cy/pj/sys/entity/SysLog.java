package com.cy.pj.sys.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 实体类规范实现序列化
 * 
 * 实现Serializable接口来进行序列化
 * 
 * 序列化会将实体类转化为字节文件保存在磁盘中,缓解内存压力
 * 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysLog implements Serializable {

	/**
	 * 序列化的id值,这个id值是实体类序列化的唯一表示
	 * 
	 * 我们可以使用这个id来进行序列化和反序列化
	 * 
	 * 这里是编辑器事前的
	 */
	private static final long serialVersionUID = 3594823546108659148L;


	private Integer id;

	/**
	 * 用户名
	 */
	private String username;

	/**
	 * 用户操作
	 */
	private String operation;

	/**
	 * 请求方法
	 */
	private String method;

	/**
	 * 请求擦参数
	 * */
	private String params;

	/**
	 * 请求参数
	 * */
	private Long time;

	/**
	 * 请求Ip地址
	 * */
	private String ip;
	
	/**
	 * 创建时间
	 * */
	private Date createdTime;

}
