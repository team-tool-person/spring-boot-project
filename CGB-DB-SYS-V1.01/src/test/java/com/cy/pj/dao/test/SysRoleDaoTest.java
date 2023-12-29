package com.cy.pj.dao.test;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cy.pj.sys.dao.SysRoleDao;
import com.cy.pj.sys.entity.SysRole;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class SysRoleDaoTest {

    @Autowired
    private SysRoleDao mapper;

    @Test
    public void getRowCountTest(){
        Integer rowCount = mapper.getRowCount(null);
        log.info(rowCount.toString());
    }

    @Test
    public void findPageObjectTest(){
        List<SysRole> roles = mapper.findPageObject(null, 0, 2);
        log.info(roles.toString());
    }

}
