package com.cy.pj.dao.test;

import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cy.pj.sys.dao.RoleMenuDao;

@SpringBootTest
public class RoleMenuDaoTest {

    @Autowired
    private RoleMenuDao dao;

    @Test
    public void findObjectByMenuIdTest() {
        Map<String, Object> role_menu = dao.findObjectByMenuId(1024);
        System.out.println(role_menu);
    }

    @Test
    public void deleteObjectByMenuIdTest() {

        Integer row = dao.deleteObjectByMenuId(null);

        row = dao.deleteObjectByMenuId(0);

        row = dao.deleteObjectByMenuId(1024);

    }

}
