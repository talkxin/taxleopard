package com.house.dwr;

import java.sql.SQLException;
import java.util.List;

import com.house.entity.IsRentalHouseInfo;
import com.house.service.HouseReportService;

public class HouseReportDwr {

	private HouseReportService houseReportService;

	public HouseReportService getHouseReportService() {
		return houseReportService;
	}

	public void setHouseReportService(HouseReportService houseReportService) {
		this.houseReportService = houseReportService;
	}
	
	/**
	 *查询某房产所有承租人房租和
	 * 
	 * 
	 * */
    public IsRentalHouseInfo findHouse(Integer uid,Integer hid){
		IsRentalHouseInfo isRentalHouseInfo=new IsRentalHouseInfo();
		isRentalHouseInfo.setUid(uid);
		isRentalHouseInfo.setHid(hid);
		return houseReportService.find(isRentalHouseInfo);
	}
	/**
	 *查询某房产各个承租人的房租和
	 * 
	 * 
	 * */
	public List<IsRentalHouseInfo> findLessee(Integer uid,Integer hid){
		IsRentalHouseInfo isRentalHouseInfo=new IsRentalHouseInfo();
		isRentalHouseInfo.setUid(uid);
		isRentalHouseInfo.setHid(hid);
		return houseReportService.findList(isRentalHouseInfo);
	}
	/**
	 *查询各个房产所有承租人的房租和+转让费
	 * 
	 * 
	 * */
	public List<IsRentalHouseInfo> findEveryHouse(Integer uid){
		IsRentalHouseInfo isRentalHouseInfo=new IsRentalHouseInfo();
		isRentalHouseInfo.setUid(uid);
		return houseReportService.findEveryHouseList(isRentalHouseInfo);
	}
	/**
	 * 查询某用户的某个房产针对某个承租人的信息
	 * @param 
	 */
	public List<IsRentalHouseInfo> findSingleLessee(Integer uid,Integer hid,Integer rid){
		IsRentalHouseInfo isRentalHouseInfo=new IsRentalHouseInfo();
		isRentalHouseInfo.setUid(uid);
		isRentalHouseInfo.setHid(hid);
		isRentalHouseInfo.setRid(rid);
		return houseReportService.findSingleLesseeList(isRentalHouseInfo);
	}
}
