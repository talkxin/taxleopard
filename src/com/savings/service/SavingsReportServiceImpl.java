package com.savings.service;

import java.util.List;

import com.savings.dao.SavingsReportDao;
import com.savings.entity.SaIsGetSavings;

public class SavingsReportServiceImpl implements SavingsReportService{

	private SavingsReportDao savingsReportDao;

	public SavingsReportDao getSavingsReportDao() {
		return savingsReportDao;
	}

	public void setSavingsReportDao(SavingsReportDao savingsReportDao) {
		this.savingsReportDao = savingsReportDao;
	}

	public List<SaIsGetSavings> find(SaIsGetSavings isSa) {
		return savingsReportDao.find(isSa);
	}
	
}
