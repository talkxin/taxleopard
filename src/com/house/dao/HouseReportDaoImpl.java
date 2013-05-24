package com.house.dao;

import java.sql.SQLException;
import java.util.List;

import com.house.entity.IsRentalHouseInfo;
import com.ibatis.sqlmap.client.SqlMapClient;

public class HouseReportDaoImpl implements HouseReportDao{

	private SqlMapClient sqlMapClient;

	public SqlMapClient getSqlMapClient() {
		return sqlMapClient;
	}

	public void setSqlMapClient(SqlMapClient sqlMapClient) {
		this.sqlMapClient = sqlMapClient;
	}
	public IsRentalHouseInfo find(IsRentalHouseInfo isRentalHouseInfo) {
		try {
			return (IsRentalHouseInfo)sqlMapClient.queryForObject("findIsRentalHouseInfo", isRentalHouseInfo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public List<IsRentalHouseInfo> findList(IsRentalHouseInfo isRentalHouseInfo){
		try {
			return sqlMapClient.queryForList("findIsLessee", isRentalHouseInfo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public List<IsRentalHouseInfo> findEveryHouseList(IsRentalHouseInfo isRentalHouseInfo){
		try {
			return sqlMapClient.queryForList("findIsEveryHouse", isRentalHouseInfo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public List<IsRentalHouseInfo> findSingleLesseeList(IsRentalHouseInfo isRentalHouseInfo){
		try {
			return sqlMapClient.queryForList("findIsSingleLessee", isRentalHouseInfo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
