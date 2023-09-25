package com.cy.pj.dao.test;

import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cy.pj.sys.dao.SysLogDao;
import com.cy.pj.sys.entity.SysLog;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class SysLogDaoTest {

	@Autowired
	private SysLogDao logDao;

	/***
	 * 获取总行数测试
	 */
	@Test
	public void getRowTest() {

		int row = logDao.getRowCount("");
		log.info(row);

		row = logDao.getRowCount("l");
		log.info(row);
	}

	/**
	 * 获取指定用户的日志信息
	 * 
	 */
	@Test
	public void findPageObject() {

		List<SysLog> logs = logDao.findPageObject("", 1, 100);

		for (Iterator<SysLog> iterator = logs.iterator(); iterator.hasNext();) {
			SysLog sysLog = (SysLog) iterator.next();
			log.info(sysLog);
		}

		log.info(logDao.findPageObject("xiao", 0, 10));

	}

}
