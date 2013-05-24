package com.savings.dao;

import java.sql.SQLException;
import java.util.List;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.savings.entity.SaIsGetSavings;

public class SavingsReportDaoImpl implements SavingsReportDao{

	private SqlMapClient sqlMapClient;

	public SqlMapClient getSqlMapClient() {
		return sqlMapClient;
	}

	public void setSqlMapClient(SqlMapClient sqlMapClient) {
		this.sqlMapClient = sqlMapClient;
	}

	public List<SaIsGetSavings> find(SaIsGetSavings isSa) {
		try {
			return sqlMapClient.queryForList("findSa", isSa);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


    
}
