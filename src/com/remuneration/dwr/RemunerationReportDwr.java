package com.remuneration.dwr;

import java.util.List;

import com.remuneration.entity.ReIsGetAllRemu;
import com.remuneration.entity.ReIsGetRemu;
import com.remuneration.service.RemunerationReportService;

public class RemunerationReportDwr {

	private RemunerationReportService remunerationReportService;

	public RemunerationReportService getRemunerationReportService() {
		return remunerationReportService;
	}

	public void setRemunerationReportService(
			RemunerationReportService remunerationReportService) {
		this.remunerationReportService = remunerationReportService;
	}
	/**
	 * 查询用户某年某作品的出版信息
	 */
	public List<ReIsGetRemu> findRemuDwr(Integer uid,Integer rid,String publishYear){
		ReIsGetRemu remu=new ReIsGetRemu();
		remu.setUid(uid);
		remu.setRid(rid);
		remu.setPublishYear(publishYear);
		return remunerationReportService.findRe(remu);
	} 
	/**
	 * 查询用户在某出版社某个作品的出版信息
	 * @param sinfo
	 * @return
	 */
	public List<ReIsGetRemu> findReByPressDwr(Integer uid,Integer rid,Integer ptid){
		ReIsGetRemu remu=new ReIsGetRemu();
		remu.setUid(uid);
		remu.setRid(rid);
		remu.setPtid(ptid);
		return remunerationReportService.findReByPress(remu);
	}
	/**
	 * 查询用户某年所有作品的出版信息
	 */
	public List<ReIsGetAllRemu> findAllRemuDwr(Integer uid,String publishYear){
		ReIsGetAllRemu remu=new ReIsGetAllRemu();
		remu.setUid(uid);
		remu.setPublishYear(publishYear);
		return remunerationReportService.findAllRe(remu);
	} 
}
