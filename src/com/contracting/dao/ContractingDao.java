package com.contracting.dao;

import java.sql.SQLException;
import java.util.List;

import com.contracting.entity.ConContract;
import com.contracting.entity.ConContractInfo;

public interface ContractingDao{
	/***
	 * 添加承租机构
	 * @param co
	 * @return
	 */
public ConContractInfo addContractInfo(ConContractInfo co) throws SQLException;
/**
 * 修改承租机构
 * @param co
 */
public void upContractInfo(ConContractInfo co) throws SQLException;
/**
 * 删除承租机构
 * @param co
 */
public void delContractInfo(int co) throws SQLException;
/**
 * 添加所得
 * @param co
 */
public void addContract(ConContract co) throws SQLException;
/**
 * 修改所得
 * @param co
 */
public void upContract(ConContract co) throws SQLException;
/**
 * 删除所得
 * @param co
 */
public void delContract(int co) throws SQLException;
/**
 * 获取所有用户的承租机构
 * @param co
 * @return
 * @throws SQLException
 */
public List<ConContractInfo> isGetUserContractInfo(int co)throws SQLException;
}
