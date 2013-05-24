package com.labor.service.impl;

import java.util.List;

import com.labor.dao.LaborReportDao;
import com.labor.dao.impl.LaborReportDaoImpl;
import com.labor.entity.LsLaborMonth;
import com.labor.service.LsLaborMonthService;

@SuppressWarnings("unchecked")
public class LsLaborMonthServiceImpl extends LaborReportDaoImpl<LsLaborMonth> implements LsLaborMonthService{

	private LaborReportDao laborReportDao;

	public LaborReportDao getLaborReportDao() {
		return laborReportDao;
	}

	public void setLaborReportDao(LaborReportDao laborReportDao) {
		this.laborReportDao = laborReportDao;
	}
	
	
	public List<LsLaborMonth> find(LsLaborMonth lsLaborMonth){
 		return laborReportDao.find(lsLaborMonth);
	}
}
