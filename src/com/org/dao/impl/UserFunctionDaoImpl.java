package com.org.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.org.dao.UserFunctionDao;
import com.org.entity.UserFunction;

public class UserFunctionDaoImpl implements UserFunctionDao {
	private SqlMapClient sqlMapClient;

	public SqlMapClient getSqlMapClient() {
		return sqlMapClient;
	}

	public void setSqlMapClient(SqlMapClient sqlMapClient) {
		this.sqlMapClient = sqlMapClient;
	}

	/**
	 * 查询所有功能
	 * 
	 * @throws SQLException
	 * */
	@SuppressWarnings("unchecked")
	public List<UserFunction> findUserFunction() throws SQLException {
		return this.getSqlMapClient().queryForList("");
	}

	/**
	 * 添加用户功能
	 * 
	 * @throws SQLException
	 * */
	public void addUserFunction(UserFunction userFunction) throws SQLException {
		this.getSqlMapClient().insert("addUserFunction", userFunction);
	}
	/**
	 * 删除功能
	 * 
	 * @throws SQLException
	 * */
	public void delUserFunction(int userFunctionID) throws SQLException {
		this.getSqlMapClient().delete("", userFunctionID);

	}

	/**
	 * 更改功能
	 * @throws SQLException 
	 * */
	public void updUserFunction(UserFunction userFunction) throws SQLException {
		this.getSqlMapClient().update("", userFunction);
	}

}
