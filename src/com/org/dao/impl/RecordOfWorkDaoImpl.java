package com.org.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.org.dao.RecordOfWorkDao;
import com.org.entity.RecordOfWork;

public class RecordOfWorkDaoImpl implements RecordOfWorkDao {
	//Spring注入
	private SqlMapClient sqlMapClient;

	public SqlMapClient getSqlMapClient() {
		return sqlMapClient;
	}

	public void setSqlMapClient(SqlMapClient sqlMapClient) {
		this.sqlMapClient = sqlMapClient;
	}
	//操作
	public void delete(Integer id) throws SQLException {
		sqlMapClient.delete("deleteRescordForID",id);
	}

	public void insert(RecordOfWork recordOfWork) throws SQLException {
		sqlMapClient.insert("addRecordOfWork", recordOfWork);
	}

	@SuppressWarnings("unchecked")
	public List<RecordOfWork> selectAll(Integer userID) throws SQLException {
		return sqlMapClient.queryForList("findRecordOfWork",userID);
	}

	public RecordOfWork selectByID(Integer id) throws SQLException {
		return (RecordOfWork)sqlMapClient.queryForObject("selectRecordOfWorkByID",id);
	}

	@SuppressWarnings("unchecked")
	public List<RecordOfWork> selectByTime(RecordOfWork recordOfWork) throws SQLException {
		return sqlMapClient.queryForList("findRecordOfWorkByBeginTime",recordOfWork);
	}

	public void update(RecordOfWork recordOfWork) throws SQLException {
		sqlMapClient.update("updateRescordForID", recordOfWork);
	}

}
