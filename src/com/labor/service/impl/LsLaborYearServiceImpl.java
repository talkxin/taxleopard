package com.labor.service.impl;

import java.util.List;

import com.labor.dao.LaborReportDao;
import com.labor.dao.impl.LaborReportDaoImpl;
import com.labor.entity.LsLaborYear;
import com.labor.service.LsLaborYearService;
@SuppressWarnings("unchecked")
public class LsLaborYearServiceImpl extends LaborReportDaoImpl<LsLaborYear> implements LsLaborYearService{

	private LaborReportDao laborReportDao;

	public LaborReportDao getLaborReportDao() {
		return laborReportDao;
	}

	public void setLaborReportDao(LaborReportDao laborReportDao) {
		this.laborReportDao = laborReportDao;
	}
	
	
	public List<LsLaborYear> find(LsLaborYear lsLaborYear){
 		return laborReportDao.find(lsLaborYear);
	}
}
