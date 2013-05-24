package com.savings.dwr;

import java.util.List;

import com.savings.entity.SaIsGetSavings;
import com.savings.service.SavingsReportService;

public class SavingsReportDwr {

	private SavingsReportService savingsReportService;

	public SavingsReportService getSavingsReportService() {
		return savingsReportService;
	}

	public void setSavingsReportService(SavingsReportService savingsReportService) {
		this.savingsReportService = savingsReportService;
	}
	/**
	 * 查询用户某个账户的储蓄信息
	 * @param isOccasional
	 */
    public List<SaIsGetSavings> findSavingsDwr(Integer uid,Integer siid){
    	SaIsGetSavings isSa=new SaIsGetSavings();
    	isSa.setUid(uid);
    	isSa.setSiid(siid);
    	return savingsReportService.find(isSa);
    }
}
