package com.paychex.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.paychex.dao.WageDao;
import com.paychex.dao.impl.WageDaoImpl;
import com.paychex.entity.BonusMonth;
import com.paychex.service.BonusMonthService;
@SuppressWarnings("unchecked")
public class BonusMonthServiceImpl extends WageDaoImpl<BonusMonth> implements BonusMonthService{

    private WageDao wageDao;
    
    public WageDao getWageDao() {
		return wageDao;
	}

    public void setWageDao(WageDao wageDao) {
		this.wageDao = wageDao;
	}
    /**
	 * 查询某个用户某年各月的分红和
	 * 
	 * @throws SQLException
	 * */
	public List<BonusMonth> find(BonusMonth bonusMonth) {
		
		return wageDao.find(bonusMonth);
	}
}
