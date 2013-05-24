package com.geti.service;

import java.util.List;

import com.geti.entity.GtGetigongshang;

public interface GetiReportService {

	/**
	 * 查询用户的个体工商
	 * @param geti
	 * @return
	 */
		public List<GtGetigongshang> findGe(GtGetigongshang geti);
}
