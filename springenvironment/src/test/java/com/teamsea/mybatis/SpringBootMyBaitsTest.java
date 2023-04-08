package com.teamsea.mybatis;

import java.security.PublicKey;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.teamsea.mapper.UserMapper;

/**
 * 测试SpringBoot框架整合MyBatis框架
 */
@SpringBootTest
public class SpringBootMyBaitsTest {

	// SpringBoot 注入依赖

	@Autowired
	private UserMapper mapper;

	@Test
	public void printMapper() {
		System.out.println(mapper);
	}

	@Test
	public void InsertTest() {
		System.out.println(mapper.insertUser("TeamSea"));
	}

	@Test
	public void deleteTest() {
		System.out.println(mapper.deleteUserByName("TeamSea"));
	}

	@Test
	public void InsertUsersTest() {

		String[] names = new String[2];
		names[0] = "TeamSea";
		names[1] = "QC";
		System.out.println(mapper.insertUsers(names));

	}

	/**
	 * 针对SQL语句进行一些加强
	 */
	@Test
	public void deleteUsersTest() {

		String[] names = new String[2];
		names[0] = "TeamSea";
		names[1] = "QC";

//		System.out.println(mapper.deleteUsers(names));
		
		// 这里我们不传递参数
		System.out.println(mapper.deleteUsers());

	}

}
