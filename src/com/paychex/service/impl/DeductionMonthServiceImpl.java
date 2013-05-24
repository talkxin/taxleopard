package com.paychex.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.paychex.dao.WageDao;
import com.paychex.dao.impl.WageDaoImpl;
import com.paychex.entity.DeductionMonth;
import com.paychex.service.DeductionMonthService;
@SuppressWarnings("unchecked")
public class DeductionMonthServiceImpl extends WageDaoImpl<DeductionMonth> implements DeductionMonthService{

    private WageDao wageDao;
    
    public WageDao getWageDao() {
		return wageDao;
	}

    public void setWageDao(WageDao wageDao) {
		this.wageDao = wageDao;
	}
    /**
	 * 查询某个用户某年各月的扣除项和
	 * 
	 * @throws SQLException
	 * */
	public List<DeductionMonth> find(DeductionMonth deductionMonth) {
		
		return wageDao.find(deductionMonth);
	}
	
}
