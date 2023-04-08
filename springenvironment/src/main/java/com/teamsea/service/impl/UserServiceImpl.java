package com.teamsea.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamsea.bean.User;
import com.teamsea.mapper.UserMapper;
import com.teamsea.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper mapper;
	
	@Override
	public List<User> findUsers() {
		// 获取运行时间
		long start = System.currentTimeMillis();
		List<User> list = mapper.findUsers();
		long end = System.currentTimeMillis();
		System.out.println(end-start + "ms");
		return list;
	}

}
