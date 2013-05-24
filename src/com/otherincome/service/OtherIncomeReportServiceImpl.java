package com.otherincome.service;

import java.util.List;

import com.otherincome.dao.OtherIncomeReportDao;
import com.otherincome.entity.OiOtherincome;

public class OtherIncomeReportServiceImpl implements OtherIncomeReportService{

	private OtherIncomeReportDao otherIncomeReportDao;

	public OtherIncomeReportDao getOtherIncomeReportDao() {
		return otherIncomeReportDao;
	}

	public void setOtherIncomeReportDao(OtherIncomeReportDao otherIncomeReportDao) {
		this.otherIncomeReportDao = otherIncomeReportDao;
	}

	public List<OiOtherincome> find(OiOtherincome otherIn) {
		return otherIncomeReportDao.find(otherIn);
	}
	
}
