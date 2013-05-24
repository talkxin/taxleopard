package com.labor.service;

import java.util.List;

import com.labor.entity.LsLaborCooItem;
import com.labor.entity.LsLaborInfo;
import com.labor.entity.LsLaborMonth;
import com.labor.entity.LsLaborService;

public interface LaborDataService {
	/**
	 * 添加公司
	 * @param li
	 */
	public LsLaborInfo addLaborInfo(LsLaborInfo li);
	/**
	 * 修改公司信息
	 * @param li
	 */
	public void upLaborInfo(LsLaborInfo li);
	/**
	 * 删除公司信息
	 * @param li
	 */
	public void delLaborInfo(int li);
	/**
	 * 添加工作信息
	 * @param li
	 */
	public void addLaborService(List<LsLaborService> li);
	/**
	 * 修改工作信息
	 * @param li
	 */
	public void upLaborService(LsLaborMonth li);
	/**
	 * 删除工作信息
	 * @param li
	 */
	public void delLaboService(int li);
	/**
	 * 添加项目
	 * @param li
	 */
	public LsLaborCooItem addLaborCooItem(LsLaborCooItem li);
	/**
	 * 修改项目信息
	 * @param li
	 */
	public void upLaborCooItem(LsLaborCooItem li);
	/**
	 * 删除项目信息
	 * @param li
	 */
	public void delLaborCooItem(int li);
	/**
	 * 添加税务信息
	 */
	public void addLaborTax(LsLaborService li);
	/**
	 * 返回用户的公司
	 * @param UID
	 * @return
	 */
	public List<LsLaborInfo> isGetUserCoo(int UID);
	/**
	 * 返回该公司下的项目
	 * @param ll
	 * @return
	 */
	public List<LsLaborCooItem> isGetTeam(int ll);
	/**
	 * 获取公司详细信息
	 * @param id
	 * @return
	 */
	public LsLaborInfo isGetCooInfo(int id);
}
