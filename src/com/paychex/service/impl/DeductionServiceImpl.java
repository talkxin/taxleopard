package com.paychex.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.paychex.dao.WageDao;
import com.paychex.dao.impl.WageDaoImpl;
import com.paychex.entity.Deduction;
import com.paychex.service.DeductionService;
@SuppressWarnings("unchecked")
public class DeductionServiceImpl extends WageDaoImpl<Deduction> implements DeductionService{

    private WageDao wageDao;
    
	public WageDao getWageDao() {
		return wageDao;
	}

	public void setWageDao(WageDao wageDao) {
		this.wageDao = wageDao;
	}

	/**
	 * 查询某个用户某月所有扣除项
	 * 
	 * @throws SQLException
	 * */
	public List<Deduction> find(Deduction deduction){
		return wageDao.find(deduction);
	}
}
