package com.paychex.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.paychex.dao.WageDao;
import com.paychex.dao.impl.WageDaoImpl;
import com.paychex.entity.SubsidyJoin;
import com.paychex.service.SubsidyService;
@SuppressWarnings("unchecked")
public class SubsidyServiceImpl extends WageDaoImpl<SubsidyJoin> implements SubsidyService{
    
	private WageDao wageDao;
    

	public WageDao getWageDao() {
		return wageDao;
	}


	public void setWageDao(WageDao wageDao) {
		this.wageDao = wageDao;
	}


	/**
	 * 查询某个用户某月所有补贴
	 * 
	 * @throws SQLException
	 * */
	public List<SubsidyJoin> find(SubsidyJoin subsidyJoin)  {
		
		return wageDao.find(subsidyJoin);
	}

}
