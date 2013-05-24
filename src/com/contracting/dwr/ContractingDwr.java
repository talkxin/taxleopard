package com.contracting.dwr;

import java.sql.SQLException;
import java.util.List;

import com.contracting.entity.ConContract;
import com.contracting.entity.ConContractInfo;
import com.contracting.service.ContractingService;

public class ContractingDwr {
	private ContractingService contractingService;

	public ContractingService getContractingService() {
		return contractingService;
	}

	public void setContractingService(ContractingService contractingService) {
		this.contractingService = contractingService;
	}

	/***
	 * 添加承租机构
	 * 
	 * @param co
	 * @return
	 */
	public ConContractInfo addContractInfo(ConContractInfo co)
			throws SQLException {
		return contractingService.addContractInfo(co);
	}

	/**
	 * 修改承租机构
	 * 
	 * @param co
	 */
	public void upContractInfo(ConContractInfo co) throws SQLException {
		contractingService.upContractInfo(co);
	}

	/**
	 * 删除承租机构
	 * 
	 * @param co
	 */
	public void delContractInfo(int co) throws SQLException {
		contractingService.delContractInfo(co);
	}

	/**
	 * 添加所得
	 * 
	 * @param co
	 */
	public void addContract(ConContract co) throws SQLException {
		contractingService.addContract(co);
	}

	/**
	 * 修改所得
	 * 
	 * @param co
	 */
	public void upContract(ConContract co) throws SQLException {
		contractingService.upContract(co);
	}

	/**
	 * 删除所得
	 * 
	 * @param co
	 */
	public void delContract(int co) throws SQLException {
		contractingService.delContract(co);
	}
	/**
	 * 获取所有用户的承租机构
	 * @param co
	 * @return
	 * @throws SQLException
	 */
	public List<ConContractInfo> isGetUserContractInfo(int co)throws SQLException{
		return contractingService.isGetUserContractInfo(co);
	}
}
