package com.teamsea.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MsgServiceTest {

	@Autowired
	private MsgService service;

	@Test
	public void getMsgShow() {
		service.getMsgShows();
	}

}
