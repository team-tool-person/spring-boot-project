package com.cy.pj.service;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cy.pj.common.vo.Node;
import com.cy.pj.sys.dao.MenusDao;
import com.cy.pj.sys.entity.Menu;
import com.cy.pj.sys.service.MenusService;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class MenuServiceTest {

	@Autowired
	private MenusService service;

	@Autowired
	private MenusDao dao;

	@Test
	public void getZTreeTest() {
		List<Node> nodes = service.findZtreeMenuNodes();
		System.out.println(nodes);
	}

	@Test
	public void isExistTest() {

		List<Menu> menus = dao.getObjects();
		Menu menu = menus.get(0);

		Boolean isExist = service.isExist(menu.getId(), menu.getName(), menu.getParentId());
		log.info(isExist.toString());

		menu.setId(50);
		isExist = service.isExist(menu.getId(), menu.getName(), menu.getParentId());
		log.info(isExist.toString());

		menu = menus.get(0);
		menu.setName("TeamSea");
		menu.setParentId(110);
		isExist = service.isExist(menu.getId(), menu.getName(), menu.getParentId());
		log.info(isExist.toString());

	}
}
