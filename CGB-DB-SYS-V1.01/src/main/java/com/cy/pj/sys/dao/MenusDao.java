package com.cy.pj.sys.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MenusDao {
    
    /**
     * 查询菜单信息,将对象信息封装到Map中
     * 
     * 查询到的菜单信息包括菜单所有信息还有父菜单名称
     * 
     * @return 使用Map封装的菜单数据
     */
    List<Map<String,Object>> findObjects();

}
