package com.teamsea.pojo.test;

import java.lang.reflect.Method;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.teamsea.pojo.Activity;

@SpringBootTest
public class PojoTest {

	@Test
	public void testLombok() {
		
		Activity activity = new Activity();
		
		Class clazz =  activity.getClass();
		
		Method[] methods = clazz.getMethods();
		
		for (Method method : methods) {
			System.out.println(method.getName());
		}
		
	}
	
	
}
