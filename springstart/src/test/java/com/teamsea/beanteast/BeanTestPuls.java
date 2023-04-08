package com.teamsea.beanteast;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;

import com.teamsea.cache.CaChe;

@SpringBootTest
public class BeanTestPuls {
	
	@Autowired
	@Qualifier("defaultCaChe")
	public CaChe caChe;
	
	@Test
	public void testBeanPlus() {
		System.out.println(caChe.caChe());
	}
	
}
