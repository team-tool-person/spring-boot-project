package com.cy.pj.sys.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRoleDao {

    /**
     * 删除指定角色数据
     * @param ids 角色id
     * @return 影响的行数
     */
    Integer deleteObjectByRoleId(Integer...ids);

}
