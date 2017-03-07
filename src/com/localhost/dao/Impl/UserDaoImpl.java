package com.localhost.dao.Impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;

import com.localhost.dao.UserDao;
import com.localhost.util.DBUtil;

public class UserDaoImpl implements UserDao {
	
	@Override
	public List<String> search(String keyword) {
		System.out.println("dao:" + keyword);
		// 创建缓冲池对象
		DBUtil pool = DBUtil.getInstance();
		// 创建连接
		Connection connection = pool.getConnection();
		// 创建SQL执行工具
		QueryRunner runner = new QueryRunner();
		// 创建SQL语句
		String sql = "SELECT username FROM user WHERE username LIKE '" + keyword + "%'";
		System.out.println(sql);
		// 执行SQL语句
		try {
//			List<String> list = (List<String>) runner.query(connection, sql, new BeanListHandler(String.class));
			List<String> list = runner.query(connection, sql, new ColumnListHandler<String>("username"));
			System.out.println("执行SQL");
			for (String string : list) {
				System.out.println(string);
			}
			
			return list;
		} catch (SQLException e) {
			System.out.println("exception");
			e.printStackTrace();
		} finally {
			DbUtils.closeQuietly(connection);
		}
		return null;
	}

}
