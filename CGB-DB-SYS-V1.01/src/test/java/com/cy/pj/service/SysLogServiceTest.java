package com.cy.pj.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cy.pj.common.vo.PageObject;
import com.cy.pj.sys.entity.SysLog;
import com.cy.pj.sys.service.SysLogService;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class SysLogServiceTest {
    
    @Autowired
    SysLogService service;

    @Test
    public void findPageObjectTest(){
        
        PageObject<SysLog> pageObject =  service.finPageObject("", 1L);

        log.info(pageObject);
        log.info(pageObject.getRecords().size());
     
        try {

            service.finPageObject("", null);

        } catch (Exception e) {
            
            e.printStackTrace();

        }
        try {

           service.finPageObject(null, 10000000L);

        } catch (Exception e) {
            
            e.printStackTrace();

        }

        

    }


}
