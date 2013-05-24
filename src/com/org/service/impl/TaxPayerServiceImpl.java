package com.org.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.org.dao.TaxPayerDao;
import com.org.entity.AdminRegister;
import com.org.entity.Functions;
import com.org.entity.Matter;
import com.org.entity.TaxPayer;
import com.org.service.taxPayerService;

public class TaxPayerServiceImpl implements taxPayerService {
	private TaxPayerDao taxPayerDao;

	public TaxPayerDao getTaxPayerDao() {
		return taxPayerDao;
	}

	public void setTaxPayerDao(TaxPayerDao taxPayerDao) {
		this.taxPayerDao = taxPayerDao;
	}

	/**
	 * 登录操作
	 * 
	 * @throws SQLException
	 * */
	public TaxPayer findLogin(TaxPayer taxPayer) throws SQLException {
		return taxPayerDao.findLogin(taxPayer);
	}

	/**
	 * 添加用户
	 * 
	 * @throws SQLException
	 * */
	public void addTaxPayer(TaxPayer taxPayer) throws SQLException {
		taxPayerDao.addTaxPayer(taxPayer);
	}

	/**
	 * 更改用户状态
	 * 
	 * @throws SQLException
	 * */
	public void updateTaxPayerByState(TaxPayer id) throws SQLException {
		taxPayerDao.updateTaxPayerByState(id);
	}

	/**
	 * 根据用户名查找用户
	 * */
	public TaxPayer findTaxPayerByName(TaxPayer taxPayer) throws SQLException {
		return taxPayerDao.findTaxPayerByName(taxPayer);
	}

	/**
	 * 查询密码问题
	 * */
	public List<Matter> findMatters(int taxID) throws SQLException {
		return taxPayerDao.findMatters(taxID);
	}

	public Matter findMatterByName(String matter) throws SQLException {
		return taxPayerDao.findMatterByName(matter);
	}

	/**
	 * 根据id修改密码
	 * */
	public void updatePassWord(TaxPayer taxPayer) throws SQLException {
		taxPayerDao.updatePassWord(taxPayer);

	}

	/**
	 * 查询附属功能
	 * */
	public List<Functions> findReside(int FunctionReside) throws SQLException {
		return taxPayerDao.findReside(FunctionReside);
	}

	/**
	 * 查询功能
	 * */
	public List<Functions> findFunction(Integer userID) throws SQLException {
		return taxPayerDao.findFunction(userID);
	}

	/**
	 * 添加登录信息
	 * */
	public void addAdminRegister(AdminRegister adminRegister)
			throws SQLException {
		taxPayerDao.addAdminRegister(adminRegister);
	}
}
