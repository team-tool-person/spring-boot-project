package com.cy.pj.sys.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.cy.pj.sys.dao.MenusDao;
import com.cy.pj.sys.service.MenusService;

@Service
public class MenusServiceImpl implements MenusService{

    private MenusDao menusDao;

    @Override
    public List<Map<String, Object>> findObjects() {
        
        List<Map<String,Object>> maps =  menusDao.findObjects();
        
        return maps;
  
    }
    
}
