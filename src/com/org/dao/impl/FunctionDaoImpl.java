package com.org.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.org.dao.FunctionDao;
import com.org.entity.Functions;

public class FunctionDaoImpl implements FunctionDao {
	private SqlMapClient sqlMapClient;

	public SqlMapClient getSqlMapClient() {
		return sqlMapClient;
	}

	public void setSqlMapClient(SqlMapClient sqlMapClient) {
		this.sqlMapClient = sqlMapClient;
	}

	/**
	 * 添加功能
	 * 
	 * @throws SQLException
	 * */
	public void addFunctions(Functions function) throws SQLException {
		this.getSqlMapClient().insert("addFunction", function);

	}

	/**
	 * 删除功能
	 * 
	 * @throws SQLException
	 * */
	public void delFunctions(int functionID) throws SQLException {
		this.getSqlMapClient().delete("delFunction", functionID);

	}

	/**
	 * 更改功能
	 * 
	 * @throws SQLException
	 * */
	public void updFunctions(Functions functions) throws SQLException {
		this.getSqlMapClient().update("updFunction", functions);

	}

	/**
	 * 查询功能
	 * 
	 * @throws SQLException
	 * */
	@SuppressWarnings("unchecked")
	public List<Functions> findFunction(Integer userID) throws SQLException {
		return this.getSqlMapClient().queryForList("findFunction",userID);
	}

	/**
	 * 查询附属功能
	 * 
	 * @throws SQLException
	 * */
	@SuppressWarnings("unchecked")
	public List<Functions> findReside(int FunctionReside) throws SQLException {
		return this.getSqlMapClient()
				.queryForList("findReside", FunctionReside);
	}

}
