package com.cy.pj.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cy.pj.sys.entity.SysRole;

/**
 * 角色持久层操作接口
 * 
 */
@Mapper
public interface SysRoleDao {

	/**
	 * 查询指定角色名的总数目
	 * 
	 * 这里的查询为模糊查询
	 * 
	 * @param name 指定的角色名称
	 * @return 数据总数目
	 */
	Integer getRowCount(String name);

	/**
	 * 查询指定角色名的数据
	 * 
	 * 这里的查询为模糊查询
	 * 
	 * @param name 指定的角色名
	 * @param jump 跳过数目
	 * @param num  一页的查询总数
	 * @return 查询到的数据
	 */
	List<SysRole> findPageObject(String name, Integer startIndex, Integer pageSize);

}
