package com.cy.pj.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cy.pj.common.vo.RoleMenuVo;
import com.cy.pj.sys.entity.Role;

/**
 * 角色持久层操作接口
 *
 */
@Mapper
public interface RoleDao {

/*===查询操作======================================================================================*/

	/**
	 * 查询指定角色名的总数目,这里的查询为模糊查询
	 * @param name 指定的角色名称
	 * @return 数据总数目
	 */
	Long getRowCount(String name);

	/**
	 * 查询指定角色名的数据,这里的查询为模糊查询
	 * @param name 指定的角色名
	 * @param startIndex 起始查询位置
	 * @param pageSize  一页的查询总数
	 * @return 查询到的数据
	 */
	List<Role> findPageObject(String name, long startIndex, int pageSize);

	
	/**
	 * 通过Name属性来获取id
	 * @param name
	 * @return
	 */
	Integer getIdByName(String name);

	/**
	 * 通过Id来查询数据,其中包括角色的id,name,note和角色管理的所有的菜单id
	 * @param id
	 * @return
	 */
	RoleMenuVo findObjectById(Integer id);
	
/*===删除操作======================================================================================*/
	
	/**
	 * 删除指定的角色,删除多个
	 * @param ids 要删除的角色id
	 * @return 影响的行数
	 */
	Integer deleteObjects(Integer...ids);

	
	/**
	 * 删除指定角色,删除一个
	 * @param id 要删除的角色id
	 * @return 影响的行数
	 */
	Integer deleteObject(Integer id);
	
/*===添加操作======================================================================================*/
	
	/**
	 * 添加角色信息
	 * @param role 添加的角色信息
	 * @return 影响的行数
	 */
	Integer saveObject(Role role);
	
}
