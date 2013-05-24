package com.org.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.org.dao.AdminRegisterDao;
import com.org.entity.AdminRegister;

public class AdminRegisterDaoImpl implements AdminRegisterDao {
	private SqlMapClient sqlMapClient;

	public SqlMapClient getSqlMapClient() {
		return sqlMapClient;
	}

	public void setSqlMapClient(SqlMapClient sqlMapClient) {
		this.sqlMapClient = sqlMapClient;
	}

	/**
	 * 添加登录信息
	 * @throws SQLException 
	 * */
	public void addAdminRegister(AdminRegister adminRegister) throws SQLException {
		this.getSqlMapClient().insert("addAdminRegister",adminRegister);

	}

	/**
	 * 查询登录信息
	 * @throws SQLException 
	 * */
	@SuppressWarnings("unchecked")
	public List<AdminRegister> findAdminRegister() throws SQLException {
		return this.getSqlMapClient().queryForList("findAdminRegister");
	}

	public AdminRegister selectUserByUserID(String userName) throws SQLException {
		return (AdminRegister) this.getSqlMapClient().queryForObject("selectUserByUserID",userName);
	}
}
