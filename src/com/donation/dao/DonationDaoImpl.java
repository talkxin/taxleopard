package com.donation.dao;

import java.sql.SQLException;

import com.donation.entity.JzDonationInfo;
import com.ibatis.sqlmap.client.SqlMapClient;

public class DonationDaoImpl implements DonationDao {
	private SqlMapClient sqlMapClient;

	public SqlMapClient getSqlMapClient() {
		return sqlMapClient;
	}

	public void setSqlMapClient(SqlMapClient sqlMapClient) {
		this.sqlMapClient = sqlMapClient;
	}

	public JzDonationInfo addDonation(JzDonationInfo donationInfo)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public void upDonation(JzDonationInfo donationInfo) throws SQLException {
		// TODO Auto-generated method stub

	}

	public void delDonation(JzDonationInfo donationInfo) throws SQLException {
		// TODO Auto-generated method stub

	}

}
