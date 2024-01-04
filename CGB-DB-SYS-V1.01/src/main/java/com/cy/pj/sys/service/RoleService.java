package com.cy.pj.sys.service;

import com.cy.pj.common.vo.PageObject;
import com.cy.pj.sys.entity.Role;

public interface RoleService {

    Integer pageSize = 2;

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

}
