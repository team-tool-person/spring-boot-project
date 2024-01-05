package com.cy.pj.sys.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface RoleMenuDao {

    /**
     * 根据菜单ID来查询关系表
     *
     * @param menuId 菜单Id
     * @return
     */
    List<Map<String, Object>> findObjectByMenuId(Integer menuId);

    /**
     * 删除指定菜单id关系表数据
     * 删除菜单时要先删除关系表中的对应关系
     * @param menuId 菜单id
     * @return 影响的行数
     */
    Integer deleteObjectByMenuId(Integer menuId);

    /**
     * 删除指定角色id的关系表数据,这里只删除一个
     * 在删除角色时要先删除关系表内容
     * @param id 角色id 这里只删除一个
     * @return 影响行数
     */
    Integer deleteObjectByRoleId(Integer roleId);

    /**
     * 删除指定角色ids的关系表数据,这里使用的可变参数
     * 在删除角色时要先删除关系表内容
     * @param roleIds 角色ids 可变数据
     * @return 影响行数
     */
    Integer deleteObjectByRoleIds(@Param("roleIds")Integer...roleIds);

}
