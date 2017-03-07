package com.localhost.dao;

import java.util.List;

import com.localhost.vo.User;

public interface UserDao {

	/**
	 * 智能搜索
	 * @param string 关键字
	 * @return 查询结果
	 */ 
	List<String> search(String keyword);
}
