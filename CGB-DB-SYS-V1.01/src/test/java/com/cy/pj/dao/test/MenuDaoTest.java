package com.cy.pj.dao.test;

import java.util.List;
import java.util.Map;
import java.util.Iterator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cy.pj.sys.dao.MenusDao;

@SpringBootTest
public class MenuDaoTest {
    
    @Autowired
    private MenusDao dao;

    @Test
    public void findObjects(){
        List<Map<String,Object>> maps =  dao.findObjects();
        for (Iterator<Map<String,Object>> it =  maps.iterator();it.hasNext();) {
            
            System.out.println(it.next());
            
        }

    }
}
