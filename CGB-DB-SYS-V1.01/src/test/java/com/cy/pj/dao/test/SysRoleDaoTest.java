package com.cy.pj.dao.test;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cy.pj.sys.dao.RoleDao;
import com.cy.pj.sys.entity.SysRole;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class SysRoleDaoTest {

    @Autowired
    private RoleDao mapper;

    @Test
    public void getRowCountTest() {
        Long rowCount = mapper.getRowCount(null);
        log.info(rowCount.toString());
    }

    @Test
    public void findPageObjectTest() {
        List<SysRole> roles = mapper.findPageObject(null, 0l, 2);
        log.info(roles.toString());
    }

    @Test
    public void deleteObjectTest() {
        Integer row = mapper.deleteObject(48, 49);
        log.info(row.toString());
    }

}
