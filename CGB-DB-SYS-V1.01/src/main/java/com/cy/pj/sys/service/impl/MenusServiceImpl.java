package com.cy.pj.sys.service.impl;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cy.pj.common.exception.ServiceException;
import com.cy.pj.common.vo.Node;
import com.cy.pj.sys.dao.MenusDao;
import com.cy.pj.sys.dao.RoleMenuDao;
import com.cy.pj.sys.entity.Menu;
import com.cy.pj.sys.service.MenusService;

@Service
public class MenusServiceImpl implements MenusService {

    @Autowired
    private MenusDao menusDao;

    @Autowired
    private RoleMenuDao roleMenuDao;

    /*
     * 查询业务
     * -----------------------------------------------------------------------------
     */

    /**
     * 查询所有的菜单,其中包括菜单表中的部分属加父菜单名称
     * 
     * @return 使用Map封装的查询结果
     */
    @Override
    public List<Map<String, Object>> findObjects() {

        List<Map<String, Object>> maps = menusDao.findObjects();

        return maps;

    }

    /**
     * 查询菜单获取Ztree节点,其中包括菜单id,菜单名称,父菜单id
     * 
     * @return 节点对象
     */
    @Override
    public List<Node> findZtreeMenuNodes() {
        List<Node> nodes = menusDao.findZtreeMenuNodes();
        return nodes;
    }

    /**
     * 验证菜单是否存在
     * 
     * @param id       菜单id
     * @param name     菜单名称
     * @param parentId 父id
     * @return true为存在,fales为不存在
     */
    @Override
    public Boolean isExist(Integer id, String name, Integer parentId) {
        Integer num = menusDao.isExist(id, name, parentId);

        return num > 0;
    }

    /*
     * 删除业务
     * ----------------------------------------------------------------------------
     */

    /**
     * 删除指定菜单
     * 
     * 因为菜单表有自关联,且对表`sys_role_menus`有外关联所以在删除的事要进行限制和联级
     * 
     * 对自关联的数据进行限制
     * 
     * 对外关联的表`sys_role_menus`进行联级
     * 
     * @param id 菜单Id
     * @return
     */
    @Override
    public Integer deleteObject(Integer id) {

        int rows = -1;

        // 检查参数
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("菜单ID错误");
        }

        // 查询有无子菜单
        Integer childCount = menusDao.getChildCount(id);

        if (id > 0) {
            throw new ServiceException("请先删除" + childCount + "子菜单");
        }

        // 联级删除
        roleMenuDao.deleteObjectByMenuId(id); // 先删除主表内容
        rows = menusDao.deleteObject(id);// 在删除从表内容

        // 判断删除是否成功
        if (rows <= 0) {
            throw new NoSuchElementException("这个菜单已经不存在了");
        }

        return rows;
    }

    /**
     * 添加业务
     * ----------------------------------------------------------------------------
     */

    @Override
    public Integer saveObject(Menu menu) {
        if (menu == null) {
            throw new IllegalArgumentException("添加菜单为空值");
        }

        if (isExist(menu.getId(), menu.getName(), menu.getParentId()))
            throw new IllegalArgumentException("菜单已经存在");

        return menusDao.insertObject(menu);
    }

    @Override
    public Integer updateObject(Menu menu) {
        if (menu == null)
            throw new IllegalArgumentException("更改参数为空");

        if (!isExist(menu.getId(), menu.getName(), menu.getParentId()))
            throw new IllegalArgumentException("菜单不存在");

        return menusDao.updateObject(menu);
    }
}
