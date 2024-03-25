package com.cy.pj.dao.test;

import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cy.pj.common.vo.UserDeptVo;
import com.cy.pj.sys.dao.UserDao;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class UserDaoTest {
    
    @Autowired
    UserDao mapper;

    @Test
    public void getRowCountTest(){
        Integer row = mapper.getRowCount(null);
        log.info(row.toString());

        row = mapper.getRowCount("user");
        log.info(row.toString());
    }

    @Test
    public void findPageObejctTest(){
        List<UserDeptVo> userVos = mapper.findPageObject(null, 0, mapper.pageSize);
        
        for (Iterator iterator = userVos.iterator(); iterator.hasNext();) {
			UserDeptVo userDeptVo = (UserDeptVo) iterator.next();
			log.info(userDeptVo.toString());
		}
        
    }
}
