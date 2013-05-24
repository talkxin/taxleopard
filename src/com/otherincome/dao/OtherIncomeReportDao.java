package com.otherincome.dao;

import java.util.List;

import com.otherincome.entity.OiOtherincome;

public interface OtherIncomeReportDao {

/**
 * 查询其他所得
 * @param otherIn
 * @return
 */
	public List<OiOtherincome> find(OiOtherincome otherIn);
}
