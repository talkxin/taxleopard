package com.org.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.org.dao.SysRecordOfWorkDao;
import com.org.entity.SysRecordOfWork;

public class SysRecordOfWorkDaoImpl implements SysRecordOfWorkDao {
	//Spring注入
	private SqlMapClient sqlMapClient;
	public SqlMapClient getSqlMapClient() {
		return sqlMapClient;
	}
	public void setSqlMapClient(SqlMapClient sqlMapClient) {
		this.sqlMapClient = sqlMapClient;
	}
	//操作
	public void delete(Integer integer) throws SQLException {
		sqlMapClient.delete("deleteSysRecordOfWork",integer);
	}

	public void insert(SysRecordOfWork sysRecordOfWork) throws SQLException {
		sqlMapClient.insert("insertSysRecordOfWork", sysRecordOfWork);
	}

	@SuppressWarnings("unchecked")
	public List<SysRecordOfWork> select() throws SQLException {
		return sqlMapClient.queryForList("selectAllSysRecordOfWork");
	}

	public SysRecordOfWork select(Integer integer) throws SQLException {
		return (SysRecordOfWork) sqlMapClient.queryForObject("selectSysRecordOfWorkByID", integer);
	}

	@SuppressWarnings("unchecked")
	public List<SysRecordOfWork> select(SysRecordOfWork sysRecordOfWork)
			throws SQLException {
		return sqlMapClient.queryForList("selectSysRecordOfWorkByTime",sysRecordOfWork);
	}

	public void update(SysRecordOfWork sysRecordOfWork) throws SQLException {
		sqlMapClient.update("updateSysRecordOfWork", sysRecordOfWork);
	}

}
