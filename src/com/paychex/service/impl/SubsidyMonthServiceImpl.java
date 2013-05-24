package com.paychex.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.paychex.dao.WageDao;
import com.paychex.dao.impl.WageDaoImpl;
import com.paychex.entity.SubsidyMonth;
import com.paychex.service.SubsidyMonthService;
@SuppressWarnings("unchecked")
public class SubsidyMonthServiceImpl extends WageDaoImpl<SubsidyMonth> implements SubsidyMonthService{

	  private WageDao wageDao;
	    
	  public WageDao getWageDao() {
			return wageDao;
	  }

	  public void setWageDao(WageDao wageDao) {
			this.wageDao = wageDao;
      }
		/**
		 * 查询某个用户12个月各月的补贴和
		 * 
		 * @throws SQLException
		 * */
		public List<SubsidyMonth> find(SubsidyMonth subsidyMonth) {
			
			return wageDao.find(subsidyMonth);
		}
}
