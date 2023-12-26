package com.cy.pj.dao.test;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cy.pj.sys.dao.RoleMenuDao;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class RoleMenuDaoTest {

    @Autowired
    private RoleMenuDao dao;

    @Test
    public void findObjectByMenuIdTest() {
        List<Map<String, Object>> role_menu = dao.findObjectByMenuId(1024);
        System.out.println(role_menu);
    }

    @Test
    public void deleteObjectByMenuIdTest() {

        Integer row = dao.deleteObjectByMenuId(null);

        row = dao.deleteObjectByMenuId(0);

        log.info(row.toString());

        row = dao.deleteObjectByMenuId(1024);

        log.info(row.toString());

    }

}
