package com.geti.dwr;

import java.util.List;

import com.geti.entity.GtGetigongshang;
import com.geti.service.GetiReportService;

public class GetiReportDwr {

	private GetiReportService getiReportService;

	public GetiReportService getGetiReportService() {
		return getiReportService;
	}

	public void setGetiReportService(GetiReportService getiReportService) {
		this.getiReportService = getiReportService;
	}
	public List<GtGetigongshang> findGe(Integer uid){
		GtGetigongshang geti=new GtGetigongshang();
		geti.setUid(uid);
		return getiReportService.findGe(geti);
	}
}
