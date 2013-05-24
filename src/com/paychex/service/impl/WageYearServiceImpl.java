package com.paychex.service.impl;

import java.sql.SQLException;

import com.paychex.dao.WageDao;
import com.paychex.dao.impl.WageDaoImpl;
import com.paychex.entity.WageYear;
import com.paychex.service.WageYearService;
@SuppressWarnings("unchecked")
public class WageYearServiceImpl extends WageDaoImpl<WageYear> implements WageYearService{

	private WageDao wageDao;

	public WageDao getWageDao() {
		return wageDao;
	}

	public void setWageDao(WageDao wageDao) {
		this.wageDao = wageDao;
	}
	/**
	 * 查询某个用户全年工资信息汇总
	 * 
	 * @throws SQLException
	 * */
	public WageYear findSingle(WageYear wageYear) {
		
		return (WageYear)wageDao.findSingle(wageYear);
	}
	public String findMap(Integer uid,String year,String zsybx){
		return wageDao.findMap(uid, year, zsybx);
	}
}
