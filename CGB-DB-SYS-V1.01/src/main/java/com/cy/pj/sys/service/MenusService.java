package com.cy.pj.sys.service;

import java.util.List;
import java.util.Map;

public interface MenusService {
    
    /**
     * 查询所有菜单信息
     * 
     * @return 使用Map封装数据对象的集合
     */
    List<Map<String,Object>> findObjects ();

    /**
     * 根据菜单id来进行删除
     * 
     * @param id 菜单Id
     * @return 影响行数
     */
    Integer deleteObject(Integer id);
}
