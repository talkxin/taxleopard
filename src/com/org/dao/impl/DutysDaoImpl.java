package com.org.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.org.dao.DutysDao;
import com.org.entity.Dutys;

public class DutysDaoImpl implements DutysDao {
	private SqlMapClient sqlMapClient;

	public SqlMapClient getSqlMapClient() {
		return sqlMapClient;
	}

	public void setSqlMapClient(SqlMapClient sqlMapClient) {
		this.sqlMapClient = sqlMapClient;
	}

	/**
	 * 添加税模块
	 * 
	 * @throws SQLException
	 * */
	public void addDutys(Dutys dutys) throws SQLException {
		this.getSqlMapClient().insert("addDutys", dutys);

	}

	/**
	 * 删除税模块
	 * 
	 * @throws SQLException
	 * */
	public void delDutys(int DutysID) throws SQLException {
		this.getSqlMapClient().delete("delDutys", DutysID);

	}

	/**
	 * 查询所有的税模块
	 * @throws SQLException
	 * */
	@SuppressWarnings("unchecked")
	public List<Dutys> findDutys() throws SQLException {

		return this.getSqlMapClient().queryForList("findDutys");
	}

	/**
	 * 更改税模块
	 * @throws SQLException
	 * */
	public void updDutys(Dutys dutys) throws SQLException {
		this.getSqlMapClient().update("updDutys", dutys);
	}

	public Dutys findDutys(Integer id) throws SQLException {
		return (Dutys) this.getSqlMapClient().queryForObject("selectDutysByID", id);
	}

}
