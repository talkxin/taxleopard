package com.auction.dao;

import java.sql.SQLException;
import java.util.List;

import com.auction.entity.AcAuction;
import com.ibatis.sqlmap.client.SqlMapClient;

public class AuctionReportDaoImpl implements AuctionReportDao{

	private SqlMapClient sqlMapClient;

	public SqlMapClient getSqlMapClient() {
		return sqlMapClient;
	}

	public void setSqlMapClient(SqlMapClient sqlMapClient) {
		this.sqlMapClient = sqlMapClient;
	}

	public List<AcAuction> find(AcAuction auction) {
		try {
			return sqlMapClient.queryForList("findAllAuction",auction);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
