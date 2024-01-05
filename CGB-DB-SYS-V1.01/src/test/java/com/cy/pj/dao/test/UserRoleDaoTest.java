package com.cy.pj.dao.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cy.pj.sys.dao.UserRoleDao;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class UserRoleDaoTest {

	@Autowired
	private UserRoleDao mapper;

	@Test
	public void deleteObjectByRoleId() {
		Integer row = mapper.deleteObjectByRoleId(0);
		log.info(row.toString());

		row = mapper.deleteObjectByRoleId(null);
		log.info(row.toString());

		row = mapper.deleteObjectByRoleId(72);
		log.info(row.toString());
	}

	@Test
	public void deleteObjectByRoleIds() {
		Integer row = 0;

		/*
		 * 这里都传递了两个null值,但是出现了第一个将这个null被拿到了数据进行比较,第二个没有进行比较
		 */

		row = mapper.deleteObjectByRoleIds(null, 0);
		log.info(row.toString());

		Integer[] param = null;
		row = mapper.deleteObjectByRoleIds(param);
		log.info(row.toString());

		param = new Integer[2];
		param[0] = 10;
		param[1] = 20;
		row = mapper.deleteObjectByRoleIds(param);
		log.info(row.toString());

	}

}
