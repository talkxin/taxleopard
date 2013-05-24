package com.shares.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.shares.entity.ShIsGetFirstShare;
import com.shares.entity.ShIsGetShareIn;
import com.shares.entity.ShIsGetShareOut;
import com.shares.entity.ShSharesInfo;

public class SharesReportDaoImpl implements SharesReportDao{

	private SqlMapClient sqlMapClient;

	public SqlMapClient getSqlMapClient() {
		return sqlMapClient;
	}

	public void setSqlMapClient(SqlMapClient sqlMapClient) {
		this.sqlMapClient = sqlMapClient;
	}


    public ShIsGetFirstShare findFirst(ShIsGetFirstShare sinfo) {
    	try {
			return (ShIsGetFirstShare) sqlMapClient.queryForObject("findFirstShare",sinfo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<ShIsGetShareIn> findIn(ShIsGetShareIn sin) {
		try {
			return sqlMapClient.queryForList("findInShare",sin);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<ShIsGetShareOut> findOut(ShIsGetShareOut sout) {
		try {
			return sqlMapClient.queryForList("findOutShare",sout);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<ShIsGetFirstShare> findFullFirst(ShIsGetFirstShare sinfo) {
		try {
			return sqlMapClient.queryForList("findFullFirstShare",sinfo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
