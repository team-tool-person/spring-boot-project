package com.cy.pj.sys.service;

import java.util.List;
import java.util.Map;

public interface MenusService {
    
    /**
     * 查询所有菜单信息
     * 
     * @return
     */
    List<Map<String,Object>> findObjects ();
}
