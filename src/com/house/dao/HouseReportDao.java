package com.house.dao;

import java.util.List;

import com.house.entity.IsRentalHouseInfo;

public interface HouseReportDao {
  
	public IsRentalHouseInfo find(IsRentalHouseInfo isRentalHouseInfo);
	public List<IsRentalHouseInfo> findList(IsRentalHouseInfo isRentalHouseInfo);
	public List<IsRentalHouseInfo> findEveryHouseList(IsRentalHouseInfo isRentalHouseInfo);
	/**
	 * 查询某用户的某个房产针对某个承租人的信息
	 * @param hi
	 */
	public List<IsRentalHouseInfo> findSingleLesseeList(IsRentalHouseInfo isRentalHouseInfo);
}