package com.otherincome.service;

import java.util.List;

import com.otherincome.entity.OiOtherincome;

public interface OtherIncomeReportService {

	/**
	 * 查询其他所得
	 * @param otherIn
	 * @return
	 */
		public List<OiOtherincome> find(OiOtherincome otherIn);
}
