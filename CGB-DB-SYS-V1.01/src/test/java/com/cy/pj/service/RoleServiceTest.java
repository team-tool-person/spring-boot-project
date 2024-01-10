package com.cy.pj.service;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cy.pj.sys.entity.Role;
import com.cy.pj.sys.service.RoleService;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class RoleServiceTest {

    @Autowired
    private RoleService roleService;

    Role role = new Role();

    @BeforeEach
    public void initRole() {
        role.setName("TestUser");
        role.setNote("TestNode");

    }

    @Test
    public void saveObjectTest() {

        Integer[] menuIds = new Integer[10];
        int j = 10101;
        for (int i = 0; i < menuIds.length; i++) {
            menuIds[i] = j;
            j++;
        }

        log.info(Arrays.toString(menuIds));

        Integer row = roleService.saveObejct(role, menuIds);
        log.info(row.toString());

    }

    @Test
    public void deleteObjectTest() {

        Integer id  =0;

        Integer row = roleService.deleteObject(id);
        log.info(row.toString());
    }
}