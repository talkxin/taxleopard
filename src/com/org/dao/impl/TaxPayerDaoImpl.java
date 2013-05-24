package com.org.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.org.dao.TaxPayerDao;
import com.org.entity.AdminRegister;
import com.org.entity.Functions;
import com.org.entity.Matter;
import com.org.entity.TaxPayer;

public class TaxPayerDaoImpl implements TaxPayerDao {
	private SqlMapClient sqlMapClient;

	public SqlMapClient getSqlMapClient() {
		return sqlMapClient;
	}

	public void setSqlMapClient(SqlMapClient sqlMapClient) {
		this.sqlMapClient = sqlMapClient;
	}

	/**
	 * 登录操作
	 * 
	 * @throws SQLException
	 * @throws SQLException
	 * */
	public TaxPayer findLogin(TaxPayer taxPayer) throws SQLException {
		return (TaxPayer) this.getSqlMapClient().queryForObject("findLogin", taxPayer);
	}

	/**
	 * 添加用户
	 * 
	 * @throws SQLException
	 * */
	public void addTaxPayer(TaxPayer taxPayer) throws SQLException {
		this.getSqlMapClient().insert("addTaxPayer", taxPayer);
	}

	/**
	 * 更改用户状态
	 * 
	 * @throws SQLException
	 * */
	public void updateTaxPayerByState(TaxPayer id) throws SQLException {
		this.getSqlMapClient().update("updTaxPayer", id);

	}

	/**
	 * 根据用户名查找用户密码
	 * 
	 * @throws SQLException
	 * */
	public TaxPayer findTaxPayerByName(TaxPayer taxPayer) throws SQLException {
		return (TaxPayer) this.getSqlMapClient().queryForObject(
				"findTaxPayerByName", taxPayer);
	}

	/**
	 * 查询密码问题
	 * 
	 * @throws SQLException
	 * */
	@SuppressWarnings("unchecked")
	public List<Matter> findMatters(int taxID) throws SQLException {
		return this.getSqlMapClient().queryForList("findMatters", taxID);
	}

	/**
	 * 根据问题查找问题
	 * 
	 * @throws SQLException
	 * */
	public Matter findMatterByName(String matter) throws SQLException {
		return (Matter) this.getSqlMapClient().queryForObject(
				"findMatterByName", matter);
	}

	/**
	 * 根据id修改密码
	 * 
	 * @throws SQLException
	 * */
	public void updatePassWord(TaxPayer taxPayer) throws SQLException {
		this.getSqlMapClient().update("updPassWord", taxPayer);
	}

	@SuppressWarnings("unchecked")
	public List<Functions> findFunction(Integer userID) throws SQLException {
		return this.getSqlMapClient().queryForList("findFunction",userID);
	}

	/**
	 * 查询附属功能
	 * 
	 * @throws SQLException
	 * */
	@SuppressWarnings("unchecked")
	public List<Functions> findReside(int FunctionReside) throws SQLException {
		return this.getSqlMapClient()
				.queryForList("findReside", FunctionReside);
	}

	/**
	 * 添加登录信息
	 * 
	 * @throws SQLException
	 * */
	public void addAdminRegister(AdminRegister adminRegister)
			throws SQLException {
		this.getSqlMapClient().insert("addAdminRegister", adminRegister);
	}
}
