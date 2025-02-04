package com.cy.pj.sys.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.cy.pj.common.vo.Node;
import com.cy.pj.sys.entity.Menu;



@Mapper
public interface MenusDao {

    /**
     * 查询菜单信息,将对象信息封装到Map中
     * 
     * 查询到的菜单信息包括菜单所有信息还有父菜单名称
     * 
     * @return 使用Map封装的菜单数据
     */
    List<Map<String, Object>> findObjects();

    /**
     * 查询的到信息放置到对象中
     * @return 使用对象来封住数据
     */
    List<Menu> getObjects();

    /**
     * 查找该菜单下有无子菜单
     * 
     * @param id 菜单id
     * @return 子菜单数
     */
    Integer getChildCount(Integer id);

    /**
     * 验证菜单是否存在
     * @param id 菜单id
     * @param name 菜单名称
     * @param parentId 父辈id
     * @return 存在数
     */
    Integer isExist(Integer id,String name,Integer parentId);

    /**
     * 查询ZTree数节点 
     * 
     * @return ZTree节点
     */
    List<Node> findZtreeMenuNodes();

    /**
     * 删除菜单信息
     * 
     * @param menuId 菜单id
     * @return 影响行数
     */
    Integer deleteObject(Integer id);

    /**
     * 菜单添加操作
     * 
     * @param menu 要添加的新菜单
     * @return 影响行数
     */
    Integer insertObject(Menu menu);

    /**
     * 菜单修改操作
     * @param menu 要更新的菜单数据
     * @return 影响行数
     */
    Integer updateObject(Menu menu);
}
