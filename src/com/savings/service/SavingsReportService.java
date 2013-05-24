package com.savings.service;

import java.util.List;

import com.savings.entity.SaIsGetSavings;

public interface SavingsReportService {

	/**
	 * 查询用户某个账户的储蓄信息
	 * @param isOccasional
	 */
    public List<SaIsGetSavings> find(SaIsGetSavings isSa);
}
