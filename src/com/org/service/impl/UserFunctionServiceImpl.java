package com.org.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.org.dao.UserFunctionDao;
import com.org.entity.UserFunction;
import com.org.service.UserFunctionService;

public class UserFunctionServiceImpl implements UserFunctionService {
	private UserFunctionDao userFunctionDao;

	public UserFunctionDao getUserFunctionDao() {
		return userFunctionDao;
	}

	public void setUserFunctionDao(UserFunctionDao userFunctionDao) {
		this.userFunctionDao = userFunctionDao;
	}

	/**
	 * 添加功能
	 * 
	 * @throws SQLException
	 * */
	public void addUserFunction(UserFunction userFunction) throws SQLException {
		userFunctionDao.addUserFunction(userFunction);
	}

	/**
	 * 删除功能
	 * 
	 * @throws SQLException
	 * */
	public void delUserFunction(int userFunctionID) throws SQLException {
		userFunctionDao.delUserFunction(userFunctionID);

	}

	/**
	 * 查询所有用户功能
	 * 
	 * @throws SQLException
	 * */
	public List<UserFunction> findUserFunction() throws SQLException {
		return userFunctionDao.findUserFunction();
	}

	/**
	 * 修改功能
	 * 
	 * @throws SQLException
	 * */
	public void updUserFunction(UserFunction userFunction) throws SQLException {
		userFunctionDao.updUserFunction(userFunction);

	}

}
