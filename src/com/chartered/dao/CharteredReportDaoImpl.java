package com.chartered.dao;

import java.sql.SQLException;
import java.util.List;

import com.chartered.entity.CrIsGetChartered;
import com.ibatis.sqlmap.client.SqlMapClient;

public class CharteredReportDaoImpl implements CharteredReportDao{

	private SqlMapClient sqlMapClient;

	public SqlMapClient getSqlMapClient() {
		return sqlMapClient;
	}

	public void setSqlMapClient(SqlMapClient sqlMapClient) {
		this.sqlMapClient = sqlMapClient;
	}

	public List<CrIsGetChartered> find(CrIsGetChartered isCh) {
		try {
			return sqlMapClient.queryForList("findCh", isCh);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
