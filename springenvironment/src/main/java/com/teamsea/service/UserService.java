package com.teamsea.service;

import java.util.List;

import com.teamsea.bean.User;

public interface UserService {

	/**
	 * 获取所有的User(id,name)属性
	 */
	public List<User> findUsers();

}
