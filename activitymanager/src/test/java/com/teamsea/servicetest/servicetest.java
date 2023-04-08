package com.teamsea.servicetest;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.teamsea.pojo.Activity;
import com.teamsea.service.impl.ActivityServiceImpl;

@SpringBootTest
public class servicetest {

	@Autowired
	ActivityServiceImpl serviceImpl;

	@Test
	public void fieldInRuleTest() {
		Activity activity = new Activity();

		// 没有任何参数
		print(activity);

		activity.setTitle("Title");
		print(activity);

		activity.setCategory("Category");
		print(activity);

		activity.setStartTime(LocalDateTime.of(2023, 4, 6, 13, 0));
		print(activity);
		
		activity.setEndTime(LocalDateTime.of(2022, 4, 6, 13, 0));
		print(activity);
		
		
		activity.setState((byte) -1);
		print(activity);
		
		activity.setState((byte) 1);
		activity.setRemark("");
		print(activity);
		
		activity.setRemark("...");
		activity.setCreateUser("");
		print(activity);
		
		activity.setCreateUser("TeamSea");
		print(activity);
		
		activity.setCreatedTime(LocalDateTime.of(2022, 4, 6, 13, 0));
		print(activity);
	}

	private void print(Activity activity) {
		try {
			serviceImpl.fieldInRule(activity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	

}
