package com.labor.dwr;

import java.util.List;

import com.labor.entity.LsLaborItem;
import com.labor.entity.LsLaborMonth;
import com.labor.entity.LsLaborYear;
import com.labor.service.LsLaborItemService;
import com.labor.service.LsLaborMonthService;
import com.labor.service.LsLaborYearService;

public class LaborReportDwr {

	private LsLaborYearService lsLaborYearService;
    private LsLaborItemService lsLaborItemService;
    private LsLaborMonthService lsLaborMonthService;
	public void setLsLaborYearService(LsLaborYearService lsLaborYearService) {
		this.lsLaborYearService = lsLaborYearService;
	}
	public void setLsLaborItemService(LsLaborItemService lsLaborItemService) {
		this.lsLaborItemService = lsLaborItemService;
	}
    public void setLsLaborMonthService(LsLaborMonthService lsLaborMonthService) {
		this.lsLaborMonthService = lsLaborMonthService;
	}
    
	public List<LsLaborYear> findLaborYear(Integer uid,String year){
		LsLaborYear lsLaborYear=new LsLaborYear();
		lsLaborYear.setUid(uid);
		lsLaborYear.setLaborYear(year);
		return lsLaborYearService.find(lsLaborYear);
	}
	public List<LsLaborItem> findLaborItem(Integer uid,String year,Integer lid){
		LsLaborItem lsLaborItem=new LsLaborItem();
		lsLaborItem.setUid(uid);
		lsLaborItem.setLid(lid);
		lsLaborItem.setLaborYear(year);
		return lsLaborItemService.find(lsLaborItem);
	}
	public List<LsLaborMonth> findLaborMonth(Integer uid,String year,Integer ltid){
		LsLaborMonth lsLaborMonth=new LsLaborMonth();
		lsLaborMonth.setUid(uid);
		lsLaborMonth.setLtid(ltid);
		lsLaborMonth.setLbYear(year);
		return lsLaborMonthService.find(lsLaborMonth);
	}
}