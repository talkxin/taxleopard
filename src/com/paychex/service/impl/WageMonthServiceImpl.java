package com.paychex.service.impl;

import java.sql.SQLException;
import java.util.HashMap;

import com.paychex.dao.WageDao;
import com.paychex.dao.impl.WageDaoImpl;
import com.paychex.entity.WageMonth;
import com.paychex.service.WageMonthService;
@SuppressWarnings("unchecked")
public class WageMonthServiceImpl extends WageDaoImpl<WageMonth> implements WageMonthService{

	private WageDao wageDao;

	public WageDao getWageDao() {
		return wageDao;
	}

	public void setWageDao(WageDao wageDao) {
		this.wageDao = wageDao;
	}
	/**
	 * 查询某个用户月工资信息汇总
	 * 
	 * @throws SQLException
	 * */
    public WageMonth findSingle(WageMonth wageMonth) {
		
		return (WageMonth)wageDao.findSingle(wageMonth);
	}
    public String findMonthMap(Integer uid,String month,String sybx){
		return wageDao.findMonthMap(uid,month,sybx);
	}
}
