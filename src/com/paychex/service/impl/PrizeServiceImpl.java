package com.paychex.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.paychex.dao.WageDao;
import com.paychex.dao.impl.WageDaoImpl;
import com.paychex.entity.PrizeJoin;
import com.paychex.service.PrizeService;
@SuppressWarnings("unchecked")
public class PrizeServiceImpl extends WageDaoImpl<PrizeJoin> implements PrizeService{

    private WageDao wageDao;
    
    public WageDao getWageDao() {
		return wageDao;
	}

    public void setWageDao(WageDao wageDao) {
		this.wageDao = wageDao;
	}

   /**
	 * 查询某个用户某月所有奖金
	 * 
	 * @throws SQLException
	 * */
	public List<PrizeJoin> find(PrizeJoin prizeJoin) {
		
		return wageDao.find(prizeJoin);
	}


}
