package com.cy.pj.dao.test;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cy.pj.common.vo.RoleMenuVo;
import com.cy.pj.sys.dao.RoleMenuDao;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class RoleMenuDaoTest {

    @Autowired
    private RoleMenuDao mapper;

    @Test
    public void findObjectByMenuIdTest() {
        List<Map<String, Object>> role_menu = mapper.findObjectByMenuId(1024);
        System.out.println(role_menu);
    }

    @Test
    public void deleteObjectByMenuIdTest() {

        Integer row = mapper.deleteObjectByMenuId(null);

        row = mapper.deleteObjectByMenuId(0);

        log.info(row.toString());

        row = mapper.deleteObjectByMenuId(1024);

        log.info(row.toString());

    }

    @Test
    public void deleteObjectByRoleIdsTest(){
        
        Integer row = mapper.deleteObjectByRoleIds(5,7);
        log.info(row.toString());


        Integer[] parms = {5,7};
        row = mapper.deleteObjectByRoleIds(parms);
        log.info(row.toString());
    }

    @Test
    public void insertObjectTest(){
        Integer row = 0;

        int roleId = 9527;
        Integer[] menuId = {999,998,776,255,65535,-2};

        row = mapper.insertObejcts(roleId,menuId);
        log.info(row.toString());

        row = mapper.deleteObjectByRoleId(roleId);
        log.info(row.toString());
    }


    @Test
    public void findObjectByIdTest(){
        RoleMenuVo vo = mapper.findObjectById(1);
        
        log.info(vo.toString());
    }


    @Test
    public void findMenuIdsByRoleIdTest(){
        List<Integer> list = mapper.findMenuIdsByRoleId(1);

        log.info(list.toString());
    }
}
