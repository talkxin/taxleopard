package com.contracting.service;

import java.sql.SQLException;
import java.util.List;

import com.contracting.dao.ContractingDao;
import com.contracting.entity.ConContract;
import com.contracting.entity.ConContractInfo;

public class ContractingServiceimpl implements ContractingService{
	private ContractingDao contractingDao;

	public ContractingDao getContractingDao() {
		return contractingDao;
	}

	public void setContractingDao(ContractingDao contractingDao) {
		this.contractingDao = contractingDao;
	}

	public ConContractInfo addContractInfo(ConContractInfo co)
			throws SQLException {
		// TODO Auto-generated method stub
		return contractingDao.addContractInfo(co);
	}

	public void upContractInfo(ConContractInfo co) throws SQLException {
		// TODO Auto-generated method stub
		contractingDao.upContractInfo(co);
	}

	public void delContractInfo(int co) throws SQLException {
		// TODO Auto-generated method stub
		contractingDao.delContractInfo(co);
	}

	public void addContract(ConContract co) throws SQLException {
		// TODO Auto-generated method stub
		contractingDao.addContract(co);
	}

	public void upContract(ConContract co) throws SQLException {
		// TODO Auto-generated method stub
		contractingDao.upContract(co);
	}

	public void delContract(int co) throws SQLException {
		// TODO Auto-generated method stub
		contractingDao.delContract(co);
	}

	public List<ConContractInfo> isGetUserContractInfo(int co)
			throws SQLException {
		// TODO Auto-generated method stub
		return contractingDao.isGetUserContractInfo(co);
	}
}
