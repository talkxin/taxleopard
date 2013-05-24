package com.savings.service;

import java.sql.SQLException;
import java.util.List;

import com.savings.entity.SaInterest;
import com.savings.entity.SaSavings;
import com.savings.entity.SaSavingsInfo;

public interface SavingsService {
	/**
	 * 添加账户
	 * @param sa
	 * @return
	 */
	public SaSavingsInfo addSaSavingsInfo(SaSavingsInfo sa) throws SQLException; 
	/**
	 * 修改账户
	 * @param sa
	 */
	public void upSaSavingsInfo(SaSavingsInfo sa) throws SQLException; 
	/**
	 * 删除账户
	 * @param sa
	 */
	public void delSaSavingsInfo(int sa) throws SQLException; 
	/**
	 * 添加信息
	 * @param sa
	 */
	public void addSaSavings(SaSavings sa) throws SQLException; 
	/**
	 * 修改信息
	 * @param sa
	 */
	public void upSaSavings(SaSavings sa) throws SQLException; 
	/**
	 * 删除信息
	 * @param sa
	 */
	public void delSaSavings(int sa) throws SQLException; 
	/**
	 * 返回所有账户
	 * @param sa
	 * @return
	 */
	public List<SaSavingsInfo> isGetSavingsInfo(int sa) throws SQLException;
	/**
	 * 添加利率
	 * 
	 * @param sa
	 * @throws SQLException
	 */
	public void addInterest(SaInterest sa) throws SQLException;

	/**
	 * 修改利率
	 * 
	 * @param sa
	 * @throws SQLException
	 */
	public void upInterest(SaInterest sa) throws SQLException;

	/**
	 * 删除利率
	 * 
	 * @param sa
	 * @throws SQLException
	 */
	public void delInterest(int sa) throws SQLException;

	/**
	 * 返回利率
	 * 
	 * @param sa
	 * @return
	 */
	public List<SaInterest> isGetInterest(int sa) throws SQLException;
	/**
	 * 返回最新利率
	 * @param sa
	 * @return
	 * @throws SQLException
	 */
	public SaInterest isGetNewInterest(int sa) throws SQLException;
}
