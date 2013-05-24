package com.labor.service.impl;

import java.util.List;

import com.labor.dao.LaborReportDao;
import com.labor.dao.impl.LaborReportDaoImpl;
import com.labor.entity.LsLaborItem;
import com.labor.service.LsLaborItemService;
@SuppressWarnings("unchecked")
public class LsLaborItemServiceImpl extends LaborReportDaoImpl<LsLaborItem> implements LsLaborItemService{

	private LaborReportDao laborReportDao;

	public LaborReportDao getLaborReportDao() {
		return laborReportDao;
	}

	public void setLaborReportDao(LaborReportDao laborReportDao) {
		this.laborReportDao = laborReportDao;
	}
	public List<LsLaborItem> find(LsLaborItem lsLaborItem){
 		return laborReportDao.find(lsLaborItem);
	}
}

