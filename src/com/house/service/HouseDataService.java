package com.house.service;

import java.util.List;

import com.house.entity.HpHouseInfo;
import com.house.entity.HpRentalHouseInfo;
import com.house.entity.HpRentalInfo;
import com.house.entity.HpTransfer;

public interface HouseDataService {
	/**
	 * 添加房产
	 * @param hi
	 */
	public HpHouseInfo addHouse(HpHouseInfo hi);
	/**
	 * 修改房产
	 * @param hi
	 */
	public void upHouse(HpHouseInfo hi);
	/**
	 * 删除房产
	 * @param hi
	 */
	public void delHouse(HpHouseInfo hi);
	/**
	 * 添加房产转让，修改房产状态
	 * @param hi
	 */
	public void addSellHouse(HpTransfer hi);
	/**
	 * 修改房产转让
	 * @param hi
	 */
	public void upSellHouse(HpTransfer hi);
	/**
	 * 删除房产转让，并修改状态
	 * @param hi
	 */
	public void delSellHouse(int hi);
	/**
	 * 添加出租人
	 * @param hi
	 */
	public HpRentalInfo addRentPop(HpRentalInfo hi);
	/**
	 * 修改出租人信息
	 * @param hi
	 */
	public void upRentPop(HpRentalInfo hi);
	/**
	 * 删除出租人
	 * @param hi
	 */
	public void delRentPop(int hi);
	/**
	 * 增加出租信息
	 * @param hi
	 */
	public void addRentInfo(HpRentalHouseInfo hi);
	/**
	 * 修改出租信息
	 * @param hi
	 */
	public void upRentInfo(HpRentalHouseInfo hi);
	/**
	 * 删除出租信息
	 * @param hi
	 */
	public void delRentInfo(int hi);
	/**
	 * 修改房产状态
	 * @param hi
	 */
	public void upHouseState(HpHouseInfo hi);
	/**
	 * 查询用户房产
	 * @param uid
	 * @return
	 */
	public List<HpHouseInfo> isGetHouse(int uid);
	/**
	 * 查询出租人
	 * @param uid
	 * @return
	 */
	public List<HpRentalInfo> isGetRentalInfo(int uid);
	/**
	 * 终止某房屋所有出租合同
	 * @param hi
	 */
	public void upAllRant(HpRentalHouseInfo hi);
	/**
	 * 查询所有该用户的房产转让信息
	 * @param hid
	 * @return
	 */
	public HpTransfer isGetHouseSellAll(int hid);
	/**
	 * 查询某用户所有承租人
	 * @param uid
	 * @return
	 */
	List<HpRentalInfo> isGetUserAllRentalInfo(int uid);
}
