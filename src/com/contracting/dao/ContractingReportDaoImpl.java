package com.contracting.dao;

import java.sql.SQLException;
import java.util.List;

import com.contracting.entity.ConIsGetContract;
import com.ibatis.sqlmap.client.SqlMapClient;

public class ContractingReportDaoImpl implements ContractingReportDao{

	private SqlMapClient sqlMapClient;

	public SqlMapClient getSqlMapClient() {
		return sqlMapClient;
	}

	public void setSqlMapClient(SqlMapClient sqlMapClient) {
		this.sqlMapClient = sqlMapClient;
	}

	public List<ConIsGetContract> findCon(ConIsGetContract con) {
		try {
			return sqlMapClient.queryForList("findCon", con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
    
}
