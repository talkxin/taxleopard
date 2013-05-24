package com.chartered.service;

import java.util.List;

import com.chartered.dao.CharteredReportDao;
import com.chartered.entity.CrIsGetChartered;

public class CharteredReportServiceImpl implements CharteredReportService{

	private CharteredReportDao charteredReportDao;

	public CharteredReportDao getCharteredReportDao() {
		return charteredReportDao;
	}

	public void setCharteredReportDao(CharteredReportDao charteredReportDao) {
		this.charteredReportDao = charteredReportDao;
	}

	public List<CrIsGetChartered> find(CrIsGetChartered isCh) {
        return charteredReportDao.find(isCh);
	}
	
}
