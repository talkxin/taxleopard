package com.house.service;

import java.util.List;

import com.house.dao.HouseReportDao;
import com.house.entity.IsRentalHouseInfo;

public class HouseReportServiceImpl implements HouseReportService {

	private HouseReportDao houseReportDao;
	
	public HouseReportDao getHouseReportDao() {
		return houseReportDao;
	}

	public void setHouseReportDao(HouseReportDao houseReportDao) {
		this.houseReportDao = houseReportDao;
	}

	public IsRentalHouseInfo find(IsRentalHouseInfo isRentalHouseInfo){
		return houseReportDao.find(isRentalHouseInfo);
	}
	public List<IsRentalHouseInfo> findList(IsRentalHouseInfo isRentalHouseInfo){
		return houseReportDao.findList(isRentalHouseInfo);
	}
	public List<IsRentalHouseInfo> findEveryHouseList(IsRentalHouseInfo isRentalHouseInfo){
		return houseReportDao.findEveryHouseList(isRentalHouseInfo);
	}
	public List<IsRentalHouseInfo> findSingleLesseeList(IsRentalHouseInfo isRentalHouseInfo){
		return houseReportDao.findSingleLesseeList(isRentalHouseInfo);
	}
}
