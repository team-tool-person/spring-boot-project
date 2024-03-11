package com.cy.pj.sys.service;

import com.cy.pj.common.vo.PageObject;
import com.cy.pj.common.vo.RoleMenuVo;
import com.cy.pj.sys.entity.Role;

public interface RoleService {

    Integer pageSize = 20;

    /**
     * 获取到当前页面的角色
     *
     * @return 指定名称的当前页面角色对象页面数据
     */
    PageObject<Role> findPageObject(String name, Long pageCurrent);
    
    /**
     * 使用角色id进行删除
     * @param ids
     * @return 影响行数
     */
    Integer deleteObject(Integer roleId);

    /**
     * 添加角色信息,以及其管理管理的菜单信息
     * @param role 角色信息
     * @param menuIds 菜单Id,添加的角色所管理的所有菜单
     * @return 影响行数
     */
    Integer saveObejct(Role role,Integer[] menuIds);

    /**
     * 根据角色Name属性获取其id值
     * @param name 角色名称
     * @return 角色的id
     */
    Integer getRoleIdByName(String name);

    /**
     * 根据角色的id来获取VO对象数据，进行展示和修改
     */
    RoleMenuVo findObjectById(Integer id);

    /**
     * 修改指定角色的信息和其管理的菜单
     * @param role 要修改的角色信息
     * @param menuIds 要修改要管理菜单信息
     * @return 影响的行数
     */
    Integer updateObject(Role role,Integer[] menuIds);

}
