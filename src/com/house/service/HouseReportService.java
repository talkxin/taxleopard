package com.house.service;


import java.util.List;

import com.house.entity.IsRentalHouseInfo;

public interface HouseReportService {

	public IsRentalHouseInfo find(IsRentalHouseInfo isRentalHouseInfo);
	public List<IsRentalHouseInfo> findList(IsRentalHouseInfo isRentalHouseInfo);
	public List<IsRentalHouseInfo> findEveryHouseList(IsRentalHouseInfo isRentalHouseInfo);
	public List<IsRentalHouseInfo> findSingleLesseeList(IsRentalHouseInfo isRentalHouseInfo);
}
