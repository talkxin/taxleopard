package com.org.dao;

import java.sql.SQLException;
import java.util.List;

import com.org.entity.Dutys;

public interface DutysDao {

	/**
	 * 查询税模块
	 * @throws SQLException 
	 * */
	public List<Dutys> findDutys() throws SQLException;
	/**
	 * 根据编号查询
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public Dutys findDutys(Integer id)throws SQLException;

	/**
	 * 删除税模块
	 * 
	 * @throws SQLException
	 * */
	public void delDutys(int DutysID) throws SQLException;

	/**
	 * 添加税模块
	 * 
	 * @throws SQLException
	 * */
	public void addDutys(Dutys dutys) throws SQLException;

	/**
	 * 更改税模块
	 * @throws SQLException 
	 */
	public void updDutys(Dutys dutys) throws SQLException;

}
