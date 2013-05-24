package com.contracting.dwr;

import java.util.List;

import com.contracting.entity.ConIsGetContract;
import com.contracting.service.ContractingReportService;

public class ContractingReportDwr {

	private ContractingReportService contractingReportService;

	public ContractingReportService getContractingReportService() {
		return contractingReportService;
	}

	public void setContractingReportService(
			ContractingReportService contractingReportService) {
		this.contractingReportService = contractingReportService;
	}
	/***
	 * 查询用户某个承包承租的详细信息
	 * @param con
	 * @return
	 */

	public List<ConIsGetContract> findConDwr(Integer uid,Integer ciid){
		ConIsGetContract con=new ConIsGetContract();
		con.setUid(uid);
		con.setCiid(ciid);
		return contractingReportService.findCon(con);
	}
	
}
