package com.cy.pj.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cy.pj.sys.entity.SysLog;

/**
 * 日志持久层操作接口
 * 
 */
@Mapper
public interface SysLogDao {

	/*
	 * ***********************按条件统计记录总数*******************************************
	 */

	/**
	 * 查询指定用户日志条总数
	 * 
	 * 这里的查询条件为模糊查询
	 * 
	 * @param username 指定用户名
	 * 
	 */
	Integer getRowCount(String username);

	/*
	 * ***********************按条件查询Log条目********************************************
	 */
	/**
	 * 查询指定用户的日志
	 * 
	 * @param username   指定的用户名
	 * @param startIndex 起始索引位置
	 * @param pageSize   一页要显示的行数
	 * 
	 */
	List<SysLog> findPageObject(String username, long startIndex, int pageSize);

	/*
	 * ***********************按条件进行增删改等操作********************************************
	 */
	/**
     * 删除指定条目
     * 
	 * 
     * @param ids id号码,允许多数据进行删除
	 * 
     */
	Integer deleteObject(Integer...ids);

	/**
	 * 增加用户操作日志
	 * 
	 * @param entitiy 日志信息
	 */
	Integer insertObject(SysLog entity);
}
