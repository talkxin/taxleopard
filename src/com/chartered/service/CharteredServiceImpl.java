package com.chartered.service;

import java.sql.SQLException;
import java.util.List;

import com.chartered.dao.CharteredDao;
import com.chartered.entity.CrChartered;
import com.chartered.entity.CrCharteredInfo;

public class CharteredServiceImpl implements CharteredService{
	private CharteredDao charteredDao;

	public CharteredDao getCharteredDao() {
		return charteredDao;
	}

	public void setCharteredDao(CharteredDao charteredDao) {
		this.charteredDao = charteredDao;
	}

	public CrCharteredInfo addCrCharteredInfo(CrCharteredInfo cr)
			throws SQLException {
		// TODO Auto-generated method stub
		return charteredDao.addCrCharteredInfo(cr);
	}

	public void upCrCharteredInfo(CrCharteredInfo cr) throws SQLException {
		// TODO Auto-generated method stub
		charteredDao.upCrCharteredInfo(cr);
	}

	public void delCrCharteredInfo(int cr) throws SQLException {
		// TODO Auto-generated method stub
		charteredDao.delCrCharteredInfo(cr);
	}

	public void addCrChartered(CrChartered cr) throws SQLException {
		// TODO Auto-generated method stub
		charteredDao.addCrChartered(cr);
	}

	public void upCrChartered(CrChartered cr) throws SQLException {
		// TODO Auto-generated method stub
		charteredDao.upCrChartered(cr);
	}

	public void delCrChartered(int cr) throws SQLException {
		// TODO Auto-generated method stub
		charteredDao.delCrChartered(cr);
	}

	public List<CrCharteredInfo> isGetCharteredInfo(int cr) throws SQLException {
		// TODO Auto-generated method stub
		return charteredDao.isGetCharteredInfo(cr);
	}
}
