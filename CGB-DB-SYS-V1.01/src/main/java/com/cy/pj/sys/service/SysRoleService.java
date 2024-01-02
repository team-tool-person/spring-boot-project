package com.cy.pj.sys.service;

import com.cy.pj.common.vo.PageObject;
import com.cy.pj.sys.entity.SysRole;

public interface SysRoleService {

    Integer pageSize = 2;

    /**
     * 获取到当前页面的角色
     *
     * @return 指定名称的当前页面角色对象页面数据
     */
    PageObject<SysRole> findPageObject(String name, Long pageCurrent);

}
