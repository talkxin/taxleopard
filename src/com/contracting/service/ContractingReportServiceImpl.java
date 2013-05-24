package com.contracting.service;

import java.util.List;

import com.contracting.dao.ContractingReportDao;
import com.contracting.entity.ConIsGetContract;

public class ContractingReportServiceImpl implements ContractingReportService{

	private ContractingReportDao contractingReportDao;

	public ContractingReportDao getContractingReportDao() {
		return contractingReportDao;
	}

	public void setContractingReportDao(ContractingReportDao contractingReportDao) {
		this.contractingReportDao = contractingReportDao;
	}

	public List<ConIsGetContract> findCon(ConIsGetContract con) {
        return contractingReportDao.findCon(con);
	}
	
}
