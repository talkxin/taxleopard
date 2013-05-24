package com.org.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.org.dao.DutyDao;
import com.org.entity.Duty;

public class DutyDaoImpl implements DutyDao {
	private SqlMapClient sqlMapClient;

	public SqlMapClient getSqlMapClient() {
		return sqlMapClient;
	}

	public void setSqlMapClient(SqlMapClient sqlMapClient) {
		this.sqlMapClient = sqlMapClient;
	}

	/**
	 * 添加税法
	 * 
	 * @throws SQLException
	 */
	public void addDuty(Duty duty) throws SQLException {
		this.getSqlMapClient().insert("addDuty", duty);

	}

	/**
	 * 删除税法
	 * 
	 * @throws SQLException
	 * */
	public void delDuty(int DutyID) throws SQLException {
		this.getSqlMapClient().delete("delDuty", DutyID);

	}

	/**
	 * 查询税法
	 * 
	 * @throws SQLException
	 * */
	@SuppressWarnings("unchecked")
	public List<Duty> findDutys() throws SQLException {
		return this.getSqlMapClient().queryForList("findDuty");
	}

	/**
	 *更改税法
	 * 
	 * @throws SQLException
	 * */
	public void updDuty(Duty duty) throws SQLException {
		this.getSqlMapClient().update("updDuty", duty);

	}

	public Duty findDutys(Integer id) throws SQLException {
		return (Duty) this.getSqlMapClient().queryForObject("findDutyByID", id);
	}

}
