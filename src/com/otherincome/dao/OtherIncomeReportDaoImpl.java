package com.otherincome.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.otherincome.entity.OiOtherincome;

public class OtherIncomeReportDaoImpl implements OtherIncomeReportDao{

	private SqlMapClient sqlMapClient;

	public SqlMapClient getSqlMapClient() {
		return sqlMapClient;
	}

	public void setSqlMapClient(SqlMapClient sqlMapClient) {
		this.sqlMapClient = sqlMapClient;
	}

	public List<OiOtherincome> find(OiOtherincome otherIn) {
		try {
			return sqlMapClient.queryForList("findAllOtherIncome",otherIn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
