package com.org.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.org.dao.UserPartDao;
import com.org.entity.UserPart;

public class UserPartDaoImpl implements UserPartDao {
	private SqlMapClient sqlMapClient;

	public SqlMapClient getSqlMapClient() {
		return sqlMapClient;
	}

	public void setSqlMapClient(SqlMapClient sqlMapClient) {
		this.sqlMapClient = sqlMapClient;
	}

	/**
	 * 添加角色
	 * 
	 * @throws SQLException
	 * */
	public void addUserPart(UserPart userPart) throws SQLException {
		this.getSqlMapClient().insert("addUserPart", userPart);

	}

	/**
	 * 查询所有角色
	 * 
	 * @throws SQLException
	 * */
	@SuppressWarnings("unchecked")
	public List<UserPart> findUserPart() throws SQLException {
		return this.getSqlMapClient().queryForList("findUserPart");
	}

	/**
	 * 删除角色
	 * @throws SQLException 
	 * */
	public void delUserPart(int userPartID) throws SQLException {
		this.getSqlMapClient().delete("", userPartID);

	}

	/**
	 * 更改角色
	 * @throws SQLException 
	 * */
	public void updUserPart(UserPart userPart) throws SQLException {
		this.getSqlMapClient().update("", userPart);
		
	}
}
