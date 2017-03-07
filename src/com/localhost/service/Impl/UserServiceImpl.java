package com.localhost.service.Impl;

import java.util.List;

import com.localhost.dao.UserDao;
import com.localhost.dao.Impl.UserDaoImpl;
import com.localhost.service.UserService;

public class UserServiceImpl implements UserService {
	
	UserDao userDao = new UserDaoImpl();
	
	@Override
	public List<String> search(String keyword) {
		System.out.println("service:" + keyword);
		List<String> list = userDao.search(keyword);
		return list;
	}

}
