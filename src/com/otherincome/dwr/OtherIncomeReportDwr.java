package com.otherincome.dwr;

import java.util.List;

import com.otherincome.entity.OiOtherincome;
import com.otherincome.service.OtherIncomeReportService;

public class OtherIncomeReportDwr {

	private OtherIncomeReportService otherIncomeReportService;

	public OtherIncomeReportService getOtherIncomeReportService() {
		return otherIncomeReportService;
	}

	public void setOtherIncomeReportService(
			OtherIncomeReportService otherIncomeReportService) {
		this.otherIncomeReportService = otherIncomeReportService;
	}
	/**
	 * 查询其他所得
	 * @param otherIn
	 * @return
	 */
	public List<OiOtherincome> findOtherIncomeDwr(Integer uid){
		OiOtherincome otherIn=new OiOtherincome();
		otherIn.setUid(uid);
	    return otherIncomeReportService.find(otherIn);
    }
}
