package com.paychex.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.paychex.dao.WageDao;
import com.paychex.dao.impl.WageDaoImpl;
import com.paychex.entity.PayrollMonth;
import com.paychex.service.PayrollMonthService;

@SuppressWarnings("unchecked")
public class PayrollMonthServiceImpl extends WageDaoImpl<PayrollMonth> implements PayrollMonthService{

    private WageDao wageDao;
    
    public WageDao getWageDao() {
		return wageDao;
	}

    public void setWageDao(WageDao wageDao) {
		this.wageDao = wageDao;
	}
    /**
	 * 查询某个用户某年各月的基础工资/纳税额
	 * 
	 * @throws SQLException
	 * */
	public List<PayrollMonth> find(PayrollMonth taxMonth) {
		
		return wageDao.find(taxMonth);
	}
}
