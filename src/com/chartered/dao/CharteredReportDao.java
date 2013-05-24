package com.chartered.dao;

import java.util.List;

import com.chartered.entity.CrIsGetChartered;
import com.savings.entity.SaIsGetSavings;

public interface CharteredReportDao {

	/**
	 * 查询用户某个专利的详细信息
	 * @param isOccasional
	 */
    public List<CrIsGetChartered> find(CrIsGetChartered isCh);
}
