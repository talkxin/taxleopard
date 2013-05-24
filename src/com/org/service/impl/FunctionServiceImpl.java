package com.org.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.org.dao.FunctionDao;
import com.org.entity.Functions;
import com.org.service.FunctionService;

public class FunctionServiceImpl implements FunctionService {
	private FunctionDao functionDao;

	public FunctionDao getFunctionDao() {
		return functionDao;
	}

	public void setFunctionDao(FunctionDao functionDao) {
		this.functionDao = functionDao;
	}

	/**
	 * 添加功能
	 * */
	public void addFunctions(Functions function) throws SQLException {
		functionDao.addFunctions(function);

	}

	/**
	 * 删除功能
	 * */
	public void delFunctions(int functionID) throws SQLException {
		functionDao.delFunctions(functionID);

	}

	/**
	 * 更改功能
	 * */
	public void updFunctions(Functions functions) throws SQLException {
		functionDao.updFunctions(functions);
	}

	/**
	 * 查询附属功能
	 * */
	public List<Functions> findReside(int FunctionReside) throws SQLException {
		return functionDao.findReside(FunctionReside);
	}

	/**
	 * 查询功能
	 * */
	public List<Functions> findFunction(Integer userID) throws SQLException {
		return functionDao.findFunction(userID);
	}

}
