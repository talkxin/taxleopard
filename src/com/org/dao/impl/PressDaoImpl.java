package com.org.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.org.dao.PressDao;
import com.org.entity.Press;

public class PressDaoImpl implements PressDao {
	private SqlMapClient sqlMapClient;

	public SqlMapClient getSqlMapClient() {
		return sqlMapClient;
	}

	public void setSqlMapClient(SqlMapClient sqlMapClient) {
		this.sqlMapClient = sqlMapClient;
	}

	/**
	 * 添加新闻
	 * 
	 * @throws SQLException
	 * */
	public void addPress(Press press) throws SQLException {
		this.getSqlMapClient().insert("addPress", press);

	}

	/**
	 * 删除新闻
	 * 
	 * @throws SQLException
	 * */
	public void delPress(int pressID) throws SQLException {
		this.getSqlMapClient().delete("delPress", pressID);

	}

	/**
	 * 查询新闻
	 * 
	 * @throws SQLException
	 * */
	@SuppressWarnings("unchecked")
	public List<Press> findPress() throws SQLException {
		return this.getSqlMapClient().queryForList("findPress");
	}

	/**
	 * 更改新闻
	 * 
	 * @throws SQLException
	 * */
	public void updPress(Press press) throws SQLException {
		this.getSqlMapClient().update("updPress", press);
	}

	/***
	 * 根据ID查询新闻
	 * 
	 * @throws SQLException
	 * */
	public Press findPressByID(int pressID) throws SQLException {
		return (Press) this.getSqlMapClient().queryForObject("findPressByID",
				pressID);
	}

	/**
	 * 查询下一篇
	 * */
	public Press findNextPress(int pressID) throws SQLException {
		return (Press) this.getSqlMapClient().queryForObject("findNextPress",
				pressID);
	}

	/**
	 * 查询上一篇
	 * 
	 * @throws SQLException
	 * */
	public Press findUpPress(int pressID) throws SQLException {
		return (Press) this.getSqlMapClient().queryForObject("findUpPress",
				pressID);
	}

	/**
	 * 查询分页
	 * 
	 * @throws SQLException
	 * */
	@SuppressWarnings("unchecked")
	public List<Press> findPage(Press press) throws SQLException {
		return this.getSqlMapClient().queryForList("findPage", press);
	}

	/**
	 * 查询总记录数
	 * @throws SQLException 
	 * */
	public Integer recordCount(String where) throws SQLException {
		
		return (Integer) this.getSqlMapClient().queryForObject("recordCount",where);
	}
	//查询新闻
	@SuppressWarnings("unchecked")
	public List<Press> selectNewIndex() throws SQLException {
		return this.getSqlMapClient().queryForList("selectNewIndex");
	}

}
