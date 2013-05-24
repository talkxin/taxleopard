package com.remuneration.service;

import java.util.List;

import com.remuneration.dao.RemunerationReportDao;
import com.remuneration.entity.ReIsGetAllRemu;
import com.remuneration.entity.ReIsGetRemu;

public class RemunerationReportServiceImpl implements RemunerationReportService{

	private RemunerationReportDao remunerationReportDao;

	public RemunerationReportDao getRemunerationReportDao() {
		return remunerationReportDao;
	}

	public void setRemunerationReportDao(RemunerationReportDao remunerationReportDao) {
		this.remunerationReportDao = remunerationReportDao;
	}

	public List<ReIsGetRemu> findRe(ReIsGetRemu remu) {
		return remunerationReportDao.findRe(remu);
	}
	
	public List<ReIsGetRemu> findReByPress(ReIsGetRemu remu) {
		return remunerationReportDao.findReByPress(remu); 
	}

	public List<ReIsGetAllRemu> findAllRe(ReIsGetAllRemu remu) {
		return remunerationReportDao.findAllRe(remu);
	}


	
}
