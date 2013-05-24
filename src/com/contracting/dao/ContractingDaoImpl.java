package com.contracting.dao;

import java.sql.SQLException;
import java.util.List;

import com.contracting.entity.ConContract;
import com.contracting.entity.ConContractInfo;
import com.ibatis.sqlmap.client.SqlMapClient;

public class ContractingDaoImpl implements ContractingDao{
	private SqlMapClient sqlMapClient;

	public SqlMapClient getSqlMapClient() {
		return sqlMapClient;
	}

	public void setSqlMapClient(SqlMapClient sqlMapClient) {
		this.sqlMapClient = sqlMapClient;
	}

	public ConContractInfo addContractInfo(ConContractInfo co)
			throws SQLException {
		// TODO Auto-generated method stub
		return (ConContractInfo) sqlMapClient.queryForObject("addContractInfo",co);
	}

	public void upContractInfo(ConContractInfo co) throws SQLException {
		// TODO Auto-generated method stub
		sqlMapClient.update("upContractInfo",co);
	}

	public void delContractInfo(int co) throws SQLException {
		// TODO Auto-generated method stub
		sqlMapClient.delete("delContractInfo",co);
	}

	public void addContract(ConContract co) throws SQLException {
		// TODO Auto-generated method stub
		sqlMapClient.insert("addContract",co);
	}

	public void upContract(ConContract co) throws SQLException {
		// TODO Auto-generated method stub
		sqlMapClient.update("upContract",co);
	}

	public void delContract(int co) throws SQLException {
		// TODO Auto-generated method stub
		sqlMapClient.delete("delContract",co);
	}

	public List<ConContractInfo> isGetUserContractInfo(int co)
			throws SQLException {
		// TODO Auto-generated method stub
		return sqlMapClient.queryForList("isGetUserContractInfo",co);
	}
}
