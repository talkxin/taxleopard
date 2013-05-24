package com.geti.service;

import java.util.List;

import com.geti.dao.GetiReportDao;
import com.geti.entity.GtGetigongshang;

public class GetiReportServiceImpl implements GetiReportService{

	private GetiReportDao getiReportDao;
	
	public GetiReportDao getGetiReportDao() {
		return getiReportDao;
	}

	public void setGetiReportDao(GetiReportDao getiReportDao) {
		this.getiReportDao = getiReportDao;
	}

	public List<GtGetigongshang> findGe(GtGetigongshang geti) {
       return getiReportDao.findGe(geti);
	}

}
