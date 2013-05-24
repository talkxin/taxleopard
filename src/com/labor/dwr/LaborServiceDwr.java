package com.labor.dwr;

import java.util.ArrayList;
import java.util.List;

import com.labor.entity.LsLaborCooItem;
import com.labor.entity.LsLaborInfo;
import com.labor.entity.LsLaborMonth;
import com.labor.entity.LsLaborService;
import com.labor.service.LaborDataService;
import com.paychex.entity.PcIndustry;
import com.paychex.service.PayChexService;

public class LaborServiceDwr {
	private LaborDataService laborDataService;
	private PayChexService payChexService;
	public LaborDataService getLaborDataService() {
		return laborDataService;
	}
	public void setLaborDataService(LaborDataService laborDataService) {
		this.laborDataService = laborDataService;
	}
	public PayChexService getPayChexService() {
		return payChexService;
	}
	public void setPayChexService(PayChexService payChexService) {
		this.payChexService = payChexService;
	}
	/**
	 * 返回行业
	 * @return
	 */
	public List<PcIndustry> isGetIndustry(){
		return payChexService.isGetIndustry();
	}
	/**
	 * 存储公司信息
	 * @param li
	 */
	public LsLaborInfo isSaveCoo(LsLaborInfo li){
		return laborDataService.addLaborInfo(li);
	}
	/**
	 * 修改公司信息
	 * @param li
	 */
	public void isupCoo(LsLaborInfo li){
		laborDataService.upLaborInfo(li);
	}
	/**
	 * 获取公司详细信息
	 * @param lid
	 * @return
	 */
	public LsLaborInfo isGetCooInfo(int lid){
		return laborDataService.isGetCooInfo(lid);
	}
	/**
	 * 删除公司信息
	 * @param lid
	 */
	public void isdelCoo(int lid){
		laborDataService.delLaborInfo(lid);
	}
	/**
	 * 获取该用户公司
	 * @param uid
	 * @return
	 */
	public List<LsLaborInfo> isGetUserCoo(int uid){
		return laborDataService.isGetUserCoo(uid);
	}
	/**
	 * 返回某公司项目
	 * @param lid
	 * @return
	 */
	public List<LsLaborCooItem> isGetCooItem(int lid){
		return laborDataService.isGetTeam(lid);
	}
	/**
	 * 添加未知项目
	 * @param li
	 * @return
	 */
	public LsLaborCooItem addCooItem(LsLaborCooItem li){
		return laborDataService.addLaborCooItem(li);
	}
	/**
	 * 修改项目名称
	 * @param li
	 */
	public void upCooItem(LsLaborCooItem li){
		laborDataService.upLaborCooItem(li);
	}
	/**
	 * 删除项目
	 * @param li
	 */
	public void delCooItem(int li){
		laborDataService.delLaborCooItem(li);
	}
	/**
	 * 添加工作
	 * @param ls
	 */
	public void addUserService(LsLaborService[] ls){
		List<LsLaborService> list=new ArrayList<LsLaborService>();
		for (int i = 0; i < ls.length; i++) {
			list.add(ls[i]);
		}
		laborDataService.addLaborService(list);
	}
	/**
	 * 修改工作
	 * @param li
	 */
	public void upUserServicedwr(LsLaborMonth li){
		laborDataService.upLaborService(li);
	}
	/**
	 * 删除工作
	 * @param li
	 */
	public void delService(int li){
		laborDataService.delLaboService(li);
	}
}
