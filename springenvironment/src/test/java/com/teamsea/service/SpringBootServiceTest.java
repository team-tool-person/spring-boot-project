package com.teamsea.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SpringBootServiceTest {
	
	
	@Autowired
	private UserService service;
	
	@Test
	public void  findUsers() {
		
		System.out.println(service.findUsers().toString());
		System.out.println(service.findUsers());
	}
	
}
