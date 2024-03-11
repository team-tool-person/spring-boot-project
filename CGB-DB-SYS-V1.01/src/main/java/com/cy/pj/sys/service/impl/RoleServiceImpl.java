package com.cy.pj.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cy.pj.common.exception.ServiceException;
import com.cy.pj.common.vo.PageObject;
import com.cy.pj.common.vo.RoleMenuVo;
import com.cy.pj.sys.dao.RoleDao;
import com.cy.pj.sys.dao.RoleMenuDao;
import com.cy.pj.sys.dao.UserRoleDao;
import com.cy.pj.sys.entity.Role;
import com.cy.pj.sys.service.RoleService;

import io.micrometer.common.util.StringUtils;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMenuDao roleMenuDao;

    @Autowired
    private UserRoleDao userRoleDao;

    @Autowired
    private RoleDao roleDao;

    /**
     * 查询角色页面数据,包括分页数据和角色数据
     *
     * @param name        要查询角色的名称,模糊查询,可以为空
     * @param pageCurrent 当前页面
     * @return 角色页面数据信息
     */
    @Override
    public PageObject<Role> findPageObject(String name, Long pageCurrent) {

        // 验证参数是否正确
        // pageCurrent是否正确
        if (pageCurrent == null || pageCurrent < 1)
            throw new IllegalArgumentException("当前页码值无效");

        // 对总查询记录进行校验
        Long rowCount = roleDao.getRowCount(name);

        if (rowCount == 0)
            throw new ServiceException("没有找到对应记录");

        // 获取页面数据
        Long startIndex = ((pageCurrent - 1) * pageSize);
        List<Role> sysRoles = roleDao.findPageObject(name, startIndex, pageSize);
        return new PageObject<Role>(pageCurrent, pageSize, rowCount, sysRoles);

    }

    /**
     * 根据角色id进行删除,首先先验证参数,在进行主表数据的删除,在删除从表数据
     *
     * @param roleIds 角色Id
     * @return 影响的行数
     */
    @Override
    public Integer deleteObject(Integer roleId) {

        Integer row = 0;

        // 验证参数
        if (roleId == null || roleId <= 0)
            throw new IllegalArgumentException("请先选择");

        // 删除主表内容
        row = roleMenuDao.deleteObjectByRoleId(roleId);
        log.info(row.toString());
        if (row <= 0) {
            log.info("这个角色与菜单没有关联");
        }

        row = userRoleDao.deleteObjectByRoleId(roleId);
        log.info(row.toString());
        if (row <= 0) {
            log.info("没有成为这个角色的用户");
        }

        // 对角色表进行删除
        row = roleDao.deleteObject(roleId);
        log.info(row.toString());

        if (row == 0) {
            throw new ServiceException("未能进行删除,可能已被删除");
        }

        return row;
    }

    @Override
    public Integer saveObejct(Role role, Integer[] menuIds) {
        // 验证参数
        if (role == null) {
            throw new IllegalArgumentException("保存的角色不能为空");
        }

        if (StringUtils.isEmpty(role.getName())) {
            throw new IllegalArgumentException("角色名称不能为空");
        }

        if (menuIds == null || menuIds.length == 0) {
            throw new IllegalArgumentException("必须为角色分配权限");
        }

        // 保存角色信息
        Integer row = 0;
        if (role.getId() == null) {

            row = roleDao.saveObject(role);
            log.info(row.toString());

        }else{

            row = roleDao.insertObject(role);
            log.info(row.toString());
            
        }

        
        // 保存角色菜单关系表
        Integer id = roleDao.getIdByName(role.getName());
        row = roleMenuDao.insertObejcts(id, menuIds);
        log.info(row.toString());

        return row;
    }

    @Override
    public Integer getRoleIdByName(String name) {
        return roleDao.getIdByName(name);
    }

    /**
     * 根据角色Id信息查询到角色的信息
     * 
     * 包括id,name,note和其管理的菜单信息
     * 
     * 这个业务有很多中方法来解决,我们这里使用关联查询法
     * 
     * @param 角色id
     * 
     * @return RoleMenu对象其中包括角色id,name,note属性,还有其管理的
     */
    @Override
    public RoleMenuVo findObjectById(Integer id) {

        // 参数校验
        if (id == null || id < 1)
            throw new IllegalArgumentException("无效参数");

        RoleMenuVo roleMenuVo = roleMenuDao.findObjectById(id);

        if (roleMenuVo == null) {
            throw new ServiceException("此角色已经不存在");
        }

        return roleMenuVo;
    }

    @Override
    public Integer updateObject(Role role, Integer[] menuIds) {
        // 验证参数
        if (role == null)
            throw new IllegalArgumentException("更新的对象不能为空");

        if (role.getId() == null)
            throw new IllegalArgumentException("id值不能为空");

        if (StringUtils.isEmpty(role.getName()))
            throw new IllegalArgumentException("角色名不能为空");

        if (menuIds == null || menuIds.length == 0)
            throw new IllegalArgumentException("必须为角色指定一个权限");

        // 更新数据
        Integer row = roleDao.updateObject(role);

        if (row == 0)
            throw new IllegalArgumentException("对象可能已经不存在");

        row += roleMenuDao.deleteObjectByRoleId(role.getId());
        row += roleMenuDao.insertObejcts(role.getId(), menuIds);

        return row;
    }

}
