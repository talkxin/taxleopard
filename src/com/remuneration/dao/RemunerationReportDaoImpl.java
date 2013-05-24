package com.remuneration.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.remuneration.entity.ReIsGetAllRemu;
import com.remuneration.entity.ReIsGetRemu;

public class RemunerationReportDaoImpl implements RemunerationReportDao{

	private SqlMapClient sqlMapClient;

	public SqlMapClient getSqlMapClient() {
		return sqlMapClient;
	}

	public void setSqlMapClient(SqlMapClient sqlMapClient) {
		this.sqlMapClient = sqlMapClient;
	}

	public List<ReIsGetRemu> findRe(ReIsGetRemu remu) {
		try {
			return sqlMapClient.queryForList("isGetRemu",remu);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<ReIsGetRemu> findReByPress(ReIsGetRemu remu) {
		try {
			return sqlMapClient.queryForList("isGetAllRemuByPress",remu);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public List<ReIsGetAllRemu> findAllRe(ReIsGetAllRemu remu) {
		try {
			return sqlMapClient.queryForList("isGetAllRemu",remu);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


}
