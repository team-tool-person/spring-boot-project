package com.cy.pj.sys.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRoleDao {

    Integer seveObject(Integer roleId,Integer userId);

    /**
     * 删除指定角色主表数据,仅删除一个
     * @param roleId
     * @return 影响的行数
     */
    Integer deleteObjectByRoleId(Integer roleId);

    /**
     * 删除指定角色主表数据,删除多个
     * @param roleIds 角色id
     * @return 影响的行数
     */
    Integer deleteObjectByRoleIds(Integer...roleIds);

    

}
