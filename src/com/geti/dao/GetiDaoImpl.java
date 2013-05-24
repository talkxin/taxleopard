package com.geti.dao;

import java.sql.SQLException;

import com.geti.entity.GtGetigongshang;
import com.ibatis.sqlmap.client.SqlMapClient;

public class GetiDaoImpl implements GetiDao {
	private SqlMapClient sqlMapClient;

	public SqlMapClient getSqlMapClient() {
		return sqlMapClient;
	}

	public void setSqlMapClient(SqlMapClient sqlMapClient) {
		this.sqlMapClient = sqlMapClient;
	}

	public void addGetti(GtGetigongshang gt) throws SQLException {
		// TODO Auto-generated method stub
		sqlMapClient.insert("addGetti", gt);
	}

	public void upGetti(GtGetigongshang gt) throws SQLException {
		// TODO Auto-generated method stub
		sqlMapClient.update("upGetti", gt);
	}

	public void delGetti(int gt) throws SQLException {
		// TODO Auto-generated method stub
		sqlMapClient.delete("delGetti", gt);
	}
}
