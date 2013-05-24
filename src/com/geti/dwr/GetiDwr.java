package com.geti.dwr;

import java.sql.SQLException;

import com.geti.entity.GtGetigongshang;
import com.geti.service.GetiService;

public class GetiDwr {
	private GetiService getiService;

	public GetiService getGetiService() {
		return getiService;
	}

	public void setGetiService(GetiService getiService) {
		this.getiService = getiService;
	}

	public void addGetti(GtGetigongshang gt) throws SQLException {
		getiService.addGetti(gt);
	}

	public void upGetti(GtGetigongshang gt) throws SQLException {
		getiService.upGetti(gt);
	}

	public void delGetti(int gt) throws SQLException {
		getiService.delGetti(gt);
	}
}
