package com.savings.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.savings.entity.SaInterest;
import com.savings.entity.SaSavings;
import com.savings.entity.SaSavingsInfo;

public class SavingsDaoImpl implements SavingsDao{
	private SqlMapClient sqlMapClient;

	public SqlMapClient getSqlMapClient() {
		return sqlMapClient;
	}

	public void setSqlMapClient(SqlMapClient sqlMapClient) {
		this.sqlMapClient = sqlMapClient;
	}

	public SaSavingsInfo addSaSavingsInfo(SaSavingsInfo sa) throws SQLException {
		// TODO Auto-generated method stub
		return (SaSavingsInfo) sqlMapClient.queryForObject("addSaSavingsInfo",sa);
	}

	public void upSaSavingsInfo(SaSavingsInfo sa) throws SQLException {
		// TODO Auto-generated method stub
		sqlMapClient.update("upSaSavingsInfo",sa);
	}

	public void delSaSavingsInfo(int sa) throws SQLException {
		// TODO Auto-generated method stub
		sqlMapClient.delete("delSaSavingsInfo",sa);
	}

	public void addSaSavings(SaSavings sa) throws SQLException {
		// TODO Auto-generated method stub
		sqlMapClient.insert("addSaSavings",sa);
	}

	public void upSaSavings(SaSavings sa) throws SQLException {
		// TODO Auto-generated method stub
		sqlMapClient.update("upSaSavings",sa);
	}

	public void delSaSavings(int sa) throws SQLException {
		// TODO Auto-generated method stub
		sqlMapClient.delete("delSaSavings",sa);
	}

	public List<SaSavingsInfo> isGetSavingsInfo(int sa) throws SQLException {
		// TODO Auto-generated method stub
		return sqlMapClient.queryForList("isGetSavingsInfo",sa);
	}

	public void addInterest(SaInterest sa) throws SQLException {
		// TODO Auto-generated method stub
		sqlMapClient.insert("addInterest",sa);
	}

	public void upInterest(SaInterest sa) throws SQLException {
		// TODO Auto-generated method stub
		sqlMapClient.update("upInterest",sa);
	}

	public void delInterest(int sa) throws SQLException {
		// TODO Auto-generated method stub
		sqlMapClient.delete("delInterest",sa);
	}

	public List<SaInterest> isGetInterest(int sa) throws SQLException {
		// TODO Auto-generated method stub
		return sqlMapClient.queryForList("isGetInterest",sa);
	}

	public SaInterest isGetNewInterest(int sa) throws SQLException {
		// TODO Auto-generated method stub
		return (SaInterest) sqlMapClient.queryForObject("isGetNewInterest",sa);
	}
}
