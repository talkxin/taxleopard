package com.geti.dao;

import java.sql.SQLException;
import java.util.List;

import com.geti.entity.GtGetigongshang;
import com.ibatis.sqlmap.client.SqlMapClient;

public class GetiReportDaoImpl implements GetiReportDao{
	private SqlMapClient sqlMapClient;

	public SqlMapClient getSqlMapClient() {
		return sqlMapClient;
	}

	public void setSqlMapClient(SqlMapClient sqlMapClient) {
		this.sqlMapClient = sqlMapClient;
	} 
	public List<GtGetigongshang> findGe(GtGetigongshang geti) {
		try {
			return sqlMapClient.queryForList("findGeti", geti);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
