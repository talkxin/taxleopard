package com.chartered.service;

import java.sql.SQLException;
import java.util.List;

import com.chartered.entity.CrChartered;
import com.chartered.entity.CrCharteredInfo;

public interface CharteredService {
	/**
	 * 添加特许权信息
	 * 
	 * @param cr
	 * @return
	 */
	public CrCharteredInfo addCrCharteredInfo(CrCharteredInfo cr)throws SQLException;

	/**
	 * 修改特许权信息
	 * 
	 * @param cr
	 */
	public void upCrCharteredInfo(CrCharteredInfo cr)throws SQLException;

	/**
	 * 删除特许权信息
	 * 
	 * @param cr
	 */
	public void delCrCharteredInfo(int cr)throws SQLException;

	/**
	 * 添加特许权使用信息
	 * 
	 * @param cr
	 */
	public void addCrChartered(CrChartered cr)throws SQLException;

	/**
	 * 修改特许权使用信息
	 * 
	 * @param cr
	 */
	public void upCrChartered(CrChartered cr)throws SQLException;

	/**
	 * 删除特许权使用信息
	 * 
	 * @param cr
	 * @return
	 */
	public void delCrChartered(int cr)throws SQLException;

	/**
	 * 返回用户的特许权列表
	 * 
	 * @param cr
	 * @return
	 */
	public List<CrCharteredInfo> isGetCharteredInfo(int cr)throws SQLException;
}
