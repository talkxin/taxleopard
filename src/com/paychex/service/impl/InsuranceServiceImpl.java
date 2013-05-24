package com.paychex.service.impl;

import java.sql.SQLException;

import com.paychex.dao.WageDao;
import com.paychex.dao.impl.WageDaoImpl;
import com.paychex.entity.Insurance;
import com.paychex.service.InsuranceService;
@SuppressWarnings("unchecked")
public class InsuranceServiceImpl extends WageDaoImpl<Insurance> implements InsuranceService{

    private WageDao wageDao;
    

	public WageDao getWageDao() {
		return wageDao;
	}


	public void setWageDao(WageDao wageDao) {
		this.wageDao = wageDao;
	}


	/**
	 * 查询某个用户的社保
	 * 
	 * @throws SQLException
	 * */
	@Override
	public Insurance findSingle(Insurance insurance)  {
		
		return (Insurance)wageDao.findSingle(insurance);
	}
	
}
