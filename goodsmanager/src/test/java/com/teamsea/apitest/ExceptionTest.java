package com.teamsea.apitest;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.teamsea.api.exception.ValueAlreadyExistsException;


@SpringBootTest 
public class ExceptionTest {

	@Test
	public void ValueAlreadyExistsTest() {
		
		try {
			ValueAlreadyExists();
		} catch (Exception e) {
			e.printStackTrace();;
		}
		
	}
	
	
	private void ValueAlreadyExists() {
		throw new ValueAlreadyExistsException("这条数据已经存在了");
	}
	
}
