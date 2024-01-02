package com.cy.pj.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cy.pj.common.exception.ServiceException;
import com.cy.pj.common.vo.PageObject;
import com.cy.pj.sys.dao.SysRoleDao;
import com.cy.pj.sys.entity.SysRole;
import com.cy.pj.sys.service.SysRoleService;

@Service
public class SysRoleServiceImpl implements SysRoleService {

    @Autowired
    private SysRoleDao sysRoleDao;

    @Override
    public PageObject<SysRole> findPageObject(String name, Long pageCurrent) {
        
        // 验证参数是否正确
        // pageCurrent是否正确
        if(pageCurrent == null || pageCurrent<1)
            throw new IllegalArgumentException("当前页码值无效");
        
        // 对总查询记录进行校验
        Long rowCount = sysRoleDao.getRowCount(name);
        
        if(rowCount ==0 )
            throw new ServiceException("没有找到对应记录");

        // 获取页面数据
        Long startIndex = ((pageCurrent - 1 ) * pageSize);
        List<SysRole> sysRoles = sysRoleDao.findPageObject(name, startIndex, pageSize);
        return new PageObject<SysRole>(pageCurrent,pageSize,rowCount,sysRoles);

    }

}
