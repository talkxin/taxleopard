package com.paychex.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.paychex.dao.WageDao;
import com.paychex.dao.impl.WageDaoImpl;
import com.paychex.entity.PrizeMonth;
import com.paychex.service.PrizeMonthService;
@SuppressWarnings("unchecked")
public class PrizeMonthServiceImpl extends WageDaoImpl<PrizeMonth> implements PrizeMonthService{

    private WageDao wageDao;
    
    public WageDao getWageDao() {
		return wageDao;
	}

    public void setWageDao(WageDao wageDao) {
		this.wageDao = wageDao;
	}
	/**
	 * 查询某个用户12个月各月的奖金和
	 * 
	 * @throws SQLException
	 * */
	public List<PrizeMonth> find(PrizeMonth prizeMonth) {
		
		return wageDao.find(prizeMonth);
	}
}
