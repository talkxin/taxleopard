package com.prompt.dao;

import java.sql.SQLException;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.prompt.entity.ProPrompt;

public class PromptDaoImpl implements PromptDao{
	private SqlMapClient sqlMapClient;

	public SqlMapClient getSqlMapClient() {
		return sqlMapClient;
	}

	public void setSqlMapClient(SqlMapClient sqlMapClient) {
		this.sqlMapClient = sqlMapClient;
	}

	public void addPrompt(ProPrompt pro) throws SQLException {
		// TODO Auto-generated method stub
		sqlMapClient.insert("addPrompt",pro);
	}

	public void upPrompt(ProPrompt pro) throws SQLException {
		// TODO Auto-generated method stub
		sqlMapClient.update("upPrompt",pro);
	}

	public void delPrompt(int pro) throws SQLException {
		// TODO Auto-generated method stub
		sqlMapClient.delete("delPrompt",pro);
	}

	public ProPrompt isGetPrompt(String pro) throws SQLException {
		// TODO Auto-generated method stub
		return (ProPrompt) sqlMapClient.queryForObject("isGetPrompt",pro);
	}
}
