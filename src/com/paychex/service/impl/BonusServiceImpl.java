package com.paychex.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.paychex.dao.WageDao;
import com.paychex.dao.impl.WageDaoImpl;
import com.paychex.entity.Bonus;
import com.paychex.service.BonusService;
@SuppressWarnings("unchecked")
public class BonusServiceImpl extends WageDaoImpl<Bonus> implements BonusService{
	
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
	public List<Bonus> find(Bonus bonus){
		return wageDao.find(bonus);
	}

	
}
