package com.labor.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.labor.dao.LaborReportDao;
@SuppressWarnings("unchecked")
public class LaborReportDaoImpl<T> implements LaborReportDao<T> {

    private SqlMapClient sqlMapClient;
    public SqlMapClient getSqlMapClient() {
		return sqlMapClient;
	}

	public void setSqlMapClient(SqlMapClient sqlMapClient) {
		this.sqlMapClient = sqlMapClient;
	}
	public List<T> find(T t) {
        String findX="find"+t.getClass().getSimpleName();
		try {
			return sqlMapClient.queryForList(findX, t);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
