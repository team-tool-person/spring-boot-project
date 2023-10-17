package com.cy.pj.service;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cy.pj.sys.service.MenusService;
import com.cy.pj.common.vo.Node;

@SpringBootTest
public class MenuServiceTest {

    @Autowired
    private MenusService service;

    @Test
    public void getZTreeTest() {
        List<Node> nodes = service.findZtreeMenuNodes();
        System.out.println(nodes);
    }

}
