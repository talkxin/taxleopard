package com.auction.dao;

import java.sql.SQLException;

import com.auction.entity.AcAuction;
import com.ibatis.sqlmap.client.SqlMapClient;

public class AuctionDaoImpl implements AuctionDao {
	private SqlMapClient sqlMapClient;

	public SqlMapClient getSqlMapClient() {
		return sqlMapClient;
	}

	public void setSqlMapClient(SqlMapClient sqlMapClient) {
		this.sqlMapClient = sqlMapClient;
	}

	public void addAuctionInfo(AcAuction ac) {
		// TODO Auto-generated method stub
		try {
			sqlMapClient.insert("addAuctionInfo",ac);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void upAuctionInfo(AcAuction ac) {
		// TODO Auto-generated method stub
		try {
			sqlMapClient.update("upAuctionInfo",ac);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void delAuctionInfo(int ac) {
		// TODO Auto-generated method stub
		try {
			sqlMapClient.delete("delAuctionInfo",ac);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
