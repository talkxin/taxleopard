package com.remuneration.dwr;

import java.util.List;

import com.remuneration.entity.RePressType;
import com.remuneration.entity.RePublish;
import com.remuneration.entity.ReRemunerationInfo;
import com.remuneration.service.RemunerationDataService;

public class RemunerationDataDwr {
	private RemunerationDataService remunerationDataService;
	public RemunerationDataService getRemunerationDataService() {
		return remunerationDataService;
	}
	public void setRemunerationDataService(
			RemunerationDataService remunerationDataService) {
		this.remunerationDataService = remunerationDataService;
	}
	/**
	 * 增加作品信息
	 * @param re
	 */
	public ReRemunerationInfo addRemunerationInfo(ReRemunerationInfo re){
		return remunerationDataService.addRemunerationInfo(re);
	}
	/**
	 * 修改作品信息
	 * @param re
	 */
	public void upRemunerationInfo(ReRemunerationInfo re){
		remunerationDataService.upRemunerationInfo(re);
	}
	/**
	 * 删除作品信息
	 * @param re
	 */
	public void delRemunerationInfo(int re){
		remunerationDataService.delRemunerationInfo(re);
	}
	/**
	 * 添加出版社
	 * @param re
	 * @return
	 */
	public RePressType addRePressType(RePressType re){
		return remunerationDataService.addRePressType(re);
	}
	/**
	 * 修改出版社
	 * @param re
	 */
	public void upRePressType(RePressType re){
		remunerationDataService.upRePressType(re);
	}
	/**
	 * 删除出版社
	 * @param re
	 */
	public void delRePressType(int re){
		remunerationDataService.delRePressType(re);
	}
	/**
	 * 增加稿酬信息
	 * @param re
	 * @return
	 */
	public void addRePublish(RePublish re){
		remunerationDataService.addRePublish(re);
	}
	/**
	 * 修改稿酬信息
	 * @param re
	 */
	public void upRePublish(RePublish re){
		remunerationDataService.upRePublish(re);
	}
	/**
	 * 删除稿酬信息
	 * @param re
	 */
	public void delRePublish(int re){
		remunerationDataService.delRePublish(re);
	}
	/**
	 * 返回用户所有的作品
	 * @param re
	 * @return
	 */
	public List<ReRemunerationInfo> isGetReRemunerationInfo(int re){
		return remunerationDataService.isGetReRemunerationInfo(re);
	}
	/**
	 * 返回用户所有的出版社
	 * @param re
	 * @return
	 */
	public List<RePressType> isGetRePressType(int re){
		return remunerationDataService.isGetRePressType(re);
	}
	/**
	 * 返回用户添加的所有出版社
	 * @param re
	 * @return
	 */
	public List<RePressType> isGetAllRePressType(int re){
		return remunerationDataService.isGetAllRePressType(re);
	}
}
