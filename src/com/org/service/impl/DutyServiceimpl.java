package com.org.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.org.dao.DutyDao;
import com.org.entity.Duty;
import com.org.service.DutyService;

public class DutyServiceimpl implements DutyService {
	private DutyDao dutyDao;

	public DutyDao getDutyDao() {
		return dutyDao;
	}

	public void setDutyDao(DutyDao dutyDao) {
		this.dutyDao = dutyDao;
	}

	/**
	 * 查询所有税法
	 * 
	 * @throws SQLException
	 * */
	public List<Duty> findDutys() throws SQLException {
		return dutyDao.findDutys();
	}

	/**
	 * 添加税法
	 * 
	 * @throws SQLException
	 * */
	public void addDuty(Duty duty) throws SQLException {
		dutyDao.addDuty(duty);

	}

	/**
	 * 更改税法
	 * 
	 * @throws SQLException
	 * */
	public void updDuty(Duty duty) throws SQLException {
		dutyDao.updDuty(duty);

	}

	/**
	 * 删除税法
	 * 
	 * @throws SQLException
	 * */
	public void delDuty(int DutyID) throws SQLException {
		dutyDao.delDuty(DutyID);

	}

}
