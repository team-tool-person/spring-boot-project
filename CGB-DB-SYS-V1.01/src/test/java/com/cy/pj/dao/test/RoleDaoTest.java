package com.cy.pj.dao.test;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cy.pj.sys.dao.RoleDao;
import com.cy.pj.sys.entity.Role;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class RoleDaoTest {

    @Autowired
    private RoleDao mapper;

    @Test
    public void getRowCountTest() {
        Long rowCount = mapper.getRowCount(null);
        log.info(rowCount.toString());
    }

    @Test
    public void findPageObjectTest() {
        List<Role> roles = mapper.findPageObject(null, 0l, 2);
        log.info(roles.toString());
    }

    @Test
    public void deleteObjecstTest() {
        Integer row = mapper.deleteObjects(48, 49);
        log.info(row.toString());

        row = mapper.deleteObjects();
        log.info(row.toString());
    }
    
    @Test
    public void deleteObjectTest(){
    	Integer row = mapper.deleteObject(0);
    	log.info(row.toString());
    	
    	row = mapper.deleteObject(2);
    	log.info(row.toString());
    }

}
