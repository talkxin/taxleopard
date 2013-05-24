package com.chartered.dwr;

import java.util.List;

import com.chartered.entity.CrIsGetChartered;
import com.chartered.service.CharteredReportService;

public class CharteredReportDwr {

	private CharteredReportService charteredReportService;

	public CharteredReportService getCharteredReportService() {
		return charteredReportService;
	}

	public void setCharteredReportService(
			CharteredReportService charteredReportService) {
		this.charteredReportService = charteredReportService;
	}
	/**
	 * 查询用户某个专利的详细信息
	 * @param isOccasional
	 */
    public List<CrIsGetChartered> findCharDwr(Integer uid,Integer ciid){
    	CrIsGetChartered isCh=new CrIsGetChartered();
    	isCh.setUid(uid);
    	isCh.setCiid(ciid);
    	return charteredReportService.find(isCh);
    }
}
