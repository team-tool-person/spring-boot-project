package com.teamsea.servicetest;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.teamsea.service.ActivityService;
import com.teamsea.service.impl.ActivityServiceImpl;

@SpringBootTest
public class ServiceUpdateSQLTest {

	/**
	 * 使用Logger org.slf4j.Logger
	 * 
	 * 在使用logger对象时,要创建成一个静态常量
	 * 
	 * 1. 稳定的运行日志框架
	 * 
	 * 2. 在类加载前就是用这个框架
	 */
	private static final Logger logger = LoggerFactory.getLogger(ActivityServiceImpl.class);

	@Autowired
	private ActivityService service;

	/**
	 * 
	 * 获取活动列表
	 */
	@Test
	public void getActivitiesListTest() {
		// 使用Logger
		logger.info("start: {}", System.currentTimeMillis());
		logger.info(service.getActivities().toString());
		logger.info("end: {}", System.currentTimeMillis());
	}

	/**
	 * 测试创建活动
	 */
	@Test
	public void createActivityTest() {
		
	}

}
