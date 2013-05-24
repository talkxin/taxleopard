package com.geti.dao;

import java.util.List;

import com.geti.entity.GtGetigongshang;

public interface GetiReportDao {

/**
 * 查询用户的个体工商
 * @param geti
 * @return
 */
	public List<GtGetigongshang> findGe(GtGetigongshang geti);
}
