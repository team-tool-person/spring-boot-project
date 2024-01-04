package com.cy.pj.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cy.pj.sys.entity.Role;

/**
 * 角色持久层操作接口
 * 
 */
@Mapper
public interface RoleDao {

	/**
	 * 查询指定角色名的总数目
	 * 
	 * 这里的查询为模糊查询
	 * 
	 * @param name 指定的角色名称
	 * @return 数据总数目
	 */
	Long getRowCount(String name);

	/**
	 * 查询指定角色名的数据
	 * 
	 * 这里的查询为模糊查询
	 * 
	 * @param name 指定的角色名
	 * @param startIndex 起始查询位置
	 * @param pageSize  一页的查询总数
	 * @return 查询到的数据
	 */
	List<Role> findPageObject(String name, long startIndex, int pageSize);

	/**
	 * 删除指定的角色
	 * @param id
	 * @return 影响的行数
	 */
	Integer deleteObject(Integer...ids);

	
}
