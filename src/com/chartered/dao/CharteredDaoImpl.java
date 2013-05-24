package com.chartered.dao;

import java.sql.SQLException;
import java.util.List;

import com.chartered.entity.CrChartered;
import com.chartered.entity.CrCharteredInfo;
import com.ibatis.sqlmap.client.SqlMapClient;

public class CharteredDaoImpl implements CharteredDao{
	private SqlMapClient sqlMapClient;

	public SqlMapClient getSqlMapClient() {
		return sqlMapClient;
	}

	public void setSqlMapClient(SqlMapClient sqlMapClient) {
		this.sqlMapClient = sqlMapClient;
	}

	public CrCharteredInfo addCrCharteredInfo(CrCharteredInfo cr)throws SQLException {
		// TODO Auto-generated method stub
			return (CrCharteredInfo) sqlMapClient.queryForObject("addCrCharteredInfo",cr);
	}

	public void upCrCharteredInfo(CrCharteredInfo cr)throws SQLException {
		// TODO Auto-generated method stub
			sqlMapClient.update("upCrCharteredInfo",cr);
	}

	public void delCrCharteredInfo(int cr)throws SQLException {
		// TODO Auto-generated method stub
			sqlMapClient.delete("delCrCharteredInfo",cr);
	}

	public void addCrChartered(CrChartered cr)throws SQLException {
		// TODO Auto-generated method stub
		sqlMapClient.insert("addCrChartered",cr);
	}

	public void upCrChartered(CrChartered cr)throws SQLException {
		// TODO Auto-generated method stub
		sqlMapClient.update("upCrChartered",cr);
	}

	public void delCrChartered(int cr)throws SQLException {
		// TODO Auto-generated method stub
		sqlMapClient.delete("delCrChartered",cr);
	}

	public List<CrCharteredInfo> isGetCharteredInfo(int cr)throws SQLException {
		// TODO Auto-generated method stub
		return sqlMapClient.queryForList("isGetCharteredInfo",cr);
	}
}
