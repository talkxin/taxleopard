package com.org.service;

import java.sql.SQLException;
import java.util.List;

import com.org.entity.Functions;

public interface FunctionService {

	/**
	 * 删除功能
	 * 
	 * @throws SQLException
	 * 
	 */
	public void delFunctions(int functionID) throws SQLException;

	/**
	 * 增加功能
	 * 
	 * @throws SQLException
	 * */
	public void addFunctions(Functions function) throws SQLException;

	/**
	 * 更改功能
	 * 
	 * @throws SQLException
	 * */
	public void updFunctions(Functions functions) throws SQLException;

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
}
