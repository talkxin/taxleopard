package com.chartered.dwr;

import java.sql.SQLException;
import java.util.List;

import com.chartered.entity.CrChartered;
import com.chartered.entity.CrCharteredInfo;
import com.chartered.service.CharteredService;

public class CharteredDwr {
	private CharteredService charteredService;

	public CharteredService getCharteredService() {
		return charteredService;
	}

	public void setCharteredService(CharteredService charteredService) {
		this.charteredService = charteredService;
	}
	/**
	 * 添加特许权信息
	 * 
	 * @param cr
	 * @return
	 */
	public CrCharteredInfo addCrCharteredInfo(CrCharteredInfo cr){
		try {
			return charteredService.addCrCharteredInfo(cr);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 修改特许权信息
	 * 
	 * @param cr
	 */
	public void upCrCharteredInfo(CrCharteredInfo cr){
		try {
			charteredService.upCrCharteredInfo(cr);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 删除特许权信息
	 * 
	 * @param cr
	 */
	public void delCrCharteredInfo(int cr){
		try {
			charteredService.delCrCharteredInfo(cr);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 添加特许权使用信息
	 * 
	 * @param cr
	 */
	public void addCrChartered(CrChartered cr){
		try {
			charteredService.addCrChartered(cr);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 修改特许权使用信息
	 * 
	 * @param cr
	 */
	public void upCrChartered(CrChartered cr){
		try {
			charteredService.upCrChartered(cr);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 删除特许权使用信息
	 * 
	 * @param cr
	 * @return
	 */
	public void delCrChartered(int cr){
		try {
			charteredService.delCrChartered(cr);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 返回用户的特许权列表
	 * 
	 * @param cr
	 * @return
	 */
	public List<CrCharteredInfo> isGetCharteredInfo(int cr){
		try {
			return charteredService.isGetCharteredInfo(cr);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
