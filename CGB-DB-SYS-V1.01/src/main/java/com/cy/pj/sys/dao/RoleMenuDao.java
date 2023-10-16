package com.cy.pj.sys.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

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
     * 删除菜单时要先删除关系表中的对应关系
     * 
     * @param menuId 菜单id
     * @return
     */
    Integer deleteObjectByMenuId(Integer menuId);

}
