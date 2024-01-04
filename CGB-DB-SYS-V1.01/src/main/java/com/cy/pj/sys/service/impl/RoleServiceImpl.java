package com.cy.pj.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cy.pj.common.exception.ServiceException;
import com.cy.pj.common.vo.PageObject;
import com.cy.pj.sys.dao.RoleDao;
import com.cy.pj.sys.dao.RoleMenuDao;
import com.cy.pj.sys.dao.UserRoleDao;
import com.cy.pj.sys.entity.Role;
import com.cy.pj.sys.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMenuDao roleMenuDao;

    @Autowired
    private UserRoleDao userRoleDao;

    @Autowired
    private RoleDao roleDao;

    @Override
    public PageObject<Role> findPageObject(String name, Long pageCurrent) {
        
        // 验证参数是否正确
        // pageCurrent是否正确
        if(pageCurrent == null || pageCurrent<1)
            throw new IllegalArgumentException("当前页码值无效");
        
        // 对总查询记录进行校验
        Long rowCount = roleDao.getRowCount(name);
        
        if(rowCount ==0 )
            throw new ServiceException("没有找到对应记录");

        // 获取页面数据
        Long startIndex = ((pageCurrent - 1 ) * pageSize);
        List<Role> sysRoles = roleDao.findPageObject(name, startIndex, pageSize);
        return new PageObject<Role>(pageCurrent,pageSize,rowCount,sysRoles);

    }

    /**
     * 根据角色id进行删除
     *
     * 首先先验证参数
     *
     * 在进行主表数据的删除,在删除从表数据
     * @param roleIds 角色Id
     * @return 影响的行数
     */
    @Override
    public Integer deleteObject(Integer roleId) {
        // 验证参数
        if (roleId == null || roleId<=0)
            throw new IllegalArgumentException("请先选择");
        
        roleMenuDao.deleteObjectByRoleId(roleId);

        userRoleDao.deleteObjectByRoleId(roleId);

        return roleDao.deleteObject(roleId);
    }


    

}
