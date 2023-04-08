package com.teamsea.datasource;


import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource; 

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 	测试连接池 HiKarCP
 * */
@SpringBootTest
public class SpringBootDataSourceTest {

	
	// Spring 框架注入依赖 	
	@Autowired
	DataSource dataSource;
	
	@Test
	public void getDataSource() {
		System.out.println(dataSource);
	}
	
	/**
	 * 获取连接对象
	 * */
	@Test
	public void getConnection() {
		try {
			System.out.println(dataSource.getConnection());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 执行一个SQL语句
	 * */
	@Test
	public void sqlTest() {
		String sql = "CREATE TABLE `user`.users (\r\n"
				+ "	id int auto_increment NOT NULL,\r\n"
				+ "	name varchar(10) NOT NULL,\r\n"
				+ "	CONSTRAINT users_pk PRIMARY KEY (id)\r\n"
				+ ")\r\n"
				+ "ENGINE=InnoDB\r\n"
				+ "DEFAULT CHARSET=utf8mb4";
		
		Connection connection = null;
		Statement statement = null;
		
		try {
			connection = dataSource.getConnection();
			statement = connection.createStatement();
			statement.execute(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	
}
