package com.donation.dao;

import java.sql.SQLException;
import java.util.List;

import com.donation.entity.JzIsGetDonation;
import com.ibatis.sqlmap.client.SqlMapClient;

public class DonationReportDaoImpl implements DonationReportDao{

	private SqlMapClient sqlMapClient;

	public SqlMapClient getSqlMapClient() {
		return sqlMapClient;
	}

	public void setSqlMapClient(SqlMapClient sqlMapClient) {
		this.sqlMapClient = sqlMapClient;
	}
	
	public List<JzIsGetDonation> find(JzIsGetDonation isDo) {
		try {
			return sqlMapClient.queryForList("findDo", isDo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	
}
