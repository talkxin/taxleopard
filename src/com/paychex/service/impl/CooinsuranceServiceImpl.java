package com.paychex.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.paychex.dao.WageDao;
import com.paychex.dao.impl.WageDaoImpl;
import com.paychex.entity.Cooinsurance;
import com.paychex.service.CooinsuranceService;
@SuppressWarnings("unchecked")
public class CooinsuranceServiceImpl extends WageDaoImpl<Cooinsurance> implements CooinsuranceService{

    private WageDao wageDao;
    
	public WageDao getWageDao() {
		return wageDao;
	}

	public void setWageDao(WageDao wageDao) {
		this.wageDao = wageDao;
	}

	/**
	 * 查询某个用户某月所有分红
	 * 
	 * @throws SQLException
	 * */
	public List<Cooinsurance> find(Cooinsurance cooinsurance){
		return wageDao.find(cooinsurance);
	}
}
