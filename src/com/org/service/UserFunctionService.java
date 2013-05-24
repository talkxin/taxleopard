package com.org.service;

import java.sql.SQLException;
import java.util.List;

import com.org.entity.UserFunction;

public interface UserFunctionService {
	/**
	 * 查询所有用户功能
	 * 
	 * @throws SQLException
	 * */
	public List<UserFunction> findUserFunction() throws SQLException;

	/**
	 * 添加功能
	 * 
	 * @throws SQLException
	 * */
	public void addUserFunction(UserFunction userFunction) throws SQLException;

	/**
	 * 删除功能
	 * 
	 * @throws SQLException
	 * */
	public void delUserFunction(int userFunctionID) throws SQLException;

	/**
	 * 修改功能
	 * 
	 * @throws SQLException
	 * */
	public void updUserFunction(UserFunction userFunction) throws SQLException;

}
