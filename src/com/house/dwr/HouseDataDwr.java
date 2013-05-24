package com.house.dwr;

import java.util.List;

import com.house.entity.HpHouseInfo;
import com.house.entity.HpRentalHouseInfo;
import com.house.entity.HpRentalInfo;
import com.house.entity.HpTransfer;
import com.house.service.HouseDataService;

public class HouseDataDwr {
	private HouseDataService houseDataService;

	public HouseDataService getHouseDataService() {
		return houseDataService;
	}

	public void setHouseDataService(HouseDataService houseDataService) {
		this.houseDataService = houseDataService;
	}

	/**
	 * 添加房产
	 * 
	 * @param hi
	 */
	public HpHouseInfo addHouseDwr(HpHouseInfo hi) {
		return houseDataService.addHouse(hi);
	}

	/**
	 * 修改房产
	 * 
	 * @param hi
	 */
	public void upHouseDwr(HpHouseInfo hi) {
		houseDataService.upHouse(hi);
	}

	/**
	 * 删除房产
	 * 
	 * @param hi
	 */
	public void delHouseDwr(HpHouseInfo hi) {
		houseDataService.delHouse(hi);
	}

	/**
	 * 添加房产转让
	 * 
	 * @param hi
	 */
	public void addSellHouseDwr(HpTransfer hi) {
		houseDataService.addSellHouse(hi);
	}

	/**
	 * 修改房产转让
	 * 
	 * @param hi
	 */
	public void upSellHouseDwr(HpTransfer hi) {
		houseDataService.upSellHouse(hi);
	}

	/**
	 * 删除房产转让恢复房产状态
	 * 
	 * @param hi
	 */
	public void delSellHouseDwr(int hi) {
		houseDataService.delSellHouse(hi);
	}

	/**
	 * 添加出租人
	 * 
	 * @param hi
	 */
	public HpRentalInfo addRentPopDwr(HpRentalInfo hi) {
		return houseDataService.addRentPop(hi);
	}

	/**
	 * 修改出租人
	 * 
	 * @param hi
	 */
	public void upRentPopDwr(HpRentalInfo hi) {
		houseDataService.upRentPop(hi);
	}

	/**
	 * 删除出租人
	 * 
	 * @param hi
	 */
	public void delRentPopDwr(int hi) {
		houseDataService.delRentPop(hi);
	}

	/**
	 * 增加出租信息
	 * 
	 * @param hi
	 */
	public void addRentInfoDwr(HpRentalHouseInfo hi) {
		houseDataService.addRentInfo(hi);
	}

	/**
	 * 修改出租信息
	 * 
	 * @param hi
	 */
	public void upRentInfoDwr(HpRentalHouseInfo hi) {
		houseDataService.upRentInfo(hi);
	}

	/**
	 * 删除出租信息
	 * 
	 * @param hi
	 */
	public void delRentInfoDwr(int hi) {
		houseDataService.delRentInfo(hi);
	}

	/**
	 * 修改房产状态
	 * 
	 * @param hi
	 */
	public void upHouseStateDwr(HpHouseInfo hi) {
		houseDataService.upHouseState(hi);
	}

	/**
	 * 查询用户房产
	 * 
	 * @param uid
	 * @return
	 */
	public List<HpHouseInfo> isGetHouseDwr(int uid) {
		return houseDataService.isGetHouse(uid);
	}

	/**
	 * 查询出租人
	 * 
	 * @param uid
	 * @return
	 */
	public List<HpRentalInfo> isGetRentalInfoDwr(int uid) {
		return houseDataService.isGetRentalInfo(uid);
	}

	/**
	 * 将某房屋所有租赁信息修改至某月
	 * 
	 * @param hi
	 */
	public void upAllRantDwr(HpRentalHouseInfo hi) {
		houseDataService.upAllRant(hi);
	}

	/**
	 * 查询所有该用户的房产转让信息
	 * 
	 * @param hid
	 * @return
	 */
	public HpTransfer isGetHouseSellAllDwr(int hid) {
		return houseDataService.isGetHouseSellAll(hid);

	}
	/**
	 * 查询某用户所有承租人
	 * @param uid
	 * @return
	 */
	public List<HpRentalInfo> isGetUserAllRentalInfoDwr(int uid){
		return houseDataService.isGetUserAllRentalInfo(uid);
	}
}
