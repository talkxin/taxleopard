package com.org.service;

import java.sql.SQLException;
import java.util.List;

import com.org.entity.Duty;

public interface DutyService {
	/**
	 * 查询所有税法
	 * 
	 * @throws SQLException
	 * */
	public List<Duty> findDutys() throws SQLException;

	/**
	 * 添加税法
	 * 
	 * @throws SQLException
	 * */
	public void addDuty(Duty duty) throws SQLException;
	/**
	 * 更改税法
	 * 
	 * @throws SQLException
	 * */
	public void updDuty(Duty duty) throws SQLException;

	/**
	 * 删除税法
	 * 
	 * @throws SQLException
	 * */
	public void delDuty(int DutyID) throws SQLException;

}
