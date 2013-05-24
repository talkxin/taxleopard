package com.org.dao;

import java.sql.SQLException;
import java.util.List;

import com.org.entity.AdminRegister;
import com.org.entity.Functions;
import com.org.entity.Matter;
import com.org.entity.TaxPayer;

public interface TaxPayerDao {
	/**
	 * 登录操作
	 * 
	 * @throws SQLException
	 * */
	public TaxPayer findLogin(TaxPayer taxPayer) throws SQLException;

	/**
	 * 添加用户
	 * 
	 * @throws SQLException
	 * */
	public void addTaxPayer(TaxPayer taxPayer) throws SQLException;

	/**
	 * 更改用户状态
	 * 
	 * @throws SQLException
	 * */
	public void updateTaxPayerByState(TaxPayer id) throws SQLException;

	/***
	 *根据用户名查找用户
	 * 
	 * @throws SQLException
	 * */
	public TaxPayer findTaxPayerByName(TaxPayer taxPayer) throws SQLException;

	/**
	 * 查询密码问题
	 * 
	 * @throws SQLException
	 * */
	public List<Matter> findMatters(int taxID) throws SQLException;

	/**
	 * 根据密码问题验证
	 * 
	 * @throws SQLException
	 * */
	public Matter findMatterByName(String matter) throws SQLException;

	/**
	 * 根据id修改密码
	 * 
	 * @throws SQLException
	 * */
	public void updatePassWord(TaxPayer taxPayer) throws SQLException;

	/**
	 * 查询所有功能
	 * 
	 * @throws SQLException
	 * 
	 * */
	public List<Functions> findFunction(Integer userID) throws SQLException;

	/**
	 * 查询附属功能
	 * 
	 * @throws SQLException
	 * */
	public List<Functions> findReside(int FunctionReside) throws SQLException;

	/***
	 * 添加登录记录
	 * 
	 * @throws SQLException
	 * */
	public void addAdminRegister(AdminRegister adminRegister)
			throws SQLException;
}
